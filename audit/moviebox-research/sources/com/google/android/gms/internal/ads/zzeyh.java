package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.transsion.push.PushConstants;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzeyh implements zzexp {
    final String zza;
    final int zzb;

    public /* synthetic */ zzeyh(String str, int i11, zzeyg zzeygVar) {
        this.zza = str;
        this.zzb = i11;
    }

    @Override // com.google.android.gms.internal.ads.zzexp
    public final /* bridge */ /* synthetic */ void zzj(Object obj) {
        Bundle bundle = (Bundle) obj;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzjU)).booleanValue()) {
            if (!TextUtils.isEmpty(this.zza)) {
                bundle.putString(PushConstants.SP_KEY_SUBSCRIBE_TOPICS, this.zza);
            }
            int i11 = this.zzb;
            if (i11 != -1) {
                bundle.putInt("atps", i11);
            }
        }
    }
}
