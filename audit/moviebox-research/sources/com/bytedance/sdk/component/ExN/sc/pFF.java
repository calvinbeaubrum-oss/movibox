package com.bytedance.sdk.component.ExN.sc;

import com.bytedance.sdk.component.ExN.Ol;
import com.bytedance.sdk.component.ExN.Tf;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class pFF {
    public static Tf sc() {
        return new Tf() { // from class: com.bytedance.sdk.component.ExN.sc.pFF.1

            /* JADX INFO: renamed from: sc, reason: collision with root package name */
            private WeakHashMap<String, String> f26498sc = new WeakHashMap<>();

            private String sc(String str) {
                String str2 = this.f26498sc.get(str);
                if (str2 != null) {
                    return str2;
                }
                String strSc = com.bytedance.sdk.component.ExN.zY.zY.zY.sc(str);
                this.f26498sc.put(str, strSc);
                return strSc;
            }

            @Override // com.bytedance.sdk.component.ExN.Tf
            public String pFF(Ol ol2) {
                return sc(ol2.sc());
            }

            @Override // com.bytedance.sdk.component.ExN.Tf
            public String sc(Ol ol2) {
                return sc(ol2.sc() + "#width=" + ol2.pFF() + "#height=" + ol2.zY() + "#scaletype=" + ol2.We() + "#bitmapConfig=" + ol2.TRI());
            }
        };
    }
}
