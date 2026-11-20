package androidx.media3.exoplayer.mediacodec;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.io.IOException;
import java.nio.ByteBuffer;
import z3.j0;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class g implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MediaCodec f10769a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public ByteBuffer[] f10770b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public ByteBuffer[] f10771c;

    /* JADX INFO: compiled from: source.java */
    public static class b implements c.b {
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0, types: [androidx.media3.exoplayer.mediacodec.g$a] */
        /* JADX WARN: Type inference failed for: r0v2 */
        /* JADX WARN: Type inference failed for: r0v3 */
        @Override // androidx.media3.exoplayer.mediacodec.c.b
        public c a(c.a aVar) throws Throwable {
            MediaCodec mediaCodec = 0;
            mediaCodec = 0;
            try {
                MediaCodec mediaCodecB = b(aVar);
                try {
                    j0.a("configureCodec");
                    mediaCodecB.configure(aVar.f10751b, aVar.f10753d, aVar.f10754e, aVar.f10755f);
                    j0.c();
                    j0.a("startCodec");
                    mediaCodecB.start();
                    j0.c();
                    return new g(mediaCodecB);
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
            z3.a.e(aVar.f10750a);
            String str = aVar.f10750a.f10756a;
            j0.a("createCodec:" + str);
            MediaCodec mediaCodecCreateByCodecName = MediaCodec.createByCodecName(str);
            j0.c();
            return mediaCodecCreateByCodecName;
        }
    }

    public g(MediaCodec mediaCodec) {
        this.f10769a = mediaCodec;
        if (u0.f81838a < 21) {
            this.f10770b = mediaCodec.getInputBuffers();
            this.f10771c = mediaCodec.getOutputBuffers();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o(c.InterfaceC0102c interfaceC0102c, MediaCodec mediaCodec, long j11, long j12) {
        interfaceC0102c.a(this, j11, j12);
    }

    @Override // androidx.media3.exoplayer.mediacodec.c
    public void a(int i11, int i12, int i13, long j11, int i14) {
        this.f10769a.queueInputBuffer(i11, i12, i13, j11, i14);
    }

    @Override // androidx.media3.exoplayer.mediacodec.c
    @RequiresApi(19)
    public void b(Bundle bundle) {
        this.f10769a.setParameters(bundle);
    }

    @Override // androidx.media3.exoplayer.mediacodec.c
    public MediaFormat c() {
        return this.f10769a.getOutputFormat();
    }

    @Override // androidx.media3.exoplayer.mediacodec.c
    @Nullable
    public ByteBuffer d(int i11) {
        return u0.f81838a >= 21 ? this.f10769a.getInputBuffer(i11) : ((ByteBuffer[]) u0.i(this.f10770b))[i11];
    }

    @Override // androidx.media3.exoplayer.mediacodec.c
    @RequiresApi(23)
    public void e(Surface surface) {
        this.f10769a.setOutputSurface(surface);
    }

    @Override // androidx.media3.exoplayer.mediacodec.c
    public void f(int i11, int i12, androidx.media3.decoder.c cVar, long j11, int i13) {
        this.f10769a.queueSecureInputBuffer(i11, i12, cVar.a(), j11, i13);
    }

    @Override // androidx.media3.exoplayer.mediacodec.c
    public void flush() {
        this.f10769a.flush();
    }

    @Override // androidx.media3.exoplayer.mediacodec.c
    public boolean g() {
        return false;
    }

    @Override // androidx.media3.exoplayer.mediacodec.c
    @RequiresApi(21)
    public void h(int i11, long j11) {
        this.f10769a.releaseOutputBuffer(i11, j11);
    }

    @Override // androidx.media3.exoplayer.mediacodec.c
    public int i() {
        return this.f10769a.dequeueInputBuffer(0L);
    }

    @Override // androidx.media3.exoplayer.mediacodec.c
    public int j(MediaCodec.BufferInfo bufferInfo) {
        int iDequeueOutputBuffer;
        do {
            iDequeueOutputBuffer = this.f10769a.dequeueOutputBuffer(bufferInfo, 0L);
            if (iDequeueOutputBuffer == -3 && u0.f81838a < 21) {
                this.f10771c = this.f10769a.getOutputBuffers();
            }
        } while (iDequeueOutputBuffer == -3);
        return iDequeueOutputBuffer;
    }

    @Override // androidx.media3.exoplayer.mediacodec.c
    public void k(int i11, boolean z11) {
        this.f10769a.releaseOutputBuffer(i11, z11);
    }

    @Override // androidx.media3.exoplayer.mediacodec.c
    @Nullable
    public ByteBuffer l(int i11) {
        return u0.f81838a >= 21 ? this.f10769a.getOutputBuffer(i11) : ((ByteBuffer[]) u0.i(this.f10771c))[i11];
    }

    @Override // androidx.media3.exoplayer.mediacodec.c
    @RequiresApi(23)
    public void m(final c.InterfaceC0102c interfaceC0102c, Handler handler) {
        this.f10769a.setOnFrameRenderedListener(new MediaCodec.OnFrameRenderedListener() { // from class: m4.c0
            @Override // android.media.MediaCodec.OnFrameRenderedListener
            public final void onFrameRendered(MediaCodec mediaCodec, long j11, long j12) {
                this.f70752a.o(interfaceC0102c, mediaCodec, j11, j12);
            }
        }, handler);
    }

    @Override // androidx.media3.exoplayer.mediacodec.c
    public void release() {
        this.f10770b = null;
        this.f10771c = null;
        this.f10769a.release();
    }

    @Override // androidx.media3.exoplayer.mediacodec.c
    public void setVideoScalingMode(int i11) {
        this.f10769a.setVideoScalingMode(i11);
    }
}
