package ys;

import java.io.IOException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class a extends xs.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Cipher f81620a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f81621b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f81622c;

    public a(byte[] bArr, byte[] bArr2) throws IOException {
        this.f81622c = bArr;
        this.f81621b = bArr2;
        if (bArr.length != 16 && bArr.length != 24 && bArr.length != 32) {
            throw new IOException();
        }
        if (bArr2.length != 16) {
            throw new IOException();
        }
    }

    public byte[] d(byte[] bArr) throws Exception {
        e();
        return this.f81620a.doFinal(bArr);
    }

    public final void e() throws Exception {
        if (this.f81620a == null) {
            SecretKeySpec secretKeySpec = new SecretKeySpec(this.f81622c, "AES");
            IvParameterSpec ivParameterSpec = new IvParameterSpec(this.f81621b);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, secretKeySpec, ivParameterSpec);
            this.f81620a = cipher;
        }
    }
}
