package com.applovin.impl;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.view.Surface;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class ul implements hd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MediaCodec f23628a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Surface f23629b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ByteBuffer[] f23630c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ByteBuffer[] f23631d;

    /* JADX INFO: compiled from: source.java */
    public static final class b {
        public static Surface a(MediaCodec mediaCodec) {
            return mediaCodec.createInputSurface();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c implements hd.b {
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0, types: [com.applovin.impl.ul$a] */
        /* JADX WARN: Type inference failed for: r0v1, types: [android.view.Surface] */
        /* JADX WARN: Type inference failed for: r0v3 */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        @Override // com.applovin.impl.hd.b
        public hd a(hd.a aVar) throws Throwable {
            MediaCodec mediaCodecB;
            Surface surfaceA;
            ?? r11 = 0;
            r11 = 0;
            r11 = 0;
            try {
                mediaCodecB = b(aVar);
                try {
                    ko.a("configureCodec");
                    mediaCodecB.configure(aVar.f19472b, aVar.f19474d, aVar.f19475e, aVar.f19476f);
                    ko.a();
                    if (!aVar.f19477g) {
                        surfaceA = null;
                    } else {
                        if (xp.f24372a < 18) {
                            throw new IllegalStateException("Encoding from a surface is only supported on API 18 and up.");
                        }
                        surfaceA = b.a(mediaCodecB);
                    }
                    try {
                        ko.a("startCodec");
                        mediaCodecB.start();
                        ko.a();
                        return new ul(mediaCodecB, surfaceA);
                    } catch (IOException | RuntimeException e11) {
                        r11 = surfaceA;
                        e = e11;
                        if (r11 != 0) {
                            r11.release();
                        }
                        if (mediaCodecB != null) {
                            mediaCodecB.release();
                        }
                        throw e;
                    }
                } catch (IOException e12) {
                    e = e12;
                } catch (RuntimeException e13) {
                    e = e13;
                }
            } catch (IOException | RuntimeException e14) {
                e = e14;
                mediaCodecB = null;
            }
        }

        public MediaCodec b(hd.a aVar) throws IOException {
            b1.a(aVar.f19471a);
            String str = aVar.f19471a.f20199a;
            ko.a("createCodec:" + str);
            MediaCodec mediaCodecCreateByCodecName = MediaCodec.createByCodecName(str);
            ko.a();
            return mediaCodecCreateByCodecName;
        }
    }

    private ul(MediaCodec mediaCodec, Surface surface) {
        this.f23628a = mediaCodec;
        this.f23629b = surface;
        if (xp.f24372a < 21) {
            this.f23630c = mediaCodec.getInputBuffers();
            this.f23631d = mediaCodec.getOutputBuffers();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(hd.c cVar, MediaCodec mediaCodec, long j11, long j12) {
        cVar.a(this, j11, j12);
    }

    @Override // com.applovin.impl.hd
    public int a(MediaCodec.BufferInfo bufferInfo) {
        int iDequeueOutputBuffer;
        do {
            iDequeueOutputBuffer = this.f23628a.dequeueOutputBuffer(bufferInfo, 0L);
            if (iDequeueOutputBuffer == -3 && xp.f24372a < 21) {
                this.f23631d = this.f23628a.getOutputBuffers();
            }
        } while (iDequeueOutputBuffer == -3);
        return iDequeueOutputBuffer;
    }

    @Override // com.applovin.impl.hd
    public ByteBuffer a(int i11) {
        return xp.f24372a >= 21 ? this.f23628a.getInputBuffer(i11) : ((ByteBuffer[]) xp.a((Object) this.f23630c))[i11];
    }

    @Override // com.applovin.impl.hd
    public void a() {
        this.f23630c = null;
        this.f23631d = null;
        Surface surface = this.f23629b;
        if (surface != null) {
            surface.release();
        }
        this.f23628a.release();
    }

    @Override // com.applovin.impl.hd
    public void a(int i11, int i12, int i13, long j11, int i14) {
        this.f23628a.queueInputBuffer(i11, i12, i13, j11, i14);
    }

    @Override // com.applovin.impl.hd
    public void a(int i11, int i12, a5 a5Var, long j11, int i13) {
        this.f23628a.queueSecureInputBuffer(i11, i12, a5Var.a(), j11, i13);
    }

    @Override // com.applovin.impl.hd
    public void a(int i11, long j11) {
        this.f23628a.releaseOutputBuffer(i11, j11);
    }

    @Override // com.applovin.impl.hd
    public void a(int i11, boolean z11) {
        this.f23628a.releaseOutputBuffer(i11, z11);
    }

    @Override // com.applovin.impl.hd
    public void a(Bundle bundle) {
        this.f23628a.setParameters(bundle);
    }

    @Override // com.applovin.impl.hd
    public void a(Surface surface) {
        this.f23628a.setOutputSurface(surface);
    }

    @Override // com.applovin.impl.hd
    public void a(final hd.c cVar, Handler handler) {
        this.f23628a.setOnFrameRenderedListener(new MediaCodec.OnFrameRenderedListener() { // from class: com.applovin.impl.b70
            @Override // android.media.MediaCodec.OnFrameRenderedListener
            public final void onFrameRendered(MediaCodec mediaCodec, long j11, long j12) {
                this.f17880a.a(cVar, mediaCodec, j11, j12);
            }
        }, handler);
    }

    @Override // com.applovin.impl.hd
    public ByteBuffer b(int i11) {
        return xp.f24372a >= 21 ? this.f23628a.getOutputBuffer(i11) : ((ByteBuffer[]) xp.a((Object) this.f23631d))[i11];
    }

    @Override // com.applovin.impl.hd
    public void b() {
        this.f23628a.flush();
    }

    @Override // com.applovin.impl.hd
    public void c(int i11) {
        this.f23628a.setVideoScalingMode(i11);
    }

    @Override // com.applovin.impl.hd
    public boolean c() {
        return false;
    }

    @Override // com.applovin.impl.hd
    public int d() {
        return this.f23628a.dequeueInputBuffer(0L);
    }

    @Override // com.applovin.impl.hd
    public MediaFormat e() {
        return this.f23628a.getOutputFormat();
    }
}
