package v30;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class a extends c {
    public a(i iVar, d dVar, long j11, int i11) throws IOException {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
        byteBufferAllocate.order(dVar.f78712a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j12 = j11 + ((long) (i11 * 8));
        this.f78710a = iVar.j(byteBufferAllocate, j12);
        this.f78711b = iVar.j(byteBufferAllocate, j12 + 4);
    }
}
