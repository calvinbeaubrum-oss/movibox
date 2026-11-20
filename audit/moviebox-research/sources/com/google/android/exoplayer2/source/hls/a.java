package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.upstream.k0;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class a implements com.google.android.exoplayer2.upstream.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.google.android.exoplayer2.upstream.k f33976a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f33977b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f33978c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public CipherInputStream f33979d;

    public a(com.google.android.exoplayer2.upstream.k kVar, byte[] bArr, byte[] bArr2) {
        this.f33976a = kVar;
        this.f33977b = bArr;
        this.f33978c = bArr2;
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public final long a(com.google.android.exoplayer2.upstream.n nVar) throws IOException {
        try {
            Cipher cipherF = f();
            try {
                cipherF.init(2, new SecretKeySpec(this.f33977b, "AES"), new IvParameterSpec(this.f33978c));
                com.google.android.exoplayer2.upstream.l lVar = new com.google.android.exoplayer2.upstream.l(this.f33976a, nVar);
                this.f33979d = new CipherInputStream(lVar, cipherF);
                lVar.b();
                return -1L;
            } catch (InvalidAlgorithmParameterException | InvalidKeyException e11) {
                throw new RuntimeException(e11);
            }
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e12) {
            throw new RuntimeException(e12);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public void close() throws IOException {
        if (this.f33979d != null) {
            this.f33979d = null;
            this.f33976a.close();
        }
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public final void e(k0 k0Var) {
        com.google.android.exoplayer2.util.a.e(k0Var);
        this.f33976a.e(k0Var);
    }

    public Cipher f() throws NoSuchPaddingException, NoSuchAlgorithmException {
        return Cipher.getInstance("AES/CBC/PKCS7Padding");
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public final Map<String, List<String>> getResponseHeaders() {
        return this.f33976a.getResponseHeaders();
    }

    @Override // com.google.android.exoplayer2.upstream.k
    @Nullable
    public final Uri getUri() {
        return this.f33976a.getUri();
    }

    @Override // com.google.android.exoplayer2.upstream.g
    public final int read(byte[] bArr, int i11, int i12) throws IOException {
        com.google.android.exoplayer2.util.a.e(this.f33979d);
        int i13 = this.f33979d.read(bArr, i11, i12);
        if (i13 < 0) {
            return -1;
        }
        return i13;
    }
}
