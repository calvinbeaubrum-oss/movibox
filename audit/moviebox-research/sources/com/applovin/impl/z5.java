package com.applovin.impl;

import android.net.Uri;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class z5 implements c7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f24807a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private td.e f24808b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private b7 f24809c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private qa.b f24810d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f24811e;

    private b7 a(td.e eVar) {
        qa.b bVarA = this.f24810d;
        if (bVarA == null) {
            bVarA = new d6.b().a(this.f24811e);
        }
        Uri uri = eVar.f23273b;
        ra raVar = new ra(uri == null ? null : uri.toString(), eVar.f23277f, bVarA);
        pp it = eVar.f23274c.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            raVar.a((String) entry.getKey(), (String) entry.getValue());
        }
        y5 y5VarA = new y5.b().a(eVar.f23272a, m9.f20633d).a(eVar.f23275d).b(eVar.f23276e).a(ub.a(eVar.f23278g)).a(raVar);
        y5VarA.a(0, eVar.b());
        return y5VarA;
    }

    @Override // com.applovin.impl.c7
    public b7 a(td tdVar) {
        b7 b7Var;
        b1.a(tdVar.f23247b);
        td.e eVar = tdVar.f23247b.f23302c;
        if (eVar == null || xp.f24372a < 18) {
            return b7.f17877a;
        }
        synchronized (this.f24807a) {
            try {
                if (!xp.a(eVar, this.f24808b)) {
                    this.f24808b = eVar;
                    this.f24809c = a(eVar);
                }
                b7Var = (b7) b1.a(this.f24809c);
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return b7Var;
    }
}
