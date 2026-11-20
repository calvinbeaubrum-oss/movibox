package com.transsion.transfer.androidasync;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f58488a = false;

    /* JADX INFO: compiled from: source.java */
    public class a implements fy.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u f58489a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ByteBufferList f58490b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ fy.a f58491c;

        public a(u uVar, ByteBufferList byteBufferList, fy.a aVar) {
            this.f58489a = uVar;
            this.f58490b = byteBufferList;
            this.f58491c = aVar;
        }

        @Override // fy.j
        public void a() {
            this.f58489a.m(this.f58490b);
            if (this.f58490b.C() != 0 || this.f58491c == null) {
                return;
            }
            this.f58489a.p(null);
            this.f58491c.i(null);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements fy.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f58492a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ fy.a f58493b;

        public b(fy.a aVar) {
            this.f58493b = aVar;
        }

        @Override // fy.a
        public void i(Exception exc) {
            if (this.f58492a) {
                return;
            }
            this.f58492a = true;
            this.f58493b.i(exc);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements fy.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f58494a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ByteBufferList f58495b = new ByteBufferList();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public com.transsion.transfer.androidasync.util.a f58496c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ u f58497d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ InputStream f58498e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ long f58499f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ fy.a f58500g;

        public c(u uVar, InputStream inputStream, long j11, fy.a aVar) {
            this.f58497d = uVar;
            this.f58498e = inputStream;
            this.f58499f = j11;
            this.f58500g = aVar;
            this.f58496c = new com.transsion.transfer.androidasync.util.a().d((int) Math.min(PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED, j11));
        }

        @Override // fy.j
        public void a() {
            do {
                try {
                    if (!this.f58495b.r()) {
                        ByteBuffer byteBufferA = this.f58496c.a();
                        int i11 = this.f58498e.read(byteBufferA.array(), 0, (int) Math.min(this.f58499f - ((long) this.f58494a), byteBufferA.capacity()));
                        if (i11 != -1 && this.f58494a != this.f58499f) {
                            this.f58496c.e(i11);
                            this.f58494a += i11;
                            byteBufferA.position(0);
                            byteBufferA.limit(i11);
                            this.f58495b.a(byteBufferA);
                        }
                        b();
                        this.f58500g.i(null);
                        return;
                    }
                    this.f58497d.m(this.f58495b);
                } catch (Exception e11) {
                    b();
                    this.f58500g.i(e11);
                    return;
                }
            } while (!this.f58495b.r());
        }

        public final void b() {
            this.f58497d.y(null);
            this.f58497d.p(null);
            this.f58495b.B();
            com.transsion.transfer.androidasync.util.e.a(this.f58498e);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d implements fy.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f58501a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ fy.a f58502b;

        public d(fy.a aVar) {
            this.f58502b = aVar;
        }

        @Override // fy.a
        public void i(Exception exc) {
            if (this.f58501a) {
                return;
            }
            this.f58501a = true;
            this.f58502b.i(exc);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class e implements fy.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f58503a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ByteBufferList f58504b = new ByteBufferList();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public com.transsion.transfer.androidasync.util.a f58505c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ u f58506d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ InputStream f58507e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ long f58508f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ fy.a f58509g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ fy.e f58510h;

        public e(u uVar, InputStream inputStream, long j11, fy.a aVar, fy.e eVar) {
            this.f58506d = uVar;
            this.f58507e = inputStream;
            this.f58508f = j11;
            this.f58509g = aVar;
            this.f58510h = eVar;
            this.f58505c = new com.transsion.transfer.androidasync.util.a().d((int) Math.min(PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED, j11));
        }

        private void b() {
            this.f58506d.y(null);
            this.f58506d.p(null);
            this.f58504b.B();
            com.transsion.transfer.androidasync.util.e.a(this.f58507e);
        }

        @Override // fy.j
        public void a() {
            do {
                try {
                    if (!this.f58504b.r()) {
                        ByteBuffer byteBufferA = this.f58505c.a();
                        int i11 = this.f58507e.read(byteBufferA.array(), 0, (int) Math.min(this.f58508f - ((long) this.f58503a), byteBufferA.capacity()));
                        if (i11 != -1 && this.f58503a != this.f58508f) {
                            this.f58505c.e(i11);
                            int i12 = this.f58503a + i11;
                            this.f58503a = i12;
                            fy.e eVar = this.f58510h;
                            if (eVar != null) {
                                eVar.a(i12, this.f58508f);
                            }
                            byteBufferA.position(0);
                            byteBufferA.limit(i11);
                            this.f58504b.a(byteBufferA);
                        }
                        b();
                        this.f58509g.i(null);
                        fy.e eVar2 = this.f58510h;
                        if (eVar2 != null) {
                            eVar2.b(null);
                            return;
                        }
                        return;
                    }
                    this.f58506d.m(this.f58504b);
                } catch (Exception e11) {
                    b();
                    this.f58509g.i(e11);
                    fy.e eVar3 = this.f58510h;
                    if (eVar3 != null) {
                        eVar3.b(e11);
                        return;
                    }
                    return;
                }
            } while (!this.f58504b.r());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class f implements fy.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u f58511a;

        public f(u uVar) {
            this.f58511a = uVar;
        }

        @Override // fy.d
        public void D(r rVar, ByteBufferList byteBufferList) {
            this.f58511a.m(byteBufferList);
            if (byteBufferList.C() > 0) {
                rVar.pause();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class g implements fy.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ r f58512a;

        public g(r rVar) {
            this.f58512a = rVar;
        }

        @Override // fy.j
        public void a() {
            this.f58512a.resume();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class h implements fy.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f58513a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ r f58514b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ u f58515c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ fy.a f58516d;

        public h(r rVar, u uVar, fy.a aVar) {
            this.f58514b = rVar;
            this.f58515c = uVar;
            this.f58516d = aVar;
        }

        @Override // fy.a
        public void i(Exception exc) {
            if (this.f58513a) {
                return;
            }
            this.f58513a = true;
            this.f58514b.o(null);
            this.f58514b.A(null);
            this.f58515c.y(null);
            this.f58515c.p(null);
            this.f58516d.i(exc);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class i implements fy.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ fy.a f58517a;

        public i(fy.a aVar) {
            this.f58517a = aVar;
        }

        @Override // fy.a
        public void i(Exception exc) {
            if (exc == null) {
                exc = new IOException("sink was closed before emitter ended");
            }
            this.f58517a.i(exc);
        }
    }

    public static void a(r rVar, ByteBufferList byteBufferList) {
        int iC;
        fy.d dVarG = null;
        while (!rVar.e() && (dVarG = rVar.G()) != null && (iC = byteBufferList.C()) > 0) {
            dVarG.D(rVar, byteBufferList);
            if (iC == byteBufferList.C() && dVarG == rVar.G() && !rVar.e()) {
                System.out.println("handler: " + dVarG);
                byteBufferList.B();
                if (!f58488a) {
                    throw new RuntimeException("mDataHandler failed to consume data, yet remains the mDataHandler.");
                }
                return;
            }
        }
        if (byteBufferList.C() == 0 || rVar.e()) {
            return;
        }
        PrintStream printStream = System.out;
        printStream.println("handler: " + dVarG);
        printStream.println("emitter: " + rVar);
        byteBufferList.B();
    }

    public static void b(fy.a aVar, Exception exc) {
        if (aVar != null) {
            aVar.i(exc);
        }
    }

    public static void c(r rVar, u uVar, fy.a aVar) {
        rVar.o(new f(uVar));
        uVar.p(new g(rVar));
        h hVar = new h(rVar, uVar, aVar);
        rVar.A(hVar);
        uVar.y(new i(hVar));
    }

    public static void d(InputStream inputStream, long j11, u uVar, fy.a aVar) {
        b bVar = new b(aVar);
        c cVar = new c(uVar, inputStream, j11, bVar);
        uVar.p(cVar);
        uVar.y(bVar);
        cVar.a();
    }

    public static void e(InputStream inputStream, long j11, u uVar, fy.a aVar, fy.e eVar) {
        d dVar = new d(aVar);
        e eVar2 = new e(uVar, inputStream, j11, dVar, eVar);
        uVar.p(eVar2);
        uVar.y(dVar);
        eVar2.a();
    }

    public static void f(InputStream inputStream, u uVar, fy.a aVar) {
        d(inputStream, 2147483647L, uVar, aVar);
    }

    public static void g(u uVar, ByteBufferList byteBufferList, fy.a aVar) {
        a aVar2 = new a(uVar, byteBufferList, aVar);
        uVar.p(aVar2);
        aVar2.a();
    }

    public static void h(u uVar, byte[] bArr, fy.a aVar) {
        ByteBuffer byteBufferT = ByteBufferList.t(bArr.length);
        byteBufferT.put(bArr);
        byteBufferT.flip();
        ByteBufferList byteBufferList = new ByteBufferList();
        byteBufferList.a(byteBufferT);
        g(uVar, byteBufferList, aVar);
    }
}
