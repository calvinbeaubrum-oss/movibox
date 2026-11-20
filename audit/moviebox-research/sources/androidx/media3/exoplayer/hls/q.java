package androidx.media3.exoplayer.hls;

import android.net.Uri;
import android.os.Handler;
import android.util.SparseIntArray;
import androidx.annotation.Nullable;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.Metadata;
import androidx.media3.common.ParserException;
import androidx.media3.common.f0;
import androidx.media3.common.n0;
import androidx.media3.common.y;
import androidx.media3.datasource.HttpDataSource;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.b3;
import androidx.media3.exoplayer.source.t;
import androidx.media3.exoplayer.t1;
import androidx.media3.exoplayer.upstream.Loader;
import androidx.media3.exoplayer.w1;
import androidx.media3.extractor.metadata.emsg.EventMessage;
import androidx.media3.extractor.metadata.id3.PrivFrame;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.e0;
import com.google.common.primitives.Ints;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import p4.k0;
import s4.d0;
import s4.z;
import u4.m0;
import u4.q0;
import u4.r0;
import u4.u;
import z3.c0;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class q implements Loader.b<q4.e>, Loader.e, t, u, androidx.media3.exoplayer.source.s.d {
    public static final Set<Integer> Z = Collections.unmodifiableSet(new HashSet(Arrays.asList(1, 2, 5)));
    public r0 A;
    public int B;
    public int C;
    public boolean D;
    public boolean E;
    public int F;
    public y G;

    @Nullable
    public y H;
    public boolean I;
    public k0 J;
    public Set<n0> K;
    public int[] L;
    public int M;
    public boolean N;
    public boolean[] O;
    public boolean[] P;
    public long Q;
    public long R;
    public boolean S;
    public boolean T;
    public boolean U;
    public boolean V;
    public long W;

    @Nullable
    public DrmInitData X;

    @Nullable
    public i Y;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f10587a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f10588b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f10589c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e f10590d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final androidx.media3.exoplayer.upstream.b f10591f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public final y f10592g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final androidx.media3.exoplayer.drm.c f10593h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final androidx.media3.exoplayer.drm.b.a f10594i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final androidx.media3.exoplayer.upstream.m f10595j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final androidx.media3.exoplayer.source.m.a f10597l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f10598m;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ArrayList<i> f10600o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final List<i> f10601p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Runnable f10602q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Runnable f10603r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Handler f10604s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final ArrayList<m> f10605t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Map<String, DrmInitData> f10606u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @Nullable
    public q4.e f10607v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public d[] f10608w;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Set<Integer> f10610y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public SparseIntArray f10611z;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Loader f10596k = new Loader("Loader:HlsSampleStreamWrapper");

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final e.b f10599n = new e.b();

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int[] f10609x = new int[0];

    /* JADX INFO: compiled from: source.java */
    public interface b extends t.a<q> {
        void d(Uri uri);

        void onPrepared();
    }

    /* JADX INFO: compiled from: source.java */
    public static class c implements r0 {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final y f10612g = new y.b().k0(MimeTypes.APPLICATION_ID3).I();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final y f10613h = new y.b().k0(MimeTypes.APPLICATION_EMSG).I();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e5.a f10614a = new e5.a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final r0 f10615b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final y f10616c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public y f10617d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public byte[] f10618e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f10619f;

        public c(r0 r0Var, int i11) {
            this.f10615b = r0Var;
            if (i11 == 1) {
                this.f10616c = f10612g;
            } else {
                if (i11 != 3) {
                    throw new IllegalArgumentException("Unknown metadataType: " + i11);
                }
                this.f10616c = f10613h;
            }
            this.f10618e = new byte[0];
            this.f10619f = 0;
        }

        @Override // u4.r0
        public void a(c0 c0Var, int i11, int i12) {
            h(this.f10619f + i11);
            c0Var.l(this.f10618e, this.f10619f, i11);
            this.f10619f += i11;
        }

        @Override // u4.r0
        public void b(y yVar) {
            this.f10617d = yVar;
            this.f10615b.b(this.f10616c);
        }

        @Override // u4.r0
        public /* synthetic */ void c(c0 c0Var, int i11) {
            q0.b(this, c0Var, i11);
        }

        @Override // u4.r0
        public /* synthetic */ int d(androidx.media3.common.l lVar, int i11, boolean z11) {
            return q0.a(this, lVar, i11, z11);
        }

        @Override // u4.r0
        public int e(androidx.media3.common.l lVar, int i11, boolean z11, int i12) throws IOException {
            h(this.f10619f + i11);
            int i13 = lVar.read(this.f10618e, this.f10619f, i11);
            if (i13 != -1) {
                this.f10619f += i13;
                return i13;
            }
            if (z11) {
                return -1;
            }
            throw new EOFException();
        }

        @Override // u4.r0
        public void f(long j11, int i11, int i12, int i13, @Nullable r0.a aVar) {
            z3.a.e(this.f10617d);
            c0 c0VarI = i(i12, i13);
            if (!u0.c(this.f10617d.f9501m, this.f10616c.f9501m)) {
                if (!MimeTypes.APPLICATION_EMSG.equals(this.f10617d.f9501m)) {
                    z3.o.h("HlsSampleStreamWrapper", "Ignoring sample for unsupported format: " + this.f10617d.f9501m);
                    return;
                }
                EventMessage eventMessageC = this.f10614a.c(c0VarI);
                if (!g(eventMessageC)) {
                    z3.o.h("HlsSampleStreamWrapper", String.format("Ignoring EMSG. Expected it to contain wrapped %s but actual wrapped format: %s", this.f10616c.f9501m, eventMessageC.getWrappedMetadataFormat()));
                    return;
                }
                c0VarI = new c0((byte[]) z3.a.e(eventMessageC.getWrappedMetadataBytes()));
            }
            int iA = c0VarI.a();
            this.f10615b.c(c0VarI, iA);
            this.f10615b.f(j11, i11, iA, i13, aVar);
        }

        public final boolean g(EventMessage eventMessage) {
            y wrappedMetadataFormat = eventMessage.getWrappedMetadataFormat();
            return wrappedMetadataFormat != null && u0.c(this.f10616c.f9501m, wrappedMetadataFormat.f9501m);
        }

        public final void h(int i11) {
            byte[] bArr = this.f10618e;
            if (bArr.length < i11) {
                this.f10618e = Arrays.copyOf(bArr, i11 + (i11 / 2));
            }
        }

        public final c0 i(int i11, int i12) {
            int i13 = this.f10619f - i12;
            c0 c0Var = new c0(Arrays.copyOfRange(this.f10618e, i13 - i11, i13));
            byte[] bArr = this.f10618e;
            System.arraycopy(bArr, i13, bArr, 0, i12);
            this.f10619f = i12;
            return c0Var;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class d extends androidx.media3.exoplayer.source.s {
        public final Map<String, DrmInitData> H;

        @Nullable
        public DrmInitData I;

        public d(androidx.media3.exoplayer.upstream.b bVar, androidx.media3.exoplayer.drm.c cVar, androidx.media3.exoplayer.drm.b.a aVar, Map<String, DrmInitData> map) {
            super(bVar, cVar, aVar);
            this.H = map;
        }

        @Override // androidx.media3.exoplayer.source.s, u4.r0
        public void f(long j11, int i11, int i12, int i13, @Nullable r0.a aVar) {
            super.f(j11, i11, i12, i13, aVar);
        }

        @Nullable
        public final Metadata i0(@Nullable Metadata metadata) {
            if (metadata == null) {
                return null;
            }
            int length = metadata.length();
            int i11 = 0;
            int i12 = 0;
            while (true) {
                if (i12 >= length) {
                    i12 = -1;
                    break;
                }
                Metadata.Entry entry = metadata.get(i12);
                if ((entry instanceof PrivFrame) && "com.apple.streaming.transportStreamTimestamp".equals(((PrivFrame) entry).owner)) {
                    break;
                }
                i12++;
            }
            if (i12 == -1) {
                return metadata;
            }
            if (length == 1) {
                return null;
            }
            Metadata.Entry[] entryArr = new Metadata.Entry[length - 1];
            while (i11 < length) {
                if (i11 != i12) {
                    entryArr[i11 < i12 ? i11 : i11 - 1] = metadata.get(i11);
                }
                i11++;
            }
            return new Metadata(entryArr);
        }

        public void j0(@Nullable DrmInitData drmInitData) {
            this.I = drmInitData;
            J();
        }

        public void k0(i iVar) {
            g0(iVar.f10417k);
        }

        @Override // androidx.media3.exoplayer.source.s
        public y x(y yVar) {
            DrmInitData drmInitData;
            DrmInitData drmInitData2 = this.I;
            if (drmInitData2 == null) {
                drmInitData2 = yVar.f9504p;
            }
            if (drmInitData2 != null && (drmInitData = this.H.get(drmInitData2.schemeType)) != null) {
                drmInitData2 = drmInitData;
            }
            Metadata metadataI0 = i0(yVar.f9499k);
            if (drmInitData2 != yVar.f9504p || metadataI0 != yVar.f9499k) {
                yVar = yVar.b().R(drmInitData2).d0(metadataI0).I();
            }
            return super.x(yVar);
        }
    }

    public q(String str, int i11, b bVar, e eVar, Map<String, DrmInitData> map, androidx.media3.exoplayer.upstream.b bVar2, long j11, @Nullable y yVar, androidx.media3.exoplayer.drm.c cVar, androidx.media3.exoplayer.drm.b.a aVar, androidx.media3.exoplayer.upstream.m mVar, androidx.media3.exoplayer.source.m.a aVar2, int i12) {
        this.f10587a = str;
        this.f10588b = i11;
        this.f10589c = bVar;
        this.f10590d = eVar;
        this.f10606u = map;
        this.f10591f = bVar2;
        this.f10592g = yVar;
        this.f10593h = cVar;
        this.f10594i = aVar;
        this.f10595j = mVar;
        this.f10597l = aVar2;
        this.f10598m = i12;
        Set<Integer> set = Z;
        this.f10610y = new HashSet(set.size());
        this.f10611z = new SparseIntArray(set.size());
        this.f10608w = new d[0];
        this.P = new boolean[0];
        this.O = new boolean[0];
        ArrayList<i> arrayList = new ArrayList<>();
        this.f10600o = arrayList;
        this.f10601p = Collections.unmodifiableList(arrayList);
        this.f10605t = new ArrayList<>();
        this.f10602q = new Runnable() { // from class: androidx.media3.exoplayer.hls.o
            @Override // java.lang.Runnable
            public final void run() {
                this.f10463a.H();
            }
        };
        this.f10603r = new Runnable() { // from class: androidx.media3.exoplayer.hls.p
            @Override // java.lang.Runnable
            public final void run() {
                this.f10464a.Q();
            }
        };
        this.f10604s = u0.A();
        this.Q = j11;
        this.R = j11;
    }

    public static int A(int i11) {
        if (i11 == 1) {
            return 2;
        }
        if (i11 != 2) {
            return i11 != 3 ? 0 : 1;
        }
        return 3;
    }

    public static boolean C(q4.e eVar) {
        return eVar instanceof i;
    }

    private boolean D() {
        return this.R != C.TIME_UNSET;
    }

    public static u4.q q(int i11, int i12) {
        z3.o.h("HlsSampleStreamWrapper", "Unmapped track with id " + i11 + " of type " + i12);
        return new u4.q();
    }

    public static y t(@Nullable y yVar, y yVar2, boolean z11) {
        String strD;
        String strG;
        if (yVar == null) {
            return yVar2;
        }
        int iK = f0.k(yVar2.f9501m);
        if (u0.P(yVar.f9498j, iK) == 1) {
            strD = u0.Q(yVar.f9498j, iK);
            strG = f0.g(strD);
        } else {
            strD = f0.d(yVar.f9498j, yVar2.f9501m);
            strG = yVar2.f9501m;
        }
        y.b bVarM = yVar2.b().X(yVar.f9489a).Z(yVar.f9490b).a0(yVar.f9491c).b0(yVar.f9492d).m0(yVar.f9493e).i0(yVar.f9494f).K(z11 ? yVar.f9495g : -1).f0(z11 ? yVar.f9496h : -1).M(strD);
        if (iK == 2) {
            bVarM.r0(yVar.f9506r).V(yVar.f9507s).U(yVar.f9508t);
        }
        if (strG != null) {
            bVarM.k0(strG);
        }
        int i11 = yVar.f9514z;
        if (i11 != -1 && iK == 1) {
            bVarM.L(i11);
        }
        Metadata metadataCopyWithAppendedEntriesFrom = yVar.f9499k;
        if (metadataCopyWithAppendedEntriesFrom != null) {
            Metadata metadata = yVar2.f9499k;
            if (metadata != null) {
                metadataCopyWithAppendedEntriesFrom = metadata.copyWithAppendedEntriesFrom(metadataCopyWithAppendedEntriesFrom);
            }
            bVarM.d0(metadataCopyWithAppendedEntriesFrom);
        }
        return bVarM.I();
    }

    public static boolean x(y yVar, y yVar2) {
        String str = yVar.f9501m;
        String str2 = yVar2.f9501m;
        int iK = f0.k(str);
        if (iK != 3) {
            return iK == f0.k(str2);
        }
        if (u0.c(str, str2)) {
            return !(MimeTypes.APPLICATION_CEA608.equals(str) || MimeTypes.APPLICATION_CEA708.equals(str)) || yVar.E == yVar2.E;
        }
        return false;
    }

    public final void B(i iVar) {
        this.Y = iVar;
        this.G = iVar.f74325d;
        this.R = C.TIME_UNSET;
        this.f10600o.add(iVar);
        ImmutableList.a aVarBuilder = ImmutableList.builder();
        for (d dVar : this.f10608w) {
            aVarBuilder.a(Integer.valueOf(dVar.H()));
        }
        iVar.l(this, aVarBuilder.m());
        for (d dVar2 : this.f10608w) {
            dVar2.k0(iVar);
            if (iVar.f10420n) {
                dVar2.h0();
            }
        }
    }

    public boolean E(int i11) {
        return !D() && this.f10608w[i11].L(this.U);
    }

    public boolean F() {
        return this.B == 2;
    }

    public final void G() {
        int i11 = this.J.f73574a;
        int[] iArr = new int[i11];
        this.L = iArr;
        Arrays.fill(iArr, -1);
        for (int i12 = 0; i12 < i11; i12++) {
            int i13 = 0;
            while (true) {
                d[] dVarArr = this.f10608w;
                if (i13 >= dVarArr.length) {
                    break;
                }
                if (x((y) z3.a.i(dVarArr[i13].G()), this.J.b(i12).a(0))) {
                    this.L[i12] = i13;
                    break;
                }
                i13++;
            }
        }
        Iterator<m> it = this.f10605t.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    public final void H() {
        if (!this.I && this.L == null && this.D) {
            for (d dVar : this.f10608w) {
                if (dVar.G() == null) {
                    return;
                }
            }
            if (this.J != null) {
                G();
                return;
            }
            l();
            Z();
            this.f10589c.onPrepared();
        }
    }

    public void I() throws IOException {
        this.f10596k.maybeThrowError();
        this.f10590d.o();
    }

    public void J(int i11) throws IOException {
        I();
        this.f10608w[i11].O();
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.b
    /* JADX INFO: renamed from: K, reason: merged with bridge method [inline-methods] */
    public void o(q4.e eVar, long j11, long j12, boolean z11) {
        this.f10607v = null;
        p4.n nVar = new p4.n(eVar.f74322a, eVar.f74323b, eVar.d(), eVar.c(), j11, j12, eVar.a());
        this.f10595j.b(eVar.f74322a);
        this.f10597l.q(nVar, eVar.f74324c, this.f10588b, eVar.f74325d, eVar.f74326e, eVar.f74327f, eVar.f74328g, eVar.f74329h);
        if (z11) {
            return;
        }
        if (D() || this.F == 0) {
            U();
        }
        if (this.F > 0) {
            this.f10589c.h(this);
        }
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.b
    /* JADX INFO: renamed from: L, reason: merged with bridge method [inline-methods] */
    public void n(q4.e eVar, long j11, long j12) {
        this.f10607v = null;
        this.f10590d.q(eVar);
        p4.n nVar = new p4.n(eVar.f74322a, eVar.f74323b, eVar.d(), eVar.c(), j11, j12, eVar.a());
        this.f10595j.b(eVar.f74322a);
        this.f10597l.t(nVar, eVar.f74324c, this.f10588b, eVar.f74325d, eVar.f74326e, eVar.f74327f, eVar.f74328g, eVar.f74329h);
        if (this.E) {
            this.f10589c.h(this);
        } else {
            a(new w1.b().f(this.Q).d());
        }
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.b
    /* JADX INFO: renamed from: M, reason: merged with bridge method [inline-methods] */
    public Loader.c k(q4.e eVar, long j11, long j12, IOException iOException, int i11) {
        Loader.c cVarG;
        int i12;
        boolean zC = C(eVar);
        if (zC && !((i) eVar).o() && (iOException instanceof HttpDataSource.InvalidResponseCodeException) && ((i12 = ((HttpDataSource.InvalidResponseCodeException) iOException).responseCode) == 410 || i12 == 404)) {
            return Loader.f11434d;
        }
        long jA = eVar.a();
        p4.n nVar = new p4.n(eVar.f74322a, eVar.f74323b, eVar.d(), eVar.c(), j11, j12, jA);
        androidx.media3.exoplayer.upstream.m.c cVar = new androidx.media3.exoplayer.upstream.m.c(nVar, new p4.o(eVar.f74324c, this.f10588b, eVar.f74325d, eVar.f74326e, eVar.f74327f, u0.B1(eVar.f74328g), u0.B1(eVar.f74329h)), iOException, i11);
        androidx.media3.exoplayer.upstream.m.b bVarD = this.f10595j.d(d0.c(this.f10590d.k()), cVar);
        boolean zN = (bVarD == null || bVarD.f11494a != 2) ? false : this.f10590d.n(eVar, bVarD.f11495b);
        if (zN) {
            if (zC && jA == 0) {
                ArrayList<i> arrayList = this.f10600o;
                z3.a.g(arrayList.remove(arrayList.size() - 1) == eVar);
                if (this.f10600o.isEmpty()) {
                    this.R = this.Q;
                } else {
                    ((i) e0.g(this.f10600o)).m();
                }
            }
            cVarG = Loader.f11436f;
        } else {
            long jC = this.f10595j.c(cVar);
            cVarG = jC != C.TIME_UNSET ? Loader.g(false, jC) : Loader.f11437g;
        }
        Loader.c cVar2 = cVarG;
        boolean z11 = !cVar2.c();
        this.f10597l.v(nVar, eVar.f74324c, this.f10588b, eVar.f74325d, eVar.f74326e, eVar.f74327f, eVar.f74328g, eVar.f74329h, iOException, z11);
        if (z11) {
            this.f10607v = null;
            this.f10595j.b(eVar.f74322a);
        }
        if (zN) {
            if (this.E) {
                this.f10589c.h(this);
            } else {
                a(new w1.b().f(this.Q).d());
            }
        }
        return cVar2;
    }

    public void N() {
        this.f10610y.clear();
    }

    public boolean O(Uri uri, androidx.media3.exoplayer.upstream.m.c cVar, boolean z11) {
        androidx.media3.exoplayer.upstream.m.b bVarD;
        if (!this.f10590d.p(uri)) {
            return true;
        }
        long j11 = (z11 || (bVarD = this.f10595j.d(d0.c(this.f10590d.k()), cVar)) == null || bVarD.f11494a != 2) ? -9223372036854775807L : bVarD.f11495b;
        return this.f10590d.r(uri, j11) && j11 != C.TIME_UNSET;
    }

    public void P() {
        if (this.f10600o.isEmpty()) {
            return;
        }
        i iVar = (i) e0.g(this.f10600o);
        int iC = this.f10590d.c(iVar);
        if (iC == 1) {
            iVar.t();
        } else if (iC == 2 && !this.U && this.f10596k.i()) {
            this.f10596k.e();
        }
    }

    public final void Q() {
        this.D = true;
        H();
    }

    public void R(n0[] n0VarArr, int i11, int... iArr) {
        this.J = s(n0VarArr);
        this.K = new HashSet();
        for (int i12 : iArr) {
            this.K.add(this.J.b(i12));
        }
        this.M = i11;
        Handler handler = this.f10604s;
        final b bVar = this.f10589c;
        Objects.requireNonNull(bVar);
        handler.post(new Runnable() { // from class: androidx.media3.exoplayer.hls.n
            @Override // java.lang.Runnable
            public final void run() {
                bVar.onPrepared();
            }
        });
        Z();
    }

    public int S(int i11, t1 t1Var, DecoderInputBuffer decoderInputBuffer, int i12) {
        if (D()) {
            return -3;
        }
        int i13 = 0;
        if (!this.f10600o.isEmpty()) {
            int i14 = 0;
            while (i14 < this.f10600o.size() - 1 && w(this.f10600o.get(i14))) {
                i14++;
            }
            u0.d1(this.f10600o, 0, i14);
            i iVar = this.f10600o.get(0);
            y yVar = iVar.f74325d;
            if (!yVar.equals(this.H)) {
                this.f10597l.h(this.f10588b, yVar, iVar.f74326e, iVar.f74327f, iVar.f74328g);
            }
            this.H = yVar;
        }
        if (!this.f10600o.isEmpty() && !this.f10600o.get(0).o()) {
            return -3;
        }
        int iT = this.f10608w[i11].T(t1Var, decoderInputBuffer, i12, this.U);
        if (iT == -5) {
            y yVarN = (y) z3.a.e(t1Var.f11382b);
            if (i11 == this.C) {
                int iD = Ints.d(this.f10608w[i11].R());
                while (i13 < this.f10600o.size() && this.f10600o.get(i13).f10417k != iD) {
                    i13++;
                }
                yVarN = yVarN.n(i13 < this.f10600o.size() ? this.f10600o.get(i13).f74325d : (y) z3.a.e(this.G));
            }
            t1Var.f11382b = yVarN;
        }
        return iT;
    }

    public void T() {
        if (this.E) {
            for (d dVar : this.f10608w) {
                dVar.S();
            }
        }
        this.f10596k.l(this);
        this.f10604s.removeCallbacksAndMessages(null);
        this.I = true;
        this.f10605t.clear();
    }

    public final void U() {
        for (d dVar : this.f10608w) {
            dVar.X(this.S);
        }
        this.S = false;
    }

    public final boolean V(long j11, @Nullable i iVar) {
        int length = this.f10608w.length;
        for (int i11 = 0; i11 < length; i11++) {
            d dVar = this.f10608w[i11];
            if (!(iVar != null ? dVar.Z(iVar.k(i11)) : dVar.a0(j11, false)) && (this.P[i11] || !this.N)) {
                return false;
            }
        }
        return true;
    }

    public boolean W(long j11, boolean z11) {
        i iVar;
        this.Q = j11;
        if (D()) {
            this.R = j11;
            return true;
        }
        if (!this.f10590d.l()) {
            iVar = null;
            break;
        }
        int i11 = 0;
        while (true) {
            if (i11 >= this.f10600o.size()) {
                iVar = null;
                break;
            }
            iVar = this.f10600o.get(i11);
            if (iVar.f74328g == j11) {
                break;
            }
            i11++;
        }
        if (this.D && !z11 && V(j11, iVar)) {
            return false;
        }
        this.R = j11;
        this.U = false;
        this.f10600o.clear();
        if (this.f10596k.i()) {
            if (this.D) {
                for (d dVar : this.f10608w) {
                    dVar.r();
                }
            }
            this.f10596k.e();
        } else {
            this.f10596k.f();
            U();
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:69:0x0121  */
    public boolean X(z[] zVarArr, boolean[] zArr, p4.e0[] e0VarArr, boolean[] zArr2, long j11, boolean z11) {
        boolean z12;
        i();
        int i11 = this.F;
        int i12 = 0;
        for (int i13 = 0; i13 < zVarArr.length; i13++) {
            m mVar = (m) e0VarArr[i13];
            if (mVar != null && (zVarArr[i13] == null || !zArr[i13])) {
                this.F--;
                mVar.d();
                e0VarArr[i13] = null;
            }
        }
        boolean z13 = z11 || (!this.T ? j11 == this.Q : i11 != 0);
        z zVarK = this.f10590d.k();
        boolean z14 = z13;
        z zVar = zVarK;
        for (int i14 = 0; i14 < zVarArr.length; i14++) {
            z zVar2 = zVarArr[i14];
            if (zVar2 != null) {
                int iD = this.J.d(zVar2.getTrackGroup());
                if (iD == this.M) {
                    this.f10590d.v(zVar2);
                    zVar = zVar2;
                }
                if (e0VarArr[i14] == null) {
                    this.F++;
                    m mVar2 = new m(this, iD);
                    e0VarArr[i14] = mVar2;
                    zArr2[i14] = true;
                    if (this.L != null) {
                        mVar2.a();
                        if (!z14) {
                            d dVar = this.f10608w[this.L[iD]];
                            z14 = (dVar.D() == 0 || dVar.a0(j11, true)) ? false : true;
                        }
                    }
                }
            }
        }
        if (this.F == 0) {
            this.f10590d.s();
            this.H = null;
            this.S = true;
            this.f10600o.clear();
            if (this.f10596k.i()) {
                if (this.D) {
                    d[] dVarArr = this.f10608w;
                    int length = dVarArr.length;
                    while (i12 < length) {
                        dVarArr[i12].r();
                        i12++;
                    }
                }
                this.f10596k.e();
            } else {
                U();
            }
        } else {
            if (this.f10600o.isEmpty() || u0.c(zVar, zVarK)) {
                z12 = z11;
            } else {
                if (!this.T) {
                    long j12 = j11 < 0 ? -j11 : 0L;
                    i iVarY = y();
                    zVar.h(j11, j12, C.TIME_UNSET, this.f10601p, this.f10590d.a(iVarY, j11));
                    if (zVar.getSelectedIndexInTrackGroup() == this.f10590d.j().b(iVarY.f74325d)) {
                        z12 = z11;
                    }
                }
                this.S = true;
                z12 = true;
                z14 = true;
            }
            if (z14) {
                W(j11, z12);
                while (i12 < e0VarArr.length) {
                    if (e0VarArr[i12] != null) {
                        zArr2[i12] = true;
                    }
                    i12++;
                }
            }
        }
        e0(e0VarArr);
        this.T = true;
        return z14;
    }

    public void Y(@Nullable DrmInitData drmInitData) {
        if (u0.c(this.X, drmInitData)) {
            return;
        }
        this.X = drmInitData;
        int i11 = 0;
        while (true) {
            d[] dVarArr = this.f10608w;
            if (i11 >= dVarArr.length) {
                return;
            }
            if (this.P[i11]) {
                dVarArr[i11].j0(drmInitData);
            }
            i11++;
        }
    }

    public final void Z() {
        this.E = true;
    }

    @Override // androidx.media3.exoplayer.source.t
    public boolean a(w1 w1Var) {
        List<i> listEmptyList;
        long jMax;
        if (this.U || this.f10596k.i() || this.f10596k.h()) {
            return false;
        }
        if (D()) {
            listEmptyList = Collections.emptyList();
            jMax = this.R;
            for (d dVar : this.f10608w) {
                dVar.c0(this.R);
            }
        } else {
            listEmptyList = this.f10601p;
            i iVarY = y();
            jMax = iVarY.f() ? iVarY.f74329h : Math.max(this.Q, iVarY.f74328g);
        }
        List<i> list = listEmptyList;
        long j11 = jMax;
        this.f10599n.a();
        this.f10590d.e(w1Var, j11, list, this.E || !list.isEmpty(), this.f10599n);
        e.b bVar = this.f10599n;
        boolean z11 = bVar.f10404b;
        q4.e eVar = bVar.f10403a;
        Uri uri = bVar.f10405c;
        if (z11) {
            this.R = C.TIME_UNSET;
            this.U = true;
            return true;
        }
        if (eVar == null) {
            if (uri != null) {
                this.f10589c.d(uri);
            }
            return false;
        }
        if (C(eVar)) {
            B((i) eVar);
        }
        this.f10607v = eVar;
        this.f10597l.z(new p4.n(eVar.f74322a, eVar.f74323b, this.f10596k.m(eVar, this, this.f10595j.a(eVar.f74324c))), eVar.f74324c, this.f10588b, eVar.f74325d, eVar.f74326e, eVar.f74327f, eVar.f74328g, eVar.f74329h);
        return true;
    }

    public void a0(boolean z11) {
        this.f10590d.u(z11);
    }

    public long b(long j11, b3 b3Var) {
        return this.f10590d.b(j11, b3Var);
    }

    public void b0(long j11) {
        if (this.W != j11) {
            this.W = j11;
            for (d dVar : this.f10608w) {
                dVar.b0(j11);
            }
        }
    }

    @Override // androidx.media3.exoplayer.source.s.d
    public void c(y yVar) {
        this.f10604s.post(this.f10602q);
    }

    public int c0(int i11, long j11) {
        if (D()) {
            return 0;
        }
        d dVar = this.f10608w[i11];
        int iF = dVar.F(j11, this.U);
        i iVar = (i) e0.h(this.f10600o, null);
        if (iVar != null && !iVar.o()) {
            iF = Math.min(iF, iVar.k(i11) - dVar.D());
        }
        dVar.f0(iF);
        return iF;
    }

    public void d0(int i11) {
        i();
        z3.a.e(this.L);
        int i12 = this.L[i11];
        z3.a.g(this.O[i12]);
        this.O[i12] = false;
    }

    public void discardBuffer(long j11, boolean z11) {
        if (!this.D || D()) {
            return;
        }
        int length = this.f10608w.length;
        for (int i11 = 0; i11 < length; i11++) {
            this.f10608w[i11].q(j11, z11, this.O[i11]);
        }
    }

    public final void e0(p4.e0[] e0VarArr) {
        this.f10605t.clear();
        for (p4.e0 e0Var : e0VarArr) {
            if (e0Var != null) {
                this.f10605t.add((m) e0Var);
            }
        }
    }

    @Override // u4.u
    public void endTracks() {
        this.V = true;
        this.f10604s.post(this.f10603r);
    }

    @Override // u4.u
    public void f(m0 m0Var) {
    }

    @Override // androidx.media3.exoplayer.source.t
    public long getBufferedPositionUs() {
        if (this.U) {
            return Long.MIN_VALUE;
        }
        if (D()) {
            return this.R;
        }
        long jMax = this.Q;
        i iVarY = y();
        if (!iVarY.f()) {
            if (this.f10600o.size() > 1) {
                ArrayList<i> arrayList = this.f10600o;
                iVarY = arrayList.get(arrayList.size() - 2);
            } else {
                iVarY = null;
            }
        }
        if (iVarY != null) {
            jMax = Math.max(jMax, iVarY.f74329h);
        }
        if (this.D) {
            for (d dVar : this.f10608w) {
                jMax = Math.max(jMax, dVar.A());
            }
        }
        return jMax;
    }

    @Override // androidx.media3.exoplayer.source.t
    public long getNextLoadPositionUs() {
        if (D()) {
            return this.R;
        }
        if (this.U) {
            return Long.MIN_VALUE;
        }
        return y().f74329h;
    }

    public k0 getTrackGroups() {
        i();
        return this.J;
    }

    public final void i() {
        z3.a.g(this.E);
        z3.a.e(this.J);
        z3.a.e(this.K);
    }

    @Override // androidx.media3.exoplayer.source.t
    public boolean isLoading() {
        return this.f10596k.i();
    }

    public int j(int i11) {
        i();
        z3.a.e(this.L);
        int i12 = this.L[i11];
        if (i12 == -1) {
            return this.K.contains(this.J.b(i11)) ? -3 : -2;
        }
        boolean[] zArr = this.O;
        if (zArr[i12]) {
            return -2;
        }
        zArr[i12] = true;
        return i12;
    }

    public final void l() {
        y yVar;
        int length = this.f10608w.length;
        int i11 = 0;
        int i12 = -2;
        int i13 = -1;
        while (true) {
            int i14 = 2;
            if (i11 >= length) {
                break;
            }
            String str = ((y) z3.a.i(this.f10608w[i11].G())).f9501m;
            if (!f0.s(str)) {
                i14 = f0.o(str) ? 1 : f0.r(str) ? 3 : -2;
            }
            if (A(i14) > A(i12)) {
                i13 = i11;
                i12 = i14;
            } else if (i14 == i12 && i13 != -1) {
                i13 = -1;
            }
            i11++;
        }
        n0 n0VarJ = this.f10590d.j();
        int i15 = n0VarJ.f9330a;
        this.M = -1;
        this.L = new int[length];
        for (int i16 = 0; i16 < length; i16++) {
            this.L[i16] = i16;
        }
        n0[] n0VarArr = new n0[length];
        int i17 = 0;
        while (i17 < length) {
            y yVar2 = (y) z3.a.i(this.f10608w[i17].G());
            if (i17 == i13) {
                y[] yVarArr = new y[i15];
                for (int i18 = 0; i18 < i15; i18++) {
                    y yVarA = n0VarJ.a(i18);
                    if (i12 == 1 && (yVar = this.f10592g) != null) {
                        yVarA = yVarA.n(yVar);
                    }
                    yVarArr[i18] = i15 == 1 ? yVar2.n(yVarA) : t(yVarA, yVar2, true);
                }
                n0VarArr[i17] = new n0(this.f10587a, yVarArr);
                this.M = i17;
            } else {
                y yVar3 = (i12 == 2 && f0.o(yVar2.f9501m)) ? this.f10592g : null;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(this.f10587a);
                sb2.append(":muxed:");
                sb2.append(i17 < i13 ? i17 : i17 - 1);
                n0VarArr[i17] = new n0(sb2.toString(), t(yVar3, yVar2, false));
            }
            i17++;
        }
        this.J = s(n0VarArr);
        z3.a.g(this.K == null);
        this.K = Collections.emptySet();
    }

    public final boolean m(int i11) {
        for (int i12 = i11; i12 < this.f10600o.size(); i12++) {
            if (this.f10600o.get(i12).f10420n) {
                return false;
            }
        }
        i iVar = this.f10600o.get(i11);
        for (int i13 = 0; i13 < this.f10608w.length; i13++) {
            if (this.f10608w[i13].D() > iVar.k(i13)) {
                return false;
            }
        }
        return true;
    }

    public void maybeThrowPrepareError() throws IOException {
        I();
        if (this.U && !this.E) {
            throw ParserException.createForMalformedContainer("Loading finished before preparation is complete.", null);
        }
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.e
    public void onLoaderReleased() {
        for (d dVar : this.f10608w) {
            dVar.U();
        }
    }

    public void p() {
        if (this.E) {
            return;
        }
        a(new w1.b().f(this.Q).d());
    }

    public final androidx.media3.exoplayer.source.s r(int i11, int i12) {
        int length = this.f10608w.length;
        boolean z11 = true;
        if (i12 != 1 && i12 != 2) {
            z11 = false;
        }
        d dVar = new d(this.f10591f, this.f10593h, this.f10594i, this.f10606u);
        dVar.c0(this.Q);
        if (z11) {
            dVar.j0(this.X);
        }
        dVar.b0(this.W);
        i iVar = this.Y;
        if (iVar != null) {
            dVar.k0(iVar);
        }
        dVar.e0(this);
        int i13 = length + 1;
        int[] iArrCopyOf = Arrays.copyOf(this.f10609x, i13);
        this.f10609x = iArrCopyOf;
        iArrCopyOf[length] = i11;
        this.f10608w = (d[]) u0.V0(this.f10608w, dVar);
        boolean[] zArrCopyOf = Arrays.copyOf(this.P, i13);
        this.P = zArrCopyOf;
        zArrCopyOf[length] = z11;
        this.N |= z11;
        this.f10610y.add(Integer.valueOf(i12));
        this.f10611z.append(i12, length);
        if (A(i12) > A(this.B)) {
            this.C = length;
            this.B = i12;
        }
        this.O = Arrays.copyOf(this.O, i13);
        return dVar;
    }

    @Override // androidx.media3.exoplayer.source.t
    public void reevaluateBuffer(long j11) {
        if (this.f10596k.h() || D()) {
            return;
        }
        if (this.f10596k.i()) {
            z3.a.e(this.f10607v);
            if (this.f10590d.w(j11, this.f10607v, this.f10601p)) {
                this.f10596k.e();
                return;
            }
            return;
        }
        int size = this.f10601p.size();
        while (size > 0 && this.f10590d.c(this.f10601p.get(size - 1)) == 2) {
            size--;
        }
        if (size < this.f10601p.size()) {
            u(size);
        }
        int iH = this.f10590d.h(j11, this.f10601p);
        if (iH < this.f10600o.size()) {
            u(iH);
        }
    }

    public final k0 s(n0[] n0VarArr) {
        for (int i11 = 0; i11 < n0VarArr.length; i11++) {
            n0 n0Var = n0VarArr[i11];
            y[] yVarArr = new y[n0Var.f9330a];
            for (int i12 = 0; i12 < n0Var.f9330a; i12++) {
                y yVarA = n0Var.a(i12);
                yVarArr[i12] = yVarA.c(this.f10593h.c(yVarA));
            }
            n0VarArr[i11] = new n0(n0Var.f9331b, yVarArr);
        }
        return new k0(n0VarArr);
    }

    @Override // u4.u
    public r0 track(int i11, int i12) {
        r0 r0VarR;
        if (!Z.contains(Integer.valueOf(i12))) {
            int i13 = 0;
            while (true) {
                r0[] r0VarArr = this.f10608w;
                if (i13 >= r0VarArr.length) {
                    r0VarR = null;
                    break;
                }
                if (this.f10609x[i13] == i11) {
                    r0VarR = r0VarArr[i13];
                    break;
                }
                i13++;
            }
        } else {
            r0VarR = z(i11, i12);
        }
        if (r0VarR == null) {
            if (this.V) {
                return q(i11, i12);
            }
            r0VarR = r(i11, i12);
        }
        if (i12 != 5) {
            return r0VarR;
        }
        if (this.A == null) {
            this.A = new c(r0VarR, this.f10598m);
        }
        return this.A;
    }

    public final void u(int i11) {
        z3.a.g(!this.f10596k.i());
        while (true) {
            if (i11 >= this.f10600o.size()) {
                i11 = -1;
                break;
            } else if (m(i11)) {
                break;
            } else {
                i11++;
            }
        }
        if (i11 == -1) {
            return;
        }
        long j11 = y().f74329h;
        i iVarV = v(i11);
        if (this.f10600o.isEmpty()) {
            this.R = this.Q;
        } else {
            ((i) e0.g(this.f10600o)).m();
        }
        this.U = false;
        this.f10597l.C(this.B, iVarV.f74328g, j11);
    }

    public final i v(int i11) {
        i iVar = this.f10600o.get(i11);
        ArrayList<i> arrayList = this.f10600o;
        u0.d1(arrayList, i11, arrayList.size());
        for (int i12 = 0; i12 < this.f10608w.length; i12++) {
            this.f10608w[i12].u(iVar.k(i12));
        }
        return iVar;
    }

    public final boolean w(i iVar) {
        int i11 = iVar.f10417k;
        int length = this.f10608w.length;
        for (int i12 = 0; i12 < length; i12++) {
            if (this.O[i12] && this.f10608w[i12].R() == i11) {
                return false;
            }
        }
        return true;
    }

    public final i y() {
        ArrayList<i> arrayList = this.f10600o;
        return arrayList.get(arrayList.size() - 1);
    }

    @Nullable
    public final r0 z(int i11, int i12) {
        z3.a.a(Z.contains(Integer.valueOf(i12)));
        int i13 = this.f10611z.get(i12, -1);
        if (i13 == -1) {
            return null;
        }
        if (this.f10610y.add(Integer.valueOf(i12))) {
            this.f10609x[i13] = i11;
        }
        return this.f10609x[i13] == i11 ? this.f10608w[i13] : q(i11, i12);
    }
}
