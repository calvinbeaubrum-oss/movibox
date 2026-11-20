package p007do;

import androidx.core.util.a;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ThreadLocalRandom;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f63507a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ByteBuffer f63508b = ByteBuffer.allocate(4096).order(ByteOrder.LITTLE_ENDIAN);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f63509c;

    public u(a aVar) {
        this.f63507a = aVar;
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        for (int i11 = 0; i11 < 2; i11++) {
            this.f63508b.putInt(threadLocalRandomCurrent.nextInt() * 1640531527);
        }
    }

    public final void a(String str) {
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        b(ByteBuffer.wrap(bytes, 0, bytes.length).order(ByteOrder.LITTLE_ENDIAN));
    }

    public final void b(ByteBuffer byteBuffer) {
        int i11;
        int i12;
        if (byteBuffer.hasRemaining()) {
            ByteOrder byteOrderOrder = byteBuffer.order();
            ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
            if (byteOrderOrder != byteOrder) {
                byteBuffer = byteBuffer.duplicate().order(byteOrder);
            }
        } else {
            byteBuffer = ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putLong(0, 7046029254386353131L);
        }
        ByteBuffer byteBuffer2 = this.f63508b;
        do {
            if (!byteBuffer2.hasRemaining()) {
                ByteBuffer byteBuffer3 = this.f63508b;
                if (this.f63509c != 0) {
                    byteBuffer3.flip();
                    this.f63507a.accept(byteBuffer3);
                    byteBuffer3.clear();
                    for (int i13 = 0; i13 < 2; i13++) {
                        byteBuffer3.putInt(byteBuffer3.getInt(i13 * 4) * 1640531527);
                    }
                    this.f63509c = 0L;
                }
            }
            if (byteBuffer.remaining() < 8) {
                int iPosition = byteBuffer2.position();
                byteBuffer2.put(byteBuffer).put((byte) 0).position(iPosition);
                i11 = byteBuffer2.getInt(iPosition);
                i12 = byteBuffer2.getInt(iPosition + 4);
            } else {
                i11 = byteBuffer.getInt();
                i12 = byteBuffer.getInt();
            }
            int i14 = (byteBuffer2.getInt(0) * 1640531527) ^ (byteBuffer2.getInt(4) * 1640531527);
            int i15 = i11 + ((((i12 << 4) ^ (i12 >>> 5)) + i12) ^ (byteBuffer2.getInt((i14 & 1) * 4) + i14));
            byteBuffer2.putInt(i15).putInt(i12 + ((((i15 << 4) ^ (i15 >>> 5)) + i15) ^ (byteBuffer2.getInt(((i14 >>> 11) & 1) * 4) + i14)));
            this.f63509c += 8;
        } while (byteBuffer.hasRemaining());
    }
}
