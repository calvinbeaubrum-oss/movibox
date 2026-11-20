package fh;

import android.media.MediaCodec;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.compose.animation.core.j0;
import com.google.android.exoplayer2.util.o0;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(23)
public class d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ArrayDeque<b> f64884g = new ArrayDeque<>();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Object f64885h = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MediaCodec f64886a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HandlerThread f64887b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Handler f64888c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicReference<RuntimeException> f64889d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.google.android.exoplayer2.util.h f64890e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f64891f;

    /* JADX INFO: compiled from: source.java */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            d.this.f(message);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f64893a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f64894b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f64895c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final MediaCodec.CryptoInfo f64896d = new MediaCodec.CryptoInfo();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f64897e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f64898f;

        public void a(int i11, int i12, int i13, long j11, int i14) {
            this.f64893a = i11;
            this.f64894b = i12;
            this.f64895c = i13;
            this.f64897e = j11;
            this.f64898f = i14;
        }
    }

    public d(MediaCodec mediaCodec, HandlerThread handlerThread) {
        this(mediaCodec, handlerThread, new com.google.android.exoplayer2.util.h());
    }

    public d(MediaCodec mediaCodec, HandlerThread handlerThread, com.google.android.exoplayer2.util.h hVar) {
        this.f64886a = mediaCodec;
        this.f64887b = handlerThread;
        this.f64890e = hVar;
        this.f64889d = new AtomicReference<>();
    }

    public static void c(com.google.android.exoplayer2.decoder.c cVar, MediaCodec.CryptoInfo cryptoInfo) {
        cryptoInfo.numSubSamples = cVar.f33055f;
        cryptoInfo.numBytesOfClearData = e(cVar.f33053d, cryptoInfo.numBytesOfClearData);
        cryptoInfo.numBytesOfEncryptedData = e(cVar.f33054e, cryptoInfo.numBytesOfEncryptedData);
        cryptoInfo.key = (byte[]) com.google.android.exoplayer2.util.a.e(d(cVar.f33051b, cryptoInfo.key));
        cryptoInfo.iv = (byte[]) com.google.android.exoplayer2.util.a.e(d(cVar.f33050a, cryptoInfo.iv));
        cryptoInfo.mode = cVar.f33052c;
        if (o0.f35608a >= 24) {
            m4.f.a();
            cryptoInfo.setPattern(androidx.media3.decoder.d.a(cVar.f33056g, cVar.f33057h));
        }
    }

    @Nullable
    public static byte[] d(@Nullable byte[] bArr, @Nullable byte[] bArr2) {
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
    public static int[] e(@Nullable int[] iArr, @Nullable int[] iArr2) {
        if (iArr == null) {
            return iArr2;
        }
        if (iArr2 == null || iArr2.length < iArr.length) {
            return Arrays.copyOf(iArr, iArr.length);
        }
        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
        return iArr2;
    }

    public static b k() {
        ArrayDeque<b> arrayDeque = f64884g;
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

    public static void o(b bVar) {
        ArrayDeque<b> arrayDeque = f64884g;
        synchronized (arrayDeque) {
            arrayDeque.add(bVar);
        }
    }

    public final void b() throws InterruptedException {
        this.f64890e.d();
        ((Handler) com.google.android.exoplayer2.util.a.e(this.f64888c)).obtainMessage(2).sendToTarget();
        this.f64890e.a();
    }

    public final void f(Message message) {
        b bVar;
        int i11 = message.what;
        if (i11 == 0) {
            bVar = (b) message.obj;
            g(bVar.f64893a, bVar.f64894b, bVar.f64895c, bVar.f64897e, bVar.f64898f);
        } else if (i11 != 1) {
            bVar = null;
            if (i11 != 2) {
                j0.a(this.f64889d, null, new IllegalStateException(String.valueOf(message.what)));
            } else {
                this.f64890e.f();
            }
        } else {
            bVar = (b) message.obj;
            h(bVar.f64893a, bVar.f64894b, bVar.f64896d, bVar.f64897e, bVar.f64898f);
        }
        if (bVar != null) {
            o(bVar);
        }
    }

    public final void g(int i11, int i12, int i13, long j11, int i14) {
        try {
            this.f64886a.queueInputBuffer(i11, i12, i13, j11, i14);
        } catch (RuntimeException e11) {
            j0.a(this.f64889d, null, e11);
        }
    }

    public final void h(int i11, int i12, MediaCodec.CryptoInfo cryptoInfo, long j11, int i13) {
        try {
            synchronized (f64885h) {
                this.f64886a.queueSecureInputBuffer(i11, i12, cryptoInfo, j11, i13);
            }
        } catch (RuntimeException e11) {
            j0.a(this.f64889d, null, e11);
        }
    }

    public void i() {
        if (this.f64891f) {
            try {
                j();
            } catch (InterruptedException e11) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException(e11);
            }
        }
    }

    public final void j() throws InterruptedException {
        ((Handler) com.google.android.exoplayer2.util.a.e(this.f64888c)).removeCallbacksAndMessages(null);
        b();
    }

    public final void l() {
        RuntimeException andSet = this.f64889d.getAndSet(null);
        if (andSet != null) {
            throw andSet;
        }
    }

    public void m(int i11, int i12, int i13, long j11, int i14) {
        l();
        b bVarK = k();
        bVarK.a(i11, i12, i13, j11, i14);
        ((Handler) o0.j(this.f64888c)).obtainMessage(0, bVarK).sendToTarget();
    }

    public void n(int i11, int i12, com.google.android.exoplayer2.decoder.c cVar, long j11, int i13) {
        l();
        b bVarK = k();
        bVarK.a(i11, i12, 0, j11, i13);
        c(cVar, bVarK.f64896d);
        ((Handler) o0.j(this.f64888c)).obtainMessage(1, bVarK).sendToTarget();
    }

    public void p() {
        if (this.f64891f) {
            i();
            this.f64887b.quit();
        }
        this.f64891f = false;
    }

    public void q() {
        if (this.f64891f) {
            return;
        }
        this.f64887b.start();
        this.f64888c = new a(this.f64887b.getLooper());
        this.f64891f = true;
    }

    public void r() throws InterruptedException {
        b();
    }
}
