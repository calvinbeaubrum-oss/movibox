package com.bytedance.adsdk.sc.pFF.zY.sc;

import com.bytedance.adsdk.sc.pFF.pFF.sc.uEA;
import java.util.Deque;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class zY extends TRI {
    private int sc(String str, int i11, Deque<com.bytedance.adsdk.sc.pFF.pFF.sc> deque) {
        int i12;
        int i13 = 0;
        while (true) {
            i12 = i13 + i11;
            char cSc = sc(i12, str);
            if (!com.bytedance.adsdk.sc.pFF.ExN.sc.pFF(cSc) && !com.bytedance.adsdk.sc.pFF.ExN.sc.zY(cSc) && '.' != cSc && '[' != cSc && ']' != cSc && '_' != cSc && '-' != cSc) {
                break;
            }
            i13++;
        }
        String strSubstring = str.substring(i11, i12);
        if (com.bytedance.adsdk.sc.pFF.We.sc.sc(strSubstring) != null) {
            deque.push(new com.bytedance.adsdk.sc.pFF.pFF.sc.qr(strSubstring));
        } else {
            deque.push(new uEA(strSubstring));
        }
        return i12;
    }

    @Override // com.bytedance.adsdk.sc.pFF.zY.sc.TRI
    public int sc(String str, int i11, Deque<com.bytedance.adsdk.sc.pFF.pFF.sc> deque, com.bytedance.adsdk.sc.pFF.zY.sc scVar) {
        return !com.bytedance.adsdk.sc.pFF.ExN.sc.pFF(sc(i11, str)) ? scVar.sc(str, i11, deque) : sc(str, i11, deque);
    }
}
