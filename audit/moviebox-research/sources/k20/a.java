package k20;

import android.util.Base64;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class a {
    public byte[] a(String str) {
        return Base64.decode(str, 2);
    }

    public byte[] b(String str) {
        return Base64.decode(str, 2);
    }

    public String c(byte[] bArr) {
        return new String(Base64.encode(bArr, 2));
    }
}
