package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.MobileAds;
import java.util.LinkedHashMap;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzemf implements zzgej {
    final /* synthetic */ long zza;
    final /* synthetic */ zzfgp zzb;
    final /* synthetic */ zzfgm zzc;
    final /* synthetic */ String zzd;
    final /* synthetic */ zzfnu zze;
    final /* synthetic */ zzfgy zzf;
    final /* synthetic */ zzemh zzg;

    public zzemf(zzemh zzemhVar, long j11, zzfgp zzfgpVar, zzfgm zzfgmVar, String str, zzfnu zzfnuVar, zzfgy zzfgyVar) {
        this.zza = j11;
        this.zzb = zzfgpVar;
        this.zzc = zzfgmVar;
        this.zzd = str;
        this.zze = zzfnuVar;
        this.zzf = zzfgyVar;
        this.zzg = zzemhVar;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0072 A[Catch: all -> 0x0083, TryCatch #0 {all -> 0x0083, blocks: (B:32:0x006a, B:34:0x0072, B:36:0x007e, B:40:0x0086, B:41:0x008e, B:43:0x00a0, B:44:0x00b5, B:46:0x00bd, B:48:0x00bf, B:56:0x00fd, B:57:0x0108, B:51:0x00e2, B:53:0x00e6, B:55:0x00f0), top: B:61:0x006a }] */
    /* JADX WARN: Code duplicated, block: B:36:0x007e A[Catch: all -> 0x0083, TryCatch #0 {all -> 0x0083, blocks: (B:32:0x006a, B:34:0x0072, B:36:0x007e, B:40:0x0086, B:41:0x008e, B:43:0x00a0, B:44:0x00b5, B:46:0x00bd, B:48:0x00bf, B:56:0x00fd, B:57:0x0108, B:51:0x00e2, B:53:0x00e6, B:55:0x00f0), top: B:61:0x006a }] */
    /* JADX WARN: Code duplicated, block: B:43:0x00a0 A[Catch: all -> 0x0083, TryCatch #0 {all -> 0x0083, blocks: (B:32:0x006a, B:34:0x0072, B:36:0x007e, B:40:0x0086, B:41:0x008e, B:43:0x00a0, B:44:0x00b5, B:46:0x00bd, B:48:0x00bf, B:56:0x00fd, B:57:0x0108, B:51:0x00e2, B:53:0x00e6, B:55:0x00f0), top: B:61:0x006a }] */
    /* JADX WARN: Code duplicated, block: B:46:0x00bd A[Catch: all -> 0x0083, DONT_GENERATE, TryCatch #0 {all -> 0x0083, blocks: (B:32:0x006a, B:34:0x0072, B:36:0x007e, B:40:0x0086, B:41:0x008e, B:43:0x00a0, B:44:0x00b5, B:46:0x00bd, B:48:0x00bf, B:56:0x00fd, B:57:0x0108, B:51:0x00e2, B:53:0x00e6, B:55:0x00f0), top: B:61:0x006a }] */
    /* JADX WARN: Code duplicated, block: B:48:0x00bf A[Catch: all -> 0x0083, TryCatch #0 {all -> 0x0083, blocks: (B:32:0x006a, B:34:0x0072, B:36:0x007e, B:40:0x0086, B:41:0x008e, B:43:0x00a0, B:44:0x00b5, B:46:0x00bd, B:48:0x00bf, B:56:0x00fd, B:57:0x0108, B:51:0x00e2, B:53:0x00e6, B:55:0x00f0), top: B:61:0x006a }] */
    /* JADX WARN: Code duplicated, block: B:61:0x006a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzgej
    public final void zza(Throwable th2) {
        Integer numValueOf;
        int i11;
        com.google.android.gms.ads.internal.client.zze zzeVarZzb;
        zzemh zzemhVar;
        zzemh zzemhVar2;
        com.google.android.gms.ads.internal.client.zze zzeVarZza;
        int i12;
        com.google.android.gms.ads.internal.client.zze zzeVar;
        long jElapsedRealtime = this.zzg.zza.elapsedRealtime() - this.zza;
        if (!(th2 instanceof TimeoutException)) {
            if (th2 instanceof zzelp) {
                numValueOf = null;
                i11 = 3;
            } else if (th2 instanceof CancellationException) {
                i11 = 4;
            } else if (th2 instanceof zzfho) {
                i11 = 5;
            } else {
                if (th2 instanceof zzead) {
                    int i13 = zzfij.zza(th2).zza == 3 ? 1 : 6;
                    numValueOf = (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzbC)).booleanValue() && (th2 instanceof zzeir) && (zzeVarZzb = ((zzeir) th2).zzb()) != null) ? Integer.valueOf(zzeVarZzb.zza) : null;
                    i11 = i13;
                } else {
                    numValueOf = null;
                    i11 = 6;
                }
            }
            synchronized (this.zzg) {
                try {
                    zzemhVar = this.zzg;
                    if (zzemhVar.zze) {
                        zzemhVar.zzb.zza(this.zzb, this.zzc, i11, th2 instanceof zzeir ? (zzeir) th2 : null, jElapsedRealtime);
                    }
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzij)).booleanValue()) {
                        zzfny zzfnyVar = this.zzg.zzc;
                        zzfnu zzfnuVar = this.zze;
                        zzfgy zzfgyVar = this.zzf;
                        zzfgm zzfgmVar = this.zzc;
                        zzfnyVar.zzd(zzfnuVar.zzc(zzfgyVar, zzfgmVar, zzfgmVar.zzo));
                    }
                    zzemhVar2 = this.zzg;
                    if (zzemhVar2.zzg) {
                        return;
                    }
                    LinkedHashMap linkedHashMap = zzemhVar2.zzd;
                    zzfgm zzfgmVar2 = this.zzc;
                    linkedHashMap.put(zzfgmVar2, new zzemg(this.zzd, zzfgmVar2.zzag, i11, jElapsedRealtime, numValueOf));
                    zzeVarZza = zzfij.zza(th2);
                    i12 = zzeVarZza.zza;
                    if ((i12 != 3 || i12 == 0) && (zzeVar = zzeVarZza.zzd) != null && !zzeVar.zzc.equals(MobileAds.ERROR_DOMAIN)) {
                    }
                    this.zzg.zzf.zzf(this.zzc, jElapsedRealtime, zzeVarZza);
                } catch (Throwable th3) {
                    throw th3;
                }
            }
        }
        i11 = 2;
        numValueOf = null;
        synchronized (this.zzg) {
            zzemhVar = this.zzg;
            if (zzemhVar.zze) {
                zzemhVar.zzb.zza(this.zzb, this.zzc, i11, th2 instanceof zzeir ? (zzeir) th2 : null, jElapsedRealtime);
            }
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzij)).booleanValue()) {
                zzfny zzfnyVar2 = this.zzg.zzc;
                zzfnu zzfnuVar2 = this.zze;
                zzfgy zzfgyVar2 = this.zzf;
                zzfgm zzfgmVar3 = this.zzc;
                zzfnyVar2.zzd(zzfnuVar2.zzc(zzfgyVar2, zzfgmVar3, zzfgmVar3.zzo));
            }
            zzemhVar2 = this.zzg;
            if (zzemhVar2.zzg) {
                return;
            }
            LinkedHashMap linkedHashMap2 = zzemhVar2.zzd;
            zzfgm zzfgmVar4 = this.zzc;
            linkedHashMap2.put(zzfgmVar4, new zzemg(this.zzd, zzfgmVar4.zzag, i11, jElapsedRealtime, numValueOf));
            zzeVarZza = zzfij.zza(th2);
            i12 = zzeVarZza.zza;
            zzeVarZza = i12 != 3 ? zzfij.zza(new zzeir(13, zzeVarZza.zzd)) : zzfij.zza(new zzeir(13, zzeVarZza.zzd));
            this.zzg.zzf.zzf(this.zzc, jElapsedRealtime, zzeVarZza);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgej
    public final void zzb(Object obj) {
        long jElapsedRealtime = this.zzg.zza.elapsedRealtime() - this.zza;
        synchronized (this.zzg) {
            try {
                zzemh zzemhVar = this.zzg;
                if (zzemhVar.zze) {
                    zzemhVar.zzb.zza(this.zzb, this.zzc, 0, null, jElapsedRealtime);
                }
                zzemh zzemhVar2 = this.zzg;
                if (zzemhVar2.zzg) {
                    return;
                }
                if (zzemhVar2.zzq(this.zzc)) {
                    ((zzemg) this.zzg.zzd.get(this.zzc)).zzd = jElapsedRealtime;
                } else {
                    LinkedHashMap linkedHashMap = this.zzg.zzd;
                    zzfgm zzfgmVar = this.zzc;
                    linkedHashMap.put(zzfgmVar, new zzemg(this.zzd, zzfgmVar.zzag, 0, jElapsedRealtime, null));
                }
                this.zzg.zzf.zzg(this.zzc, jElapsedRealtime, null);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
