package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class zzfmn {
    public static zzfmo zza(Context context, int i11) {
        boolean zBooleanValue;
        if (zzfnc.zza()) {
            int i12 = i11 - 2;
            if (i12 != 20 && i12 != 21) {
                switch (i12) {
                    case 2:
                    case 3:
                    case 6:
                    case 7:
                    case 8:
                        zBooleanValue = ((Boolean) zzbht.zzc.zze()).booleanValue();
                        break;
                    case 4:
                    case 9:
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                        zBooleanValue = ((Boolean) zzbht.zzd.zze()).booleanValue();
                        break;
                    case 5:
                        zBooleanValue = ((Boolean) zzbht.zzb.zze()).booleanValue();
                        break;
                }
            } else {
                zBooleanValue = ((Boolean) zzbht.zze.zze()).booleanValue();
            }
            if (zBooleanValue) {
                return new zzfmq(context, i11);
            }
        }
        return new zzfnl();
    }

    public static zzfmo zzb(Context context, int i11, int i12, com.google.android.gms.ads.internal.client.zzl zzlVar) {
        zzfmo zzfmoVarZza = zza(context, i11);
        if (zzfmoVarZza instanceof zzfmq) {
            zzfmoVarZza.zzh();
            zzfmoVarZza.zzm(i12);
            if (zzfmy.zze(zzlVar.zzp)) {
                zzfmoVarZza.zze(zzlVar.zzp);
            }
        }
        return zzfmoVarZza;
    }
}
