package i30;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f66915a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f66916b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c f66917c;

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f66918a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public c[] f66919b = new c[6];

        public final void a(c cVar) {
            int i11 = this.f66918a;
            c[] cVarArr = this.f66919b;
            if (i11 >= cVarArr.length) {
                c[] cVarArr2 = new c[cVarArr.length + 6];
                System.arraycopy(cVarArr, 0, cVarArr2, 0, i11);
                this.f66919b = cVarArr2;
            }
            c[] cVarArr3 = this.f66919b;
            int i12 = this.f66918a;
            this.f66918a = i12 + 1;
            cVarArr3[i12] = cVar;
        }

        public void b(c cVar) {
            while (cVar != null) {
                if (!c(cVar)) {
                    a(cVar);
                }
                cVar = cVar.f66917c;
            }
        }

        public final boolean c(c cVar) {
            for (int i11 = 0; i11 < this.f66918a; i11++) {
                if (this.f66919b[i11].f66915a.equals(cVar.f66915a)) {
                    return true;
                }
            }
            return false;
        }

        public c[] d() {
            int i11 = this.f66918a;
            c[] cVarArr = new c[i11];
            System.arraycopy(this.f66919b, 0, cVarArr, 0, i11);
            return cVarArr;
        }
    }

    public c(String str) {
        this.f66915a = str;
    }

    public final int a(x xVar) {
        return b(xVar, null, 0, -1, -1);
    }

    public final int b(x xVar, byte[] bArr, int i11, int i12, int i13) {
        g gVar = xVar.f67090a;
        int i14 = 0;
        for (c cVar = this; cVar != null; cVar = cVar.f66917c) {
            xVar.D(cVar.f66915a);
            i14 += cVar.h(gVar, bArr, i11, i12, i13).f66921b + 6;
        }
        return i14;
    }

    public final int c() {
        int i11 = 0;
        for (c cVar = this; cVar != null; cVar = cVar.f66917c) {
            i11++;
        }
        return i11;
    }

    public boolean d() {
        return false;
    }

    public final void e(x xVar, d dVar) {
        f(xVar, null, 0, -1, -1, dVar);
    }

    public final void f(x xVar, byte[] bArr, int i11, int i12, int i13, d dVar) {
        g gVar = xVar.f67090a;
        for (c cVar = this; cVar != null; cVar = cVar.f66917c) {
            d dVarH = cVar.h(gVar, bArr, i11, i12, i13);
            dVar.k(xVar.D(cVar.f66915a)).i(dVarH.f66921b);
            dVar.h(dVarH.f66920a, 0, dVarH.f66921b);
        }
    }

    public c g(e eVar, int i11, int i12, char[] cArr, int i13, q[] qVarArr) {
        c cVar = new c(this.f66915a);
        byte[] bArr = new byte[i12];
        cVar.f66916b = bArr;
        System.arraycopy(eVar.f66922a, i11, bArr, 0, i12);
        return cVar;
    }

    public d h(g gVar, byte[] bArr, int i11, int i12, int i13) {
        return new d(this.f66916b);
    }
}
