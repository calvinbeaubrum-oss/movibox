package com.applovin.impl;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import java.util.ArrayDeque;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class i1 extends MediaCodec.Callback {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final HandlerThread f19579b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Handler f19580c;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private MediaFormat f19585h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private MediaFormat f19586i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private MediaCodec.CodecException f19587j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f19588k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f19589l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private IllegalStateException f19590m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f19578a = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ob f19581d = new ob();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ob f19582e = new ob();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ArrayDeque f19583f = new ArrayDeque();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ArrayDeque f19584g = new ArrayDeque();

    public i1(HandlerThread handlerThread) {
        this.f19579b = handlerThread;
    }

    private void a(MediaFormat mediaFormat) {
        this.f19582e.a(-2);
        this.f19584g.add(mediaFormat);
    }

    private void a(IllegalStateException illegalStateException) {
        synchronized (this.f19578a) {
            this.f19590m = illegalStateException;
        }
    }

    private void b() {
        if (!this.f19584g.isEmpty()) {
            this.f19586i = (MediaFormat) this.f19584g.getLast();
        }
        this.f19581d.a();
        this.f19582e.a();
        this.f19583f.clear();
        this.f19584g.clear();
        this.f19587j = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void b(Runnable runnable) {
        synchronized (this.f19578a) {
            d(runnable);
        }
    }

    private void d(Runnable runnable) {
        if (this.f19589l) {
            return;
        }
        long j11 = this.f19588k - 1;
        this.f19588k = j11;
        if (j11 > 0) {
            return;
        }
        if (j11 < 0) {
            a(new IllegalStateException());
            return;
        }
        b();
        try {
            runnable.run();
        } catch (IllegalStateException e11) {
            a(e11);
        } catch (Exception e12) {
            a(new IllegalStateException(e12));
        }
    }

    private boolean d() {
        return this.f19588k > 0 || this.f19589l;
    }

    private void e() {
        f();
        g();
    }

    private void f() {
        IllegalStateException illegalStateException = this.f19590m;
        if (illegalStateException == null) {
            return;
        }
        this.f19590m = null;
        throw illegalStateException;
    }

    private void g() {
        MediaCodec.CodecException codecException = this.f19587j;
        if (codecException == null) {
            return;
        }
        this.f19587j = null;
        throw codecException;
    }

    public int a() {
        synchronized (this.f19578a) {
            try {
                int iD = -1;
                if (d()) {
                    return -1;
                }
                e();
                if (!this.f19581d.c()) {
                    iD = this.f19581d.d();
                }
                return iD;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public int a(MediaCodec.BufferInfo bufferInfo) {
        synchronized (this.f19578a) {
            try {
                if (d()) {
                    return -1;
                }
                e();
                if (this.f19582e.c()) {
                    return -1;
                }
                int iD = this.f19582e.d();
                if (iD >= 0) {
                    b1.b(this.f19585h);
                    MediaCodec.BufferInfo bufferInfo2 = (MediaCodec.BufferInfo) this.f19583f.remove();
                    bufferInfo.set(bufferInfo2.offset, bufferInfo2.size, bufferInfo2.presentationTimeUs, bufferInfo2.flags);
                } else if (iD == -2) {
                    this.f19585h = (MediaFormat) this.f19584g.remove();
                }
                return iD;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void a(MediaCodec mediaCodec) {
        b1.b(this.f19580c == null);
        this.f19579b.start();
        Handler handler = new Handler(this.f19579b.getLooper());
        mediaCodec.setCallback(this, handler);
        this.f19580c = handler;
    }

    public void a(final Runnable runnable) {
        synchronized (this.f19578a) {
            this.f19588k++;
            ((Handler) xp.a(this.f19580c)).post(new Runnable() { // from class: com.applovin.impl.ky
                @Override // java.lang.Runnable
                public final void run() {
                    this.f20292a.b(runnable);
                }
            });
        }
    }

    public MediaFormat c() {
        MediaFormat mediaFormat;
        synchronized (this.f19578a) {
            try {
                mediaFormat = this.f19585h;
                if (mediaFormat == null) {
                    throw new IllegalStateException();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return mediaFormat;
    }

    public void h() {
        synchronized (this.f19578a) {
            this.f19589l = true;
            this.f19579b.quit();
            b();
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onError(MediaCodec mediaCodec, MediaCodec.CodecException codecException) {
        synchronized (this.f19578a) {
            this.f19587j = codecException;
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onInputBufferAvailable(MediaCodec mediaCodec, int i11) {
        synchronized (this.f19578a) {
            this.f19581d.a(i11);
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onOutputBufferAvailable(MediaCodec mediaCodec, int i11, MediaCodec.BufferInfo bufferInfo) {
        synchronized (this.f19578a) {
            try {
                MediaFormat mediaFormat = this.f19586i;
                if (mediaFormat != null) {
                    a(mediaFormat);
                    this.f19586i = null;
                }
                this.f19582e.a(i11);
                this.f19583f.add(bufferInfo);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        synchronized (this.f19578a) {
            a(mediaFormat);
            this.f19586i = null;
        }
    }
}
