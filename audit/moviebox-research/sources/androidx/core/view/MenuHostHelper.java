package androidx.core.view;

import android.annotation.SuppressLint;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class MenuHostHelper {
    private final Runnable mOnInvalidateMenuCallback;
    private final CopyOnWriteArrayList<MenuProvider> mMenuProviders = new CopyOnWriteArrayList<>();
    private final Map<MenuProvider, a> mProviderToLifecycleContainers = new HashMap();

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Lifecycle f7912a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public androidx.lifecycle.r f7913b;

        public a(@NonNull Lifecycle lifecycle, @NonNull androidx.lifecycle.r rVar) {
            this.f7912a = lifecycle;
            this.f7913b = rVar;
            lifecycle.a(rVar);
        }

        public void a() {
            this.f7912a.d(this.f7913b);
            this.f7913b = null;
        }
    }

    public MenuHostHelper(@NonNull Runnable runnable) {
        this.mOnInvalidateMenuCallback = runnable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addMenuProvider$0(MenuProvider menuProvider, androidx.lifecycle.u uVar, Lifecycle.Event event) {
        if (event == Lifecycle.Event.ON_DESTROY) {
            removeMenuProvider(menuProvider);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addMenuProvider$1(Lifecycle.State state, MenuProvider menuProvider, androidx.lifecycle.u uVar, Lifecycle.Event event) {
        if (event == Lifecycle.Event.upTo(state)) {
            addMenuProvider(menuProvider);
            return;
        }
        if (event == Lifecycle.Event.ON_DESTROY) {
            removeMenuProvider(menuProvider);
        } else if (event == Lifecycle.Event.downFrom(state)) {
            this.mMenuProviders.remove(menuProvider);
            this.mOnInvalidateMenuCallback.run();
        }
    }

    public void addMenuProvider(@NonNull MenuProvider menuProvider) {
        this.mMenuProviders.add(menuProvider);
        this.mOnInvalidateMenuCallback.run();
    }

    public void addMenuProvider(@NonNull final MenuProvider menuProvider, @NonNull androidx.lifecycle.u uVar) {
        addMenuProvider(menuProvider);
        Lifecycle lifecycle = uVar.getLifecycle();
        a aVarRemove = this.mProviderToLifecycleContainers.remove(menuProvider);
        if (aVarRemove != null) {
            aVarRemove.a();
        }
        this.mProviderToLifecycleContainers.put(menuProvider, new a(lifecycle, new androidx.lifecycle.r() { // from class: androidx.core.view.v
            @Override // androidx.lifecycle.r
            public final void onStateChanged(androidx.lifecycle.u uVar2, Lifecycle.Event event) {
                this.f8026a.lambda$addMenuProvider$0(menuProvider, uVar2, event);
            }
        }));
    }

    @SuppressLint({"LambdaLast"})
    public void addMenuProvider(@NonNull final MenuProvider menuProvider, @NonNull androidx.lifecycle.u uVar, @NonNull final Lifecycle.State state) {
        Lifecycle lifecycle = uVar.getLifecycle();
        a aVarRemove = this.mProviderToLifecycleContainers.remove(menuProvider);
        if (aVarRemove != null) {
            aVarRemove.a();
        }
        this.mProviderToLifecycleContainers.put(menuProvider, new a(lifecycle, new androidx.lifecycle.r() { // from class: androidx.core.view.w
            @Override // androidx.lifecycle.r
            public final void onStateChanged(androidx.lifecycle.u uVar2, Lifecycle.Event event) {
                this.f8028a.lambda$addMenuProvider$1(state, menuProvider, uVar2, event);
            }
        }));
    }

    public void onCreateMenu(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
        Iterator<MenuProvider> it = this.mMenuProviders.iterator();
        while (it.hasNext()) {
            it.next().onCreateMenu(menu, menuInflater);
        }
    }

    public void onMenuClosed(@NonNull Menu menu) {
        Iterator<MenuProvider> it = this.mMenuProviders.iterator();
        while (it.hasNext()) {
            it.next().onMenuClosed(menu);
        }
    }

    public boolean onMenuItemSelected(@NonNull MenuItem menuItem) {
        Iterator<MenuProvider> it = this.mMenuProviders.iterator();
        while (it.hasNext()) {
            if (it.next().onMenuItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void onPrepareMenu(@NonNull Menu menu) {
        Iterator<MenuProvider> it = this.mMenuProviders.iterator();
        while (it.hasNext()) {
            it.next().onPrepareMenu(menu);
        }
    }

    public void removeMenuProvider(@NonNull MenuProvider menuProvider) {
        this.mMenuProviders.remove(menuProvider);
        a aVarRemove = this.mProviderToLifecycleContainers.remove(menuProvider);
        if (aVarRemove != null) {
            aVarRemove.a();
        }
        this.mOnInvalidateMenuCallback.run();
    }
}
