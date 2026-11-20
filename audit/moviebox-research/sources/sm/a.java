package sm;

import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class a {
    public static hm.a a(List<b> list) {
        int size = list.size() * 2;
        int i11 = size - 1;
        if (list.get(list.size() - 1).c() == null) {
            i11 = size - 2;
        }
        hm.a aVar = new hm.a(i11 * 12);
        int i12 = 0;
        int iB = list.get(0).c().b();
        for (int i13 = 11; i13 >= 0; i13--) {
            if (((1 << i13) & iB) != 0) {
                aVar.r(i12);
            }
            i12++;
        }
        for (int i14 = 1; i14 < list.size(); i14++) {
            b bVar = list.get(i14);
            int iB2 = bVar.b().b();
            for (int i15 = 11; i15 >= 0; i15--) {
                if (((1 << i15) & iB2) != 0) {
                    aVar.r(i12);
                }
                i12++;
            }
            if (bVar.c() != null) {
                int iB3 = bVar.c().b();
                for (int i16 = 11; i16 >= 0; i16--) {
                    if (((1 << i16) & iB3) != 0) {
                        aVar.r(i12);
                    }
                    i12++;
                }
            }
        }
        return aVar;
    }
}
