package com.google.android.exoplayer2.source;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.b3;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.n1;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.i0;
import com.google.android.exoplayer2.upstream.k0;
import com.google.android.exoplayer2.upstream.z;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.w;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import nh.d0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class r implements h, Loader.b<c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.google.android.exoplayer2.upstream.n f34363a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.google.android.exoplayer2.upstream.k.a f34364b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final k0 f34365c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final z f34366d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final j.a f34367f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final nh.k0 f34368g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f34370i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final m1 f34372k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f34373l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f34374m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public byte[] f34375n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f34376o;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ArrayList<b> f34369h = new ArrayList<>();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Loader f34371j = new Loader("SingleSampleMediaPeriod");

    /* JADX INFO: compiled from: source.java */
    public final class b implements d0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f34377a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f34378b;

        public b() {
        }

        public final void a() {
            if (this.f34378b) {
                return;
            }
            r.this.f34367f.i(w.k(r.this.f34372k.f33445m), r.this.f34372k, 0, null, 0L);
            this.f34378b = true;
        }

        @Override // nh.d0
        public int b(n1 n1Var, DecoderInputBuffer decoderInputBuffer, int i11) {
            a();
            r rVar = r.this;
            boolean z11 = rVar.f34374m;
            if (z11 && rVar.f34375n == null) {
                this.f34377a = 2;
            }
            int i12 = this.f34377a;
            if (i12 == 2) {
                decoderInputBuffer.a(4);
                return -4;
            }
            if ((i11 & 2) != 0 || i12 == 0) {
                n1Var.f33603b = rVar.f34372k;
                this.f34377a = 1;
                return -5;
            }
            if (!z11) {
                return -3;
            }
            com.google.android.exoplayer2.util.a.e(rVar.f34375n);
            decoderInputBuffer.a(1);
            decoderInputBuffer.f33032f = 0L;
            if ((i11 & 4) == 0) {
                decoderInputBuffer.n(r.this.f34376o);
                ByteBuffer byteBuffer = decoderInputBuffer.f33030c;
                r rVar2 = r.this;
                byteBuffer.put(rVar2.f34375n, 0, rVar2.f34376o);
            }
            if ((i11 & 1) == 0) {
                this.f34377a = 2;
            }
            return -4;
        }

        public void c() {
            if (this.f34377a == 2) {
                this.f34377a = 1;
            }
        }

        @Override // nh.d0
        public boolean isReady() {
            return r.this.f34374m;
        }

        @Override // nh.d0
        public void maybeThrowError() throws IOException {
            r rVar = r.this;
            if (rVar.f34373l) {
                return;
            }
            rVar.f34371j.maybeThrowError();
        }

        @Override // nh.d0
        public int skipData(long j11) {
            a();
            if (j11 <= 0 || this.f34377a == 2) {
                return 0;
            }
            this.f34377a = 2;
            return 1;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c implements Loader.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f34380a = nh.n.a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final com.google.android.exoplayer2.upstream.n f34381b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final i0 f34382c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        public byte[] f34383d;

        public c(com.google.android.exoplayer2.upstream.n nVar, com.google.android.exoplayer2.upstream.k kVar) {
            this.f34381b = nVar;
            this.f34382c = new i0(kVar);
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.d
        public void cancelLoad() {
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.d
        public void load() throws IOException {
            int iF;
            i0 i0Var;
            byte[] bArr;
            this.f34382c.j();
            try {
                this.f34382c.a(this.f34381b);
                do {
                    iF = (int) this.f34382c.f();
                    byte[] bArr2 = this.f34383d;
                    if (bArr2 == null) {
                        this.f34383d = new byte[1024];
                    } else if (iF == bArr2.length) {
                        this.f34383d = Arrays.copyOf(bArr2, bArr2.length * 2);
                    }
                    i0Var = this.f34382c;
                    bArr = this.f34383d;
                } while (i0Var.read(bArr, iF, bArr.length - iF) != -1);
            } finally {
                com.google.android.exoplayer2.upstream.m.a(this.f34382c);
            }
        }
    }

    public r(com.google.android.exoplayer2.upstream.n nVar, com.google.android.exoplayer2.upstream.k.a aVar, @Nullable k0 k0Var, m1 m1Var, long j11, z zVar, j.a aVar2, boolean z11) {
        this.f34363a = nVar;
        this.f34364b = aVar;
        this.f34365c = k0Var;
        this.f34372k = m1Var;
        this.f34370i = j11;
        this.f34366d = zVar;
        this.f34367f = aVar2;
        this.f34373l = z11;
        this.f34368g = new nh.k0(new nh.i0(m1Var));
    }

    @Override // com.google.android.exoplayer2.source.h
    public long a(long j11, b3 b3Var) {
        return j11;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.b
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void j(c cVar, long j11, long j12, boolean z11) {
        i0 i0Var = cVar.f34382c;
        nh.n nVar = new nh.n(cVar.f34380a, cVar.f34381b, i0Var.h(), i0Var.i(), j11, j12, i0Var.f());
        this.f34366d.b(cVar.f34380a);
        this.f34367f.r(nVar, 1, -1, null, 0, null, 0L, this.f34370i);
    }

    @Override // com.google.android.exoplayer2.source.h, com.google.android.exoplayer2.source.q
    public boolean continueLoading(long j11) {
        if (this.f34374m || this.f34371j.i() || this.f34371j.h()) {
            return false;
        }
        com.google.android.exoplayer2.upstream.k kVarCreateDataSource = this.f34364b.createDataSource();
        k0 k0Var = this.f34365c;
        if (k0Var != null) {
            kVarCreateDataSource.e(k0Var);
        }
        c cVar = new c(this.f34363a, kVarCreateDataSource);
        this.f34367f.A(new nh.n(cVar.f34380a, this.f34363a, this.f34371j.m(cVar, this, this.f34366d.a(1))), 1, -1, this.f34372k, 0, null, 0L, this.f34370i);
        return true;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.b
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public void l(c cVar, long j11, long j12) {
        this.f34376o = (int) cVar.f34382c.f();
        this.f34375n = (byte[]) com.google.android.exoplayer2.util.a.e(cVar.f34383d);
        this.f34374m = true;
        i0 i0Var = cVar.f34382c;
        nh.n nVar = new nh.n(cVar.f34380a, cVar.f34381b, i0Var.h(), i0Var.i(), j11, j12, this.f34376o);
        this.f34366d.b(cVar.f34380a);
        this.f34367f.u(nVar, 1, -1, this.f34372k, 0, null, 0L, this.f34370i);
    }

    @Override // com.google.android.exoplayer2.source.h
    public void discardBuffer(long j11, boolean z11) {
    }

    @Override // com.google.android.exoplayer2.source.h
    public long e(fi.s[] sVarArr, boolean[] zArr, d0[] d0VarArr, boolean[] zArr2, long j11) {
        for (int i11 = 0; i11 < sVarArr.length; i11++) {
            d0 d0Var = d0VarArr[i11];
            if (d0Var != null && (sVarArr[i11] == null || !zArr[i11])) {
                this.f34369h.remove(d0Var);
                d0VarArr[i11] = null;
            }
            if (d0VarArr[i11] == null && sVarArr[i11] != null) {
                b bVar = new b();
                this.f34369h.add(bVar);
                d0VarArr[i11] = bVar;
                zArr2[i11] = true;
            }
        }
        return j11;
    }

    @Override // com.google.android.exoplayer2.source.h
    public void f(h.a aVar, long j11) {
        aVar.h(this);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.b
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public Loader.c n(c cVar, long j11, long j12, IOException iOException, int i11) {
        Loader.c cVarG;
        i0 i0Var = cVar.f34382c;
        nh.n nVar = new nh.n(cVar.f34380a, cVar.f34381b, i0Var.h(), i0Var.i(), j11, j12, i0Var.f());
        long jC = this.f34366d.c(new z.c(nVar, new nh.o(1, -1, this.f34372k, 0, null, 0L, o0.f1(this.f34370i)), iOException, i11));
        boolean z11 = jC == C.TIME_UNSET || i11 >= this.f34366d.a(1);
        if (this.f34373l && z11) {
            com.google.android.exoplayer2.util.s.j("SingleSampleMediaPeriod", "Loading failed, treating as end-of-stream.", iOException);
            this.f34374m = true;
            cVarG = Loader.f35231f;
        } else {
            cVarG = jC != C.TIME_UNSET ? Loader.g(false, jC) : Loader.f35232g;
        }
        Loader.c cVar2 = cVarG;
        boolean z12 = !cVar2.c();
        this.f34367f.w(nVar, 1, -1, this.f34372k, 0, null, 0L, this.f34370i, iOException, z12);
        if (z12) {
            this.f34366d.b(cVar.f34380a);
        }
        return cVar2;
    }

    @Override // com.google.android.exoplayer2.source.h, com.google.android.exoplayer2.source.q
    public long getBufferedPositionUs() {
        return this.f34374m ? Long.MIN_VALUE : 0L;
    }

    @Override // com.google.android.exoplayer2.source.h, com.google.android.exoplayer2.source.q
    public long getNextLoadPositionUs() {
        return (this.f34374m || this.f34371j.i()) ? Long.MIN_VALUE : 0L;
    }

    @Override // com.google.android.exoplayer2.source.h
    public nh.k0 getTrackGroups() {
        return this.f34368g;
    }

    public void h() {
        this.f34371j.k();
    }

    @Override // com.google.android.exoplayer2.source.h, com.google.android.exoplayer2.source.q
    public boolean isLoading() {
        return this.f34371j.i();
    }

    @Override // com.google.android.exoplayer2.source.h
    public void maybeThrowPrepareError() {
    }

    @Override // com.google.android.exoplayer2.source.h
    public long readDiscontinuity() {
        return C.TIME_UNSET;
    }

    @Override // com.google.android.exoplayer2.source.h, com.google.android.exoplayer2.source.q
    public void reevaluateBuffer(long j11) {
    }

    @Override // com.google.android.exoplayer2.source.h
    public long seekToUs(long j11) {
        for (int i11 = 0; i11 < this.f34369h.size(); i11++) {
            this.f34369h.get(i11).c();
        }
        return j11;
    }
}
