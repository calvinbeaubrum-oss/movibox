package au;

import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.transsion.http.request.HttpMethod;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class g implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f13830a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public HttpURLConnection f13831b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public InputStream f13832c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f13833d = 480;

    public g(f fVar) {
        this.f13830a = fVar;
    }

    public void a() {
        try {
            InputStream inputStream = this.f13832c;
            if (inputStream != null) {
                bu.d.a(inputStream);
                this.f13832c = null;
            }
            HttpURLConnection httpURLConnection = this.f13831b;
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public long b() {
        int iAvailable;
        HttpURLConnection httpURLConnection = this.f13831b;
        long contentLength = 0;
        try {
            if (httpURLConnection != null) {
                try {
                    contentLength = httpURLConnection.getContentLength();
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
                if (contentLength >= 1) {
                    return contentLength;
                }
                iAvailable = c().available();
            } else {
                iAvailable = c().available();
            }
            contentLength = iAvailable;
            return contentLength;
        } catch (Throwable unused) {
            return contentLength;
        }
    }

    public InputStream c() throws IOException {
        HttpURLConnection httpURLConnection = this.f13831b;
        if (httpURLConnection != null && this.f13832c == null) {
            this.f13832c = httpURLConnection.getResponseCode() >= 400 ? this.f13831b.getErrorStream() : this.f13831b.getInputStream();
        }
        return this.f13832c;
    }

    public f d() {
        return this.f13830a;
    }

    public int f() {
        if (this.f13831b != null) {
            return this.f13833d;
        }
        return 404;
    }

    public Map<String, List<String>> g() {
        HttpURLConnection httpURLConnection = this.f13831b;
        if (httpURLConnection == null) {
            return null;
        }
        return httpURLConnection.getHeaderFields();
    }

    public void h() throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new vt.c(this.f13830a.n()).b().openConnection()));
        this.f13831b = httpURLConnection;
        httpURLConnection.setReadTimeout(this.f13830a.j());
        this.f13831b.setConnectTimeout(this.f13830a.a());
        if ((this.f13831b instanceof HttpsURLConnection) && this.f13830a.q()) {
            ((HttpsURLConnection) this.f13831b).setSSLSocketFactory(this.f13830a.l());
            ((HttpsURLConnection) this.f13831b).setHostnameVerifier(this.f13830a.g());
        }
        HttpMethod httpMethodH = this.f13830a.h();
        this.f13831b.setRequestMethod(httpMethodH.toString());
        if (this.f13830a.f() != null) {
            for (String str : this.f13830a.f().keySet()) {
                this.f13831b.setRequestProperty(str, this.f13830a.f().get(str));
            }
        }
        if (HttpMethod.permitsRequestBody(httpMethodH)) {
            this.f13831b.setRequestProperty("connection", "Keep-Alive");
            this.f13831b.setRequestProperty("charset", "utf-8");
            this.f13831b.setRequestProperty(HttpHeaders.CONTENT_TYPE, this.f13830a.d().toString());
            long length = this.f13830a.c().getBytes().length;
            if (length < 0) {
                this.f13831b.setChunkedStreamingMode(262144);
            } else if (length < 2147483647L) {
                this.f13831b.setFixedLengthStreamingMode((int) length);
            } else {
                this.f13831b.setFixedLengthStreamingMode(length);
            }
            this.f13831b.setRequestProperty(HttpHeaders.CONTENT_LENGTH, String.valueOf(length));
            this.f13831b.setDoOutput(true);
            OutputStream outputStream = this.f13831b.getOutputStream();
            this.f13833d = 481;
            outputStream.write(this.f13830a.c().getBytes());
            outputStream.flush();
            outputStream.close();
        }
        int responseCode = this.f13831b.getResponseCode();
        this.f13833d = responseCode;
        if (302 == responseCode || 301 == responseCode) {
            String headerField = this.f13831b.getHeaderField(HttpHeaders.LOCATION);
            if (TextUtils.isEmpty(headerField)) {
                return;
            }
            a();
            this.f13830a.b(headerField);
            h();
        }
    }
}
