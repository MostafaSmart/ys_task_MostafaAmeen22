package com.example.ys_task_mostafaameen.data.model.ResponseModels.Order;

import com.google.gson.annotations.SerializedName;

public class OrderDetail {
    @SerializedName("ITM_SRL")
    private String itemSerial;

    @SerializedName("I_CODE")
    private String itemCode;

    @SerializedName("ITM_NM")
    private String itemName;

    @SerializedName("ITM_UNT")
    private String itemUnit;

    @SerializedName("I_QTY")
    private String itemQuantity;

    @SerializedName("ITM_DSC")
    private String itemDescription;

    @SerializedName("PRCSSD_FLG")
    private String processedFlag;

    @SerializedName("PRNT_DATE")
    private String printDate;

    @SerializedName("CNCL_FLG")
    private String cancelFlag;

    @SerializedName("ITM_STS")
    private String itemStatus;

    // Getters and Setters
    public String getItemSerial() { return itemSerial; }
    public void setItemSerial(String itemSerial) { this.itemSerial = itemSerial; }

    public String getItemCode() { return itemCode; }
    public void setItemCode(String itemCode) { this.itemCode = itemCode; }

    public String getItemName() { return itemName; }
    public void setItemName(String itemName) { this.itemName = itemName; }

    public String getItemUnit() { return itemUnit; }
    public void setItemUnit(String itemUnit) { this.itemUnit = itemUnit; }

    public String getItemQuantity() { return itemQuantity; }
    public void setItemQuantity(String itemQuantity) { this.itemQuantity = itemQuantity; }

    public String getItemDescription() { return itemDescription; }
    public void setItemDescription(String itemDescription) { this.itemDescription = itemDescription; }

    public String getProcessedFlag() { return processedFlag; }
    public void setProcessedFlag(String processedFlag) { this.processedFlag = processedFlag; }

    public String getPrintDate() { return printDate; }
    public void setPrintDate(String printDate) { this.printDate = printDate; }

    public String getCancelFlag() { return cancelFlag; }
    public void setCancelFlag(String cancelFlag) { this.cancelFlag = cancelFlag; }

    public String getItemStatus() { return itemStatus; }
    public void setItemStatus(String itemStatus) { this.itemStatus = itemStatus; }
}