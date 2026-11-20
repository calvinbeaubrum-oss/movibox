package m4;

import android.media.MediaCodec;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.compose.animation.core.j0;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(23)
public class g implements l {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ArrayDeque<b> f70757g = new ArrayDeque<>();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Object f70758h = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MediaCodec f70759a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HandlerThread f70760b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Handler f70761c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicReference<RuntimeException> f70762d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final z3.g f70763e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f70764f;

    /* JADX INFO: compiled from: source.java */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            g.this.j(message);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f70766a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f70767b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f70768c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final MediaCodec.CryptoInfo f70769d = new MediaCodec.CryptoInfo();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f70770e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f70771f;

        public void a(int i11, int i12, int i13, long j11, int i14) {
            this.f70766a = i11;
            this.f70767b = i12;
            this.f70768c = i13;
            this.f70770e = j11;
            this.f70771f = i14;
        }
    }

    public g(MediaCodec mediaCodec, HandlerThread handlerThread) {
        this(mediaCodec, handlerThread, new z3.g());
    }

    public g(MediaCodec mediaCodec, HandlerThread handlerThread, z3.g gVar) {
        this.f70759a = mediaCodec;
        this.f70760b = handlerThread;
        this.f70763e = gVar;
        this.f70762d = new AtomicReference<>();
    }

    public static void g(androidx.media3.decoder.c cVar, MediaCodec.CryptoInfo cryptoInfo) {
        cryptoInfo.numSubSamples = cVar.f9807f;
        cryptoInfo.numBytesOfClearData = i(cVar.f9805d, cryptoInfo.numBytesOfClearData);
        cryptoInfo.numBytesOfEncryptedData = i(cVar.f9806e, cryptoInfo.numBytesOfEncryptedData);
        cryptoInfo.key = (byte[]) z3.a.e(h(cVar.f9803b, cryptoInfo.key));
        cryptoInfo.iv = (byte[]) z3.a.e(h(cVar.f9802a, cryptoInfo.iv));
        cryptoInfo.mode = cVar.f9804c;
        if (u0.f81838a >= 24) {
            f.a();
            cryptoInfo.setPattern(androidx.media3.decoder.d.a(cVar.f9808g, cVar.f9809h));
        }
    }

    @Nullable
    public static byte[] h(@Nullable byte[] bArr, @Nullable byte[] bArr2) {
        if (bArr == null) {
            return bArr2;
        }
        if (bArr2 == null || bArr2.length < bArr.length) {
            return Arrays.copyOf(bArr, bArr.length);
        }
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    @Nullable
    public static int[] i(@Nullable int[] iArr, @Nullable int[] iArr2) {
        if (iArr == null) {
            return iArr2;
        }
        if (iArr2 == null || iArr2.length < iArr.length) {
            return Arrays.copyOf(iArr, iArr.length);
        }
        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
        return iArr2;
    }

    public static b o() {
        ArrayDeque<b> arrayDeque = f70757g;
        synchronized (arrayDeque) {
            try {
                if (arrayDeque.isEmpty()) {
                    return new b();
                }
                return arrayDeque.removeFirst();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static void p(b bVar) {
        ArrayDeque<b> arrayDeque = f70757g;
        synchronized (arrayDeque) {
            arrayDeque.add(bVar);
        }
    }

    @Override // m4.l
    public void a(int i11, int i12, int i13, long j11, int i14) {
        c();
        b bVarO = o();
        bVarO.a(i11, i12, i13, j11, i14);
        ((Handler) u0.i(this.f70761c)).obtainMessage(0, bVarO).sendToTarget();
    }

    @Override // m4.l
    public void b(Bundle bundle) {
        c();
        ((Handler) u0.i(this.f70761c)).obtainMessage(3, bundle).sendToTarget();
    }

    @Override // m4.l
    public void c() {
        RuntimeException andSet = this.f70762d.getAndSet(null);
        if (andSet != null) {
            throw andSet;
        }
    }

    public final void e() throws InterruptedException {
        this.f70763e.d();
        ((Handler) z3.a.e(this.f70761c)).obtainMessage(2).sendToTarget();
        this.f70763e.a();
    }

    @Override // m4.l
    public void f(int i11, int i12, androidx.media3.decoder.c cVar, long j11, int i13) {
        c();
        b bVarO = o();
        bVarO.a(i11, i12, 0, j11, i13);
        g(cVar, bVarO.f70769d);
        ((Handler) u0.i(this.f70761c)).obtainMessage(1, bVarO).sendToTarget();
    }

    @Override // m4.l
    public void flush() {
        if (this.f70764f) {
            try {
                n();
            } catch (InterruptedException e11) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException(e11);
            }
        }
    }

    public final void j(Message message) {
        b bVar;
        int i11 = message.what;
        if (i11 == 0) {
            bVar = (b) message.obj;
            k(bVar.f70766a, bVar.f70767b, bVar.f70768c, bVar.f70770e, bVar.f70771f);
        } else if (i11 != 1) {
            bVar = null;
            if (i11 == 2) {
                this.f70763e.f();
            } else if (i11 != 3) {
                j0.a(this.f70762d, null, new IllegalStateException(String.valueOf(message.what)));
            } else {
                m((Bundle) message.obj);
            }
        } else {
            bVar = (b) message.obj;
            l(bVar.f70766a, bVar.f70767b, bVar.f70769d, bVar.f70770e, bVar.f70771f);
        }
        if (bVar != null) {
            p(bVar);
        }
    }

    public final void k(int i11, int i12, int i13, long j11, int i14) {
        try {
            this.f70759a.queueInputBuffer(i11, i12, i13, j11, i14);
        } catch (RuntimeException e11) {
            j0.a(this.f70762d, null, e11);
        }
    }

    public final void l(int i11, int i12, MediaCodec.CryptoInfo cryptoInfo, long j11, int i13) {
        try {
            synchronized (f70758h) {
                this.f70759a.queueSecureInputBuffer(i11, i12, cryptoInfo, j11, i13);
            }
        } catch (RuntimeException e11) {
            j0.a(this.f70762d, null, e11);
        }
    }

    public final void m(Bundle bundle) {
        try {
            this.f70759a.setParameters(bundle);
        } catch (RuntimeException e11) {
            j0.a(this.f70762d, null, e11);
        }
    }

    public final void n() throws InterruptedException {
        ((Handler) z3.a.e(this.f70761c)).removeCallbacksAndMessages(null);
        e();
    }

    @Override // m4.l
    public void shutdown() {
        if (this.f70764f) {
            flush();
            this.f70760b.quit();
        }
        this.f70764f = false;
    }

    @Override // m4.l
    public void start() {
        if (this.f70764f) {
            return;
        }
        this.f70760b.start();
        this.f70761c = new a(this.f70760b.getLooper());
        this.f70764f = true;
    }
}
