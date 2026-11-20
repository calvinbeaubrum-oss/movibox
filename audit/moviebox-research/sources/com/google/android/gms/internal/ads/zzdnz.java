package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.ViewGroup;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzdnz implements zzbja {
    final /* synthetic */ zzdow zza;
    final /* synthetic */ ViewGroup zzb;

    public zzdnz(zzdow zzdowVar, ViewGroup viewGroup) {
        this.zza = zzdowVar;
        this.zzb = viewGroup;
    }

    @Override // com.google.android.gms.internal.ads.zzbja
    public final JSONObject zza() {
        return this.zza.zzo();
    }

    @Override // com.google.android.gms.internal.ads.zzbja
    public final JSONObject zzb() {
        return this.zza.zzp();
    }

    @Override // com.google.android.gms.internal.ads.zzbja
    public final void zzc() {
        zzgaa zzgaaVar = zzdnw.zza;
        Map mapZzm = this.zza.zzm();
        if (mapZzm == null) {
            return;
        }
        int size = zzgaaVar.size();
        int i11 = 0;
        while (i11 < size) {
            Object obj = mapZzm.get((String) zzgaaVar.get(i11));
            i11++;
            if (obj != null) {
                this.zza.onClick(this.zzb);
                return;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbja
    public final void zzd(MotionEvent motionEvent) {
        this.zza.onTouch(null, motionEvent);
    }
}
