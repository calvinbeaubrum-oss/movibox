package com.google.firebase.datatransport;

import android.content.Context;
import androidx.annotation.Keep;
import cg.h;
import com.google.android.datatransport.runtime.t;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.datatransport.TransportRegistrar;
import dg.a;
import java.util.Arrays;
import java.util.List;
import rj.c;
import rj.e;
import rj.r;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
@Keep
public class TransportRegistrar implements ComponentRegistrar {
    private static final String LIBRARY_NAME = "fire-transport";

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ h lambda$getComponents$0(e eVar) {
        t.f((Context) eVar.b(Context.class));
        return t.c().g(a.f63033h);
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<c<?>> getComponents() {
        return Arrays.asList(c.c(h.class).h(LIBRARY_NAME).b(r.j(Context.class)).f(new rj.h() { // from class: sk.a
            @Override // rj.h
            public final Object a(e eVar) {
                return TransportRegistrar.lambda$getComponents$0(eVar);
            }
        }).d(), xl.h.b(LIBRARY_NAME, "18.1.7"));
    }
}
