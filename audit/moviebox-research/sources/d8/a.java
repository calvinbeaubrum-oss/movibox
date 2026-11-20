package d8;

import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class a<T> implements ue.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<T> f62945a;

    public a(List<T> list) {
        this.f62945a = list;
    }

    @Override // ue.a
    public int a() {
        return this.f62945a.size();
    }

    @Override // ue.a
    public Object getItem(int i11) {
        return (i11 < 0 || i11 >= this.f62945a.size()) ? "" : this.f62945a.get(i11);
    }
}
