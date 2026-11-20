package com.bytedance.adsdk.ugeno.We.pFF;

import android.text.TextUtils;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class We extends sc {
    public We(com.bytedance.adsdk.ugeno.pFF.zY zYVar, String str, com.bytedance.adsdk.ugeno.We.pFF.sc scVar) {
        super(zYVar, str, scVar);
    }

    private void sc(com.bytedance.adsdk.ugeno.pFF.zY zYVar) {
        if (zYVar == null) {
            return;
        }
        for (String str : this.TRI.keySet()) {
            if (!TextUtils.isEmpty(str) && !TextUtils.equals(str, "id")) {
                zYVar.sc(str, this.TRI.get(str));
            }
        }
        zYVar.cvk();
        zYVar.pFF();
    }

    @Override // com.bytedance.adsdk.ugeno.We.pFF.sc
    public void sc() {
        Map<String, String> map = this.TRI;
        if (map == null || map.size() <= 0) {
            return;
        }
        String str = this.TRI.get("id");
        if (TextUtils.isEmpty(str)) {
            sc(this.zY);
            return;
        }
        com.bytedance.adsdk.ugeno.pFF.zY zYVar = this.zY;
        com.bytedance.adsdk.ugeno.pFF.zY zYVarPFF = zYVar.pFF(zYVar);
        if (zYVarPFF == null) {
            return;
        }
        sc(zYVarPFF.zY(str));
    }
}
