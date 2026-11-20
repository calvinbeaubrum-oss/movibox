package androidx.core.view;

import android.R;
import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class SoftwareKeyboardControllerCompat {
    private final c mImpl;

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(20)
    public static class a extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public final View f7915a;

        public a(@Nullable View view) {
            this.f7915a = view;
        }

        public static /* synthetic */ void d(View view) {
            ((InputMethodManager) view.getContext().getSystemService("input_method")).showSoftInput(view, 0);
        }

        @Override // androidx.core.view.SoftwareKeyboardControllerCompat.c
        public void a() {
            View view = this.f7915a;
            if (view != null) {
                ((InputMethodManager) view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.f7915a.getWindowToken(), 0);
            }
        }

        @Override // androidx.core.view.SoftwareKeyboardControllerCompat.c
        public void b() {
            final View viewFindViewById = this.f7915a;
            if (viewFindViewById == null) {
                return;
            }
            if (viewFindViewById.isInEditMode() || viewFindViewById.onCheckIsTextEditor()) {
                viewFindViewById.requestFocus();
            } else {
                viewFindViewById = viewFindViewById.getRootView().findFocus();
            }
            if (viewFindViewById == null) {
                viewFindViewById = this.f7915a.getRootView().findViewById(R.id.content);
            }
            if (viewFindViewById == null || !viewFindViewById.hasWindowFocus()) {
                return;
            }
            viewFindViewById.post(new Runnable() { // from class: androidx.core.view.y
                @Override // java.lang.Runnable
                public final void run() {
                    SoftwareKeyboardControllerCompat.a.d(viewFindViewById);
                }
            });
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(30)
    public static class b extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public View f7916b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        public WindowInsetsController f7917c;

        public b(@NonNull View view) {
            super(view);
            this.f7916b = view;
        }

        public b(@Nullable WindowInsetsController windowInsetsController) {
            super(null);
            this.f7917c = windowInsetsController;
        }

        public static /* synthetic */ void f(AtomicBoolean atomicBoolean, WindowInsetsController windowInsetsController, int i11) {
            atomicBoolean.set((i11 & 8) != 0);
        }

        @Override // androidx.core.view.SoftwareKeyboardControllerCompat.a, androidx.core.view.SoftwareKeyboardControllerCompat.c
        public void a() {
            View view;
            WindowInsetsController windowInsetsController = this.f7917c;
            if (windowInsetsController == null) {
                View view2 = this.f7916b;
                windowInsetsController = view2 != null ? view2.getWindowInsetsController() : null;
            }
            if (windowInsetsController == null) {
                super.a();
                return;
            }
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            WindowInsetsController.OnControllableInsetsChangedListener onControllableInsetsChangedListener = new WindowInsetsController.OnControllableInsetsChangedListener() { // from class: androidx.core.view.f0
                @Override // android.view.WindowInsetsController.OnControllableInsetsChangedListener
                public final void onControllableInsetsChanged(WindowInsetsController windowInsetsController2, int i11) {
                    SoftwareKeyboardControllerCompat.b.f(atomicBoolean, windowInsetsController2, i11);
                }
            };
            windowInsetsController.addOnControllableInsetsChangedListener(onControllableInsetsChangedListener);
            if (!atomicBoolean.get() && (view = this.f7916b) != null) {
                ((InputMethodManager) view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.f7916b.getWindowToken(), 0);
            }
            windowInsetsController.removeOnControllableInsetsChangedListener(onControllableInsetsChangedListener);
            windowInsetsController.hide(WindowInsets.Type.ime());
        }

        @Override // androidx.core.view.SoftwareKeyboardControllerCompat.a, androidx.core.view.SoftwareKeyboardControllerCompat.c
        public void b() {
            View view = this.f7916b;
            if (view != null && Build.VERSION.SDK_INT < 33) {
                ((InputMethodManager) view.getContext().getSystemService("input_method")).isActive();
            }
            WindowInsetsController windowInsetsController = this.f7917c;
            if (windowInsetsController == null) {
                View view2 = this.f7916b;
                windowInsetsController = view2 != null ? view2.getWindowInsetsController() : null;
            }
            if (windowInsetsController != null) {
                windowInsetsController.show(WindowInsets.Type.ime());
            }
            super.b();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c {
        public void a() {
            throw null;
        }

        public void b() {
            throw null;
        }
    }

    public SoftwareKeyboardControllerCompat(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 30) {
            this.mImpl = new b(view);
        } else {
            this.mImpl = new a(view);
        }
    }

    @RequiresApi(30)
    @Deprecated
    public SoftwareKeyboardControllerCompat(@NonNull WindowInsetsController windowInsetsController) {
        this.mImpl = new b(windowInsetsController);
    }

    public void hide() {
        this.mImpl.a();
    }

    public void show() {
        this.mImpl.b();
    }
}
