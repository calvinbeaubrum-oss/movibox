package com.google.android.exoplayer2.upstream;

import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface i {

    /* JADX INFO: compiled from: source.java */
    public interface a {
        i createDataSink();
    }

    void a(n nVar) throws IOException;

    void close() throws IOException;

    void write(byte[] bArr, int i11, int i12) throws IOException;
}
