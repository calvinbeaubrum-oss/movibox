package androidx.media3.exoplayer.source;

import android.net.Uri;
import e4.x3;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import u4.l0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public interface o {

    /* JADX INFO: compiled from: source.java */
    public interface a {
        o a(x3 x3Var);
    }

    void a();

    long b();

    void c(androidx.media3.common.l lVar, Uri uri, Map<String, List<String>> map, long j11, long j12, u4.u uVar) throws IOException;

    int d(l0 l0Var) throws IOException;

    void release();

    void seek(long j11, long j12);
}
