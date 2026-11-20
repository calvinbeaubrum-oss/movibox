package k4;

import androidx.annotation.Nullable;
import androidx.media3.exoplayer.hls.playlist.HlsPlaylistParser;
import androidx.media3.exoplayer.upstream.o;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements f {
    @Override // k4.f
    public o.a<e> a() {
        return new HlsPlaylistParser();
    }

    @Override // k4.f
    public o.a<e> b(androidx.media3.exoplayer.hls.playlist.c cVar, @Nullable androidx.media3.exoplayer.hls.playlist.b bVar) {
        return new HlsPlaylistParser(cVar, bVar);
    }
}
