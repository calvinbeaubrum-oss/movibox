package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Parcelable;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$layout;
import androidx.appcompat.widget.MenuPopupWindow;
import androidx.appcompat.widget.d0;
import androidx.core.view.GravityCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class CascadingMenuPopup extends j implements View.OnKeyListener, PopupWindow.OnDismissListener {
    public static final int C = R$layout.abc_cascading_menu_item_layout;
    public PopupWindow.OnDismissListener A;
    public boolean B;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f994b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f995c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f996d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f997f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f998g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Handler f999h;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public View f1007p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public View f1008q;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f1010s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f1011t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f1012u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f1013v;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f1015x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public l.a f1016y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public ViewTreeObserver f1017z;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<f> f1000i = new ArrayList();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<c> f1001j = new ArrayList();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ViewTreeObserver.OnGlobalLayoutListener f1002k = new a();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final View.OnAttachStateChangeListener f1003l = new b();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final d0 f1004m = new d0() { // from class: androidx.appcompat.view.menu.CascadingMenuPopup.3
        @Override // androidx.appcompat.widget.d0
        public void d(@NonNull final f fVar, @NonNull final MenuItem menuItem) {
            CascadingMenuPopup.this.f999h.removeCallbacksAndMessages(null);
            int size = CascadingMenuPopup.this.f1001j.size();
            int i11 = 0;
            while (true) {
                if (i11 >= size) {
                    i11 = -1;
                    break;
                } else if (fVar == CascadingMenuPopup.this.f1001j.get(i11).f1022b) {
                    break;
                } else {
                    i11++;
                }
            }
            if (i11 == -1) {
                return;
            }
            int i12 = i11 + 1;
            final c cVar = i12 < CascadingMenuPopup.this.f1001j.size() ? CascadingMenuPopup.this.f1001j.get(i12) : null;
            CascadingMenuPopup.this.f999h.postAtTime(new Runnable() { // from class: androidx.appcompat.view.menu.CascadingMenuPopup.3.1
                @Override // java.lang.Runnable
                public void run() {
                    c cVar2 = cVar;
                    if (cVar2 != null) {
                        CascadingMenuPopup.this.B = true;
                        cVar2.f1022b.e(false);
                        CascadingMenuPopup.this.B = false;
                    }
                    if (menuItem.isEnabled() && menuItem.hasSubMenu()) {
                        fVar.O(menuItem, 4);
                    }
                }
            }, fVar, SystemClock.uptimeMillis() + 200);
        }

        @Override // androidx.appcompat.widget.d0
        public void n(@NonNull f fVar, @NonNull MenuItem menuItem) {
            CascadingMenuPopup.this.f999h.removeCallbacksAndMessages(fVar);
        }
    };

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f1005n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f1006o = 0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f1014w = false;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f1009r = E();

    /* JADX INFO: compiled from: source.java */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!CascadingMenuPopup.this.a() || CascadingMenuPopup.this.f1001j.size() <= 0 || CascadingMenuPopup.this.f1001j.get(0).f1021a.A()) {
                return;
            }
            View view = CascadingMenuPopup.this.f1008q;
            if (view == null || !view.isShown()) {
                CascadingMenuPopup.this.dismiss();
                return;
            }
            Iterator<c> it = CascadingMenuPopup.this.f1001j.iterator();
            while (it.hasNext()) {
                it.next().f1021a.show();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements View.OnAttachStateChangeListener {
        public b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = CascadingMenuPopup.this.f1017z;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    CascadingMenuPopup.this.f1017z = view.getViewTreeObserver();
                }
                CascadingMenuPopup cascadingMenuPopup = CascadingMenuPopup.this;
                cascadingMenuPopup.f1017z.removeGlobalOnLayoutListener(cascadingMenuPopup.f1002k);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MenuPopupWindow f1021a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final f f1022b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f1023c;

        public c(@NonNull MenuPopupWindow menuPopupWindow, @NonNull f fVar, int i11) {
            this.f1021a = menuPopupWindow;
            this.f1022b = fVar;
            this.f1023c = i11;
        }

        public ListView a() {
            return this.f1021a.o();
        }
    }

    public CascadingMenuPopup(@NonNull Context context, @NonNull View view, int i11, int i12, boolean z11) {
        this.f994b = context;
        this.f1007p = view;
        this.f996d = i11;
        this.f997f = i12;
        this.f998g = z11;
        Resources resources = context.getResources();
        this.f995c = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R$dimen.abc_config_prefDialogWidth));
        this.f999h = new Handler();
    }

    public final MenuPopupWindow A() {
        MenuPopupWindow menuPopupWindow = new MenuPopupWindow(this.f994b, null, this.f996d, this.f997f);
        menuPopupWindow.T(this.f1004m);
        menuPopupWindow.K(this);
        menuPopupWindow.J(this);
        menuPopupWindow.C(this.f1007p);
        menuPopupWindow.F(this.f1006o);
        menuPopupWindow.I(true);
        menuPopupWindow.H(2);
        return menuPopupWindow;
    }

    public final int B(@NonNull f fVar) {
        int size = this.f1001j.size();
        for (int i11 = 0; i11 < size; i11++) {
            if (fVar == this.f1001j.get(i11).f1022b) {
                return i11;
            }
        }
        return -1;
    }

    public final MenuItem C(@NonNull f fVar, @NonNull f fVar2) {
        int size = fVar.size();
        for (int i11 = 0; i11 < size; i11++) {
            MenuItem item = fVar.getItem(i11);
            if (item.hasSubMenu() && fVar2 == item.getSubMenu()) {
                return item;
            }
        }
        return null;
    }

    @Nullable
    public final View D(@NonNull c cVar, @NonNull f fVar) {
        e eVar;
        int headersCount;
        int firstVisiblePosition;
        MenuItem menuItemC = C(cVar.f1022b, fVar);
        if (menuItemC == null) {
            return null;
        }
        ListView listViewA = cVar.a();
        ListAdapter adapter = listViewA.getAdapter();
        int i11 = 0;
        if (adapter instanceof HeaderViewListAdapter) {
            HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
            headersCount = headerViewListAdapter.getHeadersCount();
            eVar = (e) headerViewListAdapter.getWrappedAdapter();
        } else {
            eVar = (e) adapter;
            headersCount = 0;
        }
        int count = eVar.getCount();
        while (true) {
            if (i11 >= count) {
                i11 = -1;
                break;
            }
            if (menuItemC == eVar.getItem(i11)) {
                break;
            }
            i11++;
        }
        if (i11 != -1 && (firstVisiblePosition = (i11 + headersCount) - listViewA.getFirstVisiblePosition()) >= 0 && firstVisiblePosition < listViewA.getChildCount()) {
            return listViewA.getChildAt(firstVisiblePosition);
        }
        return null;
    }

    public final int E() {
        return this.f1007p.getLayoutDirection() == 1 ? 0 : 1;
    }

    public final int F(int i11) {
        List<c> list = this.f1001j;
        ListView listViewA = list.get(list.size() - 1).a();
        int[] iArr = new int[2];
        listViewA.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        this.f1008q.getWindowVisibleDisplayFrame(rect);
        if (this.f1009r == 1) {
            return (iArr[0] + listViewA.getWidth()) + i11 > rect.right ? 0 : 1;
        }
        return iArr[0] - i11 < 0 ? 1 : 0;
    }

    public final void G(@NonNull f fVar) {
        c cVar;
        View viewD;
        int i11;
        int i12;
        int i13;
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f994b);
        e eVar = new e(fVar, layoutInflaterFrom, this.f998g, C);
        if (!a() && this.f1014w) {
            eVar.d(true);
        } else if (a()) {
            eVar.d(j.y(fVar));
        }
        int iP = j.p(eVar, null, this.f994b, this.f995c);
        MenuPopupWindow menuPopupWindowA = A();
        menuPopupWindowA.m(eVar);
        menuPopupWindowA.E(iP);
        menuPopupWindowA.F(this.f1006o);
        if (this.f1001j.size() > 0) {
            List<c> list = this.f1001j;
            cVar = list.get(list.size() - 1);
            viewD = D(cVar, fVar);
        } else {
            cVar = null;
            viewD = null;
        }
        if (viewD != null) {
            menuPopupWindowA.U(false);
            menuPopupWindowA.R(null);
            int iF = F(iP);
            boolean z11 = iF == 1;
            this.f1009r = iF;
            if (Build.VERSION.SDK_INT >= 26) {
                menuPopupWindowA.C(viewD);
                i12 = 0;
                i11 = 0;
            } else {
                int[] iArr = new int[2];
                this.f1007p.getLocationOnScreen(iArr);
                int[] iArr2 = new int[2];
                viewD.getLocationOnScreen(iArr2);
                if ((this.f1006o & 7) == 5) {
                    iArr[0] = iArr[0] + this.f1007p.getWidth();
                    iArr2[0] = iArr2[0] + viewD.getWidth();
                }
                i11 = iArr2[0] - iArr[0];
                i12 = iArr2[1] - iArr[1];
            }
            if ((this.f1006o & 5) == 5) {
                if (z11) {
                    i13 = i11 + iP;
                } else {
                    iP = viewD.getWidth();
                    i13 = i11 - iP;
                }
            } else if (z11) {
                iP = viewD.getWidth();
                i13 = i11 + iP;
            } else {
                i13 = i11 - iP;
            }
            menuPopupWindowA.e(i13);
            menuPopupWindowA.M(true);
            menuPopupWindowA.i(i12);
        } else {
            if (this.f1010s) {
                menuPopupWindowA.e(this.f1012u);
            }
            if (this.f1011t) {
                menuPopupWindowA.i(this.f1013v);
            }
            menuPopupWindowA.G(n());
        }
        this.f1001j.add(new c(menuPopupWindowA, fVar, this.f1009r));
        menuPopupWindowA.show();
        ListView listViewO = menuPopupWindowA.o();
        listViewO.setOnKeyListener(this);
        if (cVar == null && this.f1015x && fVar.z() != null) {
            FrameLayout frameLayout = (FrameLayout) layoutInflaterFrom.inflate(R$layout.abc_popup_menu_header_item_layout, (ViewGroup) listViewO, false);
            TextView textView = (TextView) frameLayout.findViewById(R.id.title);
            frameLayout.setEnabled(false);
            textView.setText(fVar.z());
            listViewO.addHeaderView(frameLayout, null, false);
            menuPopupWindowA.show();
        }
    }

    @Override // androidx.appcompat.view.menu.o
    public boolean a() {
        return this.f1001j.size() > 0 && this.f1001j.get(0).f1021a.a();
    }

    @Override // androidx.appcompat.view.menu.l
    public void b(f fVar, boolean z11) {
        int iB = B(fVar);
        if (iB < 0) {
            return;
        }
        int i11 = iB + 1;
        if (i11 < this.f1001j.size()) {
            this.f1001j.get(i11).f1022b.e(false);
        }
        c cVarRemove = this.f1001j.remove(iB);
        cVarRemove.f1022b.R(this);
        if (this.B) {
            cVarRemove.f1021a.S(null);
            cVarRemove.f1021a.D(0);
        }
        cVarRemove.f1021a.dismiss();
        int size = this.f1001j.size();
        if (size > 0) {
            this.f1009r = this.f1001j.get(size - 1).f1023c;
        } else {
            this.f1009r = E();
        }
        if (size != 0) {
            if (z11) {
                this.f1001j.get(0).f1022b.e(false);
                return;
            }
            return;
        }
        dismiss();
        l.a aVar = this.f1016y;
        if (aVar != null) {
            aVar.b(fVar, true);
        }
        ViewTreeObserver viewTreeObserver = this.f1017z;
        if (viewTreeObserver != null) {
            if (viewTreeObserver.isAlive()) {
                this.f1017z.removeGlobalOnLayoutListener(this.f1002k);
            }
            this.f1017z = null;
        }
        this.f1008q.removeOnAttachStateChangeListener(this.f1003l);
        this.A.onDismiss();
    }

    @Override // androidx.appcompat.view.menu.l
    public void d(l.a aVar) {
        this.f1016y = aVar;
    }

    @Override // androidx.appcompat.view.menu.o
    public void dismiss() {
        int size = this.f1001j.size();
        if (size > 0) {
            c[] cVarArr = (c[]) this.f1001j.toArray(new c[size]);
            for (int i11 = size - 1; i11 >= 0; i11--) {
                c cVar = cVarArr[i11];
                if (cVar.f1021a.a()) {
                    cVar.f1021a.dismiss();
                }
            }
        }
    }

    @Override // androidx.appcompat.view.menu.l
    public void e(Parcelable parcelable) {
    }

    @Override // androidx.appcompat.view.menu.l
    public boolean f(q qVar) {
        for (c cVar : this.f1001j) {
            if (qVar == cVar.f1022b) {
                cVar.a().requestFocus();
                return true;
            }
        }
        if (!qVar.hasVisibleItems()) {
            return false;
        }
        l(qVar);
        l.a aVar = this.f1016y;
        if (aVar != null) {
            aVar.c(qVar);
        }
        return true;
    }

    @Override // androidx.appcompat.view.menu.l
    public Parcelable g() {
        return null;
    }

    @Override // androidx.appcompat.view.menu.l
    public void h(boolean z11) {
        Iterator<c> it = this.f1001j.iterator();
        while (it.hasNext()) {
            j.z(it.next().a().getAdapter()).notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.l
    public boolean i() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public void l(f fVar) {
        fVar.c(this, this.f994b);
        if (a()) {
            G(fVar);
        } else {
            this.f1000i.add(fVar);
        }
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean m() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.o
    public ListView o() {
        if (this.f1001j.isEmpty()) {
            return null;
        }
        List<c> list = this.f1001j;
        return list.get(list.size() - 1).a();
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        c cVar;
        int size = this.f1001j.size();
        int i11 = 0;
        while (true) {
            if (i11 >= size) {
                cVar = null;
                break;
            }
            cVar = this.f1001j.get(i11);
            if (!cVar.f1021a.a()) {
                break;
            } else {
                i11++;
            }
        }
        if (cVar != null) {
            cVar.f1022b.e(false);
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i11, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i11 != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    @Override // androidx.appcompat.view.menu.j
    public void q(@NonNull View view) {
        if (this.f1007p != view) {
            this.f1007p = view;
            this.f1006o = GravityCompat.getAbsoluteGravity(this.f1005n, view.getLayoutDirection());
        }
    }

    @Override // androidx.appcompat.view.menu.j
    public void s(boolean z11) {
        this.f1014w = z11;
    }

    @Override // androidx.appcompat.view.menu.o
    public void show() {
        if (a()) {
            return;
        }
        Iterator<f> it = this.f1000i.iterator();
        while (it.hasNext()) {
            G(it.next());
        }
        this.f1000i.clear();
        View view = this.f1007p;
        this.f1008q = view;
        if (view != null) {
            boolean z11 = this.f1017z == null;
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            this.f1017z = viewTreeObserver;
            if (z11) {
                viewTreeObserver.addOnGlobalLayoutListener(this.f1002k);
            }
            this.f1008q.addOnAttachStateChangeListener(this.f1003l);
        }
    }

    @Override // androidx.appcompat.view.menu.j
    public void t(int i11) {
        if (this.f1005n != i11) {
            this.f1005n = i11;
            this.f1006o = GravityCompat.getAbsoluteGravity(i11, this.f1007p.getLayoutDirection());
        }
    }

    @Override // androidx.appcompat.view.menu.j
    public void u(int i11) {
        this.f1010s = true;
        this.f1012u = i11;
    }

    @Override // androidx.appcompat.view.menu.j
    public void v(PopupWindow.OnDismissListener onDismissListener) {
        this.A = onDismissListener;
    }

    @Override // androidx.appcompat.view.menu.j
    public void w(boolean z11) {
        this.f1015x = z11;
    }

    @Override // androidx.appcompat.view.menu.j
    public void x(int i11) {
        this.f1011t = true;
        this.f1013v = i11;
    }
}
