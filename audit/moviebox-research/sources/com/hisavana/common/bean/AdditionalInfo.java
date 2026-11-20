package com.hisavana.common.bean;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class AdditionalInfo {
    private Double admobECPM;
    private String currency;
    private String currencyCode;
    private Double eCPM;
    private TAdErrorCode errorCode;
    private String experimentGroupId;
    private Boolean isBidding;
    private Boolean isInternalAd;
    private String mediatorSource;
    private String precision;
    private Integer precisionType;
    private String sdkVersion;
    private String trafficGroupId;
    private String triggerId;
    private String placementId = "";
    private Integer source = -1;
    private String applicationId = "";
    private String applicationKey = "";
    private String codeSeatId = "";
    private String mcc = "";

    public AdditionalInfo() {
        Double dValueOf = Double.valueOf(0.0d);
        this.eCPM = dValueOf;
        this.precision = "";
        this.currency = "";
        this.triggerId = "";
        Boolean bool = Boolean.FALSE;
        this.isBidding = bool;
        this.trafficGroupId = "";
        this.experimentGroupId = "";
        this.sdkVersion = "";
        this.admobECPM = dValueOf;
        this.currencyCode = "";
        this.precisionType = -1;
        this.mediatorSource = "";
        this.isInternalAd = bool;
    }

    public final Double getAdmobECPM() {
        return this.admobECPM;
    }

    public final String getApplicationId() {
        return this.applicationId;
    }

    public final String getApplicationKey() {
        return this.applicationKey;
    }

    public final String getCodeSeatId() {
        return this.codeSeatId;
    }

    public final String getCurrency() {
        return this.currency;
    }

    public final String getCurrencyCode() {
        return this.currencyCode;
    }

    public final Double getECPM() {
        return this.eCPM;
    }

    public final TAdErrorCode getErrorCode() {
        return this.errorCode;
    }

    public final String getExperimentGroupId() {
        return this.experimentGroupId;
    }

    public final String getMcc() {
        return this.mcc;
    }

    public final String getMediatorSource() {
        return this.mediatorSource;
    }

    public final String getPlacementId() {
        return this.placementId;
    }

    public final String getPrecision() {
        return this.precision;
    }

    public final Integer getPrecisionType() {
        return this.precisionType;
    }

    public final String getSdkVersion() {
        return this.sdkVersion;
    }

    public final Integer getSource() {
        return this.source;
    }

    public final String getTrafficGroupId() {
        return this.trafficGroupId;
    }

    public final String getTriggerId() {
        return this.triggerId;
    }

    public final Boolean isBidding() {
        return this.isBidding;
    }

    public final Boolean isInternalAd() {
        return this.isInternalAd;
    }

    public final void setAdmobECPM(Double d11) {
        this.admobECPM = d11;
    }

    public final void setApplicationId(String str) {
        this.applicationId = str;
    }

    public final void setApplicationKey(String str) {
        this.applicationKey = str;
    }

    public final void setBidding(Boolean bool) {
        this.isBidding = bool;
    }

    public final void setCodeSeatId(String str) {
        this.codeSeatId = str;
    }

    public final void setCurrency(String str) {
        this.currency = str;
    }

    public final void setCurrencyCode(String str) {
        this.currencyCode = str;
    }

    public final void setECPM(Double d11) {
        this.eCPM = d11;
    }

    public final void setErrorCode(TAdErrorCode tAdErrorCode) {
        this.errorCode = tAdErrorCode;
    }

    public final void setExperimentGroupId(String str) {
        this.experimentGroupId = str;
    }

    public final void setInternalAd(Boolean bool) {
        this.isInternalAd = bool;
    }

    public final void setMcc(String str) {
        this.mcc = str;
    }

    public final void setMediatorSource(String str) {
        this.mediatorSource = str;
    }

    public final void setPlacementId(String str) {
        this.placementId = str;
    }

    public final void setPrecision(String str) {
        this.precision = str;
    }

    public final void setPrecisionType(Integer num) {
        this.precisionType = num;
    }

    public final void setSdkVersion(String str) {
        this.sdkVersion = str;
    }

    public final void setSource(Integer num) {
        this.source = num;
    }

    public final void setTrafficGroupId(String str) {
        this.trafficGroupId = str;
    }

    public final void setTriggerId(String str) {
        this.triggerId = str;
    }

    public String toString() {
        return "AdditionalInfo(placementId=" + this.placementId + ", source=" + this.source + ", applicationId=" + this.applicationId + ", applicationKey=" + this.applicationKey + ", codeSeatId=" + this.codeSeatId + ", errorCode=" + this.errorCode + ", mcc=" + this.mcc + ", eCPM=" + this.eCPM + ", precision=" + this.precision + ", currency=" + this.currency + ", triggerId=" + this.triggerId + ", isBidding=" + this.isBidding + ", trafficGroupId=" + this.trafficGroupId + ", experimentGroupId=" + this.experimentGroupId + ", sdkVersion=" + this.sdkVersion + ", admobECPM=" + this.admobECPM + ", currencyCode=" + this.currencyCode + ", precisionType=" + this.precisionType + ", mediatorSource=" + this.mediatorSource + ", isInternalAd=" + this.isInternalAd + ')';
    }
}
