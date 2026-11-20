package q4;

import androidx.annotation.Nullable;
import androidx.media3.common.y;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class l extends e {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final f f74369j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public f.b f74370k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f74371l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public volatile boolean f74372m;

    public l(androidx.media3.datasource.a aVar, c4.g gVar, y yVar, int i11, @Nullable Object obj, f fVar) {
        super(aVar, gVar, 2, yVar, i11, obj, C.TIME_UNSET, C.TIME_UNSET);
        this.f74369j = fVar;
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.d
    public void cancelLoad() {
        this.f74372m = true;
    }

    public void e(f.b bVar) {
        this.f74370k = bVar;
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.d
    public void load() throws IOException {
        if (this.f74371l == 0) {
            this.f74369j.d(this.f74370k, C.TIME_UNSET, C.TIME_UNSET);
        }
        try {
            c4.g gVarE = this.f74323b.e(this.f74371l);
            c4.m mVar = this.f74330i;
            u4.j jVar = new u4.j(mVar, gVarE.f14604g, mVar.a(gVarE));
            while (!this.f74372m && this.f74369j.a(jVar)) {
                try {
                } catch (Throwable th2) {
                    this.f74371l = jVar.getPosition() - this.f74323b.f14604g;
                    throw th2;
                }
            }
            this.f74371l = jVar.getPosition() - this.f74323b.f14604g;
            c4.f.a(this.f74330i);
        } catch (Throwable th3) {
            c4.f.a(this.f74330i);
            throw th3;
        }
    }
}
