package ww;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import java.nio.charset.Charset;
import java.security.Key;
import java.security.KeyStore;
import javax.crypto.Cipher;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class b extends k20.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Cipher f79654a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Cipher f79655b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Key f79656c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Key f79657d;

    public b(Context context) {
    }

    @SuppressLint({"TrulyRandom"})
    private void h() throws Exception {
        i();
        if (this.f79655b == null) {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(1, this.f79657d);
            this.f79655b = cipher;
        }
    }

    public byte[] d(byte[] bArr) throws Exception {
        g();
        return this.f79654a.doFinal(bArr);
    }

    public byte[] e(String str) throws Exception {
        return f(str.getBytes(Charset.forName("UTF-8")));
    }

    public byte[] f(byte[] bArr) throws Exception {
        h();
        return this.f79655b.doFinal(bArr);
    }

    public final void g() throws Exception {
        i();
        if (this.f79654a == null) {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(2, this.f79656c);
            this.f79654a = cipher;
        }
    }

    public final void i() throws Exception {
        if (this.f79656c == null || this.f79657d == null) {
            try {
                KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
                keyStore.load(null);
                if (Build.VERSION.SDK_INT >= 28) {
                    this.f79656c = keyStore.getKey("crypto", null);
                    this.f79657d = keyStore.getCertificate("crypto").getPublicKey();
                } else {
                    KeyStore.PrivateKeyEntry privateKeyEntry = (KeyStore.PrivateKeyEntry) keyStore.getEntry("crypto", null);
                    this.f79656c = privateKeyEntry.getPrivateKey();
                    this.f79657d = privateKeyEntry.getCertificate().getPublicKey();
                }
            } catch (Exception e11) {
                e11.printStackTrace();
                throw e11;
            }
        }
    }
}
