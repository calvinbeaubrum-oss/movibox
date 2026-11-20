package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class ConstraintHelper extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int[] f7267a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f7268b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Context f7269c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public v2.a f7270d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f7271f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f7272g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f7273h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public View[] f7274i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public HashMap<Integer, String> f7275j;

    public ConstraintHelper(Context context) {
        super(context);
        this.f7267a = new int[32];
        this.f7271f = false;
        this.f7274i = null;
        this.f7275j = new HashMap<>();
        this.f7269c = context;
        k(null);
    }

    public ConstraintHelper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7267a = new int[32];
        this.f7271f = false;
        this.f7274i = null;
        this.f7275j = new HashMap<>();
        this.f7269c = context;
        k(attributeSet);
    }

    public ConstraintHelper(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f7267a = new int[32];
        this.f7271f = false;
        this.f7274i = null;
        this.f7275j = new HashMap<>();
        this.f7269c = context;
        k(attributeSet);
    }

    public final void a(String str) {
        if (str == null || str.length() == 0 || this.f7269c == null) {
            return;
        }
        String strTrim = str.trim();
        if (getParent() instanceof ConstraintLayout) {
        }
        int i11 = i(strTrim);
        if (i11 != 0) {
            this.f7275j.put(Integer.valueOf(i11), strTrim);
            b(i11);
            return;
        }
        Log.w("ConstraintHelper", "Could not find id of \"" + strTrim + "\"");
    }

    public void addView(View view) {
        if (view == this) {
            return;
        }
        if (view.getId() == -1) {
            Log.e("ConstraintHelper", "Views added to a ConstraintHelper need to have an id");
        } else {
            if (view.getParent() == null) {
                Log.e("ConstraintHelper", "Views added to a ConstraintHelper need to have a parent");
                return;
            }
            this.f7272g = null;
            b(view.getId());
            requestLayout();
        }
    }

    public final void b(int i11) {
        if (i11 == getId()) {
            return;
        }
        int i12 = this.f7268b + 1;
        int[] iArr = this.f7267a;
        if (i12 > iArr.length) {
            this.f7267a = Arrays.copyOf(iArr, iArr.length * 2);
        }
        int[] iArr2 = this.f7267a;
        int i13 = this.f7268b;
        iArr2[i13] = i11;
        this.f7268b = i13 + 1;
    }

    public final void c(String str) {
        if (str == null || str.length() == 0 || this.f7269c == null) {
            return;
        }
        String strTrim = str.trim();
        ConstraintLayout constraintLayout = getParent() instanceof ConstraintLayout ? (ConstraintLayout) getParent() : null;
        if (constraintLayout == null) {
            Log.w("ConstraintHelper", "Parent not a ConstraintLayout");
            return;
        }
        int childCount = constraintLayout.getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = constraintLayout.getChildAt(i11);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            if ((layoutParams instanceof ConstraintLayout.b) && strTrim.equals(((ConstraintLayout.b) layoutParams).f7282c0)) {
                if (childAt.getId() == -1) {
                    Log.w("ConstraintHelper", "to use ConstraintTag view " + childAt.getClass().getSimpleName() + " must have an ID");
                } else {
                    b(childAt.getId());
                }
            }
        }
    }

    public boolean containsId(int i11) {
        for (int i12 : this.f7267a) {
            if (i12 == i11) {
                return true;
            }
        }
        return false;
    }

    public void d() {
        ViewParent parent = getParent();
        if (parent == null || !(parent instanceof ConstraintLayout)) {
            return;
        }
        e((ConstraintLayout) parent);
    }

    public void e(ConstraintLayout constraintLayout) {
        int visibility = getVisibility();
        float elevation = getElevation();
        for (int i11 = 0; i11 < this.f7268b; i11++) {
            View viewById = constraintLayout.getViewById(this.f7267a[i11]);
            if (viewById != null) {
                viewById.setVisibility(visibility);
                if (elevation > 0.0f) {
                    viewById.setTranslationZ(viewById.getTranslationZ() + elevation);
                }
            }
        }
    }

    public void f(ConstraintLayout constraintLayout) {
    }

    public final int[] g(View view, String str) {
        String[] strArrSplit = str.split(",");
        view.getContext();
        int[] iArr = new int[strArrSplit.length];
        int i11 = 0;
        for (String str2 : strArrSplit) {
            int i12 = i(str2.trim());
            if (i12 != 0) {
                iArr[i11] = i12;
                i11++;
            }
        }
        return i11 != strArrSplit.length ? Arrays.copyOf(iArr, i11) : iArr;
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.f7267a, this.f7268b);
    }

    public final int h(ConstraintLayout constraintLayout, String str) {
        Resources resources;
        String resourceEntryName;
        if (str == null || constraintLayout == null || (resources = this.f7269c.getResources()) == null) {
            return 0;
        }
        int childCount = constraintLayout.getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = constraintLayout.getChildAt(i11);
            if (childAt.getId() != -1) {
                try {
                    resourceEntryName = resources.getResourceEntryName(childAt.getId());
                } catch (Resources.NotFoundException unused) {
                    resourceEntryName = null;
                }
                if (str.equals(resourceEntryName)) {
                    return childAt.getId();
                }
            }
        }
        return 0;
    }

    public final int i(String str) {
        ConstraintLayout constraintLayout = getParent() instanceof ConstraintLayout ? (ConstraintLayout) getParent() : null;
        int iH = 0;
        if (isInEditMode() && constraintLayout != null) {
            Object designInformation = constraintLayout.getDesignInformation(0, str);
            if (designInformation instanceof Integer) {
                iH = ((Integer) designInformation).intValue();
            }
        }
        if (iH == 0 && constraintLayout != null) {
            iH = h(constraintLayout, str);
        }
        if (iH == 0) {
            try {
                iH = R$id.class.getField(str).getInt(null);
            } catch (Exception unused) {
            }
        }
        return iH == 0 ? this.f7269c.getResources().getIdentifier(str, "id", this.f7269c.getPackageName()) : iH;
    }

    public int indexFromId(int i11) {
        int i12 = -1;
        for (int i13 : this.f7267a) {
            i12++;
            if (i13 == i11) {
                return i12;
            }
        }
        return i12;
    }

    public View[] j(ConstraintLayout constraintLayout) {
        View[] viewArr = this.f7274i;
        if (viewArr == null || viewArr.length != this.f7268b) {
            this.f7274i = new View[this.f7268b];
        }
        for (int i11 = 0; i11 < this.f7268b; i11++) {
            this.f7274i[i11] = constraintLayout.getViewById(this.f7267a[i11]);
        }
        return this.f7274i;
    }

    public void k(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.ConstraintLayout_Layout);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i11);
                if (index == R$styleable.ConstraintLayout_Layout_constraint_referenced_ids) {
                    String string = typedArrayObtainStyledAttributes.getString(index);
                    this.f7272g = string;
                    setIds(string);
                } else if (index == R$styleable.ConstraintLayout_Layout_constraint_referenced_tags) {
                    String string2 = typedArrayObtainStyledAttributes.getString(index);
                    this.f7273h = string2;
                    setReferenceTags(string2);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public void loadParameters(b.a aVar, v2.b bVar, ConstraintLayout.b bVar2, SparseArray<ConstraintWidget> sparseArray) {
        b.C0070b c0070b = aVar.f7381e;
        int[] iArr = c0070b.f7419k0;
        if (iArr != null) {
            setReferencedIds(iArr);
        } else {
            String str = c0070b.f7421l0;
            if (str != null) {
                if (str.length() > 0) {
                    b.C0070b c0070b2 = aVar.f7381e;
                    c0070b2.f7419k0 = g(this, c0070b2.f7421l0);
                } else {
                    aVar.f7381e.f7419k0 = null;
                }
            }
        }
        if (bVar == null) {
            return;
        }
        bVar.b();
        if (aVar.f7381e.f7419k0 == null) {
            return;
        }
        int i11 = 0;
        while (true) {
            int[] iArr2 = aVar.f7381e.f7419k0;
            if (i11 >= iArr2.length) {
                return;
            }
            ConstraintWidget constraintWidget = sparseArray.get(iArr2[i11]);
            if (constraintWidget != null) {
                bVar.a(constraintWidget);
            }
            i11++;
        }
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String str = this.f7272g;
        if (str != null) {
            setIds(str);
        }
        String str2 = this.f7273h;
        if (str2 != null) {
            setReferenceTags(str2);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
    }

    @Override // android.view.View
    public void onMeasure(int i11, int i12) {
        if (this.f7271f) {
            super.onMeasure(i11, i12);
        } else {
            setMeasuredDimension(0, 0);
        }
    }

    public int removeView(View view) {
        int i11;
        int id2 = view.getId();
        int i12 = -1;
        if (id2 == -1) {
            return -1;
        }
        this.f7272g = null;
        for (int i13 = 0; i13 < this.f7268b; i13++) {
            if (this.f7267a[i13] == id2) {
                int i14 = i13;
                while (true) {
                    i11 = this.f7268b;
                    if (i14 >= i11 - 1) {
                        break;
                    }
                    int[] iArr = this.f7267a;
                    int i15 = i14 + 1;
                    iArr[i14] = iArr[i15];
                    i14 = i15;
                }
                this.f7267a[i11 - 1] = 0;
                this.f7268b = i11 - 1;
                i12 = i13;
                break;
            }
        }
        requestLayout();
        return i12;
    }

    public void resolveRtl(ConstraintWidget constraintWidget, boolean z11) {
    }

    public void setIds(String str) {
        this.f7272g = str;
        if (str == null) {
            return;
        }
        int i11 = 0;
        this.f7268b = 0;
        while (true) {
            int iIndexOf = str.indexOf(44, i11);
            if (iIndexOf == -1) {
                a(str.substring(i11));
                return;
            } else {
                a(str.substring(i11, iIndexOf));
                i11 = iIndexOf + 1;
            }
        }
    }

    public void setReferenceTags(String str) {
        this.f7273h = str;
        if (str == null) {
            return;
        }
        int i11 = 0;
        this.f7268b = 0;
        while (true) {
            int iIndexOf = str.indexOf(44, i11);
            if (iIndexOf == -1) {
                c(str.substring(i11));
                return;
            } else {
                c(str.substring(i11, iIndexOf));
                i11 = iIndexOf + 1;
            }
        }
    }

    public void setReferencedIds(int[] iArr) {
        this.f7272g = null;
        this.f7268b = 0;
        for (int i11 : iArr) {
            b(i11);
        }
    }

    @Override // android.view.View
    public void setTag(int i11, Object obj) {
        super.setTag(i11, obj);
        if (obj == null && this.f7272g == null) {
            b(i11);
        }
    }

    public void updatePostConstraints(ConstraintLayout constraintLayout) {
    }

    public void updatePostLayout(ConstraintLayout constraintLayout) {
    }

    public void updatePostMeasure(ConstraintLayout constraintLayout) {
    }

    public void updatePreDraw(ConstraintLayout constraintLayout) {
    }

    public void updatePreLayout(androidx.constraintlayout.core.widgets.d dVar, v2.a aVar, SparseArray<ConstraintWidget> sparseArray) {
        aVar.b();
        for (int i11 = 0; i11 < this.f7268b; i11++) {
            aVar.a(sparseArray.get(this.f7267a[i11]));
        }
    }

    public void updatePreLayout(ConstraintLayout constraintLayout) {
        String str;
        int iH;
        if (isInEditMode()) {
            setIds(this.f7272g);
        }
        v2.a aVar = this.f7270d;
        if (aVar == null) {
            return;
        }
        aVar.b();
        for (int i11 = 0; i11 < this.f7268b; i11++) {
            int i12 = this.f7267a[i11];
            View viewById = constraintLayout.getViewById(i12);
            if (viewById == null && (iH = h(constraintLayout, (str = this.f7275j.get(Integer.valueOf(i12))))) != 0) {
                this.f7267a[i11] = iH;
                this.f7275j.put(Integer.valueOf(iH), str);
                viewById = constraintLayout.getViewById(iH);
            }
            if (viewById != null) {
                this.f7270d.a(constraintLayout.getViewWidget(viewById));
            }
        }
        this.f7270d.c(constraintLayout.mLayoutWidget);
    }

    public void validateParams() {
        if (this.f7270d == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.b) {
            ((ConstraintLayout.b) layoutParams).f7320v0 = (ConstraintWidget) this.f7270d;
        }
    }
}
