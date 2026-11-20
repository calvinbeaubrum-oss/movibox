package androidx.media3.ui;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public interface o0 {

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void f(o0 o0Var, long j11);

        void p(o0 o0Var, long j11);

        void r(o0 o0Var, long j11, boolean z11);
    }

    void addListener(a aVar);

    long getPreferredUpdateDelay();

    void setAdGroupTimesMs(@Nullable long[] jArr, @Nullable boolean[] zArr, int i11);

    void setBufferedPosition(long j11);

    void setDuration(long j11);

    void setEnabled(boolean z11);

    void setPosition(long j11);
}
