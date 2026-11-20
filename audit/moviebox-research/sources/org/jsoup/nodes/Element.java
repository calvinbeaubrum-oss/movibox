package org.jsoup.nodes;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import org.jsoup.helper.ChangeNotifyingArrayList;
import org.jsoup.select.Elements;
import org.jsoup.select.Selector;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class Element extends g {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final List<g> f73079i = Collections.emptyList();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Pattern f73080j = Pattern.compile("\\s+");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public org.jsoup.parser.f f73081c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public WeakReference<List<Element>> f73082d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List<g> f73083f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public b f73084g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f73085h;

    /* JADX INFO: compiled from: source.java */
    public static final class NodeList extends ChangeNotifyingArrayList<g> {
        private final Element owner;

        public NodeList(Element element, int i11) {
            super(i11);
            this.owner = element;
        }

        @Override // org.jsoup.helper.ChangeNotifyingArrayList
        public void onContentsChanged() {
            this.owner.F();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class a implements g30.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ StringBuilder f73086a;

        public a(StringBuilder sb2) {
            this.f73086a = sb2;
        }

        @Override // g30.a
        public void a(g gVar, int i11) {
            if ((gVar instanceof Element) && ((Element) gVar).K0() && (gVar.D() instanceof i) && !i.h0(this.f73086a)) {
                this.f73086a.append(' ');
            }
        }

        @Override // g30.a
        public void b(g gVar, int i11) {
            if (gVar instanceof i) {
                Element.k0(this.f73086a, (i) gVar);
            } else if (gVar instanceof Element) {
                Element element = (Element) gVar;
                if (this.f73086a.length() > 0) {
                    if ((element.K0() || element.f73081c.b().equals(TtmlNode.TAG_BR)) && !i.h0(this.f73086a)) {
                        this.f73086a.append(' ');
                    }
                }
            }
        }
    }

    public Element(org.jsoup.parser.f fVar, String str) {
        this(fVar, str, null);
    }

    public Element(org.jsoup.parser.f fVar, String str, b bVar) {
        d30.d.j(fVar);
        d30.d.j(str);
        this.f73083f = f73079i;
        this.f73085h = str;
        this.f73084g = bVar;
        this.f73081c = fVar;
    }

    public static <E extends Element> int I0(Element element, List<E> list) {
        for (int i11 = 0; i11 < list.size(); i11++) {
            if (list.get(i11) == element) {
                return i11;
            }
        }
        return 0;
    }

    public static boolean R0(g gVar) {
        if (gVar != null && (gVar instanceof Element)) {
            Element elementL = (Element) gVar;
            int i11 = 0;
            while (!elementL.f73081c.h()) {
                elementL = elementL.L();
                i11++;
                if (i11 >= 6 || elementL == null) {
                }
            }
            return true;
        }
        return false;
    }

    public static void f0(Element element, Elements elements) {
        Element elementL = element.L();
        if (elementL == null || elementL.X0().equals("#root")) {
            return;
        }
        elements.add(elementL);
        f0(elementL, elements);
    }

    public static void k0(StringBuilder sb2, i iVar) {
        String strF0 = iVar.f0();
        if (R0(iVar.f73102a) || (iVar instanceof c)) {
            sb2.append(strF0);
        } else {
            d30.c.a(sb2, strF0, i.h0(sb2));
        }
    }

    public static void l0(Element element, StringBuilder sb2) {
        if (!element.f73081c.b().equals(TtmlNode.TAG_BR) || i.h0(sb2)) {
            return;
        }
        sb2.append(" ");
    }

    @Override // org.jsoup.nodes.g
    public boolean A() {
        return this.f73084g != null;
    }

    public Elements A0() {
        return org.jsoup.select.a.a(new org.jsoup.select.c.a(), this);
    }

    public Elements B0(String str) {
        d30.d.h(str);
        return org.jsoup.select.a.a(new org.jsoup.select.c.j0(e30.b.b(str)), this);
    }

    public boolean C0(String str) {
        String strY = j().y("class");
        int length = strY.length();
        int length2 = str.length();
        if (length != 0 && length >= length2) {
            if (length == length2) {
                return str.equalsIgnoreCase(strY);
            }
            boolean z11 = false;
            int i11 = 0;
            for (int i12 = 0; i12 < length; i12++) {
                if (Character.isWhitespace(strY.charAt(i12))) {
                    if (!z11) {
                        continue;
                    } else {
                        if (i12 - i11 == length2 && strY.regionMatches(true, i11, str, 0, length2)) {
                            return true;
                        }
                        z11 = false;
                    }
                } else if (!z11) {
                    i11 = i12;
                    z11 = true;
                }
            }
            if (z11 && length - i11 == length2) {
                return strY.regionMatches(true, i11, str, 0, length2);
            }
        }
        return false;
    }

    public boolean D0() {
        for (g gVar : this.f73083f) {
            if (gVar instanceof i) {
                if (!((i) gVar).g0()) {
                    return true;
                }
            } else if ((gVar instanceof Element) && ((Element) gVar).D0()) {
                return true;
            }
        }
        return false;
    }

    @Override // org.jsoup.nodes.g
    public String E() {
        return this.f73081c.b();
    }

    public String E0() {
        StringBuilder sbO = d30.c.o();
        G0(sbO);
        boolean zL = y().l();
        String string = sbO.toString();
        return zL ? string.trim() : string;
    }

    @Override // org.jsoup.nodes.g
    public void F() {
        super.F();
        this.f73082d = null;
    }

    public Element F0(String str) {
        z0();
        i0(str);
        return this;
    }

    public final void G0(StringBuilder sb2) {
        Iterator<g> it = this.f73083f.iterator();
        while (it.hasNext()) {
            it.next().H(sb2);
        }
    }

    public String H0() {
        return j().y("id");
    }

    @Override // org.jsoup.nodes.g
    public void I(Appendable appendable, int i11, Document.OutputSettings outputSettings) throws IOException {
        if (outputSettings.l() && ((this.f73081c.a() || ((L() != null && L().W0().a()) || outputSettings.j())) && (!(appendable instanceof StringBuilder) || ((StringBuilder) appendable).length() > 0))) {
            C(appendable, i11, outputSettings);
        }
        appendable.append('<').append(X0());
        b bVar = this.f73084g;
        if (bVar != null) {
            bVar.C(appendable, outputSettings);
        }
        if (!this.f73083f.isEmpty() || !this.f73081c.g()) {
            appendable.append('>');
        } else if (outputSettings.m() == Document.OutputSettings.Syntax.html && this.f73081c.d()) {
            appendable.append('>');
        } else {
            appendable.append(" />");
        }
    }

    @Override // org.jsoup.nodes.g
    public void J(Appendable appendable, int i11, Document.OutputSettings outputSettings) throws IOException {
        if (this.f73083f.isEmpty() && this.f73081c.g()) {
            return;
        }
        if (outputSettings.l() && !this.f73083f.isEmpty() && (this.f73081c.a() || (outputSettings.j() && (this.f73083f.size() > 1 || (this.f73083f.size() == 1 && !(this.f73083f.get(0) instanceof i)))))) {
            C(appendable, i11, outputSettings);
        }
        appendable.append("</").append(X0()).append('>');
    }

    public boolean J0(org.jsoup.select.c cVar) {
        return cVar.a((Element) U(), this);
    }

    public boolean K0() {
        return this.f73081c.c();
    }

    public Element L0() {
        if (this.f73102a == null) {
            return null;
        }
        List<Element> listQ0 = L().q0();
        Integer numValueOf = Integer.valueOf(I0(this, listQ0));
        d30.d.j(numValueOf);
        if (listQ0.size() > numValueOf.intValue() + 1) {
            return listQ0.get(numValueOf.intValue() + 1);
        }
        return null;
    }

    public String M0() {
        StringBuilder sb2 = new StringBuilder();
        N0(sb2);
        return sb2.toString().trim();
    }

    public final void N0(StringBuilder sb2) {
        for (g gVar : this.f73083f) {
            if (gVar instanceof i) {
                k0(sb2, (i) gVar);
            } else if (gVar instanceof Element) {
                l0((Element) gVar, sb2);
            }
        }
    }

    @Override // org.jsoup.nodes.g
    /* JADX INFO: renamed from: O0, reason: merged with bridge method [inline-methods] */
    public final Element L() {
        return (Element) this.f73102a;
    }

    public Elements P0() {
        Elements elements = new Elements();
        f0(this, elements);
        return elements;
    }

    public Element Q0(String str) {
        d30.d.j(str);
        List<g> listD = org.jsoup.parser.e.d(str, this, k());
        b(0, (g[]) listD.toArray(new g[listD.size()]));
        return this;
    }

    public Element S0() {
        if (this.f73102a == null) {
            return null;
        }
        List<Element> listQ0 = L().q0();
        Integer numValueOf = Integer.valueOf(I0(this, listQ0));
        d30.d.j(numValueOf);
        if (numValueOf.intValue() > 0) {
            return listQ0.get(numValueOf.intValue() - 1);
        }
        return null;
    }

    public Element T0(String str) {
        d30.d.j(str);
        Set<String> setT0 = t0();
        setT0.remove(str);
        u0(setT0);
        return this;
    }

    public Elements U0(String str) {
        return Selector.c(str, this);
    }

    public Elements V0() {
        if (this.f73102a == null) {
            return new Elements(0);
        }
        List<Element> listQ0 = L().q0();
        Elements elements = new Elements(listQ0.size() - 1);
        for (Element element : listQ0) {
            if (element != this) {
                elements.add(element);
            }
        }
        return elements;
    }

    public org.jsoup.parser.f W0() {
        return this.f73081c;
    }

    public String X0() {
        return this.f73081c.b();
    }

    public Element Y0(String str) {
        d30.d.i(str, "Tag name must not be empty.");
        this.f73081c = org.jsoup.parser.f.l(str, org.jsoup.parser.d.f73172d);
        return this;
    }

    public String Z0() {
        StringBuilder sb2 = new StringBuilder();
        org.jsoup.select.d.c(new a(sb2), this);
        return sb2.toString().trim();
    }

    public Element a1(String str) {
        d30.d.j(str);
        z0();
        j0(new i(str));
        return this;
    }

    public List<i> b1() {
        ArrayList arrayList = new ArrayList();
        for (g gVar : this.f73083f) {
            if (gVar instanceof i) {
                arrayList.add((i) gVar);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public Element c1(String str) {
        d30.d.j(str);
        Set<String> setT0 = t0();
        if (setT0.contains(str)) {
            setT0.remove(str);
        } else {
            setT0.add(str);
        }
        u0(setT0);
        return this;
    }

    public String d1() {
        return X0().equals("textarea") ? Z0() : g(AppMeasurementSdk.ConditionalUserProperty.VALUE);
    }

    public Element e1(String str) {
        if (X0().equals("textarea")) {
            a1(str);
        } else {
            m0(AppMeasurementSdk.ConditionalUserProperty.VALUE, str);
        }
        return this;
    }

    public Element f1(String str) {
        return (Element) super.c0(str);
    }

    public Element g0(String str) {
        d30.d.j(str);
        Set<String> setT0 = t0();
        setT0.add(str);
        u0(setT0);
        return this;
    }

    public Element h0(String str) {
        return (Element) super.f(str);
    }

    public Element i0(String str) {
        d30.d.j(str);
        List<g> listD = org.jsoup.parser.e.d(str, this, k());
        c((g[]) listD.toArray(new g[listD.size()]));
        return this;
    }

    @Override // org.jsoup.nodes.g
    public b j() {
        if (!A()) {
            this.f73084g = new b();
        }
        return this.f73084g;
    }

    public Element j0(g gVar) {
        d30.d.j(gVar);
        R(gVar);
        v();
        this.f73083f.add(gVar);
        gVar.X(this.f73083f.size() - 1);
        return this;
    }

    @Override // org.jsoup.nodes.g
    public String k() {
        return this.f73085h;
    }

    public Element m0(String str, String str2) {
        super.h(str, str2);
        return this;
    }

    public Element n0(String str) {
        return (Element) super.l(str);
    }

    @Override // org.jsoup.nodes.g
    public int o() {
        return this.f73083f.size();
    }

    public Element o0(g gVar) {
        return (Element) super.m(gVar);
    }

    public Element p0(int i11) {
        return q0().get(i11);
    }

    public final List<Element> q0() {
        List<Element> list;
        WeakReference<List<Element>> weakReference = this.f73082d;
        if (weakReference != null && (list = weakReference.get()) != null) {
            return list;
        }
        int size = this.f73083f.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i11 = 0; i11 < size; i11++) {
            g gVar = this.f73083f.get(i11);
            if (gVar instanceof Element) {
                arrayList.add((Element) gVar);
            }
        }
        this.f73082d = new WeakReference<>(arrayList);
        return arrayList;
    }

    public Elements r0() {
        return new Elements(q0());
    }

    public String s0() {
        return g("class").trim();
    }

    @Override // org.jsoup.nodes.g
    public void t(String str) {
        this.f73085h = str;
    }

    public Set<String> t0() {
        LinkedHashSet linkedHashSet = new LinkedHashSet(Arrays.asList(f73080j.split(s0())));
        linkedHashSet.remove("");
        return linkedHashSet;
    }

    @Override // org.jsoup.nodes.g
    public String toString() {
        return G();
    }

    public Element u0(Set<String> set) {
        d30.d.j(set);
        if (set.isEmpty()) {
            j().K("class");
        } else {
            j().G("class", d30.c.i(set, " "));
        }
        return this;
    }

    @Override // org.jsoup.nodes.g
    public List<g> v() {
        if (this.f73083f == f73079i) {
            this.f73083f = new NodeList(this, 4);
        }
        return this.f73083f;
    }

    @Override // org.jsoup.nodes.g
    public Element v0() {
        return (Element) super.v0();
    }

    public String w0() {
        StringBuilder sb2 = new StringBuilder();
        for (g gVar : this.f73083f) {
            if (gVar instanceof e) {
                sb2.append(((e) gVar).f0());
            } else if (gVar instanceof d) {
                sb2.append(((d) gVar).f0());
            } else if (gVar instanceof Element) {
                sb2.append(((Element) gVar).w0());
            } else if (gVar instanceof c) {
                sb2.append(((c) gVar).f0());
            }
        }
        return sb2.toString();
    }

    @Override // org.jsoup.nodes.g
    /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
    public Element s(g gVar) {
        Element element = (Element) super.s(gVar);
        b bVar = this.f73084g;
        element.f73084g = bVar != null ? bVar.clone() : null;
        element.f73085h = this.f73085h;
        NodeList nodeList = new NodeList(element, this.f73083f.size());
        element.f73083f = nodeList;
        nodeList.addAll(this.f73083f);
        return element;
    }

    public int y0() {
        if (L() == null) {
            return 0;
        }
        return I0(this, L().q0());
    }

    public Element z0() {
        this.f73083f.clear();
        return this;
    }
}
