package t10;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final List<C0842a> f76709j;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f76711b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public byte[] f76714e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f76715f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public InputStream f76716g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean[] f76718i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f76710a = new byte[8000];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public short[] f76712c = new short[256];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f76713d = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f76717h = false;

    /* JADX INFO: renamed from: t10.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class C0842a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public h f76719a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f76720b;

        public C0842a(h hVar, boolean z11) {
            this.f76719a = hVar;
            this.f76720b = z11;
        }
    }

    static {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new C0842a(new d(), true));
        arrayList.add(new C0842a(new e.a(), true));
        arrayList.add(new C0842a(new e.b(), true));
        arrayList.add(new C0842a(new e.d(), true));
        arrayList.add(new C0842a(new e.C0844e(), true));
        arrayList.add(new C0842a(new f.d(), true));
        arrayList.add(new C0842a(new c.b(), true));
        arrayList.add(new C0842a(new c.a(), true));
        arrayList.add(new C0842a(new c.C0843c(), true));
        arrayList.add(new C0842a(new f.c(), true));
        arrayList.add(new C0842a(new f.b.a(), true));
        arrayList.add(new C0842a(new f.b.C0845b(), true));
        arrayList.add(new C0842a(new f.a(), true));
        arrayList.add(new C0842a(new g.a(), true));
        arrayList.add(new C0842a(new g.b(), true));
        arrayList.add(new C0842a(new g.d(), true));
        arrayList.add(new C0842a(new g.f(), true));
        arrayList.add(new C0842a(new g.h(), true));
        arrayList.add(new C0842a(new g.j(), true));
        arrayList.add(new C0842a(new g.k(), true));
        arrayList.add(new C0842a(new g.u(), true));
        arrayList.add(new C0842a(new g.v(), true));
        arrayList.add(new C0842a(new g.t(), true));
        arrayList.add(new C0842a(new g.m(), true));
        arrayList.add(new C0842a(new g.s(), false));
        arrayList.add(new C0842a(new g.r(), false));
        arrayList.add(new C0842a(new g.p(), false));
        arrayList.add(new C0842a(new g.o(), false));
        f76709j = Collections.unmodifiableList(arrayList);
    }

    public final void a() {
        int i11;
        int i12;
        if (this.f76717h) {
            int i13 = 0;
            i11 = 0;
            i12 = 0;
            boolean z11 = false;
            for (int i14 = 0; i14 < this.f76715f; i14++) {
                byte[] bArr = this.f76710a;
                if (i13 >= bArr.length) {
                    break;
                }
                byte b11 = this.f76714e[i14];
                if (b11 == 60) {
                    if (z11) {
                        i12++;
                    }
                    i11++;
                    z11 = true;
                }
                if (!z11) {
                    bArr[i13] = b11;
                    i13++;
                }
                if (b11 == 62) {
                    z11 = false;
                }
            }
            this.f76711b = i13;
        } else {
            i11 = 0;
            i12 = 0;
        }
        if (i11 < 5 || i11 / 5 < i12 || (this.f76711b < 100 && this.f76715f > 600)) {
            int i15 = this.f76715f;
            if (i15 > 8000) {
                i15 = 8000;
            }
            int i16 = 0;
            while (i16 < i15) {
                this.f76710a[i16] = this.f76714e[i16];
                i16++;
            }
            this.f76711b = i16;
        }
        Arrays.fill(this.f76712c, (short) 0);
        for (int i17 = 0; i17 < this.f76711b; i17++) {
            int i18 = this.f76710a[i17] & 255;
            short[] sArr = this.f76712c;
            sArr[i18] = (short) (sArr[i18] + 1);
        }
        this.f76713d = false;
        for (int i19 = 128; i19 <= 159; i19++) {
            if (this.f76712c[i19] != 0) {
                this.f76713d = true;
                return;
            }
        }
    }

    public b b() {
        b[] bVarArrC = c();
        if (bVarArrC == null || bVarArrC.length == 0) {
            return null;
        }
        return bVarArrC[0];
    }

    public b[] c() {
        b bVarC;
        ArrayList arrayList = new ArrayList();
        a();
        int i11 = 0;
        while (true) {
            List<C0842a> list = f76709j;
            if (i11 >= list.size()) {
                Collections.sort(arrayList);
                Collections.reverse(arrayList);
                return (b[]) arrayList.toArray(new b[arrayList.size()]);
            }
            C0842a c0842a = list.get(i11);
            boolean[] zArr = this.f76718i;
            if ((zArr != null ? zArr[i11] : c0842a.f76720b) && (bVarC = c0842a.f76719a.c(this)) != null) {
                arrayList.add(bVarC);
            }
            i11++;
        }
    }

    public a d(byte[] bArr) {
        this.f76714e = bArr;
        this.f76715f = bArr.length;
        return this;
    }
}
