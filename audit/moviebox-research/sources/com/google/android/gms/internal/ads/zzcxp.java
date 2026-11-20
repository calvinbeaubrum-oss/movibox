package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.common.util.concurrent.s;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcxp {
    private final zzebl zza;
    private final zzfhh zzb;
    private final zzflm zzc;
    private final zzcqt zzd;
    private final zzemo zze;
    private final zzdgc zzf;

    @Nullable
    private zzfgy zzg;
    private final zzecq zzh;
    private final zzdab zzi;
    private final Executor zzj;
    private final zzecc zzk;
    private final zzeis zzl;
    private final zzedg zzm;
    private final zzedn zzn;

    public zzcxp(zzebl zzeblVar, zzfhh zzfhhVar, zzflm zzflmVar, zzcqt zzcqtVar, zzemo zzemoVar, zzdgc zzdgcVar, @Nullable zzfgy zzfgyVar, zzecq zzecqVar, zzdab zzdabVar, Executor executor, zzecc zzeccVar, zzeis zzeisVar, zzedg zzedgVar, zzedn zzednVar) {
        this.zza = zzeblVar;
        this.zzb = zzfhhVar;
        this.zzc = zzflmVar;
        this.zzd = zzcqtVar;
        this.zze = zzemoVar;
        this.zzf = zzdgcVar;
        this.zzg = zzfgyVar;
        this.zzh = zzecqVar;
        this.zzi = zzdabVar;
        this.zzj = executor;
        this.zzk = zzeccVar;
        this.zzl = zzeisVar;
        this.zzm = zzedgVar;
        this.zzn = zzednVar;
    }

    public final com.google.android.gms.ads.internal.client.zze zza(Throwable th2) {
        return zzfij.zzb(th2, this.zzl);
    }

    public final zzdgc zzc() {
        return this.zzf;
    }

    public final /* synthetic */ zzfgy zzd(zzfgy zzfgyVar) throws Exception {
        this.zzd.zza(zzfgyVar);
        return zzfgyVar;
    }

    public final s zze(final zzfjc zzfjcVar) {
        zzfkr zzfkrVarZza = this.zzc.zzb(zzflg.GET_CACHE_KEY, this.zzi.zzc()).zzf(new zzgdu() { // from class: com.google.android.gms.internal.ads.zzcxl
            @Override // com.google.android.gms.internal.ads.zzgdu
            public final s zza(Object obj) {
                return this.zza.zzf(zzfjcVar, (zzbze) obj);
            }
        }).zza();
        zzgen.zzr(zzfkrVarZza, new zzcxn(this), this.zzj);
        return zzfkrVarZza;
    }

    public final /* synthetic */ s zzf(zzfjc zzfjcVar, zzbze zzbzeVar) throws Exception {
        zzbzeVar.zzi = zzfjcVar;
        return this.zzh.zza(zzbzeVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ s zzg(s sVar, s sVar2, s sVar3) throws Exception {
        return this.zzn.zzc((zzbze) sVar.get(), (JSONObject) sVar2.get(), (zzbzh) sVar3.get());
    }

    public final s zzh(zzbze zzbzeVar) {
        zzfkr zzfkrVarZza = this.zzc.zzb(zzflg.NOTIFY_CACHE_HIT, this.zzh.zzg(zzbzeVar)).zza();
        zzgen.zzr(zzfkrVarZza, new zzcxo(this), this.zzj);
        return zzfkrVarZza;
    }

    public final s zzi(s sVar) {
        zzfld zzfldVarZzf = this.zzc.zzb(zzflg.RENDERER, sVar).zze(new zzfkp() { // from class: com.google.android.gms.internal.ads.zzcxg
            @Override // com.google.android.gms.internal.ads.zzfkp
            public final Object zza(Object obj) throws Exception {
                zzfgy zzfgyVar = (zzfgy) obj;
                this.zza.zzd(zzfgyVar);
                return zzfgyVar;
            }
        }).zzf(this.zze);
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzfv)).booleanValue()) {
            zzfldVarZzf = zzfldVarZzf.zzi(((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzfx)).intValue(), TimeUnit.SECONDS);
        }
        return zzfldVarZzf.zza();
    }

    public final s zzj() {
        com.google.android.gms.ads.internal.client.zzl zzlVar = this.zzb.zzd;
        if (zzlVar.zzx == null && zzlVar.zzs == null) {
            return zzk(this.zzi.zzc());
        }
        zzflm zzflmVar = this.zzc;
        zzebl zzeblVar = this.zza;
        return zzfkw.zzc(zzeblVar.zza(), zzflg.PRELOADED_LOADER, zzflmVar).zza();
    }

    public final s zzk(final s sVar) {
        zzfgy zzfgyVar = this.zzg;
        if (zzfgyVar != null) {
            return zzfkw.zzc(zzgen.zzh(zzfgyVar), zzflg.SERVER_TRANSACTION, this.zzc).zza();
        }
        com.google.android.gms.ads.internal.zzt.zzc().zzj();
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzkV)).booleanValue() || ((Boolean) zzbig.zzc.zze()).booleanValue()) {
            zzfld zzfldVarZzb = this.zzc.zzb(zzflg.SERVER_TRANSACTION, sVar);
            final zzecc zzeccVar = this.zzk;
            Objects.requireNonNull(zzeccVar);
            return zzfldVarZzb.zzf(new zzgdu() { // from class: com.google.android.gms.internal.ads.zzcxm
                @Override // com.google.android.gms.internal.ads.zzgdu
                public final s zza(Object obj) {
                    return zzeccVar.zzb((zzbze) obj);
                }
            }).zza();
        }
        final zzedg zzedgVar = this.zzm;
        Objects.requireNonNull(zzedgVar);
        final s sVarZzn = zzgen.zzn(sVar, new zzgdu() { // from class: com.google.android.gms.internal.ads.zzcxh
            @Override // com.google.android.gms.internal.ads.zzgdu
            public final s zza(Object obj) {
                return zzedgVar.zza((zzbze) obj);
            }
        }, this.zzj);
        zzfld zzfldVarZzb2 = this.zzc.zzb(zzflg.BUILD_URL, sVarZzn);
        final zzecq zzecqVar = this.zzh;
        Objects.requireNonNull(zzecqVar);
        final zzfkr zzfkrVarZza = zzfldVarZzb2.zzf(new zzgdu() { // from class: com.google.android.gms.internal.ads.zzcxi
            @Override // com.google.android.gms.internal.ads.zzgdu
            public final s zza(Object obj) {
                return zzecqVar.zzb((JSONObject) obj);
            }
        }).zza();
        return this.zzc.zza(zzflg.SERVER_TRANSACTION, sVar, sVarZzn, zzfkrVarZza).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzcxj
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zza.zzg(sVar, sVarZzn, zzfkrVarZza);
            }
        }).zzf(new zzgdu() { // from class: com.google.android.gms.internal.ads.zzcxk
            @Override // com.google.android.gms.internal.ads.zzgdu
            public final s zza(Object obj) {
                return (s) obj;
            }
        }).zza();
    }

    public final void zzl(zzfgy zzfgyVar) {
        this.zzg = zzfgyVar;
    }
}
