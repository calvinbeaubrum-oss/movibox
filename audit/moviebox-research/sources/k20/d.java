package k20;

import android.util.Log;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Cipher f68213a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Cipher f68214b;

    public d(byte[] bArr) {
        byte[] bytes = "abcdefghijk1mnop".getBytes();
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            this.f68213a = cipher;
            cipher.init(1, secretKeySpec, new IvParameterSpec(bytes));
            SecretKeySpec secretKeySpec2 = new SecretKeySpec(bArr, "AES");
            Cipher cipher2 = Cipher.getInstance("AES/CBC/PKCS5Padding");
            this.f68214b = cipher2;
            cipher2.init(2, secretKeySpec2, new IvParameterSpec(bytes));
        } catch (Exception e11) {
            com.transsion.sdk.oneid.f.f57417a.i(Log.getStackTraceString(e11));
        }
    }

    public byte[] a(String str) {
        Cipher cipher = this.f68213a;
        if (cipher != null) {
            try {
                return cipher.doFinal(str.getBytes("UTF-8"));
            } catch (Exception e11) {
                com.transsion.sdk.oneid.f.f57417a.i(Log.getStackTraceString(e11));
            }
        }
        return null;
    }
}
