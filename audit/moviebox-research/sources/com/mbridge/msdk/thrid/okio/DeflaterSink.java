package com.mbridge.msdk.thrid.okio;

import java.io.IOException;
import java.util.zip.Deflater;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class DeflaterSink implements Sink {
    private boolean closed;
    private final Deflater deflater;
    private final BufferedSink sink;

    public DeflaterSink(BufferedSink bufferedSink, Deflater deflater) {
        if (bufferedSink == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (deflater == null) {
            throw new IllegalArgumentException("inflater == null");
        }
        this.sink = bufferedSink;
        this.deflater = deflater;
    }

    public DeflaterSink(Sink sink, Deflater deflater) {
        this(Okio.buffer(sink), deflater);
    }

    private void deflate(boolean z11) throws IOException {
        Segment segmentWritableSegment;
        int iDeflate;
        Buffer buffer = this.sink.buffer();
        while (true) {
            segmentWritableSegment = buffer.writableSegment(1);
            if (z11) {
                Deflater deflater = this.deflater;
                byte[] bArr = segmentWritableSegment.data;
                int i11 = segmentWritableSegment.limit;
                iDeflate = deflater.deflate(bArr, i11, 8192 - i11, 2);
            } else {
                Deflater deflater2 = this.deflater;
                byte[] bArr2 = segmentWritableSegment.data;
                int i12 = segmentWritableSegment.limit;
                iDeflate = deflater2.deflate(bArr2, i12, 8192 - i12);
            }
            if (iDeflate > 0) {
                segmentWritableSegment.limit += iDeflate;
                buffer.size += (long) iDeflate;
                this.sink.emitCompleteSegments();
            } else if (this.deflater.needsInput()) {
                break;
            }
        }
        if (segmentWritableSegment.pos == segmentWritableSegment.limit) {
            buffer.head = segmentWritableSegment.pop();
            SegmentPool.recycle(segmentWritableSegment);
        }
    }

    @Override // com.mbridge.msdk.thrid.okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        if (this.closed) {
            return;
        }
        finishDeflate();
        th = null;
        try {
            this.deflater.end();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        try {
            this.sink.close();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        this.closed = true;
        if (th != null) {
            Util.sneakyRethrow(th);
        }
    }

    public void finishDeflate() throws IOException {
        this.deflater.finish();
        deflate(false);
    }

    @Override // com.mbridge.msdk.thrid.okio.Sink, java.io.Flushable
    public void flush() throws IOException {
        deflate(true);
        this.sink.flush();
    }

    @Override // com.mbridge.msdk.thrid.okio.Sink
    public Timeout timeout() {
        return this.sink.timeout();
    }

    public String toString() {
        return "DeflaterSink(" + this.sink + ")";
    }

    @Override // com.mbridge.msdk.thrid.okio.Sink
    public void write(Buffer buffer, long j11) throws IOException {
        Util.checkOffsetAndCount(buffer.size, 0L, j11);
        while (j11 > 0) {
            Segment segment = buffer.head;
            int iMin = (int) Math.min(j11, segment.limit - segment.pos);
            this.deflater.setInput(segment.data, segment.pos, iMin);
            deflate(false);
            long j12 = iMin;
            buffer.size -= j12;
            int i11 = segment.pos + iMin;
            segment.pos = i11;
            if (i11 == segment.limit) {
                buffer.head = segment.pop();
                SegmentPool.recycle(segment);
            }
            j11 -= j12;
        }
    }
}
