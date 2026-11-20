package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.ShowFirstParty;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
@ShowFirstParty
public final class zzfrc {
    private final Context zza;
    private final Looper zzb;

    public zzfrc(@NonNull Context context, @NonNull Looper looper) {
        this.zza = context;
        this.zzb = looper;
    }

    public final void zza(@NonNull String str) {
        zzfrq zzfrqVarZza = zzfrs.zza();
        zzfrqVarZza.zza(this.zza.getPackageName());
        zzfrqVarZza.zzc(2);
        zzfrn zzfrnVarZza = zzfro.zza();
        zzfrnVarZza.zza(str);
        zzfrnVarZza.zzb(2);
        zzfrqVarZza.zzb(zzfrnVarZza);
        new zzfrd(this.zza, this.zzb, (zzfrs) zzfrqVarZza.zzal()).zza();
    }
}
