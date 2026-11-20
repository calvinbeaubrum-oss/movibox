package com.journeyapps.barcodescanner.camera;

import android.graphics.Rect;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import xn.t;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class PreviewScalingStrategy {
    public List<t> a(List<t> list, final t tVar) {
        if (tVar == null) {
            return list;
        }
        Collections.sort(list, new Comparator<t>() { // from class: com.journeyapps.barcodescanner.camera.PreviewScalingStrategy.1
            @Override // java.util.Comparator
            public int compare(t tVar2, t tVar3) {
                return Float.compare(PreviewScalingStrategy.this.c(tVar3, tVar), PreviewScalingStrategy.this.c(tVar2, tVar));
            }
        });
        return list;
    }

    public t b(List<t> list, t tVar) {
        List<t> listA = a(list, tVar);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Viewfinder size: ");
        sb2.append(tVar);
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Preview in order of preference: ");
        sb3.append(listA);
        return listA.get(0);
    }

    public abstract float c(t tVar, t tVar2);

    public abstract Rect d(t tVar, t tVar2);
}
