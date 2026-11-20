package e20;

import android.annotation.TargetApi;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@TargetApi(11)
public class a {
    public static i20.a a(List<i20.a> list, int i11) {
        i20.a aVar;
        if (i11 >= 0 && i11 <= list.size() - 1) {
            return list.get(i11);
        }
        i20.a aVar2 = new i20.a();
        if (i11 < 0) {
            aVar = list.get(0);
        } else {
            i11 = (i11 - list.size()) + 1;
            aVar = list.get(list.size() - 1);
        }
        aVar2.f66885a = aVar.f66885a + (aVar.b() * i11);
        aVar2.f66886b = aVar.f66886b;
        aVar2.f66887c = aVar.f66887c + (aVar.b() * i11);
        aVar2.f66888d = aVar.f66888d;
        aVar2.f66889e = aVar.f66889e + (aVar.b() * i11);
        aVar2.f66890f = aVar.f66890f;
        aVar2.f66891g = aVar.f66891g + (i11 * aVar.b());
        aVar2.f66892h = aVar.f66892h;
        return aVar2;
    }
}
