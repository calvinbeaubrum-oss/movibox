package androidx.work;

import androidx.annotation.NonNull;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class OverwritingInputMerger extends g {
    @Override // androidx.work.g
    @NonNull
    public d b(@NonNull List<d> list) {
        d.a aVar = new d.a();
        HashMap map = new HashMap();
        Iterator<d> it = list.iterator();
        while (it.hasNext()) {
            map.putAll(it.next().h());
        }
        aVar.d(map);
        return aVar.a();
    }
}
