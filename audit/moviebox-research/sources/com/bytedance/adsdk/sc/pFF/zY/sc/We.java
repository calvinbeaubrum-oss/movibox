package com.bytedance.adsdk.sc.pFF.zY.sc;

import com.bytedance.adsdk.sc.pFF.pFF.sc.Dl;
import java.util.Deque;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class We extends TRI {
    @Override // com.bytedance.adsdk.sc.pFF.zY.sc.TRI
    public int sc(String str, int i11, Deque<com.bytedance.adsdk.sc.pFF.pFF.sc> deque, com.bytedance.adsdk.sc.pFF.zY.sc scVar) {
        if ('(' != sc(i11, str)) {
            return scVar.sc(str, i11, deque);
        }
        deque.push(new Dl(com.bytedance.adsdk.sc.pFF.We.We.LEFT_PAREN));
        return i11 + 1;
    }
}
