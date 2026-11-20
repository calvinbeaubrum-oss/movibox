package iy;

import com.transsion.transfer.androidasync.ByteBufferList;
import com.transsion.transfer.androidasync.r;
import com.transsion.transfer.androidasync.y;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Locale;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class c extends d {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f67747i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public CRC32 f67748j;

    /* JADX INFO: compiled from: source.java */
    public class a implements y.j<byte[]> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f67749a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f67750b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ r f67751c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ y f67752d;

        /* JADX INFO: renamed from: iy.c$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public class C0717a implements y.j<byte[]> {

            /* JADX INFO: renamed from: iy.c$a$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: source.java */
            public class C0718a implements y.j<byte[]> {
                public C0718a() {
                }

                @Override // com.transsion.transfer.androidasync.y.j
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public void a(byte[] bArr) {
                    a aVar = a.this;
                    if (aVar.f67750b) {
                        c.this.f67748j.update(bArr, 0, bArr.length);
                    }
                    a.this.e();
                }
            }

            public C0717a() {
            }

            @Override // com.transsion.transfer.androidasync.y.j
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void a(byte[] bArr) {
                a aVar = a.this;
                if (aVar.f67750b) {
                    c.this.f67748j.update(bArr, 0, 2);
                }
                a.this.f67752d.b(c.N(bArr, 0, ByteOrder.LITTLE_ENDIAN) & 65535, new C0718a());
            }
        }

        /* JADX INFO: compiled from: source.java */
        public class b implements fy.d {
            public b() {
            }

            @Override // fy.d
            public void D(r rVar, ByteBufferList byteBufferList) {
                if (a.this.f67750b) {
                    while (byteBufferList.E() > 0) {
                        ByteBuffer byteBufferD = byteBufferList.D();
                        c.this.f67748j.update(byteBufferD.array(), byteBufferD.arrayOffset() + byteBufferD.position(), byteBufferD.remaining());
                        ByteBufferList.A(byteBufferD);
                    }
                }
                byteBufferList.B();
                a.this.d();
            }
        }

        /* JADX INFO: renamed from: iy.c$a$c, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public class C0719c implements y.j<byte[]> {
            public C0719c() {
            }

            @Override // com.transsion.transfer.androidasync.y.j
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void a(byte[] bArr) {
                if (((short) c.this.f67748j.getValue()) != c.N(bArr, 0, ByteOrder.LITTLE_ENDIAN)) {
                    c.this.L(new IOException("CRC mismatch"));
                    return;
                }
                c.this.f67748j.reset();
                a aVar = a.this;
                c cVar = c.this;
                cVar.f67747i = false;
                cVar.M(aVar.f67751c);
            }
        }

        public a(r rVar, y yVar) {
            this.f67751c = rVar;
            this.f67752d = yVar;
        }

        public final void d() {
            if (this.f67750b) {
                this.f67752d.b(2, new C0719c());
                return;
            }
            c cVar = c.this;
            cVar.f67747i = false;
            cVar.M(this.f67751c);
        }

        public final void e() {
            y yVar = new y(this.f67751c);
            b bVar = new b();
            int i11 = this.f67749a;
            if ((i11 & 8) != 0) {
                yVar.c((byte) 0, bVar);
            } else if ((i11 & 16) != 0) {
                yVar.c((byte) 0, bVar);
            } else {
                d();
            }
        }

        @Override // com.transsion.transfer.androidasync.y.j
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void a(byte[] bArr) {
            short sN = c.N(bArr, 0, ByteOrder.LITTLE_ENDIAN);
            if (sN != -29921) {
                c.this.L(new IOException(String.format(Locale.ENGLISH, "unknown format (magic number %x)", Short.valueOf(sN))));
                this.f67751c.o(new fy.d.a());
                return;
            }
            byte b11 = bArr[3];
            this.f67749a = b11;
            boolean z11 = (b11 & 2) != 0;
            this.f67750b = z11;
            if (z11) {
                c.this.f67748j.update(bArr, 0, bArr.length);
            }
            if ((this.f67749a & 4) != 0) {
                this.f67752d.b(2, new C0717a());
            } else {
                e();
            }
        }
    }

    public c() {
        super(new Inflater(true));
        this.f67747i = true;
        this.f67748j = new CRC32();
    }

    public static short N(byte[] bArr, int i11, ByteOrder byteOrder) {
        int i12;
        byte b11;
        if (byteOrder == ByteOrder.BIG_ENDIAN) {
            i12 = bArr[i11] << 8;
            b11 = bArr[i11 + 1];
        } else {
            i12 = bArr[i11 + 1] << 8;
            b11 = bArr[i11];
        }
        return (short) ((b11 & 255) | i12);
    }

    @Override // iy.d, com.transsion.transfer.androidasync.v, fy.d
    public void D(r rVar, ByteBufferList byteBufferList) {
        if (!this.f67747i) {
            super.D(rVar, byteBufferList);
        } else {
            y yVar = new y(rVar);
            yVar.b(10, new a(rVar, yVar));
        }
    }
}
