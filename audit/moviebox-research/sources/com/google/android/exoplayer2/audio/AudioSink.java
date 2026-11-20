package com.google.android.exoplayer2.audio;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.m2;
import java.nio.ByteBuffer;
import qg.u1;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface AudioSink {

    /* JADX INFO: compiled from: source.java */
    public static final class ConfigurationException extends Exception {
        public final m1 format;

        public ConfigurationException(String str, m1 m1Var) {
            super(str);
            this.format = m1Var;
        }

        public ConfigurationException(Throwable th2, m1 m1Var) {
            super(th2);
            this.format = m1Var;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class InitializationException extends Exception {
        public final int audioTrackState;
        public final m1 format;
        public final boolean isRecoverable;

        public InitializationException(int i11, int i12, int i13, int i14, m1 m1Var, boolean z11, @Nullable Exception exc) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("AudioTrack init failed ");
            sb2.append(i11);
            sb2.append(" ");
            sb2.append("Config(");
            sb2.append(i12);
            sb2.append(", ");
            sb2.append(i13);
            sb2.append(", ");
            sb2.append(i14);
            sb2.append(")");
            sb2.append(z11 ? " (recoverable)" : "");
            super(sb2.toString(), exc);
            this.audioTrackState = i11;
            this.isRecoverable = z11;
            this.format = m1Var;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class UnexpectedDiscontinuityException extends Exception {
        public final long actualPresentationTimeUs;
        public final long expectedPresentationTimeUs;

        public UnexpectedDiscontinuityException(long j11, long j12) {
            super("Unexpected audio track timestamp discontinuity: expected " + j12 + ", got " + j11);
            this.actualPresentationTimeUs = j11;
            this.expectedPresentationTimeUs = j12;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class WriteException extends Exception {
        public final int errorCode;
        public final m1 format;
        public final boolean isRecoverable;

        public WriteException(int i11, m1 m1Var, boolean z11) {
            super("AudioTrack write failed: " + i11);
            this.isRecoverable = z11;
            this.errorCode = i11;
            this.format = m1Var;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void a(Exception exc);

        void b(long j11);

        void c();

        void d();

        void onPositionDiscontinuity();

        void onSkipSilenceEnabledChanged(boolean z11);

        void onUnderrun(int i11, long j11, long j12);
    }

    boolean a(m1 m1Var);

    void b(m2 m2Var);

    boolean c(ByteBuffer byteBuffer, long j11, int i11) throws WriteException, InitializationException;

    void d(@Nullable u1 u1Var);

    void disableTunneling();

    void e();

    void f(boolean z11);

    void flush();

    void g(e eVar);

    long getCurrentPositionUs(boolean z11);

    m2 getPlaybackParameters();

    void h(a aVar);

    void handleDiscontinuity();

    boolean hasPendingData();

    int i(m1 m1Var);

    boolean isEnded();

    void j();

    void k(u uVar);

    void l(m1 m1Var, int i11, @Nullable int[] iArr) throws ConfigurationException;

    void pause();

    void play();

    void playToEndOfStream() throws WriteException;

    void reset();

    void setAudioSessionId(int i11);

    void setVolume(float f11);
}
