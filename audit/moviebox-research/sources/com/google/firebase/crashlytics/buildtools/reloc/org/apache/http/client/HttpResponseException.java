package com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class HttpResponseException extends ClientProtocolException {
    private static final long serialVersionUID = -7186627969477257933L;
    private final int statusCode;

    public HttpResponseException(int i11, String str) {
        super(str);
        this.statusCode = i11;
    }

    public int getStatusCode() {
        return this.statusCode;
    }
}
