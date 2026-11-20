package k4;

import androidx.annotation.Nullable;
import androidx.media3.common.StreamKey;
import androidx.media3.exoplayer.offline.r;
import androidx.media3.exoplayer.upstream.o;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f68237a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<StreamKey> f68238b;

    public d(f fVar, List<StreamKey> list) {
        this.f68237a = fVar;
        this.f68238b = list;
    }

    @Override // k4.f
    public o.a<e> a() {
        return new r(this.f68237a.a(), this.f68238b);
    }

    @Override // k4.f
    public o.a<e> b(androidx.media3.exoplayer.hls.playlist.c cVar, @Nullable androidx.media3.exoplayer.hls.playlist.b bVar) {
        return new r(this.f68237a.b(cVar, bVar), this.f68238b);
    }
}
