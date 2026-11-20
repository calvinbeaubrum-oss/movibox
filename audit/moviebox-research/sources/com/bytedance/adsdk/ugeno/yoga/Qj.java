package com.bytedance.adsdk.ugeno.yoga;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class Qj extends ViewGroup implements com.bytedance.adsdk.ugeno.pFF.pFF, com.bytedance.adsdk.ugeno.sc.ExN {
    private com.bytedance.adsdk.ugeno.sc.TRI We;
    private final Tf pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final Map<View, Tf> f26465sc;
    private com.bytedance.adsdk.ugeno.zY zY;

    /* JADX INFO: compiled from: source.java */
    public static class pFF implements Ol {
        private int sc(WH wh2) {
            if (wh2 == WH.AT_MOST) {
                return Integer.MIN_VALUE;
            }
            return wh2 == WH.EXACTLY ? 1073741824 : 0;
        }

        @Override // com.bytedance.adsdk.ugeno.yoga.Ol
        public long sc(Tf tf2, float f11, WH wh2, float f12, WH wh3) {
            View view = (View) tf2.Ol();
            if (view == null || (view instanceof Qj)) {
                return UFX.sc(0, 0);
            }
            view.measure(View.MeasureSpec.makeMeasureSpec((int) f11, sc(wh2)), View.MeasureSpec.makeMeasureSpec((int) f12, sc(wh3)));
            return UFX.sc(view.getMeasuredWidth(), view.getMeasuredHeight());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class sc extends ViewGroup.LayoutParams {
        private float BT;
        private float ExN;
        private float Ol;
        private float Qj;
        private float Ql;
        private float SR;
        private float Sfl;
        private float TRI;
        private float Tf;
        private float UFX;
        private float WH;
        private float We;
        private float Xc;
        private float dE;
        SparseArray<String> pFF;

        /* JADX INFO: renamed from: qr, reason: collision with root package name */
        private float f26466qr;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        SparseArray<Float> f26467sc;
        private float wjp;
        private float zY;

        public sc(int i11, int i12) {
            super(i11, i12);
            this.f26467sc = new SparseArray<>();
            this.pFF = new SparseArray<>();
            if (i11 == -2 || i11 == -1 || i11 >= 0) {
                this.f26467sc.put(15, Float.valueOf(i11));
            }
            if (i12 == -2 || i12 == -1 || i12 >= 0) {
                this.f26467sc.put(16, Float.valueOf(i12));
            }
        }

        public sc(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            if (layoutParams instanceof sc) {
                sc scVar = (sc) layoutParams;
                this.f26467sc = scVar.f26467sc.clone();
                this.pFF = scVar.pFF.clone();
                return;
            }
            this.f26467sc = new SparseArray<>();
            this.pFF = new SparseArray<>();
            if (layoutParams.width >= 0) {
                this.f26467sc.put(15, Float.valueOf(((ViewGroup.LayoutParams) this).width));
            }
            if (layoutParams.height >= 0) {
                this.f26467sc.put(16, Float.valueOf(((ViewGroup.LayoutParams) this).height));
            }
        }

        public void BT(float f11) {
            this.Xc = f11;
            this.f26467sc.put(25, Float.valueOf(f11));
        }

        public void ExN(float f11) {
            this.UFX = f11;
            this.f26467sc.put(9, Float.valueOf(f11));
        }

        public void Ol(float f11) {
            this.BT = f11;
            this.f26467sc.put(12, Float.valueOf(f11));
        }

        public void Qj(float f11) {
            this.SR = f11;
            this.f26467sc.put(11, Float.valueOf(f11));
        }

        public void Ql(float f11) {
            this.ExN = f11;
            this.f26467sc.put(19, Float.valueOf(f11));
        }

        public void SR(float f11) {
            this.TRI = f11;
            this.f26467sc.put(20, Float.valueOf(f11));
        }

        public void TRI(float f11) {
            this.Tf = f11;
            this.f26467sc.put(14, Float.valueOf(f11));
        }

        public void Tf(float f11) {
            this.We = f11;
            this.f26467sc.put(18, Float.valueOf(f11));
        }

        public void UFX(float f11) {
            this.zY = f11;
            this.f26467sc.put(17, Float.valueOf(f11));
        }

        public void WH(float f11) {
            this.dE = f11;
            this.f26467sc.put(13, Float.valueOf(f11));
        }

        public void We(float f11) {
            this.WH = f11;
            this.f26467sc.put(8, Float.valueOf(f11));
        }

        public void Xc(float f11) {
            this.Sfl = f11;
            this.f26467sc.put(28, Float.valueOf(f11));
        }

        public void dE(float f11) {
            this.wjp = f11;
            this.f26467sc.put(27, Float.valueOf(f11));
        }

        public void pFF(float f11) {
            this.Qj = f11;
            this.f26467sc.put(6, Float.valueOf(f11));
        }

        public void qr(float f11) {
            this.Ql = f11;
            this.f26467sc.put(10, Float.valueOf(f11));
        }

        public void sc(float f11) {
            this.f26466qr = f11;
            this.f26467sc.put(5, Float.valueOf(f11));
        }

        public void zY(float f11) {
            this.Ol = f11;
            this.f26467sc.put(7, Float.valueOf(f11));
        }
    }

    public Qj(Context context) {
        this(context, null, 0);
    }

    public Qj(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.We = new com.bytedance.adsdk.ugeno.sc.TRI(this);
        Tf tfSc = Ql.sc();
        this.pFF = tfSc;
        this.f26465sc = new HashMap();
        tfSc.sc(this);
        tfSc.sc((Ol) new pFF());
        sc((sc) generateDefaultLayoutParams(), tfSc, this);
    }

    private void pFF(Tf tf2, int i11) {
        if (i11 == -1) {
            tf2.qr(100.0f);
        } else if (i11 == -2) {
            tf2.We();
        } else {
            tf2.TRI(i11);
        }
    }

    private void sc(int i11, int i12) {
        int size = View.MeasureSpec.getSize(i11);
        int size2 = View.MeasureSpec.getSize(i12);
        int mode = View.MeasureSpec.getMode(i11);
        int mode2 = View.MeasureSpec.getMode(i12);
        if (mode2 == 1073741824) {
            this.pFF.TRI(size2);
        }
        if (mode == 1073741824) {
            this.pFF.We(size);
        }
        if (mode2 == Integer.MIN_VALUE) {
            this.pFF.UFX(size2);
        }
        if (mode == Integer.MIN_VALUE) {
            this.pFF.WH(size);
        }
        this.pFF.sc(Float.NaN, Float.NaN);
    }

    private void sc(View view, boolean z11) {
        Tf tf2 = this.f26465sc.get(view);
        if (tf2 == null) {
            return;
        }
        Tf tfPFF = tf2.pFF();
        for (int i11 = 0; i11 < tfPFF.sc(); i11++) {
            if (tfPFF.sc(i11).equals(tf2)) {
                tfPFF.pFF(i11);
                break;
            }
        }
        tf2.sc((Object) null);
        this.f26465sc.remove(view);
        if (z11) {
            this.pFF.sc(Float.NaN, Float.NaN);
        }
    }

    public static void sc(sc scVar, Tf tf2, View view) {
        if (view.getResources().getConfiguration().getLayoutDirection() == 1) {
            tf2.sc(We.RTL);
        }
        Drawable background = view.getBackground();
        if (background != null) {
            Rect rect = new Rect();
            if (background.getPadding(rect)) {
                tf2.pFF(ExN.LEFT, rect.left);
                tf2.pFF(ExN.TOP, rect.top);
                tf2.pFF(ExN.RIGHT, rect.right);
                tf2.pFF(ExN.BOTTOM, rect.bottom);
            }
        }
        for (int i11 = 0; i11 < scVar.f26467sc.size(); i11++) {
            int iKeyAt = scVar.f26467sc.keyAt(i11);
            float fFloatValue = scVar.f26467sc.valueAt(i11).floatValue();
            if (iKeyAt == 4) {
                tf2.zY(com.bytedance.adsdk.ugeno.yoga.pFF.sc(Math.round(fFloatValue)));
            } else if (iKeyAt == 0) {
                tf2.sc(com.bytedance.adsdk.ugeno.yoga.pFF.sc(Math.round(fFloatValue)));
            } else if (iKeyAt == 9) {
                tf2.pFF(com.bytedance.adsdk.ugeno.yoga.pFF.sc(Math.round(fFloatValue)));
            } else if (iKeyAt == 25) {
                tf2.Tf(fFloatValue);
            } else if (iKeyAt == 8) {
                tf2.zY(fFloatValue);
            } else if (iKeyAt == 1) {
                tf2.sc(TRI.sc(Math.round(fFloatValue)));
            } else if (iKeyAt == 6) {
                tf2.sc(fFloatValue);
            } else if (iKeyAt == 7) {
                tf2.pFF(fFloatValue);
            } else if (iKeyAt == 16) {
                if (fFloatValue == -1.0f) {
                    tf2.qr(100.0f);
                } else if (fFloatValue == -2.0f) {
                    tf2.We();
                } else {
                    tf2.TRI(fFloatValue);
                }
            } else if (iKeyAt == 18) {
                tf2.sc(ExN.LEFT, fFloatValue);
            } else if (iKeyAt == 3) {
                tf2.sc(qr.sc(Math.round(fFloatValue)));
            } else if (iKeyAt == 17) {
                tf2.sc(ExN.TOP, fFloatValue);
            } else if (iKeyAt == 20) {
                tf2.sc(ExN.RIGHT, fFloatValue);
            } else if (iKeyAt == 19) {
                tf2.sc(ExN.BOTTOM, fFloatValue);
            } else if (iKeyAt == 28) {
                tf2.Ol(fFloatValue);
            } else if (iKeyAt == 27) {
                tf2.Qj(fFloatValue);
            } else if (iKeyAt == 22) {
                tf2.pFF(ExN.LEFT, fFloatValue);
            } else if (iKeyAt == 21) {
                tf2.pFF(ExN.TOP, fFloatValue);
            } else if (iKeyAt == 24) {
                tf2.pFF(ExN.RIGHT, fFloatValue);
            } else if (iKeyAt == 23) {
                tf2.pFF(ExN.BOTTOM, fFloatValue);
            } else if (iKeyAt == 11) {
                tf2.zY(ExN.LEFT, fFloatValue);
            } else if (iKeyAt == 10) {
                tf2.zY(ExN.TOP, fFloatValue);
            } else if (iKeyAt == 13) {
                tf2.zY(ExN.RIGHT, fFloatValue);
            } else if (iKeyAt == 12) {
                tf2.zY(ExN.BOTTOM, fFloatValue);
            } else if (iKeyAt == 14) {
                tf2.sc(BT.sc(Math.round(fFloatValue)));
            } else if (iKeyAt == 15) {
                if (fFloatValue == -1.0f) {
                    tf2.ExN(100.0f);
                } else if (fFloatValue == -2.0f) {
                    tf2.zY();
                } else {
                    tf2.We(fFloatValue);
                }
            } else if (iKeyAt == 2) {
                tf2.sc(dE.sc(Math.round(fFloatValue)));
            }
        }
    }

    private void sc(Tf tf2) {
        if (tf2.pFF() != null) {
            sc(tf2.pFF());
        } else {
            tf2.sc(Float.NaN, Float.NaN);
        }
    }

    private void sc(Tf tf2, float f11, float f12) {
        View view = (View) tf2.Ol();
        if (view != null && view != this) {
            if (view.getVisibility() == 8) {
                return;
            }
            int iRound = Math.round(tf2.ExN() + f11);
            int iRound2 = Math.round(tf2.TRI() + f12);
            view.measure(View.MeasureSpec.makeMeasureSpec(Math.round(tf2.qr()), 1073741824), View.MeasureSpec.makeMeasureSpec(Math.round(tf2.Qj()), 1073741824));
            view.layout(iRound, iRound2, view.getMeasuredWidth() + iRound, view.getMeasuredHeight() + iRound2);
        }
        int iSc = tf2.sc();
        for (int i11 = 0; i11 < iSc; i11++) {
            if (equals(view)) {
                sc(tf2.sc(i11), f11, f12);
            } else if (!(view instanceof Qj)) {
                sc(tf2.sc(i11), tf2.ExN() + f11, tf2.TRI() + f12);
            }
        }
    }

    private void sc(Tf tf2, int i11) {
        if (i11 == -1) {
            tf2.ExN(100.0f);
        } else if (i11 == -2) {
            tf2.zY();
        } else {
            tf2.We(i11);
        }
    }

    public void We(View view, int i11) {
        int iSc;
        view.setVisibility(i11);
        try {
            Tf tf2 = this.f26465sc.get(view);
            Object tag = view.getTag(151060224);
            if (i11 != 0) {
                if (i11 != 8 || (iSc = this.pFF.sc(tf2)) == -1) {
                    return;
                }
                this.pFF.pFF(iSc);
                view.setTag(151060224, Integer.valueOf(iSc));
                sc(this.pFF);
                return;
            }
            if (tag == null || this.pFF.sc(tf2) != -1) {
                return;
            }
            int iIntValue = ((Integer) tag).intValue();
            if (iIntValue < this.pFF.sc()) {
                this.pFF.sc(this.f26465sc.get(view), iIntValue);
            } else {
                this.pFF.sc(this.f26465sc.get(view), this.pFF.sc());
            }
            sc(this.pFF);
        } catch (Throwable unused) {
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i11, ViewGroup.LayoutParams layoutParams) {
        Tf tfSc;
        this.pFF.sc((Ol) null);
        if (view instanceof com.bytedance.adsdk.ugeno.yoga.sc) {
            throw null;
        }
        super.addView(view, i11, layoutParams);
        if (this.f26465sc.containsKey(view)) {
            return;
        }
        if (view instanceof Qj) {
            tfSc = ((Qj) view).getYogaNode();
        } else {
            tfSc = this.f26465sc.containsKey(view) ? this.f26465sc.get(view) : Ql.sc();
            tfSc.sc(view);
            tfSc.sc((Ol) new pFF());
        }
        sc((sc) view.getLayoutParams(), tfSc, view);
        this.f26465sc.put(view, tfSc);
        if (view.getVisibility() == 8) {
            view.setTag(151060224, Integer.valueOf(this.pFF.sc()));
        } else {
            Tf tf2 = this.pFF;
            tf2.sc(tfSc, tf2.sc());
        }
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof sc;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new sc(-1, -1);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new sc(layoutParams);
    }

    public float getBorderRadius() {
        return this.We.sc();
    }

    @Override // com.bytedance.adsdk.ugeno.sc.ExN
    public float getRipple() {
        return this.We.getRipple();
    }

    @Override // com.bytedance.adsdk.ugeno.sc.ExN
    public float getRubIn() {
        return this.We.getRubIn();
    }

    @Override // com.bytedance.adsdk.ugeno.sc.ExN
    public float getShine() {
        return this.We.getShine();
    }

    @Override // com.bytedance.adsdk.ugeno.sc.ExN
    public float getStretch() {
        return this.We.getStretch();
    }

    public Tf getYogaNode() {
        return this.pFF;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.bytedance.adsdk.ugeno.zY zYVar = this.zY;
        if (zYVar != null) {
            zYVar.qr();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.bytedance.adsdk.ugeno.zY zYVar = this.zY;
        if (zYVar != null) {
            zYVar.Qj();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        com.bytedance.adsdk.ugeno.zY zYVar = this.zY;
        if (zYVar != null) {
            zYVar.sc(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        com.bytedance.adsdk.ugeno.zY zYVar = this.zY;
        if (zYVar != null) {
            zYVar.TRI();
        }
        if (!(getParent() instanceof Qj)) {
            sc(View.MeasureSpec.makeMeasureSpec(i13 - i11, 1073741824), View.MeasureSpec.makeMeasureSpec(i14 - i12, 1073741824));
        }
        sc(this.pFF, 0.0f, 0.0f);
        com.bytedance.adsdk.ugeno.zY zYVar2 = this.zY;
        if (zYVar2 != null) {
            zYVar2.sc(i11, i12, i13, i14);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i11, int i12) {
        if (!(getParent() instanceof Qj)) {
            sc(i11, i12);
        }
        com.bytedance.adsdk.ugeno.zY zYVar = this.zY;
        if (zYVar != null) {
            int[] iArrSc = zYVar.sc(i11, i12);
            setMeasuredDimension(iArrSc[0], iArrSc[1]);
        } else {
            setMeasuredDimension(Math.round(this.pFF.qr()), Math.round(this.pFF.Qj()));
        }
        com.bytedance.adsdk.ugeno.zY zYVar2 = this.zY;
        if (zYVar2 != null) {
            zYVar2.ExN();
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        com.bytedance.adsdk.ugeno.zY zYVar = this.zY;
        if (zYVar != null) {
            zYVar.pFF(i11, i12, i13, i14);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z11) {
        super.onWindowFocusChanged(z11);
    }

    @Override // com.bytedance.adsdk.ugeno.pFF.pFF
    public void pFF(int i11) {
        Tf tf2 = this.pFF;
        if (tf2 != null) {
            pFF(tf2, i11);
            requestLayout();
        }
    }

    @Override // com.bytedance.adsdk.ugeno.pFF.pFF
    public void pFF(View view, int i11) {
        Tf tfSc;
        if (view == null || (tfSc = sc(view)) == null) {
            return;
        }
        pFF(tfSc, i11);
        view.requestLayout();
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            sc(getChildAt(i11), false);
        }
        super.removeAllViews();
    }

    @Override // android.view.ViewGroup
    public void removeAllViewsInLayout() {
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            sc(getChildAt(i11), true);
        }
        super.removeAllViewsInLayout();
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        sc(view, false);
        super.removeView(view);
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int i11) {
        sc(getChildAt(i11), false);
        super.removeViewAt(i11);
    }

    @Override // android.view.ViewGroup
    public void removeViewInLayout(View view) {
        sc(view, true);
        super.removeViewInLayout(view);
    }

    @Override // android.view.ViewGroup
    public void removeViews(int i11, int i12) {
        for (int i13 = i11; i13 < i11 + i12; i13++) {
            sc(getChildAt(i13), false);
        }
        super.removeViews(i11, i12);
    }

    @Override // android.view.ViewGroup
    public void removeViewsInLayout(int i11, int i12) {
        for (int i13 = i11; i13 < i11 + i12; i13++) {
            sc(getChildAt(i13), true);
        }
        super.removeViewsInLayout(i11, i12);
    }

    public Tf sc(View view) {
        return this.f26465sc.get(view);
    }

    @Override // com.bytedance.adsdk.ugeno.pFF.pFF
    public void sc(int i11) {
        Tf tf2 = this.pFF;
        if (tf2 != null) {
            sc(tf2, i11);
            requestLayout();
        }
    }

    @Override // com.bytedance.adsdk.ugeno.pFF.pFF
    public void sc(View view, int i11) {
        Tf tfSc;
        if (view == null || (tfSc = sc(view)) == null) {
            return;
        }
        sc(tfSc, i11);
        view.requestLayout();
    }

    public void sc(com.bytedance.adsdk.ugeno.pFF.zY zYVar) {
        this.zY = zYVar;
    }

    @Override // android.view.View
    public void setBackgroundColor(int i11) {
        this.We.sc(i11);
    }

    public void setBorderRadius(float f11) {
        this.We.sc(f11);
    }

    public void setRipple(float f11) {
        com.bytedance.adsdk.ugeno.sc.TRI tri = this.We;
        if (tri != null) {
            tri.pFF(f11);
        }
    }

    public void setRubIn(float f11) {
        com.bytedance.adsdk.ugeno.sc.TRI tri = this.We;
        if (tri != null) {
            tri.ExN(f11);
        }
    }

    public void setShine(float f11) {
        com.bytedance.adsdk.ugeno.sc.TRI tri = this.We;
        if (tri != null) {
            tri.zY(f11);
        }
    }

    public void setStretch(float f11) {
        com.bytedance.adsdk.ugeno.sc.TRI tri = this.We;
        if (tri != null) {
            tri.We(f11);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.pFF.pFF
    public void zY(View view, int i11) {
        We(view, i11);
    }
}
