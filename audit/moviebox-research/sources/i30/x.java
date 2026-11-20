package i30;

import com.google.android.gms.common.api.Api;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import org.mvel2.optimizers.OptimizationNotSupported;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f67090a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f67091b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f67092c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f67093d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f67094e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public a[] f67095f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f67096g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public d f67097h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f67098i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public d f67099j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f67100k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public a[] f67101l;

    /* JADX INFO: compiled from: source.java */
    public static class a extends w {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int f67102h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public a f67103i;

        public a(int i11, int i12, long j11, int i13) {
            super(i11, i12, null, null, null, j11);
            this.f67102h = i13;
        }

        public a(int i11, int i12, String str, int i13) {
            super(i11, i12, null, null, str, 0L);
            this.f67102h = i13;
        }

        public a(int i11, int i12, String str, long j11, int i13) {
            super(i11, i12, null, null, str, j11);
            this.f67102h = i13;
        }

        public a(int i11, int i12, String str, String str2, int i13) {
            super(i11, i12, null, str, str2, 0L);
            this.f67102h = i13;
        }

        public a(int i11, int i12, String str, String str2, String str3, long j11, int i13) {
            super(i11, i12, str, str2, str3, j11);
            this.f67102h = i13;
        }
    }

    public x(g gVar) {
        this.f67090a = gVar;
        this.f67091b = null;
        this.f67095f = new a[256];
        this.f67096g = 1;
        this.f67097h = new d();
    }

    public x(g gVar, e eVar) {
        this.f67090a = gVar;
        this.f67091b = eVar;
        byte[] bArr = eVar.f66922a;
        int iF = eVar.f(1) - 1;
        int i11 = eVar.f66928g - iF;
        this.f67096g = eVar.g();
        d dVar = new d(i11);
        this.f67097h = dVar;
        dVar.h(bArr, iF, i11);
        this.f67095f = new a[this.f67096g * 2];
        char[] cArr = new char[eVar.h()];
        boolean z11 = false;
        int i12 = 1;
        while (i12 < this.f67096g) {
            int iF2 = eVar.f(i12);
            byte b11 = bArr[iF2 - 1];
            switch (b11) {
                case 1:
                    E(i12, eVar.J(i12, cArr));
                    break;
                case 2:
                case 13:
                case 14:
                default:
                    throw new IllegalArgumentException();
                case 3:
                case 4:
                    n(i12, b11, eVar.t(iF2));
                    break;
                case 5:
                case 6:
                    r(i12, b11, eVar.v(iF2));
                    break;
                case 7:
                case 8:
                case 16:
                case 19:
                case 20:
                    G(i12, b11, eVar.G(iF2, cArr));
                    break;
                case 9:
                case 10:
                case 11:
                    int iF3 = eVar.f(eVar.H(iF2 + 2));
                    t(i12, b11, eVar.m(iF2, cArr), eVar.G(iF3, cArr), eVar.G(iF3 + 2, cArr));
                    break;
                case 12:
                    A(i12, eVar.G(iF2, cArr), eVar.G(iF2 + 2, cArr));
                    break;
                case 15:
                    int iF4 = eVar.f(eVar.H(iF2 + 1));
                    int iF5 = eVar.f(eVar.H(iF4 + 2));
                    v(i12, eVar.l(iF2), eVar.m(iF4, cArr), eVar.G(iF5, cArr), eVar.G(iF5 + 2, cArr));
                    break;
                case 17:
                case 18:
                    int iF6 = eVar.f(eVar.H(iF2 + 2));
                    i(b11, i12, eVar.G(iF6, cArr), eVar.G(iF6 + 2, cArr), eVar.H(iF2));
                    z11 = true;
                    break;
            }
            i12 += (b11 == 5 || b11 == 6) ? 2 : 1;
        }
        if (z11) {
            M(eVar, cArr);
        }
    }

    public static int U(int i11, int i12) {
        return (i11 + i12) & Api.BaseClientBuilder.API_PRIORITY_OTHER;
    }

    public static int V(int i11, long j11) {
        return (i11 + ((int) j11) + ((int) (j11 >>> 32))) & Api.BaseClientBuilder.API_PRIORITY_OTHER;
    }

    public static int W(int i11, String str) {
        return (i11 + str.hashCode()) & Api.BaseClientBuilder.API_PRIORITY_OTHER;
    }

    public static int X(int i11, String str, int i12) {
        return (i11 + str.hashCode() + i12) & Api.BaseClientBuilder.API_PRIORITY_OTHER;
    }

    public static int Y(int i11, String str, String str2) {
        return (i11 + (str.hashCode() * str2.hashCode())) & Api.BaseClientBuilder.API_PRIORITY_OTHER;
    }

    public static int Z(int i11, String str, String str2, int i12) {
        return (i11 + (str.hashCode() * str2.hashCode() * (i12 + 1))) & Api.BaseClientBuilder.API_PRIORITY_OTHER;
    }

    public static int a0(int i11, String str, String str2, String str3) {
        return (i11 + (str.hashCode() * str2.hashCode() * str3.hashCode())) & Api.BaseClientBuilder.API_PRIORITY_OTHER;
    }

    public static int b0(int i11, String str, String str2, String str3, int i12) {
        return (i11 + (str.hashCode() * str2.hashCode() * str3.hashCode() * i12)) & Api.BaseClientBuilder.API_PRIORITY_OTHER;
    }

    public final void A(int i11, String str, String str2) {
        a(new a(i11, 12, str, str2, Y(12, str, str2)));
    }

    public w B(String str) {
        return F(20, str);
    }

    public w C(String str) {
        return F(8, str);
    }

    public int D(String str) {
        int iW = W(1, str);
        for (a aVarN = N(iW); aVarN != null; aVarN = aVarN.f67103i) {
            if (aVarN.f67084b == 1 && aVarN.f67102h == iW && aVarN.f67087e.equals(str)) {
                return aVarN.f67083a;
            }
        }
        this.f67097h.g(1).l(str);
        int i11 = this.f67096g;
        this.f67096g = i11 + 1;
        return c0(new a(i11, 1, str, iW)).f67083a;
    }

    public final void E(int i11, String str) {
        a(new a(i11, 1, str, W(1, str)));
    }

    public final w F(int i11, String str) {
        int iW = W(i11, str);
        for (a aVarN = N(iW); aVarN != null; aVarN = aVarN.f67103i) {
            if (aVarN.f67084b == i11 && aVarN.f67102h == iW && aVarN.f67087e.equals(str)) {
                return aVarN;
            }
        }
        this.f67097h.e(i11, D(str));
        int i12 = this.f67096g;
        this.f67096g = i12 + 1;
        return c0(new a(i12, i11, str, iW));
    }

    public final void G(int i11, int i12, String str) {
        a(new a(i11, i12, str, W(i12, str)));
    }

    public int H(int i11, int i12) {
        long j11 = ((long) i11) | (((long) i12) << 32);
        int iU = U(TsExtractor.TS_STREAM_TYPE_HDMV_DTS, i11 + i12);
        for (a aVarN = N(iU); aVarN != null; aVarN = aVarN.f67103i) {
            if (aVarN.f67084b == 130 && aVarN.f67102h == iU && aVarN.f67088f == j11) {
                return aVarN.f67089g;
            }
        }
        a[] aVarArr = this.f67101l;
        int I = I(this.f67090a.p(aVarArr[i11].f67087e, aVarArr[i12].f67087e));
        c0(new a(this.f67100k, TsExtractor.TS_STREAM_TYPE_HDMV_DTS, j11, iU)).f67089g = I;
        return I;
    }

    public int I(String str) {
        int iW = W(128, str);
        for (a aVarN = N(iW); aVarN != null; aVarN = aVarN.f67103i) {
            if (aVarN.f67084b == 128 && aVarN.f67102h == iW && aVarN.f67087e.equals(str)) {
                return aVarN.f67083a;
            }
        }
        return J(new a(this.f67100k, 128, str, iW));
    }

    public final int J(a aVar) {
        if (this.f67101l == null) {
            this.f67101l = new a[16];
        }
        int i11 = this.f67100k;
        a[] aVarArr = this.f67101l;
        if (i11 == aVarArr.length) {
            a[] aVarArr2 = new a[aVarArr.length * 2];
            System.arraycopy(aVarArr, 0, aVarArr2, 0, aVarArr.length);
            this.f67101l = aVarArr2;
        }
        a[] aVarArr3 = this.f67101l;
        int i12 = this.f67100k;
        this.f67100k = i12 + 1;
        aVarArr3[i12] = aVar;
        return c0(aVar).f67083a;
    }

    public int K(String str, int i11) {
        int iX = X(TsExtractor.TS_STREAM_TYPE_AC3, str, i11);
        for (a aVarN = N(iX); aVarN != null; aVarN = aVarN.f67103i) {
            if (aVarN.f67084b == 129 && aVarN.f67102h == iX && aVarN.f67088f == i11 && aVarN.f67087e.equals(str)) {
                return aVarN.f67083a;
            }
        }
        return J(new a(this.f67100k, TsExtractor.TS_STREAM_TYPE_AC3, str, i11, iX));
    }

    public int L() {
        if (this.f67099j == null) {
            return 0;
        }
        D("BootstrapMethods");
        return this.f67099j.f66921b + 8;
    }

    public final void M(e eVar, char[] cArr) {
        byte[] bArr = eVar.f66922a;
        int iE = eVar.e();
        for (int iH = eVar.H(iE - 2); iH > 0; iH--) {
            if ("BootstrapMethods".equals(eVar.G(iE, cArr))) {
                this.f67098i = eVar.H(iE + 6);
                break;
            }
            iE += eVar.t(iE + 2) + 6;
        }
        if (this.f67098i > 0) {
            int i11 = iE + 8;
            int iT = eVar.t(iE + 2) - 2;
            d dVar = new d(iT);
            this.f67099j = dVar;
            dVar.h(bArr, i11, iT);
            int i12 = i11;
            for (int i13 = 0; i13 < this.f67098i; i13++) {
                int i14 = i12 - i11;
                int iH2 = eVar.H(i12);
                int iH3 = eVar.H(i12 + 2);
                i12 += 4;
                int iHashCode = eVar.o(iH2, cArr).hashCode();
                while (true) {
                    int i15 = iH3 - 1;
                    if (iH3 > 0) {
                        int iH4 = eVar.H(i12);
                        i12 += 2;
                        iHashCode ^= eVar.o(iH4, cArr).hashCode();
                        iH3 = i15;
                    }
                }
                a(new a(i13, 64, i14, iHashCode & Api.BaseClientBuilder.API_PRIORITY_OTHER));
            }
        }
    }

    public final a N(int i11) {
        a[] aVarArr = this.f67095f;
        return aVarArr[i11 % aVarArr.length];
    }

    public String O() {
        return this.f67093d;
    }

    public int P() {
        return this.f67096g;
    }

    public int Q() {
        return this.f67097h.f66921b;
    }

    public int R() {
        return this.f67092c;
    }

    public e S() {
        return this.f67091b;
    }

    public w T(int i11) {
        return this.f67101l[i11];
    }

    public final void a(a aVar) {
        this.f67094e++;
        int i11 = aVar.f67102h;
        a[] aVarArr = this.f67095f;
        int length = i11 % aVarArr.length;
        aVar.f67103i = aVarArr[length];
        aVarArr[length] = aVar;
    }

    public final w b(int i11, int i12, int i13) {
        byte[] bArr = this.f67099j.f66920a;
        for (a aVarN = N(i13); aVarN != null; aVarN = aVarN.f67103i) {
            if (aVarN.f67084b == 64 && aVarN.f67102h == i13) {
                int i14 = (int) aVarN.f67088f;
                int i15 = 0;
                while (true) {
                    if (i15 >= i12) {
                        this.f67099j.f66921b = i11;
                        return aVarN;
                    }
                    if (bArr[i11 + i15] != bArr[i14 + i15]) {
                        break;
                    }
                    i15++;
                }
            }
        }
        int i16 = this.f67098i;
        this.f67098i = i16 + 1;
        return c0(new a(i16, 64, i11, i13));
    }

    public w c(o oVar, Object... objArr) {
        d dVar = this.f67099j;
        if (dVar == null) {
            dVar = new d();
            this.f67099j = dVar;
        }
        for (Object obj : objArr) {
            d(obj);
        }
        int i11 = dVar.f66921b;
        dVar.k(u(oVar.d(), oVar.c(), oVar.b(), oVar.a(), oVar.e()).f67083a);
        dVar.k(objArr.length);
        for (Object obj2 : objArr) {
            dVar.k(d(obj2).f67083a);
        }
        int i12 = dVar.f66921b - i11;
        int iHashCode = oVar.hashCode();
        for (Object obj3 : objArr) {
            iHashCode ^= obj3.hashCode();
        }
        return b(i11, i12, iHashCode & Api.BaseClientBuilder.API_PRIORITY_OTHER);
    }

    public final a c0(a aVar) {
        int i11 = this.f67094e;
        a[] aVarArr = this.f67095f;
        if (i11 > (aVarArr.length * 3) / 4) {
            int length = aVarArr.length;
            int i12 = (length * 2) + 1;
            a[] aVarArr2 = new a[i12];
            for (int i13 = length - 1; i13 >= 0; i13--) {
                a aVar2 = this.f67095f[i13];
                while (aVar2 != null) {
                    int i14 = aVar2.f67102h % i12;
                    a aVar3 = aVar2.f67103i;
                    aVar2.f67103i = aVarArr2[i14];
                    aVarArr2[i14] = aVar2;
                    aVar2 = aVar3;
                }
            }
            this.f67095f = aVarArr2;
        }
        this.f67094e++;
        int i15 = aVar.f67102h;
        a[] aVarArr3 = this.f67095f;
        int length2 = i15 % aVarArr3.length;
        aVar.f67103i = aVarArr3[length2];
        aVarArr3[length2] = aVar;
        return aVar;
    }

    public w d(Object obj) {
        if (obj instanceof Integer) {
            return l(((Integer) obj).intValue());
        }
        if (obj instanceof Byte) {
            return l(((Byte) obj).intValue());
        }
        if (obj instanceof Character) {
            return l(((Character) obj).charValue());
        }
        if (obj instanceof Short) {
            return l(((Short) obj).intValue());
        }
        if (obj instanceof Boolean) {
            return l(((Boolean) obj).booleanValue() ? 1 : 0);
        }
        if (obj instanceof Float) {
            return k(((Float) obj).floatValue());
        }
        if (obj instanceof Long) {
            return p(((Long) obj).longValue());
        }
        if (obj instanceof Double) {
            return f(((Double) obj).doubleValue());
        }
        if (obj instanceof String) {
            return C((String) obj);
        }
        if (obj instanceof y) {
            y yVar = (y) obj;
            int iL = yVar.l();
            if (iL == 10) {
                return e(yVar.g());
            }
            return iL == 11 ? w(yVar.e()) : e(yVar.e());
        }
        if (obj instanceof o) {
            o oVar = (o) obj;
            return u(oVar.d(), oVar.c(), oVar.b(), oVar.a(), oVar.e());
        }
        if (!(obj instanceof h)) {
            throw new OptimizationNotSupported();
        }
        h hVar = (h) obj;
        return g(hVar.d(), hVar.c(), hVar.a(), hVar.b());
    }

    public void d0(d dVar) {
        if (this.f67099j != null) {
            d dVarK = dVar.k(D("BootstrapMethods")).i(this.f67099j.f66921b + 2).k(this.f67098i);
            d dVar2 = this.f67099j;
            dVarK.h(dVar2.f66920a, 0, dVar2.f66921b);
        }
    }

    public w e(String str) {
        return F(7, str);
    }

    public void e0(d dVar) {
        d dVarK = dVar.k(this.f67096g);
        d dVar2 = this.f67097h;
        dVarK.h(dVar2.f66920a, 0, dVar2.f66921b);
    }

    public w f(double d11) {
        return q(6, Double.doubleToRawLongBits(d11));
    }

    public int f0(int i11, String str) {
        this.f67092c = i11;
        this.f67093d = str;
        return e(str).f67083a;
    }

    public w g(String str, String str2, o oVar, Object... objArr) {
        return h(17, str, str2, c(oVar, objArr).f67083a);
    }

    public final w h(int i11, String str, String str2, int i12) {
        int iZ = Z(i11, str, str2, i12);
        for (a aVarN = N(iZ); aVarN != null; aVarN = aVarN.f67103i) {
            if (aVarN.f67084b == i11 && aVarN.f67102h == iZ && aVarN.f67088f == i12 && aVarN.f67086d.equals(str) && aVarN.f67087e.equals(str2)) {
                return aVarN;
            }
        }
        this.f67097h.f(i11, i12, z(str, str2));
        int i13 = this.f67096g;
        this.f67096g = i13 + 1;
        return c0(new a(i13, i11, null, str, str2, i12, iZ));
    }

    public final void i(int i11, int i12, String str, String str2, int i13) {
        a(new a(i12, i11, null, str, str2, i13, Z(i11, str, str2, i13)));
    }

    public w j(String str, String str2, String str3) {
        return s(9, str, str2, str3);
    }

    public w k(float f11) {
        return m(4, Float.floatToRawIntBits(f11));
    }

    public w l(int i11) {
        return m(3, i11);
    }

    public final w m(int i11, int i12) {
        int iU = U(i11, i12);
        for (a aVarN = N(iU); aVarN != null; aVarN = aVarN.f67103i) {
            if (aVarN.f67084b == i11 && aVarN.f67102h == iU && aVarN.f67088f == i12) {
                return aVarN;
            }
        }
        this.f67097h.g(i11).i(i12);
        int i13 = this.f67096g;
        this.f67096g = i13 + 1;
        return c0(new a(i13, i11, i12, iU));
    }

    public final void n(int i11, int i12, int i13) {
        a(new a(i11, i12, i13, U(i12, i13)));
    }

    public w o(String str, String str2, o oVar, Object... objArr) {
        return h(18, str, str2, c(oVar, objArr).f67083a);
    }

    public w p(long j11) {
        return q(5, j11);
    }

    public final w q(int i11, long j11) {
        int iV = V(i11, j11);
        for (a aVarN = N(iV); aVarN != null; aVarN = aVarN.f67103i) {
            if (aVarN.f67084b == i11 && aVarN.f67102h == iV && aVarN.f67088f == j11) {
                return aVarN;
            }
        }
        int i12 = this.f67096g;
        this.f67097h.g(i11).j(j11);
        this.f67096g += 2;
        return c0(new a(i12, i11, j11, iV));
    }

    public final void r(int i11, int i12, long j11) {
        a(new a(i11, i12, j11, V(i12, j11)));
    }

    public final a s(int i11, String str, String str2, String str3) {
        int iA0 = a0(i11, str, str2, str3);
        for (a aVarN = N(iA0); aVarN != null; aVarN = aVarN.f67103i) {
            if (aVarN.f67084b == i11 && aVarN.f67102h == iA0 && aVarN.f67085c.equals(str) && aVarN.f67086d.equals(str2) && aVarN.f67087e.equals(str3)) {
                return aVarN;
            }
        }
        this.f67097h.f(i11, e(str).f67083a, z(str2, str3));
        int i12 = this.f67096g;
        this.f67096g = i12 + 1;
        return c0(new a(i12, i11, str, str2, str3, 0L, iA0));
    }

    public final void t(int i11, int i12, String str, String str2, String str3) {
        a(new a(i11, i12, str, str2, str3, 0L, a0(i12, str, str2, str3)));
    }

    public w u(int i11, String str, String str2, String str3, boolean z11) {
        int iB0 = b0(15, str, str2, str3, i11);
        for (a aVarN = N(iB0); aVarN != null; aVarN = aVarN.f67103i) {
            if (aVarN.f67084b == 15 && aVarN.f67102h == iB0 && aVarN.f67088f == i11 && aVarN.f67085c.equals(str) && aVarN.f67086d.equals(str2) && aVarN.f67087e.equals(str3)) {
                return aVarN;
            }
        }
        if (i11 <= 4) {
            this.f67097h.d(15, i11, j(str, str2, str3).f67083a);
        } else {
            this.f67097h.d(15, i11, x(str, str2, str3, z11).f67083a);
        }
        int i12 = this.f67096g;
        this.f67096g = i12 + 1;
        return c0(new a(i12, 15, str, str2, str3, i11, iB0));
    }

    public final void v(int i11, int i12, String str, String str2, String str3) {
        a(new a(i11, 15, str, str2, str3, i12, b0(15, str, str2, str3, i12)));
    }

    public w w(String str) {
        return F(16, str);
    }

    public w x(String str, String str2, String str3, boolean z11) {
        return s(z11 ? 11 : 10, str, str2, str3);
    }

    public w y(String str) {
        return F(19, str);
    }

    public int z(String str, String str2) {
        int iY = Y(12, str, str2);
        for (a aVarN = N(iY); aVarN != null; aVarN = aVarN.f67103i) {
            if (aVarN.f67084b == 12 && aVarN.f67102h == iY && aVarN.f67086d.equals(str) && aVarN.f67087e.equals(str2)) {
                return aVarN.f67083a;
            }
        }
        this.f67097h.f(12, D(str), D(str2));
        int i11 = this.f67096g;
        this.f67096g = i11 + 1;
        return c0(new a(i11, 12, str, str2, iY)).f67083a;
    }
}
