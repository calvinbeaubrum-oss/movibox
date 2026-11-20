package org.jsoup.select;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.transsion.gslb.Utils;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jsoup.parser.g;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String[] f73251d = {",", ">", "+", "~", " "};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String[] f73252e = {"=", "!=", "^=", "$=", "*=", "~="};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Pattern f73253f = Pattern.compile("(([+-])?(\\d+)?)n(\\s*([+-])?\\s*\\d+)?", 2);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Pattern f73254g = Pattern.compile("([+-])?(\\d+)");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g f73255a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f73256b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<c> f73257c = new ArrayList();

    public e(String str) {
        this.f73256b = str;
        this.f73255a = new g(str);
    }

    public static c t(String str) {
        try {
            return new e(str).s();
        } catch (IllegalArgumentException e11) {
            throw new Selector.SelectorParseException(e11.getMessage(), new Object[0]);
        }
    }

    public final void a() {
        this.f73257c.add(new c.a());
    }

    public final void b() {
        g gVar = new g(this.f73255a.a('[', ']'));
        String strH = gVar.h(f73252e);
        d30.d.h(strH);
        gVar.i();
        if (gVar.j()) {
            if (strH.startsWith("^")) {
                this.f73257c.add(new c.d(strH.substring(1)));
                return;
            } else {
                this.f73257c.add(new c.b(strH));
                return;
            }
        }
        if (gVar.k("=")) {
            this.f73257c.add(new c.e(strH, gVar.q()));
            return;
        }
        if (gVar.k("!=")) {
            this.f73257c.add(new c.i(strH, gVar.q()));
            return;
        }
        if (gVar.k("^=")) {
            this.f73257c.add(new c.j(strH, gVar.q()));
            return;
        }
        if (gVar.k("$=")) {
            this.f73257c.add(new c.g(strH, gVar.q()));
        } else if (gVar.k("*=")) {
            this.f73257c.add(new c.f(strH, gVar.q()));
        } else {
            if (!gVar.k("~=")) {
                throw new Selector.SelectorParseException("Could not parse attribute query '%s': unexpected token at '%s'", this.f73256b, gVar.q());
            }
            this.f73257c.add(new c.h(strH, Pattern.compile(gVar.q())));
        }
    }

    public final void c() {
        String strE = this.f73255a.e();
        d30.d.h(strE);
        this.f73257c.add(new c.k(strE.trim()));
    }

    public final void d() {
        String strE = this.f73255a.e();
        d30.d.h(strE);
        this.f73257c.add(new c.p(strE));
    }

    public final void e() {
        String strF = this.f73255a.f();
        d30.d.h(strF);
        if (strF.startsWith("*|")) {
            this.f73257c.add(new b.C0790b(new c.j0(e30.b.b(strF)), new c.k0(e30.b.b(strF.replace("*|", ":")))));
            return;
        }
        if (strF.contains("|")) {
            strF = strF.replace("|", ":");
        }
        this.f73257c.add(new c.j0(strF.trim()));
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0048  */
    /* JADX WARN: Code duplicated, block: B:13:0x0059  */
    /* JADX WARN: Code duplicated, block: B:15:0x005d  */
    /* JADX WARN: Code duplicated, block: B:16:0x006e  */
    /* JADX WARN: Code duplicated, block: B:18:0x0072  */
    /* JADX WARN: Code duplicated, block: B:19:0x0083  */
    /* JADX WARN: Code duplicated, block: B:21:0x0087  */
    /* JADX WARN: Code duplicated, block: B:22:0x0098 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:23:0x009a  */
    /* JADX WARN: Code duplicated, block: B:25:0x009e  */
    /* JADX WARN: Code duplicated, block: B:26:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:28:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:29:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:32:0x00c0  */
    /* JADX WARN: Instruction removed from duplicated block: B:32:0x00c0, please report this as an issue */
    public final void f(char c11) {
        c aVar;
        c cVar;
        boolean z11;
        b.C0790b c0790b;
        c cVar2;
        b.a aVar2;
        b.a aVar3;
        b.a aVar4;
        c cVar3;
        b.a aVar5;
        this.f73255a.i();
        c cVarT = t(h());
        if (this.f73257c.size() == 1) {
            aVar = this.f73257c.get(0);
            if ((aVar instanceof b.C0790b) && c11 != ',') {
                z11 = true;
                cVar = aVar;
                aVar = ((b.C0790b) aVar).c();
            }
            this.f73257c.clear();
            if (c11 == '>') {
                aVar5 = new b.a(cVarT, new f.b(aVar));
            } else if (c11 == ' ') {
                aVar4 = new b.a(cVarT, new f.e(aVar));
            } else if (c11 == '+') {
                aVar3 = new b.a(cVarT, new f.c(aVar));
            } else if (c11 == '~') {
                aVar2 = new b.a(cVarT, new f.C0792f(aVar));
            } else {
                if (c11 == ',') {
                    throw new Selector.SelectorParseException("Unknown combinator: " + c11, new Object[0]);
                }
                if (aVar instanceof b.C0790b) {
                    b.C0790b c0790b2 = (b.C0790b) aVar;
                    c0790b2.e(cVarT);
                    cVar2 = c0790b2;
                } else {
                    c0790b = new b.C0790b();
                    c0790b.e(aVar);
                    c0790b.e(cVarT);
                }
            }
            if (z11) {
                cVar2 = c0790b;
                cVar2 = aVar2;
                cVar2 = aVar3;
                cVar2 = aVar4;
                cVar2 = aVar5;
                ((b.C0790b) cVar).b(cVar2);
                cVar3 = cVar;
            } else {
                cVar2 = c0790b;
                cVar2 = aVar2;
                cVar2 = aVar3;
                cVar2 = aVar4;
                cVar2 = aVar5;
                cVar3 = cVar2;
            }
            this.f73257c.add(cVar3);
        }
        aVar = new b.a(this.f73257c);
        cVar = aVar;
        z11 = false;
        this.f73257c.clear();
        if (c11 == '>') {
            aVar5 = new b.a(cVarT, new f.b(aVar));
        } else if (c11 == ' ') {
            aVar4 = new b.a(cVarT, new f.e(aVar));
        } else if (c11 == '+') {
            aVar3 = new b.a(cVarT, new f.c(aVar));
        } else if (c11 == '~') {
            aVar2 = new b.a(cVarT, new f.C0792f(aVar));
        } else {
            if (c11 == ',') {
                throw new Selector.SelectorParseException("Unknown combinator: " + c11, new Object[0]);
            }
            if (aVar instanceof b.C0790b) {
                b.C0790b c0790b3 = (b.C0790b) aVar;
                c0790b3.e(cVarT);
                cVar2 = c0790b3;
            } else {
                c0790b = new b.C0790b();
                c0790b.e(aVar);
                c0790b.e(cVarT);
            }
        }
        if (z11) {
            cVar2 = c0790b;
            cVar2 = aVar2;
            cVar2 = aVar3;
            cVar2 = aVar4;
            cVar2 = aVar5;
            ((b.C0790b) cVar).b(cVar2);
            cVar3 = cVar;
        } else {
            cVar2 = c0790b;
            cVar2 = aVar2;
            cVar2 = aVar3;
            cVar2 = aVar4;
            cVar2 = aVar5;
            cVar3 = cVar2;
        }
        this.f73257c.add(cVar3);
    }

    public final int g() {
        String strTrim = this.f73255a.b(")").trim();
        d30.d.e(d30.c.g(strTrim), "Index must be numeric");
        return Integer.parseInt(strTrim);
    }

    public final String h() {
        StringBuilder sb2 = new StringBuilder();
        while (!this.f73255a.j()) {
            if (this.f73255a.l("(")) {
                sb2.append("(");
                sb2.append(this.f73255a.a('(', ')'));
                sb2.append(")");
            } else if (this.f73255a.l("[")) {
                sb2.append("[");
                sb2.append(this.f73255a.a('[', ']'));
                sb2.append("]");
            } else {
                if (this.f73255a.n(f73251d)) {
                    break;
                }
                sb2.append(this.f73255a.c());
            }
        }
        return sb2.toString();
    }

    public final void i(boolean z11) {
        this.f73255a.d(z11 ? ":containsOwn" : ":contains");
        String strS = g.s(this.f73255a.a('(', ')'));
        d30.d.i(strS, ":contains(text) query must not be empty");
        if (z11) {
            this.f73257c.add(new c.m(strS));
        } else {
            this.f73257c.add(new c.n(strS));
        }
    }

    public final void j() {
        this.f73255a.d(":containsData");
        String strS = g.s(this.f73255a.a('(', ')'));
        d30.d.i(strS, ":containsData(text) query must not be empty");
        this.f73257c.add(new c.l(strS));
    }

    public final void k(boolean z11, boolean z12) {
        String strB = e30.b.b(this.f73255a.b(")"));
        Matcher matcher = f73253f.matcher(strB);
        Matcher matcher2 = f73254g.matcher(strB);
        int i11 = 2;
        int i12 = 1;
        if (!"odd".equals(strB)) {
            if ("even".equals(strB)) {
                i12 = 0;
            } else if (matcher.matches()) {
                int i13 = matcher.group(3) != null ? Integer.parseInt(matcher.group(1).replaceFirst("^\\+", "")) : 1;
                i12 = matcher.group(4) != null ? Integer.parseInt(matcher.group(4).replaceFirst("^\\+", "")) : 0;
                i11 = i13;
            } else {
                if (!matcher2.matches()) {
                    throw new Selector.SelectorParseException("Could not parse nth-index '%s': unexpected format", strB);
                }
                i12 = Integer.parseInt(matcher2.group().replaceFirst("^\\+", ""));
                i11 = 0;
            }
        }
        if (z12) {
            if (z11) {
                this.f73257c.add(new c.b0(i11, i12));
                return;
            } else {
                this.f73257c.add(new c.c0(i11, i12));
                return;
            }
        }
        if (z11) {
            this.f73257c.add(new c.a0(i11, i12));
        } else {
            this.f73257c.add(new c.z(i11, i12));
        }
    }

    public final void l() {
        if (this.f73255a.k(Utils.SEPARATOR)) {
            d();
            return;
        }
        if (this.f73255a.k(InstructionFileId.DOT)) {
            c();
            return;
        }
        if (this.f73255a.p() || this.f73255a.l("*|")) {
            e();
            return;
        }
        if (this.f73255a.l("[")) {
            b();
            return;
        }
        if (this.f73255a.k("*")) {
            a();
            return;
        }
        if (this.f73255a.k(":lt(")) {
            p();
            return;
        }
        if (this.f73255a.k(":gt(")) {
            o();
            return;
        }
        if (this.f73255a.k(":eq(")) {
            n();
            return;
        }
        if (this.f73255a.l(":has(")) {
            m();
            return;
        }
        if (this.f73255a.l(":contains(")) {
            i(false);
            return;
        }
        if (this.f73255a.l(":containsOwn(")) {
            i(true);
            return;
        }
        if (this.f73255a.l(":containsData(")) {
            j();
            return;
        }
        if (this.f73255a.l(":matches(")) {
            q(false);
            return;
        }
        if (this.f73255a.l(":matchesOwn(")) {
            q(true);
            return;
        }
        if (this.f73255a.l(":not(")) {
            r();
            return;
        }
        if (this.f73255a.k(":nth-child(")) {
            k(false, false);
            return;
        }
        if (this.f73255a.k(":nth-last-child(")) {
            k(true, false);
            return;
        }
        if (this.f73255a.k(":nth-of-type(")) {
            k(false, true);
            return;
        }
        if (this.f73255a.k(":nth-last-of-type(")) {
            k(true, true);
            return;
        }
        if (this.f73255a.k(":first-child")) {
            this.f73257c.add(new c.v());
            return;
        }
        if (this.f73255a.k(":last-child")) {
            this.f73257c.add(new c.x());
            return;
        }
        if (this.f73255a.k(":first-of-type")) {
            this.f73257c.add(new c.w());
            return;
        }
        if (this.f73255a.k(":last-of-type")) {
            this.f73257c.add(new c.y());
            return;
        }
        if (this.f73255a.k(":only-child")) {
            this.f73257c.add(new c.d0());
            return;
        }
        if (this.f73255a.k(":only-of-type")) {
            this.f73257c.add(new c.e0());
            return;
        }
        if (this.f73255a.k(":empty")) {
            this.f73257c.add(new c.u());
        } else if (this.f73255a.k(":root")) {
            this.f73257c.add(new c.f0());
        } else {
            if (!this.f73255a.k(":matchText")) {
                throw new Selector.SelectorParseException("Could not parse query '%s': unexpected token at '%s'", this.f73256b, this.f73255a.q());
            }
            this.f73257c.add(new c.g0());
        }
    }

    public final void m() {
        this.f73255a.d(":has");
        String strA = this.f73255a.a('(', ')');
        d30.d.i(strA, ":has(el) subselect must not be empty");
        this.f73257c.add(new f.a(t(strA)));
    }

    public final void n() {
        this.f73257c.add(new c.q(g()));
    }

    public final void o() {
        this.f73257c.add(new c.s(g()));
    }

    public final void p() {
        this.f73257c.add(new c.t(g()));
    }

    public final void q(boolean z11) {
        this.f73255a.d(z11 ? ":matchesOwn" : ":matches");
        String strA = this.f73255a.a('(', ')');
        d30.d.i(strA, ":matches(regex) query must not be empty");
        if (z11) {
            this.f73257c.add(new c.i0(Pattern.compile(strA)));
        } else {
            this.f73257c.add(new c.h0(Pattern.compile(strA)));
        }
    }

    public final void r() {
        this.f73255a.d(":not");
        String strA = this.f73255a.a('(', ')');
        d30.d.i(strA, ":not(selector) subselect must not be empty");
        this.f73257c.add(new f.d(t(strA)));
    }

    public c s() {
        this.f73255a.i();
        if (this.f73255a.n(f73251d)) {
            this.f73257c.add(new f.g());
            f(this.f73255a.c());
        } else {
            l();
        }
        while (!this.f73255a.j()) {
            boolean zI = this.f73255a.i();
            if (this.f73255a.n(f73251d)) {
                f(this.f73255a.c());
            } else if (zI) {
                f(' ');
            } else {
                l();
            }
        }
        return this.f73257c.size() == 1 ? this.f73257c.get(0) : new b.a(this.f73257c);
    }
}
