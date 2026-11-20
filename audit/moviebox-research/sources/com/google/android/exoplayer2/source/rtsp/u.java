package com.google.android.exoplayer2.source.rtsp;

import android.os.Handler;
import android.os.HandlerThread;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.common.collect.ImmutableList;
import com.google.common.primitives.Ints;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class u implements Closeable {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Charset f34609h = com.google.common.base.c.f38165c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f34610a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Loader f34611b = new Loader("ExoPlayer:RtspMessageChannel:ReceiverLoader");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<Integer, b> f34612c = Collections.synchronizedMap(new HashMap());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public g f34613d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Socket f34614f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile boolean f34615g;

    /* JADX INFO: compiled from: source.java */
    public interface b {
        void f(byte[] bArr);
    }

    /* JADX INFO: compiled from: source.java */
    public final class c implements Loader.b<f> {
        public c() {
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void j(f fVar, long j11, long j12, boolean z11) {
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void l(f fVar, long j11, long j12) {
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.b
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Loader.c n(f fVar, long j11, long j12, IOException iOException, int i11) {
            if (!u.this.f34615g) {
                u.this.f34610a.a(iOException);
            }
            return Loader.f35231f;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface d {
        void a(Exception exc);

        void b(List<String> list, Exception exc);

        void c(List<String> list);
    }

    /* JADX INFO: compiled from: source.java */
    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<String> f34617a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f34618b = 1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f34619c;

        public static byte[] d(byte b11, DataInputStream dataInputStream) throws IOException {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = {b11, dataInputStream.readByte()};
            byteArrayOutputStream.write(bArr);
            while (true) {
                if (bArr[0] == 13 && bArr[1] == 10) {
                    return byteArrayOutputStream.toByteArray();
                }
                bArr[0] = bArr[1];
                byte b12 = dataInputStream.readByte();
                bArr[1] = b12;
                byteArrayOutputStream.write(b12);
            }
        }

        public final ImmutableList<String> a(byte[] bArr) {
            com.google.android.exoplayer2.util.a.g(this.f34618b == 3);
            if (bArr.length <= 0 || bArr[bArr.length - 1] != 10) {
                throw new IllegalArgumentException("Message body is empty or does not end with a LF.");
            }
            this.f34617a.add((bArr.length <= 1 || bArr[bArr.length + (-2)] != 13) ? new String(bArr, 0, bArr.length - 1, u.f34609h) : new String(bArr, 0, bArr.length - 2, u.f34609h));
            ImmutableList<String> immutableListCopyOf = ImmutableList.copyOf((Collection) this.f34617a);
            e();
            return immutableListCopyOf;
        }

        @Nullable
        public final ImmutableList<String> b(byte[] bArr) throws ParserException {
            com.google.android.exoplayer2.util.a.a(bArr.length >= 2 && bArr[bArr.length - 2] == 13 && bArr[bArr.length - 1] == 10);
            String str = new String(bArr, 0, bArr.length - 2, u.f34609h);
            this.f34617a.add(str);
            int i11 = this.f34618b;
            if (i11 == 1) {
                if (!y.f(str)) {
                    return null;
                }
                this.f34618b = 2;
                return null;
            }
            if (i11 != 2) {
                throw new IllegalStateException();
            }
            long jG = y.g(str);
            if (jG != -1) {
                this.f34619c = jG;
            }
            if (!str.isEmpty()) {
                return null;
            }
            if (this.f34619c > 0) {
                this.f34618b = 3;
                return null;
            }
            ImmutableList<String> immutableListCopyOf = ImmutableList.copyOf((Collection) this.f34617a);
            e();
            return immutableListCopyOf;
        }

        public ImmutableList<String> c(byte b11, DataInputStream dataInputStream) throws IOException {
            ImmutableList<String> immutableListB = b(d(b11, dataInputStream));
            while (immutableListB == null) {
                if (this.f34618b == 3) {
                    long j11 = this.f34619c;
                    if (j11 <= 0) {
                        throw new IllegalStateException("Expects a greater than zero Content-Length.");
                    }
                    int iD = Ints.d(j11);
                    com.google.android.exoplayer2.util.a.g(iD != -1);
                    byte[] bArr = new byte[iD];
                    dataInputStream.readFully(bArr, 0, iD);
                    immutableListB = a(bArr);
                } else {
                    immutableListB = b(d(dataInputStream.readByte(), dataInputStream));
                }
            }
            return immutableListB;
        }

        public final void e() {
            this.f34617a.clear();
            this.f34618b = 1;
            this.f34619c = 0L;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class f implements Loader.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final DataInputStream f34620a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final e f34621b = new e();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public volatile boolean f34622c;

        public f(InputStream inputStream) {
            this.f34620a = new DataInputStream(inputStream);
        }

        public final void a() throws IOException {
            int unsignedByte = this.f34620a.readUnsignedByte();
            int unsignedShort = this.f34620a.readUnsignedShort();
            byte[] bArr = new byte[unsignedShort];
            this.f34620a.readFully(bArr, 0, unsignedShort);
            b bVar = (b) u.this.f34612c.get(Integer.valueOf(unsignedByte));
            if (bVar == null || u.this.f34615g) {
                return;
            }
            bVar.f(bArr);
        }

        public final void b(byte b11) throws IOException {
            if (u.this.f34615g) {
                return;
            }
            u.this.f34610a.c(this.f34621b.c(b11, this.f34620a));
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.d
        public void cancelLoad() {
            this.f34622c = true;
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.d
        public void load() throws IOException {
            while (!this.f34622c) {
                byte b11 = this.f34620a.readByte();
                if (b11 == 36) {
                    a();
                } else {
                    b(b11);
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class g implements Closeable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final OutputStream f34624a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final HandlerThread f34625b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Handler f34626c;

        public g(OutputStream outputStream) {
            this.f34624a = outputStream;
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:RtspMessageChannel:Sender");
            this.f34625b = handlerThread;
            handlerThread.start();
            this.f34626c = new Handler(handlerThread.getLooper());
        }

        public final /* synthetic */ void b(byte[] bArr, List list) {
            try {
                this.f34624a.write(bArr);
            } catch (Exception e11) {
                if (u.this.f34615g) {
                    return;
                }
                u.this.f34610a.b(list, e11);
            }
        }

        public void c(final List<String> list) {
            final byte[] bArrB = y.b(list);
            this.f34626c.post(new Runnable() { // from class: com.google.android.exoplayer2.source.rtsp.w
                @Override // java.lang.Runnable
                public final void run() {
                    this.f34628a.b(bArrB, list);
                }
            });
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            Handler handler = this.f34626c;
            final HandlerThread handlerThread = this.f34625b;
            Objects.requireNonNull(handlerThread);
            handler.post(new Runnable() { // from class: com.google.android.exoplayer2.source.rtsp.x
                @Override // java.lang.Runnable
                public final void run() {
                    handlerThread.quit();
                }
            });
            try {
                this.f34625b.join();
            } catch (InterruptedException unused) {
                this.f34625b.interrupt();
            }
        }
    }

    public u(d dVar) {
        this.f34610a = dVar;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f34615g) {
            return;
        }
        try {
            g gVar = this.f34613d;
            if (gVar != null) {
                gVar.close();
            }
            this.f34611b.k();
            Socket socket = this.f34614f;
            if (socket != null) {
                socket.close();
            }
        } finally {
            this.f34615g = true;
        }
    }

    public void d(Socket socket) throws IOException {
        this.f34614f = socket;
        this.f34613d = new g(socket.getOutputStream());
        this.f34611b.m(new f(socket.getInputStream()), new c(), 0);
    }

    public void e(int i11, b bVar) {
        this.f34612c.put(Integer.valueOf(i11), bVar);
    }

    public void g(List<String> list) {
        com.google.android.exoplayer2.util.a.i(this.f34613d);
        this.f34613d.c(list);
    }
}
