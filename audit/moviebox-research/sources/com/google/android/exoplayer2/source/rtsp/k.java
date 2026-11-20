package com.google.android.exoplayer2.source.rtsp;

import android.net.Uri;
import com.google.android.exoplayer2.util.o0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class k {
    public static com.google.android.exoplayer2.upstream.n a(int i11) {
        return new com.google.android.exoplayer2.upstream.n(Uri.parse(o0.C("%s:%d", "rtp://0.0.0.0", Integer.valueOf(i11))));
    }
}
