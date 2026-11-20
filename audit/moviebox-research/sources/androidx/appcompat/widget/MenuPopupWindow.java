package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.transition.Transition;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.view.menu.ListMenuItemView;
import com.vungle.warren.error.VungleException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class MenuPopupWindow extends ListPopupWindow implements d0 {
    public static Method L;
    public d0 K;

    /* JADX INFO: compiled from: source.java */
    public static class MenuDropDownListView extends DropDownListView {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final int f1478o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final int f1479p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public d0 f1480q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public MenuItem f1481r;

        public MenuDropDownListView(Context context, boolean z11) {
            super(context, z11);
            if (1 == context.getResources().getConfiguration().getLayoutDirection()) {
                this.f1478o = 21;
                this.f1479p = 22;
            } else {
                this.f1478o = 22;
                this.f1479p = 21;
            }
        }

        public void clearSelection() {
            setSelection(-1);
        }

        @Override // androidx.appcompat.widget.DropDownListView, android.view.ViewGroup, android.view.View
        public /* bridge */ /* synthetic */ boolean hasFocus() {
            return super.hasFocus();
        }

        @Override // androidx.appcompat.widget.DropDownListView, android.view.View
        public /* bridge */ /* synthetic */ boolean hasWindowFocus() {
            return super.hasWindowFocus();
        }

        @Override // androidx.appcompat.widget.DropDownListView, android.view.View
        public /* bridge */ /* synthetic */ boolean isFocused() {
            return super.isFocused();
        }

        @Override // androidx.appcompat.widget.DropDownListView, android.view.View
        public /* bridge */ /* synthetic */ boolean isInTouchMode() {
            return super.isInTouchMode();
        }

        @Override // androidx.appcompat.widget.DropDownListView
        public /* bridge */ /* synthetic */ int lookForSelectablePosition(int i11, boolean z11) {
            return super.lookForSelectablePosition(i11, z11);
        }

        @Override // androidx.appcompat.widget.DropDownListView
        public /* bridge */ /* synthetic */ int measureHeightOfChildrenCompat(int i11, int i12, int i13, int i14, int i15) {
            return super.measureHeightOfChildrenCompat(i11, i12, i13, i14, i15);
        }

        @Override // androidx.appcompat.widget.DropDownListView
        public /* bridge */ /* synthetic */ boolean onForwardedEvent(MotionEvent motionEvent, int i11) {
            return super.onForwardedEvent(motionEvent, i11);
        }

        @Override // androidx.appcompat.widget.DropDownListView, android.view.View
        public boolean onHoverEvent(MotionEvent motionEvent) {
            androidx.appcompat.view.menu.e eVar;
            int headersCount;
            int iPointToPosition;
            int i11;
            if (this.f1480q != null) {
                ListAdapter adapter = getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                    headersCount = headerViewListAdapter.getHeadersCount();
                    eVar = (androidx.appcompat.view.menu.e) headerViewListAdapter.getWrappedAdapter();
                } else {
                    eVar = (androidx.appcompat.view.menu.e) adapter;
                    headersCount = 0;
                }
                androidx.appcompat.view.menu.h item = (motionEvent.getAction() == 10 || (iPointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY())) == -1 || (i11 = iPointToPosition - headersCount) < 0 || i11 >= eVar.getCount()) ? null : eVar.getItem(i11);
                MenuItem menuItem = this.f1481r;
                if (menuItem != item) {
                    androidx.appcompat.view.menu.f fVarB = eVar.b();
                    if (menuItem != null) {
                        this.f1480q.n(fVarB, menuItem);
                    }
                    this.f1481r = item;
                    if (item != null) {
                        this.f1480q.d(fVarB, item);
                    }
                }
            }
            return super.onHoverEvent(motionEvent);
        }

        @Override // android.widget.ListView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
        public boolean onKeyDown(int i11, KeyEvent keyEvent) {
            ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
            if (listMenuItemView != null && i11 == this.f1478o) {
                if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                    performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
                }
                return true;
            }
            if (listMenuItemView == null || i11 != this.f1479p) {
                return super.onKeyDown(i11, keyEvent);
            }
            setSelection(-1);
            ListAdapter adapter = getAdapter();
            (adapter instanceof HeaderViewListAdapter ? (androidx.appcompat.view.menu.e) ((HeaderViewListAdapter) adapter).getWrappedAdapter() : (androidx.appcompat.view.menu.e) adapter).b().e(false);
            return true;
        }

        @Override // androidx.appcompat.widget.DropDownListView, android.widget.AbsListView, android.view.View
        public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
            return super.onTouchEvent(motionEvent);
        }

        public void setHoverListener(d0 d0Var) {
            this.f1480q = d0Var;
        }

        @Override // androidx.appcompat.widget.DropDownListView, android.widget.AbsListView
        public /* bridge */ /* synthetic */ void setSelector(Drawable drawable) {
            super.setSelector(drawable);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(23)
    public static class a {
        public static void a(PopupWindow popupWindow, Transition transition) {
            popupWindow.setEnterTransition(transition);
        }

        public static void b(PopupWindow popupWindow, Transition transition) {
            popupWindow.setExitTransition(transition);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(VungleException.INCORRECT_DEFAULT_API_USAGE)
    public static class b {
        public static void a(PopupWindow popupWindow, boolean z11) {
            popupWindow.setTouchModal(z11);
        }
    }

    static {
        try {
            if (Build.VERSION.SDK_INT <= 28) {
                L = PopupWindow.class.getDeclaredMethod("setTouchModal", Boolean.TYPE);
            }
        } catch (NoSuchMethodException unused) {
        }
    }

    public MenuPopupWindow(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
    }

    public void R(Object obj) {
        if (Build.VERSION.SDK_INT >= 23) {
            a.a(this.G, (Transition) obj);
        }
    }

    public void S(Object obj) {
        if (Build.VERSION.SDK_INT >= 23) {
            a.b(this.G, (Transition) obj);
        }
    }

    public void T(d0 d0Var) {
        this.K = d0Var;
    }

    public void U(boolean z11) {
        if (Build.VERSION.SDK_INT > 28) {
            b.a(this.G, z11);
            return;
        }
        Method method = L;
        if (method != null) {
            try {
                method.invoke(this.G, Boolean.valueOf(z11));
            } catch (Exception unused) {
            }
        }
    }

    @Override // androidx.appcompat.widget.d0
    public void d(@NonNull androidx.appcompat.view.menu.f fVar, @NonNull MenuItem menuItem) {
        d0 d0Var = this.K;
        if (d0Var != null) {
            d0Var.d(fVar, menuItem);
        }
    }

    @Override // androidx.appcompat.widget.d0
    public void n(@NonNull androidx.appcompat.view.menu.f fVar, @NonNull MenuItem menuItem) {
        d0 d0Var = this.K;
        if (d0Var != null) {
            d0Var.n(fVar, menuItem);
        }
    }

    @Override // androidx.appcompat.widget.ListPopupWindow
    @NonNull
    public DropDownListView r(Context context, boolean z11) {
        MenuDropDownListView menuDropDownListView = new MenuDropDownListView(context, z11);
        menuDropDownListView.setHoverListener(this);
        return menuDropDownListView;
    }
}
