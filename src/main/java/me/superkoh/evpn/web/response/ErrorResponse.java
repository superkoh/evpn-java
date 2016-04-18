package me.superkoh.evpn.web.response;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by KOH on 16/4/19.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {
    public int ok = 0;
    public String msg;
}
