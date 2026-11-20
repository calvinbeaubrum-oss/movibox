package v30;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class b extends c {
    public b(i iVar, d dVar, long j11, int i11) throws IOException {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.order(dVar.f78712a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j12 = j11 + ((long) (i11 * 16));
        this.f78710a = iVar.h(byteBufferAllocate, j12);
        this.f78711b = iVar.h(byteBufferAllocate, j12 + 8);
    }
}
