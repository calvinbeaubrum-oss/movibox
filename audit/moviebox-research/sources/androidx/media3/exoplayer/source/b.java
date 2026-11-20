package androidx.media3.exoplayer.source;

import androidx.annotation.Nullable;
import androidx.media3.common.f0;
import androidx.media3.common.y;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.b3;
import androidx.media3.exoplayer.t1;
import androidx.media3.exoplayer.w1;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import p4.e0;
import p4.k0;
import s4.z;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b implements k, k.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f11124a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public k.a f11125b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a[] f11126c = new a[0];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f11127d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f11128f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f11129g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public ClippingMediaSource.IllegalClippingException f11130h;

    /* JADX INFO: compiled from: source.java */
    public final class a implements e0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e0 f11131a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f11132b;

        public a(e0 e0Var) {
            this.f11131a = e0Var;
        }

        public void a() {
            this.f11132b = false;
        }

        @Override // p4.e0
        public int c(t1 t1Var, DecoderInputBuffer decoderInputBuffer, int i11) {
            if (b.this.i()) {
                return -3;
            }
            if (this.f11132b) {
                decoderInputBuffer.setFlags(4);
                return -4;
            }
            long bufferedPositionUs = b.this.getBufferedPositionUs();
            int iC = this.f11131a.c(t1Var, decoderInputBuffer, i11);
            if (iC == -5) {
                y yVar = (y) z3.a.e(t1Var.f11382b);
                int i12 = yVar.C;
                if (i12 != 0 || yVar.D != 0) {
                    b bVar = b.this;
                    if (bVar.f11128f != 0) {
                        i12 = 0;
                    }
                    t1Var.f11382b = yVar.b().S(i12).T(bVar.f11129g == Long.MIN_VALUE ? yVar.D : 0).I();
                }
                return -5;
            }
            long j11 = b.this.f11129g;
            if (j11 == Long.MIN_VALUE || ((iC != -4 || decoderInputBuffer.f9782f < j11) && !(iC == -3 && bufferedPositionUs == Long.MIN_VALUE && !decoderInputBuffer.f9781d))) {
                return iC;
            }
            decoderInputBuffer.clear();
            decoderInputBuffer.setFlags(4);
            this.f11132b = true;
            return -4;
        }

        @Override // p4.e0
        public boolean isReady() {
            return !b.this.i() && this.f11131a.isReady();
        }

        @Override // p4.e0
        public void maybeThrowError() throws IOException {
            this.f11131a.maybeThrowError();
        }

        @Override // p4.e0
        public int skipData(long j11) {
            if (b.this.i()) {
                return -3;
            }
            return this.f11131a.skipData(j11);
        }
    }

    public b(k kVar, boolean z11, long j11, long j12) {
        this.f11124a = kVar;
        this.f11127d = z11 ? j11 : C.TIME_UNSET;
        this.f11128f = j11;
        this.f11129g = j12;
    }

    public static boolean l(long j11, z[] zVarArr) {
        if (j11 != 0) {
            for (z zVar : zVarArr) {
                if (zVar != null) {
                    y selectedFormat = zVar.getSelectedFormat();
                    if (!f0.a(selectedFormat.f9501m, selectedFormat.f9498j)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // androidx.media3.exoplayer.source.k, androidx.media3.exoplayer.source.t
    public boolean a(w1 w1Var) {
        return this.f11124a.a(w1Var);
    }

    @Override // androidx.media3.exoplayer.source.k
    public long b(long j11, b3 b3Var) {
        long j12 = this.f11128f;
        if (j11 == j12) {
            return j12;
        }
        return this.f11124a.b(j11, c(j11, b3Var));
    }

    public final b3 c(long j11, b3 b3Var) {
        long jQ = u0.q(b3Var.f10007a, 0L, j11 - this.f11128f);
        long j12 = b3Var.f10008b;
        long j13 = this.f11129g;
        long jQ2 = u0.q(j12, 0L, j13 == Long.MIN_VALUE ? Long.MAX_VALUE : j13 - j11);
        return (jQ == b3Var.f10007a && jQ2 == b3Var.f10008b) ? b3Var : new b3(jQ, jQ2);
    }

    @Override // androidx.media3.exoplayer.source.k
    public void discardBuffer(long j11, boolean z11) {
        this.f11124a.discardBuffer(j11, z11);
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0043  */
    /* JADX WARN: Code duplicated, block: B:27:0x0063  */
    @Override // androidx.media3.exoplayer.source.k
    public long e(z[] zVarArr, boolean[] zArr, e0[] e0VarArr, boolean[] zArr2, long j11) {
        long j12;
        boolean z11;
        this.f11126c = new a[e0VarArr.length];
        e0[] e0VarArr2 = new e0[e0VarArr.length];
        int i11 = 0;
        while (true) {
            e0 e0Var = null;
            if (i11 >= e0VarArr.length) {
                break;
            }
            a[] aVarArr = this.f11126c;
            a aVar = (a) e0VarArr[i11];
            aVarArr[i11] = aVar;
            if (aVar != null) {
                e0Var = aVar.f11131a;
            }
            e0VarArr2[i11] = e0Var;
            i11++;
        }
        long jE = this.f11124a.e(zVarArr, zArr, e0VarArr2, zArr2, j11);
        if (i()) {
            long j13 = this.f11128f;
            if (j11 == j13 && l(j13, zVarArr)) {
                j12 = jE;
            } else {
                j12 = C.TIME_UNSET;
            }
        } else {
            j12 = C.TIME_UNSET;
        }
        this.f11127d = j12;
        if (jE != j11) {
            if (jE >= this.f11128f) {
                long j14 = this.f11129g;
                z11 = j14 == Long.MIN_VALUE || jE <= j14;
            }
        }
        z3.a.g(z11);
        for (int i12 = 0; i12 < e0VarArr.length; i12++) {
            e0 e0Var2 = e0VarArr2[i12];
            if (e0Var2 == null) {
                this.f11126c[i12] = null;
            } else {
                a[] aVarArr2 = this.f11126c;
                a aVar2 = aVarArr2[i12];
                if (aVar2 == null || aVar2.f11131a != e0Var2) {
                    aVarArr2[i12] = new a(e0Var2);
                }
            }
            e0VarArr[i12] = this.f11126c[i12];
        }
        return jE;
    }

    @Override // androidx.media3.exoplayer.source.k.a
    public void f(k kVar) {
        if (this.f11130h != null) {
            return;
        }
        ((k.a) z3.a.e(this.f11125b)).f(this);
    }

    @Override // androidx.media3.exoplayer.source.k
    public void g(k.a aVar, long j11) {
        this.f11125b = aVar;
        this.f11124a.g(this, j11);
    }

    @Override // androidx.media3.exoplayer.source.k, androidx.media3.exoplayer.source.t
    public long getBufferedPositionUs() {
        long bufferedPositionUs = this.f11124a.getBufferedPositionUs();
        if (bufferedPositionUs != Long.MIN_VALUE) {
            long j11 = this.f11129g;
            if (j11 == Long.MIN_VALUE || bufferedPositionUs < j11) {
                return bufferedPositionUs;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // androidx.media3.exoplayer.source.k, androidx.media3.exoplayer.source.t
    public long getNextLoadPositionUs() {
        long nextLoadPositionUs = this.f11124a.getNextLoadPositionUs();
        if (nextLoadPositionUs != Long.MIN_VALUE) {
            long j11 = this.f11129g;
            if (j11 == Long.MIN_VALUE || nextLoadPositionUs < j11) {
                return nextLoadPositionUs;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // androidx.media3.exoplayer.source.k
    public k0 getTrackGroups() {
        return this.f11124a.getTrackGroups();
    }

    public boolean i() {
        return this.f11127d != C.TIME_UNSET;
    }

    @Override // androidx.media3.exoplayer.source.k, androidx.media3.exoplayer.source.t
    public boolean isLoading() {
        return this.f11124a.isLoading();
    }

    @Override // androidx.media3.exoplayer.source.t.a
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public void h(k kVar) {
        ((k.a) z3.a.e(this.f11125b)).h(this);
    }

    public void k(ClippingMediaSource.IllegalClippingException illegalClippingException) {
        this.f11130h = illegalClippingException;
    }

    public void m(long j11, long j12) {
        this.f11128f = j11;
        this.f11129g = j12;
    }

    @Override // androidx.media3.exoplayer.source.k
    public void maybeThrowPrepareError() throws IOException {
        ClippingMediaSource.IllegalClippingException illegalClippingException = this.f11130h;
        if (illegalClippingException != null) {
            throw illegalClippingException;
        }
        this.f11124a.maybeThrowPrepareError();
    }

    @Override // androidx.media3.exoplayer.source.k
    public long readDiscontinuity() {
        if (i()) {
            long j11 = this.f11127d;
            this.f11127d = C.TIME_UNSET;
            long discontinuity = readDiscontinuity();
            return discontinuity != C.TIME_UNSET ? discontinuity : j11;
        }
        long discontinuity2 = this.f11124a.readDiscontinuity();
        if (discontinuity2 == C.TIME_UNSET) {
            return C.TIME_UNSET;
        }
        z3.a.g(discontinuity2 >= this.f11128f);
        long j12 = this.f11129g;
        z3.a.g(j12 == Long.MIN_VALUE || discontinuity2 <= j12);
        return discontinuity2;
    }

    @Override // androidx.media3.exoplayer.source.k, androidx.media3.exoplayer.source.t
    public void reevaluateBuffer(long j11) {
        this.f11124a.reevaluateBuffer(j11);
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0034  */
    @Override // androidx.media3.exoplayer.source.k
    public long seekToUs(long j11) {
        this.f11127d = C.TIME_UNSET;
        boolean z11 = false;
        for (a aVar : this.f11126c) {
            if (aVar != null) {
                aVar.a();
            }
        }
        long jSeekToUs = this.f11124a.seekToUs(j11);
        if (jSeekToUs == j11) {
            z11 = true;
        } else if (jSeekToUs >= this.f11128f) {
            long j12 = this.f11129g;
            if (j12 == Long.MIN_VALUE || jSeekToUs <= j12) {
                z11 = true;
            }
        }
        z3.a.g(z11);
        return jSeekToUs;
    }
}
