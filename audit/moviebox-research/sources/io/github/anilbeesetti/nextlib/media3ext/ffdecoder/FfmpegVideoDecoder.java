package io.github.anilbeesetti.nextlib.media3ext.ffdecoder;

import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.media3.common.y;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.decoder.SimpleDecoder;
import androidx.media3.decoder.VideoDecoderOutputBuffer;
import androidx.media3.decoder.h;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.nio.ByteBuffer;
import java.util.List;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
final class FfmpegVideoDecoder extends SimpleDecoder<DecoderInputBuffer, VideoDecoderOutputBuffer, FfmpegDecoderException> {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f67279o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f67280p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @Nullable
    public final byte[] f67281q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public y f67282r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public volatile int f67283s;

    public FfmpegVideoDecoder(int i11, int i12, int i13, int i14, y yVar) throws FfmpegDecoderException {
        super(new DecoderInputBuffer[i11], new VideoDecoderOutputBuffer[i12]);
        if (!FfmpegLibrary.d()) {
            throw new FfmpegDecoderException("Failed to load decoder native library.");
        }
        String str = (String) z3.a.e(FfmpegLibrary.a(yVar.f9501m));
        this.f67279o = str;
        byte[] bArrX = x(yVar.f9501m, yVar.f9503o);
        this.f67281q = bArrX;
        this.f67282r = yVar;
        long jFfmpegInitialize = ffmpegInitialize(str, bArrX, i14);
        this.f67280p = jFfmpegInitialize;
        if (jFfmpegInitialize == 0) {
            throw new FfmpegDecoderException("Failed to initialize decoder.");
        }
        s(i13);
    }

    private native long ffmpegInitialize(String str, @Nullable byte[] bArr, int i11);

    private native int ffmpegReceiveFrame(long j11, int i11, VideoDecoderOutputBuffer videoDecoderOutputBuffer, boolean z11);

    private native void ffmpegRelease(long j11);

    private native int ffmpegRenderFrame(long j11, Surface surface, VideoDecoderOutputBuffer videoDecoderOutputBuffer, int i11, int i12);

    private native long ffmpegReset(long j11);

    private native int ffmpegSendPacket(long j11, ByteBuffer byteBuffer, int i11, long j12);

    @Nullable
    private static byte[] x(String str, List<byte[]> list) {
        if (list.isEmpty()) {
            return null;
        }
        str.hashCode();
        if (str.equals(MimeTypes.VIDEO_H265)) {
            return list.get(0);
        }
        if (!str.equals(MimeTypes.VIDEO_H264)) {
            return null;
        }
        byte[] bArr = list.get(0);
        byte[] bArr2 = list.get(1);
        byte[] bArr3 = new byte[bArr.length + bArr2.length];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    public void A(int i11) {
        this.f67283s = i11;
    }

    @Override // androidx.media3.decoder.SimpleDecoder
    public DecoderInputBuffer e() {
        return new DecoderInputBuffer(2);
    }

    @Override // androidx.media3.decoder.g
    public String getName() {
        return "ffmpeg" + FfmpegLibrary.c() + "-" + this.f67279o;
    }

    @Override // androidx.media3.decoder.SimpleDecoder, androidx.media3.decoder.g
    public void release() {
        super.release();
        ffmpegRelease(this.f67280p);
        this.f67280p = 0L;
    }

    @Override // androidx.media3.decoder.SimpleDecoder
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public VideoDecoderOutputBuffer f() {
        return new VideoDecoderOutputBuffer(new h.a() { // from class: io.github.anilbeesetti.nextlib.media3ext.ffdecoder.c
            @Override // androidx.media3.decoder.h.a
            public final void a(h hVar) {
                this.f67285a.p((VideoDecoderOutputBuffer) hVar);
            }
        });
    }

    @Override // androidx.media3.decoder.SimpleDecoder
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public FfmpegDecoderException g(Throwable th2) {
        return new FfmpegDecoderException("Unexpected decode error", th2);
    }

    @Override // androidx.media3.decoder.SimpleDecoder
    @Nullable
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public FfmpegDecoderException h(DecoderInputBuffer decoderInputBuffer, VideoDecoderOutputBuffer videoDecoderOutputBuffer, boolean z11) {
        if (z11) {
            long jFfmpegReset = ffmpegReset(this.f67280p);
            this.f67280p = jFfmpegReset;
            if (jFfmpegReset == 0) {
                return new FfmpegDecoderException("Error resetting (see logcat).");
            }
        }
        ByteBuffer byteBuffer = (ByteBuffer) u0.i(decoderInputBuffer.f9780c);
        int iFfmpegSendPacket = ffmpegSendPacket(this.f67280p, byteBuffer, byteBuffer.limit(), decoderInputBuffer.f9782f);
        if (iFfmpegSendPacket == -1) {
            videoDecoderOutputBuffer.setFlags(Integer.MIN_VALUE);
            return null;
        }
        if (iFfmpegSendPacket == -3) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("VIDEO_DECODER_ERROR_READ_FRAME: timeUs=");
            sb2.append(decoderInputBuffer.f9782f);
        } else if (iFfmpegSendPacket == -2) {
            return new FfmpegDecoderException("ffmpegDecode error: (see logcat)");
        }
        boolean zIsDecodeOnly = decoderInputBuffer.isDecodeOnly();
        int iFfmpegReceiveFrame = ffmpegReceiveFrame(this.f67280p, this.f67283s, videoDecoderOutputBuffer, zIsDecodeOnly);
        if (iFfmpegReceiveFrame == -2) {
            return new FfmpegDecoderException("ffmpegDecode error: (see logcat)");
        }
        if (iFfmpegReceiveFrame == -1) {
            videoDecoderOutputBuffer.addFlag(Integer.MIN_VALUE);
        }
        if (!zIsDecodeOnly) {
            videoDecoderOutputBuffer.format = decoderInputBuffer.f9778a;
        }
        return null;
    }

    public void z(VideoDecoderOutputBuffer videoDecoderOutputBuffer, Surface surface) throws FfmpegDecoderException {
        if (videoDecoderOutputBuffer.mode != 1) {
            throw new FfmpegDecoderException("Invalid output mode.");
        }
        if (ffmpegRenderFrame(this.f67280p, surface, videoDecoderOutputBuffer, videoDecoderOutputBuffer.width, videoDecoderOutputBuffer.height) == -2) {
            throw new FfmpegDecoderException("Buffer render error: ");
        }
    }
}
