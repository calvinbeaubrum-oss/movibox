package tm;

import com.google.zxing.NotFoundException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public abstract class f extends i {
    public f(hm.a aVar) {
        super(aVar);
    }

    @Override // tm.j
    public String d() throws NotFoundException {
        if (c().m() != 60) {
            throw NotFoundException.getNotFoundInstance();
        }
        StringBuilder sb2 = new StringBuilder();
        f(sb2, 5);
        j(sb2, 45, 15);
        return sb2.toString();
    }
}
