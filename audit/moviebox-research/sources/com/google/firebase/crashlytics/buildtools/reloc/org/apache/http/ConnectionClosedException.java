package com.google.firebase.crashlytics.buildtools.reloc.org.apache.http;

import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class ConnectionClosedException extends IOException {
    private static final long serialVersionUID = 617550366255636674L;

    public ConnectionClosedException(String str) {
        super(HttpException.clean(str));
    }
}
