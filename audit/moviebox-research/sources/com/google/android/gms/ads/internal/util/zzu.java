package com.google.android.gms.ads.internal.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.webkit.CookieManager;
import android.webkit.WebResourceResponse;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.ads.zzbbp;
import com.google.android.gms.internal.ads.zzcec;
import com.google.android.gms.internal.ads.zzcjk;
import com.google.android.gms.internal.ads.zzcjs;
import com.google.android.gms.internal.ads.zzckp;
import com.google.android.gms.internal.ads.zzehs;
import java.io.InputStream;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
@TargetApi(21)
public class zzu extends zzab {
    public zzu() {
        super(null);
    }

    @Override // com.google.android.gms.ads.internal.util.zzab
    @Nullable
    public final CookieManager zza(Context context) {
        com.google.android.gms.ads.internal.zzt.zzp();
        if (zzt.zzE()) {
            return null;
        }
        try {
            return CookieManager.getInstance();
        } catch (Throwable th2) {
            zzcec.zzh("Failed to obtain CookieManager.", th2);
            com.google.android.gms.ads.internal.zzt.zzo().zzv(th2, "ApiLevelUtil.getCookieManager");
            return null;
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzab
    public final WebResourceResponse zzb(String str, String str2, int i11, String str3, Map map, InputStream inputStream) {
        return new WebResourceResponse(str, str2, i11, str3, map, inputStream);
    }

    @Override // com.google.android.gms.ads.internal.util.zzab
    public final zzcjs zzc(zzcjk zzcjkVar, zzbbp zzbbpVar, boolean z11, @Nullable zzehs zzehsVar) {
        return new zzckp(zzcjkVar, zzbbpVar, z11, zzehsVar);
    }
}
