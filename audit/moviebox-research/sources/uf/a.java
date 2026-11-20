package uf;

import android.util.Log;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.facebook.biddingkit.http.client.HttpMethod;
import com.facebook.biddingkit.http.client.HttpRequestException;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import javax.net.ssl.HttpsURLConnection;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Set<String> f78524d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Set<String> f78525e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f78521a = 2000;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f78522b = 8000;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f78523c = "UTF-8";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f78526f = 3;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f78527g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Map<String, String> f78528h = new TreeMap();

    public final void a(HttpURLConnection httpURLConnection) {
        for (String str : this.f78528h.keySet()) {
            httpURLConnection.setRequestProperty(str, this.f78528h.get(str));
        }
        httpURLConnection.setRequestProperty("Accept-Charset", this.f78523c);
    }

    /* JADX WARN: Code duplicated, block: B:56:0x009b  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r4v0, types: [uf.a] */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r5v5 */
    public e b(String str, HttpMethod httpMethod, String str2, byte[] bArr) throws Throwable {
        boolean z11 = false;
        ?? r11 = 0;
        try {
            try {
                this.f78527g = false;
                HttpURLConnection httpURLConnectionI = i(str);
                try {
                    k(httpURLConnectionI, httpMethod, str2);
                    a(httpURLConnectionI);
                    httpURLConnectionI.connect();
                    this.f78527g = true;
                    Set<String> set = this.f78525e;
                    boolean z12 = (set == null || set.isEmpty()) ? false : true;
                    Set<String> set2 = this.f78524d;
                    if (set2 != null && !set2.isEmpty()) {
                        z11 = true;
                    }
                    if ((httpURLConnectionI instanceof HttpsURLConnection) && (z12 || z11)) {
                        try {
                            f.b((HttpsURLConnection) httpURLConnectionI, this.f78525e, this.f78524d);
                        } catch (Exception e11) {
                            Log.e("AndroidHttpClient", "Unable to validate SSL certificates: ", e11);
                        }
                    }
                    if (httpURLConnectionI.getDoOutput() && bArr != null) {
                        t(httpURLConnectionI, bArr);
                    }
                    e eVarM = httpURLConnectionI.getDoInput() ? m(httpURLConnectionI) : new e(httpURLConnectionI, null);
                    httpURLConnectionI.disconnect();
                    return eVarM;
                } catch (Exception e12) {
                    e = e12;
                    str = httpURLConnectionI;
                    try {
                        try {
                            e eVarL = l(str);
                            if (eVarL == null || eVarL.c() <= 0) {
                                throw new HttpRequestException(e, eVarL);
                            }
                            if (str != 0) {
                                str.disconnect();
                            }
                            return eVarL;
                        } catch (Throwable unused) {
                            throw new HttpRequestException(e, null);
                        }
                    } catch (Exception unused2) {
                        Log.e("AndroidHttpClient", "Failed http method: ", e);
                        throw new HttpRequestException(e, null);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                r11 = str;
                if (r11 != 0) {
                    r11.disconnect();
                }
                throw th;
            }
        } catch (Exception e13) {
            e = e13;
            str = 0;
        } catch (Throwable th3) {
            th = th3;
            if (r11 != 0) {
                r11.disconnect();
            }
            throw th;
        }
    }

    public e c(d dVar) {
        try {
            return s(dVar);
        } catch (HttpRequestException e11) {
            Log.e("AndroidHttpClient", "Unable to send request and got a HttpRequestException: ", e11);
            return null;
        } catch (Exception e12) {
            Log.e("AndroidHttpClient", "Unable to send request and got a RuntimeException: ", new HttpRequestException(e12, null));
            return null;
        }
    }

    public final int d(int i11) {
        return (i11 <= 1 || i11 > 20) ? i11 : d(i11 - 1) + d(i11 - 2);
    }

    public e e(String str, Map<String, String> map) {
        return c(new b(str, map));
    }

    public int f(int i11) {
        return d(i11 + 2) * 1000;
    }

    public boolean g(HttpRequestException httpRequestException) {
        e httpResponse = httpRequestException.getHttpResponse();
        return httpResponse != null && httpResponse.c() > 0;
    }

    public boolean h(Throwable th2, long j11) {
        long jCurrentTimeMillis = (System.currentTimeMillis() - j11) + 10;
        if (this.f78527g) {
            return jCurrentTimeMillis >= ((long) this.f78522b);
        }
        return jCurrentTimeMillis >= ((long) this.f78521a);
    }

    public HttpURLConnection i(String str) throws IOException {
        try {
            return (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(str).openConnection()));
        } catch (MalformedURLException e11) {
            throw new IllegalArgumentException(str + " is not a valid URL", e11);
        }
    }

    public e j(String str, String str2, byte[] bArr) {
        return c(new c(str, null, str2, bArr));
    }

    public void k(HttpURLConnection httpURLConnection, HttpMethod httpMethod, String str) throws IOException {
        httpURLConnection.setConnectTimeout(this.f78521a);
        httpURLConnection.setReadTimeout(this.f78522b);
        httpURLConnection.setRequestMethod(httpMethod.getMethodName());
        httpURLConnection.setDoOutput(httpMethod.getDoOutput());
        httpURLConnection.setDoInput(httpMethod.getDoInput());
        if (str != null) {
            httpURLConnection.setRequestProperty(HttpHeaders.CONTENT_TYPE, str);
        }
    }

    public e l(HttpURLConnection httpURLConnection) throws Exception {
        InputStream inputStream = null;
        byte[] bArrN = null;
        try {
            InputStream errorStream = httpURLConnection.getErrorStream();
            if (errorStream != null) {
                try {
                    bArrN = n(errorStream);
                } catch (Throwable th2) {
                    th = th2;
                    inputStream = errorStream;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception unused) {
                        }
                    }
                    throw th;
                }
            }
            e eVar = new e(httpURLConnection, bArrN);
            if (errorStream != null) {
                try {
                    errorStream.close();
                } catch (Exception unused2) {
                }
            }
            return eVar;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public e m(HttpURLConnection httpURLConnection) throws Exception {
        InputStream inputStream = null;
        byte[] bArrN = null;
        try {
            InputStream inputStream2 = httpURLConnection.getInputStream();
            if (inputStream2 != null) {
                try {
                    bArrN = n(inputStream2);
                } catch (Throwable th2) {
                    th = th2;
                    inputStream = inputStream2;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception unused) {
                        }
                    }
                    throw th;
                }
            }
            e eVar = new e(httpURLConnection, bArrN);
            if (inputStream2 != null) {
                try {
                    inputStream2.close();
                } catch (Exception unused2) {
                }
            }
            return eVar;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public final byte[] n(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[16384];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int i11 = inputStream.read(bArr);
            if (i11 == -1) {
                byteArrayOutputStream.flush();
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, i11);
        }
    }

    public void o(int i11) {
        this.f78521a = i11;
    }

    public void p(Set<String> set) {
        this.f78525e = set;
    }

    public void q(Set<String> set) {
        this.f78524d = set;
    }

    public void r(int i11) {
        this.f78522b = i11;
    }

    public e s(d dVar) throws Throwable {
        long jCurrentTimeMillis = System.currentTimeMillis();
        e eVarB = null;
        for (int i11 = 0; i11 < this.f78526f; i11++) {
            try {
                o(f(i11));
                jCurrentTimeMillis = System.currentTimeMillis();
                eVarB = b(dVar.d(), dVar.c(), dVar.b(), dVar.a());
                if (eVarB != null) {
                    return eVarB;
                }
            } catch (HttpRequestException e11) {
                if (h(e11, jCurrentTimeMillis) && i11 < this.f78526f - 1) {
                    continue;
                } else {
                    if (!g(e11) || i11 >= this.f78526f - 1) {
                        Log.e("AndroidHttpClient", "Unable to send request: ", e11);
                        return eVarB;
                    }
                    try {
                        Thread.sleep(this.f78521a);
                    } catch (InterruptedException e12) {
                        Log.e("AndroidHttpClient", "App is stopping: ", e12);
                    }
                }
            }
        }
        return eVarB;
    }

    public int t(HttpURLConnection httpURLConnection, byte[] bArr) throws Exception {
        OutputStream outputStream;
        try {
            outputStream = httpURLConnection.getOutputStream();
            if (outputStream != null) {
                try {
                    outputStream.write(bArr);
                } catch (Throwable th2) {
                    th = th2;
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (Exception unused) {
                        }
                    }
                    throw th;
                }
            }
            int responseCode = httpURLConnection.getResponseCode();
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Exception unused2) {
                }
            }
            return responseCode;
        } catch (Throwable th3) {
            th = th3;
            outputStream = null;
        }
    }
}
