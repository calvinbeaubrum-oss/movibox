package com.bytedance.adsdk.sc.pFF;

import com.bytedance.adsdk.sc.pFF.zY.sc.ExN;
import com.bytedance.adsdk.sc.pFF.zY.sc.Ol;
import com.bytedance.adsdk.sc.pFF.zY.sc.Qj;
import com.bytedance.adsdk.sc.pFF.zY.sc.TRI;
import com.bytedance.adsdk.sc.pFF.zY.sc.WH;
import com.bytedance.adsdk.sc.pFF.zY.sc.We;
import com.bytedance.adsdk.sc.pFF.zY.sc.pFF;
import com.bytedance.adsdk.sc.pFF.zY.sc.qr;
import com.bytedance.adsdk.sc.pFF.zY.sc.zY;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class sc {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private static final com.bytedance.adsdk.sc.pFF.zY.sc f26308sc;
    private String ExN;
    private Deque<com.bytedance.adsdk.sc.pFF.pFF.sc> We = new LinkedList();
    private final com.bytedance.adsdk.sc.pFF.zY.sc pFF;
    private com.bytedance.adsdk.sc.pFF.pFF.sc zY;

    static {
        int i11 = 8;
        TRI[] triArr = {new WH(), new We(), new Ol(), new pFF(), new ExN(), new com.bytedance.adsdk.sc.pFF.zY.sc.sc(), new qr(), new zY(), new Qj()};
        final com.bytedance.adsdk.sc.pFF.zY.sc scVar = new com.bytedance.adsdk.sc.pFF.zY.sc() { // from class: com.bytedance.adsdk.sc.pFF.sc.1
            @Override // com.bytedance.adsdk.sc.pFF.zY.sc
            public int sc(String str, int i12, Deque<com.bytedance.adsdk.sc.pFF.pFF.sc> deque) {
                return i12;
            }
        };
        while (i11 >= 0) {
            final TRI tri = triArr[i11];
            i11--;
            scVar = new com.bytedance.adsdk.sc.pFF.zY.sc() { // from class: com.bytedance.adsdk.sc.pFF.sc.2
                @Override // com.bytedance.adsdk.sc.pFF.zY.sc
                public int sc(String str, int i12, Deque<com.bytedance.adsdk.sc.pFF.pFF.sc> deque) {
                    return tri.sc(str, i12, deque, scVar);
                }
            };
        }
        f26308sc = scVar;
    }

    private sc(String str, com.bytedance.adsdk.sc.pFF.zY.sc scVar) {
        this.pFF = scVar;
        this.ExN = str;
        try {
            sc();
        } catch (Exception e11) {
            throw new com.bytedance.adsdk.sc.sc.pFF(str, e11);
        }
    }

    public static sc sc(String str) {
        return new sc(str, f26308sc);
    }

    private void sc() {
        int length = this.ExN.length();
        int i11 = 0;
        while (i11 < length) {
            int iSc = this.pFF.sc(this.ExN, i11, this.We);
            if (iSc == i11) {
                throw new IllegalArgumentException("Unrecognized expression, unrecognized characters encountered during parsing:" + this.ExN.substring(0, i11));
            }
            i11 = iSc;
        }
        ArrayList arrayList = new ArrayList();
        while (true) {
            com.bytedance.adsdk.sc.pFF.pFF.sc scVarPollFirst = this.We.pollFirst();
            if (scVarPollFirst == null) {
                this.zY = com.bytedance.adsdk.sc.pFF.ExN.pFF.sc(arrayList, this.ExN, i11);
                this.We = null;
                return;
            }
            arrayList.add(0, scVarPollFirst);
        }
    }

    public <T> T sc(Map<String, JSONObject> map) {
        return (T) this.zY.sc(map);
    }

    public <T> T sc(JSONObject jSONObject) {
        HashMap map = new HashMap();
        map.put("default_key", jSONObject);
        return (T) sc(map);
    }
}
