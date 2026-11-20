package com.google.android.exoplayer2.source.rtsp;

import androidx.annotation.Nullable;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface c extends com.google.android.exoplayer2.upstream.k {

    /* JADX INFO: compiled from: source.java */
    public interface a {
        c a(int i11) throws IOException;

        @Nullable
        a b();
    }

    String c();

    int d();

    @Nullable
    u.b g();
}
