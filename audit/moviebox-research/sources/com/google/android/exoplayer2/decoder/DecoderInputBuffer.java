package com.google.android.exoplayer2.decoder;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.k1;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class DecoderInputBuffer extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f33029b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public ByteBuffer f33030c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f33031d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f33032f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public ByteBuffer f33033g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f33034h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f33035i;

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
        k1.a("goog.exo.decoder");
    }

    public DecoderInputBuffer(int i11) {
        this(i11, 0);
    }

    public DecoderInputBuffer(int i11, int i12) {
        this.f33029b = new c();
        this.f33034h = i11;
        this.f33035i = i12;
    }

    public static DecoderInputBuffer q() {
        return new DecoderInputBuffer(0);
    }

    @Override // com.google.android.exoplayer2.decoder.a
    public void b() {
        super.b();
        ByteBuffer byteBuffer = this.f33030c;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
        ByteBuffer byteBuffer2 = this.f33033g;
        if (byteBuffer2 != null) {
            byteBuffer2.clear();
        }
        this.f33031d = false;
    }

    public final ByteBuffer m(int i11) {
        int i12 = this.f33034h;
        if (i12 == 1) {
            return ByteBuffer.allocate(i11);
        }
        if (i12 == 2) {
            return ByteBuffer.allocateDirect(i11);
        }
        ByteBuffer byteBuffer = this.f33030c;
        throw new InsufficientCapacityException(byteBuffer == null ? 0 : byteBuffer.capacity(), i11);
    }

    public void n(int i11) {
        int i12 = i11 + this.f33035i;
        ByteBuffer byteBuffer = this.f33030c;
        if (byteBuffer == null) {
            this.f33030c = m(i12);
            return;
        }
        int iCapacity = byteBuffer.capacity();
        int iPosition = byteBuffer.position();
        int i13 = i12 + iPosition;
        if (iCapacity >= i13) {
            this.f33030c = byteBuffer;
            return;
        }
        ByteBuffer byteBufferM = m(i13);
        byteBufferM.order(byteBuffer.order());
        if (iPosition > 0) {
            byteBuffer.flip();
            byteBufferM.put(byteBuffer);
        }
        this.f33030c = byteBufferM;
    }

    public final void o() {
        ByteBuffer byteBuffer = this.f33030c;
        if (byteBuffer != null) {
            byteBuffer.flip();
        }
        ByteBuffer byteBuffer2 = this.f33033g;
        if (byteBuffer2 != null) {
            byteBuffer2.flip();
        }
    }

    public final boolean p() {
        return d(1073741824);
    }

    public void r(int i11) {
        ByteBuffer byteBuffer = this.f33033g;
        if (byteBuffer == null || byteBuffer.capacity() < i11) {
            this.f33033g = ByteBuffer.allocate(i11);
        } else {
            this.f33033g.clear();
        }
    }
}
