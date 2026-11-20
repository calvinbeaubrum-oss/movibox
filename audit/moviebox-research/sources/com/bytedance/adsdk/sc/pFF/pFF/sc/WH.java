package com.bytedance.adsdk.sc.pFF.pFF.sc;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class WH implements com.bytedance.adsdk.sc.pFF.pFF.sc {
    private String pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private com.bytedance.adsdk.sc.pFF.pFF.sc[] f26302sc;
    private com.bytedance.adsdk.sc.pFF.sc.sc zY;

    public WH(String str) {
        this.pFF = str;
    }

    @Override // com.bytedance.adsdk.sc.pFF.pFF.sc
    public String pFF() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.pFF);
        sb2.append("(");
        com.bytedance.adsdk.sc.pFF.pFF.sc[] scVarArr = this.f26302sc;
        if (scVarArr != null && scVarArr.length > 0) {
            int i11 = 0;
            while (true) {
                com.bytedance.adsdk.sc.pFF.pFF.sc[] scVarArr2 = this.f26302sc;
                if (i11 >= scVarArr2.length) {
                    break;
                }
                sb2.append(scVarArr2[i11].pFF());
                sb2.append(",");
                i11++;
            }
        }
        sb2.append(")");
        return sb2.toString();
    }

    @Override // com.bytedance.adsdk.sc.pFF.pFF.sc
    public com.bytedance.adsdk.sc.pFF.We.ExN sc() {
        return com.bytedance.adsdk.sc.pFF.We.pFF.METHOD;
    }

    @Override // com.bytedance.adsdk.sc.pFF.pFF.sc
    public Object sc(Map<String, JSONObject> map) {
        com.bytedance.adsdk.sc.pFF.sc.sc scVar = new com.bytedance.adsdk.sc.pFF.sc.sc();
        this.zY = scVar;
        scVar.sc(this.pFF);
        Object[] objArr = new Object[this.f26302sc.length];
        int i11 = 0;
        while (true) {
            com.bytedance.adsdk.sc.pFF.pFF.sc[] scVarArr = this.f26302sc;
            if (i11 >= scVarArr.length) {
                this.zY.sc(objArr);
                return com.bytedance.adsdk.sc.qr.sc(this.pFF).sc(map.get("default_key"), objArr);
            }
            com.bytedance.adsdk.sc.pFF.pFF.sc scVar2 = scVarArr[i11];
            if (scVar2 != null) {
                objArr[i11] = scVar2.sc(map);
            }
            i11++;
        }
    }

    public void sc(com.bytedance.adsdk.sc.pFF.pFF.sc[] scVarArr) {
        this.f26302sc = scVarArr;
    }
}
