package com.mbridge.msdk.thrid.okhttp.internal.cache2;

import com.mbridge.msdk.thrid.okio.Buffer;
import java.io.IOException;
import java.nio.channels.FileChannel;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
final class FileOperator {
    private final FileChannel fileChannel;

    public FileOperator(FileChannel fileChannel) {
        this.fileChannel = fileChannel;
    }

    public void read(long j11, Buffer buffer, long j12) throws IOException {
        if (j12 < 0) {
            throw new IndexOutOfBoundsException();
        }
        while (j12 > 0) {
            long jTransferTo = this.fileChannel.transferTo(j11, j12, buffer);
            j11 += jTransferTo;
            j12 -= jTransferTo;
        }
    }

    public void write(long j11, Buffer buffer, long j12) throws IOException {
        if (j12 < 0 || j12 > buffer.size()) {
            throw new IndexOutOfBoundsException();
        }
        long j13 = j11;
        long j14 = j12;
        while (j14 > 0) {
            long jTransferFrom = this.fileChannel.transferFrom(buffer, j13, j14);
            j13 += jTransferFrom;
            j14 -= jTransferFrom;
        }
    }
}
