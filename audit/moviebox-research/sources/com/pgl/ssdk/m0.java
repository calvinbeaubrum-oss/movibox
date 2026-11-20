package com.pgl.ssdk;

import android.content.Context;
import com.alibaba.sdk.android.oss.common.OSSConstants;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.Locale;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public abstract class m0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f48797b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f48798c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f48799d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f48800e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private byte[] f48801f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f48796a = "";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f48802g = -1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private byte[] f48803h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f48804i = 10000;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f48805j = 2;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f48806k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f48807l = false;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f48808m = true;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private HttpURLConnection f48809n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private Runnable f48810o = new a();

    /* JADX INFO: compiled from: source.java */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m0.this.a() || m0.this.f48806k >= m0.this.f48805j) {
                return;
            }
            m0.c(m0.this);
            o0.a(this);
        }
    }

    public m0(Context context, String str) {
        str = (str == null || str.length() <= 0) ? "" : str;
        this.f48797b = context;
        this.f48798c = str;
    }

    private void a(int i11) throws ProtocolException {
        String str;
        if (i11 == 1) {
            str = "POST";
        } else if (i11 == 3) {
            str = "PUT";
        } else if (i11 == 4) {
            str = "DELETE";
        } else if (i11 != 5) {
            str = i11 != 6 ? "GET" : "TRACE";
        } else {
            str = "HEAD";
        }
        this.f48809n.setRequestMethod(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:22:0x0087 A[Catch: all -> 0x001d, PHI: r1
  0x0087: PHI (r1v16 java.io.InputStream) = (r1v15 java.io.InputStream), (r1v21 java.io.InputStream) binds: [B:20:0x0084, B:16:0x007d] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x001d, blocks: (B:3:0x0001, B:5:0x000c, B:8:0x002e, B:10:0x004b, B:12:0x004e, B:13:0x0064, B:22:0x0087, B:7:0x0020), top: B:37:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:29:0x0095 A[PHI: r1 r2
  0x0095: PHI (r1v1 java.net.HttpURLConnection) = (r1v0 java.net.HttpURLConnection), (r1v17 java.net.HttpURLConnection) binds: [B:27:0x0092, B:24:0x008c] A[DONT_GENERATE, DONT_INLINE]
  0x0095: PHI (r2v1 boolean) = (r2v0 boolean), (r2v7 boolean) binds: [B:27:0x0092, B:24:0x008c] A[DONT_GENERATE, DONT_INLINE]] */
    public boolean a() {
        HttpURLConnection httpURLConnection;
        boolean z11;
        InputStream inputStream;
        try {
            URL url = new URL(this.f48796a);
            if (this.f48808m) {
                this.f48809n = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(url.openConnection(Proxy.NO_PROXY)));
            } else {
                this.f48809n = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(url.openConnection()));
            }
            this.f48809n.setConnectTimeout(this.f48804i);
            this.f48809n.setReadTimeout(this.f48804i);
            a(this.f48799d);
            b(this.f48800e);
            byte[] bArr = this.f48801f;
            z11 = true;
            if (bArr != null && bArr.length > 0) {
                this.f48809n.setDoOutput(true);
                OutputStream outputStream = this.f48809n.getOutputStream();
                outputStream.write(this.f48801f);
                outputStream.flush();
                outputStream.close();
            }
            this.f48809n.connect();
            try {
                this.f48802g = this.f48809n.getResponseCode();
                inputStream = this.f48809n.getInputStream();
                try {
                    this.f48803h = a(inputStream);
                    if (inputStream != null) {
                        inputStream.close();
                    }
                } catch (Throwable unused) {
                    if (inputStream != null) {
                        inputStream.close();
                    }
                }
            } catch (Throwable unused2) {
                inputStream = null;
            }
            httpURLConnection = this.f48809n;
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
                this.f48809n = null;
            }
        } catch (Throwable unused3) {
            httpURLConnection = this.f48809n;
            z11 = false;
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
                this.f48809n = null;
            }
        }
        if (z11) {
            a(this.f48802g, this.f48803h);
        }
        return z11;
    }

    private byte[] a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int i11 = inputStream.read(bArr, 0, 1024);
            if (i11 <= 0) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, i11);
        }
    }

    private void b(int i11) {
        String str;
        if (i11 != 1) {
            str = i11 != 2 ? "" : OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE;
        } else {
            str = "application/json; charset=utf-8";
        }
        if (str.length() > 0) {
            this.f48809n.addRequestProperty(HttpHeaders.CONTENT_TYPE, str);
        }
        this.f48809n.addRequestProperty("Cookie", "sessionid=" + this.f48798c);
        try {
            String language = Locale.getDefault().getLanguage();
            if (language.equalsIgnoreCase("zh")) {
                this.f48809n.addRequestProperty("Accept-Language", Locale.getDefault().toString() + "," + language + ";q=0.9");
                return;
            }
            this.f48809n.addRequestProperty("Accept-Language", Locale.getDefault().toString() + "," + language + ";q=0.9,en-US;q=0.6,en;q=0.4");
        } catch (Throwable unused) {
        }
    }

    private void b(int i11, int i12, byte[] bArr) {
        this.f48799d = i11;
        this.f48800e = i12;
        this.f48801f = bArr;
    }

    public static /* synthetic */ int c(m0 m0Var) {
        int i11 = m0Var.f48806k;
        m0Var.f48806k = i11 + 1;
        return i11;
    }

    public void a(int i11, int i12, byte[] bArr) {
        b(i11, i12, bArr);
        o0.a(this.f48810o);
    }

    public abstract boolean a(int i11, byte[] bArr);
}
