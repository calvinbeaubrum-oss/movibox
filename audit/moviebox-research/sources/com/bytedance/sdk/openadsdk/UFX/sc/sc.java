package com.bytedance.sdk.openadsdk.UFX.sc;

import androidx.annotation.NonNull;
import com.bytedance.sdk.component.sc.Xc;
import com.bytedance.sdk.openadsdk.core.HJN;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import java.lang.ref.WeakReference;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class sc extends com.bytedance.sdk.component.sc.We<JSONObject, JSONObject> {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final WeakReference<HJN> f27297sc;

    public sc(HJN hjn) {
        this.f27297sc = new WeakReference<>(hjn);
    }

    public static void sc(Xc xc2, final HJN hjn) {
        xc2.sc("getNetworkData", new com.bytedance.sdk.component.sc.We.pFF() { // from class: com.bytedance.sdk.openadsdk.UFX.sc.sc.1
            @Override // com.bytedance.sdk.component.sc.We.pFF
            public com.bytedance.sdk.component.sc.We sc() {
                return new sc(hjn);
            }
        });
    }

    @Override // com.bytedance.sdk.component.sc.We
    public void sc(@NonNull JSONObject jSONObject, @NonNull com.bytedance.sdk.component.sc.TRI tri) throws Exception {
        HJN hjn = this.f27297sc.get();
        if (hjn == null) {
            zY();
        } else {
            hjn.sc(jSONObject, new com.bytedance.sdk.openadsdk.Tf.zY() { // from class: com.bytedance.sdk.openadsdk.UFX.sc.sc.2
                @Override // com.bytedance.sdk.openadsdk.Tf.zY
                public void sc(boolean z11, List<Sfl> list) {
                    try {
                        JSONObject jSONObject2 = new JSONObject();
                        if (!z11) {
                            sc.this.sc(jSONObject2);
                        } else {
                            jSONObject2.put("creatives", HJN.pFF(list));
                            sc.this.sc(jSONObject2);
                        }
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }
}
