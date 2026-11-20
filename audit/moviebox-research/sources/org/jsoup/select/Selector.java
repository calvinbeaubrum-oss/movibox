package org.jsoup.select;

import java.util.ArrayList;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class Selector {

    /* JADX INFO: compiled from: source.java */
    public static class SelectorParseException extends IllegalStateException {
        public SelectorParseException(String str, Object... objArr) {
            super(String.format(str, objArr));
        }
    }

    public static Elements a(Collection<Element> collection, Collection<Element> collection2) {
        Elements elements = new Elements();
        for (Element element : collection) {
            Iterator<Element> it = collection2.iterator();
            do {
                if (!it.hasNext()) {
                    elements.add(element);
                    break;
                }
            } while (!element.equals(it.next()));
        }
        return elements;
    }

    public static Elements b(String str, Iterable<Element> iterable) {
        d30.d.h(str);
        d30.d.j(iterable);
        c cVarT = e.t(str);
        ArrayList arrayList = new ArrayList();
        IdentityHashMap identityHashMap = new IdentityHashMap();
        Iterator<Element> it = iterable.iterator();
        while (it.hasNext()) {
            for (Element element : d(cVarT, it.next())) {
                if (!identityHashMap.containsKey(element)) {
                    arrayList.add(element);
                    identityHashMap.put(element, Boolean.TRUE);
                }
            }
        }
        return new Elements((List<Element>) arrayList);
    }

    public static Elements c(String str, Element element) {
        d30.d.h(str);
        return d(e.t(str), element);
    }

    public static Elements d(c cVar, Element element) {
        d30.d.j(cVar);
        d30.d.j(element);
        return a.a(cVar, element);
    }
}
