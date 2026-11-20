package athena;

import android.util.Log;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Cipher f13729a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Cipher f13730b;

    public n0(byte[] bArr) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            this.f13729a = cipher;
            cipher.init(1, secretKeySpec, new IvParameterSpec(br.g.f14362o));
            SecretKeySpec secretKeySpec2 = new SecretKeySpec(bArr, "AES");
            Cipher cipher2 = Cipher.getInstance("AES/CBC/PKCS5Padding");
            this.f13730b = cipher2;
            cipher2.init(2, secretKeySpec2, new IvParameterSpec(br.g.f14362o));
        } catch (Exception e11) {
            a0.c(Log.getStackTraceString(e11));
        }
    }

    public byte[] a(String str) {
        Cipher cipher = this.f13729a;
        if (cipher != null) {
            try {
                return cipher.doFinal(str.getBytes("UTF-8"));
            } catch (Exception e11) {
                a0.c(Log.getStackTraceString(e11));
            }
        }
        return null;
    }

    public byte[] b(byte[] bArr) {
        Cipher cipher = this.f13730b;
        if (cipher != null) {
            try {
                return cipher.doFinal(bArr);
            } catch (Exception e11) {
                a0.c(Log.getStackTraceString(e11));
            }
        }
        return null;
    }

    public byte[] c(byte[] bArr) {
        Cipher cipher = this.f13729a;
        if (cipher != null) {
            try {
                return cipher.doFinal(bArr);
            } catch (Exception e11) {
                a0.c(Log.getStackTraceString(e11));
            }
        }
        return null;
    }
}
