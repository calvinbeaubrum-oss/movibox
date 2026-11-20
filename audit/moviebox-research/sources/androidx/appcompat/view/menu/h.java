package androidx.appcompat.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R$string;
import androidx.core.view.ActionProvider;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class h implements e3.b {
    public View A;
    public ActionProvider B;
    public MenuItem.OnActionExpandListener C;
    public ContextMenu.ContextMenuInfo E;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1125a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1126b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f1127c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f1128d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CharSequence f1129e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public CharSequence f1130f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Intent f1131g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public char f1132h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public char f1134j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Drawable f1136l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public f f1138n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public q f1139o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Runnable f1140p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public MenuItem.OnMenuItemClickListener f1141q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public CharSequence f1142r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public CharSequence f1143s;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f1150z;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f1133i = 4096;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f1135k = 4096;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f1137m = 0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public ColorStateList f1144t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public PorterDuff.Mode f1145u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f1146v = false;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f1147w = false;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f1148x = false;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f1149y = 16;
    public boolean D = false;

    /* JADX INFO: compiled from: source.java */
    public class a implements ActionProvider.VisibilityListener {
        public a() {
        }

        @Override // androidx.core.view.ActionProvider.VisibilityListener
        public void onActionProviderVisibilityChanged(boolean z11) {
            h hVar = h.this;
            hVar.f1138n.M(hVar);
        }
    }

    public h(f fVar, int i11, int i12, int i13, int i14, CharSequence charSequence, int i15) {
        this.f1138n = fVar;
        this.f1125a = i12;
        this.f1126b = i11;
        this.f1127c = i13;
        this.f1128d = i14;
        this.f1129e = charSequence;
        this.f1150z = i15;
    }

    public static void d(StringBuilder sb2, int i11, int i12, String str) {
        if ((i11 & i12) == i12) {
            sb2.append(str);
        }
    }

    public boolean A() {
        return this.f1138n.K() && g() != 0;
    }

    public boolean B() {
        return (this.f1150z & 4) == 4;
    }

    @Override // e3.b
    public ActionProvider a() {
        return this.B;
    }

    @Override // e3.b
    @NonNull
    public e3.b b(ActionProvider actionProvider) {
        ActionProvider actionProvider2 = this.B;
        if (actionProvider2 != null) {
            actionProvider2.reset();
        }
        this.A = null;
        this.B = actionProvider;
        this.f1138n.N(true);
        ActionProvider actionProvider3 = this.B;
        if (actionProvider3 != null) {
            actionProvider3.setVisibilityListener(new a());
        }
        return this;
    }

    public void c() {
        this.f1138n.L(this);
    }

    @Override // e3.b, android.view.MenuItem
    public boolean collapseActionView() {
        if ((this.f1150z & 8) == 0) {
            return false;
        }
        if (this.A == null) {
            return true;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.C;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionCollapse(this)) {
            return this.f1138n.f(this);
        }
        return false;
    }

    public final Drawable e(Drawable drawable) {
        if (drawable != null && this.f1148x && (this.f1146v || this.f1147w)) {
            drawable = d3.a.r(drawable).mutate();
            if (this.f1146v) {
                d3.a.o(drawable, this.f1144t);
            }
            if (this.f1147w) {
                d3.a.p(drawable, this.f1145u);
            }
            this.f1148x = false;
        }
        return drawable;
    }

    @Override // e3.b, android.view.MenuItem
    public boolean expandActionView() {
        if (!j()) {
            return false;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.C;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionExpand(this)) {
            return this.f1138n.m(this);
        }
        return false;
    }

    public int f() {
        return this.f1128d;
    }

    public char g() {
        return this.f1138n.J() ? this.f1134j : this.f1132h;
    }

    @Override // android.view.MenuItem
    public android.view.ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    @Override // e3.b, android.view.MenuItem
    public View getActionView() {
        View view = this.A;
        if (view != null) {
            return view;
        }
        ActionProvider actionProvider = this.B;
        if (actionProvider == null) {
            return null;
        }
        View viewOnCreateActionView = actionProvider.onCreateActionView(this);
        this.A = viewOnCreateActionView;
        return viewOnCreateActionView;
    }

    @Override // e3.b, android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f1135k;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f1134j;
    }

    @Override // e3.b, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f1142r;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f1126b;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        Drawable drawable = this.f1136l;
        if (drawable != null) {
            return e(drawable);
        }
        if (this.f1137m == 0) {
            return null;
        }
        Drawable drawableB = d1.a.b(this.f1138n.w(), this.f1137m);
        this.f1137m = 0;
        this.f1136l = drawableB;
        return e(drawableB);
    }

    @Override // e3.b, android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f1144t;
    }

    @Override // e3.b, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f1145u;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f1131g;
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public int getItemId() {
        return this.f1125a;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.E;
    }

    @Override // e3.b, android.view.MenuItem
    public int getNumericModifiers() {
        return this.f1133i;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f1132h;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f1127c;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return this.f1139o;
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public CharSequence getTitle() {
        return this.f1129e;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f1130f;
        return charSequence != null ? charSequence : this.f1129e;
    }

    @Override // e3.b, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f1143s;
    }

    public String h() {
        char cG = g();
        if (cG == 0) {
            return "";
        }
        Resources resources = this.f1138n.w().getResources();
        StringBuilder sb2 = new StringBuilder();
        if (ViewConfiguration.get(this.f1138n.w()).hasPermanentMenuKey()) {
            sb2.append(resources.getString(R$string.abc_prepend_shortcut_label));
        }
        int i11 = this.f1138n.J() ? this.f1135k : this.f1133i;
        d(sb2, i11, 65536, resources.getString(R$string.abc_menu_meta_shortcut_label));
        d(sb2, i11, 4096, resources.getString(R$string.abc_menu_ctrl_shortcut_label));
        d(sb2, i11, 2, resources.getString(R$string.abc_menu_alt_shortcut_label));
        d(sb2, i11, 1, resources.getString(R$string.abc_menu_shift_shortcut_label));
        d(sb2, i11, 4, resources.getString(R$string.abc_menu_sym_shortcut_label));
        d(sb2, i11, 8, resources.getString(R$string.abc_menu_function_shortcut_label));
        if (cG == '\b') {
            sb2.append(resources.getString(R$string.abc_menu_delete_shortcut_label));
        } else if (cG == '\n') {
            sb2.append(resources.getString(R$string.abc_menu_enter_shortcut_label));
        } else if (cG != ' ') {
            sb2.append(cG);
        } else {
            sb2.append(resources.getString(R$string.abc_menu_space_shortcut_label));
        }
        return sb2.toString();
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return this.f1139o != null;
    }

    public CharSequence i(m.a aVar) {
        return (aVar == null || !aVar.prefersCondensedTitle()) ? getTitle() : getTitleCondensed();
    }

    @Override // e3.b, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return this.D;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return (this.f1149y & 1) == 1;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.f1149y & 2) == 2;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.f1149y & 16) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        ActionProvider actionProvider = this.B;
        if (actionProvider == null || !actionProvider.overridesItemVisibility()) {
            return (this.f1149y & 8) == 0;
        }
        return (this.f1149y & 8) == 0 && this.B.isVisible();
    }

    public boolean j() {
        ActionProvider actionProvider;
        if ((this.f1150z & 8) == 0) {
            return false;
        }
        if (this.A == null && (actionProvider = this.B) != null) {
            this.A = actionProvider.onCreateActionView(this);
        }
        return this.A != null;
    }

    public boolean k() {
        MenuItem.OnMenuItemClickListener onMenuItemClickListener = this.f1141q;
        if (onMenuItemClickListener != null && onMenuItemClickListener.onMenuItemClick(this)) {
            return true;
        }
        f fVar = this.f1138n;
        if (fVar.h(fVar, this)) {
            return true;
        }
        Runnable runnable = this.f1140p;
        if (runnable != null) {
            runnable.run();
            return true;
        }
        if (this.f1131g != null) {
            try {
                this.f1138n.w().startActivity(this.f1131g);
                return true;
            } catch (ActivityNotFoundException e11) {
                Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", e11);
            }
        }
        ActionProvider actionProvider = this.B;
        return actionProvider != null && actionProvider.onPerformDefaultAction();
    }

    public boolean l() {
        return (this.f1149y & 32) == 32;
    }

    public boolean m() {
        return (this.f1149y & 4) != 0;
    }

    public boolean n() {
        return (this.f1150z & 1) == 1;
    }

    public boolean o() {
        return (this.f1150z & 2) == 2;
    }

    @Override // e3.b, android.view.MenuItem
    @NonNull
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public e3.b setActionView(int i11) {
        Context contextW = this.f1138n.w();
        setActionView(LayoutInflater.from(contextW).inflate(i11, (ViewGroup) new LinearLayout(contextW), false));
        return this;
    }

    @Override // e3.b, android.view.MenuItem
    @NonNull
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public e3.b setActionView(View view) {
        int i11;
        this.A = view;
        this.B = null;
        if (view != null && view.getId() == -1 && (i11 = this.f1125a) > 0) {
            view.setId(i11);
        }
        this.f1138n.L(this);
        return this;
    }

    public void r(boolean z11) {
        this.D = z11;
        this.f1138n.N(false);
    }

    public void s(boolean z11) {
        int i11 = this.f1149y;
        int i12 = (z11 ? 2 : 0) | (i11 & (-3));
        this.f1149y = i12;
        if (i11 != i12) {
            this.f1138n.N(false);
        }
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(android.view.ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c11) {
        if (this.f1134j == c11) {
            return this;
        }
        this.f1134j = Character.toLowerCase(c11);
        this.f1138n.N(false);
        return this;
    }

    @Override // e3.b, android.view.MenuItem
    @NonNull
    public MenuItem setAlphabeticShortcut(char c11, int i11) {
        if (this.f1134j == c11 && this.f1135k == i11) {
            return this;
        }
        this.f1134j = Character.toLowerCase(c11);
        this.f1135k = KeyEvent.normalizeMetaState(i11);
        this.f1138n.N(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z11) {
        int i11 = this.f1149y;
        int i12 = (z11 ? 1 : 0) | (i11 & (-2));
        this.f1149y = i12;
        if (i11 != i12) {
            this.f1138n.N(false);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z11) {
        if ((this.f1149y & 4) != 0) {
            this.f1138n.Y(this);
        } else {
            s(z11);
        }
        return this;
    }

    @Override // android.view.MenuItem
    @NonNull
    public e3.b setContentDescription(CharSequence charSequence) {
        this.f1142r = charSequence;
        this.f1138n.N(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z11) {
        if (z11) {
            this.f1149y |= 16;
        } else {
            this.f1149y &= -17;
        }
        this.f1138n.N(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i11) {
        this.f1136l = null;
        this.f1137m = i11;
        this.f1148x = true;
        this.f1138n.N(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f1137m = 0;
        this.f1136l = drawable;
        this.f1148x = true;
        this.f1138n.N(false);
        return this;
    }

    @Override // e3.b, android.view.MenuItem
    @NonNull
    public MenuItem setIconTintList(@Nullable ColorStateList colorStateList) {
        this.f1144t = colorStateList;
        this.f1146v = true;
        this.f1148x = true;
        this.f1138n.N(false);
        return this;
    }

    @Override // e3.b, android.view.MenuItem
    @NonNull
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f1145u = mode;
        this.f1147w = true;
        this.f1148x = true;
        this.f1138n.N(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f1131g = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c11) {
        if (this.f1132h == c11) {
            return this;
        }
        this.f1132h = c11;
        this.f1138n.N(false);
        return this;
    }

    @Override // e3.b, android.view.MenuItem
    @NonNull
    public MenuItem setNumericShortcut(char c11, int i11) {
        if (this.f1132h == c11 && this.f1133i == i11) {
            return this;
        }
        this.f1132h = c11;
        this.f1133i = KeyEvent.normalizeMetaState(i11);
        this.f1138n.N(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.C = onActionExpandListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f1141q = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c11, char c12) {
        this.f1132h = c11;
        this.f1134j = Character.toLowerCase(c12);
        this.f1138n.N(false);
        return this;
    }

    @Override // e3.b, android.view.MenuItem
    @NonNull
    public MenuItem setShortcut(char c11, char c12, int i11, int i12) {
        this.f1132h = c11;
        this.f1133i = KeyEvent.normalizeMetaState(i11);
        this.f1134j = Character.toLowerCase(c12);
        this.f1135k = KeyEvent.normalizeMetaState(i12);
        this.f1138n.N(false);
        return this;
    }

    @Override // e3.b, android.view.MenuItem
    public void setShowAsAction(int i11) {
        int i12 = i11 & 3;
        if (i12 != 0 && i12 != 1 && i12 != 2) {
            throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
        this.f1150z = i11;
        this.f1138n.L(this);
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i11) {
        return setTitle(this.f1138n.w().getString(i11));
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f1129e = charSequence;
        this.f1138n.N(false);
        q qVar = this.f1139o;
        if (qVar != null) {
            qVar.setHeaderTitle(charSequence);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f1130f = charSequence;
        this.f1138n.N(false);
        return this;
    }

    @Override // android.view.MenuItem
    @NonNull
    public e3.b setTooltipText(CharSequence charSequence) {
        this.f1143s = charSequence;
        this.f1138n.N(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z11) {
        if (y(z11)) {
            this.f1138n.M(this);
        }
        return this;
    }

    public void t(boolean z11) {
        this.f1149y = (z11 ? 4 : 0) | (this.f1149y & (-5));
    }

    public String toString() {
        CharSequence charSequence = this.f1129e;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    public void u(boolean z11) {
        if (z11) {
            this.f1149y |= 32;
        } else {
            this.f1149y &= -33;
        }
    }

    public void v(ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.E = contextMenuInfo;
    }

    @Override // e3.b, android.view.MenuItem
    @NonNull
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public e3.b setShowAsActionFlags(int i11) {
        setShowAsAction(i11);
        return this;
    }

    public void x(q qVar) {
        this.f1139o = qVar;
        qVar.setHeaderTitle(getTitle());
    }

    public boolean y(boolean z11) {
        int i11 = this.f1149y;
        int i12 = (z11 ? 0 : 8) | (i11 & (-9));
        this.f1149y = i12;
        return i11 != i12;
    }

    public boolean z() {
        return this.f1138n.C();
    }
}
