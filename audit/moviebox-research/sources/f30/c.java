package f30;

import d30.d;
import java.util.Collections;
import java.util.List;
import org.jsoup.nodes.g;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public abstract class c extends g {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final List<g> f64538d = Collections.emptyList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f64539c;

    @Override // org.jsoup.nodes.g
    public final boolean A() {
        return this.f64539c instanceof org.jsoup.nodes.b;
    }

    @Override // org.jsoup.nodes.g
    public String a(String str) {
        e0();
        return super.a(str);
    }

    public String d0() {
        return g(E());
    }

    public final void e0() {
        if (A()) {
            return;
        }
        Object obj = this.f64539c;
        org.jsoup.nodes.b bVar = new org.jsoup.nodes.b();
        this.f64539c = bVar;
        if (obj != null) {
            bVar.G(E(), (String) obj);
        }
    }

    @Override // org.jsoup.nodes.g
    public String g(String str) {
        d.j(str);
        if (A()) {
            return super.g(str);
        }
        return str.equals(E()) ? (String) this.f64539c : "";
    }

    @Override // org.jsoup.nodes.g
    public g h(String str, String str2) {
        if (A() || !str.equals(E())) {
            e0();
            super.h(str, str2);
        } else {
            this.f64539c = str2;
        }
        return this;
    }

    @Override // org.jsoup.nodes.g
    public final org.jsoup.nodes.b j() {
        e0();
        return (org.jsoup.nodes.b) this.f64539c;
    }

    @Override // org.jsoup.nodes.g
    public String k() {
        return B() ? L().k() : "";
    }

    @Override // org.jsoup.nodes.g
    public int o() {
        return 0;
    }

    @Override // org.jsoup.nodes.g
    public void t(String str) {
    }

    @Override // org.jsoup.nodes.g
    public List<g> v() {
        return f64538d;
    }

    @Override // org.jsoup.nodes.g
    public boolean z(String str) {
        e0();
        return super.z(str);
    }
}
