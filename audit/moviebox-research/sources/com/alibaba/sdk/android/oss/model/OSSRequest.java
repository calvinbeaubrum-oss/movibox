package com.alibaba.sdk.android.oss.model;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class OSSRequest {
    private boolean isAuthorizationRequired = true;
    private Enum CRC64 = CRC64Config.NULL;

    /* JADX INFO: compiled from: source.java */
    public enum CRC64Config {
        NULL,
        YES,
        NO
    }

    public Enum getCRC64() {
        return this.CRC64;
    }

    public boolean isAuthorizationRequired() {
        return this.isAuthorizationRequired;
    }

    public void setCRC64(Enum r11) {
        this.CRC64 = r11;
    }

    public void setIsAuthorizationRequired(boolean z11) {
        this.isAuthorizationRequired = z11;
    }
}
