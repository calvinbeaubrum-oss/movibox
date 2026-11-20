package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.util.l0;
import com.google.common.base.q;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(23)
public final class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MediaCodec f33536a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final fh.f f33537b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final fh.d f33538c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f33539d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f33540e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f33541f;

    /* JADX INFO: compiled from: source.java */
    public static final class b implements c.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final q<HandlerThread> f33542a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final q<HandlerThread> f33543b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f33544c;

        public b(final int i11, boolean z11) {
            this(new q() { // from class: fh.b
                @Override // com.google.common.base.q
                /* JADX INFO: renamed from: get */
                public final Object get2() {
                    return com.google.android.exoplayer2.mediacodec.a.b.e(i11);
                }
            }, new q() { // from class: fh.c
                @Override // com.google.common.base.q
                /* JADX INFO: renamed from: get */
                public final Object get2() {
                    return com.google.android.exoplayer2.mediacodec.a.b.f(i11);
                }
            }, z11);
        }

        public b(q<HandlerThread> qVar, q<HandlerThread> qVar2, boolean z11) {
            this.f33542a = qVar;
            this.f33543b = qVar2;
            this.f33544c = z11;
        }

        public static /* synthetic */ HandlerThread e(int i11) {
            return new HandlerThread(a.r(i11));
        }

        public static /* synthetic */ HandlerThread f(int i11) {
            return new HandlerThread(a.s(i11));
        }

        @Override // com.google.android.exoplayer2.mediacodec.c.b
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public a a(c.a aVar) throws Exception {
            MediaCodec mediaCodecCreateByCodecName;
            String str = aVar.f33547a.f33553a;
            a aVar2 = null;
            try {
                l0.a("createCodec:" + str);
                mediaCodecCreateByCodecName = MediaCodec.createByCodecName(str);
                try {
                    a aVar3 = new a(mediaCodecCreateByCodecName, this.f33542a.get2(), this.f33543b.get2(), this.f33544c);
                    try {
                        l0.c();
                        aVar3.u(aVar.f33548b, aVar.f33550d, aVar.f33551e, aVar.f33552f);
                        return aVar3;
                    } catch (Exception e11) {
                        e = e11;
                        aVar2 = aVar3;
                        if (aVar2 != null) {
                            aVar2.release();
                        } else if (mediaCodecCreateByCodecName != null) {
                            mediaCodecCreateByCodecName.release();
                        }
                        throw e;
                    }
                } catch (Exception e12) {
                    e = e12;
                }
            } catch (Exception e13) {
                e = e13;
                mediaCodecCreateByCodecName = null;
            }
        }
    }

    public a(MediaCodec mediaCodec, HandlerThread handlerThread, HandlerThread handlerThread2, boolean z11) {
        this.f33536a = mediaCodec;
        this.f33537b = new fh.f(handlerThread);
        this.f33538c = new fh.d(mediaCodec, handlerThread2);
        this.f33539d = z11;
        this.f33541f = 0;
    }

    public static String r(int i11) {
        return t(i11, "ExoPlayer:MediaCodecAsyncAdapter:");
    }

    public static String s(int i11) {
        return t(i11, "ExoPlayer:MediaCodecQueueingThread:");
    }

    public static String t(int i11, String str) {
        StringBuilder sb2 = new StringBuilder(str);
        if (i11 == 1) {
            sb2.append("Audio");
        } else if (i11 == 2) {
            sb2.append("Video");
        } else {
            sb2.append("Unknown(");
            sb2.append(i11);
            sb2.append(")");
        }
        return sb2.toString();
    }

    @Override // com.google.android.exoplayer2.mediacodec.c
    public void a(int i11, int i12, int i13, long j11, int i14) {
        this.f33538c.m(i11, i12, i13, j11, i14);
    }

    @Override // com.google.android.exoplayer2.mediacodec.c
    public void b(Bundle bundle) {
        w();
        this.f33536a.setParameters(bundle);
    }

    @Override // com.google.android.exoplayer2.mediacodec.c
    public MediaFormat c() {
        return this.f33537b.g();
    }

    @Override // com.google.android.exoplayer2.mediacodec.c
    @Nullable
    public ByteBuffer d(int i11) {
        return this.f33536a.getInputBuffer(i11);
    }

    @Override // com.google.android.exoplayer2.mediacodec.c
    public void e(Surface surface) {
        w();
        this.f33536a.setOutputSurface(surface);
    }

    @Override // com.google.android.exoplayer2.mediacodec.c
    public void f(int i11, int i12, com.google.android.exoplayer2.decoder.c cVar, long j11, int i13) {
        this.f33538c.n(i11, i12, cVar, j11, i13);
    }

    @Override // com.google.android.exoplayer2.mediacodec.c
    public void flush() {
        this.f33538c.i();
        this.f33536a.flush();
        this.f33537b.e();
        this.f33536a.start();
    }

    @Override // com.google.android.exoplayer2.mediacodec.c
    public boolean g() {
        return false;
    }

    @Override // com.google.android.exoplayer2.mediacodec.c
    public void h(int i11, long j11) {
        this.f33536a.releaseOutputBuffer(i11, j11);
    }

    @Override // com.google.android.exoplayer2.mediacodec.c
    public int i() {
        return this.f33537b.c();
    }

    @Override // com.google.android.exoplayer2.mediacodec.c
    public int j(MediaCodec.BufferInfo bufferInfo) {
        return this.f33537b.d(bufferInfo);
    }

    @Override // com.google.android.exoplayer2.mediacodec.c
    public void k(int i11, boolean z11) {
        this.f33536a.releaseOutputBuffer(i11, z11);
    }

    @Override // com.google.android.exoplayer2.mediacodec.c
    @Nullable
    public ByteBuffer l(int i11) {
        return this.f33536a.getOutputBuffer(i11);
    }

    @Override // com.google.android.exoplayer2.mediacodec.c
    public void m(final c.InterfaceC0362c interfaceC0362c, Handler handler) {
        w();
        this.f33536a.setOnFrameRenderedListener(new MediaCodec.OnFrameRenderedListener() { // from class: fh.a
            @Override // android.media.MediaCodec.OnFrameRenderedListener
            public final void onFrameRendered(MediaCodec mediaCodec, long j11, long j12) {
                this.f64880a.v(interfaceC0362c, mediaCodec, j11, j12);
            }
        }, handler);
    }

    @Override // com.google.android.exoplayer2.mediacodec.c
    public void release() {
        try {
            if (this.f33541f == 1) {
                this.f33538c.p();
                this.f33537b.o();
            }
            this.f33541f = 2;
        } finally {
            if (!this.f33540e) {
                this.f33536a.release();
                this.f33540e = true;
            }
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.c
    public void setVideoScalingMode(int i11) {
        w();
        this.f33536a.setVideoScalingMode(i11);
    }

    public final void u(@Nullable MediaFormat mediaFormat, @Nullable Surface surface, @Nullable MediaCrypto mediaCrypto, int i11) {
        this.f33537b.h(this.f33536a);
        l0.a("configureCodec");
        this.f33536a.configure(mediaFormat, surface, mediaCrypto, i11);
        l0.c();
        this.f33538c.q();
        l0.a("startCodec");
        this.f33536a.start();
        l0.c();
        this.f33541f = 1;
    }

    public final /* synthetic */ void v(c.InterfaceC0362c interfaceC0362c, MediaCodec mediaCodec, long j11, long j12) {
        interfaceC0362c.a(this, j11, j12);
    }

    public final void w() {
        if (this.f33539d) {
            try {
                this.f33538c.r();
            } catch (InterruptedException e11) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException(e11);
            }
        }
    }
}
