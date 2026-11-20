package com.bytedance.adsdk.pFF.sc.pFF;

import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class Qj {
    private final List<sc<Integer, Integer>> pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final List<sc<com.bytedance.adsdk.pFF.zY.pFF.SR, Path>> f26185sc;
    private final List<com.bytedance.adsdk.pFF.zY.pFF.Qj> zY;

    public Qj(List<com.bytedance.adsdk.pFF.zY.pFF.Qj> list) {
        this.zY = list;
        this.f26185sc = new ArrayList(list.size());
        this.pFF = new ArrayList(list.size());
        for (int i11 = 0; i11 < list.size(); i11++) {
            this.f26185sc.add(list.get(i11).pFF().sc());
            this.pFF.add(list.get(i11).zY().sc());
        }
    }

    public List<sc<com.bytedance.adsdk.pFF.zY.pFF.SR, Path>> pFF() {
        return this.f26185sc;
    }

    public List<com.bytedance.adsdk.pFF.zY.pFF.Qj> sc() {
        return this.zY;
    }

    public List<sc<Integer, Integer>> zY() {
        return this.pFF;
    }
}
