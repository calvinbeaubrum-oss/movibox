package com.cloud.sdk.commonutil.util;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.RequiresApi;
import com.cloud.sdk.commonutil.R$string;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f30274a = "";

    @RequiresApi(api = 19)
    public static String a(String str) {
        try {
            byte[] bytes = b().getBytes();
            byte[] bArr = new byte[12];
            new SecureRandom().nextBytes(bArr);
            SecretKeySpec secretKeySpec = new SecretKeySpec(bytes, "AES");
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(1, secretKeySpec, new GCMParameterSpec(128, bArr));
            byte[] bArrDoFinal = cipher.doFinal(str.getBytes("UTF8"));
            byte[] bArr2 = new byte[bArrDoFinal.length + 12];
            System.arraycopy(bArr, 0, bArr2, 0, 12);
            System.arraycopy(bArrDoFinal, 0, bArr2, 12, bArrDoFinal.length);
            return f(bArr2);
        } catch (Exception e11) {
            Log.e("AESUtils", Log.getStackTraceString(e11));
            return "";
        }
    }

    public static String b() {
        if (TextUtils.isEmpty(f30274a)) {
            f30274a = "sOWGI8Lv" + c(1, 2) + e() + d();
        }
        return f30274a;
    }

    public static String c(int i11, int i12) {
        for (int i13 = 1; i13 <= i11 * i12; i13++) {
            if (i13 % i11 == 0 && i13 % i12 == 0) {
                return "FnvyH19r";
            }
        }
        return "FnvyH19r";
    }

    public static String d() {
        return f.a().getResources().getString(R$string.bk4);
    }

    public static String e() {
        return "s2DytdII";
    }

    public static String f(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b11 : bArr) {
            String hexString = Integer.toHexString(b11 & 255);
            if (hexString.length() == 1) {
                hexString = '0' + hexString;
            }
            stringBuffer.append(hexString.toUpperCase());
        }
        return stringBuffer.toString();
    }
}
