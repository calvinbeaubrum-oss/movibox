package ys;

import android.annotation.SuppressLint;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class c extends xs.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Cipher f81627a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f81628b;

    public c(String str) {
        this.f81628b = b(str);
    }

    @SuppressLint({"TrulyRandom"})
    private void e() throws Exception {
        if (this.f81627a == null) {
            PublicKey publicKeyGeneratePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(this.f81628b));
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(1, publicKeyGeneratePublic);
            this.f81627a = cipher;
        }
    }

    public byte[] d(byte[] bArr) throws Exception {
        e();
        return this.f81627a.doFinal(bArr);
    }

    public final boolean f(byte[] bArr, byte[] bArr2) throws Exception {
        PublicKey publicKeyGeneratePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(this.f81628b));
        Signature signature = Signature.getInstance("MD5withRSA");
        signature.initVerify(publicKeyGeneratePublic);
        signature.update(bArr);
        return signature.verify(bArr2);
    }

    public boolean g(byte[] bArr, byte[] bArr2) throws Exception {
        return f(bArr, bArr2);
    }
}
