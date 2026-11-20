package org.jsoup.nodes;

import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class f extends f30.c {
    public f(String str, String str2, String str3) {
        d30.d.j(str);
        d30.d.j(str2);
        d30.d.j(str3);
        h("name", str);
        h("publicId", str2);
        if (f0("publicId")) {
            h("pubSysKey", "PUBLIC");
        }
        h("systemId", str3);
    }

    @Override // org.jsoup.nodes.g
    public String E() {
        return "#doctype";
    }

    @Override // org.jsoup.nodes.g
    public void I(Appendable appendable, int i11, Document.OutputSettings outputSettings) throws IOException {
        if (outputSettings.m() != Document.OutputSettings.Syntax.html || f0("publicId") || f0("systemId")) {
            appendable.append("<!DOCTYPE");
        } else {
            appendable.append("<!doctype");
        }
        if (f0("name")) {
            appendable.append(" ").append(g("name"));
        }
        if (f0("pubSysKey")) {
            appendable.append(" ").append(g("pubSysKey"));
        }
        if (f0("publicId")) {
            appendable.append(" \"").append(g("publicId")).append('\"');
        }
        if (f0("systemId")) {
            appendable.append(" \"").append(g("systemId")).append('\"');
        }
        appendable.append('>');
    }

    @Override // org.jsoup.nodes.g
    public void J(Appendable appendable, int i11, Document.OutputSettings outputSettings) {
    }

    @Override // f30.c, org.jsoup.nodes.g
    public /* bridge */ /* synthetic */ String a(String str) {
        return super.a(str);
    }

    public final boolean f0(String str) {
        return !d30.c.e(g(str));
    }

    @Override // f30.c, org.jsoup.nodes.g
    public /* bridge */ /* synthetic */ String g(String str) {
        return super.g(str);
    }

    public void g0(String str) {
        if (str != null) {
            h("pubSysKey", str);
        }
    }

    @Override // f30.c, org.jsoup.nodes.g
    public /* bridge */ /* synthetic */ g h(String str, String str2) {
        return super.h(str, str2);
    }

    @Override // f30.c, org.jsoup.nodes.g
    public /* bridge */ /* synthetic */ String k() {
        return super.k();
    }

    @Override // f30.c, org.jsoup.nodes.g
    public /* bridge */ /* synthetic */ int o() {
        return super.o();
    }

    @Override // f30.c, org.jsoup.nodes.g
    public /* bridge */ /* synthetic */ boolean z(String str) {
        return super.z(str);
    }
}
