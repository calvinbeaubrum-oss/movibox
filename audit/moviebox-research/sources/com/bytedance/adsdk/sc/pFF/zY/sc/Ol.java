package com.bytedance.adsdk.sc.pFF.zY.sc;

import java.util.Deque;
import java.util.LinkedList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class Ol extends TRI {
    @Override // com.bytedance.adsdk.sc.pFF.zY.sc.TRI
    public int sc(String str, int i11, Deque<com.bytedance.adsdk.sc.pFF.pFF.sc> deque, com.bytedance.adsdk.sc.pFF.zY.sc scVar) {
        com.bytedance.adsdk.sc.pFF.pFF.sc scVarPollFirst;
        if (')' != sc(i11, str)) {
            return scVar.sc(str, i11, deque);
        }
        LinkedList<com.bytedance.adsdk.sc.pFF.pFF.sc> linkedList = new LinkedList();
        while (true) {
            scVarPollFirst = deque.pollFirst();
            if (scVarPollFirst == null || scVarPollFirst.sc() == com.bytedance.adsdk.sc.pFF.We.pFF.METHOD || scVarPollFirst.sc() == com.bytedance.adsdk.sc.pFF.We.We.LEFT_PAREN) {
                break;
            }
            linkedList.addFirst(scVarPollFirst);
        }
        if (scVarPollFirst == null) {
            throw new IllegalArgumentException(str.substring(0, i11));
        }
        if (scVarPollFirst.sc() != com.bytedance.adsdk.sc.pFF.We.pFF.METHOD) {
            deque.push(com.bytedance.adsdk.sc.pFF.ExN.pFF.sc(linkedList, str, i11));
            return i11 + 1;
        }
        com.bytedance.adsdk.sc.pFF.pFF.sc.WH wh2 = (com.bytedance.adsdk.sc.pFF.pFF.sc.WH) scVarPollFirst;
        LinkedList linkedList2 = new LinkedList();
        LinkedList linkedList3 = new LinkedList();
        for (com.bytedance.adsdk.sc.pFF.pFF.sc scVar2 : linkedList) {
            if (scVar2.sc() == com.bytedance.adsdk.sc.pFF.We.We.COMMA) {
                linkedList2.add(com.bytedance.adsdk.sc.pFF.ExN.pFF.sc(linkedList3, str, i11));
                linkedList3.clear();
            } else {
                linkedList3.addLast(scVar2);
            }
        }
        if (!linkedList3.isEmpty()) {
            linkedList2.add(com.bytedance.adsdk.sc.pFF.ExN.pFF.sc(linkedList3, str, i11));
        }
        wh2.sc((com.bytedance.adsdk.sc.pFF.pFF.sc[]) linkedList2.toArray(new com.bytedance.adsdk.sc.pFF.pFF.sc[linkedList2.size()]));
        int i12 = i11 + 1;
        deque.push(wh2);
        return i12;
    }
}
