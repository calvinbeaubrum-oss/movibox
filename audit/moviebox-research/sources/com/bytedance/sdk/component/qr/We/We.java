package com.bytedance.sdk.component.qr.We;

import android.content.Context;
import com.bytedance.sdk.component.qr.zY.Qj;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class We {
    private static String sc(int i11) {
        return "tnc_config".concat(String.valueOf(i11));
    }

    /* JADX WARN: Code duplicated, block: B:10:0x002a  */
    public static String sc(Context context, int i11, int i12) {
        String strSc;
        if (i11 != 1) {
            strSc = "";
        } else {
            try {
                if (Qj.sc().sc(i12).We() != null) {
                    strSc = Qj.sc().sc(i12).We().sc(context, sc(i12), "");
                } else {
                    strSc = "";
                }
            } catch (Exception unused) {
            }
        }
        return strSc instanceof String ? String.valueOf(strSc) : "";
    }

    public static void sc(Context context, int i11, String str, int i12) {
        try {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (i11 == 1) {
                linkedHashMap.put(sc(i12), str);
            }
            if (Qj.sc().sc(i12).We() != null) {
                Qj.sc().sc(i12).We().sc(context, linkedHashMap);
            }
        } catch (Exception unused) {
        }
    }
}
