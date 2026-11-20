package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedDispatcher;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.app.e0;
import androidx.core.view.MenuHost;
import androidx.core.view.MenuProvider;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.x0;
import androidx.lifecycle.y0;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class FragmentActivity extends ComponentActivity implements ActivityCompat.e, ActivityCompat.f {
    static final String LIFECYCLE_TAG = "android:support:lifecycle";
    boolean mCreated;
    final androidx.lifecycle.w mFragmentLifecycleRegistry;
    final g mFragments;
    boolean mResumed;
    boolean mStopped;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public class a extends i<FragmentActivity> implements z2.d, z2.e, androidx.core.app.y, androidx.core.app.z, y0, androidx.activity.s, b1.d, f6.e, t, MenuHost {
        public a() {
            super(FragmentActivity.this);
        }

        @Override // androidx.fragment.app.t
        public void a(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
            FragmentActivity.this.onAttachFragment(fragment);
        }

        @Override // androidx.core.view.MenuHost
        public void addMenuProvider(@NonNull MenuProvider menuProvider) {
            FragmentActivity.this.addMenuProvider(menuProvider);
        }

        @Override // androidx.core.view.MenuHost
        public void addMenuProvider(@NonNull MenuProvider menuProvider, @NonNull androidx.lifecycle.u uVar) {
            FragmentActivity.this.addMenuProvider(menuProvider, uVar);
        }

        @Override // androidx.core.view.MenuHost
        public void addMenuProvider(@NonNull MenuProvider menuProvider, @NonNull androidx.lifecycle.u uVar, @NonNull Lifecycle.State state) {
            FragmentActivity.this.addMenuProvider(menuProvider, uVar, state);
        }

        @Override // z2.d
        public void addOnConfigurationChangedListener(@NonNull androidx.core.util.a<Configuration> aVar) {
            FragmentActivity.this.addOnConfigurationChangedListener(aVar);
        }

        @Override // androidx.core.app.y
        public void addOnMultiWindowModeChangedListener(@NonNull androidx.core.util.a<androidx.core.app.l> aVar) {
            FragmentActivity.this.addOnMultiWindowModeChangedListener(aVar);
        }

        @Override // androidx.core.app.z
        public void addOnPictureInPictureModeChangedListener(@NonNull androidx.core.util.a<androidx.core.app.b0> aVar) {
            FragmentActivity.this.addOnPictureInPictureModeChangedListener(aVar);
        }

        @Override // z2.e
        public void addOnTrimMemoryListener(@NonNull androidx.core.util.a<Integer> aVar) {
            FragmentActivity.this.addOnTrimMemoryListener(aVar);
        }

        @Override // androidx.fragment.app.i, androidx.fragment.app.f
        @Nullable
        public View c(int i11) {
            return FragmentActivity.this.findViewById(i11);
        }

        @Override // androidx.fragment.app.i, androidx.fragment.app.f
        public boolean d() {
            Window window = FragmentActivity.this.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }

        @Override // b1.d
        @NonNull
        public b1.c getActivityResultRegistry() {
            return FragmentActivity.this.getActivityResultRegistry();
        }

        @Override // androidx.lifecycle.u
        @NonNull
        public Lifecycle getLifecycle() {
            return FragmentActivity.this.mFragmentLifecycleRegistry;
        }

        @Override // androidx.activity.s
        @NonNull
        public OnBackPressedDispatcher getOnBackPressedDispatcher() {
            return FragmentActivity.this.getOnBackPressedDispatcher();
        }

        @Override // f6.e
        @NonNull
        public f6.c getSavedStateRegistry() {
            return FragmentActivity.this.getSavedStateRegistry();
        }

        @Override // androidx.lifecycle.y0
        @NonNull
        public x0 getViewModelStore() {
            return FragmentActivity.this.getViewModelStore();
        }

        @Override // androidx.fragment.app.i
        public void h(@NonNull String str, @Nullable FileDescriptor fileDescriptor, @NonNull PrintWriter printWriter, @Nullable String[] strArr) {
            FragmentActivity.this.dump(str, fileDescriptor, printWriter, strArr);
        }

        @Override // androidx.core.view.MenuHost
        public void invalidateMenu() {
            FragmentActivity.this.invalidateOptionsMenu();
        }

        @Override // androidx.fragment.app.i
        @NonNull
        public LayoutInflater j() {
            return FragmentActivity.this.getLayoutInflater().cloneInContext(FragmentActivity.this);
        }

        @Override // androidx.fragment.app.i
        public boolean l(@NonNull String str) {
            return ActivityCompat.j(FragmentActivity.this, str);
        }

        @Override // androidx.fragment.app.i
        public void o() {
            invalidateMenu();
        }

        @Override // androidx.fragment.app.i
        /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
        public FragmentActivity i() {
            return FragmentActivity.this;
        }

        @Override // androidx.core.view.MenuHost
        public void removeMenuProvider(@NonNull MenuProvider menuProvider) {
            FragmentActivity.this.removeMenuProvider(menuProvider);
        }

        @Override // z2.d
        public void removeOnConfigurationChangedListener(@NonNull androidx.core.util.a<Configuration> aVar) {
            FragmentActivity.this.removeOnConfigurationChangedListener(aVar);
        }

        @Override // androidx.core.app.y
        public void removeOnMultiWindowModeChangedListener(@NonNull androidx.core.util.a<androidx.core.app.l> aVar) {
            FragmentActivity.this.removeOnMultiWindowModeChangedListener(aVar);
        }

        @Override // androidx.core.app.z
        public void removeOnPictureInPictureModeChangedListener(@NonNull androidx.core.util.a<androidx.core.app.b0> aVar) {
            FragmentActivity.this.removeOnPictureInPictureModeChangedListener(aVar);
        }

        @Override // z2.e
        public void removeOnTrimMemoryListener(@NonNull androidx.core.util.a<Integer> aVar) {
            FragmentActivity.this.removeOnTrimMemoryListener(aVar);
        }
    }

    public FragmentActivity() {
        this.mFragments = g.b(new a());
        this.mFragmentLifecycleRegistry = new androidx.lifecycle.w(this);
        this.mStopped = true;
        init();
    }

    public FragmentActivity(int i11) {
        super(i11);
        this.mFragments = g.b(new a());
        this.mFragmentLifecycleRegistry = new androidx.lifecycle.w(this);
        this.mStopped = true;
        init();
    }

    private void init() {
        getSavedStateRegistry().h(LIFECYCLE_TAG, new f6.c.InterfaceC0670c() { // from class: androidx.fragment.app.b
            @Override // f6.c.InterfaceC0670c
            public final Bundle saveState() {
                return this.f8579a.lambda$init$0();
            }
        });
        addOnConfigurationChangedListener(new androidx.core.util.a() { // from class: androidx.fragment.app.c
            @Override // androidx.core.util.a
            public final void accept(Object obj) {
                this.f8580a.lambda$init$1((Configuration) obj);
            }
        });
        addOnNewIntentListener(new androidx.core.util.a() { // from class: androidx.fragment.app.d
            @Override // androidx.core.util.a
            public final void accept(Object obj) {
                this.f8581a.lambda$init$2((Intent) obj);
            }
        });
        addOnContextAvailableListener(new androidx.activity.contextaware.d() { // from class: androidx.fragment.app.e
            @Override // androidx.activity.contextaware.d
            public final void a(Context context) {
                this.f8582a.lambda$init$3(context);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Bundle lambda$init$0() {
        markFragmentsCreated();
        this.mFragmentLifecycleRegistry.i(Lifecycle.Event.ON_STOP);
        return new Bundle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$1(Configuration configuration) {
        this.mFragments.m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$2(Intent intent) {
        this.mFragments.m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$3(Context context) {
        this.mFragments.a(null);
    }

    private static boolean markState(FragmentManager fragmentManager, Lifecycle.State state) {
        boolean zMarkState = false;
        for (Fragment fragment : fragmentManager.getFragments()) {
            if (fragment != null) {
                if (fragment.getHost() != null) {
                    zMarkState |= markState(fragment.getChildFragmentManager(), state);
                }
                z zVar = fragment.mViewLifecycleOwner;
                if (zVar != null && zVar.getLifecycle().b().isAtLeast(Lifecycle.State.STARTED)) {
                    fragment.mViewLifecycleOwner.f(state);
                    zMarkState = true;
                }
                if (fragment.mLifecycleRegistry.b().isAtLeast(Lifecycle.State.STARTED)) {
                    fragment.mLifecycleRegistry.n(state);
                    zMarkState = true;
                }
            }
        }
        return zMarkState;
    }

    @Nullable
    public final View dispatchFragmentsOnCreateView(@Nullable View view, @NonNull String str, @NonNull Context context, @NonNull AttributeSet attributeSet) {
        return this.mFragments.n(view, str, context, attributeSet);
    }

    @Override // android.app.Activity
    public void dump(@NonNull String str, @Nullable FileDescriptor fileDescriptor, @NonNull PrintWriter printWriter, @Nullable String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        if (shouldDumpInternalState(strArr)) {
            printWriter.print(str);
            printWriter.print("Local FragmentActivity ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(" State:");
            String str2 = str + "  ";
            printWriter.print(str2);
            printWriter.print("mCreated=");
            printWriter.print(this.mCreated);
            printWriter.print(" mResumed=");
            printWriter.print(this.mResumed);
            printWriter.print(" mStopped=");
            printWriter.print(this.mStopped);
            if (getApplication() != null) {
                t3.a.b(this).a(str2, fileDescriptor, printWriter, strArr);
            }
            this.mFragments.l().dump(str, fileDescriptor, printWriter, strArr);
        }
    }

    @NonNull
    public FragmentManager getSupportFragmentManager() {
        return this.mFragments.l();
    }

    @NonNull
    @Deprecated
    public t3.a getSupportLoaderManager() {
        return t3.a.b(this);
    }

    public void markFragmentsCreated() {
        while (markState(getSupportFragmentManager(), Lifecycle.State.CREATED)) {
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    @CallSuper
    public void onActivityResult(int i11, int i12, @Nullable Intent intent) {
        this.mFragments.m();
        super.onActivityResult(i11, i12, intent);
    }

    @Deprecated
    public void onAttachFragment(@NonNull Fragment fragment) {
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.mFragmentLifecycleRegistry.i(Lifecycle.Event.ON_CREATE);
        this.mFragments.e();
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    @Nullable
    public View onCreateView(@Nullable View view, @NonNull String str, @NonNull Context context, @NonNull AttributeSet attributeSet) {
        View viewDispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView(view, str, context, attributeSet);
        return viewDispatchFragmentsOnCreateView == null ? super.onCreateView(view, str, context, attributeSet) : viewDispatchFragmentsOnCreateView;
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    @Nullable
    public View onCreateView(@NonNull String str, @NonNull Context context, @NonNull AttributeSet attributeSet) {
        View viewDispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView(null, str, context, attributeSet);
        return viewDispatchFragmentsOnCreateView == null ? super.onCreateView(str, context, attributeSet) : viewDispatchFragmentsOnCreateView;
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mFragments.f();
        this.mFragmentLifecycleRegistry.i(Lifecycle.Event.ON_DESTROY);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i11, @NonNull MenuItem menuItem) {
        if (super.onMenuItemSelected(i11, menuItem)) {
            return true;
        }
        if (i11 == 6) {
            return this.mFragments.d(menuItem);
        }
        return false;
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        this.mResumed = false;
        this.mFragments.g();
        this.mFragmentLifecycleRegistry.i(Lifecycle.Event.ON_PAUSE);
    }

    @Override // android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        onResumeFragments();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    @CallSuper
    public void onRequestPermissionsResult(int i11, @NonNull String[] strArr, @NonNull int[] iArr) {
        this.mFragments.m();
        super.onRequestPermissionsResult(i11, strArr, iArr);
    }

    @Override // android.app.Activity
    public void onResume() {
        this.mFragments.m();
        super.onResume();
        this.mResumed = true;
        this.mFragments.k();
    }

    public void onResumeFragments() {
        this.mFragmentLifecycleRegistry.i(Lifecycle.Event.ON_RESUME);
        this.mFragments.h();
    }

    @Override // android.app.Activity
    public void onStart() {
        this.mFragments.m();
        super.onStart();
        this.mStopped = false;
        if (!this.mCreated) {
            this.mCreated = true;
            this.mFragments.c();
        }
        this.mFragments.k();
        this.mFragmentLifecycleRegistry.i(Lifecycle.Event.ON_START);
        this.mFragments.i();
    }

    @Override // android.app.Activity
    public void onStateNotSaved() {
        this.mFragments.m();
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        this.mStopped = true;
        markFragmentsCreated();
        this.mFragments.j();
        this.mFragmentLifecycleRegistry.i(Lifecycle.Event.ON_STOP);
    }

    public void setEnterSharedElementCallback(@Nullable e0 e0Var) {
        ActivityCompat.h(this, e0Var);
    }

    public void setExitSharedElementCallback(@Nullable e0 e0Var) {
        ActivityCompat.i(this, e0Var);
    }

    public void startActivityFromFragment(@NonNull Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i11) {
        startActivityFromFragment(fragment, intent, i11, (Bundle) null);
    }

    public void startActivityFromFragment(@NonNull Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i11, @Nullable Bundle bundle) {
        if (i11 == -1) {
            ActivityCompat.k(this, intent, -1, bundle);
        } else {
            fragment.startActivityForResult(intent, i11, bundle);
        }
    }

    @Deprecated
    public void startIntentSenderFromFragment(@NonNull Fragment fragment, @SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i11, @Nullable Intent intent, int i12, int i13, int i14, @Nullable Bundle bundle) throws IntentSender.SendIntentException {
        if (i11 == -1) {
            ActivityCompat.l(this, intentSender, i11, intent, i12, i13, i14, bundle);
        } else {
            fragment.startIntentSenderForResult(intentSender, i11, intent, i12, i13, i14, bundle);
        }
    }

    public void supportFinishAfterTransition() {
        ActivityCompat.c(this);
    }

    @Deprecated
    public void supportInvalidateOptionsMenu() {
        invalidateOptionsMenu();
    }

    public void supportPostponeEnterTransition() {
        ActivityCompat.e(this);
    }

    public void supportStartPostponedEnterTransition() {
        ActivityCompat.m(this);
    }

    @Override // androidx.core.app.ActivityCompat.f
    @Deprecated
    public final void validateRequestPermissionsRequestCode(int i11) {
    }
}
