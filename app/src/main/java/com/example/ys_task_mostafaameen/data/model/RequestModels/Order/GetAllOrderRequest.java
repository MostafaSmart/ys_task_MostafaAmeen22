package com.example.ys_task_mostafaameen.data.model.RequestModels.Order;
import org.json.JSONException;
import org.json.JSONObject;

public class GetAllOrderRequest {
    private String UNT_NO;
    private String P_BRN_NO;
    private String P_TRMNL_NO;
    private String P_LANG_NO;

    public GetAllOrderRequest(String UNT_NO, String P_BRN_NO, String P_TRMNL_NO, String P_LANG_NO) {
        this.UNT_NO = UNT_NO;
        this.P_BRN_NO = P_BRN_NO;
        this.P_TRMNL_NO = P_TRMNL_NO;
        this.P_LANG_NO = P_LANG_NO;
    }

    public String getUNT_NO() {
        return UNT_NO;
    }

    public void setUNT_NO(String UNT_NO) {
        this.UNT_NO = UNT_NO;
    }

    public String getP_BRN_NO() {
        return P_BRN_NO;
    }

    public void setP_BRN_NO(String P_BRN_NO) {
        this.P_BRN_NO = P_BRN_NO;
    }

    public String getP_TRMNL_NO() {
        return P_TRMNL_NO;
    }

    public void setP_TRMNL_NO(String P_TRMNL_NO) {
        this.P_TRMNL_NO = P_TRMNL_NO;
    }

    public String getP_LANG_NO() {
        return P_LANG_NO;
    }

    public void setP_LANG_NO(String P_LANG_NO) {
        this.P_LANG_NO = P_LANG_NO;
    }

}

