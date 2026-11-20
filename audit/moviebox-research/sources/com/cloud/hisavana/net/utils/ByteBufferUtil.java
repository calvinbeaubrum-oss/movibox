package com.cloud.hisavana.net.utils;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class ByteBufferUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicReference<byte[]> f29023a = new AtomicReference<>();

    /* JADX INFO: compiled from: source.java */
    public static class ByteBufferStream extends InputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ByteBuffer f29024a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f29025b;

        @Override // java.io.InputStream
        public int available() throws IOException {
            return this.f29024a.remaining();
        }

        @Override // java.io.InputStream
        public synchronized void mark(int i11) {
            this.f29025b = this.f29024a.position();
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            return true;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            if (this.f29024a.hasRemaining()) {
                return this.f29024a.get();
            }
            return -1;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i11, int i12) throws IOException {
            if (!this.f29024a.hasRemaining()) {
                return -1;
            }
            int iMin = Math.min(i12, available());
            this.f29024a.get(bArr, i11, iMin);
            return iMin;
        }

        @Override // java.io.InputStream
        public synchronized void reset() throws IOException {
            int i11 = this.f29025b;
            if (i11 == -1) {
                throw new IOException("Cannot reset to unset mark position");
            }
            this.f29024a.position(i11);
        }

        @Override // java.io.InputStream
        public long skip(long j11) throws IOException {
            if (!this.f29024a.hasRemaining()) {
                return -1L;
            }
            long jMin = Math.min(j11, available());
            ByteBuffer byteBuffer = this.f29024a;
            byteBuffer.position((int) (((long) byteBuffer.position()) + jMin));
            return jMin;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class ContentLengthInputStream extends InputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final InputStream f29026a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f29027b;

        @Override // java.io.InputStream
        public int available() {
            return this.f29027b;
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f29026a.close();
        }

        @Override // java.io.InputStream
        public synchronized void mark(int i11) {
            this.f29026a.mark(i11);
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            return this.f29026a.markSupported();
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            return this.f29026a.read();
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr) throws IOException {
            return this.f29026a.read(bArr);
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i11, int i12) throws IOException {
            return this.f29026a.read(bArr, i11, i12);
        }

        @Override // java.io.InputStream
        public synchronized void reset() throws IOException {
            this.f29026a.reset();
        }

        @Override // java.io.InputStream
        public long skip(long j11) throws IOException {
            return this.f29026a.skip(j11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class SafeArray {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f29028a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f29029b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final byte[] f29030c;

        public SafeArray(byte[] bArr, int i11, int i12) {
            this.f29030c = bArr;
            this.f29028a = i11;
            this.f29029b = i12;
        }
    }

    private ByteBufferUtil() {
    }

    public static ByteBuffer a(File file) throws Throwable {
        RandomAccessFile randomAccessFile;
        FileChannel channel = null;
        try {
            randomAccessFile = new RandomAccessFile(file, CampaignEx.JSON_KEY_AD_R);
            try {
                channel = randomAccessFile.getChannel();
                MappedByteBuffer mappedByteBufferLoad = channel.map(FileChannel.MapMode.READ_ONLY, 0L, file.length()).load();
                try {
                    channel.close();
                } catch (IOException unused) {
                }
                try {
                    randomAccessFile.close();
                } catch (IOException unused2) {
                }
                return mappedByteBufferLoad;
            } catch (Throwable th2) {
                th = th2;
                if (channel != null) {
                    try {
                        channel.close();
                    } catch (IOException unused3) {
                    }
                }
                if (randomAccessFile == null) {
                    throw th;
                }
                try {
                    randomAccessFile.close();
                    throw th;
                } catch (IOException unused4) {
                    throw th;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            randomAccessFile = null;
        }
    }

    public static SafeArray b(ByteBuffer byteBuffer) {
        if (byteBuffer.isReadOnly() || !byteBuffer.hasArray()) {
            return null;
        }
        return new SafeArray(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.limit());
    }

    public static byte[] c(ByteBuffer byteBuffer) {
        SafeArray safeArrayB = b(byteBuffer);
        if (safeArrayB != null && safeArrayB.f29028a == 0 && safeArrayB.f29029b == safeArrayB.f29030c.length) {
            return byteBuffer.array();
        }
        ByteBuffer byteBufferAsReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        byte[] bArr = new byte[byteBufferAsReadOnlyBuffer.limit()];
        byteBufferAsReadOnlyBuffer.position(0);
        byteBufferAsReadOnlyBuffer.get(bArr);
        return bArr;
    }
}
