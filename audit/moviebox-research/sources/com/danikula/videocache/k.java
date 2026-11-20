package com.danikula.videocache;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ExecutorService f32366a = Executors.newSingleThreadExecutor();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f32367b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f32368c;

    /* JADX INFO: compiled from: source.java */
    public class a implements Callable<Boolean> {
        public a() {
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean call() throws Exception {
            return Boolean.valueOf(k.this.f());
        }
    }

    public k(String str, int i11) {
        this.f32367b = (String) l.c(str);
        this.f32368c = i11;
    }

    public final List<Proxy> b() {
        try {
            return ProxySelector.getDefault().select(new URI(c()));
        } catch (URISyntaxException e11) {
            throw new IllegalStateException(e11);
        }
    }

    public final String c() {
        return String.format(Locale.US, "http://%s:%d/%s", this.f32367b, Integer.valueOf(this.f32368c), "ping");
    }

    public boolean d(String str) {
        return "ping".equals(str);
    }

    public boolean e(int i11, int i12) {
        l.a(i11 >= 1);
        l.a(i12 > 0);
        int i13 = 0;
        while (i13 < i11) {
            try {
                if (((Boolean) this.f32366a.submit(new a()).get(i12, TimeUnit.MILLISECONDS)).booleanValue()) {
                    return true;
                }
                i13++;
                i12 *= 2;
            } catch (InterruptedException | ExecutionException unused) {
                q.b("Error pinging server due to unexpected error");
            } catch (TimeoutException unused2) {
                q.f("Error pinging server (attempt: " + i13 + ", timeout: " + i12 + "). ");
            }
        }
        q.b(String.format(Locale.US, "Error pinging server (attempts: %d, max timeout: %d). If you see this message, please, report at https://github.com/danikula/AndroidVideoCache/issues/134. Default proxies are: %s", Integer.valueOf(i13), Integer.valueOf(i12 / 2), b()));
        return false;
    }

    public final boolean f() throws ProxyCacheException {
        h hVar = new h(c());
        try {
            byte[] bytes = "ping ok".getBytes();
            hVar.d(0L);
            byte[] bArr = new byte[bytes.length];
            hVar.f(bArr);
            boolean zEquals = Arrays.equals(bytes, bArr);
            q.c("Ping response: `" + new String(bArr) + "`, pinged? " + zEquals);
            return zEquals;
        } catch (ProxyCacheException unused) {
            q.b("Error reading ping response");
            return false;
        } finally {
            hVar.a();
        }
    }

    public void g(Socket socket) throws IOException {
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("HTTP/1.1 200 OK\n\n".getBytes());
        outputStream.write("ping ok".getBytes());
    }
}
