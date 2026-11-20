package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b extends e {
    public static b i(ByteBuffer byteBuffer) {
        return j(byteBuffer, new b());
    }

    public static b j(ByteBuffer byteBuffer, b bVar) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return bVar.g(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public b g(int i11, ByteBuffer byteBuffer) {
        h(i11, byteBuffer);
        return this;
    }

    public void h(int i11, ByteBuffer byteBuffer) {
        c(i11, byteBuffer);
    }

    public a k(a aVar, int i11) {
        int iB = b(6);
        if (iB != 0) {
            return aVar.g(a(d(iB) + (i11 * 4)), this.f8323b);
        }
        return null;
    }

    public int l() {
        int iB = b(6);
        if (iB != 0) {
            return e(iB);
        }
        return 0;
    }

    public int m() {
        int iB = b(4);
        if (iB != 0) {
            return this.f8323b.getInt(iB + this.f8322a);
        }
        return 0;
    }
}
