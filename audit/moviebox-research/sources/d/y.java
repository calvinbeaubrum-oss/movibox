package d;

import android.text.TextUtils;
import android.util.Base64;
import com.transsion.api.gateway.utils.EncoderUtil;
import java.security.MessageDigest;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class y {
    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new String(Base64.decode(str, 0));
    }

    public static byte[] b(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(EncoderUtil.ALGORITHM_SHA_256);
            messageDigest.reset();
            messageDigest.update(bArr);
            return messageDigest.digest();
        } catch (Exception e11) {
            e11.printStackTrace();
            return null;
        }
    }

    public static int c(String str) {
        int iD = d(str);
        if (iD <= 0) {
            return 1;
        }
        return iD;
    }

    public static int d(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return Integer.valueOf(str).intValue();
        } catch (Exception e11) {
            e11.printStackTrace();
            return -1;
        }
    }

    public static long e(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            return Long.valueOf(str).longValue();
        } catch (Exception e11) {
            e11.printStackTrace();
            return -1L;
        }
    }
}
