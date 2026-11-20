package com.google.android.exoplayer2.source;

import android.net.Uri;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import qg.u1;
import tg.a0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface l {

    /* JADX INFO: compiled from: source.java */
    public interface a {
        l a(u1 u1Var);
    }

    void a();

    long b();

    void c(com.google.android.exoplayer2.upstream.g gVar, Uri uri, Map<String, List<String>> map, long j11, long j12, tg.n nVar) throws IOException;

    int d(a0 a0Var) throws IOException;

    void release();

    void seek(long j11, long j12);
}
