package tm;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class b extends f {
    public b(hm.a aVar) {
        super(aVar);
    }

    @Override // tm.i
    public void h(StringBuilder sb2, int i11) {
        if (i11 < 10000) {
            sb2.append("(3202)");
        } else {
            sb2.append("(3203)");
        }
    }

    @Override // tm.i
    public int i(int i11) {
        return i11 < 10000 ? i11 : i11 - 10000;
    }
}
