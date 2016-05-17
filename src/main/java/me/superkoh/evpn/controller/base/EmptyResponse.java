package me.superkoh.evpn.controller.base;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by KOH on 16/5/12.
 */
@ApiModel
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmptyResponse extends BizResponse {

    @ApiModelProperty(hidden = true)
    public String empty;
}
