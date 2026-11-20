package com.aliyun.player.bean;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class InfoBean {
    private InfoCode mCode;
    private long mExtraValue = -1;
    private String mExtraMsg = null;

    public InfoCode getCode() {
        return this.mCode;
    }

    public String getExtraMsg() {
        return this.mExtraMsg;
    }

    public long getExtraValue() {
        return this.mExtraValue;
    }

    public void setCode(InfoCode infoCode) {
        this.mCode = infoCode;
    }

    public void setExtraMsg(String str) {
        this.mExtraMsg = str;
    }

    public void setExtraValue(long j11) {
        this.mExtraValue = j11;
    }
}
