package i30;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.google.android.gms.common.api.Api;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import org.mvel2.asm.MethodTooLargeException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class s extends r {

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static final int[] f67030c0 = {0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 2, 2, 1, 1, 1, 0, 0, 1, 2, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, -1, 0, -1, -1, -1, -1, -1, -2, -1, -2, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -3, -4, -3, -4, -3, -3, -3, -3, -1, -2, 1, 1, 1, 2, 2, 2, 0, -1, -2, -1, -2, -1, -2, -1, -2, -1, -2, -1, -2, -1, -2, -1, -2, -1, -2, -1, -2, 0, 0, 0, 0, -1, -1, -1, -1, -1, -1, -1, -2, -1, -2, -1, -2, 0, 1, 0, 1, -1, -1, 0, 0, 1, 1, -1, 0, -1, 0, 0, 0, -3, -1, -1, -3, -3, -1, -1, -1, -1, -1, -1, -2, -2, -2, -2, -2, -2, -2, -2, 0, 1, 0, -1, -1, -1, -2, -1, -2, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, -1, -1, 0, 0, -1, -1, 0, 0};
    public final int A;
    public b B;
    public b C;
    public int D;
    public b[] E;
    public int F;
    public b[] G;
    public b H;
    public b I;
    public d J;
    public int K;
    public d L;
    public c M;
    public final int N;
    public q O;
    public q P;
    public q Q;
    public int R;
    public int S;
    public int T;
    public int U;
    public int[] V;
    public int[] W;
    public boolean X;
    public boolean Y;
    public int Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public int f67031a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public int f67032b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final x f67033c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f67034d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f67035e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f67036f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f67037g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f67038h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f67039i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f67040j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final d f67041k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public p f67042l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public p f67043m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f67044n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public d f67045o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f67046p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public d f67047q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f67048r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public d f67049s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f67050t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public d f67051u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public b f67052v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public b f67053w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public c f67054x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f67055y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final int[] f67056z;

    public s(x xVar, int i11, String str, String str2, String str3, String[] strArr, int i12) {
        super(458752);
        this.f67041k = new d();
        this.f67033c = xVar;
        this.f67034d = "<init>".equals(str) ? 262144 | i11 : i11;
        this.f67035e = xVar.D(str);
        this.f67036f = str;
        this.f67037g = xVar.D(str2);
        this.f67038h = str2;
        this.A = str3 == null ? 0 : xVar.D(str3);
        if (strArr == null || strArr.length <= 0) {
            this.f67055y = 0;
            this.f67056z = null;
        } else {
            int length = strArr.length;
            this.f67055y = length;
            this.f67056z = new int[length];
            for (int i13 = 0; i13 < this.f67055y; i13++) {
                this.f67056z[i13] = xVar.e(strArr[i13]).f67083a;
            }
        }
        this.N = i12;
        if (i12 != 0) {
            int iC = y.c(str2) >> 2;
            iC = (i11 & 8) != 0 ? iC - 1 : iC;
            this.f67040j = iC;
            this.T = iC;
            q qVar = new q();
            this.O = qVar;
            o(qVar);
        }
    }

    @Override // i30.r
    public void A(int i11, int i12, q qVar, q... qVarArr) {
        d dVar = this.f67041k;
        this.Z = dVar.f66921b;
        dVar.g(170).h(null, 0, (4 - (this.f67041k.f66921b % 4)) % 4);
        qVar.h(this.f67041k, this.Z, true);
        this.f67041k.i(i11).i(i12);
        for (q qVar2 : qVarArr) {
            qVar2.h(this.f67041k, this.Z, true);
        }
        W(qVar, qVarArr);
    }

    @Override // i30.r
    public a B(int i11, z zVar, String str, boolean z11) {
        d dVar = new d();
        a0.a(i11, dVar);
        z.d(zVar, dVar);
        dVar.k(this.f67033c.D(str)).k(0);
        if (z11) {
            b bVar = new b(this.f67033c, dVar, this.f67052v);
            this.f67052v = bVar;
            return bVar;
        }
        b bVar2 = new b(this.f67033c, dVar, this.f67053w);
        this.f67053w = bVar2;
        return bVar2;
    }

    @Override // i30.r
    public void C(q qVar, q qVar2, q qVar3, String str) {
        p pVar = new p(qVar, qVar2, qVar3, str != null ? this.f67033c.e(str).f67083a : 0, str);
        if (this.f67042l == null) {
            this.f67042l = pVar;
        } else {
            this.f67043m.f67013f = pVar;
        }
        this.f67043m = pVar;
    }

    @Override // i30.r
    public a D(int i11, z zVar, String str, boolean z11) {
        d dVar = new d();
        a0.a(i11, dVar);
        z.d(zVar, dVar);
        dVar.k(this.f67033c.D(str)).k(0);
        if (z11) {
            b bVar = new b(this.f67033c, dVar, this.H);
            this.H = bVar;
            return bVar;
        }
        b bVar2 = new b(this.f67033c, dVar, this.I);
        this.I = bVar2;
        return bVar2;
    }

    @Override // i30.r
    public void E(int i11, String str) {
        this.Z = this.f67041k.f66921b;
        w wVarE = this.f67033c.e(str);
        this.f67041k.e(i11, wVarE.f67083a);
        q qVar = this.Q;
        if (qVar != null) {
            int i12 = this.N;
            if (i12 == 4 || i12 == 3) {
                qVar.f67024j.d(i11, this.Z, wVarE, this.f67033c);
            } else if (i11 == 187) {
                int i13 = this.R + 1;
                if (i13 > this.S) {
                    this.S = i13;
                }
                this.R = i13;
            }
        }
    }

    @Override // i30.r
    public void F(int i11, int i12) {
        d dVar = this.f67041k;
        this.Z = dVar.f66921b;
        if (i12 < 4 && i11 != 169) {
            dVar.g((i11 < 54 ? ((i11 - 21) << 2) + 26 : ((i11 - 54) << 2) + 59) + i12);
        } else if (i12 >= 256) {
            dVar.g(196).e(i11, i12);
        } else {
            dVar.c(i11, i12);
        }
        q qVar = this.Q;
        if (qVar != null) {
            int i13 = this.N;
            if (i13 == 4 || i13 == 3) {
                qVar.f67024j.d(i11, i12, null, null);
            } else if (i11 == 169) {
                qVar.f67015a = (short) (qVar.f67015a | 64);
                qVar.f67021g = (short) this.R;
                M();
            } else {
                int i14 = this.R + f67030c0[i11];
                if (i14 > this.S) {
                    this.S = i14;
                }
                this.R = i14;
            }
        }
        int i15 = this.N;
        if (i15 != 0) {
            int i16 = (i11 == 22 || i11 == 24 || i11 == 55 || i11 == 57) ? i12 + 2 : i12 + 1;
            if (i16 > this.f67040j) {
                this.f67040j = i16;
            }
        }
        if (i11 < 54 || i15 != 4 || this.f67042l == null) {
            return;
        }
        o(new q());
    }

    public final void G(int i11, q qVar) {
        q qVar2 = this.Q;
        qVar2.f67026l = new k(i11, qVar, qVar2.f67026l);
    }

    public boolean H(e eVar, int i11, int i12, boolean z11, boolean z12, int i13, int i14, int i15) {
        if (eVar == this.f67033c.S() && i13 == this.f67037g && i14 == this.A) {
            if (z12 == ((this.f67034d & 131072) != 0)) {
                if (z11 != (this.f67033c.R() < 49 && (this.f67034d & 4096) != 0)) {
                    return false;
                }
                if (i15 == 0) {
                    if (this.f67055y != 0) {
                        return false;
                    }
                } else if (eVar.H(i15) == this.f67055y) {
                    int i16 = i15 + 2;
                    for (int i17 = 0; i17 < this.f67055y; i17++) {
                        if (eVar.H(i16) != this.f67056z[i17]) {
                            return false;
                        }
                        i16 += 2;
                    }
                }
                this.f67031a0 = i11 + 6;
                this.f67032b0 = i12 - 6;
                return true;
            }
        }
        return false;
    }

    public final void I(c.a aVar) {
        aVar.b(this.M);
        aVar.b(this.f67054x);
    }

    public final void J() {
        p pVar = this.f67042l;
        while (true) {
            if (pVar == null) {
                break;
            }
            String str = pVar.f67012e;
            int iG = n.g(this.f67033c, str != null ? str : "java/lang/Throwable");
            q qVarE = pVar.f67010c.e();
            qVarE.f67015a = (short) (qVarE.f67015a | 2);
            q qVarE2 = pVar.f67009b.e();
            for (q qVarE3 = pVar.f67008a.e(); qVarE3 != qVarE2; qVarE3 = qVarE3.f67025k) {
                qVarE3.f67026l = new k(iG, qVarE, qVarE3.f67026l);
            }
            pVar = pVar.f67013f;
        }
        n nVar = this.O.f67024j;
        nVar.t(this.f67033c, this.f67034d, this.f67038h, this.f67040j);
        nVar.a(this);
        q qVar = this.O;
        qVar.f67027m = q.f67014n;
        int iMax = 0;
        while (qVar != q.f67014n) {
            q qVar2 = qVar.f67027m;
            qVar.f67027m = null;
            qVar.f67015a = (short) (qVar.f67015a | 8);
            int i11 = qVar.f67024j.i() + qVar.f67022h;
            if (i11 > iMax) {
                iMax = i11;
            }
            for (k kVar = qVar.f67026l; kVar != null; kVar = kVar.f66980c) {
                q qVarE4 = kVar.f66979b.e();
                if (qVar.f67024j.l(this.f67033c, qVarE4.f67024j, kVar.f66978a) && qVarE4.f67027m == null) {
                    qVarE4.f67027m = qVar2;
                    qVar2 = qVarE4;
                }
            }
            qVar = qVar2;
        }
        for (q qVar3 = this.O; qVar3 != null; qVar3 = qVar3.f67025k) {
            if ((qVar3.f67015a & 10) == 10) {
                qVar3.f67024j.a(this);
            }
            if ((qVar3.f67015a & 8) == 0) {
                q qVar4 = qVar3.f67025k;
                int i12 = qVar3.f67018d;
                int i13 = (qVar4 == null ? this.f67041k.f66921b : qVar4.f67018d) - 1;
                if (i13 >= i12) {
                    for (int i14 = i12; i14 < i13; i14++) {
                        this.f67041k.f66920a[i14] = 0;
                    }
                    this.f67041k.f66920a[i13] = -65;
                    this.W[V(i12, 0, 1)] = n.g(this.f67033c, "java/lang/Throwable");
                    U();
                    this.f67042l = p.d(this.f67042l, qVar3, qVar4);
                    iMax = Math.max(iMax, 1);
                }
            }
        }
        this.f67039i = iMax;
    }

    public final void K() {
        for (p pVar = this.f67042l; pVar != null; pVar = pVar.f67013f) {
            q qVar = pVar.f67010c;
            q qVar2 = pVar.f67009b;
            for (q qVar3 = pVar.f67008a; qVar3 != qVar2; qVar3 = qVar3.f67025k) {
                if ((qVar3.f67015a & 16) == 0) {
                    qVar3.f67026l = new k(Api.BaseClientBuilder.API_PRIORITY_OTHER, qVar, qVar3.f67026l);
                } else {
                    k kVar = qVar3.f67026l.f66980c;
                    kVar.f66980c = new k(Api.BaseClientBuilder.API_PRIORITY_OTHER, qVar, kVar.f66980c);
                }
            }
        }
        if (this.X) {
            this.O.f((short) 1);
            short s11 = 1;
            for (short s12 = 1; s12 <= s11; s12 = (short) (s12 + 1)) {
                for (q qVar4 = this.O; qVar4 != null; qVar4 = qVar4.f67025k) {
                    if ((qVar4.f67015a & 16) != 0 && qVar4.f67023i == s12) {
                        q qVar5 = qVar4.f67026l.f66980c.f66979b;
                        if (qVar5.f67023i == 0) {
                            s11 = (short) (s11 + 1);
                            qVar5.f(s11);
                        }
                    }
                }
            }
            for (q qVar6 = this.O; qVar6 != null; qVar6 = qVar6.f67025k) {
                if ((qVar6.f67015a & 16) != 0) {
                    qVar6.f67026l.f66980c.f66979b.d(qVar6);
                }
            }
        }
        q qVar7 = this.O;
        qVar7.f67027m = q.f67014n;
        int i11 = this.f67039i;
        while (qVar7 != q.f67014n) {
            q qVar8 = qVar7.f67027m;
            short s13 = qVar7.f67020f;
            int i12 = qVar7.f67022h + s13;
            if (i12 > i11) {
                i11 = i12;
            }
            k kVar2 = qVar7.f67026l;
            if ((qVar7.f67015a & 16) != 0) {
                kVar2 = kVar2.f66980c;
            }
            qVar7 = qVar8;
            while (kVar2 != null) {
                q qVar9 = kVar2.f66979b;
                if (qVar9.f67027m == null) {
                    int i13 = kVar2.f66978a;
                    qVar9.f67020f = (short) (i13 == Integer.MAX_VALUE ? 1 : i13 + s13);
                    qVar9.f67027m = qVar7;
                    qVar7 = qVar9;
                }
                kVar2 = kVar2.f66980c;
            }
        }
        this.f67039i = i11;
    }

    public int L() {
        int iF;
        if (this.f67031a0 != 0) {
            return this.f67032b0 + 6;
        }
        int i11 = this.f67041k.f66921b;
        if (i11 <= 0) {
            iF = 8;
        } else {
            if (i11 > 65535) {
                throw new MethodTooLargeException(this.f67033c.O(), this.f67036f, this.f67038h, this.f67041k.f66921b);
            }
            this.f67033c.D("Code");
            iF = this.f67041k.f66921b + 16 + p.b(this.f67042l) + 8;
            if (this.f67051u != null) {
                this.f67033c.D(this.f67033c.R() >= 50 ? "StackMapTable" : "StackMap");
                iF += this.f67051u.f66921b + 8;
            }
            if (this.f67045o != null) {
                this.f67033c.D("LineNumberTable");
                iF += this.f67045o.f66921b + 8;
            }
            if (this.f67047q != null) {
                this.f67033c.D("LocalVariableTable");
                iF += this.f67047q.f66921b + 8;
            }
            if (this.f67049s != null) {
                this.f67033c.D("LocalVariableTypeTable");
                iF += this.f67049s.f66921b + 8;
            }
            b bVar = this.f67052v;
            if (bVar != null) {
                iF += bVar.f("RuntimeVisibleTypeAnnotations");
            }
            b bVar2 = this.f67053w;
            if (bVar2 != null) {
                iF += bVar2.f("RuntimeInvisibleTypeAnnotations");
            }
            c cVar = this.f67054x;
            if (cVar != null) {
                x xVar = this.f67033c;
                d dVar = this.f67041k;
                iF += cVar.b(xVar, dVar.f66920a, dVar.f66921b, this.f67039i, this.f67040j);
            }
        }
        if (this.f67055y > 0) {
            this.f67033c.D("Exceptions");
            iF += (this.f67055y * 2) + 8;
        }
        boolean z11 = this.f67033c.R() < 49;
        if ((this.f67034d & 4096) != 0 && z11) {
            this.f67033c.D("Synthetic");
            iF += 6;
        }
        if (this.A != 0) {
            this.f67033c.D(RequestParameters.SIGNATURE);
            iF += 8;
        }
        if ((this.f67034d & 131072) != 0) {
            this.f67033c.D("Deprecated");
            iF += 6;
        }
        b bVar3 = this.B;
        if (bVar3 != null) {
            iF += bVar3.f("RuntimeVisibleAnnotations");
        }
        b bVar4 = this.C;
        if (bVar4 != null) {
            iF += bVar4.f("RuntimeInvisibleAnnotations");
        }
        b[] bVarArr = this.E;
        if (bVarArr != null) {
            int length = this.D;
            if (length == 0) {
                length = bVarArr.length;
            }
            iF += b.g("RuntimeVisibleParameterAnnotations", bVarArr, length);
        }
        b[] bVarArr2 = this.G;
        if (bVarArr2 != null) {
            int length2 = this.F;
            if (length2 == 0) {
                length2 = bVarArr2.length;
            }
            iF += b.g("RuntimeInvisibleParameterAnnotations", bVarArr2, length2);
        }
        b bVar5 = this.H;
        if (bVar5 != null) {
            iF += bVar5.f("RuntimeVisibleTypeAnnotations");
        }
        b bVar6 = this.I;
        if (bVar6 != null) {
            iF += bVar6.f("RuntimeInvisibleTypeAnnotations");
        }
        if (this.J != null) {
            this.f67033c.D("AnnotationDefault");
            iF += this.J.f66921b + 6;
        }
        if (this.L != null) {
            this.f67033c.D("MethodParameters");
            iF += this.L.f66921b + 7;
        }
        c cVar2 = this.M;
        return cVar2 != null ? iF + cVar2.a(this.f67033c) : iF;
    }

    public final void M() {
        int i11 = this.N;
        if (i11 != 4) {
            if (i11 == 1) {
                this.Q.f67022h = (short) this.S;
                this.Q = null;
                return;
            }
            return;
        }
        q qVar = new q();
        qVar.f67024j = new n(qVar);
        d dVar = this.f67041k;
        qVar.i(dVar.f66920a, dVar.f66921b);
        this.P.f67025k = qVar;
        this.P = qVar;
        this.Q = null;
    }

    public boolean N() {
        return this.Y;
    }

    public boolean O() {
        return this.f67050t > 0;
    }

    public final void P(int i11, int i12) {
        while (i11 < i12) {
            n.r(this.f67033c, this.W[i11], this.f67051u);
            i11++;
        }
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0077  */
    public final void Q() {
        char c11;
        int[] iArr = this.W;
        int i11 = iArr[1];
        int i12 = iArr[2];
        if (this.f67033c.R() < 50) {
            this.f67051u.k(this.W[0]).k(i11);
            int i13 = i11 + 3;
            P(3, i13);
            this.f67051u.k(i12);
            P(i13, i12 + i13);
            return;
        }
        int i14 = this.f67050t == 0 ? this.W[0] : (this.W[0] - this.V[0]) - 1;
        int i15 = this.V[1];
        int i16 = i11 - i15;
        if (i12 == 0) {
            switch (i16) {
                case C.RESULT_NOTHING_READ /* -3 */:
                case -2:
                case -1:
                    c11 = 248;
                    break;
                case 0:
                    c11 = i14 < 64 ? (char) 0 : (char) 251;
                    break;
                case 1:
                case 2:
                case 3:
                    c11 = 252;
                    break;
                default:
                    c11 = 255;
                    break;
            }
        } else if (i16 == 0 && i12 == 1) {
            c11 = i14 < 63 ? '@' : (char) 247;
        } else {
            c11 = 255;
        }
        if (c11 != 255) {
            int i17 = 3;
            for (int i18 = 0; i18 < i15 && i18 < i11; i18++) {
                if (this.W[i17] != this.V[i17]) {
                    c11 = 255;
                } else {
                    i17++;
                }
            }
        }
        if (c11 == 0) {
            this.f67051u.g(i14);
            return;
        }
        if (c11 == '@') {
            this.f67051u.g(i14 + 64);
            P(i11 + 3, i11 + 4);
            return;
        }
        if (c11 == 247) {
            this.f67051u.g(247).k(i14);
            P(i11 + 3, i11 + 4);
            return;
        }
        if (c11 == 248) {
            this.f67051u.g(i16 + 251).k(i14);
            return;
        }
        if (c11 == 251) {
            this.f67051u.g(251).k(i14);
            return;
        }
        if (c11 == 252) {
            this.f67051u.g(i16 + 251).k(i14);
            P(i15 + 3, i11 + 3);
            return;
        }
        this.f67051u.g(255).k(i14).k(i11);
        int i19 = i11 + 3;
        P(3, i19);
        this.f67051u.k(i12);
        P(i19, i12 + i19);
    }

    public final void R(Object obj) {
        if (obj instanceof Integer) {
            this.f67051u.g(((Integer) obj).intValue());
        } else if (obj instanceof String) {
            this.f67051u.g(7).k(this.f67033c.e((String) obj).f67083a);
        } else {
            this.f67051u.g(8).k(((q) obj).f67018d);
        }
    }

    /* JADX WARN: Code duplicated, block: B:111:0x023e  */
    public void S(d dVar) {
        int i11;
        int iC;
        boolean z11 = this.f67033c.R() < 49;
        dVar.k((~(z11 ? 4096 : 0)) & this.f67034d).k(this.f67035e).k(this.f67037g);
        if (this.f67031a0 != 0) {
            dVar.h(this.f67033c.S().f66922a, this.f67031a0, this.f67032b0);
            return;
        }
        int iC2 = this.f67041k.f66921b > 0 ? 1 : 0;
        if (this.f67055y > 0) {
            iC2++;
        }
        int i12 = this.f67034d;
        if ((i12 & 4096) != 0 && z11) {
            iC2++;
        }
        if (this.A != 0) {
            iC2++;
        }
        if ((i12 & 131072) != 0) {
            iC2++;
        }
        if (this.B != null) {
            iC2++;
        }
        if (this.C != null) {
            iC2++;
        }
        if (this.E != null) {
            iC2++;
        }
        if (this.G != null) {
            iC2++;
        }
        if (this.H != null) {
            iC2++;
        }
        if (this.I != null) {
            iC2++;
        }
        if (this.J != null) {
            iC2++;
        }
        if (this.L != null) {
            iC2++;
        }
        c cVar = this.M;
        if (cVar != null) {
            iC2 += cVar.c();
        }
        dVar.k(iC2);
        int i13 = this.f67041k.f66921b;
        if (i13 > 0) {
            int iB = i13 + 10 + p.b(this.f67042l);
            d dVar2 = this.f67051u;
            if (dVar2 != null) {
                iB += dVar2.f66921b + 8;
                iC = 1;
            } else {
                iC = 0;
            }
            d dVar3 = this.f67045o;
            if (dVar3 != null) {
                iB += dVar3.f66921b + 8;
                iC++;
            }
            d dVar4 = this.f67047q;
            if (dVar4 != null) {
                iB += dVar4.f66921b + 8;
                iC++;
            }
            d dVar5 = this.f67049s;
            if (dVar5 != null) {
                iB += dVar5.f66921b + 8;
                iC++;
            }
            b bVar = this.f67052v;
            if (bVar != null) {
                iB += bVar.f("RuntimeVisibleTypeAnnotations");
                iC++;
            }
            b bVar2 = this.f67053w;
            if (bVar2 != null) {
                iB += bVar2.f("RuntimeInvisibleTypeAnnotations");
                iC++;
            }
            c cVar2 = this.f67054x;
            if (cVar2 != null) {
                x xVar = this.f67033c;
                d dVar6 = this.f67041k;
                iB += cVar2.b(xVar, dVar6.f66920a, dVar6.f66921b, this.f67039i, this.f67040j);
                iC += this.f67054x.c();
            }
            d dVarI = dVar.k(this.f67033c.D("Code")).i(iB).k(this.f67039i).k(this.f67040j).i(this.f67041k.f66921b);
            d dVar7 = this.f67041k;
            dVarI.h(dVar7.f66920a, 0, dVar7.f66921b);
            p.c(this.f67042l, dVar);
            dVar.k(iC);
            if (this.f67051u != null) {
                d dVarK = dVar.k(this.f67033c.D(this.f67033c.R() >= 50 ? "StackMapTable" : "StackMap")).i(this.f67051u.f66921b + 2).k(this.f67050t);
                d dVar8 = this.f67051u;
                dVarK.h(dVar8.f66920a, 0, dVar8.f66921b);
            }
            if (this.f67045o != null) {
                d dVarK2 = dVar.k(this.f67033c.D("LineNumberTable")).i(this.f67045o.f66921b + 2).k(this.f67044n);
                d dVar9 = this.f67045o;
                dVarK2.h(dVar9.f66920a, 0, dVar9.f66921b);
            }
            if (this.f67047q != null) {
                d dVarK3 = dVar.k(this.f67033c.D("LocalVariableTable")).i(this.f67047q.f66921b + 2).k(this.f67046p);
                d dVar10 = this.f67047q;
                dVarK3.h(dVar10.f66920a, 0, dVar10.f66921b);
            }
            if (this.f67049s != null) {
                d dVarK4 = dVar.k(this.f67033c.D("LocalVariableTypeTable")).i(this.f67049s.f66921b + 2).k(this.f67048r);
                d dVar11 = this.f67049s;
                dVarK4.h(dVar11.f66920a, 0, dVar11.f66921b);
            }
            b bVar3 = this.f67052v;
            if (bVar3 != null) {
                bVar3.h(this.f67033c.D("RuntimeVisibleTypeAnnotations"), dVar);
            }
            b bVar4 = this.f67053w;
            if (bVar4 != null) {
                bVar4.h(this.f67033c.D("RuntimeInvisibleTypeAnnotations"), dVar);
            }
            c cVar3 = this.f67054x;
            if (cVar3 != null) {
                x xVar2 = this.f67033c;
                d dVar12 = this.f67041k;
                i11 = 2;
                cVar3.f(xVar2, dVar12.f66920a, dVar12.f66921b, this.f67039i, this.f67040j, dVar);
            } else {
                i11 = 2;
            }
        } else {
            i11 = 2;
        }
        if (this.f67055y > 0) {
            dVar.k(this.f67033c.D("Exceptions")).i((this.f67055y * 2) + i11).k(this.f67055y);
            for (int i14 : this.f67056z) {
                dVar.k(i14);
            }
        }
        if ((this.f67034d & 4096) != 0 && z11) {
            dVar.k(this.f67033c.D("Synthetic")).i(0);
        }
        if (this.A != 0) {
            dVar.k(this.f67033c.D(RequestParameters.SIGNATURE)).i(i11).k(this.A);
        }
        if ((this.f67034d & 131072) != 0) {
            dVar.k(this.f67033c.D("Deprecated")).i(0);
        }
        b bVar5 = this.B;
        if (bVar5 != null) {
            bVar5.h(this.f67033c.D("RuntimeVisibleAnnotations"), dVar);
        }
        b bVar6 = this.C;
        if (bVar6 != null) {
            bVar6.h(this.f67033c.D("RuntimeInvisibleAnnotations"), dVar);
        }
        if (this.E != null) {
            int iD = this.f67033c.D("RuntimeVisibleParameterAnnotations");
            b[] bVarArr = this.E;
            int length = this.D;
            if (length == 0) {
                length = bVarArr.length;
            }
            b.i(iD, bVarArr, length, dVar);
        }
        if (this.G != null) {
            int iD2 = this.f67033c.D("RuntimeInvisibleParameterAnnotations");
            b[] bVarArr2 = this.G;
            int length2 = this.F;
            if (length2 == 0) {
                length2 = bVarArr2.length;
            }
            b.i(iD2, bVarArr2, length2, dVar);
        }
        b bVar7 = this.H;
        if (bVar7 != null) {
            bVar7.h(this.f67033c.D("RuntimeVisibleTypeAnnotations"), dVar);
        }
        b bVar8 = this.I;
        if (bVar8 != null) {
            bVar8.h(this.f67033c.D("RuntimeInvisibleTypeAnnotations"), dVar);
        }
        if (this.J != null) {
            d dVarI2 = dVar.k(this.f67033c.D("AnnotationDefault")).i(this.J.f66921b);
            d dVar13 = this.J;
            dVarI2.h(dVar13.f66920a, 0, dVar13.f66921b);
        }
        if (this.L != null) {
            d dVarG = dVar.k(this.f67033c.D("MethodParameters")).i(this.L.f66921b + 1).g(this.K);
            d dVar14 = this.L;
            dVarG.h(dVar14.f66920a, 0, dVar14.f66921b);
        }
        c cVar4 = this.M;
        if (cVar4 != null) {
            cVar4.e(this.f67033c, dVar);
        }
    }

    public void T(int i11, int i12) {
        this.W[i11] = i12;
    }

    public void U() {
        if (this.V != null) {
            if (this.f67051u == null) {
                this.f67051u = new d();
            }
            Q();
            this.f67050t++;
        }
        this.V = this.W;
        this.W = null;
    }

    public int V(int i11, int i12, int i13) {
        int i14 = i12 + 3 + i13;
        int[] iArr = this.W;
        if (iArr == null || iArr.length < i14) {
            this.W = new int[i14];
        }
        int[] iArr2 = this.W;
        iArr2[0] = i11;
        iArr2[1] = i12;
        iArr2[2] = i13;
        return 3;
    }

    public final void W(q qVar, q[] qVarArr) {
        q qVar2 = this.Q;
        if (qVar2 != null) {
            int i11 = this.N;
            if (i11 == 4) {
                qVar2.f67024j.d(171, 0, null, null);
                G(0, qVar);
                q qVarE = qVar.e();
                qVarE.f67015a = (short) (qVarE.f67015a | 2);
                for (q qVar3 : qVarArr) {
                    G(0, qVar3);
                    q qVarE2 = qVar3.e();
                    qVarE2.f67015a = (short) (qVarE2.f67015a | 2);
                }
            } else if (i11 == 1) {
                int i12 = this.R - 1;
                this.R = i12;
                G(i12, qVar);
                for (q qVar4 : qVarArr) {
                    G(this.R, qVar4);
                }
            }
            M();
        }
    }

    @Override // i30.r
    public void a(int i11, boolean z11) {
        if (z11) {
            this.D = i11;
        } else {
            this.F = i11;
        }
    }

    @Override // i30.r
    public a b(String str, boolean z11) {
        d dVar = new d();
        dVar.k(this.f67033c.D(str)).k(0);
        if (z11) {
            b bVar = new b(this.f67033c, dVar, this.B);
            this.B = bVar;
            return bVar;
        }
        b bVar2 = new b(this.f67033c, dVar, this.C);
        this.C = bVar2;
        return bVar2;
    }

    @Override // i30.r
    public a c() {
        d dVar = new d();
        this.J = dVar;
        return new b(this.f67033c, false, dVar, null);
    }

    @Override // i30.r
    public void d(c cVar) {
        if (cVar.d()) {
            cVar.f66917c = this.f67054x;
            this.f67054x = cVar;
        } else {
            cVar.f66917c = this.M;
            this.M = cVar;
        }
    }

    @Override // i30.r
    public void e() {
    }

    @Override // i30.r
    public void f() {
    }

    @Override // i30.r
    public void g(int i11, String str, String str2, String str3) {
        int i12;
        int i13;
        this.Z = this.f67041k.f66921b;
        w wVarJ = this.f67033c.j(str, str2, str3);
        this.f67041k.e(i11, wVarJ.f67083a);
        q qVar = this.Q;
        if (qVar != null) {
            int i14 = this.N;
            if (i14 == 4 || i14 == 3) {
                qVar.f67024j.d(i11, 0, wVarJ, this.f67033c);
                return;
            }
            char cCharAt = str3.charAt(0);
            int i15 = -2;
            switch (i11) {
                case 178:
                    i12 = this.R + ((cCharAt == 'D' || cCharAt == 'J') ? 2 : 1);
                    break;
                case 179:
                    i13 = this.R;
                    if (cCharAt != 'D' && cCharAt != 'J') {
                        i15 = -1;
                    }
                    i12 = i13 + i15;
                    break;
                case 180:
                    i12 = this.R + ((cCharAt == 'D' || cCharAt == 'J') ? 1 : 0);
                    break;
                default:
                    i13 = this.R;
                    if (cCharAt == 'D' || cCharAt == 'J') {
                        i15 = -3;
                    }
                    i12 = i13 + i15;
                    break;
            }
            if (i12 > this.S) {
                this.S = i12;
            }
            this.R = i12;
        }
    }

    @Override // i30.r
    public void h(int i11, int i12, Object[] objArr, int i13, Object[] objArr2) {
        int i14;
        int i15 = this.N;
        if (i15 == 4) {
            return;
        }
        if (i15 == 3) {
            q qVar = this.Q;
            n nVar = qVar.f67024j;
            if (nVar == null) {
                qVar.f67024j = new j(qVar);
                this.Q.f67024j.t(this.f67033c, this.f67034d, this.f67038h, i12);
                this.Q.f67024j.a(this);
            } else {
                if (i11 == -1) {
                    nVar.s(this.f67033c, i12, objArr, i13, objArr2);
                }
                this.Q.f67024j.a(this);
            }
        } else if (i11 == -1) {
            if (this.V == null) {
                int iC = y.c(this.f67038h) >> 2;
                n nVar2 = new n(new q());
                nVar2.t(this.f67033c, this.f67034d, this.f67038h, iC);
                nVar2.a(this);
            }
            this.T = i12;
            int iV = V(this.f67041k.f66921b, i12, i13);
            int i16 = 0;
            while (i16 < i12) {
                this.W[iV] = n.e(this.f67033c, objArr[i16]);
                i16++;
                iV++;
            }
            int i17 = 0;
            while (i17 < i13) {
                this.W[iV] = n.e(this.f67033c, objArr2[i17]);
                i17++;
                iV++;
            }
            U();
        } else {
            if (this.f67051u == null) {
                this.f67051u = new d();
                i14 = this.f67041k.f66921b;
            } else {
                i14 = (this.f67041k.f66921b - this.U) - 1;
                if (i14 < 0) {
                    if (i11 != 3) {
                        throw new IllegalStateException();
                    }
                    return;
                }
            }
            if (i11 == 0) {
                this.T = i12;
                this.f67051u.g(255).k(i14).k(i12);
                for (int i18 = 0; i18 < i12; i18++) {
                    R(objArr[i18]);
                }
                this.f67051u.k(i13);
                for (int i19 = 0; i19 < i13; i19++) {
                    R(objArr2[i19]);
                }
            } else if (i11 == 1) {
                this.T += i12;
                this.f67051u.g(i12 + 251).k(i14);
                for (int i21 = 0; i21 < i12; i21++) {
                    R(objArr[i21]);
                }
            } else if (i11 == 2) {
                this.T -= i12;
                this.f67051u.g(251 - i12).k(i14);
            } else if (i11 != 3) {
                if (i11 != 4) {
                    throw new IllegalArgumentException();
                }
                if (i14 < 64) {
                    this.f67051u.g(i14 + 64);
                } else {
                    this.f67051u.g(247).k(i14);
                }
                R(objArr2[0]);
            } else if (i14 < 64) {
                this.f67051u.g(i14);
            } else {
                this.f67051u.g(251).k(i14);
            }
            this.U = this.f67041k.f66921b;
            this.f67050t++;
        }
        if (this.N == 2) {
            this.R = i13;
            for (int i22 = 0; i22 < i13; i22++) {
                Object obj = objArr2[i22];
                if (obj == v.f67080e || obj == v.f67079d) {
                    this.R++;
                }
            }
            int i23 = this.R;
            if (i23 > this.S) {
                this.S = i23;
            }
        }
        this.f67039i = Math.max(this.f67039i, i13);
        this.f67040j = Math.max(this.f67040j, this.T);
    }

    @Override // i30.r
    public void i(int i11, int i12) {
        int i13;
        int i14;
        d dVar = this.f67041k;
        this.Z = dVar.f66921b;
        if (i11 > 255 || i12 > 127 || i12 < -128) {
            dVar.g(196).e(132, i11).k(i12);
        } else {
            dVar.g(132).c(i11, i12);
        }
        q qVar = this.Q;
        if (qVar != null && ((i14 = this.N) == 4 || i14 == 3)) {
            qVar.f67024j.d(132, i11, null, null);
        }
        if (this.N == 0 || (i13 = i11 + 1) <= this.f67040j) {
            return;
        }
        this.f67040j = i13;
    }

    @Override // i30.r
    public void j(int i11) {
        d dVar = this.f67041k;
        this.Z = dVar.f66921b;
        dVar.g(i11);
        q qVar = this.Q;
        if (qVar != null) {
            int i12 = this.N;
            if (i12 == 4 || i12 == 3) {
                qVar.f67024j.d(i11, 0, null, null);
            } else {
                int i13 = this.R + f67030c0[i11];
                if (i13 > this.S) {
                    this.S = i13;
                }
                this.R = i13;
            }
            if ((i11 < 172 || i11 > 177) && i11 != 191) {
                return;
            }
            M();
        }
    }

    @Override // i30.r
    public a k(int i11, z zVar, String str, boolean z11) {
        d dVar = new d();
        a0.a((i11 & (-16776961)) | (this.Z << 8), dVar);
        z.d(zVar, dVar);
        dVar.k(this.f67033c.D(str)).k(0);
        if (z11) {
            b bVar = new b(this.f67033c, dVar, this.f67052v);
            this.f67052v = bVar;
            return bVar;
        }
        b bVar2 = new b(this.f67033c, dVar, this.f67053w);
        this.f67053w = bVar2;
        return bVar2;
    }

    @Override // i30.r
    public void l(int i11, int i12) {
        d dVar = this.f67041k;
        this.Z = dVar.f66921b;
        if (i11 == 17) {
            dVar.e(i11, i12);
        } else {
            dVar.c(i11, i12);
        }
        q qVar = this.Q;
        if (qVar != null) {
            int i13 = this.N;
            if (i13 == 4 || i13 == 3) {
                qVar.f67024j.d(i11, i12, null, null);
            } else if (i11 != 188) {
                int i14 = this.R + 1;
                if (i14 > this.S) {
                    this.S = i14;
                }
                this.R = i14;
            }
        }
    }

    @Override // i30.r
    public void m(String str, String str2, o oVar, Object... objArr) {
        this.Z = this.f67041k.f66921b;
        w wVarO = this.f67033c.o(str, str2, oVar, objArr);
        this.f67041k.e(186, wVarO.f67083a);
        this.f67041k.k(0);
        q qVar = this.Q;
        if (qVar != null) {
            int i11 = this.N;
            if (i11 == 4 || i11 == 3) {
                qVar.f67024j.d(186, 0, wVarO, this.f67033c);
                return;
            }
            int iA = wVarO.a();
            int i12 = this.R + ((iA & 3) - (iA >> 2)) + 1;
            if (i12 > this.S) {
                this.S = i12;
            }
            this.R = i12;
        }
    }

    @Override // i30.r
    public void n(int i11, q qVar) {
        boolean z11;
        d dVar = this.f67041k;
        int i12 = dVar.f66921b;
        this.Z = i12;
        int i13 = i11 >= 200 ? i11 - 33 : i11;
        if ((qVar.f67015a & 4) == 0 || qVar.f67018d - i12 >= -32768) {
            if (i13 != i11) {
                dVar.g(i11);
                d dVar2 = this.f67041k;
                qVar.h(dVar2, dVar2.f66921b - 1, true);
            } else {
                dVar.g(i13);
                d dVar3 = this.f67041k;
                qVar.h(dVar3, dVar3.f66921b - 1, false);
            }
            z11 = false;
        } else {
            if (i13 == 167) {
                dVar.g(200);
            } else {
                if (i13 == 168) {
                    dVar.g(201);
                } else {
                    dVar.g(i13 >= 198 ? i13 ^ 1 : ((i13 + 1) ^ 1) - 1);
                    this.f67041k.k(8);
                    this.f67041k.g(220);
                    this.Y = true;
                    z11 = true;
                }
                d dVar4 = this.f67041k;
                qVar.h(dVar4, dVar4.f66921b - 1, true);
            }
            z11 = false;
            d dVar5 = this.f67041k;
            qVar.h(dVar5, dVar5.f66921b - 1, true);
        }
        q qVar2 = this.Q;
        if (qVar2 != null) {
            int i14 = this.N;
            q qVar3 = null;
            if (i14 == 4) {
                qVar2.f67024j.d(i13, 0, null, null);
                q qVarE = qVar.e();
                qVarE.f67015a = (short) (qVarE.f67015a | 2);
                G(0, qVar);
                if (i13 != 167) {
                    qVar3 = new q();
                }
            } else if (i14 == 3) {
                qVar2.f67024j.d(i13, 0, null, null);
            } else if (i14 == 2) {
                this.R += f67030c0[i13];
            } else if (i13 == 168) {
                short s11 = qVar.f67015a;
                if ((s11 & 32) == 0) {
                    qVar.f67015a = (short) (s11 | 32);
                    this.X = true;
                }
                qVar2.f67015a = (short) (qVar2.f67015a | 16);
                G(this.R + 1, qVar);
                qVar3 = new q();
            } else {
                int i15 = this.R + f67030c0[i13];
                this.R = i15;
                G(i15, qVar);
            }
            if (qVar3 != null) {
                if (z11) {
                    qVar3.f67015a = (short) (qVar3.f67015a | 2);
                }
                o(qVar3);
            }
            if (i13 == 167) {
                M();
            }
        }
    }

    @Override // i30.r
    public void o(q qVar) {
        boolean z11 = this.Y;
        d dVar = this.f67041k;
        this.Y = z11 | qVar.i(dVar.f66920a, dVar.f66921b);
        short s11 = qVar.f67015a;
        if ((s11 & 1) != 0) {
            return;
        }
        int i11 = this.N;
        if (i11 == 4) {
            q qVar2 = this.Q;
            if (qVar2 != null) {
                if (qVar.f67018d == qVar2.f67018d) {
                    qVar2.f67015a = (short) ((s11 & 2) | qVar2.f67015a);
                    qVar.f67024j = qVar2.f67024j;
                    return;
                }
                G(0, qVar);
            }
            q qVar3 = this.P;
            if (qVar3 != null) {
                if (qVar.f67018d == qVar3.f67018d) {
                    qVar3.f67015a = (short) (qVar3.f67015a | (qVar.f67015a & 2));
                    qVar.f67024j = qVar3.f67024j;
                    this.Q = qVar3;
                    return;
                }
                qVar3.f67025k = qVar;
            }
            this.P = qVar;
            this.Q = qVar;
            qVar.f67024j = new n(qVar);
            return;
        }
        if (i11 == 3) {
            q qVar4 = this.Q;
            if (qVar4 == null) {
                this.Q = qVar;
                return;
            } else {
                qVar4.f67024j.f66994a = qVar;
                return;
            }
        }
        if (i11 != 1) {
            if (i11 == 2 && this.Q == null) {
                this.Q = qVar;
                return;
            }
            return;
        }
        q qVar5 = this.Q;
        if (qVar5 != null) {
            qVar5.f67022h = (short) this.S;
            G(this.R, qVar);
        }
        this.Q = qVar;
        this.R = 0;
        this.S = 0;
        q qVar6 = this.P;
        if (qVar6 != null) {
            qVar6.f67025k = qVar;
        }
        this.P = qVar;
    }

    @Override // i30.r
    public void p(Object obj) {
        char cCharAt;
        this.Z = this.f67041k.f66921b;
        w wVarD = this.f67033c.d(obj);
        int i11 = wVarD.f67083a;
        int i12 = wVarD.f67084b;
        boolean z11 = i12 == 5 || i12 == 6 || (i12 == 17 && ((cCharAt = wVarD.f67087e.charAt(0)) == 'J' || cCharAt == 'D'));
        if (z11) {
            this.f67041k.e(20, i11);
        } else if (i11 >= 256) {
            this.f67041k.e(19, i11);
        } else {
            this.f67041k.c(18, i11);
        }
        q qVar = this.Q;
        if (qVar != null) {
            int i13 = this.N;
            if (i13 == 4 || i13 == 3) {
                qVar.f67024j.d(18, 0, wVarD, this.f67033c);
                return;
            }
            int i14 = this.R + (z11 ? 2 : 1);
            if (i14 > this.S) {
                this.S = i14;
            }
            this.R = i14;
        }
    }

    @Override // i30.r
    public void q(int i11, q qVar) {
        if (this.f67045o == null) {
            this.f67045o = new d();
        }
        this.f67044n++;
        this.f67045o.k(qVar.f67018d);
        this.f67045o.k(i11);
    }

    @Override // i30.r
    public void r(String str, String str2, String str3, q qVar, q qVar2, int i11) {
        if (str3 != null) {
            if (this.f67049s == null) {
                this.f67049s = new d();
            }
            this.f67048r++;
            this.f67049s.k(qVar.f67018d).k(qVar2.f67018d - qVar.f67018d).k(this.f67033c.D(str)).k(this.f67033c.D(str3)).k(i11);
        }
        if (this.f67047q == null) {
            this.f67047q = new d();
        }
        this.f67046p++;
        this.f67047q.k(qVar.f67018d).k(qVar2.f67018d - qVar.f67018d).k(this.f67033c.D(str)).k(this.f67033c.D(str2)).k(i11);
        if (this.N != 0) {
            char cCharAt = str2.charAt(0);
            int i12 = i11 + ((cCharAt == 'J' || cCharAt == 'D') ? 2 : 1);
            if (i12 > this.f67040j) {
                this.f67040j = i12;
            }
        }
    }

    @Override // i30.r
    public a s(int i11, z zVar, q[] qVarArr, q[] qVarArr2, int[] iArr, String str, boolean z11) {
        d dVar = new d();
        dVar.g(i11 >>> 24).k(qVarArr.length);
        for (int i12 = 0; i12 < qVarArr.length; i12++) {
            dVar.k(qVarArr[i12].f67018d).k(qVarArr2[i12].f67018d - qVarArr[i12].f67018d).k(iArr[i12]);
        }
        z.d(zVar, dVar);
        dVar.k(this.f67033c.D(str)).k(0);
        if (z11) {
            b bVar = new b(this.f67033c, dVar, this.f67052v);
            this.f67052v = bVar;
            return bVar;
        }
        b bVar2 = new b(this.f67033c, dVar, this.f67053w);
        this.f67053w = bVar2;
        return bVar2;
    }

    @Override // i30.r
    public void t(q qVar, int[] iArr, q[] qVarArr) {
        d dVar = this.f67041k;
        this.Z = dVar.f66921b;
        dVar.g(171).h(null, 0, (4 - (this.f67041k.f66921b % 4)) % 4);
        qVar.h(this.f67041k, this.Z, true);
        this.f67041k.i(qVarArr.length);
        for (int i11 = 0; i11 < qVarArr.length; i11++) {
            this.f67041k.i(iArr[i11]);
            qVarArr[i11].h(this.f67041k, this.Z, true);
        }
        W(qVar, qVarArr);
    }

    @Override // i30.r
    public void u(int i11, int i12) {
        int i13 = this.N;
        if (i13 == 4) {
            J();
            return;
        }
        if (i13 == 1) {
            K();
        } else if (i13 == 2) {
            this.f67039i = this.S;
        } else {
            this.f67039i = i11;
            this.f67040j = i12;
        }
    }

    @Override // i30.r
    public void w(int i11, String str, String str2, String str3, boolean z11) {
        this.Z = this.f67041k.f66921b;
        w wVarX = this.f67033c.x(str, str2, str3, z11);
        if (i11 == 185) {
            this.f67041k.e(185, wVarX.f67083a).c(wVarX.a() >> 2, 0);
        } else {
            this.f67041k.e(i11, wVarX.f67083a);
        }
        q qVar = this.Q;
        if (qVar != null) {
            int i12 = this.N;
            if (i12 == 4 || i12 == 3) {
                qVar.f67024j.d(i11, 0, wVarX, this.f67033c);
                return;
            }
            int iA = wVarX.a();
            int i13 = (iA & 3) - (iA >> 2);
            int i14 = i11 == 184 ? this.R + i13 + 1 : this.R + i13;
            if (i14 > this.S) {
                this.S = i14;
            }
            this.R = i14;
        }
    }

    @Override // i30.r
    public void x(String str, int i11) {
        this.Z = this.f67041k.f66921b;
        w wVarE = this.f67033c.e(str);
        this.f67041k.e(197, wVarE.f67083a).g(i11);
        q qVar = this.Q;
        if (qVar != null) {
            int i12 = this.N;
            if (i12 == 4 || i12 == 3) {
                qVar.f67024j.d(197, i11, wVarE, this.f67033c);
            } else {
                this.R += 1 - i11;
            }
        }
    }

    @Override // i30.r
    public void y(String str, int i11) {
        if (this.L == null) {
            this.L = new d();
        }
        this.K++;
        this.L.k(str == null ? 0 : this.f67033c.D(str)).k(i11);
    }

    @Override // i30.r
    public a z(int i11, String str, boolean z11) {
        d dVar = new d();
        dVar.k(this.f67033c.D(str)).k(0);
        if (z11) {
            if (this.E == null) {
                this.E = new b[y.b(this.f67038h).length];
            }
            b[] bVarArr = this.E;
            b bVar = new b(this.f67033c, dVar, bVarArr[i11]);
            bVarArr[i11] = bVar;
            return bVar;
        }
        if (this.G == null) {
            this.G = new b[y.b(this.f67038h).length];
        }
        b[] bVarArr2 = this.G;
        b bVar2 = new b(this.f67033c, dVar, bVarArr2[i11]);
        bVarArr2[i11] = bVar2;
        return bVar2;
    }
}
