package com.bytedance.adsdk.sc;

import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class sc implements com.bytedance.adsdk.ugeno.zY.sc {

    /* JADX INFO: renamed from: com.bytedance.adsdk.sc.sc$sc, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class C0224sc implements com.bytedance.adsdk.ugeno.zY.sc.InterfaceC0239sc {
        private String pFF;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        private com.bytedance.adsdk.sc.pFF.sc f26311sc;

        private C0224sc(String str) {
            this.pFF = str;
            this.f26311sc = com.bytedance.adsdk.sc.pFF.sc.sc(str);
        }

        public static C0224sc sc(String str) {
            return new C0224sc(str);
        }

        @Override // com.bytedance.adsdk.ugeno.zY.sc.InterfaceC0239sc
        public Object sc(JSONObject jSONObject) {
            com.bytedance.adsdk.sc.pFF.sc scVar = this.f26311sc;
            if (scVar == null) {
                return this.pFF;
            }
            Object objSc = scVar.sc(jSONObject);
            if (objSc instanceof String) {
                return objSc;
            }
            return objSc instanceof com.bytedance.adsdk.sc.pFF.sc.sc ? String.valueOf(qr.sc((com.bytedance.adsdk.sc.pFF.sc.sc) objSc)) : String.valueOf(objSc);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.zY.sc
    public com.bytedance.adsdk.ugeno.zY.sc.InterfaceC0239sc sc(String str) {
        return C0224sc.sc(str);
    }
}
