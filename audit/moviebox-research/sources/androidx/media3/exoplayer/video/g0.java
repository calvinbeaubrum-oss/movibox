package androidx.media3.exoplayer.video;

import android.view.Surface;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public interface g0 {
    void a(p pVar);

    void c(o oVar);

    void d(z3.d dVar);

    void e(List<androidx.media3.common.p> list);

    p f();

    void g(androidx.media3.common.y yVar) throws VideoSink.VideoSinkException;

    void i();

    boolean isInitialized();

    void j(Surface surface, z3.e0 e0Var);

    VideoSink k();

    void l(long j11);

    void release();
}
