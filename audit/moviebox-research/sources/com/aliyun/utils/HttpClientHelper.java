package com.aliyun.utils;

import com.cicada.player.utils.Logger;
import com.cloud.hisavana.sdk.internal.agentpage.AgentPageJsBridge;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class HttpClientHelper {
    private static final int CONNECTION_TIMEOUT = 10000;
    private static final String TAG = "HttpClientHelper";
    private static ExecutorService sThreadCachePool = Executors.newCachedThreadPool();
    private String mUrl;
    private URLConnection urlConnection = null;
    private String mReferer = null;
    private int mNetworkTimeout = 10000;
    private String mHttpProxy = null;
    private String mUserAgent = null;
    private String[] mCustomHeaders = null;

    public HttpClientHelper(String str) {
        this.mUrl = str;
    }

    private InputStream getErrorStream() {
        URLConnection uRLConnection = this.urlConnection;
        if (uRLConnection instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) uRLConnection).getErrorStream();
        }
        if (uRLConnection instanceof HttpURLConnection) {
            return ((HttpURLConnection) uRLConnection).getErrorStream();
        }
        return null;
    }

    private URLConnection getHttpUrlConnection(String str) {
        Proxy proxy;
        URLConnection uRLConnection = null;
        try {
            if (this.mHttpProxy != null) {
                try {
                    URL url = new URL(this.mHttpProxy);
                    proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(url.getHost(), url.getPort()));
                } catch (Exception unused) {
                    proxy = null;
                }
            } else {
                proxy = null;
            }
            URL url2 = new URL(str);
            URLConnection uRLConnection2 = proxy != null ? (URLConnection) FirebasePerfUrlConnection.instrument(url2.openConnection(proxy)) : (URLConnection) FirebasePerfUrlConnection.instrument(url2.openConnection());
            try {
                if (!(uRLConnection2 instanceof HttpURLConnection)) {
                    return null;
                }
                HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnection2;
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setConnectTimeout(this.mNetworkTimeout);
                httpURLConnection.setReadTimeout(this.mNetworkTimeout);
                return uRLConnection2;
            } catch (Exception unused2) {
                uRLConnection = uRLConnection2;
                return uRLConnection;
            }
        } catch (Exception unused3) {
        }
    }

    private URLConnection getHttpsUrlConnection(String str) {
        Proxy proxy;
        URLConnection uRLConnection = null;
        try {
            if (this.mHttpProxy != null) {
                try {
                    URL url = new URL(this.mHttpProxy);
                    proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(url.getHost(), url.getPort()));
                } catch (Exception unused) {
                    proxy = null;
                }
            } else {
                proxy = null;
            }
            URL url2 = new URL(str);
            URLConnection uRLConnection2 = proxy != null ? (URLConnection) FirebasePerfUrlConnection.instrument(url2.openConnection(proxy)) : (URLConnection) FirebasePerfUrlConnection.instrument(url2.openConnection());
            try {
                if (!(uRLConnection2 instanceof HttpsURLConnection)) {
                    return null;
                }
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) uRLConnection2;
                httpsURLConnection.setRequestMethod("GET");
                httpsURLConnection.setConnectTimeout(this.mNetworkTimeout);
                httpsURLConnection.setReadTimeout(this.mNetworkTimeout);
                return uRLConnection2;
            } catch (Exception unused2) {
                uRLConnection = uRLConnection2;
                return uRLConnection;
            }
        } catch (Exception unused3) {
        }
    }

    private int getResponseCode() throws IOException {
        URLConnection uRLConnection = this.urlConnection;
        if (uRLConnection instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) uRLConnection).getResponseCode();
        }
        if (uRLConnection instanceof HttpURLConnection) {
            return ((HttpURLConnection) uRLConnection).getResponseCode();
        }
        return 0;
    }

    /* JADX WARN: Code duplicated, block: B:38:0x0092 A[PHI: r7
  0x0092: PHI (r7v6 java.net.URLConnection) = (r7v8 java.net.URLConnection), (r7v11 java.net.URLConnection) binds: [B:55:0x00c2, B:37:0x0090] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:46:0x00aa A[Catch: IOException -> 0x00a6, TRY_LEAVE, TryCatch #3 {IOException -> 0x00a6, blocks: (B:43:0x00a2, B:46:0x00aa), top: B:58:0x00a2 }] */
    /* JADX WARN: Code duplicated, block: B:48:0x00af  */
    /* JADX WARN: Code duplicated, block: B:54:0x00bf A[Catch: IOException -> 0x00bb, TRY_LEAVE, TryCatch #9 {IOException -> 0x00bb, blocks: (B:51:0x00b7, B:54:0x00bf), top: B:62:0x00b7 }] */
    /* JADX WARN: Code duplicated, block: B:73:? A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r3v9 */
    public static byte[] post(String str, byte[] bArr) throws Throwable {
        URLConnection uRLConnection;
        ByteArrayOutputStream byteArrayOutputStream;
        InputStream inputStream;
        ?? r11;
        InputStream inputStream2 = null;
        try {
            uRLConnection = (URLConnection) FirebasePerfUrlConnection.instrument(new URL(str).openConnection());
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnection;
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(bArr != null);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setConnectTimeout(10000);
                httpURLConnection.setReadTimeout(10000);
                if (bArr != null) {
                    httpURLConnection.setFixedLengthStreamingMode(bArr.length);
                    httpURLConnection.connect();
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    outputStream.write(bArr);
                    outputStream.close();
                } else {
                    httpURLConnection.connect();
                }
                if (httpURLConnection.getResponseCode() != 200) {
                    if (uRLConnection != null) {
                        ((HttpURLConnection) uRLConnection).disconnect();
                    }
                    return null;
                }
                inputStream = httpURLConnection.getInputStream();
                try {
                    byte[] bArr2 = new byte[4096];
                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                    while (true) {
                        try {
                            int i11 = inputStream.read(bArr2);
                            if (i11 == -1) {
                                break;
                            }
                            byteArrayOutputStream2.write(bArr2, 0, i11);
                        } catch (Exception unused) {
                            r11 = byteArrayOutputStream2;
                        } catch (Throwable th2) {
                            inputStream2 = inputStream;
                            th = th2;
                            byteArrayOutputStream = byteArrayOutputStream2;
                            if (inputStream2 != null) {
                                try {
                                    inputStream2.close();
                                    if (byteArrayOutputStream != null) {
                                        byteArrayOutputStream.close();
                                    }
                                } catch (IOException unused2) {
                                    if (uRLConnection != null) {
                                        throw th;
                                    }
                                    ((HttpURLConnection) uRLConnection).disconnect();
                                    throw th;
                                }
                            } else if (byteArrayOutputStream != null) {
                                byteArrayOutputStream.close();
                            }
                            if (uRLConnection != null) {
                                throw th;
                            }
                            ((HttpURLConnection) uRLConnection).disconnect();
                            throw th;
                        }
                    }
                    byte[] byteArray = byteArrayOutputStream2.toByteArray();
                    try {
                        inputStream.close();
                        byteArrayOutputStream2.close();
                    } catch (IOException unused3) {
                    }
                    if (uRLConnection != null) {
                        ((HttpURLConnection) uRLConnection).disconnect();
                    }
                    return byteArray;
                } catch (Exception unused4) {
                    r11 = 0;
                } catch (Throwable th3) {
                    byteArrayOutputStream = null;
                    inputStream2 = inputStream;
                    th = th3;
                }
            } catch (Exception unused5) {
                inputStream = null;
                r11 = inputStream;
            } catch (Throwable th4) {
                th = th4;
                byteArrayOutputStream = null;
            }
        } catch (Exception unused6) {
            uRLConnection = null;
            inputStream = null;
        } catch (Throwable th5) {
            th = th5;
            uRLConnection = null;
            byteArrayOutputStream = null;
        }
        if (inputStream != null) {
            try {
                inputStream.close();
                if (r11 != 0) {
                    r11.close();
                }
            } catch (IOException unused7) {
            }
        } else if (r11 != 0) {
            r11.close();
        }
        if (uRLConnection != null) {
            ((HttpURLConnection) uRLConnection).disconnect();
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:109:0x0161 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:110:0x0163 A[Catch: IOException -> 0x015f, TryCatch #14 {IOException -> 0x015f, blocks: (B:107:0x015b, B:110:0x0163, B:112:0x0168), top: B:145:0x015b }] */
    /* JADX WARN: Code duplicated, block: B:112:0x0168 A[Catch: IOException -> 0x015f, TRY_LEAVE, TryCatch #14 {IOException -> 0x015f, blocks: (B:107:0x015b, B:110:0x0163, B:112:0x0168), top: B:145:0x015b }] */
    /* JADX WARN: Code duplicated, block: B:115:0x016f  */
    /* JADX WARN: Code duplicated, block: B:117:0x0173  */
    /* JADX WARN: Code duplicated, block: B:118:0x0179  */
    /* JADX WARN: Code duplicated, block: B:120:0x017d  */
    /* JADX WARN: Code duplicated, block: B:125:0x018b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:126:0x018d A[Catch: IOException -> 0x0189, TryCatch #8 {IOException -> 0x0189, blocks: (B:123:0x0185, B:126:0x018d, B:128:0x0192), top: B:141:0x0185 }] */
    /* JADX WARN: Code duplicated, block: B:128:0x0192 A[Catch: IOException -> 0x0189, TRY_LEAVE, TryCatch #8 {IOException -> 0x0189, blocks: (B:123:0x0185, B:126:0x018d, B:128:0x0192), top: B:141:0x0185 }] */
    /* JADX WARN: Code duplicated, block: B:131:0x0199  */
    /* JADX WARN: Code duplicated, block: B:133:0x019d  */
    /* JADX WARN: Code duplicated, block: B:135:0x01a1  */
    /* JADX WARN: Code duplicated, block: B:136:0x01a7  */
    /* JADX WARN: Code duplicated, block: B:141:0x0185 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:145:0x015b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:165:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:166:? A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v16, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v25 */
    /* JADX WARN: Type inference failed for: r4v26 */
    /* JADX WARN: Type inference failed for: r4v27 */
    /* JADX WARN: Type inference failed for: r4v28 */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    public String doGet() throws Throwable {
        InputStream errorStream;
        InputStreamReader inputStreamReader;
        InputStream inputStream;
        InputStreamReader inputStreamReader2;
        InputStreamReader inputStreamReader3;
        Throwable th2;
        ?? bufferedReader;
        ?? r11;
        URLConnection uRLConnection;
        ?? r12;
        ?? r13;
        URLConnection uRLConnection2;
        if (this.mUrl.startsWith(AgentPageJsBridge.HTTPS)) {
            this.urlConnection = getHttpsUrlConnection(this.mUrl);
        } else if (this.mUrl.startsWith("http://")) {
            this.urlConnection = getHttpUrlConnection(this.mUrl);
        } else {
            this.urlConnection = null;
        }
        URLConnection uRLConnection3 = this.urlConnection;
        if (uRLConnection3 == null) {
            return null;
        }
        String str = this.mReferer;
        if (str != null) {
            uRLConnection3.setRequestProperty("Referer", str);
        }
        String str2 = this.mUserAgent;
        if (str2 != null) {
            this.urlConnection.addRequestProperty("User-Agent", str2);
        }
        String[] strArr = this.mCustomHeaders;
        if (strArr != null) {
            for (String str3 : strArr) {
                if (str3 != null) {
                    String[] strArrSplit = str3.split(":");
                    if (strArrSplit.length == 2) {
                        this.urlConnection.addRequestProperty(strArrSplit[0], strArrSplit[1]);
                    }
                }
            }
        }
        try {
            int responseCode = getResponseCode();
            if (responseCode == 200) {
                inputStream = this.urlConnection.getInputStream();
                try {
                    inputStreamReader2 = new InputStreamReader(inputStream);
                    try {
                        bufferedReader = new BufferedReader(inputStreamReader2);
                        try {
                            try {
                                StringBuilder sb2 = new StringBuilder();
                                while (true) {
                                    String line = bufferedReader.readLine();
                                    if (line == null) {
                                        break;
                                    }
                                    sb2.append(line);
                                    th2 = th;
                                    r13 = bufferedReader;
                                    inputStreamReader = inputStreamReader2;
                                    r12 = r13;
                                    errorStream = inputStream;
                                    r11 = r12;
                                    if (errorStream != null) {
                                        try {
                                            errorStream.close();
                                            if (inputStreamReader != null) {
                                                inputStreamReader.close();
                                            }
                                            if (r11 != 0) {
                                                r11.close();
                                            }
                                        } catch (IOException unused) {
                                        }
                                    } else {
                                        if (inputStreamReader != null) {
                                            inputStreamReader.close();
                                        }
                                        if (r11 != 0) {
                                            r11.close();
                                        }
                                    }
                                    uRLConnection = this.urlConnection;
                                    if (uRLConnection != null) {
                                        throw th2;
                                    }
                                    if (!(uRLConnection instanceof HttpURLConnection)) {
                                        ((HttpURLConnection) uRLConnection).disconnect();
                                        throw th2;
                                    }
                                    if (uRLConnection instanceof HttpsURLConnection) {
                                        throw th2;
                                    }
                                    ((HttpsURLConnection) uRLConnection).disconnect();
                                    throw th2;
                                }
                                String string = sb2.toString();
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (IOException unused2) {
                                    }
                                }
                                inputStreamReader2.close();
                                bufferedReader.close();
                                URLConnection uRLConnection4 = this.urlConnection;
                                if (uRLConnection4 != null) {
                                    if (uRLConnection4 instanceof HttpURLConnection) {
                                        ((HttpURLConnection) uRLConnection4).disconnect();
                                    } else if (uRLConnection4 instanceof HttpsURLConnection) {
                                        ((HttpsURLConnection) uRLConnection4).disconnect();
                                    }
                                }
                                return string;
                            } catch (Exception e11) {
                                e = e11;
                                bufferedReader = bufferedReader;
                                Logger.d("HttpClientUtil", e.getMessage());
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                        if (inputStreamReader2 != null) {
                                            inputStreamReader2.close();
                                        }
                                        if (bufferedReader != 0) {
                                            bufferedReader.close();
                                        }
                                    } catch (IOException unused3) {
                                    }
                                } else {
                                    if (inputStreamReader2 != null) {
                                        inputStreamReader2.close();
                                    }
                                    if (bufferedReader != 0) {
                                        bufferedReader.close();
                                    }
                                }
                                uRLConnection2 = this.urlConnection;
                                if (uRLConnection2 != null) {
                                    if (uRLConnection2 instanceof HttpURLConnection) {
                                        ((HttpURLConnection) uRLConnection2).disconnect();
                                    } else if (uRLConnection2 instanceof HttpsURLConnection) {
                                        ((HttpsURLConnection) uRLConnection2).disconnect();
                                    }
                                }
                                return null;
                            }
                        } catch (Throwable th3) {
                            th2 = th3;
                            r13 = bufferedReader;
                        }
                    } catch (Exception e12) {
                        e = e12;
                        bufferedReader = 0;
                    } catch (Throwable th4) {
                        r13 = 0;
                        th2 = th4;
                    }
                } catch (Exception e13) {
                    e = e13;
                    inputStreamReader2 = null;
                    bufferedReader = inputStreamReader2;
                } catch (Throwable th5) {
                    inputStreamReader = null;
                    r12 = 0;
                    th2 = th5;
                }
            } else {
                errorStream = getErrorStream();
                try {
                    inputStreamReader = new InputStreamReader(errorStream);
                    try {
                        BufferedReader bufferedReader2 = new BufferedReader(inputStreamReader);
                        try {
                            StringBuilder sb3 = new StringBuilder();
                            while (true) {
                                String line2 = bufferedReader2.readLine();
                                if (line2 == null) {
                                    break;
                                }
                                sb3.append(line2);
                            }
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("StatusCode", responseCode);
                            jSONObject.put("ResponseStr", sb3.toString());
                            String string2 = jSONObject.toString();
                            if (errorStream != null) {
                                try {
                                    errorStream.close();
                                } catch (IOException unused4) {
                                }
                            }
                            inputStreamReader.close();
                            bufferedReader2.close();
                            URLConnection uRLConnection5 = this.urlConnection;
                            if (uRLConnection5 != null) {
                                if (uRLConnection5 instanceof HttpURLConnection) {
                                    ((HttpURLConnection) uRLConnection5).disconnect();
                                } else if (uRLConnection5 instanceof HttpsURLConnection) {
                                    ((HttpsURLConnection) uRLConnection5).disconnect();
                                }
                            }
                            return string2;
                        } catch (Exception e14) {
                            e = e14;
                            inputStream = errorStream;
                            inputStreamReader2 = inputStreamReader;
                            bufferedReader = bufferedReader2;
                        } catch (Throwable th6) {
                            th2 = th6;
                            r11 = bufferedReader2;
                        }
                    } catch (Exception e15) {
                        e = e15;
                        inputStream = errorStream;
                        inputStreamReader2 = inputStreamReader;
                        bufferedReader = 0;
                    } catch (Throwable th7) {
                        th = th7;
                        inputStreamReader3 = null;
                        th2 = th;
                        r11 = inputStreamReader3;
                    }
                } catch (Exception e16) {
                    e = e16;
                    bufferedReader = 0;
                    inputStream = errorStream;
                    inputStreamReader2 = null;
                } catch (Throwable th8) {
                    th = th8;
                    inputStreamReader = null;
                    inputStreamReader3 = inputStreamReader;
                    th2 = th;
                    r11 = inputStreamReader3;
                    if (errorStream != null) {
                        errorStream.close();
                        if (inputStreamReader != null) {
                            inputStreamReader.close();
                        }
                        if (r11 != 0) {
                            r11.close();
                        }
                    } else {
                        if (inputStreamReader != null) {
                            inputStreamReader.close();
                        }
                        if (r11 != 0) {
                            r11.close();
                        }
                    }
                    uRLConnection = this.urlConnection;
                    if (uRLConnection != null) {
                        throw th2;
                    }
                    if (!(uRLConnection instanceof HttpURLConnection)) {
                        ((HttpURLConnection) uRLConnection).disconnect();
                        throw th2;
                    }
                    if (uRLConnection instanceof HttpsURLConnection) {
                        throw th2;
                    }
                    ((HttpsURLConnection) uRLConnection).disconnect();
                    throw th2;
                }
            }
        } catch (Exception e17) {
            e = e17;
            inputStream = null;
            inputStreamReader2 = null;
        } catch (Throwable th9) {
            th = th9;
            errorStream = null;
            inputStreamReader = null;
        }
        Logger.d("HttpClientUtil", e.getMessage());
        if (inputStream != null) {
            inputStream.close();
            if (inputStreamReader2 != null) {
                inputStreamReader2.close();
            }
            if (bufferedReader != 0) {
                bufferedReader.close();
            }
        } else {
            if (inputStreamReader2 != null) {
                inputStreamReader2.close();
            }
            if (bufferedReader != 0) {
                bufferedReader.close();
            }
        }
        uRLConnection2 = this.urlConnection;
        if (uRLConnection2 != null) {
            if (uRLConnection2 instanceof HttpURLConnection) {
                ((HttpURLConnection) uRLConnection2).disconnect();
            } else if (uRLConnection2 instanceof HttpsURLConnection) {
                ((HttpsURLConnection) uRLConnection2).disconnect();
            }
        }
        return null;
    }

    public void setCustomHeaders(String[] strArr) {
        this.mCustomHeaders = strArr;
    }

    public void setHttpProxy(String str) {
        this.mHttpProxy = str;
    }

    public void setRefer(String str) {
        this.mReferer = str;
    }

    public void setTimeout(int i11) {
        this.mNetworkTimeout = i11;
    }

    public void setUerAgent(String str) {
        this.mUserAgent = str;
    }

    public void stop() {
        Logger.d(TAG, "HttpClientHelper stop().... urlConnection = " + this.urlConnection);
        if (this.urlConnection != null) {
            sThreadCachePool.execute(new Runnable() { // from class: com.aliyun.utils.HttpClientHelper.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (HttpClientHelper.this.urlConnection instanceof HttpsURLConnection) {
                            Logger.i(HttpClientHelper.TAG, "HttpClientHelper stop().... HttpsURLConnection.disconnect ");
                            ((HttpsURLConnection) HttpClientHelper.this.urlConnection).disconnect();
                        } else if (HttpClientHelper.this.urlConnection instanceof HttpURLConnection) {
                            Logger.i(HttpClientHelper.TAG, "HttpClientHelper stop().... HttpURLConnection.disconnect ");
                            ((HttpURLConnection) HttpClientHelper.this.urlConnection).disconnect();
                        }
                    } catch (Exception e11) {
                        Logger.e(HttpClientHelper.TAG, e11.getMessage());
                    }
                }
            });
        }
    }
}
