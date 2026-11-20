package com.bytedance.sdk.openadsdk.component.sc;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.Qj.Ol;
import com.bytedance.sdk.openadsdk.core.Qj.Qj;
import com.bytedance.sdk.openadsdk.core.model.JPJ;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import com.bytedance.sdk.openadsdk.core.pFF.zY;
import com.bytedance.sdk.openadsdk.wjp.sc.sc.qr;
import java.util.HashMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class pFF {
    public static Qj pFF(Sfl sfl, Activity activity, final com.bytedance.sdk.openadsdk.component.Qj.sc scVar, com.bytedance.sdk.openadsdk.component.Ol.pFF pff) {
        Qj qj2 = new Qj(activity.getApplicationContext(), sfl, "open_ad", 4) { // from class: com.bytedance.sdk.openadsdk.component.sc.pFF.2
            @Override // com.bytedance.sdk.openadsdk.core.pFF.sc, com.bytedance.sdk.openadsdk.core.pFF.pFF, com.bytedance.sdk.openadsdk.core.pFF.zY
            public void sc(View view, float f11, float f12, float f13, float f14, SparseArray<zY.sc> sparseArray, boolean z11) {
                HashMap map = new HashMap();
                map.put("duration", Long.valueOf(scVar.pFF()));
                sc(map);
                super.sc(view, f11, f12, f13, f14, sparseArray, z11);
            }
        };
        qj2.sc((View) pff);
        sc(activity.getApplicationContext(), sfl, qj2);
        sc(qj2, sfl);
        return qj2;
    }

    public static sc sc(Sfl sfl, Activity activity, com.bytedance.sdk.openadsdk.component.Qj.sc scVar) {
        sc scVar2 = new sc(activity.getApplicationContext(), sfl, "open_ad", 4, scVar);
        scVar2.sc(activity.findViewById(R.id.content));
        scVar2.pFF(activity.findViewById(520093713));
        sc(activity.getApplicationContext(), sfl, scVar2);
        sc(scVar2, sfl);
        return scVar2;
    }

    public static Ol sc(Sfl sfl, Activity activity, final com.bytedance.sdk.openadsdk.component.Qj.sc scVar, com.bytedance.sdk.openadsdk.component.Ol.pFF pff) {
        Ol ol2 = new Ol(activity, sfl, "open_ad", 4) { // from class: com.bytedance.sdk.openadsdk.component.sc.pFF.1
            @Override // com.bytedance.sdk.openadsdk.core.pFF.pFF, com.bytedance.sdk.openadsdk.core.pFF.zY
            public void sc(View view, float f11, float f12, float f13, float f14, SparseArray<zY.sc> sparseArray, boolean z11) {
                HashMap map = new HashMap();
                map.put("duration", Long.valueOf(scVar.pFF()));
                sc(map);
                super.sc(view, f11, f12, f13, f14, sparseArray, z11);
            }
        };
        ol2.sc(pff);
        sc(activity.getApplicationContext(), sfl, ol2);
        sc(ol2, sfl);
        return ol2;
    }

    private static void sc(Context context, Sfl sfl, com.bytedance.sdk.openadsdk.core.pFF.pFF pff) {
        if (sfl == null || sfl.QLv() != 4) {
            return;
        }
        pff.sc(qr.sc(context, sfl, "open_ad"));
    }

    public static void sc(com.bytedance.sdk.openadsdk.core.pFF.pFF pff, Sfl sfl) {
        HashMap map = new HashMap();
        map.put("click_area", Integer.valueOf(sfl.Ql()));
        map.put("openad_creative_type", Sfl.ExN(sfl) ? "video_normal_ad" : "image_normal_ad");
        map.put("click_scence", Integer.valueOf(JPJ.zY(sfl) ? 3 : 1));
        pff.sc(map);
    }
}
