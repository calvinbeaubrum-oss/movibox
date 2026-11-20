package q4;

import androidx.media3.exoplayer.b3;
import androidx.media3.exoplayer.w1;
import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public interface i {
    long b(long j11, b3 b3Var);

    boolean c(e eVar, boolean z11, androidx.media3.exoplayer.upstream.m.c cVar, androidx.media3.exoplayer.upstream.m mVar);

    boolean d(long j11, e eVar, List<? extends m> list);

    void e(w1 w1Var, long j11, List<? extends m> list, g gVar);

    void f(e eVar);

    int getPreferredQueueSize(long j11, List<? extends m> list);

    void maybeThrowError() throws IOException;

    void release();
}
