package bu;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicReference<byte[]> f14399a = new AtomicReference<>();

    /* JADX INFO: renamed from: bu.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class C0148a extends InputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ByteBuffer f14400a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f14401b = -1;

        public C0148a(ByteBuffer byteBuffer) {
            this.f14400a = byteBuffer;
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            return this.f14400a.remaining();
        }

        @Override // java.io.InputStream
        public synchronized void mark(int i11) {
            this.f14401b = this.f14400a.position();
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            return true;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            if (this.f14400a.hasRemaining()) {
                return this.f14400a.get();
            }
            return -1;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i11, int i12) throws IOException {
            if (!this.f14400a.hasRemaining()) {
                return -1;
            }
            int iMin = Math.min(i12, this.f14400a.remaining());
            this.f14400a.get(bArr, i11, iMin);
            return iMin;
        }

        @Override // java.io.InputStream
        public synchronized void reset() throws IOException {
            int i11 = this.f14401b;
            if (i11 == -1) {
                throw new IOException("Cannot reset to unset mark position");
            }
            this.f14400a.position(i11);
        }

        @Override // java.io.InputStream
        public long skip(long j11) throws IOException {
            if (!this.f14400a.hasRemaining()) {
                return -1L;
            }
            long jMin = Math.min(j11, this.f14400a.remaining());
            ByteBuffer byteBuffer = this.f14400a;
            byteBuffer.position((int) (((long) byteBuffer.position()) + jMin));
            return jMin;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f14402a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f14403b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final byte[] f14404c;

        public b(byte[] bArr, int i11, int i12) {
            this.f14404c = bArr;
            this.f14402a = i11;
            this.f14403b = i12;
        }
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

    public static ByteBuffer b(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        byte[] andSet = f14399a.getAndSet(null);
        if (andSet == null) {
            andSet = new byte[16384];
        }
        while (true) {
            int i11 = inputStream.read(andSet);
            if (i11 < 0) {
                f14399a.set(andSet);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                return (ByteBuffer) ByteBuffer.allocateDirect(byteArray.length).put(byteArray).position(0);
            }
            byteArrayOutputStream.write(andSet, 0, i11);
        }
    }

    public static b c(ByteBuffer byteBuffer) {
        if (byteBuffer.isReadOnly() || !byteBuffer.hasArray()) {
            return null;
        }
        return new b(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.limit());
    }

    public static byte[] d(ByteBuffer byteBuffer) {
        b bVarC = c(byteBuffer);
        if (bVarC != null && bVarC.f14402a == 0 && bVarC.f14403b == bVarC.f14404c.length) {
            return byteBuffer.array();
        }
        ByteBuffer byteBufferAsReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        byte[] bArr = new byte[byteBufferAsReadOnlyBuffer.limit()];
        byteBufferAsReadOnlyBuffer.position(0);
        byteBufferAsReadOnlyBuffer.get(bArr);
        return bArr;
    }

    public static void e(ByteBuffer byteBuffer, File file) throws Throwable {
        RandomAccessFile randomAccessFile;
        FileChannel channel = null;
        try {
            randomAccessFile = new RandomAccessFile(file, "rw");
            try {
                channel = randomAccessFile.getChannel();
                channel.write(byteBuffer);
                channel.force(false);
                channel.close();
                randomAccessFile.close();
                try {
                    channel.close();
                } catch (IOException unused) {
                }
                try {
                    randomAccessFile.close();
                } catch (IOException unused2) {
                }
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

    public static InputStream f(ByteBuffer byteBuffer) {
        return new C0148a(byteBuffer);
    }
}
