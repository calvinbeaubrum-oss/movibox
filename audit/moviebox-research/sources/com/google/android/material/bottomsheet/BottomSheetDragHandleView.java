package com.google.android.material.bottomsheet;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import com.google.android.material.R$attr;
import com.google.android.material.R$string;
import com.google.android.material.R$style;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class BottomSheetDragHandleView extends AppCompatImageView implements AccessibilityManager.AccessibilityStateChangeListener {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f36355k = R$style.Widget_Material3_BottomSheet_DragHandle;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final AccessibilityManager f36356a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public BottomSheetBehavior<?> f36357b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f36358c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f36359d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f36360f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f36361g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f36362h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f36363i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final BottomSheetBehavior.f f36364j;

    /* JADX INFO: compiled from: source.java */
    public class a extends BottomSheetBehavior.f {
        public a() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.f
        public void b(@NonNull View view, float f11) {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.f
        public void c(@NonNull View view, int i11) {
            BottomSheetDragHandleView.this.i(i11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends AccessibilityDelegateCompat {
        public b() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onPopulateAccessibilityEvent(View view, @NonNull AccessibilityEvent accessibilityEvent) {
            super.onPopulateAccessibilityEvent(view, accessibilityEvent);
            if (accessibilityEvent.getEventType() == 1) {
                BottomSheetDragHandleView.this.e();
            }
        }
    }

    public BottomSheetDragHandleView(@NonNull Context context) {
        this(context, null);
    }

    public BottomSheetDragHandleView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.bottomSheetDragHandleStyle);
    }

    public BottomSheetDragHandleView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(zi.a.c(context, attributeSet, i11, f36355k), attributeSet, i11);
        this.f36361g = getResources().getString(R$string.bottomsheet_action_expand);
        this.f36362h = getResources().getString(R$string.bottomsheet_action_collapse);
        this.f36363i = getResources().getString(R$string.bottomsheet_drag_handle_clicked);
        this.f36364j = new a();
        this.f36356a = (AccessibilityManager) getContext().getSystemService("accessibility");
        j();
        ViewCompat.setAccessibilityDelegate(this, new b());
    }

    @Nullable
    public static View g(View view) {
        Object parent = view.getParent();
        if (parent instanceof View) {
            return (View) parent;
        }
        return null;
    }

    private void setBottomSheetBehavior(@Nullable BottomSheetBehavior<?> bottomSheetBehavior) {
        BottomSheetBehavior<?> bottomSheetBehavior2 = this.f36357b;
        if (bottomSheetBehavior2 != null) {
            bottomSheetBehavior2.B0(this.f36364j);
            this.f36357b.G0(null);
        }
        this.f36357b = bottomSheetBehavior;
        if (bottomSheetBehavior != null) {
            bottomSheetBehavior.G0(this);
            i(this.f36357b.q0());
            this.f36357b.Y(this.f36364j);
        }
        j();
    }

    public final void d(String str) {
        if (this.f36356a == null) {
            return;
        }
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(16384);
        accessibilityEventObtain.getText().add(str);
        this.f36356a.sendAccessibilityEvent(accessibilityEventObtain);
    }

    public final boolean e() {
        boolean z11 = false;
        if (!this.f36359d) {
            return false;
        }
        d(this.f36363i);
        if (!this.f36357b.v0() && !this.f36357b.a1()) {
            z11 = true;
        }
        int iQ0 = this.f36357b.q0();
        int i11 = 6;
        if (iQ0 == 4) {
            if (!z11) {
                i11 = 3;
            }
        } else if (iQ0 != 3) {
            i11 = this.f36360f ? 3 : 4;
        } else if (!z11) {
            i11 = 4;
        }
        this.f36357b.U0(i11);
        return true;
    }

    @Nullable
    public final BottomSheetBehavior<?> f() {
        View viewG = this;
        while (true) {
            viewG = g(viewG);
            if (viewG == null) {
                return null;
            }
            ViewGroup.LayoutParams layoutParams = viewG.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.f) {
                CoordinatorLayout.c cVarF = ((CoordinatorLayout.f) layoutParams).f();
                if (cVarF instanceof BottomSheetBehavior) {
                    return (BottomSheetBehavior) cVarF;
                }
            }
        }
    }

    public final /* synthetic */ boolean h(View view, AccessibilityViewCommand.CommandArguments commandArguments) {
        return e();
    }

    public final void i(int i11) {
        if (i11 == 4) {
            this.f36360f = true;
        } else if (i11 == 3) {
            this.f36360f = false;
        }
        ViewCompat.replaceAccessibilityAction(this, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK, this.f36360f ? this.f36361g : this.f36362h, new AccessibilityViewCommand() { // from class: com.google.android.material.bottomsheet.c
            @Override // androidx.core.view.accessibility.AccessibilityViewCommand
            public final boolean perform(View view, AccessibilityViewCommand.CommandArguments commandArguments) {
                return this.f36388a.h(view, commandArguments);
            }
        });
    }

    public final void j() {
        this.f36359d = this.f36358c && this.f36357b != null;
        ViewCompat.setImportantForAccessibility(this, this.f36357b == null ? 2 : 1);
        setClickable(this.f36359d);
    }

    @Override // android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener
    public void onAccessibilityStateChanged(boolean z11) {
        this.f36358c = z11;
        j();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        setBottomSheetBehavior(f());
        AccessibilityManager accessibilityManager = this.f36356a;
        if (accessibilityManager != null) {
            accessibilityManager.addAccessibilityStateChangeListener(this);
            onAccessibilityStateChanged(this.f36356a.isEnabled());
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        AccessibilityManager accessibilityManager = this.f36356a;
        if (accessibilityManager != null) {
            accessibilityManager.removeAccessibilityStateChangeListener(this);
        }
        setBottomSheetBehavior(null);
        super.onDetachedFromWindow();
    }
}
