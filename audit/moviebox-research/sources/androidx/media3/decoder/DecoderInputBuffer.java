package androidx.media3.decoder;

import androidx.annotation.Nullable;
import androidx.media3.common.c0;
import androidx.media3.common.y;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class DecoderInputBuffer extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public y f9778a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f9779b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public ByteBuffer f9780c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f9781d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f9782f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public ByteBuffer f9783g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f9784h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f9785i;

    /* JADX INFO: compiled from: source.java */
    public static final class InsufficientCapacityException extends IllegalStateException {
        public final int currentCapacity;
        public final int requiredCapacity;

        public InsufficientCapacityException(int i11, int i12) {
            super("Buffer too small (" + i11 + " < " + i12 + ")");
            this.currentCapacity = i11;
            this.requiredCapacity = i12;
        }
    }

    static {
        c0.a("media3.decoder");
    }

    public DecoderInputBuffer(int i11) {
        this(i11, 0);
    }

    public DecoderInputBuffer(int i11, int i12) {
        this.f9779b = new c();
        this.f9784h = i11;
        this.f9785i = i12;
    }

    public static DecoderInputBuffer e() {
        return new DecoderInputBuffer(0);
    }

    public final ByteBuffer a(int i11) {
        int i12 = this.f9784h;
        if (i12 == 1) {
            return ByteBuffer.allocate(i11);
        }
        if (i12 == 2) {
            return ByteBuffer.allocateDirect(i11);
        }
        ByteBuffer byteBuffer = this.f9780c;
        throw new InsufficientCapacityException(byteBuffer == null ? 0 : byteBuffer.capacity(), i11);
    }

    public void b(int i11) {
        int i12 = i11 + this.f9785i;
        ByteBuffer byteBuffer = this.f9780c;
        if (byteBuffer == null) {
            this.f9780c = a(i12);
            return;
        }
        int iCapacity = byteBuffer.capacity();
        int iPosition = byteBuffer.position();
        int i13 = i12 + iPosition;
        if (iCapacity >= i13) {
            this.f9780c = byteBuffer;
            return;
        }
        ByteBuffer byteBufferA = a(i13);
        byteBufferA.order(byteBuffer.order());
        if (iPosition > 0) {
            byteBuffer.flip();
            byteBufferA.put(byteBuffer);
        }
        this.f9780c = byteBufferA;
    }

    public final void c() {
        ByteBuffer byteBuffer = this.f9780c;
        if (byteBuffer != null) {
            byteBuffer.flip();
        }
        ByteBuffer byteBuffer2 = this.f9783g;
        if (byteBuffer2 != null) {
            byteBuffer2.flip();
        }
    }

    @Override // androidx.media3.decoder.a
    public void clear() {
        super.clear();
        ByteBuffer byteBuffer = this.f9780c;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
        ByteBuffer byteBuffer2 = this.f9783g;
        if (byteBuffer2 != null) {
            byteBuffer2.clear();
        }
        this.f9781d = false;
    }

    public final boolean d() {
        return getFlag(1073741824);
    }

    public void h(int i11) {
        ByteBuffer byteBuffer = this.f9783g;
        if (byteBuffer == null || byteBuffer.capacity() < i11) {
            this.f9783g = ByteBuffer.allocate(i11);
        } else {
            this.f9783g.clear();
        }
    }
}
