package com.irayhan.medicineapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import com.google.gson.Gson
import com.irayhan.medicineapplication.databinding.ActivityMainBinding
import java.io.IOException
import java.nio.charset.Charset

class MainActivity : AppCompatActivity() {

    private lateinit var listModel: MutableList<Any>
    private lateinit var adapterMedicine: MedicineAdapter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val medicine = Gson().fromJson(getMedicine(), Medicine::class.java)
        showMedicine(medicine)
        setSearch(medicine)
    }

    private fun getMedicine(): String? {
        val json = try {
            val inputStream = resources.openRawResource(R.raw.medicne)
            val size: Int = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            String(buffer, Charset.forName("UTF-8"))
        } catch (ex: IOException) {
            ex.printStackTrace()
            return null
        }
        return json
    }

    private fun showMedicine(medicine: Medicine) {
        listModel = mutableListOf()
        listModel.apply {
            addAll(medicine.brands!!)
            addAll(medicine.companies!!)
            addAll(medicine.generics!!)
            addAll(medicine.indications!!)
            addAll(medicine.pregnancyCategories!!)
            addAll(medicine.systemics!!)
            addAll(medicine.therapatics!!)
        }
        adapterMedicine = MedicineAdapter(this, listModel)
        binding.rvMedicine.apply {
            setHasFixedSize(true)
            adapter = adapterMedicine
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun setSearch(medicine: Medicine) {
        val listSearch = mutableListOf<Any>()
        binding.etSearch.addTextChangedListener {
            listSearch.clear()
            for (brand in medicine.brands!!) if (brand.brandName?.contains(it.toString(), true) == true) listSearch.add(brand)
            for (company in medicine.companies!!) if (company.companyName?.contains(it.toString(), true) == true) listSearch.add(company)
            for (generic in medicine.generics!!) if (generic.genericName?.contains(it.toString(), true) == true) listSearch.add(generic)
            for (indication in medicine.indications!!) if (indication.indicationName?.contains(it.toString(), true) == true) listSearch.add(indication)
            for (pregnancyCategory in medicine.pregnancyCategories!!) if (pregnancyCategory.pregnancyName?.contains(it.toString(), true) == true) listSearch.add(pregnancyCategory)
            for (systemic in medicine.systemics!!) if (systemic.systemicName?.contains(it.toString(), true) == true) listSearch.add(systemic)
            for (therapeutic in medicine.therapatics!!) if (therapeutic.therapiticName?.contains(it.toString(), true) == true) listSearch.add(therapeutic)
            if (listSearch.isNotEmpty()) {
                listModel.clear()
                listModel.addAll(listSearch)
                adapterMedicine.notifyDataSetChanged()
            } else {
                listModel.clear()
                listModel.apply {
                    addAll(medicine.brands)
                    addAll(medicine.companies)
                    addAll(medicine.generics)
                    addAll(medicine.indications)
                    addAll(medicine.pregnancyCategories)
                    addAll(medicine.systemics)
                    addAll(medicine.therapatics)
                }
                adapterMedicine.notifyDataSetChanged()
            }
        }
    }
}