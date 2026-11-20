package com.bytedance.adsdk.sc.pFF.zY.sc;

import com.bytedance.adsdk.sc.pFF.pFF.sc.BT;
import java.util.Deque;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class qr extends TRI {
    private boolean sc(String str, int i11, Deque<com.bytedance.adsdk.sc.pFF.pFF.sc> deque) {
        if ('-' != sc(i11, str)) {
            return com.bytedance.adsdk.sc.pFF.ExN.sc.zY(sc(i11, str));
        }
        if (deque.peek() != null && !com.bytedance.adsdk.sc.pFF.We.zY.sc(deque.peek().sc())) {
            return false;
        }
        if (com.bytedance.adsdk.sc.pFF.ExN.sc.zY(sc(i11 + 1, str))) {
            return true;
        }
        throw new IllegalArgumentException("Unrecognized - symbol, not a negative number or operator, problem range:" + str.substring(0, i11));
    }

    @Override // com.bytedance.adsdk.sc.pFF.zY.sc.TRI
    public int sc(String str, int i11, Deque<com.bytedance.adsdk.sc.pFF.pFF.sc> deque, com.bytedance.adsdk.sc.pFF.zY.sc scVar) {
        char cSc;
        if (!sc(str, i11, deque)) {
            return scVar.sc(str, i11, deque);
        }
        int i12 = sc(i11, str) == '-' ? i11 + 1 : i11;
        boolean z11 = false;
        while (true) {
            cSc = sc(i12, str);
            if (!com.bytedance.adsdk.sc.pFF.ExN.sc.zY(cSc) && (z11 || cSc != '.')) {
                break;
            }
            i12++;
            if (cSc == '.') {
                z11 = true;
            }
        }
        if (cSc != '.') {
            deque.push(new BT(str.substring(i11, i12)));
            return i12;
        }
        throw new IllegalArgumentException("Illegal negative number format, problem interval:" + str.substring(i11, i12));
    }
}
