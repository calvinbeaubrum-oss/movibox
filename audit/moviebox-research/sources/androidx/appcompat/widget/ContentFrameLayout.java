package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class ContentFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TypedValue f1396a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TypedValue f1397b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TypedValue f1398c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TypedValue f1399d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TypedValue f1400f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TypedValue f1401g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Rect f1402h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public a f1403i;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public interface a {
        void a();

        void onDetachedFromWindow();
    }

    public ContentFrameLayout(@NonNull Context context) {
        this(context, null);
    }

    public ContentFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ContentFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f1402h = new Rect();
    }

    public void dispatchFitSystemWindows(Rect rect) {
        fitSystemWindows(rect);
    }

    public TypedValue getFixedHeightMajor() {
        if (this.f1400f == null) {
            this.f1400f = new TypedValue();
        }
        return this.f1400f;
    }

    public TypedValue getFixedHeightMinor() {
        if (this.f1401g == null) {
            this.f1401g = new TypedValue();
        }
        return this.f1401g;
    }

    public TypedValue getFixedWidthMajor() {
        if (this.f1398c == null) {
            this.f1398c = new TypedValue();
        }
        return this.f1398c;
    }

    public TypedValue getFixedWidthMinor() {
        if (this.f1399d == null) {
            this.f1399d = new TypedValue();
        }
        return this.f1399d;
    }

    public TypedValue getMinWidthMajor() {
        if (this.f1396a == null) {
            this.f1396a = new TypedValue();
        }
        return this.f1396a;
    }

    public TypedValue getMinWidthMinor() {
        if (this.f1397b == null) {
            this.f1397b = new TypedValue();
        }
        return this.f1397b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        a aVar = this.f1403i;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a aVar = this.f1403i;
        if (aVar != null) {
            aVar.onDetachedFromWindow();
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x004a  */
    /* JADX WARN: Code duplicated, block: B:22:0x0060  */
    /* JADX WARN: Code duplicated, block: B:37:0x0086  */
    /* JADX WARN: Code duplicated, block: B:54:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:56:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:57:0x00db  */
    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i11, int i12) {
        boolean z11;
        int i13;
        int i14;
        float fraction;
        int i15;
        int i16;
        float fraction2;
        int i17;
        int i18;
        float fraction3;
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        boolean z12 = true;
        boolean z13 = displayMetrics.widthPixels < displayMetrics.heightPixels;
        int mode = View.MeasureSpec.getMode(i11);
        int mode2 = View.MeasureSpec.getMode(i12);
        if (mode != Integer.MIN_VALUE) {
            z11 = false;
        } else {
            TypedValue typedValue = z13 ? this.f1399d : this.f1398c;
            if (typedValue == null || (i17 = typedValue.type) == 0) {
                z11 = false;
            } else {
                if (i17 == 5) {
                    fraction3 = typedValue.getDimension(displayMetrics);
                } else {
                    if (i17 == 6) {
                        int i19 = displayMetrics.widthPixels;
                        fraction3 = typedValue.getFraction(i19, i19);
                    } else {
                        i18 = 0;
                    }
                    if (i18 > 0) {
                        Rect rect = this.f1402h;
                        i11 = View.MeasureSpec.makeMeasureSpec(Math.min(i18 - (rect.left + rect.right), View.MeasureSpec.getSize(i11)), 1073741824);
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                }
                i18 = (int) fraction3;
                if (i18 > 0) {
                    Rect rect2 = this.f1402h;
                    i11 = View.MeasureSpec.makeMeasureSpec(Math.min(i18 - (rect2.left + rect2.right), View.MeasureSpec.getSize(i11)), 1073741824);
                    z11 = true;
                } else {
                    z11 = false;
                }
            }
        }
        if (mode2 == Integer.MIN_VALUE) {
            TypedValue typedValue2 = z13 ? this.f1400f : this.f1401g;
            if (typedValue2 != null && (i15 = typedValue2.type) != 0) {
                if (i15 == 5) {
                    fraction2 = typedValue2.getDimension(displayMetrics);
                } else {
                    if (i15 == 6) {
                        int i21 = displayMetrics.heightPixels;
                        fraction2 = typedValue2.getFraction(i21, i21);
                    } else {
                        i16 = 0;
                    }
                    if (i16 > 0) {
                        Rect rect3 = this.f1402h;
                        i12 = View.MeasureSpec.makeMeasureSpec(Math.min(i16 - (rect3.top + rect3.bottom), View.MeasureSpec.getSize(i12)), 1073741824);
                    }
                }
                i16 = (int) fraction2;
                if (i16 > 0) {
                    Rect rect4 = this.f1402h;
                    i12 = View.MeasureSpec.makeMeasureSpec(Math.min(i16 - (rect4.top + rect4.bottom), View.MeasureSpec.getSize(i12)), 1073741824);
                }
            }
        }
        super.onMeasure(i11, i12);
        int measuredWidth = getMeasuredWidth();
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
        if (z11 || mode != Integer.MIN_VALUE) {
            z12 = false;
        } else {
            TypedValue typedValue3 = z13 ? this.f1397b : this.f1396a;
            if (typedValue3 == null || (i13 = typedValue3.type) == 0) {
                z12 = false;
            } else {
                if (i13 == 5) {
                    fraction = typedValue3.getDimension(displayMetrics);
                } else {
                    if (i13 == 6) {
                        int i22 = displayMetrics.widthPixels;
                        fraction = typedValue3.getFraction(i22, i22);
                    } else {
                        i14 = 0;
                    }
                    if (i14 > 0) {
                        Rect rect5 = this.f1402h;
                        i14 -= rect5.left + rect5.right;
                    }
                    if (measuredWidth < i14) {
                        iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i14, 1073741824);
                    } else {
                        z12 = false;
                    }
                }
                i14 = (int) fraction;
                if (i14 > 0) {
                    Rect rect6 = this.f1402h;
                    i14 -= rect6.left + rect6.right;
                }
                if (measuredWidth < i14) {
                    iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i14, 1073741824);
                } else {
                    z12 = false;
                }
            }
        }
        if (z12) {
            super.onMeasure(iMakeMeasureSpec, i12);
        }
    }

    public void setAttachListener(a aVar) {
        this.f1403i = aVar;
    }

    public void setDecorPadding(int i11, int i12, int i13, int i14) {
        this.f1402h.set(i11, i12, i13, i14);
        if (isLaidOut()) {
            requestLayout();
        }
    }
}
