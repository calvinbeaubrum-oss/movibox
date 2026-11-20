package com.bytedance.sdk.openadsdk.Qj;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.utils.cD;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class We extends sc {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public static zY f27110sc;

    public static String sc(com.bytedance.sdk.component.qr.pFF.zY zYVar, String str) {
        zY zYVarSc;
        Map map;
        if (!cD.zY() || (zYVarSc = pFF.sc("net")) == null || (map = (Map) zYVarSc.sc(1, str)) == null) {
            return str;
        }
        String str2 = (String) map.get("url");
        if (!TextUtils.isEmpty(str2)) {
            str = str2;
        }
        Map map2 = (Map) map.get("header");
        if (map2 != null) {
            for (String str3 : map2.keySet()) {
                zYVar.pFF(str3, (String) map2.get(str3));
            }
        }
        return str;
    }
}
