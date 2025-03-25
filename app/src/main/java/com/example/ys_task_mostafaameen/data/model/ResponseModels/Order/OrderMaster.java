package com.example.ys_task_mostafaameen.data.model.ResponseModels.Order;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class OrderMaster {
    @SerializedName("BILL_NO")
    private String billNo;

    @SerializedName("ORDR_SRL")
    private String orderSerial;

    @SerializedName("BILL_DATE")
    private String billDate;

    @SerializedName("BILL_TIME")
    private String billTime;

    @SerializedName("ORDR_NOTE")
    private String orderNote;

    @SerializedName("BILL_DOC_TYPE")
    private String billDocType;

    @SerializedName("BILL_DOC_TYPE_NM")
    private String billDocTypeName;

    @SerializedName("LAST_UPDT")
    private String lastUpdate;

    @SerializedName("CNCL_FLG")
    private String cancelFlag;

    @SerializedName("PRCSSD_FLG")
    private String processedFlag;

    @SerializedName("PRCSSD_U_ID")
    private String processedUserId;

    @SerializedName("PRCSSD_DATE")
    private String processedDate;

    @SerializedName("AD_DATE")
    private String addedDate;

    @SerializedName("ORDR_TRC_FLG")
    private String orderTraceFlag;

    @SerializedName("PSSD_TM")
    private String passedTime;

    @SerializedName("ORDR_STS")
    private String orderStatus;

    @SerializedName("ordrDtl")
    private List<OrderDetail> orderDetails;

    @SerializedName("BILL_SRL")
    private String billSerial;

    @SerializedName("BILL_SRVC_TYPE")
    private String billServiceType;

    @SerializedName("BRN_NO")
    private String branchNo;

    @SerializedName("HALL_NO")
    private String hallNo;

    @SerializedName("PRCSS_TM")
    private String processTime;

    @SerializedName("PRNT_DATE")
    private String printDate;

    @SerializedName("STG_NO")
    private String stageNo;

    @SerializedName("STG_ORDR")
    private String stageOrder;

    @SerializedName("TBL_NO")
    private String tableNo;

    @SerializedName("TRMNL_NM")
    private String terminalName;

    @SerializedName("TRMNL_NO")
    private String terminalNo;

    // Getters and Setters لجميع الحقول
    public String getBillNo() { return billNo; }
    public void setBillNo(String billNo) { this.billNo = billNo; }

    public String getOrderSerial() { return orderSerial; }
    public void setOrderSerial(String orderSerial) { this.orderSerial = orderSerial; }

    public String getBillDate() { return billDate; }
    public void setBillDate(String billDate) { this.billDate = billDate; }

    public String getBillTime() { return billTime; }
    public void setBillTime(String billTime) { this.billTime = billTime; }

    public String getOrderNote() { return orderNote; }
    public void setOrderNote(String orderNote) { this.orderNote = orderNote; }

    public String getBillDocType() { return billDocType; }
    public void setBillDocType(String billDocType) { this.billDocType = billDocType; }

    public String getBillDocTypeName() { return billDocTypeName; }
    public void setBillDocTypeName(String billDocTypeName) { this.billDocTypeName = billDocTypeName; }

    public String getLastUpdate() { return lastUpdate; }
    public void setLastUpdate(String lastUpdate) { this.lastUpdate = lastUpdate; }

    public String getCancelFlag() { return cancelFlag; }
    public void setCancelFlag(String cancelFlag) { this.cancelFlag = cancelFlag; }

    public String getProcessedFlag() { return processedFlag; }
    public void setProcessedFlag(String processedFlag) { this.processedFlag = processedFlag; }

    public String getProcessedUserId() { return processedUserId; }
    public void setProcessedUserId(String processedUserId) { this.processedUserId = processedUserId; }

    public String getProcessedDate() { return processedDate; }
    public void setProcessedDate(String processedDate) { this.processedDate = processedDate; }

    public String getAddedDate() { return addedDate; }
    public void setAddedDate(String addedDate) { this.addedDate = addedDate; }

    public String getOrderTraceFlag() { return orderTraceFlag; }
    public void setOrderTraceFlag(String orderTraceFlag) { this.orderTraceFlag = orderTraceFlag; }

    public String getPassedTime() { return passedTime; }
    public void setPassedTime(String passedTime) { this.passedTime = passedTime; }

    public String getOrderStatus() { return orderStatus; }
    public void setOrderStatus(String orderStatus) { this.orderStatus = orderStatus; }

    public List<OrderDetail> getOrderDetails() { return orderDetails; }
    public void setOrderDetails(List<OrderDetail> orderDetails) { this.orderDetails = orderDetails; }

    public String getTableNo() { return tableNo; }
    public void setTableNo(String tableNo) { this.tableNo = tableNo; }
}
