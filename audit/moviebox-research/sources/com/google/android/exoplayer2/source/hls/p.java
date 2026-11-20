package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import android.os.Handler;
import android.util.SparseIntArray;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.b3;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import com.google.android.exoplayer2.metadata.id3.PrivFrame;
import com.google.android.exoplayer2.n1;
import com.google.android.exoplayer2.upstream.HttpDataSource$InvalidResponseCodeException;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.z;
import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.s;
import com.google.android.exoplayer2.util.w;
import com.google.common.collect.ImmutableList;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import fi.a0;
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
import nh.i0;
import nh.k0;
import tg.b0;
import tg.d0;
import tg.e0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class p implements Loader.b<ph.f>, Loader.e, com.google.android.exoplayer2.source.q, tg.n, com.google.android.exoplayer2.source.p.d {
    public static final Set<Integer> Z = Collections.unmodifiableSet(new HashSet(Arrays.asList(1, 2, 5)));
    public e0 A;
    public int B;
    public int C;
    public boolean D;
    public boolean E;
    public int F;
    public m1 G;

    @Nullable
    public m1 H;
    public boolean I;
    public k0 J;
    public Set<i0> K;
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
    public final String f34069a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f34070b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f34071c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e f34072d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.google.android.exoplayer2.upstream.b f34073f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public final m1 f34074g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.google.android.exoplayer2.drm.c f34075h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final com.google.android.exoplayer2.drm.b.a f34076i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final z f34077j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final com.google.android.exoplayer2.source.j.a f34079l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f34080m;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ArrayList<i> f34082o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final List<i> f34083p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Runnable f34084q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Runnable f34085r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Handler f34086s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final ArrayList<l> f34087t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Map<String, DrmInitData> f34088u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @Nullable
    public ph.f f34089v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public d[] f34090w;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Set<Integer> f34092y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public SparseIntArray f34093z;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Loader f34078k = new Loader("Loader:HlsSampleStreamWrapper");

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final e.b f34081n = new e.b();

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int[] f34091x = new int[0];

    /* JADX INFO: compiled from: source.java */
    public interface b extends com.google.android.exoplayer2.source.q.a<p> {
        void d(Uri uri);

        void onPrepared();
    }

    /* JADX INFO: compiled from: source.java */
    public static class c implements e0 {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final m1 f34094g = new m1.b().e0(MimeTypes.APPLICATION_ID3).E();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final m1 f34095h = new m1.b().e0(MimeTypes.APPLICATION_EMSG).E();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ih.a f34096a = new ih.a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final e0 f34097b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final m1 f34098c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public m1 f34099d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public byte[] f34100e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f34101f;

        public c(e0 e0Var, int i11) {
            this.f34097b = e0Var;
            if (i11 == 1) {
                this.f34098c = f34094g;
            } else {
                if (i11 != 3) {
                    throw new IllegalArgumentException("Unknown metadataType: " + i11);
                }
                this.f34098c = f34095h;
            }
            this.f34100e = new byte[0];
            this.f34101f = 0;
        }

        @Override // tg.e0
        public int a(com.google.android.exoplayer2.upstream.g gVar, int i11, boolean z11, int i12) throws IOException {
            h(this.f34101f + i11);
            int i13 = gVar.read(this.f34100e, this.f34101f, i11);
            if (i13 != -1) {
                this.f34101f += i13;
                return i13;
            }
            if (z11) {
                return -1;
            }
            throw new EOFException();
        }

        @Override // tg.e0
        public /* synthetic */ int b(com.google.android.exoplayer2.upstream.g gVar, int i11, boolean z11) {
            return d0.a(this, gVar, i11, z11);
        }

        @Override // tg.e0
        public /* synthetic */ void c(c0 c0Var, int i11) {
            d0.b(this, c0Var, i11);
        }

        @Override // tg.e0
        public void d(long j11, int i11, int i12, int i13, @Nullable e0.a aVar) {
            com.google.android.exoplayer2.util.a.e(this.f34099d);
            c0 c0VarI = i(i12, i13);
            if (!o0.c(this.f34099d.f33445m, this.f34098c.f33445m)) {
                if (!MimeTypes.APPLICATION_EMSG.equals(this.f34099d.f33445m)) {
                    s.i("HlsSampleStreamWrapper", "Ignoring sample for unsupported format: " + this.f34099d.f33445m);
                    return;
                }
                EventMessage eventMessageC = this.f34096a.c(c0VarI);
                if (!g(eventMessageC)) {
                    s.i("HlsSampleStreamWrapper", String.format("Ignoring EMSG. Expected it to contain wrapped %s but actual wrapped format: %s", this.f34098c.f33445m, eventMessageC.getWrappedMetadataFormat()));
                    return;
                }
                c0VarI = new c0((byte[]) com.google.android.exoplayer2.util.a.e(eventMessageC.getWrappedMetadataBytes()));
            }
            int iA = c0VarI.a();
            this.f34097b.c(c0VarI, iA);
            this.f34097b.d(j11, i11, iA, i13, aVar);
        }

        @Override // tg.e0
        public void e(m1 m1Var) {
            this.f34099d = m1Var;
            this.f34097b.e(this.f34098c);
        }

        @Override // tg.e0
        public void f(c0 c0Var, int i11, int i12) {
            h(this.f34101f + i11);
            c0Var.j(this.f34100e, this.f34101f, i11);
            this.f34101f += i11;
        }

        public final boolean g(EventMessage eventMessage) {
            m1 wrappedMetadataFormat = eventMessage.getWrappedMetadataFormat();
            return wrappedMetadataFormat != null && o0.c(this.f34098c.f33445m, wrappedMetadataFormat.f33445m);
        }

        public final void h(int i11) {
            byte[] bArr = this.f34100e;
            if (bArr.length < i11) {
                this.f34100e = Arrays.copyOf(bArr, i11 + (i11 / 2));
            }
        }

        public final c0 i(int i11, int i12) {
            int i13 = this.f34101f - i12;
            c0 c0Var = new c0(Arrays.copyOfRange(this.f34100e, i13 - i11, i13));
            byte[] bArr = this.f34100e;
            System.arraycopy(bArr, i13, bArr, 0, i12);
            this.f34101f = i12;
            return c0Var;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class d extends com.google.android.exoplayer2.source.p {
        public final Map<String, DrmInitData> H;

        @Nullable
        public DrmInitData I;

        public d(com.google.android.exoplayer2.upstream.b bVar, com.google.android.exoplayer2.drm.c cVar, com.google.android.exoplayer2.drm.b.a aVar, Map<String, DrmInitData> map) {
            super(bVar, cVar, aVar);
            this.H = map;
        }

        @Override // com.google.android.exoplayer2.source.p, tg.e0
        public void d(long j11, int i11, int i12, int i13, @Nullable e0.a aVar) {
            super.d(j11, i11, i12, i13, aVar);
        }

        @Nullable
        public final Metadata h0(@Nullable Metadata metadata) {
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

        public void i0(@Nullable DrmInitData drmInitData) {
            this.I = drmInitData;
            I();
        }

        public void j0(i iVar) {
            f0(iVar.f34023k);
        }

        @Override // com.google.android.exoplayer2.source.p
        public m1 w(m1 m1Var) {
            DrmInitData drmInitData;
            DrmInitData drmInitData2 = this.I;
            if (drmInitData2 == null) {
                drmInitData2 = m1Var.f33448p;
            }
            if (drmInitData2 != null && (drmInitData = this.H.get(drmInitData2.schemeType)) != null) {
                drmInitData2 = drmInitData;
            }
            Metadata metadataH0 = h0(m1Var.f33443k);
            if (drmInitData2 != m1Var.f33448p || metadataH0 != m1Var.f33443k) {
                m1Var = m1Var.b().M(drmInitData2).X(metadataH0).E();
            }
            return super.w(m1Var);
        }
    }

    public p(String str, int i11, b bVar, e eVar, Map<String, DrmInitData> map, com.google.android.exoplayer2.upstream.b bVar2, long j11, @Nullable m1 m1Var, com.google.android.exoplayer2.drm.c cVar, com.google.android.exoplayer2.drm.b.a aVar, z zVar, com.google.android.exoplayer2.source.j.a aVar2, int i12) {
        this.f34069a = str;
        this.f34070b = i11;
        this.f34071c = bVar;
        this.f34072d = eVar;
        this.f34088u = map;
        this.f34073f = bVar2;
        this.f34074g = m1Var;
        this.f34075h = cVar;
        this.f34076i = aVar;
        this.f34077j = zVar;
        this.f34079l = aVar2;
        this.f34080m = i12;
        Set<Integer> set = Z;
        this.f34092y = new HashSet(set.size());
        this.f34093z = new SparseIntArray(set.size());
        this.f34090w = new d[0];
        this.P = new boolean[0];
        this.O = new boolean[0];
        ArrayList<i> arrayList = new ArrayList<>();
        this.f34082o = arrayList;
        this.f34083p = Collections.unmodifiableList(arrayList);
        this.f34087t = new ArrayList<>();
        this.f34084q = new Runnable() { // from class: com.google.android.exoplayer2.source.hls.n
            @Override // java.lang.Runnable
            public final void run() {
                this.f34067a.G();
            }
        };
        this.f34085r = new Runnable() { // from class: com.google.android.exoplayer2.source.hls.o
            @Override // java.lang.Runnable
            public final void run() {
                this.f34068a.P();
            }
        };
        this.f34086s = o0.w();
        this.Q = j11;
        this.R = j11;
    }

    private static boolean B(ph.f fVar) {
        return fVar instanceof i;
    }

    private boolean C() {
        return this.R != C.TIME_UNSET;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G() {
        if (!this.I && this.L == null && this.D) {
            for (d dVar : this.f34090w) {
                if (dVar.F() == null) {
                    return;
                }
            }
            if (this.J != null) {
                F();
                return;
            }
            k();
            Y();
            this.f34071c.onPrepared();
        }
    }

    private void T() {
        for (d dVar : this.f34090w) {
            dVar.W(this.S);
        }
        this.S = false;
    }

    public static tg.k p(int i11, int i12) {
        s.i("HlsSampleStreamWrapper", "Unmapped track with id " + i11 + " of type " + i12);
        return new tg.k();
    }

    public static m1 s(@Nullable m1 m1Var, m1 m1Var2, boolean z11) {
        String strD;
        String strG;
        if (m1Var == null) {
            return m1Var2;
        }
        int iK = w.k(m1Var2.f33445m);
        if (o0.K(m1Var.f33442j, iK) == 1) {
            strD = o0.L(m1Var.f33442j, iK);
            strG = w.g(strD);
        } else {
            strD = w.d(m1Var.f33442j, m1Var2.f33445m);
            strG = m1Var2.f33445m;
        }
        m1.b bVarI = m1Var2.b().S(m1Var.f33434a).U(m1Var.f33435b).V(m1Var.f33436c).g0(m1Var.f33437d).c0(m1Var.f33438f).G(z11 ? m1Var.f33439g : -1).Z(z11 ? m1Var.f33440h : -1).I(strD);
        if (iK == 2) {
            bVarI.j0(m1Var.f33450r).Q(m1Var.f33451s).P(m1Var.f33452t);
        }
        if (strG != null) {
            bVarI.e0(strG);
        }
        int i11 = m1Var.f33458z;
        if (i11 != -1 && iK == 1) {
            bVarI.H(i11);
        }
        Metadata metadataCopyWithAppendedEntriesFrom = m1Var.f33443k;
        if (metadataCopyWithAppendedEntriesFrom != null) {
            Metadata metadata = m1Var2.f33443k;
            if (metadata != null) {
                metadataCopyWithAppendedEntriesFrom = metadata.copyWithAppendedEntriesFrom(metadataCopyWithAppendedEntriesFrom);
            }
            bVarI.X(metadataCopyWithAppendedEntriesFrom);
        }
        return bVarI.E();
    }

    private void t(int i11) {
        com.google.android.exoplayer2.util.a.g(!this.f34078k.i());
        while (true) {
            if (i11 >= this.f34082o.size()) {
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
        long j11 = x().f73813h;
        i iVarU = u(i11);
        if (this.f34082o.isEmpty()) {
            this.R = this.Q;
        } else {
            ((i) com.google.common.collect.e0.g(this.f34082o)).m();
        }
        this.U = false;
        this.f34079l.D(this.B, iVarU.f73812g, j11);
    }

    public static boolean w(m1 m1Var, m1 m1Var2) {
        String str = m1Var.f33445m;
        String str2 = m1Var2.f33445m;
        int iK = w.k(str);
        if (iK != 3) {
            return iK == w.k(str2);
        }
        if (o0.c(str, str2)) {
            return !(MimeTypes.APPLICATION_CEA608.equals(str) || MimeTypes.APPLICATION_CEA708.equals(str)) || m1Var.E == m1Var2.E;
        }
        return false;
    }

    public static int z(int i11) {
        if (i11 == 1) {
            return 2;
        }
        if (i11 != 2) {
            return i11 != 3 ? 0 : 1;
        }
        return 3;
    }

    public final void A(i iVar) {
        this.Y = iVar;
        this.G = iVar.f73809d;
        this.R = C.TIME_UNSET;
        this.f34082o.add(iVar);
        ImmutableList.a aVarBuilder = ImmutableList.builder();
        for (d dVar : this.f34090w) {
            aVarBuilder.a(Integer.valueOf(dVar.G()));
        }
        iVar.l(this, aVarBuilder.m());
        for (d dVar2 : this.f34090w) {
            dVar2.j0(iVar);
            if (iVar.f34026n) {
                dVar2.g0();
            }
        }
    }

    public boolean D(int i11) {
        return !C() && this.f34090w[i11].K(this.U);
    }

    public boolean E() {
        return this.B == 2;
    }

    public final void F() {
        int i11 = this.J.f71941a;
        int[] iArr = new int[i11];
        this.L = iArr;
        Arrays.fill(iArr, -1);
        for (int i12 = 0; i12 < i11; i12++) {
            int i13 = 0;
            while (true) {
                d[] dVarArr = this.f34090w;
                if (i13 >= dVarArr.length) {
                    break;
                }
                if (w((m1) com.google.android.exoplayer2.util.a.i(dVarArr[i13].F()), this.J.b(i12).c(0))) {
                    this.L[i12] = i13;
                    break;
                }
                i13++;
            }
        }
        Iterator<l> it = this.f34087t.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    public void H() throws IOException {
        this.f34078k.maybeThrowError();
        this.f34072d.n();
    }

    public void I(int i11) throws IOException {
        H();
        this.f34090w[i11].N();
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.b
    /* JADX INFO: renamed from: J, reason: merged with bridge method [inline-methods] */
    public void j(ph.f fVar, long j11, long j12, boolean z11) {
        this.f34089v = null;
        nh.n nVar = new nh.n(fVar.f73806a, fVar.f73807b, fVar.d(), fVar.c(), j11, j12, fVar.a());
        this.f34077j.b(fVar.f73806a);
        this.f34079l.r(nVar, fVar.f73808c, this.f34070b, fVar.f73809d, fVar.f73810e, fVar.f73811f, fVar.f73812g, fVar.f73813h);
        if (z11) {
            return;
        }
        if (C() || this.F == 0) {
            T();
        }
        if (this.F > 0) {
            this.f34071c.g(this);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.b
    /* JADX INFO: renamed from: K, reason: merged with bridge method [inline-methods] */
    public void l(ph.f fVar, long j11, long j12) {
        this.f34089v = null;
        this.f34072d.p(fVar);
        nh.n nVar = new nh.n(fVar.f73806a, fVar.f73807b, fVar.d(), fVar.c(), j11, j12, fVar.a());
        this.f34077j.b(fVar.f73806a);
        this.f34079l.u(nVar, fVar.f73808c, this.f34070b, fVar.f73809d, fVar.f73810e, fVar.f73811f, fVar.f73812g, fVar.f73813h);
        if (this.E) {
            this.f34071c.g(this);
        } else {
            continueLoading(this.Q);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.b
    /* JADX INFO: renamed from: L, reason: merged with bridge method [inline-methods] */
    public Loader.c n(ph.f fVar, long j11, long j12, IOException iOException, int i11) {
        Loader.c cVarG;
        int i12;
        boolean zB = B(fVar);
        if (zB && !((i) fVar).o() && (iOException instanceof HttpDataSource$InvalidResponseCodeException) && ((i12 = ((HttpDataSource$InvalidResponseCodeException) iOException).responseCode) == 410 || i12 == 404)) {
            return Loader.f35229d;
        }
        long jA = fVar.a();
        nh.n nVar = new nh.n(fVar.f73806a, fVar.f73807b, fVar.d(), fVar.c(), j11, j12, jA);
        z.c cVar = new z.c(nVar, new nh.o(fVar.f73808c, this.f34070b, fVar.f73809d, fVar.f73810e, fVar.f73811f, o0.f1(fVar.f73812g), o0.f1(fVar.f73813h)), iOException, i11);
        z.b bVarD = this.f34077j.d(a0.c(this.f34072d.k()), cVar);
        boolean zM = (bVarD == null || bVarD.f35525a != 2) ? false : this.f34072d.m(fVar, bVarD.f35526b);
        if (zM) {
            if (zB && jA == 0) {
                ArrayList<i> arrayList = this.f34082o;
                com.google.android.exoplayer2.util.a.g(arrayList.remove(arrayList.size() - 1) == fVar);
                if (this.f34082o.isEmpty()) {
                    this.R = this.Q;
                } else {
                    ((i) com.google.common.collect.e0.g(this.f34082o)).m();
                }
            }
            cVarG = Loader.f35231f;
        } else {
            long jC = this.f34077j.c(cVar);
            cVarG = jC != C.TIME_UNSET ? Loader.g(false, jC) : Loader.f35232g;
        }
        Loader.c cVar2 = cVarG;
        boolean z11 = !cVar2.c();
        this.f34079l.w(nVar, fVar.f73808c, this.f34070b, fVar.f73809d, fVar.f73810e, fVar.f73811f, fVar.f73812g, fVar.f73813h, iOException, z11);
        if (z11) {
            this.f34089v = null;
            this.f34077j.b(fVar.f73806a);
        }
        if (zM) {
            if (this.E) {
                this.f34071c.g(this);
            } else {
                continueLoading(this.Q);
            }
        }
        return cVar2;
    }

    public void M() {
        this.f34092y.clear();
    }

    public boolean N(Uri uri, z.c cVar, boolean z11) {
        z.b bVarD;
        if (!this.f34072d.o(uri)) {
            return true;
        }
        long j11 = (z11 || (bVarD = this.f34077j.d(a0.c(this.f34072d.k()), cVar)) == null || bVarD.f35525a != 2) ? -9223372036854775807L : bVarD.f35526b;
        return this.f34072d.q(uri, j11) && j11 != C.TIME_UNSET;
    }

    public void O() {
        if (this.f34082o.isEmpty()) {
            return;
        }
        i iVar = (i) com.google.common.collect.e0.g(this.f34082o);
        int iC = this.f34072d.c(iVar);
        if (iC == 1) {
            iVar.t();
        } else if (iC == 2 && !this.U && this.f34078k.i()) {
            this.f34078k.e();
        }
    }

    public final void P() {
        this.D = true;
        G();
    }

    public void Q(i0[] i0VarArr, int i11, int... iArr) {
        this.J = r(i0VarArr);
        this.K = new HashSet();
        for (int i12 : iArr) {
            this.K.add(this.J.b(i12));
        }
        this.M = i11;
        Handler handler = this.f34086s;
        final b bVar = this.f34071c;
        Objects.requireNonNull(bVar);
        handler.post(new Runnable() { // from class: com.google.android.exoplayer2.source.hls.m
            @Override // java.lang.Runnable
            public final void run() {
                bVar.onPrepared();
            }
        });
        Y();
    }

    public int R(int i11, n1 n1Var, DecoderInputBuffer decoderInputBuffer, int i12) {
        if (C()) {
            return -3;
        }
        int i13 = 0;
        if (!this.f34082o.isEmpty()) {
            int i14 = 0;
            while (i14 < this.f34082o.size() - 1 && v(this.f34082o.get(i14))) {
                i14++;
            }
            o0.N0(this.f34082o, 0, i14);
            i iVar = this.f34082o.get(0);
            m1 m1Var = iVar.f73809d;
            if (!m1Var.equals(this.H)) {
                this.f34079l.i(this.f34070b, m1Var, iVar.f73810e, iVar.f73811f, iVar.f73812g);
            }
            this.H = m1Var;
        }
        if (!this.f34082o.isEmpty() && !this.f34082o.get(0).o()) {
            return -3;
        }
        int iS = this.f34090w[i11].S(n1Var, decoderInputBuffer, i12, this.U);
        if (iS == -5) {
            m1 m1VarJ = (m1) com.google.android.exoplayer2.util.a.e(n1Var.f33603b);
            if (i11 == this.C) {
                int iQ = this.f34090w[i11].Q();
                while (i13 < this.f34082o.size() && this.f34082o.get(i13).f34023k != iQ) {
                    i13++;
                }
                m1VarJ = m1VarJ.j(i13 < this.f34082o.size() ? this.f34082o.get(i13).f73809d : (m1) com.google.android.exoplayer2.util.a.e(this.G));
            }
            n1Var.f33603b = m1VarJ;
        }
        return iS;
    }

    public void S() {
        if (this.E) {
            for (d dVar : this.f34090w) {
                dVar.R();
            }
        }
        this.f34078k.l(this);
        this.f34086s.removeCallbacksAndMessages(null);
        this.I = true;
        this.f34087t.clear();
    }

    public final boolean U(long j11) {
        int length = this.f34090w.length;
        for (int i11 = 0; i11 < length; i11++) {
            if (!this.f34090w[i11].Z(j11, false) && (this.P[i11] || !this.N)) {
                return false;
            }
        }
        return true;
    }

    public boolean V(long j11, boolean z11) {
        this.Q = j11;
        if (C()) {
            this.R = j11;
            return true;
        }
        if (this.D && !z11 && U(j11)) {
            return false;
        }
        this.R = j11;
        this.U = false;
        this.f34082o.clear();
        if (this.f34078k.i()) {
            if (this.D) {
                for (d dVar : this.f34090w) {
                    dVar.r();
                }
            }
            this.f34078k.e();
        } else {
            this.f34078k.f();
            T();
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:69:0x0121  */
    public boolean W(fi.s[] sVarArr, boolean[] zArr, nh.d0[] d0VarArr, boolean[] zArr2, long j11, boolean z11) {
        boolean z12;
        h();
        int i11 = this.F;
        int i12 = 0;
        for (int i13 = 0; i13 < sVarArr.length; i13++) {
            l lVar = (l) d0VarArr[i13];
            if (lVar != null && (sVarArr[i13] == null || !zArr[i13])) {
                this.F--;
                lVar.d();
                d0VarArr[i13] = null;
            }
        }
        boolean z13 = z11 || (!this.T ? j11 == this.Q : i11 != 0);
        fi.s sVarK = this.f34072d.k();
        boolean z14 = z13;
        fi.s sVar = sVarK;
        for (int i14 = 0; i14 < sVarArr.length; i14++) {
            fi.s sVar2 = sVarArr[i14];
            if (sVar2 != null) {
                int iC = this.J.c(sVar2.getTrackGroup());
                if (iC == this.M) {
                    this.f34072d.u(sVar2);
                    sVar = sVar2;
                }
                if (d0VarArr[i14] == null) {
                    this.F++;
                    l lVar2 = new l(this, iC);
                    d0VarArr[i14] = lVar2;
                    zArr2[i14] = true;
                    if (this.L != null) {
                        lVar2.a();
                        if (!z14) {
                            d dVar = this.f34090w[this.L[iC]];
                            z14 = (dVar.Z(j11, true) || dVar.C() == 0) ? false : true;
                        }
                    }
                }
            }
        }
        if (this.F == 0) {
            this.f34072d.r();
            this.H = null;
            this.S = true;
            this.f34082o.clear();
            if (this.f34078k.i()) {
                if (this.D) {
                    d[] dVarArr = this.f34090w;
                    int length = dVarArr.length;
                    while (i12 < length) {
                        dVarArr[i12].r();
                        i12++;
                    }
                }
                this.f34078k.e();
            } else {
                T();
            }
        } else {
            if (this.f34082o.isEmpty() || o0.c(sVar, sVarK)) {
                z12 = z11;
            } else {
                if (!this.T) {
                    long j12 = j11 < 0 ? -j11 : 0L;
                    i iVarX = x();
                    sVar.d(j11, j12, C.TIME_UNSET, this.f34083p, this.f34072d.a(iVarX, j11));
                    if (sVar.getSelectedIndexInTrackGroup() == this.f34072d.j().d(iVarX.f73809d)) {
                        z12 = z11;
                    }
                }
                this.S = true;
                z12 = true;
                z14 = true;
            }
            if (z14) {
                V(j11, z12);
                while (i12 < d0VarArr.length) {
                    if (d0VarArr[i12] != null) {
                        zArr2[i12] = true;
                    }
                    i12++;
                }
            }
        }
        d0(d0VarArr);
        this.T = true;
        return z14;
    }

    public void X(@Nullable DrmInitData drmInitData) {
        if (o0.c(this.X, drmInitData)) {
            return;
        }
        this.X = drmInitData;
        int i11 = 0;
        while (true) {
            d[] dVarArr = this.f34090w;
            if (i11 >= dVarArr.length) {
                return;
            }
            if (this.P[i11]) {
                dVarArr[i11].i0(drmInitData);
            }
            i11++;
        }
    }

    public final void Y() {
        this.E = true;
    }

    public void Z(boolean z11) {
        this.f34072d.t(z11);
    }

    public long a(long j11, b3 b3Var) {
        return this.f34072d.b(j11, b3Var);
    }

    public void a0(long j11) {
        if (this.W != j11) {
            this.W = j11;
            for (d dVar : this.f34090w) {
                dVar.a0(j11);
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.p.d
    public void b(m1 m1Var) {
        this.f34086s.post(this.f34084q);
    }

    public int b0(int i11, long j11) {
        if (C()) {
            return 0;
        }
        d dVar = this.f34090w[i11];
        int iE = dVar.E(j11, this.U);
        i iVar = (i) com.google.common.collect.e0.h(this.f34082o, null);
        if (iVar != null && !iVar.o()) {
            iE = Math.min(iE, iVar.k(i11) - dVar.C());
        }
        dVar.e0(iE);
        return iE;
    }

    public void c0(int i11) {
        h();
        com.google.android.exoplayer2.util.a.e(this.L);
        int i12 = this.L[i11];
        com.google.android.exoplayer2.util.a.g(this.O[i12]);
        this.O[i12] = false;
    }

    @Override // com.google.android.exoplayer2.source.q
    public boolean continueLoading(long j11) {
        List<i> listEmptyList;
        long jMax;
        if (this.U || this.f34078k.i() || this.f34078k.h()) {
            return false;
        }
        if (C()) {
            listEmptyList = Collections.emptyList();
            jMax = this.R;
            for (d dVar : this.f34090w) {
                dVar.b0(this.R);
            }
        } else {
            listEmptyList = this.f34083p;
            i iVarX = x();
            jMax = iVarX.f() ? iVarX.f73813h : Math.max(this.Q, iVarX.f73812g);
        }
        List<i> list = listEmptyList;
        long j12 = jMax;
        this.f34081n.a();
        this.f34072d.e(j11, j12, list, this.E || !list.isEmpty(), this.f34081n);
        e.b bVar = this.f34081n;
        boolean z11 = bVar.f34009b;
        ph.f fVar = bVar.f34008a;
        Uri uri = bVar.f34010c;
        if (z11) {
            this.R = C.TIME_UNSET;
            this.U = true;
            return true;
        }
        if (fVar == null) {
            if (uri != null) {
                this.f34071c.d(uri);
            }
            return false;
        }
        if (B(fVar)) {
            A((i) fVar);
        }
        this.f34089v = fVar;
        this.f34079l.A(new nh.n(fVar.f73806a, fVar.f73807b, this.f34078k.m(fVar, this, this.f34077j.a(fVar.f73808c))), fVar.f73808c, this.f34070b, fVar.f73809d, fVar.f73810e, fVar.f73811f, fVar.f73812g, fVar.f73813h);
        return true;
    }

    public final void d0(nh.d0[] d0VarArr) {
        this.f34087t.clear();
        for (nh.d0 d0Var : d0VarArr) {
            if (d0Var != null) {
                this.f34087t.add((l) d0Var);
            }
        }
    }

    public void discardBuffer(long j11, boolean z11) {
        if (!this.D || C()) {
            return;
        }
        int length = this.f34090w.length;
        for (int i11 = 0; i11 < length; i11++) {
            this.f34090w[i11].q(j11, z11, this.O[i11]);
        }
    }

    @Override // tg.n
    public void endTracks() {
        this.V = true;
        this.f34086s.post(this.f34085r);
    }

    @Override // tg.n
    public void g(b0 b0Var) {
    }

    @Override // com.google.android.exoplayer2.source.q
    public long getBufferedPositionUs() {
        if (this.U) {
            return Long.MIN_VALUE;
        }
        if (C()) {
            return this.R;
        }
        long jMax = this.Q;
        i iVarX = x();
        if (!iVarX.f()) {
            if (this.f34082o.size() > 1) {
                ArrayList<i> arrayList = this.f34082o;
                iVarX = arrayList.get(arrayList.size() - 2);
            } else {
                iVarX = null;
            }
        }
        if (iVarX != null) {
            jMax = Math.max(jMax, iVarX.f73813h);
        }
        if (this.D) {
            for (d dVar : this.f34090w) {
                jMax = Math.max(jMax, dVar.z());
            }
        }
        return jMax;
    }

    @Override // com.google.android.exoplayer2.source.q
    public long getNextLoadPositionUs() {
        if (C()) {
            return this.R;
        }
        if (this.U) {
            return Long.MIN_VALUE;
        }
        return x().f73813h;
    }

    public k0 getTrackGroups() {
        h();
        return this.J;
    }

    public final void h() {
        com.google.android.exoplayer2.util.a.g(this.E);
        com.google.android.exoplayer2.util.a.e(this.J);
        com.google.android.exoplayer2.util.a.e(this.K);
    }

    public int i(int i11) {
        h();
        com.google.android.exoplayer2.util.a.e(this.L);
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

    @Override // com.google.android.exoplayer2.source.q
    public boolean isLoading() {
        return this.f34078k.i();
    }

    public final void k() {
        m1 m1Var;
        int length = this.f34090w.length;
        int i11 = 0;
        int i12 = -2;
        int i13 = -1;
        while (true) {
            int i14 = 2;
            if (i11 >= length) {
                break;
            }
            String str = ((m1) com.google.android.exoplayer2.util.a.i(this.f34090w[i11].F())).f33445m;
            if (!w.s(str)) {
                i14 = w.o(str) ? 1 : w.r(str) ? 3 : -2;
            }
            if (z(i14) > z(i12)) {
                i13 = i11;
                i12 = i14;
            } else if (i14 == i12 && i13 != -1) {
                i13 = -1;
            }
            i11++;
        }
        i0 i0VarJ = this.f34072d.j();
        int i15 = i0VarJ.f71931a;
        this.M = -1;
        this.L = new int[length];
        for (int i16 = 0; i16 < length; i16++) {
            this.L[i16] = i16;
        }
        i0[] i0VarArr = new i0[length];
        int i17 = 0;
        while (i17 < length) {
            m1 m1Var2 = (m1) com.google.android.exoplayer2.util.a.i(this.f34090w[i17].F());
            if (i17 == i13) {
                m1[] m1VarArr = new m1[i15];
                for (int i18 = 0; i18 < i15; i18++) {
                    m1 m1VarC = i0VarJ.c(i18);
                    if (i12 == 1 && (m1Var = this.f34074g) != null) {
                        m1VarC = m1VarC.j(m1Var);
                    }
                    m1VarArr[i18] = i15 == 1 ? m1Var2.j(m1VarC) : s(m1VarC, m1Var2, true);
                }
                i0VarArr[i17] = new i0(this.f34069a, m1VarArr);
                this.M = i17;
            } else {
                m1 m1Var3 = (i12 == 2 && w.o(m1Var2.f33445m)) ? this.f34074g : null;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(this.f34069a);
                sb2.append(":muxed:");
                sb2.append(i17 < i13 ? i17 : i17 - 1);
                i0VarArr[i17] = new i0(sb2.toString(), s(m1Var3, m1Var2, false));
            }
            i17++;
        }
        this.J = r(i0VarArr);
        com.google.android.exoplayer2.util.a.g(this.K == null);
        this.K = Collections.emptySet();
    }

    public final boolean m(int i11) {
        for (int i12 = i11; i12 < this.f34082o.size(); i12++) {
            if (this.f34082o.get(i12).f34026n) {
                return false;
            }
        }
        i iVar = this.f34082o.get(i11);
        for (int i13 = 0; i13 < this.f34090w.length; i13++) {
            if (this.f34090w[i13].C() > iVar.k(i13)) {
                return false;
            }
        }
        return true;
    }

    public void maybeThrowPrepareError() throws IOException {
        H();
        if (this.U && !this.E) {
            throw ParserException.createForMalformedContainer("Loading finished before preparation is complete.", null);
        }
    }

    public void o() {
        if (this.E) {
            return;
        }
        continueLoading(this.Q);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.e
    public void onLoaderReleased() {
        for (d dVar : this.f34090w) {
            dVar.T();
        }
    }

    public final com.google.android.exoplayer2.source.p q(int i11, int i12) {
        int length = this.f34090w.length;
        boolean z11 = true;
        if (i12 != 1 && i12 != 2) {
            z11 = false;
        }
        d dVar = new d(this.f34073f, this.f34075h, this.f34076i, this.f34088u);
        dVar.b0(this.Q);
        if (z11) {
            dVar.i0(this.X);
        }
        dVar.a0(this.W);
        i iVar = this.Y;
        if (iVar != null) {
            dVar.j0(iVar);
        }
        dVar.d0(this);
        int i13 = length + 1;
        int[] iArrCopyOf = Arrays.copyOf(this.f34091x, i13);
        this.f34091x = iArrCopyOf;
        iArrCopyOf[length] = i11;
        this.f34090w = (d[]) o0.F0(this.f34090w, dVar);
        boolean[] zArrCopyOf = Arrays.copyOf(this.P, i13);
        this.P = zArrCopyOf;
        zArrCopyOf[length] = z11;
        this.N |= z11;
        this.f34092y.add(Integer.valueOf(i12));
        this.f34093z.append(i12, length);
        if (z(i12) > z(this.B)) {
            this.C = length;
            this.B = i12;
        }
        this.O = Arrays.copyOf(this.O, i13);
        return dVar;
    }

    public final k0 r(i0[] i0VarArr) {
        for (int i11 = 0; i11 < i0VarArr.length; i11++) {
            i0 i0Var = i0VarArr[i11];
            m1[] m1VarArr = new m1[i0Var.f71931a];
            for (int i12 = 0; i12 < i0Var.f71931a; i12++) {
                m1 m1VarC = i0Var.c(i12);
                m1VarArr[i12] = m1VarC.c(this.f34075h.a(m1VarC));
            }
            i0VarArr[i11] = new i0(i0Var.f71932b, m1VarArr);
        }
        return new k0(i0VarArr);
    }

    @Override // com.google.android.exoplayer2.source.q
    public void reevaluateBuffer(long j11) {
        if (this.f34078k.h() || C()) {
            return;
        }
        if (this.f34078k.i()) {
            com.google.android.exoplayer2.util.a.e(this.f34089v);
            if (this.f34072d.v(j11, this.f34089v, this.f34083p)) {
                this.f34078k.e();
                return;
            }
            return;
        }
        int size = this.f34083p.size();
        while (size > 0 && this.f34072d.c(this.f34083p.get(size - 1)) == 2) {
            size--;
        }
        if (size < this.f34083p.size()) {
            t(size);
        }
        int iH = this.f34072d.h(j11, this.f34083p);
        if (iH < this.f34082o.size()) {
            t(iH);
        }
    }

    @Override // tg.n
    public e0 track(int i11, int i12) {
        e0 e0VarQ;
        if (!Z.contains(Integer.valueOf(i12))) {
            int i13 = 0;
            while (true) {
                e0[] e0VarArr = this.f34090w;
                if (i13 >= e0VarArr.length) {
                    e0VarQ = null;
                    break;
                }
                if (this.f34091x[i13] == i11) {
                    e0VarQ = e0VarArr[i13];
                    break;
                }
                i13++;
            }
        } else {
            e0VarQ = y(i11, i12);
        }
        if (e0VarQ == null) {
            if (this.V) {
                return p(i11, i12);
            }
            e0VarQ = q(i11, i12);
        }
        if (i12 != 5) {
            return e0VarQ;
        }
        if (this.A == null) {
            this.A = new c(e0VarQ, this.f34080m);
        }
        return this.A;
    }

    public final i u(int i11) {
        i iVar = this.f34082o.get(i11);
        ArrayList<i> arrayList = this.f34082o;
        o0.N0(arrayList, i11, arrayList.size());
        for (int i12 = 0; i12 < this.f34090w.length; i12++) {
            this.f34090w[i12].u(iVar.k(i12));
        }
        return iVar;
    }

    public final boolean v(i iVar) {
        int i11 = iVar.f34023k;
        int length = this.f34090w.length;
        for (int i12 = 0; i12 < length; i12++) {
            if (this.O[i12] && this.f34090w[i12].Q() == i11) {
                return false;
            }
        }
        return true;
    }

    public final i x() {
        ArrayList<i> arrayList = this.f34082o;
        return arrayList.get(arrayList.size() - 1);
    }

    @Nullable
    public final e0 y(int i11, int i12) {
        com.google.android.exoplayer2.util.a.a(Z.contains(Integer.valueOf(i12)));
        int i13 = this.f34093z.get(i12, -1);
        if (i13 == -1) {
            return null;
        }
        if (this.f34092y.add(Integer.valueOf(i12))) {
            this.f34091x[i13] = i11;
        }
        return this.f34091x[i13] == i11 ? this.f34090w[i13] : p(i11, i12);
    }
}
