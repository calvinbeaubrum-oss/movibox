package com.google.android.datatransport.runtime;

import android.content.Context;
import java.util.Collections;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class t implements s {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile u f32667e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final og.a f32668a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final og.a f32669b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final kg.e f32670c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final lg.o f32671d;

    public t(og.a aVar, og.a aVar2, kg.e eVar, lg.o oVar, lg.s sVar) {
        this.f32668a = aVar;
        this.f32669b = aVar2;
        this.f32670c = eVar;
        this.f32671d = oVar;
        sVar.c();
    }

    public static t c() {
        u uVar = f32667e;
        if (uVar != null) {
            return uVar.b();
        }
        throw new IllegalStateException("Not initialized!");
    }

    public static Set<cg.c> d(f fVar) {
        return fVar instanceof g ? Collections.unmodifiableSet(((g) fVar).a()) : Collections.singleton(cg.c.b("proto"));
    }

    public static void f(Context context) {
        if (f32667e == null) {
            synchronized (t.class) {
                try {
                    if (f32667e == null) {
                        f32667e = e.a().a(context).build();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    @Override // com.google.android.datatransport.runtime.s
    public void a(n nVar, cg.i iVar) {
        this.f32670c.a(nVar.f().f(nVar.c().c()), b(nVar), iVar);
    }

    public final i b(n nVar) {
        i.a aVarG = i.a().i(this.f32668a.a()).l(this.f32669b.a()).k(nVar.g()).h(new h(nVar.b(), nVar.d())).g(nVar.c().a());
        if (nVar.c().d() != null && nVar.c().d().a() != null) {
            aVarG.j(nVar.c().d().a());
        }
        return aVarG.d();
    }

    public lg.o e() {
        return this.f32671d;
    }

    public cg.h g(f fVar) {
        return new p(d(fVar), o.a().b(fVar.getName()).c(fVar.getExtras()).a(), this);
    }

    @Deprecated
    public cg.h h(String str) {
        return new p(d(null), o.a().b(str).a(), this);
    }
}
