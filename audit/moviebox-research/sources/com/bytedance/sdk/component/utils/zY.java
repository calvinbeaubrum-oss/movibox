package com.bytedance.sdk.component.utils;

import android.content.Context;
import android.content.pm.Signature;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class zY {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private static HashMap<String, ArrayList<String>> f27042sc = new HashMap<>();

    private static Signature[] pFF(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 64).signatures;
        } catch (Exception e11) {
            Tf.pFF(e11.toString());
            return null;
        }
    }

    public static String sc(Context context) {
        StringBuilder sb2 = new StringBuilder();
        ArrayList<String> arrayListSc = sc(context, "SHA1");
        if (arrayListSc != null && arrayListSc.size() != 0) {
            for (int i11 = 0; i11 < arrayListSc.size(); i11++) {
                sb2.append(arrayListSc.get(i11));
                if (i11 < arrayListSc.size() - 1) {
                    sb2.append(",");
                }
            }
        }
        return sb2.toString();
    }

    private static String sc(Signature signature, String str) {
        byte[] byteArray = signature.toByteArray();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            if (messageDigest == null) {
                return "error!";
            }
            byte[] bArrDigest = messageDigest.digest(byteArray);
            StringBuilder sb2 = new StringBuilder();
            for (byte b11 : bArrDigest) {
                sb2.append(Integer.toHexString((b11 & 255) | 256).substring(1, 3).toUpperCase());
                sb2.append(":");
            }
            return sb2.substring(0, sb2.length() - 1).toString();
        } catch (Exception e11) {
            Tf.pFF(e11.toString());
            return "error!";
        }
    }

    public static ArrayList<String> sc(Context context, String str) {
        ArrayList<String> arrayList = null;
        if (context != null && str != null) {
            String packageName = context.getPackageName();
            if (packageName == null) {
                return null;
            }
            if (f27042sc.get(str) != null) {
                return f27042sc.get(str);
            }
            arrayList = new ArrayList<>();
            try {
                for (Signature signature : pFF(context, packageName)) {
                    String strSc = "error!";
                    if ("MD5".equals(str)) {
                        strSc = sc(signature, "MD5");
                    } else if ("SHA1".equals(str)) {
                        strSc = sc(signature, "SHA1");
                    } else if ("SHA256".equals(str)) {
                        strSc = sc(signature, "SHA256");
                    }
                    arrayList.add(strSc);
                }
            } catch (Exception e11) {
                Tf.pFF(e11.toString());
            }
            f27042sc.put(str, arrayList);
        }
        return arrayList;
    }
}
