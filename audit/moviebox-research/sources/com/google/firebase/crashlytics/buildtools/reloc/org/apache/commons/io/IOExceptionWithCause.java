package com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io;

import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public class IOExceptionWithCause extends IOException {
    private static final long serialVersionUID = 1;

    public IOExceptionWithCause(String str, Throwable th2) {
        super(str, th2);
    }

    public IOExceptionWithCause(Throwable th2) {
        super(th2);
    }
}
