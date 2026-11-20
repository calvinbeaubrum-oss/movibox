package io.github.anilbeesetti.nextlib.media3ext.ffdecoder;

import android.os.Handler;
import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.media3.common.y;
import androidx.media3.decoder.DecoderException;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.decoder.VideoDecoderOutputBuffer;
import androidx.media3.decoder.g;
import androidx.media3.exoplayer.video.f0;
import androidx.media3.exoplayer.video.h;
import androidx.media3.exoplayer.x2;
import z3.j0;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class d extends h {

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static final int f67286d0 = ((u0.k(1280, 64) * u0.k(720, 64)) * 6144) / 2;
    public final int Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public final int f67287a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public final int f67288b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    @Nullable
    public FfmpegVideoDecoder f67289c0;

    public d(long j11, @Nullable Handler handler, @Nullable f0 f0Var, int i11) {
        this(j11, handler, f0Var, i11, Runtime.getRuntime().availableProcessors(), 4, 4);
    }

    public d(long j11, @Nullable Handler handler, @Nullable f0 f0Var, int i11, int i12, int i13, int i14) {
        super(j11, handler, f0Var, i11);
        this.f67288b0 = i12;
        this.Z = i13;
        this.f67287a0 = i14;
    }

    @Override // androidx.media3.exoplayer.video.h
    public g<DecoderInputBuffer, ? extends VideoDecoderOutputBuffer, ? extends DecoderException> O(y yVar, @Nullable androidx.media3.decoder.b bVar) throws DecoderException {
        j0.a("createFfmpegVideoDecoder");
        int i11 = yVar.f9502n;
        if (i11 == -1) {
            i11 = f67286d0;
        }
        FfmpegVideoDecoder ffmpegVideoDecoder = new FfmpegVideoDecoder(this.Z, this.f67287a0, i11, this.f67288b0, yVar);
        this.f67289c0 = ffmpegVideoDecoder;
        j0.c();
        return ffmpegVideoDecoder;
    }

    @Override // androidx.media3.exoplayer.y2
    public final int a(y yVar) {
        String str = (String) z3.a.e(yVar.f9501m);
        if (!FfmpegLibrary.d() || !androidx.media3.common.f0.s(str)) {
            return 0;
        }
        if (FfmpegLibrary.e(yVar.f9501m)) {
            return yVar.f9504p != null ? x2.a(2) : x2.b(4, 16, 0);
        }
        return x2.a(1);
    }

    @Override // androidx.media3.exoplayer.w2, androidx.media3.exoplayer.y2
    public String getName() {
        return "FfmpegVideoRenderer";
    }

    @Override // androidx.media3.exoplayer.video.h
    public void n0(VideoDecoderOutputBuffer videoDecoderOutputBuffer, Surface surface) throws FfmpegDecoderException {
        FfmpegVideoDecoder ffmpegVideoDecoder = this.f67289c0;
        if (ffmpegVideoDecoder == null) {
            throw new FfmpegDecoderException("Failed to render output buffer to surface: decoder is not initialized.");
        }
        ffmpegVideoDecoder.z(videoDecoderOutputBuffer, surface);
        videoDecoderOutputBuffer.release();
    }

    @Override // androidx.media3.exoplayer.video.h
    public void p0(int i11) {
        FfmpegVideoDecoder ffmpegVideoDecoder = this.f67289c0;
        if (ffmpegVideoDecoder != null) {
            ffmpegVideoDecoder.A(i11);
        }
    }
}
