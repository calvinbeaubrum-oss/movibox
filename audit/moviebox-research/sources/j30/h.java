package j30;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class h implements org.mvel2.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final org.mvel2.a[] f67843a;

    public h(org.mvel2.a... aVarArr) {
        this.f67843a = aVarArr;
    }

    @Override // org.mvel2.a
    public boolean a(Class cls) {
        for (org.mvel2.a aVar : this.f67843a) {
            if (aVar.a(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // org.mvel2.a
    public Object b(Object obj) {
        for (org.mvel2.a aVar : this.f67843a) {
            if (aVar.a(obj.getClass())) {
                return aVar.b(obj);
            }
        }
        return null;
    }
}
