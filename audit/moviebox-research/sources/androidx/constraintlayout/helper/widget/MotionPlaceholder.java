package androidx.constraintlayout.helper.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.d;
import androidx.constraintlayout.core.widgets.h;
import androidx.constraintlayout.core.widgets.i;
import androidx.constraintlayout.widget.VirtualLayout;
import v2.a;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class MotionPlaceholder extends VirtualLayout {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public h f6759m;

    public MotionPlaceholder(Context context) {
        super(context);
    }

    public MotionPlaceholder(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MotionPlaceholder(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }

    public MotionPlaceholder(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11);
    }

    @Override // androidx.constraintlayout.widget.VirtualLayout, androidx.constraintlayout.widget.ConstraintHelper
    public void k(AttributeSet attributeSet) {
        super.k(attributeSet);
        this.f7270d = new h();
        validateParams();
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    @SuppressLint({"WrongCall"})
    public void onMeasure(int i11, int i12) {
        onMeasure(this.f6759m, i11, i12);
    }

    @Override // androidx.constraintlayout.widget.VirtualLayout
    public void onMeasure(i iVar, int i11, int i12) {
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i11);
        int mode2 = View.MeasureSpec.getMode(i12);
        int size2 = View.MeasureSpec.getSize(i12);
        if (iVar == null) {
            setMeasuredDimension(0, 0);
        } else {
            iVar.G1(mode, size, mode2, size2);
            setMeasuredDimension(iVar.B1(), iVar.A1());
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void updatePreLayout(d dVar, a aVar, SparseArray<ConstraintWidget> sparseArray) {
    }
}
