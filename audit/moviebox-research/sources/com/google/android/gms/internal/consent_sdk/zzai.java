package com.google.android.gms.internal.consent_sdk;

import android.app.Application;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzai {
    private Application zza;

    private zzai() {
    }

    public /* synthetic */ zzai(zzah zzahVar) {
    }

    public final zza zza() {
        zzdp.zzb(this.zza, Application.class);
        return new zzag(this.zza, null);
    }

    public final zzai zzb(Application application) {
        application.getClass();
        this.zza = application;
        return this;
    }
}
