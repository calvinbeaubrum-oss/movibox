package mg;

import androidx.annotation.Nullable;
import java.io.Closeable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface d extends Closeable {
    int B();

    void C(Iterable<k> iterable);

    void G(com.google.android.datatransport.runtime.o oVar, long j11);

    Iterable<com.google.android.datatransport.runtime.o> H();

    long O(com.google.android.datatransport.runtime.o oVar);

    boolean P(com.google.android.datatransport.runtime.o oVar);

    void Q(Iterable<k> iterable);

    Iterable<k> T(com.google.android.datatransport.runtime.o oVar);

    @Nullable
    k o0(com.google.android.datatransport.runtime.o oVar, com.google.android.datatransport.runtime.i iVar);
}
