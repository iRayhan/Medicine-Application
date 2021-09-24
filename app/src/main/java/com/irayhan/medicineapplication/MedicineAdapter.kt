package com.irayhan.medicineapplication

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.irayhan.medicineapplication.databinding.*

class MedicineAdapter(
    private val context: Context,
    private val listModel: List<Any>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>()  {

    companion object {
        const val TYPE_BRAND = 1
        const val TYPE_COMPANY = 2
        const val TYPE_GENERIC = 3
        const val TYPE_INDICATION = 4
        const val TYPE_PREGNANCY = 5
        const val TYPE_SYSTEMIC = 6
        const val TYPE_THERAPY = 7
    }

    override fun getItemViewType(position: Int): Int {
        return when {
            listModel[position] is Brand -> TYPE_BRAND
            listModel[position] is Company -> TYPE_COMPANY
            listModel[position] is Generic -> TYPE_GENERIC
            listModel[position] is Indication -> TYPE_INDICATION
            listModel[position] is PregnancyCategory -> TYPE_PREGNANCY
            listModel[position] is Systemic -> TYPE_SYSTEMIC
            else -> TYPE_THERAPY
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_BRAND -> {
                val view = RowBrandBinding.inflate(LayoutInflater.from(context), viewGroup, false)
                BrandViewHolder(view)
            }
            TYPE_COMPANY -> {
                val view = RowCompanyBinding.inflate(LayoutInflater.from(context), viewGroup, false)
                CompanyViewHolder(view)
            }
            TYPE_GENERIC -> {
                val view = RowGenericBinding.inflate(LayoutInflater.from(context), viewGroup, false)
                GenericViewHolder(view)
            }
            TYPE_INDICATION -> {
                val view = RowIndicationBinding.inflate(LayoutInflater.from(context), viewGroup, false)
                IndicationViewHolder(view)
            }
            TYPE_PREGNANCY -> {
                val view = RowPregnancyBinding.inflate(LayoutInflater.from(context), viewGroup, false)
                PregnancyViewHolder(view)
            }
            TYPE_SYSTEMIC -> {
                val view = RowSystemeticBinding.inflate(LayoutInflater.from(context), viewGroup, false)
                SystemicViewHolder(view)
            }
            else -> {
                val view = RowTherapyBinding.inflate(LayoutInflater.from(context), viewGroup, false)
                TherapyViewHolder(view)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            TYPE_BRAND -> {
                val viewHolder = holder as BrandViewHolder
                setBrand(viewHolder, position)
            }
            TYPE_COMPANY -> {
                val viewHolder = holder as CompanyViewHolder
                setCompany(viewHolder, position)
            }
            TYPE_GENERIC -> {
                val viewHolder = holder as GenericViewHolder
                setGeneric(viewHolder, position)
            }
            TYPE_INDICATION -> {
                val viewHolder = holder as IndicationViewHolder
                setIndication(viewHolder, position)
            }
            TYPE_PREGNANCY -> {
                val viewHolder = holder as PregnancyViewHolder
                setPregnancy(viewHolder, position)
            }
            TYPE_SYSTEMIC -> {
                val viewHolder = holder as SystemicViewHolder
                setSystemic(viewHolder, position)
            }
            TYPE_THERAPY -> {
                val viewHolder = holder as TherapyViewHolder
                setTherapy(viewHolder, position)
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun setBrand(holder: BrandViewHolder, position: Int) {
        val brand = listModel[position] as Brand
        holder.binding.apply {
            txtBrand.text = "Brand: ${brand.brandName}"
            txtStrength.text = "Strength: ${brand.strength}"
            txtPrice.text = "Price: ${brand.price}"
            txtPackSize.text = "Pack Size: ${brand.packsize}"
        }
    }

    @SuppressLint("SetTextI18n")
    private fun setCompany(holder: CompanyViewHolder, position: Int) {
        val company = listModel[position] as Company
        holder.binding.apply {
            txtCompany.text = "Company: ${company.companyName}"
            txtId.text = "Company Id: ${company.companyId}"
        }
    }

    @SuppressLint("SetTextI18n")
    private fun setGeneric(holder: GenericViewHolder, position: Int) {
        val generic = listModel[position] as Generic
        holder.binding.apply {
            txtGeneric.text = "Generic: ${generic.genericName}"
            txtIndication.text = "Indication: ${generic.indication}"
            txtPrecaution.text = "Precaution: ${generic.precaution}"
            txtSideEffect.text = "Side Effect: ${generic.sideEffect}"
        }
    }

    @SuppressLint("SetTextI18n")
    private fun setIndication(holder: IndicationViewHolder, position: Int) {
        val indication = listModel[position] as Indication
        holder.binding.apply {
            txtIndication.text = "Indication: ${indication.indicationName}"
            txtId.text = "Indication Id: ${indication.indicationId}"
        }
    }

    @SuppressLint("SetTextI18n")
    private fun setPregnancy(holder: PregnancyViewHolder, position: Int) {
        val pregnancy = listModel[position] as PregnancyCategory
        holder.binding.apply {
            txtPregnant.text = "Pregnancy Name: ${pregnancy.pregnancyName}"
            txtDescription.text = "Description: ${pregnancy.pregnancyDescription}"
        }
    }

    @SuppressLint("SetTextI18n")
    private fun setSystemic(holder: SystemicViewHolder, position: Int) {
        val systemic = listModel[position] as Systemic
        holder.binding.apply {
            txtSystematic.text = "Systemic: ${systemic.systemicName}"
            txtId.text = "Systemic Id: ${systemic.systemicId}"
        }
    }

    @SuppressLint("SetTextI18n")
    private fun setTherapy(holder: TherapyViewHolder, position: Int) {
        val therapy = listModel[position] as Therapatic
        holder.binding.apply {
            txtTherapy.text = "Therapy: ${therapy.therapiticName}"
            txtId.text = "Therapeutic Systemic Class Id: ${therapy.therapiticSystemicClassId}"
        }
    }

    internal class BrandViewHolder(val binding: RowBrandBinding) : RecyclerView.ViewHolder(binding.root)
    internal class CompanyViewHolder(val binding: RowCompanyBinding) : RecyclerView.ViewHolder(binding.root)
    internal class GenericViewHolder(val binding: RowGenericBinding) : RecyclerView.ViewHolder(binding.root)
    internal class IndicationViewHolder(val binding: RowIndicationBinding) : RecyclerView.ViewHolder(binding.root)
    internal class PregnancyViewHolder(val binding: RowPregnancyBinding) : RecyclerView.ViewHolder(binding.root)
    internal class SystemicViewHolder(val binding: RowSystemeticBinding) : RecyclerView.ViewHolder(binding.root)
    internal class TherapyViewHolder(val binding: RowTherapyBinding) : RecyclerView.ViewHolder(binding.root)

    override fun getItemCount(): Int {
        return listModel.size
    }
}