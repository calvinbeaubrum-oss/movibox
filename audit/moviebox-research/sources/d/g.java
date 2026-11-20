package d;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.hisavana.common.constant.ComConstants;
import com.transsion.push.bean.MsgStyle;
import com.transsion.push.utils.PushLogUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class g {
    public static long a(InputStream inputStream, OutputStream outputStream) throws IOException {
        return b(inputStream, outputStream, 8024);
    }

    public static long b(InputStream inputStream, OutputStream outputStream, int i11) throws IOException {
        byte[] bArr = new byte[i11];
        long j11 = 0;
        while (true) {
            int i12 = inputStream.read(bArr);
            if (i12 <= 0) {
                return j11;
            }
            outputStream.write(bArr, 0, i12);
            j11 += (long) i12;
        }
    }

    public static byte[] c(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        a(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] d(String str, byte[] bArr) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(str).openConnection()));
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setConnectTimeout(ComConstants.AD_TIMEOUT_MILLIS);
        httpURLConnection.setReadTimeout(ComConstants.AD_TIMEOUT_MILLIS);
        httpURLConnection.setRequestProperty(HttpHeaders.CONTENT_TYPE, "application/json");
        httpURLConnection.setRequestProperty("User-Agent", MsgStyle.SOURCE_PUSH);
        OutputStream outputStream = httpURLConnection.getOutputStream();
        outputStream.write(bArr);
        outputStream.flush();
        PushLogUtils.LOG.g("response code:" + httpURLConnection.getResponseCode());
        if (httpURLConnection.getResponseCode() >= 400) {
            return null;
        }
        return c(httpURLConnection.getInputStream());
    }
}
