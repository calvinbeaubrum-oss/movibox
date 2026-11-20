package ww;

import android.annotation.SuppressLint;
import java.nio.charset.Charset;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class a extends k20.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Cipher f79652a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f79653b;

    public a(String str) {
        this.f79653b = b(str);
    }

    public byte[] d(String str) throws Exception {
        return e(str.getBytes(Charset.forName("UTF-8")));
    }

    public byte[] e(byte[] bArr) throws Exception {
        f();
        return this.f79652a.doFinal(bArr);
    }

    @SuppressLint({"TrulyRandom"})
    public final void f() throws Exception {
        if (this.f79652a == null) {
            PublicKey publicKeyGeneratePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(this.f79653b));
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(1, publicKeyGeneratePublic);
            this.f79652a = cipher;
        }
    }
}
