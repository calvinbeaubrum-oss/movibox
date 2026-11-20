package com.bytedance.sdk.openadsdk.component.sc;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.JPJ.pFF.ExN;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import com.bytedance.sdk.openadsdk.core.pFF.zY;
import java.util.HashMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class sc extends com.bytedance.sdk.openadsdk.core.pFF.sc {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final com.bytedance.sdk.openadsdk.component.Qj.sc f27986sc;

    public sc(@NonNull Context context, @NonNull Sfl sfl, @NonNull String str, int i11, com.bytedance.sdk.openadsdk.component.Qj.sc scVar) {
        super(context, sfl, str, i11);
        this.f27986sc = scVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.pFF.sc, com.bytedance.sdk.openadsdk.core.pFF.pFF, com.bytedance.sdk.openadsdk.core.pFF.zY
    public void sc(View view, float f11, float f12, float f13, float f14, SparseArray<zY.sc> sparseArray, boolean z11) {
        if (view.getTag() == "open_ad_click_button_tag") {
            sc("click_bar");
        } else {
            sc("click_material");
        }
        HashMap map = new HashMap();
        map.put("duration", Long.valueOf(this.f27986sc.pFF()));
        sc(map);
        super.sc(view, f11, f12, f13, f14, sparseArray, z11);
        ExN.sc(((com.bytedance.sdk.openadsdk.core.pFF.pFF) this).TRI, 9);
    }
}
