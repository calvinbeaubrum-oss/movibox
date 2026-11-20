package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.s;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class zzfay implements zzexq {
    public static final /* synthetic */ zzfay zza = new zzfay();

    private /* synthetic */ zzfay() {
    }

    @Override // com.google.android.gms.internal.ads.zzexq
    public final /* synthetic */ int zza() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzexq
    public final s zzb() {
        return zzgen.zzh(new zzexp() { // from class: com.google.android.gms.internal.ads.zzfaz
            @Override // com.google.android.gms.internal.ads.zzexp
            public final void zzj(Object obj) {
                try {
                    ((JSONObject) obj).getJSONObject("sdk_env").put("container_version", 12451000);
                } catch (JSONException unused) {
                }
            }
        });
    }
}
