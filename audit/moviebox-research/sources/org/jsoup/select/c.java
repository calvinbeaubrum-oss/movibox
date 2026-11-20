package org.jsoup.select;

import java.util.Iterator;
import java.util.regex.Pattern;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public abstract class c {

    /* JADX INFO: compiled from: source.java */
    public static final class a extends c {
        @Override // org.jsoup.select.c
        public boolean a(Element element, Element element2) {
            return true;
        }

        public String toString() {
            return "*";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class a0 extends o {
        public a0(int i11, int i12) {
            super(i11, i12);
        }

        @Override // org.jsoup.select.c.o
        public int b(Element element, Element element2) {
            return element2.L().r0().size() - element2.y0();
        }

        @Override // org.jsoup.select.c.o
        public String c() {
            return "nth-last-child";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f73233a;

        public b(String str) {
            this.f73233a = str;
        }

        @Override // org.jsoup.select.c
        public boolean a(Element element, Element element2) {
            return element2.z(this.f73233a);
        }

        public String toString() {
            return String.format("[%s]", this.f73233a);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b0 extends o {
        public b0(int i11, int i12) {
            super(i11, i12);
        }

        @Override // org.jsoup.select.c.o
        public int b(Element element, Element element2) {
            Elements elementsR0 = element2.L().r0();
            int i11 = 0;
            for (int iY0 = element2.y0(); iY0 < elementsR0.size(); iY0++) {
                if (elementsR0.get(iY0).W0().equals(element2.W0())) {
                    i11++;
                }
            }
            return i11;
        }

        @Override // org.jsoup.select.c.o
        public String c() {
            return "nth-last-of-type";
        }
    }

    /* JADX INFO: renamed from: org.jsoup.select.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static abstract class AbstractC0791c extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f73234a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f73235b;

        public AbstractC0791c(String str, String str2) {
            d30.d.h(str);
            d30.d.h(str2);
            this.f73234a = e30.b.b(str);
            if ((str2.startsWith("\"") && str2.endsWith("\"")) || (str2.startsWith("'") && str2.endsWith("'"))) {
                str2 = str2.substring(1, str2.length() - 1);
            }
            this.f73235b = e30.b.b(str2);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c0 extends o {
        public c0(int i11, int i12) {
            super(i11, i12);
        }

        @Override // org.jsoup.select.c.o
        public int b(Element element, Element element2) {
            int i11 = 0;
            for (Element element3 : element2.L().r0()) {
                if (element3.W0().equals(element2.W0())) {
                    i11++;
                }
                if (element3 == element2) {
                    break;
                }
            }
            return i11;
        }

        @Override // org.jsoup.select.c.o
        public String c() {
            return "nth-of-type";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class d extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f73236a;

        public d(String str) {
            d30.d.h(str);
            this.f73236a = e30.b.a(str);
        }

        @Override // org.jsoup.select.c
        public boolean a(Element element, Element element2) {
            Iterator<org.jsoup.nodes.a> it = element2.j().j().iterator();
            while (it.hasNext()) {
                if (e30.b.a(it.next().getKey()).startsWith(this.f73236a)) {
                    return true;
                }
            }
            return false;
        }

        public String toString() {
            return String.format("[^%s]", this.f73236a);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class d0 extends c {
        @Override // org.jsoup.select.c
        public boolean a(Element element, Element element2) {
            Element elementL = element2.L();
            return (elementL == null || (elementL instanceof Document) || element2.V0().size() != 0) ? false : true;
        }

        public String toString() {
            return ":only-child";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class e extends AbstractC0791c {
        public e(String str, String str2) {
            super(str, str2);
        }

        @Override // org.jsoup.select.c
        public boolean a(Element element, Element element2) {
            return element2.z(this.f73234a) && this.f73235b.equalsIgnoreCase(element2.g(this.f73234a).trim());
        }

        public String toString() {
            return String.format("[%s=%s]", this.f73234a, this.f73235b);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class e0 extends c {
        @Override // org.jsoup.select.c
        public boolean a(Element element, Element element2) {
            Element elementL = element2.L();
            if (elementL == null || (elementL instanceof Document)) {
                return false;
            }
            Iterator<Element> it = elementL.r0().iterator();
            int i11 = 0;
            while (it.hasNext()) {
                if (it.next().W0().equals(element2.W0())) {
                    i11++;
                }
            }
            return i11 == 1;
        }

        public String toString() {
            return ":only-of-type";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class f extends AbstractC0791c {
        public f(String str, String str2) {
            super(str, str2);
        }

        @Override // org.jsoup.select.c
        public boolean a(Element element, Element element2) {
            return element2.z(this.f73234a) && e30.b.a(element2.g(this.f73234a)).contains(this.f73235b);
        }

        public String toString() {
            return String.format("[%s*=%s]", this.f73234a, this.f73235b);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class f0 extends c {
        @Override // org.jsoup.select.c
        public boolean a(Element element, Element element2) {
            if (element instanceof Document) {
                element = element.p0(0);
            }
            return element2 == element;
        }

        public String toString() {
            return ":root";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class g extends AbstractC0791c {
        public g(String str, String str2) {
            super(str, str2);
        }

        @Override // org.jsoup.select.c
        public boolean a(Element element, Element element2) {
            return element2.z(this.f73234a) && e30.b.a(element2.g(this.f73234a)).endsWith(this.f73235b);
        }

        public String toString() {
            return String.format("[%s$=%s]", this.f73234a, this.f73235b);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class g0 extends c {
        @Override // org.jsoup.select.c
        public boolean a(Element element, Element element2) {
            if (element2 instanceof org.jsoup.nodes.h) {
                return true;
            }
            for (org.jsoup.nodes.i iVar : element2.b1()) {
                org.jsoup.nodes.h hVar = new org.jsoup.nodes.h(org.jsoup.parser.f.k(element2.X0()), element2.k(), element2.j());
                iVar.T(hVar);
                hVar.j0(iVar);
            }
            return false;
        }

        public String toString() {
            return ":matchText";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class h extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f73237a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Pattern f73238b;

        public h(String str, Pattern pattern) {
            this.f73237a = e30.b.b(str);
            this.f73238b = pattern;
        }

        @Override // org.jsoup.select.c
        public boolean a(Element element, Element element2) {
            return element2.z(this.f73237a) && this.f73238b.matcher(element2.g(this.f73237a)).find();
        }

        public String toString() {
            return String.format("[%s~=%s]", this.f73237a, this.f73238b.toString());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class h0 extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Pattern f73239a;

        public h0(Pattern pattern) {
            this.f73239a = pattern;
        }

        @Override // org.jsoup.select.c
        public boolean a(Element element, Element element2) {
            return this.f73239a.matcher(element2.Z0()).find();
        }

        public String toString() {
            return String.format(":matches(%s)", this.f73239a);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class i extends AbstractC0791c {
        public i(String str, String str2) {
            super(str, str2);
        }

        @Override // org.jsoup.select.c
        public boolean a(Element element, Element element2) {
            return !this.f73235b.equalsIgnoreCase(element2.g(this.f73234a));
        }

        public String toString() {
            return String.format("[%s!=%s]", this.f73234a, this.f73235b);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class i0 extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Pattern f73240a;

        public i0(Pattern pattern) {
            this.f73240a = pattern;
        }

        @Override // org.jsoup.select.c
        public boolean a(Element element, Element element2) {
            return this.f73240a.matcher(element2.M0()).find();
        }

        public String toString() {
            return String.format(":matchesOwn(%s)", this.f73240a);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class j extends AbstractC0791c {
        public j(String str, String str2) {
            super(str, str2);
        }

        @Override // org.jsoup.select.c
        public boolean a(Element element, Element element2) {
            return element2.z(this.f73234a) && e30.b.a(element2.g(this.f73234a)).startsWith(this.f73235b);
        }

        public String toString() {
            return String.format("[%s^=%s]", this.f73234a, this.f73235b);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class j0 extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f73241a;

        public j0(String str) {
            this.f73241a = str;
        }

        @Override // org.jsoup.select.c
        public boolean a(Element element, Element element2) {
            return element2.X0().equalsIgnoreCase(this.f73241a);
        }

        public String toString() {
            return String.format("%s", this.f73241a);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class k extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f73242a;

        public k(String str) {
            this.f73242a = str;
        }

        @Override // org.jsoup.select.c
        public boolean a(Element element, Element element2) {
            return element2.C0(this.f73242a);
        }

        public String toString() {
            return String.format(".%s", this.f73242a);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class k0 extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f73243a;

        public k0(String str) {
            this.f73243a = str;
        }

        @Override // org.jsoup.select.c
        public boolean a(Element element, Element element2) {
            return element2.X0().endsWith(this.f73243a);
        }

        public String toString() {
            return String.format("%s", this.f73243a);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class l extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f73244a;

        public l(String str) {
            this.f73244a = e30.b.a(str);
        }

        @Override // org.jsoup.select.c
        public boolean a(Element element, Element element2) {
            return e30.b.a(element2.w0()).contains(this.f73244a);
        }

        public String toString() {
            return String.format(":containsData(%s)", this.f73244a);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class m extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f73245a;

        public m(String str) {
            this.f73245a = e30.b.a(str);
        }

        @Override // org.jsoup.select.c
        public boolean a(Element element, Element element2) {
            return e30.b.a(element2.M0()).contains(this.f73245a);
        }

        public String toString() {
            return String.format(":containsOwn(%s)", this.f73245a);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class n extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f73246a;

        public n(String str) {
            this.f73246a = e30.b.a(str);
        }

        @Override // org.jsoup.select.c
        public boolean a(Element element, Element element2) {
            return e30.b.a(element2.Z0()).contains(this.f73246a);
        }

        public String toString() {
            return String.format(":contains(%s)", this.f73246a);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class o extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f73247a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f73248b;

        public o(int i11, int i12) {
            this.f73247a = i11;
            this.f73248b = i12;
        }

        @Override // org.jsoup.select.c
        public boolean a(Element element, Element element2) {
            Element elementL = element2.L();
            if (elementL == null || (elementL instanceof Document)) {
                return false;
            }
            int iB = b(element, element2);
            int i11 = this.f73247a;
            if (i11 == 0) {
                return iB == this.f73248b;
            }
            int i12 = this.f73248b;
            return (iB - i12) * i11 >= 0 && (iB - i12) % i11 == 0;
        }

        public abstract int b(Element element, Element element2);

        public abstract String c();

        public String toString() {
            if (this.f73247a == 0) {
                return String.format(":%s(%d)", c(), Integer.valueOf(this.f73248b));
            }
            return this.f73248b == 0 ? String.format(":%s(%dn)", c(), Integer.valueOf(this.f73247a)) : String.format(":%s(%dn%+d)", c(), Integer.valueOf(this.f73247a), Integer.valueOf(this.f73248b));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class p extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f73249a;

        public p(String str) {
            this.f73249a = str;
        }

        @Override // org.jsoup.select.c
        public boolean a(Element element, Element element2) {
            return this.f73249a.equals(element2.H0());
        }

        public String toString() {
            return String.format("#%s", this.f73249a);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class q extends r {
        public q(int i11) {
            super(i11);
        }

        @Override // org.jsoup.select.c
        public boolean a(Element element, Element element2) {
            return element2.y0() == this.f73250a;
        }

        public String toString() {
            return String.format(":eq(%d)", Integer.valueOf(this.f73250a));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class r extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f73250a;

        public r(int i11) {
            this.f73250a = i11;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class s extends r {
        public s(int i11) {
            super(i11);
        }

        @Override // org.jsoup.select.c
        public boolean a(Element element, Element element2) {
            return element2.y0() > this.f73250a;
        }

        public String toString() {
            return String.format(":gt(%d)", Integer.valueOf(this.f73250a));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class t extends r {
        public t(int i11) {
            super(i11);
        }

        @Override // org.jsoup.select.c
        public boolean a(Element element, Element element2) {
            return element != element2 && element2.y0() < this.f73250a;
        }

        public String toString() {
            return String.format(":lt(%d)", Integer.valueOf(this.f73250a));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class u extends c {
        @Override // org.jsoup.select.c
        public boolean a(Element element, Element element2) {
            for (org.jsoup.nodes.g gVar : element2.p()) {
                if (!(gVar instanceof org.jsoup.nodes.d) && !(gVar instanceof org.jsoup.nodes.j) && !(gVar instanceof org.jsoup.nodes.f)) {
                    return false;
                }
            }
            return true;
        }

        public String toString() {
            return ":empty";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class v extends c {
        @Override // org.jsoup.select.c
        public boolean a(Element element, Element element2) {
            Element elementL = element2.L();
            return (elementL == null || (elementL instanceof Document) || element2.y0() != 0) ? false : true;
        }

        public String toString() {
            return ":first-child";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class w extends c0 {
        public w() {
            super(0, 1);
        }

        @Override // org.jsoup.select.c.o
        public String toString() {
            return ":first-of-type";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class x extends c {
        @Override // org.jsoup.select.c
        public boolean a(Element element, Element element2) {
            Element elementL = element2.L();
            return (elementL == null || (elementL instanceof Document) || element2.y0() != elementL.r0().size() - 1) ? false : true;
        }

        public String toString() {
            return ":last-child";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class y extends b0 {
        public y() {
            super(0, 1);
        }

        @Override // org.jsoup.select.c.o
        public String toString() {
            return ":last-of-type";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class z extends o {
        public z(int i11, int i12) {
            super(i11, i12);
        }

        @Override // org.jsoup.select.c.o
        public int b(Element element, Element element2) {
            return element2.y0() + 1;
        }

        @Override // org.jsoup.select.c.o
        public String c() {
            return "nth-child";
        }
    }

    public abstract boolean a(Element element, Element element2);
}
