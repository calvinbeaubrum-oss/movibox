package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextUtils;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.bytedance.sdk.component.adexpress.dynamic.animation.view.IAnimation;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ExN extends FrameLayout implements IAnimation, OXF, cJ {
    protected View BT;
    private com.bytedance.sdk.component.utils.YIK Dl;
    protected float ExN;
    protected int Ol;
    protected int Qj;
    protected com.bytedance.sdk.component.adexpress.dynamic.We.Qj Ql;
    protected DynamicRootView SR;
    private float Sfl;
    protected float TRI;
    protected com.bytedance.sdk.component.adexpress.dynamic.We.qr Tf;
    protected Context UFX;
    protected int WH;
    protected float We;
    protected com.bytedance.sdk.component.adexpress.dynamic.animation.sc.pFF Xc;
    private float YIK;
    protected boolean dE;
    private float pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    protected int f26791qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private float f26792sc;
    com.bytedance.sdk.component.adexpress.dynamic.animation.view.zY wjp;
    protected float zY;
    private static final View.OnTouchListener uEA = new View.OnTouchListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ExN.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    };
    private static final View.OnClickListener JPJ = new View.OnClickListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ExN.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    };

    public ExN(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.We.Qj qj2) {
        super(context);
        this.UFX = context;
        this.SR = dynamicRootView;
        this.Ql = qj2;
        this.zY = qj2.TRI();
        this.We = qj2.qr();
        this.ExN = qj2.Qj();
        this.TRI = qj2.Ol();
        this.Ol = (int) com.bytedance.sdk.component.adexpress.We.Qj.sc(this.UFX, this.zY);
        this.WH = (int) com.bytedance.sdk.component.adexpress.We.Qj.sc(this.UFX, this.We);
        this.f26791qr = (int) com.bytedance.sdk.component.adexpress.We.Qj.sc(this.UFX, this.ExN);
        this.Qj = (int) com.bytedance.sdk.component.adexpress.We.Qj.sc(this.UFX, this.TRI);
        com.bytedance.sdk.component.adexpress.dynamic.We.qr qrVar = new com.bytedance.sdk.component.adexpress.dynamic.We.qr(qj2.WH());
        this.Tf = qrVar;
        if (qrVar.wjp() > 0) {
            this.f26791qr += this.Tf.wjp() * 2;
            this.Qj += this.Tf.wjp() * 2;
            this.Ol -= this.Tf.wjp();
            this.WH -= this.Tf.wjp();
            List<com.bytedance.sdk.component.adexpress.dynamic.We.Qj> listUFX = qj2.UFX();
            if (listUFX != null) {
                for (com.bytedance.sdk.component.adexpress.dynamic.We.Qj qj3 : listUFX) {
                    qj3.zY(qj3.TRI() + com.bytedance.sdk.component.adexpress.We.Qj.pFF(this.UFX, this.Tf.wjp()));
                    qj3.We(qj3.qr() + com.bytedance.sdk.component.adexpress.We.Qj.pFF(this.UFX, this.Tf.wjp()));
                    qj3.sc(com.bytedance.sdk.component.adexpress.We.Qj.pFF(this.UFX, this.Tf.wjp()));
                    qj3.pFF(com.bytedance.sdk.component.adexpress.We.Qj.pFF(this.UFX, this.Tf.wjp()));
                }
            }
        }
        this.dE = this.Tf.SR() > 0.0d;
        this.wjp = new com.bytedance.sdk.component.adexpress.dynamic.animation.view.zY();
    }

    private List<String> pFF(String str) {
        ArrayList arrayList = new ArrayList();
        int i11 = 0;
        boolean z11 = false;
        int i12 = 0;
        for (int i13 = 0; i13 < str.length(); i13++) {
            if (str.charAt(i13) == '(') {
                i11++;
                z11 = true;
            } else if (str.charAt(i13) == ')' && (i11 = i11 - 1) == 0 && z11) {
                int i14 = i13 + 1;
                arrayList.add(str.substring(i12, i14));
                i12 = i14;
                z11 = false;
            }
        }
        return arrayList;
    }

    private void sc() {
        if (isShown()) {
            int iSc = com.bytedance.sdk.component.adexpress.dynamic.pFF.sc.sc(this.Tf);
            if (iSc == 2) {
                if (this.Dl == null) {
                    this.Dl = new com.bytedance.sdk.component.utils.YIK(getContext().getApplicationContext(), 1);
                }
                new Object() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ExN.4
                };
                com.bytedance.sdk.component.adexpress.pFF.Ql renderRequest = this.SR.getRenderRequest();
                if (renderRequest != null) {
                    renderRequest.BT();
                    renderRequest.Dl();
                    renderRequest.Sfl();
                    return;
                }
                return;
            }
            if (iSc == 3) {
                if (this.Dl == null) {
                    this.Dl = new com.bytedance.sdk.component.utils.YIK(getContext().getApplicationContext(), 2);
                }
                new Object() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ExN.5
                };
                com.bytedance.sdk.component.adexpress.pFF.Ql renderRequest2 = this.SR.getRenderRequest();
                if (renderRequest2 != null) {
                    renderRequest2.Xc();
                    renderRequest2.uEA();
                    renderRequest2.wjp();
                    renderRequest2.YIK();
                }
            }
        }
    }

    private Drawable[] sc(List<String> list) {
        Drawable[] drawableArr = new Drawable[list.size()];
        for (int i11 = 0; i11 < list.size(); i11++) {
            String str = list.get(i11);
            if (str.contains("linear-gradient")) {
                String[] strArrSplit = str.substring(str.indexOf("(") + 1, str.length() - 1).split(", ");
                int length = strArrSplit.length - 1;
                int[] iArr = new int[length];
                int i12 = 0;
                while (i12 < length) {
                    int i13 = i12 + 1;
                    iArr[i12] = com.bytedance.sdk.component.adexpress.dynamic.We.qr.sc(strArrSplit[i13].substring(0, 7));
                    i12 = i13;
                }
                GradientDrawable gradientDrawableSc = sc(sc(strArrSplit[0]), iArr);
                gradientDrawableSc.setShape(0);
                gradientDrawableSc.setCornerRadius(com.bytedance.sdk.component.adexpress.We.Qj.sc(this.UFX, this.Tf.BT()));
                drawableArr[(list.size() - 1) - i11] = gradientDrawableSc;
            }
        }
        return drawableArr;
    }

    public boolean ExN() {
        com.bytedance.sdk.component.adexpress.dynamic.We.qr qrVar = this.Tf;
        return (qrVar == null || qrVar.II() == 0) ? false : true;
    }

    public boolean Qj() {
        com.bytedance.sdk.component.adexpress.dynamic.We.Qj qj2 = this.Ql;
        return qj2 == null || qj2.WH() == null || this.Ql.WH().ExN() == null || this.Ql.WH().ExN().GOt() == null;
    }

    public void TRI() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.f26791qr, this.Qj);
        layoutParams.topMargin = this.WH;
        int i11 = this.Ol;
        layoutParams.leftMargin = i11;
        layoutParams.setMarginStart(i11);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        setLayoutParams(layoutParams);
    }

    /* JADX WARN: Failed to analyze thrown exceptions
    java.util.ConcurrentModificationException
    	at java.base/java.util.ArrayList$Itr.checkForComodification(ArrayList.java:1095)
    	at java.base/java.util.ArrayList$Itr.next(ArrayList.java:1049)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:130)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:68)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.checkInsn(MethodThrowsVisitor.java:178)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:131)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:68)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.checkInsn(MethodThrowsVisitor.java:178)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:131)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:68)
     */
    public boolean We() {
        View.OnTouchListener onTouchListener;
        View.OnClickListener onClickListener;
        View view = this.BT;
        View view2 = view;
        if (view == null) {
            view2 = this;
        }
        if (ExN()) {
            onTouchListener = (View.OnTouchListener) getDynamicClickListener();
            onClickListener = (View.OnClickListener) getDynamicClickListener();
        } else {
            onTouchListener = uEA;
            onClickListener = JPJ;
        }
        if (onTouchListener != null && onClickListener != null) {
            view2.setOnTouchListener(onTouchListener);
            view2.setOnClickListener(onClickListener);
            int iSc = com.bytedance.sdk.component.adexpress.dynamic.pFF.sc.sc(this.Tf);
            if (iSc == 2 || iSc == 3) {
                view2.setOnClickListener(JPJ);
            } else {
                view2.setOnClickListener(onClickListener);
            }
        }
        sc(view2);
        pFF(view2);
        return true;
    }

    public Drawable getBackgroundDrawable() {
        return sc(false, "");
    }

    public boolean getBeginInvisibleAndShow() {
        return this.dE;
    }

    public int getClickArea() {
        return this.Tf.II();
    }

    public GradientDrawable getDrawable() {
        return new GradientDrawable();
    }

    public com.bytedance.sdk.component.adexpress.dynamic.TRI.sc getDynamicClickListener() {
        return this.SR.getDynamicClickListener();
    }

    public int getDynamicHeight() {
        return this.Qj;
    }

    public com.bytedance.sdk.component.adexpress.dynamic.We.TRI getDynamicLayoutBrickValue() {
        com.bytedance.sdk.component.adexpress.dynamic.We.ExN exNWH;
        com.bytedance.sdk.component.adexpress.dynamic.We.Qj qj2 = this.Ql;
        if (qj2 == null || (exNWH = qj2.WH()) == null) {
            return null;
        }
        return exNWH.ExN();
    }

    public int getDynamicWidth() {
        return this.f26791qr;
    }

    public String getImageObjectFit() {
        return this.Tf.ko();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.IAnimation
    public float getMarqueeValue() {
        return this.Sfl;
    }

    public Drawable getMutilBackgroundDrawable() {
        try {
            return new LayerDrawable(sc(pFF(this.Tf.kX().replaceAll("/\\*.*\\*/", ""))));
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.IAnimation
    public float getRippleValue() {
        return this.f26792sc;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.IAnimation
    public float getShineValue() {
        return this.pFF;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.IAnimation
    public float getStretchValue() {
        return this.YIK;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        qr();
        sc();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        pFF();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.wjp.sc(canvas, this, this);
    }

    @Override // android.view.View
    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        com.bytedance.sdk.component.adexpress.dynamic.animation.view.zY zYVar = this.wjp;
        View view = this.BT;
        if (view == null) {
            view = this;
        }
        zYVar.sc(view, i11, i12);
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z11) {
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.cJ
    public void pFF() {
        com.bytedance.sdk.component.adexpress.dynamic.animation.sc.pFF pff = this.Xc;
        if (pff != null) {
            pff.pFF();
        }
    }

    public void pFF(@NonNull View view) {
        com.bytedance.sdk.component.adexpress.dynamic.We.TRI triExN;
        com.bytedance.sdk.component.adexpress.dynamic.We.Qj qj2 = this.Ql;
        if (qj2 == null || (triExN = qj2.WH().ExN()) == null) {
            return;
        }
        view.setTag(2097610716, Boolean.valueOf(triExN.qOv()));
    }

    public void qr() {
        if (Qj()) {
            return;
        }
        View view = this.BT;
        if (view == null) {
            view = this;
        }
        this.Xc = new com.bytedance.sdk.component.adexpress.dynamic.animation.sc.pFF(view, this.Ql.WH().ExN().GOt());
        post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ExN.1
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.component.adexpress.dynamic.animation.sc.pFF pff = ExN.this.Xc;
                if (pff != null) {
                    pff.sc();
                }
            }
        });
    }

    public Drawable sc(boolean z11, String str) {
        String[] strArrSplit;
        int[] iArr;
        if (!TextUtils.isEmpty(this.Tf.kX())) {
            try {
                String strKX = this.Tf.kX();
                String strSubstring = strKX.substring(strKX.indexOf("(") + 1, strKX.length() - 1);
                if (strSubstring.contains("rgba") && strSubstring.contains("%")) {
                    strArrSplit = new String[]{strSubstring.substring(0, strSubstring.indexOf(",")).trim(), strSubstring.substring(strSubstring.indexOf(",") + 1, strSubstring.indexOf("%") + 1).trim(), strSubstring.substring(strSubstring.indexOf("%") + 2).trim()};
                    iArr = new int[]{com.bytedance.sdk.component.adexpress.dynamic.We.qr.sc(strArrSplit[1]), com.bytedance.sdk.component.adexpress.dynamic.We.qr.sc(strArrSplit[2])};
                } else {
                    strArrSplit = strSubstring.split(", ");
                    iArr = new int[]{com.bytedance.sdk.component.adexpress.dynamic.We.qr.sc(strArrSplit[1].substring(0, 7)), com.bytedance.sdk.component.adexpress.dynamic.We.qr.sc(strArrSplit[2].substring(0, 7))};
                }
                try {
                    double d11 = Double.parseDouble(strSubstring.substring(strSubstring.indexOf("linear-gradient(") + 1, strSubstring.indexOf("deg")));
                    if (d11 > 225.0d && d11 < 315.0d) {
                        int i11 = iArr[1];
                        iArr[1] = iArr[0];
                        iArr[0] = i11;
                    }
                } catch (Exception unused) {
                }
                GradientDrawable gradientDrawableSc = sc(sc(strArrSplit[0]), iArr);
                gradientDrawableSc.setShape(0);
                gradientDrawableSc.setCornerRadius(com.bytedance.sdk.component.adexpress.We.Qj.sc(this.UFX, this.Tf.BT()));
                return gradientDrawableSc;
            } catch (Exception unused2) {
                Drawable mutilBackgroundDrawable = getMutilBackgroundDrawable();
                if (mutilBackgroundDrawable != null) {
                    return mutilBackgroundDrawable;
                }
            }
        }
        GradientDrawable drawable = getDrawable();
        drawable.setShape(0);
        float fSc = com.bytedance.sdk.component.adexpress.We.Qj.sc(this.UFX, this.Tf.BT());
        drawable.setCornerRadius(fSc);
        if (fSc < 1.0f) {
            float fSc2 = com.bytedance.sdk.component.adexpress.We.Qj.sc(this.UFX, this.Tf.Gb());
            float fSc3 = com.bytedance.sdk.component.adexpress.We.Qj.sc(this.UFX, this.Tf.cD());
            float fSc4 = com.bytedance.sdk.component.adexpress.We.Qj.sc(this.UFX, this.Tf.Cb());
            float fSc5 = com.bytedance.sdk.component.adexpress.We.Qj.sc(this.UFX, this.Tf.OXF());
            float[] fArr = new float[8];
            if (fSc2 > 0.0f) {
                fArr[0] = fSc2;
                fArr[1] = fSc2;
            }
            if (fSc3 > 0.0f) {
                fArr[2] = fSc3;
                fArr[3] = fSc3;
            }
            if (fSc4 > 0.0f) {
                fArr[4] = fSc4;
                fArr[5] = fSc4;
            }
            if (fSc5 > 0.0f) {
                fArr[6] = fSc5;
                fArr[7] = fSc5;
            }
            drawable.setCornerRadii(fArr);
        }
        drawable.setColor(z11 ? Color.parseColor(str) : this.Tf.McK());
        if (this.Tf.Xc() > 0.0f) {
            drawable.setStroke((int) com.bytedance.sdk.component.adexpress.We.Qj.sc(this.UFX, this.Tf.Xc()), this.Tf.dE());
            return drawable;
        }
        if (this.Tf.wjp() <= 0) {
            return drawable;
        }
        drawable.setStroke(this.Tf.wjp(), this.Tf.dE());
        drawable.setAlpha(50);
        if (!TextUtils.equals(this.Ql.WH().pFF(), "video-vd")) {
            return drawable;
        }
        setLayerType(1, null);
        return new Sfl((int) fSc, this.Tf.wjp());
    }

    public GradientDrawable.Orientation sc(String str) {
        try {
            int i11 = (int) Float.parseFloat(str.substring(0, str.length() - 3));
            if (i11 <= 90) {
                return GradientDrawable.Orientation.LEFT_RIGHT;
            }
            if (i11 <= 180) {
                return GradientDrawable.Orientation.TOP_BOTTOM;
            }
            return i11 <= 270 ? GradientDrawable.Orientation.RIGHT_LEFT : GradientDrawable.Orientation.BOTTOM_TOP;
        } catch (Exception unused) {
            return GradientDrawable.Orientation.LEFT_RIGHT;
        }
    }

    public GradientDrawable sc(GradientDrawable.Orientation orientation, int[] iArr) {
        if (iArr == null || iArr.length == 0) {
            return new GradientDrawable();
        }
        if (iArr.length != 1) {
            return new GradientDrawable(orientation, iArr);
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(iArr[0]);
        return gradientDrawable;
    }

    public pFF sc(Bitmap bitmap) {
        return new sc(bitmap, null);
    }

    public void sc(int i11) {
        com.bytedance.sdk.component.adexpress.dynamic.We.qr qrVar = this.Tf;
        if (qrVar != null && qrVar.sc(i11)) {
            Ol();
            int childCount = getChildCount();
            for (int i12 = 0; i12 < childCount; i12++) {
                View childAt = getChildAt(i12);
                if (childAt != null && (getChildAt(i12) instanceof ExN)) {
                    ((ExN) childAt).sc(i11);
                }
            }
        }
    }

    /* JADX WARN: Failed to analyze thrown exceptions
    java.util.ConcurrentModificationException
    	at java.base/java.util.ArrayList$Itr.checkForComodification(ArrayList.java:1095)
    	at java.base/java.util.ArrayList$Itr.next(ArrayList.java:1049)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:130)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:68)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.checkInsn(MethodThrowsVisitor.java:178)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:131)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:68)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.checkInsn(MethodThrowsVisitor.java:178)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:131)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:68)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.checkInsn(MethodThrowsVisitor.java:178)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:131)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:68)
     */
    public void sc(View view) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("width", this.Ql.Qj());
            jSONObject.put("height", this.Ql.Ol());
            if (com.bytedance.sdk.component.adexpress.We.pFF()) {
                view.setTag(com.bytedance.sdk.component.adexpress.dynamic.sc.YIK, this.Tf.BR());
                view.setTag(com.bytedance.sdk.component.adexpress.dynamic.sc.Dl, this.Ql.WH().pFF());
                view.setTag(com.bytedance.sdk.component.adexpress.dynamic.sc.uEA, this.Ql.zY());
                view.setTag(com.bytedance.sdk.component.adexpress.dynamic.sc.JPJ, jSONObject.toString());
                return;
            }
            view.setTag(2097610717, this.Tf.BR());
            view.setTag(2097610715, this.Ql.WH().pFF());
            view.setTag(2097610714, this.Ql.zY());
            view.setTag(2097610713, jSONObject.toString());
            int iSc = com.bytedance.sdk.component.adexpress.dynamic.pFF.sc.sc(this.Tf);
            if (iSc == 1) {
                view.setTag(2097610707, new Pair(this.Tf.WP(), Long.valueOf(this.Tf.cvk())));
                view.setTag(2097610708, Integer.valueOf(iSc));
            }
        } catch (JSONException unused) {
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.IAnimation
    public void setMarqueeValue(float f11) {
        this.Sfl = f11;
        postInvalidate();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.IAnimation
    public void setRippleValue(float f11) {
        this.f26792sc = f11;
        postInvalidate();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.IAnimation
    public void setShineValue(float f11) {
        this.pFF = f11;
        postInvalidate();
    }

    public void setShouldInvisible(boolean z11) {
        this.dE = z11;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.IAnimation
    public void setStretchValue(float f11) {
        this.YIK = f11;
        this.wjp.sc(this, f11);
    }

    public boolean zY() {
        Ol();
        TRI();
        We();
        return true;
    }
}
