package gy;

import android.text.TextUtils;
import com.transsion.transfer.androidasync.ByteBufferList;
import com.transsion.transfer.androidasync.c0;
import com.transsion.transfer.androidasync.future.Continuation;
import com.transsion.transfer.androidasync.http.Headers;
import com.transsion.transfer.androidasync.http.Multimap;
import com.transsion.transfer.androidasync.http.j;
import com.transsion.transfer.androidasync.http.server.q;
import com.transsion.transfer.androidasync.r;
import com.transsion.transfer.androidasync.u;
import com.transsion.transfer.androidasync.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class c extends q implements gy.a<Multimap> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public x f65610i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Headers f65611j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ByteBufferList f65612k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public gy.d f65613l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f65614m = "multipart/form-data";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f65615n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f65616o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ArrayList<gy.d> f65617p;

    /* JADX INFO: compiled from: source.java */
    public class a implements x.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Headers f65618a;

        /* JADX INFO: renamed from: gy.c$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public class C0690a implements fy.d {
            public C0690a() {
            }

            @Override // fy.d
            public void D(r rVar, ByteBufferList byteBufferList) {
                byteBufferList.f(c.this.f65612k);
            }
        }

        public a(Headers headers) {
            this.f65618a = headers;
        }

        @Override // com.transsion.transfer.androidasync.x.a
        public void a(String str) {
            if (!"\r".equals(str)) {
                this.f65618a.b(str);
                return;
            }
            c.this.V();
            c cVar = c.this;
            cVar.f65610i = null;
            cVar.o(null);
            gy.d dVar = new gy.d(this.f65618a);
            c.this.getClass();
            if (c.this.G() == null) {
                c cVar2 = c.this;
                cVar2.f65613l = dVar;
                cVar2.f65612k = new ByteBufferList();
                c.this.o(new C0690a());
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements fy.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ fy.a f65621a;

        public b(fy.a aVar) {
            this.f65621a = aVar;
        }

        @Override // fy.a
        public void i(Exception exc) {
            this.f65621a.i(exc);
        }
    }

    /* JADX INFO: renamed from: gy.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public class C0691c implements fy.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u f65623a;

        public C0691c(u uVar) {
            this.f65623a = uVar;
        }

        @Override // fy.c
        public void onContinue(Continuation continuation, fy.a aVar) throws Exception {
            byte[] bytes = "\r\n".getBytes();
            c0.h(this.f65623a, bytes, aVar);
            c.this.f65615n += bytes.length;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d implements fy.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ gy.d f65625a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ u f65626b;

        public d(gy.d dVar, u uVar) {
            this.f65625a = dVar;
            this.f65626b = uVar;
        }

        @Override // fy.c
        public void onContinue(Continuation continuation, fy.a aVar) throws Exception {
            long jC = this.f65625a.c();
            if (jC >= 0) {
                c cVar = c.this;
                cVar.f65615n = (int) (((long) cVar.f65615n) + jC);
            }
            this.f65625a.d(this.f65626b, aVar);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class e implements fy.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ gy.d f65628a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ u f65629b;

        public e(gy.d dVar, u uVar) {
            this.f65628a = dVar;
            this.f65629b = uVar;
        }

        @Override // fy.c
        public void onContinue(Continuation continuation, fy.a aVar) throws Exception {
            byte[] bytes = this.f65628a.b().g(c.this.P()).getBytes();
            c0.h(this.f65629b, bytes, aVar);
            c.this.f65615n += bytes.length;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class f implements fy.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u f65631a;

        public f(u uVar) {
            this.f65631a = uVar;
        }

        @Override // fy.c
        public void onContinue(Continuation continuation, fy.a aVar) throws Exception {
            byte[] bytes = c.this.O().getBytes();
            c0.h(this.f65631a, bytes, aVar);
            c.this.f65615n += bytes.length;
        }
    }

    public c(String str) {
        String string = Multimap.parseSemicolonDelimited(str).getString("boundary");
        if (string == null) {
            L(new Exception("No boundary found for multipart/form-data"));
        } else {
            S(string);
        }
    }

    @Override // gy.a
    public void B(r rVar, fy.a aVar) {
        M(rVar);
        A(aVar);
    }

    @Override // gy.a
    public void H(j jVar, u uVar, fy.a aVar) {
        if (this.f65617p == null) {
            return;
        }
        Continuation continuation = new Continuation(new b(aVar));
        for (gy.d dVar : this.f65617p) {
            continuation.add(new e(dVar, uVar)).add(new d(dVar, uVar)).add(new C0691c(uVar));
        }
        continuation.add(new f(uVar));
        continuation.start();
    }

    @Override // gy.a
    public boolean J() {
        return false;
    }

    @Override // com.transsion.transfer.androidasync.http.server.q
    public void Q() {
        super.Q();
        V();
    }

    @Override // com.transsion.transfer.androidasync.http.server.q
    public void R() {
        Headers headers = new Headers();
        x xVar = new x();
        this.f65610i = xVar;
        xVar.a(new a(headers));
        o(this.f65610i);
    }

    public void T(gy.d dVar) {
        if (this.f65617p == null) {
            this.f65617p = new ArrayList<>();
        }
        this.f65617p.add(dVar);
    }

    public List<gy.d> U() {
        if (this.f65617p == null) {
            return null;
        }
        return new ArrayList(this.f65617p);
    }

    public void V() {
        if (this.f65612k == null) {
            return;
        }
        if (this.f65611j == null) {
            this.f65611j = new Headers();
        }
        String strV = this.f65612k.v();
        String strA = TextUtils.isEmpty(this.f65613l.a()) ? "unnamed" : this.f65613l.a();
        g gVar = new g(strA, strV);
        gVar.f65633a = this.f65613l.f65633a;
        T(gVar);
        this.f65611j.a(strA, strV);
        this.f65613l = null;
        this.f65612k = null;
    }

    @Override // gy.a
    public String c() {
        if (N() == null) {
            S("----------------------------" + UUID.randomUUID().toString().replace("-", ""));
        }
        return this.f65614m + "; boundary=" + N();
    }

    @Override // gy.a
    public int length() {
        if (N() == null) {
            S("----------------------------" + UUID.randomUUID().toString().replace("-", ""));
        }
        int iC = 0;
        for (gy.d dVar : this.f65617p) {
            String strG = dVar.b().g(P());
            if (dVar.c() == -1) {
                return -1;
            }
            iC = (int) (((long) iC) + dVar.c() + ((long) strG.getBytes().length) + ((long) 2));
        }
        int length = iC + O().getBytes().length;
        this.f65616o = length;
        return length;
    }

    public String toString() {
        Iterator<gy.d> it = U().iterator();
        return it.hasNext() ? it.next().toString() : "multipart content is empty";
    }
}
