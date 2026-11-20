package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.view.menu.ActionMenuItemView;
import com.google.android.gms.common.api.Api;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class ActionMenuView extends LinearLayoutCompat implements androidx.appcompat.view.menu.f.b, androidx.appcompat.view.menu.m {
    public int A;
    public e B;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public androidx.appcompat.view.menu.f f1284q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Context f1285r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f1286s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f1287t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public ActionMenuPresenter f1288u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public androidx.appcompat.view.menu.l.a f1289v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public androidx.appcompat.view.menu.f.a f1290w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f1291x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f1292y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f1293z;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public interface a {
        boolean needsDividerAfter();

        boolean needsDividerBefore();
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public static class b implements androidx.appcompat.view.menu.l.a {
        @Override // androidx.appcompat.view.menu.l.a
        public void b(@NonNull androidx.appcompat.view.menu.f fVar, boolean z11) {
        }

        @Override // androidx.appcompat.view.menu.l.a
        public boolean c(@NonNull androidx.appcompat.view.menu.f fVar) {
            return false;
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public static class c extends LinearLayoutCompat.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @ViewDebug.ExportedProperty
        public boolean f1294a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @ViewDebug.ExportedProperty
        public int f1295b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @ViewDebug.ExportedProperty
        public int f1296c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @ViewDebug.ExportedProperty
        public boolean f1297d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @ViewDebug.ExportedProperty
        public boolean f1298e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f1299f;

        public c(int i11, int i12) {
            super(i11, i12);
            this.f1294a = false;
        }

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public c(c cVar) {
            super((ViewGroup.LayoutParams) cVar);
            this.f1294a = cVar.f1294a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public class d implements androidx.appcompat.view.menu.f.a {
        public d() {
        }

        @Override // androidx.appcompat.view.menu.f.a
        public boolean a(@NonNull androidx.appcompat.view.menu.f fVar, @NonNull MenuItem menuItem) {
            e eVar = ActionMenuView.this.B;
            return eVar != null && eVar.onMenuItemClick(menuItem);
        }

        @Override // androidx.appcompat.view.menu.f.a
        public void b(@NonNull androidx.appcompat.view.menu.f fVar) {
            androidx.appcompat.view.menu.f.a aVar = ActionMenuView.this.f1290w;
            if (aVar != null) {
                aVar.b(fVar);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public interface e {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public ActionMenuView(@NonNull Context context) {
        this(context, null);
    }

    public ActionMenuView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f11 = context.getResources().getDisplayMetrics().density;
        this.f1293z = (int) (56.0f * f11);
        this.A = (int) (f11 * 4.0f);
        this.f1285r = context;
        this.f1286s = 0;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x004d  */
    public static int x(View view, int i11, int i12, int i13, int i14) {
        int i15;
        c cVar = (c) view.getLayoutParams();
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i13) - i14, View.MeasureSpec.getMode(i13));
        ActionMenuItemView actionMenuItemView = view instanceof ActionMenuItemView ? (ActionMenuItemView) view : null;
        boolean z11 = false;
        boolean z12 = actionMenuItemView != null && actionMenuItemView.hasText();
        if (i12 > 0) {
            i15 = 2;
            if (!z12 || i12 >= 2) {
                view.measure(View.MeasureSpec.makeMeasureSpec(i12 * i11, Integer.MIN_VALUE), iMakeMeasureSpec);
                int measuredWidth = view.getMeasuredWidth();
                int i16 = measuredWidth / i11;
                if (measuredWidth % i11 != 0) {
                    i16++;
                }
                if (!z12 || i16 >= 2) {
                    i15 = i16;
                }
            } else {
                i15 = 0;
            }
        } else {
            i15 = 0;
        }
        if (!cVar.f1294a && z12) {
            z11 = true;
        }
        cVar.f1297d = z11;
        cVar.f1295b = i15;
        view.measure(View.MeasureSpec.makeMeasureSpec(i11 * i15, 1073741824), iMakeMeasureSpec);
        return i15;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof c;
    }

    public void dismissPopupMenus() {
        ActionMenuPresenter actionMenuPresenter = this.f1288u;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.A();
        }
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public c generateLayoutParams(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    public c generateOverflowButtonLayoutParams() {
        c cVarGenerateDefaultLayoutParams = generateDefaultLayoutParams();
        cVarGenerateDefaultLayoutParams.f1294a = true;
        return cVarGenerateDefaultLayoutParams;
    }

    public Menu getMenu() {
        if (this.f1284q == null) {
            Context context = getContext();
            androidx.appcompat.view.menu.f fVar = new androidx.appcompat.view.menu.f(context);
            this.f1284q = fVar;
            fVar.W(new d());
            ActionMenuPresenter actionMenuPresenter = new ActionMenuPresenter(context);
            this.f1288u = actionMenuPresenter;
            actionMenuPresenter.M(true);
            ActionMenuPresenter actionMenuPresenter2 = this.f1288u;
            androidx.appcompat.view.menu.l.a bVar = this.f1289v;
            if (bVar == null) {
                bVar = new b();
            }
            actionMenuPresenter2.d(bVar);
            this.f1284q.c(this.f1288u, this.f1285r);
            this.f1288u.K(this);
        }
        return this.f1284q;
    }

    @Nullable
    public Drawable getOverflowIcon() {
        getMenu();
        return this.f1288u.C();
    }

    public int getPopupTheme() {
        return this.f1286s;
    }

    public int getWindowAnimations() {
        return 0;
    }

    public boolean hideOverflowMenu() {
        ActionMenuPresenter actionMenuPresenter = this.f1288u;
        return actionMenuPresenter != null && actionMenuPresenter.D();
    }

    @Override // androidx.appcompat.view.menu.m
    public void initialize(androidx.appcompat.view.menu.f fVar) {
        this.f1284q = fVar;
    }

    @Override // androidx.appcompat.view.menu.f.b
    public boolean invokeItem(androidx.appcompat.view.menu.h hVar) {
        return this.f1284q.O(hVar, 0);
    }

    public boolean isOverflowMenuShowPending() {
        ActionMenuPresenter actionMenuPresenter = this.f1288u;
        return actionMenuPresenter != null && actionMenuPresenter.F();
    }

    public boolean isOverflowMenuShowing() {
        ActionMenuPresenter actionMenuPresenter = this.f1288u;
        return actionMenuPresenter != null && actionMenuPresenter.G();
    }

    public boolean isOverflowReserved() {
        return this.f1287t;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ActionMenuPresenter actionMenuPresenter = this.f1288u;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.h(false);
            if (this.f1288u.G()) {
                this.f1288u.D();
                this.f1288u.N();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        dismissPopupMenus();
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        int width;
        int paddingLeft;
        if (!this.f1291x) {
            super.onLayout(z11, i11, i12, i13, i14);
            return;
        }
        int childCount = getChildCount();
        int i15 = (i14 - i12) / 2;
        int dividerWidth = getDividerWidth();
        int i16 = i13 - i11;
        int paddingRight = (i16 - getPaddingRight()) - getPaddingLeft();
        boolean zB = y0.b(this);
        int i17 = 0;
        int i18 = 0;
        for (int i19 = 0; i19 < childCount; i19++) {
            View childAt = getChildAt(i19);
            if (childAt.getVisibility() != 8) {
                c cVar = (c) childAt.getLayoutParams();
                if (cVar.f1294a) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (w(i19)) {
                        measuredWidth += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (zB) {
                        paddingLeft = getPaddingLeft() + ((LinearLayout.LayoutParams) cVar).leftMargin;
                        width = paddingLeft + measuredWidth;
                    } else {
                        width = (getWidth() - getPaddingRight()) - ((LinearLayout.LayoutParams) cVar).rightMargin;
                        paddingLeft = width - measuredWidth;
                    }
                    int i21 = i15 - (measuredHeight / 2);
                    childAt.layout(paddingLeft, i21, width, measuredHeight + i21);
                    paddingRight -= measuredWidth;
                    i17 = 1;
                } else {
                    paddingRight -= (childAt.getMeasuredWidth() + ((LinearLayout.LayoutParams) cVar).leftMargin) + ((LinearLayout.LayoutParams) cVar).rightMargin;
                    w(i19);
                    i18++;
                }
            }
        }
        if (childCount == 1 && i17 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i22 = (i16 / 2) - (measuredWidth2 / 2);
            int i23 = i15 - (measuredHeight2 / 2);
            childAt2.layout(i22, i23, measuredWidth2 + i22, measuredHeight2 + i23);
            return;
        }
        int i24 = i18 - (i17 ^ 1);
        int iMax = Math.max(0, i24 > 0 ? paddingRight / i24 : 0);
        if (zB) {
            int width2 = getWidth() - getPaddingRight();
            for (int i25 = 0; i25 < childCount; i25++) {
                View childAt3 = getChildAt(i25);
                c cVar2 = (c) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !cVar2.f1294a) {
                    int i26 = width2 - ((LinearLayout.LayoutParams) cVar2).rightMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i27 = i15 - (measuredHeight3 / 2);
                    childAt3.layout(i26 - measuredWidth3, i27, i26, measuredHeight3 + i27);
                    width2 = i26 - ((measuredWidth3 + ((LinearLayout.LayoutParams) cVar2).leftMargin) + iMax);
                }
            }
            return;
        }
        int paddingLeft2 = getPaddingLeft();
        for (int i28 = 0; i28 < childCount; i28++) {
            View childAt4 = getChildAt(i28);
            c cVar3 = (c) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !cVar3.f1294a) {
                int i29 = paddingLeft2 + ((LinearLayout.LayoutParams) cVar3).leftMargin;
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i31 = i15 - (measuredHeight4 / 2);
                childAt4.layout(i29, i31, i29 + measuredWidth4, measuredHeight4 + i31);
                paddingLeft2 = i29 + measuredWidth4 + ((LinearLayout.LayoutParams) cVar3).rightMargin + iMax;
            }
        }
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    public void onMeasure(int i11, int i12) {
        androidx.appcompat.view.menu.f fVar;
        boolean z11 = this.f1291x;
        boolean z12 = View.MeasureSpec.getMode(i11) == 1073741824;
        this.f1291x = z12;
        if (z11 != z12) {
            this.f1292y = 0;
        }
        int size = View.MeasureSpec.getSize(i11);
        if (this.f1291x && (fVar = this.f1284q) != null && size != this.f1292y) {
            this.f1292y = size;
            fVar.N(true);
        }
        int childCount = getChildCount();
        if (this.f1291x && childCount > 0) {
            y(i11, i12);
            return;
        }
        for (int i13 = 0; i13 < childCount; i13++) {
            c cVar = (c) getChildAt(i13).getLayoutParams();
            ((LinearLayout.LayoutParams) cVar).rightMargin = 0;
            ((LinearLayout.LayoutParams) cVar).leftMargin = 0;
        }
        super.onMeasure(i11, i12);
    }

    public androidx.appcompat.view.menu.f peekMenu() {
        return this.f1284q;
    }

    public void setExpandedActionViewsExclusive(boolean z11) {
        this.f1288u.J(z11);
    }

    public void setMenuCallbacks(androidx.appcompat.view.menu.l.a aVar, androidx.appcompat.view.menu.f.a aVar2) {
        this.f1289v = aVar;
        this.f1290w = aVar2;
    }

    public void setOnMenuItemClickListener(e eVar) {
        this.B = eVar;
    }

    public void setOverflowIcon(@Nullable Drawable drawable) {
        getMenu();
        this.f1288u.L(drawable);
    }

    public void setOverflowReserved(boolean z11) {
        this.f1287t = z11;
    }

    public void setPopupTheme(int i11) {
        if (this.f1286s != i11) {
            this.f1286s = i11;
            if (i11 == 0) {
                this.f1285r = getContext();
            } else {
                this.f1285r = new ContextThemeWrapper(getContext(), i11);
            }
        }
    }

    public void setPresenter(ActionMenuPresenter actionMenuPresenter) {
        this.f1288u = actionMenuPresenter;
        actionMenuPresenter.K(this);
    }

    public boolean showOverflowMenu() {
        ActionMenuPresenter actionMenuPresenter = this.f1288u;
        return actionMenuPresenter != null && actionMenuPresenter.N();
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public c generateDefaultLayoutParams() {
        c cVar = new c(-2, -2);
        ((LinearLayout.LayoutParams) cVar).gravity = 16;
        return cVar;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public c generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams == null) {
            return generateDefaultLayoutParams();
        }
        c cVar = layoutParams instanceof c ? new c((c) layoutParams) : new c(layoutParams);
        if (((LinearLayout.LayoutParams) cVar).gravity <= 0) {
            ((LinearLayout.LayoutParams) cVar).gravity = 16;
        }
        return cVar;
    }

    public boolean w(int i11) {
        boolean zNeedsDividerAfter = false;
        if (i11 == 0) {
            return false;
        }
        KeyEvent.Callback childAt = getChildAt(i11 - 1);
        KeyEvent.Callback childAt2 = getChildAt(i11);
        if (i11 < getChildCount() && (childAt instanceof a)) {
            zNeedsDividerAfter = ((a) childAt).needsDividerAfter();
        }
        return (i11 <= 0 || !(childAt2 instanceof a)) ? zNeedsDividerAfter : zNeedsDividerAfter | ((a) childAt2).needsDividerBefore();
    }

    /* JADX WARN: Type inference failed for: r14v12 */
    /* JADX WARN: Type inference failed for: r14v8 */
    /* JADX WARN: Type inference failed for: r14v9, types: [boolean, int] */
    public final void y(int i11, int i12) {
        boolean z11;
        int i13;
        boolean z12;
        ?? r14;
        int mode = View.MeasureSpec.getMode(i12);
        int size = View.MeasureSpec.getSize(i11);
        int size2 = View.MeasureSpec.getSize(i12);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i12, paddingTop, -2);
        int i14 = size - paddingLeft;
        int i15 = this.f1293z;
        int i16 = i14 / i15;
        int i17 = i14 % i15;
        if (i16 == 0) {
            setMeasuredDimension(i14, 0);
            return;
        }
        int i18 = i15 + (i17 / i16);
        int childCount = getChildCount();
        int iMax = 0;
        int i19 = 0;
        boolean z13 = false;
        int i21 = 0;
        int iMax2 = 0;
        int i22 = 0;
        long j11 = 0;
        while (i19 < childCount) {
            View childAt = getChildAt(i19);
            int i23 = size2;
            if (childAt.getVisibility() != 8) {
                boolean z14 = childAt instanceof ActionMenuItemView;
                int i24 = i21 + 1;
                if (z14) {
                    int i25 = this.A;
                    r14 = 0;
                    childAt.setPadding(i25, 0, i25, 0);
                } else {
                    r14 = 0;
                }
                c cVar = (c) childAt.getLayoutParams();
                cVar.f1299f = r14;
                cVar.f1296c = r14;
                cVar.f1295b = r14;
                cVar.f1297d = r14;
                ((LinearLayout.LayoutParams) cVar).leftMargin = r14;
                ((LinearLayout.LayoutParams) cVar).rightMargin = r14;
                cVar.f1298e = z14 && ((ActionMenuItemView) childAt).hasText();
                int iX = x(childAt, i18, cVar.f1294a ? 1 : i16, childMeasureSpec, paddingTop);
                iMax2 = Math.max(iMax2, iX);
                if (cVar.f1297d) {
                    i22++;
                }
                if (cVar.f1294a) {
                    z13 = true;
                }
                i16 -= iX;
                iMax = Math.max(iMax, childAt.getMeasuredHeight());
                if (iX == 1) {
                    j11 |= (long) (1 << i19);
                    iMax = iMax;
                }
                i21 = i24;
            }
            i19++;
            size2 = i23;
        }
        int i26 = size2;
        boolean z15 = z13 && i21 == 2;
        boolean z16 = false;
        while (true) {
            if (i22 <= 0 || i16 <= 0) {
                z11 = z16;
                i13 = iMax;
                break;
            }
            int i27 = 0;
            int i28 = 0;
            int i29 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            long j12 = 0;
            while (i28 < childCount) {
                boolean z17 = z16;
                c cVar2 = (c) getChildAt(i28).getLayoutParams();
                int i31 = iMax;
                if (cVar2.f1297d) {
                    int i32 = cVar2.f1295b;
                    if (i32 < i29) {
                        j12 = 1 << i28;
                        i29 = i32;
                        i27 = 1;
                    } else if (i32 == i29) {
                        i27++;
                        j12 |= 1 << i28;
                    }
                }
                i28++;
                iMax = i31;
                z16 = z17;
            }
            z11 = z16;
            i13 = iMax;
            j11 |= j12;
            if (i27 > i16) {
                break;
            }
            int i33 = i29 + 1;
            int i34 = 0;
            while (i34 < childCount) {
                View childAt2 = getChildAt(i34);
                c cVar3 = (c) childAt2.getLayoutParams();
                int i35 = i14;
                int i36 = mode;
                long j13 = 1 << i34;
                if ((j12 & j13) == 0) {
                    if (cVar3.f1295b == i33) {
                        j11 |= j13;
                    }
                    z15 = z15;
                } else {
                    if (z15 && cVar3.f1298e && i16 == 1) {
                        int i37 = this.A;
                        childAt2.setPadding(i37 + i18, 0, i37, 0);
                    }
                    cVar3.f1295b++;
                    cVar3.f1299f = true;
                    i16--;
                }
                i34++;
                mode = i36;
                i14 = i35;
                z15 = z15;
            }
            iMax = i13;
            z16 = true;
        }
        boolean z18 = !z13 && i21 == 1;
        if (i16 <= 0 || j11 == 0 || (i16 >= i21 - 1 && !z18 && iMax2 <= 1)) {
            z12 = z11;
        } else {
            float fBitCount = Long.bitCount(j11);
            if (!z18) {
                if ((j11 & 1) != 0 && !((c) getChildAt(0).getLayoutParams()).f1298e) {
                    fBitCount -= 0.5f;
                }
                int i38 = childCount - 1;
                if ((j11 & ((long) (1 << i38))) != 0 && !((c) getChildAt(i38).getLayoutParams()).f1298e) {
                    fBitCount -= 0.5f;
                }
            }
            int i39 = fBitCount > 0.0f ? (int) ((i16 * i18) / fBitCount) : 0;
            z12 = z11;
            for (int i40 = 0; i40 < childCount; i40++) {
                if ((j11 & ((long) (1 << i40))) != 0) {
                    View childAt3 = getChildAt(i40);
                    c cVar4 = (c) childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        cVar4.f1296c = i39;
                        cVar4.f1299f = true;
                        if (i40 == 0 && !cVar4.f1298e) {
                            ((LinearLayout.LayoutParams) cVar4).leftMargin = (-i39) / 2;
                        }
                    } else if (cVar4.f1294a) {
                        cVar4.f1296c = i39;
                        cVar4.f1299f = true;
                        ((LinearLayout.LayoutParams) cVar4).rightMargin = (-i39) / 2;
                    } else {
                        if (i40 != 0) {
                            ((LinearLayout.LayoutParams) cVar4).leftMargin = i39 / 2;
                        }
                        if (i40 != childCount - 1) {
                            ((LinearLayout.LayoutParams) cVar4).rightMargin = i39 / 2;
                        }
                    }
                    z12 = true;
                }
            }
        }
        if (z12) {
            for (int i41 = 0; i41 < childCount; i41++) {
                View childAt4 = getChildAt(i41);
                c cVar5 = (c) childAt4.getLayoutParams();
                if (cVar5.f1299f) {
                    childAt4.measure(View.MeasureSpec.makeMeasureSpec((cVar5.f1295b * i18) + cVar5.f1296c, 1073741824), childMeasureSpec);
                }
            }
        }
        setMeasuredDimension(i14, mode != 1073741824 ? i13 : i26);
    }
}
