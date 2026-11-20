package com.applovin.impl;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import com.applovin.exoplayer2.common.base.Supplier;
import java.nio.ByteBuffer;
import java.util.Objects;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class g1 implements hd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MediaCodec f19139a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final i1 f19140b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final h1 f19141c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f19142d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f19143e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f19144f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Surface f19145g;

    /* JADX INFO: compiled from: source.java */
    public static final class b implements hd.b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Supplier f19146b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Supplier f19147c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f19148d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final boolean f19149e;

        public b(final int i11, boolean z11, boolean z12) {
            this(new Supplier() { // from class: com.applovin.impl.zv
                @Override // com.applovin.exoplayer2.common.base.Supplier
                public final Object get() {
                    return g1.b.a(i11);
                }
            }, new Supplier() { // from class: com.applovin.impl.aw
                @Override // com.applovin.exoplayer2.common.base.Supplier
                public final Object get() {
                    return g1.b.b(i11);
                }
            }, z11, z12);
        }

        public b(Supplier supplier, Supplier supplier2, boolean z11, boolean z12) {
            this.f19146b = supplier;
            this.f19147c = supplier2;
            this.f19148d = z11;
            this.f19149e = z12;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ HandlerThread a(int i11) {
            return new HandlerThread(g1.f(i11));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ HandlerThread b(int i11) {
            return new HandlerThread(g1.g(i11));
        }

        @Override // com.applovin.impl.hd.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public g1 a(hd.a aVar) throws Exception {
            MediaCodec mediaCodecCreateByCodecName;
            String str = aVar.f19471a.f20199a;
            g1 g1Var = null;
            try {
                ko.a("createCodec:" + str);
                mediaCodecCreateByCodecName = MediaCodec.createByCodecName(str);
                try {
                    g1 g1Var2 = new g1(mediaCodecCreateByCodecName, (HandlerThread) this.f19146b.get(), (HandlerThread) this.f19147c.get(), this.f19148d, this.f19149e);
                    try {
                        ko.a();
                        g1Var2.a(aVar.f19472b, aVar.f19474d, aVar.f19475e, aVar.f19476f, aVar.f19477g);
                        return g1Var2;
                    } catch (Exception e11) {
                        e = e11;
                        g1Var = g1Var2;
                        if (g1Var != null) {
                            g1Var.a();
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

    private g1(MediaCodec mediaCodec, HandlerThread handlerThread, HandlerThread handlerThread2, boolean z11, boolean z12) {
        this.f19139a = mediaCodec;
        this.f19140b = new i1(handlerThread);
        this.f19141c = new h1(mediaCodec, handlerThread2, z11);
        this.f19142d = z12;
        this.f19144f = 0;
    }

    private static String a(int i11, String str) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MediaFormat mediaFormat, Surface surface, MediaCrypto mediaCrypto, int i11, boolean z11) {
        this.f19140b.a(this.f19139a);
        ko.a("configureCodec");
        this.f19139a.configure(mediaFormat, surface, mediaCrypto, i11);
        ko.a();
        if (z11) {
            this.f19145g = this.f19139a.createInputSurface();
        }
        this.f19141c.h();
        ko.a("startCodec");
        this.f19139a.start();
        ko.a();
        this.f19144f = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(hd.c cVar, MediaCodec mediaCodec, long j11, long j12) {
        cVar.a(this, j11, j12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String f(int i11) {
        return a(i11, "ExoPlayer:MediaCodecAsyncAdapter:");
    }

    private void f() {
        if (this.f19142d) {
            try {
                this.f19141c.i();
            } catch (InterruptedException e11) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException(e11);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String g(int i11) {
        return a(i11, "ExoPlayer:MediaCodecQueueingThread:");
    }

    @Override // com.applovin.impl.hd
    public int a(MediaCodec.BufferInfo bufferInfo) {
        return this.f19140b.a(bufferInfo);
    }

    @Override // com.applovin.impl.hd
    public ByteBuffer a(int i11) {
        return this.f19139a.getInputBuffer(i11);
    }

    @Override // com.applovin.impl.hd
    public void a() {
        try {
            if (this.f19144f == 1) {
                this.f19141c.g();
                this.f19140b.h();
            }
            this.f19144f = 2;
        } finally {
            Surface surface = this.f19145g;
            if (surface != null) {
                surface.release();
            }
            if (!this.f19143e) {
                this.f19139a.release();
                this.f19143e = true;
            }
        }
    }

    @Override // com.applovin.impl.hd
    public void a(int i11, int i12, int i13, long j11, int i14) {
        this.f19141c.b(i11, i12, i13, j11, i14);
    }

    @Override // com.applovin.impl.hd
    public void a(int i11, int i12, a5 a5Var, long j11, int i13) {
        this.f19141c.a(i11, i12, a5Var, j11, i13);
    }

    @Override // com.applovin.impl.hd
    public void a(int i11, long j11) {
        this.f19139a.releaseOutputBuffer(i11, j11);
    }

    @Override // com.applovin.impl.hd
    public void a(int i11, boolean z11) {
        this.f19139a.releaseOutputBuffer(i11, z11);
    }

    @Override // com.applovin.impl.hd
    public void a(Bundle bundle) {
        f();
        this.f19139a.setParameters(bundle);
    }

    @Override // com.applovin.impl.hd
    public void a(Surface surface) {
        f();
        this.f19139a.setOutputSurface(surface);
    }

    @Override // com.applovin.impl.hd
    public void a(final hd.c cVar, Handler handler) {
        f();
        this.f19139a.setOnFrameRenderedListener(new MediaCodec.OnFrameRenderedListener() { // from class: com.applovin.impl.xv
            @Override // android.media.MediaCodec.OnFrameRenderedListener
            public final void onFrameRendered(MediaCodec mediaCodec, long j11, long j12) {
                this.f24419a.a(cVar, mediaCodec, j11, j12);
            }
        }, handler);
    }

    @Override // com.applovin.impl.hd
    public ByteBuffer b(int i11) {
        return this.f19139a.getOutputBuffer(i11);
    }

    @Override // com.applovin.impl.hd
    public void b() {
        this.f19141c.b();
        this.f19139a.flush();
        i1 i1Var = this.f19140b;
        final MediaCodec mediaCodec = this.f19139a;
        Objects.requireNonNull(mediaCodec);
        i1Var.a(new Runnable() { // from class: com.applovin.impl.yv
            @Override // java.lang.Runnable
            public final void run() {
                mediaCodec.start();
            }
        });
    }

    @Override // com.applovin.impl.hd
    public void c(int i11) {
        f();
        this.f19139a.setVideoScalingMode(i11);
    }

    @Override // com.applovin.impl.hd
    public boolean c() {
        return false;
    }

    @Override // com.applovin.impl.hd
    public int d() {
        return this.f19140b.a();
    }

    @Override // com.applovin.impl.hd
    public MediaFormat e() {
        return this.f19140b.c();
    }
}
