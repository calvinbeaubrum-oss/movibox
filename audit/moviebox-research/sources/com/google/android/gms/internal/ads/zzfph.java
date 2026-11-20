package com.google.android.gms.internal.ads;

import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfph implements zzfpe {
    private final int[] zza = new int[2];

    @Override // com.google.android.gms.internal.ads.zzfpe
    public final JSONObject zza(View view) {
        if (view == null) {
            return zzfpo.zza(0, 0, 0, 0);
        }
        int[] iArr = this.zza;
        int width = view.getWidth();
        int height = view.getHeight();
        view.getLocationOnScreen(iArr);
        int[] iArr2 = this.zza;
        return zzfpo.zza(iArr2[0], iArr2[1], width, height);
    }

    @Override // com.google.android.gms.internal.ads.zzfpe
    public final void zzb(View view, JSONObject jSONObject, zzfpd zzfpdVar, boolean z11, boolean z12) {
        int i11;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (!z11) {
                for (int i12 = 0; i12 < viewGroup.getChildCount(); i12++) {
                    zzfpdVar.zza(viewGroup.getChildAt(i12), this, jSONObject, z12);
                }
                return;
            }
            HashMap map = new HashMap();
            for (int i13 = 0; i13 < viewGroup.getChildCount(); i13++) {
                View childAt = viewGroup.getChildAt(i13);
                ArrayList arrayList = (ArrayList) map.get(Float.valueOf(childAt.getZ()));
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    map.put(Float.valueOf(childAt.getZ()), arrayList);
                }
                arrayList.add(childAt);
            }
            ArrayList arrayList2 = new ArrayList(map.keySet());
            Collections.sort(arrayList2);
            int size = arrayList2.size();
            int i14 = 0;
            while (i14 < size) {
                ArrayList arrayList3 = (ArrayList) map.get((Float) arrayList2.get(i14));
                int size2 = arrayList3.size();
                int i15 = 0;
                while (true) {
                    i11 = i14 + 1;
                    if (i15 < size2) {
                        zzfpdVar.zza((View) arrayList3.get(i15), this, jSONObject, z12);
                        i15++;
                    }
                }
                i14 = i11;
            }
        }
    }
}
