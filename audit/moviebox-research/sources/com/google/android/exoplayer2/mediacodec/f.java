package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.util.l0;
import com.google.android.exoplayer2.util.o0;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class f implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MediaCodec f33565a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public ByteBuffer[] f33566b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public ByteBuffer[] f33567c;

    /* JADX INFO: compiled from: source.java */
    public static class b implements c.b {
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.exoplayer2.mediacodec.f$a] */
        /* JADX WARN: Type inference failed for: r0v2 */
        /* JADX WARN: Type inference failed for: r0v3 */
        @Override // com.google.android.exoplayer2.mediacodec.c.b
        public c a(c.a aVar) throws Throwable {
            MediaCodec mediaCodec = 0;
            mediaCodec = 0;
            try {
                MediaCodec mediaCodecB = b(aVar);
                try {
                    l0.a("configureCodec");
                    mediaCodecB.configure(aVar.f33548b, aVar.f33550d, aVar.f33551e, aVar.f33552f);
                    l0.c();
                    l0.a("startCodec");
                    mediaCodecB.start();
                    l0.c();
                    return new f(mediaCodecB);
                } catch (IOException | RuntimeException e11) {
                    e = e11;
                    mediaCodec = mediaCodecB;
                    if (mediaCodec != 0) {
                        mediaCodec.release();
                    }
                    throw e;
                }
            } catch (IOException e12) {
                e = e12;
            } catch (RuntimeException e13) {
                e = e13;
            }
        }

        public MediaCodec b(c.a aVar) throws IOException {
            com.google.android.exoplayer2.util.a.e(aVar.f33547a);
            String str = aVar.f33547a.f33553a;
            l0.a("createCodec:" + str);
            MediaCodec mediaCodecCreateByCodecName = MediaCodec.createByCodecName(str);
            l0.c();
            return mediaCodecCreateByCodecName;
        }
    }

    public f(MediaCodec mediaCodec) {
        this.f33565a = mediaCodec;
        if (o0.f35608a < 21) {
            this.f33566b = mediaCodec.getInputBuffers();
            this.f33567c = mediaCodec.getOutputBuffers();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o(c.InterfaceC0362c interfaceC0362c, MediaCodec mediaCodec, long j11, long j12) {
        interfaceC0362c.a(this, j11, j12);
    }

    @Override // com.google.android.exoplayer2.mediacodec.c
    public void a(int i11, int i12, int i13, long j11, int i14) {
        this.f33565a.queueInputBuffer(i11, i12, i13, j11, i14);
    }

    @Override // com.google.android.exoplayer2.mediacodec.c
    @RequiresApi(19)
    public void b(Bundle bundle) {
        this.f33565a.setParameters(bundle);
    }

    @Override // com.google.android.exoplayer2.mediacodec.c
    public MediaFormat c() {
        return this.f33565a.getOutputFormat();
    }

    @Override // com.google.android.exoplayer2.mediacodec.c
    @Nullable
    public ByteBuffer d(int i11) {
        return o0.f35608a >= 21 ? this.f33565a.getInputBuffer(i11) : ((ByteBuffer[]) o0.j(this.f33566b))[i11];
    }

    @Override // com.google.android.exoplayer2.mediacodec.c
    @RequiresApi(23)
    public void e(Surface surface) {
        this.f33565a.setOutputSurface(surface);
    }

    @Override // com.google.android.exoplayer2.mediacodec.c
    public void f(int i11, int i12, com.google.android.exoplayer2.decoder.c cVar, long j11, int i13) {
        this.f33565a.queueSecureInputBuffer(i11, i12, cVar.a(), j11, i13);
    }

    @Override // com.google.android.exoplayer2.mediacodec.c
    public void flush() {
        this.f33565a.flush();
    }

    @Override // com.google.android.exoplayer2.mediacodec.c
    public boolean g() {
        return false;
    }

    @Override // com.google.android.exoplayer2.mediacodec.c
    @RequiresApi(21)
    public void h(int i11, long j11) {
        this.f33565a.releaseOutputBuffer(i11, j11);
    }

    @Override // com.google.android.exoplayer2.mediacodec.c
    public int i() {
        return this.f33565a.dequeueInputBuffer(0L);
    }

    @Override // com.google.android.exoplayer2.mediacodec.c
    public int j(MediaCodec.BufferInfo bufferInfo) {
        int iDequeueOutputBuffer;
        do {
            iDequeueOutputBuffer = this.f33565a.dequeueOutputBuffer(bufferInfo, 0L);
            if (iDequeueOutputBuffer == -3 && o0.f35608a < 21) {
                this.f33567c = this.f33565a.getOutputBuffers();
            }
        } while (iDequeueOutputBuffer == -3);
        return iDequeueOutputBuffer;
    }

    @Override // com.google.android.exoplayer2.mediacodec.c
    public void k(int i11, boolean z11) {
        this.f33565a.releaseOutputBuffer(i11, z11);
    }

    @Override // com.google.android.exoplayer2.mediacodec.c
    @Nullable
    public ByteBuffer l(int i11) {
        return o0.f35608a >= 21 ? this.f33565a.getOutputBuffer(i11) : ((ByteBuffer[]) o0.j(this.f33567c))[i11];
    }

    @Override // com.google.android.exoplayer2.mediacodec.c
    @RequiresApi(23)
    public void m(final c.InterfaceC0362c interfaceC0362c, Handler handler) {
        this.f33565a.setOnFrameRenderedListener(new MediaCodec.OnFrameRenderedListener() { // from class: fh.o
            @Override // android.media.MediaCodec.OnFrameRenderedListener
            public final void onFrameRendered(MediaCodec mediaCodec, long j11, long j12) {
                this.f64926a.o(interfaceC0362c, mediaCodec, j11, j12);
            }
        }, handler);
    }

    @Override // com.google.android.exoplayer2.mediacodec.c
    public void release() {
        this.f33566b = null;
        this.f33567c = null;
        this.f33565a.release();
    }

    @Override // com.google.android.exoplayer2.mediacodec.c
    public void setVideoScalingMode(int i11) {
        this.f33565a.setVideoScalingMode(i11);
    }
}
