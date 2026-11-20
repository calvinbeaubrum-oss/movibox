package com.google.android.exoplayer2.upstream;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class v implements z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f35516a;

    public v() {
        this(-1);
    }

    public v(int i11) {
        this.f35516a = i11;
    }

    @Override // com.google.android.exoplayer2.upstream.z
    public int a(int i11) {
        int i12 = this.f35516a;
        if (i12 == -1) {
            return i11 == 7 ? 6 : 3;
        }
        return i12;
    }

    @Override // com.google.android.exoplayer2.upstream.z
    public /* synthetic */ void b(long j11) {
        y.a(this, j11);
    }

    @Override // com.google.android.exoplayer2.upstream.z
    public long c(z.c cVar) {
        IOException iOException = cVar.f35529c;
        return ((iOException instanceof ParserException) || (iOException instanceof FileNotFoundException) || (iOException instanceof HttpDataSource$CleartextNotPermittedException) || (iOException instanceof Loader.UnexpectedLoaderException) || DataSourceException.isCausedByPositionOutOfRange(iOException)) ? C.TIME_UNSET : Math.min((cVar.f35530d - 1) * 1000, 5000);
    }

    @Override // com.google.android.exoplayer2.upstream.z
    @Nullable
    public z.b d(z.a aVar, z.c cVar) {
        if (!e(cVar.f35529c)) {
            return null;
        }
        if (aVar.a(1)) {
            return new z.b(1, 300000L);
        }
        if (aVar.a(2)) {
            return new z.b(2, ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS);
        }
        return null;
    }

    public boolean e(IOException iOException) {
        if (!(iOException instanceof HttpDataSource$InvalidResponseCodeException)) {
            return false;
        }
        int i11 = ((HttpDataSource$InvalidResponseCodeException) iOException).responseCode;
        return i11 == 403 || i11 == 404 || i11 == 410 || i11 == 416 || i11 == 500 || i11 == 503;
    }
}
