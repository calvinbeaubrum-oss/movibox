package com.google.android.material.bottomsheet;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.w;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$style;
import com.google.android.material.internal.f0;
import yi.i;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class b extends w {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public BottomSheetBehavior<FrameLayout> f36367g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public FrameLayout f36368h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public CoordinatorLayout f36369i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public FrameLayout f36370j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f36371k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f36372l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f36373m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f36374n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public f f36375o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f36376p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @Nullable
    public ti.c f36377q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @NonNull
    public BottomSheetBehavior.f f36378r;

    /* JADX INFO: compiled from: source.java */
    public class a implements OnApplyWindowInsetsListener {
        public a() {
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            if (b.this.f36375o != null) {
                b.this.f36367g.B0(b.this.f36375o);
            }
            if (windowInsetsCompat != null) {
                b bVar = b.this;
                bVar.f36375o = new f(bVar.f36370j, windowInsetsCompat, null);
                b.this.f36375o.e(b.this.getWindow());
                b.this.f36367g.Y(b.this.f36375o);
            }
            return windowInsetsCompat;
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.bottomsheet.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public class ViewOnClickListenerC0378b implements View.OnClickListener {
        public ViewOnClickListenerC0378b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b bVar = b.this;
            if (bVar.f36372l && bVar.isShowing() && b.this.r()) {
                b.this.cancel();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c extends AccessibilityDelegateCompat {
        public c() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            if (!b.this.f36372l) {
                accessibilityNodeInfoCompat.setDismissable(false);
            } else {
                accessibilityNodeInfoCompat.addAction(1048576);
                accessibilityNodeInfoCompat.setDismissable(true);
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean performAccessibilityAction(View view, int i11, Bundle bundle) {
            if (i11 == 1048576) {
                b bVar = b.this;
                if (bVar.f36372l) {
                    bVar.cancel();
                    return true;
                }
            }
            return super.performAccessibilityAction(view, i11, bundle);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d implements View.OnTouchListener {
        public d() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class e extends BottomSheetBehavior.f {
        public e() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.f
        public void b(@NonNull View view, float f11) {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.f
        public void c(@NonNull View view, int i11) {
            if (i11 == 5) {
                b.this.cancel();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class f extends BottomSheetBehavior.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public final Boolean f36384a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NonNull
        public final WindowInsetsCompat f36385b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        public Window f36386c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f36387d;

        public f(@NonNull View view, @NonNull WindowInsetsCompat windowInsetsCompat) {
            this.f36385b = windowInsetsCompat;
            i iVarP0 = BottomSheetBehavior.m0(view).p0();
            ColorStateList colorStateListZ = iVarP0 != null ? iVarP0.z() : ViewCompat.getBackgroundTintList(view);
            if (colorStateListZ != null) {
                this.f36384a = Boolean.valueOf(com.google.android.material.color.b.i(colorStateListZ.getDefaultColor()));
                return;
            }
            Integer numH = f0.h(view);
            if (numH != null) {
                this.f36384a = Boolean.valueOf(com.google.android.material.color.b.i(numH.intValue()));
            } else {
                this.f36384a = null;
            }
        }

        public /* synthetic */ f(View view, WindowInsetsCompat windowInsetsCompat, a aVar) {
            this(view, windowInsetsCompat);
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.f
        public void a(@NonNull View view) {
            d(view);
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.f
        public void b(@NonNull View view, float f11) {
            d(view);
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.f
        public void c(@NonNull View view, int i11) {
            d(view);
        }

        public final void d(View view) {
            if (view.getTop() < this.f36385b.getSystemWindowInsetTop()) {
                Window window = this.f36386c;
                if (window != null) {
                    Boolean bool = this.f36384a;
                    com.google.android.material.internal.e.f(window, bool == null ? this.f36387d : bool.booleanValue());
                }
                view.setPadding(view.getPaddingLeft(), this.f36385b.getSystemWindowInsetTop() - view.getTop(), view.getPaddingRight(), view.getPaddingBottom());
                return;
            }
            if (view.getTop() != 0) {
                Window window2 = this.f36386c;
                if (window2 != null) {
                    com.google.android.material.internal.e.f(window2, this.f36387d);
                }
                view.setPadding(view.getPaddingLeft(), 0, view.getPaddingRight(), view.getPaddingBottom());
            }
        }

        public void e(@Nullable Window window) {
            if (this.f36386c == window) {
                return;
            }
            this.f36386c = window;
            if (window != null) {
                this.f36387d = WindowCompat.getInsetsController(window, window.getDecorView()).isAppearanceLightStatusBars();
            }
        }
    }

    public b(@NonNull Context context) {
        this(context, 0);
        this.f36376p = getContext().getTheme().obtainStyledAttributes(new int[]{R$attr.enableEdgeToEdge}).getBoolean(0, false);
    }

    public b(@NonNull Context context, int i11) {
        super(context, f(context, i11));
        this.f36372l = true;
        this.f36373m = true;
        this.f36378r = new e();
        i(1);
        this.f36376p = getContext().getTheme().obtainStyledAttributes(new int[]{R$attr.enableEdgeToEdge}).getBoolean(0, false);
    }

    public static int f(@NonNull Context context, int i11) {
        if (i11 != 0) {
            return i11;
        }
        TypedValue typedValue = new TypedValue();
        return context.getTheme().resolveAttribute(R$attr.bottomSheetDialogTheme, typedValue, true) ? typedValue.resourceId : R$style.Theme_Design_Light_BottomSheetDialog;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        BottomSheetBehavior<FrameLayout> bottomSheetBehaviorO = o();
        if (!this.f36371k || bottomSheetBehaviorO.q0() == 5) {
            super.cancel();
        } else {
            bottomSheetBehaviorO.U0(5);
        }
    }

    public final FrameLayout n() {
        if (this.f36368h == null) {
            FrameLayout frameLayout = (FrameLayout) View.inflate(getContext(), R$layout.design_bottom_sheet_dialog, null);
            this.f36368h = frameLayout;
            this.f36369i = (CoordinatorLayout) frameLayout.findViewById(R$id.coordinator);
            FrameLayout frameLayout2 = (FrameLayout) this.f36368h.findViewById(R$id.design_bottom_sheet);
            this.f36370j = frameLayout2;
            BottomSheetBehavior<FrameLayout> bottomSheetBehaviorM0 = BottomSheetBehavior.m0(frameLayout2);
            this.f36367g = bottomSheetBehaviorM0;
            bottomSheetBehaviorM0.Y(this.f36378r);
            this.f36367g.M0(this.f36372l);
            this.f36377q = new ti.c(this.f36367g, this.f36370j);
        }
        return this.f36368h;
    }

    @NonNull
    public BottomSheetBehavior<FrameLayout> o() {
        if (this.f36367g == null) {
            n();
        }
        return this.f36367g;
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Window window = getWindow();
        if (window != null) {
            boolean z11 = this.f36376p && Color.alpha(window.getNavigationBarColor()) < 255;
            FrameLayout frameLayout = this.f36368h;
            if (frameLayout != null) {
                frameLayout.setFitsSystemWindows(!z11);
            }
            CoordinatorLayout coordinatorLayout = this.f36369i;
            if (coordinatorLayout != null) {
                coordinatorLayout.setFitsSystemWindows(!z11);
            }
            WindowCompat.setDecorFitsSystemWindows(window, !z11);
            f fVar = this.f36375o;
            if (fVar != null) {
                fVar.e(window);
            }
        }
        s();
    }

    @Override // androidx.appcompat.app.w, androidx.activity.k, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            int i11 = Build.VERSION.SDK_INT;
            window.setStatusBarColor(0);
            window.addFlags(Integer.MIN_VALUE);
            if (i11 < 23) {
                window.addFlags(67108864);
            }
            window.setLayout(-1, -1);
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        f fVar = this.f36375o;
        if (fVar != null) {
            fVar.e(null);
        }
        ti.c cVar = this.f36377q;
        if (cVar != null) {
            cVar.f();
        }
    }

    @Override // androidx.activity.k, android.app.Dialog
    public void onStart() {
        super.onStart();
        BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.f36367g;
        if (bottomSheetBehavior == null || bottomSheetBehavior.q0() != 5) {
            return;
        }
        this.f36367g.U0(4);
    }

    public boolean p() {
        return this.f36371k;
    }

    public void q() {
        this.f36367g.B0(this.f36378r);
    }

    public boolean r() {
        if (!this.f36374n) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(new int[]{R.attr.windowCloseOnTouchOutside});
            this.f36373m = typedArrayObtainStyledAttributes.getBoolean(0, true);
            typedArrayObtainStyledAttributes.recycle();
            this.f36374n = true;
        }
        return this.f36373m;
    }

    public final void s() {
        ti.c cVar = this.f36377q;
        if (cVar == null) {
            return;
        }
        if (this.f36372l) {
            cVar.c();
        } else {
            cVar.f();
        }
    }

    @Override // android.app.Dialog
    public void setCancelable(boolean z11) {
        super.setCancelable(z11);
        if (this.f36372l != z11) {
            this.f36372l = z11;
            BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.f36367g;
            if (bottomSheetBehavior != null) {
                bottomSheetBehavior.M0(z11);
            }
            if (getWindow() != null) {
                s();
            }
        }
    }

    @Override // android.app.Dialog
    public void setCanceledOnTouchOutside(boolean z11) {
        super.setCanceledOnTouchOutside(z11);
        if (z11 && !this.f36372l) {
            this.f36372l = true;
        }
        this.f36373m = z11;
        this.f36374n = true;
    }

    @Override // androidx.appcompat.app.w, androidx.activity.k, android.app.Dialog
    public void setContentView(int i11) {
        super.setContentView(t(i11, null, null));
    }

    @Override // androidx.appcompat.app.w, androidx.activity.k, android.app.Dialog
    public void setContentView(View view) {
        super.setContentView(t(0, view, null));
    }

    @Override // androidx.appcompat.app.w, androidx.activity.k, android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(t(0, view, layoutParams));
    }

    public final View t(int i11, @Nullable View view, @Nullable ViewGroup.LayoutParams layoutParams) {
        n();
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) this.f36368h.findViewById(R$id.coordinator);
        if (i11 != 0 && view == null) {
            view = getLayoutInflater().inflate(i11, (ViewGroup) coordinatorLayout, false);
        }
        if (this.f36376p) {
            ViewCompat.setOnApplyWindowInsetsListener(this.f36370j, new a());
        }
        this.f36370j.removeAllViews();
        if (layoutParams == null) {
            this.f36370j.addView(view);
        } else {
            this.f36370j.addView(view, layoutParams);
        }
        coordinatorLayout.findViewById(R$id.touch_outside).setOnClickListener(new ViewOnClickListenerC0378b());
        ViewCompat.setAccessibilityDelegate(this.f36370j, new c());
        this.f36370j.setOnTouchListener(new d());
        return this.f36368h;
    }
}
