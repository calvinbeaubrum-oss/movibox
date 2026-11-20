package qh;

import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.n1;
import com.google.android.exoplayer2.util.o0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import nh.d0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class h implements d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m1 f74788a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long[] f74790c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f74791d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public rh.f f74792f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f74793g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f74794h;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ih.b f74789b = new ih.b();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f74795i = C.TIME_UNSET;

    public h(rh.f fVar, m1 m1Var, boolean z11) {
        this.f74788a = m1Var;
        this.f74792f = fVar;
        this.f74790c = fVar.f75425b;
        d(fVar, z11);
    }

    public String a() {
        return this.f74792f.a();
    }

    @Override // nh.d0
    public int b(n1 n1Var, DecoderInputBuffer decoderInputBuffer, int i11) {
        int i12 = this.f74794h;
        boolean z11 = i12 == this.f74790c.length;
        if (z11 && !this.f74791d) {
            decoderInputBuffer.l(4);
            return -4;
        }
        if ((i11 & 2) != 0 || !this.f74793g) {
            n1Var.f33603b = this.f74788a;
            this.f74793g = true;
            return -5;
        }
        if (z11) {
            return -3;
        }
        if ((i11 & 1) == 0) {
            this.f74794h = i12 + 1;
        }
        if ((i11 & 4) == 0) {
            byte[] bArrA = this.f74789b.a(this.f74792f.f75424a[i12]);
            decoderInputBuffer.n(bArrA.length);
            decoderInputBuffer.f33030c.put(bArrA);
        }
        decoderInputBuffer.f33032f = this.f74790c[i12];
        decoderInputBuffer.l(1);
        return -4;
    }

    public void c(long j11) {
        int iE = o0.e(this.f74790c, j11, true, false);
        this.f74794h = iE;
        if (!this.f74791d || iE != this.f74790c.length) {
            j11 = C.TIME_UNSET;
        }
        this.f74795i = j11;
    }

    public void d(rh.f fVar, boolean z11) {
        int i11 = this.f74794h;
        long j11 = i11 == 0 ? -9223372036854775807L : this.f74790c[i11 - 1];
        this.f74791d = z11;
        this.f74792f = fVar;
        long[] jArr = fVar.f75425b;
        this.f74790c = jArr;
        long j12 = this.f74795i;
        if (j12 != C.TIME_UNSET) {
            c(j12);
        } else if (j11 != C.TIME_UNSET) {
            this.f74794h = o0.e(jArr, j11, false, false);
        }
    }

    @Override // nh.d0
    public boolean isReady() {
        return true;
    }

    @Override // nh.d0
    public void maybeThrowError() throws IOException {
    }

    @Override // nh.d0
    public int skipData(long j11) {
        int iMax = Math.max(this.f74794h, o0.e(this.f74790c, j11, true, false));
        int i11 = iMax - this.f74794h;
        this.f74794h = iMax;
        return i11;
    }
}
