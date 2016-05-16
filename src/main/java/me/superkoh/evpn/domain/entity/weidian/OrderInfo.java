
package me.superkoh.evpn.domain.entity.weidian;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "buyer_info",
    "price",
    "trade_no",
    "express_no",
    "express",
    "express_note",
    "total",
    "quantity",
    "status",
    "order_id",
    "status2",
    "note",
    "seller_id",
    "sk",
    "discount",
    "discount_info",
    "discount_amount",
    "express_fee",
    "total_fee",
    "seller_phone",
    "seller_name",
    "is_close",
    "user_phone",
    "send_time",
    "pay_time",
    "add_time",
    "buyer_identity_id",
    "order_type",
    "order_type_des",
    "return_code",
    "argue_flag",
    "status_desc",
    "fx_fee_value",
    "f_seller_id",
    "f_shop_name",
    "f_phone",
    "confirm_expire",
    "refund_info",
    "items",
    "modify_price_enable",
    "express_fee_num",
    "original_total_price",
    "real_income_price"
})
public class OrderInfo {

    @JsonProperty("buyer_info")
    public BuyerInfo buyerInfo;
    @JsonProperty("price")
    public String price;
    @JsonProperty("trade_no")
    public String tradeNo;
    @JsonProperty("express_no")
    public String expressNo;
    @JsonProperty("express")
    public String express;
    @JsonProperty("express_note")
    public String expressNote;
    @JsonProperty("total")
    public String total;
    @JsonProperty("quantity")
    public String quantity;
    @JsonProperty("status")
    public String status;
    @JsonProperty("order_id")
    public String orderId;
    @JsonProperty("status2")
    public String status2;
    @JsonProperty("note")
    public String note;
    @JsonProperty("seller_id")
    public String sellerId;
    @JsonProperty("sk")
    public String sk;
    @JsonProperty("discount")
    public String discount;
    @JsonProperty("discount_info")
    public String discountInfo;
    @JsonProperty("discount_amount")
    public String discountAmount;
    @JsonProperty("express_fee")
    public String expressFee;
    @JsonProperty("total_fee")
    public String totalFee;
    @JsonProperty("seller_phone")
    public String sellerPhone;
    @JsonProperty("seller_name")
    public String sellerName;
    @JsonProperty("is_close")
    public Integer isClose;
    @JsonProperty("user_phone")
    public String userPhone;
    @JsonProperty("send_time")
    public String sendTime;
    @JsonProperty("pay_time")
    public String payTime;
    @JsonProperty("add_time")
    public String addTime;
    @JsonProperty("buyer_identity_id")
    public String buyerIdentityId;
    @JsonProperty("order_type")
    public String orderType;
    @JsonProperty("order_type_des")
    public String orderTypeDes;
    @JsonProperty("return_code")
    public String returnCode;
    @JsonProperty("argue_flag")
    public Integer argueFlag;
    @JsonProperty("status_desc")
    public String statusDesc;
    @JsonProperty("fx_fee_value")
    public String fxFeeValue;
    @JsonProperty("f_seller_id")
    public String fSellerId;
    @JsonProperty("f_shop_name")
    public String fShopName;
    @JsonProperty("f_phone")
    public String fPhone;
    @JsonProperty("confirm_expire")
    public String confirmExpire;
    @JsonProperty("refund_info")
    public RefundInfo refundInfo;
    @JsonProperty("items")
    public List<Item> items = new ArrayList<Item>();
    @JsonProperty("modify_price_enable")
    public String modifyPriceEnable;
    @JsonProperty("express_fee_num")
    public String expressFeeNum;
    @JsonProperty("original_total_price")
    public String originalTotalPrice;
    @JsonProperty("real_income_price")
    public String realIncomePrice;

}
