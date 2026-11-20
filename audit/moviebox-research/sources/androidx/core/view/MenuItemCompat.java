package androidx.core.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Build;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class MenuItemCompat {

    @Deprecated
    public static final int SHOW_AS_ACTION_ALWAYS = 2;

    @Deprecated
    public static final int SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW = 8;

    @Deprecated
    public static final int SHOW_AS_ACTION_IF_ROOM = 1;

    @Deprecated
    public static final int SHOW_AS_ACTION_NEVER = 0;

    @Deprecated
    public static final int SHOW_AS_ACTION_WITH_TEXT = 4;
    private static final String TAG = "MenuItemCompat";

    /* JADX INFO: compiled from: source.java */
    @Deprecated
    public interface OnActionExpandListener {
        boolean onMenuItemActionCollapse(MenuItem menuItem);

        boolean onMenuItemActionExpand(MenuItem menuItem);
    }

    /* JADX INFO: compiled from: source.java */
    public class a implements MenuItem.OnActionExpandListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OnActionExpandListener f7914a;

        public a(OnActionExpandListener onActionExpandListener) {
            this.f7914a = onActionExpandListener;
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return this.f7914a.onMenuItemActionCollapse(menuItem);
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            return this.f7914a.onMenuItemActionExpand(menuItem);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(26)
    public static class b {
        public static int a(MenuItem menuItem) {
            return menuItem.getAlphabeticModifiers();
        }

        public static CharSequence b(MenuItem menuItem) {
            return menuItem.getContentDescription();
        }

        public static ColorStateList c(MenuItem menuItem) {
            return menuItem.getIconTintList();
        }

        public static PorterDuff.Mode d(MenuItem menuItem) {
            return menuItem.getIconTintMode();
        }

        public static int e(MenuItem menuItem) {
            return menuItem.getNumericModifiers();
        }

        public static CharSequence f(MenuItem menuItem) {
            return menuItem.getTooltipText();
        }

        public static MenuItem g(MenuItem menuItem, char c11, int i11) {
            return menuItem.setAlphabeticShortcut(c11, i11);
        }

        public static MenuItem h(MenuItem menuItem, CharSequence charSequence) {
            return menuItem.setContentDescription(charSequence);
        }

        public static MenuItem i(MenuItem menuItem, ColorStateList colorStateList) {
            return menuItem.setIconTintList(colorStateList);
        }

        public static MenuItem j(MenuItem menuItem, PorterDuff.Mode mode) {
            return menuItem.setIconTintMode(mode);
        }

        public static MenuItem k(MenuItem menuItem, char c11, int i11) {
            return menuItem.setNumericShortcut(c11, i11);
        }

        public static MenuItem l(MenuItem menuItem, char c11, char c12, int i11, int i12) {
            return menuItem.setShortcut(c11, c12, i11, i12);
        }

        public static MenuItem m(MenuItem menuItem, CharSequence charSequence) {
            return menuItem.setTooltipText(charSequence);
        }
    }

    private MenuItemCompat() {
    }

    @Deprecated
    public static boolean collapseActionView(MenuItem menuItem) {
        return menuItem.collapseActionView();
    }

    @Deprecated
    public static boolean expandActionView(MenuItem menuItem) {
        return menuItem.expandActionView();
    }

    @Nullable
    public static ActionProvider getActionProvider(@NonNull MenuItem menuItem) {
        if (menuItem instanceof e3.b) {
            return ((e3.b) menuItem).a();
        }
        Log.w(TAG, "getActionProvider: item does not implement SupportMenuItem; returning null");
        return null;
    }

    @Deprecated
    public static View getActionView(MenuItem menuItem) {
        return menuItem.getActionView();
    }

    public static int getAlphabeticModifiers(@NonNull MenuItem menuItem) {
        if (menuItem instanceof e3.b) {
            return ((e3.b) menuItem).getAlphabeticModifiers();
        }
        if (Build.VERSION.SDK_INT >= 26) {
            return b.a(menuItem);
        }
        return 0;
    }

    @Nullable
    public static CharSequence getContentDescription(@NonNull MenuItem menuItem) {
        if (menuItem instanceof e3.b) {
            return ((e3.b) menuItem).getContentDescription();
        }
        if (Build.VERSION.SDK_INT >= 26) {
            return b.b(menuItem);
        }
        return null;
    }

    @Nullable
    public static ColorStateList getIconTintList(@NonNull MenuItem menuItem) {
        if (menuItem instanceof e3.b) {
            return ((e3.b) menuItem).getIconTintList();
        }
        if (Build.VERSION.SDK_INT >= 26) {
            return b.c(menuItem);
        }
        return null;
    }

    @Nullable
    public static PorterDuff.Mode getIconTintMode(@NonNull MenuItem menuItem) {
        if (menuItem instanceof e3.b) {
            return ((e3.b) menuItem).getIconTintMode();
        }
        if (Build.VERSION.SDK_INT >= 26) {
            return b.d(menuItem);
        }
        return null;
    }

    public static int getNumericModifiers(@NonNull MenuItem menuItem) {
        if (menuItem instanceof e3.b) {
            return ((e3.b) menuItem).getNumericModifiers();
        }
        if (Build.VERSION.SDK_INT >= 26) {
            return b.e(menuItem);
        }
        return 0;
    }

    @Nullable
    public static CharSequence getTooltipText(@NonNull MenuItem menuItem) {
        if (menuItem instanceof e3.b) {
            return ((e3.b) menuItem).getTooltipText();
        }
        if (Build.VERSION.SDK_INT >= 26) {
            return b.f(menuItem);
        }
        return null;
    }

    @Deprecated
    public static boolean isActionViewExpanded(MenuItem menuItem) {
        return menuItem.isActionViewExpanded();
    }

    @Nullable
    public static MenuItem setActionProvider(@NonNull MenuItem menuItem, @Nullable ActionProvider actionProvider) {
        if (menuItem instanceof e3.b) {
            return ((e3.b) menuItem).b(actionProvider);
        }
        Log.w(TAG, "setActionProvider: item does not implement SupportMenuItem; ignoring");
        return menuItem;
    }

    @Deprecated
    public static MenuItem setActionView(MenuItem menuItem, int i11) {
        return menuItem.setActionView(i11);
    }

    @Deprecated
    public static MenuItem setActionView(MenuItem menuItem, View view) {
        return menuItem.setActionView(view);
    }

    public static void setAlphabeticShortcut(@NonNull MenuItem menuItem, char c11, int i11) {
        if (menuItem instanceof e3.b) {
            ((e3.b) menuItem).setAlphabeticShortcut(c11, i11);
        } else if (Build.VERSION.SDK_INT >= 26) {
            b.g(menuItem, c11, i11);
        }
    }

    public static void setContentDescription(@NonNull MenuItem menuItem, @Nullable CharSequence charSequence) {
        if (menuItem instanceof e3.b) {
            ((e3.b) menuItem).setContentDescription(charSequence);
        } else if (Build.VERSION.SDK_INT >= 26) {
            b.h(menuItem, charSequence);
        }
    }

    public static void setIconTintList(@NonNull MenuItem menuItem, @Nullable ColorStateList colorStateList) {
        if (menuItem instanceof e3.b) {
            ((e3.b) menuItem).setIconTintList(colorStateList);
        } else if (Build.VERSION.SDK_INT >= 26) {
            b.i(menuItem, colorStateList);
        }
    }

    public static void setIconTintMode(@NonNull MenuItem menuItem, @Nullable PorterDuff.Mode mode) {
        if (menuItem instanceof e3.b) {
            ((e3.b) menuItem).setIconTintMode(mode);
        } else if (Build.VERSION.SDK_INT >= 26) {
            b.j(menuItem, mode);
        }
    }

    public static void setNumericShortcut(@NonNull MenuItem menuItem, char c11, int i11) {
        if (menuItem instanceof e3.b) {
            ((e3.b) menuItem).setNumericShortcut(c11, i11);
        } else if (Build.VERSION.SDK_INT >= 26) {
            b.k(menuItem, c11, i11);
        }
    }

    @Deprecated
    public static MenuItem setOnActionExpandListener(MenuItem menuItem, OnActionExpandListener onActionExpandListener) {
        return menuItem.setOnActionExpandListener(new a(onActionExpandListener));
    }

    public static void setShortcut(@NonNull MenuItem menuItem, char c11, char c12, int i11, int i12) {
        if (menuItem instanceof e3.b) {
            ((e3.b) menuItem).setShortcut(c11, c12, i11, i12);
        } else if (Build.VERSION.SDK_INT >= 26) {
            b.l(menuItem, c11, c12, i11, i12);
        }
    }

    @Deprecated
    public static void setShowAsAction(MenuItem menuItem, int i11) {
        menuItem.setShowAsAction(i11);
    }

    public static void setTooltipText(@NonNull MenuItem menuItem, @Nullable CharSequence charSequence) {
        if (menuItem instanceof e3.b) {
            ((e3.b) menuItem).setTooltipText(charSequence);
        } else if (Build.VERSION.SDK_INT >= 26) {
            b.m(menuItem, charSequence);
        }
    }
}
