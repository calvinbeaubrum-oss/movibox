package org.jsoup.parser;

import com.google.android.libraries.places.api.model.PlaceTypes;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class b extends i {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public HtmlTreeBuilderState f73156k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public HtmlTreeBuilderState f73157l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f73158m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Element f73159n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public f30.b f73160o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Element f73161p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ArrayList<Element> f73162q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public List<String> f73163r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Token.g f73164s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f73165t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f73166u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f73167v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String[] f73168w = {null};

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final String[] f73153x = {"applet", "caption", "html", "marquee", "object", "table", "td", "th"};

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final String[] f73154y = {"ol", "ul"};

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final String[] f73155z = {"button"};
    public static final String[] A = {"html", "table"};
    public static final String[] B = {"optgroup", "option"};
    public static final String[] C = {"dd", "dt", "li", "optgroup", "option", TtmlNode.TAG_P, "rp", "rt"};
    public static final String[] D = {PlaceTypes.ADDRESS, "applet", "area", "article", "aside", "base", "basefont", "bgsound", "blockquote", TtmlNode.TAG_BODY, TtmlNode.TAG_BR, "button", "caption", TtmlNode.CENTER, "col", "colgroup", "command", "dd", "details", "dir", TtmlNode.TAG_DIV, "dl", "dt", "embed", "fieldset", "figcaption", "figure", "footer", "form", "frame", "frameset", "h1", "h2", "h3", "h4", "h5", "h6", TtmlNode.TAG_HEAD, "header", "hgroup", "hr", "html", "iframe", "img", "input", "isindex", "li", "link", "listing", "marquee", "menu", "meta", "nav", "noembed", "noframes", "noscript", "object", "ol", TtmlNode.TAG_P, "param", "plaintext", "pre", "script", "section", "select", TtmlNode.TAG_STYLE, "summary", "table", "tbody", "td", "textarea", "tfoot", "th", "thead", CampaignEx.JSON_KEY_TITLE, "tr", "ul", "wbr", "xmp"};

    public List<String> A() {
        return this.f73163r;
    }

    public void A0(Element element) {
        this.f73159n = element;
    }

    public ArrayList<Element> B() {
        return this.f73220d;
    }

    public HtmlTreeBuilderState B0() {
        return this.f73156k;
    }

    public boolean C(String str) {
        return F(str, f73155z);
    }

    public void C0(HtmlTreeBuilderState htmlTreeBuilderState) {
        this.f73156k = htmlTreeBuilderState;
    }

    public boolean D(String str) {
        return F(str, f73154y);
    }

    public boolean E(String str) {
        return F(str, null);
    }

    public boolean F(String str, String[] strArr) {
        return I(str, f73153x, strArr);
    }

    public boolean G(String[] strArr) {
        return J(strArr, f73153x, null);
    }

    public boolean H(String str) {
        for (int size = this.f73220d.size() - 1; size >= 0; size--) {
            String strE = this.f73220d.get(size).E();
            if (strE.equals(str)) {
                return true;
            }
            if (!d30.c.c(strE, B)) {
                return false;
            }
        }
        d30.d.a("Should not be reachable");
        return false;
    }

    public final boolean I(String str, String[] strArr, String[] strArr2) {
        String[] strArr3 = this.f73168w;
        strArr3[0] = str;
        return J(strArr3, strArr, strArr2);
    }

    public final boolean J(String[] strArr, String[] strArr2, String[] strArr3) {
        int size = this.f73220d.size();
        int i11 = size - 1;
        int i12 = i11 > 100 ? size - 101 : 0;
        while (i11 >= i12) {
            String strE = this.f73220d.get(i11).E();
            if (d30.c.c(strE, strArr)) {
                return true;
            }
            if (d30.c.c(strE, strArr2)) {
                return false;
            }
            if (strArr3 != null && d30.c.c(strE, strArr3)) {
                return false;
            }
            i11--;
        }
        return false;
    }

    public boolean K(String str) {
        return I(str, A, null);
    }

    public Element L(Token.h hVar) {
        if (!hVar.z()) {
            Element element = new Element(f.l(hVar.A(), this.f73224h), this.f73221e, this.f73224h.a(hVar.f73144j));
            M(element);
            return element;
        }
        Element elementP = P(hVar);
        this.f73220d.add(elementP);
        this.f73218b.u(TokeniserState.Data);
        this.f73218b.k(this.f73164s.m().B(elementP.X0()));
        return elementP;
    }

    public void M(Element element) {
        T(element);
        this.f73220d.add(element);
    }

    public void N(Token.c cVar) {
        org.jsoup.nodes.g eVar;
        String strX0 = a().X0();
        String strQ = cVar.q();
        if (cVar.f()) {
            eVar = new org.jsoup.nodes.c(strQ);
        } else {
            eVar = (strX0.equals("script") || strX0.equals(TtmlNode.TAG_STYLE)) ? new org.jsoup.nodes.e(strQ) : new org.jsoup.nodes.i(strQ);
        }
        a().j0(eVar);
    }

    public void O(Token.d dVar) {
        T(new org.jsoup.nodes.d(dVar.p()));
    }

    public Element P(Token.h hVar) {
        f fVarL = f.l(hVar.A(), this.f73224h);
        Element element = new Element(fVarL, this.f73221e, hVar.f73144j);
        T(element);
        if (hVar.z()) {
            if (!fVarL.f()) {
                fVarL.j();
            } else if (!fVarL.d()) {
                this.f73218b.q("Tag cannot be self closing; not a void tag");
            }
        }
        return element;
    }

    public f30.b Q(Token.h hVar, boolean z11) {
        f30.b bVar = new f30.b(f.l(hVar.A(), this.f73224h), this.f73221e, hVar.f73144j);
        y0(bVar);
        T(bVar);
        if (z11) {
            this.f73220d.add(bVar);
        }
        return bVar;
    }

    public void R(org.jsoup.nodes.g gVar) {
        Element elementJ;
        Element elementY = y("table");
        boolean z11 = false;
        if (elementY == null) {
            elementJ = this.f73220d.get(0);
        } else if (elementY.L() != null) {
            elementJ = elementY.L();
            z11 = true;
        } else {
            elementJ = j(elementY);
        }
        if (!z11) {
            elementJ.j0(gVar);
        } else {
            d30.d.j(elementY);
            elementY.o0(gVar);
        }
    }

    public void S() {
        this.f73162q.add(null);
    }

    public final void T(org.jsoup.nodes.g gVar) {
        f30.b bVar;
        if (this.f73220d.size() == 0) {
            this.f73219c.j0(gVar);
        } else if (X()) {
            R(gVar);
        } else {
            a().j0(gVar);
        }
        if (gVar instanceof Element) {
            Element element = (Element) gVar;
            if (!element.W0().e() || (bVar = this.f73160o) == null) {
                return;
            }
            bVar.g1(element);
        }
    }

    public void U(Element element, Element element2) {
        int iLastIndexOf = this.f73220d.lastIndexOf(element);
        d30.d.d(iLastIndexOf != -1);
        this.f73220d.add(iLastIndexOf + 1, element2);
    }

    public Element V(String str) {
        Element element = new Element(f.l(str, this.f73224h), this.f73221e);
        M(element);
        return element;
    }

    public final boolean W(ArrayList<Element> arrayList, Element element) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size) == element) {
                return true;
            }
        }
        return false;
    }

    public boolean X() {
        return this.f73166u;
    }

    public boolean Y() {
        return this.f73167v;
    }

    public boolean Z(Element element) {
        return W(this.f73162q, element);
    }

    public final boolean a0(Element element, Element element2) {
        return element.E().equals(element2.E()) && element.j().equals(element2.j());
    }

    @Override // org.jsoup.parser.i
    public d b() {
        return d.f73171c;
    }

    public boolean b0(Element element) {
        return d30.c.c(element.E(), D);
    }

    @Override // org.jsoup.parser.i
    public void c(Reader reader, String str, ParseErrorList parseErrorList, d dVar) {
        super.c(reader, str, parseErrorList, dVar);
        this.f73156k = HtmlTreeBuilderState.Initial;
        this.f73157l = null;
        this.f73158m = false;
        this.f73159n = null;
        this.f73160o = null;
        this.f73161p = null;
        this.f73162q = new ArrayList<>();
        this.f73163r = new ArrayList();
        this.f73164s = new Token.g();
        this.f73165t = true;
        this.f73166u = false;
        this.f73167v = false;
    }

    public Element c0() {
        if (this.f73162q.size() <= 0) {
            return null;
        }
        ArrayList<Element> arrayList = this.f73162q;
        return arrayList.get(arrayList.size() - 1);
    }

    public void d0() {
        this.f73157l = this.f73156k;
    }

    @Override // org.jsoup.parser.i
    public boolean e(Token token) {
        this.f73222f = token;
        return this.f73156k.process(token, this);
    }

    public void e0(Element element) {
        if (this.f73158m) {
            return;
        }
        String strA = element.a("href");
        if (strA.length() != 0) {
            this.f73221e = strA;
            this.f73158m = true;
            this.f73219c.V(strA);
        }
    }

    public void f0() {
        this.f73163r = new ArrayList();
    }

    public boolean g0(Element element) {
        return W(this.f73220d, element);
    }

    @Override // org.jsoup.parser.i
    public /* bridge */ /* synthetic */ boolean h(String str, org.jsoup.nodes.b bVar) {
        return super.h(str, bVar);
    }

    public HtmlTreeBuilderState h0() {
        return this.f73157l;
    }

    public List<org.jsoup.nodes.g> i0(String str, Element element, String str2, ParseErrorList parseErrorList, d dVar) {
        Element element2;
        this.f73156k = HtmlTreeBuilderState.Initial;
        c(new StringReader(str), str2, parseErrorList, dVar);
        this.f73161p = element;
        this.f73167v = true;
        if (element != null) {
            if (element.K() != null) {
                this.f73219c.l1(element.K().k1());
            }
            String strX0 = element.X0();
            if (d30.c.b(strX0, CampaignEx.JSON_KEY_TITLE, "textarea")) {
                this.f73218b.u(TokeniserState.Rcdata);
            } else if (d30.c.b(strX0, "iframe", "noembed", "noframes", TtmlNode.TAG_STYLE, "xmp")) {
                this.f73218b.u(TokeniserState.Rawtext);
            } else if (strX0.equals("script")) {
                this.f73218b.u(TokeniserState.ScriptData);
            } else if (!strX0.equals("noscript") && strX0.equals("plaintext")) {
                this.f73218b.u(TokeniserState.Data);
            } else {
                this.f73218b.u(TokeniserState.Data);
            }
            element2 = new Element(f.l("html", dVar), str2);
            this.f73219c.j0(element2);
            this.f73220d.add(element2);
            x0();
            Elements elementsP0 = element.P0();
            elementsP0.add(0, element);
            for (Element element3 : elementsP0) {
                if (element3 instanceof f30.b) {
                    this.f73160o = (f30.b) element3;
                    break;
                }
            }
        } else {
            element2 = null;
        }
        i();
        return element != null ? element2.p() : this.f73219c.p();
    }

    public Element j(Element element) {
        for (int size = this.f73220d.size() - 1; size >= 0; size--) {
            if (this.f73220d.get(size) == element) {
                return this.f73220d.get(size - 1);
            }
        }
        return null;
    }

    public Element j0() {
        return this.f73220d.remove(this.f73220d.size() - 1);
    }

    public void k() {
        while (!this.f73162q.isEmpty() && t0() != null) {
        }
    }

    public void k0(String str) {
        for (int size = this.f73220d.size() - 1; size >= 0 && !this.f73220d.get(size).E().equals(str); size--) {
            this.f73220d.remove(size);
        }
    }

    public final void l(String... strArr) {
        for (int size = this.f73220d.size() - 1; size >= 0; size--) {
            Element element = this.f73220d.get(size);
            if (d30.c.b(element.E(), strArr) || element.E().equals("html")) {
                return;
            }
            this.f73220d.remove(size);
        }
    }

    public void l0(String str) {
        for (int size = this.f73220d.size() - 1; size >= 0; size--) {
            Element element = this.f73220d.get(size);
            this.f73220d.remove(size);
            if (element.E().equals(str)) {
                return;
            }
        }
    }

    public void m() {
        l("tbody", "tfoot", "thead", "template");
    }

    public void m0(String... strArr) {
        for (int size = this.f73220d.size() - 1; size >= 0; size--) {
            Element element = this.f73220d.get(size);
            this.f73220d.remove(size);
            if (d30.c.c(element.E(), strArr)) {
                return;
            }
        }
    }

    public void n() {
        l("table");
    }

    public boolean n0(Token token, HtmlTreeBuilderState htmlTreeBuilderState) {
        this.f73222f = token;
        return htmlTreeBuilderState.process(token, this);
    }

    public void o() {
        l("tr", "template");
    }

    public void o0(Element element) {
        this.f73220d.add(element);
    }

    public void p(HtmlTreeBuilderState htmlTreeBuilderState) {
        if (this.f73223g.canAddError()) {
            this.f73223g.add(new c(this.f73217a.F(), "Unexpected token [%s] when in state [%s]", this.f73222f.o(), htmlTreeBuilderState));
        }
    }

    public void p0(Element element) {
        int i11 = 0;
        for (int size = this.f73162q.size() - 1; size >= 0; size--) {
            Element element2 = this.f73162q.get(size);
            if (element2 == null) {
                break;
            }
            if (a0(element, element2)) {
                i11++;
            }
            if (i11 == 3) {
                this.f73162q.remove(size);
                break;
            }
        }
        this.f73162q.add(element);
    }

    public void q(boolean z11) {
        this.f73165t = z11;
    }

    public void q0() {
        Element elementC0 = c0();
        if (elementC0 == null || g0(elementC0)) {
            return;
        }
        boolean z11 = true;
        int size = this.f73162q.size() - 1;
        int i11 = size;
        while (i11 != 0) {
            i11--;
            elementC0 = this.f73162q.get(i11);
            if (elementC0 == null || g0(elementC0)) {
                z11 = false;
                break;
            }
        }
        while (true) {
            if (!z11) {
                i11++;
                elementC0 = this.f73162q.get(i11);
            }
            d30.d.j(elementC0);
            Element elementV = V(elementC0.E());
            elementV.j().g(elementC0.j());
            this.f73162q.set(i11, elementV);
            if (i11 == size) {
                return;
            } else {
                z11 = false;
            }
        }
    }

    public boolean r() {
        return this.f73165t;
    }

    public void r0(Element element) {
        for (int size = this.f73162q.size() - 1; size >= 0; size--) {
            if (this.f73162q.get(size) == element) {
                this.f73162q.remove(size);
                return;
            }
        }
    }

    public void s() {
        t(null);
    }

    public boolean s0(Element element) {
        for (int size = this.f73220d.size() - 1; size >= 0; size--) {
            if (this.f73220d.get(size) == element) {
                this.f73220d.remove(size);
                return true;
            }
        }
        return false;
    }

    public void t(String str) {
        while (str != null && !a().E().equals(str) && d30.c.c(a().E(), C)) {
            j0();
        }
    }

    public Element t0() {
        int size = this.f73162q.size();
        if (size > 0) {
            return this.f73162q.remove(size - 1);
        }
        return null;
    }

    public String toString() {
        return "TreeBuilder{currentToken=" + this.f73222f + ", state=" + this.f73156k + ", currentElement=" + a() + '}';
    }

    public Element u(String str) {
        for (int size = this.f73162q.size() - 1; size >= 0; size--) {
            Element element = this.f73162q.get(size);
            if (element == null) {
                return null;
            }
            if (element.E().equals(str)) {
                return element;
            }
        }
        return null;
    }

    public void u0(Element element, Element element2) {
        v0(this.f73162q, element, element2);
    }

    public String v() {
        return this.f73221e;
    }

    public final void v0(ArrayList<Element> arrayList, Element element, Element element2) {
        int iLastIndexOf = arrayList.lastIndexOf(element);
        d30.d.d(iLastIndexOf != -1);
        arrayList.set(iLastIndexOf, element2);
    }

    public Document w() {
        return this.f73219c;
    }

    public void w0(Element element, Element element2) {
        v0(this.f73220d, element, element2);
    }

    public f30.b x() {
        return this.f73160o;
    }

    public void x0() {
        boolean z11 = false;
        for (int size = this.f73220d.size() - 1; size >= 0; size--) {
            Element element = this.f73220d.get(size);
            if (size == 0) {
                element = this.f73161p;
                z11 = true;
            }
            String strE = element.E();
            if ("select".equals(strE)) {
                C0(HtmlTreeBuilderState.InSelect);
                return;
            }
            if ("td".equals(strE) || ("th".equals(strE) && !z11)) {
                C0(HtmlTreeBuilderState.InCell);
                return;
            }
            if ("tr".equals(strE)) {
                C0(HtmlTreeBuilderState.InRow);
                return;
            }
            if ("tbody".equals(strE) || "thead".equals(strE) || "tfoot".equals(strE)) {
                C0(HtmlTreeBuilderState.InTableBody);
                return;
            }
            if ("caption".equals(strE)) {
                C0(HtmlTreeBuilderState.InCaption);
                return;
            }
            if ("colgroup".equals(strE)) {
                C0(HtmlTreeBuilderState.InColumnGroup);
                return;
            }
            if ("table".equals(strE)) {
                C0(HtmlTreeBuilderState.InTable);
                return;
            }
            if (TtmlNode.TAG_HEAD.equals(strE)) {
                C0(HtmlTreeBuilderState.InBody);
                return;
            }
            if (TtmlNode.TAG_BODY.equals(strE)) {
                C0(HtmlTreeBuilderState.InBody);
                return;
            }
            if ("frameset".equals(strE)) {
                C0(HtmlTreeBuilderState.InFrameset);
                return;
            } else if ("html".equals(strE)) {
                C0(HtmlTreeBuilderState.BeforeHead);
                return;
            } else {
                if (z11) {
                    C0(HtmlTreeBuilderState.InBody);
                    return;
                }
            }
        }
    }

    public Element y(String str) {
        for (int size = this.f73220d.size() - 1; size >= 0; size--) {
            Element element = this.f73220d.get(size);
            if (element.E().equals(str)) {
                return element;
            }
        }
        return null;
    }

    public void y0(f30.b bVar) {
        this.f73160o = bVar;
    }

    public Element z() {
        return this.f73159n;
    }

    public void z0(boolean z11) {
        this.f73166u = z11;
    }
}
