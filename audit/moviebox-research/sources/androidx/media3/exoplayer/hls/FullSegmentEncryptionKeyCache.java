package androidx.media3.exoplayer.hls;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class FullSegmentEncryptionKeyCache {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashMap<Uri, byte[]> f10337a;

    public FullSegmentEncryptionKeyCache(final int i11) {
        this.f10337a = new LinkedHashMap<Uri, byte[]>(i11 + 1, 1.0f, false) { // from class: androidx.media3.exoplayer.hls.FullSegmentEncryptionKeyCache.1
            @Override // java.util.LinkedHashMap
            public boolean removeEldestEntry(Map.Entry<Uri, byte[]> entry) {
                return size() > i11;
            }
        };
    }

    @Nullable
    public byte[] a(@Nullable Uri uri) {
        if (uri == null) {
            return null;
        }
        return this.f10337a.get(uri);
    }

    @Nullable
    public byte[] b(Uri uri, byte[] bArr) {
        return this.f10337a.put((Uri) z3.a.e(uri), (byte[]) z3.a.e(bArr));
    }

    @Nullable
    public byte[] c(Uri uri) {
        return this.f10337a.remove(z3.a.e(uri));
    }
}
