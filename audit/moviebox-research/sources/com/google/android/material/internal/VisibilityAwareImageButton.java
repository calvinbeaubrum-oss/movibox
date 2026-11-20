package com.google.android.material.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
@SuppressLint({"AppCompatCustomView"})
public class VisibilityAwareImageButton extends ImageButton {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f36971a;

    public VisibilityAwareImageButton(Context context) {
        this(context, null);
    }

    public VisibilityAwareImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VisibilityAwareImageButton(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f36971a = getVisibility();
    }

    public final int getUserSetVisibility() {
        return this.f36971a;
    }

    public final void internalSetVisibility(int i11, boolean z11) {
        super.setVisibility(i11);
        if (z11) {
            this.f36971a = i11;
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void setVisibility(int i11) {
        internalSetVisibility(i11, true);
    }
}
