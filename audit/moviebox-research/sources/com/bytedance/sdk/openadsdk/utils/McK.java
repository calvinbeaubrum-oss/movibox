package com.bytedance.sdk.openadsdk.utils;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class McK {
    public static void sc(com.bytedance.sdk.openadsdk.core.model.Sfl sfl, Double d11) {
        if (sfl == null || sfl.eoh() == null) {
            return;
        }
        Map<String, Object> mapEoh = sfl.eoh();
        try {
            Object obj = sfl.eoh().get(TTAdConstant.SDK_BIDDING_TYPE);
            if (obj != null && Integer.parseInt(obj.toString()) == 2) {
                String strReplace = (String) mapEoh.get("nurl");
                if (TextUtils.isEmpty(strReplace)) {
                    return;
                }
                if (d11 != null) {
                    strReplace = strReplace.replace("${AUCTION_BID_TO_WIN}", String.valueOf(d11));
                }
                com.bytedance.sdk.openadsdk.core.Xc.zY().sc(strReplace);
            }
        } catch (Throwable unused) {
            com.bytedance.sdk.component.utils.Tf.pFF("report Win error");
        }
    }

    public static void sc(com.bytedance.sdk.openadsdk.core.model.Sfl sfl, Double d11, String str, String str2) {
        if (sfl == null || sfl.eoh() == null) {
            return;
        }
        Map<String, Object> mapEoh = sfl.eoh();
        try {
            Object obj = sfl.eoh().get(TTAdConstant.SDK_BIDDING_TYPE);
            if (obj != null && Integer.parseInt(obj.toString()) == 2) {
                String strReplace = (String) mapEoh.get("lurl");
                if (TextUtils.isEmpty(strReplace)) {
                    return;
                }
                if (d11 != null) {
                    strReplace = strReplace.replace("${AUCTION_PRICE}", String.valueOf(d11));
                }
                if (str != null) {
                    strReplace = strReplace.replace("${AUCTION_LOSS}", str);
                }
                if (str2 != null) {
                    strReplace = strReplace.replace("${AUCTION_WINNER}", str2);
                }
                com.bytedance.sdk.openadsdk.core.Xc.zY().sc(strReplace);
            }
        } catch (Throwable unused) {
            com.bytedance.sdk.component.utils.Tf.pFF("report Loss error");
        }
    }
}
