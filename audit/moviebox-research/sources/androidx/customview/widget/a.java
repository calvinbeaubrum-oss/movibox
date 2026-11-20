package androidx.customview.widget;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.w0;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import androidx.core.view.accessibility.AccessibilityRecordCompat;
import com.google.android.gms.common.api.Api;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class a extends AccessibilityDelegateCompat {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Rect f8134k = new Rect(Api.BaseClientBuilder.API_PRIORITY_OTHER, Api.BaseClientBuilder.API_PRIORITY_OTHER, Integer.MIN_VALUE, Integer.MIN_VALUE);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final FocusStrategy.a<AccessibilityNodeInfoCompat> f8135l = new C0078a();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final FocusStrategy.b<w0<AccessibilityNodeInfoCompat>, AccessibilityNodeInfoCompat> f8136m = new b();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AccessibilityManager f8141e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f8142f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public c f8143g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Rect f8137a = new Rect();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Rect f8138b = new Rect();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Rect f8139c = new Rect();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int[] f8140d = new int[2];

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f8144h = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f8145i = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f8146j = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: androidx.customview.widget.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public class C0078a implements FocusStrategy.a<AccessibilityNodeInfoCompat> {
        @Override // androidx.customview.widget.FocusStrategy.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, Rect rect) {
            accessibilityNodeInfoCompat.getBoundsInParent(rect);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements FocusStrategy.b<w0<AccessibilityNodeInfoCompat>, AccessibilityNodeInfoCompat> {
        @Override // androidx.customview.widget.FocusStrategy.b
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public AccessibilityNodeInfoCompat a(w0<AccessibilityNodeInfoCompat> w0Var, int i11) {
            return w0Var.r(i11);
        }

        @Override // androidx.customview.widget.FocusStrategy.b
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public int b(w0<AccessibilityNodeInfoCompat> w0Var) {
            return w0Var.q();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c extends AccessibilityNodeProviderCompat {
        public c() {
        }

        @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
        public AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int i11) {
            return AccessibilityNodeInfoCompat.obtain(a.this.w(i11));
        }

        @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
        public AccessibilityNodeInfoCompat findFocus(int i11) {
            int i12 = i11 == 2 ? a.this.f8144h : a.this.f8145i;
            if (i12 == Integer.MIN_VALUE) {
                return null;
            }
            return createAccessibilityNodeInfo(i12);
        }

        @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
        public boolean performAction(int i11, int i12, Bundle bundle) {
            return a.this.E(i11, i12, bundle);
        }
    }

    public a(@NonNull View view) {
        if (view == null) {
            throw new IllegalArgumentException("View may not be null");
        }
        this.f8142f = view;
        this.f8141e = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        view.setFocusable(true);
        if (ViewCompat.getImportantForAccessibility(view) == 0) {
            ViewCompat.setImportantForAccessibility(view, 1);
        }
    }

    private boolean H(int i11) {
        int i12;
        if (!this.f8141e.isEnabled() || !this.f8141e.isTouchExplorationEnabled() || (i12 = this.f8144h) == i11) {
            return false;
        }
        if (i12 != Integer.MIN_VALUE) {
            a(i12);
        }
        this.f8144h = i11;
        this.f8142f.invalidate();
        J(i11, 32768);
        return true;
    }

    private void K(int i11) {
        int i12 = this.f8146j;
        if (i12 == i11) {
            return;
        }
        this.f8146j = i11;
        J(i11, 128);
        J(i12, 256);
    }

    private boolean a(int i11) {
        if (this.f8144h != i11) {
            return false;
        }
        this.f8144h = Integer.MIN_VALUE;
        this.f8142f.invalidate();
        J(i11, 65536);
        return true;
    }

    private AccessibilityEvent d(int i11, int i12) {
        return i11 != -1 ? e(i11, i12) : f(i12);
    }

    public static Rect q(@NonNull View view, int i11, @NonNull Rect rect) {
        int width = view.getWidth();
        int height = view.getHeight();
        if (i11 == 17) {
            rect.set(width, 0, width, height);
        } else if (i11 == 33) {
            rect.set(0, height, width, height);
        } else if (i11 == 66) {
            rect.set(-1, 0, -1, height);
        } else {
            if (i11 != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            rect.set(0, -1, width, -1);
        }
        return rect;
    }

    public static int u(int i11) {
        if (i11 == 19) {
            return 33;
        }
        if (i11 == 21) {
            return 17;
        }
        if (i11 != 22) {
            return TsExtractor.TS_STREAM_TYPE_HDMV_DTS;
        }
        return 66;
    }

    public void A(int i11, @NonNull AccessibilityEvent accessibilityEvent) {
    }

    public void B(@NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
    }

    public abstract void C(int i11, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat);

    public void D(int i11, boolean z11) {
    }

    public boolean E(int i11, int i12, Bundle bundle) {
        return i11 != -1 ? F(i11, i12, bundle) : G(i12, bundle);
    }

    public final boolean F(int i11, int i12, Bundle bundle) {
        if (i12 == 1) {
            return I(i11);
        }
        if (i12 == 2) {
            return b(i11);
        }
        if (i12 != 64) {
            return i12 != 128 ? y(i11, i12, bundle) : a(i11);
        }
        return H(i11);
    }

    public final boolean G(int i11, Bundle bundle) {
        return ViewCompat.performAccessibilityAction(this.f8142f, i11, bundle);
    }

    public final boolean I(int i11) {
        int i12;
        if ((!this.f8142f.isFocused() && !this.f8142f.requestFocus()) || (i12 = this.f8145i) == i11) {
            return false;
        }
        if (i12 != Integer.MIN_VALUE) {
            b(i12);
        }
        if (i11 == Integer.MIN_VALUE) {
            return false;
        }
        this.f8145i = i11;
        D(i11, true);
        J(i11, 8);
        return true;
    }

    public final boolean J(int i11, int i12) {
        ViewParent parent;
        if (i11 == Integer.MIN_VALUE || !this.f8141e.isEnabled() || (parent = this.f8142f.getParent()) == null) {
            return false;
        }
        return parent.requestSendAccessibilityEvent(this.f8142f, d(i11, i12));
    }

    public final boolean b(int i11) {
        if (this.f8145i != i11) {
            return false;
        }
        this.f8145i = Integer.MIN_VALUE;
        D(i11, false);
        J(i11, 8);
        return true;
    }

    public final boolean c() {
        int i11 = this.f8145i;
        return i11 != Integer.MIN_VALUE && y(i11, 16, null);
    }

    public final AccessibilityEvent e(int i11, int i12) {
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(i12);
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompatW = w(i11);
        accessibilityEventObtain.getText().add(accessibilityNodeInfoCompatW.getText());
        accessibilityEventObtain.setContentDescription(accessibilityNodeInfoCompatW.getContentDescription());
        accessibilityEventObtain.setScrollable(accessibilityNodeInfoCompatW.isScrollable());
        accessibilityEventObtain.setPassword(accessibilityNodeInfoCompatW.isPassword());
        accessibilityEventObtain.setEnabled(accessibilityNodeInfoCompatW.isEnabled());
        accessibilityEventObtain.setChecked(accessibilityNodeInfoCompatW.isChecked());
        A(i11, accessibilityEventObtain);
        if (accessibilityEventObtain.getText().isEmpty() && accessibilityEventObtain.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
        }
        accessibilityEventObtain.setClassName(accessibilityNodeInfoCompatW.getClassName());
        AccessibilityRecordCompat.setSource(accessibilityEventObtain, this.f8142f, i11);
        accessibilityEventObtain.setPackageName(this.f8142f.getContext().getPackageName());
        return accessibilityEventObtain;
    }

    public final AccessibilityEvent f(int i11) {
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(i11);
        this.f8142f.onInitializeAccessibilityEvent(accessibilityEventObtain);
        return accessibilityEventObtain;
    }

    @NonNull
    public final AccessibilityNodeInfoCompat g(int i11) {
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompatObtain = AccessibilityNodeInfoCompat.obtain();
        accessibilityNodeInfoCompatObtain.setEnabled(true);
        accessibilityNodeInfoCompatObtain.setFocusable(true);
        accessibilityNodeInfoCompatObtain.setClassName("android.view.View");
        Rect rect = f8134k;
        accessibilityNodeInfoCompatObtain.setBoundsInParent(rect);
        accessibilityNodeInfoCompatObtain.setBoundsInScreen(rect);
        accessibilityNodeInfoCompatObtain.setParent(this.f8142f);
        C(i11, accessibilityNodeInfoCompatObtain);
        if (accessibilityNodeInfoCompatObtain.getText() == null && accessibilityNodeInfoCompatObtain.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        accessibilityNodeInfoCompatObtain.getBoundsInParent(this.f8138b);
        if (this.f8138b.equals(rect)) {
            throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
        }
        int actions = accessibilityNodeInfoCompatObtain.getActions();
        if ((actions & 64) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        if ((actions & 128) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        accessibilityNodeInfoCompatObtain.setPackageName(this.f8142f.getContext().getPackageName());
        accessibilityNodeInfoCompatObtain.setSource(this.f8142f, i11);
        if (this.f8144h == i11) {
            accessibilityNodeInfoCompatObtain.setAccessibilityFocused(true);
            accessibilityNodeInfoCompatObtain.addAction(128);
        } else {
            accessibilityNodeInfoCompatObtain.setAccessibilityFocused(false);
            accessibilityNodeInfoCompatObtain.addAction(64);
        }
        boolean z11 = this.f8145i == i11;
        if (z11) {
            accessibilityNodeInfoCompatObtain.addAction(2);
        } else if (accessibilityNodeInfoCompatObtain.isFocusable()) {
            accessibilityNodeInfoCompatObtain.addAction(1);
        }
        accessibilityNodeInfoCompatObtain.setFocused(z11);
        this.f8142f.getLocationOnScreen(this.f8140d);
        accessibilityNodeInfoCompatObtain.getBoundsInScreen(this.f8137a);
        if (this.f8137a.equals(rect)) {
            accessibilityNodeInfoCompatObtain.getBoundsInParent(this.f8137a);
            if (accessibilityNodeInfoCompatObtain.mParentVirtualDescendantId != -1) {
                AccessibilityNodeInfoCompat accessibilityNodeInfoCompatObtain2 = AccessibilityNodeInfoCompat.obtain();
                for (int i12 = accessibilityNodeInfoCompatObtain.mParentVirtualDescendantId; i12 != -1; i12 = accessibilityNodeInfoCompatObtain2.mParentVirtualDescendantId) {
                    accessibilityNodeInfoCompatObtain2.setParent(this.f8142f, -1);
                    accessibilityNodeInfoCompatObtain2.setBoundsInParent(f8134k);
                    C(i12, accessibilityNodeInfoCompatObtain2);
                    accessibilityNodeInfoCompatObtain2.getBoundsInParent(this.f8138b);
                    Rect rect2 = this.f8137a;
                    Rect rect3 = this.f8138b;
                    rect2.offset(rect3.left, rect3.top);
                }
                accessibilityNodeInfoCompatObtain2.recycle();
            }
            this.f8137a.offset(this.f8140d[0] - this.f8142f.getScrollX(), this.f8140d[1] - this.f8142f.getScrollY());
        }
        if (this.f8142f.getLocalVisibleRect(this.f8139c)) {
            this.f8139c.offset(this.f8140d[0] - this.f8142f.getScrollX(), this.f8140d[1] - this.f8142f.getScrollY());
            if (this.f8137a.intersect(this.f8139c)) {
                accessibilityNodeInfoCompatObtain.setBoundsInScreen(this.f8137a);
                if (t(this.f8137a)) {
                    accessibilityNodeInfoCompatObtain.setVisibleToUser(true);
                }
            }
        }
        return accessibilityNodeInfoCompatObtain;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View view) {
        if (this.f8143g == null) {
            this.f8143g = new c();
        }
        return this.f8143g;
    }

    @NonNull
    public final AccessibilityNodeInfoCompat h() {
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompatObtain = AccessibilityNodeInfoCompat.obtain(this.f8142f);
        ViewCompat.onInitializeAccessibilityNodeInfo(this.f8142f, accessibilityNodeInfoCompatObtain);
        ArrayList arrayList = new ArrayList();
        p(arrayList);
        if (accessibilityNodeInfoCompatObtain.getChildCount() > 0 && arrayList.size() > 0) {
            throw new RuntimeException("Views cannot have both real and virtual children");
        }
        int size = arrayList.size();
        for (int i11 = 0; i11 < size; i11++) {
            accessibilityNodeInfoCompatObtain.addChild(this.f8142f, ((Integer) arrayList.get(i11)).intValue());
        }
        return accessibilityNodeInfoCompatObtain;
    }

    public final boolean i(@NonNull MotionEvent motionEvent) {
        if (!this.f8141e.isEnabled() || !this.f8141e.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 7 || action == 9) {
            int iO = o(motionEvent.getX(), motionEvent.getY());
            K(iO);
            return iO != Integer.MIN_VALUE;
        }
        if (action != 10 || this.f8146j == Integer.MIN_VALUE) {
            return false;
        }
        K(Integer.MIN_VALUE);
        return true;
    }

    public final boolean j(@NonNull KeyEvent keyEvent) {
        int i11 = 0;
        if (keyEvent.getAction() == 1) {
            return false;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 61) {
            if (keyEvent.hasNoModifiers()) {
                return v(2, null);
            }
            if (keyEvent.hasModifiers(1)) {
                return v(1, null);
            }
            return false;
        }
        if (keyCode != 66) {
            switch (keyCode) {
                case 19:
                case 20:
                case 21:
                case 22:
                    if (!keyEvent.hasNoModifiers()) {
                        return false;
                    }
                    int iU = u(keyCode);
                    int repeatCount = keyEvent.getRepeatCount() + 1;
                    boolean z11 = false;
                    while (i11 < repeatCount && v(iU, null)) {
                        i11++;
                        z11 = true;
                    }
                    return z11;
                case 23:
                    break;
                default:
                    return false;
            }
        }
        if (!keyEvent.hasNoModifiers() || keyEvent.getRepeatCount() != 0) {
            return false;
        }
        c();
        return true;
    }

    public final int k() {
        return this.f8144h;
    }

    public final w0<AccessibilityNodeInfoCompat> l() {
        ArrayList arrayList = new ArrayList();
        p(arrayList);
        w0<AccessibilityNodeInfoCompat> w0Var = new w0<>();
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            w0Var.m(arrayList.get(i11).intValue(), g(arrayList.get(i11).intValue()));
        }
        return w0Var;
    }

    public final void m(int i11, Rect rect) {
        w(i11).getBoundsInParent(rect);
    }

    public final int n() {
        return this.f8145i;
    }

    public abstract int o(float f11, float f12);

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        z(accessibilityEvent);
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        B(accessibilityNodeInfoCompat);
    }

    public abstract void p(List<Integer> list);

    public final void r(int i11) {
        s(i11, 0);
    }

    public final void s(int i11, int i12) {
        ViewParent parent;
        if (i11 == Integer.MIN_VALUE || !this.f8141e.isEnabled() || (parent = this.f8142f.getParent()) == null) {
            return;
        }
        AccessibilityEvent accessibilityEventD = d(i11, 2048);
        AccessibilityEventCompat.setContentChangeTypes(accessibilityEventD, i12);
        parent.requestSendAccessibilityEvent(this.f8142f, accessibilityEventD);
    }

    public final boolean t(Rect rect) {
        if (rect == null || rect.isEmpty() || this.f8142f.getWindowVisibility() != 0) {
            return false;
        }
        Object parent = this.f8142f.getParent();
        while (parent instanceof View) {
            View view = (View) parent;
            if (view.getAlpha() <= 0.0f || view.getVisibility() != 0) {
                return false;
            }
            parent = view.getParent();
        }
        return parent != null;
    }

    public final boolean v(int i11, @Nullable Rect rect) {
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat;
        w0<AccessibilityNodeInfoCompat> w0VarL = l();
        int i12 = this.f8145i;
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompatG = i12 == Integer.MIN_VALUE ? null : w0VarL.g(i12);
        if (i11 == 1 || i11 == 2) {
            accessibilityNodeInfoCompat = (AccessibilityNodeInfoCompat) FocusStrategy.d(w0VarL, f8136m, f8135l, accessibilityNodeInfoCompatG, i11, ViewCompat.getLayoutDirection(this.f8142f) == 1, false);
        } else {
            if (i11 != 17 && i11 != 33 && i11 != 66 && i11 != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            Rect rect2 = new Rect();
            int i13 = this.f8145i;
            if (i13 != Integer.MIN_VALUE) {
                m(i13, rect2);
            } else if (rect != null) {
                rect2.set(rect);
            } else {
                q(this.f8142f, i11, rect2);
            }
            accessibilityNodeInfoCompat = (AccessibilityNodeInfoCompat) FocusStrategy.c(w0VarL, f8136m, f8135l, accessibilityNodeInfoCompatG, rect2, i11);
        }
        return I(accessibilityNodeInfoCompat != null ? w0VarL.l(w0VarL.k(accessibilityNodeInfoCompat)) : Integer.MIN_VALUE);
    }

    @NonNull
    public AccessibilityNodeInfoCompat w(int i11) {
        return i11 == -1 ? h() : g(i11);
    }

    public final void x(boolean z11, int i11, @Nullable Rect rect) {
        int i12 = this.f8145i;
        if (i12 != Integer.MIN_VALUE) {
            b(i12);
        }
        if (z11) {
            v(i11, rect);
        }
    }

    public abstract boolean y(int i11, int i12, @Nullable Bundle bundle);

    public void z(@NonNull AccessibilityEvent accessibilityEvent) {
    }
}
