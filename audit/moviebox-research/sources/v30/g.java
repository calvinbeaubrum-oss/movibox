package v30;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class g extends d {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final i f78726j;

    public g(boolean z11, i iVar) throws IOException {
        this.f78712a = z11;
        this.f78726j = iVar;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
        byteBufferAllocate.order(z11 ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        this.f78713b = iVar.g(byteBufferAllocate, 16L);
        this.f78714c = iVar.j(byteBufferAllocate, 28L);
        this.f78715d = iVar.j(byteBufferAllocate, 32L);
        this.f78716e = iVar.g(byteBufferAllocate, 42L);
        this.f78717f = iVar.g(byteBufferAllocate, 44L);
        this.f78718g = iVar.g(byteBufferAllocate, 46L);
        this.f78719h = iVar.g(byteBufferAllocate, 48L);
        this.f78720i = iVar.g(byteBufferAllocate, 50L);
    }

    @Override // v30.d
    public c a(long j11, int i11) throws IOException {
        return new a(this.f78726j, this, j11, i11);
    }

    @Override // v30.d
    public e b(long j11) throws IOException {
        return new j(this.f78726j, this, j11);
    }

    @Override // v30.d
    public f c(int i11) throws IOException {
        return new l(this.f78726j, this, i11);
    }
}
