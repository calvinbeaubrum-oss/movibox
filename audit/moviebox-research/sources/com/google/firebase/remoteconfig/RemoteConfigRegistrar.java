package com.google.firebase.remoteconfig;

import android.content.Context;
import androidx.annotation.Keep;
import cl.g;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.remoteconfig.RemoteConfigRegistrar;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import lj.a;
import qj.b;
import rj.b0;
import rj.c;
import rj.e;
import rj.h;
import rj.r;
import yl.m;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
@Keep
public class RemoteConfigRegistrar implements ComponentRegistrar {
    private static final String LIBRARY_NAME = "fire-rc";

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ m lambda$getComponents$0(b0 b0Var, e eVar) {
        return new m((Context) eVar.b(Context.class), (Executor) eVar.e(b0Var), (jj.e) eVar.b(jj.e.class), (g) eVar.b(g.class), ((a) eVar.b(a.class)).b("frc"), eVar.f(nj.a.class));
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<c<?>> getComponents() {
        final b0 b0VarA = b0.a(b.class, Executor.class);
        return Arrays.asList(c.c(m.class).h(LIBRARY_NAME).b(r.j(Context.class)).b(r.k(b0VarA)).b(r.j(jj.e.class)).b(r.j(g.class)).b(r.j(a.class)).b(r.i(nj.a.class)).f(new h() { // from class: yl.n
            @Override // rj.h
            public final Object a(rj.e eVar) {
                return RemoteConfigRegistrar.lambda$getComponents$0(b0VarA, eVar);
            }
        }).e().d(), xl.h.b(LIBRARY_NAME, "21.2.1"));
    }
}
