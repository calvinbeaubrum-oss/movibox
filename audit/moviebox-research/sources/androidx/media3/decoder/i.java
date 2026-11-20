package androidx.media3.decoder;

import androidx.annotation.Nullable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class i extends h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h.a<i> f9814a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public ByteBuffer f9815b;

    public i(h.a<i> aVar) {
        this.f9814a = aVar;
    }

    public ByteBuffer a(long j11, int i11) {
        this.timeUs = j11;
        ByteBuffer byteBuffer = this.f9815b;
        if (byteBuffer == null || byteBuffer.capacity() < i11) {
            this.f9815b = ByteBuffer.allocateDirect(i11).order(ByteOrder.nativeOrder());
        }
        this.f9815b.position(0);
        this.f9815b.limit(i11);
        return this.f9815b;
    }

    @Override // androidx.media3.decoder.h, androidx.media3.decoder.a
    public void clear() {
        super.clear();
        ByteBuffer byteBuffer = this.f9815b;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
    }

    @Override // androidx.media3.decoder.h
    public void release() {
        this.f9814a.a(this);
    }
}
