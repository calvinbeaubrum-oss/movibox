package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$layout;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.core.view.ActionProvider;
import androidx.core.view.GravityCompat;
import java.util.ArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class ActionMenuPresenter extends androidx.appcompat.view.menu.b implements ActionProvider.SubUiVisibilityListener {
    public a A;
    public OpenOverflowRunnable B;
    public b C;
    public final e D;
    public int E;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public c f1262l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Drawable f1263m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f1264n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f1265o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f1266p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f1267q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f1268r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f1269s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f1270t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f1271u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f1272v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f1273w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f1274x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final SparseBooleanArray f1275y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public d f1276z;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public class OpenOverflowRunnable implements Runnable {
        private d mPopup;

        public OpenOverflowRunnable(d dVar) {
            this.mPopup = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ActionMenuPresenter.this.f1066c != null) {
                ActionMenuPresenter.this.f1066c.d();
            }
            View view = (View) ActionMenuPresenter.this.f1072j;
            if (view != null && view.getWindowToken() != null && this.mPopup.m()) {
                ActionMenuPresenter.this.f1276z = this.mPopup;
            }
            ActionMenuPresenter.this.B = null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    @SuppressLint({"BanParcelableUsage"})
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        public int openSubMenuId;

        /* JADX INFO: compiled from: source.java */
        public class a implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i11) {
                return new SavedState[i11];
            }
        }

        public SavedState() {
        }

        public SavedState(Parcel parcel) {
            this.openSubMenuId = parcel.readInt();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i11) {
            parcel.writeInt(this.openSubMenuId);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public class a extends androidx.appcompat.view.menu.k {
        public a(Context context, androidx.appcompat.view.menu.q qVar, View view) {
            super(context, qVar, view, false, R$attr.actionOverflowMenuStyle);
            if (!((androidx.appcompat.view.menu.h) qVar.getItem()).l()) {
                View view2 = ActionMenuPresenter.this.f1262l;
                f(view2 == null ? (View) ActionMenuPresenter.this.f1072j : view2);
            }
            j(ActionMenuPresenter.this.D);
        }

        @Override // androidx.appcompat.view.menu.k
        public void e() {
            ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
            actionMenuPresenter.A = null;
            actionMenuPresenter.E = 0;
            super.e();
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public class b extends ActionMenuItemView.b {
        public b() {
        }

        @Override // androidx.appcompat.view.menu.ActionMenuItemView.b
        public androidx.appcompat.view.menu.o a() {
            a aVar = ActionMenuPresenter.this.A;
            if (aVar != null) {
                return aVar.c();
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public class c extends AppCompatImageView implements ActionMenuView.a {

        /* JADX INFO: compiled from: source.java */
        public class a extends ForwardingListener {

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            public final /* synthetic */ ActionMenuPresenter f1280k;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(View view, ActionMenuPresenter actionMenuPresenter) {
                super(view);
                this.f1280k = actionMenuPresenter;
            }

            @Override // androidx.appcompat.widget.ForwardingListener
            public androidx.appcompat.view.menu.o b() {
                d dVar = ActionMenuPresenter.this.f1276z;
                if (dVar == null) {
                    return null;
                }
                return dVar.c();
            }

            @Override // androidx.appcompat.widget.ForwardingListener
            public boolean c() {
                ActionMenuPresenter.this.N();
                return true;
            }

            @Override // androidx.appcompat.widget.ForwardingListener
            public boolean d() {
                ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
                if (actionMenuPresenter.B != null) {
                    return false;
                }
                actionMenuPresenter.D();
                return true;
            }
        }

        public c(Context context) {
            super(context, null, R$attr.actionOverflowButtonStyle);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            s0.a(this, getContentDescription());
            setOnTouchListener(new a(this, ActionMenuPresenter.this));
        }

        @Override // androidx.appcompat.widget.ActionMenuView.a
        public boolean needsDividerAfter() {
            return false;
        }

        @Override // androidx.appcompat.widget.ActionMenuView.a
        public boolean needsDividerBefore() {
            return false;
        }

        @Override // android.view.View
        public boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            ActionMenuPresenter.this.N();
            return true;
        }

        @Override // android.widget.ImageView
        public boolean setFrame(int i11, int i12, int i13, int i14) {
            boolean frame = super.setFrame(i11, i12, i13, i14);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (drawable != null && background != null) {
                int width = getWidth();
                int height = getHeight();
                int iMax = Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                d3.a.l(background, paddingLeft - iMax, paddingTop - iMax, paddingLeft + iMax, paddingTop + iMax);
            }
            return frame;
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public class d extends androidx.appcompat.view.menu.k {
        public d(Context context, androidx.appcompat.view.menu.f fVar, View view, boolean z11) {
            super(context, fVar, view, z11, R$attr.actionOverflowMenuStyle);
            h(GravityCompat.END);
            j(ActionMenuPresenter.this.D);
        }

        @Override // androidx.appcompat.view.menu.k
        public void e() {
            if (ActionMenuPresenter.this.f1066c != null) {
                ActionMenuPresenter.this.f1066c.close();
            }
            ActionMenuPresenter.this.f1276z = null;
            super.e();
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public class e implements androidx.appcompat.view.menu.l.a {
        public e() {
        }

        @Override // androidx.appcompat.view.menu.l.a
        public void b(@NonNull androidx.appcompat.view.menu.f fVar, boolean z11) {
            if (fVar instanceof androidx.appcompat.view.menu.q) {
                fVar.F().e(false);
            }
            androidx.appcompat.view.menu.l.a aVarO = ActionMenuPresenter.this.o();
            if (aVarO != null) {
                aVarO.b(fVar, z11);
            }
        }

        @Override // androidx.appcompat.view.menu.l.a
        public boolean c(@NonNull androidx.appcompat.view.menu.f fVar) {
            if (fVar == ActionMenuPresenter.this.f1066c) {
                return false;
            }
            ActionMenuPresenter.this.E = ((androidx.appcompat.view.menu.q) fVar).getItem().getItemId();
            androidx.appcompat.view.menu.l.a aVarO = ActionMenuPresenter.this.o();
            if (aVarO != null) {
                return aVarO.c(fVar);
            }
            return false;
        }
    }

    public ActionMenuPresenter(Context context) {
        super(context, R$layout.abc_action_menu_layout, R$layout.abc_action_menu_item_layout);
        this.f1275y = new SparseBooleanArray();
        this.D = new e();
    }

    public boolean A() {
        return D() | E();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final View B(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.f1072j;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = viewGroup.getChildAt(i11);
            if ((childAt instanceof androidx.appcompat.view.menu.m.a) && ((androidx.appcompat.view.menu.m.a) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    public Drawable C() {
        c cVar = this.f1262l;
        if (cVar != null) {
            return cVar.getDrawable();
        }
        if (this.f1264n) {
            return this.f1263m;
        }
        return null;
    }

    public boolean D() {
        Object obj;
        OpenOverflowRunnable openOverflowRunnable = this.B;
        if (openOverflowRunnable != null && (obj = this.f1072j) != null) {
            ((View) obj).removeCallbacks(openOverflowRunnable);
            this.B = null;
            return true;
        }
        d dVar = this.f1276z;
        if (dVar == null) {
            return false;
        }
        dVar.b();
        return true;
    }

    public boolean E() {
        a aVar = this.A;
        if (aVar == null) {
            return false;
        }
        aVar.b();
        return true;
    }

    public boolean F() {
        return this.B != null || G();
    }

    public boolean G() {
        d dVar = this.f1276z;
        return dVar != null && dVar.d();
    }

    public boolean H() {
        return this.f1265o;
    }

    public void I(Configuration configuration) {
        if (!this.f1270t) {
            this.f1269s = g1.a.b(this.f1065b).d();
        }
        androidx.appcompat.view.menu.f fVar = this.f1066c;
        if (fVar != null) {
            fVar.N(true);
        }
    }

    public void J(boolean z11) {
        this.f1273w = z11;
    }

    public void K(ActionMenuView actionMenuView) {
        this.f1072j = actionMenuView;
        actionMenuView.initialize(this.f1066c);
    }

    public void L(Drawable drawable) {
        c cVar = this.f1262l;
        if (cVar != null) {
            cVar.setImageDrawable(drawable);
        } else {
            this.f1264n = true;
            this.f1263m = drawable;
        }
    }

    public void M(boolean z11) {
        this.f1265o = z11;
        this.f1266p = true;
    }

    public boolean N() {
        androidx.appcompat.view.menu.f fVar;
        if (!this.f1265o || G() || (fVar = this.f1066c) == null || this.f1072j == null || this.B != null || fVar.B().isEmpty()) {
            return false;
        }
        OpenOverflowRunnable openOverflowRunnable = new OpenOverflowRunnable(new d(this.f1065b, this.f1066c, this.f1262l, true));
        this.B = openOverflowRunnable;
        ((View) this.f1072j).post(openOverflowRunnable);
        return true;
    }

    @Override // androidx.appcompat.view.menu.b, androidx.appcompat.view.menu.l
    public void b(androidx.appcompat.view.menu.f fVar, boolean z11) {
        A();
        super.b(fVar, z11);
    }

    @Override // androidx.appcompat.view.menu.l
    public void e(Parcelable parcelable) {
        int i11;
        MenuItem menuItemFindItem;
        if ((parcelable instanceof SavedState) && (i11 = ((SavedState) parcelable).openSubMenuId) > 0 && (menuItemFindItem = this.f1066c.findItem(i11)) != null) {
            f((androidx.appcompat.view.menu.q) menuItemFindItem.getSubMenu());
        }
    }

    @Override // androidx.appcompat.view.menu.b, androidx.appcompat.view.menu.l
    public boolean f(androidx.appcompat.view.menu.q qVar) {
        boolean z11 = false;
        if (!qVar.hasVisibleItems()) {
            return false;
        }
        androidx.appcompat.view.menu.q qVar2 = qVar;
        while (qVar2.j0() != this.f1066c) {
            qVar2 = (androidx.appcompat.view.menu.q) qVar2.j0();
        }
        View viewB = B(qVar2.getItem());
        if (viewB == null) {
            return false;
        }
        this.E = qVar.getItem().getItemId();
        int size = qVar.size();
        for (int i11 = 0; i11 < size; i11++) {
            MenuItem item = qVar.getItem(i11);
            if (item.isVisible() && item.getIcon() != null) {
                z11 = true;
                break;
            }
        }
        a aVar = new a(this.f1065b, qVar, viewB);
        this.A = aVar;
        aVar.g(z11);
        this.A.k();
        super.f(qVar);
        return true;
    }

    @Override // androidx.appcompat.view.menu.l
    public Parcelable g() {
        SavedState savedState = new SavedState();
        savedState.openSubMenuId = this.E;
        return savedState;
    }

    @Override // androidx.appcompat.view.menu.b, androidx.appcompat.view.menu.l
    public void h(boolean z11) {
        int size;
        super.h(z11);
        ((View) this.f1072j).requestLayout();
        androidx.appcompat.view.menu.f fVar = this.f1066c;
        if (fVar != null) {
            ArrayList<androidx.appcompat.view.menu.h> arrayListU = fVar.u();
            int size2 = arrayListU.size();
            for (int i11 = 0; i11 < size2; i11++) {
                ActionProvider actionProviderA = arrayListU.get(i11).a();
                if (actionProviderA != null) {
                    actionProviderA.setSubUiVisibilityListener(this);
                }
            }
        }
        androidx.appcompat.view.menu.f fVar2 = this.f1066c;
        ArrayList<androidx.appcompat.view.menu.h> arrayListB = fVar2 != null ? fVar2.B() : null;
        if (!this.f1265o || arrayListB == null || ((size = arrayListB.size()) != 1 ? size <= 0 : !(!arrayListB.get(0).isActionViewExpanded()))) {
            c cVar = this.f1262l;
            if (cVar != null) {
                Object parent = cVar.getParent();
                Object obj = this.f1072j;
                if (parent == obj) {
                    ((ViewGroup) obj).removeView(this.f1262l);
                }
            }
        } else {
            if (this.f1262l == null) {
                this.f1262l = new c(this.f1064a);
            }
            ViewGroup viewGroup = (ViewGroup) this.f1262l.getParent();
            if (viewGroup != this.f1072j) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.f1262l);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.f1072j;
                actionMenuView.addView(this.f1262l, actionMenuView.generateOverflowButtonLayoutParams());
            }
        }
        ((ActionMenuView) this.f1072j).setOverflowReserved(this.f1265o);
    }

    @Override // androidx.appcompat.view.menu.l
    public boolean i() {
        ArrayList<androidx.appcompat.view.menu.h> arrayListG;
        int size;
        int i11;
        int iX;
        ActionMenuPresenter actionMenuPresenter = this;
        androidx.appcompat.view.menu.f fVar = actionMenuPresenter.f1066c;
        View view = null;
        int i12 = 0;
        if (fVar != null) {
            arrayListG = fVar.G();
            size = arrayListG.size();
        } else {
            arrayListG = null;
            size = 0;
        }
        int i13 = actionMenuPresenter.f1269s;
        int i14 = actionMenuPresenter.f1268r;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) actionMenuPresenter.f1072j;
        boolean z11 = false;
        int i15 = 0;
        int i16 = 0;
        for (int i17 = 0; i17 < size; i17++) {
            androidx.appcompat.view.menu.h hVar = arrayListG.get(i17);
            if (hVar.o()) {
                i15++;
            } else if (hVar.n()) {
                i16++;
            } else {
                z11 = true;
            }
            if (actionMenuPresenter.f1273w && hVar.isActionViewExpanded()) {
                i13 = 0;
            }
        }
        if (actionMenuPresenter.f1265o && (z11 || i16 + i15 > i13)) {
            i13--;
        }
        int i18 = i13 - i15;
        SparseBooleanArray sparseBooleanArray = actionMenuPresenter.f1275y;
        sparseBooleanArray.clear();
        if (actionMenuPresenter.f1271u) {
            int i19 = actionMenuPresenter.f1274x;
            iX = i14 / i19;
            i11 = i19 + ((i14 % i19) / iX);
        } else {
            i11 = 0;
            iX = 0;
        }
        int i21 = 0;
        int i22 = 0;
        while (i21 < size) {
            androidx.appcompat.view.menu.h hVar2 = arrayListG.get(i21);
            if (hVar2.o()) {
                View viewP = actionMenuPresenter.p(hVar2, view, viewGroup);
                if (actionMenuPresenter.f1271u) {
                    iX -= ActionMenuView.x(viewP, i11, iX, iMakeMeasureSpec, i12);
                } else {
                    viewP.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                }
                int measuredWidth = viewP.getMeasuredWidth();
                i14 -= measuredWidth;
                if (i22 == 0) {
                    i22 = measuredWidth;
                }
                int groupId = hVar2.getGroupId();
                if (groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                }
                hVar2.u(true);
            } else {
                if (hVar2.n()) {
                    int groupId2 = hVar2.getGroupId();
                    boolean z12 = sparseBooleanArray.get(groupId2);
                    boolean z13 = (i18 > 0 || z12) && i14 > 0 && (!actionMenuPresenter.f1271u || iX > 0);
                    boolean z14 = z13;
                    if (z13) {
                        View viewP2 = actionMenuPresenter.p(hVar2, null, viewGroup);
                        if (actionMenuPresenter.f1271u) {
                            int iX2 = ActionMenuView.x(viewP2, i11, iX, iMakeMeasureSpec, 0);
                            iX -= iX2;
                            if (iX2 == 0) {
                                z14 = false;
                            }
                        } else {
                            viewP2.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                        }
                        boolean z15 = z14;
                        int measuredWidth2 = viewP2.getMeasuredWidth();
                        i14 -= measuredWidth2;
                        if (i22 == 0) {
                            i22 = measuredWidth2;
                        }
                        z13 = z15 & (!actionMenuPresenter.f1271u ? i14 + i22 <= 0 : i14 < 0);
                    }
                    if (z13 && groupId2 != 0) {
                        sparseBooleanArray.put(groupId2, true);
                    } else if (z12) {
                        sparseBooleanArray.put(groupId2, false);
                        for (int i23 = 0; i23 < i21; i23++) {
                            androidx.appcompat.view.menu.h hVar3 = arrayListG.get(i23);
                            if (hVar3.getGroupId() == groupId2) {
                                if (hVar3.l()) {
                                    i18++;
                                }
                                hVar3.u(false);
                            }
                        }
                    }
                    if (z13) {
                        i18--;
                    }
                    hVar2.u(z13);
                } else {
                    size = size;
                    hVar2.u(false);
                }
                i21++;
                view = null;
                actionMenuPresenter = this;
                size = size;
                i12 = 0;
            }
            i21++;
            view = null;
            actionMenuPresenter = this;
            size = size;
            i12 = 0;
        }
        return true;
    }

    @Override // androidx.appcompat.view.menu.b, androidx.appcompat.view.menu.l
    public void k(@NonNull Context context, @Nullable androidx.appcompat.view.menu.f fVar) {
        super.k(context, fVar);
        Resources resources = context.getResources();
        g1.a aVarB = g1.a.b(context);
        if (!this.f1266p) {
            this.f1265o = aVarB.h();
        }
        if (!this.f1272v) {
            this.f1267q = aVarB.c();
        }
        if (!this.f1270t) {
            this.f1269s = aVarB.d();
        }
        int measuredWidth = this.f1267q;
        if (this.f1265o) {
            if (this.f1262l == null) {
                c cVar = new c(this.f1064a);
                this.f1262l = cVar;
                if (this.f1264n) {
                    cVar.setImageDrawable(this.f1263m);
                    this.f1263m = null;
                    this.f1264n = false;
                }
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.f1262l.measure(iMakeMeasureSpec, iMakeMeasureSpec);
            }
            measuredWidth -= this.f1262l.getMeasuredWidth();
        } else {
            this.f1262l = null;
        }
        this.f1268r = measuredWidth;
        this.f1274x = (int) (resources.getDisplayMetrics().density * 56.0f);
    }

    @Override // androidx.appcompat.view.menu.b
    public void l(androidx.appcompat.view.menu.h hVar, androidx.appcompat.view.menu.m.a aVar) {
        aVar.initialize(hVar, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) aVar;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.f1072j);
        if (this.C == null) {
            this.C = new b();
        }
        actionMenuItemView.setPopupCallback(this.C);
    }

    @Override // androidx.appcompat.view.menu.b
    public boolean n(ViewGroup viewGroup, int i11) {
        if (viewGroup.getChildAt(i11) == this.f1262l) {
            return false;
        }
        return super.n(viewGroup, i11);
    }

    @Override // androidx.core.view.ActionProvider.SubUiVisibilityListener
    public void onSubUiVisibilityChanged(boolean z11) {
        if (z11) {
            super.f(null);
            return;
        }
        androidx.appcompat.view.menu.f fVar = this.f1066c;
        if (fVar != null) {
            fVar.e(false);
        }
    }

    @Override // androidx.appcompat.view.menu.b
    public View p(androidx.appcompat.view.menu.h hVar, View view, ViewGroup viewGroup) {
        View actionView = hVar.getActionView();
        if (actionView == null || hVar.j()) {
            actionView = super.p(hVar, view, viewGroup);
        }
        actionView.setVisibility(hVar.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.generateLayoutParams(layoutParams));
        }
        return actionView;
    }

    @Override // androidx.appcompat.view.menu.b
    public androidx.appcompat.view.menu.m q(ViewGroup viewGroup) {
        androidx.appcompat.view.menu.m mVar = this.f1072j;
        androidx.appcompat.view.menu.m mVarQ = super.q(viewGroup);
        if (mVar != mVarQ) {
            ((ActionMenuView) mVarQ).setPresenter(this);
        }
        return mVarQ;
    }

    @Override // androidx.appcompat.view.menu.b
    public boolean s(int i11, androidx.appcompat.view.menu.h hVar) {
        return hVar.l();
    }
}
