package com.google.android.gms.internal.consent_sdk;

import android.app.Application;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbx implements zzdn {
    private final zzdr zza;

    public zzbx(zzdr zzdrVar) {
        this.zza = zzdrVar;
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzdr
    public final /* bridge */ /* synthetic */ Object zza() {
        return new zzbw((Application) this.zza.zza());
    }
}
