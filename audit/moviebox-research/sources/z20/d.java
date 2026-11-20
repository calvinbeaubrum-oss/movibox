package z20;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f81734a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int[] f81735b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int[] f81736c;

    public static void a(d dVar, org.brotli.dec.a aVar) {
        int length = dVar.f81736c.length;
        int i11 = 0;
        for (int i12 = 0; i12 < length; i12++) {
            dVar.f81736c[i12] = i11;
            org.brotli.dec.c.n(dVar.f81734a, dVar.f81735b, i11, aVar);
            i11 += 1080;
        }
    }

    public static void b(d dVar, int i11, int i12) {
        dVar.f81734a = i11;
        dVar.f81735b = new int[i12 * 1080];
        dVar.f81736c = new int[i12];
    }
}
