package OooO0o0;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import xb.i;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension
public class a extends OooO0OO implements View.OnTouchListener, View.OnClickListener {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final BottomSheetBehavior<FrameLayout> f87k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f88l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f89m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f90n;

    /* JADX INFO: renamed from: OooO0o0.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public final class C0008a extends AccessibilityDelegateCompat {
        public C0008a() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfoCompat info) {
            Intrinsics.g(host, "host");
            Intrinsics.g(info, "info");
            super.onInitializeAccessibilityNodeInfo(host, info);
            if (!a.this.f88l) {
                info.setDismissable(false);
            } else {
                info.addAction(1048576);
                info.setDismissable(true);
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean performAccessibilityAction(View host, int i11, Bundle bundle) {
            Intrinsics.g(host, "host");
            if (i11 == 1048576) {
                a aVar = a.this;
                if (aVar.f88l) {
                    aVar.cancel();
                    return true;
                }
            }
            return super.performAccessibilityAction(host, i11, bundle);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class b extends BottomSheetBehavior.f {
        public b() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.f
        public void b(View bottomSheet, float f11) {
            Intrinsics.g(bottomSheet, "bottomSheet");
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.f
        public void c(View bottomSheet, int i11) {
            Intrinsics.g(bottomSheet, "bottomSheet");
            if (i11 == 5) {
                a.this.cancel();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public a(Context context, int i11) {
        super(context, i11);
        Intrinsics.g(context, "context");
        BottomSheetBehavior<FrameLayout> bottomSheetBehavior = new BottomSheetBehavior<>(getContext(), null);
        this.f87k = bottomSheetBehavior;
        this.f88l = true;
        this.f89m = true;
        bottomSheetBehavior.Y(new b());
        bottomSheetBehavior.M0(this.f88l);
        i(1);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        if (this.f87k.q0() == 5) {
            super.cancel();
        } else {
            this.f87k.U0(5);
        }
    }

    @Override // OooO0o0.OooO0OO, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.g(view, "view");
        if (this.f88l && isShowing()) {
            if (!this.f90n) {
                TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(new int[]{R.attr.windowCloseOnTouchOutside});
                Intrinsics.f(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…ndowCloseOnTouchOutside))");
                this.f89m = typedArrayObtainStyledAttributes.getBoolean(0, true);
                typedArrayObtainStyledAttributes.recycle();
                this.f90n = true;
            }
            if (this.f89m) {
                cancel();
            }
        }
    }

    @Override // OooO0o0.OooO0OO, androidx.appcompat.app.w, androidx.activity.k, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        if (window == null) {
            return;
        }
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        View decorView = window.getDecorView();
        Intrinsics.f(decorView, "window.decorView");
        decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | InputDeviceCompat.SOURCE_TOUCHSCREEN);
        window.setLayout(-1, -1);
    }

    @Override // OooO0o0.OooO0OO, androidx.activity.k, android.app.Dialog
    public void onStart() {
        super.onStart();
        if (this.f87k.q0() != 5) {
            return;
        }
        this.f87k.U0(4);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return true;
    }

    public final View q(View view) {
        CoordinatorLayout coordinatorLayout = new CoordinatorLayout(getContext());
        coordinatorLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        View view2 = new View(getContext());
        view2.setSoundEffectsEnabled(false);
        view2.setImportantForAccessibility(2);
        view2.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        FrameLayout frameLayout = new FrameLayout(getContext());
        CoordinatorLayout.f fVar = new CoordinatorLayout.f(-1, -2);
        fVar.f7522c = 49;
        fVar.o(this.f87k);
        frameLayout.setLayoutParams(fVar);
        i.b(view);
        frameLayout.addView(view);
        i.b(view2);
        coordinatorLayout.addView(view2);
        i.b(frameLayout);
        coordinatorLayout.addView(frameLayout);
        view2.setOnClickListener(this);
        ViewCompat.setAccessibilityDelegate(frameLayout, new C0008a());
        frameLayout.setOnTouchListener(this);
        return coordinatorLayout;
    }

    @Override // android.app.Dialog
    public void setCancelable(boolean z11) {
        super.setCancelable(z11);
        if (this.f88l == z11) {
            return;
        }
        this.f88l = z11;
        this.f87k.M0(z11);
    }

    @Override // android.app.Dialog
    public void setCanceledOnTouchOutside(boolean z11) {
        super.setCanceledOnTouchOutside(z11);
        if (z11 && !this.f88l) {
            this.f88l = true;
        }
        this.f89m = z11;
        this.f90n = true;
    }

    @Override // androidx.appcompat.app.w, androidx.activity.k, android.app.Dialog
    public void setContentView(int i11) {
        View viewInflate = getLayoutInflater().inflate(i11, (ViewGroup) null, false);
        Intrinsics.f(viewInflate, "layoutInflater.inflate(layoutResId, null, false)");
        super.setContentView(q(viewInflate));
    }

    @Override // androidx.appcompat.app.w, androidx.activity.k, android.app.Dialog
    public void setContentView(View view) {
        Intrinsics.g(view, "view");
        super.setContentView(q(view));
    }

    @Override // androidx.appcompat.app.w, androidx.activity.k, android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        Intrinsics.g(view, "view");
        view.setLayoutParams(layoutParams);
        super.setContentView(q(view));
    }
}
