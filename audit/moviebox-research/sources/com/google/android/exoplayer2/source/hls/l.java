package com.google.android.exoplayer2.source.hls;

import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.n1;
import java.io.IOException;
import nh.d0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class l implements d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f34063a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p f34064b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f34065c = -1;

    public l(p pVar, int i11) {
        this.f34064b = pVar;
        this.f34063a = i11;
    }

    public void a() {
        com.google.android.exoplayer2.util.a.a(this.f34065c == -1);
        this.f34065c = this.f34064b.i(this.f34063a);
    }

    @Override // nh.d0
    public int b(n1 n1Var, DecoderInputBuffer decoderInputBuffer, int i11) {
        if (this.f34065c == -3) {
            decoderInputBuffer.a(4);
            return -4;
        }
        if (c()) {
            return this.f34064b.R(this.f34065c, n1Var, decoderInputBuffer, i11);
        }
        return -3;
    }

    public final boolean c() {
        int i11 = this.f34065c;
        return (i11 == -1 || i11 == -3 || i11 == -2) ? false : true;
    }

    public void d() {
        if (this.f34065c != -1) {
            this.f34064b.c0(this.f34063a);
            this.f34065c = -1;
        }
    }

    @Override // nh.d0
    public boolean isReady() {
        return this.f34065c == -3 || (c() && this.f34064b.D(this.f34065c));
    }

    @Override // nh.d0
    public void maybeThrowError() throws IOException {
        int i11 = this.f34065c;
        if (i11 == -2) {
            throw new SampleQueueMappingException(this.f34064b.getTrackGroups().b(this.f34063a).c(0).f33445m);
        }
        if (i11 == -1) {
            this.f34064b.H();
        } else if (i11 != -3) {
            this.f34064b.I(i11);
        }
    }

    @Override // nh.d0
    public int skipData(long j11) {
        if (c()) {
            return this.f34064b.b0(this.f34065c, j11);
        }
        return 0;
    }
}
