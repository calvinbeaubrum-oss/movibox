package org.jsoup.nodes;

import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class d extends f30.c {
    public d(String str) {
        this.f64539c = str;
    }

    @Override // org.jsoup.nodes.g
    public String E() {
        return "#comment";
    }

    @Override // org.jsoup.nodes.g
    public void I(Appendable appendable, int i11, Document.OutputSettings outputSettings) throws IOException {
        if (outputSettings.l()) {
            C(appendable, i11, outputSettings);
        }
        appendable.append("<!--").append(f0()).append("-->");
    }

    @Override // org.jsoup.nodes.g
    public void J(Appendable appendable, int i11, Document.OutputSettings outputSettings) {
    }

    @Override // f30.c, org.jsoup.nodes.g
    public /* bridge */ /* synthetic */ String a(String str) {
        return super.a(str);
    }

    public String f0() {
        return d0();
    }

    @Override // f30.c, org.jsoup.nodes.g
    public /* bridge */ /* synthetic */ String g(String str) {
        return super.g(str);
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
