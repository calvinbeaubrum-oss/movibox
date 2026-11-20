package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.R$attr;
import androidx.core.view.ViewPropertyAnimatorCompat;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class DropDownListView extends ListView {
    public static final int INVALID_POSITION = -1;
    public static final int NO_POSITION = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Rect f1404a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1405b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f1406c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f1407d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f1408f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f1409g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public d f1410h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f1411i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f1412j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f1413k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ViewPropertyAnimatorCompat f1414l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public androidx.core.widget.i f1415m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ResolveHoverRunnable f1416n;

    /* JADX INFO: compiled from: source.java */
    public class ResolveHoverRunnable implements Runnable {
        public ResolveHoverRunnable() {
        }

        public void cancel() {
            DropDownListView dropDownListView = DropDownListView.this;
            dropDownListView.f1416n = null;
            dropDownListView.removeCallbacks(this);
        }

        public void post() {
            DropDownListView.this.post(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            DropDownListView dropDownListView = DropDownListView.this;
            dropDownListView.f1416n = null;
            dropDownListView.drawableStateChanged();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(21)
    public static class a {
        public static void a(View view, float f11, float f12) {
            view.drawableHotspotChanged(f11, f12);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(30)
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static Method f1417a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static Method f1418b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static Method f1419c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static boolean f1420d;

        static {
            try {
                Class cls = Integer.TYPE;
                Class cls2 = Float.TYPE;
                Method declaredMethod = AbsListView.class.getDeclaredMethod("positionSelector", cls, View.class, Boolean.TYPE, cls2, cls2);
                f1417a = declaredMethod;
                declaredMethod.setAccessible(true);
                Method declaredMethod2 = AdapterView.class.getDeclaredMethod("setSelectedPositionInt", cls);
                f1418b = declaredMethod2;
                declaredMethod2.setAccessible(true);
                Method declaredMethod3 = AdapterView.class.getDeclaredMethod("setNextSelectedPositionInt", cls);
                f1419c = declaredMethod3;
                declaredMethod3.setAccessible(true);
                f1420d = true;
            } catch (NoSuchMethodException e11) {
                e11.printStackTrace();
            }
        }

        public static boolean a() {
            return f1420d;
        }

        @SuppressLint({"BanUncheckedReflection"})
        public static void b(DropDownListView dropDownListView, int i11, View view) {
            try {
                f1417a.invoke(dropDownListView, Integer.valueOf(i11), view, Boolean.FALSE, -1, -1);
                f1418b.invoke(dropDownListView, Integer.valueOf(i11));
                f1419c.invoke(dropDownListView, Integer.valueOf(i11));
            } catch (IllegalAccessException e11) {
                e11.printStackTrace();
            } catch (InvocationTargetException e12) {
                e12.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(33)
    public static class c {
        public static boolean a(AbsListView absListView) {
            return absListView.isSelectedChildViewEnabled();
        }

        public static void b(AbsListView absListView, boolean z11) {
            absListView.setSelectedChildViewEnabled(z11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class d extends androidx.appcompat.graphics.drawable.b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f1421b;

        public d(Drawable drawable) {
            super(drawable);
            this.f1421b = true;
        }

        public void b(boolean z11) {
            this.f1421b = z11;
        }

        @Override // androidx.appcompat.graphics.drawable.b, android.graphics.drawable.Drawable
        public void draw(@NonNull Canvas canvas) {
            if (this.f1421b) {
                super.draw(canvas);
            }
        }

        @Override // androidx.appcompat.graphics.drawable.b, android.graphics.drawable.Drawable
        public void setHotspot(float f11, float f12) {
            if (this.f1421b) {
                super.setHotspot(f11, f12);
            }
        }

        @Override // androidx.appcompat.graphics.drawable.b, android.graphics.drawable.Drawable
        public void setHotspotBounds(int i11, int i12, int i13, int i14) {
            if (this.f1421b) {
                super.setHotspotBounds(i11, i12, i13, i14);
            }
        }

        @Override // androidx.appcompat.graphics.drawable.b, android.graphics.drawable.Drawable
        public boolean setState(int[] iArr) {
            if (this.f1421b) {
                return super.setState(iArr);
            }
            return false;
        }

        @Override // androidx.appcompat.graphics.drawable.b, android.graphics.drawable.Drawable
        public boolean setVisible(boolean z11, boolean z12) {
            if (this.f1421b) {
                return super.setVisible(z11, z12);
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Field f1422a;

        static {
            Field declaredField = null;
            try {
                declaredField = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e11) {
                e11.printStackTrace();
            }
            f1422a = declaredField;
        }

        public static boolean a(AbsListView absListView) {
            Field field = f1422a;
            if (field == null) {
                return false;
            }
            try {
                return field.getBoolean(absListView);
            } catch (IllegalAccessException e11) {
                e11.printStackTrace();
                return false;
            }
        }

        public static void b(AbsListView absListView, boolean z11) {
            Field field = f1422a;
            if (field != null) {
                try {
                    field.set(absListView, Boolean.valueOf(z11));
                } catch (IllegalAccessException e11) {
                    e11.printStackTrace();
                }
            }
        }
    }

    public DropDownListView(@NonNull Context context, boolean z11) {
        super(context, null, R$attr.dropDownListViewStyle);
        this.f1404a = new Rect();
        this.f1405b = 0;
        this.f1406c = 0;
        this.f1407d = 0;
        this.f1408f = 0;
        this.f1412j = z11;
        setCacheColorHint(0);
    }

    private void setSelectorEnabled(boolean z11) {
        d dVar = this.f1410h;
        if (dVar != null) {
            dVar.b(z11);
        }
    }

    public final void a() {
        this.f1413k = false;
        setPressed(false);
        drawableStateChanged();
        View childAt = getChildAt(this.f1409g - getFirstVisiblePosition());
        if (childAt != null) {
            childAt.setPressed(false);
        }
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.f1414l;
        if (viewPropertyAnimatorCompat != null) {
            viewPropertyAnimatorCompat.cancel();
            this.f1414l = null;
        }
    }

    public final void b(View view, int i11) {
        performItemClick(view, i11, getItemIdAtPosition(i11));
    }

    public final void c(Canvas canvas) {
        Drawable selector;
        if (this.f1404a.isEmpty() || (selector = getSelector()) == null) {
            return;
        }
        selector.setBounds(this.f1404a);
        selector.draw(canvas);
    }

    public final void d(int i11, View view) {
        Rect rect = this.f1404a;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        rect.left -= this.f1405b;
        rect.top -= this.f1406c;
        rect.right += this.f1407d;
        rect.bottom += this.f1408f;
        boolean zH = h();
        if (view.isEnabled() != zH) {
            i(!zH);
            if (i11 != -1) {
                refreshDrawableState();
            }
        }
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        c(canvas);
        super.dispatchDraw(canvas);
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        if (this.f1416n != null) {
            return;
        }
        super.drawableStateChanged();
        setSelectorEnabled(true);
        k();
    }

    public final void e(int i11, View view) {
        Drawable selector = getSelector();
        boolean z11 = (selector == null || i11 == -1) ? false : true;
        if (z11) {
            selector.setVisible(false, false);
        }
        d(i11, view);
        if (z11) {
            Rect rect = this.f1404a;
            float fExactCenterX = rect.exactCenterX();
            float fExactCenterY = rect.exactCenterY();
            selector.setVisible(getVisibility() == 0, false);
            d3.a.k(selector, fExactCenterX, fExactCenterY);
        }
    }

    public final void f(int i11, View view, float f11, float f12) {
        e(i11, view);
        Drawable selector = getSelector();
        if (selector == null || i11 == -1) {
            return;
        }
        d3.a.k(selector, f11, f12);
    }

    public final void g(View view, int i11, float f11, float f12) {
        View childAt;
        this.f1413k = true;
        a.a(this, f11, f12);
        if (!isPressed()) {
            setPressed(true);
        }
        layoutChildren();
        int i12 = this.f1409g;
        if (i12 != -1 && (childAt = getChildAt(i12 - getFirstVisiblePosition())) != null && childAt != view && childAt.isPressed()) {
            childAt.setPressed(false);
        }
        this.f1409g = i11;
        a.a(view, f11 - view.getLeft(), f12 - view.getTop());
        if (!view.isPressed()) {
            view.setPressed(true);
        }
        f(i11, view, f11, f12);
        setSelectorEnabled(false);
        refreshDrawableState();
    }

    public final boolean h() {
        return Build.VERSION.SDK_INT >= 33 ? c.a(this) : e.a(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean hasFocus() {
        return this.f1412j || super.hasFocus();
    }

    @Override // android.view.View
    public boolean hasWindowFocus() {
        return this.f1412j || super.hasWindowFocus();
    }

    public final void i(boolean z11) {
        if (Build.VERSION.SDK_INT >= 33) {
            c.b(this, z11);
        } else {
            e.b(this, z11);
        }
    }

    @Override // android.view.View
    public boolean isFocused() {
        return this.f1412j || super.isFocused();
    }

    @Override // android.view.View
    public boolean isInTouchMode() {
        return (this.f1412j && this.f1411i) || super.isInTouchMode();
    }

    public final boolean j() {
        return this.f1413k;
    }

    public final void k() {
        Drawable selector = getSelector();
        if (selector != null && j() && isPressed()) {
            selector.setState(getDrawableState());
        }
    }

    public int lookForSelectablePosition(int i11, boolean z11) {
        int iMin;
        ListAdapter adapter = getAdapter();
        if (adapter != null && !isInTouchMode()) {
            int count = adapter.getCount();
            if (!getAdapter().areAllItemsEnabled()) {
                if (z11) {
                    iMin = Math.max(0, i11);
                    while (iMin < count && !adapter.isEnabled(iMin)) {
                        iMin++;
                    }
                } else {
                    iMin = Math.min(i11, count - 1);
                    while (iMin >= 0 && !adapter.isEnabled(iMin)) {
                        iMin--;
                    }
                }
                if (iMin < 0 || iMin >= count) {
                    return -1;
                }
                return iMin;
            }
            if (i11 >= 0 && i11 < count) {
                return i11;
            }
        }
        return -1;
    }

    public int measureHeightOfChildrenCompat(int i11, int i12, int i13, int i14, int i15) {
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        if (adapter == null) {
            return listPaddingTop + listPaddingBottom;
        }
        int measuredHeight = listPaddingTop + listPaddingBottom;
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        int count = adapter.getCount();
        View view = null;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        while (i16 < count) {
            int itemViewType = adapter.getItemViewType(i16);
            if (itemViewType != i17) {
                view = null;
                i17 = itemViewType;
            }
            view = adapter.getView(i16, view, this);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            int i19 = layoutParams.height;
            view.measure(i11, i19 > 0 ? View.MeasureSpec.makeMeasureSpec(i19, 1073741824) : View.MeasureSpec.makeMeasureSpec(0, 0));
            view.forceLayout();
            if (i16 > 0) {
                measuredHeight += dividerHeight;
            }
            measuredHeight += view.getMeasuredHeight();
            if (measuredHeight >= i14) {
                return (i15 < 0 || i16 <= i15 || i18 <= 0 || measuredHeight == i14) ? i14 : i18;
            }
            if (i15 >= 0 && i16 >= i15) {
                i18 = measuredHeight;
            }
            i16++;
        }
        return measuredHeight;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        this.f1416n = null;
        super.onDetachedFromWindow();
    }

    /* JADX WARN: Code duplicated, block: B:23:0x004a  */
    /* JADX WARN: Code duplicated, block: B:25:0x004f  */
    /* JADX WARN: Code duplicated, block: B:27:0x0053  */
    /* JADX WARN: Code duplicated, block: B:29:0x0065  */
    /* JADX WARN: Code duplicated, block: B:31:0x0069  */
    /* JADX WARN: Code duplicated, block: B:9:0x0011  */
    public boolean onForwardedEvent(MotionEvent motionEvent, int i11) {
        boolean z11;
        boolean z12;
        androidx.core.widget.i iVar;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1) {
            z11 = false;
        } else {
            if (actionMasked != 2) {
                if (actionMasked != 3) {
                    z12 = false;
                    z11 = true;
                } else {
                    z12 = false;
                    z11 = false;
                }
                if (z11 || z12) {
                    a();
                }
                if (z11) {
                    if (this.f1415m == null) {
                        this.f1415m = new androidx.core.widget.i(this);
                    }
                    this.f1415m.m(true);
                    this.f1415m.onTouch(this, motionEvent);
                } else {
                    iVar = this.f1415m;
                    if (iVar != null) {
                        iVar.m(false);
                    }
                }
                return z11;
            }
            z11 = true;
        }
        int iFindPointerIndex = motionEvent.findPointerIndex(i11);
        if (iFindPointerIndex < 0) {
            z12 = false;
            z11 = false;
        } else {
            int x11 = (int) motionEvent.getX(iFindPointerIndex);
            int y11 = (int) motionEvent.getY(iFindPointerIndex);
            int iPointToPosition = pointToPosition(x11, y11);
            if (iPointToPosition == -1) {
                z12 = true;
            } else {
                View childAt = getChildAt(iPointToPosition - getFirstVisiblePosition());
                g(childAt, iPointToPosition, x11, y11);
                if (actionMasked == 1) {
                    b(childAt, iPointToPosition);
                }
                z12 = false;
                z11 = true;
            }
        }
        if (z11) {
            a();
        } else {
            a();
        }
        if (z11) {
            if (this.f1415m == null) {
                this.f1415m = new androidx.core.widget.i(this);
            }
            this.f1415m.m(true);
            this.f1415m.onTouch(this, motionEvent);
        } else {
            iVar = this.f1415m;
            if (iVar != null) {
                iVar.m(false);
            }
        }
        return z11;
    }

    @Override // android.view.View
    public boolean onHoverEvent(@NonNull MotionEvent motionEvent) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 < 26) {
            return super.onHoverEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 10 && this.f1416n == null) {
            ResolveHoverRunnable resolveHoverRunnable = new ResolveHoverRunnable();
            this.f1416n = resolveHoverRunnable;
            resolveHoverRunnable.post();
        }
        boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
        if (actionMasked == 9 || actionMasked == 7) {
            int iPointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
            if (iPointToPosition != -1 && iPointToPosition != getSelectedItemPosition()) {
                View childAt = getChildAt(iPointToPosition - getFirstVisiblePosition());
                if (childAt.isEnabled()) {
                    requestFocus();
                    if (i11 < 30 || !b.a()) {
                        setSelectionFromTop(iPointToPosition, childAt.getTop() - getTop());
                    } else {
                        b.b(this, iPointToPosition, childAt);
                    }
                }
                k();
            }
        } else {
            setSelection(-1);
        }
        return zOnHoverEvent;
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f1409g = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        ResolveHoverRunnable resolveHoverRunnable = this.f1416n;
        if (resolveHoverRunnable != null) {
            resolveHoverRunnable.cancel();
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setListSelectionHidden(boolean z11) {
        this.f1411i = z11;
    }

    @Override // android.widget.AbsListView
    public void setSelector(Drawable drawable) {
        d dVar = drawable != null ? new d(drawable) : null;
        this.f1410h = dVar;
        super.setSelector(dVar);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.f1405b = rect.left;
        this.f1406c = rect.top;
        this.f1407d = rect.right;
        this.f1408f = rect.bottom;
    }
}
