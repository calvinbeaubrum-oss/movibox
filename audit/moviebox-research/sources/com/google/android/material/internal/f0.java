package com.google.android.material.internal;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import com.google.android.material.R$styleable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class f0 {

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes5.dex */
    public class a implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f37036a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f37037b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f37038c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ d f37039d;

        public a(boolean z11, boolean z12, boolean z13, d dVar) {
            this.f37036a = z11;
            this.f37037b = z12;
            this.f37038c = z13;
            this.f37039d = dVar;
        }

        @Override // com.google.android.material.internal.f0.d
        @NonNull
        public WindowInsetsCompat a(View view, @NonNull WindowInsetsCompat windowInsetsCompat, @NonNull e eVar) {
            if (this.f37036a) {
                eVar.f37045d += windowInsetsCompat.getSystemWindowInsetBottom();
            }
            boolean zP = f0.p(view);
            if (this.f37037b) {
                if (zP) {
                    eVar.f37044c += windowInsetsCompat.getSystemWindowInsetLeft();
                } else {
                    eVar.f37042a += windowInsetsCompat.getSystemWindowInsetLeft();
                }
            }
            if (this.f37038c) {
                if (zP) {
                    eVar.f37042a += windowInsetsCompat.getSystemWindowInsetRight();
                } else {
                    eVar.f37044c += windowInsetsCompat.getSystemWindowInsetRight();
                }
            }
            eVar.a(view);
            d dVar = this.f37039d;
            return dVar != null ? dVar.a(view, windowInsetsCompat, eVar) : windowInsetsCompat;
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes5.dex */
    public class b implements OnApplyWindowInsetsListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f37040a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e f37041b;

        public b(d dVar, e eVar) {
            this.f37040a = dVar;
            this.f37041b = eVar;
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            return this.f37040a.a(view, windowInsetsCompat, new e(this.f37041b));
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes5.dex */
    public class c implements View.OnAttachStateChangeListener {
        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(@NonNull View view) {
            view.removeOnAttachStateChangeListener(this);
            ViewCompat.requestApplyInsets(view);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes5.dex */
    public interface d {
        WindowInsetsCompat a(View view, WindowInsetsCompat windowInsetsCompat, e eVar);
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes5.dex */
    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f37042a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f37043b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f37044c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f37045d;

        public e(int i11, int i12, int i13, int i14) {
            this.f37042a = i11;
            this.f37043b = i12;
            this.f37044c = i13;
            this.f37045d = i14;
        }

        public e(@NonNull e eVar) {
            this.f37042a = eVar.f37042a;
            this.f37043b = eVar.f37043b;
            this.f37044c = eVar.f37044c;
            this.f37045d = eVar.f37045d;
        }

        public void a(View view) {
            ViewCompat.setPaddingRelative(view, this.f37042a, this.f37043b, this.f37044c, this.f37045d);
        }
    }

    @NonNull
    public static Rect b(@NonNull View view, @NonNull View view2) {
        int[] iArr = new int[2];
        view2.getLocationOnScreen(iArr);
        int i11 = iArr[0];
        int i12 = iArr[1];
        int[] iArr2 = new int[2];
        view.getLocationOnScreen(iArr2);
        int i13 = i11 - iArr2[0];
        int i14 = i12 - iArr2[1];
        return new Rect(i13, i14, view2.getWidth() + i13, view2.getHeight() + i14);
    }

    @NonNull
    public static Rect c(@NonNull View view) {
        return d(view, 0);
    }

    @NonNull
    public static Rect d(@NonNull View view, int i11) {
        return new Rect(view.getLeft(), view.getTop() + i11, view.getRight(), view.getBottom() + i11);
    }

    public static void e(@NonNull View view, @Nullable AttributeSet attributeSet, int i11, int i12, @Nullable d dVar) {
        TypedArray typedArrayObtainStyledAttributes = view.getContext().obtainStyledAttributes(attributeSet, R$styleable.Insets, i11, i12);
        boolean z11 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.Insets_paddingBottomSystemWindowInsets, false);
        boolean z12 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.Insets_paddingLeftSystemWindowInsets, false);
        boolean z13 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.Insets_paddingRightSystemWindowInsets, false);
        typedArrayObtainStyledAttributes.recycle();
        f(view, new a(z11, z12, z13, dVar));
    }

    public static void f(@NonNull View view, @NonNull d dVar) {
        ViewCompat.setOnApplyWindowInsetsListener(view, new b(dVar, new e(ViewCompat.getPaddingStart(view), view.getPaddingTop(), ViewCompat.getPaddingEnd(view), view.getPaddingBottom())));
        s(view);
    }

    public static float g(@NonNull Context context, int i11) {
        return TypedValue.applyDimension(1, i11, context.getResources().getDisplayMetrics());
    }

    @Nullable
    public static Integer h(@NonNull View view) {
        ColorStateList colorStateListG = oi.f.g(view.getBackground());
        if (colorStateListG != null) {
            return Integer.valueOf(colorStateListG.getDefaultColor());
        }
        return null;
    }

    @NonNull
    public static List<View> i(@Nullable View view) {
        ArrayList arrayList = new ArrayList();
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i11 = 0; i11 < viewGroup.getChildCount(); i11++) {
                arrayList.add(viewGroup.getChildAt(i11));
            }
        }
        return arrayList;
    }

    @Nullable
    public static ViewGroup j(@Nullable View view) {
        if (view == null) {
            return null;
        }
        View rootView = view.getRootView();
        ViewGroup viewGroup = (ViewGroup) rootView.findViewById(R.id.content);
        if (viewGroup != null) {
            return viewGroup;
        }
        if (rootView == view || !(rootView instanceof ViewGroup)) {
            return null;
        }
        return (ViewGroup) rootView;
    }

    @Nullable
    public static d0 k(@NonNull View view) {
        return m(j(view));
    }

    @Nullable
    public static InputMethodManager l(@NonNull View view) {
        return (InputMethodManager) z2.a.getSystemService(view.getContext(), InputMethodManager.class);
    }

    @Nullable
    public static d0 m(@Nullable View view) {
        if (view == null) {
            return null;
        }
        return new c0(view);
    }

    public static float n(@NonNull View view) {
        float elevation = 0.0f;
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            elevation += ViewCompat.getElevation((View) parent);
        }
        return elevation;
    }

    public static void o(@NonNull View view, boolean z11) {
        WindowInsetsControllerCompat windowInsetsController;
        if (z11 && (windowInsetsController = ViewCompat.getWindowInsetsController(view)) != null) {
            windowInsetsController.hide(WindowInsetsCompat.Type.ime());
            return;
        }
        InputMethodManager inputMethodManagerL = l(view);
        if (inputMethodManagerL != null) {
            inputMethodManagerL.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public static boolean p(View view) {
        return ViewCompat.getLayoutDirection(view) == 1;
    }

    public static PorterDuff.Mode r(int i11, PorterDuff.Mode mode) {
        if (i11 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i11 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i11 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i11) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    public static void s(@NonNull View view) {
        if (ViewCompat.isAttachedToWindow(view)) {
            ViewCompat.requestApplyInsets(view);
        } else {
            view.addOnAttachStateChangeListener(new c());
        }
    }

    public static void t(@NonNull final View view, final boolean z11) {
        view.requestFocus();
        view.post(new Runnable() { // from class: com.google.android.material.internal.e0
            @Override // java.lang.Runnable
            public final void run() {
                f0.v(view, z11);
            }
        });
    }

    public static void u(@NonNull View view, @NonNull Rect rect) {
        view.setLeft(rect.left);
        view.setTop(rect.top);
        view.setRight(rect.right);
        view.setBottom(rect.bottom);
    }

    public static void v(@NonNull View view, boolean z11) {
        WindowInsetsControllerCompat windowInsetsController;
        if (!z11 || (windowInsetsController = ViewCompat.getWindowInsetsController(view)) == null) {
            l(view).showSoftInput(view, 1);
        } else {
            windowInsetsController.show(WindowInsetsCompat.Type.ime());
        }
    }
}
