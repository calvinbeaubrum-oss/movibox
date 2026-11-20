package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import androidx.annotation.Nullable;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzens implements zzeip {
    private final zzeow zza;
    private final zzdua zzb;

    public zzens(zzeow zzeowVar, zzdua zzduaVar) {
        this.zza = zzeowVar;
        this.zzb = zzduaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeip
    @Nullable
    public final zzeiq zza(String str, JSONObject jSONObject) throws zzfho {
        zzbus zzbusVarZzb;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzbE)).booleanValue()) {
            try {
                zzbusVarZzb = this.zzb.zzb(str);
            } catch (RemoteException e11) {
                zzcec.zzh("Coundn't create RTB adapter: ", e11);
                zzbusVarZzb = null;
            }
        } else {
            zzbusVarZzb = this.zza.zza(str);
        }
        if (zzbusVarZzb == null) {
            return null;
        }
        return new zzeiq(zzbusVarZzb, new zzekj(), str);
    }
}
