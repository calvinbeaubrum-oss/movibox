package q4;

import androidx.annotation.Nullable;
import androidx.media3.common.y;
import com.google.android.gms.common.api.Api;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import u4.r0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class o extends a {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f74375o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final y f74376p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f74377q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f74378r;

    public o(androidx.media3.datasource.a aVar, c4.g gVar, y yVar, int i11, @Nullable Object obj, long j11, long j12, long j13, int i12, y yVar2) {
        super(aVar, gVar, yVar, i11, obj, j11, j12, C.TIME_UNSET, C.TIME_UNSET, j13);
        this.f74375o = i12;
        this.f74376p = yVar2;
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.d
    public void cancelLoad() {
    }

    @Override // q4.m
    public boolean f() {
        return this.f74378r;
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.d
    public void load() throws IOException {
        c cVarH = h();
        cVarH.b(0L);
        r0 r0VarTrack = cVarH.track(0, this.f74375o);
        r0VarTrack.b(this.f74376p);
        try {
            long jA = this.f74330i.a(this.f74323b.e(this.f74377q));
            if (jA != -1) {
                jA += this.f74377q;
            }
            u4.j jVar = new u4.j(this.f74330i, this.f74377q, jA);
            for (int iD = 0; iD != -1; iD = r0VarTrack.d(jVar, Api.BaseClientBuilder.API_PRIORITY_OTHER, true)) {
                this.f74377q += (long) iD;
            }
            r0VarTrack.f(this.f74328g, 1, (int) this.f74377q, 0, null);
            c4.f.a(this.f74330i);
            this.f74378r = true;
        } catch (Throwable th2) {
            c4.f.a(this.f74330i);
            throw th2;
        }
    }
}
