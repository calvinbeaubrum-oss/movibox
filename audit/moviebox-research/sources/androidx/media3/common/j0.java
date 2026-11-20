package androidx.media3.common;

import android.content.Context;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public interface j0 extends s0 {

    /* JADX INFO: compiled from: source.java */
    public interface a {
        j0 a(Context context, k kVar, k kVar2, n nVar, s0.a aVar, Executor executor, List<p> list, long j11) throws VideoFrameProcessingException;
    }

    void b(long j11);
}
