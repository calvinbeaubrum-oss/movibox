package io.github.anilbeesetti.nextlib.media3ext.ffdecoder;

import android.os.Handler;
import androidx.annotation.Nullable;
import androidx.media3.common.f0;
import androidx.media3.common.y;
import androidx.media3.exoplayer.audio.AudioSink;
import androidx.media3.exoplayer.audio.e;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import z3.j0;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class b extends e<FfmpegAudioDecoder> {
    public b(@Nullable Handler handler, @Nullable androidx.media3.exoplayer.audio.c cVar, AudioSink audioSink) {
        super(handler, cVar, audioSink);
    }

    @Override // androidx.media3.exoplayer.w2, androidx.media3.exoplayer.y2
    public String getName() {
        return "FfmpegAudioRenderer";
    }

    @Override // androidx.media3.exoplayer.audio.e
    public int h0(y yVar) {
        String str = (String) z3.a.e(yVar.f9501m);
        if (!FfmpegLibrary.d() || !f0.o(str)) {
            return 0;
        }
        if (!FfmpegLibrary.e(str)) {
            return 1;
        }
        if (m0(yVar, 2) || m0(yVar, 4)) {
            return yVar.I != 0 ? 2 : 4;
        }
        return 1;
    }

    @Override // androidx.media3.exoplayer.audio.e
    /* JADX INFO: renamed from: j0, reason: merged with bridge method [inline-methods] */
    public FfmpegAudioDecoder Q(y yVar, @Nullable androidx.media3.decoder.b bVar) throws FfmpegDecoderException {
        j0.a("createFfmpegAudioDecoder");
        int i11 = yVar.f9502n;
        FfmpegAudioDecoder ffmpegAudioDecoder = new FfmpegAudioDecoder(yVar, 16, 16, i11 != -1 ? i11 : 5760, l0(yVar));
        j0.c();
        return ffmpegAudioDecoder;
    }

    @Override // androidx.media3.exoplayer.audio.e
    /* JADX INFO: renamed from: k0, reason: merged with bridge method [inline-methods] */
    public y V(FfmpegAudioDecoder ffmpegAudioDecoder) {
        z3.a.e(ffmpegAudioDecoder);
        return new y.b().k0(MimeTypes.AUDIO_RAW).L(ffmpegAudioDecoder.y()).l0(ffmpegAudioDecoder.B()).e0(ffmpegAudioDecoder.z()).I();
    }

    public final boolean l0(y yVar) {
        if (!m0(yVar, 2)) {
            return true;
        }
        if (W(u0.k0(4, yVar.f9514z, yVar.A)) != 2) {
            return false;
        }
        return !MimeTypes.AUDIO_AC3.equals(yVar.f9501m);
    }

    public final boolean m0(y yVar, int i11) {
        return g0(u0.k0(i11, yVar.f9514z, yVar.A));
    }

    @Override // androidx.media3.exoplayer.m, androidx.media3.exoplayer.y2
    public int supportsMixedMimeTypeAdaptation() {
        return 8;
    }
}
