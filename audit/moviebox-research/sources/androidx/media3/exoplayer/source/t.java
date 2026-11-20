package androidx.media3.exoplayer.source;

import androidx.media3.exoplayer.w1;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public interface t {

    /* JADX INFO: compiled from: source.java */
    public interface a<T extends t> {
        void h(T t11);
    }

    boolean a(w1 w1Var);

    long getBufferedPositionUs();

    long getNextLoadPositionUs();

    boolean isLoading();

    void reevaluateBuffer(long j11);
}
