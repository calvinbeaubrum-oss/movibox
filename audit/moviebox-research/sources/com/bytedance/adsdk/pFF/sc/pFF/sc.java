package com.bytedance.adsdk.pFF.sc.pFF;

import android.view.animation.Interpolator;
import com.bytedance.component.sdk.annotation.FloatRange;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class sc<K, A> {
    private final zY<K> ExN;
    protected com.bytedance.adsdk.pFF.qr.pFF<A> zY;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    final List<InterfaceC0222sc> f26191sc = new ArrayList(1);
    private boolean We = false;
    protected float pFF = 0.0f;
    private A TRI = null;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private float f26190qr = -1.0f;
    private float Qj = -1.0f;

    /* JADX INFO: compiled from: source.java */
    public static final class ExN<T> implements zY<T> {
        private float pFF = -1.0f;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        private final com.bytedance.adsdk.pFF.qr.sc<T> f26192sc;

        public ExN(List<? extends com.bytedance.adsdk.pFF.qr.sc<T>> list) {
            this.f26192sc = list.get(0);
        }

        @Override // com.bytedance.adsdk.pFF.sc.pFF.sc.zY
        public float We() {
            return this.f26192sc.We();
        }

        @Override // com.bytedance.adsdk.pFF.sc.pFF.sc.zY
        public com.bytedance.adsdk.pFF.qr.sc<T> pFF() {
            return this.f26192sc;
        }

        @Override // com.bytedance.adsdk.pFF.sc.pFF.sc.zY
        public boolean pFF(float f11) {
            if (this.pFF == f11) {
                return true;
            }
            this.pFF = f11;
            return false;
        }

        @Override // com.bytedance.adsdk.pFF.sc.pFF.sc.zY
        public boolean sc() {
            return false;
        }

        @Override // com.bytedance.adsdk.pFF.sc.pFF.sc.zY
        public boolean sc(float f11) {
            return !this.f26192sc.ExN();
        }

        @Override // com.bytedance.adsdk.pFF.sc.pFF.sc.zY
        public float zY() {
            return this.f26192sc.zY();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class We<T> implements zY<T> {

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        private final List<? extends com.bytedance.adsdk.pFF.qr.sc<T>> f26193sc;
        private com.bytedance.adsdk.pFF.qr.sc<T> zY = null;
        private float We = -1.0f;
        private com.bytedance.adsdk.pFF.qr.sc<T> pFF = zY(0.0f);

        public We(List<? extends com.bytedance.adsdk.pFF.qr.sc<T>> list) {
            this.f26193sc = list;
        }

        private com.bytedance.adsdk.pFF.qr.sc<T> zY(float f11) {
            List<? extends com.bytedance.adsdk.pFF.qr.sc<T>> list = this.f26193sc;
            com.bytedance.adsdk.pFF.qr.sc<T> scVar = list.get(list.size() - 1);
            if (f11 >= scVar.zY()) {
                return scVar;
            }
            for (int size = this.f26193sc.size() - 2; size > 0; size--) {
                com.bytedance.adsdk.pFF.qr.sc<T> scVar2 = this.f26193sc.get(size);
                if (this.pFF != scVar2 && scVar2.sc(f11)) {
                    return scVar2;
                }
            }
            return this.f26193sc.get(0);
        }

        @Override // com.bytedance.adsdk.pFF.sc.pFF.sc.zY
        public float We() {
            List<? extends com.bytedance.adsdk.pFF.qr.sc<T>> list = this.f26193sc;
            return list.get(list.size() - 1).We();
        }

        @Override // com.bytedance.adsdk.pFF.sc.pFF.sc.zY
        public com.bytedance.adsdk.pFF.qr.sc<T> pFF() {
            return this.pFF;
        }

        @Override // com.bytedance.adsdk.pFF.sc.pFF.sc.zY
        public boolean pFF(float f11) {
            com.bytedance.adsdk.pFF.qr.sc<T> scVar = this.zY;
            com.bytedance.adsdk.pFF.qr.sc<T> scVar2 = this.pFF;
            if (scVar == scVar2 && this.We == f11) {
                return true;
            }
            this.zY = scVar2;
            this.We = f11;
            return false;
        }

        @Override // com.bytedance.adsdk.pFF.sc.pFF.sc.zY
        public boolean sc() {
            return false;
        }

        @Override // com.bytedance.adsdk.pFF.sc.pFF.sc.zY
        public boolean sc(float f11) {
            if (this.pFF.sc(f11)) {
                return !this.pFF.ExN();
            }
            this.pFF = zY(f11);
            return true;
        }

        @Override // com.bytedance.adsdk.pFF.sc.pFF.sc.zY
        public float zY() {
            return this.f26193sc.get(0).zY();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class pFF<T> implements zY<T> {
        private pFF() {
        }

        @Override // com.bytedance.adsdk.pFF.sc.pFF.sc.zY
        public float We() {
            return 1.0f;
        }

        @Override // com.bytedance.adsdk.pFF.sc.pFF.sc.zY
        public com.bytedance.adsdk.pFF.qr.sc<T> pFF() {
            throw new IllegalStateException("not implemented");
        }

        @Override // com.bytedance.adsdk.pFF.sc.pFF.sc.zY
        public boolean pFF(float f11) {
            throw new IllegalStateException("not implemented");
        }

        @Override // com.bytedance.adsdk.pFF.sc.pFF.sc.zY
        public boolean sc() {
            return true;
        }

        @Override // com.bytedance.adsdk.pFF.sc.pFF.sc.zY
        public boolean sc(float f11) {
            return false;
        }

        @Override // com.bytedance.adsdk.pFF.sc.pFF.sc.zY
        public float zY() {
            return 0.0f;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.adsdk.pFF.sc.pFF.sc$sc, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public interface InterfaceC0222sc {
        void sc();
    }

    /* JADX INFO: compiled from: source.java */
    public interface zY<T> {
        @FloatRange(from = 0.0d, to = 1.0d)
        float We();

        com.bytedance.adsdk.pFF.qr.sc<T> pFF();

        boolean pFF(float f11);

        boolean sc();

        boolean sc(float f11);

        @FloatRange(from = 0.0d, to = 1.0d)
        float zY();
    }

    public sc(List<? extends com.bytedance.adsdk.pFF.qr.sc<K>> list) {
        this.ExN = sc(list);
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    private float Ol() {
        if (this.f26190qr == -1.0f) {
            this.f26190qr = this.ExN.zY();
        }
        return this.f26190qr;
    }

    private static <T> zY<T> sc(List<? extends com.bytedance.adsdk.pFF.qr.sc<T>> list) {
        if (list.isEmpty()) {
            return new pFF();
        }
        return list.size() == 1 ? new ExN(list) : new We(list);
    }

    public float ExN() {
        com.bytedance.adsdk.pFF.qr.sc<K> scVarZY = zY();
        if (scVarZY == null || scVarZY.ExN()) {
            return 0.0f;
        }
        return scVarZY.zY.getInterpolation(We());
    }

    public float Qj() {
        return this.pFF;
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float TRI() {
        if (this.Qj == -1.0f) {
            this.Qj = this.ExN.We();
        }
        return this.Qj;
    }

    public float We() {
        if (this.We) {
            return 0.0f;
        }
        com.bytedance.adsdk.pFF.qr.sc<K> scVarZY = zY();
        if (scVarZY.ExN()) {
            return 0.0f;
        }
        return (this.pFF - scVarZY.zY()) / (scVarZY.We() - scVarZY.zY());
    }

    public void pFF() {
        for (int i11 = 0; i11 < this.f26191sc.size(); i11++) {
            this.f26191sc.get(i11).sc();
        }
    }

    public A qr() {
        float fWe = We();
        if (this.zY == null && this.ExN.pFF(fWe)) {
            return this.TRI;
        }
        com.bytedance.adsdk.pFF.qr.sc<K> scVarZY = zY();
        Interpolator interpolator = scVarZY.We;
        A aSc = (interpolator == null || scVarZY.ExN == null) ? sc(scVarZY, ExN()) : sc(scVarZY, fWe, interpolator.getInterpolation(fWe), scVarZY.ExN.getInterpolation(fWe));
        this.TRI = aSc;
        return aSc;
    }

    public abstract A sc(com.bytedance.adsdk.pFF.qr.sc<K> scVar, float f11);

    public A sc(com.bytedance.adsdk.pFF.qr.sc<K> scVar, float f11, float f12, float f13) {
        throw new UnsupportedOperationException("This animation does not support split dimensions!");
    }

    public void sc() {
        this.We = true;
    }

    public void sc(@FloatRange(from = 0.0d, to = 1.0d) float f11) {
        if (this.ExN.sc()) {
            return;
        }
        if (f11 < Ol()) {
            f11 = Ol();
        } else if (f11 > TRI()) {
            f11 = TRI();
        }
        if (f11 == this.pFF) {
            return;
        }
        this.pFF = f11;
        if (this.ExN.sc(f11)) {
            pFF();
        }
    }

    public void sc(InterfaceC0222sc interfaceC0222sc) {
        this.f26191sc.add(interfaceC0222sc);
    }

    public com.bytedance.adsdk.pFF.qr.sc<K> zY() {
        com.bytedance.adsdk.pFF.ExN.sc("BaseKeyframeAnimation#getCurrentKeyframe");
        com.bytedance.adsdk.pFF.qr.sc<K> scVarPFF = this.ExN.pFF();
        com.bytedance.adsdk.pFF.ExN.pFF("BaseKeyframeAnimation#getCurrentKeyframe");
        return scVarPFF;
    }
}
