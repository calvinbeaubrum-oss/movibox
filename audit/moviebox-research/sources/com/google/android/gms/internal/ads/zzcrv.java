package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcrv implements zzdbs {
    private final zzfif zza;

    public zzcrv(zzfif zzfifVar) {
        this.zza = zzfifVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdbs
    public final void zzbs(@Nullable Context context) {
        try {
            this.zza.zzg();
        } catch (zzfho e11) {
            zzcec.zzk("Cannot invoke onDestroy for the mediation adapter.", e11);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdbs
    public final void zzbu(@Nullable Context context) {
        try {
            this.zza.zzt();
        } catch (zzfho e11) {
            zzcec.zzk("Cannot invoke onPause for the mediation adapter.", e11);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdbs
    public final void zzbv(@Nullable Context context) {
        try {
            this.zza.zzu();
            if (context != null) {
                this.zza.zzs(context);
            }
        } catch (zzfho e11) {
            zzcec.zzk("Cannot invoke onResume for the mediation adapter.", e11);
        }
    }
}
