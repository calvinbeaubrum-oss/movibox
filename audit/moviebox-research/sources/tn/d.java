package tn;

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
    public final int[] f77257a = new int[2];

    @Override // tn.a
    public JSONObject a(View view) {
        if (view == null) {
            return un.b.b(0, 0, 0, 0);
        }
        int width = view.getWidth();
        int height = view.getHeight();
        view.getLocationOnScreen(this.f77257a);
        int[] iArr = this.f77257a;
        return un.b.b(iArr[0], iArr[1], width, height);
    }

    @Override // tn.a
    public void a(View view, JSONObject jSONObject, a.InterfaceC0855a interfaceC0855a, boolean z11) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (z11) {
                c(viewGroup, jSONObject, interfaceC0855a);
            } else {
                b(viewGroup, jSONObject, interfaceC0855a);
            }
        }
    }

    public final void b(ViewGroup viewGroup, JSONObject jSONObject, a.InterfaceC0855a interfaceC0855a) {
        for (int i11 = 0; i11 < viewGroup.getChildCount(); i11++) {
            interfaceC0855a.a(viewGroup.getChildAt(i11), this, jSONObject);
        }
    }

    @TargetApi(21)
    public final void c(ViewGroup viewGroup, JSONObject jSONObject, a.InterfaceC0855a interfaceC0855a) {
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
                interfaceC0855a.a((View) it2.next(), this, jSONObject);
            }
        }
    }
}
