package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzbmw implements zzbng {
    @Override // com.google.android.gms.internal.ads.zzbng
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcjk zzcjkVar = (zzcjk) obj;
        try {
            JSONArray jSONArray = new JSONArray((String) map.get("args"));
            SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(zzcjkVar.getContext()).edit();
            for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                editorEdit.remove(jSONArray.getString(i11));
            }
            editorEdit.apply();
        } catch (JSONException e11) {
            com.google.android.gms.ads.internal.zzt.zzo().zzw(e11, "GMSG clear local storage keys handler");
        }
    }
}
