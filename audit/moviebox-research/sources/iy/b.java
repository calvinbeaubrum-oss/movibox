package iy;

import com.transsion.transfer.androidasync.ByteBufferList;
import com.transsion.transfer.androidasync.http.filter.PrematureDataEndException;
import com.transsion.transfer.androidasync.r;
import com.transsion.transfer.androidasync.v;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class b extends v {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f67744g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f67745h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ByteBufferList f67746i = new ByteBufferList();

    public b(long j11) {
        this.f67744g = j11;
    }

    @Override // com.transsion.transfer.androidasync.v, fy.d
    public void D(r rVar, ByteBufferList byteBufferList) {
        byteBufferList.g(this.f67746i, (int) Math.min(this.f67744g - this.f67745h, byteBufferList.C()));
        int iC = this.f67746i.C();
        super.D(rVar, this.f67746i);
        this.f67745h += (long) (iC - this.f67746i.C());
        this.f67746i.f(byteBufferList);
        if (this.f67745h == this.f67744g) {
            L(null);
        }
    }

    @Override // com.transsion.transfer.androidasync.s
    public void L(Exception exc) {
        if (exc == null && this.f67745h != this.f67744g) {
            exc = new PrematureDataEndException("End of data reached before content length was read: " + this.f67745h + "/" + this.f67744g + " Paused: " + e());
        }
        super.L(exc);
    }
}
