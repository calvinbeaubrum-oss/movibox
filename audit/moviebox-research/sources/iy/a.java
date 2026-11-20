package iy;

import com.google.android.gms.common.api.Api;
import com.transsion.transfer.androidasync.ByteBufferList;
import com.transsion.transfer.androidasync.u;
import com.transsion.transfer.androidasync.w;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class a extends w {
    public a(u uVar) {
        super(uVar);
    }

    @Override // com.transsion.transfer.androidasync.p, com.transsion.transfer.androidasync.u
    public void f() {
        n(Api.BaseClientBuilder.API_PRIORITY_OTHER);
        m(new ByteBufferList());
        n(0);
    }

    @Override // com.transsion.transfer.androidasync.w
    public ByteBufferList q(ByteBufferList byteBufferList) {
        byteBufferList.c(ByteBuffer.wrap((Integer.toString(byteBufferList.C(), 16) + "\r\n").getBytes()));
        byteBufferList.a(ByteBuffer.wrap("\r\n".getBytes()));
        return byteBufferList;
    }
}
