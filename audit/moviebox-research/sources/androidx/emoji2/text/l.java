package androidx.emoji2.text;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(19)
public class l {

    /* JADX INFO: compiled from: source.java */
    public static class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NonNull
        public final ByteBuffer f8361a;

        public a(@NonNull ByteBuffer byteBuffer) {
            this.f8361a = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        @Override // androidx.emoji2.text.l.c
        public int a() throws IOException {
            return this.f8361a.getInt();
        }

        @Override // androidx.emoji2.text.l.c
        public long b() throws IOException {
            return l.c(this.f8361a.getInt());
        }

        @Override // androidx.emoji2.text.l.c
        public long getPosition() {
            return this.f8361a.position();
        }

        @Override // androidx.emoji2.text.l.c
        public int readUnsignedShort() throws IOException {
            return l.d(this.f8361a.getShort());
        }

        @Override // androidx.emoji2.text.l.c
        public void skip(int i11) throws IOException {
            ByteBuffer byteBuffer = this.f8361a;
            byteBuffer.position(byteBuffer.position() + i11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f8362a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f8363b;

        public b(long j11, long j12) {
            this.f8362a = j11;
            this.f8363b = j12;
        }

        public long a() {
            return this.f8362a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface c {
        int a() throws IOException;

        long b() throws IOException;

        long getPosition();

        int readUnsignedShort() throws IOException;

        void skip(int i11) throws IOException;
    }

    public static b a(c cVar) throws IOException {
        long jB;
        cVar.skip(4);
        int unsignedShort = cVar.readUnsignedShort();
        if (unsignedShort > 100) {
            throw new IOException("Cannot read metadata.");
        }
        cVar.skip(6);
        int i11 = 0;
        while (true) {
            if (i11 >= unsignedShort) {
                jB = -1;
                break;
            }
            int iA = cVar.a();
            cVar.skip(4);
            jB = cVar.b();
            cVar.skip(4);
            if (1835365473 == iA) {
                break;
            }
            i11++;
        }
        if (jB != -1) {
            cVar.skip((int) (jB - cVar.getPosition()));
            cVar.skip(12);
            long jB2 = cVar.b();
            for (int i12 = 0; i12 < jB2; i12++) {
                int iA2 = cVar.a();
                long jB3 = cVar.b();
                long jB4 = cVar.b();
                if (1164798569 == iA2 || 1701669481 == iA2) {
                    return new b(jB3 + jB, jB4);
                }
            }
        }
        throw new IOException("Cannot read metadata.");
    }

    public static androidx.emoji2.text.flatbuffer.b b(ByteBuffer byteBuffer) throws IOException {
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        byteBufferDuplicate.position((int) a(new a(byteBufferDuplicate)).a());
        return androidx.emoji2.text.flatbuffer.b.i(byteBufferDuplicate);
    }

    public static long c(int i11) {
        return ((long) i11) & 4294967295L;
    }

    public static int d(short s11) {
        return s11 & 65535;
    }
}
