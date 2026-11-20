package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R$dimen;
import androidx.core.view.GravityCompat;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f1163a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f1164b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f1165c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f1166d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f1167e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f1168f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f1169g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f1170h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public l.a f1171i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public j f1172j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public PopupWindow.OnDismissListener f1173k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final PopupWindow.OnDismissListener f1174l;

    /* JADX INFO: compiled from: source.java */
    public class a implements PopupWindow.OnDismissListener {
        public a() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            k.this.e();
        }
    }

    public k(@NonNull Context context, @NonNull f fVar, @NonNull View view, boolean z11, int i11) {
        this(context, fVar, view, z11, i11, 0);
    }

    public k(@NonNull Context context, @NonNull f fVar, @NonNull View view, boolean z11, int i11, int i12) {
        this.f1169g = GravityCompat.START;
        this.f1174l = new a();
        this.f1163a = context;
        this.f1164b = fVar;
        this.f1168f = view;
        this.f1165c = z11;
        this.f1166d = i11;
        this.f1167e = i12;
    }

    @NonNull
    public final j a() {
        Display defaultDisplay = ((WindowManager) this.f1163a.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getRealSize(point);
        j cascadingMenuPopup = Math.min(point.x, point.y) >= this.f1163a.getResources().getDimensionPixelSize(R$dimen.abc_cascading_menus_min_smallest_width) ? new CascadingMenuPopup(this.f1163a, this.f1168f, this.f1166d, this.f1167e, this.f1165c) : new p(this.f1163a, this.f1164b, this.f1168f, this.f1166d, this.f1167e, this.f1165c);
        cascadingMenuPopup.l(this.f1164b);
        cascadingMenuPopup.v(this.f1174l);
        cascadingMenuPopup.q(this.f1168f);
        cascadingMenuPopup.d(this.f1171i);
        cascadingMenuPopup.s(this.f1170h);
        cascadingMenuPopup.t(this.f1169g);
        return cascadingMenuPopup;
    }

    public void b() {
        if (d()) {
            this.f1172j.dismiss();
        }
    }

    @NonNull
    public j c() {
        if (this.f1172j == null) {
            this.f1172j = a();
        }
        return this.f1172j;
    }

    public boolean d() {
        j jVar = this.f1172j;
        return jVar != null && jVar.a();
    }

    public void e() {
        this.f1172j = null;
        PopupWindow.OnDismissListener onDismissListener = this.f1173k;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public void f(@NonNull View view) {
        this.f1168f = view;
    }

    public void g(boolean z11) {
        this.f1170h = z11;
        j jVar = this.f1172j;
        if (jVar != null) {
            jVar.s(z11);
        }
    }

    public void h(int i11) {
        this.f1169g = i11;
    }

    public void i(@Nullable PopupWindow.OnDismissListener onDismissListener) {
        this.f1173k = onDismissListener;
    }

    public void j(@Nullable l.a aVar) {
        this.f1171i = aVar;
        j jVar = this.f1172j;
        if (jVar != null) {
            jVar.d(aVar);
        }
    }

    public void k() {
        if (!m()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public final void l(int i11, int i12, boolean z11, boolean z12) {
        j jVarC = c();
        jVarC.w(z12);
        if (z11) {
            if ((GravityCompat.getAbsoluteGravity(this.f1169g, this.f1168f.getLayoutDirection()) & 7) == 5) {
                i11 -= this.f1168f.getWidth();
            }
            jVarC.u(i11);
            jVarC.x(i12);
            int i13 = (int) ((this.f1163a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            jVarC.r(new Rect(i11 - i13, i12 - i13, i11 + i13, i12 + i13));
        }
        jVarC.show();
    }

    public boolean m() {
        if (d()) {
            return true;
        }
        if (this.f1168f == null) {
            return false;
        }
        l(0, 0, false, false);
        return true;
    }

    public boolean n(int i11, int i12) {
        if (d()) {
            return true;
        }
        if (this.f1168f == null) {
            return false;
        }
        l(i11, i12, true, true);
        return true;
    }
}
