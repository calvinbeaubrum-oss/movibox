package androidx.fragment.app;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.fragment.R$id;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.y0;
import com.applovin.sdk.AppLovinMediationProvider;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f8618a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final w f8619b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final Fragment f8620c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f8621d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f8622e = -1;

    /* JADX INFO: compiled from: source.java */
    public class a implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f8623a;

        public a(View view) {
            this.f8623a = view;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            this.f8623a.removeOnAttachStateChangeListener(this);
            ViewCompat.requestApplyInsets(this.f8623a);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f8625a;

        static {
            int[] iArr = new int[Lifecycle.State.values().length];
            f8625a = iArr;
            try {
                iArr[Lifecycle.State.RESUMED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8625a[Lifecycle.State.STARTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8625a[Lifecycle.State.CREATED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f8625a[Lifecycle.State.INITIALIZED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public v(@NonNull k kVar, @NonNull w wVar, @NonNull Fragment fragment) {
        this.f8618a = kVar;
        this.f8619b = wVar;
        this.f8620c = fragment;
    }

    public v(@NonNull k kVar, @NonNull w wVar, @NonNull Fragment fragment, @NonNull FragmentState fragmentState) {
        this.f8618a = kVar;
        this.f8619b = wVar;
        this.f8620c = fragment;
        fragment.mSavedViewState = null;
        fragment.mSavedViewRegistryState = null;
        fragment.mBackStackNesting = 0;
        fragment.mInLayout = false;
        fragment.mAdded = false;
        Fragment fragment2 = fragment.mTarget;
        fragment.mTargetWho = fragment2 != null ? fragment2.mWho : null;
        fragment.mTarget = null;
        Bundle bundle = fragmentState.f8521n;
        if (bundle != null) {
            fragment.mSavedFragmentState = bundle;
        } else {
            fragment.mSavedFragmentState = new Bundle();
        }
    }

    public v(@NonNull k kVar, @NonNull w wVar, @NonNull ClassLoader classLoader, @NonNull h hVar, @NonNull FragmentState fragmentState) {
        this.f8618a = kVar;
        this.f8619b = wVar;
        Fragment fragmentA = fragmentState.a(hVar, classLoader);
        this.f8620c = fragmentA;
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v(FragmentManager.TAG, "Instantiated fragment " + fragmentA);
        }
    }

    public void a() {
        if (FragmentManager.isLoggingEnabled(3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("moveto ACTIVITY_CREATED: ");
            sb2.append(this.f8620c);
        }
        Fragment fragment = this.f8620c;
        fragment.performActivityCreated(fragment.mSavedFragmentState);
        k kVar = this.f8618a;
        Fragment fragment2 = this.f8620c;
        kVar.a(fragment2, fragment2.mSavedFragmentState, false);
    }

    public void b() {
        int iJ = this.f8619b.j(this.f8620c);
        Fragment fragment = this.f8620c;
        fragment.mContainer.addView(fragment.mView, iJ);
    }

    public void c() {
        if (FragmentManager.isLoggingEnabled(3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("moveto ATTACHED: ");
            sb2.append(this.f8620c);
        }
        Fragment fragment = this.f8620c;
        Fragment fragment2 = fragment.mTarget;
        v vVarO = null;
        if (fragment2 != null) {
            v vVarO2 = this.f8619b.o(fragment2.mWho);
            if (vVarO2 == null) {
                throw new IllegalStateException("Fragment " + this.f8620c + " declared target fragment " + this.f8620c.mTarget + " that does not belong to this FragmentManager!");
            }
            Fragment fragment3 = this.f8620c;
            fragment3.mTargetWho = fragment3.mTarget.mWho;
            fragment3.mTarget = null;
            vVarO = vVarO2;
        } else {
            String str = fragment.mTargetWho;
            if (str != null && (vVarO = this.f8619b.o(str)) == null) {
                throw new IllegalStateException("Fragment " + this.f8620c + " declared target fragment " + this.f8620c.mTargetWho + " that does not belong to this FragmentManager!");
            }
        }
        if (vVarO != null) {
            vVarO.m();
        }
        Fragment fragment4 = this.f8620c;
        fragment4.mHost = fragment4.mFragmentManager.getHost();
        Fragment fragment5 = this.f8620c;
        fragment5.mParentFragment = fragment5.mFragmentManager.getParent();
        this.f8618a.g(this.f8620c, false);
        this.f8620c.performAttach();
        this.f8618a.b(this.f8620c, false);
    }

    public int d() {
        Fragment fragment = this.f8620c;
        if (fragment.mFragmentManager == null) {
            return fragment.mState;
        }
        int iMin = this.f8622e;
        int i11 = b.f8625a[fragment.mMaxState.ordinal()];
        if (i11 != 1) {
            if (i11 == 2) {
                iMin = Math.min(iMin, 5);
            } else if (i11 != 3) {
                iMin = i11 != 4 ? Math.min(iMin, -1) : Math.min(iMin, 0);
            } else {
                iMin = Math.min(iMin, 1);
            }
        }
        Fragment fragment2 = this.f8620c;
        if (fragment2.mFromLayout) {
            if (fragment2.mInLayout) {
                iMin = Math.max(this.f8622e, 2);
                View view = this.f8620c.mView;
                if (view != null && view.getParent() == null) {
                    iMin = Math.min(iMin, 2);
                }
            } else {
                iMin = this.f8622e < 4 ? Math.min(iMin, fragment2.mState) : Math.min(iMin, 1);
            }
        }
        if (!this.f8620c.mAdded) {
            iMin = Math.min(iMin, 1);
        }
        Fragment fragment3 = this.f8620c;
        ViewGroup viewGroup = fragment3.mContainer;
        SpecialEffectsController.Operation.LifecycleImpact lifecycleImpactL = viewGroup != null ? SpecialEffectsController.n(viewGroup, fragment3.getParentFragmentManager()).l(this) : null;
        if (lifecycleImpactL == SpecialEffectsController.Operation.LifecycleImpact.ADDING) {
            iMin = Math.min(iMin, 6);
        } else if (lifecycleImpactL == SpecialEffectsController.Operation.LifecycleImpact.REMOVING) {
            iMin = Math.max(iMin, 3);
        } else {
            Fragment fragment4 = this.f8620c;
            if (fragment4.mRemoving) {
                iMin = fragment4.isInBackStack() ? Math.min(iMin, 1) : Math.min(iMin, -1);
            }
        }
        Fragment fragment5 = this.f8620c;
        if (fragment5.mDeferStart && fragment5.mState < 5) {
            iMin = Math.min(iMin, 4);
        }
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v(FragmentManager.TAG, "computeExpectedState() of " + iMin + " for " + this.f8620c);
        }
        return iMin;
    }

    public void e() {
        if (FragmentManager.isLoggingEnabled(3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("moveto CREATED: ");
            sb2.append(this.f8620c);
        }
        Fragment fragment = this.f8620c;
        if (fragment.mIsCreated) {
            fragment.restoreChildFragmentState(fragment.mSavedFragmentState);
            this.f8620c.mState = 1;
            return;
        }
        this.f8618a.h(fragment, fragment.mSavedFragmentState, false);
        Fragment fragment2 = this.f8620c;
        fragment2.performCreate(fragment2.mSavedFragmentState);
        k kVar = this.f8618a;
        Fragment fragment3 = this.f8620c;
        kVar.c(fragment3, fragment3.mSavedFragmentState, false);
    }

    public void f() {
        String resourceName;
        if (this.f8620c.mFromLayout) {
            return;
        }
        if (FragmentManager.isLoggingEnabled(3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("moveto CREATE_VIEW: ");
            sb2.append(this.f8620c);
        }
        Fragment fragment = this.f8620c;
        LayoutInflater layoutInflaterPerformGetLayoutInflater = fragment.performGetLayoutInflater(fragment.mSavedFragmentState);
        Fragment fragment2 = this.f8620c;
        ViewGroup viewGroup = fragment2.mContainer;
        if (viewGroup == null) {
            int i11 = fragment2.mContainerId;
            if (i11 == 0) {
                viewGroup = null;
            } else {
                if (i11 == -1) {
                    throw new IllegalArgumentException("Cannot create fragment " + this.f8620c + " for a container view with no id");
                }
                viewGroup = (ViewGroup) fragment2.mFragmentManager.getContainer().c(this.f8620c.mContainerId);
                if (viewGroup == null) {
                    Fragment fragment3 = this.f8620c;
                    if (!fragment3.mRestored) {
                        try {
                            resourceName = fragment3.getResources().getResourceName(this.f8620c.mContainerId);
                        } catch (Resources.NotFoundException unused) {
                            resourceName = AppLovinMediationProvider.UNKNOWN;
                        }
                        throw new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(this.f8620c.mContainerId) + " (" + resourceName + ") for fragment " + this.f8620c);
                    }
                } else if (!(viewGroup instanceof FragmentContainerView)) {
                    FragmentStrictMode.n(this.f8620c, viewGroup);
                }
            }
        }
        Fragment fragment4 = this.f8620c;
        fragment4.mContainer = viewGroup;
        fragment4.performCreateView(layoutInflaterPerformGetLayoutInflater, viewGroup, fragment4.mSavedFragmentState);
        View view = this.f8620c.mView;
        if (view != null) {
            view.setSaveFromParentEnabled(false);
            Fragment fragment5 = this.f8620c;
            fragment5.mView.setTag(R$id.fragment_container_view_tag, fragment5);
            if (viewGroup != null) {
                b();
            }
            Fragment fragment6 = this.f8620c;
            if (fragment6.mHidden) {
                fragment6.mView.setVisibility(8);
            }
            if (ViewCompat.isAttachedToWindow(this.f8620c.mView)) {
                ViewCompat.requestApplyInsets(this.f8620c.mView);
            } else {
                View view2 = this.f8620c.mView;
                view2.addOnAttachStateChangeListener(new a(view2));
            }
            this.f8620c.performViewCreated();
            k kVar = this.f8618a;
            Fragment fragment7 = this.f8620c;
            kVar.m(fragment7, fragment7.mView, fragment7.mSavedFragmentState, false);
            int visibility = this.f8620c.mView.getVisibility();
            this.f8620c.setPostOnViewCreatedAlpha(this.f8620c.mView.getAlpha());
            Fragment fragment8 = this.f8620c;
            if (fragment8.mContainer != null && visibility == 0) {
                View viewFindFocus = fragment8.mView.findFocus();
                if (viewFindFocus != null) {
                    this.f8620c.setFocusedView(viewFindFocus);
                    if (FragmentManager.isLoggingEnabled(2)) {
                        Log.v(FragmentManager.TAG, "requestFocus: Saved focused view " + viewFindFocus + " for Fragment " + this.f8620c);
                    }
                }
                this.f8620c.mView.setAlpha(0.0f);
            }
        }
        this.f8620c.mState = 2;
    }

    public void g() {
        Fragment fragmentF;
        if (FragmentManager.isLoggingEnabled(3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("movefrom CREATED: ");
            sb2.append(this.f8620c);
        }
        Fragment fragment = this.f8620c;
        boolean zIsChangingConfigurations = true;
        boolean z11 = fragment.mRemoving && !fragment.isInBackStack();
        if (z11) {
            Fragment fragment2 = this.f8620c;
            if (!fragment2.mBeingSaved) {
                this.f8619b.C(fragment2.mWho, null);
            }
        }
        if (!z11 && !this.f8619b.q().p(this.f8620c)) {
            String str = this.f8620c.mTargetWho;
            if (str != null && (fragmentF = this.f8619b.f(str)) != null && fragmentF.mRetainInstance) {
                this.f8620c.mTarget = fragmentF;
            }
            this.f8620c.mState = 0;
            return;
        }
        i<?> iVar = this.f8620c.mHost;
        if (iVar instanceof y0) {
            zIsChangingConfigurations = this.f8619b.q().l();
        } else if (iVar.f() instanceof Activity) {
            zIsChangingConfigurations = true ^ ((Activity) iVar.f()).isChangingConfigurations();
        }
        if ((z11 && !this.f8620c.mBeingSaved) || zIsChangingConfigurations) {
            this.f8619b.q().c(this.f8620c);
        }
        this.f8620c.performDestroy();
        this.f8618a.d(this.f8620c, false);
        for (v vVar : this.f8619b.l()) {
            if (vVar != null) {
                Fragment fragmentK = vVar.k();
                if (this.f8620c.mWho.equals(fragmentK.mTargetWho)) {
                    fragmentK.mTarget = this.f8620c;
                    fragmentK.mTargetWho = null;
                }
            }
        }
        Fragment fragment3 = this.f8620c;
        String str2 = fragment3.mTargetWho;
        if (str2 != null) {
            fragment3.mTarget = this.f8619b.f(str2);
        }
        this.f8619b.t(this);
    }

    public void h() {
        View view;
        if (FragmentManager.isLoggingEnabled(3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("movefrom CREATE_VIEW: ");
            sb2.append(this.f8620c);
        }
        Fragment fragment = this.f8620c;
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null && (view = fragment.mView) != null) {
            viewGroup.removeView(view);
        }
        this.f8620c.performDestroyView();
        this.f8618a.n(this.f8620c, false);
        Fragment fragment2 = this.f8620c;
        fragment2.mContainer = null;
        fragment2.mView = null;
        fragment2.mViewLifecycleOwner = null;
        fragment2.mViewLifecycleOwnerLiveData.q(null);
        this.f8620c.mInLayout = false;
    }

    public void i() {
        if (FragmentManager.isLoggingEnabled(3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("movefrom ATTACHED: ");
            sb2.append(this.f8620c);
        }
        this.f8620c.performDetach();
        this.f8618a.e(this.f8620c, false);
        Fragment fragment = this.f8620c;
        fragment.mState = -1;
        fragment.mHost = null;
        fragment.mParentFragment = null;
        fragment.mFragmentManager = null;
        if ((!fragment.mRemoving || fragment.isInBackStack()) && !this.f8619b.q().p(this.f8620c)) {
            return;
        }
        if (FragmentManager.isLoggingEnabled(3)) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("initState called for fragment: ");
            sb3.append(this.f8620c);
        }
        this.f8620c.initState();
    }

    public void j() {
        Fragment fragment = this.f8620c;
        if (fragment.mFromLayout && fragment.mInLayout && !fragment.mPerformedCreateView) {
            if (FragmentManager.isLoggingEnabled(3)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("moveto CREATE_VIEW: ");
                sb2.append(this.f8620c);
            }
            Fragment fragment2 = this.f8620c;
            fragment2.performCreateView(fragment2.performGetLayoutInflater(fragment2.mSavedFragmentState), null, this.f8620c.mSavedFragmentState);
            View view = this.f8620c.mView;
            if (view != null) {
                view.setSaveFromParentEnabled(false);
                Fragment fragment3 = this.f8620c;
                fragment3.mView.setTag(R$id.fragment_container_view_tag, fragment3);
                Fragment fragment4 = this.f8620c;
                if (fragment4.mHidden) {
                    fragment4.mView.setVisibility(8);
                }
                this.f8620c.performViewCreated();
                k kVar = this.f8618a;
                Fragment fragment5 = this.f8620c;
                kVar.m(fragment5, fragment5.mView, fragment5.mSavedFragmentState, false);
                this.f8620c.mState = 2;
            }
        }
    }

    @NonNull
    public Fragment k() {
        return this.f8620c;
    }

    public final boolean l(@NonNull View view) {
        if (view == this.f8620c.mView) {
            return true;
        }
        for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
            if (parent == this.f8620c.mView) {
                return true;
            }
        }
        return false;
    }

    public void m() {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        ViewGroup viewGroup3;
        if (this.f8621d) {
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v(FragmentManager.TAG, "Ignoring re-entrant call to moveToExpectedState() for " + k());
                return;
            }
            return;
        }
        try {
            this.f8621d = true;
            boolean z11 = false;
            while (true) {
                int iD = d();
                Fragment fragment = this.f8620c;
                int i11 = fragment.mState;
                if (iD == i11) {
                    if (!z11 && i11 == -1 && fragment.mRemoving && !fragment.isInBackStack() && !this.f8620c.mBeingSaved) {
                        if (FragmentManager.isLoggingEnabled(3)) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("Cleaning up state of never attached fragment: ");
                            sb2.append(this.f8620c);
                        }
                        this.f8619b.q().c(this.f8620c);
                        this.f8619b.t(this);
                        if (FragmentManager.isLoggingEnabled(3)) {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("initState called for fragment: ");
                            sb3.append(this.f8620c);
                        }
                        this.f8620c.initState();
                    }
                    Fragment fragment2 = this.f8620c;
                    if (fragment2.mHiddenChanged) {
                        if (fragment2.mView != null && (viewGroup = fragment2.mContainer) != null) {
                            SpecialEffectsController specialEffectsControllerN = SpecialEffectsController.n(viewGroup, fragment2.getParentFragmentManager());
                            if (this.f8620c.mHidden) {
                                specialEffectsControllerN.c(this);
                            } else {
                                specialEffectsControllerN.e(this);
                            }
                        }
                        Fragment fragment3 = this.f8620c;
                        FragmentManager fragmentManager = fragment3.mFragmentManager;
                        if (fragmentManager != null) {
                            fragmentManager.invalidateMenuForFragment(fragment3);
                        }
                        Fragment fragment4 = this.f8620c;
                        fragment4.mHiddenChanged = false;
                        fragment4.onHiddenChanged(fragment4.mHidden);
                        this.f8620c.mChildFragmentManager.dispatchOnHiddenChanged();
                    }
                    return;
                }
                if (iD <= i11) {
                    switch (i11 - 1) {
                        case -1:
                            i();
                            break;
                        case 0:
                            if (fragment.mBeingSaved && this.f8619b.r(fragment.mWho) == null) {
                                s();
                            }
                            g();
                            break;
                        case 1:
                            h();
                            this.f8620c.mState = 1;
                            break;
                        case 2:
                            fragment.mInLayout = false;
                            fragment.mState = 2;
                            break;
                        case 3:
                            if (FragmentManager.isLoggingEnabled(3)) {
                                StringBuilder sb4 = new StringBuilder();
                                sb4.append("movefrom ACTIVITY_CREATED: ");
                                sb4.append(this.f8620c);
                            }
                            Fragment fragment5 = this.f8620c;
                            if (fragment5.mBeingSaved) {
                                s();
                            } else if (fragment5.mView != null && fragment5.mSavedViewState == null) {
                                t();
                            }
                            Fragment fragment6 = this.f8620c;
                            if (fragment6.mView != null && (viewGroup2 = fragment6.mContainer) != null) {
                                SpecialEffectsController.n(viewGroup2, fragment6.getParentFragmentManager()).d(this);
                            }
                            this.f8620c.mState = 3;
                            break;
                        case 4:
                            w();
                            break;
                        case 5:
                            fragment.mState = 5;
                            break;
                        case 6:
                            n();
                            break;
                    }
                } else {
                    switch (i11 + 1) {
                        case 0:
                            c();
                            break;
                        case 1:
                            e();
                            break;
                        case 2:
                            j();
                            f();
                            break;
                        case 3:
                            a();
                            break;
                        case 4:
                            if (fragment.mView != null && (viewGroup3 = fragment.mContainer) != null) {
                                SpecialEffectsController.n(viewGroup3, fragment.getParentFragmentManager()).b(SpecialEffectsController.Operation.State.from(this.f8620c.mView.getVisibility()), this);
                            }
                            this.f8620c.mState = 4;
                            break;
                        case 5:
                            v();
                            break;
                        case 6:
                            fragment.mState = 6;
                            break;
                        case 7:
                            p();
                            break;
                    }
                }
                z11 = true;
            }
        } finally {
            this.f8621d = false;
        }
    }

    public void n() {
        if (FragmentManager.isLoggingEnabled(3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("movefrom RESUMED: ");
            sb2.append(this.f8620c);
        }
        this.f8620c.performPause();
        this.f8618a.f(this.f8620c, false);
    }

    public void o(@NonNull ClassLoader classLoader) {
        Bundle bundle = this.f8620c.mSavedFragmentState;
        if (bundle == null) {
            return;
        }
        bundle.setClassLoader(classLoader);
        Fragment fragment = this.f8620c;
        fragment.mSavedViewState = fragment.mSavedFragmentState.getSparseParcelableArray("android:view_state");
        Fragment fragment2 = this.f8620c;
        fragment2.mSavedViewRegistryState = fragment2.mSavedFragmentState.getBundle("android:view_registry_state");
        Fragment fragment3 = this.f8620c;
        fragment3.mTargetWho = fragment3.mSavedFragmentState.getString("android:target_state");
        Fragment fragment4 = this.f8620c;
        if (fragment4.mTargetWho != null) {
            fragment4.mTargetRequestCode = fragment4.mSavedFragmentState.getInt("android:target_req_state", 0);
        }
        Fragment fragment5 = this.f8620c;
        Boolean bool = fragment5.mSavedUserVisibleHint;
        if (bool != null) {
            fragment5.mUserVisibleHint = bool.booleanValue();
            this.f8620c.mSavedUserVisibleHint = null;
        } else {
            fragment5.mUserVisibleHint = fragment5.mSavedFragmentState.getBoolean("android:user_visible_hint", true);
        }
        Fragment fragment6 = this.f8620c;
        if (fragment6.mUserVisibleHint) {
            return;
        }
        fragment6.mDeferStart = true;
    }

    public void p() {
        if (FragmentManager.isLoggingEnabled(3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("moveto RESUMED: ");
            sb2.append(this.f8620c);
        }
        View focusedView = this.f8620c.getFocusedView();
        if (focusedView != null && l(focusedView)) {
            boolean zRequestFocus = focusedView.requestFocus();
            if (FragmentManager.isLoggingEnabled(2)) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("requestFocus: Restoring focused view ");
                sb3.append(focusedView);
                sb3.append(" ");
                sb3.append(zRequestFocus ? "succeeded" : "failed");
                sb3.append(" on Fragment ");
                sb3.append(this.f8620c);
                sb3.append(" resulting in focused view ");
                sb3.append(this.f8620c.mView.findFocus());
                Log.v(FragmentManager.TAG, sb3.toString());
            }
        }
        this.f8620c.setFocusedView(null);
        this.f8620c.performResume();
        this.f8618a.i(this.f8620c, false);
        Fragment fragment = this.f8620c;
        fragment.mSavedFragmentState = null;
        fragment.mSavedViewState = null;
        fragment.mSavedViewRegistryState = null;
    }

    public final Bundle q() {
        Bundle bundle = new Bundle();
        this.f8620c.performSaveInstanceState(bundle);
        this.f8618a.j(this.f8620c, bundle, false);
        if (bundle.isEmpty()) {
            bundle = null;
        }
        if (this.f8620c.mView != null) {
            t();
        }
        if (this.f8620c.mSavedViewState != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", this.f8620c.mSavedViewState);
        }
        if (this.f8620c.mSavedViewRegistryState != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBundle("android:view_registry_state", this.f8620c.mSavedViewRegistryState);
        }
        if (!this.f8620c.mUserVisibleHint) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", this.f8620c.mUserVisibleHint);
        }
        return bundle;
    }

    @Nullable
    public Fragment.SavedState r() {
        Bundle bundleQ;
        if (this.f8620c.mState <= -1 || (bundleQ = q()) == null) {
            return null;
        }
        return new Fragment.SavedState(bundleQ);
    }

    public void s() {
        FragmentState fragmentState = new FragmentState(this.f8620c);
        Fragment fragment = this.f8620c;
        if (fragment.mState <= -1 || fragmentState.f8521n != null) {
            fragmentState.f8521n = fragment.mSavedFragmentState;
        } else {
            Bundle bundleQ = q();
            fragmentState.f8521n = bundleQ;
            if (this.f8620c.mTargetWho != null) {
                if (bundleQ == null) {
                    fragmentState.f8521n = new Bundle();
                }
                fragmentState.f8521n.putString("android:target_state", this.f8620c.mTargetWho);
                int i11 = this.f8620c.mTargetRequestCode;
                if (i11 != 0) {
                    fragmentState.f8521n.putInt("android:target_req_state", i11);
                }
            }
        }
        this.f8619b.C(this.f8620c.mWho, fragmentState);
    }

    public void t() {
        if (this.f8620c.mView == null) {
            return;
        }
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v(FragmentManager.TAG, "Saving view state for fragment " + this.f8620c + " with view " + this.f8620c.mView);
        }
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        this.f8620c.mView.saveHierarchyState(sparseArray);
        if (sparseArray.size() > 0) {
            this.f8620c.mSavedViewState = sparseArray;
        }
        Bundle bundle = new Bundle();
        this.f8620c.mViewLifecycleOwner.e(bundle);
        if (bundle.isEmpty()) {
            return;
        }
        this.f8620c.mSavedViewRegistryState = bundle;
    }

    public void u(int i11) {
        this.f8622e = i11;
    }

    public void v() {
        if (FragmentManager.isLoggingEnabled(3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("moveto STARTED: ");
            sb2.append(this.f8620c);
        }
        this.f8620c.performStart();
        this.f8618a.k(this.f8620c, false);
    }

    public void w() {
        if (FragmentManager.isLoggingEnabled(3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("movefrom STARTED: ");
            sb2.append(this.f8620c);
        }
        this.f8620c.performStop();
        this.f8618a.l(this.f8620c, false);
    }
}
