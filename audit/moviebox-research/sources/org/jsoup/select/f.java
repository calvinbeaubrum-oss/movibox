package org.jsoup.select;

import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public abstract class f extends org.jsoup.select.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public org.jsoup.select.c f73258a;

    /* JADX INFO: compiled from: source.java */
    public static class a extends f {
        public a(org.jsoup.select.c cVar) {
            this.f73258a = cVar;
        }

        @Override // org.jsoup.select.c
        public boolean a(Element element, Element element2) {
            for (Element element3 : element2.A0()) {
                if (element3 != element2 && this.f73258a.a(element, element3)) {
                    return true;
                }
            }
            return false;
        }

        public String toString() {
            return String.format(":has(%s)", this.f73258a);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b extends f {
        public b(org.jsoup.select.c cVar) {
            this.f73258a = cVar;
        }

        @Override // org.jsoup.select.c
        public boolean a(Element element, Element element2) {
            Element elementL;
            return (element == element2 || (elementL = element2.L()) == null || !this.f73258a.a(element, elementL)) ? false : true;
        }

        public String toString() {
            return String.format(":ImmediateParent%s", this.f73258a);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c extends f {
        public c(org.jsoup.select.c cVar) {
            this.f73258a = cVar;
        }

        @Override // org.jsoup.select.c
        public boolean a(Element element, Element element2) {
            Element elementS0;
            return (element == element2 || (elementS0 = element2.S0()) == null || !this.f73258a.a(element, elementS0)) ? false : true;
        }

        public String toString() {
            return String.format(":prev%s", this.f73258a);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class d extends f {
        public d(org.jsoup.select.c cVar) {
            this.f73258a = cVar;
        }

        @Override // org.jsoup.select.c
        public boolean a(Element element, Element element2) {
            return !this.f73258a.a(element, element2);
        }

        public String toString() {
            return String.format(":not%s", this.f73258a);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class e extends f {
        public e(org.jsoup.select.c cVar) {
            this.f73258a = cVar;
        }

        @Override // org.jsoup.select.c
        public boolean a(Element element, Element element2) {
            if (element == element2) {
                return false;
            }
            for (Element elementL = element2.L(); !this.f73258a.a(element, elementL); elementL = elementL.L()) {
                if (elementL == element) {
                    return false;
                }
            }
            return true;
        }

        public String toString() {
            return String.format(":parent%s", this.f73258a);
        }
    }

    /* JADX INFO: renamed from: org.jsoup.select.f$f, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class C0792f extends f {
        public C0792f(org.jsoup.select.c cVar) {
            this.f73258a = cVar;
        }

        @Override // org.jsoup.select.c
        public boolean a(Element element, Element element2) {
            if (element == element2) {
                return false;
            }
            for (Element elementS0 = element2.S0(); elementS0 != null; elementS0 = elementS0.S0()) {
                if (this.f73258a.a(element, elementS0)) {
                    return true;
                }
            }
            return false;
        }

        public String toString() {
            return String.format(":prev*%s", this.f73258a);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class g extends org.jsoup.select.c {
        @Override // org.jsoup.select.c
        public boolean a(Element element, Element element2) {
            return element == element2;
        }
    }
}
