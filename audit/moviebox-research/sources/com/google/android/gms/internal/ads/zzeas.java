package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.common.api.Api;
import com.hisavana.common.tracking.TrackingKey;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzeas implements zzhhd {
    private final zzhhu zza;

    public zzeas(zzhhu zzhhuVar) {
        this.zza = zzhhuVar;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0037  */
    /* JADX WARN: Code duplicated, block: B:14:0x0052  */
    /* JADX WARN: Code duplicated, block: B:18:0x003d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzhhu
    public final /* bridge */ /* synthetic */ Object zzb() {
        String strValueOf;
        zzfhh zzfhhVarZza = ((zzdao) this.zza).zza();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzhm)).booleanValue()) {
            String str = zzfhhVarZza.zzd.zzx;
            if (!TextUtils.isEmpty(str)) {
                try {
                    strValueOf = new JSONObject(str).getString(TrackingKey.REQUEST_ID);
                    if (TextUtils.isEmpty(strValueOf)) {
                        if (zzfhhVarZza.zzd.zzs != null) {
                            try {
                                strValueOf = new JSONObject(zzfhhVarZza.zzd.zzs.zza).getString(TrackingKey.REQUEST_ID);
                                if (TextUtils.isEmpty(strValueOf)) {
                                    strValueOf = String.valueOf(com.google.android.gms.ads.internal.client.zzay.zze().nextInt() & Api.BaseClientBuilder.API_PRIORITY_OTHER);
                                }
                            } catch (JSONException unused) {
                            }
                        } else {
                            strValueOf = String.valueOf(com.google.android.gms.ads.internal.client.zzay.zze().nextInt() & Api.BaseClientBuilder.API_PRIORITY_OTHER);
                        }
                    }
                } catch (JSONException unused2) {
                }
            } else if (zzfhhVarZza.zzd.zzs != null) {
                strValueOf = new JSONObject(zzfhhVarZza.zzd.zzs.zza).getString(TrackingKey.REQUEST_ID);
                if (TextUtils.isEmpty(strValueOf)) {
                    strValueOf = String.valueOf(com.google.android.gms.ads.internal.client.zzay.zze().nextInt() & Api.BaseClientBuilder.API_PRIORITY_OTHER);
                }
            } else {
                strValueOf = String.valueOf(com.google.android.gms.ads.internal.client.zzay.zze().nextInt() & Api.BaseClientBuilder.API_PRIORITY_OTHER);
            }
        } else {
            strValueOf = String.valueOf(com.google.android.gms.ads.internal.client.zzay.zze().nextInt() & Api.BaseClientBuilder.API_PRIORITY_OTHER);
        }
        zzhhl.zzb(strValueOf);
        return strValueOf;
    }
}
