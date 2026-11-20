package m4;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.ArrayDeque;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(23)
public final class j extends MediaCodec.Callback {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HandlerThread f70774b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Handler f70775c;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public MediaFormat f70780h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public MediaFormat f70781i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    public MediaCodec.CodecException f70782j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    public MediaCodec.CryptoException f70783k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f70784l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f70785m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Nullable
    public IllegalStateException f70786n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f70773a = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final androidx.collection.e f70776d = new androidx.collection.e();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final androidx.collection.e f70777e = new androidx.collection.e();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ArrayDeque<MediaCodec.BufferInfo> f70778f = new ArrayDeque<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ArrayDeque<MediaFormat> f70779g = new ArrayDeque<>();

    public j(HandlerThread handlerThread) {
        this.f70774b = handlerThread;
    }

    public final void b(MediaFormat mediaFormat) {
        this.f70777e.a(-2);
        this.f70779g.add(mediaFormat);
    }

    public int c() {
        synchronized (this.f70773a) {
            try {
                j();
                int iE = -1;
                if (i()) {
                    return -1;
                }
                if (!this.f70776d.d()) {
                    iE = this.f70776d.e();
                }
                return iE;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public int d(MediaCodec.BufferInfo bufferInfo) {
        synchronized (this.f70773a) {
            try {
                j();
                if (i()) {
                    return -1;
                }
                if (this.f70777e.d()) {
                    return -1;
                }
                int iE = this.f70777e.e();
                if (iE >= 0) {
                    z3.a.i(this.f70780h);
                    MediaCodec.BufferInfo bufferInfoRemove = this.f70778f.remove();
                    bufferInfo.set(bufferInfoRemove.offset, bufferInfoRemove.size, bufferInfoRemove.presentationTimeUs, bufferInfoRemove.flags);
                } else if (iE == -2) {
                    this.f70780h = this.f70779g.remove();
                }
                return iE;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void e() {
        synchronized (this.f70773a) {
            this.f70784l++;
            ((Handler) u0.i(this.f70775c)).post(new Runnable() { // from class: m4.i
                @Override // java.lang.Runnable
                public final void run() {
                    this.f70772a.n();
                }
            });
        }
    }

    public final void f() {
        if (!this.f70779g.isEmpty()) {
            this.f70781i = this.f70779g.getLast();
        }
        this.f70776d.b();
        this.f70777e.b();
        this.f70778f.clear();
        this.f70779g.clear();
    }

    public MediaFormat g() {
        MediaFormat mediaFormat;
        synchronized (this.f70773a) {
            try {
                mediaFormat = this.f70780h;
                if (mediaFormat == null) {
                    throw new IllegalStateException();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return mediaFormat;
    }

    public void h(MediaCodec mediaCodec) {
        z3.a.g(this.f70775c == null);
        this.f70774b.start();
        Handler handler = new Handler(this.f70774b.getLooper());
        mediaCodec.setCallback(this, handler);
        this.f70775c = handler;
    }

    public final boolean i() {
        return this.f70784l > 0 || this.f70785m;
    }

    public final void j() {
        k();
        m();
        l();
    }

    public final void k() {
        IllegalStateException illegalStateException = this.f70786n;
        if (illegalStateException == null) {
            return;
        }
        this.f70786n = null;
        throw illegalStateException;
    }

    public final void l() {
        MediaCodec.CryptoException cryptoException = this.f70783k;
        if (cryptoException == null) {
            return;
        }
        this.f70783k = null;
        throw cryptoException;
    }

    public final void m() {
        MediaCodec.CodecException codecException = this.f70782j;
        if (codecException == null) {
            return;
        }
        this.f70782j = null;
        throw codecException;
    }

    public final void n() {
        synchronized (this.f70773a) {
            try {
                if (this.f70785m) {
                    return;
                }
                long j11 = this.f70784l - 1;
                this.f70784l = j11;
                if (j11 > 0) {
                    return;
                }
                if (j11 < 0) {
                    o(new IllegalStateException());
                } else {
                    f();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void o(IllegalStateException illegalStateException) {
        synchronized (this.f70773a) {
            this.f70786n = illegalStateException;
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onCryptoError(MediaCodec mediaCodec, MediaCodec.CryptoException cryptoException) {
        synchronized (this.f70773a) {
            this.f70783k = cryptoException;
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onError(MediaCodec mediaCodec, MediaCodec.CodecException codecException) {
        synchronized (this.f70773a) {
            this.f70782j = codecException;
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onInputBufferAvailable(MediaCodec mediaCodec, int i11) {
        synchronized (this.f70773a) {
            this.f70776d.a(i11);
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onOutputBufferAvailable(MediaCodec mediaCodec, int i11, MediaCodec.BufferInfo bufferInfo) {
        synchronized (this.f70773a) {
            try {
                MediaFormat mediaFormat = this.f70781i;
                if (mediaFormat != null) {
                    b(mediaFormat);
                    this.f70781i = null;
                }
                this.f70777e.a(i11);
                this.f70778f.add(bufferInfo);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        synchronized (this.f70773a) {
            b(mediaFormat);
            this.f70781i = null;
        }
    }

    public void p() {
        synchronized (this.f70773a) {
            this.f70785m = true;
            this.f70774b.quit();
            f();
        }
    }
}
