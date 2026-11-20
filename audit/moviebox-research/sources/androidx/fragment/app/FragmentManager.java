package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.IntentSenderRequest;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.MenuHost;
import androidx.core.view.MenuProvider;
import androidx.fragment.R$id;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.x0;
import androidx.lifecycle.y0;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class FragmentManager {
    private static boolean DEBUG = false;
    private static final String EXTRA_CREATED_FILLIN_INTENT = "androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE";
    static final String FRAGMENT_MANAGER_STATE_TAG = "state";
    static final String FRAGMENT_NAME_PREFIX = "fragment_";
    static final String FRAGMENT_STATE_TAG = "state";
    public static final int POP_BACK_STACK_INCLUSIVE = 1;
    static final String RESULT_NAME_PREFIX = "result_";
    static final String SAVED_STATE_TAG = "android:support:fragments";
    public static final String TAG = "FragmentManager";
    ArrayList<androidx.fragment.app.a> mBackStack;
    private ArrayList<o> mBackStackChangeListeners;
    private androidx.fragment.app.f mContainer;
    private ArrayList<Fragment> mCreatedMenus;
    private boolean mDestroyed;
    private boolean mExecutingActions;
    private boolean mHavePendingDeferredStart;
    private androidx.fragment.app.i<?> mHost;
    private boolean mNeedMenuInvalidate;
    private androidx.fragment.app.s mNonConfig;
    private OnBackPressedDispatcher mOnBackPressedDispatcher;
    private Fragment mParent;

    @Nullable
    Fragment mPrimaryNav;
    private b1.b<String[]> mRequestPermissions;
    private b1.b<Intent> mStartActivityForResult;
    private b1.b<IntentSenderRequest> mStartIntentSenderForResult;
    private boolean mStateSaved;
    private boolean mStopped;
    private FragmentStrictMode.b mStrictModePolicy;
    private ArrayList<Fragment> mTmpAddedFragments;
    private ArrayList<Boolean> mTmpIsPop;
    private ArrayList<androidx.fragment.app.a> mTmpRecords;
    private final ArrayList<p> mPendingActions = new ArrayList<>();
    private final w mFragmentStore = new w();
    private final androidx.fragment.app.j mLayoutInflaterFactory = new androidx.fragment.app.j(this);
    private final androidx.activity.p mOnBackPressedCallback = new b(false);
    private final AtomicInteger mBackStackIndex = new AtomicInteger();
    private final Map<String, BackStackState> mBackStackStates = Collections.synchronizedMap(new HashMap());
    private final Map<String, Bundle> mResults = Collections.synchronizedMap(new HashMap());
    private final Map<String, n> mResultListeners = Collections.synchronizedMap(new HashMap());
    private final androidx.fragment.app.k mLifecycleCallbacksDispatcher = new androidx.fragment.app.k(this);
    private final CopyOnWriteArrayList<t> mOnAttachListeners = new CopyOnWriteArrayList<>();
    private final androidx.core.util.a<Configuration> mOnConfigurationChangedListener = new androidx.core.util.a() { // from class: androidx.fragment.app.l
        @Override // androidx.core.util.a
        public final void accept(Object obj) {
            this.f8596a.lambda$new$0((Configuration) obj);
        }
    };
    private final androidx.core.util.a<Integer> mOnTrimMemoryListener = new androidx.core.util.a() { // from class: androidx.fragment.app.m
        @Override // androidx.core.util.a
        public final void accept(Object obj) {
            this.f8597a.lambda$new$1((Integer) obj);
        }
    };
    private final androidx.core.util.a<androidx.core.app.l> mOnMultiWindowModeChangedListener = new androidx.core.util.a() { // from class: androidx.fragment.app.n
        @Override // androidx.core.util.a
        public final void accept(Object obj) {
            this.f8598a.lambda$new$2((androidx.core.app.l) obj);
        }
    };
    private final androidx.core.util.a<androidx.core.app.b0> mOnPictureInPictureModeChangedListener = new androidx.core.util.a() { // from class: androidx.fragment.app.o
        @Override // androidx.core.util.a
        public final void accept(Object obj) {
            this.f8599a.lambda$new$3((androidx.core.app.b0) obj);
        }
    };
    private final MenuProvider mMenuProvider = new c();
    int mCurState = -1;
    private androidx.fragment.app.h mFragmentFactory = null;
    private androidx.fragment.app.h mHostFragmentFactory = new d();
    private b0 mSpecialEffectsControllerFactory = null;
    private b0 mDefaultSpecialEffectsControllerFactory = new e();
    ArrayDeque<LaunchedFragmentInfo> mLaunchedFragments = new ArrayDeque<>();
    private Runnable mExecCommit = new Runnable() { // from class: androidx.fragment.app.FragmentManager.5
        @Override // java.lang.Runnable
        public void run() {
            FragmentManager.this.execPendingActions(true);
        }
    };

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    @SuppressLint({"BanParcelableUsage"})
    public static class LaunchedFragmentInfo implements Parcelable {
        public static final Parcelable.Creator<LaunchedFragmentInfo> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f8473a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f8474b;

        /* JADX INFO: compiled from: source.java */
        public class a implements Parcelable.Creator<LaunchedFragmentInfo> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public LaunchedFragmentInfo createFromParcel(Parcel parcel) {
                return new LaunchedFragmentInfo(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public LaunchedFragmentInfo[] newArray(int i11) {
                return new LaunchedFragmentInfo[i11];
            }
        }

        public LaunchedFragmentInfo(@NonNull Parcel parcel) {
            this.f8473a = parcel.readString();
            this.f8474b = parcel.readInt();
        }

        public LaunchedFragmentInfo(@NonNull String str, int i11) {
            this.f8473a = str;
            this.f8474b = i11;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i11) {
            parcel.writeString(this.f8473a);
            parcel.writeInt(this.f8474b);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public class a implements b1.a<Map<String, Boolean>> {
        public a() {
        }

        @Override // b1.a
        @SuppressLint({"SyntheticAccessor"})
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Map<String, Boolean> map) {
            String[] strArr = (String[]) map.keySet().toArray(new String[0]);
            ArrayList arrayList = new ArrayList(map.values());
            int[] iArr = new int[arrayList.size()];
            for (int i11 = 0; i11 < arrayList.size(); i11++) {
                iArr[i11] = ((Boolean) arrayList.get(i11)).booleanValue() ? 0 : -1;
            }
            LaunchedFragmentInfo launchedFragmentInfoPollFirst = FragmentManager.this.mLaunchedFragments.pollFirst();
            if (launchedFragmentInfoPollFirst == null) {
                Log.w(FragmentManager.TAG, "No permissions were requested for " + this);
                return;
            }
            String str = launchedFragmentInfoPollFirst.f8473a;
            int i12 = launchedFragmentInfoPollFirst.f8474b;
            Fragment fragmentI = FragmentManager.this.mFragmentStore.i(str);
            if (fragmentI != null) {
                fragmentI.onRequestPermissionsResult(i12, strArr, iArr);
                return;
            }
            Log.w(FragmentManager.TAG, "Permission request result delivered for unknown Fragment " + str);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public class b extends androidx.activity.p {
        public b(boolean z11) {
            super(z11);
        }

        @Override // androidx.activity.p
        public void handleOnBackPressed() {
            FragmentManager.this.handleOnBackPressed();
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public class c implements MenuProvider {
        public c() {
        }

        @Override // androidx.core.view.MenuProvider
        public void onCreateMenu(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
            FragmentManager.this.dispatchCreateOptionsMenu(menu, menuInflater);
        }

        @Override // androidx.core.view.MenuProvider
        public void onMenuClosed(@NonNull Menu menu) {
            FragmentManager.this.dispatchOptionsMenuClosed(menu);
        }

        @Override // androidx.core.view.MenuProvider
        public boolean onMenuItemSelected(@NonNull MenuItem menuItem) {
            return FragmentManager.this.dispatchOptionsItemSelected(menuItem);
        }

        @Override // androidx.core.view.MenuProvider
        public void onPrepareMenu(@NonNull Menu menu) {
            FragmentManager.this.dispatchPrepareOptionsMenu(menu);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public class d extends androidx.fragment.app.h {
        public d() {
        }

        @Override // androidx.fragment.app.h
        @NonNull
        public Fragment instantiate(@NonNull ClassLoader classLoader, @NonNull String str) {
            return FragmentManager.this.getHost().b(FragmentManager.this.getHost().f(), str, null);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public class e implements b0 {
        public e() {
        }

        @Override // androidx.fragment.app.b0
        @NonNull
        public SpecialEffectsController a(@NonNull ViewGroup viewGroup) {
            return new DefaultSpecialEffectsController(viewGroup);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class f implements androidx.lifecycle.r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f8480a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ u f8481b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Lifecycle f8482c;

        public f(String str, u uVar, Lifecycle lifecycle) {
            this.f8480a = str;
            this.f8481b = uVar;
            this.f8482c = lifecycle;
        }

        @Override // androidx.lifecycle.r
        public void onStateChanged(@NonNull androidx.lifecycle.u uVar, @NonNull Lifecycle.Event event) {
            Bundle bundle;
            if (event == Lifecycle.Event.ON_START && (bundle = (Bundle) FragmentManager.this.mResults.get(this.f8480a)) != null) {
                this.f8481b.a(this.f8480a, bundle);
                FragmentManager.this.clearFragmentResult(this.f8480a);
            }
            if (event == Lifecycle.Event.ON_DESTROY) {
                this.f8482c.d(this);
                FragmentManager.this.mResultListeners.remove(this.f8480a);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public class g implements t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Fragment f8484a;

        public g(Fragment fragment) {
            this.f8484a = fragment;
        }

        @Override // androidx.fragment.app.t
        public void a(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
            this.f8484a.onAttachFragment(fragment);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public class h implements b1.a<ActivityResult> {
        public h() {
        }

        @Override // b1.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(ActivityResult activityResult) {
            LaunchedFragmentInfo launchedFragmentInfoPollFirst = FragmentManager.this.mLaunchedFragments.pollFirst();
            if (launchedFragmentInfoPollFirst == null) {
                Log.w(FragmentManager.TAG, "No Activities were started for result for " + this);
                return;
            }
            String str = launchedFragmentInfoPollFirst.f8473a;
            int i11 = launchedFragmentInfoPollFirst.f8474b;
            Fragment fragmentI = FragmentManager.this.mFragmentStore.i(str);
            if (fragmentI != null) {
                fragmentI.onActivityResult(i11, activityResult.getResultCode(), activityResult.getData());
                return;
            }
            Log.w(FragmentManager.TAG, "Activity result delivered for unknown Fragment " + str);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public class i implements b1.a<ActivityResult> {
        public i() {
        }

        @Override // b1.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(ActivityResult activityResult) {
            LaunchedFragmentInfo launchedFragmentInfoPollFirst = FragmentManager.this.mLaunchedFragments.pollFirst();
            if (launchedFragmentInfoPollFirst == null) {
                Log.w(FragmentManager.TAG, "No IntentSenders were started for " + this);
                return;
            }
            String str = launchedFragmentInfoPollFirst.f8473a;
            int i11 = launchedFragmentInfoPollFirst.f8474b;
            Fragment fragmentI = FragmentManager.this.mFragmentStore.i(str);
            if (fragmentI != null) {
                fragmentI.onActivityResult(i11, activityResult.getResultCode(), activityResult.getData());
                return;
            }
            Log.w(FragmentManager.TAG, "Intent Sender result delivered for unknown Fragment " + str);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public interface j {
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public class k implements p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f8488a;

        public k(String str) {
            this.f8488a = str;
        }

        @Override // androidx.fragment.app.FragmentManager.p
        public boolean a(@NonNull ArrayList<androidx.fragment.app.a> arrayList, @NonNull ArrayList<Boolean> arrayList2) {
            return FragmentManager.this.clearBackStackState(arrayList, arrayList2, this.f8488a);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public static class l extends c1.a<IntentSenderRequest, ActivityResult> {
        @Override // c1.a
        @NonNull
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Intent a(@NonNull Context context, IntentSenderRequest intentSenderRequest) {
            Bundle bundleExtra;
            Intent intent = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST");
            Intent fillInIntent = intentSenderRequest.getFillInIntent();
            if (fillInIntent != null && (bundleExtra = fillInIntent.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) != null) {
                intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundleExtra);
                fillInIntent.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                if (fillInIntent.getBooleanExtra(FragmentManager.EXTRA_CREATED_FILLIN_INTENT, false)) {
                    intentSenderRequest = new IntentSenderRequest.a(intentSenderRequest.getIntentSender()).b(null).c(intentSenderRequest.getFlagsValues(), intentSenderRequest.getFlagsMask()).a();
                }
            }
            intent.putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", intentSenderRequest);
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v(FragmentManager.TAG, "CreateIntent created the following intent: " + intent);
            }
            return intent;
        }

        @Override // c1.a
        @NonNull
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public ActivityResult c(int i11, @Nullable Intent intent) {
            return new ActivityResult(i11, intent);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public static abstract class m {
        @Deprecated
        public void onFragmentActivityCreated(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @Nullable Bundle bundle) {
        }

        public void onFragmentAttached(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @NonNull Context context) {
        }

        public void onFragmentCreated(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @Nullable Bundle bundle) {
        }

        public void onFragmentDestroyed(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
        }

        public void onFragmentDetached(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
        }

        public void onFragmentPaused(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
        }

        public void onFragmentPreAttached(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @NonNull Context context) {
        }

        public void onFragmentPreCreated(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @Nullable Bundle bundle) {
        }

        public void onFragmentResumed(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
        }

        public void onFragmentSaveInstanceState(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @NonNull Bundle bundle) {
        }

        public void onFragmentStarted(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
        }

        public void onFragmentStopped(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
        }

        public void onFragmentViewCreated(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @NonNull View view, @Nullable Bundle bundle) {
        }

        public void onFragmentViewDestroyed(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public static class n implements u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Lifecycle f8490a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final u f8491b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final androidx.lifecycle.r f8492c;

        public n(@NonNull Lifecycle lifecycle, @NonNull u uVar, @NonNull androidx.lifecycle.r rVar) {
            this.f8490a = lifecycle;
            this.f8491b = uVar;
            this.f8492c = rVar;
        }

        @Override // androidx.fragment.app.u
        public void a(@NonNull String str, @NonNull Bundle bundle) {
            this.f8491b.a(str, bundle);
        }

        public boolean b(Lifecycle.State state) {
            return this.f8490a.b().isAtLeast(state);
        }

        public void c() {
            this.f8490a.d(this.f8492c);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public interface o {
        void a();
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public interface p {
        boolean a(@NonNull ArrayList<androidx.fragment.app.a> arrayList, @NonNull ArrayList<Boolean> arrayList2);
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public class q implements p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f8493a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f8494b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f8495c;

        public q(String str, int i11, int i12) {
            this.f8493a = str;
            this.f8494b = i11;
            this.f8495c = i12;
        }

        @Override // androidx.fragment.app.FragmentManager.p
        public boolean a(@NonNull ArrayList<androidx.fragment.app.a> arrayList, @NonNull ArrayList<Boolean> arrayList2) {
            Fragment fragment = FragmentManager.this.mPrimaryNav;
            if (fragment == null || this.f8494b >= 0 || this.f8493a != null || !fragment.getChildFragmentManager().popBackStackImmediate()) {
                return FragmentManager.this.popBackStackState(arrayList, arrayList2, this.f8493a, this.f8494b, this.f8495c);
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public class r implements p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f8497a;

        public r(String str) {
            this.f8497a = str;
        }

        @Override // androidx.fragment.app.FragmentManager.p
        public boolean a(@NonNull ArrayList<androidx.fragment.app.a> arrayList, @NonNull ArrayList<Boolean> arrayList2) {
            return FragmentManager.this.restoreBackStackState(arrayList, arrayList2, this.f8497a);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public class s implements p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f8499a;

        public s(String str) {
            this.f8499a = str;
        }

        @Override // androidx.fragment.app.FragmentManager.p
        public boolean a(@NonNull ArrayList<androidx.fragment.app.a> arrayList, @NonNull ArrayList<Boolean> arrayList2) {
            return FragmentManager.this.saveBackStackState(arrayList, arrayList2, this.f8499a);
        }
    }

    private void checkStateLoss() {
        if (isStateSaved()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }

    private void cleanupExec() {
        this.mExecutingActions = false;
        this.mTmpIsPop.clear();
        this.mTmpRecords.clear();
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0039  */
    /* JADX WARN: Code duplicated, block: B:15:0x004b A[LOOP:1: B:13:0x0045->B:15:0x004b, LOOP_END] */
    private void clearBackStackStateViewModels() {
        boolean zL;
        Iterator<BackStackState> it;
        Iterator<String> it2;
        androidx.fragment.app.i<?> iVar = this.mHost;
        if (!(iVar instanceof y0)) {
            if (iVar.f() instanceof Activity) {
                zL = !((Activity) this.mHost.f()).isChangingConfigurations();
            }
            it = this.mBackStackStates.values().iterator();
            while (it.hasNext()) {
                it2 = it.next().f8396a.iterator();
                while (it2.hasNext()) {
                    this.mFragmentStore.q().d(it2.next());
                }
            }
        }
        zL = this.mFragmentStore.q().l();
        if (!zL) {
            return;
        }
        it = this.mBackStackStates.values().iterator();
        while (it.hasNext()) {
            it2 = it.next().f8396a.iterator();
            while (it2.hasNext()) {
                this.mFragmentStore.q().d(it2.next());
            }
        }
    }

    private Set<SpecialEffectsController> collectAllSpecialEffectsController() {
        HashSet hashSet = new HashSet();
        Iterator<v> it = this.mFragmentStore.l().iterator();
        while (it.hasNext()) {
            ViewGroup viewGroup = it.next().k().mContainer;
            if (viewGroup != null) {
                hashSet.add(SpecialEffectsController.o(viewGroup, getSpecialEffectsControllerFactory()));
            }
        }
        return hashSet;
    }

    private Set<SpecialEffectsController> collectChangedControllers(@NonNull ArrayList<androidx.fragment.app.a> arrayList, int i11, int i12) {
        ViewGroup viewGroup;
        HashSet hashSet = new HashSet();
        while (i11 < i12) {
            Iterator<FragmentTransaction.a> it = arrayList.get(i11).mOps.iterator();
            while (it.hasNext()) {
                Fragment fragment = it.next().f8537b;
                if (fragment != null && (viewGroup = fragment.mContainer) != null) {
                    hashSet.add(SpecialEffectsController.n(viewGroup, this));
                }
            }
            i11++;
        }
        return hashSet;
    }

    private void dispatchParentPrimaryNavigationFragmentChanged(@Nullable Fragment fragment) {
        if (fragment == null || !fragment.equals(findActiveFragment(fragment.mWho))) {
            return;
        }
        fragment.performPrimaryNavigationFragmentChanged();
    }

    private void dispatchStateChange(int i11) {
        try {
            this.mExecutingActions = true;
            this.mFragmentStore.d(i11);
            moveToState(i11, false);
            Iterator<SpecialEffectsController> it = collectAllSpecialEffectsController().iterator();
            while (it.hasNext()) {
                it.next().j();
            }
            this.mExecutingActions = false;
            execPendingActions(true);
        } catch (Throwable th2) {
            this.mExecutingActions = false;
            throw th2;
        }
    }

    private void doPendingDeferredStart() {
        if (this.mHavePendingDeferredStart) {
            this.mHavePendingDeferredStart = false;
            startPendingDeferredFragments();
        }
    }

    @Deprecated
    public static void enableDebugLogging(boolean z11) {
        DEBUG = z11;
    }

    private void endAnimatingAwayFragments() {
        Iterator<SpecialEffectsController> it = collectAllSpecialEffectsController().iterator();
        while (it.hasNext()) {
            it.next().j();
        }
    }

    private void ensureExecReady(boolean z11) {
        if (this.mExecutingActions) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        }
        if (this.mHost == null) {
            if (!this.mDestroyed) {
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            }
            throw new IllegalStateException("FragmentManager has been destroyed");
        }
        if (Looper.myLooper() != this.mHost.g().getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
        if (!z11) {
            checkStateLoss();
        }
        if (this.mTmpRecords == null) {
            this.mTmpRecords = new ArrayList<>();
            this.mTmpIsPop = new ArrayList<>();
        }
    }

    private static void executeOps(@NonNull ArrayList<androidx.fragment.app.a> arrayList, @NonNull ArrayList<Boolean> arrayList2, int i11, int i12) {
        while (i11 < i12) {
            androidx.fragment.app.a aVar = arrayList.get(i11);
            if (arrayList2.get(i11).booleanValue()) {
                aVar.b(-1);
                aVar.h();
            } else {
                aVar.b(1);
                aVar.g();
            }
            i11++;
        }
    }

    private void executeOpsTogether(@NonNull ArrayList<androidx.fragment.app.a> arrayList, @NonNull ArrayList<Boolean> arrayList2, int i11, int i12) {
        boolean z11 = arrayList.get(i11).mReorderingAllowed;
        ArrayList<Fragment> arrayList3 = this.mTmpAddedFragments;
        if (arrayList3 == null) {
            this.mTmpAddedFragments = new ArrayList<>();
        } else {
            arrayList3.clear();
        }
        this.mTmpAddedFragments.addAll(this.mFragmentStore.p());
        Fragment primaryNavigationFragment = getPrimaryNavigationFragment();
        boolean z12 = false;
        for (int i13 = i11; i13 < i12; i13++) {
            androidx.fragment.app.a aVar = arrayList.get(i13);
            primaryNavigationFragment = !arrayList2.get(i13).booleanValue() ? aVar.i(this.mTmpAddedFragments, primaryNavigationFragment) : aVar.l(this.mTmpAddedFragments, primaryNavigationFragment);
            z12 = z12 || aVar.mAddToBackStack;
        }
        this.mTmpAddedFragments.clear();
        if (!z11 && this.mCurState >= 1) {
            for (int i14 = i11; i14 < i12; i14++) {
                Iterator<FragmentTransaction.a> it = arrayList.get(i14).mOps.iterator();
                while (it.hasNext()) {
                    Fragment fragment = it.next().f8537b;
                    if (fragment != null && fragment.mFragmentManager != null) {
                        this.mFragmentStore.s(createOrGetFragmentStateManager(fragment));
                    }
                }
            }
        }
        executeOps(arrayList, arrayList2, i11, i12);
        boolean zBooleanValue = arrayList2.get(i12 - 1).booleanValue();
        for (int i15 = i11; i15 < i12; i15++) {
            androidx.fragment.app.a aVar2 = arrayList.get(i15);
            if (zBooleanValue) {
                for (int size = aVar2.mOps.size() - 1; size >= 0; size--) {
                    Fragment fragment2 = aVar2.mOps.get(size).f8537b;
                    if (fragment2 != null) {
                        createOrGetFragmentStateManager(fragment2).m();
                    }
                }
            } else {
                Iterator<FragmentTransaction.a> it2 = aVar2.mOps.iterator();
                while (it2.hasNext()) {
                    Fragment fragment3 = it2.next().f8537b;
                    if (fragment3 != null) {
                        createOrGetFragmentStateManager(fragment3).m();
                    }
                }
            }
        }
        moveToState(this.mCurState, true);
        for (SpecialEffectsController specialEffectsController : collectChangedControllers(arrayList, i11, i12)) {
            specialEffectsController.r(zBooleanValue);
            specialEffectsController.p();
            specialEffectsController.g();
        }
        while (i11 < i12) {
            androidx.fragment.app.a aVar3 = arrayList.get(i11);
            if (arrayList2.get(i11).booleanValue() && aVar3.f8575c >= 0) {
                aVar3.f8575c = -1;
            }
            aVar3.k();
            i11++;
        }
        if (z12) {
            reportBackStackChanged();
        }
    }

    private int findBackStackIndex(@Nullable String str, int i11, boolean z11) {
        ArrayList<androidx.fragment.app.a> arrayList = this.mBackStack;
        if (arrayList == null || arrayList.isEmpty()) {
            return -1;
        }
        if (str == null && i11 < 0) {
            if (z11) {
                return 0;
            }
            return this.mBackStack.size() - 1;
        }
        int size = this.mBackStack.size() - 1;
        while (size >= 0) {
            androidx.fragment.app.a aVar = this.mBackStack.get(size);
            if ((str != null && str.equals(aVar.j())) || (i11 >= 0 && i11 == aVar.f8575c)) {
                break;
            }
            size--;
        }
        if (size < 0) {
            return size;
        }
        if (!z11) {
            if (size == this.mBackStack.size() - 1) {
                return -1;
            }
            return size + 1;
        }
        while (size > 0) {
            androidx.fragment.app.a aVar2 = this.mBackStack.get(size - 1);
            if ((str == null || !str.equals(aVar2.j())) && (i11 < 0 || i11 != aVar2.f8575c)) {
                return size;
            }
            size--;
        }
        return size;
    }

    @NonNull
    public static <F extends Fragment> F findFragment(@NonNull View view) {
        F f11 = (F) findViewFragment(view);
        if (f11 != null) {
            return f11;
        }
        throw new IllegalStateException("View " + view + " does not have a Fragment set");
    }

    @NonNull
    public static FragmentManager findFragmentManager(@NonNull View view) {
        FragmentActivity fragmentActivity;
        Fragment fragmentFindViewFragment = findViewFragment(view);
        if (fragmentFindViewFragment != null) {
            if (fragmentFindViewFragment.isAdded()) {
                return fragmentFindViewFragment.getChildFragmentManager();
            }
            throw new IllegalStateException("The Fragment " + fragmentFindViewFragment + " that owns View " + view + " has already been destroyed. Nested fragments should always use the child FragmentManager.");
        }
        Context context = view.getContext();
        while (true) {
            if (!(context instanceof ContextWrapper)) {
                fragmentActivity = null;
                break;
            }
            if (context instanceof FragmentActivity) {
                fragmentActivity = (FragmentActivity) context;
                break;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        if (fragmentActivity != null) {
            return fragmentActivity.getSupportFragmentManager();
        }
        throw new IllegalStateException("View " + view + " is not within a subclass of FragmentActivity.");
    }

    @Nullable
    private static Fragment findViewFragment(@NonNull View view) {
        while (view != null) {
            Fragment viewFragment = getViewFragment(view);
            if (viewFragment != null) {
                return viewFragment;
            }
            Object parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        return null;
    }

    private void forcePostponedTransactions() {
        Iterator<SpecialEffectsController> it = collectAllSpecialEffectsController().iterator();
        while (it.hasNext()) {
            it.next().k();
        }
    }

    private boolean generateOpsForPendingActions(@NonNull ArrayList<androidx.fragment.app.a> arrayList, @NonNull ArrayList<Boolean> arrayList2) {
        synchronized (this.mPendingActions) {
            if (this.mPendingActions.isEmpty()) {
                return false;
            }
            try {
                int size = this.mPendingActions.size();
                boolean zA = false;
                for (int i11 = 0; i11 < size; i11++) {
                    zA |= this.mPendingActions.get(i11).a(arrayList, arrayList2);
                }
                this.mPendingActions.clear();
                this.mHost.g().removeCallbacks(this.mExecCommit);
                return zA;
            } catch (Throwable th2) {
                this.mPendingActions.clear();
                this.mHost.g().removeCallbacks(this.mExecCommit);
                throw th2;
            }
        }
    }

    @NonNull
    private androidx.fragment.app.s getChildNonConfig(@NonNull Fragment fragment) {
        return this.mNonConfig.g(fragment);
    }

    private ViewGroup getFragmentContainer(@NonNull Fragment fragment) {
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null) {
            return viewGroup;
        }
        if (fragment.mContainerId > 0 && this.mContainer.d()) {
            View viewC = this.mContainer.c(fragment.mContainerId);
            if (viewC instanceof ViewGroup) {
                return (ViewGroup) viewC;
            }
        }
        return null;
    }

    @Nullable
    public static Fragment getViewFragment(@NonNull View view) {
        Object tag = view.getTag(R$id.fragment_container_view_tag);
        if (tag instanceof Fragment) {
            return (Fragment) tag;
        }
        return null;
    }

    public static boolean isLoggingEnabled(int i11) {
        return DEBUG || Log.isLoggable(TAG, i11);
    }

    private boolean isMenuAvailable(@NonNull Fragment fragment) {
        return (fragment.mHasMenu && fragment.mMenuVisible) || fragment.mChildFragmentManager.checkForMenus();
    }

    private boolean isParentAdded() {
        Fragment fragment = this.mParent;
        if (fragment == null) {
            return true;
        }
        return fragment.isAdded() && this.mParent.getParentFragmentManager().isParentAdded();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(Configuration configuration) {
        if (isParentAdded()) {
            dispatchConfigurationChanged(configuration, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1(Integer num) {
        if (isParentAdded() && num.intValue() == 80) {
            dispatchLowMemory(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$2(androidx.core.app.l lVar) {
        if (isParentAdded()) {
            dispatchMultiWindowModeChanged(lVar.a(), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$3(androidx.core.app.b0 b0Var) {
        if (isParentAdded()) {
            dispatchPictureInPictureModeChanged(b0Var.a(), false);
        }
    }

    private boolean popBackStackImmediate(@Nullable String str, int i11, int i12) {
        execPendingActions(false);
        ensureExecReady(true);
        Fragment fragment = this.mPrimaryNav;
        if (fragment != null && i11 < 0 && str == null && fragment.getChildFragmentManager().popBackStackImmediate()) {
            return true;
        }
        boolean zPopBackStackState = popBackStackState(this.mTmpRecords, this.mTmpIsPop, str, i11, i12);
        if (zPopBackStackState) {
            this.mExecutingActions = true;
            try {
                removeRedundantOperationsAndExecute(this.mTmpRecords, this.mTmpIsPop);
                cleanupExec();
            } catch (Throwable th2) {
                cleanupExec();
                throw th2;
            }
        }
        updateOnBackPressedCallbackEnabled();
        doPendingDeferredStart();
        this.mFragmentStore.b();
        return zPopBackStackState;
    }

    private void removeRedundantOperationsAndExecute(@NonNull ArrayList<androidx.fragment.app.a> arrayList, @NonNull ArrayList<Boolean> arrayList2) {
        if (arrayList.isEmpty()) {
            return;
        }
        if (arrayList.size() != arrayList2.size()) {
            throw new IllegalStateException("Internal error with the back stack records");
        }
        int size = arrayList.size();
        int i11 = 0;
        int i12 = 0;
        while (i11 < size) {
            if (!arrayList.get(i11).mReorderingAllowed) {
                if (i12 != i11) {
                    executeOpsTogether(arrayList, arrayList2, i12, i11);
                }
                i12 = i11 + 1;
                if (arrayList2.get(i11).booleanValue()) {
                    while (i12 < size && arrayList2.get(i12).booleanValue() && !arrayList.get(i12).mReorderingAllowed) {
                        i12++;
                    }
                }
                executeOpsTogether(arrayList, arrayList2, i11, i12);
                i11 = i12 - 1;
            }
            i11++;
        }
        if (i12 != size) {
            executeOpsTogether(arrayList, arrayList2, i12, size);
        }
    }

    private void reportBackStackChanged() {
        if (this.mBackStackChangeListeners != null) {
            for (int i11 = 0; i11 < this.mBackStackChangeListeners.size(); i11++) {
                this.mBackStackChangeListeners.get(i11).a();
            }
        }
    }

    public static int reverseTransit(int i11) {
        if (i11 == 4097) {
            return 8194;
        }
        if (i11 == 8194) {
            return FragmentTransaction.TRANSIT_FRAGMENT_OPEN;
        }
        if (i11 == 8197) {
            return FragmentTransaction.TRANSIT_FRAGMENT_MATCH_ACTIVITY_OPEN;
        }
        if (i11 == 4099) {
            return FragmentTransaction.TRANSIT_FRAGMENT_FADE;
        }
        if (i11 != 4100) {
            return 0;
        }
        return FragmentTransaction.TRANSIT_FRAGMENT_MATCH_ACTIVITY_CLOSE;
    }

    private void setVisibleRemovingFragment(@NonNull Fragment fragment) {
        ViewGroup fragmentContainer = getFragmentContainer(fragment);
        if (fragmentContainer == null || fragment.getEnterAnim() + fragment.getExitAnim() + fragment.getPopEnterAnim() + fragment.getPopExitAnim() <= 0) {
            return;
        }
        if (fragmentContainer.getTag(R$id.visible_removing_fragment_view_tag) == null) {
            fragmentContainer.setTag(R$id.visible_removing_fragment_view_tag, fragment);
        }
        ((Fragment) fragmentContainer.getTag(R$id.visible_removing_fragment_view_tag)).setPopDirection(fragment.getPopDirection());
    }

    private void startPendingDeferredFragments() {
        Iterator<v> it = this.mFragmentStore.l().iterator();
        while (it.hasNext()) {
            performPendingDeferredStart(it.next());
        }
    }

    private void throwException(RuntimeException runtimeException) {
        Log.e(TAG, runtimeException.getMessage());
        Log.e(TAG, "Activity state:");
        PrintWriter printWriter = new PrintWriter(new a0(TAG));
        androidx.fragment.app.i<?> iVar = this.mHost;
        if (iVar != null) {
            try {
                iVar.h("  ", null, printWriter, new String[0]);
                throw runtimeException;
            } catch (Exception e11) {
                Log.e(TAG, "Failed dumping state", e11);
                throw runtimeException;
            }
        }
        try {
            dump("  ", null, printWriter, new String[0]);
            throw runtimeException;
        } catch (Exception e12) {
            Log.e(TAG, "Failed dumping state", e12);
            throw runtimeException;
        }
    }

    private void updateOnBackPressedCallbackEnabled() {
        synchronized (this.mPendingActions) {
            try {
                if (this.mPendingActions.isEmpty()) {
                    this.mOnBackPressedCallback.setEnabled(getBackStackEntryCount() > 0 && isPrimaryNavigation(this.mParent));
                } else {
                    this.mOnBackPressedCallback.setEnabled(true);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void addBackStackState(androidx.fragment.app.a aVar) {
        if (this.mBackStack == null) {
            this.mBackStack = new ArrayList<>();
        }
        this.mBackStack.add(aVar);
    }

    public v addFragment(@NonNull Fragment fragment) {
        String str = fragment.mPreviousWho;
        if (str != null) {
            FragmentStrictMode.f(fragment, str);
        }
        if (isLoggingEnabled(2)) {
            Log.v(TAG, "add: " + fragment);
        }
        v vVarCreateOrGetFragmentStateManager = createOrGetFragmentStateManager(fragment);
        fragment.mFragmentManager = this;
        this.mFragmentStore.s(vVarCreateOrGetFragmentStateManager);
        if (!fragment.mDetached) {
            this.mFragmentStore.a(fragment);
            fragment.mRemoving = false;
            if (fragment.mView == null) {
                fragment.mHiddenChanged = false;
            }
            if (isMenuAvailable(fragment)) {
                this.mNeedMenuInvalidate = true;
            }
        }
        return vVarCreateOrGetFragmentStateManager;
    }

    public void addFragmentOnAttachListener(@NonNull t tVar) {
        this.mOnAttachListeners.add(tVar);
    }

    public void addOnBackStackChangedListener(@NonNull o oVar) {
        if (this.mBackStackChangeListeners == null) {
            this.mBackStackChangeListeners = new ArrayList<>();
        }
        this.mBackStackChangeListeners.add(oVar);
    }

    public void addRetainedFragment(@NonNull Fragment fragment) {
        this.mNonConfig.b(fragment);
    }

    public int allocBackStackIndex() {
        return this.mBackStackIndex.getAndIncrement();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"SyntheticAccessor"})
    public void attachController(@NonNull androidx.fragment.app.i<?> iVar, @NonNull androidx.fragment.app.f fVar, @Nullable Fragment fragment) {
        String str;
        androidx.lifecycle.u uVar;
        if (this.mHost != null) {
            throw new IllegalStateException("Already attached");
        }
        this.mHost = iVar;
        this.mContainer = fVar;
        this.mParent = fragment;
        if (fragment != null) {
            addFragmentOnAttachListener(new g(fragment));
        } else if (iVar instanceof t) {
            addFragmentOnAttachListener((t) iVar);
        }
        if (this.mParent != null) {
            updateOnBackPressedCallbackEnabled();
        }
        if (iVar instanceof androidx.activity.s) {
            androidx.activity.s sVar = (androidx.activity.s) iVar;
            OnBackPressedDispatcher onBackPressedDispatcher = sVar.getOnBackPressedDispatcher();
            this.mOnBackPressedDispatcher = onBackPressedDispatcher;
            if (fragment != null) {
                uVar = sVar;
                uVar = fragment;
            }
            uVar = sVar;
            onBackPressedDispatcher.i(uVar, this.mOnBackPressedCallback);
        }
        if (fragment != null) {
            this.mNonConfig = fragment.mFragmentManager.getChildNonConfig(fragment);
        } else if (iVar instanceof y0) {
            this.mNonConfig = androidx.fragment.app.s.h(((y0) iVar).getViewModelStore());
        } else {
            this.mNonConfig = new androidx.fragment.app.s(false);
        }
        this.mNonConfig.o(isStateSaved());
        this.mFragmentStore.B(this.mNonConfig);
        Object obj = this.mHost;
        if ((obj instanceof f6.e) && fragment == null) {
            f6.c savedStateRegistry = ((f6.e) obj).getSavedStateRegistry();
            savedStateRegistry.h(SAVED_STATE_TAG, new f6.c.InterfaceC0670c() { // from class: androidx.fragment.app.p
                @Override // f6.c.InterfaceC0670c
                public final Bundle saveState() {
                    return this.f8600a.lambda$attachController$4();
                }
            });
            Bundle bundleB = savedStateRegistry.b(SAVED_STATE_TAG);
            if (bundleB != null) {
                restoreSaveStateInternal(bundleB);
            }
        }
        Object obj2 = this.mHost;
        if (obj2 instanceof b1.d) {
            b1.c activityResultRegistry = ((b1.d) obj2).getActivityResultRegistry();
            if (fragment != null) {
                str = fragment.mWho + ":";
            } else {
                str = "";
            }
            String str2 = "FragmentManager:" + str;
            this.mStartActivityForResult = activityResultRegistry.j(str2 + "StartActivityForResult", new c1.j(), new h());
            this.mStartIntentSenderForResult = activityResultRegistry.j(str2 + "StartIntentSenderForResult", new l(), new i());
            this.mRequestPermissions = activityResultRegistry.j(str2 + "RequestPermissions", new c1.h(), new a());
        }
        Object obj3 = this.mHost;
        if (obj3 instanceof z2.d) {
            ((z2.d) obj3).addOnConfigurationChangedListener(this.mOnConfigurationChangedListener);
        }
        Object obj4 = this.mHost;
        if (obj4 instanceof z2.e) {
            ((z2.e) obj4).addOnTrimMemoryListener(this.mOnTrimMemoryListener);
        }
        Object obj5 = this.mHost;
        if (obj5 instanceof androidx.core.app.y) {
            ((androidx.core.app.y) obj5).addOnMultiWindowModeChangedListener(this.mOnMultiWindowModeChangedListener);
        }
        Object obj6 = this.mHost;
        if (obj6 instanceof androidx.core.app.z) {
            ((androidx.core.app.z) obj6).addOnPictureInPictureModeChangedListener(this.mOnPictureInPictureModeChangedListener);
        }
        Object obj7 = this.mHost;
        if ((obj7 instanceof MenuHost) && fragment == null) {
            ((MenuHost) obj7).addMenuProvider(this.mMenuProvider);
        }
    }

    public void attachFragment(@NonNull Fragment fragment) {
        if (isLoggingEnabled(2)) {
            Log.v(TAG, "attach: " + fragment);
        }
        if (fragment.mDetached) {
            fragment.mDetached = false;
            if (fragment.mAdded) {
                return;
            }
            this.mFragmentStore.a(fragment);
            if (isLoggingEnabled(2)) {
                Log.v(TAG, "add from attach: " + fragment);
            }
            if (isMenuAvailable(fragment)) {
                this.mNeedMenuInvalidate = true;
            }
        }
    }

    @NonNull
    public FragmentTransaction beginTransaction() {
        return new androidx.fragment.app.a(this);
    }

    public boolean checkForMenus() {
        boolean zIsMenuAvailable = false;
        for (Fragment fragment : this.mFragmentStore.m()) {
            if (fragment != null) {
                zIsMenuAvailable = isMenuAvailable(fragment);
            }
            if (zIsMenuAvailable) {
                return true;
            }
        }
        return false;
    }

    public void clearBackStack(@NonNull String str) {
        enqueueAction(new k(str), false);
    }

    public boolean clearBackStackState(@NonNull ArrayList<androidx.fragment.app.a> arrayList, @NonNull ArrayList<Boolean> arrayList2, @NonNull String str) {
        if (restoreBackStackState(arrayList, arrayList2, str)) {
            return popBackStackState(arrayList, arrayList2, str, -1, 1);
        }
        return false;
    }

    public final void clearFragmentResult(@NonNull String str) {
        this.mResults.remove(str);
        if (isLoggingEnabled(2)) {
            Log.v(TAG, "Clearing fragment result with key " + str);
        }
    }

    public final void clearFragmentResultListener(@NonNull String str) {
        n nVarRemove = this.mResultListeners.remove(str);
        if (nVarRemove != null) {
            nVarRemove.c();
        }
        if (isLoggingEnabled(2)) {
            Log.v(TAG, "Clearing FragmentResultListener for key " + str);
        }
    }

    @NonNull
    public v createOrGetFragmentStateManager(@NonNull Fragment fragment) {
        v vVarO = this.mFragmentStore.o(fragment.mWho);
        if (vVarO != null) {
            return vVarO;
        }
        v vVar = new v(this.mLifecycleCallbacksDispatcher, this.mFragmentStore, fragment);
        vVar.o(this.mHost.f().getClassLoader());
        vVar.u(this.mCurState);
        return vVar;
    }

    public void detachFragment(@NonNull Fragment fragment) {
        if (isLoggingEnabled(2)) {
            Log.v(TAG, "detach: " + fragment);
        }
        if (fragment.mDetached) {
            return;
        }
        fragment.mDetached = true;
        if (fragment.mAdded) {
            if (isLoggingEnabled(2)) {
                Log.v(TAG, "remove from detach: " + fragment);
            }
            this.mFragmentStore.v(fragment);
            if (isMenuAvailable(fragment)) {
                this.mNeedMenuInvalidate = true;
            }
            setVisibleRemovingFragment(fragment);
        }
    }

    public void dispatchActivityCreated() {
        this.mStateSaved = false;
        this.mStopped = false;
        this.mNonConfig.o(false);
        dispatchStateChange(4);
    }

    public void dispatchAttach() {
        this.mStateSaved = false;
        this.mStopped = false;
        this.mNonConfig.o(false);
        dispatchStateChange(0);
    }

    public void dispatchConfigurationChanged(@NonNull Configuration configuration, boolean z11) {
        if (z11 && (this.mHost instanceof z2.d)) {
            throwException(new IllegalStateException("Do not call dispatchConfigurationChanged() on host. Host implements OnConfigurationChangedProvider and automatically dispatches configuration changes to fragments."));
        }
        for (Fragment fragment : this.mFragmentStore.p()) {
            if (fragment != null) {
                fragment.performConfigurationChanged(configuration);
                if (z11) {
                    fragment.mChildFragmentManager.dispatchConfigurationChanged(configuration, true);
                }
            }
        }
    }

    public boolean dispatchContextItemSelected(@NonNull MenuItem menuItem) {
        if (this.mCurState < 1) {
            return false;
        }
        for (Fragment fragment : this.mFragmentStore.p()) {
            if (fragment != null && fragment.performContextItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void dispatchCreate() {
        this.mStateSaved = false;
        this.mStopped = false;
        this.mNonConfig.o(false);
        dispatchStateChange(1);
    }

    public boolean dispatchCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
        if (this.mCurState < 1) {
            return false;
        }
        ArrayList<Fragment> arrayList = null;
        boolean z11 = false;
        for (Fragment fragment : this.mFragmentStore.p()) {
            if (fragment != null && isParentMenuVisible(fragment) && fragment.performCreateOptionsMenu(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(fragment);
                z11 = true;
            }
        }
        if (this.mCreatedMenus != null) {
            for (int i11 = 0; i11 < this.mCreatedMenus.size(); i11++) {
                Fragment fragment2 = this.mCreatedMenus.get(i11);
                if (arrayList == null || !arrayList.contains(fragment2)) {
                    fragment2.onDestroyOptionsMenu();
                }
            }
        }
        this.mCreatedMenus = arrayList;
        return z11;
    }

    public void dispatchDestroy() {
        this.mDestroyed = true;
        execPendingActions(true);
        endAnimatingAwayFragments();
        clearBackStackStateViewModels();
        dispatchStateChange(-1);
        Object obj = this.mHost;
        if (obj instanceof z2.e) {
            ((z2.e) obj).removeOnTrimMemoryListener(this.mOnTrimMemoryListener);
        }
        Object obj2 = this.mHost;
        if (obj2 instanceof z2.d) {
            ((z2.d) obj2).removeOnConfigurationChangedListener(this.mOnConfigurationChangedListener);
        }
        Object obj3 = this.mHost;
        if (obj3 instanceof androidx.core.app.y) {
            ((androidx.core.app.y) obj3).removeOnMultiWindowModeChangedListener(this.mOnMultiWindowModeChangedListener);
        }
        Object obj4 = this.mHost;
        if (obj4 instanceof androidx.core.app.z) {
            ((androidx.core.app.z) obj4).removeOnPictureInPictureModeChangedListener(this.mOnPictureInPictureModeChangedListener);
        }
        Object obj5 = this.mHost;
        if (obj5 instanceof MenuHost) {
            ((MenuHost) obj5).removeMenuProvider(this.mMenuProvider);
        }
        this.mHost = null;
        this.mContainer = null;
        this.mParent = null;
        if (this.mOnBackPressedDispatcher != null) {
            this.mOnBackPressedCallback.remove();
            this.mOnBackPressedDispatcher = null;
        }
        b1.b<Intent> bVar = this.mStartActivityForResult;
        if (bVar != null) {
            bVar.c();
            this.mStartIntentSenderForResult.c();
            this.mRequestPermissions.c();
        }
    }

    public void dispatchDestroyView() {
        dispatchStateChange(1);
    }

    public void dispatchLowMemory(boolean z11) {
        if (z11 && (this.mHost instanceof z2.e)) {
            throwException(new IllegalStateException("Do not call dispatchLowMemory() on host. Host implements OnTrimMemoryProvider and automatically dispatches low memory callbacks to fragments."));
        }
        for (Fragment fragment : this.mFragmentStore.p()) {
            if (fragment != null) {
                fragment.performLowMemory();
                if (z11) {
                    fragment.mChildFragmentManager.dispatchLowMemory(true);
                }
            }
        }
    }

    public void dispatchMultiWindowModeChanged(boolean z11, boolean z12) {
        if (z12 && (this.mHost instanceof androidx.core.app.y)) {
            throwException(new IllegalStateException("Do not call dispatchMultiWindowModeChanged() on host. Host implements OnMultiWindowModeChangedProvider and automatically dispatches multi-window mode changes to fragments."));
        }
        for (Fragment fragment : this.mFragmentStore.p()) {
            if (fragment != null) {
                fragment.performMultiWindowModeChanged(z11);
                if (z12) {
                    fragment.mChildFragmentManager.dispatchMultiWindowModeChanged(z11, true);
                }
            }
        }
    }

    public void dispatchOnAttachFragment(@NonNull Fragment fragment) {
        Iterator<t> it = this.mOnAttachListeners.iterator();
        while (it.hasNext()) {
            it.next().a(this, fragment);
        }
    }

    public void dispatchOnHiddenChanged() {
        for (Fragment fragment : this.mFragmentStore.m()) {
            if (fragment != null) {
                fragment.onHiddenChanged(fragment.isHidden());
                fragment.mChildFragmentManager.dispatchOnHiddenChanged();
            }
        }
    }

    public boolean dispatchOptionsItemSelected(@NonNull MenuItem menuItem) {
        if (this.mCurState < 1) {
            return false;
        }
        for (Fragment fragment : this.mFragmentStore.p()) {
            if (fragment != null && fragment.performOptionsItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void dispatchOptionsMenuClosed(@NonNull Menu menu) {
        if (this.mCurState < 1) {
            return;
        }
        for (Fragment fragment : this.mFragmentStore.p()) {
            if (fragment != null) {
                fragment.performOptionsMenuClosed(menu);
            }
        }
    }

    public void dispatchPause() {
        dispatchStateChange(5);
    }

    public void dispatchPictureInPictureModeChanged(boolean z11, boolean z12) {
        if (z12 && (this.mHost instanceof androidx.core.app.z)) {
            throwException(new IllegalStateException("Do not call dispatchPictureInPictureModeChanged() on host. Host implements OnPictureInPictureModeChangedProvider and automatically dispatches picture-in-picture mode changes to fragments."));
        }
        for (Fragment fragment : this.mFragmentStore.p()) {
            if (fragment != null) {
                fragment.performPictureInPictureModeChanged(z11);
                if (z12) {
                    fragment.mChildFragmentManager.dispatchPictureInPictureModeChanged(z11, true);
                }
            }
        }
    }

    public boolean dispatchPrepareOptionsMenu(@NonNull Menu menu) {
        boolean z11 = false;
        if (this.mCurState < 1) {
            return false;
        }
        for (Fragment fragment : this.mFragmentStore.p()) {
            if (fragment != null && isParentMenuVisible(fragment) && fragment.performPrepareOptionsMenu(menu)) {
                z11 = true;
            }
        }
        return z11;
    }

    public void dispatchPrimaryNavigationFragmentChanged() {
        updateOnBackPressedCallbackEnabled();
        dispatchParentPrimaryNavigationFragmentChanged(this.mPrimaryNav);
    }

    public void dispatchResume() {
        this.mStateSaved = false;
        this.mStopped = false;
        this.mNonConfig.o(false);
        dispatchStateChange(7);
    }

    public void dispatchStart() {
        this.mStateSaved = false;
        this.mStopped = false;
        this.mNonConfig.o(false);
        dispatchStateChange(5);
    }

    public void dispatchStop() {
        this.mStopped = true;
        this.mNonConfig.o(true);
        dispatchStateChange(4);
    }

    public void dispatchViewCreated() {
        dispatchStateChange(2);
    }

    public void dump(@NonNull String str, @Nullable FileDescriptor fileDescriptor, @NonNull PrintWriter printWriter, @Nullable String[] strArr) {
        int size;
        int size2;
        String str2 = str + "    ";
        this.mFragmentStore.e(str, fileDescriptor, printWriter, strArr);
        ArrayList<Fragment> arrayList = this.mCreatedMenus;
        if (arrayList != null && (size2 = arrayList.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i11 = 0; i11 < size2; i11++) {
                Fragment fragment = this.mCreatedMenus.get(i11);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i11);
                printWriter.print(": ");
                printWriter.println(fragment.toString());
            }
        }
        ArrayList<androidx.fragment.app.a> arrayList2 = this.mBackStack;
        if (arrayList2 != null && (size = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i12 = 0; i12 < size; i12++) {
                androidx.fragment.app.a aVar = this.mBackStack.get(i12);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i12);
                printWriter.print(": ");
                printWriter.println(aVar.toString());
                aVar.e(str2, printWriter);
            }
        }
        printWriter.print(str);
        printWriter.println("Back Stack Index: " + this.mBackStackIndex.get());
        synchronized (this.mPendingActions) {
            try {
                int size3 = this.mPendingActions.size();
                if (size3 > 0) {
                    printWriter.print(str);
                    printWriter.println("Pending Actions:");
                    for (int i13 = 0; i13 < size3; i13++) {
                        p pVar = this.mPendingActions.get(i13);
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(i13);
                        printWriter.print(": ");
                        printWriter.println(pVar);
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.mHost);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.mContainer);
        if (this.mParent != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.mParent);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.mCurState);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.mStateSaved);
        printWriter.print(" mStopped=");
        printWriter.print(this.mStopped);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.mDestroyed);
        if (this.mNeedMenuInvalidate) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.mNeedMenuInvalidate);
        }
    }

    public void enqueueAction(@NonNull p pVar, boolean z11) {
        if (!z11) {
            if (this.mHost == null) {
                if (!this.mDestroyed) {
                    throw new IllegalStateException("FragmentManager has not been attached to a host.");
                }
                throw new IllegalStateException("FragmentManager has been destroyed");
            }
            checkStateLoss();
        }
        synchronized (this.mPendingActions) {
            try {
                if (this.mHost == null) {
                    if (!z11) {
                        throw new IllegalStateException("Activity has been destroyed");
                    }
                } else {
                    this.mPendingActions.add(pVar);
                    scheduleCommit();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public boolean execPendingActions(boolean z11) {
        ensureExecReady(z11);
        boolean z12 = false;
        while (generateOpsForPendingActions(this.mTmpRecords, this.mTmpIsPop)) {
            z12 = true;
            this.mExecutingActions = true;
            try {
                removeRedundantOperationsAndExecute(this.mTmpRecords, this.mTmpIsPop);
                cleanupExec();
            } catch (Throwable th2) {
                cleanupExec();
                throw th2;
            }
        }
        updateOnBackPressedCallbackEnabled();
        doPendingDeferredStart();
        this.mFragmentStore.b();
        return z12;
    }

    public void execSingleAction(@NonNull p pVar, boolean z11) {
        if (z11 && (this.mHost == null || this.mDestroyed)) {
            return;
        }
        ensureExecReady(z11);
        if (pVar.a(this.mTmpRecords, this.mTmpIsPop)) {
            this.mExecutingActions = true;
            try {
                removeRedundantOperationsAndExecute(this.mTmpRecords, this.mTmpIsPop);
                cleanupExec();
            } catch (Throwable th2) {
                cleanupExec();
                throw th2;
            }
        }
        updateOnBackPressedCallbackEnabled();
        doPendingDeferredStart();
        this.mFragmentStore.b();
    }

    public boolean executePendingTransactions() {
        boolean zExecPendingActions = execPendingActions(true);
        forcePostponedTransactions();
        return zExecPendingActions;
    }

    @Nullable
    public Fragment findActiveFragment(@NonNull String str) {
        return this.mFragmentStore.f(str);
    }

    @Nullable
    public Fragment findFragmentById(int i11) {
        return this.mFragmentStore.g(i11);
    }

    @Nullable
    public Fragment findFragmentByTag(@Nullable String str) {
        return this.mFragmentStore.h(str);
    }

    public Fragment findFragmentByWho(@NonNull String str) {
        return this.mFragmentStore.i(str);
    }

    public int getActiveFragmentCount() {
        return this.mFragmentStore.k();
    }

    @NonNull
    public List<Fragment> getActiveFragments() {
        return this.mFragmentStore.m();
    }

    @NonNull
    public j getBackStackEntryAt(int i11) {
        return this.mBackStack.get(i11);
    }

    public int getBackStackEntryCount() {
        ArrayList<androidx.fragment.app.a> arrayList = this.mBackStack;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    @NonNull
    public androidx.fragment.app.f getContainer() {
        return this.mContainer;
    }

    @Nullable
    public Fragment getFragment(@NonNull Bundle bundle, @NonNull String str) {
        String string = bundle.getString(str);
        if (string == null) {
            return null;
        }
        Fragment fragmentFindActiveFragment = findActiveFragment(string);
        if (fragmentFindActiveFragment == null) {
            throwException(new IllegalStateException("Fragment no longer exists for key " + str + ": unique id " + string));
        }
        return fragmentFindActiveFragment;
    }

    @NonNull
    public androidx.fragment.app.h getFragmentFactory() {
        androidx.fragment.app.h hVar = this.mFragmentFactory;
        if (hVar != null) {
            return hVar;
        }
        Fragment fragment = this.mParent;
        return fragment != null ? fragment.mFragmentManager.getFragmentFactory() : this.mHostFragmentFactory;
    }

    @NonNull
    public w getFragmentStore() {
        return this.mFragmentStore;
    }

    @NonNull
    public List<Fragment> getFragments() {
        return this.mFragmentStore.p();
    }

    @NonNull
    public androidx.fragment.app.i<?> getHost() {
        return this.mHost;
    }

    @NonNull
    public LayoutInflater.Factory2 getLayoutInflaterFactory() {
        return this.mLayoutInflaterFactory;
    }

    @NonNull
    public androidx.fragment.app.k getLifecycleCallbacksDispatcher() {
        return this.mLifecycleCallbacksDispatcher;
    }

    @Nullable
    public Fragment getParent() {
        return this.mParent;
    }

    @Nullable
    public Fragment getPrimaryNavigationFragment() {
        return this.mPrimaryNav;
    }

    @NonNull
    public b0 getSpecialEffectsControllerFactory() {
        b0 b0Var = this.mSpecialEffectsControllerFactory;
        if (b0Var != null) {
            return b0Var;
        }
        Fragment fragment = this.mParent;
        return fragment != null ? fragment.mFragmentManager.getSpecialEffectsControllerFactory() : this.mDefaultSpecialEffectsControllerFactory;
    }

    @Nullable
    public FragmentStrictMode.b getStrictModePolicy() {
        return this.mStrictModePolicy;
    }

    @NonNull
    public x0 getViewModelStore(@NonNull Fragment fragment) {
        return this.mNonConfig.k(fragment);
    }

    public void handleOnBackPressed() {
        execPendingActions(true);
        if (this.mOnBackPressedCallback.isEnabled()) {
            popBackStackImmediate();
        } else {
            this.mOnBackPressedDispatcher.l();
        }
    }

    public void hideFragment(@NonNull Fragment fragment) {
        if (isLoggingEnabled(2)) {
            Log.v(TAG, "hide: " + fragment);
        }
        if (fragment.mHidden) {
            return;
        }
        fragment.mHidden = true;
        fragment.mHiddenChanged = true ^ fragment.mHiddenChanged;
        setVisibleRemovingFragment(fragment);
    }

    public void invalidateMenuForFragment(@NonNull Fragment fragment) {
        if (fragment.mAdded && isMenuAvailable(fragment)) {
            this.mNeedMenuInvalidate = true;
        }
    }

    public boolean isDestroyed() {
        return this.mDestroyed;
    }

    public boolean isParentHidden(@Nullable Fragment fragment) {
        if (fragment == null) {
            return false;
        }
        return fragment.isHidden();
    }

    public boolean isParentMenuVisible(@Nullable Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        return fragment.isMenuVisible();
    }

    public boolean isPrimaryNavigation(@Nullable Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        FragmentManager fragmentManager = fragment.mFragmentManager;
        return fragment.equals(fragmentManager.getPrimaryNavigationFragment()) && isPrimaryNavigation(fragmentManager.mParent);
    }

    public boolean isStateAtLeast(int i11) {
        return this.mCurState >= i11;
    }

    public boolean isStateSaved() {
        return this.mStateSaved || this.mStopped;
    }

    public void launchRequestPermissions(@NonNull Fragment fragment, @NonNull String[] strArr, int i11) {
        if (this.mRequestPermissions == null) {
            this.mHost.k(fragment, strArr, i11);
            return;
        }
        this.mLaunchedFragments.addLast(new LaunchedFragmentInfo(fragment.mWho, i11));
        this.mRequestPermissions.a(strArr);
    }

    public void launchStartActivityForResult(@NonNull Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i11, @Nullable Bundle bundle) {
        if (this.mStartActivityForResult == null) {
            this.mHost.m(fragment, intent, i11, bundle);
            return;
        }
        this.mLaunchedFragments.addLast(new LaunchedFragmentInfo(fragment.mWho, i11));
        if (intent != null && bundle != null) {
            intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
        }
        this.mStartActivityForResult.a(intent);
    }

    public void launchStartIntentSenderForResult(@NonNull Fragment fragment, @SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i11, @Nullable Intent intent, int i12, int i13, int i14, @Nullable Bundle bundle) throws IntentSender.SendIntentException {
        Intent intent2;
        if (this.mStartIntentSenderForResult == null) {
            this.mHost.n(fragment, intentSender, i11, intent, i12, i13, i14, bundle);
            return;
        }
        if (bundle != null) {
            if (intent == null) {
                intent2 = new Intent();
                intent2.putExtra(EXTRA_CREATED_FILLIN_INTENT, true);
            } else {
                intent2 = intent;
            }
            if (isLoggingEnabled(2)) {
                Log.v(TAG, "ActivityOptions " + bundle + " were added to fillInIntent " + intent2 + " for fragment " + fragment);
            }
            intent2.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
        } else {
            intent2 = intent;
        }
        IntentSenderRequest intentSenderRequestA = new IntentSenderRequest.a(intentSender).b(intent2).c(i13, i12).a();
        this.mLaunchedFragments.addLast(new LaunchedFragmentInfo(fragment.mWho, i11));
        if (isLoggingEnabled(2)) {
            Log.v(TAG, "Fragment " + fragment + "is launching an IntentSender for result ");
        }
        this.mStartIntentSenderForResult.a(intentSenderRequestA);
    }

    public void moveToState(int i11, boolean z11) {
        androidx.fragment.app.i<?> iVar;
        if (this.mHost == null && i11 != -1) {
            throw new IllegalStateException("No activity");
        }
        if (z11 || i11 != this.mCurState) {
            this.mCurState = i11;
            this.mFragmentStore.u();
            startPendingDeferredFragments();
            if (this.mNeedMenuInvalidate && (iVar = this.mHost) != null && this.mCurState == 7) {
                iVar.o();
                this.mNeedMenuInvalidate = false;
            }
        }
    }

    public void noteStateNotSaved() {
        if (this.mHost == null) {
            return;
        }
        this.mStateSaved = false;
        this.mStopped = false;
        this.mNonConfig.o(false);
        for (Fragment fragment : this.mFragmentStore.p()) {
            if (fragment != null) {
                fragment.noteStateNotSaved();
            }
        }
    }

    public void onContainerAvailable(@NonNull FragmentContainerView fragmentContainerView) {
        View view;
        for (v vVar : this.mFragmentStore.l()) {
            Fragment fragmentK = vVar.k();
            if (fragmentK.mContainerId == fragmentContainerView.getId() && (view = fragmentK.mView) != null && view.getParent() == null) {
                fragmentK.mContainer = fragmentContainerView;
                vVar.b();
            }
        }
    }

    @NonNull
    @Deprecated
    public FragmentTransaction openTransaction() {
        return beginTransaction();
    }

    public void performPendingDeferredStart(@NonNull v vVar) {
        Fragment fragmentK = vVar.k();
        if (fragmentK.mDeferStart) {
            if (this.mExecutingActions) {
                this.mHavePendingDeferredStart = true;
            } else {
                fragmentK.mDeferStart = false;
                vVar.m();
            }
        }
    }

    public void popBackStack() {
        enqueueAction(new q(null, -1, 0), false);
    }

    public void popBackStack(int i11, int i12) {
        popBackStack(i11, i12, false);
    }

    public void popBackStack(int i11, int i12, boolean z11) {
        if (i11 >= 0) {
            enqueueAction(new q(null, i11, i12), z11);
            return;
        }
        throw new IllegalArgumentException("Bad id: " + i11);
    }

    public void popBackStack(@Nullable String str, int i11) {
        enqueueAction(new q(str, -1, i11), false);
    }

    public boolean popBackStackImmediate() {
        return popBackStackImmediate(null, -1, 0);
    }

    public boolean popBackStackImmediate(int i11, int i12) {
        if (i11 >= 0) {
            return popBackStackImmediate(null, i11, i12);
        }
        throw new IllegalArgumentException("Bad id: " + i11);
    }

    public boolean popBackStackImmediate(@Nullable String str, int i11) {
        return popBackStackImmediate(str, -1, i11);
    }

    public boolean popBackStackState(@NonNull ArrayList<androidx.fragment.app.a> arrayList, @NonNull ArrayList<Boolean> arrayList2, @Nullable String str, int i11, int i12) {
        int iFindBackStackIndex = findBackStackIndex(str, i11, (i12 & 1) != 0);
        if (iFindBackStackIndex < 0) {
            return false;
        }
        for (int size = this.mBackStack.size() - 1; size >= iFindBackStackIndex; size--) {
            arrayList.add(this.mBackStack.remove(size));
            arrayList2.add(Boolean.TRUE);
        }
        return true;
    }

    public void putFragment(@NonNull Bundle bundle, @NonNull String str, @NonNull Fragment fragment) {
        if (fragment.mFragmentManager != this) {
            throwException(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        bundle.putString(str, fragment.mWho);
    }

    public void registerFragmentLifecycleCallbacks(@NonNull m mVar, boolean z11) {
        this.mLifecycleCallbacksDispatcher.o(mVar, z11);
    }

    public void removeFragment(@NonNull Fragment fragment) {
        if (isLoggingEnabled(2)) {
            Log.v(TAG, "remove: " + fragment + " nesting=" + fragment.mBackStackNesting);
        }
        boolean z11 = !fragment.isInBackStack();
        if (!fragment.mDetached || z11) {
            this.mFragmentStore.v(fragment);
            if (isMenuAvailable(fragment)) {
                this.mNeedMenuInvalidate = true;
            }
            fragment.mRemoving = true;
            setVisibleRemovingFragment(fragment);
        }
    }

    public void removeFragmentOnAttachListener(@NonNull t tVar) {
        this.mOnAttachListeners.remove(tVar);
    }

    public void removeOnBackStackChangedListener(@NonNull o oVar) {
        ArrayList<o> arrayList = this.mBackStackChangeListeners;
        if (arrayList != null) {
            arrayList.remove(oVar);
        }
    }

    public void removeRetainedFragment(@NonNull Fragment fragment) {
        this.mNonConfig.m(fragment);
    }

    public void restoreAllState(@Nullable Parcelable parcelable, @Nullable androidx.fragment.app.r rVar) {
        if (this.mHost instanceof y0) {
            throwException(new IllegalStateException("You must use restoreSaveState when your FragmentHostCallback implements ViewModelStoreOwner"));
        }
        this.mNonConfig.n(rVar);
        restoreSaveStateInternal(parcelable);
    }

    public void restoreBackStack(@NonNull String str) {
        enqueueAction(new r(str), false);
    }

    public boolean restoreBackStackState(@NonNull ArrayList<androidx.fragment.app.a> arrayList, @NonNull ArrayList<Boolean> arrayList2, @NonNull String str) {
        BackStackState backStackStateRemove = this.mBackStackStates.remove(str);
        if (backStackStateRemove == null) {
            return false;
        }
        HashMap map = new HashMap();
        for (androidx.fragment.app.a aVar : arrayList) {
            if (aVar.f8576d) {
                Iterator<FragmentTransaction.a> it = aVar.mOps.iterator();
                while (it.hasNext()) {
                    Fragment fragment = it.next().f8537b;
                    if (fragment != null) {
                        map.put(fragment.mWho, fragment);
                    }
                }
            }
        }
        Iterator<androidx.fragment.app.a> it2 = backStackStateRemove.a(this, map).iterator();
        while (true) {
            boolean z11 = false;
            while (it2.hasNext()) {
                if (it2.next().a(arrayList, arrayList2) || z11) {
                    z11 = true;
                }
            }
            return z11;
        }
    }

    public void restoreSaveState(@Nullable Parcelable parcelable) {
        if (this.mHost instanceof f6.e) {
            throwException(new IllegalStateException("You cannot use restoreSaveState when your FragmentHostCallback implements SavedStateRegistryOwner."));
        }
        restoreSaveStateInternal(parcelable);
    }

    public void restoreSaveStateInternal(@Nullable Parcelable parcelable) {
        v vVar;
        Bundle bundle;
        Bundle bundle2;
        if (parcelable == null) {
            return;
        }
        Bundle bundle3 = (Bundle) parcelable;
        for (String str : bundle3.keySet()) {
            if (str.startsWith(RESULT_NAME_PREFIX) && (bundle2 = bundle3.getBundle(str)) != null) {
                bundle2.setClassLoader(this.mHost.f().getClassLoader());
                this.mResults.put(str.substring(7), bundle2);
            }
        }
        ArrayList<FragmentState> arrayList = new ArrayList<>();
        for (String str2 : bundle3.keySet()) {
            if (str2.startsWith(FRAGMENT_NAME_PREFIX) && (bundle = bundle3.getBundle(str2)) != null) {
                bundle.setClassLoader(this.mHost.f().getClassLoader());
                arrayList.add((FragmentState) bundle.getParcelable("state"));
            }
        }
        this.mFragmentStore.y(arrayList);
        FragmentManagerState fragmentManagerState = (FragmentManagerState) bundle3.getParcelable("state");
        if (fragmentManagerState == null) {
            return;
        }
        this.mFragmentStore.w();
        Iterator<String> it = fragmentManagerState.f8501a.iterator();
        while (it.hasNext()) {
            FragmentState fragmentStateC = this.mFragmentStore.C(it.next(), null);
            if (fragmentStateC != null) {
                Fragment fragmentF = this.mNonConfig.f(fragmentStateC.f8510b);
                if (fragmentF != null) {
                    if (isLoggingEnabled(2)) {
                        Log.v(TAG, "restoreSaveState: re-attaching retained " + fragmentF);
                    }
                    vVar = new v(this.mLifecycleCallbacksDispatcher, this.mFragmentStore, fragmentF, fragmentStateC);
                } else {
                    vVar = new v(this.mLifecycleCallbacksDispatcher, this.mFragmentStore, this.mHost.f().getClassLoader(), getFragmentFactory(), fragmentStateC);
                }
                Fragment fragmentK = vVar.k();
                fragmentK.mFragmentManager = this;
                if (isLoggingEnabled(2)) {
                    Log.v(TAG, "restoreSaveState: active (" + fragmentK.mWho + "): " + fragmentK);
                }
                vVar.o(this.mHost.f().getClassLoader());
                this.mFragmentStore.s(vVar);
                vVar.u(this.mCurState);
            }
        }
        for (Fragment fragment : this.mNonConfig.i()) {
            if (!this.mFragmentStore.c(fragment.mWho)) {
                if (isLoggingEnabled(2)) {
                    Log.v(TAG, "Discarding retained Fragment " + fragment + " that was not found in the set of active Fragments " + fragmentManagerState.f8501a);
                }
                this.mNonConfig.m(fragment);
                fragment.mFragmentManager = this;
                v vVar2 = new v(this.mLifecycleCallbacksDispatcher, this.mFragmentStore, fragment);
                vVar2.u(1);
                vVar2.m();
                fragment.mRemoving = true;
                vVar2.m();
            }
        }
        this.mFragmentStore.x(fragmentManagerState.f8502b);
        if (fragmentManagerState.f8503c != null) {
            this.mBackStack = new ArrayList<>(fragmentManagerState.f8503c.length);
            int i11 = 0;
            while (true) {
                BackStackRecordState[] backStackRecordStateArr = fragmentManagerState.f8503c;
                if (i11 >= backStackRecordStateArr.length) {
                    break;
                }
                androidx.fragment.app.a aVarB = backStackRecordStateArr[i11].b(this);
                if (isLoggingEnabled(2)) {
                    Log.v(TAG, "restoreAllState: back stack #" + i11 + " (index " + aVarB.f8575c + "): " + aVarB);
                    PrintWriter printWriter = new PrintWriter(new a0(TAG));
                    aVarB.f("  ", printWriter, false);
                    printWriter.close();
                }
                this.mBackStack.add(aVarB);
                i11++;
            }
        } else {
            this.mBackStack = null;
        }
        this.mBackStackIndex.set(fragmentManagerState.f8504d);
        String str3 = fragmentManagerState.f8505f;
        if (str3 != null) {
            Fragment fragmentFindActiveFragment = findActiveFragment(str3);
            this.mPrimaryNav = fragmentFindActiveFragment;
            dispatchParentPrimaryNavigationFragmentChanged(fragmentFindActiveFragment);
        }
        ArrayList<String> arrayList2 = fragmentManagerState.f8506g;
        if (arrayList2 != null) {
            for (int i12 = 0; i12 < arrayList2.size(); i12++) {
                this.mBackStackStates.put(arrayList2.get(i12), fragmentManagerState.f8507h.get(i12));
            }
        }
        this.mLaunchedFragments = new ArrayDeque<>(fragmentManagerState.f8508i);
    }

    @Deprecated
    public androidx.fragment.app.r retainNonConfig() {
        if (this.mHost instanceof y0) {
            throwException(new IllegalStateException("You cannot use retainNonConfig when your FragmentHostCallback implements ViewModelStoreOwner."));
        }
        return this.mNonConfig.j();
    }

    public Parcelable saveAllState() {
        if (this.mHost instanceof f6.e) {
            throwException(new IllegalStateException("You cannot use saveAllState when your FragmentHostCallback implements SavedStateRegistryOwner."));
        }
        Bundle bundleLambda$attachController$4 = lambda$attachController$4();
        if (bundleLambda$attachController$4.isEmpty()) {
            return null;
        }
        return bundleLambda$attachController$4;
    }

    @NonNull
    /* JADX INFO: renamed from: saveAllStateInternal, reason: merged with bridge method [inline-methods] */
    public Bundle lambda$attachController$4() {
        BackStackRecordState[] backStackRecordStateArr;
        int size;
        Bundle bundle = new Bundle();
        forcePostponedTransactions();
        endAnimatingAwayFragments();
        execPendingActions(true);
        this.mStateSaved = true;
        this.mNonConfig.o(true);
        ArrayList<String> arrayListZ = this.mFragmentStore.z();
        ArrayList<FragmentState> arrayListN = this.mFragmentStore.n();
        if (!arrayListN.isEmpty()) {
            ArrayList<String> arrayListA = this.mFragmentStore.A();
            ArrayList<androidx.fragment.app.a> arrayList = this.mBackStack;
            if (arrayList == null || (size = arrayList.size()) <= 0) {
                backStackRecordStateArr = null;
            } else {
                backStackRecordStateArr = new BackStackRecordState[size];
                for (int i11 = 0; i11 < size; i11++) {
                    backStackRecordStateArr[i11] = new BackStackRecordState(this.mBackStack.get(i11));
                    if (isLoggingEnabled(2)) {
                        Log.v(TAG, "saveAllState: adding back stack #" + i11 + ": " + this.mBackStack.get(i11));
                    }
                }
            }
            FragmentManagerState fragmentManagerState = new FragmentManagerState();
            fragmentManagerState.f8501a = arrayListZ;
            fragmentManagerState.f8502b = arrayListA;
            fragmentManagerState.f8503c = backStackRecordStateArr;
            fragmentManagerState.f8504d = this.mBackStackIndex.get();
            Fragment fragment = this.mPrimaryNav;
            if (fragment != null) {
                fragmentManagerState.f8505f = fragment.mWho;
            }
            fragmentManagerState.f8506g.addAll(this.mBackStackStates.keySet());
            fragmentManagerState.f8507h.addAll(this.mBackStackStates.values());
            fragmentManagerState.f8508i = new ArrayList<>(this.mLaunchedFragments);
            bundle.putParcelable("state", fragmentManagerState);
            for (String str : this.mResults.keySet()) {
                bundle.putBundle(RESULT_NAME_PREFIX + str, this.mResults.get(str));
            }
            for (FragmentState fragmentState : arrayListN) {
                Bundle bundle2 = new Bundle();
                bundle2.putParcelable("state", fragmentState);
                bundle.putBundle(FRAGMENT_NAME_PREFIX + fragmentState.f8510b, bundle2);
            }
        } else if (isLoggingEnabled(2)) {
            Log.v(TAG, "saveAllState: no fragments!");
        }
        return bundle;
    }

    public void saveBackStack(@NonNull String str) {
        enqueueAction(new s(str), false);
    }

    public boolean saveBackStackState(@NonNull ArrayList<androidx.fragment.app.a> arrayList, @NonNull ArrayList<Boolean> arrayList2, @NonNull String str) {
        int i11;
        int iFindBackStackIndex = findBackStackIndex(str, -1, true);
        if (iFindBackStackIndex < 0) {
            return false;
        }
        for (int i12 = iFindBackStackIndex; i12 < this.mBackStack.size(); i12++) {
            androidx.fragment.app.a aVar = this.mBackStack.get(i12);
            if (!aVar.mReorderingAllowed) {
                throwException(new IllegalArgumentException("saveBackStack(\"" + str + "\") included FragmentTransactions must use setReorderingAllowed(true) to ensure that the back stack can be restored as an atomic operation. Found " + aVar + " that did not use setReorderingAllowed(true)."));
            }
        }
        HashSet hashSet = new HashSet();
        for (int i13 = iFindBackStackIndex; i13 < this.mBackStack.size(); i13++) {
            androidx.fragment.app.a aVar2 = this.mBackStack.get(i13);
            HashSet hashSet2 = new HashSet();
            HashSet hashSet3 = new HashSet();
            for (FragmentTransaction.a aVar3 : aVar2.mOps) {
                Fragment fragment = aVar3.f8537b;
                if (fragment != null) {
                    if (!aVar3.f8538c || (i11 = aVar3.f8536a) == 1 || i11 == 2 || i11 == 8) {
                        hashSet.add(fragment);
                        hashSet2.add(fragment);
                    }
                    int i14 = aVar3.f8536a;
                    if (i14 == 1 || i14 == 2) {
                        hashSet3.add(fragment);
                    }
                }
            }
            hashSet2.removeAll(hashSet3);
            if (!hashSet2.isEmpty()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("saveBackStack(\"");
                sb2.append(str);
                sb2.append("\") must be self contained and not reference fragments from non-saved FragmentTransactions. Found reference to fragment");
                sb2.append(hashSet2.size() == 1 ? " " + hashSet2.iterator().next() : "s " + hashSet2);
                sb2.append(" in ");
                sb2.append(aVar2);
                sb2.append(" that were previously added to the FragmentManager through a separate FragmentTransaction.");
                throwException(new IllegalArgumentException(sb2.toString()));
            }
        }
        ArrayDeque arrayDeque = new ArrayDeque(hashSet);
        while (!arrayDeque.isEmpty()) {
            Fragment fragment2 = (Fragment) arrayDeque.removeFirst();
            if (fragment2.mRetainInstance) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("saveBackStack(\"");
                sb3.append(str);
                sb3.append("\") must not contain retained fragments. Found ");
                sb3.append(hashSet.contains(fragment2) ? "direct reference to retained " : "retained child ");
                sb3.append("fragment ");
                sb3.append(fragment2);
                throwException(new IllegalArgumentException(sb3.toString()));
            }
            for (Fragment fragment3 : fragment2.mChildFragmentManager.getActiveFragments()) {
                if (fragment3 != null) {
                    arrayDeque.addLast(fragment3);
                }
            }
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            arrayList3.add(((Fragment) it.next()).mWho);
        }
        ArrayList arrayList4 = new ArrayList(this.mBackStack.size() - iFindBackStackIndex);
        for (int i15 = iFindBackStackIndex; i15 < this.mBackStack.size(); i15++) {
            arrayList4.add(null);
        }
        BackStackState backStackState = new BackStackState(arrayList3, arrayList4);
        for (int size = this.mBackStack.size() - 1; size >= iFindBackStackIndex; size--) {
            androidx.fragment.app.a aVarRemove = this.mBackStack.remove(size);
            androidx.fragment.app.a aVar4 = new androidx.fragment.app.a(aVarRemove);
            aVar4.c();
            arrayList4.set(size - iFindBackStackIndex, new BackStackRecordState(aVar4));
            aVarRemove.f8576d = true;
            arrayList.add(aVarRemove);
            arrayList2.add(Boolean.TRUE);
        }
        this.mBackStackStates.put(str, backStackState);
        return true;
    }

    @Nullable
    public Fragment.SavedState saveFragmentInstanceState(@NonNull Fragment fragment) {
        v vVarO = this.mFragmentStore.o(fragment.mWho);
        if (vVarO == null || !vVarO.k().equals(fragment)) {
            throwException(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        return vVarO.r();
    }

    public void scheduleCommit() {
        synchronized (this.mPendingActions) {
            try {
                if (this.mPendingActions.size() == 1) {
                    this.mHost.g().removeCallbacks(this.mExecCommit);
                    this.mHost.g().post(this.mExecCommit);
                    updateOnBackPressedCallbackEnabled();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void setExitAnimationOrder(@NonNull Fragment fragment, boolean z11) {
        ViewGroup fragmentContainer = getFragmentContainer(fragment);
        if (fragmentContainer == null || !(fragmentContainer instanceof FragmentContainerView)) {
            return;
        }
        ((FragmentContainerView) fragmentContainer).setDrawDisappearingViewsLast(!z11);
    }

    public void setFragmentFactory(@NonNull androidx.fragment.app.h hVar) {
        this.mFragmentFactory = hVar;
    }

    public final void setFragmentResult(@NonNull String str, @NonNull Bundle bundle) {
        n nVar = this.mResultListeners.get(str);
        if (nVar == null || !nVar.b(Lifecycle.State.STARTED)) {
            this.mResults.put(str, bundle);
        } else {
            nVar.a(str, bundle);
        }
        if (isLoggingEnabled(2)) {
            Log.v(TAG, "Setting fragment result with key " + str + " and result " + bundle);
        }
    }

    @SuppressLint({"SyntheticAccessor"})
    public final void setFragmentResultListener(@NonNull String str, @NonNull androidx.lifecycle.u uVar, @NonNull u uVar2) {
        Lifecycle lifecycle = uVar.getLifecycle();
        if (lifecycle.b() == Lifecycle.State.DESTROYED) {
            return;
        }
        f fVar = new f(str, uVar2, lifecycle);
        lifecycle.a(fVar);
        n nVarPut = this.mResultListeners.put(str, new n(lifecycle, uVar2, fVar));
        if (nVarPut != null) {
            nVarPut.c();
        }
        if (isLoggingEnabled(2)) {
            Log.v(TAG, "Setting FragmentResultListener with key " + str + " lifecycleOwner " + lifecycle + " and listener " + uVar2);
        }
    }

    public void setMaxLifecycle(@NonNull Fragment fragment, @NonNull Lifecycle.State state) {
        if (fragment.equals(findActiveFragment(fragment.mWho)) && (fragment.mHost == null || fragment.mFragmentManager == this)) {
            fragment.mMaxState = state;
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    public void setPrimaryNavigationFragment(@Nullable Fragment fragment) {
        if (fragment == null || (fragment.equals(findActiveFragment(fragment.mWho)) && (fragment.mHost == null || fragment.mFragmentManager == this))) {
            Fragment fragment2 = this.mPrimaryNav;
            this.mPrimaryNav = fragment;
            dispatchParentPrimaryNavigationFragmentChanged(fragment2);
            dispatchParentPrimaryNavigationFragmentChanged(this.mPrimaryNav);
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    public void setSpecialEffectsControllerFactory(@NonNull b0 b0Var) {
        this.mSpecialEffectsControllerFactory = b0Var;
    }

    public void setStrictModePolicy(@Nullable FragmentStrictMode.b bVar) {
        this.mStrictModePolicy = bVar;
    }

    public void showFragment(@NonNull Fragment fragment) {
        if (isLoggingEnabled(2)) {
            Log.v(TAG, "show: " + fragment);
        }
        if (fragment.mHidden) {
            fragment.mHidden = false;
            fragment.mHiddenChanged = !fragment.mHiddenChanged;
        }
    }

    @NonNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append("FragmentManager{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append(" in ");
        Fragment fragment = this.mParent;
        if (fragment != null) {
            sb2.append(fragment.getClass().getSimpleName());
            sb2.append("{");
            sb2.append(Integer.toHexString(System.identityHashCode(this.mParent)));
            sb2.append("}");
        } else {
            androidx.fragment.app.i<?> iVar = this.mHost;
            if (iVar != null) {
                sb2.append(iVar.getClass().getSimpleName());
                sb2.append("{");
                sb2.append(Integer.toHexString(System.identityHashCode(this.mHost)));
                sb2.append("}");
            } else {
                sb2.append("null");
            }
        }
        sb2.append("}}");
        return sb2.toString();
    }

    public void unregisterFragmentLifecycleCallbacks(@NonNull m mVar) {
        this.mLifecycleCallbacksDispatcher.p(mVar);
    }
}
