package com.example.ys_task_mostafaameen.data.model.RequestModels.Order;

import org.json.JSONException;
import org.json.JSONObject;

public class UpdateOrderRequest {

    private ValueUpdateOrder Value;

    public UpdateOrderRequest(ValueUpdateOrder value) {
        this.Value = value;
    }

    public ValueUpdateOrder getValue() {
        return Value;
    }

    public void setValue(ValueUpdateOrder value) {
        this.Value = value;
    }

    @Override
    public String toString() {
        try {
            return new JSONObject()
                    .put("Value", new JSONObject()
                            .put("P_ORDR_SRL", Value.getP_ORDR_SRL())
                            .put("P_USR_NO", Value.getP_USR_NO())
                            .put("P_LANG_NO", Value.getP_LANG_NO())
                            .put("UNT_NO", Value.getUNT_NO()))
                    .toString();
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public static class ValueUpdateOrder {
        private String P_ORDR_SRL;
        private String P_USR_NO;
        private String P_LANG_NO;
        private String UNT_NO;

        // Constructor
        public ValueUpdateOrder(String P_ORDR_SRL, String P_USR_NO, String P_LANG_NO, String UNT_NO) {
            this.P_ORDR_SRL = P_ORDR_SRL;
            this.P_USR_NO = P_USR_NO;
            this.P_LANG_NO = P_LANG_NO;
            this.UNT_NO = UNT_NO;
        }

        public ValueUpdateOrder() {}

        // Getters
        public String getP_ORDR_SRL() {
            return P_ORDR_SRL;
        }

        public String getP_USR_NO() {
            return P_USR_NO;
        }

        public String getP_LANG_NO() {
            return P_LANG_NO;
        }

        public String getUNT_NO() {
            return UNT_NO;
        }

        // Setters
        public void setP_ORDR_SRL(String P_ORDR_SRL) {
            this.P_ORDR_SRL = P_ORDR_SRL;
        }

        public void setP_USR_NO(String P_USR_NO) {
            this.P_USR_NO = P_USR_NO;
        }

        public void setP_LANG_NO(String P_LANG_NO) {
            this.P_LANG_NO = P_LANG_NO;
        }

        public void setUNT_NO(String UNT_NO) {
            this.UNT_NO = UNT_NO;
        }
    }

}
