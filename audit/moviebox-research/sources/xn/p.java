package xn;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class p extends j {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f80634c;

    public p(com.google.zxing.i iVar) {
        super(iVar);
        this.f80634c = true;
    }

    @Override // xn.j
    public com.google.zxing.b e(com.google.zxing.e eVar) {
        if (this.f80634c) {
            this.f80634c = false;
            return new com.google.zxing.b(new hm.l(eVar.e()));
        }
        this.f80634c = true;
        return new com.google.zxing.b(new hm.l(eVar));
    }
}
