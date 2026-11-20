package com.bytedance.sdk.openadsdk.Xc;

import android.content.Context;
import android.location.Address;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.core.Tf;
import com.bytedance.sdk.openadsdk.core.Xc;
import com.bytedance.sdk.openadsdk.utils.cJ;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class pFF implements com.bytedance.sdk.component.qr.zY.pFF {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public static String f27476sc = "sp_multi_ttadnet_config";
    private final Context pFF;

    public pFF(Context context) {
        this.pFF = context;
    }

    @Override // com.bytedance.sdk.component.qr.zY.pFF
    public String ExN() {
        return Tf.sc(this.pFF);
    }

    @Override // com.bytedance.sdk.component.qr.zY.pFF
    public String[] TRI() {
        String[] strArr = {"tnc16-useast1a.isnssdk.com", "tnc16-useast1a.byteoversea.com", "tnc16-alisg.isnssdk.com", "tnc16-alisg.byteoversea.com"};
        String strJoC = Xc.We().JoC();
        if (!TextUtils.isEmpty(strJoC)) {
            return ("SG".equals(strJoC) || "CN".equals(strJoC)) ? new String[]{"tnc16-alisg.isnssdk.com", "tnc16-alisg.byteoversea.com", "tnc16-useast1a.isnssdk.com", "tnc16-useast1a.byteoversea.com"} : strArr;
        }
        int iDE = cJ.dE();
        return (iDE == 2 || iDE == 1) ? new String[]{"tnc16-alisg.isnssdk.com", "tnc16-alisg.byteoversea.com", "tnc16-useast1a.isnssdk.com", "tnc16-useast1a.byteoversea.com"} : strArr;
    }

    @Override // com.bytedance.sdk.component.qr.zY.pFF
    public int We() {
        return BuildConfig.VERSION_CODE;
    }

    @Override // com.bytedance.sdk.component.qr.zY.pFF
    public String pFF() {
        return "pangle_sdk";
    }

    @Override // com.bytedance.sdk.component.qr.zY.pFF
    public int sc() {
        return Integer.parseInt("1371");
    }

    @Override // com.bytedance.sdk.component.qr.zY.pFF
    public Address sc(Context context) {
        return null;
    }

    @Override // com.bytedance.sdk.component.qr.zY.pFF
    public String sc(Context context, String str, String str2) {
        return com.bytedance.sdk.openadsdk.multipro.We.sc.pFF(f27476sc, str, str2);
    }

    @Override // com.bytedance.sdk.component.qr.zY.pFF
    public void sc(Context context, Map<String, ?> map) {
        if (map != null) {
            try {
                for (Map.Entry<String, ?> entry : map.entrySet()) {
                    Object value = entry.getValue();
                    if (value instanceof Integer) {
                        com.bytedance.sdk.openadsdk.multipro.We.sc.sc(f27476sc, entry.getKey(), (Integer) value);
                    } else if (value instanceof Long) {
                        com.bytedance.sdk.openadsdk.multipro.We.sc.sc(f27476sc, entry.getKey(), (Long) value);
                    } else if (value instanceof Float) {
                        com.bytedance.sdk.openadsdk.multipro.We.sc.sc(f27476sc, entry.getKey(), (Float) value);
                    } else if (value instanceof Boolean) {
                        com.bytedance.sdk.openadsdk.multipro.We.sc.sc(f27476sc, entry.getKey(), (Boolean) value);
                    } else if (value instanceof String) {
                        com.bytedance.sdk.openadsdk.multipro.We.sc.sc(f27476sc, entry.getKey(), (String) value);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.bytedance.sdk.component.qr.zY.pFF
    public String zY() {
        return "android";
    }
}
