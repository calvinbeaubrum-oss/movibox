package com.airbnb.lottie.model.content;

import b7.d;
import b7.h;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class Mask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MaskMode f15157a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f15158b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f15159c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f15160d;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes.dex */
    public enum MaskMode {
        MASK_MODE_ADD,
        MASK_MODE_SUBTRACT,
        MASK_MODE_INTERSECT,
        MASK_MODE_NONE
    }

    public Mask(MaskMode maskMode, h hVar, d dVar, boolean z11) {
        this.f15157a = maskMode;
        this.f15158b = hVar;
        this.f15159c = dVar;
        this.f15160d = z11;
    }

    public MaskMode a() {
        return this.f15157a;
    }

    public h b() {
        return this.f15158b;
    }

    public d c() {
        return this.f15159c;
    }

    public boolean d() {
        return this.f15160d;
    }
}
