package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcga {
    private final Context zza;
    private final zzcgl zzb;
    private final ViewGroup zzc;
    private zzcfz zzd;

    public zzcga(Context context, ViewGroup viewGroup, zzcjk zzcjkVar) {
        this.zza = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.zzc = viewGroup;
        this.zzb = zzcjkVar;
        this.zzd = null;
    }

    public final zzcfz zza() {
        return this.zzd;
    }

    @Nullable
    public final Integer zzb() {
        zzcfz zzcfzVar = this.zzd;
        if (zzcfzVar != null) {
            return zzcfzVar.zzl();
        }
        return null;
    }

    public final void zzc(int i11, int i12, int i13, int i14) {
        Preconditions.checkMainThread("The underlay may only be modified from the UI thread.");
        zzcfz zzcfzVar = this.zzd;
        if (zzcfzVar != null) {
            zzcfzVar.zzF(i11, i12, i13, i14);
        }
    }

    public final void zzd(int i11, int i12, int i13, int i14, int i15, boolean z11, zzcgk zzcgkVar) {
        if (this.zzd != null) {
            return;
        }
        zzbgm.zza(this.zzb.zzm().zza(), this.zzb.zzk(), "vpr2");
        Context context = this.zza;
        zzcgl zzcglVar = this.zzb;
        zzcfz zzcfzVar = new zzcfz(context, zzcglVar, i15, z11, zzcglVar.zzm().zza(), zzcgkVar);
        this.zzd = zzcfzVar;
        this.zzc.addView(zzcfzVar, 0, new ViewGroup.LayoutParams(-1, -1));
        this.zzd.zzF(i11, i12, i13, i14);
        this.zzb.zzz(false);
    }

    public final void zze() {
        Preconditions.checkMainThread("onDestroy must be called from the UI thread.");
        zzcfz zzcfzVar = this.zzd;
        if (zzcfzVar != null) {
            zzcfzVar.zzo();
            this.zzc.removeView(this.zzd);
            this.zzd = null;
        }
    }

    public final void zzf() {
        Preconditions.checkMainThread("onPause must be called from the UI thread.");
        zzcfz zzcfzVar = this.zzd;
        if (zzcfzVar != null) {
            zzcfzVar.zzu();
        }
    }

    public final void zzg(int i11) {
        zzcfz zzcfzVar = this.zzd;
        if (zzcfzVar != null) {
            zzcfzVar.zzC(i11);
        }
    }
}
