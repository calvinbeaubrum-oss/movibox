package e4;

import android.os.Looper;
import androidx.annotation.Nullable;
import androidx.media3.exoplayer.audio.AudioSink;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public interface a extends androidx.media3.common.h0.d, androidx.media3.exoplayer.source.m, androidx.media3.exoplayer.upstream.e.a, androidx.media3.exoplayer.drm.b {
    void C(c cVar);

    void G(androidx.media3.common.h0 h0Var, Looper looper);

    void a(Exception exc);

    void b(String str);

    void c(String str);

    void d(long j11);

    void e(Exception exc);

    void g(Object obj, long j11);

    void h(Exception exc);

    void i(int i11, long j11, long j12);

    void j(long j11, int i11);

    void k(AudioSink.a aVar);

    void l(AudioSink.a aVar);

    void m();

    void n(androidx.media3.exoplayer.n nVar);

    void o(androidx.media3.exoplayer.n nVar);

    void onAudioDecoderInitialized(String str, long j11, long j12);

    void onDroppedFrames(int i11, long j11);

    void onVideoDecoderInitialized(String str, long j11, long j12);

    void q(List<androidx.media3.exoplayer.source.l.b> list, @Nullable androidx.media3.exoplayer.source.l.b bVar);

    void release();

    void s(androidx.media3.common.y yVar, @Nullable androidx.media3.exoplayer.o oVar);

    void t(androidx.media3.exoplayer.n nVar);

    void w(androidx.media3.common.y yVar, @Nullable androidx.media3.exoplayer.o oVar);

    void x(androidx.media3.exoplayer.n nVar);
}
