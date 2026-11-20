package com.google.android.material.progressindicator;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class LinearProgressIndicator extends BaseProgressIndicator<n> {
    public static final int DEF_STYLE_RES = R$style.Widget_MaterialComponents_LinearProgressIndicator;
    public static final int INDETERMINATE_ANIMATION_TYPE_CONTIGUOUS = 0;
    public static final int INDETERMINATE_ANIMATION_TYPE_DISJOINT = 1;
    public static final int INDICATOR_DIRECTION_END_TO_START = 3;
    public static final int INDICATOR_DIRECTION_LEFT_TO_RIGHT = 0;
    public static final int INDICATOR_DIRECTION_RIGHT_TO_LEFT = 1;
    public static final int INDICATOR_DIRECTION_START_TO_END = 2;

    public LinearProgressIndicator(@NonNull Context context) {
        this(context, null);
    }

    public LinearProgressIndicator(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.linearProgressIndicatorStyle);
    }

    public LinearProgressIndicator(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11, DEF_STYLE_RES);
        r();
    }

    private void r() {
        k kVar = new k((n) this.f37235a);
        setIndeterminateDrawable(j.u(getContext(), (n) this.f37235a, kVar));
        setProgressDrawable(f.w(getContext(), (n) this.f37235a, kVar));
    }

    public int getIndeterminateAnimationType() {
        return ((n) this.f37235a).f37340h;
    }

    public int getIndicatorDirection() {
        return ((n) this.f37235a).f37341i;
    }

    public int getTrackStopIndicatorSize() {
        return ((n) this.f37235a).f37343k;
    }

    @Override // android.view.View
    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        super.onLayout(z11, i11, i12, i13, i14);
        S s11 = this.f37235a;
        n nVar = (n) s11;
        boolean z12 = true;
        if (((n) s11).f37341i != 1 && ((ViewCompat.getLayoutDirection(this) != 1 || ((n) this.f37235a).f37341i != 2) && (ViewCompat.getLayoutDirection(this) != 0 || ((n) this.f37235a).f37341i != 3))) {
            z12 = false;
        }
        nVar.f37342j = z12;
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        int paddingLeft = i11 - (getPaddingLeft() + getPaddingRight());
        int paddingTop = i12 - (getPaddingTop() + getPaddingBottom());
        j<n> indeterminateDrawable = getIndeterminateDrawable();
        if (indeterminateDrawable != null) {
            indeterminateDrawable.setBounds(0, 0, paddingLeft, paddingTop);
        }
        f<n> progressDrawable = getProgressDrawable();
        if (progressDrawable != null) {
            progressDrawable.setBounds(0, 0, paddingLeft, paddingTop);
        }
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public n i(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        return new n(context, attributeSet);
    }

    public void setIndeterminateAnimationType(int i11) {
        if (((n) this.f37235a).f37340h == i11) {
            return;
        }
        if (p() && isIndeterminate()) {
            throw new IllegalStateException("Cannot change indeterminate animation type while the progress indicator is show in indeterminate mode.");
        }
        S s11 = this.f37235a;
        ((n) s11).f37340h = i11;
        ((n) s11).e();
        if (i11 == 0) {
            getIndeterminateDrawable().y(new l((n) this.f37235a));
        } else {
            getIndeterminateDrawable().y(new m(getContext(), (n) this.f37235a));
        }
        invalidate();
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public void setIndicatorColor(@NonNull int... iArr) {
        super.setIndicatorColor(iArr);
        ((n) this.f37235a).e();
    }

    public void setIndicatorDirection(int i11) {
        S s11 = this.f37235a;
        ((n) s11).f37341i = i11;
        n nVar = (n) s11;
        boolean z11 = true;
        if (i11 != 1 && ((ViewCompat.getLayoutDirection(this) != 1 || ((n) this.f37235a).f37341i != 2) && (ViewCompat.getLayoutDirection(this) != 0 || i11 != 3))) {
            z11 = false;
        }
        nVar.f37342j = z11;
        invalidate();
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public void setProgressCompat(int i11, boolean z11) {
        S s11 = this.f37235a;
        if (s11 != 0 && ((n) s11).f37340h == 0 && isIndeterminate()) {
            return;
        }
        super.setProgressCompat(i11, z11);
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public void setTrackCornerRadius(int i11) {
        super.setTrackCornerRadius(i11);
        ((n) this.f37235a).e();
        invalidate();
    }

    public void setTrackStopIndicatorSize(int i11) {
        S s11 = this.f37235a;
        if (((n) s11).f37343k != i11) {
            ((n) s11).f37343k = Math.min(i11, ((n) s11).f37251a);
            ((n) this.f37235a).e();
            invalidate();
        }
    }
}
