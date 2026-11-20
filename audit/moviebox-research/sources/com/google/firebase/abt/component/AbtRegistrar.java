package com.google.firebase.abt.component;

import android.content.Context;
import androidx.annotation.Keep;
import com.google.firebase.abt.component.AbtRegistrar;
import com.google.firebase.components.ComponentRegistrar;
import java.util.Arrays;
import java.util.List;
import lj.a;
import rj.c;
import rj.e;
import rj.h;
import rj.r;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
@Keep
public class AbtRegistrar implements ComponentRegistrar {
    private static final String LIBRARY_NAME = "fire-abt";

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ a lambda$getComponents$0(e eVar) {
        return new a((Context) eVar.b(Context.class), eVar.f(nj.a.class));
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<c<?>> getComponents() {
        return Arrays.asList(c.c(a.class).h(LIBRARY_NAME).b(r.j(Context.class)).b(r.i(nj.a.class)).f(new h() { // from class: lj.b
            @Override // rj.h
            public final Object a(e eVar) {
                return AbtRegistrar.lambda$getComponents$0(eVar);
            }
        }).d(), xl.h.b(LIBRARY_NAME, "21.1.0"));
    }
}
