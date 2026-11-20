package uf;

import android.util.Base64;
import com.transsion.api.gateway.utils.EncoderUtil;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Set;
import javax.net.ssl.HttpsURLConnection;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class f {
    public static String a(byte[] bArr, String str) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        messageDigest.reset();
        return Base64.encodeToString(messageDigest.digest(bArr), 0);
    }

    public static void b(HttpsURLConnection httpsURLConnection, Set<String> set, Set<String> set2) throws Exception {
        for (Certificate certificate : httpsURLConnection.getServerCertificates()) {
            X509Certificate x509Certificate = (X509Certificate) certificate;
            String strA = a(x509Certificate.getEncoded(), EncoderUtil.ALGORITHM_SHA_1);
            if (set != null && set.contains(strA)) {
                return;
            }
            String strA2 = a(x509Certificate.getPublicKey().getEncoded(), EncoderUtil.ALGORITHM_SHA_1);
            if (set2 != null && set2.contains(strA2)) {
                return;
            }
        }
        throw new CertificateException("Unable to find valid certificate or public key.");
    }
}
