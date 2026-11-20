package org.jsoup.select;

import org.jsoup.nodes.Element;
import org.jsoup.nodes.g;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class a {

    /* JADX INFO: renamed from: org.jsoup.select.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class C0789a implements g30.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Element f73228a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Elements f73229b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final c f73230c;

        public C0789a(Element element, Elements elements, c cVar) {
            this.f73228a = element;
            this.f73229b = elements;
            this.f73230c = cVar;
        }

        @Override // g30.a
        public void a(g gVar, int i11) {
        }

        @Override // g30.a
        public void b(g gVar, int i11) {
            if (gVar instanceof Element) {
                Element element = (Element) gVar;
                if (this.f73230c.a(this.f73228a, element)) {
                    this.f73229b.add(element);
                }
            }
        }
    }

    public static Elements a(c cVar, Element element) {
        Elements elements = new Elements();
        d.c(new C0789a(element, elements, cVar), element);
        return elements;
    }
}
