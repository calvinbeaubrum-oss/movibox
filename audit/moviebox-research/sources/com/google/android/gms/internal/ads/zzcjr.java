package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzcjr implements com.google.android.gms.ads.internal.overlay.zzp {
    private final zzcjk zza;

    @Nullable
    private final com.google.android.gms.ads.internal.overlay.zzp zzb;

    public zzcjr(zzcjk zzcjkVar, @Nullable com.google.android.gms.ads.internal.overlay.zzp zzpVar) {
        this.zza = zzcjkVar;
        this.zzb = zzpVar;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void zzbA() {
        com.google.android.gms.ads.internal.overlay.zzp zzpVar = this.zzb;
        if (zzpVar != null) {
            zzpVar.zzbA();
        }
        this.zza.zzY();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void zzbC() {
        com.google.android.gms.ads.internal.overlay.zzp zzpVar = this.zzb;
        if (zzpVar != null) {
            zzpVar.zzbC();
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void zzbD(int i11) {
        com.google.android.gms.ads.internal.overlay.zzp zzpVar = this.zzb;
        if (zzpVar != null) {
            zzpVar.zzbD(i11);
        }
        this.zza.zzW();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void zzbP() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void zzbt() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void zzbz() {
        com.google.android.gms.ads.internal.overlay.zzp zzpVar = this.zzb;
        if (zzpVar != null) {
            zzpVar.zzbz();
        }
    }
}
