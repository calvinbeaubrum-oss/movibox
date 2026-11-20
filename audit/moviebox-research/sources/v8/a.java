package v8;

import android.text.TextUtils;
import com.applovin.exoplayer2.common.base.Ascii;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MessageDigest f78759a = c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final char[] f78760b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String a(String str) {
        byte[] bArrDigest;
        MessageDigest messageDigest = f78759a;
        if (messageDigest == null || TextUtils.isEmpty(str)) {
            return "";
        }
        byte[] bytes = str.getBytes(Charset.forName("UTF-8"));
        synchronized (a.class) {
            bArrDigest = messageDigest.digest(bytes);
        }
        return b(bArrDigest);
    }

    public static String b(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        char[] cArr = new char[bArr.length << 1];
        int i11 = 0;
        for (byte b11 : bArr) {
            int i12 = i11 + 1;
            char[] cArr2 = f78760b;
            cArr[i11] = cArr2[(b11 & 240) >> 4];
            i11 += 2;
            cArr[i12] = cArr2[b11 & Ascii.SI];
        }
        return new String(cArr);
    }

    public static MessageDigest c() {
        try {
            return MessageDigest.getInstance("md5");
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }
}
