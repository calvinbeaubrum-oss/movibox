package sl;

import com.google.firebase.perf.util.Timer;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ProtocolException;
import java.net.URL;
import java.security.Permission;
import java.security.Principal;
import java.security.cert.Certificate;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class d extends HttpsURLConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f76383a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HttpsURLConnection f76384b;

    public d(HttpsURLConnection httpsURLConnection, Timer timer, com.google.firebase.perf.metrics.j jVar) {
        super(httpsURLConnection.getURL());
        this.f76384b = httpsURLConnection;
        this.f76383a = new g(httpsURLConnection, timer, jVar);
    }

    @Override // java.net.URLConnection
    public void addRequestProperty(String str, String str2) {
        this.f76383a.a(str, str2);
    }

    @Override // java.net.URLConnection
    public void connect() throws IOException {
        this.f76383a.b();
    }

    @Override // java.net.HttpURLConnection
    public void disconnect() {
        this.f76383a.c();
    }

    public boolean equals(Object obj) {
        return this.f76383a.equals(obj);
    }

    @Override // java.net.URLConnection
    public boolean getAllowUserInteraction() {
        return this.f76383a.d();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public String getCipherSuite() {
        return this.f76384b.getCipherSuite();
    }

    @Override // java.net.URLConnection
    public int getConnectTimeout() {
        return this.f76383a.e();
    }

    @Override // java.net.URLConnection
    public Object getContent() throws IOException {
        return this.f76383a.f();
    }

    @Override // java.net.URLConnection
    public Object getContent(Class[] clsArr) throws IOException {
        return this.f76383a.g(clsArr);
    }

    @Override // java.net.URLConnection
    public String getContentEncoding() {
        return this.f76383a.h();
    }

    @Override // java.net.URLConnection
    public int getContentLength() {
        return this.f76383a.i();
    }

    @Override // java.net.URLConnection
    public long getContentLengthLong() {
        return this.f76383a.j();
    }

    @Override // java.net.URLConnection
    public String getContentType() {
        return this.f76383a.k();
    }

    @Override // java.net.URLConnection
    public long getDate() {
        return this.f76383a.l();
    }

    @Override // java.net.URLConnection
    public boolean getDefaultUseCaches() {
        return this.f76383a.m();
    }

    @Override // java.net.URLConnection
    public boolean getDoInput() {
        return this.f76383a.n();
    }

    @Override // java.net.URLConnection
    public boolean getDoOutput() {
        return this.f76383a.o();
    }

    @Override // java.net.HttpURLConnection
    public InputStream getErrorStream() {
        return this.f76383a.p();
    }

    @Override // java.net.URLConnection
    public long getExpiration() {
        return this.f76383a.q();
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public String getHeaderField(int i11) {
        return this.f76383a.r(i11);
    }

    @Override // java.net.URLConnection
    public String getHeaderField(String str) {
        return this.f76383a.s(str);
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public long getHeaderFieldDate(String str, long j11) {
        return this.f76383a.t(str, j11);
    }

    @Override // java.net.URLConnection
    public int getHeaderFieldInt(String str, int i11) {
        return this.f76383a.u(str, i11);
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public String getHeaderFieldKey(int i11) {
        return this.f76383a.v(i11);
    }

    @Override // java.net.URLConnection
    public long getHeaderFieldLong(String str, long j11) {
        return this.f76383a.w(str, j11);
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getHeaderFields() {
        return this.f76383a.x();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public HostnameVerifier getHostnameVerifier() {
        return this.f76384b.getHostnameVerifier();
    }

    @Override // java.net.URLConnection
    public long getIfModifiedSince() {
        return this.f76383a.y();
    }

    @Override // java.net.URLConnection
    public InputStream getInputStream() throws IOException {
        return this.f76383a.z();
    }

    @Override // java.net.HttpURLConnection
    public boolean getInstanceFollowRedirects() {
        return this.f76383a.A();
    }

    @Override // java.net.URLConnection
    public long getLastModified() {
        return this.f76383a.B();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Certificate[] getLocalCertificates() {
        return this.f76384b.getLocalCertificates();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Principal getLocalPrincipal() {
        return this.f76384b.getLocalPrincipal();
    }

    @Override // java.net.URLConnection
    public OutputStream getOutputStream() throws IOException {
        return this.f76383a.C();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
        return this.f76384b.getPeerPrincipal();
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public Permission getPermission() throws IOException {
        return this.f76383a.D();
    }

    @Override // java.net.URLConnection
    public int getReadTimeout() {
        return this.f76383a.E();
    }

    @Override // java.net.HttpURLConnection
    public String getRequestMethod() {
        return this.f76383a.F();
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getRequestProperties() {
        return this.f76383a.G();
    }

    @Override // java.net.URLConnection
    public String getRequestProperty(String str) {
        return this.f76383a.H(str);
    }

    @Override // java.net.HttpURLConnection
    public int getResponseCode() throws IOException {
        return this.f76383a.I();
    }

    @Override // java.net.HttpURLConnection
    public String getResponseMessage() throws IOException {
        return this.f76383a.J();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public SSLSocketFactory getSSLSocketFactory() {
        return this.f76384b.getSSLSocketFactory();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Certificate[] getServerCertificates() throws SSLPeerUnverifiedException {
        return this.f76384b.getServerCertificates();
    }

    @Override // java.net.URLConnection
    public URL getURL() {
        return this.f76383a.K();
    }

    @Override // java.net.URLConnection
    public boolean getUseCaches() {
        return this.f76383a.L();
    }

    public int hashCode() {
        return this.f76383a.hashCode();
    }

    @Override // java.net.URLConnection
    public void setAllowUserInteraction(boolean z11) {
        this.f76383a.M(z11);
    }

    @Override // java.net.HttpURLConnection
    public void setChunkedStreamingMode(int i11) {
        this.f76383a.N(i11);
    }

    @Override // java.net.URLConnection
    public void setConnectTimeout(int i11) {
        this.f76383a.O(i11);
    }

    @Override // java.net.URLConnection
    public void setDefaultUseCaches(boolean z11) {
        this.f76383a.P(z11);
    }

    @Override // java.net.URLConnection
    public void setDoInput(boolean z11) {
        this.f76383a.Q(z11);
    }

    @Override // java.net.URLConnection
    public void setDoOutput(boolean z11) {
        this.f76383a.R(z11);
    }

    @Override // java.net.HttpURLConnection
    public void setFixedLengthStreamingMode(int i11) {
        this.f76383a.S(i11);
    }

    @Override // java.net.HttpURLConnection
    public void setFixedLengthStreamingMode(long j11) {
        this.f76383a.T(j11);
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public void setHostnameVerifier(HostnameVerifier hostnameVerifier) {
        this.f76384b.setHostnameVerifier(hostnameVerifier);
    }

    @Override // java.net.URLConnection
    public void setIfModifiedSince(long j11) {
        this.f76383a.U(j11);
    }

    @Override // java.net.HttpURLConnection
    public void setInstanceFollowRedirects(boolean z11) {
        this.f76383a.V(z11);
    }

    @Override // java.net.URLConnection
    public void setReadTimeout(int i11) {
        this.f76383a.W(i11);
    }

    @Override // java.net.HttpURLConnection
    public void setRequestMethod(String str) throws ProtocolException {
        this.f76383a.X(str);
    }

    @Override // java.net.URLConnection
    public void setRequestProperty(String str, String str2) {
        this.f76383a.Y(str, str2);
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public void setSSLSocketFactory(SSLSocketFactory sSLSocketFactory) {
        this.f76384b.setSSLSocketFactory(sSLSocketFactory);
    }

    @Override // java.net.URLConnection
    public void setUseCaches(boolean z11) {
        this.f76383a.Z(z11);
    }

    @Override // java.net.URLConnection
    public String toString() {
        return this.f76383a.toString();
    }

    @Override // java.net.HttpURLConnection
    public boolean usingProxy() {
        return this.f76383a.b0();
    }
}
