package OoooO00;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import com.google.android.material.card.MaterialCardView;
import java.util.ArrayList;
import java.util.List;
import r0.a;
import r0.b;
import r0.c;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class OooOO0 extends View implements a {

    /* JADX INFO: renamed from: OooO, reason: collision with root package name */
    public float f268OooO;
    public int OooO00o;
    public int OooO0O0;
    public float OooO0OO;

    /* JADX INFO: renamed from: OooO0Oo, reason: collision with root package name */
    public float f269OooO0Oo;

    /* JADX INFO: renamed from: OooO0o, reason: collision with root package name */
    public String f270OooO0o;

    /* JADX INFO: renamed from: OooO0o0, reason: collision with root package name */
    public int f271OooO0o0;
    public boolean OooO0oO;

    /* JADX INFO: renamed from: OooO0oo, reason: collision with root package name */
    public int f272OooO0oo;

    /* JADX INFO: renamed from: OooOO0, reason: collision with root package name */
    public float f273OooOO0;
    public int OooOO0O;

    /* JADX INFO: renamed from: OooOO0o, reason: collision with root package name */
    public RectF f274OooOO0o;
    public Path OooOOO;
    public RectF OooOOO0;
    public Paint.FontMetrics OooOOOO;
    public PointF OooOOOo;
    public PointF OooOOo;
    public PointF OooOOo0;
    public PointF OooOOoo;
    public TextPaint OooOo;
    public View OooOo0;
    public List<PointF> OooOo00;
    public int OooOo0O;
    public int OooOo0o;
    public Paint OooOoO;
    public Paint OooOoO0;

    /* JADX INFO: renamed from: OooOoOO, reason: collision with root package name */
    public b f275OooOoOO;

    /* JADX INFO: renamed from: OooOoo0, reason: collision with root package name */
    public ViewGroup f276OooOoo0;

    /* JADX INFO: compiled from: source.java */
    public class OooO00o extends ViewGroup {
        public OooO00o(OooOO0 oooOO0, Context context) {
            super(context);
        }

        @Override // android.view.ViewGroup, android.view.View
        public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
            if (getParent() instanceof RelativeLayout) {
                return;
            }
            super.dispatchRestoreInstanceState(sparseArray);
        }

        @Override // android.view.ViewGroup, android.view.View
        public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
            for (int i15 = 0; i15 < getChildCount(); i15++) {
                View childAt = getChildAt(i15);
                childAt.layout(0, 0, childAt.getMeasuredWidth(), childAt.getMeasuredHeight());
            }
        }

        @Override // android.view.View
        public void onMeasure(int i11, int i12) {
            View view = null;
            View view2 = null;
            for (int i13 = 0; i13 < getChildCount(); i13++) {
                View childAt = getChildAt(i13);
                if (childAt instanceof OooOO0) {
                    view2 = childAt;
                } else {
                    view = childAt;
                }
            }
            if (view == null) {
                super.onMeasure(i11, i12);
                return;
            }
            view.measure(i11, i12);
            if (view2 != null) {
                view2.measure(View.MeasureSpec.makeMeasureSpec(view.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(view.getMeasuredHeight(), 1073741824));
            }
            setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
        }
    }

    public OooOO0(Context context, AttributeSet attributeSet) {
        this(context, null, 0);
    }

    public OooOO0(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        OooO00o();
    }

    private float getBadgeCircleRadius() {
        float fWidth;
        float f11;
        if (this.f270OooO0o.isEmpty()) {
            return this.f269OooO0Oo;
        }
        if (this.f270OooO0o.length() != 1) {
            return this.OooOOO0.height() / 2.0f;
        }
        if (this.f274OooOO0o.height() > this.f274OooOO0o.width()) {
            fWidth = this.f274OooOO0o.height() / 2.0f;
            f11 = this.f269OooO0Oo;
        } else {
            fWidth = this.f274OooOO0o.width() / 2.0f;
            f11 = this.f269OooO0Oo;
        }
        return (f11 * 0.5f) + fWidth;
    }

    public a OooO00o(int i11) {
        this.f271OooO0o0 = i11;
        if (i11 < 0) {
            this.f270OooO0o = "";
        } else if (i11 > 99) {
            this.f270OooO0o = "99+";
        } else if (i11 > 0 && i11 <= 99) {
            this.f270OooO0o = String.valueOf(i11);
        } else if (i11 == 0) {
            this.f270OooO0o = null;
        }
        OooO0OO();
        invalidate();
        return this;
    }

    public a OooO00o(View view) {
        if (view == null) {
            throw new IllegalStateException("targetView can not be null");
        }
        if (getParent() != null) {
            ((ViewGroup) getParent()).removeView(this);
        }
        ViewParent parent = view.getParent();
        if (!(parent instanceof ViewGroup)) {
            throw new IllegalStateException("targetView must have a parent");
        }
        this.OooOo0 = view;
        if (parent instanceof OooO00o) {
            ((OooO00o) parent).addView(this);
        } else {
            ViewGroup viewGroup = (ViewGroup) parent;
            int iIndexOfChild = viewGroup.indexOfChild(view);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            viewGroup.removeView(view);
            OooO00o oooO00o = new OooO00o(this, getContext());
            if (viewGroup instanceof RelativeLayout) {
                oooO00o.setId(view.getId());
            }
            viewGroup.addView(oooO00o, iIndexOfChild, layoutParams);
            oooO00o.addView(view);
            oooO00o.addView(this);
        }
        return this;
    }

    public final void OooO00o() {
        setLayerType(1, null);
        this.f274OooOO0o = new RectF();
        this.OooOOO0 = new RectF();
        this.OooOOO = new Path();
        this.OooOOOo = new PointF();
        this.OooOOo0 = new PointF();
        this.OooOOo = new PointF();
        this.OooOOoo = new PointF();
        this.OooOo00 = new ArrayList();
        TextPaint textPaint = new TextPaint();
        this.OooOo = textPaint;
        textPaint.setAntiAlias(true);
        this.OooOo.setSubpixelText(true);
        this.OooOo.setFakeBoldText(true);
        this.OooOo.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        Paint paint = new Paint();
        this.OooOoO0 = paint;
        paint.setAntiAlias(true);
        this.OooOoO0.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.OooOoO = paint2;
        paint2.setAntiAlias(true);
        this.OooOoO.setStyle(Paint.Style.STROKE);
        this.OooO00o = -1552832;
        this.OooO0O0 = -1;
        this.OooO0OO = c.a(getContext(), 11.0f);
        this.f269OooO0Oo = c.a(getContext(), 5.0f);
        this.f271OooO0o0 = 0;
        this.f272OooO0oo = MaterialCardView.CHECKED_ICON_GRAVITY_TOP_END;
        this.f268OooO = c.a(getContext(), 1.0f);
        this.f273OooOO0 = c.a(getContext(), 1.0f);
        c.a(getContext(), 90.0f);
        this.OooO0oO = true;
        setTranslationZ(1000.0f);
    }

    public final void OooO00o(Canvas canvas, PointF pointF, float f11) {
        if (pointF.x == -1000.0f && pointF.y == -1000.0f) {
            return;
        }
        if (this.f270OooO0o.isEmpty() || this.f270OooO0o.length() == 1) {
            RectF rectF = this.OooOOO0;
            float f12 = pointF.x;
            float f13 = (int) f11;
            rectF.left = f12 - f13;
            float f14 = pointF.y;
            rectF.top = f14 - f13;
            rectF.right = f12 + f13;
            rectF.bottom = f13 + f14;
            canvas.drawCircle(f12, f14, f11, this.OooOoO0);
        } else {
            this.OooOOO0.left = pointF.x - ((this.f274OooOO0o.width() / 2.0f) + this.f269OooO0Oo);
            this.OooOOO0.top = pointF.y - ((this.f269OooO0Oo * 0.5f) + (this.f274OooOO0o.height() / 2.0f));
            this.OooOOO0.right = (this.f274OooOO0o.width() / 2.0f) + this.f269OooO0Oo + pointF.x;
            this.OooOOO0.bottom = (this.f269OooO0Oo * 0.5f) + (this.f274OooOO0o.height() / 2.0f) + pointF.y;
            float fHeight = this.OooOOO0.height() / 2.0f;
            canvas.drawRoundRect(this.OooOOO0, fHeight, fHeight, this.OooOoO0);
        }
        if (this.f270OooO0o.isEmpty()) {
            return;
        }
        String str = this.f270OooO0o;
        float f15 = pointF.x;
        RectF rectF2 = this.OooOOO0;
        float f16 = rectF2.bottom + rectF2.top;
        Paint.FontMetrics fontMetrics = this.OooOOOO;
        canvas.drawText(str, f15, ((f16 - fontMetrics.bottom) - fontMetrics.top) / 2.0f, this.OooOo);
    }

    public final void OooO00o(boolean z11) {
        int iA = c.a(getContext(), 1.0f);
        int iA2 = c.a(getContext(), 1.5f);
        int i11 = this.OooOO0O;
        if (i11 == 1) {
            iA = c.a(getContext(), 1.0f);
            iA2 = c.a(getContext(), -1.5f);
        } else if (i11 == 2) {
            iA = c.a(getContext(), -1.0f);
            iA2 = c.a(getContext(), -1.5f);
        } else if (i11 == 3) {
            iA = c.a(getContext(), -1.0f);
            iA2 = c.a(getContext(), 1.5f);
        } else if (i11 == 4) {
            iA = c.a(getContext(), 1.0f);
            iA2 = c.a(getContext(), 1.5f);
        }
        this.OooOoO0.setShadowLayer(z11 ? c.a(getContext(), 2.0f) : 0.0f, iA, iA2, 855638016);
    }

    public final void OooO0O0() {
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        PointF pointF = this.OooOOo;
        PointF pointF2 = this.OooOOOo;
        pointF.x = pointF2.x + iArr[0];
        pointF.y = pointF2.y + iArr[1];
    }

    public final void OooO0O0(View view) {
        if (view.getParent() instanceof View) {
            OooO0O0((View) view.getParent());
        } else if (view instanceof ViewGroup) {
            this.f276OooOoo0 = (ViewGroup) view;
        }
    }

    public final void OooO0OO() {
        RectF rectF = this.f274OooOO0o;
        rectF.left = 0.0f;
        rectF.top = 0.0f;
        if (TextUtils.isEmpty(this.f270OooO0o)) {
            RectF rectF2 = this.f274OooOO0o;
            rectF2.right = 0.0f;
            rectF2.bottom = 0.0f;
            return;
        }
        this.OooOo.setTextSize(this.OooO0OO);
        this.f274OooOO0o.right = this.OooOo.measureText(this.f270OooO0o);
        Paint.FontMetrics fontMetrics = this.OooOo.getFontMetrics();
        this.OooOOOO = fontMetrics;
        this.f274OooOO0o.bottom = fontMetrics.descent - fontMetrics.ascent;
    }

    public Drawable getBadgeBackground() {
        return null;
    }

    public int getBadgeBackgroundColor() {
        return this.OooO00o;
    }

    public int getBadgeGravity() {
        return this.f272OooO0oo;
    }

    public int getBadgeNumber() {
        return this.f271OooO0o0;
    }

    public String getBadgeText() {
        return this.f270OooO0o;
    }

    public int getBadgeTextColor() {
        return this.OooO0O0;
    }

    public PointF getDragCenter() {
        return null;
    }

    public View getTargetView() {
        return this.OooOo0;
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f276OooOoo0 == null) {
            View view = this.OooOo0;
            ViewGroup viewGroup = (ViewGroup) view.getRootView();
            this.f276OooOoo0 = viewGroup;
            if (viewGroup == null) {
                OooO0O0(view);
            }
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.f270OooO0o != null) {
            OooO00o(this.OooO0oO);
            this.OooOoO0.setColor(this.OooO00o);
            this.OooOoO.setColor(0);
            this.OooOoO.setStrokeWidth(0.0f);
            this.OooOo.setColor(this.OooO0O0);
            this.OooOo.setTextAlign(Paint.Align.CENTER);
            float badgeCircleRadius = getBadgeCircleRadius();
            PointF pointF = this.OooOOo;
            PointF pointF2 = this.OooOOo0;
            Math.sqrt(Math.pow(pointF.y - pointF2.y, 2.0d) + Math.pow(pointF.x - pointF2.x, 2.0d));
            float fHeight = this.f274OooOO0o.height() > this.f274OooOO0o.width() ? this.f274OooOO0o.height() : this.f274OooOO0o.width();
            switch (this.f272OooO0oo) {
                case 17:
                    PointF pointF3 = this.OooOOOo;
                    pointF3.x = this.OooOo0O / 2.0f;
                    pointF3.y = this.OooOo0o / 2.0f;
                    break;
                case 49:
                    PointF pointF4 = this.OooOOOo;
                    pointF4.x = this.OooOo0O / 2.0f;
                    pointF4.y = (this.f274OooOO0o.height() / 2.0f) + this.f273OooOO0 + this.f269OooO0Oo;
                    break;
                case 81:
                    PointF pointF5 = this.OooOOOo;
                    pointF5.x = this.OooOo0O / 2.0f;
                    pointF5.y = this.OooOo0o - ((this.f274OooOO0o.height() / 2.0f) + (this.f273OooOO0 + this.f269OooO0Oo));
                    break;
                case 8388627:
                    PointF pointF6 = this.OooOOOo;
                    pointF6.x = (fHeight / 2.0f) + this.f268OooO + this.f269OooO0Oo;
                    pointF6.y = this.OooOo0o / 2.0f;
                    break;
                case 8388629:
                    PointF pointF7 = this.OooOOOo;
                    pointF7.x = this.OooOo0O - ((fHeight / 2.0f) + (this.f268OooO + this.f269OooO0Oo));
                    pointF7.y = this.OooOo0o / 2.0f;
                    break;
                case MaterialCardView.CHECKED_ICON_GRAVITY_TOP_START /* 8388659 */:
                    PointF pointF8 = this.OooOOOo;
                    float f11 = this.f268OooO;
                    float f12 = this.f269OooO0Oo;
                    pointF8.x = (fHeight / 2.0f) + f11 + f12;
                    pointF8.y = (this.f274OooOO0o.height() / 2.0f) + this.f273OooOO0 + f12;
                    break;
                case MaterialCardView.CHECKED_ICON_GRAVITY_TOP_END /* 8388661 */:
                    PointF pointF9 = this.OooOOOo;
                    float f13 = this.OooOo0O;
                    float f14 = this.f268OooO;
                    float f15 = this.f269OooO0Oo;
                    pointF9.x = f13 - ((fHeight / 2.0f) + (f14 + f15));
                    pointF9.y = (this.f274OooOO0o.height() / 2.0f) + this.f273OooOO0 + f15;
                    break;
                case MaterialCardView.CHECKED_ICON_GRAVITY_BOTTOM_START /* 8388691 */:
                    PointF pointF10 = this.OooOOOo;
                    float f16 = this.f268OooO;
                    float f17 = this.f269OooO0Oo;
                    pointF10.x = (fHeight / 2.0f) + f16 + f17;
                    pointF10.y = this.OooOo0o - ((this.f274OooOO0o.height() / 2.0f) + (this.f273OooOO0 + f17));
                    break;
                case MaterialCardView.CHECKED_ICON_GRAVITY_BOTTOM_END /* 8388693 */:
                    PointF pointF11 = this.OooOOOo;
                    float f18 = this.OooOo0O;
                    float f19 = this.f268OooO;
                    float f21 = this.f269OooO0Oo;
                    pointF11.x = f18 - ((fHeight / 2.0f) + (f19 + f21));
                    pointF11.y = this.OooOo0o - ((this.f274OooOO0o.height() / 2.0f) + (this.f273OooOO0 + f21));
                    break;
            }
            OooO0O0();
            OooO00o(canvas, this.OooOOOo, badgeCircleRadius);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        this.OooOo0O = i11;
        this.OooOo0o = i12;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0013  */
    /* JADX WARN: Code duplicated, block: B:14:0x001b  */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            motionEvent.getX();
            motionEvent.getY();
        } else if (actionMasked == 1 || actionMasked == 3) {
            motionEvent.getPointerId(motionEvent.getActionIndex());
        } else if (actionMasked == 5) {
            motionEvent.getX();
            motionEvent.getY();
        } else if (actionMasked == 6) {
            motionEvent.getPointerId(motionEvent.getActionIndex());
        }
        return super.onTouchEvent(motionEvent);
    }
}
