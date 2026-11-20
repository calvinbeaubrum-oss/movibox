package sl;

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
public final class c extends HttpURLConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f76382a;

    public c(HttpURLConnection httpURLConnection, Timer timer, com.google.firebase.perf.metrics.j jVar) {
        super(httpURLConnection.getURL());
        this.f76382a = new g(httpURLConnection, timer, jVar);
    }

    @Override // java.net.URLConnection
    public void addRequestProperty(String str, String str2) {
        this.f76382a.a(str, str2);
    }

    @Override // java.net.URLConnection
    public void connect() throws IOException {
        this.f76382a.b();
    }

    @Override // java.net.HttpURLConnection
    public void disconnect() {
        this.f76382a.c();
    }

    public boolean equals(Object obj) {
        return this.f76382a.equals(obj);
    }

    @Override // java.net.URLConnection
    public boolean getAllowUserInteraction() {
        return this.f76382a.d();
    }

    @Override // java.net.URLConnection
    public int getConnectTimeout() {
        return this.f76382a.e();
    }

    @Override // java.net.URLConnection
    public Object getContent() throws IOException {
        return this.f76382a.f();
    }

    @Override // java.net.URLConnection
    public Object getContent(Class[] clsArr) throws IOException {
        return this.f76382a.g(clsArr);
    }

    @Override // java.net.URLConnection
    public String getContentEncoding() {
        return this.f76382a.h();
    }

    @Override // java.net.URLConnection
    public int getContentLength() {
        return this.f76382a.i();
    }

    @Override // java.net.URLConnection
    public long getContentLengthLong() {
        return this.f76382a.j();
    }

    @Override // java.net.URLConnection
    public String getContentType() {
        return this.f76382a.k();
    }

    @Override // java.net.URLConnection
    public long getDate() {
        return this.f76382a.l();
    }

    @Override // java.net.URLConnection
    public boolean getDefaultUseCaches() {
        return this.f76382a.m();
    }

    @Override // java.net.URLConnection
    public boolean getDoInput() {
        return this.f76382a.n();
    }

    @Override // java.net.URLConnection
    public boolean getDoOutput() {
        return this.f76382a.o();
    }

    @Override // java.net.HttpURLConnection
    public InputStream getErrorStream() {
        return this.f76382a.p();
    }

    @Override // java.net.URLConnection
    public long getExpiration() {
        return this.f76382a.q();
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public String getHeaderField(int i11) {
        return this.f76382a.r(i11);
    }

    @Override // java.net.URLConnection
    public String getHeaderField(String str) {
        return this.f76382a.s(str);
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public long getHeaderFieldDate(String str, long j11) {
        return this.f76382a.t(str, j11);
    }

    @Override // java.net.URLConnection
    public int getHeaderFieldInt(String str, int i11) {
        return this.f76382a.u(str, i11);
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public String getHeaderFieldKey(int i11) {
        return this.f76382a.v(i11);
    }

    @Override // java.net.URLConnection
    public long getHeaderFieldLong(String str, long j11) {
        return this.f76382a.w(str, j11);
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getHeaderFields() {
        return this.f76382a.x();
    }

    @Override // java.net.URLConnection
    public long getIfModifiedSince() {
        return this.f76382a.y();
    }

    @Override // java.net.URLConnection
    public InputStream getInputStream() throws IOException {
        return this.f76382a.z();
    }

    @Override // java.net.HttpURLConnection
    public boolean getInstanceFollowRedirects() {
        return this.f76382a.A();
    }

    @Override // java.net.URLConnection
    public long getLastModified() {
        return this.f76382a.B();
    }

    @Override // java.net.URLConnection
    public OutputStream getOutputStream() throws IOException {
        return this.f76382a.C();
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public Permission getPermission() throws IOException {
        return this.f76382a.D();
    }

    @Override // java.net.URLConnection
    public int getReadTimeout() {
        return this.f76382a.E();
    }

    @Override // java.net.HttpURLConnection
    public String getRequestMethod() {
        return this.f76382a.F();
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getRequestProperties() {
        return this.f76382a.G();
    }

    @Override // java.net.URLConnection
    public String getRequestProperty(String str) {
        return this.f76382a.H(str);
    }

    @Override // java.net.HttpURLConnection
    public int getResponseCode() throws IOException {
        return this.f76382a.I();
    }

    @Override // java.net.HttpURLConnection
    public String getResponseMessage() throws IOException {
        return this.f76382a.J();
    }

    @Override // java.net.URLConnection
    public URL getURL() {
        return this.f76382a.K();
    }

    @Override // java.net.URLConnection
    public boolean getUseCaches() {
        return this.f76382a.L();
    }

    public int hashCode() {
        return this.f76382a.hashCode();
    }

    @Override // java.net.URLConnection
    public void setAllowUserInteraction(boolean z11) {
        this.f76382a.M(z11);
    }

    @Override // java.net.HttpURLConnection
    public void setChunkedStreamingMode(int i11) {
        this.f76382a.N(i11);
    }

    @Override // java.net.URLConnection
    public void setConnectTimeout(int i11) {
        this.f76382a.O(i11);
    }

    @Override // java.net.URLConnection
    public void setDefaultUseCaches(boolean z11) {
        this.f76382a.P(z11);
    }

    @Override // java.net.URLConnection
    public void setDoInput(boolean z11) {
        this.f76382a.Q(z11);
    }

    @Override // java.net.URLConnection
    public void setDoOutput(boolean z11) {
        this.f76382a.R(z11);
    }

    @Override // java.net.HttpURLConnection
    public void setFixedLengthStreamingMode(int i11) {
        this.f76382a.S(i11);
    }

    @Override // java.net.HttpURLConnection
    public void setFixedLengthStreamingMode(long j11) {
        this.f76382a.T(j11);
    }

    @Override // java.net.URLConnection
    public void setIfModifiedSince(long j11) {
        this.f76382a.U(j11);
    }

    @Override // java.net.HttpURLConnection
    public void setInstanceFollowRedirects(boolean z11) {
        this.f76382a.V(z11);
    }

    @Override // java.net.URLConnection
    public void setReadTimeout(int i11) {
        this.f76382a.W(i11);
    }

    @Override // java.net.HttpURLConnection
    public void setRequestMethod(String str) throws ProtocolException {
        this.f76382a.X(str);
    }

    @Override // java.net.URLConnection
    public void setRequestProperty(String str, String str2) {
        this.f76382a.Y(str, str2);
    }

    @Override // java.net.URLConnection
    public void setUseCaches(boolean z11) {
        this.f76382a.Z(z11);
    }

    @Override // java.net.URLConnection
    public String toString() {
        return this.f76382a.toString();
    }

    @Override // java.net.HttpURLConnection
    public boolean usingProxy() {
        return this.f76382a.b0();
    }
}
