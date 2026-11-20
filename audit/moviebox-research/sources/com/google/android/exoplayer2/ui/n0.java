package com.google.android.exoplayer2.ui;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface n0 {

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void f(n0 n0Var, long j11);

        void p(n0 n0Var, long j11, boolean z11);

        void q(n0 n0Var, long j11);
    }

    void addListener(a aVar);

    long getPreferredUpdateDelay();

    void setAdGroupTimesMs(@Nullable long[] jArr, @Nullable boolean[] zArr, int i11);

    void setBufferedPosition(long j11);

    void setDuration(long j11);

    void setEnabled(boolean z11);

    void setPosition(long j11);
}
