package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R$styleable;
import androidx.constraintlayout.widget.VirtualLayout;
import androidx.constraintlayout.widget.b;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class CircularFlow extends VirtualLayout {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static int f6722w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static float f6723x;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ConstraintLayout f6724m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f6725n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float[] f6726o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int[] f6727p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f6728q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f6729r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f6730s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f6731t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Float f6732u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Integer f6733v;

    public CircularFlow(Context context) {
        super(context);
    }

    public CircularFlow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CircularFlow(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }

    public static float[] removeElementFromArray(float[] fArr, int i11) {
        float[] fArr2 = new float[fArr.length - 1];
        int i12 = 0;
        for (int i13 = 0; i13 < fArr.length; i13++) {
            if (i13 != i11) {
                fArr2[i12] = fArr[i13];
                i12++;
            }
        }
        return fArr2;
    }

    public static int[] removeElementFromArray(int[] iArr, int i11) {
        int[] iArr2 = new int[iArr.length - 1];
        int i12 = 0;
        for (int i13 = 0; i13 < iArr.length; i13++) {
            if (i13 != i11) {
                iArr2[i12] = iArr[i13];
                i12++;
            }
        }
        return iArr2;
    }

    private void setAngles(String str) {
        if (str == null) {
            return;
        }
        int i11 = 0;
        this.f6729r = 0;
        while (true) {
            int iIndexOf = str.indexOf(44, i11);
            if (iIndexOf == -1) {
                l(str.substring(i11).trim());
                return;
            } else {
                l(str.substring(i11, iIndexOf).trim());
                i11 = iIndexOf + 1;
            }
        }
    }

    private void setRadius(String str) {
        if (str == null) {
            return;
        }
        int i11 = 0;
        this.f6728q = 0;
        while (true) {
            int iIndexOf = str.indexOf(44, i11);
            if (iIndexOf == -1) {
                m(str.substring(i11).trim());
                return;
            } else {
                m(str.substring(i11, iIndexOf).trim());
                i11 = iIndexOf + 1;
            }
        }
    }

    public void addViewToCircularFlow(View view, int i11, float f11) {
        if (containsId(view.getId())) {
            return;
        }
        addView(view);
        this.f6729r++;
        float[] angles = getAngles();
        this.f6726o = angles;
        angles[this.f6729r - 1] = f11;
        this.f6728q++;
        int[] radius = getRadius();
        this.f6727p = radius;
        radius[this.f6728q - 1] = (int) (i11 * this.f7269c.getResources().getDisplayMetrics().density);
        n();
    }

    public float[] getAngles() {
        return Arrays.copyOf(this.f6726o, this.f6729r);
    }

    public int[] getRadius() {
        return Arrays.copyOf(this.f6727p, this.f6728q);
    }

    public boolean isUpdatable(View view) {
        return containsId(view.getId()) && indexFromId(view.getId()) != -1;
    }

    @Override // androidx.constraintlayout.widget.VirtualLayout, androidx.constraintlayout.widget.ConstraintHelper
    public void k(AttributeSet attributeSet) {
        super.k(attributeSet);
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.ConstraintLayout_Layout);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i11);
                if (index == R$styleable.ConstraintLayout_Layout_circularflow_viewCenter) {
                    this.f6725n = typedArrayObtainStyledAttributes.getResourceId(index, 0);
                } else if (index == R$styleable.ConstraintLayout_Layout_circularflow_angles) {
                    String string = typedArrayObtainStyledAttributes.getString(index);
                    this.f6730s = string;
                    setAngles(string);
                } else if (index == R$styleable.ConstraintLayout_Layout_circularflow_radiusInDP) {
                    String string2 = typedArrayObtainStyledAttributes.getString(index);
                    this.f6731t = string2;
                    setRadius(string2);
                } else if (index == R$styleable.ConstraintLayout_Layout_circularflow_defaultAngle) {
                    Float fValueOf = Float.valueOf(typedArrayObtainStyledAttributes.getFloat(index, f6723x));
                    this.f6732u = fValueOf;
                    setDefaultAngle(fValueOf.floatValue());
                } else if (index == R$styleable.ConstraintLayout_Layout_circularflow_defaultRadius) {
                    Integer numValueOf = Integer.valueOf(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, f6722w));
                    this.f6733v = numValueOf;
                    setDefaultRadius(numValueOf.intValue());
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public final void l(String str) {
        float[] fArr;
        if (str == null || str.length() == 0 || this.f7269c == null || (fArr = this.f6726o) == null) {
            return;
        }
        if (this.f6729r + 1 > fArr.length) {
            this.f6726o = Arrays.copyOf(fArr, fArr.length + 1);
        }
        this.f6726o[this.f6729r] = Integer.parseInt(str);
        this.f6729r++;
    }

    public final void m(String str) {
        int[] iArr;
        if (str == null || str.length() == 0 || this.f7269c == null || (iArr = this.f6727p) == null) {
            return;
        }
        if (this.f6728q + 1 > iArr.length) {
            this.f6727p = Arrays.copyOf(iArr, iArr.length + 1);
        }
        this.f6727p[this.f6728q] = (int) (Integer.parseInt(str) * this.f7269c.getResources().getDisplayMetrics().density);
        this.f6728q++;
    }

    public final void n() {
        this.f6724m = (ConstraintLayout) getParent();
        for (int i11 = 0; i11 < this.f7268b; i11++) {
            View viewById = this.f6724m.getViewById(this.f7267a[i11]);
            if (viewById != null) {
                int i12 = f6722w;
                float f11 = f6723x;
                int[] iArr = this.f6727p;
                if (iArr == null || i11 >= iArr.length) {
                    Integer num = this.f6733v;
                    if (num == null || num.intValue() == -1) {
                        Log.e("CircularFlow", "Added radius to view with id: " + this.f7275j.get(Integer.valueOf(viewById.getId())));
                    } else {
                        this.f6728q++;
                        if (this.f6727p == null) {
                            this.f6727p = new int[1];
                        }
                        int[] radius = getRadius();
                        this.f6727p = radius;
                        radius[this.f6728q - 1] = i12;
                    }
                } else {
                    i12 = iArr[i11];
                }
                float[] fArr = this.f6726o;
                if (fArr == null || i11 >= fArr.length) {
                    Float f12 = this.f6732u;
                    if (f12 == null || f12.floatValue() == -1.0f) {
                        Log.e("CircularFlow", "Added angle to view with id: " + this.f7275j.get(Integer.valueOf(viewById.getId())));
                    } else {
                        this.f6729r++;
                        if (this.f6726o == null) {
                            this.f6726o = new float[1];
                        }
                        float[] angles = getAngles();
                        this.f6726o = angles;
                        angles[this.f6729r - 1] = f11;
                    }
                } else {
                    f11 = fArr[i11];
                }
                ConstraintLayout.b bVar = (ConstraintLayout.b) viewById.getLayoutParams();
                bVar.f7311r = f11;
                bVar.f7307p = this.f6725n;
                bVar.f7309q = i12;
                viewById.setLayoutParams(bVar);
            }
        }
        d();
    }

    public final float[] o(float[] fArr, int i11) {
        return (fArr == null || i11 < 0 || i11 >= this.f6729r) ? fArr : removeElementFromArray(fArr, i11);
    }

    @Override // androidx.constraintlayout.widget.VirtualLayout, androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String str = this.f6730s;
        if (str != null) {
            this.f6726o = new float[1];
            setAngles(str);
        }
        String str2 = this.f6731t;
        if (str2 != null) {
            this.f6727p = new int[1];
            setRadius(str2);
        }
        Float f11 = this.f6732u;
        if (f11 != null) {
            setDefaultAngle(f11.floatValue());
        }
        Integer num = this.f6733v;
        if (num != null) {
            setDefaultRadius(num.intValue());
        }
        n();
    }

    public final int[] p(int[] iArr, int i11) {
        return (iArr == null || i11 < 0 || i11 >= this.f6728q) ? iArr : removeElementFromArray(iArr, i11);
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public int removeView(View view) {
        int iRemoveView = super.removeView(view);
        if (iRemoveView == -1) {
            return iRemoveView;
        }
        b bVar = new b();
        bVar.p(this.f6724m);
        bVar.n(view.getId(), 8);
        bVar.i(this.f6724m);
        float[] fArr = this.f6726o;
        if (iRemoveView < fArr.length) {
            this.f6726o = o(fArr, iRemoveView);
            this.f6729r--;
        }
        int[] iArr = this.f6727p;
        if (iRemoveView < iArr.length) {
            this.f6727p = p(iArr, iRemoveView);
            this.f6728q--;
        }
        n();
        return iRemoveView;
    }

    public void setDefaultAngle(float f11) {
        f6723x = f11;
    }

    public void setDefaultRadius(int i11) {
        f6722w = i11;
    }

    public void updateAngle(View view, float f11) {
        if (!isUpdatable(view)) {
            Log.e("CircularFlow", "It was not possible to update angle to view with id: " + view.getId());
            return;
        }
        int iIndexFromId = indexFromId(view.getId());
        if (iIndexFromId > this.f6726o.length) {
            return;
        }
        float[] angles = getAngles();
        this.f6726o = angles;
        angles[iIndexFromId] = f11;
        n();
    }

    public void updateRadius(View view, int i11) {
        if (!isUpdatable(view)) {
            Log.e("CircularFlow", "It was not possible to update radius to view with id: " + view.getId());
            return;
        }
        int iIndexFromId = indexFromId(view.getId());
        if (iIndexFromId > this.f6727p.length) {
            return;
        }
        int[] radius = getRadius();
        this.f6727p = radius;
        radius[iIndexFromId] = (int) (i11 * this.f7269c.getResources().getDisplayMetrics().density);
        n();
    }

    public void updateReference(View view, int i11, float f11) {
        if (!isUpdatable(view)) {
            Log.e("CircularFlow", "It was not possible to update radius and angle to view with id: " + view.getId());
            return;
        }
        int iIndexFromId = indexFromId(view.getId());
        if (getAngles().length > iIndexFromId) {
            float[] angles = getAngles();
            this.f6726o = angles;
            angles[iIndexFromId] = f11;
        }
        if (getRadius().length > iIndexFromId) {
            int[] radius = getRadius();
            this.f6727p = radius;
            radius[iIndexFromId] = (int) (i11 * this.f7269c.getResources().getDisplayMetrics().density);
        }
        n();
    }
}
