package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.common.util.concurrent.s;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfld {
    final /* synthetic */ zzfle zza;
    private final Object zzb;

    @Nullable
    private final String zzc;
    private final s zzd;
    private final List zze;
    private final s zzf;

    private zzfld(zzfle zzfleVar, Object obj, String str, s sVar, List list, s sVar2) {
        this.zza = zzfleVar;
        this.zzb = obj;
        this.zzc = str;
        this.zzd = sVar;
        this.zze = list;
        this.zzf = sVar2;
    }

    public final zzfkr zza() {
        Object obj = this.zzb;
        String strZzf = this.zzc;
        if (strZzf == null) {
            strZzf = this.zza.zzf(obj);
        }
        final zzfkr zzfkrVar = new zzfkr(obj, strZzf, this.zzf);
        this.zza.zzd.zza(zzfkrVar);
        s sVar = this.zzd;
        Runnable runnable = new Runnable() { // from class: com.google.android.gms.internal.ads.zzfla
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zza.zzd.zzc(zzfkrVar);
            }
        };
        zzgey zzgeyVar = zzcep.zzf;
        sVar.addListener(runnable, zzgeyVar);
        zzgen.zzr(zzfkrVar, new zzflb(this, zzfkrVar), zzgeyVar);
        return zzfkrVar;
    }

    public final zzfld zzb(Object obj) {
        return this.zza.zzb(obj, zza());
    }

    public final zzfld zzc(Class cls, zzgdu zzgduVar) {
        return new zzfld(this.zza, this.zzb, this.zzc, this.zzd, this.zze, zzgen.zzf(this.zzf, cls, zzgduVar, this.zza.zzb));
    }

    public final zzfld zzd(final s sVar) {
        return zzg(new zzgdu() { // from class: com.google.android.gms.internal.ads.zzfkz
            @Override // com.google.android.gms.internal.ads.zzgdu
            public final s zza(Object obj) {
                return sVar;
            }
        }, zzcep.zzf);
    }

    public final zzfld zze(final zzfkp zzfkpVar) {
        return zzf(new zzgdu() { // from class: com.google.android.gms.internal.ads.zzfky
            @Override // com.google.android.gms.internal.ads.zzgdu
            public final s zza(Object obj) {
                return zzgen.zzh(zzfkpVar.zza(obj));
            }
        });
    }

    public final zzfld zzf(zzgdu zzgduVar) {
        return zzg(zzgduVar, this.zza.zzb);
    }

    public final zzfld zzg(zzgdu zzgduVar, Executor executor) {
        return new zzfld(this.zza, this.zzb, this.zzc, this.zzd, this.zze, zzgen.zzn(this.zzf, zzgduVar, executor));
    }

    public final zzfld zzh(String str) {
        return new zzfld(this.zza, this.zzb, str, this.zzd, this.zze, this.zzf);
    }

    public final zzfld zzi(long j11, TimeUnit timeUnit) {
        return new zzfld(this.zza, this.zzb, this.zzc, this.zzd, this.zze, zzgen.zzo(this.zzf, j11, timeUnit, this.zza.zzc));
    }
}
