package org.jsoup.nodes;

import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class j extends f30.c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f73108f;

    public j(String str, boolean z11) {
        d30.d.j(str);
        this.f64539c = str;
        this.f73108f = z11;
    }

    @Override // org.jsoup.nodes.g
    public String E() {
        return "#declaration";
    }

    @Override // org.jsoup.nodes.g
    public void I(Appendable appendable, int i11, Document.OutputSettings outputSettings) throws IOException {
        appendable.append("<").append(this.f73108f ? "!" : "?").append(d0());
        f0(appendable, outputSettings);
        appendable.append(this.f73108f ? "!" : "?").append(">");
    }

    @Override // org.jsoup.nodes.g
    public void J(Appendable appendable, int i11, Document.OutputSettings outputSettings) {
    }

    @Override // f30.c, org.jsoup.nodes.g
    public /* bridge */ /* synthetic */ String a(String str) {
        return super.a(str);
    }

    public final void f0(Appendable appendable, Document.OutputSettings outputSettings) throws IOException {
        for (a aVar : j()) {
            if (!aVar.getKey().equals(E())) {
                appendable.append(' ');
                aVar.f(appendable, outputSettings);
            }
        }
    }

    @Override // f30.c, org.jsoup.nodes.g
    public /* bridge */ /* synthetic */ String g(String str) {
        return super.g(str);
    }

    public String g0() {
        return d0();
    }

    @Override // f30.c, org.jsoup.nodes.g
    public /* bridge */ /* synthetic */ String k() {
        return super.k();
    }

    @Override // f30.c, org.jsoup.nodes.g
    public /* bridge */ /* synthetic */ int o() {
        return super.o();
    }

    @Override // org.jsoup.nodes.g
    public String toString() {
        return G();
    }

    @Override // f30.c, org.jsoup.nodes.g
    public /* bridge */ /* synthetic */ boolean z(String str) {
        return super.z(str);
    }
}
