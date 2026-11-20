package com.google.firebase.crashlytics.ndk;

import android.content.Context;
import com.google.firebase.components.ComponentRegistrar;
import java.util.Arrays;
import java.util.List;
import rj.c;
import rj.e;
import rj.h;
import rj.r;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class CrashlyticsNdkRegistrar implements ComponentRegistrar {
    public final gk.a b(e eVar) {
        Context context = (Context) eVar.b(Context.class);
        return a.f(context, !gk.e.g(context));
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<c<?>> getComponents() {
        return Arrays.asList(c.c(gk.a.class).h("fire-cls-ndk").b(r.j(Context.class)).f(new h() { // from class: rk.a
            @Override // rj.h
            public final Object a(rj.e eVar) {
                return this.f75587a.b(eVar);
            }
        }).e().d(), xl.h.b("fire-cls-ndk", "18.3.2"));
    }
}
