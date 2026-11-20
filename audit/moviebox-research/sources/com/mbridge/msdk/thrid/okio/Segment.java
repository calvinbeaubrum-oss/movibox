package com.mbridge.msdk.thrid.okio;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
final class Segment {
    static final int SHARE_MINIMUM = 1024;
    static final int SIZE = 8192;
    final byte[] data;
    int limit;
    Segment next;
    boolean owner;
    int pos;
    Segment prev;
    boolean shared;

    public Segment() {
        this.data = new byte[8192];
        this.owner = true;
        this.shared = false;
    }

    public Segment(byte[] bArr, int i11, int i12, boolean z11, boolean z12) {
        this.data = bArr;
        this.pos = i11;
        this.limit = i12;
        this.shared = z11;
        this.owner = z12;
    }

    public final void compact() {
        Segment segment = this.prev;
        if (segment == this) {
            throw new IllegalStateException();
        }
        if (segment.owner) {
            int i11 = this.limit - this.pos;
            if (i11 > (8192 - segment.limit) + (segment.shared ? 0 : segment.pos)) {
                return;
            }
            writeTo(segment, i11);
            pop();
            SegmentPool.recycle(this);
        }
    }

    @Nullable
    public final Segment pop() {
        Segment segment = this.next;
        Segment segment2 = segment != this ? segment : null;
        Segment segment3 = this.prev;
        segment3.next = segment;
        this.next.prev = segment3;
        this.next = null;
        this.prev = null;
        return segment2;
    }

    public final Segment push(Segment segment) {
        segment.prev = this;
        segment.next = this.next;
        this.next.prev = segment;
        this.next = segment;
        return segment;
    }

    public final Segment sharedCopy() {
        this.shared = true;
        return new Segment(this.data, this.pos, this.limit, true, false);
    }

    public final Segment split(int i11) {
        Segment segmentTake;
        if (i11 <= 0 || i11 > this.limit - this.pos) {
            throw new IllegalArgumentException();
        }
        if (i11 >= 1024) {
            segmentTake = sharedCopy();
        } else {
            segmentTake = SegmentPool.take();
            System.arraycopy(this.data, this.pos, segmentTake.data, 0, i11);
        }
        segmentTake.limit = segmentTake.pos + i11;
        this.pos += i11;
        this.prev.push(segmentTake);
        return segmentTake;
    }

    public final Segment unsharedCopy() {
        return new Segment((byte[]) this.data.clone(), this.pos, this.limit, false, true);
    }

    public final void writeTo(Segment segment, int i11) {
        if (!segment.owner) {
            throw new IllegalArgumentException();
        }
        int i12 = segment.limit;
        if (i12 + i11 > 8192) {
            if (segment.shared) {
                throw new IllegalArgumentException();
            }
            int i13 = segment.pos;
            if ((i12 + i11) - i13 > 8192) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = segment.data;
            System.arraycopy(bArr, i13, bArr, 0, i12 - i13);
            segment.limit -= segment.pos;
            segment.pos = 0;
        }
        System.arraycopy(this.data, this.pos, segment.data, segment.limit, i11);
        segment.limit += i11;
        this.pos += i11;
    }
}
