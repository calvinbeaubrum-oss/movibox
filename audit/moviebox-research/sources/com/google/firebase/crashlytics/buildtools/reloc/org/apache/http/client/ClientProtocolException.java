package com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client;

import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class ClientProtocolException extends IOException {
    private static final long serialVersionUID = -5596590843227115865L;

    public ClientProtocolException() {
    }

    public ClientProtocolException(String str) {
        super(str);
    }

    public ClientProtocolException(String str, Throwable th2) {
        super(str);
        initCause(th2);
    }

    public ClientProtocolException(Throwable th2) {
        initCause(th2);
    }
}
