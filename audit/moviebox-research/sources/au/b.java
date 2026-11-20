package au;

import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static SSLSocketFactory f13778a;

    /* JADX INFO: compiled from: source.java */
    public class a implements X509TrustManager {
        public a(b bVar) {
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }

    public SSLSocketFactory a() {
        if (f13778a == null) {
            synchronized (this) {
                try {
                    if (f13778a == null) {
                        TrustManager[] trustManagerArr = {new a(this)};
                        try {
                            SSLContext sSLContext = SSLContext.getInstance("TLS");
                            sSLContext.init(null, trustManagerArr, null);
                            f13778a = sSLContext.getSocketFactory();
                        } catch (Throwable th2) {
                            zt.a.f82154a.e("SSL", th2.getMessage());
                        }
                    }
                } catch (Throwable th3) {
                    throw th3;
                }
            }
        }
        return f13778a;
    }
}
