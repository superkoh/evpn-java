
package me.superkoh.evpn.component.weidian.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "refund_time",
    "buyer_refund_fee"
})
public class RefundInfo {

    @JsonProperty("refund_time")
    public String refundTime;
    @JsonProperty("buyer_refund_fee")
    public String buyerRefundFee;

}
