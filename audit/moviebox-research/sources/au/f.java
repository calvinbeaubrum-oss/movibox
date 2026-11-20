package au;

import android.content.Context;
import com.transsion.http.request.HttpMethod;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f13796a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f13797b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f13798c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f13799d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f13800e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final HttpMethod f13801f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f13802g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<String, String> f13803h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Context f13804i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f13805j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final com.transsion.http.request.a f13806k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f13807l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final SSLSocketFactory f13808m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final HostnameVerifier f13809n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f13810o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f13811p;

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f13812a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f13813b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f13814c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f13815d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f13816e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f13817f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Object f13818g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public HttpMethod f13819h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f13820i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Context f13821j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public String f13822k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public com.transsion.http.request.a f13823l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public Map<String, String> f13824m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f13825n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public SSLSocketFactory f13826o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public HostnameVerifier f13827p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public boolean f13828q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public boolean f13829r = true;

        public a() {
            zt.a.f82154a.a(this.f13812a);
        }

        public a b(int i11) {
            this.f13813b = i11;
            return this;
        }

        public a c(Context context) {
            this.f13821j = context;
            return this;
        }

        public a d(HttpMethod httpMethod) {
            this.f13819h = httpMethod;
            return this;
        }

        public a e(com.transsion.http.request.a aVar) {
            this.f13823l = aVar;
            return this;
        }

        public a f(Object obj) {
            this.f13818g = obj;
            return this;
        }

        public a g(String str) {
            this.f13817f = str;
            return this;
        }

        public a h(Map<String, String> map) {
            this.f13824m = map;
            return this;
        }

        public a i(HostnameVerifier hostnameVerifier) {
            this.f13827p = hostnameVerifier;
            return this;
        }

        public a j(SSLSocketFactory sSLSocketFactory) {
            this.f13826o = sSLSocketFactory;
            return this;
        }

        public a k(boolean z11) {
            this.f13828q = z11;
            return this;
        }

        public f l() {
            if (this.f13816e == null) {
                throw new IllegalStateException("url == null");
            }
            if (this.f13826o == null) {
                this.f13826o = new b().a();
            }
            if (this.f13827p == null) {
                this.f13827p = new au.a().a();
            }
            return new f(this);
        }

        public a n(int i11) {
            this.f13814c = i11;
            return this;
        }

        public a o(boolean z11) {
            this.f13815d = z11;
            return this;
        }

        public a p(String str) {
            this.f13816e = str;
            return this;
        }

        public a q(boolean z11) {
            this.f13820i = z11;
            return this;
        }

        public a s(boolean z11) {
            this.f13812a = z11;
            zt.a.f82154a.a(z11);
            return this;
        }

        public a v(boolean z11) {
            this.f13829r = z11;
            return this;
        }
    }

    public f(a aVar) {
        this.f13796a = aVar.f13813b;
        this.f13797b = aVar.f13814c;
        boolean unused = aVar.f13815d;
        this.f13798c = aVar.f13816e;
        this.f13799d = aVar.f13817f;
        this.f13800e = aVar.f13818g != null ? aVar.f13818g : this;
        this.f13801f = aVar.f13819h;
        this.f13803h = aVar.f13824m;
        this.f13802g = aVar.f13820i;
        this.f13804i = aVar.f13821j;
        this.f13805j = aVar.f13822k;
        this.f13806k = aVar.f13823l;
        this.f13807l = aVar.f13825n;
        this.f13808m = aVar.f13826o;
        this.f13809n = aVar.f13827p;
        this.f13810o = aVar.f13828q;
        this.f13811p = aVar.f13829r;
    }

    public int a() {
        return this.f13796a;
    }

    public void b(String str) {
        this.f13798c = str;
    }

    public String c() {
        return this.f13799d;
    }

    public com.transsion.http.request.a d() {
        return this.f13806k;
    }

    public Context e() {
        return this.f13804i;
    }

    public Map<String, String> f() {
        return this.f13803h;
    }

    public HostnameVerifier g() {
        return this.f13809n;
    }

    public HttpMethod h() {
        return this.f13801f;
    }

    public String i() {
        return this.f13805j;
    }

    public int j() {
        return this.f13797b;
    }

    public boolean k() {
        return this.f13807l;
    }

    public SSLSocketFactory l() {
        return this.f13808m;
    }

    public Object m() {
        return this.f13800e;
    }

    public String n() {
        return this.f13798c;
    }

    public boolean o() {
        return this.f13810o;
    }

    public boolean p() {
        return this.f13802g;
    }

    public boolean q() {
        return this.f13811p;
    }
}
