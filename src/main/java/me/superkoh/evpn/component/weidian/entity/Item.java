
package me.superkoh.evpn.component.weidian.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "item_id",
    "price",
    "quantity",
    "total_price",
    "sku_id",
    "sku_title",
    "item_name",
    "img",
    "url",
    "fx_fee_rate",
    "merchant_code",
    "sku_merchant_code"
})
public class Item {

    @JsonProperty("item_id")
    public String itemId;
    @JsonProperty("price")
    public String price;
    @JsonProperty("quantity")
    public String quantity;
    @JsonProperty("total_price")
    public String totalPrice;
    @JsonProperty("sku_id")
    public String skuId;
    @JsonProperty("sku_title")
    public String skuTitle;
    @JsonProperty("item_name")
    public String itemName;
    @JsonProperty("img")
    public String img;
    @JsonProperty("url")
    public String url;
    @JsonProperty("fx_fee_rate")
    public String fxFeeRate;
    @JsonProperty("merchant_code")
    public String merchantCode;
    @JsonProperty("sku_merchant_code")
    public String skuMerchantCode;

}
