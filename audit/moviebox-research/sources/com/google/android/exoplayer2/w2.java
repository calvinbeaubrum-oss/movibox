package com.google.android.exoplayer2;

import androidx.annotation.Nullable;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface w2 extends r2.b {

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void a();

        void b();
    }

    void c(float f11, float f12) throws ExoPlaybackException;

    long d();

    void disable();

    void f(m1[] m1VarArr, nh.d0 d0Var, long j11, long j12) throws ExoPlaybackException;

    void g(z2 z2Var, m1[] m1VarArr, nh.d0 d0Var, long j11, boolean z11, boolean z12, long j12, long j13) throws ExoPlaybackException;

    y2 getCapabilities();

    @Nullable
    com.google.android.exoplayer2.util.u getMediaClock();

    String getName();

    int getState();

    @Nullable
    nh.d0 getStream();

    int getTrackType();

    void h(int i11, qg.u1 u1Var);

    boolean hasReadStreamToEnd();

    boolean isCurrentStreamFinal();

    boolean isEnded();

    boolean isReady();

    void maybeThrowStreamError() throws IOException;

    void render(long j11, long j12) throws ExoPlaybackException;

    void reset();

    void resetPosition(long j11) throws ExoPlaybackException;

    void setCurrentStreamFinal();

    void start() throws ExoPlaybackException;

    void stop();
}
