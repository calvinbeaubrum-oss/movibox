package org.jsoup.nodes;

import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class i extends f30.c {
    public i(String str) {
        this.f64539c = str;
    }

    public static boolean h0(StringBuilder sb2) {
        return sb2.length() != 0 && sb2.charAt(sb2.length() - 1) == ' ';
    }

    @Override // org.jsoup.nodes.g
    public String E() {
        return "#text";
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0024  */
    /* JADX WARN: Code duplicated, block: B:18:0x003a  */
    @Override // org.jsoup.nodes.g
    public void I(Appendable appendable, int i11, Document.OutputSettings outputSettings) throws IOException {
        if (outputSettings.l()) {
            if (Y() == 0) {
                g gVar = this.f73102a;
                if ((gVar instanceof Element) && ((Element) gVar).W0().a() && !g0()) {
                    C(appendable, i11, outputSettings);
                } else if (outputSettings.j() && Z().size() > 0 && !g0()) {
                    C(appendable, i11, outputSettings);
                }
            } else if (outputSettings.j()) {
                C(appendable, i11, outputSettings);
            }
        }
        Entities.e(appendable, d0(), outputSettings, false, outputSettings.l() && (L() instanceof Element) && !Element.R0(L()), false);
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

    public boolean g0() {
        return d30.c.e(d0());
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
