package com.bykv.vk.openvk.sc.sc.pFF.pFF;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.util.SparseArray;
import com.bykv.vk.openvk.sc.sc.pFF.pFF.pFF.zY;
import com.cloud.hisavana.sdk.internal.agentpage.AgentPageJsBridge;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class TRI {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static volatile TRI f25920j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile ServerSocket f25921a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile int f25922b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicInteger f25923c = new AtomicInteger(0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile zY f25924d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile com.bykv.vk.openvk.sc.sc.pFF.pFF.sc.zY f25925e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final SparseArray<Set<qr>> f25926f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final qr.d f25927g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Runnable f25928h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AtomicBoolean f25929i;

    /* JADX INFO: compiled from: source.java */
    public class a implements qr.d {
        public a() {
        }

        @Override // com.bykv.vk.openvk.sc.sc.pFF.pFF.qr.d
        public void a(qr qrVar) {
            synchronized (TRI.this.f25926f) {
                try {
                    Set set = (Set) TRI.this.f25926f.get(qrVar.TRI());
                    if (set != null) {
                        set.add(qrVar);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // com.bykv.vk.openvk.sc.sc.pFF.pFF.qr.d
        public void b(qr qrVar) {
            if (com.bykv.vk.openvk.sc.sc.pFF.pFF.a.f25972c) {
                "afterExecute, ProxyTask: ".concat(String.valueOf(qrVar));
            }
            int iTRI = qrVar.TRI();
            synchronized (TRI.this.f25926f) {
                try {
                    Set set = (Set) TRI.this.f25926f.get(iTRI);
                    if (set != null) {
                        set.remove(qrVar);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b implements Callable<Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f25933a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f25934b;

        public b(String str, int i11) {
            this.f25933a = str;
            this.f25934b = i11;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean call() {
            Socket socket;
            Throwable th2;
            try {
                socket = new Socket(this.f25933a, this.f25934b);
                try {
                    socket.setSoTimeout(2000);
                    OutputStream outputStream = socket.getOutputStream();
                    outputStream.write("Ping\n".getBytes(p8.a.f73721b));
                    outputStream.flush();
                    if ("OK".equals(new BufferedReader(new InputStreamReader(socket.getInputStream())).readLine())) {
                        Boolean bool = Boolean.TRUE;
                        p8.a.v(socket);
                        return bool;
                    }
                } catch (Throwable th3) {
                    th2 = th3;
                    try {
                        th2.getMessage();
                        TRI.v("ping error", Log.getStackTraceString(th2));
                    } finally {
                        p8.a.v(socket);
                    }
                }
            } catch (Throwable th4) {
                socket = null;
                th2 = th4;
            }
            return Boolean.FALSE;
        }
    }

    public TRI() {
        SparseArray<Set<qr>> sparseArray = new SparseArray<>(2);
        this.f25926f = sparseArray;
        this.f25927g = new a();
        this.f25928h = new Runnable() { // from class: com.bykv.vk.openvk.sc.sc.pFF.pFF.TRI.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    int i11 = 0;
                    TRI.this.f25921a = new ServerSocket(0, 50, InetAddress.getByName(TRI.this.d()));
                    TRI tri = TRI.this;
                    tri.f25922b = tri.f25921a.getLocalPort();
                    if (TRI.this.f25922b == -1) {
                        TRI.v("socket not bound", "");
                        TRI.this.b();
                        return;
                    }
                    c.a(TRI.this.d(), TRI.this.f25922b);
                    if (TRI.this.n()) {
                        AtomicInteger unused = TRI.this.f25923c;
                        if (TRI.this.f25923c.compareAndSet(0, 1)) {
                            AtomicInteger unused2 = TRI.this.f25923c;
                            com.bykv.vk.openvk.sc.sc.pFF.pFF.sc.zY zYVar = com.bykv.vk.openvk.sc.sc.pFF.pFF.a.f25970a;
                            while (TRI.this.f25923c.get() == 1) {
                                try {
                                    try {
                                        Socket socketAccept = TRI.this.f25921a.accept();
                                        zY zYVar2 = TRI.this.f25924d;
                                        if (zYVar2 != null) {
                                            final qr qrVarD = new qr.c().a(zYVar2).c(socketAccept).b(TRI.this.f25927g).d();
                                            com.bytedance.sdk.component.Qj.TRI.zY().execute(new com.bytedance.sdk.component.Qj.Qj("ProxyTask", 10) { // from class: com.bykv.vk.openvk.sc.sc.pFF.pFF.TRI.2.1
                                                @Override // java.lang.Runnable
                                                public void run() {
                                                    qrVarD.run();
                                                }
                                            });
                                        } else {
                                            p8.a.v(socketAccept);
                                        }
                                    } catch (IOException e11) {
                                        TRI.v("accept error", Log.getStackTraceString(e11));
                                        i11++;
                                        if (i11 > 3) {
                                            com.bykv.vk.openvk.sc.sc.pFF.pFF.sc.zY zYVar3 = com.bykv.vk.openvk.sc.sc.pFF.pFF.a.f25970a;
                                            TRI.this.b();
                                        }
                                    }
                                } catch (Throwable th2) {
                                    String stackTraceString = Log.getStackTraceString(th2);
                                    Log.e("ProxyServer", "proxy server crashed!  ".concat(String.valueOf(stackTraceString)));
                                    TRI.v("error", stackTraceString);
                                }
                            }
                            com.bykv.vk.openvk.sc.sc.pFF.pFF.sc.zY zYVar4 = com.bykv.vk.openvk.sc.sc.pFF.pFF.a.f25970a;
                            TRI.this.b();
                        }
                    }
                } catch (IOException e12) {
                    if (com.bykv.vk.openvk.sc.sc.pFF.pFF.a.f25972c) {
                        Log.e("ProxyServer", "create ServerSocket error!  " + Log.getStackTraceString(e12));
                    }
                    TRI.v("create ServerSocket error", Log.getStackTraceString(e12));
                    TRI.this.b();
                }
            }
        };
        this.f25929i = new AtomicBoolean();
        sparseArray.put(0, new HashSet());
        sparseArray.put(1, new HashSet());
    }

    public static TRI q() {
        if (f25920j == null) {
            synchronized (TRI.class) {
                try {
                    if (f25920j == null) {
                        f25920j = new TRI();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f25920j;
    }

    public static /* synthetic */ void v(String str, String str2) {
    }

    public final void b() {
        if (this.f25923c.compareAndSet(1, 2) || this.f25923c.compareAndSet(0, 2)) {
            p8.a.u(this.f25921a);
            g();
        }
    }

    public final String d() {
        return new String(Base64.decode("MTI3LjAuMC4x".getBytes(), 0));
    }

    public final void f() {
        Socket socketAccept = null;
        try {
            socketAccept = this.f25921a.accept();
            socketAccept.setSoTimeout(2000);
            if ("Ping".equals(new BufferedReader(new InputStreamReader(socketAccept.getInputStream())).readLine())) {
                OutputStream outputStream = socketAccept.getOutputStream();
                outputStream.write("OK\n".getBytes(p8.a.f73721b));
                outputStream.flush();
            }
        } catch (IOException e11) {
            Log.getStackTraceString(e11);
        } finally {
            p8.a.v(socketAccept);
        }
    }

    public final void g() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.f25926f) {
            try {
                int size = this.f25926f.size();
                for (int i11 = 0; i11 < size; i11++) {
                    SparseArray<Set<qr>> sparseArray = this.f25926f;
                    Set<qr> set = sparseArray.get(sparseArray.keyAt(i11));
                    if (set != null) {
                        arrayList.addAll(set);
                        set.clear();
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((qr) it.next()).sc();
        }
    }

    public void j() {
        if (this.f25929i.compareAndSet(false, true)) {
            Thread thread = new Thread(this.f25928h);
            thread.setName("csj_proxy_server");
            thread.start();
        }
    }

    public d k() {
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean n() {
        com.bytedance.sdk.component.Qj.qr qrVar = new com.bytedance.sdk.component.Qj.qr(new b(d(), this.f25922b), 5, 1);
        com.bytedance.sdk.component.Qj.TRI.zY().submit(qrVar);
        f();
        try {
            if (((Boolean) qrVar.get()).booleanValue()) {
                com.bykv.vk.openvk.sc.sc.pFF.pFF.sc.zY zYVar = com.bykv.vk.openvk.sc.sc.pFF.pFF.a.f25970a;
                return true;
            }
            Log.e("ProxyServer", "Ping error");
            b();
            return false;
        } catch (Throwable th2) {
            Log.getStackTraceString(th2);
            b();
            return false;
        }
    }

    public String r(boolean z11, boolean z12, String str, String... strArr) {
        List<String> listP;
        String str2;
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        if (!TextUtils.isEmpty(str) && this.f25924d != null) {
            if ((z11 ? null : this.f25925e) != null && this.f25923c.get() == 1 && (listP = p8.a.p(strArr)) != null) {
                String strB = Ol.b(str, z12 ? str : v8.a.a(str), listP);
                if (strB == null) {
                    return strArr[0];
                }
                if (z11) {
                    str2 = AgentPageJsBridge.HTTPS + d() + ":" + this.f25922b + "?f=1&" + strB;
                } else {
                    str2 = AgentPageJsBridge.HTTPS + d() + ":" + this.f25922b + "?" + strB;
                }
                return str2.replaceFirst("s", "");
            }
            return strArr[0];
        }
        return strArr[0];
    }

    public void t(zY zYVar) {
        this.f25924d = zYVar;
    }

    public void u(com.bykv.vk.openvk.sc.sc.pFF.pFF.sc.zY zYVar) {
        this.f25925e = zYVar;
    }

    public boolean w(int i11, String str) {
        if (str == null) {
            return false;
        }
        synchronized (this.f25926f) {
            Set<qr> set = this.f25926f.get(i11);
            if (set != null) {
                for (qr qrVar : set) {
                    if (qrVar != null && str.equals(qrVar.Qj)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public d x() {
        return null;
    }
}
