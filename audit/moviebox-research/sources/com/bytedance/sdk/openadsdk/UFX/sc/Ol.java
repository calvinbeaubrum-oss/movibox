package com.bytedance.sdk.openadsdk.UFX.sc;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.component.sc.Xc;
import com.bytedance.sdk.openadsdk.core.HJN;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class Ol extends com.bytedance.sdk.component.sc.ExN<JSONObject, JSONObject> {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final HJN f27288sc;

    public Ol(HJN hjn) {
        this.f27288sc = hjn;
    }

    public static void sc(Xc xc2, HJN hjn) {
        xc2.sc("overlayRenderFinish", new Ol(hjn));
    }

    @Override // com.bytedance.sdk.component.sc.ExN
    @Nullable
    public JSONObject sc(@NonNull JSONObject jSONObject, @NonNull com.bytedance.sdk.component.sc.TRI tri) throws Exception {
        this.f27288sc.Tf();
        return null;
    }
}
