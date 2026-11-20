package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R$styleable;
import java.util.HashMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class MotionHelper extends ConstraintHelper implements MotionLayout.h {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f6760k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f6761l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f6762m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public View[] f6763n;

    public MotionHelper(Context context) {
        super(context);
        this.f6760k = false;
        this.f6761l = false;
    }

    public MotionHelper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6760k = false;
        this.f6761l = false;
        k(attributeSet);
    }

    public MotionHelper(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f6760k = false;
        this.f6761l = false;
        k(attributeSet);
    }

    public float getProgress() {
        return this.f6762m;
    }

    public boolean isDecorator() {
        return false;
    }

    public boolean isUseOnHide() {
        return this.f6761l;
    }

    public boolean isUsedOnShow() {
        return this.f6760k;
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void k(AttributeSet attributeSet) {
        super.k(attributeSet);
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.MotionHelper);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i11);
                if (index == R$styleable.MotionHelper_onShow) {
                    this.f6760k = typedArrayObtainStyledAttributes.getBoolean(index, this.f6760k);
                } else if (index == R$styleable.MotionHelper_onHide) {
                    this.f6761l = typedArrayObtainStyledAttributes.getBoolean(index, this.f6761l);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public void onFinishedMotionScene(MotionLayout motionLayout) {
    }

    public void onPostDraw(Canvas canvas) {
    }

    public void onPreDraw(Canvas canvas) {
    }

    public void onPreSetup(MotionLayout motionLayout, HashMap<View, m> map) {
    }

    public void onTransitionChange(MotionLayout motionLayout, int i11, int i12, float f11) {
    }

    public void onTransitionCompleted(MotionLayout motionLayout, int i11) {
    }

    @Override // androidx.constraintlayout.motion.widget.MotionLayout.h
    public void onTransitionStarted(MotionLayout motionLayout, int i11, int i12) {
    }

    @Override // androidx.constraintlayout.motion.widget.MotionLayout.h
    public void onTransitionTrigger(MotionLayout motionLayout, int i11, boolean z11, float f11) {
    }

    public void setProgress(float f11) {
        this.f6762m = f11;
        int i11 = 0;
        if (this.f7268b > 0) {
            this.f6763n = j((ConstraintLayout) getParent());
            while (i11 < this.f7268b) {
                setProgress(this.f6763n[i11], f11);
                i11++;
            }
            return;
        }
        ViewGroup viewGroup = (ViewGroup) getParent();
        int childCount = viewGroup.getChildCount();
        while (i11 < childCount) {
            View childAt = viewGroup.getChildAt(i11);
            if (!(childAt instanceof MotionHelper)) {
                setProgress(childAt, f11);
            }
            i11++;
        }
    }

    public void setProgress(View view, float f11) {
    }
}
