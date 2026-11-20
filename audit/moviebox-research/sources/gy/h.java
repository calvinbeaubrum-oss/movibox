package gy;

import com.transsion.transfer.androidasync.ByteBufferList;
import com.transsion.transfer.androidasync.c0;
import com.transsion.transfer.androidasync.http.Multimap;
import com.transsion.transfer.androidasync.http.j;
import com.transsion.transfer.androidasync.http.w;
import com.transsion.transfer.androidasync.r;
import com.transsion.transfer.androidasync.u;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class h implements gy.a<Multimap> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Multimap f65641a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f65642b;

    /* JADX INFO: compiled from: source.java */
    public class a implements fy.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ByteBufferList f65643a;

        public a(ByteBufferList byteBufferList) {
            this.f65643a = byteBufferList;
        }

        @Override // fy.d
        public void D(r rVar, ByteBufferList byteBufferList) {
            byteBufferList.f(this.f65643a);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements fy.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ByteBufferList f65645a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ fy.a f65646b;

        public b(ByteBufferList byteBufferList, fy.a aVar) {
            this.f65645a = byteBufferList;
            this.f65646b = aVar;
        }

        @Override // fy.a
        public void i(Exception exc) {
            try {
                if (exc != null) {
                    throw exc;
                }
                h.this.f65641a = Multimap.parseUrlEncoded(this.f65645a.y());
                this.f65646b.i(null);
            } catch (Exception e11) {
                this.f65646b.i(e11);
            }
        }
    }

    @Override // gy.a
    public void B(r rVar, fy.a aVar) {
        ByteBufferList byteBufferList = new ByteBufferList();
        rVar.o(new a(byteBufferList));
        rVar.A(new b(byteBufferList, aVar));
    }

    @Override // gy.a
    public void H(j jVar, u uVar, fy.a aVar) {
        if (this.f65642b == null) {
            b();
        }
        c0.h(uVar, this.f65642b, aVar);
    }

    @Override // gy.a
    public boolean J() {
        return true;
    }

    public final void b() {
        StringBuilder sb2 = new StringBuilder();
        try {
            boolean z11 = true;
            for (w wVar : this.f65641a) {
                if (wVar.getValue() != null) {
                    if (!z11) {
                        sb2.append('&');
                    }
                    sb2.append(URLEncoder.encode(wVar.getName(), "UTF-8"));
                    sb2.append('=');
                    sb2.append(URLEncoder.encode(wVar.getValue(), "UTF-8"));
                    z11 = false;
                }
            }
            this.f65642b = sb2.toString().getBytes("UTF-8");
        } catch (UnsupportedEncodingException e11) {
            throw new AssertionError(e11);
        }
    }

    @Override // gy.a
    public String c() {
        return "application/x-www-form-urlencoded; charset=utf-8";
    }

    @Override // gy.a
    public int length() {
        if (this.f65642b == null) {
            b();
        }
        return this.f65642b.length;
    }
}
