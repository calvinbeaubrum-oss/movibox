package fh;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.util.o0;
import java.util.ArrayDeque;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(23)
public final class f extends MediaCodec.Callback {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HandlerThread f64901b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Handler f64902c;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public MediaFormat f64907h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public MediaFormat f64908i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    public MediaCodec.CodecException f64909j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f64910k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f64911l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Nullable
    public IllegalStateException f64912m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f64900a = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final i f64903d = new i();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final i f64904e = new i();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ArrayDeque<MediaCodec.BufferInfo> f64905f = new ArrayDeque<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ArrayDeque<MediaFormat> f64906g = new ArrayDeque<>();

    public f(HandlerThread handlerThread) {
        this.f64901b = handlerThread;
    }

    public final void b(MediaFormat mediaFormat) {
        this.f64904e.a(-2);
        this.f64906g.add(mediaFormat);
    }

    public int c() {
        synchronized (this.f64900a) {
            try {
                int iE = -1;
                if (i()) {
                    return -1;
                }
                j();
                if (!this.f64903d.d()) {
                    iE = this.f64903d.e();
                }
                return iE;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public int d(MediaCodec.BufferInfo bufferInfo) {
        synchronized (this.f64900a) {
            try {
                if (i()) {
                    return -1;
                }
                j();
                if (this.f64904e.d()) {
                    return -1;
                }
                int iE = this.f64904e.e();
                if (iE >= 0) {
                    com.google.android.exoplayer2.util.a.i(this.f64907h);
                    MediaCodec.BufferInfo bufferInfoRemove = this.f64905f.remove();
                    bufferInfo.set(bufferInfoRemove.offset, bufferInfoRemove.size, bufferInfoRemove.presentationTimeUs, bufferInfoRemove.flags);
                } else if (iE == -2) {
                    this.f64907h = this.f64906g.remove();
                }
                return iE;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void e() {
        synchronized (this.f64900a) {
            this.f64910k++;
            ((Handler) o0.j(this.f64902c)).post(new Runnable() { // from class: fh.e
                @Override // java.lang.Runnable
                public final void run() {
                    this.f64899a.m();
                }
            });
        }
    }

    public final void f() {
        if (!this.f64906g.isEmpty()) {
            this.f64908i = this.f64906g.getLast();
        }
        this.f64903d.b();
        this.f64904e.b();
        this.f64905f.clear();
        this.f64906g.clear();
        this.f64909j = null;
    }

    public MediaFormat g() {
        MediaFormat mediaFormat;
        synchronized (this.f64900a) {
            try {
                mediaFormat = this.f64907h;
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
        com.google.android.exoplayer2.util.a.g(this.f64902c == null);
        this.f64901b.start();
        Handler handler = new Handler(this.f64901b.getLooper());
        mediaCodec.setCallback(this, handler);
        this.f64902c = handler;
    }

    public final boolean i() {
        return this.f64910k > 0 || this.f64911l;
    }

    public final void j() {
        k();
        l();
    }

    public final void k() {
        IllegalStateException illegalStateException = this.f64912m;
        if (illegalStateException == null) {
            return;
        }
        this.f64912m = null;
        throw illegalStateException;
    }

    public final void l() {
        MediaCodec.CodecException codecException = this.f64909j;
        if (codecException == null) {
            return;
        }
        this.f64909j = null;
        throw codecException;
    }

    public final void m() {
        synchronized (this.f64900a) {
            try {
                if (this.f64911l) {
                    return;
                }
                long j11 = this.f64910k - 1;
                this.f64910k = j11;
                if (j11 > 0) {
                    return;
                }
                if (j11 < 0) {
                    n(new IllegalStateException());
                } else {
                    f();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void n(IllegalStateException illegalStateException) {
        synchronized (this.f64900a) {
            this.f64912m = illegalStateException;
        }
    }

    public void o() {
        synchronized (this.f64900a) {
            this.f64911l = true;
            this.f64901b.quit();
            f();
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onError(MediaCodec mediaCodec, MediaCodec.CodecException codecException) {
        synchronized (this.f64900a) {
            this.f64909j = codecException;
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onInputBufferAvailable(MediaCodec mediaCodec, int i11) {
        synchronized (this.f64900a) {
            this.f64903d.a(i11);
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onOutputBufferAvailable(MediaCodec mediaCodec, int i11, MediaCodec.BufferInfo bufferInfo) {
        synchronized (this.f64900a) {
            try {
                MediaFormat mediaFormat = this.f64908i;
                if (mediaFormat != null) {
                    b(mediaFormat);
                    this.f64908i = null;
                }
                this.f64904e.a(i11);
                this.f64905f.add(bufferInfo);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        synchronized (this.f64900a) {
            b(mediaFormat);
            this.f64908i = null;
        }
    }
}
