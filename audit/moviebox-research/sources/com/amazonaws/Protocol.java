package com.amazonaws;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpHost;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public enum Protocol {
    HTTP(HttpHost.DEFAULT_SCHEME_NAME),
    HTTPS("https");

    private final String protocol;

    Protocol(String str) {
        this.protocol = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.protocol;
    }
}
