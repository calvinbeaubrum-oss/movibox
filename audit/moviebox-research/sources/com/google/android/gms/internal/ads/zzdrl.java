package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.amazonaws.services.s3.model.InstructionFileId;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdrl implements zzbng {

    @Nullable
    private final zzbkq zza;
    private final zzdrz zzb;
    private final zzhgx zzc;

    public zzdrl(zzdnl zzdnlVar, zzdna zzdnaVar, zzdrz zzdrzVar, zzhgx zzhgxVar) {
        this.zza = zzdnlVar.zzc(zzdnaVar.zzA());
        this.zzb = zzdrzVar;
        this.zzc = zzhgxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbng
    public final void zza(Object obj, Map map) {
        String str = (String) map.get("asset");
        try {
            this.zza.zze((zzbkg) this.zzc.zzb(), str);
        } catch (RemoteException e11) {
            zzcec.zzk("Failed to call onCustomClick for asset " + str + InstructionFileId.DOT, e11);
        }
    }

    public final void zzb() {
        if (this.zza == null) {
            return;
        }
        this.zzb.zzi("/nativeAdCustomClick", this);
    }
}
