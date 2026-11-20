package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.source.hls.f;
import com.google.android.exoplayer2.source.j;
import com.google.android.exoplayer2.upstream.z;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
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
        HlsPlaylistTracker a(f fVar, z zVar, sh.f fVar2);
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
        boolean b(Uri uri, z.c cVar, boolean z11);

        void c();
    }

    /* JADX INFO: compiled from: source.java */
    public interface c {
        void g(com.google.android.exoplayer2.source.hls.playlist.c cVar);
    }

    void a(Uri uri) throws IOException;

    long b();

    @Nullable
    d c();

    void d(Uri uri);

    boolean e(Uri uri);

    boolean f();

    boolean g(Uri uri, long j11);

    void h() throws IOException;

    @Nullable
    com.google.android.exoplayer2.source.hls.playlist.c i(Uri uri, boolean z11);

    void k(b bVar);

    void m(b bVar);

    void o(Uri uri, j.a aVar, c cVar);

    void stop();
}
