package com.google.android.exoplayer2.source.rtsp;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.o0;
import java.util.Arrays;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class i0 extends com.google.android.exoplayer2.upstream.f implements c, u.b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LinkedBlockingQueue<byte[]> f34546e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f34547f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public byte[] f34548g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f34549h;

    public i0(long j11) {
        super(true);
        this.f34547f = j11;
        this.f34546e = new LinkedBlockingQueue<>();
        this.f34548g = new byte[0];
        this.f34549h = -1;
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public long a(com.google.android.exoplayer2.upstream.n nVar) {
        this.f34549h = nVar.f35422a.getPort();
        return -1L;
    }

    @Override // com.google.android.exoplayer2.source.rtsp.c
    public String c() {
        com.google.android.exoplayer2.util.a.g(this.f34549h != -1);
        return o0.C("RTP/AVP/TCP;unicast;interleaved=%d-%d", Integer.valueOf(this.f34549h), Integer.valueOf(this.f34549h + 1));
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public void close() {
    }

    @Override // com.google.android.exoplayer2.source.rtsp.c
    public int d() {
        return this.f34549h;
    }

    @Override // com.google.android.exoplayer2.source.rtsp.u.b
    public void f(byte[] bArr) {
        this.f34546e.add(bArr);
    }

    @Override // com.google.android.exoplayer2.source.rtsp.c
    public u.b g() {
        return this;
    }

    @Override // com.google.android.exoplayer2.upstream.k
    @Nullable
    public Uri getUri() {
        return null;
    }

    @Override // com.google.android.exoplayer2.upstream.g
    public int read(byte[] bArr, int i11, int i12) {
        if (i12 == 0) {
            return 0;
        }
        int iMin = Math.min(i12, this.f34548g.length);
        System.arraycopy(this.f34548g, 0, bArr, i11, iMin);
        byte[] bArr2 = this.f34548g;
        this.f34548g = Arrays.copyOfRange(bArr2, iMin, bArr2.length);
        if (iMin == i12) {
            return iMin;
        }
        try {
            byte[] bArrPoll = this.f34546e.poll(this.f34547f, TimeUnit.MILLISECONDS);
            if (bArrPoll == null) {
                return -1;
            }
            int iMin2 = Math.min(i12 - iMin, bArrPoll.length);
            System.arraycopy(bArrPoll, 0, bArr, i11 + iMin, iMin2);
            if (iMin2 < bArrPoll.length) {
                this.f34548g = Arrays.copyOfRange(bArrPoll, iMin2, bArrPoll.length);
            }
            return iMin + iMin2;
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            return -1;
        }
    }
}
