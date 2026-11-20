package i30;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.google.android.gms.common.api.Api;
import okhttp3.internal.http2.Settings;
import org.mvel2.asm.ClassTooLargeException;
import org.mvel2.asm.MethodTooLargeException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class g extends f {
    public int A;
    public d B;
    public c C;
    public int D;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f66931c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final x f66932d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f66933e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f66934f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f66935g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f66936h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int[] f66937i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public m f66938j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public m f66939k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public s f66940l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public s f66941m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f66942n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public d f66943o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f66944p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f66945q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f66946r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f66947s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public d f66948t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public b f66949u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public b f66950v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public b f66951w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public b f66952x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public u f66953y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f66954z;

    public g(int i11) {
        this(null, i11);
    }

    public g(e eVar, int i11) {
        super(458752);
        this.f66932d = eVar == null ? new x(this) : new x(this, eVar);
        if ((i11 & 2) != 0) {
            this.D = 4;
        } else if ((i11 & 1) != 0) {
            this.D = 1;
        } else {
            this.D = 0;
        }
    }

    @Override // i30.f
    public final void a(int i11, int i12, String str, String str2, String str3, String[] strArr) {
        this.f66931c = i11;
        this.f66933e = i12;
        x xVar = this.f66932d;
        int i13 = i11 & Settings.DEFAULT_INITIAL_WINDOW_SIZE;
        this.f66934f = xVar.f0(i13, str);
        if (str2 != null) {
            this.f66946r = this.f66932d.D(str2);
        }
        this.f66935g = str3 == null ? 0 : this.f66932d.e(str3).f67083a;
        if (strArr != null && strArr.length > 0) {
            int length = strArr.length;
            this.f66936h = length;
            this.f66937i = new int[length];
            for (int i14 = 0; i14 < this.f66936h; i14++) {
                this.f66937i[i14] = this.f66932d.e(strArr[i14]).f67083a;
            }
        }
        if (this.D != 1 || i13 < 51) {
            return;
        }
        this.D = 2;
    }

    @Override // i30.f
    public final a b(String str, boolean z11) {
        d dVar = new d();
        dVar.k(this.f66932d.D(str)).k(0);
        if (z11) {
            b bVar = new b(this.f66932d, dVar, this.f66949u);
            this.f66949u = bVar;
            return bVar;
        }
        b bVar2 = new b(this.f66932d, dVar, this.f66950v);
        this.f66950v = bVar2;
        return bVar2;
    }

    @Override // i30.f
    public final void c(c cVar) {
        cVar.f66917c = this.C;
        this.C = cVar;
    }

    @Override // i30.f
    public final void d() {
    }

    @Override // i30.f
    public final l e(int i11, String str, String str2, String str3, Object obj) {
        m mVar = new m(this.f66932d, i11, str, str2, str3, obj);
        if (this.f66938j == null) {
            this.f66938j = mVar;
        } else {
            this.f66939k.f66982b = mVar;
        }
        this.f66939k = mVar;
        return mVar;
    }

    @Override // i30.f
    public final void f(String str, String str2, String str3, int i11) {
        if (this.f66943o == null) {
            this.f66943o = new d();
        }
        w wVarE = this.f66932d.e(str);
        if (wVarE.f67089g == 0) {
            this.f66942n++;
            this.f66943o.k(wVarE.f67083a);
            this.f66943o.k(str2 == null ? 0 : this.f66932d.e(str2).f67083a);
            this.f66943o.k(str3 != null ? this.f66932d.D(str3) : 0);
            this.f66943o.k(i11);
            wVarE.f67089g = this.f66942n;
        }
    }

    @Override // i30.f
    public final r g(int i11, String str, String str2, String str3, String[] strArr) {
        s sVar = new s(this.f66932d, i11, str, str2, str3, strArr, this.D);
        if (this.f66940l == null) {
            this.f66940l = sVar;
        } else {
            this.f66941m.f67029b = sVar;
        }
        this.f66941m = sVar;
        return sVar;
    }

    @Override // i30.f
    public final t h(String str, int i11, String str2) {
        x xVar = this.f66932d;
        u uVar = new u(xVar, xVar.y(str).f67083a, i11, str2 == null ? 0 : this.f66932d.D(str2));
        this.f66953y = uVar;
        return uVar;
    }

    @Override // i30.f
    public void i(String str) {
        this.f66954z = this.f66932d.e(str).f67083a;
    }

    @Override // i30.f
    public void j(String str) {
        if (this.B == null) {
            this.B = new d();
        }
        this.A++;
        this.B.k(this.f66932d.e(str).f67083a);
    }

    @Override // i30.f
    public final void k(String str, String str2, String str3) {
        this.f66944p = this.f66932d.e(str).f67083a;
        if (str2 == null || str3 == null) {
            return;
        }
        this.f66945q = this.f66932d.z(str2, str3);
    }

    @Override // i30.f
    public final void l(String str, String str2) {
        if (str != null) {
            this.f66947s = this.f66932d.D(str);
        }
        if (str2 != null) {
            this.f66948t = new d().a(str2, 0, Api.BaseClientBuilder.API_PRIORITY_OTHER);
        }
    }

    @Override // i30.f
    public final a m(int i11, z zVar, String str, boolean z11) {
        d dVar = new d();
        a0.a(i11, dVar);
        z.d(zVar, dVar);
        dVar.k(this.f66932d.D(str)).k(0);
        if (z11) {
            b bVar = new b(this.f66932d, dVar, this.f66951w);
            this.f66951w = bVar;
            return bVar;
        }
        b bVar2 = new b(this.f66932d, dVar, this.f66952x);
        this.f66952x = bVar2;
        return bVar2;
    }

    public final c[] n() {
        c.a aVar = new c.a();
        aVar.b(this.C);
        for (m mVar = this.f66938j; mVar != null; mVar = (m) mVar.f66982b) {
            mVar.e(aVar);
        }
        for (s sVar = this.f66940l; sVar != null; sVar = (s) sVar.f67029b) {
            sVar.I(aVar);
        }
        return aVar.d();
    }

    public ClassLoader o() {
        return getClass().getClassLoader();
    }

    public String p(String str, String str2) {
        ClassLoader classLoaderO = o();
        try {
            Class<?> cls = Class.forName(str.replace('/', '.'), false, classLoaderO);
            try {
                Class<?> cls2 = Class.forName(str2.replace('/', '.'), false, classLoaderO);
                if (cls.isAssignableFrom(cls2)) {
                    return str;
                }
                if (cls2.isAssignableFrom(cls)) {
                    return str2;
                }
                if (cls.isInterface() || cls2.isInterface()) {
                    return "java/lang/Object";
                }
                do {
                    cls = cls.getSuperclass();
                } while (!cls.isAssignableFrom(cls2));
                return cls.getName().replace('.', '/');
            } catch (ClassNotFoundException e11) {
                throw new TypeNotPresentException(str2, e11);
            }
        } catch (ClassNotFoundException e12) {
            throw new TypeNotPresentException(str, e12);
        }
    }

    public final byte[] q(byte[] bArr, boolean z11) {
        c[] cVarArrN = n();
        this.f66938j = null;
        this.f66939k = null;
        this.f66940l = null;
        this.f66941m = null;
        this.f66949u = null;
        this.f66950v = null;
        this.f66951w = null;
        this.f66952x = null;
        this.f66953y = null;
        this.f66954z = 0;
        this.A = 0;
        this.B = null;
        this.C = null;
        this.D = z11 ? 3 : 0;
        new e(bArr, 0, false).a(this, cVarArrN, (z11 ? 8 : 0) | 256);
        return r();
    }

    public byte[] r() throws ClassTooLargeException, MethodTooLargeException {
        int iJ;
        int i11;
        int i12;
        int iA = (this.f66936h * 2) + 24;
        int i13 = 0;
        for (m mVar = this.f66938j; mVar != null; mVar = (m) mVar.f66982b) {
            i13++;
            iA += mVar.f();
        }
        int i14 = 0;
        for (s sVar = this.f66940l; sVar != null; sVar = (s) sVar.f67029b) {
            i14++;
            iA += sVar.L();
        }
        d dVar = this.f66943o;
        if (dVar != null) {
            iA += dVar.f66921b + 8;
            this.f66932d.D("InnerClasses");
            iJ = 1;
        } else {
            iJ = 0;
        }
        if (this.f66944p != 0) {
            iJ++;
            iA += 10;
            this.f66932d.D("EnclosingMethod");
        }
        if ((this.f66933e & 4096) != 0 && (this.f66931c & Settings.DEFAULT_INITIAL_WINDOW_SIZE) < 49) {
            iJ++;
            iA += 6;
            this.f66932d.D("Synthetic");
        }
        if (this.f66946r != 0) {
            iJ++;
            iA += 8;
            this.f66932d.D(RequestParameters.SIGNATURE);
        }
        if (this.f66947s != 0) {
            iJ++;
            iA += 8;
            this.f66932d.D("SourceFile");
        }
        d dVar2 = this.f66948t;
        if (dVar2 != null) {
            iJ++;
            iA += dVar2.f66921b + 6;
            this.f66932d.D("SourceDebugExtension");
        }
        if ((this.f66933e & 131072) != 0) {
            iJ++;
            iA += 6;
            this.f66932d.D("Deprecated");
        }
        b bVar = this.f66949u;
        if (bVar != null) {
            iJ++;
            iA += bVar.f("RuntimeVisibleAnnotations");
        }
        b bVar2 = this.f66950v;
        if (bVar2 != null) {
            iJ++;
            iA += bVar2.f("RuntimeInvisibleAnnotations");
        }
        b bVar3 = this.f66951w;
        if (bVar3 != null) {
            iJ++;
            iA += bVar3.f("RuntimeVisibleTypeAnnotations");
        }
        b bVar4 = this.f66952x;
        if (bVar4 != null) {
            iJ++;
            iA += bVar4.f("RuntimeInvisibleTypeAnnotations");
        }
        if (this.f66932d.L() > 0) {
            iJ++;
            iA += this.f66932d.L();
        }
        u uVar = this.f66953y;
        if (uVar != null) {
            iJ += uVar.j();
            iA += this.f66953y.i();
        }
        if (this.f66954z != 0) {
            iJ++;
            iA += 8;
            this.f66932d.D("NestHost");
        }
        d dVar3 = this.B;
        if (dVar3 != null) {
            iJ++;
            iA += dVar3.f66921b + 8;
            this.f66932d.D("NestMembers");
        }
        c cVar = this.C;
        if (cVar != null) {
            int iC = iJ + cVar.c();
            iA += this.C.a(this.f66932d);
            iJ = iC;
        }
        int iQ = iA + this.f66932d.Q();
        int iP = this.f66932d.P();
        if (iP > 65535) {
            throw new ClassTooLargeException(this.f66932d.O(), iP);
        }
        d dVar4 = new d(iQ);
        dVar4.i(-889275714).i(this.f66931c);
        this.f66932d.e0(dVar4);
        dVar4.k((~((this.f66931c & Settings.DEFAULT_INITIAL_WINDOW_SIZE) < 49 ? 4096 : 0)) & this.f66933e).k(this.f66934f).k(this.f66935g);
        dVar4.k(this.f66936h);
        for (int i15 = 0; i15 < this.f66936h; i15++) {
            dVar4.k(this.f66937i[i15]);
        }
        dVar4.k(i13);
        for (m mVar2 = this.f66938j; mVar2 != null; mVar2 = (m) mVar2.f66982b) {
            mVar2.g(dVar4);
        }
        dVar4.k(i14);
        boolean zO = false;
        boolean zN = false;
        for (s sVar2 = this.f66940l; sVar2 != null; sVar2 = (s) sVar2.f67029b) {
            zO |= sVar2.O();
            zN |= sVar2.N();
            sVar2.S(dVar4);
        }
        dVar4.k(iJ);
        if (this.f66943o != null) {
            d dVarK = dVar4.k(this.f66932d.D("InnerClasses")).i(this.f66943o.f66921b + 2).k(this.f66942n);
            d dVar5 = this.f66943o;
            dVarK.h(dVar5.f66920a, 0, dVar5.f66921b);
        }
        if (this.f66944p != 0) {
            dVar4.k(this.f66932d.D("EnclosingMethod")).i(4).k(this.f66944p).k(this.f66945q);
        }
        if ((this.f66933e & 4096) != 0 && (this.f66931c & Settings.DEFAULT_INITIAL_WINDOW_SIZE) < 49) {
            dVar4.k(this.f66932d.D("Synthetic")).i(0);
        }
        if (this.f66946r != 0) {
            i11 = 2;
            dVar4.k(this.f66932d.D(RequestParameters.SIGNATURE)).i(2).k(this.f66946r);
        } else {
            i11 = 2;
        }
        if (this.f66947s != 0) {
            dVar4.k(this.f66932d.D("SourceFile")).i(i11).k(this.f66947s);
        }
        d dVar6 = this.f66948t;
        if (dVar6 != null) {
            int i16 = dVar6.f66921b;
            i12 = 0;
            dVar4.k(this.f66932d.D("SourceDebugExtension")).i(i16).h(this.f66948t.f66920a, 0, i16);
        } else {
            i12 = 0;
        }
        if ((this.f66933e & 131072) != 0) {
            dVar4.k(this.f66932d.D("Deprecated")).i(i12);
        }
        b bVar5 = this.f66949u;
        if (bVar5 != null) {
            bVar5.h(this.f66932d.D("RuntimeVisibleAnnotations"), dVar4);
        }
        b bVar6 = this.f66950v;
        if (bVar6 != null) {
            bVar6.h(this.f66932d.D("RuntimeInvisibleAnnotations"), dVar4);
        }
        b bVar7 = this.f66951w;
        if (bVar7 != null) {
            bVar7.h(this.f66932d.D("RuntimeVisibleTypeAnnotations"), dVar4);
        }
        b bVar8 = this.f66952x;
        if (bVar8 != null) {
            bVar8.h(this.f66932d.D("RuntimeInvisibleTypeAnnotations"), dVar4);
        }
        this.f66932d.d0(dVar4);
        u uVar2 = this.f66953y;
        if (uVar2 != null) {
            uVar2.k(dVar4);
        }
        if (this.f66954z != 0) {
            dVar4.k(this.f66932d.D("NestHost")).i(2).k(this.f66954z);
        }
        if (this.B != null) {
            d dVarK2 = dVar4.k(this.f66932d.D("NestMembers")).i(this.B.f66921b + 2).k(this.A);
            d dVar7 = this.B;
            dVarK2.h(dVar7.f66920a, 0, dVar7.f66921b);
        }
        c cVar2 = this.C;
        if (cVar2 != null) {
            cVar2.e(this.f66932d, dVar4);
        }
        return zN ? q(dVar4.f66920a, zO) : dVar4.f66920a;
    }
}
