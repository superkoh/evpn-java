package me.superkoh.evpn.controller.base;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by KOH on 16/5/7.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {
    public int ok = 0;
    public String msg;
}
