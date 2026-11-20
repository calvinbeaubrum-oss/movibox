package com.google.android.material.textview;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import com.google.android.material.R$attr;
import com.google.android.material.R$styleable;
import vi.b;
import vi.d;
import zi.a;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class MaterialTextView extends AppCompatTextView {
    public MaterialTextView(@NonNull Context context) {
        this(context, null);
    }

    public MaterialTextView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textViewStyle);
    }

    public MaterialTextView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(a.c(context, attributeSet, i11, 0), attributeSet, i11);
        d(attributeSet, i11, 0);
    }

    @Deprecated
    public MaterialTextView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11, int i12) {
        super(a.c(context, attributeSet, i11, i12), attributeSet, i11);
        d(attributeSet, i11, i12);
    }

    public static boolean b(Context context) {
        return b.b(context, R$attr.textAppearanceLineHeightEnabled, true);
    }

    public static int c(@NonNull Resources.Theme theme, @Nullable AttributeSet attributeSet, int i11, int i12) {
        TypedArray typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, R$styleable.MaterialTextView, i11, i12);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(R$styleable.MaterialTextView_android_textAppearance, -1);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId;
    }

    public static int e(@NonNull Context context, @NonNull TypedArray typedArray, @NonNull int... iArr) {
        int iD = -1;
        for (int i11 = 0; i11 < iArr.length && iD < 0; i11++) {
            iD = d.d(context, typedArray, iArr[i11], -1);
        }
        return iD;
    }

    public static boolean f(@NonNull Context context, @NonNull Resources.Theme theme, @Nullable AttributeSet attributeSet, int i11, int i12) {
        TypedArray typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, R$styleable.MaterialTextView, i11, i12);
        int iE = e(context, typedArrayObtainStyledAttributes, R$styleable.MaterialTextView_android_lineHeight, R$styleable.MaterialTextView_lineHeight);
        typedArrayObtainStyledAttributes.recycle();
        return iE != -1;
    }

    public final void a(@NonNull Resources.Theme theme, int i11) {
        TypedArray typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(i11, R$styleable.MaterialTextAppearance);
        int iE = e(getContext(), typedArrayObtainStyledAttributes, R$styleable.MaterialTextAppearance_android_lineHeight, R$styleable.MaterialTextAppearance_lineHeight);
        typedArrayObtainStyledAttributes.recycle();
        if (iE >= 0) {
            setLineHeight(iE);
        }
    }

    public final void d(@Nullable AttributeSet attributeSet, int i11, int i12) {
        int iC;
        Context context = getContext();
        if (b(context)) {
            Resources.Theme theme = context.getTheme();
            if (f(context, theme, attributeSet, i11, i12) || (iC = c(theme, attributeSet, i11, i12)) == -1) {
                return;
            }
            a(theme, iC);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    public void setTextAppearance(@NonNull Context context, int i11) {
        super.setTextAppearance(context, i11);
        if (b(context)) {
            a(context.getTheme(), i11);
        }
    }
}
