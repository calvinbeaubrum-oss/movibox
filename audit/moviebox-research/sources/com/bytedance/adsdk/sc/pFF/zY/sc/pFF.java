package com.bytedance.adsdk.sc.pFF.zY.sc;

import com.bytedance.adsdk.sc.pFF.pFF.sc.YIK;
import java.util.Deque;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class pFF extends TRI {
    @Override // com.bytedance.adsdk.sc.pFF.zY.sc.TRI
    public int sc(String str, int i11, Deque<com.bytedance.adsdk.sc.pFF.pFF.sc> deque, com.bytedance.adsdk.sc.pFF.zY.sc scVar) {
        if ('\'' != sc(i11, str)) {
            return scVar.sc(str, i11, deque);
        }
        int i12 = i11 + 1;
        int length = str.length();
        int i13 = i12;
        while (i13 < length && sc(i13, str) != '\'') {
            i13++;
        }
        if (sc(i13, str) != '\'') {
            throw new com.bytedance.adsdk.sc.sc.sc("String expression not surrounded by '", str.substring(i11));
        }
        deque.push(new YIK(str.substring(i12, i13)));
        return i13 + 1;
    }
}
