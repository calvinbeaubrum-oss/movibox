package com.transsion.transfer.androidasync;

import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class y implements fy.d {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static Hashtable<Class, Method> f58886n = new Hashtable<>();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public r f58895i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public l f58887a = new a(0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public l f58888b = new b(1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public l f58889c = new c(2);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public l f58890d = new d(4);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public l f58891e = new e(8);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public j<byte[]> f58892f = new f();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public j<ByteBufferList> f58893g = new g();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public j<byte[]> f58894h = new h();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public LinkedList<l> f58896j = new LinkedList<>();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ArrayList<Object> f58897k = new ArrayList<>();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ByteOrder f58898l = ByteOrder.BIG_ENDIAN;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ByteBufferList f58899m = new ByteBufferList();

    /* JADX INFO: compiled from: source.java */
    public class a extends l {
        public a(int i11) {
            super(i11);
        }

        @Override // com.transsion.transfer.androidasync.y.l
        public l a(r rVar, ByteBufferList byteBufferList) {
            y.this.f58897k.add(null);
            return null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends l {
        public b(int i11) {
            super(i11);
        }

        @Override // com.transsion.transfer.androidasync.y.l
        public l a(r rVar, ByteBufferList byteBufferList) {
            y.this.f58897k.add(Byte.valueOf(byteBufferList.e()));
            return null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c extends l {
        public c(int i11) {
            super(i11);
        }

        @Override // com.transsion.transfer.androidasync.y.l
        public l a(r rVar, ByteBufferList byteBufferList) {
            y.this.f58897k.add(Short.valueOf(byteBufferList.q()));
            return null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d extends l {
        public d(int i11) {
            super(i11);
        }

        @Override // com.transsion.transfer.androidasync.y.l
        public l a(r rVar, ByteBufferList byteBufferList) {
            y.this.f58897k.add(Integer.valueOf(byteBufferList.n()));
            return null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class e extends l {
        public e(int i11) {
            super(i11);
        }

        @Override // com.transsion.transfer.androidasync.y.l
        public l a(r rVar, ByteBufferList byteBufferList) {
            y.this.f58897k.add(Long.valueOf(byteBufferList.o()));
            return null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class f implements j<byte[]> {
        public f() {
        }

        @Override // com.transsion.transfer.androidasync.y.j
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(byte[] bArr) {
            y.this.f58897k.add(bArr);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class g implements j<ByteBufferList> {
        public g() {
        }

        @Override // com.transsion.transfer.androidasync.y.j
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(ByteBufferList byteBufferList) {
            y.this.f58897k.add(byteBufferList);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class h implements j<byte[]> {
        public h() {
        }

        @Override // com.transsion.transfer.androidasync.y.j
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(byte[] bArr) {
            y.this.f58897k.add(new String(bArr));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class i extends l {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public j<byte[]> f58908b;

        public i(int i11, j<byte[]> jVar) {
            super(i11);
            if (i11 <= 0) {
                throw new IllegalArgumentException("length should be > 0");
            }
            this.f58908b = jVar;
        }

        @Override // com.transsion.transfer.androidasync.y.l
        public l a(r rVar, ByteBufferList byteBufferList) {
            byte[] bArr = new byte[this.f58911a];
            byteBufferList.h(bArr);
            this.f58908b.a(bArr);
            return null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface j<T> {
        void a(T t11);
    }

    /* JADX INFO: compiled from: source.java */
    public static class k extends l {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public byte f58909b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public fy.d f58910c;

        public k(byte b11, fy.d dVar) {
            super(1);
            this.f58909b = b11;
            this.f58910c = dVar;
        }

        @Override // com.transsion.transfer.androidasync.y.l
        public l a(r rVar, ByteBufferList byteBufferList) {
            ByteBufferList byteBufferList2 = new ByteBufferList();
            boolean z11 = true;
            while (byteBufferList.E() > 0) {
                ByteBuffer byteBufferD = byteBufferList.D();
                byteBufferD.mark();
                int i11 = 0;
                while (byteBufferD.remaining() > 0) {
                    z11 = byteBufferD.get() == this.f58909b;
                    if (z11) {
                        break;
                    }
                    i11++;
                }
                byteBufferD.reset();
                if (z11) {
                    byteBufferList.c(byteBufferD);
                    byteBufferList.g(byteBufferList2, i11);
                    byteBufferList.e();
                    break;
                }
                byteBufferList2.a(byteBufferD);
            }
            this.f58910c.D(rVar, byteBufferList2);
            if (z11) {
                return null;
            }
            return this;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f58911a;

        public l(int i11) {
            this.f58911a = i11;
        }

        public abstract l a(r rVar, ByteBufferList byteBufferList);
    }

    public y(r rVar) {
        this.f58895i = rVar;
        rVar.o(this);
    }

    @Override // fy.d
    public void D(r rVar, ByteBufferList byteBufferList) {
        byteBufferList.f(this.f58899m);
        while (this.f58896j.size() > 0 && this.f58899m.C() >= this.f58896j.peek().f58911a) {
            this.f58899m.u(this.f58898l);
            l lVarA = this.f58896j.poll().a(rVar, this.f58899m);
            if (lVarA != null) {
                this.f58896j.addFirst(lVarA);
            }
        }
        if (this.f58896j.size() == 0) {
            this.f58899m.f(byteBufferList);
        }
    }

    public y b(int i11, j<byte[]> jVar) {
        this.f58896j.add(new i(i11, jVar));
        return this;
    }

    public y c(byte b11, fy.d dVar) {
        this.f58896j.add(new k(b11, dVar));
        return this;
    }
}
