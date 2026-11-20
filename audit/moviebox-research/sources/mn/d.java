package mn;

import android.annotation.TargetApi;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class d implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f71148a = new int[2];

    @Override // mn.a
    public JSONObject a(View view) {
        if (view == null) {
            return nn.c.c(0, 0, 0, 0);
        }
        int width = view.getWidth();
        int height = view.getHeight();
        view.getLocationOnScreen(this.f71148a);
        int[] iArr = this.f71148a;
        return nn.c.c(iArr[0], iArr[1], width, height);
    }

    @Override // mn.a
    public void a(View view, JSONObject jSONObject, a.InterfaceC0761a interfaceC0761a, boolean z11, boolean z12) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (z11) {
                c(viewGroup, jSONObject, interfaceC0761a, z12);
            } else {
                b(viewGroup, jSONObject, interfaceC0761a, z12);
            }
        }
    }

    public final void b(ViewGroup viewGroup, JSONObject jSONObject, a.InterfaceC0761a interfaceC0761a, boolean z11) {
        for (int i11 = 0; i11 < viewGroup.getChildCount(); i11++) {
            interfaceC0761a.a(viewGroup.getChildAt(i11), this, jSONObject, z11);
        }
    }

    @TargetApi(21)
    public final void c(ViewGroup viewGroup, JSONObject jSONObject, a.InterfaceC0761a interfaceC0761a, boolean z11) {
        HashMap map = new HashMap();
        for (int i11 = 0; i11 < viewGroup.getChildCount(); i11++) {
            View childAt = viewGroup.getChildAt(i11);
            ArrayList arrayList = (ArrayList) map.get(Float.valueOf(childAt.getZ()));
            if (arrayList == null) {
                arrayList = new ArrayList();
                map.put(Float.valueOf(childAt.getZ()), arrayList);
            }
            arrayList.add(childAt);
        }
        ArrayList arrayList2 = new ArrayList(map.keySet());
        Collections.sort(arrayList2);
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            Iterator it2 = ((ArrayList) map.get((Float) it.next())).iterator();
            while (it2.hasNext()) {
                interfaceC0761a.a((View) it2.next(), this, jSONObject, z11);
            }
        }
    }
}
