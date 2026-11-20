package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzlv implements zzlm {
    public final zzum zza;
    public int zzd;
    public boolean zze;
    public final List zzc = new ArrayList();
    public final Object zzb = new Object();

    public zzlv(zzut zzutVar, boolean z11) {
        this.zza = new zzum(zzutVar, z11);
    }

    @Override // com.google.android.gms.internal.ads.zzlm
    public final zzcx zza() {
        return this.zza.zzC();
    }

    @Override // com.google.android.gms.internal.ads.zzlm
    public final Object zzb() {
        return this.zzb;
    }

    public final void zzc(int i11) {
        this.zzd = i11;
        this.zze = false;
        this.zzc.clear();
    }
}
