package qg;

import android.os.Looper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.n2;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface a extends n2.d, com.google.android.exoplayer2.source.j, com.google.android.exoplayer2.upstream.e.a, com.google.android.exoplayer2.drm.b {
    void a(Exception exc);

    void b(String str);

    void c(String str);

    void d(long j11);

    void e(Exception exc);

    void g(Object obj, long j11);

    void h(Exception exc);

    void i(int i11, long j11, long j12);

    void j(long j11, int i11);

    void k(com.google.android.exoplayer2.decoder.e eVar);

    void l(com.google.android.exoplayer2.m1 m1Var, @Nullable com.google.android.exoplayer2.decoder.g gVar);

    void m();

    void n(com.google.android.exoplayer2.decoder.e eVar);

    void o(com.google.android.exoplayer2.decoder.e eVar);

    void onAudioDecoderInitialized(String str, long j11, long j12);

    void onDroppedFrames(int i11, long j11);

    void onVideoDecoderInitialized(String str, long j11, long j12);

    void r(n2 n2Var, Looper looper);

    void release();

    void s(com.google.android.exoplayer2.m1 m1Var, @Nullable com.google.android.exoplayer2.decoder.g gVar);

    void t(com.google.android.exoplayer2.decoder.e eVar);

    void x(c cVar);

    void z(List<com.google.android.exoplayer2.source.i.b> list, @Nullable com.google.android.exoplayer2.source.i.b bVar);
}
