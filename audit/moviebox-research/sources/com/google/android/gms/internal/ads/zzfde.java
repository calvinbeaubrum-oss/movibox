package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.common.util.concurrent.s;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfde implements zzfed {
    private zzdae zza;
    private final Executor zzb = zzgfe.zzb();

    public final zzdae zza() {
        return this.zza;
    }

    public final s zzb(zzfee zzfeeVar, zzfec zzfecVar, @Nullable zzdae zzdaeVar) {
        zzdad zzdadVarZza = zzfecVar.zza(zzfeeVar.zzb);
        zzdadVarZza.zzb(new zzfeh(true));
        zzdae zzdaeVar2 = (zzdae) zzdadVarZza.zzh();
        this.zza = zzdaeVar2;
        final zzcxp zzcxpVarZzb = zzdaeVar2.zzb();
        final zzfje zzfjeVar = new zzfje();
        return zzgen.zzm(zzgen.zzn(zzgee.zzu(zzcxpVarZzb.zzj()), new zzgdu() { // from class: com.google.android.gms.internal.ads.zzfdc
            @Override // com.google.android.gms.internal.ads.zzgdu
            public final s zza(Object obj) {
                zzfgy zzfgyVar = (zzfgy) obj;
                zzfjeVar.zzb = zzfgyVar;
                Iterator it = zzfgyVar.zzb.zza.iterator();
                boolean z11 = false;
                while (it.hasNext()) {
                    Iterator it2 = ((zzfgm) it.next()).zza.iterator();
                    while (it2.hasNext()) {
                        if (!((String) it2.next()).contains("FirstPartyRenderer")) {
                            return zzgen.zzh(null);
                        }
                        z11 = true;
                    }
                }
                if (z11) {
                    return zzcxpVarZzb.zzi(zzgen.zzh(zzfgyVar));
                }
                return zzgen.zzh(null);
            }
        }, this.zzb), new zzfws() { // from class: com.google.android.gms.internal.ads.zzfdd
            @Override // com.google.android.gms.internal.ads.zzfws
            public final Object apply(Object obj) {
                zzfje zzfjeVar2 = zzfjeVar;
                zzfjeVar2.zzc = (zzcwh) obj;
                return zzfjeVar2;
            }
        }, this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzfed
    public final /* bridge */ /* synthetic */ s zzc(zzfee zzfeeVar, zzfec zzfecVar, @Nullable Object obj) {
        return zzb(zzfeeVar, zzfecVar, null);
    }

    @Override // com.google.android.gms.internal.ads.zzfed
    public final /* synthetic */ Object zzd() {
        return this.zza;
    }
}
