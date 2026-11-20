package com.applovin.impl;

import android.net.Uri;
import android.util.Pair;
import android.util.SparseArray;
import com.applovin.exoplayer2.common.base.Ascii;
import com.applovin.exoplayer2.common.base.Function;
import com.google.android.gms.common.api.Api;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class j9 implements k8 {
    public static final o8 I = new o8() { // from class: com.applovin.impl.yy
        @Override // com.applovin.impl.o8
        public final k8[] a() {
            return j9.d();
        }

        @Override // com.applovin.impl.o8
        public /* synthetic */ k8[] a(Uri uri, Map map) {
            return q00.a(this, uri, map);
        }
    };
    private static final byte[] J = {-94, 57, 79, 82, 90, -101, 79, Ascii.DC4, -94, 68, 108, 66, 124, 100, -115, -12};
    private static final f9 K = new f9.b().f(MimeTypes.APPLICATION_EMSG).a();
    private int A;
    private int B;
    private int C;
    private boolean D;
    private m8 E;
    private qo[] F;
    private qo[] G;
    private boolean H;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f19877a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final lo f19878b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f19879c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final SparseArray f19880d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final bh f19881e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final bh f19882f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final bh f19883g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final byte[] f19884h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final bh f19885i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final ho f19886j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final y7 f19887k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final bh f19888l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final ArrayDeque f19889m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final ArrayDeque f19890n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final qo f19891o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f19892p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f19893q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private long f19894r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f19895s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private bh f19896t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private long f19897u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f19898v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private long f19899w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private long f19900x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private long f19901y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private b f19902z;

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f19903a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f19904b;

        public a(long j11, int i11) {
            this.f19903a = j11;
            this.f19904b = i11;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final qo f19905a;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public ro f19908d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public l6 f19909e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f19910f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f19911g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f19912h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f19913i;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private boolean f19916l;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final no f19906b = new no();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final bh f19907c = new bh();

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final bh f19914j = new bh(1);

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final bh f19915k = new bh();

        public b(qo qoVar, ro roVar, l6 l6Var) {
            this.f19905a = qoVar;
            this.f19908d = roVar;
            this.f19909e = l6Var;
            a(roVar, l6Var);
        }

        public int a() {
            int i11;
            if (this.f19916l) {
                i11 = this.f19906b.f21394l[this.f19910f] ? 1 : 0;
            } else {
                i11 = this.f19908d.f22168g[this.f19910f];
            }
            return e() != null ? i11 | 1073741824 : i11;
        }

        public int a(int i11, int i12) {
            bh bhVar;
            mo moVarE = e();
            if (moVarE == null) {
                return 0;
            }
            int length = moVarE.f21187d;
            if (length != 0) {
                bhVar = this.f19906b.f21398p;
            } else {
                byte[] bArr = (byte[]) xp.a((Object) moVarE.f21188e);
                this.f19915k.a(bArr, bArr.length);
                bh bhVar2 = this.f19915k;
                length = bArr.length;
                bhVar = bhVar2;
            }
            boolean zC = this.f19906b.c(this.f19910f);
            boolean z11 = zC || i12 != 0;
            this.f19914j.c()[0] = (byte) ((z11 ? 128 : 0) | length);
            this.f19914j.f(0);
            this.f19905a.a(this.f19914j, 1, 1);
            this.f19905a.a(bhVar, length, 1);
            if (!z11) {
                return length + 1;
            }
            if (!zC) {
                this.f19907c.d(8);
                byte[] bArrC = this.f19907c.c();
                bArrC[0] = 0;
                bArrC[1] = 1;
                bArrC[2] = (byte) ((i12 >> 8) & 255);
                bArrC[3] = (byte) (i12 & 255);
                bArrC[4] = (byte) ((i11 >> 24) & 255);
                bArrC[5] = (byte) ((i11 >> 16) & 255);
                bArrC[6] = (byte) ((i11 >> 8) & 255);
                bArrC[7] = (byte) (i11 & 255);
                this.f19905a.a(this.f19907c, 8, 1);
                return length + 9;
            }
            bh bhVar3 = this.f19906b.f21398p;
            int iC = bhVar3.C();
            bhVar3.g(-2);
            int i13 = (iC * 6) + 2;
            if (i12 != 0) {
                this.f19907c.d(i13);
                byte[] bArrC2 = this.f19907c.c();
                bhVar3.a(bArrC2, 0, i13);
                int i14 = (((bArrC2[2] & 255) << 8) | (bArrC2[3] & 255)) + i12;
                bArrC2[2] = (byte) ((i14 >> 8) & 255);
                bArrC2[3] = (byte) (i14 & 255);
                bhVar3 = this.f19907c;
            }
            this.f19905a.a(bhVar3, i13, 1);
            return length + 1 + i13;
        }

        public void a(long j11) {
            int i11 = this.f19910f;
            while (true) {
                no noVar = this.f19906b;
                if (i11 >= noVar.f21388f || noVar.a(i11) >= j11) {
                    return;
                }
                if (this.f19906b.f21394l[i11]) {
                    this.f19913i = i11;
                }
                i11++;
            }
        }

        public void a(ro roVar, l6 l6Var) {
            this.f19908d = roVar;
            this.f19909e = l6Var;
            this.f19905a.a(roVar.f22162a.f20492f);
            g();
        }

        public void a(y6 y6Var) {
            mo moVarA = this.f19908d.f22162a.a(((l6) xp.a(this.f19906b.f21383a)).f20358a);
            this.f19905a.a(this.f19908d.f22162a.f20492f.a().a(y6Var.a(moVarA != null ? moVarA.f21185b : null)).a());
        }

        public long b() {
            return !this.f19916l ? this.f19908d.f22164c[this.f19910f] : this.f19906b.f21389g[this.f19912h];
        }

        public long c() {
            return !this.f19916l ? this.f19908d.f22167f[this.f19910f] : this.f19906b.a(this.f19910f);
        }

        public int d() {
            return !this.f19916l ? this.f19908d.f22165d[this.f19910f] : this.f19906b.f21391i[this.f19910f];
        }

        public mo e() {
            if (!this.f19916l) {
                return null;
            }
            int i11 = ((l6) xp.a(this.f19906b.f21383a)).f20358a;
            mo moVarA = this.f19906b.f21397o;
            if (moVarA == null) {
                moVarA = this.f19908d.f22162a.a(i11);
            }
            if (moVarA == null || !moVarA.f21184a) {
                return null;
            }
            return moVarA;
        }

        public boolean f() {
            this.f19910f++;
            if (!this.f19916l) {
                return false;
            }
            int i11 = this.f19911g + 1;
            this.f19911g = i11;
            int[] iArr = this.f19906b.f21390h;
            int i12 = this.f19912h;
            if (i11 != iArr[i12]) {
                return true;
            }
            this.f19912h = i12 + 1;
            this.f19911g = 0;
            return false;
        }

        public void g() {
            this.f19906b.a();
            this.f19910f = 0;
            this.f19912h = 0;
            this.f19911g = 0;
            this.f19913i = 0;
            this.f19916l = false;
        }

        public void h() {
            mo moVarE = e();
            if (moVarE == null) {
                return;
            }
            bh bhVar = this.f19906b.f21398p;
            int i11 = moVarE.f21187d;
            if (i11 != 0) {
                bhVar.g(i11);
            }
            if (this.f19906b.c(this.f19910f)) {
                bhVar.g(bhVar.C() * 6);
            }
        }
    }

    public j9() {
        this(0);
    }

    public j9(int i11) {
        this(i11, null);
    }

    public j9(int i11, ho hoVar) {
        this(i11, hoVar, null, Collections.emptyList());
    }

    public j9(int i11, ho hoVar, lo loVar, List list) {
        this(i11, hoVar, loVar, list, null);
    }

    public j9(int i11, ho hoVar, lo loVar, List list, qo qoVar) {
        this.f19877a = i11;
        this.f19886j = hoVar;
        this.f19878b = loVar;
        this.f19879c = Collections.unmodifiableList(list);
        this.f19891o = qoVar;
        this.f19887k = new y7();
        this.f19888l = new bh(16);
        this.f19881e = new bh(zf.f24845a);
        this.f19882f = new bh(5);
        this.f19883g = new bh();
        byte[] bArr = new byte[16];
        this.f19884h = bArr;
        this.f19885i = new bh(bArr);
        this.f19889m = new ArrayDeque();
        this.f19890n = new ArrayDeque();
        this.f19880d = new SparseArray();
        this.f19900x = C.TIME_UNSET;
        this.f19899w = C.TIME_UNSET;
        this.f19901y = C.TIME_UNSET;
        this.E = m8.f20630e;
        this.F = new qo[0];
        this.G = new qo[0];
    }

    private static int a(int i11) throws dh {
        if (i11 >= 0) {
            return i11;
        }
        throw dh.a("Unexpected negative value: " + i11, null);
    }

    /* JADX WARN: Code duplicated, block: B:42:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:45:0x00bd A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:46:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:47:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:50:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:51:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:54:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:55:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:58:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:60:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:61:0x0110  */
    /* JADX WARN: Code duplicated, block: B:64:0x012d  */
    /* JADX WARN: Code duplicated, block: B:70:0x0142  */
    private static int a(b bVar, int i11, int i12, bh bhVar, int i13) throws dh {
        long j11;
        long jC;
        int[] iArr;
        int[] iArr2;
        long[] jArr;
        boolean[] zArr;
        boolean z11;
        int i14;
        long j12;
        long j13;
        long j14;
        int i15;
        int iJ;
        int iJ2;
        int iJ3;
        long jC2;
        boolean z12;
        b bVar2 = bVar;
        bhVar.f(8);
        int iB = j1.b(bhVar.j());
        lo loVar = bVar2.f19908d.f22162a;
        no noVar = bVar2.f19906b;
        l6 l6Var = (l6) xp.a(noVar.f21383a);
        noVar.f21390h[i11] = bhVar.A();
        long[] jArr2 = noVar.f21389g;
        long j15 = noVar.f21385c;
        jArr2[i11] = j15;
        if ((iB & 1) != 0) {
            jArr2[i11] = j15 + ((long) bhVar.j());
        }
        boolean z13 = (iB & 4) != 0;
        int iJ4 = l6Var.f20361d;
        if (z13) {
            iJ4 = bhVar.j();
        }
        boolean z14 = (iB & 256) != 0;
        boolean z15 = (iB & 512) != 0;
        boolean z16 = (iB & 1024) != 0;
        boolean z17 = (iB & 2048) != 0;
        long[] jArr3 = loVar.f20494h;
        if (jArr3 != null && jArr3.length == 1) {
            j11 = 0;
            if (jArr3[0] == 0) {
                jC = xp.c(((long[]) xp.a(loVar.f20495i))[0], 1000000L, loVar.f20489c);
            }
            iArr = noVar.f21391i;
            iArr2 = noVar.f21392j;
            jArr = noVar.f21393k;
            zArr = noVar.f21394l;
            int i16 = iJ4;
            if (loVar.f20488b == 2 || (i12 & 1) == 0) {
                z11 = false;
            } else {
                z11 = true;
            }
            i14 = i13 + noVar.f21390h[i11];
            boolean z18 = z11;
            j12 = loVar.f20489c;
            j13 = jC;
            j14 = noVar.f21400r;
            i15 = i13;
            while (i15 < i14) {
                if (z14) {
                    iJ = bhVar.j();
                } else {
                    iJ = l6Var.f20359b;
                }
                int iA = a(iJ);
                if (z15) {
                    iJ2 = bhVar.j();
                } else {
                    iJ2 = l6Var.f20360c;
                }
                int iA2 = a(iJ2);
                if (z16) {
                    iJ3 = bhVar.j();
                } else if (i15 == 0 || !z13) {
                    iJ3 = l6Var.f20361d;
                } else {
                    iJ3 = i16;
                }
                if (z17) {
                    iArr2[i15] = (int) ((((long) bhVar.j()) * 1000000) / j12);
                } else {
                    iArr2[i15] = 0;
                }
                jC2 = xp.c(j14, 1000000L, j12) - j13;
                jArr[i15] = jC2;
                if (!noVar.f21401s) {
                    jArr[i15] = jC2 + bVar2.f19908d.f22169h;
                }
                iArr[i15] = iA2;
                if (((iJ3 >> 16) & 1) == 0 || (z18 && i15 != 0)) {
                    z12 = false;
                } else {
                    z12 = true;
                }
                zArr[i15] = z12;
                j14 += (long) iA;
                i15++;
                bVar2 = bVar;
                z14 = z14;
                j12 = j12;
                z13 = z13;
                z17 = z17;
                z15 = z15;
                z16 = z16;
            }
            noVar.f21400r = j14;
            return i14;
        }
        j11 = 0;
        jC = j11;
        iArr = noVar.f21391i;
        iArr2 = noVar.f21392j;
        jArr = noVar.f21393k;
        zArr = noVar.f21394l;
        int i17 = iJ4;
        if (loVar.f20488b == 2) {
            z11 = false;
        } else {
            z11 = false;
        }
        i14 = i13 + noVar.f21390h[i11];
        boolean z19 = z11;
        j12 = loVar.f20489c;
        j13 = jC;
        j14 = noVar.f21400r;
        i15 = i13;
        while (i15 < i14) {
            if (z14) {
                iJ = bhVar.j();
            } else {
                iJ = l6Var.f20359b;
            }
            int iA3 = a(iJ);
            if (z15) {
                iJ2 = bhVar.j();
            } else {
                iJ2 = l6Var.f20360c;
            }
            int iA4 = a(iJ2);
            if (z16) {
                iJ3 = bhVar.j();
            } else if (i15 == 0) {
                iJ3 = l6Var.f20361d;
            } else {
                iJ3 = l6Var.f20361d;
            }
            if (z17) {
                iArr2[i15] = (int) ((((long) bhVar.j()) * 1000000) / j12);
            } else {
                iArr2[i15] = 0;
            }
            jC2 = xp.c(j14, 1000000L, j12) - j13;
            jArr[i15] = jC2;
            if (!noVar.f21401s) {
                jArr[i15] = jC2 + bVar2.f19908d.f22169h;
            }
            iArr[i15] = iA4;
            if (((iJ3 >> 16) & 1) == 0) {
                z12 = false;
            } else {
                z12 = false;
            }
            zArr[i15] = z12;
            j14 += (long) iA3;
            i15++;
            bVar2 = bVar;
            z14 = z14;
            j12 = j12;
            z13 = z13;
            z17 = z17;
            z15 = z15;
            z16 = z16;
        }
        noVar.f21400r = j14;
        return i14;
    }

    private static Pair a(bh bhVar, long j11) throws dh {
        long jB;
        long jB2;
        bhVar.f(8);
        int iC = j1.c(bhVar.j());
        bhVar.g(4);
        long jY = bhVar.y();
        if (iC == 0) {
            jB = bhVar.y();
            jB2 = bhVar.y();
        } else {
            jB = bhVar.B();
            jB2 = bhVar.B();
        }
        long j12 = jB;
        long j13 = j11 + jB2;
        long jC = xp.c(j12, 1000000L, jY);
        bhVar.g(2);
        int iC2 = bhVar.C();
        int[] iArr = new int[iC2];
        long[] jArr = new long[iC2];
        long[] jArr2 = new long[iC2];
        long[] jArr3 = new long[iC2];
        long j14 = j12;
        long j15 = jC;
        int i11 = 0;
        while (i11 < iC2) {
            int iJ = bhVar.j();
            if ((iJ & Integer.MIN_VALUE) != 0) {
                throw dh.a("Unhandled indirect reference", null);
            }
            long jY2 = bhVar.y();
            iArr[i11] = iJ & Api.BaseClientBuilder.API_PRIORITY_OTHER;
            jArr[i11] = j13;
            jArr3[i11] = j15;
            long j16 = j14 + jY2;
            long[] jArr4 = jArr2;
            long[] jArr5 = jArr3;
            int i12 = iC2;
            int[] iArr2 = iArr;
            long jC2 = xp.c(j16, 1000000L, jY);
            jArr4[i11] = jC2 - jArr5[i11];
            bhVar.g(4);
            j13 += (long) iArr2[i11];
            i11++;
            iArr = iArr2;
            jArr3 = jArr5;
            jArr2 = jArr4;
            jArr = jArr;
            iC2 = i12;
            j14 = j16;
            j15 = jC2;
        }
        return Pair.create(Long.valueOf(jC), new g3(iArr, jArr, jArr2, jArr3));
    }

    private static b a(SparseArray sparseArray) {
        int size = sparseArray.size();
        b bVar = null;
        long j11 = Long.MAX_VALUE;
        for (int i11 = 0; i11 < size; i11++) {
            b bVar2 = (b) sparseArray.valueAt(i11);
            if ((bVar2.f19916l || bVar2.f19910f != bVar2.f19908d.f22163b) && (!bVar2.f19916l || bVar2.f19912h != bVar2.f19906b.f21387e)) {
                long jB = bVar2.b();
                if (jB < j11) {
                    bVar = bVar2;
                    j11 = jB;
                }
            }
        }
        return bVar;
    }

    private static b a(bh bhVar, SparseArray sparseArray, boolean z11) {
        bhVar.f(8);
        int iB = j1.b(bhVar.j());
        b bVar = (b) (z11 ? sparseArray.valueAt(0) : sparseArray.get(bhVar.j()));
        if (bVar == null) {
            return null;
        }
        if ((iB & 1) != 0) {
            long jB = bhVar.B();
            no noVar = bVar.f19906b;
            noVar.f21385c = jB;
            noVar.f21386d = jB;
        }
        l6 l6Var = bVar.f19909e;
        bVar.f19906b.f21383a = new l6((iB & 2) != 0 ? bhVar.j() - 1 : l6Var.f20358a, (iB & 8) != 0 ? bhVar.j() : l6Var.f20359b, (iB & 16) != 0 ? bhVar.j() : l6Var.f20360c, (iB & 32) != 0 ? bhVar.j() : l6Var.f20361d);
        return bVar;
    }

    private l6 a(SparseArray sparseArray, int i11) {
        return sparseArray.size() == 1 ? (l6) sparseArray.valueAt(0) : (l6) b1.a((l6) sparseArray.get(i11));
    }

    private static y6 a(List list) {
        int size = list.size();
        ArrayList arrayList = null;
        for (int i11 = 0; i11 < size; i11++) {
            j1.b bVar = (j1.b) list.get(i11);
            if (bVar.f19807a == 1886614376) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                byte[] bArrC = bVar.f19811b.c();
                UUID uuidC = ji.c(bArrC);
                if (uuidC == null) {
                    pc.d("FragmentedMp4Extractor", "Skipped pssh atom (failed to extract uuid)");
                } else {
                    arrayList.add(new y6.b(uuidC, MimeTypes.VIDEO_MP4, bArrC));
                }
            }
        }
        if (arrayList == null) {
            return null;
        }
        return new y6(arrayList);
    }

    private void a(long j11) {
        while (!this.f19890n.isEmpty()) {
            a aVar = (a) this.f19890n.removeFirst();
            this.f19898v -= aVar.f19904b;
            long jA = aVar.f19903a + j11;
            ho hoVar = this.f19886j;
            if (hoVar != null) {
                jA = hoVar.a(jA);
            }
            for (qo qoVar : this.F) {
                qoVar.a(jA, 1, aVar.f19904b, this.f19898v, null);
            }
        }
    }

    private void a(bh bhVar) {
        long jC;
        String str;
        long jC2;
        String str2;
        long jY;
        long jA;
        if (this.F.length == 0) {
            return;
        }
        bhVar.f(8);
        int iC = j1.c(bhVar.j());
        if (iC == 0) {
            String str3 = (String) b1.a((Object) bhVar.t());
            String str4 = (String) b1.a((Object) bhVar.t());
            long jY2 = bhVar.y();
            jC = xp.c(bhVar.y(), 1000000L, jY2);
            long j11 = this.f19901y;
            long j12 = j11 != C.TIME_UNSET ? j11 + jC : -9223372036854775807L;
            str = str3;
            jC2 = xp.c(bhVar.y(), 1000L, jY2);
            str2 = str4;
            jY = bhVar.y();
            jA = j12;
        } else {
            if (iC != 1) {
                pc.d("FragmentedMp4Extractor", "Skipping unsupported emsg version: " + iC);
                return;
            }
            long jY3 = bhVar.y();
            jA = xp.c(bhVar.B(), 1000000L, jY3);
            long jC3 = xp.c(bhVar.y(), 1000L, jY3);
            long jY4 = bhVar.y();
            str = (String) b1.a((Object) bhVar.t());
            jC2 = jC3;
            jY = jY4;
            str2 = (String) b1.a((Object) bhVar.t());
            jC = -9223372036854775807L;
        }
        byte[] bArr = new byte[bhVar.a()];
        bhVar.a(bArr, 0, bhVar.a());
        bh bhVar2 = new bh(this.f19887k.a(new w7(str, str2, jC2, jY, bArr)));
        int iA = bhVar2.a();
        for (qo qoVar : this.F) {
            bhVar2.f(0);
            qoVar.a(bhVar2, iA);
        }
        if (jA == C.TIME_UNSET) {
            this.f19890n.addLast(new a(jC, iA));
            this.f19898v += iA;
            return;
        }
        ho hoVar = this.f19886j;
        if (hoVar != null) {
            jA = hoVar.a(jA);
        }
        for (qo qoVar2 : this.F) {
            qoVar2.a(jA, 1, iA, 0, null);
        }
    }

    private static void a(bh bhVar, int i11, no noVar) throws dh {
        bhVar.f(i11 + 8);
        int iB = j1.b(bhVar.j());
        if ((iB & 1) != 0) {
            throw dh.a("Overriding TrackEncryptionBox parameters is unsupported.");
        }
        boolean z11 = (iB & 2) != 0;
        int iA = bhVar.A();
        if (iA == 0) {
            Arrays.fill(noVar.f21396n, 0, noVar.f21388f, false);
            return;
        }
        if (iA == noVar.f21388f) {
            Arrays.fill(noVar.f21396n, 0, iA, z11);
            noVar.b(bhVar.a());
            noVar.a(bhVar);
        } else {
            throw dh.a("Senc sample count " + iA + " is different from fragment sample count" + noVar.f21388f, null);
        }
    }

    private static void a(bh bhVar, no noVar) throws dh {
        bhVar.f(8);
        int iJ = bhVar.j();
        if ((j1.b(iJ) & 1) == 1) {
            bhVar.g(8);
        }
        int iA = bhVar.A();
        if (iA == 1) {
            noVar.f21386d += j1.c(iJ) == 0 ? bhVar.y() : bhVar.B();
        } else {
            throw dh.a("Unexpected saio entry count: " + iA, null);
        }
    }

    private static void a(bh bhVar, no noVar, byte[] bArr) throws dh {
        bhVar.f(8);
        bhVar.a(bArr, 0, 16);
        if (Arrays.equals(bArr, J)) {
            a(bhVar, 16, noVar);
        }
    }

    private void a(j1.a aVar) throws dh {
        int i11 = aVar.f19807a;
        if (i11 == 1836019574) {
            c(aVar);
        } else if (i11 == 1836019558) {
            b(aVar);
        } else {
            if (this.f19889m.isEmpty()) {
                return;
            }
            ((j1.a) this.f19889m.peek()).a(aVar);
        }
    }

    private static void a(j1.a aVar, SparseArray sparseArray, boolean z11, int i11, byte[] bArr) throws dh {
        int size = aVar.f19810d.size();
        for (int i12 = 0; i12 < size; i12++) {
            j1.a aVar2 = (j1.a) aVar.f19810d.get(i12);
            if (aVar2.f19807a == 1953653094) {
                b(aVar2, sparseArray, z11, i11, bArr);
            }
        }
    }

    private static void a(j1.a aVar, b bVar, int i11) throws dh {
        List list = aVar.f19809c;
        int size = list.size();
        int i12 = 0;
        int i13 = 0;
        for (int i14 = 0; i14 < size; i14++) {
            j1.b bVar2 = (j1.b) list.get(i14);
            if (bVar2.f19807a == 1953658222) {
                bh bhVar = bVar2.f19811b;
                bhVar.f(12);
                int iA = bhVar.A();
                if (iA > 0) {
                    i13 += iA;
                    i12++;
                }
            }
        }
        bVar.f19912h = 0;
        bVar.f19911g = 0;
        bVar.f19910f = 0;
        bVar.f19906b.a(i12, i13);
        int i15 = 0;
        int iA2 = 0;
        for (int i16 = 0; i16 < size; i16++) {
            j1.b bVar3 = (j1.b) list.get(i16);
            if (bVar3.f19807a == 1953658222) {
                iA2 = a(bVar, i15, i11, bVar3.f19811b, iA2);
                i15++;
            }
        }
    }

    private static void a(j1.a aVar, String str, no noVar) throws dh {
        byte[] bArr = null;
        bh bhVar = null;
        bh bhVar2 = null;
        for (int i11 = 0; i11 < aVar.f19809c.size(); i11++) {
            j1.b bVar = (j1.b) aVar.f19809c.get(i11);
            bh bhVar3 = bVar.f19811b;
            int i12 = bVar.f19807a;
            if (i12 == 1935828848) {
                bhVar3.f(12);
                if (bhVar3.j() == 1936025959) {
                    bhVar = bhVar3;
                }
            } else if (i12 == 1936158820) {
                bhVar3.f(12);
                if (bhVar3.j() == 1936025959) {
                    bhVar2 = bhVar3;
                }
            }
        }
        if (bhVar == null || bhVar2 == null) {
            return;
        }
        bhVar.f(8);
        int iC = j1.c(bhVar.j());
        bhVar.g(4);
        if (iC == 1) {
            bhVar.g(4);
        }
        if (bhVar.j() != 1) {
            throw dh.a("Entry count in sbgp != 1 (unsupported).");
        }
        bhVar2.f(8);
        int iC2 = j1.c(bhVar2.j());
        bhVar2.g(4);
        if (iC2 == 1) {
            if (bhVar2.y() == 0) {
                throw dh.a("Variable length description in sgpd found (unsupported)");
            }
        } else if (iC2 >= 2) {
            bhVar2.g(4);
        }
        if (bhVar2.y() != 1) {
            throw dh.a("Entry count in sgpd != 1 (unsupported).");
        }
        bhVar2.g(1);
        int iW = bhVar2.w();
        int i13 = (iW & 240) >> 4;
        int i14 = iW & 15;
        boolean z11 = bhVar2.w() == 1;
        if (z11) {
            int iW2 = bhVar2.w();
            byte[] bArr2 = new byte[16];
            bhVar2.a(bArr2, 0, 16);
            if (iW2 == 0) {
                int iW3 = bhVar2.w();
                bArr = new byte[iW3];
                bhVar2.a(bArr, 0, iW3);
            }
            noVar.f21395m = true;
            noVar.f21397o = new mo(z11, str, iW2, bArr2, i13, i14, bArr);
        }
    }

    private void a(j1.b bVar, long j11) throws dh {
        if (!this.f19889m.isEmpty()) {
            ((j1.a) this.f19889m.peek()).a(bVar);
            return;
        }
        int i11 = bVar.f19807a;
        if (i11 != 1936286840) {
            if (i11 == 1701671783) {
                a(bVar.f19811b);
            }
        } else {
            Pair pairA = a(bVar.f19811b, j11);
            this.f19901y = ((Long) pairA.first).longValue();
            this.E.a((ij) pairA.second);
            this.H = true;
        }
    }

    private static void a(mo moVar, bh bhVar, no noVar) throws dh {
        int i11;
        int i12 = moVar.f21187d;
        bhVar.f(8);
        if ((j1.b(bhVar.j()) & 1) == 1) {
            bhVar.g(8);
        }
        int iW = bhVar.w();
        int iA = bhVar.A();
        if (iA > noVar.f21388f) {
            throw dh.a("Saiz sample count " + iA + " is greater than fragment sample count" + noVar.f21388f, null);
        }
        if (iW == 0) {
            boolean[] zArr = noVar.f21396n;
            i11 = 0;
            for (int i13 = 0; i13 < iA; i13++) {
                int iW2 = bhVar.w();
                i11 += iW2;
                zArr[i13] = iW2 > i12;
            }
        } else {
            i11 = iW * iA;
            Arrays.fill(noVar.f21396n, 0, iA, iW > i12);
        }
        Arrays.fill(noVar.f21396n, iA, noVar.f21388f, false);
        if (i11 > 0) {
            noVar.b(i11);
        }
    }

    private static long b(bh bhVar) {
        bhVar.f(8);
        return j1.c(bhVar.j()) == 0 ? bhVar.y() : bhVar.B();
    }

    private void b() {
        this.f19892p = 0;
        this.f19895s = 0;
    }

    private void b(long j11) throws dh {
        while (!this.f19889m.isEmpty() && ((j1.a) this.f19889m.peek()).f19808b == j11) {
            a((j1.a) this.f19889m.pop());
        }
        b();
    }

    private static void b(bh bhVar, no noVar) throws dh {
        a(bhVar, 0, noVar);
    }

    private void b(j1.a aVar) throws dh {
        a(aVar, this.f19880d, this.f19878b != null, this.f19877a, this.f19884h);
        y6 y6VarA = a(aVar.f19809c);
        if (y6VarA != null) {
            int size = this.f19880d.size();
            for (int i11 = 0; i11 < size; i11++) {
                ((b) this.f19880d.valueAt(i11)).a(y6VarA);
            }
        }
        if (this.f19899w != C.TIME_UNSET) {
            int size2 = this.f19880d.size();
            for (int i12 = 0; i12 < size2; i12++) {
                ((b) this.f19880d.valueAt(i12)).a(this.f19899w);
            }
            this.f19899w = C.TIME_UNSET;
        }
    }

    private static void b(j1.a aVar, SparseArray sparseArray, boolean z11, int i11, byte[] bArr) throws dh {
        b bVarA = a(((j1.b) b1.a(aVar.e(1952868452))).f19811b, sparseArray, z11);
        if (bVarA == null) {
            return;
        }
        no noVar = bVarA.f19906b;
        long j11 = noVar.f21400r;
        boolean z12 = noVar.f21401s;
        bVarA.g();
        bVarA.f19916l = true;
        j1.b bVarE = aVar.e(1952867444);
        if (bVarE == null || (i11 & 2) != 0) {
            noVar.f21400r = j11;
            noVar.f21401s = z12;
        } else {
            noVar.f21400r = c(bVarE.f19811b);
            noVar.f21401s = true;
        }
        a(aVar, bVarA, i11);
        mo moVarA = bVarA.f19908d.f22162a.a(((l6) b1.a(noVar.f21383a)).f20358a);
        j1.b bVarE2 = aVar.e(1935763834);
        if (bVarE2 != null) {
            a((mo) b1.a(moVarA), bVarE2.f19811b, noVar);
        }
        j1.b bVarE3 = aVar.e(1935763823);
        if (bVarE3 != null) {
            a(bVarE3.f19811b, noVar);
        }
        j1.b bVarE4 = aVar.e(1936027235);
        if (bVarE4 != null) {
            b(bVarE4.f19811b, noVar);
        }
        a(aVar, moVarA != null ? moVarA.f21185b : null, noVar);
        int size = aVar.f19809c.size();
        for (int i12 = 0; i12 < size; i12++) {
            j1.b bVar = (j1.b) aVar.f19809c.get(i12);
            if (bVar.f19807a == 1970628964) {
                a(bVar.f19811b, noVar, bArr);
            }
        }
    }

    private static boolean b(int i11) {
        return i11 == 1836019574 || i11 == 1953653099 || i11 == 1835297121 || i11 == 1835626086 || i11 == 1937007212 || i11 == 1836019558 || i11 == 1953653094 || i11 == 1836475768 || i11 == 1701082227;
    }

    private boolean b(l8 l8Var) throws dh {
        if (this.f19895s == 0) {
            if (!l8Var.a(this.f19888l.c(), 0, 8, true)) {
                return false;
            }
            this.f19895s = 8;
            this.f19888l.f(0);
            this.f19894r = this.f19888l.y();
            this.f19893q = this.f19888l.j();
        }
        long j11 = this.f19894r;
        if (j11 == 1) {
            l8Var.d(this.f19888l.c(), 8, 8);
            this.f19895s += 8;
            this.f19894r = this.f19888l.B();
        } else if (j11 == 0) {
            long jA = l8Var.a();
            if (jA == -1 && !this.f19889m.isEmpty()) {
                jA = ((j1.a) this.f19889m.peek()).f19808b;
            }
            if (jA != -1) {
                this.f19894r = (jA - l8Var.f()) + ((long) this.f19895s);
            }
        }
        if (this.f19894r < this.f19895s) {
            throw dh.a("Atom size less than header length (unsupported).");
        }
        long jF = l8Var.f() - ((long) this.f19895s);
        int i11 = this.f19893q;
        if ((i11 == 1836019558 || i11 == 1835295092) && !this.H) {
            this.E.a(new ij.b(this.f19900x, jF));
            this.H = true;
        }
        if (this.f19893q == 1836019558) {
            int size = this.f19880d.size();
            for (int i12 = 0; i12 < size; i12++) {
                no noVar = ((b) this.f19880d.valueAt(i12)).f19906b;
                noVar.f21384b = jF;
                noVar.f21386d = jF;
                noVar.f21385c = jF;
            }
        }
        int i13 = this.f19893q;
        if (i13 == 1835295092) {
            this.f19902z = null;
            this.f19897u = jF + this.f19894r;
            this.f19892p = 2;
            return true;
        }
        if (b(i13)) {
            long jF2 = (l8Var.f() + this.f19894r) - 8;
            this.f19889m.push(new j1.a(this.f19893q, jF2));
            if (this.f19894r == this.f19895s) {
                b(jF2);
            } else {
                b();
            }
        } else if (c(this.f19893q)) {
            if (this.f19895s != 8) {
                throw dh.a("Leaf atom defines extended atom size (unsupported).");
            }
            long j12 = this.f19894r;
            if (j12 > 2147483647L) {
                throw dh.a("Leaf atom with length > 2147483647 (unsupported).");
            }
            bh bhVar = new bh((int) j12);
            System.arraycopy(this.f19888l.c(), 0, bhVar.c(), 0, 8);
            this.f19896t = bhVar;
            this.f19892p = 1;
        } else {
            if (this.f19894r > 2147483647L) {
                throw dh.a("Skipping atom with length > 2147483647 (unsupported).");
            }
            this.f19896t = null;
            this.f19892p = 1;
        }
        return true;
    }

    private static long c(bh bhVar) {
        bhVar.f(8);
        return j1.c(bhVar.j()) == 1 ? bhVar.B() : bhVar.y();
    }

    private void c() {
        int i11;
        qo[] qoVarArr = new qo[2];
        this.F = qoVarArr;
        qo qoVar = this.f19891o;
        int i12 = 0;
        if (qoVar != null) {
            qoVarArr[0] = qoVar;
            i11 = 1;
        } else {
            i11 = 0;
        }
        int i13 = 100;
        if ((this.f19877a & 4) != 0) {
            qoVarArr[i11] = this.E.a(100, 5);
            i13 = 101;
            i11++;
        }
        qo[] qoVarArr2 = (qo[]) xp.a(this.F, i11);
        this.F = qoVarArr2;
        for (qo qoVar2 : qoVarArr2) {
            qoVar2.a(K);
        }
        this.G = new qo[this.f19879c.size()];
        while (i12 < this.G.length) {
            qo qoVarA = this.E.a(i13, 3);
            qoVarA.a((f9) this.f19879c.get(i12));
            this.G[i12] = qoVarA;
            i12++;
            i13++;
        }
    }

    private void c(j1.a aVar) {
        int i11 = 0;
        b1.b(this.f19878b == null, "Unexpected moov box.");
        y6 y6VarA = a(aVar.f19809c);
        j1.a aVar2 = (j1.a) b1.a(aVar.d(1836475768));
        SparseArray sparseArray = new SparseArray();
        int size = aVar2.f19809c.size();
        long jB = -9223372036854775807L;
        for (int i12 = 0; i12 < size; i12++) {
            j1.b bVar = (j1.b) aVar2.f19809c.get(i12);
            int i13 = bVar.f19807a;
            if (i13 == 1953654136) {
                Pair pairD = d(bVar.f19811b);
                sparseArray.put(((Integer) pairD.first).intValue(), (l6) pairD.second);
            } else if (i13 == 1835362404) {
                jB = b(bVar.f19811b);
            }
        }
        List listA = k1.a(aVar, new z9(), jB, y6VarA, (this.f19877a & 16) != 0, false, new Function() { // from class: com.applovin.impl.xy
            @Override // com.applovin.exoplayer2.common.base.Function
            public final Object apply(Object obj) {
                return this.f24426a.a((lo) obj);
            }
        });
        int size2 = listA.size();
        if (this.f19880d.size() != 0) {
            b1.b(this.f19880d.size() == size2);
            while (i11 < size2) {
                ro roVar = (ro) listA.get(i11);
                lo loVar = roVar.f22162a;
                ((b) this.f19880d.get(loVar.f20487a)).a(roVar, a(sparseArray, loVar.f20487a));
                i11++;
            }
            return;
        }
        while (i11 < size2) {
            ro roVar2 = (ro) listA.get(i11);
            lo loVar2 = roVar2.f22162a;
            this.f19880d.put(loVar2.f20487a, new b(this.E.a(i11, loVar2.f20488b), roVar2, a(sparseArray, loVar2.f20487a)));
            this.f19900x = Math.max(this.f19900x, loVar2.f20491e);
            i11++;
        }
        this.E.c();
    }

    private void c(l8 l8Var) throws dh {
        int i11 = ((int) this.f19894r) - this.f19895s;
        bh bhVar = this.f19896t;
        if (bhVar != null) {
            l8Var.d(bhVar.c(), 8, i11);
            a(new j1.b(this.f19893q, bhVar), l8Var.f());
        } else {
            l8Var.a(i11);
        }
        b(l8Var.f());
    }

    private static boolean c(int i11) {
        return i11 == 1751411826 || i11 == 1835296868 || i11 == 1836476516 || i11 == 1936286840 || i11 == 1937011556 || i11 == 1937011827 || i11 == 1668576371 || i11 == 1937011555 || i11 == 1937011578 || i11 == 1937013298 || i11 == 1937007471 || i11 == 1668232756 || i11 == 1937011571 || i11 == 1952867444 || i11 == 1952868452 || i11 == 1953196132 || i11 == 1953654136 || i11 == 1953658222 || i11 == 1886614376 || i11 == 1935763834 || i11 == 1935763823 || i11 == 1936027235 || i11 == 1970628964 || i11 == 1935828848 || i11 == 1936158820 || i11 == 1701606260 || i11 == 1835362404 || i11 == 1701671783;
    }

    private static Pair d(bh bhVar) {
        bhVar.f(12);
        return Pair.create(Integer.valueOf(bhVar.j()), new l6(bhVar.j() - 1, bhVar.j(), bhVar.j(), bhVar.j()));
    }

    private void d(l8 l8Var) throws dh {
        int size = this.f19880d.size();
        long j11 = Long.MAX_VALUE;
        b bVar = null;
        for (int i11 = 0; i11 < size; i11++) {
            no noVar = ((b) this.f19880d.valueAt(i11)).f19906b;
            if (noVar.f21399q) {
                long j12 = noVar.f21386d;
                if (j12 < j11) {
                    bVar = (b) this.f19880d.valueAt(i11);
                    j11 = j12;
                }
            }
        }
        if (bVar == null) {
            this.f19892p = 3;
            return;
        }
        int iF = (int) (j11 - l8Var.f());
        if (iF < 0) {
            throw dh.a("Offset to encryption data was negative.", null);
        }
        l8Var.a(iF);
        bVar.f19906b.a(l8Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ k8[] d() {
        return new k8[]{new j9()};
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
    private boolean e(l8 l8Var) throws dh {
        int iA;
        b bVarA = this.f19902z;
        Throwable th2 = null;
        if (bVarA == null) {
            bVarA = a(this.f19880d);
            if (bVarA == null) {
                int iF = (int) (this.f19897u - l8Var.f());
                if (iF < 0) {
                    throw dh.a("Offset to end of mdat was negative.", null);
                }
                l8Var.a(iF);
                b();
                return false;
            }
            int iB = (int) (bVarA.b() - l8Var.f());
            if (iB < 0) {
                pc.d("FragmentedMp4Extractor", "Ignoring negative offset to sample data.");
                iB = 0;
            }
            l8Var.a(iB);
            this.f19902z = bVarA;
        }
        int i11 = 4;
        int i12 = 1;
        if (this.f19892p == 3) {
            int iD = bVarA.d();
            this.A = iD;
            if (bVarA.f19910f < bVarA.f19913i) {
                l8Var.a(iD);
                bVarA.h();
                if (!bVarA.f()) {
                    this.f19902z = null;
                }
                this.f19892p = 3;
                return true;
            }
            if (bVarA.f19908d.f22162a.f20493g == 1) {
                this.A = iD - 8;
                l8Var.a(8);
            }
            if ("audio/ac4".equals(bVarA.f19908d.f22162a.f20492f.f18900m)) {
                this.B = bVarA.a(this.A, 7);
                n.a(this.A, this.f19885i);
                bVarA.f19905a.a(this.f19885i, 7);
                this.B += 7;
            } else {
                this.B = bVarA.a(this.A, 0);
            }
            this.A += this.B;
            this.f19892p = 4;
            this.C = 0;
        }
        lo loVar = bVarA.f19908d.f22162a;
        qo qoVar = bVarA.f19905a;
        long jC = bVarA.c();
        ho hoVar = this.f19886j;
        if (hoVar != null) {
            jC = hoVar.a(jC);
        }
        long j11 = jC;
        if (loVar.f20496j == 0) {
            while (true) {
                int i13 = this.B;
                int i14 = this.A;
                if (i13 >= i14) {
                    break;
                }
                this.B += qoVar.a((g5) l8Var, i14 - i13, false);
            }
        } else {
            byte[] bArrC = this.f19882f.c();
            bArrC[0] = 0;
            bArrC[1] = 0;
            bArrC[2] = 0;
            int i15 = loVar.f20496j;
            int i16 = i15 + 1;
            int i17 = 4 - i15;
            while (this.B < this.A) {
                int i18 = this.C;
                if (i18 == 0) {
                    l8Var.d(bArrC, i17, i16);
                    this.f19882f.f(0);
                    int iJ = this.f19882f.j();
                    if (iJ < i12) {
                        throw dh.a("Invalid NAL length", th2);
                    }
                    this.C = iJ - 1;
                    this.f19881e.f(0);
                    qoVar.a(this.f19881e, i11);
                    qoVar.a(this.f19882f, i12);
                    this.D = this.G.length > 0 && zf.a(loVar.f20492f.f18900m, bArrC[i11]);
                    this.B += 5;
                    this.A += i17;
                } else {
                    if (this.D) {
                        this.f19883g.d(i18);
                        l8Var.d(this.f19883g.c(), 0, this.C);
                        qoVar.a(this.f19883g, this.C);
                        iA = this.C;
                        int iC = zf.c(this.f19883g.c(), this.f19883g.e());
                        this.f19883g.f(MimeTypes.VIDEO_H265.equals(loVar.f20492f.f18900m) ? 1 : 0);
                        this.f19883g.e(iC);
                        c3.a(j11, this.f19883g, this.G);
                    } else {
                        iA = qoVar.a((g5) l8Var, i18, false);
                    }
                    this.B += iA;
                    this.C -= iA;
                    th2 = null;
                    i11 = 4;
                    i12 = 1;
                }
            }
        }
        int iA2 = bVarA.a();
        mo moVarE = bVarA.e();
        qoVar.a(j11, iA2, this.A, 0, moVarE != null ? moVarE.f21186c : null);
        a(j11);
        if (!bVarA.f()) {
            this.f19902z = null;
        }
        this.f19892p = 3;
        return true;
    }

    @Override // com.applovin.impl.k8
    public int a(l8 l8Var, th thVar) throws dh {
        while (true) {
            int i11 = this.f19892p;
            if (i11 != 0) {
                if (i11 == 1) {
                    c(l8Var);
                } else if (i11 == 2) {
                    d(l8Var);
                } else if (e(l8Var)) {
                    return 0;
                }
            } else if (!b(l8Var)) {
                return -1;
            }
        }
    }

    public lo a(lo loVar) {
        return loVar;
    }

    @Override // com.applovin.impl.k8
    public void a() {
    }

    @Override // com.applovin.impl.k8
    public void a(long j11, long j12) {
        int size = this.f19880d.size();
        for (int i11 = 0; i11 < size; i11++) {
            ((b) this.f19880d.valueAt(i11)).g();
        }
        this.f19890n.clear();
        this.f19898v = 0;
        this.f19899w = j12;
        this.f19889m.clear();
        b();
    }

    @Override // com.applovin.impl.k8
    public void a(m8 m8Var) {
        this.E = m8Var;
        b();
        c();
        lo loVar = this.f19878b;
        if (loVar != null) {
            this.f19880d.put(0, new b(m8Var.a(0, loVar.f20488b), new ro(this.f19878b, new long[0], new int[0], 0, new long[0], new int[0], 0L), new l6(0, 0, 0, 0)));
            this.E.c();
        }
    }

    @Override // com.applovin.impl.k8
    public boolean a(l8 l8Var) {
        return lk.a(l8Var);
    }
}
