package sl;

import android.os.Build;
import com.google.firebase.perf.util.Timer;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.security.Permission;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class g {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ql.a f76385f = ql.a.e();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HttpURLConnection f76386a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.google.firebase.perf.metrics.j f76387b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f76388c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f76389d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Timer f76390e;

    public g(HttpURLConnection httpURLConnection, Timer timer, com.google.firebase.perf.metrics.j jVar) {
        this.f76386a = httpURLConnection;
        this.f76387b = jVar;
        this.f76390e = timer;
        jVar.s(httpURLConnection.getURL().toString());
    }

    public boolean A() {
        return this.f76386a.getInstanceFollowRedirects();
    }

    public long B() {
        a0();
        return this.f76386a.getLastModified();
    }

    public OutputStream C() throws IOException {
        try {
            OutputStream outputStream = this.f76386a.getOutputStream();
            return outputStream != null ? new b(outputStream, this.f76387b, this.f76390e) : outputStream;
        } catch (IOException e11) {
            this.f76387b.q(this.f76390e.getDurationMicros());
            j.d(this.f76387b);
            throw e11;
        }
    }

    public Permission D() throws IOException {
        try {
            return this.f76386a.getPermission();
        } catch (IOException e11) {
            this.f76387b.q(this.f76390e.getDurationMicros());
            j.d(this.f76387b);
            throw e11;
        }
    }

    public int E() {
        return this.f76386a.getReadTimeout();
    }

    public String F() {
        return this.f76386a.getRequestMethod();
    }

    public Map<String, List<String>> G() {
        return this.f76386a.getRequestProperties();
    }

    public String H(String str) {
        return this.f76386a.getRequestProperty(str);
    }

    public int I() throws IOException {
        a0();
        if (this.f76389d == -1) {
            long durationMicros = this.f76390e.getDurationMicros();
            this.f76389d = durationMicros;
            this.f76387b.r(durationMicros);
        }
        try {
            int responseCode = this.f76386a.getResponseCode();
            this.f76387b.i(responseCode);
            return responseCode;
        } catch (IOException e11) {
            this.f76387b.q(this.f76390e.getDurationMicros());
            j.d(this.f76387b);
            throw e11;
        }
    }

    public String J() throws IOException {
        a0();
        if (this.f76389d == -1) {
            long durationMicros = this.f76390e.getDurationMicros();
            this.f76389d = durationMicros;
            this.f76387b.r(durationMicros);
        }
        try {
            String responseMessage = this.f76386a.getResponseMessage();
            this.f76387b.i(this.f76386a.getResponseCode());
            return responseMessage;
        } catch (IOException e11) {
            this.f76387b.q(this.f76390e.getDurationMicros());
            j.d(this.f76387b);
            throw e11;
        }
    }

    public URL K() {
        return this.f76386a.getURL();
    }

    public boolean L() {
        return this.f76386a.getUseCaches();
    }

    public void M(boolean z11) {
        this.f76386a.setAllowUserInteraction(z11);
    }

    public void N(int i11) {
        this.f76386a.setChunkedStreamingMode(i11);
    }

    public void O(int i11) {
        this.f76386a.setConnectTimeout(i11);
    }

    public void P(boolean z11) {
        this.f76386a.setDefaultUseCaches(z11);
    }

    public void Q(boolean z11) {
        this.f76386a.setDoInput(z11);
    }

    public void R(boolean z11) {
        this.f76386a.setDoOutput(z11);
    }

    public void S(int i11) {
        this.f76386a.setFixedLengthStreamingMode(i11);
    }

    public void T(long j11) {
        this.f76386a.setFixedLengthStreamingMode(j11);
    }

    public void U(long j11) {
        this.f76386a.setIfModifiedSince(j11);
    }

    public void V(boolean z11) {
        this.f76386a.setInstanceFollowRedirects(z11);
    }

    public void W(int i11) {
        this.f76386a.setReadTimeout(i11);
    }

    public void X(String str) throws ProtocolException {
        this.f76386a.setRequestMethod(str);
    }

    public void Y(String str, String str2) {
        if ("User-Agent".equalsIgnoreCase(str)) {
            this.f76387b.t(str2);
        }
        this.f76386a.setRequestProperty(str, str2);
    }

    public void Z(boolean z11) {
        this.f76386a.setUseCaches(z11);
    }

    public void a(String str, String str2) {
        this.f76386a.addRequestProperty(str, str2);
    }

    public final void a0() {
        if (this.f76388c == -1) {
            this.f76390e.reset();
            long micros = this.f76390e.getMicros();
            this.f76388c = micros;
            this.f76387b.m(micros);
        }
        String strF = F();
        if (strF != null) {
            this.f76387b.h(strF);
        } else if (o()) {
            this.f76387b.h("POST");
        } else {
            this.f76387b.h("GET");
        }
    }

    public void b() throws IOException {
        if (this.f76388c == -1) {
            this.f76390e.reset();
            long micros = this.f76390e.getMicros();
            this.f76388c = micros;
            this.f76387b.m(micros);
        }
        try {
            this.f76386a.connect();
        } catch (IOException e11) {
            this.f76387b.q(this.f76390e.getDurationMicros());
            j.d(this.f76387b);
            throw e11;
        }
    }

    public boolean b0() {
        return this.f76386a.usingProxy();
    }

    public void c() {
        this.f76387b.q(this.f76390e.getDurationMicros());
        this.f76387b.c();
        this.f76386a.disconnect();
    }

    public boolean d() {
        return this.f76386a.getAllowUserInteraction();
    }

    public int e() {
        return this.f76386a.getConnectTimeout();
    }

    public boolean equals(Object obj) {
        return this.f76386a.equals(obj);
    }

    public Object f() throws IOException {
        a0();
        this.f76387b.i(this.f76386a.getResponseCode());
        try {
            Object content = this.f76386a.getContent();
            if (content instanceof InputStream) {
                this.f76387b.n(this.f76386a.getContentType());
                return new a((InputStream) content, this.f76387b, this.f76390e);
            }
            this.f76387b.n(this.f76386a.getContentType());
            this.f76387b.o(this.f76386a.getContentLength());
            this.f76387b.q(this.f76390e.getDurationMicros());
            this.f76387b.c();
            return content;
        } catch (IOException e11) {
            this.f76387b.q(this.f76390e.getDurationMicros());
            j.d(this.f76387b);
            throw e11;
        }
    }

    public Object g(Class[] clsArr) throws IOException {
        a0();
        this.f76387b.i(this.f76386a.getResponseCode());
        try {
            Object content = this.f76386a.getContent(clsArr);
            if (content instanceof InputStream) {
                this.f76387b.n(this.f76386a.getContentType());
                return new a((InputStream) content, this.f76387b, this.f76390e);
            }
            this.f76387b.n(this.f76386a.getContentType());
            this.f76387b.o(this.f76386a.getContentLength());
            this.f76387b.q(this.f76390e.getDurationMicros());
            this.f76387b.c();
            return content;
        } catch (IOException e11) {
            this.f76387b.q(this.f76390e.getDurationMicros());
            j.d(this.f76387b);
            throw e11;
        }
    }

    public String h() {
        a0();
        return this.f76386a.getContentEncoding();
    }

    public int hashCode() {
        return this.f76386a.hashCode();
    }

    public int i() {
        a0();
        return this.f76386a.getContentLength();
    }

    public long j() {
        a0();
        if (Build.VERSION.SDK_INT >= 24) {
            return this.f76386a.getContentLengthLong();
        }
        return 0L;
    }

    public String k() {
        a0();
        return this.f76386a.getContentType();
    }

    public long l() {
        a0();
        return this.f76386a.getDate();
    }

    public boolean m() {
        return this.f76386a.getDefaultUseCaches();
    }

    public boolean n() {
        return this.f76386a.getDoInput();
    }

    public boolean o() {
        return this.f76386a.getDoOutput();
    }

    public InputStream p() {
        a0();
        try {
            this.f76387b.i(this.f76386a.getResponseCode());
        } catch (IOException unused) {
            f76385f.a("IOException thrown trying to obtain the response code");
        }
        InputStream errorStream = this.f76386a.getErrorStream();
        return errorStream != null ? new a(errorStream, this.f76387b, this.f76390e) : errorStream;
    }

    public long q() {
        a0();
        return this.f76386a.getExpiration();
    }

    public String r(int i11) {
        a0();
        return this.f76386a.getHeaderField(i11);
    }

    public String s(String str) {
        a0();
        return this.f76386a.getHeaderField(str);
    }

    public long t(String str, long j11) {
        a0();
        return this.f76386a.getHeaderFieldDate(str, j11);
    }

    public String toString() {
        return this.f76386a.toString();
    }

    public int u(String str, int i11) {
        a0();
        return this.f76386a.getHeaderFieldInt(str, i11);
    }

    public String v(int i11) {
        a0();
        return this.f76386a.getHeaderFieldKey(i11);
    }

    public long w(String str, long j11) {
        a0();
        if (Build.VERSION.SDK_INT >= 24) {
            return this.f76386a.getHeaderFieldLong(str, j11);
        }
        return 0L;
    }

    public Map<String, List<String>> x() {
        a0();
        return this.f76386a.getHeaderFields();
    }

    public long y() {
        return this.f76386a.getIfModifiedSince();
    }

    public InputStream z() throws IOException {
        a0();
        this.f76387b.i(this.f76386a.getResponseCode());
        this.f76387b.n(this.f76386a.getContentType());
        try {
            InputStream inputStream = this.f76386a.getInputStream();
            return inputStream != null ? new a(inputStream, this.f76387b, this.f76390e) : inputStream;
        } catch (IOException e11) {
            this.f76387b.q(this.f76390e.getDurationMicros());
            j.d(this.f76387b);
            throw e11;
        }
    }
}
