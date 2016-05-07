package me.superkoh.evpn.controller.base;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by KOH on 16/4/17.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SuccessResponse {

    public int ok = 0;
    public Object obj;
}
