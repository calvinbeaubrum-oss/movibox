package c5;

import androidx.annotation.Nullable;
import androidx.media3.common.Metadata;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class c implements a {
    @Override // c5.a
    @Nullable
    public final Metadata a(b bVar) {
        ByteBuffer byteBuffer = (ByteBuffer) z3.a.e(bVar.f9780c);
        z3.a.a(byteBuffer.position() == 0 && byteBuffer.hasArray() && byteBuffer.arrayOffset() == 0);
        return b(bVar, byteBuffer);
    }

    @Nullable
    public abstract Metadata b(b bVar, ByteBuffer byteBuffer);
}
