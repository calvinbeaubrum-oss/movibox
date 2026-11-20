package com.facebook.ads.redexgen.uinode;

import android.os.Build;
import android.util.Base64;
import com.applovin.exoplayer2.common.base.Ascii;
import com.transsion.gslb.Worker;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Set;
import javax.net.ssl.HttpsURLConnection;
import okio.Utf8;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Rb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC1605Rb {
    public static byte[] A00;

    static {
        A02();
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 1);
        }
        return new String(bArrCopyOfRange);
    }

    public static String A01(byte[] bArr, String str) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        messageDigest.reset();
        return Base64.encodeToString(messageDigest.digest(bArr), 0);
    }

    public static void A02() {
        A00 = new byte[]{4, Ascii.RS, 0, Ascii.RS, 3, 60, 39, 46, 66, 94, Ascii.VT, 48, Utf8.REPLACEMENT_BYTE, 60, 50, 59, 126, 42, 49, 126, 56, 55, 48, 58, 126, 40, Utf8.REPLACEMENT_BYTE, 50, 55, 58, 126, 61, 59, 44, 42, 55, 56, 55, 61, Utf8.REPLACEMENT_BYTE, 42, 59, 126, 49, 44, 126, 46, 43, 60, 50, 55, 61, 126, 53, 59, 39, 112};
    }

    public static void A03(HttpsURLConnection httpsURLConnection, Set<String> set, Set<String> set2) throws Exception {
        String strA00 = A00(5, 5, Worker.WHAT_QUIT);
        if (Build.VERSION.SDK_INT == 15) {
            if (A00(0, 5, 49).equals(Build.VERSION.RELEASE)) {
                return;
            }
        }
        try {
            for (Certificate certificate : httpsURLConnection.getServerCertificates()) {
                X509Certificate x509Certificate = (X509Certificate) certificate;
                String strA01 = A01(x509Certificate.getEncoded(), strA00);
                if (set != null && set.contains(strA01)) {
                    return;
                }
                String strA02 = A01(x509Certificate.getPublicKey().getEncoded(), strA00);
                if (set2 != null && set2.contains(strA02)) {
                    return;
                }
            }
            throw new CertificateException(A00(10, 47, 95));
        } catch (Exception e11) {
            throw e11;
        }
    }
}
