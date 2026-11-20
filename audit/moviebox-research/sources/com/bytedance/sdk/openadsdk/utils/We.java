package com.bytedance.sdk.openadsdk.utils;

import android.text.TextUtils;
import java.util.Iterator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class We {
    public static String sc(String str) {
        if (!com.bytedance.sdk.component.utils.Tf.We() || TextUtils.isEmpty(str)) {
            return str;
        }
        com.bytedance.sdk.openadsdk.core.model.qr qrVar = new com.bytedance.sdk.openadsdk.core.model.qr(com.bytedance.sdk.openadsdk.core.Ol.pFF().Ql());
        StringBuilder sb2 = new StringBuilder(str);
        Iterator<String> it = qrVar.pFF().iterator();
        while (it.hasNext()) {
            if (sb2.toString().contains(it.next())) {
                if (sb2.toString().contains("?")) {
                    sb2.append("&");
                    sb2.append(qrVar.sc());
                } else {
                    sb2.append("?");
                    sb2.append(qrVar.sc());
                }
            }
        }
        return sb2.toString();
    }
}
