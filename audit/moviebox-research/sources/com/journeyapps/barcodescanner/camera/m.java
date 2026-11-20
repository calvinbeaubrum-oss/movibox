package com.journeyapps.barcodescanner.camera;

import android.graphics.Rect;
import java.util.List;
import xn.t;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public t f42625a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f42626b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f42627c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public PreviewScalingStrategy f42628d = new n();

    public m(int i11, t tVar) {
        this.f42626b = i11;
        this.f42625a = tVar;
    }

    public t a(List<t> list, boolean z11) {
        return this.f42628d.b(list, b(z11));
    }

    public t b(boolean z11) {
        t tVar = this.f42625a;
        if (tVar == null) {
            return null;
        }
        return z11 ? tVar.c() : tVar;
    }

    public int c() {
        return this.f42626b;
    }

    public Rect d(t tVar) {
        return this.f42628d.d(tVar, this.f42625a);
    }

    public void e(PreviewScalingStrategy previewScalingStrategy) {
        this.f42628d = previewScalingStrategy;
    }
}
