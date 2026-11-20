package sh;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.upstream.b0;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class d implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f76357a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<StreamKey> f76358b;

    public d(f fVar, List<StreamKey> list) {
        this.f76357a = fVar;
        this.f76358b = list;
    }

    @Override // sh.f
    public b0.a<e> a() {
        return new com.google.android.exoplayer2.offline.d(this.f76357a.a(), this.f76358b);
    }

    @Override // sh.f
    public b0.a<e> b(com.google.android.exoplayer2.source.hls.playlist.d dVar, @Nullable com.google.android.exoplayer2.source.hls.playlist.c cVar) {
        return new com.google.android.exoplayer2.offline.d(this.f76357a.b(dVar, cVar), this.f76358b);
    }
}
