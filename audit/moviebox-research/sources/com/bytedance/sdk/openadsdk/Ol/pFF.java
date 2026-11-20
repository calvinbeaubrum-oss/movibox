package com.bytedance.sdk.openadsdk.Ol;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bytedance.sdk.component.ExN.UFX;
import com.bytedance.sdk.component.ExN.dE;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import com.bytedance.sdk.openadsdk.utils.cJ;
import com.hisavana.common.tracking.TrackingKey;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class pFF<T> implements dE<T> {
    private final Sfl We;
    private final String pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final long f27105sc = SystemClock.elapsedRealtime();
    private final dE<T> zY;

    public pFF(Sfl sfl, String str, dE<T> dEVar) {
        this.zY = dEVar;
        this.We = sfl;
        this.pFF = str;
    }

    @Override // com.bytedance.sdk.component.ExN.dE
    public void sc(final int i11, final String str, @Nullable Throwable th2) {
        dE<T> dEVar = this.zY;
        if (dEVar != null) {
            dEVar.sc(i11, str, th2);
        }
        Sfl sfl = this.We;
        if (sfl == null || TextUtils.isEmpty(cJ.sc(sfl))) {
            return;
        }
        final long jElapsedRealtime = SystemClock.elapsedRealtime() - this.f27105sc;
        com.bytedance.sdk.openadsdk.SR.zY.sc("load_image_error", false, new com.bytedance.sdk.openadsdk.SR.pFF() { // from class: com.bytedance.sdk.openadsdk.Ol.pFF.2
            @Override // com.bytedance.sdk.openadsdk.SR.pFF
            @Nullable
            public com.bytedance.sdk.openadsdk.SR.sc.zY getLogStats() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("duration", jElapsedRealtime);
                jSONObject.put("url", pFF.this.pFF);
                jSONObject.put(TrackingKey.ERROR_CODE, i11);
                jSONObject.put(TrackingKey.ERROR_MESSAGE, str);
                jSONObject.put("image_mode", pFF.this.We.dix());
                return com.bytedance.sdk.openadsdk.SR.sc.We.pFF().sc("load_image_error").sc(pFF.this.We.Zn()).pFF(jSONObject.toString());
            }
        });
    }

    @Override // com.bytedance.sdk.component.ExN.dE
    public void sc(UFX<T> ufx) {
        dE<T> dEVar = this.zY;
        if (dEVar != null) {
            dEVar.sc(ufx);
        }
        if (this.We != null) {
            final long jElapsedRealtime = SystemClock.elapsedRealtime() - this.f27105sc;
            final int iQr = ufx.qr() / 1024;
            final int i11 = ufx.TRI() ? 1 : 0;
            com.bytedance.sdk.openadsdk.SR.zY.sc("load_image_success", false, new com.bytedance.sdk.openadsdk.SR.pFF() { // from class: com.bytedance.sdk.openadsdk.Ol.pFF.1
                @Override // com.bytedance.sdk.openadsdk.SR.pFF
                @Nullable
                public com.bytedance.sdk.openadsdk.SR.sc.zY getLogStats() throws Exception {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("duration", jElapsedRealtime);
                    jSONObject.put("url", pFF.this.pFF);
                    jSONObject.put("preload_size", iQr);
                    jSONObject.put("local_cache", i11);
                    jSONObject.put("image_mode", pFF.this.We.dix());
                    return com.bytedance.sdk.openadsdk.SR.sc.We.pFF().sc("load_image_success").sc(pFF.this.We.Zn()).pFF(jSONObject.toString());
                }
            });
        }
    }
}
