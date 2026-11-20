package com.google.android.exoplayer2.source;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.b3;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.n1;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.w;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import nh.d0;
import nh.k0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class b implements h, h.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f33769a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public h.a f33770b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a[] f33771c = new a[0];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f33772d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f33773f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f33774g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public ClippingMediaSource.IllegalClippingException f33775h;

    /* JADX INFO: compiled from: source.java */
    public final class a implements d0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d0 f33776a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f33777b;

        public a(d0 d0Var) {
            this.f33776a = d0Var;
        }

        public void a() {
            this.f33777b = false;
        }

        @Override // nh.d0
        public int b(n1 n1Var, DecoderInputBuffer decoderInputBuffer, int i11) {
            if (b.this.c()) {
                return -3;
            }
            if (this.f33777b) {
                decoderInputBuffer.l(4);
                return -4;
            }
            int iB = this.f33776a.b(n1Var, decoderInputBuffer, i11);
            if (iB == -5) {
                m1 m1Var = (m1) com.google.android.exoplayer2.util.a.e(n1Var.f33603b);
                int i12 = m1Var.C;
                if (i12 != 0 || m1Var.D != 0) {
                    b bVar = b.this;
                    if (bVar.f33773f != 0) {
                        i12 = 0;
                    }
                    n1Var.f33603b = m1Var.b().N(i12).O(bVar.f33774g == Long.MIN_VALUE ? m1Var.D : 0).E();
                }
                return -5;
            }
            b bVar2 = b.this;
            long j11 = bVar2.f33774g;
            if (j11 == Long.MIN_VALUE || ((iB != -4 || decoderInputBuffer.f33032f < j11) && !(iB == -3 && bVar2.getBufferedPositionUs() == Long.MIN_VALUE && !decoderInputBuffer.f33031d))) {
                return iB;
            }
            decoderInputBuffer.b();
            decoderInputBuffer.l(4);
            this.f33777b = true;
            return -4;
        }

        @Override // nh.d0
        public boolean isReady() {
            return !b.this.c() && this.f33776a.isReady();
        }

        @Override // nh.d0
        public void maybeThrowError() throws IOException {
            this.f33776a.maybeThrowError();
        }

        @Override // nh.d0
        public int skipData(long j11) {
            if (b.this.c()) {
                return -3;
            }
            return this.f33776a.skipData(j11);
        }
    }

    public b(h hVar, boolean z11, long j11, long j12) {
        this.f33769a = hVar;
        this.f33772d = z11 ? j11 : C.TIME_UNSET;
        this.f33773f = j11;
        this.f33774g = j12;
    }

    public static boolean k(long j11, fi.s[] sVarArr) {
        if (j11 != 0) {
            for (fi.s sVar : sVarArr) {
                if (sVar != null) {
                    m1 selectedFormat = sVar.getSelectedFormat();
                    if (!w.a(selectedFormat.f33445m, selectedFormat.f33442j)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.source.h
    public long a(long j11, b3 b3Var) {
        long j12 = this.f33773f;
        if (j11 == j12) {
            return j12;
        }
        return this.f33769a.a(j11, b(j11, b3Var));
    }

    public final b3 b(long j11, b3 b3Var) {
        long jR = o0.r(b3Var.f32991a, 0L, j11 - this.f33773f);
        long j12 = b3Var.f32992b;
        long j13 = this.f33774g;
        long jR2 = o0.r(j12, 0L, j13 == Long.MIN_VALUE ? Long.MAX_VALUE : j13 - j11);
        return (jR == b3Var.f32991a && jR2 == b3Var.f32992b) ? b3Var : new b3(jR, jR2);
    }

    public boolean c() {
        return this.f33772d != C.TIME_UNSET;
    }

    @Override // com.google.android.exoplayer2.source.h, com.google.android.exoplayer2.source.q
    public boolean continueLoading(long j11) {
        return this.f33769a.continueLoading(j11);
    }

    @Override // com.google.android.exoplayer2.source.h
    public void discardBuffer(long j11, boolean z11) {
        this.f33769a.discardBuffer(j11, z11);
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0043  */
    /* JADX WARN: Code duplicated, block: B:27:0x0063  */
    @Override // com.google.android.exoplayer2.source.h
    public long e(fi.s[] sVarArr, boolean[] zArr, d0[] d0VarArr, boolean[] zArr2, long j11) {
        long j12;
        boolean z11;
        this.f33771c = new a[d0VarArr.length];
        d0[] d0VarArr2 = new d0[d0VarArr.length];
        int i11 = 0;
        while (true) {
            d0 d0Var = null;
            if (i11 >= d0VarArr.length) {
                break;
            }
            a[] aVarArr = this.f33771c;
            a aVar = (a) d0VarArr[i11];
            aVarArr[i11] = aVar;
            if (aVar != null) {
                d0Var = aVar.f33776a;
            }
            d0VarArr2[i11] = d0Var;
            i11++;
        }
        long jE = this.f33769a.e(sVarArr, zArr, d0VarArr2, zArr2, j11);
        if (c()) {
            long j13 = this.f33773f;
            if (j11 == j13 && k(j13, sVarArr)) {
                j12 = jE;
            } else {
                j12 = C.TIME_UNSET;
            }
        } else {
            j12 = C.TIME_UNSET;
        }
        this.f33772d = j12;
        if (jE != j11) {
            if (jE >= this.f33773f) {
                long j14 = this.f33774g;
                z11 = j14 == Long.MIN_VALUE || jE <= j14;
            }
        }
        com.google.android.exoplayer2.util.a.g(z11);
        for (int i12 = 0; i12 < d0VarArr.length; i12++) {
            d0 d0Var2 = d0VarArr2[i12];
            if (d0Var2 == null) {
                this.f33771c[i12] = null;
            } else {
                a[] aVarArr2 = this.f33771c;
                a aVar2 = aVarArr2[i12];
                if (aVar2 == null || aVar2.f33776a != d0Var2) {
                    aVarArr2[i12] = new a(d0Var2);
                }
            }
            d0VarArr[i12] = this.f33771c[i12];
        }
        return jE;
    }

    @Override // com.google.android.exoplayer2.source.h
    public void f(h.a aVar, long j11) {
        this.f33770b = aVar;
        this.f33769a.f(this, j11);
    }

    @Override // com.google.android.exoplayer2.source.h, com.google.android.exoplayer2.source.q
    public long getBufferedPositionUs() {
        long bufferedPositionUs = this.f33769a.getBufferedPositionUs();
        if (bufferedPositionUs != Long.MIN_VALUE) {
            long j11 = this.f33774g;
            if (j11 == Long.MIN_VALUE || bufferedPositionUs < j11) {
                return bufferedPositionUs;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // com.google.android.exoplayer2.source.h, com.google.android.exoplayer2.source.q
    public long getNextLoadPositionUs() {
        long nextLoadPositionUs = this.f33769a.getNextLoadPositionUs();
        if (nextLoadPositionUs != Long.MIN_VALUE) {
            long j11 = this.f33774g;
            if (j11 == Long.MIN_VALUE || nextLoadPositionUs < j11) {
                return nextLoadPositionUs;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // com.google.android.exoplayer2.source.h
    public k0 getTrackGroups() {
        return this.f33769a.getTrackGroups();
    }

    @Override // com.google.android.exoplayer2.source.h.a
    public void h(h hVar) {
        if (this.f33775h != null) {
            return;
        }
        ((h.a) com.google.android.exoplayer2.util.a.e(this.f33770b)).h(this);
    }

    @Override // com.google.android.exoplayer2.source.q.a
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public void g(h hVar) {
        ((h.a) com.google.android.exoplayer2.util.a.e(this.f33770b)).g(this);
    }

    @Override // com.google.android.exoplayer2.source.h, com.google.android.exoplayer2.source.q
    public boolean isLoading() {
        return this.f33769a.isLoading();
    }

    public void j(ClippingMediaSource.IllegalClippingException illegalClippingException) {
        this.f33775h = illegalClippingException;
    }

    public void l(long j11, long j12) {
        this.f33773f = j11;
        this.f33774g = j12;
    }

    @Override // com.google.android.exoplayer2.source.h
    public void maybeThrowPrepareError() throws IOException {
        ClippingMediaSource.IllegalClippingException illegalClippingException = this.f33775h;
        if (illegalClippingException != null) {
            throw illegalClippingException;
        }
        this.f33769a.maybeThrowPrepareError();
    }

    @Override // com.google.android.exoplayer2.source.h
    public long readDiscontinuity() {
        if (c()) {
            long j11 = this.f33772d;
            this.f33772d = C.TIME_UNSET;
            long discontinuity = readDiscontinuity();
            return discontinuity != C.TIME_UNSET ? discontinuity : j11;
        }
        long discontinuity2 = this.f33769a.readDiscontinuity();
        if (discontinuity2 == C.TIME_UNSET) {
            return C.TIME_UNSET;
        }
        com.google.android.exoplayer2.util.a.g(discontinuity2 >= this.f33773f);
        long j12 = this.f33774g;
        com.google.android.exoplayer2.util.a.g(j12 == Long.MIN_VALUE || discontinuity2 <= j12);
        return discontinuity2;
    }

    @Override // com.google.android.exoplayer2.source.h, com.google.android.exoplayer2.source.q
    public void reevaluateBuffer(long j11) {
        this.f33769a.reevaluateBuffer(j11);
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0034  */
    @Override // com.google.android.exoplayer2.source.h
    public long seekToUs(long j11) {
        this.f33772d = C.TIME_UNSET;
        boolean z11 = false;
        for (a aVar : this.f33771c) {
            if (aVar != null) {
                aVar.a();
            }
        }
        long jSeekToUs = this.f33769a.seekToUs(j11);
        if (jSeekToUs == j11) {
            z11 = true;
        } else if (jSeekToUs >= this.f33773f) {
            long j12 = this.f33774g;
            if (j12 == Long.MIN_VALUE || jSeekToUs <= j12) {
                z11 = true;
            }
        }
        com.google.android.exoplayer2.util.a.g(z11);
        return jSeekToUs;
    }
}
