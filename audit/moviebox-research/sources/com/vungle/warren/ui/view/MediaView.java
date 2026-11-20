package com.vungle.warren.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class MediaView extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ImageView f62494a;

    public MediaView(Context context) {
        super(context);
        a(context);
    }

    public MediaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public MediaView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        a(context);
    }

    public final void a(@NonNull Context context) {
        this.f62494a = new ImageView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        this.f62494a.setLayoutParams(layoutParams);
        this.f62494a.setAdjustViewBounds(true);
        addView(this.f62494a);
        requestLayout();
    }

    public void destroy() {
        ImageView imageView = this.f62494a;
        if (imageView != null) {
            imageView.setImageDrawable(null);
            if (this.f62494a.getParent() != null) {
                ((ViewGroup) this.f62494a.getParent()).removeView(this.f62494a);
            }
            this.f62494a = null;
        }
    }

    public ImageView getMainImage() {
        if (this.f62494a == null) {
            a(getContext());
        }
        return this.f62494a;
    }
}
