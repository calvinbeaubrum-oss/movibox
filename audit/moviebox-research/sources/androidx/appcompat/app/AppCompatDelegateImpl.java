package androidx.appcompat.app;

import android.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$color;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$style;
import androidx.appcompat.R$styleable;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ViewStubCompat;
import androidx.appcompat.widget.n0;
import androidx.appcompat.widget.x0;
import androidx.appcompat.widget.y0;
import androidx.collection.v0;
import androidx.core.app.ActivityCompat;
import androidx.core.view.KeyEventDispatcher;
import androidx.core.view.LayoutInflaterCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Lifecycle;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class AppCompatDelegateImpl extends androidx.appcompat.app.f implements androidx.appcompat.view.menu.f.a, LayoutInflater.Factory2 {

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final v0<String, Integer> f737k0 = new v0<>();

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public static final boolean f738l0 = false;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public static final int[] f739m0 = {R.attr.windowBackground};

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public static final boolean f740n0 = !"robolectric".equals(Build.FINGERPRINT);
    public boolean A;
    public boolean B;
    public ViewGroup C;
    public TextView D;
    public View E;
    public boolean F;
    public boolean G;
    public boolean H;
    public boolean I;
    public boolean J;
    public boolean K;
    public boolean L;
    public boolean M;
    public PanelFeatureState[] N;
    public PanelFeatureState O;
    public boolean P;
    public boolean Q;
    public boolean R;
    public boolean S;
    public Configuration T;
    public int U;
    public int V;
    public int W;
    public boolean X;
    public n Y;
    public n Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public boolean f741a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public int f742b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public final Runnable f743c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public boolean f744d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public Rect f745e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public Rect f746f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public x f747g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public y f748h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public OnBackInvokedDispatcher f749i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public OnBackInvokedCallback f750j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Object f751k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Context f752l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Window f753m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public l f754n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final androidx.appcompat.app.d f755o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public androidx.appcompat.app.a f756p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public MenuInflater f757q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public CharSequence f758r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public androidx.appcompat.widget.v f759s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public f f760t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public q f761u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public g1.b f762v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public ActionBarContextView f763w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public PopupWindow f764x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Runnable f765y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public ViewPropertyAnimatorCompat f766z;

    /* JADX INFO: compiled from: source.java */
    public static final class PanelFeatureState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f768a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f769b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f770c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f771d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f772e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f773f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public ViewGroup f774g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public View f775h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public View f776i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public androidx.appcompat.view.menu.f f777j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public androidx.appcompat.view.menu.d f778k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public Context f779l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f780m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f781n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f782o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public boolean f783p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public boolean f784q = false;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public boolean f785r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public Bundle f786s;

        /* JADX INFO: compiled from: source.java */
        /* JADX INFO: loaded from: classes2.dex */
        @SuppressLint({"BanParcelableUsage"})
        public static class SavedState implements Parcelable {
            public static final Parcelable.Creator<SavedState> CREATOR = new a();

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f787a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public boolean f788b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public Bundle f789c;

            /* JADX INFO: compiled from: source.java */
            public class a implements Parcelable.ClassLoaderCreator<SavedState> {
                @Override // android.os.Parcelable.Creator
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public SavedState createFromParcel(Parcel parcel) {
                    return SavedState.a(parcel, null);
                }

                @Override // android.os.Parcelable.ClassLoaderCreator
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    return SavedState.a(parcel, classLoader);
                }

                @Override // android.os.Parcelable.Creator
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public SavedState[] newArray(int i11) {
                    return new SavedState[i11];
                }
            }

            public static SavedState a(Parcel parcel, ClassLoader classLoader) {
                SavedState savedState = new SavedState();
                savedState.f787a = parcel.readInt();
                boolean z11 = parcel.readInt() == 1;
                savedState.f788b = z11;
                if (z11) {
                    savedState.f789c = parcel.readBundle(classLoader);
                }
                return savedState;
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i11) {
                parcel.writeInt(this.f787a);
                parcel.writeInt(this.f788b ? 1 : 0);
                if (this.f788b) {
                    parcel.writeBundle(this.f789c);
                }
            }
        }

        public PanelFeatureState(int i11) {
            this.f768a = i11;
        }

        public androidx.appcompat.view.menu.m a(androidx.appcompat.view.menu.l.a aVar) {
            if (this.f777j == null) {
                return null;
            }
            if (this.f778k == null) {
                androidx.appcompat.view.menu.d dVar = new androidx.appcompat.view.menu.d(this.f779l, R$layout.abc_list_menu_item_layout);
                this.f778k = dVar;
                dVar.d(aVar);
                this.f777j.b(this.f778k);
            }
            return this.f778k.l(this.f774g);
        }

        public boolean b() {
            if (this.f775h == null) {
                return false;
            }
            return this.f776i != null || this.f778k.a().getCount() > 0;
        }

        public void c(androidx.appcompat.view.menu.f fVar) {
            androidx.appcompat.view.menu.d dVar;
            androidx.appcompat.view.menu.f fVar2 = this.f777j;
            if (fVar == fVar2) {
                return;
            }
            if (fVar2 != null) {
                fVar2.R(this.f778k);
            }
            this.f777j = fVar;
            if (fVar == null || (dVar = this.f778k) == null) {
                return;
            }
            fVar.b(dVar);
        }

        public void d(Context context) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme themeNewTheme = context.getResources().newTheme();
            themeNewTheme.setTo(context.getTheme());
            themeNewTheme.resolveAttribute(R$attr.actionBarPopupTheme, typedValue, true);
            int i11 = typedValue.resourceId;
            if (i11 != 0) {
                themeNewTheme.applyStyle(i11, true);
            }
            themeNewTheme.resolveAttribute(R$attr.panelMenuListTheme, typedValue, true);
            int i12 = typedValue.resourceId;
            if (i12 != 0) {
                themeNewTheme.applyStyle(i12, true);
            } else {
                themeNewTheme.applyStyle(R$style.Theme_AppCompat_CompactMenu, true);
            }
            g1.d dVar = new g1.d(context, 0);
            dVar.getTheme().setTo(themeNewTheme);
            this.f779l = dVar;
            TypedArray typedArrayObtainStyledAttributes = dVar.obtainStyledAttributes(R$styleable.AppCompatTheme);
            this.f769b = typedArrayObtainStyledAttributes.getResourceId(R$styleable.AppCompatTheme_panelBackground, 0);
            this.f773f = typedArrayObtainStyledAttributes.getResourceId(R$styleable.AppCompatTheme_android_windowAnimationStyle, 0);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public class a implements OnApplyWindowInsetsListener {
        public a() {
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            int systemWindowInsetTop = windowInsetsCompat.getSystemWindowInsetTop();
            int iH1 = AppCompatDelegateImpl.this.h1(windowInsetsCompat, null);
            if (systemWindowInsetTop != iH1) {
                windowInsetsCompat = windowInsetsCompat.replaceSystemWindowInsets(windowInsetsCompat.getSystemWindowInsetLeft(), iH1, windowInsetsCompat.getSystemWindowInsetRight(), windowInsetsCompat.getSystemWindowInsetBottom());
            }
            return ViewCompat.onApplyWindowInsets(view, windowInsetsCompat);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public class b implements ContentFrameLayout.a {
        public b() {
        }

        @Override // androidx.appcompat.widget.ContentFrameLayout.a
        public void a() {
        }

        @Override // androidx.appcompat.widget.ContentFrameLayout.a
        public void onDetachedFromWindow() {
            AppCompatDelegateImpl.this.j0();
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public class c extends ViewPropertyAnimatorListenerAdapter {
        public c() {
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            AppCompatDelegateImpl.this.f763w.setAlpha(1.0f);
            AppCompatDelegateImpl.this.f766z.setListener(null);
            AppCompatDelegateImpl.this.f766z = null;
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationStart(View view) {
            AppCompatDelegateImpl.this.f763w.setVisibility(0);
            if (AppCompatDelegateImpl.this.f763w.getParent() instanceof View) {
                ViewCompat.requestApplyInsets((View) AppCompatDelegateImpl.this.f763w.getParent());
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public class d implements androidx.appcompat.app.b {
        public d() {
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public interface e {
        boolean a(int i11);

        @Nullable
        View onCreatePanelView(int i11);
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public final class f implements androidx.appcompat.view.menu.l.a {
        public f() {
        }

        @Override // androidx.appcompat.view.menu.l.a
        public void b(@NonNull androidx.appcompat.view.menu.f fVar, boolean z11) {
            AppCompatDelegateImpl.this.d0(fVar);
        }

        @Override // androidx.appcompat.view.menu.l.a
        public boolean c(@NonNull androidx.appcompat.view.menu.f fVar) {
            Window.Callback callbackY0 = AppCompatDelegateImpl.this.y0();
            if (callbackY0 == null) {
                return true;
            }
            callbackY0.onMenuOpened(108, fVar);
            return true;
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public class g implements g1.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public g1.b.a f795a;

        /* JADX INFO: compiled from: source.java */
        public class a extends ViewPropertyAnimatorListenerAdapter {
            public a() {
            }

            @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                AppCompatDelegateImpl.this.f763w.setVisibility(8);
                AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
                PopupWindow popupWindow = appCompatDelegateImpl.f764x;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                } else if (appCompatDelegateImpl.f763w.getParent() instanceof View) {
                    ViewCompat.requestApplyInsets((View) AppCompatDelegateImpl.this.f763w.getParent());
                }
                AppCompatDelegateImpl.this.f763w.killMode();
                AppCompatDelegateImpl.this.f766z.setListener(null);
                AppCompatDelegateImpl appCompatDelegateImpl2 = AppCompatDelegateImpl.this;
                appCompatDelegateImpl2.f766z = null;
                ViewCompat.requestApplyInsets(appCompatDelegateImpl2.C);
            }
        }

        public g(g1.b.a aVar) {
            this.f795a = aVar;
        }

        @Override // g1.b.a
        public boolean a(g1.b bVar, Menu menu) {
            ViewCompat.requestApplyInsets(AppCompatDelegateImpl.this.C);
            return this.f795a.a(bVar, menu);
        }

        @Override // g1.b.a
        public boolean b(g1.b bVar, MenuItem menuItem) {
            return this.f795a.b(bVar, menuItem);
        }

        @Override // g1.b.a
        public boolean c(g1.b bVar, Menu menu) {
            return this.f795a.c(bVar, menu);
        }

        @Override // g1.b.a
        public void d(g1.b bVar) {
            this.f795a.d(bVar);
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (appCompatDelegateImpl.f764x != null) {
                appCompatDelegateImpl.f753m.getDecorView().removeCallbacks(AppCompatDelegateImpl.this.f765y);
            }
            AppCompatDelegateImpl appCompatDelegateImpl2 = AppCompatDelegateImpl.this;
            if (appCompatDelegateImpl2.f763w != null) {
                appCompatDelegateImpl2.m0();
                AppCompatDelegateImpl appCompatDelegateImpl3 = AppCompatDelegateImpl.this;
                appCompatDelegateImpl3.f766z = ViewCompat.animate(appCompatDelegateImpl3.f763w).alpha(0.0f);
                AppCompatDelegateImpl.this.f766z.setListener(new a());
            }
            AppCompatDelegateImpl appCompatDelegateImpl4 = AppCompatDelegateImpl.this;
            androidx.appcompat.app.d dVar = appCompatDelegateImpl4.f755o;
            if (dVar != null) {
                dVar.onSupportActionModeFinished(appCompatDelegateImpl4.f762v);
            }
            AppCompatDelegateImpl appCompatDelegateImpl5 = AppCompatDelegateImpl.this;
            appCompatDelegateImpl5.f762v = null;
            ViewCompat.requestApplyInsets(appCompatDelegateImpl5.C);
            AppCompatDelegateImpl.this.f1();
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    @RequiresApi(21)
    public static class h {
        public static boolean a(PowerManager powerManager) {
            return powerManager.isPowerSaveMode();
        }

        public static String b(Locale locale) {
            return locale.toLanguageTag();
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    @RequiresApi(24)
    public static class i {
        public static void a(@NonNull Configuration configuration, @NonNull Configuration configuration2, @NonNull Configuration configuration3) {
            LocaleList locales = configuration.getLocales();
            LocaleList locales2 = configuration2.getLocales();
            if (locales.equals(locales2)) {
                return;
            }
            configuration3.setLocales(locales2);
            configuration3.locale = configuration2.locale;
        }

        public static androidx.core.os.h b(Configuration configuration) {
            return androidx.core.os.h.c(configuration.getLocales().toLanguageTags());
        }

        public static void c(androidx.core.os.h hVar) {
            LocaleList.setDefault(LocaleList.forLanguageTags(hVar.h()));
        }

        public static void d(Configuration configuration, androidx.core.os.h hVar) {
            configuration.setLocales(LocaleList.forLanguageTags(hVar.h()));
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    @RequiresApi(26)
    public static class j {
        public static void a(@NonNull Configuration configuration, @NonNull Configuration configuration2, @NonNull Configuration configuration3) {
            if ((configuration.colorMode & 3) != (configuration2.colorMode & 3)) {
                configuration3.colorMode |= configuration2.colorMode & 3;
            }
            if ((configuration.colorMode & 12) != (configuration2.colorMode & 12)) {
                configuration3.colorMode |= configuration2.colorMode & 12;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    @RequiresApi(33)
    public static class k {
        public static OnBackInvokedDispatcher a(Activity activity) {
            return activity.getOnBackInvokedDispatcher();
        }

        public static OnBackInvokedCallback b(Object obj, final AppCompatDelegateImpl appCompatDelegateImpl) {
            Objects.requireNonNull(appCompatDelegateImpl);
            OnBackInvokedCallback onBackInvokedCallback = new OnBackInvokedCallback() { // from class: androidx.appcompat.app.u
                @Override // android.window.OnBackInvokedCallback
                public final void onBackInvoked() {
                    appCompatDelegateImpl.G0();
                }
            };
            r.a(obj).registerOnBackInvokedCallback(1000000, onBackInvokedCallback);
            return onBackInvokedCallback;
        }

        public static void c(Object obj, Object obj2) {
            r.a(obj).unregisterOnBackInvokedCallback(androidx.appcompat.app.q.a(obj2));
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public class l extends g1.i {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public e f798b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f799c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f800d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f801f;

        public l(Window.Callback callback) {
            super(callback);
        }

        public boolean b(Window.Callback callback, KeyEvent keyEvent) {
            try {
                this.f800d = true;
                return callback.dispatchKeyEvent(keyEvent);
            } finally {
                this.f800d = false;
            }
        }

        public void c(Window.Callback callback) {
            try {
                this.f799c = true;
                callback.onContentChanged();
            } finally {
                this.f799c = false;
            }
        }

        public void d(Window.Callback callback, int i11, Menu menu) {
            try {
                this.f801f = true;
                callback.onPanelClosed(i11, menu);
            } finally {
                this.f801f = false;
            }
        }

        @Override // g1.i, android.view.Window.Callback
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            if (this.f800d) {
                return a().dispatchKeyEvent(keyEvent);
            }
            return AppCompatDelegateImpl.this.k0(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // g1.i, android.view.Window.Callback
        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            return super.dispatchKeyShortcutEvent(keyEvent) || AppCompatDelegateImpl.this.J0(keyEvent.getKeyCode(), keyEvent);
        }

        public void e(@Nullable e eVar) {
            this.f798b = eVar;
        }

        public final ActionMode f(ActionMode.Callback callback) {
            g1.f.a aVar = new g1.f.a(AppCompatDelegateImpl.this.f752l, callback);
            g1.b bVarT = AppCompatDelegateImpl.this.T(aVar);
            if (bVarT != null) {
                return aVar.e(bVarT);
            }
            return null;
        }

        @Override // android.view.Window.Callback
        public void onContentChanged() {
            if (this.f799c) {
                a().onContentChanged();
            }
        }

        @Override // g1.i, android.view.Window.Callback
        public boolean onCreatePanelMenu(int i11, Menu menu) {
            if (i11 != 0 || (menu instanceof androidx.appcompat.view.menu.f)) {
                return super.onCreatePanelMenu(i11, menu);
            }
            return false;
        }

        @Override // g1.i, android.view.Window.Callback
        public View onCreatePanelView(int i11) {
            View viewOnCreatePanelView;
            e eVar = this.f798b;
            return (eVar == null || (viewOnCreatePanelView = eVar.onCreatePanelView(i11)) == null) ? super.onCreatePanelView(i11) : viewOnCreatePanelView;
        }

        @Override // g1.i, android.view.Window.Callback
        public boolean onMenuOpened(int i11, Menu menu) {
            super.onMenuOpened(i11, menu);
            AppCompatDelegateImpl.this.M0(i11);
            return true;
        }

        @Override // g1.i, android.view.Window.Callback
        public void onPanelClosed(int i11, Menu menu) {
            if (this.f801f) {
                a().onPanelClosed(i11, menu);
            } else {
                super.onPanelClosed(i11, menu);
                AppCompatDelegateImpl.this.N0(i11);
            }
        }

        @Override // g1.i, android.view.Window.Callback
        public boolean onPreparePanel(int i11, View view, Menu menu) {
            androidx.appcompat.view.menu.f fVar = menu instanceof androidx.appcompat.view.menu.f ? (androidx.appcompat.view.menu.f) menu : null;
            if (i11 == 0 && fVar == null) {
                return false;
            }
            if (fVar != null) {
                fVar.f0(true);
            }
            e eVar = this.f798b;
            boolean zOnPreparePanel = eVar != null && eVar.a(i11);
            if (!zOnPreparePanel) {
                zOnPreparePanel = super.onPreparePanel(i11, view, menu);
            }
            if (fVar != null) {
                fVar.f0(false);
            }
            return zOnPreparePanel;
        }

        @Override // g1.i, android.view.Window.Callback
        @RequiresApi(24)
        public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i11) {
            androidx.appcompat.view.menu.f fVar;
            PanelFeatureState panelFeatureStateW0 = AppCompatDelegateImpl.this.w0(0, true);
            if (panelFeatureStateW0 == null || (fVar = panelFeatureStateW0.f777j) == null) {
                super.onProvideKeyboardShortcuts(list, menu, i11);
            } else {
                super.onProvideKeyboardShortcuts(list, fVar, i11);
            }
        }

        @Override // g1.i, android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            if (Build.VERSION.SDK_INT >= 23) {
                return null;
            }
            return AppCompatDelegateImpl.this.E0() ? f(callback) : super.onWindowStartingActionMode(callback);
        }

        @Override // g1.i, android.view.Window.Callback
        @RequiresApi(23)
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i11) {
            return (AppCompatDelegateImpl.this.E0() && i11 == 0) ? f(callback) : super.onWindowStartingActionMode(callback, i11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public class m extends n {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final PowerManager f803c;

        public m(Context context) {
            super();
            this.f803c = (PowerManager) context.getApplicationContext().getSystemService("power");
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.n
        public IntentFilter b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
            return intentFilter;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.n
        public int c() {
            return h.a(this.f803c) ? 2 : 1;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.n
        public void d() {
            AppCompatDelegateImpl.this.f();
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public abstract class n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public BroadcastReceiver f805a;

        /* JADX INFO: compiled from: source.java */
        public class a extends BroadcastReceiver {
            public a() {
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                n.this.d();
            }
        }

        public n() {
        }

        public void a() {
            BroadcastReceiver broadcastReceiver = this.f805a;
            if (broadcastReceiver != null) {
                try {
                    AppCompatDelegateImpl.this.f752l.unregisterReceiver(broadcastReceiver);
                } catch (IllegalArgumentException unused) {
                }
                this.f805a = null;
            }
        }

        @Nullable
        public abstract IntentFilter b();

        public abstract int c();

        public abstract void d();

        public void e() {
            a();
            IntentFilter intentFilterB = b();
            if (intentFilterB == null || intentFilterB.countActions() == 0) {
                return;
            }
            if (this.f805a == null) {
                this.f805a = new a();
            }
            AppCompatDelegateImpl.this.f752l.registerReceiver(this.f805a, intentFilterB);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public class o extends n {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final c0 f808c;

        public o(c0 c0Var) {
            super();
            this.f808c = c0Var;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.n
        public IntentFilter b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.TIME_SET");
            intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
            intentFilter.addAction("android.intent.action.TIME_TICK");
            return intentFilter;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.n
        public int c() {
            return this.f808c.d() ? 2 : 1;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.n
        public void d() {
            AppCompatDelegateImpl.this.f();
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public class p extends ContentFrameLayout {
        public p(Context context) {
            super(context);
        }

        public final boolean a(int i11, int i12) {
            return i11 < -5 || i12 < -5 || i11 > getWidth() + 5 || i12 > getHeight() + 5;
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return AppCompatDelegateImpl.this.k0(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0 || !a((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            AppCompatDelegateImpl.this.f0(0);
            return true;
        }

        @Override // android.view.View
        public void setBackgroundResource(int i11) {
            setBackgroundDrawable(d1.a.b(getContext(), i11));
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public final class q implements androidx.appcompat.view.menu.l.a {
        public q() {
        }

        @Override // androidx.appcompat.view.menu.l.a
        public void b(@NonNull androidx.appcompat.view.menu.f fVar, boolean z11) {
            androidx.appcompat.view.menu.f fVarF = fVar.F();
            boolean z12 = fVarF != fVar;
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (z12) {
                fVar = fVarF;
            }
            PanelFeatureState panelFeatureStateP0 = appCompatDelegateImpl.p0(fVar);
            if (panelFeatureStateP0 != null) {
                if (!z12) {
                    AppCompatDelegateImpl.this.g0(panelFeatureStateP0, z11);
                } else {
                    AppCompatDelegateImpl.this.c0(panelFeatureStateP0.f768a, panelFeatureStateP0, fVarF);
                    AppCompatDelegateImpl.this.g0(panelFeatureStateP0, true);
                }
            }
        }

        @Override // androidx.appcompat.view.menu.l.a
        public boolean c(@NonNull androidx.appcompat.view.menu.f fVar) {
            Window.Callback callbackY0;
            if (fVar != fVar.F()) {
                return true;
            }
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (!appCompatDelegateImpl.H || (callbackY0 = appCompatDelegateImpl.y0()) == null || AppCompatDelegateImpl.this.S) {
                return true;
            }
            callbackY0.onMenuOpened(108, fVar);
            return true;
        }
    }

    public AppCompatDelegateImpl(Activity activity, androidx.appcompat.app.d dVar) {
        this(activity, null, dVar, activity);
    }

    public AppCompatDelegateImpl(Dialog dialog, androidx.appcompat.app.d dVar) {
        this(dialog.getContext(), dialog.getWindow(), dVar, dialog);
    }

    public AppCompatDelegateImpl(Context context, Window window, androidx.appcompat.app.d dVar, Object obj) {
        v0<String, Integer> v0Var;
        Integer num;
        AppCompatActivity appCompatActivityC1;
        this.f766z = null;
        this.A = true;
        this.U = -100;
        this.f743c0 = new Runnable() { // from class: androidx.appcompat.app.AppCompatDelegateImpl.2
            @Override // java.lang.Runnable
            public void run() {
                AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
                if ((appCompatDelegateImpl.f742b0 & 1) != 0) {
                    appCompatDelegateImpl.l0(0);
                }
                AppCompatDelegateImpl appCompatDelegateImpl2 = AppCompatDelegateImpl.this;
                if ((appCompatDelegateImpl2.f742b0 & 4096) != 0) {
                    appCompatDelegateImpl2.l0(108);
                }
                AppCompatDelegateImpl appCompatDelegateImpl3 = AppCompatDelegateImpl.this;
                appCompatDelegateImpl3.f741a0 = false;
                appCompatDelegateImpl3.f742b0 = 0;
            }
        };
        this.f752l = context;
        this.f755o = dVar;
        this.f751k = obj;
        if (this.U == -100 && (obj instanceof Dialog) && (appCompatActivityC1 = c1()) != null) {
            this.U = appCompatActivityC1.getDelegate().r();
        }
        if (this.U == -100 && (num = (v0Var = f737k0).get(obj.getClass().getName())) != null) {
            this.U = num.intValue();
            v0Var.remove(obj.getClass().getName());
        }
        if (window != null) {
            Z(window);
        }
        androidx.appcompat.widget.f.h();
    }

    @NonNull
    public static Configuration q0(@NonNull Configuration configuration, @Nullable Configuration configuration2) {
        Configuration configuration3 = new Configuration();
        configuration3.fontScale = 0.0f;
        if (configuration2 != null && configuration.diff(configuration2) != 0) {
            float f11 = configuration.fontScale;
            float f12 = configuration2.fontScale;
            if (f11 != f12) {
                configuration3.fontScale = f12;
            }
            int i11 = configuration.mcc;
            int i12 = configuration2.mcc;
            if (i11 != i12) {
                configuration3.mcc = i12;
            }
            int i13 = configuration.mnc;
            int i14 = configuration2.mnc;
            if (i13 != i14) {
                configuration3.mnc = i14;
            }
            int i15 = Build.VERSION.SDK_INT;
            if (i15 >= 24) {
                i.a(configuration, configuration2, configuration3);
            } else if (!androidx.core.util.d.a(configuration.locale, configuration2.locale)) {
                configuration3.locale = configuration2.locale;
            }
            int i16 = configuration.touchscreen;
            int i17 = configuration2.touchscreen;
            if (i16 != i17) {
                configuration3.touchscreen = i17;
            }
            int i18 = configuration.keyboard;
            int i19 = configuration2.keyboard;
            if (i18 != i19) {
                configuration3.keyboard = i19;
            }
            int i21 = configuration.keyboardHidden;
            int i22 = configuration2.keyboardHidden;
            if (i21 != i22) {
                configuration3.keyboardHidden = i22;
            }
            int i23 = configuration.navigation;
            int i24 = configuration2.navigation;
            if (i23 != i24) {
                configuration3.navigation = i24;
            }
            int i25 = configuration.navigationHidden;
            int i26 = configuration2.navigationHidden;
            if (i25 != i26) {
                configuration3.navigationHidden = i26;
            }
            int i27 = configuration.orientation;
            int i28 = configuration2.orientation;
            if (i27 != i28) {
                configuration3.orientation = i28;
            }
            int i29 = configuration.screenLayout & 15;
            int i31 = configuration2.screenLayout;
            if (i29 != (i31 & 15)) {
                configuration3.screenLayout |= i31 & 15;
            }
            int i32 = configuration.screenLayout & PsExtractor.AUDIO_STREAM;
            int i33 = configuration2.screenLayout;
            if (i32 != (i33 & PsExtractor.AUDIO_STREAM)) {
                configuration3.screenLayout |= i33 & PsExtractor.AUDIO_STREAM;
            }
            int i34 = configuration.screenLayout & 48;
            int i35 = configuration2.screenLayout;
            if (i34 != (i35 & 48)) {
                configuration3.screenLayout |= i35 & 48;
            }
            int i36 = configuration.screenLayout & 768;
            int i37 = configuration2.screenLayout;
            if (i36 != (i37 & 768)) {
                configuration3.screenLayout |= i37 & 768;
            }
            if (i15 >= 26) {
                j.a(configuration, configuration2, configuration3);
            }
            int i38 = configuration.uiMode & 15;
            int i39 = configuration2.uiMode;
            if (i38 != (i39 & 15)) {
                configuration3.uiMode |= i39 & 15;
            }
            int i40 = configuration.uiMode & 48;
            int i41 = configuration2.uiMode;
            if (i40 != (i41 & 48)) {
                configuration3.uiMode |= i41 & 48;
            }
            int i42 = configuration.screenWidthDp;
            int i43 = configuration2.screenWidthDp;
            if (i42 != i43) {
                configuration3.screenWidthDp = i43;
            }
            int i44 = configuration.screenHeightDp;
            int i45 = configuration2.screenHeightDp;
            if (i44 != i45) {
                configuration3.screenHeightDp = i45;
            }
            int i46 = configuration.smallestScreenWidthDp;
            int i47 = configuration2.smallestScreenWidthDp;
            if (i46 != i47) {
                configuration3.smallestScreenWidthDp = i47;
            }
            int i48 = configuration.densityDpi;
            int i49 = configuration2.densityDpi;
            if (i48 != i49) {
                configuration3.densityDpi = i49;
            }
        }
        return configuration3;
    }

    @Override // androidx.appcompat.app.f
    public void A(Configuration configuration) {
        androidx.appcompat.app.a aVarV;
        if (this.H && this.B && (aVarV = v()) != null) {
            aVarV.m(configuration);
        }
        androidx.appcompat.widget.f.b().g(this.f752l);
        this.T = new Configuration(this.f752l.getResources().getConfiguration());
        X(false, false);
    }

    public final boolean A0(PanelFeatureState panelFeatureState) {
        View view = panelFeatureState.f776i;
        if (view != null) {
            panelFeatureState.f775h = view;
            return true;
        }
        if (panelFeatureState.f777j == null) {
            return false;
        }
        if (this.f761u == null) {
            this.f761u = new q();
        }
        View view2 = (View) panelFeatureState.a(this.f761u);
        panelFeatureState.f775h = view2;
        return view2 != null;
    }

    @Override // androidx.appcompat.app.f
    public void B(Bundle bundle) {
        String strC;
        this.Q = true;
        W(false);
        o0();
        Object obj = this.f751k;
        if (obj instanceof Activity) {
            try {
                strC = androidx.core.app.m.c((Activity) obj);
            } catch (IllegalArgumentException unused) {
                strC = null;
            }
            if (strC != null) {
                androidx.appcompat.app.a aVarQ0 = Q0();
                if (aVarQ0 == null) {
                    this.f744d0 = true;
                } else {
                    aVarQ0.r(true);
                }
            }
            androidx.appcompat.app.f.d(this);
        }
        this.T = new Configuration(this.f752l.getResources().getConfiguration());
        this.R = true;
    }

    public final boolean B0(PanelFeatureState panelFeatureState) {
        panelFeatureState.d(r0());
        panelFeatureState.f774g = new p(panelFeatureState.f779l);
        panelFeatureState.f770c = 81;
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0045  */
    @Override // androidx.appcompat.app.f
    public void C() {
        if (this.f751k instanceof Activity) {
            androidx.appcompat.app.f.I(this);
        }
        if (this.f741a0) {
            this.f753m.getDecorView().removeCallbacks(this.f743c0);
        }
        this.S = true;
        if (this.U != -100) {
            Object obj = this.f751k;
            if ((obj instanceof Activity) && ((Activity) obj).isChangingConfigurations()) {
                f737k0.put(this.f751k.getClass().getName(), Integer.valueOf(this.U));
            } else {
                f737k0.remove(this.f751k.getClass().getName());
            }
        } else {
            f737k0.remove(this.f751k.getClass().getName());
        }
        androidx.appcompat.app.a aVar = this.f756p;
        if (aVar != null) {
            aVar.n();
        }
        e0();
    }

    public final boolean C0(PanelFeatureState panelFeatureState) {
        Resources.Theme themeNewTheme;
        Context context = this.f752l;
        int i11 = panelFeatureState.f768a;
        if ((i11 == 0 || i11 == 108) && this.f759s != null) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme = context.getTheme();
            theme.resolveAttribute(R$attr.actionBarTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                themeNewTheme = context.getResources().newTheme();
                themeNewTheme.setTo(theme);
                themeNewTheme.applyStyle(typedValue.resourceId, true);
                themeNewTheme.resolveAttribute(R$attr.actionBarWidgetTheme, typedValue, true);
            } else {
                theme.resolveAttribute(R$attr.actionBarWidgetTheme, typedValue, true);
                themeNewTheme = null;
            }
            if (typedValue.resourceId != 0) {
                if (themeNewTheme == null) {
                    themeNewTheme = context.getResources().newTheme();
                    themeNewTheme.setTo(theme);
                }
                themeNewTheme.applyStyle(typedValue.resourceId, true);
            }
            if (themeNewTheme != null) {
                g1.d dVar = new g1.d(context, 0);
                dVar.getTheme().setTo(themeNewTheme);
                context = dVar;
            }
        }
        androidx.appcompat.view.menu.f fVar = new androidx.appcompat.view.menu.f(context);
        fVar.W(this);
        panelFeatureState.c(fVar);
        return true;
    }

    @Override // androidx.appcompat.app.f
    public void D(Bundle bundle) {
        n0();
    }

    public final void D0(int i11) {
        this.f742b0 = (1 << i11) | this.f742b0;
        if (this.f741a0) {
            return;
        }
        ViewCompat.postOnAnimation(this.f753m.getDecorView(), this.f743c0);
        this.f741a0 = true;
    }

    @Override // androidx.appcompat.app.f
    public void E() {
        androidx.appcompat.app.a aVarV = v();
        if (aVarV != null) {
            aVarV.s(true);
        }
    }

    public boolean E0() {
        return this.A;
    }

    @Override // androidx.appcompat.app.f
    public void F(Bundle bundle) {
    }

    public int F0(@NonNull Context context, int i11) {
        if (i11 == -100) {
            return -1;
        }
        if (i11 != -1) {
            if (i11 == 0) {
                if (Build.VERSION.SDK_INT < 23 || ((UiModeManager) context.getApplicationContext().getSystemService("uimode")).getNightMode() != 0) {
                    return u0(context).c();
                }
                return -1;
            }
            if (i11 != 1 && i11 != 2) {
                if (i11 == 3) {
                    return t0(context).c();
                }
                throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
            }
        }
        return i11;
    }

    @Override // androidx.appcompat.app.f
    public void G() {
        X(true, false);
    }

    public boolean G0() {
        boolean z11 = this.P;
        this.P = false;
        PanelFeatureState panelFeatureStateW0 = w0(0, false);
        if (panelFeatureStateW0 != null && panelFeatureStateW0.f782o) {
            if (!z11) {
                g0(panelFeatureStateW0, true);
            }
            return true;
        }
        g1.b bVar = this.f762v;
        if (bVar != null) {
            bVar.c();
            return true;
        }
        androidx.appcompat.app.a aVarV = v();
        return aVarV != null && aVarV.g();
    }

    @Override // androidx.appcompat.app.f
    public void H() {
        androidx.appcompat.app.a aVarV = v();
        if (aVarV != null) {
            aVarV.s(false);
        }
    }

    public boolean H0(int i11, KeyEvent keyEvent) {
        if (i11 == 4) {
            this.P = (keyEvent.getFlags() & 128) != 0;
        } else if (i11 == 82) {
            I0(0, keyEvent);
            return true;
        }
        return false;
    }

    public final boolean I0(int i11, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() != 0) {
            return false;
        }
        PanelFeatureState panelFeatureStateW0 = w0(i11, true);
        if (panelFeatureStateW0.f782o) {
            return false;
        }
        return S0(panelFeatureStateW0, keyEvent);
    }

    public boolean J0(int i11, KeyEvent keyEvent) {
        androidx.appcompat.app.a aVarV = v();
        if (aVarV != null && aVarV.o(i11, keyEvent)) {
            return true;
        }
        PanelFeatureState panelFeatureState = this.O;
        if (panelFeatureState != null && R0(panelFeatureState, keyEvent.getKeyCode(), keyEvent, 1)) {
            PanelFeatureState panelFeatureState2 = this.O;
            if (panelFeatureState2 != null) {
                panelFeatureState2.f781n = true;
            }
            return true;
        }
        if (this.O == null) {
            PanelFeatureState panelFeatureStateW0 = w0(0, true);
            S0(panelFeatureStateW0, keyEvent);
            boolean zR0 = R0(panelFeatureStateW0, keyEvent.getKeyCode(), keyEvent, 1);
            panelFeatureStateW0.f780m = false;
            if (zR0) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.appcompat.app.f
    public boolean K(int i11) {
        int iU0 = U0(i11);
        if (this.L && iU0 == 108) {
            return false;
        }
        if (this.H && iU0 == 1) {
            this.H = false;
        }
        if (iU0 == 1) {
            b1();
            this.L = true;
            return true;
        }
        if (iU0 == 2) {
            b1();
            this.F = true;
            return true;
        }
        if (iU0 == 5) {
            b1();
            this.G = true;
            return true;
        }
        if (iU0 == 10) {
            b1();
            this.J = true;
            return true;
        }
        if (iU0 == 108) {
            b1();
            this.H = true;
            return true;
        }
        if (iU0 != 109) {
            return this.f753m.requestFeature(iU0);
        }
        b1();
        this.I = true;
        return true;
    }

    public boolean K0(int i11, KeyEvent keyEvent) {
        if (i11 != 4) {
            if (i11 == 82) {
                L0(0, keyEvent);
                return true;
            }
        } else if (G0()) {
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.app.f
    public void L(int i11) {
        n0();
        ViewGroup viewGroup = (ViewGroup) this.C.findViewById(R.id.content);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.f752l).inflate(i11, viewGroup);
        this.f754n.c(this.f753m.getCallback());
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0060  */
    public final boolean L0(int i11, KeyEvent keyEvent) {
        androidx.appcompat.widget.v vVar;
        if (this.f762v != null) {
            return false;
        }
        boolean zHideOverflowMenu = true;
        PanelFeatureState panelFeatureStateW0 = w0(i11, true);
        if (i11 != 0 || (vVar = this.f759s) == null || !vVar.canShowOverflowMenu() || ViewConfiguration.get(this.f752l).hasPermanentMenuKey()) {
            boolean z11 = panelFeatureStateW0.f782o;
            if (z11 || panelFeatureStateW0.f781n) {
                g0(panelFeatureStateW0, true);
                zHideOverflowMenu = z11;
            } else if (panelFeatureStateW0.f780m) {
                if (panelFeatureStateW0.f785r) {
                    panelFeatureStateW0.f780m = false;
                    if (!S0(panelFeatureStateW0, keyEvent)) {
                        zHideOverflowMenu = false;
                    }
                }
                P0(panelFeatureStateW0, keyEvent);
            } else {
                zHideOverflowMenu = false;
            }
        } else if (this.f759s.isOverflowMenuShowing()) {
            zHideOverflowMenu = this.f759s.hideOverflowMenu();
        } else if (this.S || !S0(panelFeatureStateW0, keyEvent)) {
            zHideOverflowMenu = false;
        } else {
            zHideOverflowMenu = this.f759s.showOverflowMenu();
        }
        if (zHideOverflowMenu) {
            AudioManager audioManager = (AudioManager) this.f752l.getApplicationContext().getSystemService(MimeTypes.BASE_TYPE_AUDIO);
            if (audioManager != null) {
                audioManager.playSoundEffect(0);
            } else {
                Log.w("AppCompatDelegate", "Couldn't get audio manager");
            }
        }
        return zHideOverflowMenu;
    }

    @Override // androidx.appcompat.app.f
    public void M(View view) {
        n0();
        ViewGroup viewGroup = (ViewGroup) this.C.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.f754n.c(this.f753m.getCallback());
    }

    public void M0(int i11) {
        androidx.appcompat.app.a aVarV;
        if (i11 != 108 || (aVarV = v()) == null) {
            return;
        }
        aVarV.h(true);
    }

    @Override // androidx.appcompat.app.f
    public void N(View view, ViewGroup.LayoutParams layoutParams) {
        n0();
        ViewGroup viewGroup = (ViewGroup) this.C.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.f754n.c(this.f753m.getCallback());
    }

    public void N0(int i11) {
        if (i11 == 108) {
            androidx.appcompat.app.a aVarV = v();
            if (aVarV != null) {
                aVarV.h(false);
                return;
            }
            return;
        }
        if (i11 == 0) {
            PanelFeatureState panelFeatureStateW0 = w0(i11, true);
            if (panelFeatureStateW0.f782o) {
                g0(panelFeatureStateW0, false);
            }
        }
    }

    public void O0(ViewGroup viewGroup) {
    }

    /* JADX WARN: Code duplicated, block: B:13:0x002c  */
    @Override // androidx.appcompat.app.f
    @RequiresApi(33)
    public void P(@Nullable OnBackInvokedDispatcher onBackInvokedDispatcher) {
        OnBackInvokedCallback onBackInvokedCallback;
        super.P(onBackInvokedDispatcher);
        OnBackInvokedDispatcher onBackInvokedDispatcher2 = this.f749i0;
        if (onBackInvokedDispatcher2 != null && (onBackInvokedCallback = this.f750j0) != null) {
            k.c(onBackInvokedDispatcher2, onBackInvokedCallback);
            this.f750j0 = null;
        }
        if (onBackInvokedDispatcher == null) {
            Object obj = this.f751k;
            if (!(obj instanceof Activity) || ((Activity) obj).getWindow() == null) {
                this.f749i0 = onBackInvokedDispatcher;
            } else {
                this.f749i0 = k.a((Activity) this.f751k);
            }
        } else {
            this.f749i0 = onBackInvokedDispatcher;
        }
        f1();
    }

    /* JADX WARN: Code duplicated, block: B:64:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:69:? A[RETURN, SYNTHETIC] */
    public final void P0(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        int i11;
        ViewGroup.LayoutParams layoutParams;
        if (panelFeatureState.f782o || this.S) {
            return;
        }
        if (panelFeatureState.f768a == 0 && (this.f752l.getResources().getConfiguration().screenLayout & 15) == 4) {
            return;
        }
        Window.Callback callbackY0 = y0();
        if (callbackY0 != null && !callbackY0.onMenuOpened(panelFeatureState.f768a, panelFeatureState.f777j)) {
            g0(panelFeatureState, true);
            return;
        }
        WindowManager windowManager = (WindowManager) this.f752l.getSystemService("window");
        if (windowManager != null && S0(panelFeatureState, keyEvent)) {
            ViewGroup viewGroup = panelFeatureState.f774g;
            if (viewGroup != null && !panelFeatureState.f784q) {
                View view = panelFeatureState.f776i;
                if (view != null && (layoutParams = view.getLayoutParams()) != null && layoutParams.width == -1) {
                    i11 = -1;
                }
                panelFeatureState.f781n = false;
                WindowManager.LayoutParams layoutParams2 = new WindowManager.LayoutParams(i11, -2, panelFeatureState.f771d, panelFeatureState.f772e, 1002, 8519680, -3);
                layoutParams2.gravity = panelFeatureState.f770c;
                layoutParams2.windowAnimations = panelFeatureState.f773f;
                windowManager.addView(panelFeatureState.f774g, layoutParams2);
                panelFeatureState.f782o = true;
                if (panelFeatureState.f768a == 0) {
                    f1();
                }
            }
            if (viewGroup == null) {
                if (!B0(panelFeatureState) || panelFeatureState.f774g == null) {
                    return;
                }
            } else if (panelFeatureState.f784q && viewGroup.getChildCount() > 0) {
                panelFeatureState.f774g.removeAllViews();
            }
            if (!A0(panelFeatureState) || !panelFeatureState.b()) {
                panelFeatureState.f784q = true;
                return;
            }
            ViewGroup.LayoutParams layoutParams3 = panelFeatureState.f775h.getLayoutParams();
            if (layoutParams3 == null) {
                layoutParams3 = new ViewGroup.LayoutParams(-2, -2);
            }
            panelFeatureState.f774g.setBackgroundResource(panelFeatureState.f769b);
            ViewParent parent = panelFeatureState.f775h.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(panelFeatureState.f775h);
            }
            panelFeatureState.f774g.addView(panelFeatureState.f775h, layoutParams3);
            if (!panelFeatureState.f775h.hasFocus()) {
                panelFeatureState.f775h.requestFocus();
            }
            i11 = -2;
            panelFeatureState.f781n = false;
            WindowManager.LayoutParams layoutParams4 = new WindowManager.LayoutParams(i11, -2, panelFeatureState.f771d, panelFeatureState.f772e, 1002, 8519680, -3);
            layoutParams4.gravity = panelFeatureState.f770c;
            layoutParams4.windowAnimations = panelFeatureState.f773f;
            windowManager.addView(panelFeatureState.f774g, layoutParams4);
            panelFeatureState.f782o = true;
            if (panelFeatureState.f768a == 0) {
                f1();
            }
        }
    }

    @Override // androidx.appcompat.app.f
    public void Q(Toolbar toolbar) {
        if (this.f751k instanceof Activity) {
            androidx.appcompat.app.a aVarV = v();
            if (aVarV instanceof d0) {
                throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
            }
            this.f757q = null;
            if (aVarV != null) {
                aVarV.n();
            }
            this.f756p = null;
            if (toolbar != null) {
                ToolbarActionBar toolbarActionBar = new ToolbarActionBar(toolbar, x0(), this.f754n);
                this.f756p = toolbarActionBar;
                this.f754n.e(toolbarActionBar.f814c);
                toolbar.setBackInvokedCallbackEnabled(true);
            } else {
                this.f754n.e(null);
            }
            x();
        }
    }

    public final androidx.appcompat.app.a Q0() {
        return this.f756p;
    }

    @Override // androidx.appcompat.app.f
    public void R(int i11) {
        this.V = i11;
    }

    public final boolean R0(PanelFeatureState panelFeatureState, int i11, KeyEvent keyEvent, int i12) {
        androidx.appcompat.view.menu.f fVar;
        boolean zPerformShortcut = false;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((panelFeatureState.f780m || S0(panelFeatureState, keyEvent)) && (fVar = panelFeatureState.f777j) != null) {
            zPerformShortcut = fVar.performShortcut(i11, keyEvent, i12);
        }
        if (zPerformShortcut && (i12 & 1) == 0 && this.f759s == null) {
            g0(panelFeatureState, true);
        }
        return zPerformShortcut;
    }

    @Override // androidx.appcompat.app.f
    public final void S(CharSequence charSequence) {
        this.f758r = charSequence;
        androidx.appcompat.widget.v vVar = this.f759s;
        if (vVar != null) {
            vVar.setWindowTitle(charSequence);
            return;
        }
        if (Q0() != null) {
            Q0().t(charSequence);
            return;
        }
        TextView textView = this.D;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public final boolean S0(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        androidx.appcompat.widget.v vVar;
        androidx.appcompat.widget.v vVar2;
        androidx.appcompat.widget.v vVar3;
        if (this.S) {
            return false;
        }
        if (panelFeatureState.f780m) {
            return true;
        }
        PanelFeatureState panelFeatureState2 = this.O;
        if (panelFeatureState2 != null && panelFeatureState2 != panelFeatureState) {
            g0(panelFeatureState2, false);
        }
        Window.Callback callbackY0 = y0();
        if (callbackY0 != null) {
            panelFeatureState.f776i = callbackY0.onCreatePanelView(panelFeatureState.f768a);
        }
        int i11 = panelFeatureState.f768a;
        boolean z11 = i11 == 0 || i11 == 108;
        if (z11 && (vVar3 = this.f759s) != null) {
            vVar3.setMenuPrepared();
        }
        if (panelFeatureState.f776i == null && (!z11 || !(Q0() instanceof ToolbarActionBar))) {
            androidx.appcompat.view.menu.f fVar = panelFeatureState.f777j;
            if (fVar == null || panelFeatureState.f785r) {
                if (fVar == null && (!C0(panelFeatureState) || panelFeatureState.f777j == null)) {
                    return false;
                }
                if (z11 && this.f759s != null) {
                    if (this.f760t == null) {
                        this.f760t = new f();
                    }
                    this.f759s.setMenu(panelFeatureState.f777j, this.f760t);
                }
                panelFeatureState.f777j.i0();
                if (!callbackY0.onCreatePanelMenu(panelFeatureState.f768a, panelFeatureState.f777j)) {
                    panelFeatureState.c(null);
                    if (z11 && (vVar = this.f759s) != null) {
                        vVar.setMenu(null, this.f760t);
                    }
                    return false;
                }
                panelFeatureState.f785r = false;
            }
            panelFeatureState.f777j.i0();
            Bundle bundle = panelFeatureState.f786s;
            if (bundle != null) {
                panelFeatureState.f777j.S(bundle);
                panelFeatureState.f786s = null;
            }
            if (!callbackY0.onPreparePanel(0, panelFeatureState.f776i, panelFeatureState.f777j)) {
                if (z11 && (vVar2 = this.f759s) != null) {
                    vVar2.setMenu(null, this.f760t);
                }
                panelFeatureState.f777j.h0();
                return false;
            }
            boolean z12 = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
            panelFeatureState.f783p = z12;
            panelFeatureState.f777j.setQwertyMode(z12);
            panelFeatureState.f777j.h0();
        }
        panelFeatureState.f780m = true;
        panelFeatureState.f781n = false;
        this.O = panelFeatureState;
        return true;
    }

    @Override // androidx.appcompat.app.f
    public g1.b T(@NonNull g1.b.a aVar) {
        androidx.appcompat.app.d dVar;
        if (aVar == null) {
            throw new IllegalArgumentException("ActionMode callback can not be null.");
        }
        g1.b bVar = this.f762v;
        if (bVar != null) {
            bVar.c();
        }
        g gVar = new g(aVar);
        androidx.appcompat.app.a aVarV = v();
        if (aVarV != null) {
            g1.b bVarU = aVarV.u(gVar);
            this.f762v = bVarU;
            if (bVarU != null && (dVar = this.f755o) != null) {
                dVar.onSupportActionModeStarted(bVarU);
            }
        }
        if (this.f762v == null) {
            this.f762v = a1(gVar);
        }
        f1();
        return this.f762v;
    }

    public final void T0(boolean z11) {
        androidx.appcompat.widget.v vVar = this.f759s;
        if (vVar == null || !vVar.canShowOverflowMenu() || (ViewConfiguration.get(this.f752l).hasPermanentMenuKey() && !this.f759s.isOverflowMenuShowPending())) {
            PanelFeatureState panelFeatureStateW0 = w0(0, true);
            panelFeatureStateW0.f784q = true;
            g0(panelFeatureStateW0, false);
            P0(panelFeatureStateW0, null);
            return;
        }
        Window.Callback callbackY0 = y0();
        if (this.f759s.isOverflowMenuShowing() && z11) {
            this.f759s.hideOverflowMenu();
            if (this.S) {
                return;
            }
            callbackY0.onPanelClosed(108, w0(0, true).f777j);
            return;
        }
        if (callbackY0 == null || this.S) {
            return;
        }
        if (this.f741a0 && (this.f742b0 & 1) != 0) {
            this.f753m.getDecorView().removeCallbacks(this.f743c0);
            this.f743c0.run();
        }
        PanelFeatureState panelFeatureStateW1 = w0(0, true);
        androidx.appcompat.view.menu.f fVar = panelFeatureStateW1.f777j;
        if (fVar == null || panelFeatureStateW1.f785r || !callbackY0.onPreparePanel(0, panelFeatureStateW1.f776i, fVar)) {
            return;
        }
        callbackY0.onMenuOpened(108, panelFeatureStateW1.f777j);
        this.f759s.showOverflowMenu();
    }

    public final int U0(int i11) {
        if (i11 == 8) {
            return 108;
        }
        if (i11 == 9) {
            return 109;
        }
        return i11;
    }

    public void V0(Configuration configuration, @NonNull androidx.core.os.h hVar) {
        if (Build.VERSION.SDK_INT >= 24) {
            i.d(configuration, hVar);
        } else {
            configuration.setLocale(hVar.d(0));
            configuration.setLayoutDirection(hVar.d(0));
        }
    }

    public final boolean W(boolean z11) {
        return X(z11, true);
    }

    public void W0(androidx.core.os.h hVar) {
        if (Build.VERSION.SDK_INT >= 24) {
            i.c(hVar);
        } else {
            Locale.setDefault(hVar.d(0));
        }
    }

    public final boolean X(boolean z11, boolean z12) {
        if (this.S) {
            return false;
        }
        int iB0 = b0();
        int iF0 = F0(this.f752l, iB0);
        androidx.core.os.h hVarA0 = Build.VERSION.SDK_INT < 33 ? a0(this.f752l) : null;
        if (!z12 && hVarA0 != null) {
            hVarA0 = v0(this.f752l.getResources().getConfiguration());
        }
        boolean zE1 = e1(iF0, hVarA0, z11);
        if (iB0 == 0) {
            u0(this.f752l).e();
        } else {
            n nVar = this.Y;
            if (nVar != null) {
                nVar.a();
            }
        }
        if (iB0 == 3) {
            t0(this.f752l).e();
        } else {
            n nVar2 = this.Z;
            if (nVar2 != null) {
                nVar2.a();
            }
        }
        return zE1;
    }

    public final boolean X0() {
        ViewGroup viewGroup;
        return this.B && (viewGroup = this.C) != null && viewGroup.isLaidOut();
    }

    public final void Y() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.C.findViewById(R.id.content);
        View decorView = this.f753m.getDecorView();
        contentFrameLayout.setDecorPadding(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray typedArrayObtainStyledAttributes = this.f752l.obtainStyledAttributes(R$styleable.AppCompatTheme);
        typedArrayObtainStyledAttributes.getValue(R$styleable.AppCompatTheme_windowMinWidthMajor, contentFrameLayout.getMinWidthMajor());
        typedArrayObtainStyledAttributes.getValue(R$styleable.AppCompatTheme_windowMinWidthMinor, contentFrameLayout.getMinWidthMinor());
        if (typedArrayObtainStyledAttributes.hasValue(R$styleable.AppCompatTheme_windowFixedWidthMajor)) {
            typedArrayObtainStyledAttributes.getValue(R$styleable.AppCompatTheme_windowFixedWidthMajor, contentFrameLayout.getFixedWidthMajor());
        }
        if (typedArrayObtainStyledAttributes.hasValue(R$styleable.AppCompatTheme_windowFixedWidthMinor)) {
            typedArrayObtainStyledAttributes.getValue(R$styleable.AppCompatTheme_windowFixedWidthMinor, contentFrameLayout.getFixedWidthMinor());
        }
        if (typedArrayObtainStyledAttributes.hasValue(R$styleable.AppCompatTheme_windowFixedHeightMajor)) {
            typedArrayObtainStyledAttributes.getValue(R$styleable.AppCompatTheme_windowFixedHeightMajor, contentFrameLayout.getFixedHeightMajor());
        }
        if (typedArrayObtainStyledAttributes.hasValue(R$styleable.AppCompatTheme_windowFixedHeightMinor)) {
            typedArrayObtainStyledAttributes.getValue(R$styleable.AppCompatTheme_windowFixedHeightMinor, contentFrameLayout.getFixedHeightMinor());
        }
        typedArrayObtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    public final boolean Y0(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        View decorView = this.f753m.getDecorView();
        while (viewParent != null) {
            if (viewParent == decorView || !(viewParent instanceof View) || ((View) viewParent).isAttachedToWindow()) {
                return false;
            }
            viewParent = viewParent.getParent();
        }
        return true;
    }

    public final void Z(@NonNull Window window) {
        if (this.f753m != null) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        Window.Callback callback = window.getCallback();
        if (callback instanceof l) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        l lVar = new l(callback);
        this.f754n = lVar;
        window.setCallback(lVar);
        n0 n0VarU = n0.u(this.f752l, null, f739m0);
        Drawable drawableH = n0VarU.h(0);
        if (drawableH != null) {
            window.setBackgroundDrawable(drawableH);
        }
        n0VarU.x();
        this.f753m = window;
        if (Build.VERSION.SDK_INT < 33 || this.f749i0 != null) {
            return;
        }
        P(null);
    }

    public boolean Z0() {
        if (this.f749i0 == null) {
            return false;
        }
        PanelFeatureState panelFeatureStateW0 = w0(0, false);
        return (panelFeatureStateW0 != null && panelFeatureStateW0.f782o) || this.f762v != null;
    }

    @Override // androidx.appcompat.view.menu.f.a
    public boolean a(@NonNull androidx.appcompat.view.menu.f fVar, @NonNull MenuItem menuItem) {
        PanelFeatureState panelFeatureStateP0;
        Window.Callback callbackY0 = y0();
        if (callbackY0 == null || this.S || (panelFeatureStateP0 = p0(fVar.F())) == null) {
            return false;
        }
        return callbackY0.onMenuItemSelected(panelFeatureStateP0.f768a, menuItem);
    }

    @Nullable
    public androidx.core.os.h a0(@NonNull Context context) {
        androidx.core.os.h hVarU;
        androidx.core.os.h hVarE;
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 33 || (hVarU = androidx.appcompat.app.f.u()) == null) {
            return null;
        }
        androidx.core.os.h hVarV0 = v0(context.getApplicationContext().getResources().getConfiguration());
        if (i11 >= 24) {
            hVarE = z.b(hVarU, hVarV0);
        } else {
            hVarE = hVarU.f() ? androidx.core.os.h.e() : androidx.core.os.h.c(h.b(hVarU.d(0)));
        }
        return hVarE.f() ? hVarV0 : hVarE;
    }

    public g1.b a1(@NonNull g1.b.a aVar) {
        g1.b bVarOnWindowStartingSupportActionMode;
        Context dVar;
        androidx.appcompat.app.d dVar2;
        m0();
        g1.b bVar = this.f762v;
        if (bVar != null) {
            bVar.c();
        }
        if (!(aVar instanceof g)) {
            aVar = new g(aVar);
        }
        androidx.appcompat.app.d dVar3 = this.f755o;
        if (dVar3 == null || this.S) {
            bVarOnWindowStartingSupportActionMode = null;
        } else {
            try {
                bVarOnWindowStartingSupportActionMode = dVar3.onWindowStartingSupportActionMode(aVar);
            } catch (AbstractMethodError unused) {
                bVarOnWindowStartingSupportActionMode = null;
            }
        }
        if (bVarOnWindowStartingSupportActionMode != null) {
            this.f762v = bVarOnWindowStartingSupportActionMode;
        } else {
            if (this.f763w == null) {
                if (this.K) {
                    TypedValue typedValue = new TypedValue();
                    Resources.Theme theme = this.f752l.getTheme();
                    theme.resolveAttribute(R$attr.actionBarTheme, typedValue, true);
                    if (typedValue.resourceId != 0) {
                        Resources.Theme themeNewTheme = this.f752l.getResources().newTheme();
                        themeNewTheme.setTo(theme);
                        themeNewTheme.applyStyle(typedValue.resourceId, true);
                        dVar = new g1.d(this.f752l, 0);
                        dVar.getTheme().setTo(themeNewTheme);
                    } else {
                        dVar = this.f752l;
                    }
                    this.f763w = new ActionBarContextView(dVar);
                    PopupWindow popupWindow = new PopupWindow(dVar, (AttributeSet) null, R$attr.actionModePopupWindowStyle);
                    this.f764x = popupWindow;
                    androidx.core.widget.k.b(popupWindow, 2);
                    this.f764x.setContentView(this.f763w);
                    this.f764x.setWidth(-1);
                    dVar.getTheme().resolveAttribute(R$attr.actionBarSize, typedValue, true);
                    this.f763w.setContentHeight(TypedValue.complexToDimensionPixelSize(typedValue.data, dVar.getResources().getDisplayMetrics()));
                    this.f764x.setHeight(-2);
                    this.f765y = new Runnable() { // from class: androidx.appcompat.app.AppCompatDelegateImpl.6

                        /* JADX INFO: renamed from: androidx.appcompat.app.AppCompatDelegateImpl$6$a */
                        /* JADX INFO: compiled from: source.java */
                        public class a extends ViewPropertyAnimatorListenerAdapter {
                            public a() {
                            }

                            @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
                            public void onAnimationEnd(View view) {
                                AppCompatDelegateImpl.this.f763w.setAlpha(1.0f);
                                AppCompatDelegateImpl.this.f766z.setListener(null);
                                AppCompatDelegateImpl.this.f766z = null;
                            }

                            @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
                            public void onAnimationStart(View view) {
                                AppCompatDelegateImpl.this.f763w.setVisibility(0);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
                            appCompatDelegateImpl.f764x.showAtLocation(appCompatDelegateImpl.f763w, 55, 0, 0);
                            AppCompatDelegateImpl.this.m0();
                            if (!AppCompatDelegateImpl.this.X0()) {
                                AppCompatDelegateImpl.this.f763w.setAlpha(1.0f);
                                AppCompatDelegateImpl.this.f763w.setVisibility(0);
                            } else {
                                AppCompatDelegateImpl.this.f763w.setAlpha(0.0f);
                                AppCompatDelegateImpl appCompatDelegateImpl2 = AppCompatDelegateImpl.this;
                                appCompatDelegateImpl2.f766z = ViewCompat.animate(appCompatDelegateImpl2.f763w).alpha(1.0f);
                                AppCompatDelegateImpl.this.f766z.setListener(new a());
                            }
                        }
                    };
                } else {
                    ViewStubCompat viewStubCompat = (ViewStubCompat) this.C.findViewById(R$id.action_mode_bar_stub);
                    if (viewStubCompat != null) {
                        viewStubCompat.setLayoutInflater(LayoutInflater.from(r0()));
                        this.f763w = (ActionBarContextView) viewStubCompat.inflate();
                    }
                }
            }
            if (this.f763w != null) {
                m0();
                this.f763w.killMode();
                g1.e eVar = new g1.e(this.f763w.getContext(), this.f763w, aVar, this.f764x == null);
                if (aVar.c(eVar, eVar.e())) {
                    eVar.k();
                    this.f763w.initForMode(eVar);
                    this.f762v = eVar;
                    if (X0()) {
                        this.f763w.setAlpha(0.0f);
                        ViewPropertyAnimatorCompat viewPropertyAnimatorCompatAlpha = ViewCompat.animate(this.f763w).alpha(1.0f);
                        this.f766z = viewPropertyAnimatorCompatAlpha;
                        viewPropertyAnimatorCompatAlpha.setListener(new c());
                    } else {
                        this.f763w.setAlpha(1.0f);
                        this.f763w.setVisibility(0);
                        if (this.f763w.getParent() instanceof View) {
                            ViewCompat.requestApplyInsets((View) this.f763w.getParent());
                        }
                    }
                    if (this.f764x != null) {
                        this.f753m.getDecorView().post(this.f765y);
                    }
                } else {
                    this.f762v = null;
                }
            }
        }
        g1.b bVar2 = this.f762v;
        if (bVar2 != null && (dVar2 = this.f755o) != null) {
            dVar2.onSupportActionModeStarted(bVar2);
        }
        f1();
        return this.f762v;
    }

    @Override // androidx.appcompat.view.menu.f.a
    public void b(@NonNull androidx.appcompat.view.menu.f fVar) {
        T0(true);
    }

    public final int b0() {
        int i11 = this.U;
        return i11 != -100 ? i11 : androidx.appcompat.app.f.p();
    }

    public final void b1() {
        if (this.B) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    public void c0(int i11, PanelFeatureState panelFeatureState, Menu menu) {
        if (menu == null) {
            if (panelFeatureState == null && i11 >= 0) {
                PanelFeatureState[] panelFeatureStateArr = this.N;
                if (i11 < panelFeatureStateArr.length) {
                    panelFeatureState = panelFeatureStateArr[i11];
                }
            }
            if (panelFeatureState != null) {
                menu = panelFeatureState.f777j;
            }
        }
        if ((panelFeatureState == null || panelFeatureState.f782o) && !this.S) {
            this.f754n.d(this.f753m.getCallback(), i11, menu);
        }
    }

    @Nullable
    public final AppCompatActivity c1() {
        for (Context baseContext = this.f752l; baseContext != null; baseContext = ((ContextWrapper) baseContext).getBaseContext()) {
            if (baseContext instanceof AppCompatActivity) {
                return (AppCompatActivity) baseContext;
            }
            if (!(baseContext instanceof ContextWrapper)) {
                break;
            }
        }
        return null;
    }

    public void d0(@NonNull androidx.appcompat.view.menu.f fVar) {
        if (this.M) {
            return;
        }
        this.M = true;
        this.f759s.dismissPopups();
        Window.Callback callbackY0 = y0();
        if (callbackY0 != null && !this.S) {
            callbackY0.onPanelClosed(108, fVar);
        }
        this.M = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void d1(Configuration configuration) {
        Activity activity = (Activity) this.f751k;
        if (activity instanceof androidx.lifecycle.u) {
            if (((androidx.lifecycle.u) activity).getLifecycle().b().isAtLeast(Lifecycle.State.CREATED)) {
                activity.onConfigurationChanged(configuration);
            }
        } else {
            if (!this.R || this.S) {
                return;
            }
            activity.onConfigurationChanged(configuration);
        }
    }

    @Override // androidx.appcompat.app.f
    public void e(View view, ViewGroup.LayoutParams layoutParams) {
        n0();
        ((ViewGroup) this.C.findViewById(R.id.content)).addView(view, layoutParams);
        this.f754n.c(this.f753m.getCallback());
    }

    public final void e0() {
        n nVar = this.Y;
        if (nVar != null) {
            nVar.a();
        }
        n nVar2 = this.Z;
        if (nVar2 != null) {
            nVar2.a();
        }
    }

    /* JADX WARN: Code duplicated, block: B:36:0x008c  */
    public final boolean e1(int i11, @Nullable androidx.core.os.h hVar, boolean z11) {
        boolean z12;
        Configuration configurationH0 = h0(this.f752l, i11, hVar, null, false);
        int iS0 = s0(this.f752l);
        Configuration configuration = this.T;
        if (configuration == null) {
            configuration = this.f752l.getResources().getConfiguration();
        }
        int i12 = configuration.uiMode & 48;
        int i13 = configurationH0.uiMode & 48;
        androidx.core.os.h hVarV0 = v0(configuration);
        androidx.core.os.h hVarV1 = hVar == null ? null : v0(configurationH0);
        int i14 = i12 != i13 ? 512 : 0;
        if (hVarV1 != null && !hVarV0.equals(hVarV1)) {
            i14 |= 8196;
        }
        boolean z13 = true;
        if (((~iS0) & i14) != 0 && z11 && this.Q && (f740n0 || this.R)) {
            Object obj = this.f751k;
            if (!(obj instanceof Activity) || ((Activity) obj).isChild()) {
                z12 = false;
            } else {
                if (Build.VERSION.SDK_INT >= 31 && (i14 & 8192) != 0) {
                    ((Activity) this.f751k).getWindow().getDecorView().setLayoutDirection(configurationH0.getLayoutDirection());
                }
                ActivityCompat.f((Activity) this.f751k);
                z12 = true;
            }
        } else {
            z12 = false;
        }
        if (z12 || i14 == 0) {
            z13 = z12;
        } else {
            g1(i13, hVarV1, (i14 & iS0) == i14, null);
        }
        if (z13) {
            Object obj2 = this.f751k;
            if (obj2 instanceof AppCompatActivity) {
                if ((i14 & 512) != 0) {
                    ((AppCompatActivity) obj2).onNightModeChanged(i11);
                }
                if ((i14 & 4) != 0) {
                    ((AppCompatActivity) this.f751k).onLocalesChanged(hVar);
                }
            }
        }
        if (hVarV1 != null) {
            W0(v0(this.f752l.getResources().getConfiguration()));
        }
        return z13;
    }

    @Override // androidx.appcompat.app.f
    public boolean f() {
        return W(true);
    }

    public void f0(int i11) {
        g0(w0(i11, true), true);
    }

    public void f1() {
        OnBackInvokedCallback onBackInvokedCallback;
        if (Build.VERSION.SDK_INT >= 33) {
            boolean zZ0 = Z0();
            if (zZ0 && this.f750j0 == null) {
                this.f750j0 = k.b(this.f749i0, this);
            } else {
                if (zZ0 || (onBackInvokedCallback = this.f750j0) == null) {
                    return;
                }
                k.c(this.f749i0, onBackInvokedCallback);
                this.f750j0 = null;
            }
        }
    }

    public void g0(PanelFeatureState panelFeatureState, boolean z11) {
        ViewGroup viewGroup;
        androidx.appcompat.widget.v vVar;
        if (z11 && panelFeatureState.f768a == 0 && (vVar = this.f759s) != null && vVar.isOverflowMenuShowing()) {
            d0(panelFeatureState.f777j);
            return;
        }
        WindowManager windowManager = (WindowManager) this.f752l.getSystemService("window");
        if (windowManager != null && panelFeatureState.f782o && (viewGroup = panelFeatureState.f774g) != null) {
            windowManager.removeView(viewGroup);
            if (z11) {
                c0(panelFeatureState.f768a, panelFeatureState, null);
            }
        }
        panelFeatureState.f780m = false;
        panelFeatureState.f781n = false;
        panelFeatureState.f782o = false;
        panelFeatureState.f775h = null;
        panelFeatureState.f784q = true;
        if (this.O == panelFeatureState) {
            this.O = null;
        }
        if (panelFeatureState.f768a == 0) {
            f1();
        }
    }

    public final void g1(int i11, @Nullable androidx.core.os.h hVar, boolean z11, @Nullable Configuration configuration) {
        Resources resources = this.f752l.getResources();
        Configuration configuration2 = new Configuration(resources.getConfiguration());
        if (configuration != null) {
            configuration2.updateFrom(configuration);
        }
        configuration2.uiMode = i11 | (resources.getConfiguration().uiMode & (-49));
        if (hVar != null) {
            V0(configuration2, hVar);
        }
        resources.updateConfiguration(configuration2, null);
        int i12 = Build.VERSION.SDK_INT;
        if (i12 < 26) {
            a0.a(resources);
        }
        int i13 = this.V;
        if (i13 != 0) {
            this.f752l.setTheme(i13);
            if (i12 >= 23) {
                this.f752l.getTheme().applyStyle(this.V, true);
            }
        }
        if (z11 && (this.f751k instanceof Activity)) {
            d1(configuration2);
        }
    }

    @NonNull
    public final Configuration h0(@NonNull Context context, int i11, @Nullable androidx.core.os.h hVar, @Nullable Configuration configuration, boolean z11) {
        int i12;
        if (i11 == 1) {
            i12 = 16;
        } else if (i11 != 2) {
            i12 = z11 ? 0 : context.getApplicationContext().getResources().getConfiguration().uiMode & 48;
        } else {
            i12 = 32;
        }
        Configuration configuration2 = new Configuration();
        configuration2.fontScale = 0.0f;
        if (configuration != null) {
            configuration2.setTo(configuration);
        }
        configuration2.uiMode = i12 | (configuration2.uiMode & (-49));
        if (hVar != null) {
            V0(configuration2, hVar);
        }
        return configuration2;
    }

    public final int h1(@Nullable WindowInsetsCompat windowInsetsCompat, @Nullable Rect rect) {
        int systemWindowInsetTop;
        boolean z11;
        boolean z12;
        if (windowInsetsCompat != null) {
            systemWindowInsetTop = windowInsetsCompat.getSystemWindowInsetTop();
        } else {
            systemWindowInsetTop = rect != null ? rect.top : 0;
        }
        ActionBarContextView actionBarContextView = this.f763w;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z11 = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f763w.getLayoutParams();
            boolean z13 = true;
            if (this.f763w.isShown()) {
                if (this.f745e0 == null) {
                    this.f745e0 = new Rect();
                    this.f746f0 = new Rect();
                }
                Rect rect2 = this.f745e0;
                Rect rect3 = this.f746f0;
                if (windowInsetsCompat == null) {
                    rect2.set(rect);
                } else {
                    rect2.set(windowInsetsCompat.getSystemWindowInsetLeft(), windowInsetsCompat.getSystemWindowInsetTop(), windowInsetsCompat.getSystemWindowInsetRight(), windowInsetsCompat.getSystemWindowInsetBottom());
                }
                y0.a(this.C, rect2, rect3);
                int i11 = rect2.top;
                int i12 = rect2.left;
                int i13 = rect2.right;
                WindowInsetsCompat rootWindowInsets = ViewCompat.getRootWindowInsets(this.C);
                int systemWindowInsetLeft = rootWindowInsets == null ? 0 : rootWindowInsets.getSystemWindowInsetLeft();
                int systemWindowInsetRight = rootWindowInsets == null ? 0 : rootWindowInsets.getSystemWindowInsetRight();
                if (marginLayoutParams.topMargin == i11 && marginLayoutParams.leftMargin == i12 && marginLayoutParams.rightMargin == i13) {
                    z12 = false;
                } else {
                    marginLayoutParams.topMargin = i11;
                    marginLayoutParams.leftMargin = i12;
                    marginLayoutParams.rightMargin = i13;
                    z12 = true;
                }
                if (i11 <= 0 || this.E != null) {
                    View view = this.E;
                    if (view != null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                        int i14 = marginLayoutParams2.height;
                        int i15 = marginLayoutParams.topMargin;
                        if (i14 != i15 || marginLayoutParams2.leftMargin != systemWindowInsetLeft || marginLayoutParams2.rightMargin != systemWindowInsetRight) {
                            marginLayoutParams2.height = i15;
                            marginLayoutParams2.leftMargin = systemWindowInsetLeft;
                            marginLayoutParams2.rightMargin = systemWindowInsetRight;
                            this.E.setLayoutParams(marginLayoutParams2);
                        }
                    }
                } else {
                    View view2 = new View(this.f752l);
                    this.E = view2;
                    view2.setVisibility(8);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, marginLayoutParams.topMargin, 51);
                    layoutParams.leftMargin = systemWindowInsetLeft;
                    layoutParams.rightMargin = systemWindowInsetRight;
                    this.C.addView(this.E, -1, layoutParams);
                }
                View view3 = this.E;
                z13 = view3 != null;
                if (z13 && view3.getVisibility() != 0) {
                    i1(this.E);
                }
                if (!this.J && z13) {
                    systemWindowInsetTop = 0;
                }
                z11 = z13;
                z13 = z12;
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                z11 = false;
            } else {
                z11 = false;
                z13 = false;
            }
            if (z13) {
                this.f763w.setLayoutParams(marginLayoutParams);
            }
        }
        View view4 = this.E;
        if (view4 != null) {
            view4.setVisibility(z11 ? 0 : 8);
        }
        return systemWindowInsetTop;
    }

    @Override // androidx.appcompat.app.f
    @NonNull
    @CallSuper
    public Context i(@NonNull Context context) {
        this.Q = true;
        int iF0 = F0(context, b0());
        if (androidx.appcompat.app.f.y(context)) {
            androidx.appcompat.app.f.V(context);
        }
        androidx.core.os.h hVarA0 = a0(context);
        if (context instanceof ContextThemeWrapper) {
            try {
                ((ContextThemeWrapper) context).applyOverrideConfiguration(h0(context, iF0, hVarA0, null, false));
                return context;
            } catch (IllegalStateException unused) {
            }
        }
        if (context instanceof g1.d) {
            try {
                ((g1.d) context).a(h0(context, iF0, hVarA0, null, false));
                return context;
            } catch (IllegalStateException unused2) {
            }
        }
        if (!f740n0) {
            return super.i(context);
        }
        Configuration configuration = new Configuration();
        configuration.uiMode = -1;
        configuration.fontScale = 0.0f;
        Configuration configuration2 = context.createConfigurationContext(configuration).getResources().getConfiguration();
        Configuration configuration3 = context.getResources().getConfiguration();
        configuration2.uiMode = configuration3.uiMode;
        Configuration configurationH0 = h0(context, iF0, hVarA0, !configuration2.equals(configuration3) ? q0(configuration2, configuration3) : null, true);
        g1.d dVar = new g1.d(context, R$style.Theme_AppCompat_Empty);
        dVar.a(configurationH0);
        try {
            if (context.getTheme() != null) {
                b3.h.f.a(dVar.getTheme());
            }
        } catch (NullPointerException unused3) {
        }
        return super.i(dVar);
    }

    public final ViewGroup i0() {
        ViewGroup viewGroup;
        TypedArray typedArrayObtainStyledAttributes = this.f752l.obtainStyledAttributes(R$styleable.AppCompatTheme);
        if (!typedArrayObtainStyledAttributes.hasValue(R$styleable.AppCompatTheme_windowActionBar)) {
            typedArrayObtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
        if (typedArrayObtainStyledAttributes.getBoolean(R$styleable.AppCompatTheme_windowNoTitle, false)) {
            K(1);
        } else if (typedArrayObtainStyledAttributes.getBoolean(R$styleable.AppCompatTheme_windowActionBar, false)) {
            K(108);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(R$styleable.AppCompatTheme_windowActionBarOverlay, false)) {
            K(109);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(R$styleable.AppCompatTheme_windowActionModeOverlay, false)) {
            K(10);
        }
        this.K = typedArrayObtainStyledAttributes.getBoolean(R$styleable.AppCompatTheme_android_windowIsFloating, false);
        typedArrayObtainStyledAttributes.recycle();
        o0();
        this.f753m.getDecorView();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f752l);
        if (this.L) {
            viewGroup = this.J ? (ViewGroup) layoutInflaterFrom.inflate(R$layout.abc_screen_simple_overlay_action_mode, (ViewGroup) null) : (ViewGroup) layoutInflaterFrom.inflate(R$layout.abc_screen_simple, (ViewGroup) null);
        } else if (this.K) {
            viewGroup = (ViewGroup) layoutInflaterFrom.inflate(R$layout.abc_dialog_title_material, (ViewGroup) null);
            this.I = false;
            this.H = false;
        } else if (this.H) {
            TypedValue typedValue = new TypedValue();
            this.f752l.getTheme().resolveAttribute(R$attr.actionBarTheme, typedValue, true);
            viewGroup = (ViewGroup) LayoutInflater.from(typedValue.resourceId != 0 ? new g1.d(this.f752l, typedValue.resourceId) : this.f752l).inflate(R$layout.abc_screen_toolbar, (ViewGroup) null);
            androidx.appcompat.widget.v vVar = (androidx.appcompat.widget.v) viewGroup.findViewById(R$id.decor_content_parent);
            this.f759s = vVar;
            vVar.setWindowCallback(y0());
            if (this.I) {
                this.f759s.initFeature(109);
            }
            if (this.F) {
                this.f759s.initFeature(2);
            }
            if (this.G) {
                this.f759s.initFeature(5);
            }
        } else {
            viewGroup = null;
        }
        if (viewGroup == null) {
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.H + ", windowActionBarOverlay: " + this.I + ", android:windowIsFloating: " + this.K + ", windowActionModeOverlay: " + this.J + ", windowNoTitle: " + this.L + " }");
        }
        ViewCompat.setOnApplyWindowInsetsListener(viewGroup, new a());
        if (this.f759s == null) {
            this.D = (TextView) viewGroup.findViewById(R$id.title);
        }
        y0.c(viewGroup);
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(R$id.action_bar_activity_content);
        ViewGroup viewGroup2 = (ViewGroup) this.f753m.findViewById(R.id.content);
        if (viewGroup2 != null) {
            while (viewGroup2.getChildCount() > 0) {
                View childAt = viewGroup2.getChildAt(0);
                viewGroup2.removeViewAt(0);
                contentFrameLayout.addView(childAt);
            }
            viewGroup2.setId(-1);
            contentFrameLayout.setId(R.id.content);
            if (viewGroup2 instanceof FrameLayout) {
                ((FrameLayout) viewGroup2).setForeground(null);
            }
        }
        this.f753m.setContentView(viewGroup);
        contentFrameLayout.setAttachListener(new b());
        return viewGroup;
    }

    public final void i1(View view) {
        view.setBackgroundColor((ViewCompat.getWindowSystemUiVisibility(view) & 8192) != 0 ? z2.a.getColor(this.f752l, R$color.abc_decor_view_status_guard_light) : z2.a.getColor(this.f752l, R$color.abc_decor_view_status_guard));
    }

    public void j0() {
        androidx.appcompat.view.menu.f fVar;
        androidx.appcompat.widget.v vVar = this.f759s;
        if (vVar != null) {
            vVar.dismissPopups();
        }
        if (this.f764x != null) {
            this.f753m.getDecorView().removeCallbacks(this.f765y);
            if (this.f764x.isShowing()) {
                try {
                    this.f764x.dismiss();
                } catch (IllegalArgumentException unused) {
                }
            }
            this.f764x = null;
        }
        m0();
        PanelFeatureState panelFeatureStateW0 = w0(0, false);
        if (panelFeatureStateW0 == null || (fVar = panelFeatureStateW0.f777j) == null) {
            return;
        }
        fVar.close();
    }

    public boolean k0(KeyEvent keyEvent) {
        View decorView;
        Object obj = this.f751k;
        if (((obj instanceof KeyEventDispatcher.Component) || (obj instanceof w)) && (decorView = this.f753m.getDecorView()) != null && KeyEventDispatcher.dispatchBeforeHierarchy(decorView, keyEvent)) {
            return true;
        }
        if (keyEvent.getKeyCode() == 82 && this.f754n.b(this.f753m.getCallback(), keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        return keyEvent.getAction() == 0 ? H0(keyCode, keyEvent) : K0(keyCode, keyEvent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.appcompat.app.f
    public View l(View view, String str, @NonNull Context context, @NonNull AttributeSet attributeSet) {
        boolean z11;
        boolean zY0 = false;
        if (this.f747g0 == null) {
            TypedArray typedArrayObtainStyledAttributes = this.f752l.obtainStyledAttributes(R$styleable.AppCompatTheme);
            String string = typedArrayObtainStyledAttributes.getString(R$styleable.AppCompatTheme_viewInflaterClass);
            typedArrayObtainStyledAttributes.recycle();
            if (string == null) {
                this.f747g0 = new x();
            } else {
                try {
                    this.f747g0 = (x) this.f752l.getClassLoader().loadClass(string).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (Throwable unused) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Failed to instantiate custom view inflater ");
                    sb2.append(string);
                    sb2.append(". Falling back to default.");
                    this.f747g0 = new x();
                }
            }
        }
        boolean z12 = f738l0;
        if (z12) {
            if (this.f748h0 == null) {
                this.f748h0 = new y();
            }
            if (this.f748h0.a(attributeSet)) {
                z11 = true;
            } else {
                if (!(attributeSet instanceof XmlPullParser)) {
                    zY0 = Y0((ViewParent) view);
                } else if (((XmlPullParser) attributeSet).getDepth() > 1) {
                    zY0 = true;
                }
                z11 = zY0;
            }
        } else {
            z11 = false;
        }
        return this.f747g0.r(view, str, context, attributeSet, z11, z12, true, x0.c());
    }

    public void l0(int i11) {
        PanelFeatureState panelFeatureStateW0;
        PanelFeatureState panelFeatureStateW1 = w0(i11, true);
        if (panelFeatureStateW1.f777j != null) {
            Bundle bundle = new Bundle();
            panelFeatureStateW1.f777j.U(bundle);
            if (bundle.size() > 0) {
                panelFeatureStateW1.f786s = bundle;
            }
            panelFeatureStateW1.f777j.i0();
            panelFeatureStateW1.f777j.clear();
        }
        panelFeatureStateW1.f785r = true;
        panelFeatureStateW1.f784q = true;
        if ((i11 != 108 && i11 != 0) || this.f759s == null || (panelFeatureStateW0 = w0(0, false)) == null) {
            return;
        }
        panelFeatureStateW0.f780m = false;
        S0(panelFeatureStateW0, null);
    }

    @Override // androidx.appcompat.app.f
    @Nullable
    public <T extends View> T m(int i11) {
        n0();
        return (T) this.f753m.findViewById(i11);
    }

    public void m0() {
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.f766z;
        if (viewPropertyAnimatorCompat != null) {
            viewPropertyAnimatorCompat.cancel();
        }
    }

    public final void n0() {
        if (this.B) {
            return;
        }
        this.C = i0();
        CharSequence charSequenceX0 = x0();
        if (!TextUtils.isEmpty(charSequenceX0)) {
            androidx.appcompat.widget.v vVar = this.f759s;
            if (vVar != null) {
                vVar.setWindowTitle(charSequenceX0);
            } else if (Q0() != null) {
                Q0().t(charSequenceX0);
            } else {
                TextView textView = this.D;
                if (textView != null) {
                    textView.setText(charSequenceX0);
                }
            }
        }
        Y();
        O0(this.C);
        this.B = true;
        PanelFeatureState panelFeatureStateW0 = w0(0, false);
        if (this.S) {
            return;
        }
        if (panelFeatureStateW0 == null || panelFeatureStateW0.f777j == null) {
            D0(108);
        }
    }

    @Override // androidx.appcompat.app.f
    public Context o() {
        return this.f752l;
    }

    public final void o0() {
        if (this.f753m == null) {
            Object obj = this.f751k;
            if (obj instanceof Activity) {
                Z(((Activity) obj).getWindow());
            }
        }
        if (this.f753m == null) {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return l(view, str, context, attributeSet);
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    public PanelFeatureState p0(Menu menu) {
        PanelFeatureState[] panelFeatureStateArr = this.N;
        int length = panelFeatureStateArr != null ? panelFeatureStateArr.length : 0;
        for (int i11 = 0; i11 < length; i11++) {
            PanelFeatureState panelFeatureState = panelFeatureStateArr[i11];
            if (panelFeatureState != null && panelFeatureState.f777j == menu) {
                return panelFeatureState;
            }
        }
        return null;
    }

    @Override // androidx.appcompat.app.f
    public final androidx.appcompat.app.b q() {
        return new d();
    }

    @Override // androidx.appcompat.app.f
    public int r() {
        return this.U;
    }

    public final Context r0() {
        androidx.appcompat.app.a aVarV = v();
        Context contextJ = aVarV != null ? aVarV.j() : null;
        return contextJ == null ? this.f752l : contextJ;
    }

    public final int s0(Context context) {
        int i11;
        if (!this.X && (this.f751k instanceof Activity)) {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return 0;
            }
            try {
                int i12 = Build.VERSION.SDK_INT;
                if (i12 >= 29) {
                    i11 = 269221888;
                } else {
                    i11 = i12 >= 24 ? 786432 : 0;
                }
                ActivityInfo activityInfo = packageManager.getActivityInfo(new ComponentName(context, this.f751k.getClass()), i11);
                if (activityInfo != null) {
                    this.W = activityInfo.configChanges;
                }
            } catch (PackageManager.NameNotFoundException unused) {
                this.W = 0;
            }
        }
        this.X = true;
        return this.W;
    }

    @Override // androidx.appcompat.app.f
    public MenuInflater t() {
        if (this.f757q == null) {
            z0();
            androidx.appcompat.app.a aVar = this.f756p;
            this.f757q = new g1.g(aVar != null ? aVar.j() : this.f752l);
        }
        return this.f757q;
    }

    public final n t0(@NonNull Context context) {
        if (this.Z == null) {
            this.Z = new m(context);
        }
        return this.Z;
    }

    public final n u0(@NonNull Context context) {
        if (this.Y == null) {
            this.Y = new o(c0.a(context));
        }
        return this.Y;
    }

    @Override // androidx.appcompat.app.f
    public androidx.appcompat.app.a v() {
        z0();
        return this.f756p;
    }

    public androidx.core.os.h v0(Configuration configuration) {
        return Build.VERSION.SDK_INT >= 24 ? i.b(configuration) : androidx.core.os.h.c(h.b(configuration.locale));
    }

    @Override // androidx.appcompat.app.f
    public void w() {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f752l);
        if (layoutInflaterFrom.getFactory() == null) {
            LayoutInflaterCompat.setFactory2(layoutInflaterFrom, this);
        } else {
            boolean z11 = layoutInflaterFrom.getFactory2() instanceof AppCompatDelegateImpl;
        }
    }

    public PanelFeatureState w0(int i11, boolean z11) {
        PanelFeatureState[] panelFeatureStateArr = this.N;
        if (panelFeatureStateArr == null || panelFeatureStateArr.length <= i11) {
            PanelFeatureState[] panelFeatureStateArr2 = new PanelFeatureState[i11 + 1];
            if (panelFeatureStateArr != null) {
                System.arraycopy(panelFeatureStateArr, 0, panelFeatureStateArr2, 0, panelFeatureStateArr.length);
            }
            this.N = panelFeatureStateArr2;
            panelFeatureStateArr = panelFeatureStateArr2;
        }
        PanelFeatureState panelFeatureState = panelFeatureStateArr[i11];
        if (panelFeatureState != null) {
            return panelFeatureState;
        }
        PanelFeatureState panelFeatureState2 = new PanelFeatureState(i11);
        panelFeatureStateArr[i11] = panelFeatureState2;
        return panelFeatureState2;
    }

    @Override // androidx.appcompat.app.f
    public void x() {
        if (Q0() == null || v().l()) {
            return;
        }
        D0(0);
    }

    public final CharSequence x0() {
        Object obj = this.f751k;
        return obj instanceof Activity ? ((Activity) obj).getTitle() : this.f758r;
    }

    public final Window.Callback y0() {
        return this.f753m.getCallback();
    }

    public final void z0() {
        n0();
        if (this.H && this.f756p == null) {
            Object obj = this.f751k;
            if (obj instanceof Activity) {
                this.f756p = new d0((Activity) this.f751k, this.I);
            } else if (obj instanceof Dialog) {
                this.f756p = new d0((Dialog) this.f751k);
            }
            androidx.appcompat.app.a aVar = this.f756p;
            if (aVar != null) {
                aVar.r(this.f744d0);
            }
        }
    }
}
