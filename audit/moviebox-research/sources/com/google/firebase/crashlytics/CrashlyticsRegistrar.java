package com.google.firebase.crashlytics;

import cl.g;
import com.google.firebase.components.ComponentRegistrar;
import gk.a;
import java.util.Arrays;
import java.util.List;
import rj.c;
import rj.e;
import rj.h;
import rj.r;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class CrashlyticsRegistrar implements ComponentRegistrar {
    public final FirebaseCrashlytics b(e eVar) {
        return FirebaseCrashlytics.a((jj.e) eVar.b(jj.e.class), (g) eVar.b(g.class), eVar.i(a.class), eVar.i(nj.a.class));
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<c<?>> getComponents() {
        return Arrays.asList(c.c(FirebaseCrashlytics.class).h("fire-cls").b(r.j(jj.e.class)).b(r.j(g.class)).b(r.a(a.class)).b(r.a(nj.a.class)).f(new h() { // from class: sj.f
            @Override // rj.h
            public final Object a(rj.e eVar) {
                return this.f76371a.b(eVar);
            }
        }).e().d(), xl.h.b("fire-cls", "18.3.2"));
    }
}
