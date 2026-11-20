package com.google.android.material.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R$dimen;
import com.google.android.material.R$layout;
import java.util.ArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class s implements androidx.appcompat.view.menu.l {
    public int A;
    public int B;
    public int C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public NavigationMenuView f37065a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LinearLayout f37066b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public androidx.appcompat.view.menu.l.a f37067c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public androidx.appcompat.view.menu.f f37068d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f37069f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public c f37070g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public LayoutInflater f37071h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    public ColorStateList f37073j;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ColorStateList f37076m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ColorStateList f37077n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Drawable f37078o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public RippleDrawable f37079p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f37080q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f37081r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f37082s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f37083t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f37084u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f37085v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f37086w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f37087x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f37088y;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f37072i = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f37074k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f37075l = true;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f37089z = true;
    public int D = -1;
    public final View.OnClickListener E = new a();

    /* JADX INFO: compiled from: source.java */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z11 = true;
            s.this.a0(true);
            androidx.appcompat.view.menu.h itemData = ((NavigationMenuItemView) view).getItemData();
            s sVar = s.this;
            boolean zP = sVar.f37068d.P(itemData, sVar, 0);
            if (itemData != null && itemData.isCheckable() && zP) {
                s.this.f37070g.p(itemData);
            } else {
                z11 = false;
            }
            s.this.a0(false);
            if (z11) {
                s.this.h(false);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b extends l {
        public b(View view) {
            super(view);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c extends RecyclerView.Adapter<l> {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final ArrayList<e> f37091i = new ArrayList<>();

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public androidx.appcompat.view.menu.h f37092j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f37093k;

        /* JADX INFO: compiled from: source.java */
        public class a extends AccessibilityDelegateCompat {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f37095a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ boolean f37096b;

            public a(int i11, boolean z11) {
                this.f37095a = i11;
                this.f37096b = z11;
            }

            @Override // androidx.core.view.AccessibilityDelegateCompat
            public void onInitializeAccessibilityNodeInfo(@NonNull View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(c.this.e(this.f37095a), 1, 1, 1, this.f37096b, view.isSelected()));
            }
        }

        public c() {
            m();
        }

        public final int e(int i11) {
            int i12 = i11;
            for (int i13 = 0; i13 < i11; i13++) {
                if (s.this.f37070g.getItemViewType(i13) == 2 || s.this.f37070g.getItemViewType(i13) == 3) {
                    i12--;
                }
            }
            return i12;
        }

        public final void f(int i11, int i12) {
            while (i11 < i12) {
                ((g) this.f37091i.get(i11)).f37101b = true;
                i11++;
            }
        }

        @NonNull
        public Bundle g() {
            Bundle bundle = new Bundle();
            androidx.appcompat.view.menu.h hVar = this.f37092j;
            if (hVar != null) {
                bundle.putInt("android:menu:checked", hVar.getItemId());
            }
            SparseArray<? extends Parcelable> sparseArray = new SparseArray<>();
            int size = this.f37091i.size();
            for (int i11 = 0; i11 < size; i11++) {
                e eVar = this.f37091i.get(i11);
                if (eVar instanceof g) {
                    androidx.appcompat.view.menu.h hVarA = ((g) eVar).a();
                    View actionView = hVarA != null ? hVarA.getActionView() : null;
                    if (actionView != null) {
                        ParcelableSparseArray parcelableSparseArray = new ParcelableSparseArray();
                        actionView.saveHierarchyState(parcelableSparseArray);
                        sparseArray.put(hVarA.getItemId(), parcelableSparseArray);
                    }
                }
            }
            bundle.putSparseParcelableArray("android:menu:action_views", sparseArray);
            return bundle;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.f37091i.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int i11) {
            return i11;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i11) {
            e eVar = this.f37091i.get(i11);
            if (eVar instanceof f) {
                return 2;
            }
            if (eVar instanceof d) {
                return 3;
            }
            if (eVar instanceof g) {
                return ((g) eVar).a().hasSubMenu() ? 1 : 0;
            }
            throw new RuntimeException("Unknown item type.");
        }

        public androidx.appcompat.view.menu.h h() {
            return this.f37092j;
        }

        public int i() {
            int i11 = 0;
            for (int i12 = 0; i12 < s.this.f37070g.getItemCount(); i12++) {
                int itemViewType = s.this.f37070g.getItemViewType(i12);
                if (itemViewType == 0 || itemViewType == 1) {
                    i11++;
                }
            }
            return i11;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(@NonNull l lVar, int i11) {
            int itemViewType = getItemViewType(i11);
            if (itemViewType != 0) {
                if (itemViewType != 1) {
                    if (itemViewType != 2) {
                        return;
                    }
                    f fVar = (f) this.f37091i.get(i11);
                    lVar.itemView.setPadding(s.this.f37084u, fVar.b(), s.this.f37085v, fVar.a());
                    return;
                }
                TextView textView = (TextView) lVar.itemView;
                textView.setText(((g) this.f37091i.get(i11)).a().getTitle());
                androidx.core.widget.m.p(textView, s.this.f37072i);
                textView.setPadding(s.this.f37086w, textView.getPaddingTop(), s.this.f37087x, textView.getPaddingBottom());
                ColorStateList colorStateList = s.this.f37073j;
                if (colorStateList != null) {
                    textView.setTextColor(colorStateList);
                }
                o(textView, i11, true);
                return;
            }
            NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) lVar.itemView;
            navigationMenuItemView.setIconTintList(s.this.f37077n);
            navigationMenuItemView.setTextAppearance(s.this.f37074k);
            ColorStateList colorStateList2 = s.this.f37076m;
            if (colorStateList2 != null) {
                navigationMenuItemView.setTextColor(colorStateList2);
            }
            Drawable drawable = s.this.f37078o;
            ViewCompat.setBackground(navigationMenuItemView, drawable != null ? drawable.getConstantState().newDrawable() : null);
            RippleDrawable rippleDrawable = s.this.f37079p;
            if (rippleDrawable != null) {
                navigationMenuItemView.setForeground(rippleDrawable.getConstantState().newDrawable());
            }
            g gVar = (g) this.f37091i.get(i11);
            navigationMenuItemView.setNeedsEmptyIcon(gVar.f37101b);
            s sVar = s.this;
            int i12 = sVar.f37080q;
            int i13 = sVar.f37081r;
            navigationMenuItemView.setPadding(i12, i13, i12, i13);
            navigationMenuItemView.setIconPadding(s.this.f37082s);
            s sVar2 = s.this;
            if (sVar2.f37088y) {
                navigationMenuItemView.setIconSize(sVar2.f37083t);
            }
            navigationMenuItemView.setMaxLines(s.this.A);
            navigationMenuItemView.initialize(gVar.a(), s.this.f37075l);
            o(navigationMenuItemView, i11, false);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @Nullable
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public l onCreateViewHolder(ViewGroup viewGroup, int i11) {
            if (i11 == 0) {
                s sVar = s.this;
                return new i(sVar.f37071h, viewGroup, sVar.E);
            }
            if (i11 == 1) {
                return new k(s.this.f37071h, viewGroup);
            }
            if (i11 == 2) {
                return new j(s.this.f37071h, viewGroup);
            }
            if (i11 != 3) {
                return null;
            }
            return new b(s.this.f37066b);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public void onViewRecycled(l lVar) {
            if (lVar instanceof i) {
                ((NavigationMenuItemView) lVar.itemView).recycle();
            }
        }

        public final void m() {
            if (this.f37093k) {
                return;
            }
            this.f37093k = true;
            this.f37091i.clear();
            this.f37091i.add(new d());
            int size = s.this.f37068d.G().size();
            int i11 = -1;
            boolean z11 = false;
            int size2 = 0;
            for (int i12 = 0; i12 < size; i12++) {
                androidx.appcompat.view.menu.h hVar = s.this.f37068d.G().get(i12);
                if (hVar.isChecked()) {
                    p(hVar);
                }
                if (hVar.isCheckable()) {
                    hVar.t(false);
                }
                if (hVar.hasSubMenu()) {
                    SubMenu subMenu = hVar.getSubMenu();
                    if (subMenu.hasVisibleItems()) {
                        if (i12 != 0) {
                            this.f37091i.add(new f(s.this.C, 0));
                        }
                        this.f37091i.add(new g(hVar));
                        int size3 = this.f37091i.size();
                        int size4 = subMenu.size();
                        boolean z12 = false;
                        for (int i13 = 0; i13 < size4; i13++) {
                            androidx.appcompat.view.menu.h hVar2 = (androidx.appcompat.view.menu.h) subMenu.getItem(i13);
                            if (hVar2.isVisible()) {
                                if (!z12 && hVar2.getIcon() != null) {
                                    z12 = true;
                                }
                                if (hVar2.isCheckable()) {
                                    hVar2.t(false);
                                }
                                if (hVar.isChecked()) {
                                    p(hVar);
                                }
                                this.f37091i.add(new g(hVar2));
                            }
                        }
                        if (z12) {
                            f(size3, this.f37091i.size());
                        }
                    }
                } else {
                    int groupId = hVar.getGroupId();
                    if (groupId != i11) {
                        size2 = this.f37091i.size();
                        z11 = hVar.getIcon() != null;
                        if (i12 != 0) {
                            size2++;
                            ArrayList<e> arrayList = this.f37091i;
                            int i14 = s.this.C;
                            arrayList.add(new f(i14, i14));
                        }
                    } else if (!z11 && hVar.getIcon() != null) {
                        f(size2, this.f37091i.size());
                        z11 = true;
                    }
                    g gVar = new g(hVar);
                    gVar.f37101b = z11;
                    this.f37091i.add(gVar);
                    i11 = groupId;
                }
            }
            this.f37093k = false;
        }

        public void n(@NonNull Bundle bundle) {
            androidx.appcompat.view.menu.h hVarA;
            View actionView;
            ParcelableSparseArray parcelableSparseArray;
            androidx.appcompat.view.menu.h hVarA2;
            int i11 = bundle.getInt("android:menu:checked", 0);
            if (i11 != 0) {
                this.f37093k = true;
                int size = this.f37091i.size();
                for (int i12 = 0; i12 < size; i12++) {
                    e eVar = this.f37091i.get(i12);
                    if ((eVar instanceof g) && (hVarA2 = ((g) eVar).a()) != null && hVarA2.getItemId() == i11) {
                        p(hVarA2);
                        break;
                    }
                }
                this.f37093k = false;
                m();
            }
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:action_views");
            if (sparseParcelableArray != null) {
                int size2 = this.f37091i.size();
                for (int i13 = 0; i13 < size2; i13++) {
                    e eVar2 = this.f37091i.get(i13);
                    if ((eVar2 instanceof g) && (hVarA = ((g) eVar2).a()) != null && (actionView = hVarA.getActionView()) != null && (parcelableSparseArray = (ParcelableSparseArray) sparseParcelableArray.get(hVarA.getItemId())) != null) {
                        actionView.restoreHierarchyState(parcelableSparseArray);
                    }
                }
            }
        }

        public final void o(View view, int i11, boolean z11) {
            ViewCompat.setAccessibilityDelegate(view, new a(i11, z11));
        }

        public void p(@NonNull androidx.appcompat.view.menu.h hVar) {
            if (this.f37092j == hVar || !hVar.isCheckable()) {
                return;
            }
            androidx.appcompat.view.menu.h hVar2 = this.f37092j;
            if (hVar2 != null) {
                hVar2.setChecked(false);
            }
            this.f37092j = hVar;
            hVar.setChecked(true);
        }

        public void q(boolean z11) {
            this.f37093k = z11;
        }

        public void r() {
            m();
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class d implements e {
    }

    /* JADX INFO: compiled from: source.java */
    public interface e {
    }

    /* JADX INFO: compiled from: source.java */
    public static class f implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f37098a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f37099b;

        public f(int i11, int i12) {
            this.f37098a = i11;
            this.f37099b = i12;
        }

        public int a() {
            return this.f37099b;
        }

        public int b() {
            return this.f37098a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class g implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final androidx.appcompat.view.menu.h f37100a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f37101b;

        public g(androidx.appcompat.view.menu.h hVar) {
            this.f37100a = hVar;
        }

        public androidx.appcompat.view.menu.h a() {
            return this.f37100a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class h extends androidx.recyclerview.widget.n {
        public h(RecyclerView recyclerView) {
            super(recyclerView);
        }

        @Override // androidx.recyclerview.widget.n, androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(s.this.f37070g.i(), 1, false));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class i extends l {
        public i(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, View.OnClickListener onClickListener) {
            super(layoutInflater.inflate(R$layout.design_navigation_item, viewGroup, false));
            this.itemView.setOnClickListener(onClickListener);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class j extends l {
        public j(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(R$layout.design_navigation_item_separator, viewGroup, false));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class k extends l {
        public k(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(R$layout.design_navigation_item_subheader, viewGroup, false));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class l extends RecyclerView.a0 {
        public l(View view) {
            super(view);
        }
    }

    public int A() {
        return this.f37087x;
    }

    public int B() {
        return this.f37086w;
    }

    public final boolean C() {
        return q() > 0;
    }

    public View D(int i11) {
        View viewInflate = this.f37071h.inflate(i11, (ViewGroup) this.f37066b, false);
        l(viewInflate);
        return viewInflate;
    }

    public void E(@NonNull View view) {
        this.f37066b.removeView(view);
        if (C()) {
            return;
        }
        NavigationMenuView navigationMenuView = this.f37065a;
        navigationMenuView.setPadding(0, this.B, 0, navigationMenuView.getPaddingBottom());
    }

    public void F(boolean z11) {
        if (this.f37089z != z11) {
            this.f37089z = z11;
            b0();
        }
    }

    public void G(@NonNull androidx.appcompat.view.menu.h hVar) {
        this.f37070g.p(hVar);
    }

    public void H(int i11) {
        this.f37085v = i11;
        h(false);
    }

    public void I(int i11) {
        this.f37084u = i11;
        h(false);
    }

    public void J(int i11) {
        this.f37069f = i11;
    }

    public void K(@Nullable Drawable drawable) {
        this.f37078o = drawable;
        h(false);
    }

    public void L(@Nullable RippleDrawable rippleDrawable) {
        this.f37079p = rippleDrawable;
        h(false);
    }

    public void M(int i11) {
        this.f37080q = i11;
        h(false);
    }

    public void N(int i11) {
        this.f37082s = i11;
        h(false);
    }

    public void O(int i11) {
        if (this.f37083t != i11) {
            this.f37083t = i11;
            this.f37088y = true;
            h(false);
        }
    }

    public void P(@Nullable ColorStateList colorStateList) {
        this.f37077n = colorStateList;
        h(false);
    }

    public void Q(int i11) {
        this.A = i11;
        h(false);
    }

    public void R(int i11) {
        this.f37074k = i11;
        h(false);
    }

    public void S(boolean z11) {
        this.f37075l = z11;
        h(false);
    }

    public void T(@Nullable ColorStateList colorStateList) {
        this.f37076m = colorStateList;
        h(false);
    }

    public void U(int i11) {
        this.f37081r = i11;
        h(false);
    }

    public void V(int i11) {
        this.D = i11;
        NavigationMenuView navigationMenuView = this.f37065a;
        if (navigationMenuView != null) {
            navigationMenuView.setOverScrollMode(i11);
        }
    }

    public void W(@Nullable ColorStateList colorStateList) {
        this.f37073j = colorStateList;
        h(false);
    }

    public void X(int i11) {
        this.f37087x = i11;
        h(false);
    }

    public void Y(int i11) {
        this.f37086w = i11;
        h(false);
    }

    public void Z(int i11) {
        this.f37072i = i11;
        h(false);
    }

    public void a0(boolean z11) {
        c cVar = this.f37070g;
        if (cVar != null) {
            cVar.q(z11);
        }
    }

    @Override // androidx.appcompat.view.menu.l
    public void b(androidx.appcompat.view.menu.f fVar, boolean z11) {
        androidx.appcompat.view.menu.l.a aVar = this.f37067c;
        if (aVar != null) {
            aVar.b(fVar, z11);
        }
    }

    public final void b0() {
        int i11 = (C() || !this.f37089z) ? 0 : this.B;
        NavigationMenuView navigationMenuView = this.f37065a;
        navigationMenuView.setPadding(0, i11, 0, navigationMenuView.getPaddingBottom());
    }

    @Override // androidx.appcompat.view.menu.l
    public boolean c(androidx.appcompat.view.menu.f fVar, androidx.appcompat.view.menu.h hVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.l
    public void e(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
            if (sparseParcelableArray != null) {
                this.f37065a.restoreHierarchyState(sparseParcelableArray);
            }
            Bundle bundle2 = bundle.getBundle("android:menu:adapter");
            if (bundle2 != null) {
                this.f37070g.n(bundle2);
            }
            SparseArray<Parcelable> sparseParcelableArray2 = bundle.getSparseParcelableArray("android:menu:header");
            if (sparseParcelableArray2 != null) {
                this.f37066b.restoreHierarchyState(sparseParcelableArray2);
            }
        }
    }

    @Override // androidx.appcompat.view.menu.l
    public boolean f(androidx.appcompat.view.menu.q qVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.l
    @NonNull
    public Parcelable g() {
        Bundle bundle = new Bundle();
        if (this.f37065a != null) {
            SparseArray<Parcelable> sparseArray = new SparseArray<>();
            this.f37065a.saveHierarchyState(sparseArray);
            bundle.putSparseParcelableArray("android:menu:list", sparseArray);
        }
        c cVar = this.f37070g;
        if (cVar != null) {
            bundle.putBundle("android:menu:adapter", cVar.g());
        }
        if (this.f37066b != null) {
            SparseArray<Parcelable> sparseArray2 = new SparseArray<>();
            this.f37066b.saveHierarchyState(sparseArray2);
            bundle.putSparseParcelableArray("android:menu:header", sparseArray2);
        }
        return bundle;
    }

    @Override // androidx.appcompat.view.menu.l
    public int getId() {
        return this.f37069f;
    }

    @Override // androidx.appcompat.view.menu.l
    public void h(boolean z11) {
        c cVar = this.f37070g;
        if (cVar != null) {
            cVar.r();
        }
    }

    @Override // androidx.appcompat.view.menu.l
    public boolean i() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.l
    public boolean j(androidx.appcompat.view.menu.f fVar, androidx.appcompat.view.menu.h hVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.l
    public void k(@NonNull Context context, @NonNull androidx.appcompat.view.menu.f fVar) {
        this.f37071h = LayoutInflater.from(context);
        this.f37068d = fVar;
        this.C = context.getResources().getDimensionPixelOffset(R$dimen.design_navigation_separator_vertical_padding);
    }

    public void l(@NonNull View view) {
        this.f37066b.addView(view);
        NavigationMenuView navigationMenuView = this.f37065a;
        navigationMenuView.setPadding(0, 0, 0, navigationMenuView.getPaddingBottom());
    }

    public void m(@NonNull WindowInsetsCompat windowInsetsCompat) {
        int systemWindowInsetTop = windowInsetsCompat.getSystemWindowInsetTop();
        if (this.B != systemWindowInsetTop) {
            this.B = systemWindowInsetTop;
            b0();
        }
        NavigationMenuView navigationMenuView = this.f37065a;
        navigationMenuView.setPadding(0, navigationMenuView.getPaddingTop(), 0, windowInsetsCompat.getSystemWindowInsetBottom());
        ViewCompat.dispatchApplyWindowInsets(this.f37066b, windowInsetsCompat);
    }

    @Nullable
    public androidx.appcompat.view.menu.h n() {
        return this.f37070g.h();
    }

    public int o() {
        return this.f37085v;
    }

    public int p() {
        return this.f37084u;
    }

    public int q() {
        return this.f37066b.getChildCount();
    }

    public View r(int i11) {
        return this.f37066b.getChildAt(i11);
    }

    @Nullable
    public Drawable s() {
        return this.f37078o;
    }

    public int t() {
        return this.f37080q;
    }

    public int u() {
        return this.f37082s;
    }

    public int v() {
        return this.A;
    }

    @Nullable
    public ColorStateList w() {
        return this.f37076m;
    }

    @Nullable
    public ColorStateList x() {
        return this.f37077n;
    }

    public int y() {
        return this.f37081r;
    }

    public androidx.appcompat.view.menu.m z(ViewGroup viewGroup) {
        if (this.f37065a == null) {
            NavigationMenuView navigationMenuView = (NavigationMenuView) this.f37071h.inflate(R$layout.design_navigation_menu, viewGroup, false);
            this.f37065a = navigationMenuView;
            navigationMenuView.setAccessibilityDelegateCompat(new h(this.f37065a));
            if (this.f37070g == null) {
                c cVar = new c();
                this.f37070g = cVar;
                cVar.setHasStableIds(true);
            }
            int i11 = this.D;
            if (i11 != -1) {
                this.f37065a.setOverScrollMode(i11);
            }
            LinearLayout linearLayout = (LinearLayout) this.f37071h.inflate(R$layout.design_navigation_item_header, (ViewGroup) this.f37065a, false);
            this.f37066b = linearLayout;
            ViewCompat.setImportantForAccessibility(linearLayout, 2);
            this.f37065a.setAdapter(this.f37070g);
        }
        return this.f37065a;
    }
}
