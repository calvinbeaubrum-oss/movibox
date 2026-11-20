package androidx.media3.exoplayer.source;

import androidx.annotation.Nullable;
import androidx.media3.common.f0;
import androidx.media3.common.n0;
import androidx.media3.common.y;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.b3;
import androidx.media3.exoplayer.t1;
import androidx.media3.exoplayer.upstream.Loader;
import androidx.media3.exoplayer.w1;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import p4.e0;
import p4.k0;
import s4.z;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class u implements k, Loader.b<c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c4.g f11337a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final androidx.media3.datasource.a.InterfaceC0090a f11338b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final c4.o f11339c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final androidx.media3.exoplayer.upstream.m f11340d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final m.a f11341f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final k0 f11342g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f11344i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final y f11346k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f11347l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f11348m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public byte[] f11349n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f11350o;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ArrayList<b> f11343h = new ArrayList<>();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Loader f11345j = new Loader("SingleSampleMediaPeriod");

    /* JADX INFO: compiled from: source.java */
    public final class b implements e0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f11351a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f11352b;

        public b() {
        }

        public final void a() {
            if (this.f11352b) {
                return;
            }
            u.this.f11341f.h(f0.k(u.this.f11346k.f9501m), u.this.f11346k, 0, null, 0L);
            this.f11352b = true;
        }

        public void b() {
            if (this.f11351a == 2) {
                this.f11351a = 1;
            }
        }

        @Override // p4.e0
        public int c(t1 t1Var, DecoderInputBuffer decoderInputBuffer, int i11) {
            a();
            u uVar = u.this;
            boolean z11 = uVar.f11348m;
            if (z11 && uVar.f11349n == null) {
                this.f11351a = 2;
            }
            int i12 = this.f11351a;
            if (i12 == 2) {
                decoderInputBuffer.addFlag(4);
                return -4;
            }
            if ((i11 & 2) != 0 || i12 == 0) {
                t1Var.f11382b = uVar.f11346k;
                this.f11351a = 1;
                return -5;
            }
            if (!z11) {
                return -3;
            }
            z3.a.e(uVar.f11349n);
            decoderInputBuffer.addFlag(1);
            decoderInputBuffer.f9782f = 0L;
            if ((i11 & 4) == 0) {
                decoderInputBuffer.b(u.this.f11350o);
                ByteBuffer byteBuffer = decoderInputBuffer.f9780c;
                u uVar2 = u.this;
                byteBuffer.put(uVar2.f11349n, 0, uVar2.f11350o);
            }
            if ((i11 & 1) == 0) {
                this.f11351a = 2;
            }
            return -4;
        }

        @Override // p4.e0
        public boolean isReady() {
            return u.this.f11348m;
        }

        @Override // p4.e0
        public void maybeThrowError() throws IOException {
            u uVar = u.this;
            if (uVar.f11347l) {
                return;
            }
            uVar.f11345j.maybeThrowError();
        }

        @Override // p4.e0
        public int skipData(long j11) {
            a();
            if (j11 <= 0 || this.f11351a == 2) {
                return 0;
            }
            this.f11351a = 2;
            return 1;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c implements Loader.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f11354a = p4.n.a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final c4.g f11355b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final c4.m f11356c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        public byte[] f11357d;

        public c(c4.g gVar, androidx.media3.datasource.a aVar) {
            this.f11355b = gVar;
            this.f11356c = new c4.m(aVar);
        }

        @Override // androidx.media3.exoplayer.upstream.Loader.d
        public void cancelLoad() {
        }

        @Override // androidx.media3.exoplayer.upstream.Loader.d
        public void load() throws IOException {
            int iD;
            c4.m mVar;
            byte[] bArr;
            this.f11356c.g();
            try {
                this.f11356c.a(this.f11355b);
                do {
                    iD = (int) this.f11356c.d();
                    byte[] bArr2 = this.f11357d;
                    if (bArr2 == null) {
                        this.f11357d = new byte[1024];
                    } else if (iD == bArr2.length) {
                        this.f11357d = Arrays.copyOf(bArr2, bArr2.length * 2);
                    }
                    mVar = this.f11356c;
                    bArr = this.f11357d;
                } while (mVar.read(bArr, iD, bArr.length - iD) != -1);
            } finally {
                c4.f.a(this.f11356c);
            }
        }
    }

    public u(c4.g gVar, androidx.media3.datasource.a.InterfaceC0090a interfaceC0090a, @Nullable c4.o oVar, y yVar, long j11, androidx.media3.exoplayer.upstream.m mVar, m.a aVar, boolean z11) {
        this.f11337a = gVar;
        this.f11338b = interfaceC0090a;
        this.f11339c = oVar;
        this.f11346k = yVar;
        this.f11344i = j11;
        this.f11340d = mVar;
        this.f11341f = aVar;
        this.f11347l = z11;
        this.f11342g = new k0(new n0(yVar));
    }

    @Override // androidx.media3.exoplayer.source.k, androidx.media3.exoplayer.source.t
    public boolean a(w1 w1Var) {
        if (this.f11348m || this.f11345j.i() || this.f11345j.h()) {
            return false;
        }
        androidx.media3.datasource.a aVarCreateDataSource = this.f11338b.createDataSource();
        c4.o oVar = this.f11339c;
        if (oVar != null) {
            aVarCreateDataSource.c(oVar);
        }
        c cVar = new c(this.f11337a, aVarCreateDataSource);
        this.f11341f.z(new p4.n(cVar.f11354a, this.f11337a, this.f11345j.m(cVar, this, this.f11340d.a(1))), 1, -1, this.f11346k, 0, null, 0L, this.f11344i);
        return true;
    }

    @Override // androidx.media3.exoplayer.source.k
    public long b(long j11, b3 b3Var) {
        return j11;
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.b
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public void o(c cVar, long j11, long j12, boolean z11) {
        c4.m mVar = cVar.f11356c;
        p4.n nVar = new p4.n(cVar.f11354a, cVar.f11355b, mVar.e(), mVar.f(), j11, j12, mVar.d());
        this.f11340d.b(cVar.f11354a);
        this.f11341f.q(nVar, 1, -1, null, 0, null, 0L, this.f11344i);
    }

    @Override // androidx.media3.exoplayer.source.k
    public void discardBuffer(long j11, boolean z11) {
    }

    @Override // androidx.media3.exoplayer.source.k
    public long e(z[] zVarArr, boolean[] zArr, e0[] e0VarArr, boolean[] zArr2, long j11) {
        for (int i11 = 0; i11 < zVarArr.length; i11++) {
            e0 e0Var = e0VarArr[i11];
            if (e0Var != null && (zVarArr[i11] == null || !zArr[i11])) {
                this.f11343h.remove(e0Var);
                e0VarArr[i11] = null;
            }
            if (e0VarArr[i11] == null && zVarArr[i11] != null) {
                b bVar = new b();
                this.f11343h.add(bVar);
                e0VarArr[i11] = bVar;
                zArr2[i11] = true;
            }
        }
        return j11;
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.b
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public void n(c cVar, long j11, long j12) {
        this.f11350o = (int) cVar.f11356c.d();
        this.f11349n = (byte[]) z3.a.e(cVar.f11357d);
        this.f11348m = true;
        c4.m mVar = cVar.f11356c;
        p4.n nVar = new p4.n(cVar.f11354a, cVar.f11355b, mVar.e(), mVar.f(), j11, j12, this.f11350o);
        this.f11340d.b(cVar.f11354a);
        this.f11341f.t(nVar, 1, -1, this.f11346k, 0, null, 0L, this.f11344i);
    }

    @Override // androidx.media3.exoplayer.source.k
    public void g(k.a aVar, long j11) {
        aVar.f(this);
    }

    @Override // androidx.media3.exoplayer.source.k, androidx.media3.exoplayer.source.t
    public long getBufferedPositionUs() {
        return this.f11348m ? Long.MIN_VALUE : 0L;
    }

    @Override // androidx.media3.exoplayer.source.k, androidx.media3.exoplayer.source.t
    public long getNextLoadPositionUs() {
        return (this.f11348m || this.f11345j.i()) ? Long.MIN_VALUE : 0L;
    }

    @Override // androidx.media3.exoplayer.source.k
    public k0 getTrackGroups() {
        return this.f11342g;
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.b
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public Loader.c k(c cVar, long j11, long j12, IOException iOException, int i11) {
        Loader.c cVarG;
        c4.m mVar = cVar.f11356c;
        p4.n nVar = new p4.n(cVar.f11354a, cVar.f11355b, mVar.e(), mVar.f(), j11, j12, mVar.d());
        long jC = this.f11340d.c(new androidx.media3.exoplayer.upstream.m.c(nVar, new p4.o(1, -1, this.f11346k, 0, null, 0L, u0.B1(this.f11344i)), iOException, i11));
        boolean z11 = jC == C.TIME_UNSET || i11 >= this.f11340d.a(1);
        if (this.f11347l && z11) {
            z3.o.i("SingleSampleMediaPeriod", "Loading failed, treating as end-of-stream.", iOException);
            this.f11348m = true;
            cVarG = Loader.f11436f;
        } else {
            cVarG = jC != C.TIME_UNSET ? Loader.g(false, jC) : Loader.f11437g;
        }
        Loader.c cVar2 = cVarG;
        boolean z12 = !cVar2.c();
        this.f11341f.v(nVar, 1, -1, this.f11346k, 0, null, 0L, this.f11344i, iOException, z12);
        if (z12) {
            this.f11340d.b(cVar.f11354a);
        }
        return cVar2;
    }

    public void i() {
        this.f11345j.k();
    }

    @Override // androidx.media3.exoplayer.source.k, androidx.media3.exoplayer.source.t
    public boolean isLoading() {
        return this.f11345j.i();
    }

    @Override // androidx.media3.exoplayer.source.k
    public void maybeThrowPrepareError() {
    }

    @Override // androidx.media3.exoplayer.source.k
    public long readDiscontinuity() {
        return C.TIME_UNSET;
    }

    @Override // androidx.media3.exoplayer.source.k, androidx.media3.exoplayer.source.t
    public void reevaluateBuffer(long j11) {
    }

    @Override // androidx.media3.exoplayer.source.k
    public long seekToUs(long j11) {
        for (int i11 = 0; i11 < this.f11343h.size(); i11++) {
            this.f11343h.get(i11).b();
        }
        return j11;
    }
}
