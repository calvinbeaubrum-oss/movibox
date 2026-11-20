package com.bytedance.sdk.openadsdk.UFX.sc;

import com.bytedance.sdk.component.sc.Xc;
import com.bytedance.sdk.component.utils.Tf;
import com.bytedance.sdk.openadsdk.core.HJN;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import com.hisavana.common.tracking.TrackingKey;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class TRI extends com.bytedance.sdk.component.sc.ExN<JSONObject, JSONObject> {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final WeakReference<HJN> f27290sc;

    public TRI(HJN hjn) {
        this.f27290sc = new WeakReference<>(hjn);
    }

    public static void sc(Xc xc2, HJN hjn) {
        xc2.sc("interactiveFinish", new TRI(hjn));
    }

    @Override // com.bytedance.sdk.component.sc.ExN
    public JSONObject sc(JSONObject jSONObject, com.bytedance.sdk.component.sc.TRI tri) throws Exception {
        JSONObject jSONObject2 = new JSONObject();
        WeakReference<HJN> weakReference = this.f27290sc;
        if (weakReference != null && weakReference.get() != null) {
            HJN hjn = this.f27290sc.get();
            Sfl sflZY = hjn.zY();
            try {
                boolean z11 = true;
                int i11 = 0;
                if (jSONObject.optInt("finish", 1) != 1) {
                    z11 = false;
                }
                int iOptInt = jSONObject.optInt("reduce_duration", -1);
                int iEf = sflZY != null ? sflZY.ef() : 0;
                if (iOptInt >= 0 && iEf >= 0) {
                    iOptInt = Math.min(iOptInt, iEf);
                } else if (iOptInt < 0) {
                    iOptInt = iEf >= 0 ? iEf : 0;
                }
                if (z11) {
                    hjn.zY(iOptInt);
                } else {
                    i11 = -1;
                }
                jSONObject2.put(TrackingKey.CODE, i11);
                jSONObject2.put("reduce_duration", iOptInt);
            } catch (JSONException e11) {
                Tf.sc("InteractiveFinishMethod", e11.getMessage());
            }
        }
        return jSONObject2;
    }
}
