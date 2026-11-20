package yn;

import com.meituan.android.walle.SignatureNotFoundException;
import java.io.IOException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.LinkedHashMap;
import java.util.Map;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class a {
    public static void a(ByteBuffer byteBuffer) {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    public static d<ByteBuffer, Long> b(FileChannel fileChannel) throws SignatureNotFoundException, IOException {
        return c(fileChannel, d(fileChannel));
    }

    public static d<ByteBuffer, Long> c(FileChannel fileChannel, long j11) throws SignatureNotFoundException, IOException {
        if (j11 < 32) {
            throw new SignatureNotFoundException("APK too small for APK Signing Block. ZIP Central Directory offset: " + j11);
        }
        fileChannel.position(j11 - 24);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(24);
        fileChannel.read(byteBufferAllocate);
        ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
        byteBufferAllocate.order(byteOrder);
        if (byteBufferAllocate.getLong(8) != 2334950737559900225L || byteBufferAllocate.getLong(16) != 3617552046287187010L) {
            throw new SignatureNotFoundException("No APK Signing Block before ZIP Central Directory");
        }
        long j12 = byteBufferAllocate.getLong(0);
        if (j12 < byteBufferAllocate.capacity() || j12 > 2147483639) {
            throw new SignatureNotFoundException("APK Signing Block size out of range: " + j12);
        }
        int i11 = (int) (8 + j12);
        long j13 = j11 - ((long) i11);
        if (j13 < 0) {
            throw new SignatureNotFoundException("APK Signing Block offset out of range: " + j13);
        }
        fileChannel.position(j13);
        ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(i11);
        fileChannel.read(byteBufferAllocate2);
        byteBufferAllocate2.order(byteOrder);
        long j14 = byteBufferAllocate2.getLong(0);
        if (j14 == j12) {
            return d.b(byteBufferAllocate2, Long.valueOf(j13));
        }
        throw new SignatureNotFoundException("APK Signing Block sizes in header and footer do not match: " + j14 + " vs " + j12);
    }

    public static long d(FileChannel fileChannel) throws IOException {
        return e(fileChannel, h(fileChannel));
    }

    public static long e(FileChannel fileChannel, long j11) throws IOException {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        fileChannel.position((fileChannel.size() - j11) - 6);
        fileChannel.read(byteBufferAllocate);
        return byteBufferAllocate.getInt(0);
    }

    public static Map<Integer, ByteBuffer> f(ByteBuffer byteBuffer) throws SignatureNotFoundException {
        a(byteBuffer);
        ByteBuffer byteBufferI = i(byteBuffer, 8, byteBuffer.capacity() - 24);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int i11 = 0;
        while (byteBufferI.hasRemaining()) {
            i11++;
            if (byteBufferI.remaining() < 8) {
                throw new SignatureNotFoundException("Insufficient data to read size of APK Signing Block entry #" + i11);
            }
            long j11 = byteBufferI.getLong();
            if (j11 < 4 || j11 > 2147483647L) {
                throw new SignatureNotFoundException("APK Signing Block entry #" + i11 + " size out of range: " + j11);
            }
            int i12 = (int) j11;
            int iPosition = byteBufferI.position() + i12;
            if (i12 > byteBufferI.remaining()) {
                throw new SignatureNotFoundException("APK Signing Block entry #" + i11 + " size out of range: " + i12 + ", available: " + byteBufferI.remaining());
            }
            linkedHashMap.put(Integer.valueOf(byteBufferI.getInt()), g(byteBufferI, i12 - 4));
        }
        return linkedHashMap;
    }

    public static ByteBuffer g(ByteBuffer byteBuffer, int i11) throws BufferUnderflowException {
        if (i11 < 0) {
            throw new IllegalArgumentException("size: " + i11);
        }
        int iLimit = byteBuffer.limit();
        int iPosition = byteBuffer.position();
        int i12 = i11 + iPosition;
        if (i12 < iPosition || i12 > iLimit) {
            throw new BufferUnderflowException();
        }
        try {
            ByteBuffer byteBufferSlice = byteBuffer.slice();
            byteBufferSlice.order(byteBuffer.order());
            return byteBufferSlice;
        } finally {
        }
    }

    public static long h(FileChannel fileChannel) throws IOException {
        long size = fileChannel.size();
        if (size < 22) {
            throw new IOException("APK too small for ZIP End of Central Directory (EOCD) record");
        }
        long j11 = size - 22;
        long jMin = Math.min(j11, WebSocketProtocol.PAYLOAD_SHORT_MAX);
        int i11 = 0;
        while (true) {
            long j12 = i11;
            if (j12 > jMin) {
                throw new IOException("ZIP End of Central Directory (EOCD) record not found");
            }
            long j13 = j11 - j12;
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
            fileChannel.position(j13);
            fileChannel.read(byteBufferAllocate);
            ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
            byteBufferAllocate.order(byteOrder);
            if (byteBufferAllocate.getInt(0) == 101010256) {
                ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(2);
                fileChannel.position(j13 + 20);
                fileChannel.read(byteBufferAllocate2);
                byteBufferAllocate2.order(byteOrder);
                short s11 = byteBufferAllocate2.getShort(0);
                if (s11 == i11) {
                    return s11;
                }
            }
            i11++;
        }
    }

    public static ByteBuffer i(ByteBuffer byteBuffer, int i11, int i12) {
        if (i11 < 0) {
            throw new IllegalArgumentException("start: " + i11);
        }
        if (i12 < i11) {
            throw new IllegalArgumentException("end < start: " + i12 + " < " + i11);
        }
        int iCapacity = byteBuffer.capacity();
        if (i12 > byteBuffer.capacity()) {
            throw new IllegalArgumentException("end > capacity: " + i12 + " > " + iCapacity);
        }
        int iLimit = byteBuffer.limit();
        int iPosition = byteBuffer.position();
        try {
            ByteBuffer byteBufferSlice = byteBuffer.slice();
            byteBufferSlice.order(byteBuffer.order());
            return byteBufferSlice;
        } finally {
        }
    }
}
