package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class FullSegmentEncryptionKeyCache {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashMap<Uri, byte[]> f33950a;

    public FullSegmentEncryptionKeyCache(final int i11) {
        this.f33950a = new LinkedHashMap<Uri, byte[]>(this, i11 + 1, 1.0f, false) { // from class: com.google.android.exoplayer2.source.hls.FullSegmentEncryptionKeyCache.1
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
        return this.f33950a.get(uri);
    }

    @Nullable
    public byte[] b(Uri uri, byte[] bArr) {
        return this.f33950a.put((Uri) com.google.android.exoplayer2.util.a.e(uri), (byte[]) com.google.android.exoplayer2.util.a.e(bArr));
    }

    @Nullable
    public byte[] c(Uri uri) {
        return this.f33950a.remove(com.google.android.exoplayer2.util.a.e(uri));
    }
}
