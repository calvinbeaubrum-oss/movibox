package com.bytedance.sdk.openadsdk.UFX.sc;

import com.bytedance.sdk.component.sc.Xc;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class WH extends com.bytedance.sdk.component.sc.ExN<JSONObject, JSONObject> {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private WeakReference<com.bytedance.sdk.component.Ol.We> f27292sc;

    public WH(com.bytedance.sdk.component.Ol.We we2) {
        this.f27292sc = new WeakReference<>(we2);
    }

    public static void sc(Xc xc2, com.bytedance.sdk.component.Ol.We we2) {
        xc2.sc("preventTouchEvent", new WH(we2));
    }

    @Override // com.bytedance.sdk.component.sc.ExN
    public JSONObject sc(JSONObject jSONObject, com.bytedance.sdk.component.sc.TRI tri) throws Exception {
        JSONObject jSONObject2 = new JSONObject();
        try {
            boolean zOptBoolean = jSONObject.optBoolean("isPrevent", false);
            com.bytedance.sdk.component.Ol.We we2 = this.f27292sc.get();
            if (we2 != null) {
                we2.setIsPreventTouchEvent(zOptBoolean);
                jSONObject2.put("success", true);
            } else {
                jSONObject2.put("success", false);
            }
        } catch (Throwable unused) {
            jSONObject2.put("success", false);
        }
        return jSONObject2;
    }
}
