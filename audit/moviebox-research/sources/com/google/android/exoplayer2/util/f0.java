package com.google.android.exoplayer2.util;

import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.applovin.exoplayer2.common.base.Ascii;
import com.google.android.exoplayer2.upstream.Loader;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.ConcurrentModificationException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f35559a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f35560b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f35561c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static long f35562d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f35563e = "time.android.com";

    /* JADX INFO: compiled from: source.java */
    public interface b {
        void a(IOException iOException);

        void onInitialized();
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c implements Loader.b<Loader.d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public final b f35564a;

        public c(@Nullable b bVar) {
            this.f35564a = bVar;
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.b
        public void j(Loader.d dVar, long j11, long j12, boolean z11) {
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.b
        public void l(Loader.d dVar, long j11, long j12) {
            if (this.f35564a != null) {
                if (f0.k()) {
                    this.f35564a.onInitialized();
                } else {
                    this.f35564a.a(new IOException(new ConcurrentModificationException()));
                }
            }
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.b
        public Loader.c n(Loader.d dVar, long j11, long j12, IOException iOException, int i11) {
            b bVar = this.f35564a;
            if (bVar != null) {
                bVar.a(iOException);
            }
            return Loader.f35231f;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class d implements Loader.d {
        public d() {
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.d
        public void cancelLoad() {
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.d
        public void load() throws IOException {
            synchronized (f0.f35559a) {
                synchronized (f0.f35560b) {
                    if (f0.f35561c) {
                        return;
                    }
                    long jL = f0.l();
                    synchronized (f0.f35560b) {
                        long unused = f0.f35562d = jL;
                        boolean unused2 = f0.f35561c = true;
                    }
                }
            }
        }
    }

    public static void g(byte b11, byte b12, int i11, long j11) throws IOException {
        if (b11 == 3) {
            throw new IOException("SNTP: Unsynchronized server");
        }
        if (b12 != 4 && b12 != 5) {
            throw new IOException("SNTP: Untrusted mode: " + ((int) b12));
        }
        if (i11 != 0 && i11 <= 15) {
            if (j11 == 0) {
                throw new IOException("SNTP: Zero transmitTime");
            }
        } else {
            throw new IOException("SNTP: Untrusted stratum: " + i11);
        }
    }

    public static long h() {
        long j11;
        synchronized (f35560b) {
            try {
                j11 = f35561c ? f35562d : C.TIME_UNSET;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return j11;
    }

    public static String i() {
        String str;
        synchronized (f35560b) {
            str = f35563e;
        }
        return str;
    }

    public static void j(@Nullable Loader loader, @Nullable b bVar) {
        if (k()) {
            if (bVar != null) {
                bVar.onInitialized();
            }
        } else {
            if (loader == null) {
                loader = new Loader("SntpClient");
            }
            loader.m(new d(), new c(bVar), 1);
        }
    }

    public static boolean k() {
        boolean z11;
        synchronized (f35560b) {
            z11 = f35561c;
        }
        return z11;
    }

    public static long l() throws IOException {
        InetAddress byName = InetAddress.getByName(i());
        DatagramSocket datagramSocket = new DatagramSocket();
        try {
            datagramSocket.setSoTimeout(10000);
            byte[] bArr = new byte[48];
            DatagramPacket datagramPacket = new DatagramPacket(bArr, 48, byName, 123);
            bArr[0] = Ascii.ESC;
            long jCurrentTimeMillis = System.currentTimeMillis();
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            o(bArr, 40, jCurrentTimeMillis);
            datagramSocket.send(datagramPacket);
            datagramSocket.receive(new DatagramPacket(bArr, 48));
            long jElapsedRealtime2 = SystemClock.elapsedRealtime();
            long j11 = jCurrentTimeMillis + (jElapsedRealtime2 - jElapsedRealtime);
            byte b11 = bArr[0];
            int i11 = bArr[1] & 255;
            long jN = n(bArr, 24);
            long jN2 = n(bArr, 32);
            long jN3 = n(bArr, 40);
            g((byte) ((b11 >> 6) & 3), (byte) (b11 & 7), i11, jN3);
            long j12 = (j11 + (((jN2 - jN) + (jN3 - j11)) / 2)) - jElapsedRealtime2;
            datagramSocket.close();
            return j12;
        } catch (Throwable th2) {
            try {
                datagramSocket.close();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    public static long m(byte[] bArr, int i11) {
        int i12 = bArr[i11];
        int i13 = bArr[i11 + 1];
        int i14 = bArr[i11 + 2];
        int i15 = bArr[i11 + 3];
        if ((i12 & 128) == 128) {
            i12 = (i12 & 127) + 128;
        }
        if ((i13 & 128) == 128) {
            i13 = (i13 & 127) + 128;
        }
        if ((i14 & 128) == 128) {
            i14 = (i14 & 127) + 128;
        }
        if ((i15 & 128) == 128) {
            i15 = (i15 & 127) + 128;
        }
        return (((long) i12) << 24) + (((long) i13) << 16) + (((long) i14) << 8) + ((long) i15);
    }

    public static long n(byte[] bArr, int i11) {
        long jM = m(bArr, i11);
        long jM2 = m(bArr, i11 + 4);
        if (jM == 0 && jM2 == 0) {
            return 0L;
        }
        return ((jM - 2208988800L) * 1000) + ((jM2 * 1000) / 4294967296L);
    }

    public static void o(byte[] bArr, int i11, long j11) {
        if (j11 == 0) {
            Arrays.fill(bArr, i11, i11 + 8, (byte) 0);
            return;
        }
        long j12 = j11 / 1000;
        long j13 = j11 - (j12 * 1000);
        long j14 = j12 + 2208988800L;
        bArr[i11] = (byte) (j14 >> 24);
        bArr[i11 + 1] = (byte) (j14 >> 16);
        bArr[i11 + 2] = (byte) (j14 >> 8);
        bArr[i11 + 3] = (byte) j14;
        long j15 = (j13 * 4294967296L) / 1000;
        bArr[i11 + 4] = (byte) (j15 >> 24);
        bArr[i11 + 5] = (byte) (j15 >> 16);
        bArr[i11 + 6] = (byte) (j15 >> 8);
        bArr[i11 + 7] = (byte) (Math.random() * 255.0d);
    }
}
