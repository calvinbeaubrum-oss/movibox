package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.s;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfjx {
    private final zzfjq zza;
    private final s zzb;
    private boolean zzc = false;
    private boolean zzd = false;

    public zzfjx(final zzfiv zzfivVar, final zzfjp zzfjpVar, final zzfjq zzfjqVar) {
        this.zza = zzfjqVar;
        this.zzb = zzgen.zzf(zzgen.zzn(zzfjpVar.zza(zzfjqVar), new zzgdu() { // from class: com.google.android.gms.internal.ads.zzfjv
            @Override // com.google.android.gms.internal.ads.zzgdu
            public final s zza(Object obj) {
                return this.zza.zzb(zzfjpVar, zzfivVar, zzfjqVar, (zzfje) obj);
            }
        }, zzfjqVar.zzb()), Exception.class, new zzgdu() { // from class: com.google.android.gms.internal.ads.zzfjw
            @Override // com.google.android.gms.internal.ads.zzgdu
            public final s zza(Object obj) {
                return this.zza.zzc(zzfjpVar, (Exception) obj);
            }
        }, zzfjqVar.zzb());
    }

    public final synchronized s zza(zzfjq zzfjqVar) {
        if (!this.zzd && !this.zzc && this.zza.zza() != null && zzfjqVar.zza() != null && this.zza.zza().equals(zzfjqVar.zza())) {
            this.zzc = true;
            return this.zzb;
        }
        return null;
    }

    public final /* synthetic */ s zzb(zzfjp zzfjpVar, zzfiv zzfivVar, zzfjq zzfjqVar, zzfje zzfjeVar) throws Exception {
        synchronized (this) {
            try {
                this.zzd = true;
                zzfjpVar.zzb(zzfjeVar);
                if (this.zzc) {
                    return zzgen.zzh(new zzfjo(zzfjeVar, zzfjqVar));
                }
                zzfivVar.zzd(zzfjqVar.zza(), zzfjeVar);
                return zzgen.zzh(null);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final /* synthetic */ s zzc(zzfjp zzfjpVar, Exception exc) throws Exception {
        synchronized (this) {
            this.zzd = true;
            throw exc;
        }
    }

    public final synchronized void zzd(zzgej zzgejVar) {
        zzgen.zzr(zzgen.zzn(this.zzb, new zzgdu() { // from class: com.google.android.gms.internal.ads.zzfju
            @Override // com.google.android.gms.internal.ads.zzgdu
            public final s zza(Object obj) {
                return zzgen.zzi();
            }
        }, this.zza.zzb()), zzgejVar, this.zza.zzb());
    }
}
