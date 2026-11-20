package com.transsion.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class l {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final char[] f52966f = "0123456789ABCDEF".toCharArray();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f52970d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f52971e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<r, com.transsion.json.b.n> f52968b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<s> f52969c = new ArrayList();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.transsion.json.b.p f52967a = new com.transsion.json.b.p(w.a());

    public l a(boolean z11) {
        this.f52970d = z11;
        return this;
    }

    public l b(String... strArr) {
        for (String str : strArr) {
            e(str);
        }
        return this;
    }

    public String c(Object obj) {
        return d(obj, t.SHALLOW, new u(new StringBuilder()));
    }

    public String d(Object obj, t tVar, q qVar) {
        i iVarQ = i.q();
        iVarQ.k(this.f52971e);
        iVarQ.m(this.f52970d);
        iVarQ.g(qVar);
        iVarQ.h(tVar);
        iVarQ.e(this.f52967a);
        iVarQ.l(this.f52968b);
        iVarQ.s(this.f52969c);
        try {
            String strY = iVarQ.y();
            if (strY == null || strY.trim().equals("")) {
                iVarQ.j(obj);
            } else {
                iVarQ.H();
                iVarQ.u(strY);
                iVarQ.j(obj);
                iVarQ.D();
            }
            return iVarQ.v().toString();
        } finally {
            i.c();
        }
    }

    public void e(String str) {
        int iLastIndexOf = str.lastIndexOf(46);
        if (iLastIndexOf > 0) {
            s sVar = new s(str.substring(0, iLastIndexOf), true);
            if (!sVar.c()) {
                this.f52969c.add(sVar);
            }
        }
        this.f52969c.add(new s(str, false));
    }
}
