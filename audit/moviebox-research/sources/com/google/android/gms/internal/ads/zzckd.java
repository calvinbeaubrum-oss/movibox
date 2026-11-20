package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzckd implements zzbng {
    final /* synthetic */ zzckf zza;

    public zzckd(zzckf zzckfVar) {
        this.zza = zzckfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbng
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        if (map != null) {
            String str = (String) map.get("height");
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                int i11 = Integer.parseInt(str);
                synchronized (this.zza) {
                    try {
                        zzckf zzckfVar = this.zza;
                        if (zzckfVar.zzH != i11) {
                            zzckfVar.zzH = i11;
                            this.zza.requestLayout();
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            } catch (Exception e11) {
                zzcec.zzk("Exception occurred while getting webview content height", e11);
            }
        }
    }
}
