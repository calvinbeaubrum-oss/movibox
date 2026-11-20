package ze;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f81897a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f81898b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f81899c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f81900d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f81901e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f81902f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f81903g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final df.b f81904h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final gf.b f81905i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ff.b f81906j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final p008if.b f81907k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final hf.b f81908l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final cf.a f81909m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Map<Class<?>, Object> f81910n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final List<jf.a> f81911o;

    /* JADX INFO: renamed from: ze.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class C0929a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f81912a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f81913b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f81914c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f81915d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f81916e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f81917f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f81918g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public df.b f81919h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public gf.b f81920i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public ff.b f81921j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public p008if.b f81922k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public hf.b f81923l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public cf.a f81924m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public Map<Class<?>, Object> f81925n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public List<jf.a> f81926o;

        public C0929a() {
            this.f81912a = Integer.MIN_VALUE;
            this.f81913b = "X-LOG";
        }

        public C0929a(a aVar) {
            this.f81912a = Integer.MIN_VALUE;
            this.f81913b = "X-LOG";
            this.f81912a = aVar.f81897a;
            this.f81913b = aVar.f81898b;
            this.f81914c = aVar.f81899c;
            this.f81915d = aVar.f81900d;
            this.f81916e = aVar.f81901e;
            this.f81917f = aVar.f81902f;
            this.f81918g = aVar.f81903g;
            this.f81919h = aVar.f81904h;
            this.f81920i = aVar.f81905i;
            this.f81921j = aVar.f81906j;
            this.f81922k = aVar.f81907k;
            this.f81923l = aVar.f81908l;
            this.f81924m = aVar.f81909m;
            if (aVar.f81910n != null) {
                this.f81925n = new HashMap(aVar.f81910n);
            }
            if (aVar.f81911o != null) {
                this.f81926o = new ArrayList(aVar.f81911o);
            }
        }

        public C0929a A(df.b bVar) {
            this.f81919h = bVar;
            return this;
        }

        public C0929a B(int i11) {
            this.f81912a = i11;
            return this;
        }

        public C0929a C(Map<Class<?>, Object> map) {
            this.f81925n = map;
            return this;
        }

        public C0929a D(hf.b bVar) {
            this.f81923l = bVar;
            return this;
        }

        public C0929a E(String str) {
            this.f81913b = str;
            return this;
        }

        public C0929a F(p008if.b bVar) {
            this.f81922k = bVar;
            return this;
        }

        public C0929a G(ff.b bVar) {
            this.f81921j = bVar;
            return this;
        }

        public C0929a H(gf.b bVar) {
            this.f81920i = bVar;
            return this;
        }

        public C0929a p(jf.a aVar) {
            if (this.f81926o == null) {
                this.f81926o = new ArrayList();
            }
            this.f81926o.add(aVar);
            return this;
        }

        public C0929a q(cf.a aVar) {
            this.f81924m = aVar;
            return this;
        }

        public a r() {
            y();
            return new a(this);
        }

        public C0929a s() {
            this.f81918g = false;
            return this;
        }

        public C0929a t() {
            this.f81915d = false;
            this.f81916e = null;
            this.f81917f = 0;
            return this;
        }

        public C0929a u() {
            this.f81914c = false;
            return this;
        }

        public C0929a v() {
            this.f81918g = true;
            return this;
        }

        public C0929a w(String str, int i11) {
            this.f81915d = true;
            this.f81916e = str;
            this.f81917f = i11;
            return this;
        }

        public C0929a x() {
            this.f81914c = true;
            return this;
        }

        public final void y() {
            if (this.f81919h == null) {
                this.f81919h = kf.a.h();
            }
            if (this.f81920i == null) {
                this.f81920i = kf.a.n();
            }
            if (this.f81921j == null) {
                this.f81921j = kf.a.l();
            }
            if (this.f81922k == null) {
                this.f81922k = kf.a.k();
            }
            if (this.f81923l == null) {
                this.f81923l = kf.a.j();
            }
            if (this.f81924m == null) {
                this.f81924m = kf.a.c();
            }
            if (this.f81925n == null) {
                this.f81925n = new HashMap(kf.a.a());
            }
        }

        public C0929a z(List<jf.a> list) {
            this.f81926o = list;
            return this;
        }
    }

    public a(C0929a c0929a) {
        this.f81897a = c0929a.f81912a;
        this.f81898b = c0929a.f81913b;
        this.f81899c = c0929a.f81914c;
        this.f81900d = c0929a.f81915d;
        this.f81901e = c0929a.f81916e;
        this.f81902f = c0929a.f81917f;
        this.f81903g = c0929a.f81918g;
        this.f81904h = c0929a.f81919h;
        this.f81905i = c0929a.f81920i;
        this.f81906j = c0929a.f81921j;
        this.f81907k = c0929a.f81922k;
        this.f81908l = c0929a.f81923l;
        this.f81909m = c0929a.f81924m;
        this.f81910n = c0929a.f81925n;
        this.f81911o = c0929a.f81926o;
    }
}
