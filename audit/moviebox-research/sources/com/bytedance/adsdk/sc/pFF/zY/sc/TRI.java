package com.bytedance.adsdk.sc.pFF.zY.sc;

import java.util.Deque;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class TRI {
    public int pFF(int i11, String str) {
        while (com.bytedance.adsdk.sc.pFF.ExN.sc.sc(sc(i11, str))) {
            i11++;
        }
        return i11;
    }

    public char sc(int i11, String str) {
        if (i11 >= str.length()) {
            return (char) 26;
        }
        return str.charAt(i11);
    }

    public abstract int sc(String str, int i11, Deque<com.bytedance.adsdk.sc.pFF.pFF.sc> deque, com.bytedance.adsdk.sc.pFF.zY.sc scVar);
}
