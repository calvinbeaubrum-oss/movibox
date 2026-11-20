package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.ArrayList;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfpg implements zzfpe {
    private final zzfpe zza;

    public zzfpg(zzfpe zzfpeVar) {
        this.zza = zzfpeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfpe
    public final JSONObject zza(View view) {
        JSONObject jSONObjectZza = zzfpo.zza(0, 0, 0, 0);
        int iZzb = zzfpr.zzb();
        int i11 = iZzb - 1;
        if (iZzb == 0) {
            throw null;
        }
        try {
            jSONObjectZza.put("noOutputDevice", i11 == 0);
        } catch (JSONException e11) {
            zzfpp.zza("Error with setting output device status", e11);
        }
        return jSONObjectZza;
    }

    @Override // com.google.android.gms.internal.ads.zzfpe
    public final void zzb(View view, JSONObject jSONObject, zzfpd zzfpdVar, boolean z11, boolean z12) {
        ArrayList arrayList = new ArrayList();
        zzfov zzfovVarZza = zzfov.zza();
        if (zzfovVarZza != null) {
            Collection collectionZzb = zzfovVarZza.zzb();
            int size = collectionZzb.size();
            IdentityHashMap identityHashMap = new IdentityHashMap(size + size + 3);
            Iterator it = collectionZzb.iterator();
            while (it.hasNext()) {
                View viewZzf = ((zzfoh) it.next()).zzf();
                if (viewZzf != null && viewZzf.isAttachedToWindow() && viewZzf.isShown()) {
                    View view2 = viewZzf;
                    while (true) {
                        if (view2 == null) {
                            View rootView = viewZzf.getRootView();
                            if (rootView != null && !identityHashMap.containsKey(rootView)) {
                                identityHashMap.put(rootView, rootView);
                                float z13 = rootView.getZ();
                                int size2 = arrayList.size();
                                while (size2 > 0) {
                                    int i11 = size2 - 1;
                                    if (((View) arrayList.get(i11)).getZ() <= z13) {
                                        break;
                                    } else {
                                        size2 = i11;
                                    }
                                }
                                arrayList.add(size2, rootView);
                                break;
                            }
                            break;
                        }
                        if (view2.getAlpha() == 0.0f) {
                            break;
                        }
                        Object parent = view2.getParent();
                        view2 = parent instanceof View ? (View) parent : null;
                    }
                }
            }
        }
        int size3 = arrayList.size();
        for (int i12 = 0; i12 < size3; i12++) {
            zzfpdVar.zza((View) arrayList.get(i12), this.zza, jSONObject, z12);
        }
    }
}
