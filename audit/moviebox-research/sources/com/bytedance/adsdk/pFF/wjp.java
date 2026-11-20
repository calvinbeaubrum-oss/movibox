package com.bytedance.adsdk.pFF;

import android.util.Pair;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class wjp {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private boolean f26224sc = false;
    private final Set<Object> pFF = new sc();
    private final Map<String, com.bytedance.adsdk.pFF.TRI.We> zY = new HashMap();
    private final Comparator<Pair<String, Float>> We = new Comparator<Pair<String, Float>>() { // from class: com.bytedance.adsdk.pFF.wjp.1
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: sc, reason: merged with bridge method [inline-methods] */
        public int compare(Pair<String, Float> pair, Pair<String, Float> pair2) {
            float fFloatValue = ((Float) pair.second).floatValue();
            float fFloatValue2 = ((Float) pair2.second).floatValue();
            if (fFloatValue2 > fFloatValue) {
                return 1;
            }
            return fFloatValue > fFloatValue2 ? -1 : 0;
        }
    };

    public void sc(String str, float f11) {
        if (this.f26224sc) {
            com.bytedance.adsdk.pFF.TRI.We we2 = this.zY.get(str);
            if (we2 == null) {
                we2 = new com.bytedance.adsdk.pFF.TRI.We();
                this.zY.put(str, we2);
            }
            we2.sc(f11);
            if (str.equals("__container")) {
                Iterator<Object> it = this.pFF.iterator();
                while (it.hasNext()) {
                    it.next();
                }
            }
        }
    }

    public void sc(boolean z11) {
        this.f26224sc = z11;
    }
}
