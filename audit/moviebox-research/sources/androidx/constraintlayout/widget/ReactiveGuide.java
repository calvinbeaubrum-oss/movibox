package androidx.constraintlayout.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class ReactiveGuide extends View implements d.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7345a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f7346b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f7347c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f7348d;

    public ReactiveGuide(Context context) {
        super(context);
        this.f7345a = -1;
        this.f7346b = false;
        this.f7347c = 0;
        this.f7348d = true;
        super.setVisibility(8);
        b(null);
    }

    public ReactiveGuide(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7345a = -1;
        this.f7346b = false;
        this.f7347c = 0;
        this.f7348d = true;
        super.setVisibility(8);
        b(attributeSet);
    }

    public ReactiveGuide(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f7345a = -1;
        this.f7346b = false;
        this.f7347c = 0;
        this.f7348d = true;
        super.setVisibility(8);
        b(attributeSet);
    }

    public ReactiveGuide(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11);
        this.f7345a = -1;
        this.f7346b = false;
        this.f7347c = 0;
        this.f7348d = true;
        super.setVisibility(8);
        b(attributeSet);
    }

    public final void a(int i11, int i12, MotionLayout motionLayout, int i13) {
        b constraintSet = motionLayout.getConstraintSet(i13);
        constraintSet.T(i12, i11);
        motionLayout.updateState(i13, constraintSet);
    }

    public final void b(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.ConstraintLayout_ReactiveGuide);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i11);
                if (index == R$styleable.ConstraintLayout_ReactiveGuide_reactiveGuide_valueId) {
                    this.f7345a = typedArrayObtainStyledAttributes.getResourceId(index, this.f7345a);
                } else if (index == R$styleable.ConstraintLayout_ReactiveGuide_reactiveGuide_animateChange) {
                    this.f7346b = typedArrayObtainStyledAttributes.getBoolean(index, this.f7346b);
                } else if (index == R$styleable.ConstraintLayout_ReactiveGuide_reactiveGuide_applyToConstraintSet) {
                    this.f7347c = typedArrayObtainStyledAttributes.getResourceId(index, this.f7347c);
                } else if (index == R$styleable.ConstraintLayout_ReactiveGuide_reactiveGuide_applyToAllConstraintSets) {
                    this.f7348d = typedArrayObtainStyledAttributes.getBoolean(index, this.f7348d);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        if (this.f7345a != -1) {
            ConstraintLayout.getSharedValues().a(this.f7345a, this);
        }
    }

    @Override // android.view.View
    @SuppressLint({"MissingSuperCall"})
    public void draw(Canvas canvas) {
    }

    public int getApplyToConstraintSetId() {
        return this.f7347c;
    }

    public int getAttributeId() {
        return this.f7345a;
    }

    public boolean isAnimatingChange() {
        return this.f7346b;
    }

    @Override // android.view.View
    public void onMeasure(int i11, int i12) {
        setMeasuredDimension(0, 0);
    }

    public void onNewValue(int i11, int i12, int i13) {
        setGuidelineBegin(i12);
        int id2 = getId();
        if (id2 > 0 && (getParent() instanceof MotionLayout)) {
            MotionLayout motionLayout = (MotionLayout) getParent();
            int currentState = motionLayout.getCurrentState();
            int i14 = this.f7347c;
            if (i14 != 0) {
                currentState = i14;
            }
            int i15 = 0;
            if (!this.f7346b) {
                if (!this.f7348d) {
                    a(i12, id2, motionLayout, currentState);
                    return;
                }
                int[] constraintSetIds = motionLayout.getConstraintSetIds();
                while (i15 < constraintSetIds.length) {
                    a(i12, id2, motionLayout, constraintSetIds[i15]);
                    i15++;
                }
                return;
            }
            if (this.f7348d) {
                int[] constraintSetIds2 = motionLayout.getConstraintSetIds();
                while (i15 < constraintSetIds2.length) {
                    int i16 = constraintSetIds2[i15];
                    if (i16 != currentState) {
                        a(i12, id2, motionLayout, i16);
                    }
                    i15++;
                }
            }
            b bVarCloneConstraintSet = motionLayout.cloneConstraintSet(currentState);
            bVarCloneConstraintSet.T(id2, i12);
            motionLayout.updateStateAnimate(currentState, bVarCloneConstraintSet, 1000);
        }
    }

    public void setAnimateChange(boolean z11) {
        this.f7346b = z11;
    }

    public void setApplyToConstraintSetId(int i11) {
        this.f7347c = i11;
    }

    public void setAttributeId(int i11) {
        d sharedValues = ConstraintLayout.getSharedValues();
        int i12 = this.f7345a;
        if (i12 != -1) {
            sharedValues.b(i12, this);
        }
        this.f7345a = i11;
        if (i11 != -1) {
            sharedValues.a(i11, this);
        }
    }

    public void setGuidelineBegin(int i11) {
        ConstraintLayout.b bVar = (ConstraintLayout.b) getLayoutParams();
        bVar.f7277a = i11;
        setLayoutParams(bVar);
    }

    public void setGuidelineEnd(int i11) {
        ConstraintLayout.b bVar = (ConstraintLayout.b) getLayoutParams();
        bVar.f7279b = i11;
        setLayoutParams(bVar);
    }

    public void setGuidelinePercent(float f11) {
        ConstraintLayout.b bVar = (ConstraintLayout.b) getLayoutParams();
        bVar.f7281c = f11;
        setLayoutParams(bVar);
    }

    @Override // android.view.View
    public void setVisibility(int i11) {
    }
}
