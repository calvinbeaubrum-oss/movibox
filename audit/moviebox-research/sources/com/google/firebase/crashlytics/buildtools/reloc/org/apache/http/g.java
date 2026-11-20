package com.google.firebase.crashlytics.buildtools.reloc.org.apache.http;

import java.io.Closeable;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public interface g extends Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close() throws IOException;

    boolean isOpen();

    void shutdown() throws IOException;
}
