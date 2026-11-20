package k7;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f68435a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f68436b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f68437c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public e[] f68438d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f68439e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final e f68440f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final e f68441g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final e f68442h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f68443i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f68444j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f68445k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f68446l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f68447m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int[] f68448n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public d f68449o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public d f68450p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public i f68451q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public i f68452r;

    public c() {
        this(0);
    }

    public c(int i11) {
        this.f68436b = 1;
        this.f68437c = new a();
        e[] eVarArr = new e[256];
        this.f68438d = eVarArr;
        this.f68439e = (int) (((double) eVarArr.length) * 0.75d);
        this.f68440f = new e();
        this.f68441g = new e();
        this.f68442h = new e();
    }

    public final e a(e eVar) {
        e[] eVarArr = this.f68438d;
        e eVar2 = eVarArr[eVar.f68464h % eVarArr.length];
        while (eVar2 != null && (eVar2.f68458b != eVar.f68458b || !eVar.a(eVar2))) {
            eVar2 = eVar2.f68465i;
        }
        return eVar2;
    }

    public e b(String str) {
        this.f68441g.c(7, str, null, null);
        e eVarA = a(this.f68441g);
        if (eVarA != null) {
            return eVarA;
        }
        this.f68437c.c(7, h(str));
        int i11 = this.f68436b;
        this.f68436b = i11 + 1;
        e eVar = new e(i11, this.f68441g);
        i(eVar);
        return eVar;
    }

    public e c(Object obj) {
        if (!(obj instanceof Integer)) {
            if (obj instanceof String) {
                return g((String) obj);
            }
            if (obj instanceof j) {
                j jVar = (j) obj;
                return b(jVar.f68494a == 10 ? jVar.f() : jVar.d());
            }
            throw new IllegalArgumentException("value " + obj);
        }
        int iIntValue = ((Integer) obj).intValue();
        this.f68440f.b(iIntValue);
        e eVarA = a(this.f68440f);
        if (eVarA != null) {
            return eVarA;
        }
        this.f68437c.d(3).f(iIntValue);
        int i11 = this.f68436b;
        this.f68436b = i11 + 1;
        e eVar = new e(i11, this.f68440f);
        i(eVar);
        return eVar;
    }

    public e d(String str, String str2, String str3) {
        this.f68442h.c(9, str, str2, str3);
        e eVarA = a(this.f68442h);
        if (eVarA != null) {
            return eVarA;
        }
        int i11 = b(str).f68457a;
        this.f68437c.c(9, i11).g(f(str2, str3).f68457a);
        int i12 = this.f68436b;
        this.f68436b = i12 + 1;
        e eVar = new e(i12, this.f68442h);
        i(eVar);
        return eVar;
    }

    public e e(String str, String str2, String str3, boolean z11) {
        int i11 = z11 ? 11 : 10;
        this.f68442h.c(i11, str, str2, str3);
        e eVarA = a(this.f68442h);
        if (eVarA != null) {
            return eVarA;
        }
        this.f68437c.c(i11, b(str).f68457a).g(f(str2, str3).f68457a);
        int i12 = this.f68436b;
        this.f68436b = i12 + 1;
        e eVar = new e(i12, this.f68442h);
        i(eVar);
        return eVar;
    }

    public e f(String str, String str2) {
        this.f68441g.c(12, str, str2, null);
        e eVarA = a(this.f68441g);
        if (eVarA != null) {
            return eVarA;
        }
        int iH = h(str);
        this.f68437c.c(12, iH).g(h(str2));
        int i11 = this.f68436b;
        this.f68436b = i11 + 1;
        e eVar = new e(i11, this.f68441g);
        i(eVar);
        return eVar;
    }

    public final e g(String str) {
        this.f68441g.c(8, str, null, null);
        e eVarA = a(this.f68441g);
        if (eVarA != null) {
            return eVarA;
        }
        this.f68437c.c(8, h(str));
        int i11 = this.f68436b;
        this.f68436b = i11 + 1;
        e eVar = new e(i11, this.f68441g);
        i(eVar);
        return eVar;
    }

    public int h(String str) {
        this.f68440f.c(1, str, null, null);
        e eVarA = a(this.f68440f);
        if (eVarA == null) {
            this.f68437c.d(1).h(str);
            int i11 = this.f68436b;
            this.f68436b = i11 + 1;
            eVarA = new e(i11, this.f68440f);
            i(eVarA);
        }
        return eVarA.f68457a;
    }

    public final void i(e eVar) {
        if (this.f68436b > this.f68439e) {
            int length = this.f68438d.length;
            int i11 = (length * 2) + 1;
            e[] eVarArr = new e[i11];
            for (int i12 = length - 1; i12 >= 0; i12--) {
                e eVar2 = this.f68438d[i12];
                while (eVar2 != null) {
                    int i13 = eVar2.f68464h % i11;
                    e eVar3 = eVar2.f68465i;
                    eVar2.f68465i = eVarArr[i13];
                    eVarArr[i13] = eVar2;
                    eVar2 = eVar3;
                }
            }
            this.f68438d = eVarArr;
            this.f68439e = (int) (((double) i11) * 0.75d);
        }
        int i14 = eVar.f68464h;
        e[] eVarArr2 = this.f68438d;
        int length2 = i14 % eVarArr2.length;
        eVar.f68465i = eVarArr2[length2];
        eVarArr2[length2] = eVar;
    }

    public byte[] j() {
        int iM = (this.f68447m * 2) + 24;
        int i11 = 0;
        for (d dVar = this.f68449o; dVar != null; dVar = dVar.f68453a) {
            i11++;
            iM += dVar.a();
        }
        int i12 = 0;
        for (i iVar = this.f68451q; iVar != null; iVar = iVar.f68475a) {
            i12++;
            iM += iVar.m();
        }
        a aVar = new a(iM + this.f68437c.f68428b);
        aVar.f(-889275714).f(this.f68435a);
        a aVarG = aVar.g(this.f68436b);
        a aVar2 = this.f68437c;
        aVarG.e(aVar2.f68427a, 0, aVar2.f68428b);
        aVar.g(this.f68443i & (-393217)).g(this.f68444j).g(this.f68446l);
        aVar.g(this.f68447m);
        for (int i13 = 0; i13 < this.f68447m; i13++) {
            aVar.g(this.f68448n[i13]);
        }
        aVar.g(i11);
        for (d dVar2 = this.f68449o; dVar2 != null; dVar2 = dVar2.f68453a) {
            dVar2.b(aVar);
        }
        aVar.g(i12);
        for (i iVar2 = this.f68451q; iVar2 != null; iVar2 = iVar2.f68475a) {
            iVar2.n(aVar);
        }
        aVar.g(0);
        return aVar.f68427a;
    }

    public void k(int i11, int i12, String str, String str2, String[] strArr) {
        this.f68435a = i11;
        this.f68443i = i12;
        this.f68444j = b(str).f68457a;
        this.f68445k = str;
        this.f68446l = str2 == null ? 0 : b(str2).f68457a;
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        int length = strArr.length;
        this.f68447m = length;
        this.f68448n = new int[length];
        for (int i13 = 0; i13 < this.f68447m; i13++) {
            this.f68448n[i13] = b(strArr[i13]).f68457a;
        }
    }
}
