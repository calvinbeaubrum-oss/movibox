package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f1728a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TypedArray f1729b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TypedValue f1730c;

    public n0(Context context, TypedArray typedArray) {
        this.f1728a = context;
        this.f1729b = typedArray;
    }

    public static n0 t(Context context, int i11, int[] iArr) {
        return new n0(context, context.obtainStyledAttributes(i11, iArr));
    }

    public static n0 u(Context context, AttributeSet attributeSet, int[] iArr) {
        return new n0(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public static n0 v(Context context, AttributeSet attributeSet, int[] iArr, int i11, int i12) {
        return new n0(context, context.obtainStyledAttributes(attributeSet, iArr, i11, i12));
    }

    public boolean a(int i11, boolean z11) {
        return this.f1729b.getBoolean(i11, z11);
    }

    public int b(int i11, int i12) {
        return this.f1729b.getColor(i11, i12);
    }

    public ColorStateList c(int i11) {
        int resourceId;
        ColorStateList colorStateListA;
        return (!this.f1729b.hasValue(i11) || (resourceId = this.f1729b.getResourceId(i11, 0)) == 0 || (colorStateListA = d1.a.a(this.f1728a, resourceId)) == null) ? this.f1729b.getColorStateList(i11) : colorStateListA;
    }

    public float d(int i11, float f11) {
        return this.f1729b.getDimension(i11, f11);
    }

    public int e(int i11, int i12) {
        return this.f1729b.getDimensionPixelOffset(i11, i12);
    }

    public int f(int i11, int i12) {
        return this.f1729b.getDimensionPixelSize(i11, i12);
    }

    public Drawable g(int i11) {
        int resourceId;
        return (!this.f1729b.hasValue(i11) || (resourceId = this.f1729b.getResourceId(i11, 0)) == 0) ? this.f1729b.getDrawable(i11) : d1.a.b(this.f1728a, resourceId);
    }

    public Drawable h(int i11) {
        int resourceId;
        if (!this.f1729b.hasValue(i11) || (resourceId = this.f1729b.getResourceId(i11, 0)) == 0) {
            return null;
        }
        return f.b().d(this.f1728a, resourceId, true);
    }

    public float i(int i11, float f11) {
        return this.f1729b.getFloat(i11, f11);
    }

    @Nullable
    public Typeface j(int i11, int i12, @Nullable b3.h.e eVar) {
        int resourceId = this.f1729b.getResourceId(i11, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.f1730c == null) {
            this.f1730c = new TypedValue();
        }
        return b3.h.h(this.f1728a, resourceId, this.f1730c, i12, eVar);
    }

    public int k(int i11, int i12) {
        return this.f1729b.getInt(i11, i12);
    }

    public int l(int i11, int i12) {
        return this.f1729b.getInteger(i11, i12);
    }

    public int m(int i11, int i12) {
        return this.f1729b.getLayoutDimension(i11, i12);
    }

    public int n(int i11, int i12) {
        return this.f1729b.getResourceId(i11, i12);
    }

    public String o(int i11) {
        return this.f1729b.getString(i11);
    }

    public CharSequence p(int i11) {
        return this.f1729b.getText(i11);
    }

    public CharSequence[] q(int i11) {
        return this.f1729b.getTextArray(i11);
    }

    public TypedArray r() {
        return this.f1729b;
    }

    public boolean s(int i11) {
        return this.f1729b.hasValue(i11);
    }

    public TypedValue w(int i11) {
        return this.f1729b.peekValue(i11);
    }

    public void x() {
        this.f1729b.recycle();
    }
}
