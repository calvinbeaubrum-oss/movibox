package xn;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class j implements com.google.zxing.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.google.zxing.i f80614a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<com.google.zxing.k> f80615b = new ArrayList();

    public j(com.google.zxing.i iVar) {
        this.f80614a = iVar;
    }

    @Override // com.google.zxing.l
    public void a(com.google.zxing.k kVar) {
        this.f80615b.add(kVar);
    }

    public com.google.zxing.j b(com.google.zxing.b bVar) {
        this.f80615b.clear();
        try {
            com.google.zxing.i iVar = this.f80614a;
            return iVar instanceof com.google.zxing.f ? ((com.google.zxing.f) iVar).d(bVar) : iVar.b(bVar);
        } catch (Exception unused) {
            return null;
        } finally {
            this.f80614a.reset();
        }
    }

    public com.google.zxing.j c(com.google.zxing.e eVar) {
        return b(e(eVar));
    }

    public List<com.google.zxing.k> d() {
        return new ArrayList(this.f80615b);
    }

    public com.google.zxing.b e(com.google.zxing.e eVar) {
        return new com.google.zxing.b(new hm.l(eVar));
    }
}
