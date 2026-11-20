package com.danikula.videocache;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class HttpProxyCacheServer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f32329a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ExecutorService f32330b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, g> f32331c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ServerSocket f32332d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f32333e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Thread f32334f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public c f32335g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public k f32336h;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes4.dex */
    public final class SocketProcessorRunnable implements Runnable {
        private final d request;
        private final Socket socket;

        public SocketProcessorRunnable(Socket socket, d dVar) {
            this.socket = socket;
            this.request = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            HttpProxyCacheServer.this.n(this.socket, this.request);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class WaitRequestsRunnable implements Runnable {
        private final CountDownLatch startSignal;

        public WaitRequestsRunnable(CountDownLatch countDownLatch) {
            this.startSignal = countDownLatch;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.startSignal.countDown();
            HttpProxyCacheServer.this.p();
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes4.dex */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public File f32337a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ye.b f32338b = new ye.a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public com.danikula.videocache.a f32339c;

        public a(Context context) {
            this.f32337a = p.b(context);
        }

        public HttpProxyCacheServer a() {
            return new HttpProxyCacheServer(b());
        }

        public final c b() {
            return new c(this.f32337a, this.f32338b, this.f32339c);
        }

        public a c(File file) {
            this.f32337a = (File) l.c(file);
            return this;
        }

        public a d(com.danikula.videocache.a aVar) {
            this.f32339c = aVar;
            return this;
        }
    }

    public HttpProxyCacheServer(c cVar) {
        this.f32329a = new Object();
        this.f32330b = Executors.newFixedThreadPool(8);
        this.f32331c = new ConcurrentHashMap();
        this.f32335g = (c) l.c(cVar);
        try {
            ServerSocket serverSocket = new ServerSocket(0, 8, InetAddress.getByName("127.0.0.1"));
            this.f32332d = serverSocket;
            int localPort = serverSocket.getLocalPort();
            this.f32333e = localPort;
            i.a("127.0.0.1", localPort);
            CountDownLatch countDownLatch = new CountDownLatch(1);
            Thread thread = new Thread(new WaitRequestsRunnable(countDownLatch));
            this.f32334f = thread;
            thread.start();
            countDownLatch.await();
            this.f32336h = new k("127.0.0.1", this.f32333e);
            q.a("init success");
        } catch (Throwable unused) {
            this.f32330b.shutdown();
        }
    }

    public final String c(String str) {
        return String.format(Locale.US, "http://%s:%d/%s", "127.0.0.1", Integer.valueOf(this.f32333e), n.c(str));
    }

    public final void d(Socket socket) {
        try {
            if (socket.isClosed()) {
                return;
            }
            socket.close();
        } catch (IOException e11) {
            m(new ProxyCacheException("Error closing socket", e11));
        }
    }

    public final void e(Socket socket) {
        try {
            if (socket.isInputShutdown()) {
                return;
            }
            socket.shutdownInput();
        } catch (SocketException unused) {
            q.a("Releasing input stream… Socket is closed by client.");
        } catch (IOException e11) {
            m(new ProxyCacheException("Error closing socket input stream", e11));
        }
    }

    public final void f(Socket socket) {
        try {
            if (socket.isOutputShutdown()) {
                return;
            }
            socket.shutdownOutput();
        } catch (IOException unused) {
            q.f("Failed to close socket on proxy side: {}. It seems client have already closed connection.");
        }
    }

    public void g() {
        synchronized (this.f32329a) {
            try {
                Iterator<g> it = this.f32331c.values().iterator();
                while (it.hasNext()) {
                    it.next().a();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final g h(String str) throws ProxyCacheException {
        g gVar;
        synchronized (this.f32329a) {
            try {
                gVar = this.f32331c.get(str);
                if (gVar == null) {
                    gVar = new g(str, this.f32335g);
                    this.f32331c.put(str, gVar);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return gVar;
    }

    public final int i() {
        int iB;
        synchronized (this.f32329a) {
            try {
                Iterator<g> it = this.f32331c.values().iterator();
                iB = 0;
                while (it.hasNext()) {
                    iB += it.next().b();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return iB;
    }

    public String j(String str, String str2, boolean z11) {
        return k(str, str2, false, z11);
    }

    public String k(String str, String str2, boolean z11, boolean z12) {
        return (!z12 || l()) ? c(str) : str;
    }

    public final boolean l() {
        return this.f32336h.e(3, 70);
    }

    public final void m(Throwable th2) {
        q.b("HttpProxyCacheServer error");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.danikula.videocache.HttpProxyCacheServer] */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.net.Socket] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.net.Socket] */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r6v9, types: [java.lang.StringBuilder] */
    public final void n(Socket socket, d dVar) {
        g gVarH = null;
        try {
            try {
                String strB = n.b(dVar.f32345a);
                q.a("Request to cache proxy， " + Thread.currentThread().getName() + "， " + dVar + ", url = " + strB);
                if (this.f32336h.d(strB)) {
                    this.f32336h.g(socket);
                } else {
                    gVarH = h(strB);
                    gVarH.d(dVar, socket);
                }
                o(socket);
                if (gVarH != null) {
                    gVarH.f();
                }
                socket = new StringBuilder();
            } catch (Throwable th2) {
                o(socket);
                if (0 != 0) {
                    gVarH.f();
                }
                q.a("Opened connections: " + i());
                throw th2;
            }
        } catch (SocketException unused) {
            q.a("Closing socket… Socket is closed by client.");
            o(socket);
            if (0 != 0) {
                gVarH.f();
            }
            socket = new StringBuilder();
        } catch (Throwable th3) {
            m(new ProxyCacheException("Error processing request", th3));
            o(socket);
            if (0 != 0) {
                gVarH.f();
            }
            socket = new StringBuilder();
        }
        socket.append("Opened connections: ");
        socket.append(i());
        q.a(socket.toString());
    }

    public final void o(Socket socket) {
        e(socket);
        f(socket);
        d(socket);
    }

    public final void p() {
        try {
            q.a("waitForRequest~ isInterrupted = " + Thread.currentThread().isInterrupted());
            while (!Thread.currentThread().isInterrupted()) {
                Socket socketAccept = this.f32332d.accept();
                q.c("Accept new socket " + socketAccept);
                d dVarC = d.c(socketAccept.getInputStream());
                String strB = n.b(dVarC.f32345a);
                g gVar = this.f32331c.get(strB);
                if (gVar != null) {
                    gVar.f();
                }
                if (!this.f32336h.d(strB)) {
                    com.transsnet.downloader.util.e.f61155a.b("3");
                }
                this.f32330b.submit(new SocketProcessorRunnable(socketAccept, dVarC));
            }
        } catch (Throwable th2) {
            q.c("waitForRequest error = " + th2.toString());
            m(new ProxyCacheException("Error during waiting connection", th2));
        }
    }
}
