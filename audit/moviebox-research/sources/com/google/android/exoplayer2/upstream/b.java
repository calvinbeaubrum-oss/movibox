package com.google.android.exoplayer2.upstream;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface b {

    /* JADX INFO: compiled from: source.java */
    public interface a {
        com.google.android.exoplayer2.upstream.a a();

        @Nullable
        a next();
    }

    void a(a aVar);

    com.google.android.exoplayer2.upstream.a allocate();

    void b(com.google.android.exoplayer2.upstream.a aVar);

    int getIndividualAllocationLength();

    void trim();
}
