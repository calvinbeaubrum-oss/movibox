package com.bytedance.adsdk.pFF.sc.sc;

import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class pFF {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final List<Dl> f26216sc = new ArrayList();

    public void sc(Path path) {
        for (int size = this.f26216sc.size() - 1; size >= 0; size--) {
            com.bytedance.adsdk.pFF.TRI.TRI.sc(path, this.f26216sc.get(size));
        }
    }

    public void sc(Dl dl2) {
        this.f26216sc.add(dl2);
    }
}
