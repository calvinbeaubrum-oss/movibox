package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzejc implements zzeit {
    private final Context zza;
    private final zzctt zzb;
    private final Executor zzc;

    public zzejc(Context context, zzctt zzcttVar, Executor executor) {
        this.zza = context;
        this.zzb = zzcttVar;
        this.zzc = executor;
    }

    @Override // com.google.android.gms.internal.ads.zzeit
    public final /* bridge */ /* synthetic */ Object zza(zzfgy zzfgyVar, zzfgm zzfgmVar, final zzeiq zzeiqVar) throws zzeml, zzfho {
        zzctq zzctqVarZza = this.zzb.zza(new zzcwx(zzfgyVar, zzfgmVar, zzeiqVar.zza), new zzdjr(new zzdkw() { // from class: com.google.android.gms.internal.ads.zzejb
            @Override // com.google.android.gms.internal.ads.zzdkw
            public final void zza(boolean z11, Context context, zzdbk zzdbkVar) throws zzdkv {
                zzeiq zzeiqVar2 = zzeiqVar;
                try {
                    ((zzfif) zzeiqVar2.zzb).zzv(z11);
                    ((zzfif) zzeiqVar2.zzb).zzw(context);
                } catch (zzfho e11) {
                    throw new zzdkv(e11.getCause());
                }
            }
        }, null), new zzctr(zzfgmVar.zzab));
        zzctqVarZza.zzd().zzo(new zzcrv((zzfif) zzeiqVar.zzb), this.zzc);
        ((zzekj) zzeiqVar.zzc).zzc(zzctqVarZza.zzj());
        return zzctqVarZza.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzeit
    public final void zzb(zzfgy zzfgyVar, zzfgm zzfgmVar, zzeiq zzeiqVar) throws zzfho {
        zzfif zzfifVar = (zzfif) zzeiqVar.zzb;
        zzfhh zzfhhVar = zzfgyVar.zza.zza;
        zzfifVar.zzl(this.zza, zzfhhVar.zzd, zzfgmVar.zzw.toString(), (zzbtb) zzeiqVar.zzc);
    }
}
