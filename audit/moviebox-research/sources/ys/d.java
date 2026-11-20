package ys;

import android.annotation.SuppressLint;
import android.content.Context;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import javax.crypto.Cipher;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class d extends xs.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Cipher f81629a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Cipher f81630b;

    public d(Context context) {
        m.b().a(context);
    }

    private void f() throws Exception {
        if (h() == null) {
            throw new Exception("key not created, please try later");
        }
        if (this.f81629a == null) {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(2, h());
            this.f81629a = cipher;
        }
    }

    @SuppressLint({"TrulyRandom"})
    private void g() throws Exception {
        if (i() == null) {
            throw new Exception("key not created, please try later");
        }
        if (this.f81630b == null) {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(1, i());
            this.f81630b = cipher;
        }
    }

    public static PrivateKey h() {
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
            return (PrivateKey) keyStore.getKey("crypto", null);
        } catch (Exception unused) {
            return null;
        }
    }

    public static PublicKey i() {
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
            return keyStore.getCertificate("crypto").getPublicKey();
        } catch (Exception unused) {
            return null;
        }
    }

    public byte[] d(byte[] bArr) throws Exception {
        f();
        return this.f81629a.doFinal(bArr);
    }

    public byte[] e(byte[] bArr) throws Exception {
        g();
        return this.f81630b.doFinal(bArr);
    }
}
