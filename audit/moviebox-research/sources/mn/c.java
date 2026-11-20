package mn;

import android.view.View;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;
import kn.g;
import nn.e;
import nn.h;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class c implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f71147a;

    public c(a aVar) {
        this.f71147a = aVar;
    }

    @Override // mn.a
    public JSONObject a(View view) {
        JSONObject jSONObjectC = nn.c.c(0, 0, 0, 0);
        nn.c.e(jSONObjectC, e.a());
        return jSONObjectC;
    }

    @Override // mn.a
    public void a(View view, JSONObject jSONObject, a.InterfaceC0761a interfaceC0761a, boolean z11, boolean z12) {
        Iterator<View> it = b().iterator();
        while (it.hasNext()) {
            interfaceC0761a.a(it.next(), this.f71147a, jSONObject, z12);
        }
    }

    @NonNull
    public ArrayList<View> b() {
        View rootView;
        ArrayList<View> arrayList = new ArrayList<>();
        com.iab.omid.library.mmadbridge.internal.c cVarE = com.iab.omid.library.mmadbridge.internal.c.e();
        if (cVarE != null) {
            Collection<g> collectionA = cVarE.a();
            IdentityHashMap identityHashMap = new IdentityHashMap((collectionA.size() * 2) + 3);
            Iterator<g> it = collectionA.iterator();
            while (it.hasNext()) {
                View viewO = it.next().o();
                if (viewO != null && h.e(viewO) && (rootView = viewO.getRootView()) != null && !identityHashMap.containsKey(rootView)) {
                    identityHashMap.put(rootView, rootView);
                    float fC = h.c(rootView);
                    int size = arrayList.size();
                    while (size > 0 && h.c(arrayList.get(size - 1)) > fC) {
                        size--;
                    }
                    arrayList.add(size, rootView);
                }
            }
        }
        return arrayList;
    }
}
