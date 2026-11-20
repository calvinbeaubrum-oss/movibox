package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<Fragment> f8626a = new ArrayList<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<String, v> f8627b = new HashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap<String, FragmentState> f8628c = new HashMap<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public s f8629d;

    @Nullable
    public ArrayList<String> A() {
        synchronized (this.f8626a) {
            try {
                if (this.f8626a.isEmpty()) {
                    return null;
                }
                ArrayList<String> arrayList = new ArrayList<>(this.f8626a.size());
                for (Fragment fragment : this.f8626a) {
                    arrayList.add(fragment.mWho);
                    if (FragmentManager.isLoggingEnabled(2)) {
                        Log.v(FragmentManager.TAG, "saveAllState: adding fragment (" + fragment.mWho + "): " + fragment);
                    }
                }
                return arrayList;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void B(@NonNull s sVar) {
        this.f8629d = sVar;
    }

    @Nullable
    public FragmentState C(@NonNull String str, @Nullable FragmentState fragmentState) {
        return fragmentState != null ? this.f8628c.put(str, fragmentState) : this.f8628c.remove(str);
    }

    public void a(@NonNull Fragment fragment) {
        if (this.f8626a.contains(fragment)) {
            throw new IllegalStateException("Fragment already added: " + fragment);
        }
        synchronized (this.f8626a) {
            this.f8626a.add(fragment);
        }
        fragment.mAdded = true;
    }

    public void b() {
        this.f8627b.values().removeAll(Collections.singleton(null));
    }

    public boolean c(@NonNull String str) {
        return this.f8627b.get(str) != null;
    }

    public void d(int i11) {
        for (v vVar : this.f8627b.values()) {
            if (vVar != null) {
                vVar.u(i11);
            }
        }
    }

    public void e(@NonNull String str, @Nullable FileDescriptor fileDescriptor, @NonNull PrintWriter printWriter, @Nullable String[] strArr) {
        String str2 = str + "    ";
        if (!this.f8627b.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Active Fragments:");
            for (v vVar : this.f8627b.values()) {
                printWriter.print(str);
                if (vVar != null) {
                    Fragment fragmentK = vVar.k();
                    printWriter.println(fragmentK);
                    fragmentK.dump(str2, fileDescriptor, printWriter, strArr);
                } else {
                    printWriter.println("null");
                }
            }
        }
        int size = this.f8626a.size();
        if (size > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i11 = 0; i11 < size; i11++) {
                Fragment fragment = this.f8626a.get(i11);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i11);
                printWriter.print(": ");
                printWriter.println(fragment.toString());
            }
        }
    }

    @Nullable
    public Fragment f(@NonNull String str) {
        v vVar = this.f8627b.get(str);
        if (vVar != null) {
            return vVar.k();
        }
        return null;
    }

    @Nullable
    public Fragment g(int i11) {
        for (int size = this.f8626a.size() - 1; size >= 0; size--) {
            Fragment fragment = this.f8626a.get(size);
            if (fragment != null && fragment.mFragmentId == i11) {
                return fragment;
            }
        }
        for (v vVar : this.f8627b.values()) {
            if (vVar != null) {
                Fragment fragmentK = vVar.k();
                if (fragmentK.mFragmentId == i11) {
                    return fragmentK;
                }
            }
        }
        return null;
    }

    @Nullable
    public Fragment h(@Nullable String str) {
        if (str != null) {
            for (int size = this.f8626a.size() - 1; size >= 0; size--) {
                Fragment fragment = this.f8626a.get(size);
                if (fragment != null && str.equals(fragment.mTag)) {
                    return fragment;
                }
            }
        }
        if (str == null) {
            return null;
        }
        for (v vVar : this.f8627b.values()) {
            if (vVar != null) {
                Fragment fragmentK = vVar.k();
                if (str.equals(fragmentK.mTag)) {
                    return fragmentK;
                }
            }
        }
        return null;
    }

    @Nullable
    public Fragment i(@NonNull String str) {
        Fragment fragmentFindFragmentByWho;
        for (v vVar : this.f8627b.values()) {
            if (vVar != null && (fragmentFindFragmentByWho = vVar.k().findFragmentByWho(str)) != null) {
                return fragmentFindFragmentByWho;
            }
        }
        return null;
    }

    public int j(@NonNull Fragment fragment) {
        View view;
        View view2;
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup == null) {
            return -1;
        }
        int iIndexOf = this.f8626a.indexOf(fragment);
        for (int i11 = iIndexOf - 1; i11 >= 0; i11--) {
            Fragment fragment2 = this.f8626a.get(i11);
            if (fragment2.mContainer == viewGroup && (view2 = fragment2.mView) != null) {
                return viewGroup.indexOfChild(view2) + 1;
            }
        }
        while (true) {
            iIndexOf++;
            if (iIndexOf >= this.f8626a.size()) {
                return -1;
            }
            Fragment fragment3 = this.f8626a.get(iIndexOf);
            if (fragment3.mContainer == viewGroup && (view = fragment3.mView) != null) {
                return viewGroup.indexOfChild(view);
            }
        }
    }

    public int k() {
        return this.f8627b.size();
    }

    @NonNull
    public List<v> l() {
        ArrayList arrayList = new ArrayList();
        for (v vVar : this.f8627b.values()) {
            if (vVar != null) {
                arrayList.add(vVar);
            }
        }
        return arrayList;
    }

    @NonNull
    public List<Fragment> m() {
        ArrayList arrayList = new ArrayList();
        for (v vVar : this.f8627b.values()) {
            if (vVar != null) {
                arrayList.add(vVar.k());
            } else {
                arrayList.add(null);
            }
        }
        return arrayList;
    }

    @NonNull
    public ArrayList<FragmentState> n() {
        return new ArrayList<>(this.f8628c.values());
    }

    @Nullable
    public v o(@NonNull String str) {
        return this.f8627b.get(str);
    }

    @NonNull
    public List<Fragment> p() {
        ArrayList arrayList;
        if (this.f8626a.isEmpty()) {
            return Collections.emptyList();
        }
        synchronized (this.f8626a) {
            arrayList = new ArrayList(this.f8626a);
        }
        return arrayList;
    }

    public s q() {
        return this.f8629d;
    }

    @Nullable
    public FragmentState r(@NonNull String str) {
        return this.f8628c.get(str);
    }

    public void s(@NonNull v vVar) {
        Fragment fragmentK = vVar.k();
        if (c(fragmentK.mWho)) {
            return;
        }
        this.f8627b.put(fragmentK.mWho, vVar);
        if (fragmentK.mRetainInstanceChangedWhileDetached) {
            if (fragmentK.mRetainInstance) {
                this.f8629d.b(fragmentK);
            } else {
                this.f8629d.m(fragmentK);
            }
            fragmentK.mRetainInstanceChangedWhileDetached = false;
        }
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v(FragmentManager.TAG, "Added fragment to active set " + fragmentK);
        }
    }

    public void t(@NonNull v vVar) {
        Fragment fragmentK = vVar.k();
        if (fragmentK.mRetainInstance) {
            this.f8629d.m(fragmentK);
        }
        if (this.f8627b.put(fragmentK.mWho, null) != null && FragmentManager.isLoggingEnabled(2)) {
            Log.v(FragmentManager.TAG, "Removed fragment from active set " + fragmentK);
        }
    }

    public void u() {
        Iterator<Fragment> it = this.f8626a.iterator();
        while (it.hasNext()) {
            v vVar = this.f8627b.get(it.next().mWho);
            if (vVar != null) {
                vVar.m();
            }
        }
        for (v vVar2 : this.f8627b.values()) {
            if (vVar2 != null) {
                vVar2.m();
                Fragment fragmentK = vVar2.k();
                if (fragmentK.mRemoving && !fragmentK.isInBackStack()) {
                    if (fragmentK.mBeingSaved && !this.f8628c.containsKey(fragmentK.mWho)) {
                        vVar2.s();
                    }
                    t(vVar2);
                }
            }
        }
    }

    public void v(@NonNull Fragment fragment) {
        synchronized (this.f8626a) {
            this.f8626a.remove(fragment);
        }
        fragment.mAdded = false;
    }

    public void w() {
        this.f8627b.clear();
    }

    public void x(@Nullable List<String> list) {
        this.f8626a.clear();
        if (list != null) {
            for (String str : list) {
                Fragment fragmentF = f(str);
                if (fragmentF == null) {
                    throw new IllegalStateException("No instantiated fragment for (" + str + ")");
                }
                if (FragmentManager.isLoggingEnabled(2)) {
                    Log.v(FragmentManager.TAG, "restoreSaveState: added (" + str + "): " + fragmentF);
                }
                a(fragmentF);
            }
        }
    }

    public void y(@NonNull ArrayList<FragmentState> arrayList) {
        this.f8628c.clear();
        for (FragmentState fragmentState : arrayList) {
            this.f8628c.put(fragmentState.f8510b, fragmentState);
        }
    }

    @NonNull
    public ArrayList<String> z() {
        ArrayList<String> arrayList = new ArrayList<>(this.f8627b.size());
        for (v vVar : this.f8627b.values()) {
            if (vVar != null) {
                Fragment fragmentK = vVar.k();
                vVar.s();
                arrayList.add(fragmentK.mWho);
                if (FragmentManager.isLoggingEnabled(2)) {
                    Log.v(FragmentManager.TAG, "Saved state of " + fragmentK + ": " + fragmentK.mSavedFragmentState);
                }
            }
        }
        return arrayList;
    }
}
