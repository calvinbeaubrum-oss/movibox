package com.mbridge.msdk.thrid.okio;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
final class SegmentPool {
    static final long MAX_SIZE = 65536;
    static long byteCount;

    @Nullable
    static Segment next;

    private SegmentPool() {
    }

    public static void recycle(Segment segment) {
        if (segment.next != null || segment.prev != null) {
            throw new IllegalArgumentException();
        }
        if (segment.shared) {
            return;
        }
        synchronized (SegmentPool.class) {
            try {
                long j11 = byteCount;
                if (j11 + PlaybackStateCompat.ACTION_PLAY_FROM_URI > 65536) {
                    return;
                }
                byteCount = j11 + PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                segment.next = next;
                segment.limit = 0;
                segment.pos = 0;
                next = segment;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static Segment take() {
        synchronized (SegmentPool.class) {
            try {
                Segment segment = next;
                if (segment == null) {
                    return new Segment();
                }
                next = segment.next;
                segment.next = null;
                byteCount -= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                return segment;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
