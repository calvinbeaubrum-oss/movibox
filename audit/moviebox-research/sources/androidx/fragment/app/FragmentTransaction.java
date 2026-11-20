package androidx.fragment.app;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.lifecycle.Lifecycle;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class FragmentTransaction {
    static final int OP_ADD = 1;
    static final int OP_ATTACH = 7;
    static final int OP_DETACH = 6;
    static final int OP_HIDE = 4;
    static final int OP_NULL = 0;
    static final int OP_REMOVE = 3;
    static final int OP_REPLACE = 2;
    static final int OP_SET_MAX_LIFECYCLE = 10;
    static final int OP_SET_PRIMARY_NAV = 8;
    static final int OP_SHOW = 5;
    static final int OP_UNSET_PRIMARY_NAV = 9;
    public static final int TRANSIT_ENTER_MASK = 4096;
    public static final int TRANSIT_EXIT_MASK = 8192;
    public static final int TRANSIT_FRAGMENT_CLOSE = 8194;
    public static final int TRANSIT_FRAGMENT_FADE = 4099;
    public static final int TRANSIT_FRAGMENT_MATCH_ACTIVITY_CLOSE = 8197;
    public static final int TRANSIT_FRAGMENT_MATCH_ACTIVITY_OPEN = 4100;
    public static final int TRANSIT_FRAGMENT_OPEN = 4097;
    public static final int TRANSIT_NONE = 0;
    public static final int TRANSIT_UNSET = -1;
    boolean mAddToBackStack;
    boolean mAllowAddToBackStack;
    int mBreadCrumbShortTitleRes;
    CharSequence mBreadCrumbShortTitleText;
    int mBreadCrumbTitleRes;
    CharSequence mBreadCrumbTitleText;
    private final ClassLoader mClassLoader;
    ArrayList<Runnable> mCommitRunnables;
    int mEnterAnim;
    int mExitAnim;
    private final h mFragmentFactory;

    @Nullable
    String mName;
    ArrayList<a> mOps;
    int mPopEnterAnim;
    int mPopExitAnim;
    boolean mReorderingAllowed;
    ArrayList<String> mSharedElementSourceNames;
    ArrayList<String> mSharedElementTargetNames;
    int mTransition;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8536a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Fragment f8537b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f8538c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f8539d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f8540e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f8541f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f8542g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Lifecycle.State f8543h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public Lifecycle.State f8544i;

        public a() {
        }

        public a(int i11, Fragment fragment) {
            this.f8536a = i11;
            this.f8537b = fragment;
            this.f8538c = false;
            Lifecycle.State state = Lifecycle.State.RESUMED;
            this.f8543h = state;
            this.f8544i = state;
        }

        public a(int i11, @NonNull Fragment fragment, Lifecycle.State state) {
            this.f8536a = i11;
            this.f8537b = fragment;
            this.f8538c = false;
            this.f8543h = fragment.mMaxState;
            this.f8544i = state;
        }

        public a(int i11, Fragment fragment, boolean z11) {
            this.f8536a = i11;
            this.f8537b = fragment;
            this.f8538c = z11;
            Lifecycle.State state = Lifecycle.State.RESUMED;
            this.f8543h = state;
            this.f8544i = state;
        }

        public a(a aVar) {
            this.f8536a = aVar.f8536a;
            this.f8537b = aVar.f8537b;
            this.f8538c = aVar.f8538c;
            this.f8539d = aVar.f8539d;
            this.f8540e = aVar.f8540e;
            this.f8541f = aVar.f8541f;
            this.f8542g = aVar.f8542g;
            this.f8543h = aVar.f8543h;
            this.f8544i = aVar.f8544i;
        }
    }

    @Deprecated
    public FragmentTransaction() {
        this.mOps = new ArrayList<>();
        this.mAllowAddToBackStack = true;
        this.mReorderingAllowed = false;
        this.mFragmentFactory = null;
        this.mClassLoader = null;
    }

    public FragmentTransaction(@NonNull h hVar, @Nullable ClassLoader classLoader) {
        this.mOps = new ArrayList<>();
        this.mAllowAddToBackStack = true;
        this.mReorderingAllowed = false;
        this.mFragmentFactory = hVar;
        this.mClassLoader = classLoader;
    }

    public FragmentTransaction(@NonNull h hVar, @Nullable ClassLoader classLoader, @NonNull FragmentTransaction fragmentTransaction) {
        this(hVar, classLoader);
        Iterator<a> it = fragmentTransaction.mOps.iterator();
        while (it.hasNext()) {
            this.mOps.add(new a(it.next()));
        }
        this.mEnterAnim = fragmentTransaction.mEnterAnim;
        this.mExitAnim = fragmentTransaction.mExitAnim;
        this.mPopEnterAnim = fragmentTransaction.mPopEnterAnim;
        this.mPopExitAnim = fragmentTransaction.mPopExitAnim;
        this.mTransition = fragmentTransaction.mTransition;
        this.mAddToBackStack = fragmentTransaction.mAddToBackStack;
        this.mAllowAddToBackStack = fragmentTransaction.mAllowAddToBackStack;
        this.mName = fragmentTransaction.mName;
        this.mBreadCrumbShortTitleRes = fragmentTransaction.mBreadCrumbShortTitleRes;
        this.mBreadCrumbShortTitleText = fragmentTransaction.mBreadCrumbShortTitleText;
        this.mBreadCrumbTitleRes = fragmentTransaction.mBreadCrumbTitleRes;
        this.mBreadCrumbTitleText = fragmentTransaction.mBreadCrumbTitleText;
        if (fragmentTransaction.mSharedElementSourceNames != null) {
            ArrayList<String> arrayList = new ArrayList<>();
            this.mSharedElementSourceNames = arrayList;
            arrayList.addAll(fragmentTransaction.mSharedElementSourceNames);
        }
        if (fragmentTransaction.mSharedElementTargetNames != null) {
            ArrayList<String> arrayList2 = new ArrayList<>();
            this.mSharedElementTargetNames = arrayList2;
            arrayList2.addAll(fragmentTransaction.mSharedElementTargetNames);
        }
        this.mReorderingAllowed = fragmentTransaction.mReorderingAllowed;
    }

    @NonNull
    private Fragment createFragment(@NonNull Class<? extends Fragment> cls, @Nullable Bundle bundle) {
        h hVar = this.mFragmentFactory;
        if (hVar == null) {
            throw new IllegalStateException("Creating a Fragment requires that this FragmentTransaction was built with FragmentManager.beginTransaction()");
        }
        ClassLoader classLoader = this.mClassLoader;
        if (classLoader == null) {
            throw new IllegalStateException("The FragmentManager must be attached to itshost to create a Fragment");
        }
        Fragment fragmentInstantiate = hVar.instantiate(classLoader, cls.getName());
        if (bundle != null) {
            fragmentInstantiate.setArguments(bundle);
        }
        return fragmentInstantiate;
    }

    @NonNull
    public FragmentTransaction add(int i11, @NonNull Fragment fragment) {
        doAddOp(i11, fragment, null, 1);
        return this;
    }

    @NonNull
    public FragmentTransaction add(int i11, @NonNull Fragment fragment, @Nullable String str) {
        doAddOp(i11, fragment, str, 1);
        return this;
    }

    @NonNull
    public final FragmentTransaction add(int i11, @NonNull Class<? extends Fragment> cls, @Nullable Bundle bundle) {
        return add(i11, createFragment(cls, bundle));
    }

    @NonNull
    public final FragmentTransaction add(int i11, @NonNull Class<? extends Fragment> cls, @Nullable Bundle bundle, @Nullable String str) {
        return add(i11, createFragment(cls, bundle), str);
    }

    public FragmentTransaction add(@NonNull ViewGroup viewGroup, @NonNull Fragment fragment, @Nullable String str) {
        fragment.mContainer = viewGroup;
        return add(viewGroup.getId(), fragment, str);
    }

    @NonNull
    public FragmentTransaction add(@NonNull Fragment fragment, @Nullable String str) {
        doAddOp(0, fragment, str, 1);
        return this;
    }

    @NonNull
    public final FragmentTransaction add(@NonNull Class<? extends Fragment> cls, @Nullable Bundle bundle, @Nullable String str) {
        return add(createFragment(cls, bundle), str);
    }

    public void addOp(a aVar) {
        this.mOps.add(aVar);
        aVar.f8539d = this.mEnterAnim;
        aVar.f8540e = this.mExitAnim;
        aVar.f8541f = this.mPopEnterAnim;
        aVar.f8542g = this.mPopExitAnim;
    }

    @NonNull
    public FragmentTransaction addSharedElement(@NonNull View view, @NonNull String str) {
        if (x.e()) {
            String transitionName = ViewCompat.getTransitionName(view);
            if (transitionName == null) {
                throw new IllegalArgumentException("Unique transitionNames are required for all sharedElements");
            }
            if (this.mSharedElementSourceNames == null) {
                this.mSharedElementSourceNames = new ArrayList<>();
                this.mSharedElementTargetNames = new ArrayList<>();
            } else {
                if (this.mSharedElementTargetNames.contains(str)) {
                    throw new IllegalArgumentException("A shared element with the target name '" + str + "' has already been added to the transaction.");
                }
                if (this.mSharedElementSourceNames.contains(transitionName)) {
                    throw new IllegalArgumentException("A shared element with the source name '" + transitionName + "' has already been added to the transaction.");
                }
            }
            this.mSharedElementSourceNames.add(transitionName);
            this.mSharedElementTargetNames.add(str);
        }
        return this;
    }

    @NonNull
    public FragmentTransaction addToBackStack(@Nullable String str) {
        if (!this.mAllowAddToBackStack) {
            throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
        }
        this.mAddToBackStack = true;
        this.mName = str;
        return this;
    }

    @NonNull
    public FragmentTransaction attach(@NonNull Fragment fragment) {
        addOp(new a(7, fragment));
        return this;
    }

    public abstract int commit();

    public abstract int commitAllowingStateLoss();

    public abstract void commitNow();

    public abstract void commitNowAllowingStateLoss();

    @NonNull
    public FragmentTransaction detach(@NonNull Fragment fragment) {
        addOp(new a(6, fragment));
        return this;
    }

    @NonNull
    public FragmentTransaction disallowAddToBackStack() {
        if (this.mAddToBackStack) {
            throw new IllegalStateException("This transaction is already being added to the back stack");
        }
        this.mAllowAddToBackStack = false;
        return this;
    }

    public void doAddOp(int i11, Fragment fragment, @Nullable String str, int i12) {
        String str2 = fragment.mPreviousWho;
        if (str2 != null) {
            FragmentStrictMode.f(fragment, str2);
        }
        Class<?> cls = fragment.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
        }
        if (str != null) {
            String str3 = fragment.mTag;
            if (str3 != null && !str.equals(str3)) {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.mTag + " now " + str);
            }
            fragment.mTag = str;
        }
        if (i11 != 0) {
            if (i11 == -1) {
                throw new IllegalArgumentException("Can't add fragment " + fragment + " with tag " + str + " to container view with no id");
            }
            int i13 = fragment.mFragmentId;
            if (i13 != 0 && i13 != i11) {
                throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.mFragmentId + " now " + i11);
            }
            fragment.mFragmentId = i11;
            fragment.mContainerId = i11;
        }
        addOp(new a(i12, fragment));
    }

    @NonNull
    public FragmentTransaction hide(@NonNull Fragment fragment) {
        addOp(new a(4, fragment));
        return this;
    }

    public boolean isAddToBackStackAllowed() {
        return this.mAllowAddToBackStack;
    }

    public boolean isEmpty() {
        return this.mOps.isEmpty();
    }

    @NonNull
    public FragmentTransaction remove(@NonNull Fragment fragment) {
        addOp(new a(3, fragment));
        return this;
    }

    @NonNull
    public FragmentTransaction replace(int i11, @NonNull Fragment fragment) {
        return replace(i11, fragment, (String) null);
    }

    @NonNull
    public FragmentTransaction replace(int i11, @NonNull Fragment fragment, @Nullable String str) {
        if (i11 == 0) {
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        }
        doAddOp(i11, fragment, str, 2);
        return this;
    }

    @NonNull
    public final FragmentTransaction replace(int i11, @NonNull Class<? extends Fragment> cls, @Nullable Bundle bundle) {
        return replace(i11, cls, bundle, null);
    }

    @NonNull
    public final FragmentTransaction replace(int i11, @NonNull Class<? extends Fragment> cls, @Nullable Bundle bundle, @Nullable String str) {
        return replace(i11, createFragment(cls, bundle), str);
    }

    @NonNull
    public FragmentTransaction runOnCommit(@NonNull Runnable runnable) {
        disallowAddToBackStack();
        if (this.mCommitRunnables == null) {
            this.mCommitRunnables = new ArrayList<>();
        }
        this.mCommitRunnables.add(runnable);
        return this;
    }

    @NonNull
    @Deprecated
    public FragmentTransaction setAllowOptimization(boolean z11) {
        return setReorderingAllowed(z11);
    }

    @NonNull
    @Deprecated
    public FragmentTransaction setBreadCrumbShortTitle(@StringRes int i11) {
        this.mBreadCrumbShortTitleRes = i11;
        this.mBreadCrumbShortTitleText = null;
        return this;
    }

    @NonNull
    @Deprecated
    public FragmentTransaction setBreadCrumbShortTitle(@Nullable CharSequence charSequence) {
        this.mBreadCrumbShortTitleRes = 0;
        this.mBreadCrumbShortTitleText = charSequence;
        return this;
    }

    @NonNull
    @Deprecated
    public FragmentTransaction setBreadCrumbTitle(@StringRes int i11) {
        this.mBreadCrumbTitleRes = i11;
        this.mBreadCrumbTitleText = null;
        return this;
    }

    @NonNull
    @Deprecated
    public FragmentTransaction setBreadCrumbTitle(@Nullable CharSequence charSequence) {
        this.mBreadCrumbTitleRes = 0;
        this.mBreadCrumbTitleText = charSequence;
        return this;
    }

    @NonNull
    public FragmentTransaction setCustomAnimations(int i11, int i12) {
        return setCustomAnimations(i11, i12, 0, 0);
    }

    @NonNull
    public FragmentTransaction setCustomAnimations(int i11, int i12, int i13, int i14) {
        this.mEnterAnim = i11;
        this.mExitAnim = i12;
        this.mPopEnterAnim = i13;
        this.mPopExitAnim = i14;
        return this;
    }

    @NonNull
    public FragmentTransaction setMaxLifecycle(@NonNull Fragment fragment, @NonNull Lifecycle.State state) {
        addOp(new a(10, fragment, state));
        return this;
    }

    @NonNull
    public FragmentTransaction setPrimaryNavigationFragment(@Nullable Fragment fragment) {
        addOp(new a(8, fragment));
        return this;
    }

    @NonNull
    public FragmentTransaction setReorderingAllowed(boolean z11) {
        this.mReorderingAllowed = z11;
        return this;
    }

    @NonNull
    public FragmentTransaction setTransition(int i11) {
        this.mTransition = i11;
        return this;
    }

    @NonNull
    @Deprecated
    public FragmentTransaction setTransitionStyle(int i11) {
        return this;
    }

    @NonNull
    public FragmentTransaction show(@NonNull Fragment fragment) {
        addOp(new a(5, fragment));
        return this;
    }
}
