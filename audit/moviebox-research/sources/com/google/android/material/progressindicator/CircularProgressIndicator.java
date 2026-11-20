package com.google.android.material.progressindicator;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class CircularProgressIndicator extends BaseProgressIndicator<e> {
    public static final int DEF_STYLE_RES = R$style.Widget_MaterialComponents_CircularProgressIndicator;
    public static final int INDICATOR_DIRECTION_CLOCKWISE = 0;
    public static final int INDICATOR_DIRECTION_COUNTERCLOCKWISE = 1;

    public CircularProgressIndicator(@NonNull Context context) {
        this(context, null);
    }

    public CircularProgressIndicator(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.circularProgressIndicatorStyle);
    }

    public CircularProgressIndicator(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11, DEF_STYLE_RES);
        r();
    }

    public int getIndicatorDirection() {
        return ((e) this.f37235a).f37280j;
    }

    public int getIndicatorInset() {
        return ((e) this.f37235a).f37279i;
    }

    public int getIndicatorSize() {
        return ((e) this.f37235a).f37278h;
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public e i(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        return new e(context, attributeSet);
    }

    public final void r() {
        c cVar = new c((e) this.f37235a);
        setIndeterminateDrawable(j.t(getContext(), (e) this.f37235a, cVar));
        setProgressDrawable(f.v(getContext(), (e) this.f37235a, cVar));
    }

    public void setIndicatorDirection(int i11) {
        ((e) this.f37235a).f37280j = i11;
        invalidate();
    }

    public void setIndicatorInset(int i11) {
        S s11 = this.f37235a;
        if (((e) s11).f37279i != i11) {
            ((e) s11).f37279i = i11;
            invalidate();
        }
    }

    public void setIndicatorSize(int i11) {
        int iMax = Math.max(i11, getTrackThickness() * 2);
        S s11 = this.f37235a;
        if (((e) s11).f37278h != iMax) {
            ((e) s11).f37278h = iMax;
            ((e) s11).e();
            requestLayout();
            invalidate();
        }
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public void setTrackThickness(int i11) {
        super.setTrackThickness(i11);
        ((e) this.f37235a).e();
    }
}
