package com.google.android.gms.internal.ads;

import android.media.AudioAttributes;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
@RequiresApi(21)
public final class zzi {
    public final AudioAttributes zza;

    public /* synthetic */ zzi(zzk zzkVar, zzh zzhVar) {
        AudioAttributes.Builder usage = new AudioAttributes.Builder().setContentType(0).setFlags(0).setUsage(1);
        int i11 = zzfy.zza;
        if (i11 >= 29) {
            zzf.zza(usage, 1);
        }
        if (i11 >= 32) {
            zzg.zza(usage, 0);
        }
        this.zza = usage.build();
    }
}
