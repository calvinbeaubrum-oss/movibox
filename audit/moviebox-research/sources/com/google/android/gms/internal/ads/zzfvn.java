package com.google.android.gms.internal.ads;

import android.os.IBinder;
import androidx.annotation.Nullable;
import com.google.android.material.card.MaterialCardView;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzfvn {
    public static zzfvm zzl() {
        zzfus zzfusVar = new zzfus();
        zzfusVar.zzd(MaterialCardView.CHECKED_ICON_GRAVITY_BOTTOM_START);
        zzfusVar.zze(-1.0f);
        zzfusVar.zzc(0);
        zzfusVar.zzf(false);
        return zzfusVar;
    }

    public abstract float zza();

    public abstract int zzb();

    public abstract int zzc();

    public abstract int zzd();

    public abstract IBinder zze();

    @Nullable
    public abstract String zzf();

    @Nullable
    public abstract String zzg();

    @Nullable
    public abstract String zzh();

    @Nullable
    public abstract String zzi();

    @Nullable
    public abstract String zzj();

    public abstract boolean zzk();
}
