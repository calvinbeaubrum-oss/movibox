package com.bytedance.adsdk.ugeno.yoga;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
@com.bytedance.adsdk.ugeno.yoga.sc.sc
public abstract class YogaNodeJNIBase extends Tf implements Cloneable {
    private zY ExN;
    private Object TRI;
    private Ol We;

    @com.bytedance.adsdk.ugeno.yoga.sc.sc
    private float[] arr;

    @com.bytedance.adsdk.ugeno.yoga.sc.sc
    private int mLayoutDirection;
    private YogaNodeJNIBase pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private boolean f26474qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    protected long f26475sc;
    private List<YogaNodeJNIBase> zY;

    public YogaNodeJNIBase() {
        this(YogaNative.jni_YGNodeNewJNI());
    }

    private YogaNodeJNIBase(long j11) {
        this.arr = null;
        this.mLayoutDirection = 0;
        this.f26474qr = true;
        if (j11 == 0) {
            throw new IllegalStateException("Failed to allocate native memory");
        }
        this.f26475sc = j11;
    }

    private void pFF(Tf tf2) {
        Ol();
    }

    @com.bytedance.adsdk.ugeno.yoga.sc.sc
    private final long replaceChild(YogaNodeJNIBase yogaNodeJNIBase, int i11) {
        List<YogaNodeJNIBase> list = this.zY;
        if (list == null) {
            throw new IllegalStateException("Cannot replace child. YogaNode does not have children");
        }
        list.remove(i11);
        this.zY.add(i11, yogaNodeJNIBase);
        yogaNodeJNIBase.pFF = this;
        return yogaNodeJNIBase.f26475sc;
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.Tf
    public float ExN() {
        float[] fArr = this.arr;
        if (fArr != null) {
            return fArr[3];
        }
        return 0.0f;
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.Tf
    public void ExN(float f11) {
        YogaNative.jni_YGNodeStyleSetWidthPercentJNI(this.f26475sc, f11);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.Tf
    public Object Ol() {
        return this.TRI;
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.Tf
    public void Ol(float f11) {
        YogaNative.jni_YGNodeStyleSetMinHeightJNI(this.f26475sc, f11);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.Tf
    public float Qj() {
        float[] fArr = this.arr;
        if (fArr != null) {
            return fArr[2];
        }
        return 0.0f;
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.Tf
    public void Qj(float f11) {
        YogaNative.jni_YGNodeStyleSetMinWidthJNI(this.f26475sc, f11);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.Tf
    public float TRI() {
        float[] fArr = this.arr;
        if (fArr != null) {
            return fArr[4];
        }
        return 0.0f;
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.Tf
    public void TRI(float f11) {
        YogaNative.jni_YGNodeStyleSetHeightJNI(this.f26475sc, f11);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.Tf
    public void Tf(float f11) {
        YogaNative.jni_YGNodeStyleSetAspectRatioJNI(this.f26475sc, f11);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.Tf
    public void UFX(float f11) {
        YogaNative.jni_YGNodeStyleSetMaxHeightJNI(this.f26475sc, f11);
    }

    public boolean UFX() {
        return this.We != null;
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.Tf
    /* JADX INFO: renamed from: WH, reason: merged with bridge method [inline-methods] */
    public YogaNodeJNIBase pFF() {
        return this.pFF;
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.Tf
    public void WH(float f11) {
        YogaNative.jni_YGNodeStyleSetMaxWidthJNI(this.f26475sc, f11);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.Tf
    /* JADX INFO: renamed from: We, reason: merged with bridge method [inline-methods] */
    public YogaNodeJNIBase pFF(int i11) {
        List<YogaNodeJNIBase> list = this.zY;
        if (list == null) {
            throw new IllegalStateException("Trying to remove a child of a YogaNode that does not have children");
        }
        YogaNodeJNIBase yogaNodeJNIBaseRemove = list.remove(i11);
        yogaNodeJNIBaseRemove.pFF = null;
        YogaNative.jni_YGNodeRemoveChildJNI(this.f26475sc, yogaNodeJNIBaseRemove.f26475sc);
        return yogaNodeJNIBaseRemove;
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.Tf
    public void We() {
        YogaNative.jni_YGNodeStyleSetHeightAutoJNI(this.f26475sc);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.Tf
    public void We(float f11) {
        YogaNative.jni_YGNodeStyleSetWidthJNI(this.f26475sc, f11);
    }

    @com.bytedance.adsdk.ugeno.yoga.sc.sc
    public final float baseline(float f11, float f12) {
        return this.ExN.sc(this, f11, f12);
    }

    @com.bytedance.adsdk.ugeno.yoga.sc.sc
    public final long measure(float f11, int i11, float f12, int i12) {
        if (UFX()) {
            return this.We.sc(this, f11, WH.sc(i11), f12, WH.sc(i12));
        }
        throw new RuntimeException("Measure function isn't defined!");
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.Tf
    public void pFF(float f11) {
        YogaNative.jni_YGNodeStyleSetFlexShrinkJNI(this.f26475sc, f11);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.Tf
    public void pFF(ExN exN, float f11) {
        YogaNative.jni_YGNodeStyleSetPaddingJNI(this.f26475sc, exN.sc(), f11);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.Tf
    public void pFF(pFF pff) {
        YogaNative.jni_YGNodeStyleSetAlignSelfJNI(this.f26475sc, pff.sc());
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.Tf
    public float qr() {
        float[] fArr = this.arr;
        if (fArr != null) {
            return fArr[1];
        }
        return 0.0f;
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.Tf
    public void qr(float f11) {
        YogaNative.jni_YGNodeStyleSetHeightPercentJNI(this.f26475sc, f11);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.Tf
    public int sc() {
        List<YogaNodeJNIBase> list = this.zY;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.Tf
    public int sc(Tf tf2) {
        List<YogaNodeJNIBase> list = this.zY;
        if (list == null) {
            return -1;
        }
        return list.indexOf(tf2);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.Tf
    public void sc(float f11) {
        YogaNative.jni_YGNodeStyleSetFlexGrowJNI(this.f26475sc, f11);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.Tf
    public void sc(float f11, float f12) {
        pFF((Tf) null);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this);
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            YogaNodeJNIBase yogaNodeJNIBase = (YogaNodeJNIBase) arrayList.get(i11);
            List<YogaNodeJNIBase> list = yogaNodeJNIBase.zY;
            if (list != null) {
                for (YogaNodeJNIBase yogaNodeJNIBase2 : list) {
                    yogaNodeJNIBase2.pFF(yogaNodeJNIBase);
                    arrayList.add(yogaNodeJNIBase2);
                }
            }
        }
        YogaNodeJNIBase[] yogaNodeJNIBaseArr = (YogaNodeJNIBase[]) arrayList.toArray(new YogaNodeJNIBase[arrayList.size()]);
        long[] jArr = new long[yogaNodeJNIBaseArr.length];
        for (int i12 = 0; i12 < yogaNodeJNIBaseArr.length; i12++) {
            jArr[i12] = yogaNodeJNIBaseArr[i12].f26475sc;
        }
        YogaNative.jni_YGNodeCalculateLayoutJNI(this.f26475sc, f11, f12, jArr, yogaNodeJNIBaseArr);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.Tf
    public void sc(BT bt2) {
        YogaNative.jni_YGNodeStyleSetPositionTypeJNI(this.f26475sc, bt2.sc());
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.Tf
    public void sc(ExN exN, float f11) {
        YogaNative.jni_YGNodeStyleSetMarginJNI(this.f26475sc, exN.sc(), f11);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.Tf
    public void sc(Ol ol2) {
        this.We = ol2;
        YogaNative.jni_YGNodeSetHasMeasureFuncJNI(this.f26475sc, ol2 != null);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.Tf
    public void sc(TRI tri) {
        YogaNative.jni_YGNodeStyleSetFlexDirectionJNI(this.f26475sc, tri.sc());
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.Tf
    public void sc(Tf tf2, int i11) {
        if (tf2 instanceof YogaNodeJNIBase) {
            YogaNodeJNIBase yogaNodeJNIBase = (YogaNodeJNIBase) tf2;
            if (yogaNodeJNIBase.pFF != null) {
                throw new IllegalStateException("Child already has a parent, it must be removed first.");
            }
            if (this.zY == null) {
                this.zY = new ArrayList(4);
            }
            this.zY.add(i11, yogaNodeJNIBase);
            yogaNodeJNIBase.pFF = this;
            YogaNative.jni_YGNodeInsertChildJNI(this.f26475sc, yogaNodeJNIBase.f26475sc, i11);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.Tf
    public void sc(We we2) {
        YogaNative.jni_YGNodeStyleSetDirectionJNI(this.f26475sc, we2.sc());
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.Tf
    public void sc(dE dEVar) {
        YogaNative.jni_YGNodeStyleSetFlexWrapJNI(this.f26475sc, dEVar.sc());
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.Tf
    public void sc(pFF pff) {
        YogaNative.jni_YGNodeStyleSetAlignItemsJNI(this.f26475sc, pff.sc());
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.Tf
    public void sc(qr qrVar) {
        YogaNative.jni_YGNodeStyleSetJustifyContentJNI(this.f26475sc, qrVar.sc());
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.Tf
    public void sc(Object obj) {
        this.TRI = obj;
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.Tf
    /* JADX INFO: renamed from: zY, reason: merged with bridge method [inline-methods] */
    public YogaNodeJNIBase sc(int i11) {
        List<YogaNodeJNIBase> list = this.zY;
        if (list != null) {
            return list.get(i11);
        }
        throw new IllegalStateException("YogaNode does not have children");
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.Tf
    public void zY() {
        YogaNative.jni_YGNodeStyleSetWidthAutoJNI(this.f26475sc);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.Tf
    public void zY(float f11) {
        YogaNative.jni_YGNodeStyleSetFlexBasisJNI(this.f26475sc, f11);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.Tf
    public void zY(ExN exN, float f11) {
        YogaNative.jni_YGNodeStyleSetPositionJNI(this.f26475sc, exN.sc(), f11);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.Tf
    public void zY(pFF pff) {
        YogaNative.jni_YGNodeStyleSetAlignContentJNI(this.f26475sc, pff.sc());
    }
}
