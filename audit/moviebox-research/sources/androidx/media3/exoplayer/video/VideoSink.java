package androidx.media3.exoplayer.video;

import android.view.Surface;
import androidx.media3.common.t0;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public interface VideoSink {

    /* JADX INFO: compiled from: source.java */
    public static final class VideoSinkException extends Exception {
        public final androidx.media3.common.y format;

        public VideoSinkException(Throwable th2, androidx.media3.common.y yVar) {
            super(th2);
            this.format = yVar;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f11549a = new C0108a();

        /* JADX INFO: renamed from: androidx.media3.exoplayer.video.VideoSink$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public class C0108a implements a {
            @Override // androidx.media3.exoplayer.video.VideoSink.a
            public void a(VideoSink videoSink) {
            }

            @Override // androidx.media3.exoplayer.video.VideoSink.a
            public void b(VideoSink videoSink, t0 t0Var) {
            }

            @Override // androidx.media3.exoplayer.video.VideoSink.a
            public void c(VideoSink videoSink) {
            }
        }

        void a(VideoSink videoSink);

        void b(VideoSink videoSink, t0 t0Var);

        void c(VideoSink videoSink);
    }

    long a(long j11, boolean z11);

    void b(int i11, androidx.media3.common.y yVar);

    boolean c();

    Surface d();

    void e(a aVar, Executor executor);

    void flush();

    boolean isEnded();

    boolean isReady();

    void render(long j11, long j12) throws VideoSinkException;

    void setPlaybackSpeed(float f11);
}
