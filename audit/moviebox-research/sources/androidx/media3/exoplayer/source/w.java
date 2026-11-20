package androidx.media3.exoplayer.source;

import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.b3;
import androidx.media3.exoplayer.t1;
import androidx.media3.exoplayer.w1;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import p4.e0;
import p4.k0;
import s4.z;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class w implements k, k.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f11372a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f11373b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public k.a f11374c;

    /* JADX INFO: compiled from: source.java */
    public static final class a implements e0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e0 f11375a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f11376b;

        public a(e0 e0Var, long j11) {
            this.f11375a = e0Var;
            this.f11376b = j11;
        }

        public e0 a() {
            return this.f11375a;
        }

        @Override // p4.e0
        public int c(t1 t1Var, DecoderInputBuffer decoderInputBuffer, int i11) {
            int iC = this.f11375a.c(t1Var, decoderInputBuffer, i11);
            if (iC == -4) {
                decoderInputBuffer.f9782f += this.f11376b;
            }
            return iC;
        }

        @Override // p4.e0
        public boolean isReady() {
            return this.f11375a.isReady();
        }

        @Override // p4.e0
        public void maybeThrowError() throws IOException {
            this.f11375a.maybeThrowError();
        }

        @Override // p4.e0
        public int skipData(long j11) {
            return this.f11375a.skipData(j11 - this.f11376b);
        }
    }

    public w(k kVar, long j11) {
        this.f11372a = kVar;
        this.f11373b = j11;
    }

    @Override // androidx.media3.exoplayer.source.k, androidx.media3.exoplayer.source.t
    public boolean a(w1 w1Var) {
        return this.f11372a.a(w1Var.a().f(w1Var.f11756a - this.f11373b).d());
    }

    @Override // androidx.media3.exoplayer.source.k
    public long b(long j11, b3 b3Var) {
        return this.f11372a.b(j11 - this.f11373b, b3Var) + this.f11373b;
    }

    public k c() {
        return this.f11372a;
    }

    @Override // androidx.media3.exoplayer.source.k
    public void discardBuffer(long j11, boolean z11) {
        this.f11372a.discardBuffer(j11 - this.f11373b, z11);
    }

    @Override // androidx.media3.exoplayer.source.k
    public long e(z[] zVarArr, boolean[] zArr, e0[] e0VarArr, boolean[] zArr2, long j11) {
        e0[] e0VarArr2 = new e0[e0VarArr.length];
        int i11 = 0;
        while (true) {
            e0 e0VarA = null;
            if (i11 >= e0VarArr.length) {
                break;
            }
            a aVar = (a) e0VarArr[i11];
            if (aVar != null) {
                e0VarA = aVar.a();
            }
            e0VarArr2[i11] = e0VarA;
            i11++;
        }
        long jE = this.f11372a.e(zVarArr, zArr, e0VarArr2, zArr2, j11 - this.f11373b);
        for (int i12 = 0; i12 < e0VarArr.length; i12++) {
            e0 e0Var = e0VarArr2[i12];
            if (e0Var == null) {
                e0VarArr[i12] = null;
            } else {
                e0 e0Var2 = e0VarArr[i12];
                if (e0Var2 == null || ((a) e0Var2).a() != e0Var) {
                    e0VarArr[i12] = new a(e0Var, this.f11373b);
                }
            }
        }
        return jE + this.f11373b;
    }

    @Override // androidx.media3.exoplayer.source.k.a
    public void f(k kVar) {
        ((k.a) z3.a.e(this.f11374c)).f(this);
    }

    @Override // androidx.media3.exoplayer.source.k
    public void g(k.a aVar, long j11) {
        this.f11374c = aVar;
        this.f11372a.g(this, j11 - this.f11373b);
    }

    @Override // androidx.media3.exoplayer.source.k, androidx.media3.exoplayer.source.t
    public long getBufferedPositionUs() {
        long bufferedPositionUs = this.f11372a.getBufferedPositionUs();
        if (bufferedPositionUs == Long.MIN_VALUE) {
            return Long.MIN_VALUE;
        }
        return this.f11373b + bufferedPositionUs;
    }

    @Override // androidx.media3.exoplayer.source.k, androidx.media3.exoplayer.source.t
    public long getNextLoadPositionUs() {
        long nextLoadPositionUs = this.f11372a.getNextLoadPositionUs();
        if (nextLoadPositionUs == Long.MIN_VALUE) {
            return Long.MIN_VALUE;
        }
        return this.f11373b + nextLoadPositionUs;
    }

    @Override // androidx.media3.exoplayer.source.k
    public k0 getTrackGroups() {
        return this.f11372a.getTrackGroups();
    }

    @Override // androidx.media3.exoplayer.source.t.a
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public void h(k kVar) {
        ((k.a) z3.a.e(this.f11374c)).h(this);
    }

    @Override // androidx.media3.exoplayer.source.k, androidx.media3.exoplayer.source.t
    public boolean isLoading() {
        return this.f11372a.isLoading();
    }

    @Override // androidx.media3.exoplayer.source.k
    public void maybeThrowPrepareError() throws IOException {
        this.f11372a.maybeThrowPrepareError();
    }

    @Override // androidx.media3.exoplayer.source.k
    public long readDiscontinuity() {
        long discontinuity = this.f11372a.readDiscontinuity();
        return discontinuity == C.TIME_UNSET ? C.TIME_UNSET : this.f11373b + discontinuity;
    }

    @Override // androidx.media3.exoplayer.source.k, androidx.media3.exoplayer.source.t
    public void reevaluateBuffer(long j11) {
        this.f11372a.reevaluateBuffer(j11 - this.f11373b);
    }

    @Override // androidx.media3.exoplayer.source.k
    public long seekToUs(long j11) {
        return this.f11372a.seekToUs(j11 - this.f11373b) + this.f11373b;
    }
}
