package sh;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import com.google.android.exoplayer2.upstream.b0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class a implements f {
    @Override // sh.f
    public b0.a<e> a() {
        return new HlsPlaylistParser();
    }

    @Override // sh.f
    public b0.a<e> b(com.google.android.exoplayer2.source.hls.playlist.d dVar, @Nullable com.google.android.exoplayer2.source.hls.playlist.c cVar) {
        return new HlsPlaylistParser(dVar, cVar);
    }
}
