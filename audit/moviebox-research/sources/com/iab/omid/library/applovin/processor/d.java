package com.iab.omid.library.applovin.processor;

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
    private final int[] f42148a = new int[2];

    private void a(ViewGroup viewGroup, JSONObject jSONObject, a.InterfaceC0463a interfaceC0463a, boolean z11) {
        for (int i11 = 0; i11 < viewGroup.getChildCount(); i11++) {
            interfaceC0463a.a(viewGroup.getChildAt(i11), this, jSONObject, z11);
        }
    }

    @TargetApi(21)
    private void b(ViewGroup viewGroup, JSONObject jSONObject, a.InterfaceC0463a interfaceC0463a, boolean z11) {
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
                interfaceC0463a.a((View) it2.next(), this, jSONObject, z11);
            }
        }
    }

    @Override // com.iab.omid.library.applovin.processor.a
    public JSONObject a(View view) {
        if (view == null) {
            return com.iab.omid.library.applovin.utils.c.a(0, 0, 0, 0);
        }
        int width = view.getWidth();
        int height = view.getHeight();
        view.getLocationOnScreen(this.f42148a);
        int[] iArr = this.f42148a;
        return com.iab.omid.library.applovin.utils.c.a(iArr[0], iArr[1], width, height);
    }

    @Override // com.iab.omid.library.applovin.processor.a
    public void a(View view, JSONObject jSONObject, a.InterfaceC0463a interfaceC0463a, boolean z11, boolean z12) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (z11) {
                b(viewGroup, jSONObject, interfaceC0463a, z12);
            } else {
                a(viewGroup, jSONObject, interfaceC0463a, z12);
            }
        }
    }
}
