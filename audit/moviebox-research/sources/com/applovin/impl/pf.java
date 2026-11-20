package com.applovin.impl;

import android.net.Uri;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Pair;
import com.applovin.exoplayer2.common.base.Function;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class pf implements k8, ij {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final o8 f21746y = new o8() { // from class: com.applovin.impl.g10
        @Override // com.applovin.impl.o8
        public final k8[] a() {
            return pf.f();
        }

        @Override // com.applovin.impl.o8
        public /* synthetic */ k8[] a(Uri uri, Map map) {
            return q00.a(this, uri, map);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f21747a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final bh f21748b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final bh f21749c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final bh f21750d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final bh f21751e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ArrayDeque f21752f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final mj f21753g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final List f21754h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f21755i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f21756j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f21757k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f21758l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private bh f21759m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f21760n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f21761o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f21762p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f21763q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private m8 f21764r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private a[] f21765s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private long[][] f21766t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f21767u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private long f21768v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f21769w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private nf f21770x;

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final lo f21771a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ro f21772b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final qo f21773c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f21774d;

        public a(lo loVar, ro roVar, qo qoVar) {
            this.f21771a = loVar;
            this.f21772b = roVar;
            this.f21773c = qoVar;
        }
    }

    public pf() {
        this(0);
    }

    public pf(int i11) {
        this.f21747a = i11;
        this.f21755i = (i11 & 4) != 0 ? 3 : 0;
        this.f21753g = new mj();
        this.f21754h = new ArrayList();
        this.f21751e = new bh(16);
        this.f21752f = new ArrayDeque();
        this.f21748b = new bh(zf.f24845a);
        this.f21749c = new bh(4);
        this.f21750d = new bh();
        this.f21760n = -1;
    }

    private static int a(int i11) {
        if (i11 != 1751476579) {
            return i11 != 1903435808 ? 0 : 1;
        }
        return 2;
    }

    private static int a(bh bhVar) {
        bhVar.f(8);
        int iA = a(bhVar.j());
        if (iA != 0) {
            return iA;
        }
        bhVar.g(4);
        while (bhVar.a() > 0) {
            int iA2 = a(bhVar.j());
            if (iA2 != 0) {
                return iA2;
            }
        }
        return 0;
    }

    private static int a(ro roVar, long j11) {
        int iA = roVar.a(j11);
        return iA == -1 ? roVar.b(j11) : iA;
    }

    private static long a(ro roVar, long j11, long j12) {
        int iA = a(roVar, j11);
        return iA == -1 ? j12 : Math.min(roVar.f22164c[iA], j12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ lo a(lo loVar) {
        return loVar;
    }

    private void a(j1.a aVar) {
        bf bfVar;
        bf bfVar2;
        ArrayList arrayList;
        bf bfVar3;
        char c11;
        int size;
        int i11;
        ArrayList arrayList2 = new ArrayList();
        boolean z11 = this.f21769w == 1;
        z9 z9Var = new z9();
        j1.b bVarE = aVar.e(1969517665);
        if (bVarE != null) {
            Pair pairA = k1.a(bVarE);
            bf bfVar4 = (bf) pairA.first;
            bf bfVar5 = (bf) pairA.second;
            if (bfVar4 != null) {
                z9Var.a(bfVar4);
            }
            bfVar = bfVar5;
            bfVar2 = bfVar4;
        } else {
            bfVar = null;
            bfVar2 = null;
        }
        j1.a aVarD = aVar.d(1835365473);
        bf bfVarB = aVarD != null ? k1.b(aVarD) : null;
        List listA = k1.a(aVar, z9Var, C.TIME_UNSET, (y6) null, (this.f21747a & 1) != 0, z11, new Function() { // from class: com.applovin.impl.f10
            @Override // com.applovin.exoplayer2.common.base.Function
            public final Object apply(Object obj) {
                return pf.a((lo) obj);
            }
        });
        m8 m8Var = (m8) b1.a(this.f21764r);
        int i12 = 0;
        int i13 = -1;
        long j11 = C.TIME_UNSET;
        for (int size2 = listA.size(); i12 < size2; size2 = size2) {
            ro roVar = (ro) listA.get(i12);
            if (roVar.f22163b == 0) {
                size = i13;
                arrayList = arrayList2;
            } else {
                lo loVar = roVar.f22162a;
                int i14 = i13;
                arrayList = arrayList2;
                long j12 = loVar.f20491e;
                if (j12 == C.TIME_UNSET) {
                    j12 = roVar.f22169h;
                }
                long jMax = Math.max(j11, j12);
                a aVar2 = new a(loVar, roVar, m8Var.a(i12, loVar.f20488b));
                int i15 = roVar.f22166e + 30;
                f9.b bVarA = loVar.f20492f.a();
                bVarA.i(i15);
                if (loVar.f20488b == 2 && j12 > 0 && (i11 = roVar.f22163b) > 1) {
                    bVarA.a(i11 / (j12 / 1000000.0f));
                }
                hf.a(loVar.f20488b, z9Var, bVarA);
                int i16 = loVar.f20488b;
                bf[] bfVarArr = new bf[2];
                bfVarArr[0] = bfVar;
                if (this.f21754h.isEmpty()) {
                    c11 = 1;
                    bfVar3 = null;
                } else {
                    bfVar3 = new bf(this.f21754h);
                    c11 = 1;
                }
                bfVarArr[c11] = bfVar3;
                hf.a(i16, bfVar2, bfVarB, bVarA, bfVarArr);
                aVar2.f21773c.a(bVarA.a());
                size = i14;
                if (loVar.f20488b == 2 && size == -1) {
                    size = arrayList.size();
                }
                arrayList.add(aVar2);
                j11 = jMax;
            }
            i12++;
            i13 = size;
            arrayList2 = arrayList;
            listA = listA;
        }
        this.f21767u = i13;
        this.f21768v = j11;
        a[] aVarArr = (a[]) arrayList2.toArray(new a[0]);
        this.f21765s = aVarArr;
        this.f21766t = a(aVarArr);
        m8Var.c();
        m8Var.a(this);
    }

    private static long[][] a(a[] aVarArr) {
        long[][] jArr = new long[aVarArr.length][];
        int[] iArr = new int[aVarArr.length];
        long[] jArr2 = new long[aVarArr.length];
        boolean[] zArr = new boolean[aVarArr.length];
        for (int i11 = 0; i11 < aVarArr.length; i11++) {
            jArr[i11] = new long[aVarArr[i11].f21772b.f22163b];
            jArr2[i11] = aVarArr[i11].f21772b.f22167f[0];
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
            ro roVar = aVarArr[i13].f21772b;
            j11 += (long) roVar.f22165d[i15];
            int i16 = i15 + 1;
            iArr[i13] = i16;
            if (i16 < jArr3.length) {
                jArr2[i13] = roVar.f22167f[i16];
            } else {
                zArr[i13] = true;
                i12++;
            }
        }
        return jArr;
    }

    private void b(l8 l8Var) {
        this.f21750d.d(8);
        l8Var.c(this.f21750d.c(), 0, 8);
        k1.a(this.f21750d);
        l8Var.a(this.f21750d.d());
        l8Var.b();
    }

    private static boolean b(int i11) {
        return i11 == 1836019574 || i11 == 1953653099 || i11 == 1835297121 || i11 == 1835626086 || i11 == 1937007212 || i11 == 1701082227 || i11 == 1835365473;
    }

    private boolean b(l8 l8Var, th thVar) {
        boolean z11;
        long j11 = this.f21757k - ((long) this.f21758l);
        long jF = l8Var.f() + j11;
        bh bhVar = this.f21759m;
        if (bhVar == null) {
            if (j11 < PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
                l8Var.a((int) j11);
            } else {
                thVar.f23379a = l8Var.f() + j11;
                z11 = true;
            }
            d(jF);
            return (z11 || this.f21755i == 2) ? false : true;
        }
        l8Var.d(bhVar.c(), this.f21758l, (int) j11);
        if (this.f21756j == 1718909296) {
            this.f21769w = a(bhVar);
        } else if (!this.f21752f.isEmpty()) {
            ((j1.a) this.f21752f.peek()).a(new j1.b(this.f21756j, bhVar));
        }
        z11 = false;
        d(jF);
        if (z11) {
        }
    }

    private int c(long j11) {
        int i11 = -1;
        int i12 = -1;
        long j12 = Long.MAX_VALUE;
        boolean z11 = true;
        long j13 = Long.MAX_VALUE;
        boolean z12 = true;
        long j14 = Long.MAX_VALUE;
        for (int i13 = 0; i13 < ((a[]) xp.a((Object) this.f21765s)).length; i13++) {
            a aVar = this.f21765s[i13];
            int i14 = aVar.f21774d;
            ro roVar = aVar.f21772b;
            if (i14 != roVar.f22163b) {
                long j15 = roVar.f22164c[i14];
                long j16 = ((long[][]) xp.a((Object) this.f21766t))[i13][i14];
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
        }
        return (j12 == Long.MAX_VALUE || !z11 || j13 < j12 + 10485760) ? i12 : i11;
    }

    private int c(l8 l8Var, th thVar) throws dh {
        long jF = l8Var.f();
        if (this.f21760n == -1) {
            int iC = c(jF);
            this.f21760n = iC;
            if (iC == -1) {
                return -1;
            }
        }
        a aVar = ((a[]) xp.a((Object) this.f21765s))[this.f21760n];
        qo qoVar = aVar.f21773c;
        int i11 = aVar.f21774d;
        ro roVar = aVar.f21772b;
        long j11 = roVar.f22164c[i11];
        int i12 = roVar.f22165d[i11];
        long j12 = (j11 - jF) + ((long) this.f21761o);
        if (j12 < 0 || j12 >= PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
            thVar.f23379a = j11;
            return 1;
        }
        if (aVar.f21771a.f20493g == 1) {
            j12 += 8;
            i12 -= 8;
        }
        l8Var.a((int) j12);
        lo loVar = aVar.f21771a;
        if (loVar.f20496j == 0) {
            if ("audio/ac4".equals(loVar.f20492f.f18900m)) {
                if (this.f21762p == 0) {
                    n.a(i12, this.f21750d);
                    qoVar.a(this.f21750d, 7);
                    this.f21762p += 7;
                }
                i12 += 7;
            }
            while (true) {
                int i13 = this.f21762p;
                if (i13 >= i12) {
                    break;
                }
                int iA = qoVar.a((g5) l8Var, i12 - i13, false);
                this.f21761o += iA;
                this.f21762p += iA;
                this.f21763q -= iA;
            }
        } else {
            byte[] bArrC = this.f21749c.c();
            bArrC[0] = 0;
            bArrC[1] = 0;
            bArrC[2] = 0;
            int i14 = aVar.f21771a.f20496j;
            int i15 = 4 - i14;
            while (this.f21762p < i12) {
                int i16 = this.f21763q;
                if (i16 == 0) {
                    l8Var.d(bArrC, i15, i14);
                    this.f21761o += i14;
                    this.f21749c.f(0);
                    int iJ = this.f21749c.j();
                    if (iJ < 0) {
                        throw dh.a("Invalid NAL length", null);
                    }
                    this.f21763q = iJ;
                    this.f21748b.f(0);
                    qoVar.a(this.f21748b, 4);
                    this.f21762p += 4;
                    i12 += i15;
                } else {
                    int iA2 = qoVar.a((g5) l8Var, i16, false);
                    this.f21761o += iA2;
                    this.f21762p += iA2;
                    this.f21763q -= iA2;
                }
            }
        }
        int i17 = i12;
        ro roVar2 = aVar.f21772b;
        qoVar.a(roVar2.f22167f[i11], roVar2.f22168g[i11], i17, 0, null);
        aVar.f21774d++;
        this.f21760n = -1;
        this.f21761o = 0;
        this.f21762p = 0;
        this.f21763q = 0;
        return 0;
    }

    private static boolean c(int i11) {
        return i11 == 1835296868 || i11 == 1836476516 || i11 == 1751411826 || i11 == 1937011556 || i11 == 1937011827 || i11 == 1937011571 || i11 == 1668576371 || i11 == 1701606260 || i11 == 1937011555 || i11 == 1937011578 || i11 == 1937013298 || i11 == 1937007471 || i11 == 1668232756 || i11 == 1953196132 || i11 == 1718909296 || i11 == 1969517665 || i11 == 1801812339 || i11 == 1768715124;
    }

    private boolean c(l8 l8Var) throws dh {
        j1.a aVar;
        if (this.f21758l == 0) {
            if (!l8Var.a(this.f21751e.c(), 0, 8, true)) {
                g();
                return false;
            }
            this.f21758l = 8;
            this.f21751e.f(0);
            this.f21757k = this.f21751e.y();
            this.f21756j = this.f21751e.j();
        }
        long j11 = this.f21757k;
        if (j11 == 1) {
            l8Var.d(this.f21751e.c(), 8, 8);
            this.f21758l += 8;
            this.f21757k = this.f21751e.B();
        } else if (j11 == 0) {
            long jA = l8Var.a();
            if (jA == -1 && (aVar = (j1.a) this.f21752f.peek()) != null) {
                jA = aVar.f19808b;
            }
            if (jA != -1) {
                this.f21757k = (jA - l8Var.f()) + ((long) this.f21758l);
            }
        }
        if (this.f21757k < this.f21758l) {
            throw dh.a("Atom size less than header length (unsupported).");
        }
        if (b(this.f21756j)) {
            long jF = l8Var.f();
            long j12 = this.f21757k;
            long j13 = this.f21758l;
            long j14 = (jF + j12) - j13;
            if (j12 != j13 && this.f21756j == 1835365473) {
                b(l8Var);
            }
            this.f21752f.push(new j1.a(this.f21756j, j14));
            if (this.f21757k == this.f21758l) {
                d(j14);
            } else {
                e();
            }
        } else if (c(this.f21756j)) {
            b1.b(this.f21758l == 8);
            b1.b(this.f21757k <= 2147483647L);
            bh bhVar = new bh((int) this.f21757k);
            System.arraycopy(this.f21751e.c(), 0, bhVar.c(), 0, 8);
            this.f21759m = bhVar;
            this.f21755i = 1;
        } else {
            e(l8Var.f() - ((long) this.f21758l));
            this.f21759m = null;
            this.f21755i = 1;
        }
        return true;
    }

    private int d(l8 l8Var, th thVar) throws dh {
        int iA = this.f21753g.a(l8Var, thVar, this.f21754h);
        if (iA == 1 && thVar.f23379a == 0) {
            e();
        }
        return iA;
    }

    private void d(long j11) {
        while (!this.f21752f.isEmpty() && ((j1.a) this.f21752f.peek()).f19808b == j11) {
            j1.a aVar = (j1.a) this.f21752f.pop();
            if (aVar.f19807a == 1836019574) {
                a(aVar);
                this.f21752f.clear();
                this.f21755i = 2;
            } else if (!this.f21752f.isEmpty()) {
                ((j1.a) this.f21752f.peek()).a(aVar);
            }
        }
        if (this.f21755i != 2) {
            e();
        }
    }

    private void e() {
        this.f21755i = 0;
        this.f21758l = 0;
    }

    private void e(long j11) {
        if (this.f21756j == 1836086884) {
            long j12 = this.f21758l;
            this.f21770x = new nf(0L, j11, C.TIME_UNSET, j11 + j12, this.f21757k - j12);
        }
    }

    private void f(long j11) {
        for (a aVar : this.f21765s) {
            ro roVar = aVar.f21772b;
            int iA = roVar.a(j11);
            if (iA == -1) {
                iA = roVar.b(j11);
            }
            aVar.f21774d = iA;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ k8[] f() {
        return new k8[]{new pf()};
    }

    private void g() {
        if (this.f21769w != 2 || (this.f21747a & 2) == 0) {
            return;
        }
        m8 m8Var = (m8) b1.a(this.f21764r);
        m8Var.a(0, 4).a(new f9.b().a(this.f21770x == null ? null : new bf(this.f21770x)).a());
        m8Var.c();
        m8Var.a(new ij.b(C.TIME_UNSET));
    }

    @Override // com.applovin.impl.k8
    public int a(l8 l8Var, th thVar) {
        while (true) {
            int i11 = this.f21755i;
            if (i11 != 0) {
                if (i11 != 1) {
                    if (i11 == 2) {
                        return c(l8Var, thVar);
                    }
                    if (i11 == 3) {
                        return d(l8Var, thVar);
                    }
                    throw new IllegalStateException();
                }
                if (b(l8Var, thVar)) {
                    return 1;
                }
            } else if (!c(l8Var)) {
                return -1;
            }
        }
    }

    @Override // com.applovin.impl.k8
    public void a() {
    }

    @Override // com.applovin.impl.k8
    public void a(long j11, long j12) {
        this.f21752f.clear();
        this.f21758l = 0;
        this.f21760n = -1;
        this.f21761o = 0;
        this.f21762p = 0;
        this.f21763q = 0;
        if (j11 != 0) {
            if (this.f21765s != null) {
                f(j12);
            }
        } else if (this.f21755i != 3) {
            e();
        } else {
            this.f21753g.a();
            this.f21754h.clear();
        }
    }

    @Override // com.applovin.impl.k8
    public void a(m8 m8Var) {
        this.f21764r = m8Var;
    }

    @Override // com.applovin.impl.k8
    public boolean a(l8 l8Var) {
        return lk.a(l8Var, (this.f21747a & 2) != 0);
    }

    @Override // com.applovin.impl.ij
    public ij.a b(long j11) {
        long j12;
        long jA;
        long j13;
        long j14;
        int iB;
        if (((a[]) b1.a(this.f21765s)).length == 0) {
            return new ij.a(kj.f20255c);
        }
        int i11 = this.f21767u;
        if (i11 != -1) {
            ro roVar = this.f21765s[i11].f21772b;
            int iA = a(roVar, j11);
            if (iA == -1) {
                return new ij.a(kj.f20255c);
            }
            long j15 = roVar.f22167f[iA];
            j12 = roVar.f22164c[iA];
            if (j15 >= j11 || iA >= roVar.f22163b - 1 || (iB = roVar.b(j11)) == -1 || iB == iA) {
                j14 = -1;
                j13 = -9223372036854775807L;
            } else {
                j13 = roVar.f22167f[iB];
                j14 = roVar.f22164c[iB];
            }
            jA = j14;
            j11 = j15;
        } else {
            j12 = Long.MAX_VALUE;
            jA = -1;
            j13 = -9223372036854775807L;
        }
        int i12 = 0;
        while (true) {
            a[] aVarArr = this.f21765s;
            if (i12 >= aVarArr.length) {
                break;
            }
            if (i12 != this.f21767u) {
                ro roVar2 = aVarArr[i12].f21772b;
                long jA2 = a(roVar2, j11, j12);
                if (j13 != C.TIME_UNSET) {
                    jA = a(roVar2, j13, jA);
                }
                j12 = jA2;
            }
            i12++;
        }
        kj kjVar = new kj(j11, j12);
        return j13 == C.TIME_UNSET ? new ij.a(kjVar) : new ij.a(kjVar, new kj(j13, jA));
    }

    @Override // com.applovin.impl.ij
    public boolean b() {
        return true;
    }

    @Override // com.applovin.impl.ij
    public long d() {
        return this.f21768v;
    }
}
