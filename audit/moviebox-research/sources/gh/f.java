package gh;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.Metadata;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class f implements b {
    @Override // gh.b
    @Nullable
    public final Metadata a(d dVar) {
        ByteBuffer byteBuffer = (ByteBuffer) com.google.android.exoplayer2.util.a.e(dVar.f33030c);
        com.google.android.exoplayer2.util.a.a(byteBuffer.position() == 0 && byteBuffer.hasArray() && byteBuffer.arrayOffset() == 0);
        if (dVar.h()) {
            return null;
        }
        return b(dVar, byteBuffer);
    }

    @Nullable
    public abstract Metadata b(d dVar, ByteBuffer byteBuffer);
}
