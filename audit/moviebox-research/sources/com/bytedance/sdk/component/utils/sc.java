package com.bytedance.sdk.component.utils;

import android.os.Build;
import android.text.TextUtils;
import java.security.SecureRandom;
import java.util.Random;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class sc {

    /* JADX INFO: renamed from: com.bytedance.sdk.component.utils.sc$sc, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class C0266sc {

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        static final Random f27038sc = sc.zY();
    }

    public static String pFF() {
        String strSc = sc(8);
        if (strSc == null || strSc.length() != 16) {
            return null;
        }
        return strSc;
    }

    public static String pFF(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String strSc = sc();
        String strSc2 = sc(strSc, 32);
        String strPFF = pFF();
        return 3 + strSc + strPFF + ((strSc2 == null || strPFF == null) ? null : com.bytedance.sdk.component.We.sc.sc(str, strPFF, strSc2));
    }

    public static String sc() {
        String strSc = sc(16);
        if (strSc == null || strSc.length() != 32) {
            return null;
        }
        return strSc;
    }

    public static String sc(int i11) {
        try {
            byte[] bArr = new byte[i11];
            C0266sc.f27038sc.nextBytes(bArr);
            return ExN.sc(bArr);
        } catch (Exception unused) {
            return null;
        }
    }

    public static String sc(String str, int i11) {
        if (str == null || str.length() != i11) {
            return null;
        }
        int i12 = i11 / 2;
        return str.substring(i12, i11) + str.substring(0, i12);
    }

    public static JSONObject sc(String str) {
        JSONObject jSONObject = new JSONObject();
        if (TextUtils.isEmpty(str)) {
            return jSONObject;
        }
        try {
            try {
                String strPFF = pFF(str);
                if (TextUtils.isEmpty(strPFF)) {
                    jSONObject.put("message", str);
                    jSONObject.put("cypher", 0);
                } else {
                    jSONObject.put("message", strPFF);
                    jSONObject.put("cypher", 3);
                }
            } catch (Throwable th2) {
                th2.getMessage();
            }
        } catch (Throwable unused) {
            jSONObject.put("message", str);
            jSONObject.put("cypher", 0);
        }
        return jSONObject;
    }

    public static JSONObject sc(JSONObject jSONObject) {
        return jSONObject == null ? new JSONObject() : sc(jSONObject.toString());
    }

    public static String zY(String str) {
        if (TextUtils.isEmpty(str) || str.length() < 49) {
            return str;
        }
        String strSc = sc(str.substring(1, 33), 32);
        String strSubstring = str.substring(33, 49);
        return (strSubstring == null || strSc == null) ? str : com.bytedance.sdk.component.We.sc.pFF(str.substring(49), strSubstring, strSc);
    }

    public static Random zY() {
        if (Build.VERSION.SDK_INT < 26) {
            return new SecureRandom();
        }
        try {
            return SecureRandom.getInstanceStrong();
        } catch (Throwable unused) {
            return new SecureRandom();
        }
    }
}
