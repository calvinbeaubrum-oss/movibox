package androidx.appcompat.widget;

import android.view.Menu;
import android.view.Window;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public interface v {
    boolean canShowOverflowMenu();

    void dismissPopups();

    boolean hideOverflowMenu();

    void initFeature(int i11);

    boolean isOverflowMenuShowPending();

    boolean isOverflowMenuShowing();

    void setMenu(Menu menu, androidx.appcompat.view.menu.l.a aVar);

    void setMenuPrepared();

    void setWindowCallback(Window.Callback callback);

    void setWindowTitle(CharSequence charSequence);

    boolean showOverflowMenu();
}
