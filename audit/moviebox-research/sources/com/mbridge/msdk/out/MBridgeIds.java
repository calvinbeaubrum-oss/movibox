package com.mbridge.msdk.out;

import android.text.TextUtils;
import com.mbridge.msdk.system.NoProGuard;
import java.io.Serializable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class MBridgeIds implements NoProGuard, Serializable {
    private String bidToken = "";
    private boolean isCache = false;
    private String localRequestId;
    private String placementId;
    private String requestId;
    private String unitId;

    public MBridgeIds() {
    }

    public MBridgeIds(String str, String str2) {
        this.placementId = str;
        this.unitId = str2;
    }

    public MBridgeIds(String str, String str2, String str3) {
        this.placementId = str;
        this.unitId = str2;
        this.requestId = str3;
    }

    public String getBidToken() {
        if (TextUtils.isEmpty(this.bidToken)) {
            this.bidToken = "";
        }
        return this.bidToken;
    }

    public String getLocalRequestId() {
        return this.localRequestId;
    }

    public String getPlacementId() {
        return this.placementId;
    }

    public String getRequestId() {
        return TextUtils.isEmpty(this.requestId) ? "" : this.requestId;
    }

    public String getUnitId() {
        return this.unitId;
    }

    public boolean isCache() {
        return this.isCache;
    }

    public void setBidToken(String str) {
        this.bidToken = str;
    }

    public void setCache(boolean z11) {
        this.isCache = z11;
    }

    public void setLocalRequestId(String str) {
        this.localRequestId = str;
    }

    public void setPlacementId(String str) {
        this.placementId = str;
    }

    public void setRequestId(String str) {
        this.requestId = str;
    }

    public void setUnitId(String str) {
        this.unitId = str;
    }

    public String toString() {
        return "MBridgeIds{placementId='" + this.placementId + "', unitId='" + this.unitId + "', bidToken='" + this.bidToken + "', localRequestId='" + this.localRequestId + "'}";
    }
}
