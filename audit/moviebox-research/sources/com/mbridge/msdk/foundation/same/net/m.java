package com.mbridge.msdk.foundation.same.net;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile AtomicInteger f44692a = new AtomicInteger(1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ExecutorService f44693b;

    /* JADX INFO: compiled from: source.java */
    public class a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private ByteBuffer f44698b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f44699c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f44700d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private e f44701e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private OutputStream f44702f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f44703g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private Socket f44704h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private String f44705i;

        public a(String str, int i11, String str2, boolean z11, e eVar) {
            this.f44699c = str;
            this.f44703g = i11;
            this.f44705i = str2;
            this.f44700d = z11;
            this.f44701e = eVar;
        }

        private void a(String str) {
            if (this.f44701e != null) {
                if (TextUtils.isEmpty(str)) {
                    str = "Unknown exception";
                }
                this.f44701e.onError(new com.mbridge.msdk.foundation.same.net.b.a(13, new com.mbridge.msdk.foundation.same.net.f.c(404, str.getBytes(), null)));
            }
        }

        public final void a() {
            byte[] bytes;
            int length;
            try {
                try {
                    Socket socket = new Socket(this.f44699c, this.f44703g);
                    this.f44704h = socket;
                    socket.setSoTimeout(DefaultLoadControl.DEFAULT_MIN_BUFFER_MS);
                    boolean z11 = this.f44699c.contains(com.mbridge.msdk.foundation.same.net.g.d.f().f44632i) || this.f44699c.contains(com.mbridge.msdk.foundation.same.net.g.d.f().f44634k);
                    ad.b("SocketManager", "Socket connect : " + this.f44699c + " : " + this.f44703g + " isAnalytics : " + z11);
                    this.f44702f = this.f44704h.getOutputStream();
                    ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[8]);
                    this.f44698b = byteBufferWrap;
                    ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
                    byteBufferWrap.order(byteOrder);
                    this.f44698b.put((byte) 2);
                    if (TextUtils.isEmpty(this.f44705i)) {
                        this.f44698b.put((byte) 1);
                    } else {
                        this.f44698b.put(this.f44700d ? (byte) 3 : (byte) 2);
                    }
                    this.f44698b.putShort((short) m.f44692a.getAndIncrement());
                    if (TextUtils.isEmpty(this.f44705i)) {
                        this.f44698b.putInt(0);
                        this.f44702f.write(this.f44698b.array());
                        length = 0;
                    } else {
                        if (this.f44700d) {
                            String str = this.f44705i;
                            if (TextUtils.isEmpty(str)) {
                                bytes = null;
                            } else {
                                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                                gZIPOutputStream.write(str.getBytes());
                                gZIPOutputStream.close();
                                bytes = byteArrayOutputStream.toByteArray();
                            }
                        } else {
                            bytes = this.f44705i.getBytes();
                        }
                        length = bytes.length;
                        this.f44698b.putInt(length);
                        this.f44702f.write(this.f44698b.array());
                        this.f44702f.write(bytes);
                    }
                    this.f44702f.flush();
                    ad.a("SocketManager", "Socket Request : header : " + Arrays.toString(this.f44698b.array()) + " length : " + length);
                    InputStream inputStream = this.f44704h.getInputStream();
                    byte[] bArr = new byte[8];
                    inputStream.read(bArr, 0, 8);
                    ByteBuffer byteBufferWrap2 = ByteBuffer.wrap(bArr);
                    this.f44698b = byteBufferWrap2;
                    byteBufferWrap2.order(byteOrder);
                    int i11 = this.f44698b.getInt(4);
                    byte b11 = bArr[1];
                    boolean z12 = b11 == 3;
                    boolean z13 = b11 == 2;
                    ad.b("SocketManager", "Socket Response : header : " + Arrays.toString(bArr) + " length : " + i11 + " isGzip : " + z12);
                    byte[] bArr2 = new byte[i11];
                    new DataInputStream(this.f44704h.getInputStream()).readFully(bArr2);
                    if (!z12 && i11 > 2 && ((bArr2[0] << 8) | (bArr2[1] & 255)) == 8075) {
                        z12 = true;
                    }
                    e eVar = this.f44701e;
                    if (eVar == null) {
                        Socket socket2 = this.f44704h;
                        if (socket2 != null) {
                            try {
                                socket2.close();
                                this.f44698b = null;
                                this.f44702f.close();
                                return;
                            } catch (IOException e11) {
                                ad.b("SocketManager", e11.getMessage());
                                return;
                            }
                        }
                        return;
                    }
                    if (z13 && i11 == 0) {
                        eVar.onSuccess(k.a(null, new com.mbridge.msdk.foundation.same.net.f.c(204, null, null)));
                        Socket socket3 = this.f44704h;
                        if (socket3 != null) {
                            try {
                                socket3.close();
                                this.f44698b = null;
                                this.f44702f.close();
                                return;
                            } catch (IOException e12) {
                                ad.b("SocketManager", e12.getMessage());
                                return;
                            }
                        }
                        return;
                    }
                    if (i11 < 1) {
                        a("The response data less than 1");
                        Socket socket4 = this.f44704h;
                        if (socket4 != null) {
                            try {
                                socket4.close();
                                this.f44698b = null;
                                this.f44702f.close();
                                return;
                            } catch (IOException e13) {
                                ad.b("SocketManager", e13.getMessage());
                                return;
                            }
                        }
                        return;
                    }
                    if (z11) {
                        if (bArr2[0] == 1) {
                            eVar.onSuccess(k.a(null, new com.mbridge.msdk.foundation.same.net.f.c(200, null, null)));
                        } else {
                            a("The server returns fail");
                        }
                        Socket socket5 = this.f44704h;
                        if (socket5 != null) {
                            try {
                                socket5.close();
                                this.f44698b = null;
                                this.f44702f.close();
                                return;
                            } catch (IOException e14) {
                                ad.b("SocketManager", e14.getMessage());
                                return;
                            }
                        }
                        return;
                    }
                    try {
                        String strA = z12 ? m.this.a(bArr2) : new String(bArr2);
                        JSONObject jSONObject = !TextUtils.isEmpty(strA) ? new JSONObject(strA) : null;
                        ad.b("SocketManager", "Socket Response length : " + i11 + " " + strA.length());
                        this.f44701e.onSuccess(k.a(jSONObject, new com.mbridge.msdk.foundation.same.net.f.c(200, null, null)));
                    } catch (Throwable th2) {
                        String message = th2.getMessage();
                        ad.b("SocketManager", th2.getMessage());
                        if (TextUtils.isEmpty(message)) {
                            message = "The JSON data is illegal";
                        }
                        a(message);
                    }
                    inputStream.close();
                    Socket socket6 = this.f44704h;
                    if (socket6 != null) {
                        socket6.close();
                        this.f44698b = null;
                        this.f44702f.close();
                    }
                } catch (IOException e15) {
                    ad.b("SocketManager", e15.getMessage());
                }
            } catch (Throwable th3) {
                try {
                    String message2 = th3.getMessage();
                    ad.a("SocketManager", "Socket exception: " + message2);
                    a(message2);
                    Socket socket7 = this.f44704h;
                    if (socket7 != null) {
                        socket7.close();
                        this.f44698b = null;
                        this.f44702f.close();
                    }
                } catch (Throwable th4) {
                    Socket socket8 = this.f44704h;
                    if (socket8 != null) {
                        try {
                            socket8.close();
                            this.f44698b = null;
                            this.f44702f.close();
                        } catch (IOException e16) {
                            ad.b("SocketManager", e16.getMessage());
                        }
                    }
                    throw th4;
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static m f44706a = new m();
    }

    private m() {
        this.f44693b = new ThreadPoolExecutor(5, 10, 5L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.mbridge.msdk.foundation.same.net.m.1
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                Thread threadNewThread = Executors.defaultThreadFactory().newThread(runnable);
                threadNewThread.setName("SocketThreadPool");
                return threadNewThread;
            }
        }, new ThreadPoolExecutor.DiscardPolicy());
    }

    public static m a() {
        return b.f44706a;
    }

    public final String a(byte[] bArr) throws IOException {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
        byte[] bArr2 = new byte[1024];
        while (true) {
            int i11 = gZIPInputStream.read(bArr2, 0, 1024);
            if (i11 <= 0) {
                gZIPInputStream.close();
                byteArrayInputStream.close();
                byteArrayOutputStream.flush();
                byteArrayOutputStream.close();
                return byteArrayOutputStream.toString();
            }
            byteArrayOutputStream.write(bArr2, 0, i11);
        }
    }

    public final void a(String str, int i11, String str2, boolean z11, e eVar) {
        final a aVar = new a(str, i11, str2, z11, eVar);
        this.f44693b.execute(new Runnable() { // from class: com.mbridge.msdk.foundation.same.net.m.2
            @Override // java.lang.Runnable
            public final void run() {
                aVar.a();
            }
        });
    }
}
