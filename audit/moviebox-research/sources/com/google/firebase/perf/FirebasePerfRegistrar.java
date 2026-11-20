package com.google.firebase.perf;

import androidx.annotation.Keep;
import cg.h;
import cl.g;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.perf.FirebasePerfRegistrar;
import java.util.Arrays;
import java.util.List;
import ll.c;
import ol.a;
import rj.e;
import rj.r;
import yl.m;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
@Keep
public class FirebasePerfRegistrar implements ComponentRegistrar {
    private static final String LIBRARY_NAME = "fire-perf";

    /* JADX INFO: Access modifiers changed from: private */
    public static c providesFirebasePerformance(e eVar) {
        return a.b().b(new pl.a((jj.e) eVar.b(jj.e.class), (g) eVar.b(g.class), eVar.f(m.class), eVar.f(h.class))).a().a();
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    @Keep
    public List<rj.c<?>> getComponents() {
        return Arrays.asList(rj.c.c(c.class).h(LIBRARY_NAME).b(r.j(jj.e.class)).b(r.l(m.class)).b(r.j(g.class)).b(r.l(h.class)).f(new rj.h() { // from class: ll.b
            @Override // rj.h
            public final Object a(rj.e eVar) {
                return FirebasePerfRegistrar.providesFirebasePerformance(eVar);
            }
        }).d(), xl.h.b(LIBRARY_NAME, "20.3.0"));
    }
}
