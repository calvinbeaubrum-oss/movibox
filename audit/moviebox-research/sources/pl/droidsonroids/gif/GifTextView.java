package pl.droidsonroids.gif;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class GifTextView extends TextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d.b f73909a;

    public GifTextView(Context context) {
        super(context);
    }

    public GifTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c(attributeSet, 0, 0);
    }

    public GifTextView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        c(attributeSet, i11, 0);
    }

    @RequiresApi(21)
    public GifTextView(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        c(attributeSet, i11, i12);
    }

    public static void d(Drawable[] drawableArr, boolean z11) {
        for (Drawable drawable : drawableArr) {
            if (drawable != null) {
                drawable.setVisible(z11, false);
            }
        }
    }

    private void setCompoundDrawablesVisible(boolean z11) {
        d(getCompoundDrawables(), z11);
        d(getCompoundDrawablesRelative(), z11);
    }

    public final void a() {
        if (this.f73909a.f73925b < 0) {
            return;
        }
        for (Drawable drawable : getCompoundDrawables()) {
            d.a(this.f73909a.f73925b, drawable);
        }
        for (Drawable drawable2 : getCompoundDrawablesRelative()) {
            d.a(this.f73909a.f73925b, drawable2);
        }
        d.a(this.f73909a.f73925b, getBackground());
    }

    public final Drawable b(int i11) {
        if (i11 == 0) {
            return null;
        }
        Resources resources = getResources();
        String resourceTypeName = resources.getResourceTypeName(i11);
        if (!isInEditMode() && d.f73921a.contains(resourceTypeName)) {
            try {
                return new GifDrawable(resources, i11);
            } catch (Resources.NotFoundException | IOException unused) {
            }
        }
        return resources.getDrawable(i11, getContext().getTheme());
    }

    public final void c(AttributeSet attributeSet, int i11, int i12) {
        if (attributeSet != null) {
            Drawable drawableB = b(attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "drawableLeft", 0));
            Drawable drawableB2 = b(attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "drawableTop", 0));
            Drawable drawableB3 = b(attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "drawableRight", 0));
            Drawable drawableB4 = b(attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "drawableBottom", 0));
            Drawable drawableB5 = b(attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "drawableStart", 0));
            Drawable drawableB6 = b(attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "drawableEnd", 0));
            if (getLayoutDirection() == 0) {
                if (drawableB5 != null) {
                    drawableB = drawableB5;
                }
                if (drawableB6 == null) {
                    drawableB6 = drawableB3;
                }
            } else {
                if (drawableB5 != null) {
                    drawableB3 = drawableB5;
                }
                if (drawableB6 == null) {
                    drawableB6 = drawableB;
                }
                drawableB = drawableB3;
            }
            setCompoundDrawablesRelativeWithIntrinsicBounds(drawableB, drawableB2, drawableB6, drawableB4);
            setBackground(b(attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "background", 0)));
            this.f73909a = new d.b(this, attributeSet, i11, i12);
            a();
        }
        this.f73909a = new d.b();
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        setCompoundDrawablesVisible(true);
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setCompoundDrawablesVisible(false);
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof GifViewSavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        GifViewSavedState gifViewSavedState = (GifViewSavedState) parcelable;
        super.onRestoreInstanceState(gifViewSavedState.getSuperState());
        Drawable[] compoundDrawables = getCompoundDrawables();
        gifViewSavedState.a(compoundDrawables[0], 0);
        gifViewSavedState.a(compoundDrawables[1], 1);
        gifViewSavedState.a(compoundDrawables[2], 2);
        gifViewSavedState.a(compoundDrawables[3], 3);
        Drawable[] compoundDrawablesRelative = getCompoundDrawablesRelative();
        gifViewSavedState.a(compoundDrawablesRelative[0], 4);
        gifViewSavedState.a(compoundDrawablesRelative[2], 5);
        gifViewSavedState.a(getBackground(), 6);
    }

    @Override // android.widget.TextView, android.view.View
    public Parcelable onSaveInstanceState() {
        Drawable[] drawableArr = new Drawable[7];
        if (this.f73909a.f73924a) {
            Drawable[] compoundDrawables = getCompoundDrawables();
            System.arraycopy(compoundDrawables, 0, drawableArr, 0, compoundDrawables.length);
            Drawable[] compoundDrawablesRelative = getCompoundDrawablesRelative();
            drawableArr[4] = compoundDrawablesRelative[0];
            drawableArr[5] = compoundDrawablesRelative[2];
            drawableArr[6] = getBackground();
        }
        return new GifViewSavedState(super.onSaveInstanceState(), drawableArr);
    }

    @Override // android.view.View
    public void setBackgroundResource(int i11) {
        setBackground(b(i11));
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i11, int i12, int i13, int i14) {
        setCompoundDrawablesRelativeWithIntrinsicBounds(b(i11), b(i12), b(i13), b(i14));
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i11, int i12, int i13, int i14) {
        setCompoundDrawablesWithIntrinsicBounds(b(i11), b(i12), b(i13), b(i14));
    }

    public void setFreezesAnimation(boolean z11) {
        this.f73909a.f73924a = z11;
    }
}
