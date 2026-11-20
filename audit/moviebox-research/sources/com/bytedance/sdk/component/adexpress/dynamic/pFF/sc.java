package com.bytedance.sdk.component.adexpress.dynamic.pFF;

import android.text.TextUtils;
import com.bytedance.sdk.component.adexpress.dynamic.We.qr;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class sc {
    public static int sc(qr qrVar) {
        if (qrVar == null) {
            return 0;
        }
        String strBR = qrVar.BR();
        String strFI = qrVar.FI();
        if (TextUtils.isEmpty(strFI) || TextUtils.isEmpty(strBR) || !strFI.equals("creative")) {
            return 0;
        }
        if (strBR.equals("shake")) {
            return 2;
        }
        if (strBR.equals("twist")) {
            return 3;
        }
        return strBR.equals("slide") ? 1 : 0;
    }
}
