package iy;

import com.transsion.transfer.androidasync.ByteBufferList;
import com.transsion.transfer.androidasync.c0;
import com.transsion.transfer.androidasync.http.filter.DataRemainingException;
import com.transsion.transfer.androidasync.r;
import com.transsion.transfer.androidasync.v;
import java.nio.ByteBuffer;
import java.util.zip.Inflater;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class d extends v {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Inflater f67758g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ByteBufferList f67759h;

    public d() {
        this(new Inflater());
    }

    public d(Inflater inflater) {
        this.f67759h = new ByteBufferList();
        this.f67758g = inflater;
    }

    @Override // com.transsion.transfer.androidasync.v, fy.d
    public void D(r rVar, ByteBufferList byteBufferList) {
        try {
            ByteBuffer byteBufferT = ByteBufferList.t(byteBufferList.C() * 2);
            while (byteBufferList.E() > 0) {
                ByteBuffer byteBufferD = byteBufferList.D();
                if (byteBufferD.hasRemaining()) {
                    byteBufferD.remaining();
                    this.f67758g.setInput(byteBufferD.array(), byteBufferD.arrayOffset() + byteBufferD.position(), byteBufferD.remaining());
                    do {
                        byteBufferT.position(byteBufferT.position() + this.f67758g.inflate(byteBufferT.array(), byteBufferT.arrayOffset() + byteBufferT.position(), byteBufferT.remaining()));
                        if (!byteBufferT.hasRemaining()) {
                            byteBufferT.flip();
                            this.f67759h.a(byteBufferT);
                            byteBufferT = ByteBufferList.t(byteBufferT.capacity() * 2);
                        }
                        if (this.f67758g.needsInput()) {
                            break;
                        }
                    } while (!this.f67758g.finished());
                }
                ByteBufferList.A(byteBufferD);
            }
            byteBufferT.flip();
            this.f67759h.a(byteBufferT);
            c0.a(this, this.f67759h);
        } catch (Exception e11) {
            L(e11);
        }
    }

    @Override // com.transsion.transfer.androidasync.s
    public void L(Exception exc) {
        this.f67758g.end();
        if (exc != null && this.f67758g.getRemaining() > 0) {
            exc = new DataRemainingException("data still remaining in inflater", exc);
        }
        super.L(exc);
    }
}
