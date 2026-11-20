package v30;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class k extends e {
    public k(i iVar, d dVar, long j11) throws IOException {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.order(dVar.f78712a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j12 = dVar.f78714c + (j11 * ((long) dVar.f78716e));
        this.f78721a = iVar.j(byteBufferAllocate, j12);
        this.f78722b = iVar.h(byteBufferAllocate, 8 + j12);
        this.f78723c = iVar.h(byteBufferAllocate, 16 + j12);
        this.f78724d = iVar.h(byteBufferAllocate, j12 + 40);
    }
}
