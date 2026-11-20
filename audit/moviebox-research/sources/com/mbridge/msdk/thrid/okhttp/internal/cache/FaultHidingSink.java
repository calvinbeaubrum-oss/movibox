package com.mbridge.msdk.thrid.okhttp.internal.cache;

import com.mbridge.msdk.thrid.okio.Buffer;
import com.mbridge.msdk.thrid.okio.ForwardingSink;
import com.mbridge.msdk.thrid.okio.Sink;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
class FaultHidingSink extends ForwardingSink {
    private boolean hasErrors;

    public FaultHidingSink(Sink sink) {
        super(sink);
    }

    @Override // com.mbridge.msdk.thrid.okio.ForwardingSink, com.mbridge.msdk.thrid.okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.hasErrors) {
            return;
        }
        try {
            super.close();
        } catch (IOException e11) {
            this.hasErrors = true;
            onException(e11);
        }
    }

    @Override // com.mbridge.msdk.thrid.okio.ForwardingSink, com.mbridge.msdk.thrid.okio.Sink, java.io.Flushable
    public void flush() throws IOException {
        if (this.hasErrors) {
            return;
        }
        try {
            super.flush();
        } catch (IOException e11) {
            this.hasErrors = true;
            onException(e11);
        }
    }

    public void onException(IOException iOException) {
    }

    @Override // com.mbridge.msdk.thrid.okio.ForwardingSink, com.mbridge.msdk.thrid.okio.Sink
    public void write(Buffer buffer, long j11) throws IOException {
        if (this.hasErrors) {
            buffer.skip(j11);
            return;
        }
        try {
            super.write(buffer, j11);
        } catch (IOException e11) {
            this.hasErrors = true;
            onException(e11);
        }
    }
}
