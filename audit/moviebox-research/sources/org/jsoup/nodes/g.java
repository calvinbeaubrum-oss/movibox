package org.jsoup.nodes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import org.jsoup.SerializationException;
import org.jsoup.select.Elements;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public abstract class g implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g f73102a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f73103b;

    /* JADX INFO: compiled from: source.java */
    public class a implements g30.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f73104a;

        public a(String str) {
            this.f73104a = str;
        }

        @Override // g30.a
        public void a(g gVar, int i11) {
        }

        @Override // g30.a
        public void b(g gVar, int i11) {
            gVar.t(this.f73104a);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b implements g30.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Appendable f73106a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Document.OutputSettings f73107b;

        public b(Appendable appendable, Document.OutputSettings outputSettings) {
            this.f73106a = appendable;
            this.f73107b = outputSettings;
            outputSettings.k();
        }

        @Override // g30.a
        public void a(g gVar, int i11) {
            if (gVar.E().equals("#text")) {
                return;
            }
            try {
                gVar.J(this.f73106a, i11, this.f73107b);
            } catch (IOException e11) {
                throw new SerializationException(e11);
            }
        }

        @Override // g30.a
        public void b(g gVar, int i11) {
            try {
                gVar.I(this.f73106a, i11, this.f73107b);
            } catch (IOException e11) {
                throw new SerializationException(e11);
            }
        }
    }

    public abstract boolean A();

    public boolean B() {
        return this.f73102a != null;
    }

    public void C(Appendable appendable, int i11, Document.OutputSettings outputSettings) throws IOException {
        appendable.append('\n').append(d30.c.l(i11 * outputSettings.h()));
    }

    public g D() {
        g gVar = this.f73102a;
        if (gVar == null) {
            return null;
        }
        List<g> listV = gVar.v();
        int i11 = this.f73103b + 1;
        if (listV.size() > i11) {
            return listV.get(i11);
        }
        return null;
    }

    public abstract String E();

    public void F() {
    }

    public String G() {
        StringBuilder sb2 = new StringBuilder(128);
        H(sb2);
        return sb2.toString();
    }

    public void H(Appendable appendable) {
        org.jsoup.select.d.c(new b(appendable, y()), this);
    }

    public abstract void I(Appendable appendable, int i11, Document.OutputSettings outputSettings) throws IOException;

    public abstract void J(Appendable appendable, int i11, Document.OutputSettings outputSettings) throws IOException;

    public Document K() {
        g gVarU = U();
        if (gVarU instanceof Document) {
            return (Document) gVarU;
        }
        return null;
    }

    public g L() {
        return this.f73102a;
    }

    public final g M() {
        return this.f73102a;
    }

    public final void N(int i11) {
        List<g> listV = v();
        while (i11 < listV.size()) {
            listV.get(i11).X(i11);
            i11++;
        }
    }

    public void O() {
        d30.d.j(this.f73102a);
        this.f73102a.Q(this);
    }

    public g P(String str) {
        d30.d.j(str);
        j().L(str);
        return this;
    }

    public void Q(g gVar) {
        d30.d.d(gVar.f73102a == this);
        int i11 = gVar.f73103b;
        v().remove(i11);
        N(i11);
        gVar.f73102a = null;
    }

    public void R(g gVar) {
        gVar.W(this);
    }

    public void S(g gVar, g gVar2) {
        d30.d.d(gVar.f73102a == this);
        d30.d.j(gVar2);
        g gVar3 = gVar2.f73102a;
        if (gVar3 != null) {
            gVar3.Q(gVar2);
        }
        int i11 = gVar.f73103b;
        v().set(i11, gVar2);
        gVar2.f73102a = this;
        gVar2.X(i11);
        gVar.f73102a = null;
    }

    public void T(g gVar) {
        d30.d.j(gVar);
        d30.d.j(this.f73102a);
        this.f73102a.S(this, gVar);
    }

    public g U() {
        g gVar = this;
        while (true) {
            g gVar2 = gVar.f73102a;
            if (gVar2 == null) {
                return gVar;
            }
            gVar = gVar2;
        }
    }

    public void V(String str) {
        d30.d.j(str);
        a0(new a(str));
    }

    public void W(g gVar) {
        d30.d.j(gVar);
        g gVar2 = this.f73102a;
        if (gVar2 != null) {
            gVar2.Q(this);
        }
        this.f73102a = gVar;
    }

    public void X(int i11) {
        this.f73103b = i11;
    }

    public int Y() {
        return this.f73103b;
    }

    public List<g> Z() {
        g gVar = this.f73102a;
        if (gVar == null) {
            return Collections.emptyList();
        }
        List<g> listV = gVar.v();
        ArrayList arrayList = new ArrayList(listV.size() - 1);
        for (g gVar2 : listV) {
            if (gVar2 != this) {
                arrayList.add(gVar2);
            }
        }
        return arrayList;
    }

    public String a(String str) {
        d30.d.h(str);
        return !z(str) ? "" : d30.c.m(k(), g(str));
    }

    public g a0(g30.a aVar) {
        d30.d.j(aVar);
        org.jsoup.select.d.c(aVar, this);
        return this;
    }

    public void b(int i11, g... gVarArr) {
        d30.d.f(gVarArr);
        List<g> listV = v();
        for (g gVar : gVarArr) {
            R(gVar);
        }
        listV.addAll(i11, Arrays.asList(gVarArr));
        N(i11);
    }

    public g b0() {
        d30.d.j(this.f73102a);
        List<g> listV = v();
        g gVar = listV.size() > 0 ? listV.get(0) : null;
        this.f73102a.b(this.f73103b, q());
        O();
        return gVar;
    }

    public void c(g... gVarArr) {
        List<g> listV = v();
        for (g gVar : gVarArr) {
            R(gVar);
            listV.add(gVar);
            gVar.X(listV.size() - 1);
        }
    }

    public g c0(String str) {
        d30.d.h(str);
        List<g> listD = org.jsoup.parser.e.d(str, L() instanceof Element ? (Element) L() : null, k());
        g gVar = listD.get(0);
        if (gVar == null || !(gVar instanceof Element)) {
            return null;
        }
        Element element = (Element) gVar;
        Element elementX = x(element);
        this.f73102a.S(this, element);
        elementX.c(this);
        if (listD.size() > 0) {
            for (int i11 = 0; i11 < listD.size(); i11++) {
                g gVar2 = listD.get(i11);
                gVar2.f73102a.Q(gVar2);
                element.j0(gVar2);
            }
        }
        return this;
    }

    public final void d(int i11, String str) {
        d30.d.j(str);
        d30.d.j(this.f73102a);
        List<g> listD = org.jsoup.parser.e.d(str, L() instanceof Element ? (Element) L() : null, k());
        this.f73102a.b(i11, (g[]) listD.toArray(new g[listD.size()]));
    }

    public boolean equals(Object obj) {
        return this == obj;
    }

    public g f(String str) {
        d(this.f73103b + 1, str);
        return this;
    }

    public String g(String str) {
        d30.d.j(str);
        if (!A()) {
            return "";
        }
        String strY = j().y(str);
        if (strY.length() > 0) {
            return strY;
        }
        return str.startsWith("abs:") ? a(str.substring(4)) : "";
    }

    public g h(String str, String str2) {
        j().I(str, str2);
        return this;
    }

    public abstract org.jsoup.nodes.b j();

    public abstract String k();

    public g l(String str) {
        d(this.f73103b, str);
        return this;
    }

    public g m(g gVar) {
        d30.d.j(gVar);
        d30.d.j(this.f73102a);
        this.f73102a.b(this.f73103b, gVar);
        return this;
    }

    public g n(int i11) {
        return v().get(i11);
    }

    public abstract int o();

    public List<g> p() {
        return Collections.unmodifiableList(v());
    }

    public g[] q() {
        return (g[]) v().toArray(new g[o()]);
    }

    @Override // 
    /* JADX INFO: renamed from: r */
    public g v0() {
        g gVarS = s(null);
        LinkedList linkedList = new LinkedList();
        linkedList.add(gVarS);
        while (!linkedList.isEmpty()) {
            g gVar = (g) linkedList.remove();
            int iO = gVar.o();
            for (int i11 = 0; i11 < iO; i11++) {
                List<g> listV = gVar.v();
                g gVarS2 = listV.get(i11).s(gVar);
                listV.set(i11, gVarS2);
                linkedList.add(gVarS2);
            }
        }
        return gVarS;
    }

    public g s(g gVar) {
        try {
            g gVar2 = (g) super.clone();
            gVar2.f73102a = gVar;
            gVar2.f73103b = gVar == null ? 0 : this.f73103b;
            return gVar2;
        } catch (CloneNotSupportedException e11) {
            throw new RuntimeException(e11);
        }
    }

    public abstract void t(String str);

    public String toString() {
        return G();
    }

    public abstract List<g> v();

    public final Element x(Element element) {
        Elements elementsR0 = element.r0();
        return elementsR0.size() > 0 ? x(elementsR0.get(0)) : element;
    }

    public Document.OutputSettings y() {
        Document documentK = K();
        if (documentK == null) {
            documentK = new Document("");
        }
        return documentK.j1();
    }

    public boolean z(String str) {
        d30.d.j(str);
        if (str.startsWith("abs:")) {
            String strSubstring = str.substring(4);
            if (j().A(strSubstring) && !a(strSubstring).equals("")) {
                return true;
            }
        }
        return j().A(str);
    }
}
