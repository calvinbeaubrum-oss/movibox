package com.airbnb.lottie;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class PerformanceTracker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f15068a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<a> f15069b = new androidx.collection.b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, g7.j> f15070c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Comparator<androidx.core.util.e<String, Float>> f15071d = new Comparator<androidx.core.util.e<String, Float>>() { // from class: com.airbnb.lottie.PerformanceTracker.1
        @Override // java.util.Comparator
        public int compare(androidx.core.util.e<String, Float> eVar, androidx.core.util.e<String, Float> eVar2) {
            float fFloatValue = eVar.f7890b.floatValue();
            float fFloatValue2 = eVar2.f7890b.floatValue();
            if (fFloatValue2 > fFloatValue) {
                return 1;
            }
            return fFloatValue > fFloatValue2 ? -1 : 0;
        }
    };

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public interface a {
        void a(float f11);
    }

    public void a(String str, float f11) {
        if (this.f15068a) {
            g7.j jVar = this.f15070c.get(str);
            if (jVar == null) {
                jVar = new g7.j();
                this.f15070c.put(str, jVar);
            }
            jVar.a(f11);
            if (str.equals("__container")) {
                Iterator<a> it = this.f15069b.iterator();
                while (it.hasNext()) {
                    it.next().a(f11);
                }
            }
        }
    }

    public void b(boolean z11) {
        this.f15068a = z11;
    }
}
