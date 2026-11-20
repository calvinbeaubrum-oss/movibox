package w20;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.apache.tools.ant.types.u;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class g extends a {
    public static u o(Iterator it) {
        return (u) it.next();
    }

    @Override // w20.a
    public Collection h() {
        return m(false);
    }

    public Collection m(boolean z11) {
        List listJ = j();
        if (listJ.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList(listJ.size() * 2);
        HashSet hashSet = new HashSet(listJ.size() * 2);
        Iterator it = listJ.iterator();
        while (it.hasNext()) {
            Iterator it2 = o(it).iterator();
            while (it2.hasNext()) {
                Object next = it2.next();
                if (z11) {
                    next = next.toString();
                }
                if (hashSet.add(next)) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    public String[] n() {
        if (isReference()) {
            return ((g) getCheckedRef()).n();
        }
        Collection collectionM = m(true);
        return (String[]) collectionM.toArray(new String[collectionM.size()]);
    }
}
