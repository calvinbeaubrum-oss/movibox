package com.bytedance.sdk.openadsdk.core.Tf.sc;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.core.Tf.pFF.zY;
import com.bytedance.sdk.openadsdk.utils.kX;
import com.hisavana.common.tracking.TrackingKey;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class pFF {
    public int ExN;
    public sc TRI;
    protected double We;
    protected final Context pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public int f28233sc;
    protected int zY;

    /* JADX INFO: compiled from: source.java */
    public static class sc {
        public int pFF;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        public int f28234sc;
        public boolean zY;
    }

    public pFF(Context context, int i11, int i12) {
        this.zY = 0;
        this.We = 0.0d;
        if (i12 > 0 && i11 > 0) {
            this.We = ((double) i11) / ((double) i12);
        }
        float fExN = kX.ExN(context);
        if (fExN != 0.0f && i11 > 0) {
            this.zY = (int) (i11 / fExN);
        }
        this.pFF = context.getApplicationContext();
    }

    public String pFF(String str, List<zY> list) {
        String strWe;
        int i11 = this.f28233sc;
        if (i11 >= 5) {
            return null;
        }
        this.f28233sc = i11 + 1;
        if (str == null) {
            return null;
        }
        try {
            com.bytedance.sdk.component.qr.pFF.pFF pffZY = com.bytedance.sdk.openadsdk.Xc.zY.sc().pFF().zY();
            pffZY.pFF(str);
            com.bytedance.sdk.component.qr.pFF pffSc = pffZY.sc();
            strWe = pffSc.We();
            try {
                pffSc.sc();
            } catch (Exception e11) {
                e = e11;
                sc(e, 0);
                if (!list.isEmpty()) {
                    zY.pFF(list, com.bytedance.sdk.openadsdk.core.Tf.sc.sc.WRAPPER_TIMEOUT, -1L, null);
                }
            }
        } catch (Exception e12) {
            e = e12;
            strWe = null;
        }
        return strWe;
    }

    public abstract com.bytedance.sdk.openadsdk.core.Tf.sc sc(String str, List<zY> list);

    public void sc(Exception exc, int i11) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("exception", exc.getMessage());
            jSONObject.put(TrackingKey.ERROR_CODE, i11);
            com.bytedance.sdk.openadsdk.SR.zY.sc().sc("load_vast", jSONObject);
        } catch (Exception unused) {
        }
    }

    public boolean sc(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        try {
            return Integer.parseInt(str) < 2;
        } catch (NumberFormatException unused) {
            return true;
        }
    }
}
