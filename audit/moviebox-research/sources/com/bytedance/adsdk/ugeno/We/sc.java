package com.bytedance.adsdk.ugeno.We;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class sc implements We {
    @Override // com.bytedance.adsdk.ugeno.We.We
    public List<zY> sc() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new zY("slide") { // from class: com.bytedance.adsdk.ugeno.We.sc.1
            @Override // com.bytedance.adsdk.ugeno.We.zY
            public com.bytedance.adsdk.ugeno.We.zY.sc sc(Context context) {
                return new com.bytedance.adsdk.ugeno.We.zY.zY(context);
            }
        });
        arrayList.add(new zY("tap") { // from class: com.bytedance.adsdk.ugeno.We.sc.2
            @Override // com.bytedance.adsdk.ugeno.We.zY
            public com.bytedance.adsdk.ugeno.We.zY.sc sc(Context context) {
                return new com.bytedance.adsdk.ugeno.We.zY.We(context);
            }
        });
        arrayList.add(new zY("timer") { // from class: com.bytedance.adsdk.ugeno.We.sc.3
            @Override // com.bytedance.adsdk.ugeno.We.zY
            public com.bytedance.adsdk.ugeno.We.zY.sc sc(Context context) {
                return new com.bytedance.adsdk.ugeno.We.zY.ExN(context);
            }
        });
        return arrayList;
    }
}
