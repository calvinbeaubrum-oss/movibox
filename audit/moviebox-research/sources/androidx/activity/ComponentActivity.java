package androidx.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.window.OnBackInvokedDispatcher;
import androidx.activity.result.IntentSenderRequest;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;
import androidx.core.app.b0;
import androidx.core.app.y;
import androidx.core.app.z;
import androidx.core.view.MenuHost;
import androidx.core.view.MenuHostHelper;
import androidx.core.view.MenuProvider;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.lifecycle.j0;
import androidx.lifecycle.o0;
import androidx.lifecycle.q0;
import androidx.lifecycle.v0;
import androidx.lifecycle.w;
import androidx.lifecycle.x0;
import androidx.lifecycle.y0;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class ComponentActivity extends androidx.core.app.ComponentActivity implements androidx.activity.contextaware.a, y0, androidx.lifecycle.m, f6.e, s, b1.d, z2.d, z2.e, y, z, MenuHost, n {
    private static final String ACTIVITY_RESULT_TAG = "android:support:activity-result";
    private final b1.c mActivityResultRegistry;
    private int mContentLayoutId;
    final androidx.activity.contextaware.b mContextAwareHelper;
    private v0.c mDefaultFactory;
    private boolean mDispatchingOnMultiWindowModeChanged;
    private boolean mDispatchingOnPictureInPictureModeChanged;

    @NonNull
    final m mFullyDrawnReporter;
    private final w mLifecycleRegistry;
    private final MenuHostHelper mMenuHostHelper;
    private final AtomicInteger mNextLocalRequestCode;
    private OnBackPressedDispatcher mOnBackPressedDispatcher;
    private final CopyOnWriteArrayList<androidx.core.util.a<Configuration>> mOnConfigurationChangedListeners;
    private final CopyOnWriteArrayList<androidx.core.util.a<androidx.core.app.l>> mOnMultiWindowModeChangedListeners;
    private final CopyOnWriteArrayList<androidx.core.util.a<Intent>> mOnNewIntentListeners;
    private final CopyOnWriteArrayList<androidx.core.util.a<b0>> mOnPictureInPictureModeChangedListeners;
    private final CopyOnWriteArrayList<androidx.core.util.a<Integer>> mOnTrimMemoryListeners;
    final h mReportFullyDrawnExecutor;
    final f6.d mSavedStateRegistryController;
    private x0 mViewModelStore;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    @RequiresApi(16)
    public class ReportFullyDrawnExecutorApi16Impl implements h, ViewTreeObserver.OnDrawListener, Runnable {
        final long mEndWatchTimeMillis = SystemClock.uptimeMillis() + 10000;
        boolean mOnDrawScheduled = false;
        Runnable mRunnable;

        public ReportFullyDrawnExecutorApi16Impl() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$execute$0() {
            Runnable runnable = this.mRunnable;
            if (runnable != null) {
                runnable.run();
                this.mRunnable = null;
            }
        }

        @Override // androidx.activity.ComponentActivity.h
        public void activityDestroyed() {
            ComponentActivity.this.getWindow().getDecorView().removeCallbacks(this);
            ComponentActivity.this.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(this);
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.mRunnable = runnable;
            View decorView = ComponentActivity.this.getWindow().getDecorView();
            if (!this.mOnDrawScheduled) {
                decorView.postOnAnimation(new Runnable() { // from class: androidx.activity.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f634a.lambda$execute$0();
                    }
                });
            } else if (Looper.myLooper() == Looper.getMainLooper()) {
                decorView.invalidate();
            } else {
                decorView.postInvalidate();
            }
        }

        @Override // android.view.ViewTreeObserver.OnDrawListener
        public void onDraw() {
            Runnable runnable = this.mRunnable;
            if (runnable == null) {
                if (SystemClock.uptimeMillis() > this.mEndWatchTimeMillis) {
                    this.mOnDrawScheduled = false;
                    ComponentActivity.this.getWindow().getDecorView().post(this);
                    return;
                }
                return;
            }
            runnable.run();
            this.mRunnable = null;
            if (ComponentActivity.this.mFullyDrawnReporter.c()) {
                this.mOnDrawScheduled = false;
                ComponentActivity.this.getWindow().getDecorView().post(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            ComponentActivity.this.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(this);
        }

        @Override // androidx.activity.ComponentActivity.h
        public void viewCreated(@NonNull View view) {
            if (this.mOnDrawScheduled) {
                return;
            }
            this.mOnDrawScheduled = true;
            view.getViewTreeObserver().addOnDrawListener(this);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class a implements androidx.lifecycle.r {
        public a() {
        }

        @Override // androidx.lifecycle.r
        public void onStateChanged(@NonNull androidx.lifecycle.u uVar, @NonNull Lifecycle.Event event) {
            if (event == Lifecycle.Event.ON_STOP) {
                Window window = ComponentActivity.this.getWindow();
                View viewPeekDecorView = window != null ? window.peekDecorView() : null;
                if (viewPeekDecorView != null) {
                    e.a(viewPeekDecorView);
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements androidx.lifecycle.r {
        public b() {
        }

        @Override // androidx.lifecycle.r
        public void onStateChanged(@NonNull androidx.lifecycle.u uVar, @NonNull Lifecycle.Event event) {
            if (event == Lifecycle.Event.ON_DESTROY) {
                ComponentActivity.this.mContextAwareHelper.b();
                if (!ComponentActivity.this.isChangingConfigurations()) {
                    ComponentActivity.this.getViewModelStore().a();
                }
                ComponentActivity.this.mReportFullyDrawnExecutor.activityDestroyed();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements androidx.lifecycle.r {
        public c() {
        }

        @Override // androidx.lifecycle.r
        public void onStateChanged(@NonNull androidx.lifecycle.u uVar, @NonNull Lifecycle.Event event) {
            ComponentActivity.this.ensureViewModelStore();
            ComponentActivity.this.getLifecycle().d(this);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public class d implements androidx.lifecycle.r {
        public d() {
        }

        @Override // androidx.lifecycle.r
        public void onStateChanged(@NonNull androidx.lifecycle.u uVar, @NonNull Lifecycle.Event event) {
            if (event != Lifecycle.Event.ON_CREATE || Build.VERSION.SDK_INT < 33) {
                return;
            }
            ComponentActivity.this.mOnBackPressedDispatcher.o(f.a((ComponentActivity) uVar));
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    @RequiresApi(19)
    public static class e {
        public static void a(View view) {
            view.cancelPendingInputEvents();
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    @RequiresApi(33)
    public static class f {
        public static OnBackInvokedDispatcher a(Activity activity) {
            return activity.getOnBackInvokedDispatcher();
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f600a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public x0 f601b;
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public interface h extends Executor {
        void activityDestroyed();

        void viewCreated(@NonNull View view);
    }

    public ComponentActivity() {
        this.mContextAwareHelper = new androidx.activity.contextaware.b();
        this.mMenuHostHelper = new MenuHostHelper(new Runnable() { // from class: androidx.activity.d
            @Override // java.lang.Runnable
            public final void run() {
                this.f630a.invalidateMenu();
            }
        });
        this.mLifecycleRegistry = new w(this);
        f6.d dVarA = f6.d.a(this);
        this.mSavedStateRegistryController = dVarA;
        this.mOnBackPressedDispatcher = null;
        h hVarCreateFullyDrawnExecutor = createFullyDrawnExecutor();
        this.mReportFullyDrawnExecutor = hVarCreateFullyDrawnExecutor;
        this.mFullyDrawnReporter = new m(hVarCreateFullyDrawnExecutor, new Function0() { // from class: androidx.activity.e
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f631a.lambda$new$0();
            }
        });
        this.mNextLocalRequestCode = new AtomicInteger();
        this.mActivityResultRegistry = new b1.c() { // from class: androidx.activity.ComponentActivity.1
            @Override // b1.c
            public <I, O> void f(final int i11, @NonNull c1.a<I, O> aVar, I i12, @Nullable androidx.core.app.b bVar) {
                Bundle bundleB;
                ComponentActivity componentActivity = ComponentActivity.this;
                final c1.a.C0152a<O> c0152aB = aVar.b(componentActivity, i12);
                if (c0152aB != null) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: androidx.activity.ComponentActivity.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            c(i11, c0152aB.a());
                        }
                    });
                    return;
                }
                Intent intentA = aVar.a(componentActivity, i12);
                if (intentA.getExtras() != null && intentA.getExtras().getClassLoader() == null) {
                    intentA.setExtrasClassLoader(componentActivity.getClassLoader());
                }
                if (intentA.hasExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) {
                    Bundle bundleExtra = intentA.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                    intentA.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                    bundleB = bundleExtra;
                } else {
                    bundleB = bVar != null ? bVar.b() : null;
                }
                if ("androidx.activity.result.contract.action.REQUEST_PERMISSIONS".equals(intentA.getAction())) {
                    String[] stringArrayExtra = intentA.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
                    if (stringArrayExtra == null) {
                        stringArrayExtra = new String[0];
                    }
                    ActivityCompat.g(componentActivity, stringArrayExtra, i11);
                    return;
                }
                if (!"androidx.activity.result.contract.action.INTENT_SENDER_REQUEST".equals(intentA.getAction())) {
                    ActivityCompat.k(componentActivity, intentA, i11, bundleB);
                    return;
                }
                IntentSenderRequest intentSenderRequest = (IntentSenderRequest) intentA.getParcelableExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST");
                try {
                    ActivityCompat.l(componentActivity, intentSenderRequest.getIntentSender(), i11, intentSenderRequest.getFillInIntent(), intentSenderRequest.getFlagsMask(), intentSenderRequest.getFlagsValues(), 0, bundleB);
                } catch (IntentSender.SendIntentException e11) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: androidx.activity.ComponentActivity.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            b(i11, 0, new Intent().setAction("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION", e11));
                        }
                    });
                }
            }
        };
        this.mOnConfigurationChangedListeners = new CopyOnWriteArrayList<>();
        this.mOnTrimMemoryListeners = new CopyOnWriteArrayList<>();
        this.mOnNewIntentListeners = new CopyOnWriteArrayList<>();
        this.mOnMultiWindowModeChangedListeners = new CopyOnWriteArrayList<>();
        this.mOnPictureInPictureModeChangedListeners = new CopyOnWriteArrayList<>();
        this.mDispatchingOnMultiWindowModeChanged = false;
        this.mDispatchingOnPictureInPictureModeChanged = false;
        if (getLifecycle() == null) {
            throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
        }
        int i11 = Build.VERSION.SDK_INT;
        getLifecycle().a(new a());
        getLifecycle().a(new b());
        getLifecycle().a(new c());
        dVarA.c();
        o0.c(this);
        if (i11 <= 23) {
            getLifecycle().a(new o(this));
        }
        getSavedStateRegistry().h(ACTIVITY_RESULT_TAG, new f6.c.InterfaceC0670c() { // from class: androidx.activity.f
            @Override // f6.c.InterfaceC0670c
            public final Bundle saveState() {
                return this.f632a.lambda$new$1();
            }
        });
        addOnContextAvailableListener(new androidx.activity.contextaware.d() { // from class: androidx.activity.g
            @Override // androidx.activity.contextaware.d
            public final void a(Context context) {
                this.f633a.lambda$new$2(context);
            }
        });
    }

    public ComponentActivity(int i11) {
        this();
        this.mContentLayoutId = i11;
    }

    private h createFullyDrawnExecutor() {
        return new ReportFullyDrawnExecutorApi16Impl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$new$0() {
        reportFullyDrawn();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Bundle lambda$new$1() {
        Bundle bundle = new Bundle();
        this.mActivityResultRegistry.h(bundle);
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$2(Context context) {
        Bundle bundleB = getSavedStateRegistry().b(ACTIVITY_RESULT_TAG);
        if (bundleB != null) {
            this.mActivityResultRegistry.g(bundleB);
        }
    }

    @Override // android.app.Activity
    public void addContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view, @SuppressLint({"UnknownNullness", "MissingNullability"}) ViewGroup.LayoutParams layoutParams) {
        initializeViewTreeOwners();
        this.mReportFullyDrawnExecutor.viewCreated(getWindow().getDecorView());
        super.addContentView(view, layoutParams);
    }

    @Override // androidx.core.view.MenuHost
    public void addMenuProvider(@NonNull MenuProvider menuProvider) {
        this.mMenuHostHelper.addMenuProvider(menuProvider);
    }

    @Override // androidx.core.view.MenuHost
    public void addMenuProvider(@NonNull MenuProvider menuProvider, @NonNull androidx.lifecycle.u uVar) {
        this.mMenuHostHelper.addMenuProvider(menuProvider, uVar);
    }

    @Override // androidx.core.view.MenuHost
    @SuppressLint({"LambdaLast"})
    public void addMenuProvider(@NonNull MenuProvider menuProvider, @NonNull androidx.lifecycle.u uVar, @NonNull Lifecycle.State state) {
        this.mMenuHostHelper.addMenuProvider(menuProvider, uVar, state);
    }

    @Override // z2.d
    public final void addOnConfigurationChangedListener(@NonNull androidx.core.util.a<Configuration> aVar) {
        this.mOnConfigurationChangedListeners.add(aVar);
    }

    public final void addOnContextAvailableListener(@NonNull androidx.activity.contextaware.d dVar) {
        this.mContextAwareHelper.a(dVar);
    }

    @Override // androidx.core.app.y
    public final void addOnMultiWindowModeChangedListener(@NonNull androidx.core.util.a<androidx.core.app.l> aVar) {
        this.mOnMultiWindowModeChangedListeners.add(aVar);
    }

    public final void addOnNewIntentListener(@NonNull androidx.core.util.a<Intent> aVar) {
        this.mOnNewIntentListeners.add(aVar);
    }

    @Override // androidx.core.app.z
    public final void addOnPictureInPictureModeChangedListener(@NonNull androidx.core.util.a<b0> aVar) {
        this.mOnPictureInPictureModeChangedListeners.add(aVar);
    }

    @Override // z2.e
    public final void addOnTrimMemoryListener(@NonNull androidx.core.util.a<Integer> aVar) {
        this.mOnTrimMemoryListeners.add(aVar);
    }

    public void ensureViewModelStore() {
        if (this.mViewModelStore == null) {
            g gVar = (g) getLastNonConfigurationInstance();
            if (gVar != null) {
                this.mViewModelStore = gVar.f601b;
            }
            if (this.mViewModelStore == null) {
                this.mViewModelStore = new x0();
            }
        }
    }

    @Override // b1.d
    @NonNull
    public final b1.c getActivityResultRegistry() {
        return this.mActivityResultRegistry;
    }

    @Override // androidx.lifecycle.m
    @NonNull
    @CallSuper
    public r3.a getDefaultViewModelCreationExtras() {
        r3.b bVar = new r3.b();
        if (getApplication() != null) {
            bVar.c(v0.a.f8785g, getApplication());
        }
        bVar.c(o0.f8761a, this);
        bVar.c(o0.f8762b, this);
        if (getIntent() != null && getIntent().getExtras() != null) {
            bVar.c(o0.f8763c, getIntent().getExtras());
        }
        return bVar;
    }

    @Override // androidx.lifecycle.m
    @NonNull
    public v0.c getDefaultViewModelProviderFactory() {
        if (this.mDefaultFactory == null) {
            this.mDefaultFactory = new q0(getApplication(), this, getIntent() != null ? getIntent().getExtras() : null);
        }
        return this.mDefaultFactory;
    }

    @NonNull
    public m getFullyDrawnReporter() {
        return this.mFullyDrawnReporter;
    }

    @Nullable
    @Deprecated
    public Object getLastCustomNonConfigurationInstance() {
        g gVar = (g) getLastNonConfigurationInstance();
        if (gVar != null) {
            return gVar.f600a;
        }
        return null;
    }

    @Override // androidx.core.app.ComponentActivity, androidx.lifecycle.u
    @NonNull
    public Lifecycle getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @Override // androidx.activity.s
    @NonNull
    public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
        if (this.mOnBackPressedDispatcher == null) {
            this.mOnBackPressedDispatcher = new OnBackPressedDispatcher(new Runnable() { // from class: androidx.activity.ComponentActivity.5
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        ComponentActivity.super.onBackPressed();
                    } catch (IllegalStateException e11) {
                        if (!TextUtils.equals(e11.getMessage(), "Can not perform this action after onSaveInstanceState")) {
                            throw e11;
                        }
                    } catch (NullPointerException e12) {
                        if (!TextUtils.equals(e12.getMessage(), "Attempt to invoke virtual method 'android.os.Handler android.app.FragmentHostCallback.getHandler()' on a null object reference")) {
                            throw e12;
                        }
                    }
                }
            });
            getLifecycle().a(new d());
        }
        return this.mOnBackPressedDispatcher;
    }

    @Override // f6.e
    @NonNull
    public final f6.c getSavedStateRegistry() {
        return this.mSavedStateRegistryController.b();
    }

    @Override // androidx.lifecycle.y0
    @NonNull
    public x0 getViewModelStore() {
        if (getApplication() == null) {
            throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
        }
        ensureViewModelStore();
        return this.mViewModelStore;
    }

    @CallSuper
    public void initializeViewTreeOwners() {
        ViewTreeLifecycleOwner.b(getWindow().getDecorView(), this);
        ViewTreeViewModelStoreOwner.b(getWindow().getDecorView(), this);
        ViewTreeSavedStateRegistryOwner.b(getWindow().getDecorView(), this);
        u.a(getWindow().getDecorView(), this);
        t.a(getWindow().getDecorView(), this);
    }

    @Override // androidx.core.view.MenuHost
    public void invalidateMenu() {
        invalidateOptionsMenu();
    }

    @Override // android.app.Activity
    @CallSuper
    @Deprecated
    public void onActivityResult(int i11, int i12, @Nullable Intent intent) {
        if (this.mActivityResultRegistry.b(i11, i12, intent)) {
            return;
        }
        super.onActivityResult(i11, i12, intent);
    }

    @Override // android.app.Activity
    @CallSuper
    @Deprecated
    public void onBackPressed() {
        getOnBackPressedDispatcher().l();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    @CallSuper
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Iterator<androidx.core.util.a<Configuration>> it = this.mOnConfigurationChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().accept(configuration);
        }
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        this.mSavedStateRegistryController.d(bundle);
        this.mContextAwareHelper.c(this);
        super.onCreate(bundle);
        j0.e(this);
        int i11 = this.mContentLayoutId;
        if (i11 != 0) {
            setContentView(i11);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i11, @NonNull Menu menu) {
        if (i11 != 0) {
            return true;
        }
        super.onCreatePanelMenu(i11, menu);
        this.mMenuHostHelper.onCreateMenu(menu, getMenuInflater());
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i11, @NonNull MenuItem menuItem) {
        if (super.onMenuItemSelected(i11, menuItem)) {
            return true;
        }
        if (i11 == 0) {
            return this.mMenuHostHelper.onMenuItemSelected(menuItem);
        }
        return false;
    }

    @Override // android.app.Activity
    @CallSuper
    public void onMultiWindowModeChanged(boolean z11) {
        if (this.mDispatchingOnMultiWindowModeChanged) {
            return;
        }
        Iterator<androidx.core.util.a<androidx.core.app.l>> it = this.mOnMultiWindowModeChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().accept(new androidx.core.app.l(z11));
        }
    }

    @Override // android.app.Activity
    @RequiresApi(api = 26)
    @CallSuper
    public void onMultiWindowModeChanged(boolean z11, @NonNull Configuration configuration) {
        this.mDispatchingOnMultiWindowModeChanged = true;
        try {
            super.onMultiWindowModeChanged(z11, configuration);
            this.mDispatchingOnMultiWindowModeChanged = false;
            Iterator<androidx.core.util.a<androidx.core.app.l>> it = this.mOnMultiWindowModeChangedListeners.iterator();
            while (it.hasNext()) {
                it.next().accept(new androidx.core.app.l(z11, configuration));
            }
        } catch (Throwable th2) {
            this.mDispatchingOnMultiWindowModeChanged = false;
            throw th2;
        }
    }

    @Override // android.app.Activity
    @CallSuper
    public void onNewIntent(@SuppressLint({"UnknownNullness", "MissingNullability"}) Intent intent) {
        super.onNewIntent(intent);
        Iterator<androidx.core.util.a<Intent>> it = this.mOnNewIntentListeners.iterator();
        while (it.hasNext()) {
            it.next().accept(intent);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i11, @NonNull Menu menu) {
        this.mMenuHostHelper.onMenuClosed(menu);
        super.onPanelClosed(i11, menu);
    }

    @Override // android.app.Activity
    @CallSuper
    public void onPictureInPictureModeChanged(boolean z11) {
        if (this.mDispatchingOnPictureInPictureModeChanged) {
            return;
        }
        Iterator<androidx.core.util.a<b0>> it = this.mOnPictureInPictureModeChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().accept(new b0(z11));
        }
    }

    @Override // android.app.Activity
    @RequiresApi(api = 26)
    @CallSuper
    public void onPictureInPictureModeChanged(boolean z11, @NonNull Configuration configuration) {
        this.mDispatchingOnPictureInPictureModeChanged = true;
        try {
            super.onPictureInPictureModeChanged(z11, configuration);
            this.mDispatchingOnPictureInPictureModeChanged = false;
            Iterator<androidx.core.util.a<b0>> it = this.mOnPictureInPictureModeChangedListeners.iterator();
            while (it.hasNext()) {
                it.next().accept(new b0(z11, configuration));
            }
        } catch (Throwable th2) {
            this.mDispatchingOnPictureInPictureModeChanged = false;
            throw th2;
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i11, @Nullable View view, @NonNull Menu menu) {
        if (i11 != 0) {
            return true;
        }
        super.onPreparePanel(i11, view, menu);
        this.mMenuHostHelper.onPrepareMenu(menu);
        return true;
    }

    @Override // android.app.Activity
    @CallSuper
    @Deprecated
    public void onRequestPermissionsResult(int i11, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (this.mActivityResultRegistry.b(i11, -1, new Intent().putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr).putExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS", iArr)) || Build.VERSION.SDK_INT < 23) {
            return;
        }
        super.onRequestPermissionsResult(i11, strArr, iArr);
    }

    @Nullable
    @Deprecated
    public Object onRetainCustomNonConfigurationInstance() {
        return null;
    }

    @Override // android.app.Activity
    @Nullable
    public final Object onRetainNonConfigurationInstance() {
        g gVar;
        Object objOnRetainCustomNonConfigurationInstance = onRetainCustomNonConfigurationInstance();
        x0 x0Var = this.mViewModelStore;
        if (x0Var == null && (gVar = (g) getLastNonConfigurationInstance()) != null) {
            x0Var = gVar.f601b;
        }
        if (x0Var == null && objOnRetainCustomNonConfigurationInstance == null) {
            return null;
        }
        g gVar2 = new g();
        gVar2.f600a = objOnRetainCustomNonConfigurationInstance;
        gVar2.f601b = x0Var;
        return gVar2;
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity
    @CallSuper
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        Lifecycle lifecycle = getLifecycle();
        if (lifecycle instanceof w) {
            ((w) lifecycle).n(Lifecycle.State.CREATED);
        }
        super.onSaveInstanceState(bundle);
        this.mSavedStateRegistryController.e(bundle);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    @CallSuper
    public void onTrimMemory(int i11) {
        super.onTrimMemory(i11);
        Iterator<androidx.core.util.a<Integer>> it = this.mOnTrimMemoryListeners.iterator();
        while (it.hasNext()) {
            it.next().accept(Integer.valueOf(i11));
        }
    }

    @Nullable
    public Context peekAvailableContext() {
        return this.mContextAwareHelper.d();
    }

    @NonNull
    public final <I, O> b1.b<I> registerForActivityResult(@NonNull c1.a<I, O> aVar, @NonNull b1.a<O> aVar2) {
        return registerForActivityResult(aVar, this.mActivityResultRegistry, aVar2);
    }

    @NonNull
    public final <I, O> b1.b<I> registerForActivityResult(@NonNull c1.a<I, O> aVar, @NonNull b1.c cVar, @NonNull b1.a<O> aVar2) {
        return cVar.i("activity_rq#" + this.mNextLocalRequestCode.getAndIncrement(), this, aVar, aVar2);
    }

    @Override // androidx.core.view.MenuHost
    public void removeMenuProvider(@NonNull MenuProvider menuProvider) {
        this.mMenuHostHelper.removeMenuProvider(menuProvider);
    }

    @Override // z2.d
    public final void removeOnConfigurationChangedListener(@NonNull androidx.core.util.a<Configuration> aVar) {
        this.mOnConfigurationChangedListeners.remove(aVar);
    }

    @Override // androidx.activity.contextaware.a
    public final void removeOnContextAvailableListener(@NonNull androidx.activity.contextaware.d dVar) {
        this.mContextAwareHelper.e(dVar);
    }

    @Override // androidx.core.app.y
    public final void removeOnMultiWindowModeChangedListener(@NonNull androidx.core.util.a<androidx.core.app.l> aVar) {
        this.mOnMultiWindowModeChangedListeners.remove(aVar);
    }

    public final void removeOnNewIntentListener(@NonNull androidx.core.util.a<Intent> aVar) {
        this.mOnNewIntentListeners.remove(aVar);
    }

    @Override // androidx.core.app.z
    public final void removeOnPictureInPictureModeChangedListener(@NonNull androidx.core.util.a<b0> aVar) {
        this.mOnPictureInPictureModeChangedListeners.remove(aVar);
    }

    @Override // z2.e
    public final void removeOnTrimMemoryListener(@NonNull androidx.core.util.a<Integer> aVar) {
        this.mOnTrimMemoryListeners.remove(aVar);
    }

    @Override // android.app.Activity
    public void reportFullyDrawn() {
        try {
            if (j6.b.d()) {
                j6.b.a("reportFullyDrawn() for ComponentActivity");
            }
            super.reportFullyDrawn();
            this.mFullyDrawnReporter.b();
        } finally {
            j6.b.b();
        }
    }

    @Override // android.app.Activity
    public void setContentView(int i11) {
        initializeViewTreeOwners();
        this.mReportFullyDrawnExecutor.viewCreated(getWindow().getDecorView());
        super.setContentView(i11);
    }

    @Override // android.app.Activity
    public void setContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view) {
        initializeViewTreeOwners();
        this.mReportFullyDrawnExecutor.viewCreated(getWindow().getDecorView());
        super.setContentView(view);
    }

    @Override // android.app.Activity
    public void setContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view, @SuppressLint({"UnknownNullness", "MissingNullability"}) ViewGroup.LayoutParams layoutParams) {
        initializeViewTreeOwners();
        this.mReportFullyDrawnExecutor.viewCreated(getWindow().getDecorView());
        super.setContentView(view, layoutParams);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startActivityForResult(@NonNull Intent intent, int i11) {
        super.startActivityForResult(intent, i11);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startActivityForResult(@NonNull Intent intent, int i11, @Nullable Bundle bundle) {
        super.startActivityForResult(intent, i11, bundle);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startIntentSenderForResult(@NonNull IntentSender intentSender, int i11, @Nullable Intent intent, int i12, int i13, int i14) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(intentSender, i11, intent, i12, i13, i14);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startIntentSenderForResult(@NonNull IntentSender intentSender, int i11, @Nullable Intent intent, int i12, int i13, int i14, @Nullable Bundle bundle) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(intentSender, i11, intent, i12, i13, i14, bundle);
    }
}
