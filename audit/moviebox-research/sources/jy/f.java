package jy;

import com.transsion.transfer.androidasync.ByteBufferList;
import com.transsion.transfer.androidasync.future.y;
import com.transsion.transfer.androidasync.r;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class f implements a<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Charset f68186a;

    @Override // jy.a
    public com.transsion.transfer.androidasync.future.f<String> a(r rVar) {
        final String strS = rVar.s();
        return new b().a(rVar).r(new y() { // from class: jy.e
            @Override // com.transsion.transfer.androidasync.future.y
            public final Object then(Object obj) {
                return this.f68184a.c(strS, (ByteBufferList) obj);
            }
        });
    }

    public final /* synthetic */ String c(String str, ByteBufferList byteBufferList) throws Exception {
        Charset charsetForName = this.f68186a;
        if (charsetForName == null && str != null) {
            charsetForName = Charset.forName(str);
        }
        return byteBufferList.z(charsetForName);
    }
}
