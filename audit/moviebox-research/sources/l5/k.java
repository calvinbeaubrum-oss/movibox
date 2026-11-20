package l5;

import android.net.Uri;
import android.support.v4.media.session.PlaybackStateCompat;
import androidx.annotation.Nullable;
import androidx.media3.common.Metadata;
import androidx.media3.common.ParserException;
import androidx.media3.extractor.metadata.mp4.MotionPhotoMetadata;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import u4.f0;
import u4.l0;
import u4.m0;
import u4.n0;
import u4.r0;
import u4.s0;
import u4.t;
import u4.u;
import u4.x;
import u4.y;
import z3.c0;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class k implements u4.s, m0 {

    @Deprecated
    public static final y A = new y() { // from class: l5.i
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
            return k.p();
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o5.s.a f69884a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f69885b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c0 f69886c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c0 f69887d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c0 f69888e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c0 f69889f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ArrayDeque<l5.a.C0749a> f69890g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final m f69891h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<Metadata.Entry> f69892i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f69893j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f69894k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f69895l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f69896m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Nullable
    public c0 f69897n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f69898o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f69899p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f69900q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f69901r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f69902s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public u f69903t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public a[] f69904u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public long[][] f69905v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f69906w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public long f69907x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f69908y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @Nullable
    public MotionPhotoMetadata f69909z;

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final p f69910a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final s f69911b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final r0 f69912c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        public final s0 f69913d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f69914e;

        public a(p pVar, s sVar, r0 r0Var) {
            this.f69910a = pVar;
            this.f69911b = sVar;
            this.f69912c = r0Var;
            this.f69913d = MimeTypes.AUDIO_TRUEHD.equals(pVar.f69933f.f9501m) ? new s0() : null;
        }
    }

    @Deprecated
    public k() {
        this(o5.s.a.f72352a, 16);
    }

    public k(o5.s.a aVar, int i11) {
        this.f69884a = aVar;
        this.f69885b = i11;
        this.f69893j = (i11 & 4) != 0 ? 3 : 0;
        this.f69891h = new m();
        this.f69892i = new ArrayList();
        this.f69889f = new c0(16);
        this.f69890g = new ArrayDeque<>();
        this.f69886c = new c0(a4.a.f366a);
        this.f69887d = new c0(4);
        this.f69888e = new c0();
        this.f69898o = -1;
        this.f69903t = u.f78395m8;
        this.f69904u = new a[0];
    }

    public static boolean B(int i11) {
        return i11 == 1836019574 || i11 == 1953653099 || i11 == 1835297121 || i11 == 1835626086 || i11 == 1937007212 || i11 == 1701082227 || i11 == 1835365473;
    }

    public static boolean C(int i11) {
        return i11 == 1835296868 || i11 == 1836476516 || i11 == 1751411826 || i11 == 1937011556 || i11 == 1937011827 || i11 == 1937011571 || i11 == 1668576371 || i11 == 1701606260 || i11 == 1937011555 || i11 == 1937011578 || i11 == 1937013298 || i11 == 1937007471 || i11 == 1668232756 || i11 == 1953196132 || i11 == 1718909296 || i11 == 1969517665 || i11 == 1801812339 || i11 == 1768715124;
    }

    public static int i(int i11) {
        if (i11 != 1751476579) {
            return i11 != 1903435808 ? 0 : 1;
        }
        return 2;
    }

    public static long[][] j(a[] aVarArr) {
        long[][] jArr = new long[aVarArr.length][];
        int[] iArr = new int[aVarArr.length];
        long[] jArr2 = new long[aVarArr.length];
        boolean[] zArr = new boolean[aVarArr.length];
        for (int i11 = 0; i11 < aVarArr.length; i11++) {
            jArr[i11] = new long[aVarArr[i11].f69911b.f69963b];
            jArr2[i11] = aVarArr[i11].f69911b.f69967f[0];
        }
        long j11 = 0;
        int i12 = 0;
        while (i12 < aVarArr.length) {
            long j12 = Long.MAX_VALUE;
            int i13 = -1;
            for (int i14 = 0; i14 < aVarArr.length; i14++) {
                if (!zArr[i14]) {
                    long j13 = jArr2[i14];
                    if (j13 <= j12) {
                        i13 = i14;
                        j12 = j13;
                    }
                }
            }
            int i15 = iArr[i13];
            long[] jArr3 = jArr[i13];
            jArr3[i15] = j11;
            s sVar = aVarArr[i13].f69911b;
            j11 += (long) sVar.f69965d[i15];
            int i16 = i15 + 1;
            iArr[i13] = i16;
            if (i16 < jArr3.length) {
                jArr2[i13] = sVar.f69967f[i16];
            } else {
                zArr[i13] = true;
                i12++;
            }
        }
        return jArr;
    }

    public static int m(s sVar, long j11) {
        int iA = sVar.a(j11);
        return iA == -1 ? sVar.b(j11) : iA;
    }

    public static /* synthetic */ p o(p pVar) {
        return pVar;
    }

    public static /* synthetic */ u4.s[] p() {
        return new u4.s[]{new k(o5.s.a.f72352a, 16)};
    }

    public static long q(s sVar, long j11, long j12) {
        int iM = m(sVar, j11);
        return iM == -1 ? j12 : Math.min(sVar.f69964c[iM], j12);
    }

    public static int u(c0 c0Var) {
        c0Var.U(8);
        int i11 = i(c0Var.q());
        if (i11 != 0) {
            return i11;
        }
        c0Var.V(4);
        while (c0Var.a() > 0) {
            int i12 = i(c0Var.q());
            if (i12 != 0) {
                return i12;
            }
        }
        return 0;
    }

    public final int A(t tVar, l0 l0Var) throws IOException {
        int iC = this.f69891h.c(tVar, l0Var, this.f69892i);
        if (iC == 1 && l0Var.f78322a == 0) {
            k();
        }
        return iC;
    }

    public final void D(a aVar, long j11) {
        s sVar = aVar.f69911b;
        int iA = sVar.a(j11);
        if (iA == -1) {
            iA = sVar.b(j11);
        }
        aVar.f69914e = iA;
    }

    @Override // u4.s
    public boolean b(t tVar) throws IOException {
        return o.d(tVar, (this.f69885b & 2) != 0);
    }

    @Override // u4.s
    public /* synthetic */ u4.s c() {
        return u4.r.a(this);
    }

    @Override // u4.s
    public int d(t tVar, l0 l0Var) throws IOException {
        while (true) {
            int i11 = this.f69893j;
            if (i11 != 0) {
                if (i11 != 1) {
                    if (i11 == 2) {
                        return z(tVar, l0Var);
                    }
                    if (i11 == 3) {
                        return A(tVar, l0Var);
                    }
                    throw new IllegalStateException();
                }
                if (y(tVar, l0Var)) {
                    return 1;
                }
            } else if (!x(tVar)) {
                return -1;
            }
        }
    }

    @Override // u4.s
    public void f(u uVar) {
        if ((this.f69885b & 16) == 0) {
            uVar = new o5.u(uVar, this.f69884a);
        }
        this.f69903t = uVar;
    }

    @Override // u4.m0
    public long getDurationUs() {
        return this.f69907x;
    }

    @Override // u4.m0
    public m0.a getSeekPoints(long j11) {
        return l(j11, -1);
    }

    @Override // u4.m0
    public boolean isSeekable() {
        return true;
    }

    public final void k() {
        this.f69893j = 0;
        this.f69896m = 0;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0062  */
    /* JADX WARN: Code duplicated, block: B:30:0x0068  */
    /* JADX WARN: Code duplicated, block: B:32:0x006c  */
    /* JADX WARN: Code duplicated, block: B:34:0x0078  */
    /* JADX WARN: Code duplicated, block: B:39:0x0089  */
    /* JADX WARN: Code duplicated, block: B:41:0x008f  */
    /* JADX WARN: Code duplicated, block: B:43:0x0080 A[EDGE_INSN: B:43:0x0080->B:37:0x0080 BREAK  A[LOOP:0: B:28:0x0063->B:36:0x007d], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:45:0x007d A[SYNTHETIC] */
    public m0.a l(long j11, int i11) {
        long j12;
        long j13;
        long jQ;
        long j14;
        int i12;
        a[] aVarArr;
        s sVar;
        int iB;
        a[] aVarArr2 = this.f69904u;
        if (aVarArr2.length == 0) {
            return new m0.a(n0.f78352c);
        }
        int i13 = i11 != -1 ? i11 : this.f69906w;
        if (i13 != -1) {
            s sVar2 = aVarArr2[i13].f69911b;
            int iM = m(sVar2, j11);
            if (iM == -1) {
                return new m0.a(n0.f78352c);
            }
            j13 = sVar2.f69967f[iM];
            j12 = sVar2.f69964c[iM];
            if (j13 < j11 && iM < sVar2.f69963b - 1 && (iB = sVar2.b(j11)) != -1 && iB != iM) {
                j14 = sVar2.f69967f[iB];
                jQ = sVar2.f69964c[iB];
            }
            if (i11 == -1) {
                i12 = 0;
                while (true) {
                    aVarArr = this.f69904u;
                    if (i12 < aVarArr.length) {
                        break;
                    }
                    if (i12 != this.f69906w) {
                        sVar = aVarArr[i12].f69911b;
                        long jQ2 = q(sVar, j13, j12);
                        if (j14 != C.TIME_UNSET) {
                            jQ = q(sVar, j14, jQ);
                        }
                        j12 = jQ2;
                    }
                    i12++;
                }
            }
            n0 n0Var = new n0(j13, j12);
            return j14 == C.TIME_UNSET ? new m0.a(n0Var) : new m0.a(n0Var, new n0(j14, jQ));
        }
        j12 = Long.MAX_VALUE;
        j13 = j11;
        jQ = -1;
        j14 = -9223372036854775807L;
        if (i11 == -1) {
            i12 = 0;
            while (true) {
                aVarArr = this.f69904u;
                if (i12 < aVarArr.length) {
                    break;
                    break;
                }
                if (i12 != this.f69906w) {
                    sVar = aVarArr[i12].f69911b;
                    long jQ3 = q(sVar, j13, j12);
                    if (j14 != C.TIME_UNSET) {
                        jQ = q(sVar, j14, jQ);
                    }
                    j12 = jQ3;
                }
                i12++;
            }
        }
        n0 n0Var2 = new n0(j13, j12);
        if (j14 == C.TIME_UNSET) {
        }
    }

    public final int n(long j11) {
        int i11 = -1;
        int i12 = -1;
        int i13 = 0;
        long j12 = Long.MAX_VALUE;
        boolean z11 = true;
        long j13 = Long.MAX_VALUE;
        boolean z12 = true;
        long j14 = Long.MAX_VALUE;
        while (true) {
            a[] aVarArr = this.f69904u;
            if (i13 >= aVarArr.length) {
                break;
            }
            a aVar = aVarArr[i13];
            int i14 = aVar.f69914e;
            s sVar = aVar.f69911b;
            if (i14 != sVar.f69963b) {
                long j15 = sVar.f69964c[i14];
                long j16 = ((long[][]) u0.i(this.f69905v))[i13][i14];
                long j17 = j15 - j11;
                boolean z13 = j17 < 0 || j17 >= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
                if ((!z13 && z12) || (z13 == z12 && j17 < j14)) {
                    z12 = z13;
                    j14 = j17;
                    i12 = i13;
                    j13 = j16;
                }
                if (j16 < j12) {
                    z11 = z13;
                    i11 = i13;
                    j12 = j16;
                }
            }
            i13++;
        }
        return (j12 == Long.MAX_VALUE || !z11 || j13 < j12 + 10485760) ? i12 : i11;
    }

    public final void r(t tVar) throws IOException {
        this.f69888e.Q(8);
        tVar.peekFully(this.f69888e.e(), 0, 8);
        b.f(this.f69888e);
        tVar.skipFully(this.f69888e.f());
        tVar.resetPeekPosition();
    }

    @Override // u4.s
    public void release() {
    }

    public final void s(long j11) throws ParserException {
        while (!this.f69890g.isEmpty() && this.f69890g.peek().f69798b == j11) {
            l5.a.C0749a c0749aPop = this.f69890g.pop();
            if (c0749aPop.f69797a == 1836019574) {
                v(c0749aPop);
                this.f69890g.clear();
                this.f69893j = 2;
            } else if (!this.f69890g.isEmpty()) {
                this.f69890g.peek().d(c0749aPop);
            }
        }
        if (this.f69893j != 2) {
            k();
        }
    }

    @Override // u4.s
    public void seek(long j11, long j12) {
        this.f69890g.clear();
        this.f69896m = 0;
        this.f69898o = -1;
        this.f69899p = 0;
        this.f69900q = 0;
        this.f69901r = 0;
        if (j11 == 0) {
            if (this.f69893j != 3) {
                k();
                return;
            } else {
                this.f69891h.g();
                this.f69892i.clear();
                return;
            }
        }
        for (a aVar : this.f69904u) {
            D(aVar, j12);
            s0 s0Var = aVar.f69913d;
            if (s0Var != null) {
                s0Var.b();
            }
        }
    }

    public final void t() {
        if (this.f69908y != 2 || (this.f69885b & 2) == 0) {
            return;
        }
        this.f69903t.track(0, 4).b(new androidx.media3.common.y.b().d0(this.f69909z == null ? null : new Metadata(this.f69909z)).I());
        this.f69903t.endTracks();
        this.f69903t.f(new m0.b(C.TIME_UNSET));
    }

    public final void v(l5.a.C0749a c0749a) throws ParserException {
        Metadata metadata;
        Metadata metadata2;
        int i11;
        int i12;
        ArrayList arrayList = new ArrayList();
        boolean z11 = this.f69908y == 1;
        f0 f0Var = new f0();
        l5.a.b bVarG = c0749a.g(1969517665);
        if (bVarG != null) {
            Metadata metadataC = b.C(bVarG);
            f0Var.c(metadataC);
            metadata = metadataC;
        } else {
            metadata = null;
        }
        l5.a.C0749a c0749aF = c0749a.f(1835365473);
        Metadata metadataP = c0749aF != null ? b.p(c0749aF) : null;
        Metadata metadata3 = new Metadata(b.r(((l5.a.b) z3.a.e(c0749a.g(1836476516))).f69801b));
        boolean z12 = (this.f69885b & 1) != 0;
        long j11 = C.TIME_UNSET;
        List<s> listB = b.B(c0749a, f0Var, C.TIME_UNSET, null, z12, z11, new com.google.common.base.f() { // from class: l5.j
            @Override // com.google.common.base.f
            public final Object apply(Object obj) {
                return k.o((p) obj);
            }
        });
        long jMax = -9223372036854775807L;
        int i13 = 0;
        int size = -1;
        int i14 = 0;
        while (i13 < listB.size()) {
            s sVar = listB.get(i13);
            if (sVar.f69963b == 0) {
                i11 = i14;
                metadata2 = metadata;
            } else {
                p pVar = sVar.f69962a;
                metadata2 = metadata;
                Metadata metadata4 = metadataP;
                long j12 = pVar.f69932e;
                if (j12 == j11) {
                    j12 = sVar.f69969h;
                }
                jMax = Math.max(jMax, j12);
                i11 = i14 + 1;
                a aVar = new a(pVar, sVar, this.f69903t.track(i14, pVar.f69929b));
                int i15 = MimeTypes.AUDIO_TRUEHD.equals(pVar.f69933f.f9501m) ? sVar.f69966e * 16 : sVar.f69966e + 30;
                androidx.media3.common.y.b bVarB = pVar.f69933f.b();
                bVarB.c0(i15);
                if (pVar.f69929b == 2) {
                    if ((this.f69885b & 8) != 0) {
                        bVarB.i0(pVar.f69933f.f9494f | (size == -1 ? 1 : 2));
                    }
                    if (j12 > 0 && (i12 = sVar.f69963b) > 0) {
                        bVarB.U(i12 / (j12 / 1000000.0f));
                    }
                }
                h.k(pVar.f69929b, f0Var, bVarB);
                int i16 = pVar.f69929b;
                Metadata[] metadataArr = new Metadata[3];
                metadataArr[0] = this.f69892i.isEmpty() ? null : new Metadata(this.f69892i);
                metadataArr[1] = metadata2;
                metadataArr[2] = metadata3;
                metadataP = metadata4;
                h.l(i16, metadataP, bVarB, metadataArr);
                aVar.f69912c.b(bVarB.I());
                if (pVar.f69929b == 2 && size == -1) {
                    size = arrayList.size();
                }
                arrayList.add(aVar);
            }
            i13++;
            metadata = metadata2;
            i14 = i11;
            j11 = C.TIME_UNSET;
        }
        this.f69906w = size;
        this.f69907x = jMax;
        a[] aVarArr = (a[]) arrayList.toArray(new a[0]);
        this.f69904u = aVarArr;
        this.f69905v = j(aVarArr);
        this.f69903t.endTracks();
        this.f69903t.f(this);
    }

    public final void w(long j11) {
        if (this.f69894k == 1836086884) {
            int i11 = this.f69896m;
            this.f69909z = new MotionPhotoMetadata(0L, j11, C.TIME_UNSET, j11 + ((long) i11), this.f69895l - ((long) i11));
        }
    }

    public final boolean x(t tVar) throws IOException {
        l5.a.C0749a c0749aPeek;
        if (this.f69896m == 0) {
            if (!tVar.readFully(this.f69889f.e(), 0, 8, true)) {
                t();
                return false;
            }
            this.f69896m = 8;
            this.f69889f.U(0);
            this.f69895l = this.f69889f.J();
            this.f69894k = this.f69889f.q();
        }
        long j11 = this.f69895l;
        if (j11 == 1) {
            tVar.readFully(this.f69889f.e(), 8, 8);
            this.f69896m += 8;
            this.f69895l = this.f69889f.M();
        } else if (j11 == 0) {
            long length = tVar.getLength();
            if (length == -1 && (c0749aPeek = this.f69890g.peek()) != null) {
                length = c0749aPeek.f69798b;
            }
            if (length != -1) {
                this.f69895l = (length - tVar.getPosition()) + ((long) this.f69896m);
            }
        }
        if (this.f69895l < this.f69896m) {
            throw ParserException.createForUnsupportedContainerFeature("Atom size less than header length (unsupported).");
        }
        if (B(this.f69894k)) {
            long position = tVar.getPosition();
            long j12 = this.f69895l;
            int i11 = this.f69896m;
            long j13 = (position + j12) - ((long) i11);
            if (j12 != i11 && this.f69894k == 1835365473) {
                r(tVar);
            }
            this.f69890g.push(new l5.a.C0749a(this.f69894k, j13));
            if (this.f69895l == this.f69896m) {
                s(j13);
            } else {
                k();
            }
        } else if (C(this.f69894k)) {
            z3.a.g(this.f69896m == 8);
            z3.a.g(this.f69895l <= 2147483647L);
            c0 c0Var = new c0((int) this.f69895l);
            System.arraycopy(this.f69889f.e(), 0, c0Var.e(), 0, 8);
            this.f69897n = c0Var;
            this.f69893j = 1;
        } else {
            w(tVar.getPosition() - ((long) this.f69896m));
            this.f69897n = null;
            this.f69893j = 1;
        }
        return true;
    }

    public final boolean y(t tVar, l0 l0Var) throws IOException {
        boolean z11;
        long j11 = this.f69895l - ((long) this.f69896m);
        long position = tVar.getPosition() + j11;
        c0 c0Var = this.f69897n;
        if (c0Var == null) {
            if (!this.f69902s && this.f69894k == 1835295092) {
                this.f69908y = 1;
            }
            if (j11 < PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
                tVar.skipFully((int) j11);
            } else {
                l0Var.f78322a = tVar.getPosition() + j11;
                z11 = true;
            }
            s(position);
            return (z11 || this.f69893j == 2) ? false : true;
        }
        tVar.readFully(c0Var.e(), this.f69896m, (int) j11);
        if (this.f69894k == 1718909296) {
            this.f69902s = true;
            this.f69908y = u(c0Var);
        } else if (!this.f69890g.isEmpty()) {
            this.f69890g.peek().e(new l5.a.b(this.f69894k, c0Var));
        }
        z11 = false;
        s(position);
        if (z11) {
        }
    }

    public final int z(t tVar, l0 l0Var) throws IOException {
        long position = tVar.getPosition();
        if (this.f69898o == -1) {
            int iN = n(position);
            this.f69898o = iN;
            if (iN == -1) {
                return -1;
            }
        }
        a aVar = this.f69904u[this.f69898o];
        r0 r0Var = aVar.f69912c;
        int i11 = aVar.f69914e;
        s sVar = aVar.f69911b;
        long j11 = sVar.f69964c[i11];
        int i12 = sVar.f69965d[i11];
        s0 s0Var = aVar.f69913d;
        long j12 = (j11 - position) + ((long) this.f69899p);
        if (j12 < 0 || j12 >= PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
            int i13 = 1;
            l0Var.f78322a = j11;
            return i13;
        }
        if (aVar.f69910a.f69934g == 1) {
            j12 += 8;
            i12 -= 8;
        }
        tVar.skipFully((int) j12);
        p pVar = aVar.f69910a;
        if (pVar.f69937j == 0) {
            if ("audio/ac4".equals(pVar.f69933f.f9501m)) {
                if (this.f69900q == 0) {
                    u4.c.a(i12, this.f69888e);
                    r0Var.c(this.f69888e, 7);
                    this.f69900q += 7;
                }
                i12 += 7;
            } else if (s0Var != null) {
                s0Var.d(tVar);
            }
            while (true) {
                int i14 = this.f69900q;
                if (i14 >= i12) {
                    break;
                }
                int iD = r0Var.d(tVar, i12 - i14, false);
                this.f69899p += iD;
                this.f69900q += iD;
                this.f69901r -= iD;
            }
        } else {
            byte[] bArrE = this.f69887d.e();
            bArrE[0] = 0;
            bArrE[1] = 0;
            bArrE[2] = 0;
            int i15 = aVar.f69910a.f69937j;
            int i16 = 4 - i15;
            while (this.f69900q < i12) {
                int i17 = this.f69901r;
                if (i17 == 0) {
                    tVar.readFully(bArrE, i16, i15);
                    this.f69899p += i15;
                    this.f69887d.U(0);
                    int iQ = this.f69887d.q();
                    if (iQ < 0) {
                        throw ParserException.createForMalformedContainer("Invalid NAL length", null);
                    }
                    this.f69901r = iQ;
                    this.f69886c.U(0);
                    r0Var.c(this.f69886c, 4);
                    this.f69900q += 4;
                    i12 += i16;
                } else {
                    int iD2 = r0Var.d(tVar, i17, false);
                    this.f69899p += iD2;
                    this.f69900q += iD2;
                    this.f69901r -= iD2;
                }
            }
        }
        int i18 = i12;
        s sVar2 = aVar.f69911b;
        long j13 = sVar2.f69967f[i11];
        int i19 = sVar2.f69968g[i11];
        if (s0Var != null) {
            s0Var.c(r0Var, j13, i19, i18, 0, null);
            if (i11 + 1 == aVar.f69911b.f69963b) {
                s0Var.a(r0Var, null);
            }
        } else {
            r0Var.f(j13, i19, i18, 0, null);
        }
        aVar.f69914e++;
        this.f69898o = -1;
        this.f69899p = 0;
        this.f69900q = 0;
        this.f69901r = 0;
        return 0;
    }
}
