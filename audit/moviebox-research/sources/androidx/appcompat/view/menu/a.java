package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ActionProvider;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class a implements e3.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1044a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1045b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f1046c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CharSequence f1047d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CharSequence f1048e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Intent f1049f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public char f1050g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public char f1052i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Drawable f1054k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Context f1055l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public MenuItem.OnMenuItemClickListener f1056m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public CharSequence f1057n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public CharSequence f1058o;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f1051h = 4096;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f1053j = 4096;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ColorStateList f1059p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public PorterDuff.Mode f1060q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f1061r = false;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f1062s = false;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f1063t = 16;

    public a(Context context, int i11, int i12, int i13, int i14, CharSequence charSequence) {
        this.f1055l = context;
        this.f1044a = i12;
        this.f1045b = i11;
        this.f1046c = i14;
        this.f1047d = charSequence;
    }

    @Override // e3.b
    public ActionProvider a() {
        return null;
    }

    @Override // e3.b
    @NonNull
    public e3.b b(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    public final void c() {
        Drawable drawable = this.f1054k;
        if (drawable != null) {
            if (this.f1061r || this.f1062s) {
                Drawable drawableR = d3.a.r(drawable);
                this.f1054k = drawableR;
                Drawable drawableMutate = drawableR.mutate();
                this.f1054k = drawableMutate;
                if (this.f1061r) {
                    d3.a.o(drawableMutate, this.f1059p);
                }
                if (this.f1062s) {
                    d3.a.p(this.f1054k, this.f1060q);
                }
            }
        }
    }

    @Override // e3.b, android.view.MenuItem
    public boolean collapseActionView() {
        return false;
    }

    @Override // e3.b, android.view.MenuItem
    @NonNull
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public e3.b setActionView(int i11) {
        throw new UnsupportedOperationException();
    }

    @Override // e3.b, android.view.MenuItem
    @NonNull
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public e3.b setActionView(View view) {
        throw new UnsupportedOperationException();
    }

    @Override // e3.b, android.view.MenuItem
    public boolean expandActionView() {
        return false;
    }

    @Override // e3.b, android.view.MenuItem
    @NonNull
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public e3.b setShowAsActionFlags(int i11) {
        setShowAsAction(i11);
        return this;
    }

    @Override // android.view.MenuItem
    public android.view.ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    @Override // e3.b, android.view.MenuItem
    public View getActionView() {
        return null;
    }

    @Override // e3.b, android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f1053j;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f1052i;
    }

    @Override // e3.b, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f1057n;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f1045b;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return this.f1054k;
    }

    @Override // e3.b, android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f1059p;
    }

    @Override // e3.b, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f1060q;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f1049f;
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.f1044a;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // e3.b, android.view.MenuItem
    public int getNumericModifiers() {
        return this.f1051h;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f1050g;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f1046c;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return null;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.f1047d;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f1048e;
        return charSequence != null ? charSequence : this.f1047d;
    }

    @Override // e3.b, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f1058o;
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return false;
    }

    @Override // e3.b, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return false;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return (this.f1063t & 1) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.f1063t & 2) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.f1063t & 16) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return (this.f1063t & 8) == 0;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(android.view.ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c11) {
        this.f1052i = Character.toLowerCase(c11);
        return this;
    }

    @Override // e3.b, android.view.MenuItem
    @NonNull
    public MenuItem setAlphabeticShortcut(char c11, int i11) {
        this.f1052i = Character.toLowerCase(c11);
        this.f1053j = KeyEvent.normalizeMetaState(i11);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z11) {
        this.f1063t = (z11 ? 1 : 0) | (this.f1063t & (-2));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z11) {
        this.f1063t = (z11 ? 2 : 0) | (this.f1063t & (-3));
        return this;
    }

    @Override // android.view.MenuItem
    @NonNull
    public e3.b setContentDescription(CharSequence charSequence) {
        this.f1057n = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z11) {
        this.f1063t = (z11 ? 16 : 0) | (this.f1063t & (-17));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i11) {
        this.f1054k = z2.a.getDrawable(this.f1055l, i11);
        c();
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f1054k = drawable;
        c();
        return this;
    }

    @Override // e3.b, android.view.MenuItem
    @NonNull
    public MenuItem setIconTintList(@Nullable ColorStateList colorStateList) {
        this.f1059p = colorStateList;
        this.f1061r = true;
        c();
        return this;
    }

    @Override // e3.b, android.view.MenuItem
    @NonNull
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f1060q = mode;
        this.f1062s = true;
        c();
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f1049f = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c11) {
        this.f1050g = c11;
        return this;
    }

    @Override // e3.b, android.view.MenuItem
    @NonNull
    public MenuItem setNumericShortcut(char c11, int i11) {
        this.f1050g = c11;
        this.f1051h = KeyEvent.normalizeMetaState(i11);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f1056m = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c11, char c12) {
        this.f1050g = c11;
        this.f1052i = Character.toLowerCase(c12);
        return this;
    }

    @Override // e3.b, android.view.MenuItem
    @NonNull
    public MenuItem setShortcut(char c11, char c12, int i11, int i12) {
        this.f1050g = c11;
        this.f1051h = KeyEvent.normalizeMetaState(i11);
        this.f1052i = Character.toLowerCase(c12);
        this.f1053j = KeyEvent.normalizeMetaState(i12);
        return this;
    }

    @Override // e3.b, android.view.MenuItem
    public void setShowAsAction(int i11) {
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i11) {
        this.f1047d = this.f1055l.getResources().getString(i11);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f1047d = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f1048e = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    @NonNull
    public e3.b setTooltipText(CharSequence charSequence) {
        this.f1058o = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z11) {
        this.f1063t = (this.f1063t & 8) | (z11 ? 0 : 8);
        return this;
    }
}
