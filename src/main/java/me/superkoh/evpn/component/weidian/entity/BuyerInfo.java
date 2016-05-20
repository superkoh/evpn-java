
package me.superkoh.evpn.component.weidian.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "buyer_id",
    "name",
    "address",
    "post",
    "phone",
    "province",
    "city",
    "region",
    "self_address"
})
public class BuyerInfo {

    @JsonProperty("buyer_id")
    public String buyerId;
    @JsonProperty("name")
    public String name;
    @JsonProperty("address")
    public String address;
    @JsonProperty("post")
    public String post;
    @JsonProperty("phone")
    public String phone;
    @JsonProperty("province")
    public String province;
    @JsonProperty("city")
    public String city;
    @JsonProperty("region")
    public String region;
    @JsonProperty("self_address")
    public String selfAddress;

}
