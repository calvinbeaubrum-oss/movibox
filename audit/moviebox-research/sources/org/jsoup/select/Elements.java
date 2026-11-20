package org.jsoup.select;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class Elements extends ArrayList<Element> {
    public Elements() {
    }

    public Elements(int i11) {
        super(i11);
    }

    public Elements(Collection<Element> collection) {
        super(collection);
    }

    public Elements(List<Element> list) {
        super(list);
    }

    public Elements(Element... elementArr) {
        super(Arrays.asList(elementArr));
    }

    private Elements siblings(String str, boolean z11, boolean z12) {
        Elements elements = new Elements();
        c cVarT = str != null ? e.t(str) : null;
        for (Element elementL0 : this) {
            do {
                elementL0 = z11 ? elementL0.L0() : elementL0.S0();
                if (elementL0 == null) {
                    break;
                }
                if (cVarT == null) {
                    elements.add(elementL0);
                } else if (elementL0.J0(cVarT)) {
                    elements.add(elementL0);
                }
            } while (z12);
        }
        return elements;
    }

    public Elements addClass(String str) {
        Iterator<Element> it = iterator();
        while (it.hasNext()) {
            it.next().g0(str);
        }
        return this;
    }

    public Elements after(String str) {
        Iterator<Element> it = iterator();
        while (it.hasNext()) {
            it.next().h0(str);
        }
        return this;
    }

    public Elements append(String str) {
        Iterator<Element> it = iterator();
        while (it.hasNext()) {
            it.next().i0(str);
        }
        return this;
    }

    public String attr(String str) {
        for (Element element : this) {
            if (element.z(str)) {
                return element.g(str);
            }
        }
        return "";
    }

    public Elements attr(String str, String str2) {
        Iterator<Element> it = iterator();
        while (it.hasNext()) {
            it.next().m0(str, str2);
        }
        return this;
    }

    public Elements before(String str) {
        Iterator<Element> it = iterator();
        while (it.hasNext()) {
            it.next().n0(str);
        }
        return this;
    }

    @Override // java.util.ArrayList
    public Elements clone() {
        Elements elements = new Elements(size());
        Iterator<Element> it = iterator();
        while (it.hasNext()) {
            elements.add(it.next().v0());
        }
        return elements;
    }

    public List<String> eachAttr(String str) {
        ArrayList arrayList = new ArrayList(size());
        for (Element element : this) {
            if (element.z(str)) {
                arrayList.add(element.g(str));
            }
        }
        return arrayList;
    }

    public List<String> eachText() {
        ArrayList arrayList = new ArrayList(size());
        for (Element element : this) {
            if (element.D0()) {
                arrayList.add(element.Z0());
            }
        }
        return arrayList;
    }

    public Elements empty() {
        Iterator<Element> it = iterator();
        while (it.hasNext()) {
            it.next().z0();
        }
        return this;
    }

    public Elements eq(int i11) {
        return size() > i11 ? new Elements(get(i11)) : new Elements();
    }

    public Elements filter(NodeFilter nodeFilter) {
        d.b(nodeFilter, this);
        return this;
    }

    public Element first() {
        if (isEmpty()) {
            return null;
        }
        return get(0);
    }

    public List<f30.b> forms() {
        ArrayList arrayList = new ArrayList();
        for (Element element : this) {
            if (element instanceof f30.b) {
                arrayList.add((f30.b) element);
            }
        }
        return arrayList;
    }

    public boolean hasAttr(String str) {
        Iterator<Element> it = iterator();
        while (it.hasNext()) {
            if (it.next().z(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasClass(String str) {
        Iterator<Element> it = iterator();
        while (it.hasNext()) {
            if (it.next().C0(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasText() {
        Iterator<Element> it = iterator();
        while (it.hasNext()) {
            if (it.next().D0()) {
                return true;
            }
        }
        return false;
    }

    public String html() {
        StringBuilder sb2 = new StringBuilder();
        for (Element element : this) {
            if (sb2.length() != 0) {
                sb2.append("\n");
            }
            sb2.append(element.E0());
        }
        return sb2.toString();
    }

    public Elements html(String str) {
        Iterator<Element> it = iterator();
        while (it.hasNext()) {
            it.next().F0(str);
        }
        return this;
    }

    public boolean is(String str) {
        c cVarT = e.t(str);
        Iterator<Element> it = iterator();
        while (it.hasNext()) {
            if (it.next().J0(cVarT)) {
                return true;
            }
        }
        return false;
    }

    public Element last() {
        if (isEmpty()) {
            return null;
        }
        return get(size() - 1);
    }

    public Elements next() {
        return siblings(null, true, false);
    }

    public Elements next(String str) {
        return siblings(str, true, false);
    }

    public Elements nextAll() {
        return siblings(null, true, true);
    }

    public Elements nextAll(String str) {
        return siblings(str, true, true);
    }

    public Elements not(String str) {
        return Selector.a(this, Selector.b(str, this));
    }

    public String outerHtml() {
        StringBuilder sb2 = new StringBuilder();
        for (Element element : this) {
            if (sb2.length() != 0) {
                sb2.append("\n");
            }
            sb2.append(element.G());
        }
        return sb2.toString();
    }

    public Elements parents() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<Element> it = iterator();
        while (it.hasNext()) {
            linkedHashSet.addAll(it.next().P0());
        }
        return new Elements(linkedHashSet);
    }

    public Elements prepend(String str) {
        Iterator<Element> it = iterator();
        while (it.hasNext()) {
            it.next().Q0(str);
        }
        return this;
    }

    public Elements prev() {
        return siblings(null, false, false);
    }

    public Elements prev(String str) {
        return siblings(str, false, false);
    }

    public Elements prevAll() {
        return siblings(null, false, true);
    }

    public Elements prevAll(String str) {
        return siblings(str, false, true);
    }

    public Elements remove() {
        Iterator<Element> it = iterator();
        while (it.hasNext()) {
            it.next().O();
        }
        return this;
    }

    public Elements removeAttr(String str) {
        Iterator<Element> it = iterator();
        while (it.hasNext()) {
            it.next().P(str);
        }
        return this;
    }

    public Elements removeClass(String str) {
        Iterator<Element> it = iterator();
        while (it.hasNext()) {
            it.next().T0(str);
        }
        return this;
    }

    public Elements select(String str) {
        return Selector.b(str, this);
    }

    public Elements tagName(String str) {
        Iterator<Element> it = iterator();
        while (it.hasNext()) {
            it.next().Y0(str);
        }
        return this;
    }

    public String text() {
        StringBuilder sb2 = new StringBuilder();
        for (Element element : this) {
            if (sb2.length() != 0) {
                sb2.append(" ");
            }
            sb2.append(element.Z0());
        }
        return sb2.toString();
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return outerHtml();
    }

    public Elements toggleClass(String str) {
        Iterator<Element> it = iterator();
        while (it.hasNext()) {
            it.next().c1(str);
        }
        return this;
    }

    public Elements traverse(g30.a aVar) {
        d.d(aVar, this);
        return this;
    }

    public Elements unwrap() {
        Iterator<Element> it = iterator();
        while (it.hasNext()) {
            it.next().b0();
        }
        return this;
    }

    public String val() {
        return size() > 0 ? first().d1() : "";
    }

    public Elements val(String str) {
        Iterator<Element> it = iterator();
        while (it.hasNext()) {
            it.next().e1(str);
        }
        return this;
    }

    public Elements wrap(String str) {
        d30.d.h(str);
        Iterator<Element> it = iterator();
        while (it.hasNext()) {
            it.next().f1(str);
        }
        return this;
    }
}
