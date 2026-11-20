package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.CollapsibleActionView;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.view.ActionProvider;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class i extends androidx.appcompat.view.menu.c implements MenuItem {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e3.b f1152d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Method f1153e;

    /* JADX INFO: compiled from: source.java */
    public class a extends ActionProvider implements android.view.ActionProvider.VisibilityListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ActionProvider.VisibilityListener f1154a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final android.view.ActionProvider f1155b;

        public a(Context context, android.view.ActionProvider actionProvider) {
            super(context);
            this.f1155b = actionProvider;
        }

        @Override // androidx.core.view.ActionProvider
        public boolean hasSubMenu() {
            return this.f1155b.hasSubMenu();
        }

        @Override // androidx.core.view.ActionProvider
        public boolean isVisible() {
            return this.f1155b.isVisible();
        }

        @Override // android.view.ActionProvider.VisibilityListener
        public void onActionProviderVisibilityChanged(boolean z11) {
            ActionProvider.VisibilityListener visibilityListener = this.f1154a;
            if (visibilityListener != null) {
                visibilityListener.onActionProviderVisibilityChanged(z11);
            }
        }

        @Override // androidx.core.view.ActionProvider
        @NonNull
        public View onCreateActionView() {
            return this.f1155b.onCreateActionView();
        }

        @Override // androidx.core.view.ActionProvider
        public View onCreateActionView(MenuItem menuItem) {
            return this.f1155b.onCreateActionView(menuItem);
        }

        @Override // androidx.core.view.ActionProvider
        public boolean onPerformDefaultAction() {
            return this.f1155b.onPerformDefaultAction();
        }

        @Override // androidx.core.view.ActionProvider
        public void onPrepareSubMenu(SubMenu subMenu) {
            this.f1155b.onPrepareSubMenu(i.this.d(subMenu));
        }

        @Override // androidx.core.view.ActionProvider
        public boolean overridesItemVisibility() {
            return this.f1155b.overridesItemVisibility();
        }

        @Override // androidx.core.view.ActionProvider
        public void refreshVisibility() {
            this.f1155b.refreshVisibility();
        }

        @Override // androidx.core.view.ActionProvider
        public void setVisibilityListener(ActionProvider.VisibilityListener visibilityListener) {
            this.f1154a = visibilityListener;
            this.f1155b.setVisibilityListener(visibilityListener != null ? this : null);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b extends FrameLayout implements g1.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CollapsibleActionView f1157a;

        /* JADX WARN: Multi-variable type inference failed */
        public b(View view) {
            super(view.getContext());
            this.f1157a = (CollapsibleActionView) view;
            addView(view);
        }

        public View a() {
            return (View) this.f1157a;
        }

        @Override // g1.c
        public void onActionViewCollapsed() {
            this.f1157a.onActionViewCollapsed();
        }

        @Override // g1.c
        public void onActionViewExpanded() {
            this.f1157a.onActionViewExpanded();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements MenuItem.OnActionExpandListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MenuItem.OnActionExpandListener f1158a;

        public c(MenuItem.OnActionExpandListener onActionExpandListener) {
            this.f1158a = onActionExpandListener;
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return this.f1158a.onMenuItemActionCollapse(i.this.c(menuItem));
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            return this.f1158a.onMenuItemActionExpand(i.this.c(menuItem));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d implements MenuItem.OnMenuItemClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MenuItem.OnMenuItemClickListener f1160a;

        public d(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
            this.f1160a = onMenuItemClickListener;
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            return this.f1160a.onMenuItemClick(i.this.c(menuItem));
        }
    }

    public i(Context context, e3.b bVar) {
        super(context);
        if (bVar == null) {
            throw new IllegalArgumentException("Wrapped Object can not be null.");
        }
        this.f1152d = bVar;
    }

    @Override // android.view.MenuItem
    public boolean collapseActionView() {
        return this.f1152d.collapseActionView();
    }

    @Override // android.view.MenuItem
    public boolean expandActionView() {
        return this.f1152d.expandActionView();
    }

    @Override // android.view.MenuItem
    public android.view.ActionProvider getActionProvider() {
        ActionProvider actionProviderA = this.f1152d.a();
        if (actionProviderA instanceof a) {
            return ((a) actionProviderA).f1155b;
        }
        return null;
    }

    @Override // android.view.MenuItem
    public View getActionView() {
        View actionView = this.f1152d.getActionView();
        return actionView instanceof b ? ((b) actionView).a() : actionView;
    }

    @Override // android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f1152d.getAlphabeticModifiers();
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f1152d.getAlphabeticShortcut();
    }

    @Override // android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f1152d.getContentDescription();
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f1152d.getGroupId();
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return this.f1152d.getIcon();
    }

    @Override // android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f1152d.getIconTintList();
    }

    @Override // android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f1152d.getIconTintMode();
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f1152d.getIntent();
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.f1152d.getItemId();
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.f1152d.getMenuInfo();
    }

    @Override // android.view.MenuItem
    public int getNumericModifiers() {
        return this.f1152d.getNumericModifiers();
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f1152d.getNumericShortcut();
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f1152d.getOrder();
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return d(this.f1152d.getSubMenu());
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.f1152d.getTitle();
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        return this.f1152d.getTitleCondensed();
    }

    @Override // android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f1152d.getTooltipText();
    }

    public void h(boolean z11) {
        try {
            if (this.f1153e == null) {
                this.f1153e = this.f1152d.getClass().getDeclaredMethod("setExclusiveCheckable", Boolean.TYPE);
            }
            this.f1153e.invoke(this.f1152d, Boolean.valueOf(z11));
        } catch (Exception e11) {
            Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e11);
        }
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return this.f1152d.hasSubMenu();
    }

    @Override // android.view.MenuItem
    public boolean isActionViewExpanded() {
        return this.f1152d.isActionViewExpanded();
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return this.f1152d.isCheckable();
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return this.f1152d.isChecked();
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return this.f1152d.isEnabled();
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return this.f1152d.isVisible();
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(android.view.ActionProvider actionProvider) {
        a aVar = new a(this.f1074a, actionProvider);
        e3.b bVar = this.f1152d;
        if (actionProvider == null) {
            aVar = null;
        }
        bVar.b(aVar);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(int i11) {
        this.f1152d.setActionView(i11);
        View actionView = this.f1152d.getActionView();
        if (actionView instanceof CollapsibleActionView) {
            this.f1152d.setActionView(new b(actionView));
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new b(view);
        }
        this.f1152d.setActionView(view);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c11) {
        this.f1152d.setAlphabeticShortcut(c11);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c11, int i11) {
        this.f1152d.setAlphabeticShortcut(c11, i11);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z11) {
        this.f1152d.setCheckable(z11);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z11) {
        this.f1152d.setChecked(z11);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setContentDescription(CharSequence charSequence) {
        this.f1152d.setContentDescription(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z11) {
        this.f1152d.setEnabled(z11);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i11) {
        this.f1152d.setIcon(i11);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f1152d.setIcon(drawable);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f1152d.setIconTintList(colorStateList);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f1152d.setIconTintMode(mode);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f1152d.setIntent(intent);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c11) {
        this.f1152d.setNumericShortcut(c11);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c11, int i11) {
        this.f1152d.setNumericShortcut(c11, i11);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.f1152d.setOnActionExpandListener(onActionExpandListener != null ? new c(onActionExpandListener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f1152d.setOnMenuItemClickListener(onMenuItemClickListener != null ? new d(onMenuItemClickListener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c11, char c12) {
        this.f1152d.setShortcut(c11, c12);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c11, char c12, int i11, int i12) {
        this.f1152d.setShortcut(c11, c12, i11, i12);
        return this;
    }

    @Override // android.view.MenuItem
    public void setShowAsAction(int i11) {
        this.f1152d.setShowAsAction(i11);
    }

    @Override // android.view.MenuItem
    public MenuItem setShowAsActionFlags(int i11) {
        this.f1152d.setShowAsActionFlags(i11);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i11) {
        this.f1152d.setTitle(i11);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f1152d.setTitle(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f1152d.setTitleCondensed(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTooltipText(CharSequence charSequence) {
        this.f1152d.setTooltipText(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z11) {
        return this.f1152d.setVisible(z11);
    }
}
