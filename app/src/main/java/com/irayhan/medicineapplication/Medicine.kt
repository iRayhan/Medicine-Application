package com.irayhan.medicineapplication
import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class Medicine(
    @SerializedName("brands")
    val brands: List<Brand>?,
    @SerializedName("companies")
    val companies: List<Company>?,
    @SerializedName("generics")
    val generics: List<Generic>?,
    @SerializedName("indications")
    val indications: List<Indication>?,
    @SerializedName("indications_generics_index")
    val indicationsGenericsIndex: List<IndicationsGenericsIndex>?,
    @SerializedName("pregnancy_categories")
    val pregnancyCategories: List<PregnancyCategory>?,
    @SerializedName("systemics")
    val systemics: List<Systemic>?,
    @SerializedName("therapatics")
    val therapatics: List<Therapatic>?,
    @SerializedName("therapatics_generics")
    val therapaticsGenerics: List<TherapaticsGeneric>?
) : Serializable

data class Brand(
    @SerializedName("brand_id")
    val brandId: String?,
    @SerializedName("brand_name")
    val brandName: String?,
    @SerializedName("company_id")
    val companyId: String?,
    @SerializedName("form")
    val form: String?,
    @SerializedName("generic_id")
    val genericId: String?,
    @SerializedName("packsize")
    val packsize: String?,
    @SerializedName("price")
    val price: String?,
    @SerializedName("strength")
    val strength: String?
) : Serializable

data class Company(
    @SerializedName("company_id")
    val companyId: String?,
    @SerializedName("company_name")
    val companyName: String?,
    @SerializedName("company_order")
    val companyOrder: String?
) : Serializable

data class Generic(
    @SerializedName("contra_indication")
    val contraIndication: String?,
    @SerializedName("dose")
    val dose: String?,
    @SerializedName("generic_id")
    val genericId: String?,
    @SerializedName("generic_name")
    val genericName: String?,
    @SerializedName("indication")
    val indication: String?,
    @SerializedName("interaction")
    val interaction: String?,
    @SerializedName("mode_of_action")
    val modeOfAction: String?,
    @SerializedName("precaution")
    val precaution: String?,
    @SerializedName("pregnancy_category_id")
    val pregnancyCategoryId: String?,
    @SerializedName("side_effect")
    val sideEffect: String?
) : Serializable

data class Indication(
    @SerializedName("indication_id")
    val indicationId: String?,
    @SerializedName("indication_name")
    val indicationName: String?
)

data class IndicationsGenericsIndex(
    @SerializedName("generic_id")
    val genericId: String?,
    @SerializedName("indication_id")
    val indicationId: String?
) : Serializable

data class PregnancyCategory(
    @SerializedName("pregnancy_description")
    val pregnancyDescription: String?,
    @SerializedName("pregnancy_id")
    val pregnancyId: String?,
    @SerializedName("pregnancy_name")
    val pregnancyName: String?
) : Serializable

data class Systemic(
    @SerializedName("systemic_id")
    val systemicId: String?,
    @SerializedName("systemic_name")
    val systemicName: String?,
    @SerializedName("systemic_parent_id")
    val systemicParentId: String?
) : Serializable

data class Therapatic(
    @SerializedName("therapitic_id")
    val therapiticId: String?,
    @SerializedName("therapitic_name")
    val therapiticName: String?,
    @SerializedName("therapitic_systemic_class_id")
    val therapiticSystemicClassId: String?
) : Serializable

data class TherapaticsGeneric(
    @SerializedName("generic_id")
    val genericId: String?,
    @SerializedName("therapitic_id")
    val therapiticId: String?
) : Serializable