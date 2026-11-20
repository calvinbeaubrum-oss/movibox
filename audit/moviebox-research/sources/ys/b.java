package ys;

import android.annotation.SuppressLint;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class b extends xs.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Cipher f81623a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Cipher f81624b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SecretKeySpec f81625c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f81626d;

    private void g() throws Exception {
        if (this.f81625c == null || this.f81626d == null) {
            throw new Exception("please call encrypt method first");
        }
        if (this.f81623a == null) {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(this.f81626d);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, this.f81625c, ivParameterSpec);
            this.f81623a = cipher;
        }
    }

    public byte[] d(byte[] bArr) throws Exception {
        g();
        return this.f81623a.doFinal(bArr);
    }

    public byte[] e(String str) throws Exception {
        return f(str.getBytes("UTF-8"));
    }

    public byte[] f(byte[] bArr) throws Exception {
        h();
        return this.f81624b.doFinal(bArr);
    }

    @SuppressLint({"TrulyRandom"})
    public final void h() throws Exception {
        if (this.f81624b == null) {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(256);
            SecretKey secretKeyGenerateKey = keyGenerator.generateKey();
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(1, secretKeyGenerateKey);
            this.f81625c = new SecretKeySpec(secretKeyGenerateKey.getEncoded(), "AES");
            this.f81626d = cipher.getIV();
            this.f81624b = cipher;
        }
    }

    public byte[] i() throws Exception {
        SecretKeySpec secretKeySpec;
        if (this.f81626d == null || (secretKeySpec = this.f81625c) == null || secretKeySpec.getEncoded() == null) {
            throw new Exception("no valid key info");
        }
        byte[] encoded = this.f81625c.getEncoded();
        byte[] bArr = this.f81626d;
        if (encoded.length != 32 || bArr.length != 16) {
            throw new Exception("key length is not valid");
        }
        byte[] bArr2 = new byte[48];
        System.arraycopy(encoded, 0, bArr2, 0, 32);
        System.arraycopy(bArr, 0, bArr2, 32, 16);
        return bArr2;
    }
}
