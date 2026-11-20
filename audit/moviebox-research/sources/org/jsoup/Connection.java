package org.jsoup;

import java.io.IOException;
import java.io.InputStream;
import java.net.Proxy;
import java.net.URL;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import javax.net.ssl.SSLSocketFactory;
import org.jsoup.nodes.Document;
import org.jsoup.parser.e;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public interface Connection {

    /* JADX INFO: compiled from: source.java */
    public enum Method {
        GET(false),
        POST(true),
        PUT(true),
        DELETE(false),
        PATCH(true),
        HEAD(false),
        OPTIONS(false),
        TRACE(false);

        private final boolean hasBody;

        Method(boolean z11) {
            this.hasBody = z11;
        }

        public final boolean hasBody() {
            return this.hasBody;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface a<T extends a> {
        URL f();

        T h(String str, String str2);

        Map<String, String> k();

        Method method();

        T n(String str);

        T p(URL url);

        T q(String str, String str2);

        T r(Method method);

        boolean s(String str);

        Map<String, List<String>> u();
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
        String a();

        boolean b();

        InputStream inputStream();

        String value();

        String z();
    }

    /* JADX INFO: compiled from: source.java */
    public interface c extends a<c> {
        c a(boolean z11);

        boolean b();

        String c();

        c d(String str);

        boolean e();

        SSLSocketFactory g();

        Proxy i();

        Collection<b> j();

        boolean l();

        c o(e eVar);

        boolean t();

        int timeout();

        String v();

        int w();

        e x();
    }

    /* JADX INFO: compiled from: source.java */
    public interface d extends a<d> {
        Document m() throws IOException;
    }

    Connection a(boolean z11);

    Connection b(String str);

    Document get() throws IOException;
}
