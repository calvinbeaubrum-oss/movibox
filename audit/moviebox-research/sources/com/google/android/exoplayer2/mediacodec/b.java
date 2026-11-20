package com.google.android.exoplayer2.mediacodec;

import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.s;
import com.google.android.exoplayer2.util.w;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class b implements c.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f33545a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f33546b;

    @Override // com.google.android.exoplayer2.mediacodec.c.b
    public c a(c.a aVar) throws IOException {
        int i11;
        int i12 = o0.f35608a;
        if (i12 < 23 || ((i11 = this.f33545a) != 1 && (i11 != 0 || i12 < 31))) {
            return new f.b().a(aVar);
        }
        int iK = w.k(aVar.f33549c.f33445m);
        s.f("DMCodecAdapterFactory", "Creating an asynchronous MediaCodec adapter for track type " + o0.m0(iK));
        return new a.b(iK, this.f33546b).a(aVar);
    }
}
