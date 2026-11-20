package com.applovin.impl;

import android.media.MediaCodec;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.applovin.exoplayer2.common.base.Ascii;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
class h1 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final ArrayDeque f19317h = new ArrayDeque();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Object f19318i = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MediaCodec f19319a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final HandlerThread f19320b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Handler f19321c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AtomicReference f19322d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final c4 f19323e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f19324f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f19325g;

    /* JADX INFO: compiled from: source.java */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            h1.this.a(message);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f19327a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f19328b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f19329c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final MediaCodec.CryptoInfo f19330d = new MediaCodec.CryptoInfo();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f19331e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f19332f;

        public void a(int i11, int i12, int i13, long j11, int i14) {
            this.f19327a = i11;
            this.f19328b = i12;
            this.f19329c = i13;
            this.f19331e = j11;
            this.f19332f = i14;
        }
    }

    public h1(MediaCodec mediaCodec, HandlerThread handlerThread, boolean z11) {
        this(mediaCodec, handlerThread, z11, new c4());
    }

    public h1(MediaCodec mediaCodec, HandlerThread handlerThread, boolean z11, c4 c4Var) {
        this.f19319a = mediaCodec;
        this.f19320b = handlerThread;
        this.f19323e = c4Var;
        this.f19322d = new AtomicReference();
        this.f19324f = z11 || f();
    }

    private void a() {
        this.f19323e.c();
        ((Handler) xp.a(this.f19321c)).obtainMessage(2).sendToTarget();
        this.f19323e.a();
    }

    private void a(int i11, int i12, int i13, long j11, int i14) {
        try {
            this.f19319a.queueInputBuffer(i11, i12, i13, j11, i14);
        } catch (RuntimeException e11) {
            a(e11);
        }
    }

    private void a(int i11, int i12, MediaCodec.CryptoInfo cryptoInfo, long j11, int i13) {
        try {
            if (!this.f19324f) {
                this.f19319a.queueSecureInputBuffer(i11, i12, cryptoInfo, j11, i13);
                return;
            }
            synchronized (f19318i) {
                this.f19319a.queueSecureInputBuffer(i11, i12, cryptoInfo, j11, i13);
            }
        } catch (RuntimeException e11) {
            a(e11);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Message message) {
        b bVar;
        int i11 = message.what;
        if (i11 == 0) {
            bVar = (b) message.obj;
            a(bVar.f19327a, bVar.f19328b, bVar.f19329c, bVar.f19331e, bVar.f19332f);
        } else if (i11 != 1) {
            if (i11 != 2) {
                a(new IllegalStateException(String.valueOf(message.what)));
            } else {
                this.f19323e.e();
            }
            bVar = null;
        } else {
            bVar = (b) message.obj;
            a(bVar.f19327a, bVar.f19328b, bVar.f19330d, bVar.f19331e, bVar.f19332f);
        }
        if (bVar != null) {
            a(bVar);
        }
    }

    private static void a(a5 a5Var, MediaCodec.CryptoInfo cryptoInfo) {
        cryptoInfo.numSubSamples = a5Var.f17445f;
        cryptoInfo.numBytesOfClearData = a(a5Var.f17443d, cryptoInfo.numBytesOfClearData);
        cryptoInfo.numBytesOfEncryptedData = a(a5Var.f17444e, cryptoInfo.numBytesOfEncryptedData);
        cryptoInfo.key = (byte[]) b1.a(a(a5Var.f17441b, cryptoInfo.key));
        cryptoInfo.iv = (byte[]) b1.a(a(a5Var.f17440a, cryptoInfo.iv));
        cryptoInfo.mode = a5Var.f17442c;
        if (xp.f24372a >= 24) {
            m4.f.a();
            cryptoInfo.setPattern(androidx.media3.decoder.d.a(a5Var.f17446g, a5Var.f17447h));
        }
    }

    private static void a(b bVar) {
        ArrayDeque arrayDeque = f19317h;
        synchronized (arrayDeque) {
            arrayDeque.add(bVar);
        }
    }

    private static byte[] a(byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            return bArr2;
        }
        if (bArr2 == null || bArr2.length < bArr.length) {
            return Arrays.copyOf(bArr, bArr.length);
        }
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    private static int[] a(int[] iArr, int[] iArr2) {
        if (iArr == null) {
            return iArr2;
        }
        if (iArr2 == null || iArr2.length < iArr.length) {
            return Arrays.copyOf(iArr, iArr.length);
        }
        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
        return iArr2;
    }

    private void c() {
        ((Handler) xp.a(this.f19321c)).removeCallbacksAndMessages(null);
        a();
        e();
    }

    private static b d() {
        ArrayDeque arrayDeque = f19317h;
        synchronized (arrayDeque) {
            try {
                if (arrayDeque.isEmpty()) {
                    return new b();
                }
                return (b) arrayDeque.removeFirst();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private void e() {
        RuntimeException runtimeException = (RuntimeException) this.f19322d.getAndSet(null);
        if (runtimeException != null) {
            throw runtimeException;
        }
    }

    private static boolean f() {
        String lowerCase = Ascii.toLowerCase(xp.f24374c);
        return lowerCase.contains("samsung") || lowerCase.contains("motorola");
    }

    public void a(int i11, int i12, a5 a5Var, long j11, int i13) {
        e();
        b bVarD = d();
        bVarD.a(i11, i12, 0, j11, i13);
        a(a5Var, bVarD.f19330d);
        ((Handler) xp.a(this.f19321c)).obtainMessage(1, bVarD).sendToTarget();
    }

    public void a(RuntimeException runtimeException) {
        this.f19322d.set(runtimeException);
    }

    public void b() {
        if (this.f19325g) {
            try {
                c();
            } catch (InterruptedException e11) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException(e11);
            }
        }
    }

    public void b(int i11, int i12, int i13, long j11, int i14) {
        e();
        b bVarD = d();
        bVarD.a(i11, i12, i13, j11, i14);
        ((Handler) xp.a(this.f19321c)).obtainMessage(0, bVarD).sendToTarget();
    }

    public void g() {
        if (this.f19325g) {
            b();
            this.f19320b.quit();
        }
        this.f19325g = false;
    }

    public void h() {
        if (this.f19325g) {
            return;
        }
        this.f19320b.start();
        this.f19321c = new a(this.f19320b.getLooper());
        this.f19325g = true;
    }

    public void i() {
        a();
    }
}
