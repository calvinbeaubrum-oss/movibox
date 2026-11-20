package s0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f75903c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f75904d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f75905e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f75906f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f75907g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a[] f75908h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f75909a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f75910b;

    static {
        a aVar = new a(0, false);
        f75903c = aVar;
        a aVar2 = new a(1, true);
        a aVar3 = new a(2, false);
        f75904d = aVar3;
        a aVar4 = new a(3, true);
        a aVar5 = new a(4, false);
        f75905e = aVar5;
        a aVar6 = new a(5, true);
        a aVar7 = new a(6, false);
        f75906f = aVar7;
        a aVar8 = new a(7, true);
        a aVar9 = new a(8, false);
        a aVar10 = new a(9, true);
        f75907g = aVar10;
        f75908h = new a[]{aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, aVar8, aVar9, aVar10, new a(10, false), new a(10, true)};
    }

    public a(int i11, boolean z11) {
        this.f75909a = i11;
        this.f75910b = z11;
    }

    public a a() {
        if (!this.f75910b) {
            return this;
        }
        a aVar = f75908h[this.f75909a - 1];
        return !aVar.f75910b ? aVar : f75903c;
    }

    public boolean b(a aVar) {
        int i11 = this.f75909a;
        int i12 = aVar.f75909a;
        return i11 < i12 || ((!this.f75910b || f75907g == this) && i11 == i12);
    }
}
