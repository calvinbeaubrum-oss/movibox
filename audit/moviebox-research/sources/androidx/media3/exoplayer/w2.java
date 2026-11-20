package androidx.media3.exoplayer;

import androidx.annotation.Nullable;
import e4.x3;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public interface w2 extends t2.b {

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void a();

        void b();
    }

    void c(float f11, float f12) throws ExoPlaybackException;

    long d();

    void disable();

    void f();

    void g(z2 z2Var, androidx.media3.common.y[] yVarArr, p4.e0 e0Var, long j11, boolean z11, boolean z12, long j12, long j13, androidx.media3.exoplayer.source.l.b bVar) throws ExoPlaybackException;

    y2 getCapabilities();

    @Nullable
    y1 getMediaClock();

    String getName();

    int getState();

    @Nullable
    p4.e0 getStream();

    int getTrackType();

    boolean hasReadStreamToEnd();

    void i(int i11, x3 x3Var, z3.d dVar);

    boolean isCurrentStreamFinal();

    boolean isEnded();

    boolean isReady();

    void l(androidx.media3.common.m0 m0Var);

    void m(androidx.media3.common.y[] yVarArr, p4.e0 e0Var, long j11, long j12, androidx.media3.exoplayer.source.l.b bVar) throws ExoPlaybackException;

    void maybeThrowStreamError() throws IOException;

    void release();

    void render(long j11, long j12) throws ExoPlaybackException;

    void reset();

    void resetPosition(long j11) throws ExoPlaybackException;

    void setCurrentStreamFinal();

    void start() throws ExoPlaybackException;

    void stop();
}
