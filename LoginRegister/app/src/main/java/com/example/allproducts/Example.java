
package com.example.allproducts;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Example implements Serializable {

    @SerializedName("product_id")
    @Expose
    private String productId;
    @SerializedName("product_english_name")
    @Expose
    private String productEnglishName;
    @SerializedName("product_quantity")
    @Expose
    private String productQuantity;
    @SerializedName("product_purchase_price")
    @Expose
    private String productPurchasePrice;
    @SerializedName("product_selling_price")
    @Expose
    private String productSellingPrice;
    @SerializedName("product_farmer_id")
    @Expose
    private String productFarmerId;
    @SerializedName("product_gujarati_name")
    @Expose
    private String productGujaratiName;
    @SerializedName("product_hindi_name")
    @Expose
    private String productHindiName;
    @SerializedName("product_description")
    @Expose
    private String productDescription;
    @SerializedName("product_added_date")
    @Expose
    private String productAddedDate;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductEnglishName() {
        return productEnglishName;
    }

    public void setProductEnglishName(String productEnglishName) {
        this.productEnglishName = productEnglishName;
    }

    public String getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(String productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String getProductPurchasePrice() {
        return productPurchasePrice;
    }

    public void setProductPurchasePrice(String productPurchasePrice) {
        this.productPurchasePrice = productPurchasePrice;
    }

    public String getProductSellingPrice() {
        return productSellingPrice;
    }

    public void setProductSellingPrice(String productSellingPrice) {
        this.productSellingPrice = productSellingPrice;
    }

    public String getProductFarmerId() {
        return productFarmerId;
    }

    public void setProductFarmerId(String productFarmerId) {
        this.productFarmerId = productFarmerId;
    }

    public String getProductGujaratiName() {
        return productGujaratiName;
    }

    public void setProductGujaratiName(String productGujaratiName) {
        this.productGujaratiName = productGujaratiName;
    }

    public String getProductHindiName() {
        return productHindiName;
    }

    public void setProductHindiName(String productHindiName) {
        this.productHindiName = productHindiName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductAddedDate() {
        return productAddedDate;
    }

    public void setProductAddedDate(String productAddedDate) {
        this.productAddedDate = productAddedDate;
    }

}
