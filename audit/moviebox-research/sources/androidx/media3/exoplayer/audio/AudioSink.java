package androidx.media3.exoplayer.audio;

import android.media.AudioDeviceInfo;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.media3.common.g0;
import androidx.media3.common.y;
import com.vungle.warren.error.VungleException;
import e4.x3;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public interface AudioSink {

    /* JADX INFO: compiled from: source.java */
    public static final class ConfigurationException extends Exception {
        public final y format;

        public ConfigurationException(String str, y yVar) {
            super(str);
            this.format = yVar;
        }

        public ConfigurationException(Throwable th2, y yVar) {
            super(th2);
            this.format = yVar;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class InitializationException extends Exception {
        public final int audioTrackState;
        public final y format;
        public final boolean isRecoverable;

        public InitializationException(int i11, int i12, int i13, int i14, y yVar, boolean z11, @Nullable Exception exc) {
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
            sb2.append(" ");
            sb2.append(yVar);
            sb2.append(z11 ? " (recoverable)" : "");
            super(sb2.toString(), exc);
            this.audioTrackState = i11;
            this.isRecoverable = z11;
            this.format = yVar;
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
        public final y format;
        public final boolean isRecoverable;

        public WriteException(int i11, y yVar, boolean z11) {
            super("AudioTrack write failed: " + i11);
            this.isRecoverable = z11;
            this.errorCode = i11;
            this.format = yVar;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f9833a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f9834b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f9835c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f9836d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f9837e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f9838f;

        public a(int i11, int i12, int i13, boolean z11, boolean z12, int i14) {
            this.f9833a = i11;
            this.f9834b = i12;
            this.f9835c = i13;
            this.f9836d = z11;
            this.f9837e = z12;
            this.f9838f = i14;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
        void a(Exception exc);

        void b(long j11);

        void c();

        void d();

        void e();

        void f();

        void k(a aVar);

        void l(a aVar);

        void onPositionDiscontinuity();

        void onSkipSilenceEnabledChanged(boolean z11);

        void onUnderrun(int i11, long j11, long j12);
    }

    boolean a(y yVar);

    void b(g0 g0Var);

    boolean c(ByteBuffer byteBuffer, long j11, int i11) throws WriteException, InitializationException;

    void d(z3.d dVar);

    void disableTunneling();

    void e();

    void f(boolean z11);

    void flush();

    void g(androidx.media3.common.d dVar);

    long getCurrentPositionUs(boolean z11);

    g0 getPlaybackParameters();

    androidx.media3.exoplayer.audio.b h(y yVar);

    void handleDiscontinuity();

    boolean hasPendingData();

    @RequiresApi(23)
    void i(@Nullable AudioDeviceInfo audioDeviceInfo);

    boolean isEnded();

    void j(b bVar);

    @RequiresApi(VungleException.INCORRECT_DEFAULT_API_USAGE)
    void k(int i11);

    void l(@Nullable x3 x3Var);

    void m(y yVar, int i11, @Nullable int[] iArr) throws ConfigurationException;

    @RequiresApi(VungleException.INCORRECT_DEFAULT_API_USAGE)
    void n(int i11, int i12);

    void o(long j11);

    int p(y yVar);

    void pause();

    void play();

    void playToEndOfStream() throws WriteException;

    void q(androidx.media3.common.g gVar);

    void release();

    void reset();

    void setAudioSessionId(int i11);

    void setVolume(float f11);
}
