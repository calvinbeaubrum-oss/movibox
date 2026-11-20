package tn;

import android.view.View;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;
import org.json.JSONObject;
import sn.f;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class c implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f77256a;

    public c(a aVar) {
        this.f77256a = aVar;
    }

    @Override // tn.a
    public JSONObject a(View view) {
        return un.b.b(0, 0, 0, 0);
    }

    @Override // tn.a
    public void a(View view, JSONObject jSONObject, a.InterfaceC0855a interfaceC0855a, boolean z11) {
        Iterator<View> it = b().iterator();
        while (it.hasNext()) {
            interfaceC0855a.a(it.next(), this.f77256a, jSONObject);
        }
    }

    @NonNull
    public ArrayList<View> b() {
        View rootView;
        ArrayList<View> arrayList = new ArrayList<>();
        com.iab.omid.library.vungle.b.a aVarA = com.iab.omid.library.vungle.b.a.a();
        if (aVarA != null) {
            Collection<f> collectionE = aVarA.e();
            IdentityHashMap identityHashMap = new IdentityHashMap((collectionE.size() * 2) + 3);
            Iterator<f> it = collectionE.iterator();
            while (it.hasNext()) {
                View viewG = it.next().g();
                if (viewG != null && un.f.c(viewG) && (rootView = viewG.getRootView()) != null && !identityHashMap.containsKey(rootView)) {
                    identityHashMap.put(rootView, rootView);
                    float fA = un.f.a(rootView);
                    int size = arrayList.size();
                    while (size > 0 && un.f.a(arrayList.get(size - 1)) > fA) {
                        size--;
                    }
                    arrayList.add(size, rootView);
                }
            }
        }
        return arrayList;
    }
}
