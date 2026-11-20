package com.bytedance.adsdk.ugeno.We.sc;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class pFF implements zY {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private List<We> f26380sc = new CopyOnWriteArrayList();

    @Override // com.bytedance.adsdk.ugeno.We.sc.zY
    public void sc(We we2) {
        this.f26380sc.add(we2);
    }

    @Override // com.bytedance.adsdk.ugeno.We.sc.zY
    public void sc(String str) {
        if (this.f26380sc.isEmpty()) {
            return;
        }
        Iterator<We> it = this.f26380sc.iterator();
        while (it.hasNext()) {
            it.next().sc(str);
        }
    }
}
