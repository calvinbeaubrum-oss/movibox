package ph;

import com.google.android.exoplayer2.b3;
import com.google.android.exoplayer2.upstream.z;
import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface j {
    long a(long j11, b3 b3Var);

    void d(f fVar);

    boolean e(f fVar, boolean z11, z.c cVar, z zVar);

    void g(long j11, long j12, List<? extends n> list, h hVar);

    int getPreferredQueueSize(long j11, List<? extends n> list);

    boolean h(long j11, f fVar, List<? extends n> list);

    void maybeThrowError() throws IOException;

    void release();
}
