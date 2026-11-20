package androidx.media3.exoplayer.hls;

import android.net.Uri;
import androidx.annotation.Nullable;
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
/* JADX INFO: loaded from: classes2.dex */
public class a implements androidx.media3.datasource.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final androidx.media3.datasource.a f10365a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f10366b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f10367c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public CipherInputStream f10368d;

    public a(androidx.media3.datasource.a aVar, byte[] bArr, byte[] bArr2) {
        this.f10365a = aVar;
        this.f10366b = bArr;
        this.f10367c = bArr2;
    }

    @Override // androidx.media3.datasource.a
    public final long a(c4.g gVar) throws IOException {
        try {
            Cipher cipherD = d();
            try {
                cipherD.init(2, new SecretKeySpec(this.f10366b, "AES"), new IvParameterSpec(this.f10367c));
                c4.e eVar = new c4.e(this.f10365a, gVar);
                this.f10368d = new CipherInputStream(eVar, cipherD);
                eVar.b();
                return -1L;
            } catch (InvalidAlgorithmParameterException | InvalidKeyException e11) {
                throw new RuntimeException(e11);
            }
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e12) {
            throw new RuntimeException(e12);
        }
    }

    @Override // androidx.media3.datasource.a
    public final void c(c4.o oVar) {
        z3.a.e(oVar);
        this.f10365a.c(oVar);
    }

    @Override // androidx.media3.datasource.a
    public void close() throws IOException {
        if (this.f10368d != null) {
            this.f10368d = null;
            this.f10365a.close();
        }
    }

    public Cipher d() throws NoSuchPaddingException, NoSuchAlgorithmException {
        return Cipher.getInstance("AES/CBC/PKCS7Padding");
    }

    @Override // androidx.media3.datasource.a
    public final Map<String, List<String>> getResponseHeaders() {
        return this.f10365a.getResponseHeaders();
    }

    @Override // androidx.media3.datasource.a
    @Nullable
    public final Uri getUri() {
        return this.f10365a.getUri();
    }

    @Override // androidx.media3.common.l
    public final int read(byte[] bArr, int i11, int i12) throws IOException {
        z3.a.e(this.f10368d);
        int i13 = this.f10368d.read(bArr, i11, i12);
        if (i13 < 0) {
            return -1;
        }
        return i13;
    }
}
