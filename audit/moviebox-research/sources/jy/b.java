package jy;

import com.transsion.transfer.androidasync.ByteBufferList;
import com.transsion.transfer.androidasync.future.w;
import com.transsion.transfer.androidasync.r;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class b implements jy.a<ByteBufferList> {

    /* JADX INFO: compiled from: source.java */
    public class a extends w<ByteBufferList> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ r f68177g;

        public a(r rVar) {
            this.f68177g = rVar;
        }

        @Override // com.transsion.transfer.androidasync.future.n
        public void cancelCleanup() {
            this.f68177g.close();
        }
    }

    /* JADX INFO: renamed from: jy.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public class C0733b implements fy.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ByteBufferList f68179a;

        public C0733b(ByteBufferList byteBufferList) {
            this.f68179a = byteBufferList;
        }

        @Override // fy.d
        public void D(r rVar, ByteBufferList byteBufferList) {
            byteBufferList.f(this.f68179a);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements fy.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ w f68181a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ByteBufferList f68182b;

        public c(w wVar, ByteBufferList byteBufferList) {
            this.f68181a = wVar;
            this.f68182b = byteBufferList;
        }

        @Override // fy.a
        public void i(Exception exc) {
            if (exc != null) {
                this.f68181a.G(exc);
                return;
            }
            try {
                this.f68181a.J(this.f68182b);
            } catch (Exception e11) {
                this.f68181a.G(e11);
            }
        }
    }

    @Override // jy.a
    public com.transsion.transfer.androidasync.future.f<ByteBufferList> a(r rVar) {
        ByteBufferList byteBufferList = new ByteBufferList();
        a aVar = new a(rVar);
        rVar.o(new C0733b(byteBufferList));
        rVar.A(new c(aVar, byteBufferList));
        return aVar;
    }
}
