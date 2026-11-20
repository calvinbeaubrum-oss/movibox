package com.bytedance.adsdk.sc;

import android.text.TextUtils;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class qr {
    public static ExN sc(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        str.hashCode();
        switch (str) {
            case "find":
                return new zY();
            case "exist":
                return new pFF();
            case "translate":
                return new TRI();
            case "isDigit":
                return new We();
            default:
                return null;
        }
    }

    public static Object sc(com.bytedance.adsdk.sc.pFF.sc.sc scVar) {
        ExN exNSc;
        if (scVar == null || (exNSc = sc(scVar.sc())) == null) {
            return null;
        }
        return exNSc.sc(null, scVar.pFF());
    }
}
