package com.transsion.json;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class i {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final ThreadLocal<i> f52950n = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f52951a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public q f52952b;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.transsion.json.b.p f52956f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Map<r, com.transsion.json.b.n> f52957g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public List<s> f52958h;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f52963m;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f52953c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Stack<x> f52954d = new Stack<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f52955e = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public t f52959i = t.SHALLOW;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public f f52960j = new f(Collections.EMPTY_SET);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final LinkedList<Object> f52961k = new LinkedList<>();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final r f52962l = new r();

    /* JADX INFO: compiled from: source.java */
    public static class a extends ThreadLocal<i> {
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public i initialValue() {
            return new i();
        }
    }

    public static void c() {
        f52950n.remove();
    }

    public static i q() {
        return f52950n.get();
    }

    public x A() {
        if (this.f52954d.isEmpty()) {
            return null;
        }
        return this.f52954d.peek();
    }

    public void B() {
        this.f52954d.pop();
    }

    public void C() {
        J();
        if (this.f52953c) {
            this.f52952b.a("\n");
            this.f52955e -= 4;
            F();
        }
        this.f52952b.a("]");
        B();
    }

    public void D() {
        J();
        if (this.f52953c) {
            this.f52952b.a("\n");
            this.f52955e -= 4;
            F();
        }
        this.f52952b.a("}");
        B();
    }

    public void E() {
        this.f52963m = true;
    }

    public void F() {
        for (int i11 = 0; i11 < this.f52955e; i11++) {
            this.f52952b.a(" ");
        }
    }

    public x G() {
        x xVarA;
        I();
        if (this.f52953c && (xVarA = A()) != null && xVarA.c() == com.transsion.json.a.ARRAY) {
            F();
        }
        x xVar = new x(com.transsion.json.a.ARRAY);
        i(xVar);
        this.f52952b.a("[");
        if (this.f52953c) {
            this.f52955e += 4;
            this.f52952b.a("\n");
        }
        return xVar;
    }

    public x H() {
        x xVarA;
        I();
        if (this.f52953c && (xVarA = A()) != null && xVarA.c() == com.transsion.json.a.ARRAY) {
            F();
        }
        x xVar = new x(com.transsion.json.a.OBJECT);
        i(xVar);
        this.f52952b.a("{");
        if (this.f52953c) {
            this.f52955e += 4;
            this.f52952b.a("\n");
        }
        return xVar;
    }

    public final void I() {
        if (this.f52963m) {
            this.f52952b.a(",");
            if (this.f52953c) {
                this.f52952b.a("\n");
            }
            this.f52963m = false;
        }
    }

    public final void J() {
        this.f52963m = false;
    }

    public final com.transsion.json.b.n K() {
        return this.f52957g.get(this.f52962l);
    }

    public com.transsion.json.b.n a(d dVar, Object obj) throws IllegalAccessException, InstantiationException {
        com.transsion.json.b.n nVarK = K();
        if (nVarK != null) {
            return nVarK;
        }
        if (dVar != null) {
            nVarK = dVar.j();
        }
        return nVarK == null ? p(obj) : nVarK;
    }

    public s b(List<s> list) {
        for (s sVar : list) {
            if (sVar.b(this.f52962l)) {
                return sVar;
            }
        }
        return null;
    }

    public final void d(char c11) {
        this.f52952b.a("\\u");
        int i11 = 0;
        int i12 = c11;
        while (i11 < 4) {
            this.f52952b.a(String.valueOf(l.f52966f[(61440 & i12) >> 12]));
            i11++;
            i12 <<= 4;
        }
    }

    public void e(com.transsion.json.b.p pVar) {
        this.f52956f = pVar;
    }

    public void f(f fVar) {
        this.f52960j = fVar;
    }

    public void g(q qVar) {
        this.f52952b = qVar;
    }

    public void h(t tVar) {
        this.f52959i = tVar;
    }

    public void i(x xVar) {
        this.f52954d.push(xVar);
    }

    public void j(Object obj) {
        com.transsion.json.b.n nVarK = K();
        if (nVarK == null) {
            nVarK = p(obj);
        }
        nVarK.a(obj);
    }

    public void k(String str) {
        this.f52951a = str;
    }

    public void l(Map<r, com.transsion.json.b.n> map) {
        this.f52957g = map;
    }

    public void m(boolean z11) {
        this.f52953c = z11;
    }

    public boolean n(d dVar) {
        s sVarB = b(this.f52958h);
        if (sVarB != null) {
            return sVarB.a();
        }
        Boolean boolL = dVar.l();
        if (boolL != null) {
            return boolL.booleanValue();
        }
        if (dVar.o().booleanValue()) {
            return false;
        }
        if (this.f52959i != t.SHALLOW) {
            return true;
        }
        Class clsH = dVar.h();
        return (clsH.isArray() || Iterable.class.isAssignableFrom(clsH) || Map.class.isAssignableFrom(clsH)) ? false : true;
    }

    public boolean o(String str, Object obj) {
        s sVarB = b(this.f52958h);
        if (sVarB != null) {
            return sVarB.a();
        }
        String strY = f52950n.get().y();
        if (obj == null) {
            return true;
        }
        t tVar = this.f52959i;
        t tVar2 = t.SHALLOW;
        if ((tVar != tVar2 || strY == null || this.f52962l.c() <= 1) && !(this.f52959i == tVar2 && strY == null)) {
            return true;
        }
        Class<?> cls = obj.getClass();
        return (cls.isArray() || Iterable.class.isAssignableFrom(cls)) ? false : true;
    }

    public final com.transsion.json.b.n p(Object obj) {
        return this.f52956f.a(obj);
    }

    public void r(String str) {
        I();
        x xVarA = A();
        if (xVarA != null && xVarA.c() == com.transsion.json.a.ARRAY) {
            F();
        }
        this.f52952b.a(str);
    }

    public void s(List<s> list) {
        this.f52958h = list;
    }

    public LinkedList<Object> t() {
        return this.f52961k;
    }

    public void u(String str) {
        I();
        if (this.f52953c) {
            F();
        }
        if (str != null) {
            w(str);
        } else {
            r("null");
        }
        this.f52952b.a(":");
        if (this.f52953c) {
            this.f52952b.a(" ");
        }
    }

    public q v() {
        return this.f52952b;
    }

    public void w(String str) {
        x xVarA;
        I();
        if (this.f52953c && (xVarA = A()) != null && xVarA.c() == com.transsion.json.a.ARRAY) {
            F();
        }
        this.f52952b.a("\"");
        int length = str.length();
        int iA = 0;
        for (int i11 = 0; i11 < length; i11++) {
            char cCharAt = str.charAt(i11);
            if (cCharAt == '\"') {
                iA = this.f52952b.b(str, iA, i11, "\\u0022");
            } else if (cCharAt == '&') {
                iA = this.f52952b.b(str, iA, i11, "\\u0026");
            } else if (cCharAt == '\'') {
                iA = this.f52952b.b(str, iA, i11, "\\u0027");
            } else if (cCharAt == '<') {
                iA = this.f52952b.b(str, iA, i11, "\\u003c");
            } else if (cCharAt == '>') {
                iA = this.f52952b.b(str, iA, i11, "\\u003e");
            } else if (cCharAt == '\\') {
                iA = this.f52952b.b(str, iA, i11, "\\\\");
            } else if (cCharAt == '\b') {
                iA = this.f52952b.b(str, iA, i11, "\\b");
            } else if (cCharAt == '\f') {
                iA = this.f52952b.b(str, iA, i11, "\\f");
            } else if (cCharAt == '\n') {
                iA = this.f52952b.b(str, iA, i11, "\\n");
            } else if (cCharAt == '\r') {
                iA = this.f52952b.b(str, iA, i11, "\\r");
            } else if (cCharAt == '\t') {
                iA = this.f52952b.b(str, iA, i11, "\\t");
            } else if (Character.isISOControl(cCharAt)) {
                iA = this.f52952b.a(str, iA, i11) + 1;
                d(cCharAt);
            }
        }
        if (iA < str.length()) {
            this.f52952b.a(str, iA, str.length());
        }
        this.f52952b.a("\"");
    }

    public r x() {
        return this.f52962l;
    }

    public String y() {
        return this.f52951a;
    }

    public f z() {
        return this.f52960j;
    }
}
