package com.google.firebase.installations;

import androidx.annotation.Keep;
import cl.g;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.concurrent.FirebaseExecutors;
import com.google.firebase.installations.FirebaseInstallationsRegistrar;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import qj.b;
import rj.b0;
import rj.c;
import rj.e;
import rj.r;
import zk.h;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
@Keep
public class FirebaseInstallationsRegistrar implements ComponentRegistrar {
    private static final String LIBRARY_NAME = "fire-installations";

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ g lambda$getComponents$0(e eVar) {
        return new a((jj.e) eVar.b(jj.e.class), eVar.f(h.class), (ExecutorService) eVar.e(b0.a(qj.a.class, ExecutorService.class)), FirebaseExecutors.b((Executor) eVar.e(b0.a(b.class, Executor.class))));
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<c<?>> getComponents() {
        return Arrays.asList(c.c(g.class).h(LIBRARY_NAME).b(r.j(jj.e.class)).b(r.i(h.class)).b(r.k(b0.a(qj.a.class, ExecutorService.class))).b(r.k(b0.a(b.class, Executor.class))).f(new rj.h() { // from class: cl.h
            @Override // rj.h
            public final Object a(rj.e eVar) {
                return FirebaseInstallationsRegistrar.lambda$getComponents$0(eVar);
            }
        }).d(), zk.g.a(), xl.h.b(LIBRARY_NAME, "17.2.0"));
    }
}
