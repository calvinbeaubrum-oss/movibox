package androidx.fragment.app;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import java.io.PrintWriter;
import java.util.ArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a extends FragmentTransaction implements FragmentManager.j, FragmentManager.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FragmentManager f8573a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f8574b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f8575c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f8576d;

    public a(@NonNull FragmentManager fragmentManager) {
        super(fragmentManager.getFragmentFactory(), fragmentManager.getHost() != null ? fragmentManager.getHost().f().getClassLoader() : null);
        this.f8575c = -1;
        this.f8576d = false;
        this.f8573a = fragmentManager;
    }

    public a(@NonNull a aVar) {
        super(aVar.f8573a.getFragmentFactory(), aVar.f8573a.getHost() != null ? aVar.f8573a.getHost().f().getClassLoader() : null, aVar);
        this.f8575c = -1;
        this.f8576d = false;
        this.f8573a = aVar.f8573a;
        this.f8574b = aVar.f8574b;
        this.f8575c = aVar.f8575c;
        this.f8576d = aVar.f8576d;
    }

    @Override // androidx.fragment.app.FragmentManager.p
    public boolean a(@NonNull ArrayList<a> arrayList, @NonNull ArrayList<Boolean> arrayList2) {
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v(FragmentManager.TAG, "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (!this.mAddToBackStack) {
            return true;
        }
        this.f8573a.addBackStackState(this);
        return true;
    }

    public void b(int i11) {
        if (this.mAddToBackStack) {
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v(FragmentManager.TAG, "Bump nesting in " + this + " by " + i11);
            }
            int size = this.mOps.size();
            for (int i12 = 0; i12 < size; i12++) {
                FragmentTransaction.a aVar = this.mOps.get(i12);
                Fragment fragment = aVar.f8537b;
                if (fragment != null) {
                    fragment.mBackStackNesting += i11;
                    if (FragmentManager.isLoggingEnabled(2)) {
                        Log.v(FragmentManager.TAG, "Bump nesting of " + aVar.f8537b + " to " + aVar.f8537b.mBackStackNesting);
                    }
                }
            }
        }
    }

    public void c() {
        int size = this.mOps.size() - 1;
        while (size >= 0) {
            FragmentTransaction.a aVar = this.mOps.get(size);
            if (aVar.f8538c) {
                if (aVar.f8536a == 8) {
                    aVar.f8538c = false;
                    this.mOps.remove(size - 1);
                    size--;
                } else {
                    int i11 = aVar.f8537b.mContainerId;
                    aVar.f8536a = 2;
                    aVar.f8538c = false;
                    for (int i12 = size - 1; i12 >= 0; i12--) {
                        FragmentTransaction.a aVar2 = this.mOps.get(i12);
                        if (aVar2.f8538c && aVar2.f8537b.mContainerId == i11) {
                            this.mOps.remove(i12);
                            size--;
                        }
                    }
                }
            }
            size--;
        }
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public int commit() {
        return d(false);
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public int commitAllowingStateLoss() {
        return d(true);
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public void commitNow() {
        disallowAddToBackStack();
        this.f8573a.execSingleAction(this, false);
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public void commitNowAllowingStateLoss() {
        disallowAddToBackStack();
        this.f8573a.execSingleAction(this, true);
    }

    public int d(boolean z11) {
        if (this.f8574b) {
            throw new IllegalStateException("commit already called");
        }
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v(FragmentManager.TAG, "Commit: " + this);
            PrintWriter printWriter = new PrintWriter(new a0(FragmentManager.TAG));
            e("  ", printWriter);
            printWriter.close();
        }
        this.f8574b = true;
        if (this.mAddToBackStack) {
            this.f8575c = this.f8573a.allocBackStackIndex();
        } else {
            this.f8575c = -1;
        }
        this.f8573a.enqueueAction(this, z11);
        return this.f8575c;
    }

    @Override // androidx.fragment.app.FragmentTransaction
    @NonNull
    public FragmentTransaction detach(@NonNull Fragment fragment) {
        FragmentManager fragmentManager = fragment.mFragmentManager;
        if (fragmentManager == null || fragmentManager == this.f8573a) {
            return super.detach(fragment);
        }
        throw new IllegalStateException("Cannot detach Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public void doAddOp(int i11, Fragment fragment, @Nullable String str, int i12) {
        super.doAddOp(i11, fragment, str, i12);
        fragment.mFragmentManager = this.f8573a;
    }

    public void e(String str, PrintWriter printWriter) {
        f(str, printWriter, true);
    }

    public void f(String str, PrintWriter printWriter, boolean z11) {
        String str2;
        if (z11) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.mName);
            printWriter.print(" mIndex=");
            printWriter.print(this.f8575c);
            printWriter.print(" mCommitted=");
            printWriter.println(this.f8574b);
            if (this.mTransition != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.mTransition));
            }
            if (this.mEnterAnim != 0 || this.mExitAnim != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.mEnterAnim));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.mExitAnim));
            }
            if (this.mPopEnterAnim != 0 || this.mPopExitAnim != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.mPopEnterAnim));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.mPopExitAnim));
            }
            if (this.mBreadCrumbTitleRes != 0 || this.mBreadCrumbTitleText != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.mBreadCrumbTitleRes));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.mBreadCrumbTitleText);
            }
            if (this.mBreadCrumbShortTitleRes != 0 || this.mBreadCrumbShortTitleText != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.mBreadCrumbShortTitleRes));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.mBreadCrumbShortTitleText);
            }
        }
        if (this.mOps.isEmpty()) {
            return;
        }
        printWriter.print(str);
        printWriter.println("Operations:");
        int size = this.mOps.size();
        for (int i11 = 0; i11 < size; i11++) {
            FragmentTransaction.a aVar = this.mOps.get(i11);
            switch (aVar.f8536a) {
                case 0:
                    str2 = "NULL";
                    break;
                case 1:
                    str2 = "ADD";
                    break;
                case 2:
                    str2 = "REPLACE";
                    break;
                case 3:
                    str2 = "REMOVE";
                    break;
                case 4:
                    str2 = "HIDE";
                    break;
                case 5:
                    str2 = "SHOW";
                    break;
                case 6:
                    str2 = "DETACH";
                    break;
                case 7:
                    str2 = "ATTACH";
                    break;
                case 8:
                    str2 = "SET_PRIMARY_NAV";
                    break;
                case 9:
                    str2 = "UNSET_PRIMARY_NAV";
                    break;
                case 10:
                    str2 = "OP_SET_MAX_LIFECYCLE";
                    break;
                default:
                    str2 = "cmd=" + aVar.f8536a;
                    break;
            }
            printWriter.print(str);
            printWriter.print("  Op #");
            printWriter.print(i11);
            printWriter.print(": ");
            printWriter.print(str2);
            printWriter.print(" ");
            printWriter.println(aVar.f8537b);
            if (z11) {
                if (aVar.f8539d != 0 || aVar.f8540e != 0) {
                    printWriter.print(str);
                    printWriter.print("enterAnim=#");
                    printWriter.print(Integer.toHexString(aVar.f8539d));
                    printWriter.print(" exitAnim=#");
                    printWriter.println(Integer.toHexString(aVar.f8540e));
                }
                if (aVar.f8541f != 0 || aVar.f8542g != 0) {
                    printWriter.print(str);
                    printWriter.print("popEnterAnim=#");
                    printWriter.print(Integer.toHexString(aVar.f8541f));
                    printWriter.print(" popExitAnim=#");
                    printWriter.println(Integer.toHexString(aVar.f8542g));
                }
            }
        }
    }

    public void g() {
        int size = this.mOps.size();
        for (int i11 = 0; i11 < size; i11++) {
            FragmentTransaction.a aVar = this.mOps.get(i11);
            Fragment fragment = aVar.f8537b;
            if (fragment != null) {
                fragment.mBeingSaved = this.f8576d;
                fragment.setPopDirection(false);
                fragment.setNextTransition(this.mTransition);
                fragment.setSharedElementNames(this.mSharedElementSourceNames, this.mSharedElementTargetNames);
            }
            switch (aVar.f8536a) {
                case 1:
                    fragment.setAnimations(aVar.f8539d, aVar.f8540e, aVar.f8541f, aVar.f8542g);
                    this.f8573a.setExitAnimationOrder(fragment, false);
                    this.f8573a.addFragment(fragment);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.f8536a);
                case 3:
                    fragment.setAnimations(aVar.f8539d, aVar.f8540e, aVar.f8541f, aVar.f8542g);
                    this.f8573a.removeFragment(fragment);
                    break;
                case 4:
                    fragment.setAnimations(aVar.f8539d, aVar.f8540e, aVar.f8541f, aVar.f8542g);
                    this.f8573a.hideFragment(fragment);
                    break;
                case 5:
                    fragment.setAnimations(aVar.f8539d, aVar.f8540e, aVar.f8541f, aVar.f8542g);
                    this.f8573a.setExitAnimationOrder(fragment, false);
                    this.f8573a.showFragment(fragment);
                    break;
                case 6:
                    fragment.setAnimations(aVar.f8539d, aVar.f8540e, aVar.f8541f, aVar.f8542g);
                    this.f8573a.detachFragment(fragment);
                    break;
                case 7:
                    fragment.setAnimations(aVar.f8539d, aVar.f8540e, aVar.f8541f, aVar.f8542g);
                    this.f8573a.setExitAnimationOrder(fragment, false);
                    this.f8573a.attachFragment(fragment);
                    break;
                case 8:
                    this.f8573a.setPrimaryNavigationFragment(fragment);
                    break;
                case 9:
                    this.f8573a.setPrimaryNavigationFragment(null);
                    break;
                case 10:
                    this.f8573a.setMaxLifecycle(fragment, aVar.f8544i);
                    break;
            }
        }
    }

    public void h() {
        for (int size = this.mOps.size() - 1; size >= 0; size--) {
            FragmentTransaction.a aVar = this.mOps.get(size);
            Fragment fragment = aVar.f8537b;
            if (fragment != null) {
                fragment.mBeingSaved = this.f8576d;
                fragment.setPopDirection(true);
                fragment.setNextTransition(FragmentManager.reverseTransit(this.mTransition));
                fragment.setSharedElementNames(this.mSharedElementTargetNames, this.mSharedElementSourceNames);
            }
            switch (aVar.f8536a) {
                case 1:
                    fragment.setAnimations(aVar.f8539d, aVar.f8540e, aVar.f8541f, aVar.f8542g);
                    this.f8573a.setExitAnimationOrder(fragment, true);
                    this.f8573a.removeFragment(fragment);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.f8536a);
                case 3:
                    fragment.setAnimations(aVar.f8539d, aVar.f8540e, aVar.f8541f, aVar.f8542g);
                    this.f8573a.addFragment(fragment);
                    break;
                case 4:
                    fragment.setAnimations(aVar.f8539d, aVar.f8540e, aVar.f8541f, aVar.f8542g);
                    this.f8573a.showFragment(fragment);
                    break;
                case 5:
                    fragment.setAnimations(aVar.f8539d, aVar.f8540e, aVar.f8541f, aVar.f8542g);
                    this.f8573a.setExitAnimationOrder(fragment, true);
                    this.f8573a.hideFragment(fragment);
                    break;
                case 6:
                    fragment.setAnimations(aVar.f8539d, aVar.f8540e, aVar.f8541f, aVar.f8542g);
                    this.f8573a.attachFragment(fragment);
                    break;
                case 7:
                    fragment.setAnimations(aVar.f8539d, aVar.f8540e, aVar.f8541f, aVar.f8542g);
                    this.f8573a.setExitAnimationOrder(fragment, true);
                    this.f8573a.detachFragment(fragment);
                    break;
                case 8:
                    this.f8573a.setPrimaryNavigationFragment(null);
                    break;
                case 9:
                    this.f8573a.setPrimaryNavigationFragment(fragment);
                    break;
                case 10:
                    this.f8573a.setMaxLifecycle(fragment, aVar.f8543h);
                    break;
            }
        }
    }

    @Override // androidx.fragment.app.FragmentTransaction
    @NonNull
    public FragmentTransaction hide(@NonNull Fragment fragment) {
        FragmentManager fragmentManager = fragment.mFragmentManager;
        if (fragmentManager == null || fragmentManager == this.f8573a) {
            return super.hide(fragment);
        }
        throw new IllegalStateException("Cannot hide Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00b6  */
    public Fragment i(ArrayList<Fragment> arrayList, Fragment fragment) {
        Fragment fragment2 = fragment;
        int i11 = 0;
        while (i11 < this.mOps.size()) {
            FragmentTransaction.a aVar = this.mOps.get(i11);
            int i12 = aVar.f8536a;
            if (i12 == 1) {
                arrayList.add(aVar.f8537b);
            } else if (i12 == 2) {
                Fragment fragment3 = aVar.f8537b;
                int i13 = fragment3.mContainerId;
                boolean z11 = false;
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    Fragment fragment4 = arrayList.get(size);
                    if (fragment4.mContainerId == i13) {
                        if (fragment4 == fragment3) {
                            z11 = true;
                        } else {
                            if (fragment4 == fragment2) {
                                this.mOps.add(i11, new FragmentTransaction.a(9, fragment4, true));
                                i11++;
                                fragment2 = null;
                            }
                            FragmentTransaction.a aVar2 = new FragmentTransaction.a(3, fragment4, true);
                            aVar2.f8539d = aVar.f8539d;
                            aVar2.f8541f = aVar.f8541f;
                            aVar2.f8540e = aVar.f8540e;
                            aVar2.f8542g = aVar.f8542g;
                            this.mOps.add(i11, aVar2);
                            arrayList.remove(fragment4);
                            i11++;
                        }
                    }
                }
                if (z11) {
                    this.mOps.remove(i11);
                    i11--;
                } else {
                    aVar.f8536a = 1;
                    aVar.f8538c = true;
                    arrayList.add(fragment3);
                }
            } else if (i12 == 3 || i12 == 6) {
                arrayList.remove(aVar.f8537b);
                Fragment fragment5 = aVar.f8537b;
                if (fragment5 == fragment2) {
                    this.mOps.add(i11, new FragmentTransaction.a(9, fragment5));
                    i11++;
                    fragment2 = null;
                }
            } else if (i12 == 7) {
                arrayList.add(aVar.f8537b);
            } else if (i12 == 8) {
                this.mOps.add(i11, new FragmentTransaction.a(9, fragment2, true));
                aVar.f8538c = true;
                i11++;
                fragment2 = aVar.f8537b;
            }
            i11++;
        }
        return fragment2;
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public boolean isEmpty() {
        return this.mOps.isEmpty();
    }

    @Nullable
    public String j() {
        return this.mName;
    }

    public void k() {
        if (this.mCommitRunnables != null) {
            for (int i11 = 0; i11 < this.mCommitRunnables.size(); i11++) {
                this.mCommitRunnables.get(i11).run();
            }
            this.mCommitRunnables = null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0027  */
    /* JADX WARN: Code duplicated, block: B:14:0x002d  */
    public Fragment l(ArrayList<Fragment> arrayList, Fragment fragment) {
        for (int size = this.mOps.size() - 1; size >= 0; size--) {
            FragmentTransaction.a aVar = this.mOps.get(size);
            int i11 = aVar.f8536a;
            if (i11 == 1) {
                arrayList.remove(aVar.f8537b);
            } else if (i11 != 3) {
                switch (i11) {
                    case 6:
                        arrayList.add(aVar.f8537b);
                        break;
                    case 7:
                        arrayList.remove(aVar.f8537b);
                        break;
                    case 8:
                        fragment = null;
                        break;
                    case 9:
                        fragment = aVar.f8537b;
                        break;
                    case 10:
                        aVar.f8544i = aVar.f8543h;
                        break;
                }
            } else {
                arrayList.add(aVar.f8537b);
            }
        }
        return fragment;
    }

    @Override // androidx.fragment.app.FragmentTransaction
    @NonNull
    public FragmentTransaction remove(@NonNull Fragment fragment) {
        FragmentManager fragmentManager = fragment.mFragmentManager;
        if (fragmentManager == null || fragmentManager == this.f8573a) {
            return super.remove(fragment);
        }
        throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    @Override // androidx.fragment.app.FragmentTransaction
    @NonNull
    public FragmentTransaction setMaxLifecycle(@NonNull Fragment fragment, @NonNull Lifecycle.State state) {
        if (fragment.mFragmentManager != this.f8573a) {
            throw new IllegalArgumentException("Cannot setMaxLifecycle for Fragment not attached to FragmentManager " + this.f8573a);
        }
        if (state == Lifecycle.State.INITIALIZED && fragment.mState > -1) {
            throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + state + " after the Fragment has been created");
        }
        if (state != Lifecycle.State.DESTROYED) {
            return super.setMaxLifecycle(fragment, state);
        }
        throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + state + ". Use remove() to remove the fragment from the FragmentManager and trigger its destruction.");
    }

    @Override // androidx.fragment.app.FragmentTransaction
    @NonNull
    public FragmentTransaction setPrimaryNavigationFragment(@Nullable Fragment fragment) {
        FragmentManager fragmentManager;
        if (fragment == null || (fragmentManager = fragment.mFragmentManager) == null || fragmentManager == this.f8573a) {
            return super.setPrimaryNavigationFragment(fragment);
        }
        throw new IllegalStateException("Cannot setPrimaryNavigation for Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    @Override // androidx.fragment.app.FragmentTransaction
    @NonNull
    public FragmentTransaction show(@NonNull Fragment fragment) {
        FragmentManager fragmentManager = fragment.mFragmentManager;
        if (fragmentManager == null || fragmentManager == this.f8573a) {
            return super.show(fragment);
        }
        throw new IllegalStateException("Cannot show Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append("BackStackEntry{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.f8575c >= 0) {
            sb2.append(" #");
            sb2.append(this.f8575c);
        }
        if (this.mName != null) {
            sb2.append(" ");
            sb2.append(this.mName);
        }
        sb2.append("}");
        return sb2.toString();
    }
}
