package com.bytedance.adsdk.sc.pFF.zY.sc;

import com.bytedance.adsdk.sc.pFF.pFF.sc.dE;
import java.util.Deque;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class Qj extends TRI {
    @Override // com.bytedance.adsdk.sc.pFF.zY.sc.TRI
    public int sc(String str, int i11, Deque<com.bytedance.adsdk.sc.pFF.pFF.sc> deque, com.bytedance.adsdk.sc.pFF.zY.sc scVar) {
        if (!com.bytedance.adsdk.sc.pFF.ExN.sc.We(sc(i11, str))) {
            return scVar.sc(str, i11, deque);
        }
        int i12 = i11 + 1;
        String str2 = new String(new char[]{sc(i11, str), sc(i12, str)});
        if (com.bytedance.adsdk.sc.pFF.We.zY.sc(str2) != null) {
            deque.push(new dE(com.bytedance.adsdk.sc.pFF.We.zY.sc(str2)));
            return i11 + 2;
        }
        String strValueOf = String.valueOf(sc(i11, str));
        if (com.bytedance.adsdk.sc.pFF.We.zY.sc(strValueOf) != null) {
            deque.push(new dE(com.bytedance.adsdk.sc.pFF.We.zY.sc(strValueOf)));
            return i12;
        }
        throw new IllegalArgumentException("Unrecognized:" + strValueOf + "examine:" + str.substring(0, i11));
    }
}
