package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzbsa implements zzbnu {
    final /* synthetic */ zzbsb zza;
    private final zzbrd zzb;
    private final zzceu zzc;

    public zzbsa(zzbsb zzbsbVar, zzbrd zzbrdVar, zzceu zzceuVar) {
        this.zza = zzbsbVar;
        this.zzb = zzbrdVar;
        this.zzc = zzceuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbnu
    public final void zza(@Nullable String str) {
        try {
            if (str == null) {
                this.zzc.zzd(new zzbrm());
            } else {
                this.zzc.zzd(new zzbrm(str));
            }
        } catch (IllegalStateException unused) {
        } finally {
            this.zzb.zzb();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbnu
    public final void zzb(JSONObject jSONObject) {
        try {
            try {
                this.zzc.zzc(this.zza.zza.zza(jSONObject));
            } catch (IllegalStateException unused) {
            } catch (JSONException e11) {
                this.zzc.zzd(e11);
            }
        } finally {
            this.zzb.zzb();
        }
    }
}
