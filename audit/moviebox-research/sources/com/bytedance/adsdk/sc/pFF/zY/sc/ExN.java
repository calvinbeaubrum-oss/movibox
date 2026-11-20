package com.bytedance.adsdk.sc.pFF.zY.sc;

import java.util.Deque;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class ExN extends TRI {
    @Override // com.bytedance.adsdk.sc.pFF.zY.sc.TRI
    public int sc(String str, int i11, Deque<com.bytedance.adsdk.sc.pFF.pFF.sc> deque, com.bytedance.adsdk.sc.pFF.zY.sc scVar) {
        char cSc;
        int i12 = i11;
        while (true) {
            cSc = sc(i12, str);
            if (!com.bytedance.adsdk.sc.pFF.ExN.sc.pFF(cSc) && !com.bytedance.adsdk.sc.pFF.ExN.sc.zY(cSc)) {
                break;
            }
            i12++;
        }
        if (cSc != '(') {
            return scVar.sc(str, i11, deque);
        }
        deque.push(new com.bytedance.adsdk.sc.pFF.pFF.sc.WH(str.substring(i11, i12)));
        return i12 + 1;
    }
}
