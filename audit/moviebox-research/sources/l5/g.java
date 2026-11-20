package l5;

import android.net.Uri;
import android.util.Pair;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.ParserException;
import androidx.media3.extractor.metadata.emsg.EventMessage;
import com.applovin.exoplayer2.common.base.Ascii;
import com.google.android.gms.common.api.Api;
import com.google.common.collect.ImmutableList;
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
import u4.f0;
import u4.l0;
import u4.m0;
import u4.r0;
import u4.t;
import u4.u;
import u4.x;
import u4.y;
import z3.c0;
import z3.i0;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class g implements u4.s {

    @Deprecated
    public static final y J = new y() { // from class: l5.e
        @Override // u4.y
        public /* synthetic */ y a(o5.s.a aVar) {
            return x.c(this, aVar);
        }

        @Override // u4.y
        public /* synthetic */ u4.s[] b(Uri uri, Map map) {
            return x.a(this, uri, map);
        }

        @Override // u4.y
        public /* synthetic */ y c(boolean z11) {
            return x.b(this, z11);
        }

        @Override // u4.y
        public final u4.s[] createExtractors() {
            return g.m();
        }
    };
    public static final byte[] K = {-94, 57, 79, 82, 90, -101, 79, Ascii.DC4, -94, 68, 108, 66, 124, 100, -115, -12};
    public static final androidx.media3.common.y L = new androidx.media3.common.y.b().k0(MimeTypes.APPLICATION_EMSG).I();

    @Nullable
    public b A;
    public int B;
    public int C;
    public int D;
    public boolean E;
    public u F;
    public r0[] G;
    public r0[] H;
    public boolean I;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o5.s.a f69842a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f69843b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final p f69844c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<androidx.media3.common.y> f69845d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SparseArray<b> f69846e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c0 f69847f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c0 f69848g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c0 f69849h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final byte[] f69850i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final c0 f69851j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    public final i0 f69852k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final e5.b f69853l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final c0 f69854m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ArrayDeque<l5.a.C0749a> f69855n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ArrayDeque<a> f69856o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @Nullable
    public final r0 f69857p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f69858q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f69859r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f69860s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f69861t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @Nullable
    public c0 f69862u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public long f69863v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f69864w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public long f69865x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public long f69866y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public long f69867z;

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f69868a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f69869b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f69870c;

        public a(long j11, boolean z11, int i11) {
            this.f69868a = j11;
            this.f69869b = z11;
            this.f69870c = i11;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final r0 f69871a;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public s f69874d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public c f69875e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f69876f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f69877g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f69878h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f69879i;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f69882l;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final r f69872b = new r();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final c0 f69873c = new c0();

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final c0 f69880j = new c0(1);

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final c0 f69881k = new c0();

        public b(r0 r0Var, s sVar, c cVar) {
            this.f69871a = r0Var;
            this.f69874d = sVar;
            this.f69875e = cVar;
            j(sVar, cVar);
        }

        public int c() {
            int i11;
            if (this.f69882l) {
                i11 = this.f69872b.f69954k[this.f69876f] ? 1 : 0;
            } else {
                i11 = this.f69874d.f69968g[this.f69876f];
            }
            return g() != null ? i11 | 1073741824 : i11;
        }

        public long d() {
            return !this.f69882l ? this.f69874d.f69964c[this.f69876f] : this.f69872b.f69950g[this.f69878h];
        }

        public long e() {
            return !this.f69882l ? this.f69874d.f69967f[this.f69876f] : this.f69872b.c(this.f69876f);
        }

        public int f() {
            return !this.f69882l ? this.f69874d.f69965d[this.f69876f] : this.f69872b.f69952i[this.f69876f];
        }

        @Nullable
        public q g() {
            if (!this.f69882l) {
                return null;
            }
            int i11 = ((c) u0.i(this.f69872b.f69944a)).f69831a;
            q qVarA = this.f69872b.f69957n;
            if (qVarA == null) {
                qVarA = this.f69874d.f69962a.a(i11);
            }
            if (qVarA == null || !qVarA.f69939a) {
                return null;
            }
            return qVarA;
        }

        public boolean h() {
            this.f69876f++;
            if (!this.f69882l) {
                return false;
            }
            int i11 = this.f69877g + 1;
            this.f69877g = i11;
            int[] iArr = this.f69872b.f69951h;
            int i12 = this.f69878h;
            if (i11 != iArr[i12]) {
                return true;
            }
            this.f69878h = i12 + 1;
            this.f69877g = 0;
            return false;
        }

        public int i(int i11, int i12) {
            c0 c0Var;
            q qVarG = g();
            if (qVarG == null) {
                return 0;
            }
            int length = qVarG.f69942d;
            if (length != 0) {
                c0Var = this.f69872b.f69958o;
            } else {
                byte[] bArr = (byte[]) u0.i(qVarG.f69943e);
                this.f69881k.S(bArr, bArr.length);
                c0 c0Var2 = this.f69881k;
                length = bArr.length;
                c0Var = c0Var2;
            }
            boolean zG = this.f69872b.g(this.f69876f);
            boolean z11 = zG || i12 != 0;
            this.f69880j.e()[0] = (byte) ((z11 ? 128 : 0) | length);
            this.f69880j.U(0);
            this.f69871a.a(this.f69880j, 1, 1);
            this.f69871a.a(c0Var, length, 1);
            if (!z11) {
                return length + 1;
            }
            if (!zG) {
                this.f69873c.Q(8);
                byte[] bArrE = this.f69873c.e();
                bArrE[0] = 0;
                bArrE[1] = 1;
                bArrE[2] = (byte) ((i12 >> 8) & 255);
                bArrE[3] = (byte) (i12 & 255);
                bArrE[4] = (byte) ((i11 >> 24) & 255);
                bArrE[5] = (byte) ((i11 >> 16) & 255);
                bArrE[6] = (byte) ((i11 >> 8) & 255);
                bArrE[7] = (byte) (i11 & 255);
                this.f69871a.a(this.f69873c, 8, 1);
                return length + 9;
            }
            c0 c0Var3 = this.f69872b.f69958o;
            int iN = c0Var3.N();
            c0Var3.V(-2);
            int i13 = (iN * 6) + 2;
            if (i12 != 0) {
                this.f69873c.Q(i13);
                byte[] bArrE2 = this.f69873c.e();
                c0Var3.l(bArrE2, 0, i13);
                int i14 = (((bArrE2[2] & 255) << 8) | (bArrE2[3] & 255)) + i12;
                bArrE2[2] = (byte) ((i14 >> 8) & 255);
                bArrE2[3] = (byte) (i14 & 255);
                c0Var3 = this.f69873c;
            }
            this.f69871a.a(c0Var3, i13, 1);
            return length + 1 + i13;
        }

        public void j(s sVar, c cVar) {
            this.f69874d = sVar;
            this.f69875e = cVar;
            this.f69871a.b(sVar.f69962a.f69933f);
            k();
        }

        public void k() {
            this.f69872b.f();
            this.f69876f = 0;
            this.f69878h = 0;
            this.f69877g = 0;
            this.f69879i = 0;
            this.f69882l = false;
        }

        public void l(long j11) {
            int i11 = this.f69876f;
            while (true) {
                r rVar = this.f69872b;
                if (i11 >= rVar.f69949f || rVar.c(i11) > j11) {
                    return;
                }
                if (this.f69872b.f69954k[i11]) {
                    this.f69879i = i11;
                }
                i11++;
            }
        }

        public void m() {
            q qVarG = g();
            if (qVarG == null) {
                return;
            }
            c0 c0Var = this.f69872b.f69958o;
            int i11 = qVarG.f69942d;
            if (i11 != 0) {
                c0Var.V(i11);
            }
            if (this.f69872b.g(this.f69876f)) {
                c0Var.V(c0Var.N() * 6);
            }
        }

        public void n(DrmInitData drmInitData) {
            q qVarA = this.f69874d.f69962a.a(((c) u0.i(this.f69872b.f69944a)).f69831a);
            this.f69871a.b(this.f69874d.f69962a.f69933f.b().R(drmInitData.copyWithSchemeType(qVarA != null ? qVarA.f69940b : null)).I());
        }
    }

    public g(o5.s.a aVar, int i11) {
        this(aVar, i11, null, null, ImmutableList.of(), null);
    }

    public g(o5.s.a aVar, int i11, @Nullable i0 i0Var, @Nullable p pVar, List<androidx.media3.common.y> list, @Nullable r0 r0Var) {
        this.f69842a = aVar;
        this.f69843b = i11;
        this.f69852k = i0Var;
        this.f69844c = pVar;
        this.f69845d = Collections.unmodifiableList(list);
        this.f69857p = r0Var;
        this.f69853l = new e5.b();
        this.f69854m = new c0(16);
        this.f69847f = new c0(a4.a.f366a);
        this.f69848g = new c0(5);
        this.f69849h = new c0();
        byte[] bArr = new byte[16];
        this.f69850i = bArr;
        this.f69851j = new c0(bArr);
        this.f69855n = new ArrayDeque<>();
        this.f69856o = new ArrayDeque<>();
        this.f69846e = new SparseArray<>();
        this.f69866y = C.TIME_UNSET;
        this.f69865x = C.TIME_UNSET;
        this.f69867z = C.TIME_UNSET;
        this.F = u.f78395m8;
        this.G = new r0[0];
        this.H = new r0[0];
    }

    public static void A(c0 c0Var, r rVar) throws ParserException {
        z(c0Var, 0, rVar);
    }

    public static Pair<Long, u4.h> B(c0 c0Var, long j11) throws ParserException {
        long jM;
        long jM2;
        c0Var.U(8);
        int iC = l5.a.c(c0Var.q());
        c0Var.V(4);
        long J2 = c0Var.J();
        if (iC == 0) {
            jM = c0Var.J();
            jM2 = c0Var.J();
        } else {
            jM = c0Var.M();
            jM2 = c0Var.M();
        }
        long j12 = jM;
        long j13 = j11 + jM2;
        long jF1 = u0.f1(j12, 1000000L, J2);
        c0Var.V(2);
        int iN = c0Var.N();
        int[] iArr = new int[iN];
        long[] jArr = new long[iN];
        long[] jArr2 = new long[iN];
        long[] jArr3 = new long[iN];
        long j14 = j12;
        long j15 = jF1;
        int i11 = 0;
        while (i11 < iN) {
            int iQ = c0Var.q();
            if ((iQ & Integer.MIN_VALUE) != 0) {
                throw ParserException.createForMalformedContainer("Unhandled indirect reference", null);
            }
            long J3 = c0Var.J();
            iArr[i11] = iQ & Api.BaseClientBuilder.API_PRIORITY_OTHER;
            jArr[i11] = j13;
            jArr3[i11] = j15;
            long j16 = j14 + J3;
            long[] jArr4 = jArr2;
            long[] jArr5 = jArr3;
            int i12 = iN;
            int[] iArr2 = iArr;
            long jF2 = u0.f1(j16, 1000000L, J2);
            jArr4[i11] = jF2 - jArr5[i11];
            c0Var.V(4);
            j13 += (long) iArr2[i11];
            i11++;
            iArr = iArr2;
            jArr3 = jArr5;
            jArr2 = jArr4;
            jArr = jArr;
            iN = i12;
            j14 = j16;
            j15 = jF2;
        }
        return Pair.create(Long.valueOf(jF1), new u4.h(iArr, jArr, jArr2, jArr3));
    }

    public static long C(c0 c0Var) {
        c0Var.U(8);
        return l5.a.c(c0Var.q()) == 1 ? c0Var.M() : c0Var.J();
    }

    @Nullable
    public static b D(c0 c0Var, SparseArray<b> sparseArray, boolean z11) {
        c0Var.U(8);
        int iB = l5.a.b(c0Var.q());
        b bVarValueAt = z11 ? sparseArray.valueAt(0) : sparseArray.get(c0Var.q());
        if (bVarValueAt == null) {
            return null;
        }
        if ((iB & 1) != 0) {
            long jM = c0Var.M();
            r rVar = bVarValueAt.f69872b;
            rVar.f69946c = jM;
            rVar.f69947d = jM;
        }
        c cVar = bVarValueAt.f69875e;
        bVarValueAt.f69872b.f69944a = new c((iB & 2) != 0 ? c0Var.q() - 1 : cVar.f69831a, (iB & 8) != 0 ? c0Var.q() : cVar.f69832b, (iB & 16) != 0 ? c0Var.q() : cVar.f69833c, (iB & 32) != 0 ? c0Var.q() : cVar.f69834d);
        return bVarValueAt;
    }

    public static void E(l5.a.C0749a c0749a, SparseArray<b> sparseArray, boolean z11, int i11, byte[] bArr) throws ParserException {
        b bVarD = D(((l5.a.b) z3.a.e(c0749a.g(1952868452))).f69801b, sparseArray, z11);
        if (bVarD == null) {
            return;
        }
        r rVar = bVarD.f69872b;
        long j11 = rVar.f69960q;
        boolean z12 = rVar.f69961r;
        bVarD.k();
        bVarD.f69882l = true;
        l5.a.b bVarG = c0749a.g(1952867444);
        if (bVarG == null || (i11 & 2) != 0) {
            rVar.f69960q = j11;
            rVar.f69961r = z12;
        } else {
            rVar.f69960q = C(bVarG.f69801b);
            rVar.f69961r = true;
        }
        H(c0749a, bVarD, i11);
        q qVarA = bVarD.f69874d.f69962a.a(((c) z3.a.e(rVar.f69944a)).f69831a);
        l5.a.b bVarG2 = c0749a.g(1935763834);
        if (bVarG2 != null) {
            x((q) z3.a.e(qVarA), bVarG2.f69801b, rVar);
        }
        l5.a.b bVarG3 = c0749a.g(1935763823);
        if (bVarG3 != null) {
            w(bVarG3.f69801b, rVar);
        }
        l5.a.b bVarG4 = c0749a.g(1936027235);
        if (bVarG4 != null) {
            A(bVarG4.f69801b, rVar);
        }
        y(c0749a, qVarA != null ? qVarA.f69940b : null, rVar);
        int size = c0749a.f69799c.size();
        for (int i12 = 0; i12 < size; i12++) {
            l5.a.b bVar = c0749a.f69799c.get(i12);
            if (bVar.f69797a == 1970628964) {
                I(bVar.f69801b, rVar, bArr);
            }
        }
    }

    public static Pair<Integer, c> F(c0 c0Var) {
        c0Var.U(12);
        return Pair.create(Integer.valueOf(c0Var.q()), new c(c0Var.q() - 1, c0Var.q(), c0Var.q(), c0Var.q()));
    }

    public static int G(b bVar, int i11, int i12, c0 c0Var, int i13) throws ParserException {
        int iQ;
        b bVar2 = bVar;
        c0Var.U(8);
        int iB = l5.a.b(c0Var.q());
        p pVar = bVar2.f69874d.f69962a;
        r rVar = bVar2.f69872b;
        c cVar = (c) u0.i(rVar.f69944a);
        rVar.f69951h[i11] = c0Var.L();
        long[] jArr = rVar.f69950g;
        long j11 = rVar.f69946c;
        jArr[i11] = j11;
        if ((iB & 1) != 0) {
            jArr[i11] = j11 + ((long) c0Var.q());
        }
        boolean z11 = (iB & 4) != 0;
        int iQ2 = cVar.f69834d;
        if (z11) {
            iQ2 = c0Var.q();
        }
        boolean z12 = (iB & 256) != 0;
        boolean z13 = (iB & 512) != 0;
        boolean z14 = (iB & 1024) != 0;
        boolean z15 = (iB & 2048) != 0;
        long j12 = l(pVar) ? ((long[]) u0.i(pVar.f69936i))[0] : 0L;
        int[] iArr = rVar.f69952i;
        long[] jArr2 = rVar.f69953j;
        boolean[] zArr = rVar.f69954k;
        int i14 = iQ2;
        boolean z16 = pVar.f69929b == 2 && (i12 & 1) != 0;
        int i15 = i13 + rVar.f69951h[i11];
        boolean z17 = z16;
        long j13 = pVar.f69930c;
        long j14 = rVar.f69960q;
        int i16 = i13;
        while (i16 < i15) {
            int iE = e(z12 ? c0Var.q() : cVar.f69832b);
            int iE2 = e(z13 ? c0Var.q() : cVar.f69833c);
            if (z14) {
                iQ = c0Var.q();
            } else {
                iQ = (i16 == 0 && z11) ? i14 : cVar.f69834d;
            }
            long jF1 = u0.f1((((long) (z15 ? c0Var.q() : 0)) + j14) - j12, 1000000L, j13);
            jArr2[i16] = jF1;
            if (!rVar.f69961r) {
                jArr2[i16] = jF1 + bVar2.f69874d.f69969h;
            }
            iArr[i16] = iE2;
            zArr[i16] = ((iQ >> 16) & 1) == 0 && (!z17 || i16 == 0);
            j14 += (long) iE;
            i16++;
            bVar2 = bVar;
            z12 = z12;
            z11 = z11;
            z15 = z15;
            z13 = z13;
            z14 = z14;
        }
        rVar.f69960q = j14;
        return i15;
    }

    public static void H(l5.a.C0749a c0749a, b bVar, int i11) throws ParserException {
        List<l5.a.b> list = c0749a.f69799c;
        int size = list.size();
        int i12 = 0;
        int i13 = 0;
        for (int i14 = 0; i14 < size; i14++) {
            l5.a.b bVar2 = list.get(i14);
            if (bVar2.f69797a == 1953658222) {
                c0 c0Var = bVar2.f69801b;
                c0Var.U(12);
                int iL = c0Var.L();
                if (iL > 0) {
                    i13 += iL;
                    i12++;
                }
            }
        }
        bVar.f69878h = 0;
        bVar.f69877g = 0;
        bVar.f69876f = 0;
        bVar.f69872b.e(i12, i13);
        int i15 = 0;
        int iG = 0;
        for (int i16 = 0; i16 < size; i16++) {
            l5.a.b bVar3 = list.get(i16);
            if (bVar3.f69797a == 1953658222) {
                iG = G(bVar, i15, i11, bVar3.f69801b, iG);
                i15++;
            }
        }
    }

    public static void I(c0 c0Var, r rVar, byte[] bArr) throws ParserException {
        c0Var.U(8);
        c0Var.l(bArr, 0, 16);
        if (Arrays.equals(bArr, K)) {
            z(c0Var, 16, rVar);
        }
    }

    private void J(long j11) throws ParserException {
        while (!this.f69855n.isEmpty() && this.f69855n.peek().f69798b == j11) {
            o(this.f69855n.pop());
        }
        g();
    }

    private boolean K(t tVar) throws IOException {
        if (this.f69861t == 0) {
            if (!tVar.readFully(this.f69854m.e(), 0, 8, true)) {
                return false;
            }
            this.f69861t = 8;
            this.f69854m.U(0);
            this.f69860s = this.f69854m.J();
            this.f69859r = this.f69854m.q();
        }
        long j11 = this.f69860s;
        if (j11 == 1) {
            tVar.readFully(this.f69854m.e(), 8, 8);
            this.f69861t += 8;
            this.f69860s = this.f69854m.M();
        } else if (j11 == 0) {
            long length = tVar.getLength();
            if (length == -1 && !this.f69855n.isEmpty()) {
                length = this.f69855n.peek().f69798b;
            }
            if (length != -1) {
                this.f69860s = (length - tVar.getPosition()) + ((long) this.f69861t);
            }
        }
        if (this.f69860s < this.f69861t) {
            throw ParserException.createForUnsupportedContainerFeature("Atom size less than header length (unsupported).");
        }
        long position = tVar.getPosition() - ((long) this.f69861t);
        int i11 = this.f69859r;
        if ((i11 == 1836019558 || i11 == 1835295092) && !this.I) {
            this.F.f(new m0.b(this.f69866y, position));
            this.I = true;
        }
        if (this.f69859r == 1836019558) {
            int size = this.f69846e.size();
            for (int i12 = 0; i12 < size; i12++) {
                r rVar = this.f69846e.valueAt(i12).f69872b;
                rVar.f69945b = position;
                rVar.f69947d = position;
                rVar.f69946c = position;
            }
        }
        int i13 = this.f69859r;
        if (i13 == 1835295092) {
            this.A = null;
            this.f69863v = position + this.f69860s;
            this.f69858q = 2;
            return true;
        }
        if (O(i13)) {
            long position2 = (tVar.getPosition() + this.f69860s) - 8;
            this.f69855n.push(new l5.a.C0749a(this.f69859r, position2));
            if (this.f69860s == this.f69861t) {
                J(position2);
            } else {
                g();
            }
        } else if (P(this.f69859r)) {
            if (this.f69861t != 8) {
                throw ParserException.createForUnsupportedContainerFeature("Leaf atom defines extended atom size (unsupported).");
            }
            if (this.f69860s > 2147483647L) {
                throw ParserException.createForUnsupportedContainerFeature("Leaf atom with length > 2147483647 (unsupported).");
            }
            c0 c0Var = new c0((int) this.f69860s);
            System.arraycopy(this.f69854m.e(), 0, c0Var.e(), 0, 8);
            this.f69862u = c0Var;
            this.f69858q = 1;
        } else {
            if (this.f69860s > 2147483647L) {
                throw ParserException.createForUnsupportedContainerFeature("Skipping atom with length > 2147483647 (unsupported).");
            }
            this.f69862u = null;
            this.f69858q = 1;
        }
        return true;
    }

    private static boolean O(int i11) {
        return i11 == 1836019574 || i11 == 1953653099 || i11 == 1835297121 || i11 == 1835626086 || i11 == 1937007212 || i11 == 1836019558 || i11 == 1953653094 || i11 == 1836475768 || i11 == 1701082227;
    }

    private static boolean P(int i11) {
        return i11 == 1751411826 || i11 == 1835296868 || i11 == 1836476516 || i11 == 1936286840 || i11 == 1937011556 || i11 == 1937011827 || i11 == 1668576371 || i11 == 1937011555 || i11 == 1937011578 || i11 == 1937013298 || i11 == 1937007471 || i11 == 1668232756 || i11 == 1937011571 || i11 == 1952867444 || i11 == 1952868452 || i11 == 1953196132 || i11 == 1953654136 || i11 == 1953658222 || i11 == 1886614376 || i11 == 1935763834 || i11 == 1935763823 || i11 == 1936027235 || i11 == 1970628964 || i11 == 1935828848 || i11 == 1936158820 || i11 == 1701606260 || i11 == 1835362404 || i11 == 1701671783;
    }

    public static int e(int i11) throws ParserException {
        if (i11 >= 0) {
            return i11;
        }
        throw ParserException.createForMalformedContainer("Unexpected negative value: " + i11, null);
    }

    private void g() {
        this.f69858q = 0;
        this.f69861t = 0;
    }

    @Nullable
    public static DrmInitData i(List<l5.a.b> list) {
        int size = list.size();
        ArrayList arrayList = null;
        for (int i11 = 0; i11 < size; i11++) {
            l5.a.b bVar = list.get(i11);
            if (bVar.f69797a == 1886614376) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                byte[] bArrE = bVar.f69801b.e();
                UUID uuidF = l.f(bArrE);
                if (uuidF == null) {
                    z3.o.h("FragmentedMp4Extractor", "Skipped pssh atom (failed to extract uuid)");
                } else {
                    arrayList.add(new DrmInitData.SchemeData(uuidF, MimeTypes.VIDEO_MP4, bArrE));
                }
            }
        }
        if (arrayList == null) {
            return null;
        }
        return new DrmInitData(arrayList);
    }

    @Nullable
    public static b j(SparseArray<b> sparseArray) {
        int size = sparseArray.size();
        b bVar = null;
        long j11 = Long.MAX_VALUE;
        for (int i11 = 0; i11 < size; i11++) {
            b bVarValueAt = sparseArray.valueAt(i11);
            if ((bVarValueAt.f69882l || bVarValueAt.f69876f != bVarValueAt.f69874d.f69963b) && (!bVarValueAt.f69882l || bVarValueAt.f69878h != bVarValueAt.f69872b.f69948e)) {
                long jD = bVarValueAt.d();
                if (jD < j11) {
                    bVar = bVarValueAt;
                    j11 = jD;
                }
            }
        }
        return bVar;
    }

    public static boolean l(p pVar) {
        long[] jArr;
        long[] jArr2 = pVar.f69935h;
        if (jArr2 == null || jArr2.length != 1 || (jArr = pVar.f69936i) == null) {
            return false;
        }
        long j11 = jArr2[0];
        return j11 == 0 || u0.f1(j11 + jArr[0], 1000000L, pVar.f69931d) >= pVar.f69932e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ u4.s[] m() {
        return new u4.s[]{new g(o5.s.a.f72352a, 32)};
    }

    public static long u(c0 c0Var) {
        c0Var.U(8);
        return l5.a.c(c0Var.q()) == 0 ? c0Var.J() : c0Var.M();
    }

    public static void v(l5.a.C0749a c0749a, SparseArray<b> sparseArray, boolean z11, int i11, byte[] bArr) throws ParserException {
        int size = c0749a.f69800d.size();
        for (int i12 = 0; i12 < size; i12++) {
            l5.a.C0749a c0749a2 = c0749a.f69800d.get(i12);
            if (c0749a2.f69797a == 1953653094) {
                E(c0749a2, sparseArray, z11, i11, bArr);
            }
        }
    }

    public static void w(c0 c0Var, r rVar) throws ParserException {
        c0Var.U(8);
        int iQ = c0Var.q();
        if ((l5.a.b(iQ) & 1) == 1) {
            c0Var.V(8);
        }
        int iL = c0Var.L();
        if (iL == 1) {
            rVar.f69947d += l5.a.c(iQ) == 0 ? c0Var.J() : c0Var.M();
        } else {
            throw ParserException.createForMalformedContainer("Unexpected saio entry count: " + iL, null);
        }
    }

    public static void x(q qVar, c0 c0Var, r rVar) throws ParserException {
        int i11;
        int i12 = qVar.f69942d;
        c0Var.U(8);
        if ((l5.a.b(c0Var.q()) & 1) == 1) {
            c0Var.V(8);
        }
        int iH = c0Var.H();
        int iL = c0Var.L();
        if (iL > rVar.f69949f) {
            throw ParserException.createForMalformedContainer("Saiz sample count " + iL + " is greater than fragment sample count" + rVar.f69949f, null);
        }
        if (iH == 0) {
            boolean[] zArr = rVar.f69956m;
            i11 = 0;
            for (int i13 = 0; i13 < iL; i13++) {
                int iH2 = c0Var.H();
                i11 += iH2;
                zArr[i13] = iH2 > i12;
            }
        } else {
            i11 = iH * iL;
            Arrays.fill(rVar.f69956m, 0, iL, iH > i12);
        }
        Arrays.fill(rVar.f69956m, iL, rVar.f69949f, false);
        if (i11 > 0) {
            rVar.d(i11);
        }
    }

    public static void y(l5.a.C0749a c0749a, @Nullable String str, r rVar) throws ParserException {
        byte[] bArr = null;
        c0 c0Var = null;
        c0 c0Var2 = null;
        for (int i11 = 0; i11 < c0749a.f69799c.size(); i11++) {
            l5.a.b bVar = c0749a.f69799c.get(i11);
            c0 c0Var3 = bVar.f69801b;
            int i12 = bVar.f69797a;
            if (i12 == 1935828848) {
                c0Var3.U(12);
                if (c0Var3.q() == 1936025959) {
                    c0Var = c0Var3;
                }
            } else if (i12 == 1936158820) {
                c0Var3.U(12);
                if (c0Var3.q() == 1936025959) {
                    c0Var2 = c0Var3;
                }
            }
        }
        if (c0Var == null || c0Var2 == null) {
            return;
        }
        c0Var.U(8);
        int iC = l5.a.c(c0Var.q());
        c0Var.V(4);
        if (iC == 1) {
            c0Var.V(4);
        }
        if (c0Var.q() != 1) {
            throw ParserException.createForUnsupportedContainerFeature("Entry count in sbgp != 1 (unsupported).");
        }
        c0Var2.U(8);
        int iC2 = l5.a.c(c0Var2.q());
        c0Var2.V(4);
        if (iC2 == 1) {
            if (c0Var2.J() == 0) {
                throw ParserException.createForUnsupportedContainerFeature("Variable length description in sgpd found (unsupported)");
            }
        } else if (iC2 >= 2) {
            c0Var2.V(4);
        }
        if (c0Var2.J() != 1) {
            throw ParserException.createForUnsupportedContainerFeature("Entry count in sgpd != 1 (unsupported).");
        }
        c0Var2.V(1);
        int iH = c0Var2.H();
        int i13 = (iH & 240) >> 4;
        int i14 = iH & 15;
        boolean z11 = c0Var2.H() == 1;
        if (z11) {
            int iH2 = c0Var2.H();
            byte[] bArr2 = new byte[16];
            c0Var2.l(bArr2, 0, 16);
            if (iH2 == 0) {
                int iH3 = c0Var2.H();
                bArr = new byte[iH3];
                c0Var2.l(bArr, 0, iH3);
            }
            rVar.f69955l = true;
            rVar.f69957n = new q(z11, str, iH2, bArr2, i13, i14, bArr);
        }
    }

    public static void z(c0 c0Var, int i11, r rVar) throws ParserException {
        c0Var.U(i11 + 8);
        int iB = l5.a.b(c0Var.q());
        if ((iB & 1) != 0) {
            throw ParserException.createForUnsupportedContainerFeature("Overriding TrackEncryptionBox parameters is unsupported.");
        }
        boolean z11 = (iB & 2) != 0;
        int iL = c0Var.L();
        if (iL == 0) {
            Arrays.fill(rVar.f69956m, 0, rVar.f69949f, false);
            return;
        }
        if (iL == rVar.f69949f) {
            Arrays.fill(rVar.f69956m, 0, iL, z11);
            rVar.d(c0Var.a());
            rVar.b(c0Var);
        } else {
            throw ParserException.createForMalformedContainer("Senc sample count " + iL + " is different from fragment sample count" + rVar.f69949f, null);
        }
    }

    public final void L(t tVar) throws IOException {
        int i11 = ((int) this.f69860s) - this.f69861t;
        c0 c0Var = this.f69862u;
        if (c0Var != null) {
            tVar.readFully(c0Var.e(), 8, i11);
            q(new l5.a.b(this.f69859r, c0Var), tVar.getPosition());
        } else {
            tVar.skipFully(i11);
        }
        J(tVar.getPosition());
    }

    public final void M(t tVar) throws IOException {
        int size = this.f69846e.size();
        long j11 = Long.MAX_VALUE;
        b bVarValueAt = null;
        for (int i11 = 0; i11 < size; i11++) {
            r rVar = this.f69846e.valueAt(i11).f69872b;
            if (rVar.f69959p) {
                long j12 = rVar.f69947d;
                if (j12 < j11) {
                    bVarValueAt = this.f69846e.valueAt(i11);
                    j11 = j12;
                }
            }
        }
        if (bVarValueAt == null) {
            this.f69858q = 3;
            return;
        }
        int position = (int) (j11 - tVar.getPosition());
        if (position < 0) {
            throw ParserException.createForMalformedContainer("Offset to encryption data was negative.", null);
        }
        tVar.skipFully(position);
        bVarValueAt.f69872b.a(tVar);
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
    public final boolean N(t tVar) throws IOException {
        int iD;
        b bVarJ = this.A;
        Throwable th2 = null;
        if (bVarJ == null) {
            bVarJ = j(this.f69846e);
            if (bVarJ == null) {
                int position = (int) (this.f69863v - tVar.getPosition());
                if (position < 0) {
                    throw ParserException.createForMalformedContainer("Offset to end of mdat was negative.", null);
                }
                tVar.skipFully(position);
                g();
                return false;
            }
            int iD2 = (int) (bVarJ.d() - tVar.getPosition());
            if (iD2 < 0) {
                z3.o.h("FragmentedMp4Extractor", "Ignoring negative offset to sample data.");
                iD2 = 0;
            }
            tVar.skipFully(iD2);
            this.A = bVarJ;
        }
        int i11 = 4;
        int i12 = 1;
        if (this.f69858q == 3) {
            int iF = bVarJ.f();
            this.B = iF;
            if (bVarJ.f69876f < bVarJ.f69879i) {
                tVar.skipFully(iF);
                bVarJ.m();
                if (!bVarJ.h()) {
                    this.A = null;
                }
                this.f69858q = 3;
                return true;
            }
            if (bVarJ.f69874d.f69962a.f69934g == 1) {
                this.B = iF - 8;
                tVar.skipFully(8);
            }
            if ("audio/ac4".equals(bVarJ.f69874d.f69962a.f69933f.f9501m)) {
                this.C = bVarJ.i(this.B, 7);
                u4.c.a(this.B, this.f69851j);
                bVarJ.f69871a.c(this.f69851j, 7);
                this.C += 7;
            } else {
                this.C = bVarJ.i(this.B, 0);
            }
            this.B += this.C;
            this.f69858q = 4;
            this.D = 0;
        }
        p pVar = bVarJ.f69874d.f69962a;
        r0 r0Var = bVarJ.f69871a;
        long jE = bVarJ.e();
        i0 i0Var = this.f69852k;
        if (i0Var != null) {
            jE = i0Var.a(jE);
        }
        long j11 = jE;
        if (pVar.f69937j == 0) {
            while (true) {
                int i13 = this.C;
                int i14 = this.B;
                if (i13 >= i14) {
                    break;
                }
                this.C += r0Var.d(tVar, i14 - i13, false);
            }
        } else {
            byte[] bArrE = this.f69848g.e();
            bArrE[0] = 0;
            bArrE[1] = 0;
            bArrE[2] = 0;
            int i15 = pVar.f69937j;
            int i16 = i15 + 1;
            int i17 = 4 - i15;
            while (this.C < this.B) {
                int i18 = this.D;
                if (i18 == 0) {
                    tVar.readFully(bArrE, i17, i16);
                    this.f69848g.U(0);
                    int iQ = this.f69848g.q();
                    if (iQ < i12) {
                        throw ParserException.createForMalformedContainer("Invalid NAL length", th2);
                    }
                    this.D = iQ - 1;
                    this.f69847f.U(0);
                    r0Var.c(this.f69847f, i11);
                    r0Var.c(this.f69848g, i12);
                    this.E = this.H.length > 0 && a4.a.g(pVar.f69933f.f9501m, bArrE[i11]);
                    this.C += 5;
                    this.B += i17;
                } else {
                    if (this.E) {
                        this.f69849h.Q(i18);
                        tVar.readFully(this.f69849h.e(), 0, this.D);
                        r0Var.c(this.f69849h, this.D);
                        iD = this.D;
                        int iQ2 = a4.a.q(this.f69849h.e(), this.f69849h.g());
                        this.f69849h.U(MimeTypes.VIDEO_H265.equals(pVar.f69933f.f9501m) ? 1 : 0);
                        this.f69849h.T(iQ2);
                        u4.g.a(j11, this.f69849h, this.H);
                    } else {
                        iD = r0Var.d(tVar, i18, false);
                    }
                    this.C += iD;
                    this.D -= iD;
                    th2 = null;
                    i11 = 4;
                    i12 = 1;
                }
            }
        }
        int iC = bVarJ.c();
        q qVarG = bVarJ.g();
        r0Var.f(j11, iC, this.B, 0, qVarG != null ? qVarG.f69941c : null);
        t(j11);
        if (!bVarJ.h()) {
            this.A = null;
        }
        this.f69858q = 3;
        return true;
    }

    @Override // u4.s
    public boolean b(t tVar) throws IOException {
        return o.b(tVar);
    }

    @Override // u4.s
    public /* synthetic */ u4.s c() {
        return u4.r.a(this);
    }

    @Override // u4.s
    public int d(t tVar, l0 l0Var) throws IOException {
        while (true) {
            int i11 = this.f69858q;
            if (i11 != 0) {
                if (i11 == 1) {
                    L(tVar);
                } else if (i11 == 2) {
                    M(tVar);
                } else if (N(tVar)) {
                    return 0;
                }
            } else if (!K(tVar)) {
                return -1;
            }
        }
    }

    @Override // u4.s
    public void f(u uVar) {
        this.F = (this.f69843b & 32) == 0 ? new o5.u(uVar, this.f69842a) : uVar;
        g();
        k();
        p pVar = this.f69844c;
        if (pVar != null) {
            this.f69846e.put(0, new b(uVar.track(0, pVar.f69929b), new s(this.f69844c, new long[0], new int[0], 0, new long[0], new int[0], 0L), new c(0, 0, 0, 0)));
            this.F.endTracks();
        }
    }

    public final c h(SparseArray<c> sparseArray, int i11) {
        return sparseArray.size() == 1 ? sparseArray.valueAt(0) : (c) z3.a.e(sparseArray.get(i11));
    }

    public final void k() {
        int i11;
        r0[] r0VarArr = new r0[2];
        this.G = r0VarArr;
        r0 r0Var = this.f69857p;
        int i12 = 0;
        if (r0Var != null) {
            r0VarArr[0] = r0Var;
            i11 = 1;
        } else {
            i11 = 0;
        }
        int i13 = 100;
        if ((this.f69843b & 4) != 0) {
            r0VarArr[i11] = this.F.track(100, 5);
            i13 = 101;
            i11++;
        }
        r0[] r0VarArr2 = (r0[]) u0.X0(this.G, i11);
        this.G = r0VarArr2;
        for (r0 r0Var2 : r0VarArr2) {
            r0Var2.b(L);
        }
        this.H = new r0[this.f69845d.size()];
        while (i12 < this.H.length) {
            r0 r0VarTrack = this.F.track(i13, 3);
            r0VarTrack.b(this.f69845d.get(i12));
            this.H[i12] = r0VarTrack;
            i12++;
            i13++;
        }
    }

    @Nullable
    public p n(@Nullable p pVar) {
        return pVar;
    }

    public final void o(l5.a.C0749a c0749a) throws ParserException {
        int i11 = c0749a.f69797a;
        if (i11 == 1836019574) {
            s(c0749a);
        } else if (i11 == 1836019558) {
            r(c0749a);
        } else {
            if (this.f69855n.isEmpty()) {
                return;
            }
            this.f69855n.peek().d(c0749a);
        }
    }

    public final void p(c0 c0Var) {
        long jF1;
        String str;
        long jF2;
        String str2;
        long J2;
        long jA;
        if (this.G.length == 0) {
            return;
        }
        c0Var.U(8);
        int iC = l5.a.c(c0Var.q());
        if (iC == 0) {
            String str3 = (String) z3.a.e(c0Var.B());
            String str4 = (String) z3.a.e(c0Var.B());
            long J3 = c0Var.J();
            jF1 = u0.f1(c0Var.J(), 1000000L, J3);
            long j11 = this.f69867z;
            long j12 = j11 != C.TIME_UNSET ? j11 + jF1 : -9223372036854775807L;
            str = str3;
            jF2 = u0.f1(c0Var.J(), 1000L, J3);
            str2 = str4;
            J2 = c0Var.J();
            jA = j12;
        } else {
            if (iC != 1) {
                z3.o.h("FragmentedMp4Extractor", "Skipping unsupported emsg version: " + iC);
                return;
            }
            long J4 = c0Var.J();
            jA = u0.f1(c0Var.M(), 1000000L, J4);
            long jF3 = u0.f1(c0Var.J(), 1000L, J4);
            long J5 = c0Var.J();
            str = (String) z3.a.e(c0Var.B());
            jF2 = jF3;
            J2 = J5;
            str2 = (String) z3.a.e(c0Var.B());
            jF1 = -9223372036854775807L;
        }
        byte[] bArr = new byte[c0Var.a()];
        c0Var.l(bArr, 0, c0Var.a());
        c0 c0Var2 = new c0(this.f69853l.a(new EventMessage(str, str2, jF2, J2, bArr)));
        int iA = c0Var2.a();
        for (r0 r0Var : this.G) {
            c0Var2.U(0);
            r0Var.c(c0Var2, iA);
        }
        if (jA == C.TIME_UNSET) {
            this.f69856o.addLast(new a(jF1, true, iA));
            this.f69864w += iA;
            return;
        }
        if (!this.f69856o.isEmpty()) {
            this.f69856o.addLast(new a(jA, false, iA));
            this.f69864w += iA;
            return;
        }
        i0 i0Var = this.f69852k;
        if (i0Var != null && !i0Var.g()) {
            this.f69856o.addLast(new a(jA, false, iA));
            this.f69864w += iA;
            return;
        }
        i0 i0Var2 = this.f69852k;
        if (i0Var2 != null) {
            jA = i0Var2.a(jA);
        }
        for (r0 r0Var2 : this.G) {
            r0Var2.f(jA, 1, iA, 0, null);
        }
    }

    public final void q(l5.a.b bVar, long j11) throws ParserException {
        if (!this.f69855n.isEmpty()) {
            this.f69855n.peek().e(bVar);
            return;
        }
        int i11 = bVar.f69797a;
        if (i11 != 1936286840) {
            if (i11 == 1701671783) {
                p(bVar.f69801b);
            }
        } else {
            Pair<Long, u4.h> pairB = B(bVar.f69801b, j11);
            this.f69867z = ((Long) pairB.first).longValue();
            this.F.f((m0) pairB.second);
            this.I = true;
        }
    }

    public final void r(l5.a.C0749a c0749a) throws ParserException {
        v(c0749a, this.f69846e, this.f69844c != null, this.f69843b, this.f69850i);
        DrmInitData drmInitDataI = i(c0749a.f69799c);
        if (drmInitDataI != null) {
            int size = this.f69846e.size();
            for (int i11 = 0; i11 < size; i11++) {
                this.f69846e.valueAt(i11).n(drmInitDataI);
            }
        }
        if (this.f69865x != C.TIME_UNSET) {
            int size2 = this.f69846e.size();
            for (int i12 = 0; i12 < size2; i12++) {
                this.f69846e.valueAt(i12).l(this.f69865x);
            }
            this.f69865x = C.TIME_UNSET;
        }
    }

    @Override // u4.s
    public void release() {
    }

    public final void s(l5.a.C0749a c0749a) throws ParserException {
        int i11 = 0;
        z3.a.h(this.f69844c == null, "Unexpected moov box.");
        DrmInitData drmInitDataI = i(c0749a.f69799c);
        l5.a.C0749a c0749a2 = (l5.a.C0749a) z3.a.e(c0749a.f(1836475768));
        SparseArray<c> sparseArray = new SparseArray<>();
        int size = c0749a2.f69799c.size();
        long jU = -9223372036854775807L;
        for (int i12 = 0; i12 < size; i12++) {
            l5.a.b bVar = c0749a2.f69799c.get(i12);
            int i13 = bVar.f69797a;
            if (i13 == 1953654136) {
                Pair<Integer, c> pairF = F(bVar.f69801b);
                sparseArray.put(((Integer) pairF.first).intValue(), (c) pairF.second);
            } else if (i13 == 1835362404) {
                jU = u(bVar.f69801b);
            }
        }
        List<s> listB = l5.b.B(c0749a, new f0(), jU, drmInitDataI, (this.f69843b & 16) != 0, false, new com.google.common.base.f() { // from class: l5.f
            @Override // com.google.common.base.f
            public final Object apply(Object obj) {
                return this.f69841a.n((p) obj);
            }
        });
        int size2 = listB.size();
        if (this.f69846e.size() != 0) {
            z3.a.g(this.f69846e.size() == size2);
            while (i11 < size2) {
                s sVar = listB.get(i11);
                p pVar = sVar.f69962a;
                this.f69846e.get(pVar.f69928a).j(sVar, h(sparseArray, pVar.f69928a));
                i11++;
            }
            return;
        }
        while (i11 < size2) {
            s sVar2 = listB.get(i11);
            p pVar2 = sVar2.f69962a;
            this.f69846e.put(pVar2.f69928a, new b(this.F.track(i11, pVar2.f69929b), sVar2, h(sparseArray, pVar2.f69928a)));
            this.f69866y = Math.max(this.f69866y, pVar2.f69932e);
            i11++;
        }
        this.F.endTracks();
    }

    @Override // u4.s
    public void seek(long j11, long j12) {
        int size = this.f69846e.size();
        for (int i11 = 0; i11 < size; i11++) {
            this.f69846e.valueAt(i11).k();
        }
        this.f69856o.clear();
        this.f69864w = 0;
        this.f69865x = j12;
        this.f69855n.clear();
        g();
    }

    public final void t(long j11) {
        while (!this.f69856o.isEmpty()) {
            a aVarRemoveFirst = this.f69856o.removeFirst();
            this.f69864w -= aVarRemoveFirst.f69870c;
            long jA = aVarRemoveFirst.f69868a;
            if (aVarRemoveFirst.f69869b) {
                jA += j11;
            }
            i0 i0Var = this.f69852k;
            if (i0Var != null) {
                jA = i0Var.a(jA);
            }
            for (r0 r0Var : this.G) {
                r0Var.f(jA, 1, aVarRemoveFirst.f69870c, this.f69864w, null);
            }
        }
    }
}
