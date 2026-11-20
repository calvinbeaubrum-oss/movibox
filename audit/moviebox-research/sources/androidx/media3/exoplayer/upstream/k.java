package androidx.media3.exoplayer.upstream;

import androidx.annotation.Nullable;
import androidx.media3.common.ParserException;
import androidx.media3.datasource.DataSourceException;
import androidx.media3.datasource.HttpDataSource;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class k implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f11489a;

    public k() {
        this(-1);
    }

    public k(int i11) {
        this.f11489a = i11;
    }

    @Override // androidx.media3.exoplayer.upstream.m
    public int a(int i11) {
        int i12 = this.f11489a;
        if (i12 == -1) {
            return i11 == 7 ? 6 : 3;
        }
        return i12;
    }

    @Override // androidx.media3.exoplayer.upstream.m
    public /* synthetic */ void b(long j11) {
        l.a(this, j11);
    }

    @Override // androidx.media3.exoplayer.upstream.m
    public long c(m.c cVar) {
        IOException iOException = cVar.f11498c;
        return ((iOException instanceof ParserException) || (iOException instanceof FileNotFoundException) || (iOException instanceof HttpDataSource.CleartextNotPermittedException) || (iOException instanceof Loader.UnexpectedLoaderException) || DataSourceException.isCausedByPositionOutOfRange(iOException)) ? C.TIME_UNSET : Math.min((cVar.f11499d - 1) * 1000, 5000);
    }

    @Override // androidx.media3.exoplayer.upstream.m
    @Nullable
    public m.b d(m.a aVar, m.c cVar) {
        if (!e(cVar.f11498c)) {
            return null;
        }
        if (aVar.a(1)) {
            return new m.b(1, 300000L);
        }
        if (aVar.a(2)) {
            return new m.b(2, ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS);
        }
        return null;
    }

    public boolean e(IOException iOException) {
        if (!(iOException instanceof HttpDataSource.InvalidResponseCodeException)) {
            return false;
        }
        int i11 = ((HttpDataSource.InvalidResponseCodeException) iOException).responseCode;
        return i11 == 403 || i11 == 404 || i11 == 410 || i11 == 416 || i11 == 500 || i11 == 503;
    }
}
