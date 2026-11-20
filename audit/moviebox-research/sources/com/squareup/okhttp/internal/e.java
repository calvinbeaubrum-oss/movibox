package com.squareup.okhttp.internal;

import com.squareup.okhttp.Protocol;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.net.ssl.SSLSocket;
import okio.Buffer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f49073a = e();

    /* JADX INFO: compiled from: source.java */
    public static class a extends e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final d<Socket> f49074b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final d<Socket> f49075c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Method f49076d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Method f49077e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final d<Socket> f49078f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final d<Socket> f49079g;

        public a(d<Socket> dVar, d<Socket> dVar2, Method method, Method method2, d<Socket> dVar3, d<Socket> dVar4) {
            this.f49074b = dVar;
            this.f49075c = dVar2;
            this.f49076d = method;
            this.f49077e = method2;
            this.f49078f = dVar3;
            this.f49079g = dVar4;
        }

        @Override // com.squareup.okhttp.internal.e
        public void c(SSLSocket sSLSocket, String str, List<Protocol> list) {
            if (str != null) {
                this.f49074b.e(sSLSocket, Boolean.TRUE);
                this.f49075c.e(sSLSocket, str);
            }
            d<Socket> dVar = this.f49079g;
            if (dVar == null || !dVar.g(sSLSocket)) {
                return;
            }
            this.f49079g.f(sSLSocket, e.b(list));
        }

        @Override // com.squareup.okhttp.internal.e
        public void d(Socket socket, InetSocketAddress inetSocketAddress, int i11) throws IOException {
            try {
                socket.connect(inetSocketAddress, i11);
            } catch (AssertionError e11) {
                if (!g.o(e11)) {
                    throw e11;
                }
                throw new IOException(e11);
            } catch (SecurityException e12) {
                IOException iOException = new IOException("Exception in connect");
                iOException.initCause(e12);
                throw iOException;
            }
        }

        @Override // com.squareup.okhttp.internal.e
        public String h(SSLSocket sSLSocket) {
            byte[] bArr;
            d<Socket> dVar = this.f49078f;
            if (dVar == null || !dVar.g(sSLSocket) || (bArr = (byte[]) this.f49078f.f(sSLSocket, new Object[0])) == null) {
                return null;
            }
            return new String(bArr, g.f49216c);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b extends e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Method f49080b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Method f49081c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Method f49082d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Class<?> f49083e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Class<?> f49084f;

        public b(Method method, Method method2, Method method3, Class<?> cls, Class<?> cls2) {
            this.f49080b = method;
            this.f49081c = method2;
            this.f49082d = method3;
            this.f49083e = cls;
            this.f49084f = cls2;
        }

        @Override // com.squareup.okhttp.internal.e
        public void a(SSLSocket sSLSocket) {
            try {
                this.f49082d.invoke(null, sSLSocket);
            } catch (IllegalAccessException | InvocationTargetException unused) {
                throw new AssertionError();
            }
        }

        @Override // com.squareup.okhttp.internal.e
        public void c(SSLSocket sSLSocket, String str, List<Protocol> list) {
            ArrayList arrayList = new ArrayList(list.size());
            int size = list.size();
            for (int i11 = 0; i11 < size; i11++) {
                Protocol protocol = list.get(i11);
                if (protocol != Protocol.HTTP_1_0) {
                    arrayList.add(protocol.toString());
                }
            }
            try {
                this.f49080b.invoke(null, sSLSocket, Proxy.newProxyInstance(e.class.getClassLoader(), new Class[]{this.f49083e, this.f49084f}, new c(arrayList)));
            } catch (IllegalAccessException | InvocationTargetException e11) {
                throw new AssertionError(e11);
            }
        }

        @Override // com.squareup.okhttp.internal.e
        public String h(SSLSocket sSLSocket) {
            try {
                c cVar = (c) Proxy.getInvocationHandler(this.f49081c.invoke(null, sSLSocket));
                if (!cVar.f49086b && cVar.f49087c == null) {
                    com.squareup.okhttp.internal.c.logger.log(Level.INFO, "ALPN callback dropped: SPDY and HTTP/2 are disabled. Is alpn-boot on the boot class path?");
                    return null;
                }
                if (cVar.f49086b) {
                    return null;
                }
                return cVar.f49087c;
            } catch (IllegalAccessException | InvocationTargetException unused) {
                throw new AssertionError();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c implements InvocationHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<String> f49085a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f49086b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f49087c;

        public c(List<String> list) {
            this.f49085a = list;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (objArr == null) {
                objArr = g.f49215b;
            }
            if (name.equals("supports") && Boolean.TYPE == returnType) {
                return Boolean.TRUE;
            }
            if (name.equals("unsupported") && Void.TYPE == returnType) {
                this.f49086b = true;
                return null;
            }
            if (name.equals("protocols") && objArr.length == 0) {
                return this.f49085a;
            }
            if ((name.equals("selectProtocol") || name.equals("select")) && String.class == returnType && objArr.length == 1) {
                Object obj2 = objArr[0];
                if (obj2 instanceof List) {
                    List list = (List) obj2;
                    int size = list.size();
                    for (int i11 = 0; i11 < size; i11++) {
                        if (this.f49085a.contains(list.get(i11))) {
                            String str = (String) list.get(i11);
                            this.f49087c = str;
                            return str;
                        }
                    }
                    String str2 = this.f49085a.get(0);
                    this.f49087c = str2;
                    return str2;
                }
            }
            if ((!name.equals("protocolSelected") && !name.equals("selected")) || objArr.length != 1) {
                return method.invoke(this, objArr);
            }
            this.f49087c = (String) objArr[0];
            return null;
        }
    }

    public static byte[] b(List<Protocol> list) {
        Buffer buffer = new Buffer();
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            Protocol protocol = list.get(i11);
            if (protocol != Protocol.HTTP_1_0) {
                buffer.writeByte(protocol.toString().length());
                buffer.writeUtf8(protocol.toString());
            }
        }
        return buffer.readByteArray();
    }

    public static e e() {
        Method method;
        d dVar;
        Method method2;
        try {
            try {
                Class.forName("com.android.org.conscrypt.OpenSSLSocketImpl");
            } catch (ClassNotFoundException unused) {
                try {
                    Class<?> cls = Class.forName("org.eclipse.jetty.alpn.ALPN");
                    Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider");
                    return new b(cls.getMethod("put", SSLSocket.class, cls2), cls.getMethod("get", SSLSocket.class), cls.getMethod("remove", SSLSocket.class), Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider"), Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider"));
                } catch (ClassNotFoundException | NoSuchMethodException unused2) {
                    return new e();
                }
            }
        } catch (ClassNotFoundException unused3) {
            Class.forName("org.apache.harmony.xnet.provider.jsse.OpenSSLSocketImpl");
        }
        d dVar2 = null;
        d dVar3 = new d(null, "setUseSessionTickets", Boolean.TYPE);
        d dVar4 = new d(null, "setHostname", String.class);
        try {
            Class<?> cls3 = Class.forName("android.net.TrafficStats");
            method2 = cls3.getMethod("tagSocket", Socket.class);
            try {
                method = cls3.getMethod("untagSocket", Socket.class);
                try {
                    Class.forName("android.net.Network");
                    dVar = new d(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
                    try {
                        dVar2 = new d(null, "setAlpnProtocols", byte[].class);
                    } catch (ClassNotFoundException | NoSuchMethodException unused4) {
                    }
                } catch (ClassNotFoundException | NoSuchMethodException unused5) {
                    dVar = null;
                }
            } catch (ClassNotFoundException | NoSuchMethodException unused6) {
                method = null;
                dVar = null;
            }
        } catch (ClassNotFoundException | NoSuchMethodException unused7) {
            method = null;
            dVar = null;
            method2 = null;
        }
        return new a(dVar3, dVar4, method2, method, dVar, dVar2);
    }

    public static e f() {
        return f49073a;
    }

    public void a(SSLSocket sSLSocket) {
    }

    public void c(SSLSocket sSLSocket, String str, List<Protocol> list) {
    }

    public void d(Socket socket, InetSocketAddress inetSocketAddress, int i11) throws IOException {
        socket.connect(inetSocketAddress, i11);
    }

    public String g() {
        return "OkHttp";
    }

    public String h(SSLSocket sSLSocket) {
        return null;
    }

    public void i(String str) {
        System.out.println(str);
    }
}
