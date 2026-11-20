package com.bytedance.sdk.openadsdk.component.qr;

import android.content.Context;
import com.bytedance.sdk.component.utils.Tf;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.component.TRI;
import com.bytedance.sdk.openadsdk.core.Ol;
import com.bytedance.sdk.openadsdk.core.Xc;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import com.bytedance.sdk.openadsdk.multipro.pFF;
import com.bytedance.sdk.openadsdk.utils.UFX;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class sc {
    public static File pFF(String str) {
        return sc(Xc.sc(), TRI.sc(Xc.sc()).pFF(), str);
    }

    public static String pFF() {
        return com.bytedance.sdk.component.utils.TRI.sc(Xc.sc(), pFF.zY(), TRI.sc(Xc.sc()).pFF()).getAbsolutePath();
    }

    public static int sc(Sfl sfl, int i11) {
        return i11 - sfl.WgX();
    }

    public static File sc(Context context, String str, String str2) {
        return com.bytedance.sdk.component.utils.TRI.sc(context, pFF.zY(), str, str2);
    }

    public static File sc(String str) {
        return new File(CacheDirFactory.getICacheDir(0).pFF() + File.separator + str);
    }

    public static String sc() {
        return UFX.sc();
    }

    public static void sc(Context context) {
        try {
            TRI.sc(context).sc();
        } catch (Throwable unused) {
        }
    }

    public static void sc(File file) {
        if (file == null) {
            return;
        }
        try {
            com.bytedance.sdk.component.utils.TRI.pFF(file);
        } catch (Throwable unused) {
        }
    }

    public static void sc(JSONObject jSONObject, int i11, boolean z11) {
        try {
            String strTRI = Ol.pFF().TRI();
            int iQr = Ol.pFF().qr();
            JSONObject jSONObject2 = jSONObject.getJSONObject("creative");
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("app_name", strTRI);
            if (!z11) {
                jSONObject3.put("app_icon_id", "@".concat(String.valueOf(iQr)));
            } else if (Ol.pFF().qr() != 0) {
                jSONObject3.put("app_icon_id", "local://pag_open_icon_id");
            }
            jSONObject2.put("open_app_info", jSONObject3);
            if (jSONObject2.optJSONObject("video") == null) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("video_duration", Xc.We().JPJ(String.valueOf(i11)));
                jSONObject2.put("video", jSONObject4);
            }
        } catch (Exception e11) {
            Tf.sc("TTAppOpenUtils", e11.getMessage());
        }
    }
}
