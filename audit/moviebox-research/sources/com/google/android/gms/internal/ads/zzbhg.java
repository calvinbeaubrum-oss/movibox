package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.query.QueryInfo;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;
import org.json.JSONException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzbhg extends QueryInfoGenerationCallback {
    final /* synthetic */ String zza;
    final /* synthetic */ zzbhh zzb;

    public zzbhg(zzbhh zzbhhVar, String str) {
        this.zza = str;
        this.zzb = zzbhhVar;
    }

    @Override // com.google.android.gms.ads.query.QueryInfoGenerationCallback
    public final void onFailure(String str) {
        zzcec.zzj("Failed to generate query info for Custom Tab error: ".concat(String.valueOf(str)));
        try {
            zzbhh zzbhhVar = this.zzb;
            zzbhhVar.zzd.j(zzbhhVar.zzc(this.zza, str).toString(), null);
        } catch (JSONException e11) {
            zzcec.zzh("Error creating PACT Error Response JSON: ", e11);
        }
    }

    @Override // com.google.android.gms.ads.query.QueryInfoGenerationCallback
    public final void onSuccess(QueryInfo queryInfo) {
        String query = queryInfo.getQuery();
        try {
            zzbhh zzbhhVar = this.zzb;
            zzbhhVar.zzd.j(zzbhhVar.zzd(this.zza, query).toString(), null);
        } catch (JSONException e11) {
            zzcec.zzh("Error creating PACT Signal Response JSON: ", e11);
        }
    }
}
