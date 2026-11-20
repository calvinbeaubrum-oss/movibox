package ze;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ze.a f81932a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public nf.c f81933b;

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f81934a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f81935b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f81936c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f81937d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f81938e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f81939f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f81940g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f81941h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f81942i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f81943j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public df.b f81944k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public gf.b f81945l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public ff.b f81946m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public p008if.b f81947n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public hf.b f81948o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public cf.a f81949p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public Map<Class<?>, Object> f81950q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public List<jf.a> f81951r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public nf.c f81952s;

        public a() {
            e.a();
        }

        public d t() {
            return new d(this);
        }

        public void u(Object[] objArr) {
            t().b(objArr);
        }

        public void v(Object[] objArr) {
            t().d(objArr);
        }

        public void w(Object[] objArr) {
            t().f(objArr);
        }

        public a x(String str) {
            this.f81935b = str;
            return this;
        }

        public void y(Object[] objArr) {
            t().j(objArr);
        }

        public void z(Object[] objArr) {
            t().k(objArr);
        }
    }

    public d(ze.a aVar, nf.c cVar) {
        this.f81932a = aVar;
        this.f81933b = cVar;
    }

    public d(a aVar) {
        ze.a.C0929a c0929a = new ze.a.C0929a(e.f81954b);
        if (aVar.f81934a != 0) {
            c0929a.B(aVar.f81934a);
        }
        if (aVar.f81935b != null) {
            c0929a.E(aVar.f81935b);
        }
        if (aVar.f81937d) {
            if (aVar.f81936c) {
                c0929a.x();
            } else {
                c0929a.u();
            }
        }
        if (aVar.f81941h) {
            if (aVar.f81938e) {
                c0929a.w(aVar.f81939f, aVar.f81940g);
            } else {
                c0929a.t();
            }
        }
        if (aVar.f81943j) {
            if (aVar.f81942i) {
                c0929a.v();
            } else {
                c0929a.s();
            }
        }
        if (aVar.f81944k != null) {
            c0929a.A(aVar.f81944k);
        }
        if (aVar.f81945l != null) {
            c0929a.H(aVar.f81945l);
        }
        if (aVar.f81946m != null) {
            c0929a.G(aVar.f81946m);
        }
        if (aVar.f81947n != null) {
            c0929a.F(aVar.f81947n);
        }
        if (aVar.f81948o != null) {
            c0929a.D(aVar.f81948o);
        }
        if (aVar.f81949p != null) {
            c0929a.q(aVar.f81949p);
        }
        if (aVar.f81950q != null) {
            c0929a.C(aVar.f81950q);
        }
        if (aVar.f81951r != null) {
            c0929a.z(aVar.f81951r);
        }
        this.f81932a = c0929a.r();
        if (aVar.f81952s != null) {
            this.f81933b = aVar.f81952s;
        } else {
            this.f81933b = e.f81955c;
        }
    }

    public void a(String str) {
        g(3, str);
    }

    public void b(Object[] objArr) {
        h(3, objArr);
    }

    public void c(String str) {
        g(6, str);
    }

    public void d(Object[] objArr) {
        h(6, objArr);
    }

    public void e(String str) {
        g(4, str);
    }

    public void f(Object[] objArr) {
        h(4, objArr);
    }

    public void g(int i11, String str) {
        if (i11 < this.f81932a.f81897a) {
            return;
        }
        if (str == null) {
            str = "";
        }
        i(i11, str);
    }

    public final void h(int i11, Object[] objArr) {
        if (i11 < this.f81932a.f81897a) {
            return;
        }
        i(i11, Arrays.deepToString(objArr));
    }

    public final void i(int i11, String str) {
        String strA;
        String string;
        ze.a aVar = this.f81932a;
        String str2 = aVar.f81898b;
        String strA2 = aVar.f81899c ? aVar.f81907k.a(Thread.currentThread()) : null;
        ze.a aVar2 = this.f81932a;
        if (aVar2.f81900d) {
            hf.b bVar = aVar2.f81908l;
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            ze.a aVar3 = this.f81932a;
            strA = bVar.a(mf.a.b(stackTrace, aVar3.f81901e, aVar3.f81902f));
        } else {
            strA = null;
        }
        if (this.f81932a.f81911o != null) {
            b bVar2 = new b(i11, str2, strA2, strA, str);
            for (jf.a aVar4 : this.f81932a.f81911o) {
                bVar2 = aVar4.a(bVar2);
                if (bVar2 == null) {
                    return;
                }
                if (bVar2.f81928b == null || bVar2.f81929c == null) {
                    kf.b.e().c("Interceptor " + aVar4 + " should not remove the tag or message of a log, if you don't want to print this log, just return a null when intercept.");
                    return;
                }
            }
            i11 = bVar2.f81927a;
            str2 = bVar2.f81928b;
            strA2 = bVar2.f81930d;
            strA = bVar2.f81931e;
            str = bVar2.f81929c;
        }
        nf.c cVar = this.f81933b;
        ze.a aVar5 = this.f81932a;
        if (aVar5.f81903g) {
            string = aVar5.f81909m.a(new String[]{strA2, strA, str});
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(strA2 != null ? strA2 + kf.c.f68544a : "");
            sb2.append(strA != null ? strA + kf.c.f68544a : "");
            sb2.append(str);
            string = sb2.toString();
        }
        cVar.a(i11, str2, string);
    }

    public void j(Object[] objArr) {
        h(2, objArr);
    }

    public void k(Object[] objArr) {
        h(5, objArr);
    }
}
