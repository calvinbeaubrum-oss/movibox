package androidx.media3.exoplayer.hls.playlist;

import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.media3.exoplayer.hls.f;
import androidx.media3.exoplayer.upstream.m;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public interface HlsPlaylistTracker {

    /* JADX INFO: compiled from: source.java */
    public static final class PlaylistResetException extends IOException {
        public final Uri url;

        public PlaylistResetException(Uri uri) {
            this.url = uri;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class PlaylistStuckException extends IOException {
        public final Uri url;

        public PlaylistStuckException(Uri uri) {
            this.url = uri;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface a {
        HlsPlaylistTracker a(f fVar, m mVar, k4.f fVar2);
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
        void c();

        boolean d(Uri uri, m.c cVar, boolean z11);
    }

    /* JADX INFO: compiled from: source.java */
    public interface c {
        void g(androidx.media3.exoplayer.hls.playlist.b bVar);
    }

    void a(Uri uri) throws IOException;

    long b();

    @Nullable
    androidx.media3.exoplayer.hls.playlist.c c();

    void d(Uri uri);

    boolean e(Uri uri);

    boolean f();

    boolean g(Uri uri, long j11);

    void h() throws IOException;

    @Nullable
    androidx.media3.exoplayer.hls.playlist.b i(Uri uri, boolean z11);

    void j(Uri uri, androidx.media3.exoplayer.source.m.a aVar, c cVar);

    void l(b bVar);

    void m(b bVar);

    void stop();
}
