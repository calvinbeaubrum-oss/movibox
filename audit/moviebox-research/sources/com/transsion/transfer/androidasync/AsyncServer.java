package com.transsion.transfer.androidasync;

import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.channels.CancelledKeyException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.ClosedSelectorException;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class AsyncServer {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static AsyncServer f58449g = new AsyncServer();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static ExecutorService f58450h = A("AsyncServer-worker-");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Comparator<InetAddress> f58451i = new Comparator<InetAddress>() { // from class: com.transsion.transfer.androidasync.AsyncServer.5
        @Override // java.util.Comparator
        public int compare(InetAddress inetAddress, InetAddress inetAddress2) {
            boolean z11 = inetAddress instanceof Inet4Address;
            if (z11 && (inetAddress2 instanceof Inet4Address)) {
                return 0;
            }
            if ((inetAddress instanceof Inet6Address) && (inetAddress2 instanceof Inet6Address)) {
                return 0;
            }
            return (z11 && (inetAddress2 instanceof Inet6Address)) ? -1 : 1;
        }
    };

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static ExecutorService f58452j = A("AsyncServer-resolver-");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final ThreadLocal<AsyncServer> f58453k = new ThreadLocal<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public z f58454a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f58455b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f58456c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f58457d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public PriorityQueue<Scheduled> f58458e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Thread f58459f;

    /* JADX INFO: renamed from: com.transsion.transfer.androidasync.AsyncServer$7, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    class AnonymousClass7 implements Runnable {
        final /* synthetic */ com.transsion.transfer.androidasync.a val$handler;
        final /* synthetic */ String val$host;
        final /* synthetic */ int val$port;
        final /* synthetic */ DatagramChannel val$socket;

        public AnonymousClass7(String str, int i11, com.transsion.transfer.androidasync.a aVar, DatagramChannel datagramChannel) {
            this.val$host = str;
            this.val$port = i11;
            this.val$socket = datagramChannel;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                InetSocketAddress inetSocketAddress = new InetSocketAddress(this.val$host, this.val$port);
                AsyncServer.this.s(null);
                this.val$socket.connect(inetSocketAddress);
            } catch (IOException e11) {
                Log.e("NIO", "Datagram error", e11);
                com.transsion.transfer.androidasync.util.e.a(this.val$socket);
            }
        }
    }

    /* JADX INFO: renamed from: com.transsion.transfer.androidasync.AsyncServer$9, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    class AnonymousClass9 implements Runnable {
        public AnonymousClass9() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (AsyncServer.this.f58454a == null) {
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Key Count: ");
            sb2.append(AsyncServer.this.f58454a.b().size());
            for (SelectionKey selectionKey : AsyncServer.this.f58454a.b()) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Key: ");
                sb3.append(selectionKey);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class AsyncSelectorException extends IOException {
        public AsyncSelectorException(Exception exc) {
            super(exc);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class RunnableWrapper implements Runnable {
        Handler handler;
        boolean hasRun;
        Runnable runnable;
        ThreadQueue threadQueue;

        private RunnableWrapper() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            synchronized (this) {
                try {
                    if (this.hasRun) {
                        return;
                    }
                    this.hasRun = true;
                    try {
                        this.runnable.run();
                    } finally {
                        this.threadQueue.remove(this);
                        this.handler.removeCallbacks(this);
                        this.threadQueue = null;
                        this.handler = null;
                        this.runnable = null;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class Scheduled implements com.transsion.transfer.androidasync.future.a, Runnable {
        boolean cancelled;
        public Runnable runnable;
        public AsyncServer server;
        public long time;

        public Scheduled(AsyncServer asyncServer, Runnable runnable, long j11) {
            this.server = asyncServer;
            this.runnable = runnable;
            this.time = j11;
        }

        @Override // com.transsion.transfer.androidasync.future.a
        public boolean cancel() {
            boolean zRemove;
            synchronized (this.server) {
                zRemove = this.server.f58458e.remove(this);
                this.cancelled = zRemove;
            }
            return zRemove;
        }

        @Override // com.transsion.transfer.androidasync.future.a
        public boolean isCancelled() {
            return this.cancelled;
        }

        public boolean isDone() {
            boolean z11;
            synchronized (this.server) {
                try {
                    z11 = (this.cancelled || this.server.f58458e.contains(this)) ? false : true;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return z11;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.runnable.run();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class Scheduler implements Comparator<Scheduled> {
        public static Scheduler INSTANCE = new Scheduler();

        private Scheduler() {
        }

        @Override // java.util.Comparator
        public int compare(Scheduled scheduled, Scheduled scheduled2) {
            long j11 = scheduled.time;
            long j12 = scheduled2.time;
            if (j11 == j12) {
                return 0;
            }
            return j11 > j12 ? 1 : -1;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class a implements com.transsion.transfer.androidasync.future.g<InetAddress> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ fy.b f58464a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.transsion.transfer.androidasync.future.w f58465b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ InetSocketAddress f58466c;

        public a(fy.b bVar, com.transsion.transfer.androidasync.future.w wVar, InetSocketAddress inetSocketAddress) {
            this.f58464a = bVar;
            this.f58465b = wVar;
            this.f58466c = inetSocketAddress;
        }

        @Override // com.transsion.transfer.androidasync.future.g
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Exception exc, InetAddress inetAddress) {
            if (exc == null) {
                this.f58465b.E((b) AsyncServer.this.l(new InetSocketAddress(inetAddress, this.f58466c.getPort()), this.f58464a));
            } else {
                this.f58464a.a(exc, null);
                this.f58465b.G(exc);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends com.transsion.transfer.androidasync.future.w<AsyncNetworkSocket> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public SocketChannel f58468g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public fy.b f58469h;

        public b() {
        }

        @Override // com.transsion.transfer.androidasync.future.n
        public void cancelCleanup() {
            super.cancelCleanup();
            try {
                SocketChannel socketChannel = this.f58468g;
                if (socketChannel != null) {
                    socketChannel.close();
                }
            } catch (IOException unused) {
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ThreadGroup f58471a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicInteger f58472b = new AtomicInteger(1);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f58473c;

        public c(String str) {
            SecurityManager securityManager = System.getSecurityManager();
            this.f58471a = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
            this.f58473c = str;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(this.f58471a, runnable, this.f58473c + this.f58472b.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 5) {
                thread.setPriority(5);
            }
            return thread;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class d<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public T f58474a;

        public d() {
        }
    }

    public AsyncServer() {
        this(null);
    }

    public AsyncServer(String str) {
        this.f58457d = 0;
        this.f58458e = new PriorityQueue<>(1, Scheduler.INSTANCE);
        this.f58455b = str == null ? "AsyncServer" : str;
    }

    public static ExecutorService A(String str) {
        return new ThreadPoolExecutor(0, 4, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new c(str));
    }

    public static void G(AsyncServer asyncServer, z zVar, PriorityQueue<Scheduled> priorityQueue) {
        while (true) {
            try {
                I(asyncServer, zVar, priorityQueue);
            } catch (AsyncSelectorException e11) {
                boolean z11 = e11.getCause() instanceof ClosedSelectorException;
                com.transsion.transfer.androidasync.util.e.a(zVar);
            }
            synchronized (asyncServer) {
                try {
                    if (!zVar.isOpen() || (zVar.b().size() <= 0 && priorityQueue.size() <= 0)) {
                        break;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        J(zVar);
        if (asyncServer.f58454a == zVar) {
            asyncServer.f58458e = new PriorityQueue<>(1, Scheduler.INSTANCE);
            asyncServer.f58454a = null;
            asyncServer.f58459f = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v18, types: [fy.b] */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.nio.channels.SelectionKey] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.nio.channels.SelectionKey] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7, types: [fy.f] */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.nio.channels.SelectionKey] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r6v4, types: [com.transsion.transfer.androidasync.AsyncNetworkSocket, com.transsion.transfer.androidasync.l, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v4, types: [com.transsion.transfer.androidasync.AsyncNetworkSocket, com.transsion.transfer.androidasync.l, java.lang.Object] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static void I(AsyncServer asyncServer, z zVar, PriorityQueue<Scheduled> priorityQueue) throws AsyncSelectorException {
        boolean z11;
        ?? r11;
        long jZ = z(asyncServer, priorityQueue);
        try {
            synchronized (asyncServer) {
                try {
                    if (zVar.e() != 0) {
                        z11 = false;
                    } else if (zVar.b().size() == 0 && jZ == Long.MAX_VALUE) {
                        return;
                    } else {
                        z11 = true;
                    }
                    if (z11) {
                        if (jZ == Long.MAX_VALUE) {
                            zVar.c();
                        } else {
                            zVar.d(jZ);
                        }
                    }
                    Set<SelectionKey> setG = zVar.g();
                    for (SelectionKey selectionKey : setG) {
                        try {
                            SocketChannel socketChannel = null;
                            ?? Register = 0;
                            if (selectionKey.isAcceptable()) {
                                try {
                                    SocketChannel socketChannelAccept = ((ServerSocketChannel) selectionKey.channel()).accept();
                                    if (socketChannelAccept != null) {
                                        try {
                                            socketChannelAccept.configureBlocking(false);
                                            socketChannelAccept.socket().setKeepAlive(true);
                                            socketChannelAccept.socket().setTcpNoDelay(true);
                                            socketChannelAccept.socket().setSoLinger(true, 0);
                                            Register = socketChannelAccept.register(zVar.a(), 1);
                                            ?? r12 = (fy.f) selectionKey.attachment();
                                            ?? asyncNetworkSocket = new AsyncNetworkSocket();
                                            asyncNetworkSocket.c(socketChannelAccept, (InetSocketAddress) socketChannelAccept.socket().getRemoteSocketAddress());
                                            asyncNetworkSocket.B(asyncServer, Register);
                                            Register.attach(asyncNetworkSocket);
                                            r12.t(asyncNetworkSocket);
                                        } catch (IOException unused) {
                                            r11 = Register;
                                            socketChannel = socketChannelAccept;
                                            com.transsion.transfer.androidasync.util.e.a(socketChannel);
                                            if (r11 != 0) {
                                                r11.cancel();
                                            }
                                        }
                                    }
                                } catch (IOException unused2) {
                                    r11 = 0;
                                }
                            } else if (selectionKey.isReadable()) {
                                asyncServer.B(((AsyncNetworkSocket) selectionKey.attachment()).q());
                            } else if (selectionKey.isWritable()) {
                                ((AsyncNetworkSocket) selectionKey.attachment()).n();
                            } else {
                                if (!selectionKey.isConnectable()) {
                                    throw new RuntimeException("Unknown key state.");
                                }
                                b bVar = (b) selectionKey.attachment();
                                SocketChannel socketChannel2 = (SocketChannel) selectionKey.channel();
                                selectionKey.interestOps(1);
                                try {
                                    socketChannel2.finishConnect();
                                    ?? asyncNetworkSocket2 = new AsyncNetworkSocket();
                                    asyncNetworkSocket2.B(asyncServer, selectionKey);
                                    asyncNetworkSocket2.c(socketChannel2, (InetSocketAddress) socketChannel2.socket().getRemoteSocketAddress());
                                    selectionKey.attach(asyncNetworkSocket2);
                                    if (bVar.J(asyncNetworkSocket2)) {
                                        bVar.f58469h.a(null, asyncNetworkSocket2);
                                    }
                                } catch (IOException e11) {
                                    selectionKey.cancel();
                                    com.transsion.transfer.androidasync.util.e.a(socketChannel2);
                                    if (bVar.G(e11)) {
                                        bVar.f58469h.a(e11, null);
                                    }
                                }
                            }
                        } catch (CancelledKeyException unused3) {
                        }
                    }
                    setG.clear();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        } catch (Exception e12) {
            throw new AsyncSelectorException(e12);
        }
    }

    public static void J(z zVar) {
        K(zVar);
        com.transsion.transfer.androidasync.util.e.a(zVar);
    }

    public static void K(z zVar) {
        try {
            for (SelectionKey selectionKey : zVar.b()) {
                com.transsion.transfer.androidasync.util.e.a(selectionKey.channel());
                try {
                    selectionKey.cancel();
                } catch (Exception unused) {
                }
            }
        } catch (Exception unused2) {
        }
    }

    public static void N(final z zVar) {
        f58450h.execute(new Runnable() { // from class: com.transsion.transfer.androidasync.g
            @Override // java.lang.Runnable
            public final void run() {
                AsyncServer.x(zVar);
            }
        });
    }

    public static AsyncServer r() {
        return f58449g;
    }

    public static /* synthetic */ InetAddress u(InetAddress[] inetAddressArr) throws Exception {
        return inetAddressArr[0];
    }

    public static /* synthetic */ void v(Runnable runnable, Semaphore semaphore) {
        runnable.run();
        semaphore.release();
    }

    public static /* synthetic */ void w(z zVar) {
        try {
            zVar.i();
        } catch (Exception unused) {
        }
    }

    public static /* synthetic */ void x(z zVar) {
        try {
            zVar.i();
        } catch (Exception unused) {
        }
    }

    public static long z(AsyncServer asyncServer, PriorityQueue<Scheduled> priorityQueue) {
        Scheduled scheduled;
        long j11 = Long.MAX_VALUE;
        while (true) {
            synchronized (asyncServer) {
                try {
                    long jElapsedRealtime = SystemClock.elapsedRealtime();
                    scheduled = null;
                    if (priorityQueue.size() > 0) {
                        Scheduled scheduledRemove = priorityQueue.remove();
                        long j12 = scheduledRemove.time;
                        if (j12 <= jElapsedRealtime) {
                            scheduled = scheduledRemove;
                        } else {
                            priorityQueue.add(scheduledRemove);
                            j11 = j12 - jElapsedRealtime;
                        }
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            if (scheduled == null) {
                asyncServer.f58457d = 0;
                return j11;
            }
            scheduled.run();
        }
    }

    public void B(int i11) {
    }

    public void C(int i11) {
    }

    public com.transsion.transfer.androidasync.future.a D(Runnable runnable) {
        return E(runnable, 0L);
    }

    public com.transsion.transfer.androidasync.future.a E(Runnable runnable, long j11) {
        synchronized (this) {
            try {
                if (this.f58456c) {
                    return com.transsion.transfer.androidasync.future.n.CANCELLED;
                }
                long jMin = 0;
                if (j11 > 0) {
                    jMin = SystemClock.elapsedRealtime() + j11;
                } else if (j11 == 0) {
                    int i11 = this.f58457d;
                    this.f58457d = i11 + 1;
                    jMin = i11;
                } else if (this.f58458e.size() > 0) {
                    jMin = Math.min(0L, this.f58458e.peek().time - 1);
                }
                PriorityQueue<Scheduled> priorityQueue = this.f58458e;
                Scheduled scheduled = new Scheduled(this, runnable, jMin);
                priorityQueue.add(scheduled);
                if (this.f58454a == null) {
                    F();
                }
                if (!t()) {
                    N(this.f58454a);
                }
                return scheduled;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void F() {
        synchronized (this) {
            try {
                z zVar = this.f58454a;
                if (zVar != null) {
                    PriorityQueue<Scheduled> priorityQueue = this.f58458e;
                    try {
                        try {
                            I(this, zVar, priorityQueue);
                            return;
                        } catch (Exception unused) {
                            return;
                        }
                    } catch (AsyncSelectorException unused2) {
                        zVar.a().close();
                        return;
                    }
                }
                try {
                    final z zVar2 = new z(SelectorProvider.provider().openSelector());
                    this.f58454a = zVar2;
                    final PriorityQueue<Scheduled> priorityQueue2 = this.f58458e;
                    Thread thread = new Thread(this.f58455b) { // from class: com.transsion.transfer.androidasync.AsyncServer.8
                        @Override // java.lang.Thread, java.lang.Runnable
                        public void run() {
                            try {
                                AsyncServer.f58453k.set(AsyncServer.this);
                                AsyncServer.G(AsyncServer.this, zVar2, priorityQueue2);
                            } finally {
                                AsyncServer.f58453k.remove();
                            }
                        }
                    };
                    this.f58459f = thread;
                    thread.start();
                } catch (IOException e11) {
                    throw new RuntimeException("unable to create selector?", e11);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void H(final Runnable runnable) {
        if (Thread.currentThread() == this.f58459f) {
            D(runnable);
            z(this, this.f58458e);
            return;
        }
        synchronized (this) {
            try {
                if (this.f58456c) {
                    return;
                }
                final Semaphore semaphore = new Semaphore(0);
                D(new Runnable() { // from class: com.transsion.transfer.androidasync.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        AsyncServer.v(runnable, semaphore);
                    }
                });
                try {
                    semaphore.acquire();
                } catch (InterruptedException e11) {
                    Log.e("NIO", "run", e11);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void L() {
        M(false);
    }

    public void M(boolean z11) {
        synchronized (this) {
            try {
                boolean zT = t();
                final z zVar = this.f58454a;
                if (zVar == null) {
                    return;
                }
                final Semaphore semaphore = new Semaphore(0);
                this.f58458e.add(new Scheduled(this, new Runnable() { // from class: com.transsion.transfer.androidasync.AsyncServer.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AsyncServer.J(zVar);
                        semaphore.release();
                    }
                }, 0L));
                f58450h.execute(new Runnable() { // from class: com.transsion.transfer.androidasync.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        AsyncServer.w(zVar);
                    }
                });
                K(zVar);
                this.f58458e = new PriorityQueue<>(1, Scheduler.INSTANCE);
                this.f58454a = null;
                this.f58459f = null;
                if (zT || !z11) {
                    return;
                }
                try {
                    semaphore.acquire();
                } catch (Exception unused) {
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public b k(InetSocketAddress inetSocketAddress, fy.b bVar, fy.h hVar) {
        b bVar2 = new b();
        D(new Runnable(bVar2, bVar, hVar, inetSocketAddress) { // from class: com.transsion.transfer.androidasync.AsyncServer.3
            final /* synthetic */ InetSocketAddress val$address;
            final /* synthetic */ fy.b val$callback;
            final /* synthetic */ b val$cancel;
            final /* synthetic */ fy.h val$createCallback;

            {
                this.val$address = inetSocketAddress;
            }

            @Override // java.lang.Runnable
            public void run() {
                SocketChannel socketChannelOpen;
                if (this.val$cancel.isCancelled()) {
                    return;
                }
                b bVar3 = this.val$cancel;
                bVar3.f58469h = this.val$callback;
                SelectionKey selectionKeyRegister = null;
                try {
                    socketChannelOpen = SocketChannel.open();
                    bVar3.f58468g = socketChannelOpen;
                    try {
                        socketChannelOpen.configureBlocking(false);
                        selectionKeyRegister = socketChannelOpen.register(AsyncServer.this.f58454a.a(), 8);
                        selectionKeyRegister.attach(this.val$cancel);
                        socketChannelOpen.connect(this.val$address);
                    } catch (Throwable th2) {
                        th = th2;
                        if (selectionKeyRegister != null) {
                            selectionKeyRegister.cancel();
                        }
                        com.transsion.transfer.androidasync.util.e.a(socketChannelOpen);
                        this.val$cancel.G(new RuntimeException(th));
                    }
                } catch (Throwable th3) {
                    th = th3;
                    socketChannelOpen = null;
                }
            }
        });
        return bVar2;
    }

    public com.transsion.transfer.androidasync.future.a l(InetSocketAddress inetSocketAddress, fy.b bVar) {
        return k(inetSocketAddress, bVar, null);
    }

    public com.transsion.transfer.androidasync.future.a m(String str, int i11, fy.b bVar) {
        return n(InetSocketAddress.createUnresolved(str, i11), bVar);
    }

    public com.transsion.transfer.androidasync.future.a n(InetSocketAddress inetSocketAddress, fy.b bVar) {
        if (!inetSocketAddress.isUnresolved()) {
            return l(inetSocketAddress, bVar);
        }
        com.transsion.transfer.androidasync.future.w wVar = new com.transsion.transfer.androidasync.future.w();
        com.transsion.transfer.androidasync.future.f<InetAddress> fVarQ = q(inetSocketAddress.getHostName());
        wVar.setParent(fVarQ);
        fVarQ.j(new a(bVar, wVar, inetSocketAddress));
        return wVar;
    }

    public Thread o() {
        return this.f58459f;
    }

    public com.transsion.transfer.androidasync.future.f<InetAddress[]> p(final String str) {
        final com.transsion.transfer.androidasync.future.w wVar = new com.transsion.transfer.androidasync.future.w();
        f58452j.execute(new Runnable() { // from class: com.transsion.transfer.androidasync.AsyncServer.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    final InetAddress[] allByName = InetAddress.getAllByName(str);
                    Arrays.sort(allByName, AsyncServer.f58451i);
                    if (allByName == null || allByName.length == 0) {
                        throw new HostnameResolutionException("no addresses for host");
                    }
                    AsyncServer.this.D(new Runnable() { // from class: com.transsion.transfer.androidasync.AsyncServer.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            wVar.H(null, allByName);
                        }
                    });
                } catch (Exception e11) {
                    AsyncServer.this.D(new Runnable() { // from class: com.transsion.transfer.androidasync.AsyncServer.6.2
                        @Override // java.lang.Runnable
                        public void run() {
                            wVar.H(e11, null);
                        }
                    });
                }
            }
        });
        return wVar;
    }

    public com.transsion.transfer.androidasync.future.f<InetAddress> q(String str) {
        return p(str).r(new com.transsion.transfer.androidasync.future.y() { // from class: com.transsion.transfer.androidasync.h
            @Override // com.transsion.transfer.androidasync.future.y
            public final Object then(Object obj) {
                return AsyncServer.u((InetAddress[]) obj);
            }
        });
    }

    public final void s(AsyncNetworkSocket asyncNetworkSocket) throws ClosedChannelException {
        SelectionKey selectionKeyC = asyncNetworkSocket.i().c(this.f58454a.a());
        selectionKeyC.attach(asyncNetworkSocket);
        asyncNetworkSocket.B(this, selectionKeyC);
    }

    public boolean t() {
        return this.f58459f == Thread.currentThread();
    }

    public k y(final InetAddress inetAddress, final int i11, final fy.f fVar) {
        final d dVar = new d();
        H(new Runnable() { // from class: com.transsion.transfer.androidasync.AsyncServer.2

            /* JADX INFO: renamed from: com.transsion.transfer.androidasync.AsyncServer$2$a */
            /* JADX INFO: compiled from: source.java */
            public class a implements k {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ ServerSocketChannel f58460a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ a0 f58461b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                public final /* synthetic */ SelectionKey f58462c;

                public a(ServerSocketChannel serverSocketChannel, a0 a0Var, SelectionKey selectionKey) {
                    this.f58460a = serverSocketChannel;
                    this.f58461b = a0Var;
                    this.f58462c = selectionKey;
                }

                @Override // com.transsion.transfer.androidasync.k
                public void stop() {
                    com.transsion.transfer.androidasync.util.e.a(this.f58461b);
                    try {
                        this.f58462c.cancel();
                    } catch (Exception unused) {
                    }
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r5v0, types: [T, com.transsion.transfer.androidasync.AsyncServer$2$a, com.transsion.transfer.androidasync.k] */
            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // java.lang.Runnable
            public void run() {
                a0 a0Var;
                IOException e11;
                ServerSocketChannel serverSocketChannelOpen;
                try {
                    serverSocketChannelOpen = ServerSocketChannel.open();
                    try {
                        a0Var = new a0(serverSocketChannelOpen);
                        try {
                            serverSocketChannelOpen.socket().bind(inetAddress == null ? new InetSocketAddress(i11) : new InetSocketAddress(inetAddress, i11));
                            SelectionKey selectionKeyC = a0Var.c(AsyncServer.this.f58454a.a());
                            selectionKeyC.attach(fVar);
                            fy.f fVar2 = fVar;
                            d dVar2 = dVar;
                            ?? aVar = new a(serverSocketChannelOpen, a0Var, selectionKeyC);
                            dVar2.f58474a = aVar;
                            fVar2.q(aVar);
                        } catch (IOException e12) {
                            e11 = e12;
                            Log.e("NIO", "wtf", e11);
                            com.transsion.transfer.androidasync.util.e.a(a0Var, serverSocketChannelOpen);
                            fVar.i(e11);
                        }
                    } catch (IOException e13) {
                        a0Var = null;
                        e11 = e13;
                    }
                } catch (IOException e14) {
                    a0Var = null;
                    e11 = e14;
                    serverSocketChannelOpen = null;
                }
            }
        });
        return (k) dVar.f58474a;
    }
}
