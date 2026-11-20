package com.bytedance.sdk.openadsdk.UFX.sc;

import androidx.annotation.NonNull;
import com.bytedance.sdk.component.sc.Xc;
import com.bytedance.sdk.component.utils.Tf;
import com.bytedance.sdk.openadsdk.core.HJN;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class pFF extends com.bytedance.sdk.component.sc.We<JSONObject, JSONObject> {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final WeakReference<HJN> f27294sc;

    public pFF(HJN hjn) {
        this.f27294sc = new WeakReference<>(hjn);
    }

    public static void sc(Xc xc2, final HJN hjn) {
        xc2.sc("interstitial_webview_close", new com.bytedance.sdk.component.sc.We.pFF() { // from class: com.bytedance.sdk.openadsdk.UFX.sc.pFF.1
            @Override // com.bytedance.sdk.component.sc.We.pFF
            public com.bytedance.sdk.component.sc.We sc() {
                return new pFF(hjn);
            }
        });
    }

    @Override // com.bytedance.sdk.component.sc.We
    public void sc(@NonNull JSONObject jSONObject, @NonNull com.bytedance.sdk.component.sc.TRI tri) throws Exception {
        com.bytedance.sdk.openadsdk.core.Ol.pFF().Xc();
        HJN hjn = this.f27294sc.get();
        if (hjn != null) {
            hjn.qr();
        } else {
            Tf.sc("DoInterstitialWebViewCloseMethod", "invoke error");
            zY();
        }
    }
}
