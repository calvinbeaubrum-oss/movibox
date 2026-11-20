package com.mbridge.msdk.playercommon.exoplayer2.upstream;

import android.net.Uri;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class DataSpec {
    public static final int FLAG_ALLOW_CACHING_UNKNOWN_LENGTH = 2;
    public static final int FLAG_ALLOW_GZIP = 1;
    public final long absoluteStreamPosition;
    public final int flags;
    public final String key;
    public final long length;
    public final long position;
    public final byte[] postBody;
    public final Uri uri;

    /* JADX INFO: compiled from: source.java */
    public @interface Flags {
    }

    public DataSpec(Uri uri) {
        this(uri, 0);
    }

    public DataSpec(Uri uri, int i11) {
        this(uri, 0L, -1L, null, i11);
    }

    public DataSpec(Uri uri, long j11, long j12, long j13, String str, int i11) {
        this(uri, null, j11, j12, j13, str, i11);
    }

    public DataSpec(Uri uri, long j11, long j12, String str) {
        this(uri, j11, j11, j12, str, 0);
    }

    public DataSpec(Uri uri, long j11, long j12, String str, int i11) {
        this(uri, j11, j11, j12, str, i11);
    }

    public DataSpec(Uri uri, byte[] bArr, long j11, long j12, long j13, String str, int i11) {
        boolean z11 = true;
        Assertions.checkArgument(j11 >= 0);
        Assertions.checkArgument(j12 >= 0);
        if (j13 <= 0 && j13 != -1) {
            z11 = false;
        }
        Assertions.checkArgument(z11);
        this.uri = uri;
        this.postBody = bArr;
        this.absoluteStreamPosition = j11;
        this.position = j12;
        this.length = j13;
        this.key = str;
        this.flags = i11;
    }

    public final boolean isFlagSet(int i11) {
        return (this.flags & i11) == i11;
    }

    public final DataSpec subrange(long j11) {
        long j12 = this.length;
        return subrange(j11, j12 != -1 ? j12 - j11 : -1L);
    }

    public final DataSpec subrange(long j11, long j12) {
        return (j11 == 0 && this.length == j12) ? this : new DataSpec(this.uri, this.postBody, this.absoluteStreamPosition + j11, this.position + j11, j12, this.key, this.flags);
    }

    public final String toString() {
        return "DataSpec[" + this.uri + ", " + Arrays.toString(this.postBody) + ", " + this.absoluteStreamPosition + ", " + this.position + ", " + this.length + ", " + this.key + ", " + this.flags + "]";
    }

    public final DataSpec withUri(Uri uri) {
        return new DataSpec(uri, this.postBody, this.absoluteStreamPosition, this.position, this.length, this.key, this.flags);
    }
}
