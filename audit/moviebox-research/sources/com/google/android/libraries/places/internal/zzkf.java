package com.google.android.libraries.places.internal;

import android.content.Context;
import cg.d;
import cg.e;
import cg.f;
import cg.g;
import com.google.android.datatransport.runtime.t;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzkf implements zzkg {
    private static final Integer zza = 79508299;
    private final g zzb;

    public zzkf(Context context) {
        t.f(context.getApplicationContext());
        this.zzb = t.c().h("cct").a("LE", zzsm.class, new f() { // from class: com.google.android.libraries.places.internal.zzke
            @Override // cg.f
            public final Object apply(Object obj) {
                return ((zzsm) obj).zzao();
            }
        });
    }

    @Override // com.google.android.libraries.places.internal.zzkg
    public final void zza(zzsm zzsmVar) {
        this.zzb.a(d.f(zzsmVar, e.b(zza)));
    }
}
