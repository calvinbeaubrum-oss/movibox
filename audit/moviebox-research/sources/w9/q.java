package w9;

import android.util.Log;
import com.applovin.exoplayer2.common.base.Ascii;
import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f79383a = {"0", "1", "2", "3", "4", "5", PrepareException.ERROR_NO_URL, "7", PrepareException.ERROR_MANIFEST_INFO, PrepareException.ERROR_MINI_APP_CLOSE, "a", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "c", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, "e", "f"};

    public static String a(byte b11) {
        int i11 = b11;
        if (b11 < 0) {
            i11 = b11 + Ascii.NUL;
        }
        StringBuilder sb2 = new StringBuilder();
        String[] strArr = f79383a;
        sb2.append(strArr[i11 / 16]);
        sb2.append(strArr[i11 % 16]);
        return sb2.toString();
    }

    public static String b(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b11 : bArr) {
            stringBuffer.append(a(b11));
        }
        return stringBuffer.toString();
    }

    public static String c(String str) {
        try {
            return b(MessageDigest.getInstance("MD5").digest(str.getBytes()));
        } catch (NoSuchAlgorithmException e11) {
            com.cloud.hisavana.sdk.z.a().e(Log.getStackTraceString(e11));
            return str;
        }
    }
}
