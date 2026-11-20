package vm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Integer, Integer> f79003a = new HashMap();

    public int[] a() {
        ArrayList arrayList = new ArrayList();
        int iIntValue = -1;
        for (Map.Entry<Integer, Integer> entry : this.f79003a.entrySet()) {
            if (entry.getValue().intValue() > iIntValue) {
                iIntValue = entry.getValue().intValue();
                arrayList.clear();
                arrayList.add(entry.getKey());
            } else if (entry.getValue().intValue() == iIntValue) {
                arrayList.add(entry.getKey());
            }
        }
        return um.a.b(arrayList);
    }

    public void b(int i11) {
        Integer num = this.f79003a.get(Integer.valueOf(i11));
        if (num == null) {
            num = 0;
        }
        this.f79003a.put(Integer.valueOf(i11), Integer.valueOf(num.intValue() + 1));
    }
}
