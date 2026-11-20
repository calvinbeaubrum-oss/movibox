package bh;

import android.net.Uri;
import android.util.Pair;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.applovin.exoplayer2.common.base.Ascii;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.k0;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.s;
import com.google.android.exoplayer2.util.x;
import com.google.android.gms.common.api.Api;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import tg.a0;
import tg.b0;
import tg.e0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class g implements tg.l {
    public static final tg.r I = new tg.r() { // from class: bh.f
        @Override // tg.r
        public /* synthetic */ tg.l[] b(Uri uri, Map map) {
            return tg.q.a(this, uri, map);
        }

        @Override // tg.r
        public final tg.l[] createExtractors() {
            return g.k();
        }
    };
    public static final byte[] J = {-94, 57, 79, 82, 90, -101, 79, Ascii.DC4, -94, 68, 108, 66, 124, 100, -115, -12};
    public static final m1 K = new m1.b().e0(MimeTypes.APPLICATION_EMSG).E();
    public int A;
    public int B;
    public int C;
    public boolean D;
    public tg.n E;
    public e0[] F;
    public e0[] G;
    public boolean H;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f14145a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final o f14146b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<m1> f14147c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SparseArray<b> f14148d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c0 f14149e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c0 f14150f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c0 f14151g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final byte[] f14152h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final c0 f14153i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    public final k0 f14154j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ih.b f14155k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final c0 f14156l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ArrayDeque<bh.a.C0144a> f14157m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ArrayDeque<a> f14158n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @Nullable
    public final e0 f14159o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f14160p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f14161q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f14162r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f14163s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @Nullable
    public c0 f14164t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f14165u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f14166v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public long f14167w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public long f14168x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public long f14169y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @Nullable
    public b f14170z;

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f14171a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f14172b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f14173c;

        public a(long j11, boolean z11, int i11) {
            this.f14171a = j11;
            this.f14172b = z11;
            this.f14173c = i11;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e0 f14174a;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public r f14177d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public c f14178e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f14179f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f14180g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f14181h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f14182i;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f14185l;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final q f14175b = new q();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final c0 f14176c = new c0();

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final c0 f14183j = new c0(1);

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final c0 f14184k = new c0();

        public b(e0 e0Var, r rVar, c cVar) {
            this.f14174a = e0Var;
            this.f14177d = rVar;
            this.f14178e = cVar;
            j(rVar, cVar);
        }

        public int c() {
            int i11;
            if (this.f14185l) {
                i11 = this.f14175b.f14255k[this.f14179f] ? 1 : 0;
            } else {
                i11 = this.f14177d.f14269g[this.f14179f];
            }
            return g() != null ? i11 | 1073741824 : i11;
        }

        public long d() {
            return !this.f14185l ? this.f14177d.f14265c[this.f14179f] : this.f14175b.f14251g[this.f14181h];
        }

        public long e() {
            return !this.f14185l ? this.f14177d.f14268f[this.f14179f] : this.f14175b.c(this.f14179f);
        }

        public int f() {
            return !this.f14185l ? this.f14177d.f14266d[this.f14179f] : this.f14175b.f14253i[this.f14179f];
        }

        @Nullable
        public p g() {
            if (!this.f14185l) {
                return null;
            }
            int i11 = ((c) o0.j(this.f14175b.f14245a)).f14134a;
            p pVarA = this.f14175b.f14258n;
            if (pVarA == null) {
                pVarA = this.f14177d.f14263a.a(i11);
            }
            if (pVarA == null || !pVarA.f14240a) {
                return null;
            }
            return pVarA;
        }

        public boolean h() {
            this.f14179f++;
            if (!this.f14185l) {
                return false;
            }
            int i11 = this.f14180g + 1;
            this.f14180g = i11;
            int[] iArr = this.f14175b.f14252h;
            int i12 = this.f14181h;
            if (i11 != iArr[i12]) {
                return true;
            }
            this.f14181h = i12 + 1;
            this.f14180g = 0;
            return false;
        }

        public int i(int i11, int i12) {
            c0 c0Var;
            p pVarG = g();
            if (pVarG == null) {
                return 0;
            }
            int length = pVarG.f14243d;
            if (length != 0) {
                c0Var = this.f14175b.f14259o;
            } else {
                byte[] bArr = (byte[]) o0.j(pVarG.f14244e);
                this.f14184k.N(bArr, bArr.length);
                c0 c0Var2 = this.f14184k;
                length = bArr.length;
                c0Var = c0Var2;
            }
            boolean zG = this.f14175b.g(this.f14179f);
            boolean z11 = zG || i12 != 0;
            this.f14183j.d()[0] = (byte) ((z11 ? 128 : 0) | length);
            this.f14183j.P(0);
            this.f14174a.f(this.f14183j, 1, 1);
            this.f14174a.f(c0Var, length, 1);
            if (!z11) {
                return length + 1;
            }
            if (!zG) {
                this.f14176c.L(8);
                byte[] bArrD = this.f14176c.d();
                bArrD[0] = 0;
                bArrD[1] = 1;
                bArrD[2] = (byte) ((i12 >> 8) & 255);
                bArrD[3] = (byte) (i12 & 255);
                bArrD[4] = (byte) ((i11 >> 24) & 255);
                bArrD[5] = (byte) ((i11 >> 16) & 255);
                bArrD[6] = (byte) ((i11 >> 8) & 255);
                bArrD[7] = (byte) (i11 & 255);
                this.f14174a.f(this.f14176c, 8, 1);
                return length + 9;
            }
            c0 c0Var3 = this.f14175b.f14259o;
            int iJ = c0Var3.J();
            c0Var3.Q(-2);
            int i13 = (iJ * 6) + 2;
            if (i12 != 0) {
                this.f14176c.L(i13);
                byte[] bArrD2 = this.f14176c.d();
                c0Var3.j(bArrD2, 0, i13);
                int i14 = (((bArrD2[2] & 255) << 8) | (bArrD2[3] & 255)) + i12;
                bArrD2[2] = (byte) ((i14 >> 8) & 255);
                bArrD2[3] = (byte) (i14 & 255);
                c0Var3 = this.f14176c;
            }
            this.f14174a.f(c0Var3, i13, 1);
            return length + 1 + i13;
        }

        public void j(r rVar, c cVar) {
            this.f14177d = rVar;
            this.f14178e = cVar;
            this.f14174a.e(rVar.f14263a.f14234f);
            k();
        }

        public void k() {
            this.f14175b.f();
            this.f14179f = 0;
            this.f14181h = 0;
            this.f14180g = 0;
            this.f14182i = 0;
            this.f14185l = false;
        }

        public void l(long j11) {
            int i11 = this.f14179f;
            while (true) {
                q qVar = this.f14175b;
                if (i11 >= qVar.f14250f || qVar.c(i11) >= j11) {
                    return;
                }
                if (this.f14175b.f14255k[i11]) {
                    this.f14182i = i11;
                }
                i11++;
            }
        }

        public void m() {
            p pVarG = g();
            if (pVarG == null) {
                return;
            }
            c0 c0Var = this.f14175b.f14259o;
            int i11 = pVarG.f14243d;
            if (i11 != 0) {
                c0Var.Q(i11);
            }
            if (this.f14175b.g(this.f14179f)) {
                c0Var.Q(c0Var.J() * 6);
            }
        }

        public void n(DrmInitData drmInitData) {
            p pVarA = this.f14177d.f14263a.a(((c) o0.j(this.f14175b.f14245a)).f14134a);
            this.f14174a.e(this.f14177d.f14263a.f14234f.b().M(drmInitData.copyWithSchemeType(pVarA != null ? pVarA.f14241b : null)).E());
        }
    }

    public g() {
        this(0);
    }

    public g(int i11) {
        this(i11, null);
    }

    public g(int i11, @Nullable k0 k0Var) {
        this(i11, k0Var, null, Collections.emptyList());
    }

    public g(int i11, @Nullable k0 k0Var, @Nullable o oVar) {
        this(i11, k0Var, oVar, Collections.emptyList());
    }

    public g(int i11, @Nullable k0 k0Var, @Nullable o oVar, List<m1> list) {
        this(i11, k0Var, oVar, list, null);
    }

    public g(int i11, @Nullable k0 k0Var, @Nullable o oVar, List<m1> list, @Nullable e0 e0Var) {
        this.f14145a = i11;
        this.f14154j = k0Var;
        this.f14146b = oVar;
        this.f14147c = Collections.unmodifiableList(list);
        this.f14159o = e0Var;
        this.f14155k = new ih.b();
        this.f14156l = new c0(16);
        this.f14149e = new c0(x.f35652a);
        this.f14150f = new c0(5);
        this.f14151g = new c0();
        byte[] bArr = new byte[16];
        this.f14152h = bArr;
        this.f14153i = new c0(bArr);
        this.f14157m = new ArrayDeque<>();
        this.f14158n = new ArrayDeque<>();
        this.f14148d = new SparseArray<>();
        this.f14168x = C.TIME_UNSET;
        this.f14167w = C.TIME_UNSET;
        this.f14169y = C.TIME_UNSET;
        this.E = tg.n.f77074l8;
        this.F = new e0[0];
        this.G = new e0[0];
    }

    public static long A(c0 c0Var) {
        c0Var.P(8);
        return bh.a.c(c0Var.n()) == 1 ? c0Var.I() : c0Var.F();
    }

    @Nullable
    public static b B(c0 c0Var, SparseArray<b> sparseArray, boolean z11) {
        c0Var.P(8);
        int iB = bh.a.b(c0Var.n());
        b bVarValueAt = z11 ? sparseArray.valueAt(0) : sparseArray.get(c0Var.n());
        if (bVarValueAt == null) {
            return null;
        }
        if ((iB & 1) != 0) {
            long jI = c0Var.I();
            q qVar = bVarValueAt.f14175b;
            qVar.f14247c = jI;
            qVar.f14248d = jI;
        }
        c cVar = bVarValueAt.f14178e;
        bVarValueAt.f14175b.f14245a = new c((iB & 2) != 0 ? c0Var.n() - 1 : cVar.f14134a, (iB & 8) != 0 ? c0Var.n() : cVar.f14135b, (iB & 16) != 0 ? c0Var.n() : cVar.f14136c, (iB & 32) != 0 ? c0Var.n() : cVar.f14137d);
        return bVarValueAt;
    }

    public static void C(bh.a.C0144a c0144a, SparseArray<b> sparseArray, boolean z11, int i11, byte[] bArr) throws ParserException {
        b bVarB = B(((bh.a.b) com.google.android.exoplayer2.util.a.e(c0144a.g(1952868452))).f14104b, sparseArray, z11);
        if (bVarB == null) {
            return;
        }
        q qVar = bVarB.f14175b;
        long j11 = qVar.f14261q;
        boolean z12 = qVar.f14262r;
        bVarB.k();
        bVarB.f14185l = true;
        bh.a.b bVarG = c0144a.g(1952867444);
        if (bVarG == null || (i11 & 2) != 0) {
            qVar.f14261q = j11;
            qVar.f14262r = z12;
        } else {
            qVar.f14261q = A(bVarG.f14104b);
            qVar.f14262r = true;
        }
        F(c0144a, bVarB, i11);
        p pVarA = bVarB.f14177d.f14263a.a(((c) com.google.android.exoplayer2.util.a.e(qVar.f14245a)).f14134a);
        bh.a.b bVarG2 = c0144a.g(1935763834);
        if (bVarG2 != null) {
            v((p) com.google.android.exoplayer2.util.a.e(pVarA), bVarG2.f14104b, qVar);
        }
        bh.a.b bVarG3 = c0144a.g(1935763823);
        if (bVarG3 != null) {
            u(bVarG3.f14104b, qVar);
        }
        bh.a.b bVarG4 = c0144a.g(1936027235);
        if (bVarG4 != null) {
            y(bVarG4.f14104b, qVar);
        }
        w(c0144a, pVarA != null ? pVarA.f14241b : null, qVar);
        int size = c0144a.f14102c.size();
        for (int i12 = 0; i12 < size; i12++) {
            bh.a.b bVar = c0144a.f14102c.get(i12);
            if (bVar.f14100a == 1970628964) {
                G(bVar.f14104b, qVar, bArr);
            }
        }
    }

    public static Pair<Integer, c> D(c0 c0Var) {
        c0Var.P(12);
        return Pair.create(Integer.valueOf(c0Var.n()), new c(c0Var.n() - 1, c0Var.n(), c0Var.n(), c0Var.n()));
    }

    /* JADX WARN: Code duplicated, block: B:42:0x0098  */
    /* JADX WARN: Code duplicated, block: B:45:0x00b0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:46:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:47:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:50:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:51:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:54:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:55:0x00db  */
    /* JADX WARN: Code duplicated, block: B:58:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:60:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:61:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:64:0x0111  */
    /* JADX WARN: Code duplicated, block: B:70:0x0126  */
    public static int E(b bVar, int i11, int i12, c0 c0Var, int i13) throws ParserException {
        long j11;
        long j12;
        int[] iArr;
        long[] jArr;
        boolean[] zArr;
        boolean z11;
        int i14;
        long j13;
        long j14;
        int i15;
        int iN;
        int iN2;
        int iN3;
        int iN4;
        long jO0;
        boolean z12;
        b bVar2 = bVar;
        c0Var.P(8);
        int iB = bh.a.b(c0Var.n());
        o oVar = bVar2.f14177d.f14263a;
        q qVar = bVar2.f14175b;
        c cVar = (c) o0.j(qVar.f14245a);
        qVar.f14252h[i11] = c0Var.H();
        long[] jArr2 = qVar.f14251g;
        long j15 = qVar.f14247c;
        jArr2[i11] = j15;
        if ((iB & 1) != 0) {
            jArr2[i11] = j15 + ((long) c0Var.n());
        }
        boolean z13 = (iB & 4) != 0;
        int iN5 = cVar.f14137d;
        if (z13) {
            iN5 = c0Var.n();
        }
        boolean z14 = (iB & 256) != 0;
        boolean z15 = (iB & 512) != 0;
        boolean z16 = (iB & 1024) != 0;
        boolean z17 = (iB & 2048) != 0;
        long[] jArr3 = oVar.f14236h;
        if (jArr3 != null && jArr3.length == 1) {
            j11 = 0;
            if (jArr3[0] == 0) {
                j12 = ((long[]) o0.j(oVar.f14237i))[0];
            }
            iArr = qVar.f14253i;
            jArr = qVar.f14254j;
            zArr = qVar.f14255k;
            int i16 = iN5;
            if (oVar.f14230b == 2 || (i12 & 1) == 0) {
                z11 = false;
            } else {
                z11 = true;
            }
            i14 = i13 + qVar.f14252h[i11];
            boolean z18 = z11;
            j13 = oVar.f14231c;
            j14 = qVar.f14261q;
            i15 = i13;
            while (i15 < i14) {
                if (z14) {
                    iN = c0Var.n();
                } else {
                    iN = cVar.f14135b;
                }
                int iE = e(iN);
                if (z15) {
                    iN2 = c0Var.n();
                } else {
                    iN2 = cVar.f14136c;
                }
                int iE2 = e(iN2);
                if (z16) {
                    iN3 = c0Var.n();
                } else if (i15 == 0 || !z13) {
                    iN3 = cVar.f14137d;
                } else {
                    iN3 = i16;
                }
                if (z17) {
                    iN4 = c0Var.n();
                } else {
                    iN4 = 0;
                }
                jO0 = o0.O0((((long) iN4) + j14) - j12, 1000000L, j13);
                jArr[i15] = jO0;
                if (!qVar.f14262r) {
                    jArr[i15] = jO0 + bVar2.f14177d.f14270h;
                }
                iArr[i15] = iE2;
                if (((iN3 >> 16) & 1) == 0 || (z18 && i15 != 0)) {
                    z12 = false;
                } else {
                    z12 = true;
                }
                zArr[i15] = z12;
                j14 += (long) iE;
                i15++;
                bVar2 = bVar;
                z14 = z14;
                z13 = z13;
                z17 = z17;
                z15 = z15;
                z16 = z16;
            }
            qVar.f14261q = j14;
            return i14;
        }
        j11 = 0;
        j12 = j11;
        iArr = qVar.f14253i;
        jArr = qVar.f14254j;
        zArr = qVar.f14255k;
        int i17 = iN5;
        if (oVar.f14230b == 2) {
            z11 = false;
        } else {
            z11 = false;
        }
        i14 = i13 + qVar.f14252h[i11];
        boolean z19 = z11;
        j13 = oVar.f14231c;
        j14 = qVar.f14261q;
        i15 = i13;
        while (i15 < i14) {
            if (z14) {
                iN = c0Var.n();
            } else {
                iN = cVar.f14135b;
            }
            int iE3 = e(iN);
            if (z15) {
                iN2 = c0Var.n();
            } else {
                iN2 = cVar.f14136c;
            }
            int iE4 = e(iN2);
            if (z16) {
                iN3 = c0Var.n();
            } else if (i15 == 0) {
                iN3 = cVar.f14137d;
            } else {
                iN3 = cVar.f14137d;
            }
            if (z17) {
                iN4 = c0Var.n();
            } else {
                iN4 = 0;
            }
            jO0 = o0.O0((((long) iN4) + j14) - j12, 1000000L, j13);
            jArr[i15] = jO0;
            if (!qVar.f14262r) {
                jArr[i15] = jO0 + bVar2.f14177d.f14270h;
            }
            iArr[i15] = iE4;
            if (((iN3 >> 16) & 1) == 0) {
                z12 = false;
            } else {
                z12 = false;
            }
            zArr[i15] = z12;
            j14 += (long) iE3;
            i15++;
            bVar2 = bVar;
            z14 = z14;
            z13 = z13;
            z17 = z17;
            z15 = z15;
            z16 = z16;
        }
        qVar.f14261q = j14;
        return i14;
    }

    public static void F(bh.a.C0144a c0144a, b bVar, int i11) throws ParserException {
        List<bh.a.b> list = c0144a.f14102c;
        int size = list.size();
        int i12 = 0;
        int i13 = 0;
        for (int i14 = 0; i14 < size; i14++) {
            bh.a.b bVar2 = list.get(i14);
            if (bVar2.f14100a == 1953658222) {
                c0 c0Var = bVar2.f14104b;
                c0Var.P(12);
                int iH = c0Var.H();
                if (iH > 0) {
                    i13 += iH;
                    i12++;
                }
            }
        }
        bVar.f14181h = 0;
        bVar.f14180g = 0;
        bVar.f14179f = 0;
        bVar.f14175b.e(i12, i13);
        int i15 = 0;
        int iE = 0;
        for (int i16 = 0; i16 < size; i16++) {
            bh.a.b bVar3 = list.get(i16);
            if (bVar3.f14100a == 1953658222) {
                iE = E(bVar, i15, i11, bVar3.f14104b, iE);
                i15++;
            }
        }
    }

    public static void G(c0 c0Var, q qVar, byte[] bArr) throws ParserException {
        c0Var.P(8);
        c0Var.j(bArr, 0, 16);
        if (Arrays.equals(bArr, J)) {
            x(c0Var, 16, qVar);
        }
    }

    private void H(long j11) throws ParserException {
        while (!this.f14157m.isEmpty() && this.f14157m.peek().f14101b == j11) {
            m(this.f14157m.pop());
        }
        f();
    }

    private boolean I(tg.m mVar) throws IOException {
        if (this.f14163s == 0) {
            if (!mVar.readFully(this.f14156l.d(), 0, 8, true)) {
                return false;
            }
            this.f14163s = 8;
            this.f14156l.P(0);
            this.f14162r = this.f14156l.F();
            this.f14161q = this.f14156l.n();
        }
        long j11 = this.f14162r;
        if (j11 == 1) {
            mVar.readFully(this.f14156l.d(), 8, 8);
            this.f14163s += 8;
            this.f14162r = this.f14156l.I();
        } else if (j11 == 0) {
            long length = mVar.getLength();
            if (length == -1 && !this.f14157m.isEmpty()) {
                length = this.f14157m.peek().f14101b;
            }
            if (length != -1) {
                this.f14162r = (length - mVar.getPosition()) + ((long) this.f14163s);
            }
        }
        if (this.f14162r < this.f14163s) {
            throw ParserException.createForUnsupportedContainerFeature("Atom size less than header length (unsupported).");
        }
        long position = mVar.getPosition() - ((long) this.f14163s);
        int i11 = this.f14161q;
        if ((i11 == 1836019558 || i11 == 1835295092) && !this.H) {
            this.E.g(new b0.b(this.f14168x, position));
            this.H = true;
        }
        if (this.f14161q == 1836019558) {
            int size = this.f14148d.size();
            for (int i12 = 0; i12 < size; i12++) {
                q qVar = this.f14148d.valueAt(i12).f14175b;
                qVar.f14246b = position;
                qVar.f14248d = position;
                qVar.f14247c = position;
            }
        }
        int i13 = this.f14161q;
        if (i13 == 1835295092) {
            this.f14170z = null;
            this.f14165u = position + this.f14162r;
            this.f14160p = 2;
            return true;
        }
        if (M(i13)) {
            long position2 = (mVar.getPosition() + this.f14162r) - 8;
            this.f14157m.push(new bh.a.C0144a(this.f14161q, position2));
            if (this.f14162r == this.f14163s) {
                H(position2);
            } else {
                f();
            }
        } else if (N(this.f14161q)) {
            if (this.f14163s != 8) {
                throw ParserException.createForUnsupportedContainerFeature("Leaf atom defines extended atom size (unsupported).");
            }
            long j12 = this.f14162r;
            if (j12 > 2147483647L) {
                throw ParserException.createForUnsupportedContainerFeature("Leaf atom with length > 2147483647 (unsupported).");
            }
            c0 c0Var = new c0((int) j12);
            System.arraycopy(this.f14156l.d(), 0, c0Var.d(), 0, 8);
            this.f14164t = c0Var;
            this.f14160p = 1;
        } else {
            if (this.f14162r > 2147483647L) {
                throw ParserException.createForUnsupportedContainerFeature("Skipping atom with length > 2147483647 (unsupported).");
            }
            this.f14164t = null;
            this.f14160p = 1;
        }
        return true;
    }

    private static boolean M(int i11) {
        return i11 == 1836019574 || i11 == 1953653099 || i11 == 1835297121 || i11 == 1835626086 || i11 == 1937007212 || i11 == 1836019558 || i11 == 1953653094 || i11 == 1836475768 || i11 == 1701082227;
    }

    private static boolean N(int i11) {
        return i11 == 1751411826 || i11 == 1835296868 || i11 == 1836476516 || i11 == 1936286840 || i11 == 1937011556 || i11 == 1937011827 || i11 == 1668576371 || i11 == 1937011555 || i11 == 1937011578 || i11 == 1937013298 || i11 == 1937007471 || i11 == 1668232756 || i11 == 1937011571 || i11 == 1952867444 || i11 == 1952868452 || i11 == 1953196132 || i11 == 1953654136 || i11 == 1953658222 || i11 == 1886614376 || i11 == 1935763834 || i11 == 1935763823 || i11 == 1936027235 || i11 == 1970628964 || i11 == 1935828848 || i11 == 1936158820 || i11 == 1701606260 || i11 == 1835362404 || i11 == 1701671783;
    }

    public static int e(int i11) throws ParserException {
        if (i11 >= 0) {
            return i11;
        }
        throw ParserException.createForMalformedContainer("Unexpected negative value: " + i11, null);
    }

    private void f() {
        this.f14160p = 0;
        this.f14163s = 0;
    }

    @Nullable
    public static DrmInitData h(List<bh.a.b> list) {
        int size = list.size();
        ArrayList arrayList = null;
        for (int i11 = 0; i11 < size; i11++) {
            bh.a.b bVar = list.get(i11);
            if (bVar.f14100a == 1886614376) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                byte[] bArrD = bVar.f14104b.d();
                UUID uuidF = l.f(bArrD);
                if (uuidF == null) {
                    s.i("FragmentedMp4Extractor", "Skipped pssh atom (failed to extract uuid)");
                } else {
                    arrayList.add(new DrmInitData.SchemeData(uuidF, MimeTypes.VIDEO_MP4, bArrD));
                }
            }
        }
        if (arrayList == null) {
            return null;
        }
        return new DrmInitData(arrayList);
    }

    @Nullable
    public static b i(SparseArray<b> sparseArray) {
        int size = sparseArray.size();
        b bVar = null;
        long j11 = Long.MAX_VALUE;
        for (int i11 = 0; i11 < size; i11++) {
            b bVarValueAt = sparseArray.valueAt(i11);
            if ((bVarValueAt.f14185l || bVarValueAt.f14179f != bVarValueAt.f14177d.f14264b) && (!bVarValueAt.f14185l || bVarValueAt.f14181h != bVarValueAt.f14175b.f14249e)) {
                long jD = bVarValueAt.d();
                if (jD < j11) {
                    bVar = bVarValueAt;
                    j11 = jD;
                }
            }
        }
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ tg.l[] k() {
        return new tg.l[]{new g()};
    }

    public static long s(c0 c0Var) {
        c0Var.P(8);
        return bh.a.c(c0Var.n()) == 0 ? c0Var.F() : c0Var.I();
    }

    public static void t(bh.a.C0144a c0144a, SparseArray<b> sparseArray, boolean z11, int i11, byte[] bArr) throws ParserException {
        int size = c0144a.f14103d.size();
        for (int i12 = 0; i12 < size; i12++) {
            bh.a.C0144a c0144a2 = c0144a.f14103d.get(i12);
            if (c0144a2.f14100a == 1953653094) {
                C(c0144a2, sparseArray, z11, i11, bArr);
            }
        }
    }

    public static void u(c0 c0Var, q qVar) throws ParserException {
        c0Var.P(8);
        int iN = c0Var.n();
        if ((bh.a.b(iN) & 1) == 1) {
            c0Var.Q(8);
        }
        int iH = c0Var.H();
        if (iH == 1) {
            qVar.f14248d += bh.a.c(iN) == 0 ? c0Var.F() : c0Var.I();
        } else {
            throw ParserException.createForMalformedContainer("Unexpected saio entry count: " + iH, null);
        }
    }

    public static void v(p pVar, c0 c0Var, q qVar) throws ParserException {
        int i11;
        int i12 = pVar.f14243d;
        c0Var.P(8);
        if ((bh.a.b(c0Var.n()) & 1) == 1) {
            c0Var.Q(8);
        }
        int iD = c0Var.D();
        int iH = c0Var.H();
        if (iH > qVar.f14250f) {
            throw ParserException.createForMalformedContainer("Saiz sample count " + iH + " is greater than fragment sample count" + qVar.f14250f, null);
        }
        if (iD == 0) {
            boolean[] zArr = qVar.f14257m;
            i11 = 0;
            for (int i13 = 0; i13 < iH; i13++) {
                int iD2 = c0Var.D();
                i11 += iD2;
                zArr[i13] = iD2 > i12;
            }
        } else {
            i11 = iD * iH;
            Arrays.fill(qVar.f14257m, 0, iH, iD > i12);
        }
        Arrays.fill(qVar.f14257m, iH, qVar.f14250f, false);
        if (i11 > 0) {
            qVar.d(i11);
        }
    }

    public static void w(bh.a.C0144a c0144a, @Nullable String str, q qVar) throws ParserException {
        byte[] bArr = null;
        c0 c0Var = null;
        c0 c0Var2 = null;
        for (int i11 = 0; i11 < c0144a.f14102c.size(); i11++) {
            bh.a.b bVar = c0144a.f14102c.get(i11);
            c0 c0Var3 = bVar.f14104b;
            int i12 = bVar.f14100a;
            if (i12 == 1935828848) {
                c0Var3.P(12);
                if (c0Var3.n() == 1936025959) {
                    c0Var = c0Var3;
                }
            } else if (i12 == 1936158820) {
                c0Var3.P(12);
                if (c0Var3.n() == 1936025959) {
                    c0Var2 = c0Var3;
                }
            }
        }
        if (c0Var == null || c0Var2 == null) {
            return;
        }
        c0Var.P(8);
        int iC = bh.a.c(c0Var.n());
        c0Var.Q(4);
        if (iC == 1) {
            c0Var.Q(4);
        }
        if (c0Var.n() != 1) {
            throw ParserException.createForUnsupportedContainerFeature("Entry count in sbgp != 1 (unsupported).");
        }
        c0Var2.P(8);
        int iC2 = bh.a.c(c0Var2.n());
        c0Var2.Q(4);
        if (iC2 == 1) {
            if (c0Var2.F() == 0) {
                throw ParserException.createForUnsupportedContainerFeature("Variable length description in sgpd found (unsupported)");
            }
        } else if (iC2 >= 2) {
            c0Var2.Q(4);
        }
        if (c0Var2.F() != 1) {
            throw ParserException.createForUnsupportedContainerFeature("Entry count in sgpd != 1 (unsupported).");
        }
        c0Var2.Q(1);
        int iD = c0Var2.D();
        int i13 = (iD & 240) >> 4;
        int i14 = iD & 15;
        boolean z11 = c0Var2.D() == 1;
        if (z11) {
            int iD2 = c0Var2.D();
            byte[] bArr2 = new byte[16];
            c0Var2.j(bArr2, 0, 16);
            if (iD2 == 0) {
                int iD3 = c0Var2.D();
                bArr = new byte[iD3];
                c0Var2.j(bArr, 0, iD3);
            }
            qVar.f14256l = true;
            qVar.f14258n = new p(z11, str, iD2, bArr2, i13, i14, bArr);
        }
    }

    public static void x(c0 c0Var, int i11, q qVar) throws ParserException {
        c0Var.P(i11 + 8);
        int iB = bh.a.b(c0Var.n());
        if ((iB & 1) != 0) {
            throw ParserException.createForUnsupportedContainerFeature("Overriding TrackEncryptionBox parameters is unsupported.");
        }
        boolean z11 = (iB & 2) != 0;
        int iH = c0Var.H();
        if (iH == 0) {
            Arrays.fill(qVar.f14257m, 0, qVar.f14250f, false);
            return;
        }
        if (iH == qVar.f14250f) {
            Arrays.fill(qVar.f14257m, 0, iH, z11);
            qVar.d(c0Var.a());
            qVar.a(c0Var);
        } else {
            throw ParserException.createForMalformedContainer("Senc sample count " + iH + " is different from fragment sample count" + qVar.f14250f, null);
        }
    }

    public static void y(c0 c0Var, q qVar) throws ParserException {
        x(c0Var, 0, qVar);
    }

    public static Pair<Long, tg.d> z(c0 c0Var, long j11) throws ParserException {
        long jI;
        long jI2;
        c0Var.P(8);
        int iC = bh.a.c(c0Var.n());
        c0Var.Q(4);
        long jF = c0Var.F();
        if (iC == 0) {
            jI = c0Var.F();
            jI2 = c0Var.F();
        } else {
            jI = c0Var.I();
            jI2 = c0Var.I();
        }
        long j12 = jI;
        long j13 = j11 + jI2;
        long jO0 = o0.O0(j12, 1000000L, jF);
        c0Var.Q(2);
        int iJ = c0Var.J();
        int[] iArr = new int[iJ];
        long[] jArr = new long[iJ];
        long[] jArr2 = new long[iJ];
        long[] jArr3 = new long[iJ];
        long j14 = j12;
        long j15 = jO0;
        int i11 = 0;
        while (i11 < iJ) {
            int iN = c0Var.n();
            if ((iN & Integer.MIN_VALUE) != 0) {
                throw ParserException.createForMalformedContainer("Unhandled indirect reference", null);
            }
            long jF2 = c0Var.F();
            iArr[i11] = iN & Api.BaseClientBuilder.API_PRIORITY_OTHER;
            jArr[i11] = j13;
            jArr3[i11] = j15;
            long j16 = j14 + jF2;
            long[] jArr4 = jArr2;
            long[] jArr5 = jArr3;
            int i12 = iJ;
            int[] iArr2 = iArr;
            long jO1 = o0.O0(j16, 1000000L, jF);
            jArr4[i11] = jO1 - jArr5[i11];
            c0Var.Q(4);
            j13 += (long) iArr2[i11];
            i11++;
            iArr = iArr2;
            jArr3 = jArr5;
            jArr2 = jArr4;
            jArr = jArr;
            iJ = i12;
            j14 = j16;
            j15 = jO1;
        }
        return Pair.create(Long.valueOf(jO0), new tg.d(iArr, jArr, jArr2, jArr3));
    }

    public final void J(tg.m mVar) throws IOException {
        int i11 = ((int) this.f14162r) - this.f14163s;
        c0 c0Var = this.f14164t;
        if (c0Var != null) {
            mVar.readFully(c0Var.d(), 8, i11);
            o(new bh.a.b(this.f14161q, c0Var), mVar.getPosition());
        } else {
            mVar.skipFully(i11);
        }
        H(mVar.getPosition());
    }

    public final void K(tg.m mVar) throws IOException {
        int size = this.f14148d.size();
        long j11 = Long.MAX_VALUE;
        b bVarValueAt = null;
        for (int i11 = 0; i11 < size; i11++) {
            q qVar = this.f14148d.valueAt(i11).f14175b;
            if (qVar.f14260p) {
                long j12 = qVar.f14248d;
                if (j12 < j11) {
                    bVarValueAt = this.f14148d.valueAt(i11);
                    j11 = j12;
                }
            }
        }
        if (bVarValueAt == null) {
            this.f14160p = 3;
            return;
        }
        int position = (int) (j11 - mVar.getPosition());
        if (position < 0) {
            throw ParserException.createForMalformedContainer("Offset to encryption data was negative.", null);
        }
        mVar.skipFully(position);
        bVarValueAt.f14175b.b(mVar);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final boolean L(tg.m mVar) throws IOException {
        int iB;
        b bVarI = this.f14170z;
        Throwable th2 = null;
        if (bVarI == null) {
            bVarI = i(this.f14148d);
            if (bVarI == null) {
                int position = (int) (this.f14165u - mVar.getPosition());
                if (position < 0) {
                    throw ParserException.createForMalformedContainer("Offset to end of mdat was negative.", null);
                }
                mVar.skipFully(position);
                f();
                return false;
            }
            int iD = (int) (bVarI.d() - mVar.getPosition());
            if (iD < 0) {
                s.i("FragmentedMp4Extractor", "Ignoring negative offset to sample data.");
                iD = 0;
            }
            mVar.skipFully(iD);
            this.f14170z = bVarI;
        }
        int i11 = 4;
        int i12 = 1;
        if (this.f14160p == 3) {
            int iF = bVarI.f();
            this.A = iF;
            if (bVarI.f14179f < bVarI.f14182i) {
                mVar.skipFully(iF);
                bVarI.m();
                if (!bVarI.h()) {
                    this.f14170z = null;
                }
                this.f14160p = 3;
                return true;
            }
            if (bVarI.f14177d.f14263a.f14235g == 1) {
                this.A = iF - 8;
                mVar.skipFully(8);
            }
            if ("audio/ac4".equals(bVarI.f14177d.f14263a.f14234f.f33445m)) {
                this.B = bVarI.i(this.A, 7);
                com.google.android.exoplayer2.audio.c.a(this.A, this.f14153i);
                bVarI.f14174a.c(this.f14153i, 7);
                this.B += 7;
            } else {
                this.B = bVarI.i(this.A, 0);
            }
            this.A += this.B;
            this.f14160p = 4;
            this.C = 0;
        }
        o oVar = bVarI.f14177d.f14263a;
        e0 e0Var = bVarI.f14174a;
        long jE = bVarI.e();
        k0 k0Var = this.f14154j;
        if (k0Var != null) {
            jE = k0Var.a(jE);
        }
        long j11 = jE;
        if (oVar.f14238j == 0) {
            while (true) {
                int i13 = this.B;
                int i14 = this.A;
                if (i13 >= i14) {
                    break;
                }
                this.B += e0Var.b(mVar, i14 - i13, false);
            }
        } else {
            byte[] bArrD = this.f14150f.d();
            bArrD[0] = 0;
            bArrD[1] = 0;
            bArrD[2] = 0;
            int i15 = oVar.f14238j;
            int i16 = i15 + 1;
            int i17 = 4 - i15;
            while (this.B < this.A) {
                int i18 = this.C;
                if (i18 == 0) {
                    mVar.readFully(bArrD, i17, i16);
                    this.f14150f.P(0);
                    int iN = this.f14150f.n();
                    if (iN < i12) {
                        throw ParserException.createForMalformedContainer("Invalid NAL length", th2);
                    }
                    this.C = iN - 1;
                    this.f14149e.P(0);
                    e0Var.c(this.f14149e, i11);
                    e0Var.c(this.f14150f, i12);
                    this.D = this.G.length > 0 && x.g(oVar.f14234f.f33445m, bArrD[i11]);
                    this.B += 5;
                    this.A += i17;
                } else {
                    if (this.D) {
                        this.f14151g.L(i18);
                        mVar.readFully(this.f14151g.d(), 0, this.C);
                        e0Var.c(this.f14151g, this.C);
                        iB = this.C;
                        int iQ = x.q(this.f14151g.d(), this.f14151g.f());
                        this.f14151g.P(MimeTypes.VIDEO_H265.equals(oVar.f14234f.f33445m) ? 1 : 0);
                        this.f14151g.O(iQ);
                        tg.c.a(j11, this.f14151g, this.G);
                    } else {
                        iB = e0Var.b(mVar, i18, false);
                    }
                    this.B += iB;
                    this.C -= iB;
                    th2 = null;
                    i11 = 4;
                    i12 = 1;
                }
            }
        }
        int iC = bVarI.c();
        p pVarG = bVarI.g();
        e0Var.d(j11, iC, this.A, 0, pVarG != null ? pVarG.f14242c : null);
        r(j11);
        if (!bVarI.h()) {
            this.f14170z = null;
        }
        this.f14160p = 3;
        return true;
    }

    @Override // tg.l
    public boolean b(tg.m mVar) throws IOException {
        return n.b(mVar);
    }

    @Override // tg.l
    public int c(tg.m mVar, a0 a0Var) throws IOException {
        while (true) {
            int i11 = this.f14160p;
            if (i11 != 0) {
                if (i11 == 1) {
                    J(mVar);
                } else if (i11 == 2) {
                    K(mVar);
                } else if (L(mVar)) {
                    return 0;
                }
            } else if (!I(mVar)) {
                return -1;
            }
        }
    }

    @Override // tg.l
    public void d(tg.n nVar) {
        this.E = nVar;
        f();
        j();
        o oVar = this.f14146b;
        if (oVar != null) {
            this.f14148d.put(0, new b(nVar.track(0, oVar.f14230b), new r(this.f14146b, new long[0], new int[0], 0, new long[0], new int[0], 0L), new c(0, 0, 0, 0)));
            this.E.endTracks();
        }
    }

    public final c g(SparseArray<c> sparseArray, int i11) {
        return sparseArray.size() == 1 ? sparseArray.valueAt(0) : (c) com.google.android.exoplayer2.util.a.e(sparseArray.get(i11));
    }

    public final void j() {
        int i11;
        e0[] e0VarArr = new e0[2];
        this.F = e0VarArr;
        e0 e0Var = this.f14159o;
        int i12 = 0;
        if (e0Var != null) {
            e0VarArr[0] = e0Var;
            i11 = 1;
        } else {
            i11 = 0;
        }
        int i13 = 100;
        if ((this.f14145a & 4) != 0) {
            e0VarArr[i11] = this.E.track(100, 5);
            i13 = 101;
            i11++;
        }
        e0[] e0VarArr2 = (e0[]) o0.H0(this.F, i11);
        this.F = e0VarArr2;
        for (e0 e0Var2 : e0VarArr2) {
            e0Var2.e(K);
        }
        this.G = new e0[this.f14147c.size()];
        while (i12 < this.G.length) {
            e0 e0VarTrack = this.E.track(i13, 3);
            e0VarTrack.e(this.f14147c.get(i12));
            this.G[i12] = e0VarTrack;
            i12++;
            i13++;
        }
    }

    @Nullable
    public o l(@Nullable o oVar) {
        return oVar;
    }

    public final void m(bh.a.C0144a c0144a) throws ParserException {
        int i11 = c0144a.f14100a;
        if (i11 == 1836019574) {
            q(c0144a);
        } else if (i11 == 1836019558) {
            p(c0144a);
        } else {
            if (this.f14157m.isEmpty()) {
                return;
            }
            this.f14157m.peek().d(c0144a);
        }
    }

    public final void n(c0 c0Var) {
        long jO0;
        String str;
        long jO1;
        String str2;
        long jF;
        long jA;
        if (this.F.length == 0) {
            return;
        }
        c0Var.P(8);
        int iC = bh.a.c(c0Var.n());
        if (iC == 0) {
            String str3 = (String) com.google.android.exoplayer2.util.a.e(c0Var.x());
            String str4 = (String) com.google.android.exoplayer2.util.a.e(c0Var.x());
            long jF2 = c0Var.F();
            jO0 = o0.O0(c0Var.F(), 1000000L, jF2);
            long j11 = this.f14169y;
            long j12 = j11 != C.TIME_UNSET ? j11 + jO0 : -9223372036854775807L;
            str = str3;
            jO1 = o0.O0(c0Var.F(), 1000L, jF2);
            str2 = str4;
            jF = c0Var.F();
            jA = j12;
        } else {
            if (iC != 1) {
                s.i("FragmentedMp4Extractor", "Skipping unsupported emsg version: " + iC);
                return;
            }
            long jF3 = c0Var.F();
            jA = o0.O0(c0Var.I(), 1000000L, jF3);
            long jO2 = o0.O0(c0Var.F(), 1000L, jF3);
            long jF4 = c0Var.F();
            str = (String) com.google.android.exoplayer2.util.a.e(c0Var.x());
            jO1 = jO2;
            jF = jF4;
            str2 = (String) com.google.android.exoplayer2.util.a.e(c0Var.x());
            jO0 = -9223372036854775807L;
        }
        byte[] bArr = new byte[c0Var.a()];
        c0Var.j(bArr, 0, c0Var.a());
        c0 c0Var2 = new c0(this.f14155k.a(new EventMessage(str, str2, jO1, jF, bArr)));
        int iA = c0Var2.a();
        for (e0 e0Var : this.F) {
            c0Var2.P(0);
            e0Var.c(c0Var2, iA);
        }
        if (jA == C.TIME_UNSET) {
            this.f14158n.addLast(new a(jO0, true, iA));
            this.f14166v += iA;
            return;
        }
        if (!this.f14158n.isEmpty()) {
            this.f14158n.addLast(new a(jA, false, iA));
            this.f14166v += iA;
            return;
        }
        k0 k0Var = this.f14154j;
        if (k0Var != null) {
            jA = k0Var.a(jA);
        }
        for (e0 e0Var2 : this.F) {
            e0Var2.d(jA, 1, iA, 0, null);
        }
    }

    public final void o(bh.a.b bVar, long j11) throws ParserException {
        if (!this.f14157m.isEmpty()) {
            this.f14157m.peek().e(bVar);
            return;
        }
        int i11 = bVar.f14100a;
        if (i11 != 1936286840) {
            if (i11 == 1701671783) {
                n(bVar.f14104b);
            }
        } else {
            Pair<Long, tg.d> pairZ = z(bVar.f14104b, j11);
            this.f14169y = ((Long) pairZ.first).longValue();
            this.E.g((b0) pairZ.second);
            this.H = true;
        }
    }

    public final void p(bh.a.C0144a c0144a) throws ParserException {
        t(c0144a, this.f14148d, this.f14146b != null, this.f14145a, this.f14152h);
        DrmInitData drmInitDataH = h(c0144a.f14102c);
        if (drmInitDataH != null) {
            int size = this.f14148d.size();
            for (int i11 = 0; i11 < size; i11++) {
                this.f14148d.valueAt(i11).n(drmInitDataH);
            }
        }
        if (this.f14167w != C.TIME_UNSET) {
            int size2 = this.f14148d.size();
            for (int i12 = 0; i12 < size2; i12++) {
                this.f14148d.valueAt(i12).l(this.f14167w);
            }
            this.f14167w = C.TIME_UNSET;
        }
    }

    public final void q(bh.a.C0144a c0144a) throws ParserException {
        int i11 = 0;
        com.google.android.exoplayer2.util.a.h(this.f14146b == null, "Unexpected moov box.");
        DrmInitData drmInitDataH = h(c0144a.f14102c);
        bh.a.C0144a c0144a2 = (bh.a.C0144a) com.google.android.exoplayer2.util.a.e(c0144a.f(1836475768));
        SparseArray<c> sparseArray = new SparseArray<>();
        int size = c0144a2.f14102c.size();
        long jS = -9223372036854775807L;
        for (int i12 = 0; i12 < size; i12++) {
            bh.a.b bVar = c0144a2.f14102c.get(i12);
            int i13 = bVar.f14100a;
            if (i13 == 1953654136) {
                Pair<Integer, c> pairD = D(bVar.f14104b);
                sparseArray.put(((Integer) pairD.first).intValue(), (c) pairD.second);
            } else if (i13 == 1835362404) {
                jS = s(bVar.f14104b);
            }
        }
        List<r> listA = bh.b.A(c0144a, new tg.x(), jS, drmInitDataH, (this.f14145a & 16) != 0, false, new com.google.common.base.f() { // from class: bh.e
            @Override // com.google.common.base.f
            public final Object apply(Object obj) {
                return this.f14144a.l((o) obj);
            }
        });
        int size2 = listA.size();
        if (this.f14148d.size() != 0) {
            com.google.android.exoplayer2.util.a.g(this.f14148d.size() == size2);
            while (i11 < size2) {
                r rVar = listA.get(i11);
                o oVar = rVar.f14263a;
                this.f14148d.get(oVar.f14229a).j(rVar, g(sparseArray, oVar.f14229a));
                i11++;
            }
            return;
        }
        while (i11 < size2) {
            r rVar2 = listA.get(i11);
            o oVar2 = rVar2.f14263a;
            this.f14148d.put(oVar2.f14229a, new b(this.E.track(i11, oVar2.f14230b), rVar2, g(sparseArray, oVar2.f14229a)));
            this.f14168x = Math.max(this.f14168x, oVar2.f14233e);
            i11++;
        }
        this.E.endTracks();
    }

    public final void r(long j11) {
        while (!this.f14158n.isEmpty()) {
            a aVarRemoveFirst = this.f14158n.removeFirst();
            this.f14166v -= aVarRemoveFirst.f14173c;
            long jA = aVarRemoveFirst.f14171a;
            if (aVarRemoveFirst.f14172b) {
                jA += j11;
            }
            k0 k0Var = this.f14154j;
            if (k0Var != null) {
                jA = k0Var.a(jA);
            }
            for (e0 e0Var : this.F) {
                e0Var.d(jA, 1, aVarRemoveFirst.f14173c, this.f14166v, null);
            }
        }
    }

    @Override // tg.l
    public void release() {
    }

    @Override // tg.l
    public void seek(long j11, long j12) {
        int size = this.f14148d.size();
        for (int i11 = 0; i11 < size; i11++) {
            this.f14148d.valueAt(i11).k();
        }
        this.f14158n.clear();
        this.f14166v = 0;
        this.f14167w = j12;
        this.f14157m.clear();
        f();
    }
}
