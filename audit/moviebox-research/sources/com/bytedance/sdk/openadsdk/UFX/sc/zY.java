package com.bytedance.sdk.openadsdk.UFX.sc;

import androidx.annotation.NonNull;
import com.bytedance.sdk.component.sc.Xc;
import com.bytedance.sdk.openadsdk.core.HJN;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class zY extends com.bytedance.sdk.component.sc.We<JSONObject, JSONObject> {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final WeakReference<HJN> f27300sc;

    public zY(HJN hjn) {
        this.f27300sc = new WeakReference<>(hjn);
    }

    public static void sc(Xc xc2, final HJN hjn) {
        xc2.sc("newClickEvent", new com.bytedance.sdk.component.sc.We.pFF() { // from class: com.bytedance.sdk.openadsdk.UFX.sc.zY.1
            @Override // com.bytedance.sdk.component.sc.We.pFF
            public com.bytedance.sdk.component.sc.We sc() {
                return new zY(hjn);
            }
        });
    }

    @Override // com.bytedance.sdk.component.sc.We
    public void sc(@NonNull JSONObject jSONObject, @NonNull com.bytedance.sdk.component.sc.TRI tri) throws Exception {
        HJN hjn = this.f27300sc.get();
        if (hjn == null) {
            zY();
        } else {
            hjn.ExN(jSONObject);
        }
    }
}
