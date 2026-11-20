package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$layout;
import androidx.appcompat.widget.MenuPopupWindow;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class p extends j implements PopupWindow.OnDismissListener, View.OnKeyListener {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f1177w = R$layout.abc_popup_menu_item_layout;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f1178b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f1179c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e f1180d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f1181f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f1182g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f1183h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f1184i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final MenuPopupWindow f1185j;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public PopupWindow.OnDismissListener f1188m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public View f1189n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public View f1190o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public l.a f1191p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ViewTreeObserver f1192q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f1193r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f1194s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f1195t;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f1197v;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ViewTreeObserver.OnGlobalLayoutListener f1186k = new a();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final View.OnAttachStateChangeListener f1187l = new b();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f1196u = 0;

    /* JADX INFO: compiled from: source.java */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!p.this.a() || p.this.f1185j.A()) {
                return;
            }
            View view = p.this.f1190o;
            if (view == null || !view.isShown()) {
                p.this.dismiss();
            } else {
                p.this.f1185j.show();
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
            ViewTreeObserver viewTreeObserver = p.this.f1192q;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    p.this.f1192q = view.getViewTreeObserver();
                }
                p pVar = p.this;
                pVar.f1192q.removeGlobalOnLayoutListener(pVar.f1186k);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    public p(Context context, f fVar, View view, int i11, int i12, boolean z11) {
        this.f1178b = context;
        this.f1179c = fVar;
        this.f1181f = z11;
        this.f1180d = new e(fVar, LayoutInflater.from(context), z11, f1177w);
        this.f1183h = i11;
        this.f1184i = i12;
        Resources resources = context.getResources();
        this.f1182g = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R$dimen.abc_config_prefDialogWidth));
        this.f1189n = view;
        this.f1185j = new MenuPopupWindow(context, null, i11, i12);
        fVar.c(this, context);
    }

    public final boolean A() {
        View view;
        if (a()) {
            return true;
        }
        if (this.f1193r || (view = this.f1189n) == null) {
            return false;
        }
        this.f1190o = view;
        this.f1185j.J(this);
        this.f1185j.K(this);
        this.f1185j.I(true);
        View view2 = this.f1190o;
        boolean z11 = this.f1192q == null;
        ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
        this.f1192q = viewTreeObserver;
        if (z11) {
            viewTreeObserver.addOnGlobalLayoutListener(this.f1186k);
        }
        view2.addOnAttachStateChangeListener(this.f1187l);
        this.f1185j.C(view2);
        this.f1185j.F(this.f1196u);
        if (!this.f1194s) {
            this.f1195t = j.p(this.f1180d, null, this.f1178b, this.f1182g);
            this.f1194s = true;
        }
        this.f1185j.E(this.f1195t);
        this.f1185j.H(2);
        this.f1185j.G(n());
        this.f1185j.show();
        ListView listViewO = this.f1185j.o();
        listViewO.setOnKeyListener(this);
        if (this.f1197v && this.f1179c.z() != null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.f1178b).inflate(R$layout.abc_popup_menu_header_item_layout, (ViewGroup) listViewO, false);
            TextView textView = (TextView) frameLayout.findViewById(R.id.title);
            if (textView != null) {
                textView.setText(this.f1179c.z());
            }
            frameLayout.setEnabled(false);
            listViewO.addHeaderView(frameLayout, null, false);
        }
        this.f1185j.m(this.f1180d);
        this.f1185j.show();
        return true;
    }

    @Override // androidx.appcompat.view.menu.o
    public boolean a() {
        return !this.f1193r && this.f1185j.a();
    }

    @Override // androidx.appcompat.view.menu.l
    public void b(f fVar, boolean z11) {
        if (fVar != this.f1179c) {
            return;
        }
        dismiss();
        l.a aVar = this.f1191p;
        if (aVar != null) {
            aVar.b(fVar, z11);
        }
    }

    @Override // androidx.appcompat.view.menu.l
    public void d(l.a aVar) {
        this.f1191p = aVar;
    }

    @Override // androidx.appcompat.view.menu.o
    public void dismiss() {
        if (a()) {
            this.f1185j.dismiss();
        }
    }

    @Override // androidx.appcompat.view.menu.l
    public void e(Parcelable parcelable) {
    }

    @Override // androidx.appcompat.view.menu.l
    public boolean f(q qVar) {
        if (qVar.hasVisibleItems()) {
            k kVar = new k(this.f1178b, qVar, this.f1190o, this.f1181f, this.f1183h, this.f1184i);
            kVar.j(this.f1191p);
            kVar.g(j.y(qVar));
            kVar.i(this.f1188m);
            this.f1188m = null;
            this.f1179c.e(false);
            int iC = this.f1185j.c();
            int iL = this.f1185j.l();
            if ((Gravity.getAbsoluteGravity(this.f1196u, this.f1189n.getLayoutDirection()) & 7) == 5) {
                iC += this.f1189n.getWidth();
            }
            if (kVar.n(iC, iL)) {
                l.a aVar = this.f1191p;
                if (aVar == null) {
                    return true;
                }
                aVar.c(qVar);
                return true;
            }
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.l
    public Parcelable g() {
        return null;
    }

    @Override // androidx.appcompat.view.menu.l
    public void h(boolean z11) {
        this.f1194s = false;
        e eVar = this.f1180d;
        if (eVar != null) {
            eVar.notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.l
    public boolean i() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public void l(f fVar) {
    }

    @Override // androidx.appcompat.view.menu.o
    public ListView o() {
        return this.f1185j.o();
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.f1193r = true;
        this.f1179c.close();
        ViewTreeObserver viewTreeObserver = this.f1192q;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.f1192q = this.f1190o.getViewTreeObserver();
            }
            this.f1192q.removeGlobalOnLayoutListener(this.f1186k);
            this.f1192q = null;
        }
        this.f1190o.removeOnAttachStateChangeListener(this.f1187l);
        PopupWindow.OnDismissListener onDismissListener = this.f1188m;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
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
    public void q(View view) {
        this.f1189n = view;
    }

    @Override // androidx.appcompat.view.menu.j
    public void s(boolean z11) {
        this.f1180d.d(z11);
    }

    @Override // androidx.appcompat.view.menu.o
    public void show() {
        if (!A()) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    @Override // androidx.appcompat.view.menu.j
    public void t(int i11) {
        this.f1196u = i11;
    }

    @Override // androidx.appcompat.view.menu.j
    public void u(int i11) {
        this.f1185j.e(i11);
    }

    @Override // androidx.appcompat.view.menu.j
    public void v(PopupWindow.OnDismissListener onDismissListener) {
        this.f1188m = onDismissListener;
    }

    @Override // androidx.appcompat.view.menu.j
    public void w(boolean z11) {
        this.f1197v = z11;
    }

    @Override // androidx.appcompat.view.menu.j
    public void x(int i11) {
        this.f1185j.i(i11);
    }
}
