package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R$id;
import androidx.appcompat.R$styleable;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class ButtonBarLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f1393a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f1394b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f1395c;

    public ButtonBarLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1395c = -1;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ButtonBarLayout);
        ViewCompat.saveAttributeDataForStyleable(this, context, R$styleable.ButtonBarLayout, attributeSet, typedArrayObtainStyledAttributes, 0, 0);
        this.f1393a = typedArrayObtainStyledAttributes.getBoolean(R$styleable.ButtonBarLayout_allowStacking, true);
        typedArrayObtainStyledAttributes.recycle();
        if (getOrientation() == 1) {
            setStacked(this.f1393a);
        }
    }

    private void setStacked(boolean z11) {
        if (this.f1394b != z11) {
            if (!z11 || this.f1393a) {
                this.f1394b = z11;
                setOrientation(z11 ? 1 : 0);
                setGravity(z11 ? GravityCompat.END : 80);
                View viewFindViewById = findViewById(R$id.spacer);
                if (viewFindViewById != null) {
                    viewFindViewById.setVisibility(z11 ? 8 : 4);
                }
                for (int childCount = getChildCount() - 2; childCount >= 0; childCount--) {
                    bringChildToFront(getChildAt(childCount));
                }
            }
        }
    }

    public final int a(int i11) {
        int childCount = getChildCount();
        while (i11 < childCount) {
            if (getChildAt(i11).getVisibility() == 0) {
                return i11;
            }
            i11++;
        }
        return -1;
    }

    public final boolean b() {
        return this.f1394b;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0058  */
    /* JADX WARN: Code duplicated, block: B:29:0x0077  */
    /* JADX WARN: Code duplicated, block: B:31:0x007e  */
    /* JADX WARN: Code duplicated, block: B:33:0x0099  */
    /* JADX WARN: Code duplicated, block: B:36:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:38:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:40:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:41:? A[RETURN, SYNTHETIC] */
    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i11, int i12) {
        int iMakeMeasureSpec;
        boolean z11;
        int iA;
        int paddingTop;
        int iA2;
        int size = View.MeasureSpec.getSize(i11);
        int paddingBottom = 0;
        if (this.f1393a) {
            if (size > this.f1395c && b()) {
                setStacked(false);
            }
            this.f1395c = size;
        }
        if (b() || View.MeasureSpec.getMode(i11) != 1073741824) {
            iMakeMeasureSpec = i11;
            z11 = false;
        } else {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE);
            z11 = true;
        }
        super.onMeasure(iMakeMeasureSpec, i12);
        if (!this.f1393a || b() || (getMeasuredWidthAndState() & ViewCompat.MEASURED_STATE_MASK) != 16777216) {
            if (z11) {
            }
            iA = a(0);
            if (iA >= 0) {
                View childAt = getChildAt(iA);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
                paddingTop = getPaddingTop() + childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
                if (b()) {
                    iA2 = a(iA + 1);
                    if (iA2 >= 0) {
                        paddingTop += getChildAt(iA2).getPaddingTop() + ((int) (getResources().getDisplayMetrics().density * 16.0f));
                    }
                    paddingBottom = paddingTop;
                } else {
                    paddingBottom = paddingTop + getPaddingBottom();
                }
            }
            if (ViewCompat.getMinimumHeight(this) != paddingBottom) {
                setMinimumHeight(paddingBottom);
                if (i12 == 0) {
                    super.onMeasure(i11, i12);
                }
            }
        }
        setStacked(true);
        super.onMeasure(i11, i12);
        iA = a(0);
        if (iA >= 0) {
            View childAt2 = getChildAt(iA);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) childAt2.getLayoutParams();
            paddingTop = getPaddingTop() + childAt2.getMeasuredHeight() + layoutParams2.topMargin + layoutParams2.bottomMargin;
            if (b()) {
                iA2 = a(iA + 1);
                if (iA2 >= 0) {
                    paddingTop += getChildAt(iA2).getPaddingTop() + ((int) (getResources().getDisplayMetrics().density * 16.0f));
                }
                paddingBottom = paddingTop;
            } else {
                paddingBottom = paddingTop + getPaddingBottom();
            }
        }
        if (ViewCompat.getMinimumHeight(this) != paddingBottom) {
            setMinimumHeight(paddingBottom);
            if (i12 == 0) {
                super.onMeasure(i11, i12);
            }
        }
    }

    public void setAllowStacking(boolean z11) {
        if (this.f1393a != z11) {
            this.f1393a = z11;
            if (!z11 && b()) {
                setStacked(false);
            }
            requestLayout();
        }
    }
}
