package au;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static HostnameVerifier f13776a;

    /* JADX INFO: renamed from: au.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public class C0134a implements HostnameVerifier {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public HostnameVerifier f13777a = HttpsURLConnection.getDefaultHostnameVerifier();

        public C0134a(a aVar) {
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            return this.f13777a.verify(str, sSLSession);
        }
    }

    public HostnameVerifier a() {
        if (f13776a == null) {
            synchronized (this) {
                try {
                    if (f13776a == null) {
                        f13776a = new C0134a(this);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f13776a;
    }
}
