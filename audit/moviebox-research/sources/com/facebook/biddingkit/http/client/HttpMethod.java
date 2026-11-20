package com.facebook.biddingkit.http.client;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public enum HttpMethod {
    GET(true, false),
    POST(true, true);

    private boolean doInput;
    private boolean doOutput;

    HttpMethod(boolean z11, boolean z12) {
        this.doInput = z11;
        this.doOutput = z12;
    }

    public boolean getDoInput() {
        return this.doInput;
    }

    public boolean getDoOutput() {
        return this.doOutput;
    }

    public String getMethodName() {
        return toString();
    }
}
