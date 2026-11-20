package au;

import com.transsion.http.request.HttpMethod;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f13779a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f13780b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HttpMethod f13781c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f13782d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, String> f13783e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f13784f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f13785g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f13786h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public SSLSocketFactory f13787i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public HostnameVerifier f13788j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f13789k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public f.a f13790l;

    public c(String str, Object obj, HttpMethod httpMethod, Map<String, String> map, boolean z11, int i11, int i12, boolean z12, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, boolean z13) {
        f.a aVar = new f.a();
        this.f13790l = aVar;
        this.f13779a = str;
        this.f13780b = obj;
        this.f13781c = httpMethod;
        this.f13783e = map;
        this.f13782d = z11;
        this.f13784f = i11;
        this.f13785g = i12;
        this.f13786h = z12;
        this.f13787i = sSLSocketFactory;
        this.f13788j = hostnameVerifier;
        this.f13789k = z13;
        aVar.p(str).f(obj).d(httpMethod).h(map).s(z11).b(this.f13784f).n(this.f13785g).o(this.f13786h).j(this.f13787i).i(this.f13788j).v(this.f13789k);
    }

    public vt.b a() {
        return new vt.b(this);
    }

    public abstract f b();

    public f c() {
        return b();
    }
}
