package com.mbridge.msdk.thrid.okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class InflaterSource implements Source {
    private int bufferBytesHeldByInflater;
    private boolean closed;
    private final Inflater inflater;
    private final BufferedSource source;

    public InflaterSource(BufferedSource bufferedSource, Inflater inflater) {
        if (bufferedSource == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (inflater == null) {
            throw new IllegalArgumentException("inflater == null");
        }
        this.source = bufferedSource;
        this.inflater = inflater;
    }

    public InflaterSource(Source source, Inflater inflater) {
        this(Okio.buffer(source), inflater);
    }

    private void releaseInflatedBytes() throws IOException {
        int i11 = this.bufferBytesHeldByInflater;
        if (i11 == 0) {
            return;
        }
        int remaining = i11 - this.inflater.getRemaining();
        this.bufferBytesHeldByInflater -= remaining;
        this.source.skip(remaining);
    }

    @Override // com.mbridge.msdk.thrid.okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.closed) {
            return;
        }
        this.inflater.end();
        this.closed = true;
        this.source.close();
    }

    @Override // com.mbridge.msdk.thrid.okio.Source
    public long read(Buffer buffer, long j11) throws IOException {
        boolean zRefill;
        if (j11 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j11);
        }
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        if (j11 == 0) {
            return 0L;
        }
        do {
            zRefill = refill();
            try {
                Segment segmentWritableSegment = buffer.writableSegment(1);
                int iInflate = this.inflater.inflate(segmentWritableSegment.data, segmentWritableSegment.limit, (int) Math.min(j11, 8192 - segmentWritableSegment.limit));
                if (iInflate > 0) {
                    segmentWritableSegment.limit += iInflate;
                    long j12 = iInflate;
                    buffer.size += j12;
                    return j12;
                }
                if (!this.inflater.finished() && !this.inflater.needsDictionary()) {
                }
                releaseInflatedBytes();
                if (segmentWritableSegment.pos != segmentWritableSegment.limit) {
                    return -1L;
                }
                buffer.head = segmentWritableSegment.pop();
                SegmentPool.recycle(segmentWritableSegment);
                return -1L;
            } catch (DataFormatException e11) {
                throw new IOException(e11);
            }
        } while (!zRefill);
        throw new EOFException("source exhausted prematurely");
    }

    public final boolean refill() throws IOException {
        if (!this.inflater.needsInput()) {
            return false;
        }
        releaseInflatedBytes();
        if (this.inflater.getRemaining() != 0) {
            throw new IllegalStateException("?");
        }
        if (this.source.exhausted()) {
            return true;
        }
        Segment segment = this.source.buffer().head;
        int i11 = segment.limit;
        int i12 = segment.pos;
        int i13 = i11 - i12;
        this.bufferBytesHeldByInflater = i13;
        this.inflater.setInput(segment.data, i12, i13);
        return false;
    }

    @Override // com.mbridge.msdk.thrid.okio.Source
    public Timeout timeout() {
        return this.source.timeout();
    }
}
