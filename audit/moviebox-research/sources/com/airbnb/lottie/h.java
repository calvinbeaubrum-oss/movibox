package com.airbnb.lottie;

import android.graphics.Rect;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.w0;
import com.airbnb.lottie.model.layer.Layer;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map<String, List<Layer>> f15103c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<String, l0> f15104d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f15105e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Map<String, a7.b> f15106f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List<a7.g> f15107g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public w0<a7.c> f15108h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public androidx.collection.v<Layer> f15109i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public List<Layer> f15110j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Rect f15111k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f15112l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f15113m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f15114n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f15115o;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f15117q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f15118r;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PerformanceTracker f15101a = new PerformanceTracker();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashSet<String> f15102b = new HashSet<>();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f15116p = 0;

    public void a(String str) {
        g7.f.c(str);
        this.f15102b.add(str);
    }

    public Rect b() {
        return this.f15111k;
    }

    public w0<a7.c> c() {
        return this.f15108h;
    }

    public float d() {
        return (long) ((e() / this.f15114n) * 1000.0f);
    }

    public float e() {
        return this.f15113m - this.f15112l;
    }

    public float f() {
        return this.f15113m;
    }

    public Map<String, a7.b> g() {
        return this.f15106f;
    }

    public float h(float f11) {
        return g7.k.i(this.f15112l, this.f15113m, f11);
    }

    public float i() {
        return this.f15114n;
    }

    public Map<String, l0> j() {
        float fE = g7.l.e();
        if (fE != this.f15105e) {
            for (Map.Entry<String, l0> entry : this.f15104d.entrySet()) {
                this.f15104d.put(entry.getKey(), entry.getValue().a(this.f15105e / fE));
            }
        }
        this.f15105e = fE;
        return this.f15104d;
    }

    public List<Layer> k() {
        return this.f15110j;
    }

    @Nullable
    public a7.g l(String str) {
        int size = this.f15107g.size();
        for (int i11 = 0; i11 < size; i11++) {
            a7.g gVar = this.f15107g.get(i11);
            if (gVar.a(str)) {
                return gVar;
            }
        }
        return null;
    }

    public int m() {
        return this.f15116p;
    }

    public PerformanceTracker n() {
        return this.f15101a;
    }

    @Nullable
    public List<Layer> o(String str) {
        return this.f15103c.get(str);
    }

    public float p() {
        return this.f15112l;
    }

    public boolean q() {
        return this.f15115o;
    }

    public void r(int i11) {
        this.f15116p += i11;
    }

    public void s(Rect rect, float f11, float f12, float f13, List<Layer> list, androidx.collection.v<Layer> vVar, Map<String, List<Layer>> map, Map<String, l0> map2, float f14, w0<a7.c> w0Var, Map<String, a7.b> map3, List<a7.g> list2, int i11, int i12) {
        this.f15111k = rect;
        this.f15112l = f11;
        this.f15113m = f12;
        this.f15114n = f13;
        this.f15110j = list;
        this.f15109i = vVar;
        this.f15103c = map;
        this.f15104d = map2;
        this.f15105e = f14;
        this.f15108h = w0Var;
        this.f15106f = map3;
        this.f15107g = list2;
        this.f15117q = i11;
        this.f15118r = i12;
    }

    public Layer t(long j11) {
        return this.f15109i.f(j11);
    }

    @NonNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder("LottieComposition:\n");
        Iterator<Layer> it = this.f15110j.iterator();
        while (it.hasNext()) {
            sb2.append(it.next().z("\t"));
        }
        return sb2.toString();
    }

    public void u(boolean z11) {
        this.f15115o = z11;
    }

    public void v(boolean z11) {
        this.f15101a.b(z11);
    }
}
