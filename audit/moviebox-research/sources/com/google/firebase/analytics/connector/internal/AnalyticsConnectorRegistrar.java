package com.google.firebase.analytics.connector.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.firebase.components.ComponentRegistrar;
import java.util.Arrays;
import java.util.List;
import jj.e;
import nj.a;
import rj.c;
import rj.h;
import rj.r;
import yk.d;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
@Keep
@KeepForSdk
public class AnalyticsConnectorRegistrar implements ComponentRegistrar {
    @Override // com.google.firebase.components.ComponentRegistrar
    @NonNull
    @Keep
    @SuppressLint({"MissingPermission"})
    @KeepForSdk
    public List<c<?>> getComponents() {
        return Arrays.asList(c.c(a.class).b(r.j(e.class)).b(r.j(Context.class)).b(r.j(d.class)).f(new h() { // from class: oj.a
            @Override // rj.h
            public final Object a(rj.e eVar) {
                return nj.b.h((jj.e) eVar.b(jj.e.class), (Context) eVar.b(Context.class), (yk.d) eVar.b(yk.d.class));
            }
        }).e().d(), xl.h.b("fire-analytics", "21.2.0"));
    }
}
