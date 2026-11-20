package androidx.fragment.app;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.t0;
import androidx.lifecycle.v0;
import androidx.lifecycle.w0;
import androidx.lifecycle.x0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class s extends t0 {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final v0.c f8604i = new a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f8608d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<String, Fragment> f8605a = new HashMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<String, s> f8606b = new HashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap<String, x0> f8607c = new HashMap<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f8609f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f8610g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f8611h = false;

    /* JADX INFO: compiled from: source.java */
    public class a implements v0.c {
        @Override // androidx.lifecycle.v0.c
        @NonNull
        public <T extends t0> T create(@NonNull Class<T> cls) {
            return new s(true);
        }

        @Override // androidx.lifecycle.v0.c
        public /* synthetic */ t0 create(Class cls, r3.a aVar) {
            return w0.b(this, cls, aVar);
        }

        @Override // androidx.lifecycle.v0.c
        public /* synthetic */ t0 create(KClass kClass, r3.a aVar) {
            return w0.c(this, kClass, aVar);
        }
    }

    public s(boolean z11) {
        this.f8608d = z11;
    }

    @NonNull
    public static s h(x0 x0Var) {
        return (s) new v0(x0Var, f8604i).a(s.class);
    }

    public void b(@NonNull Fragment fragment) {
        if (this.f8611h) {
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v(FragmentManager.TAG, "Ignoring addRetainedFragment as the state is already saved");
            }
        } else {
            if (this.f8605a.containsKey(fragment.mWho)) {
                return;
            }
            this.f8605a.put(fragment.mWho, fragment);
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v(FragmentManager.TAG, "Updating retained Fragments: Added " + fragment);
            }
        }
    }

    public void c(@NonNull Fragment fragment) {
        if (FragmentManager.isLoggingEnabled(3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Clearing non-config state for ");
            sb2.append(fragment);
        }
        e(fragment.mWho);
    }

    public void d(@NonNull String str) {
        if (FragmentManager.isLoggingEnabled(3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Clearing non-config state for saved state of Fragment ");
            sb2.append(str);
        }
        e(str);
    }

    public final void e(@NonNull String str) {
        s sVar = this.f8606b.get(str);
        if (sVar != null) {
            sVar.onCleared();
            this.f8606b.remove(str);
        }
        x0 x0Var = this.f8607c.get(str);
        if (x0Var != null) {
            x0Var.a();
            this.f8607c.remove(str);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || s.class != obj.getClass()) {
            return false;
        }
        s sVar = (s) obj;
        return this.f8605a.equals(sVar.f8605a) && this.f8606b.equals(sVar.f8606b) && this.f8607c.equals(sVar.f8607c);
    }

    @Nullable
    public Fragment f(String str) {
        return this.f8605a.get(str);
    }

    @NonNull
    public s g(@NonNull Fragment fragment) {
        s sVar = this.f8606b.get(fragment.mWho);
        if (sVar != null) {
            return sVar;
        }
        s sVar2 = new s(this.f8608d);
        this.f8606b.put(fragment.mWho, sVar2);
        return sVar2;
    }

    public int hashCode() {
        return (((this.f8605a.hashCode() * 31) + this.f8606b.hashCode()) * 31) + this.f8607c.hashCode();
    }

    @NonNull
    public Collection<Fragment> i() {
        return new ArrayList(this.f8605a.values());
    }

    @Nullable
    @Deprecated
    public r j() {
        if (this.f8605a.isEmpty() && this.f8606b.isEmpty() && this.f8607c.isEmpty()) {
            return null;
        }
        HashMap map = new HashMap();
        for (Map.Entry<String, s> entry : this.f8606b.entrySet()) {
            r rVarJ = entry.getValue().j();
            if (rVarJ != null) {
                map.put(entry.getKey(), rVarJ);
            }
        }
        this.f8610g = true;
        if (this.f8605a.isEmpty() && map.isEmpty() && this.f8607c.isEmpty()) {
            return null;
        }
        return new r(new ArrayList(this.f8605a.values()), map, new HashMap(this.f8607c));
    }

    @NonNull
    public x0 k(@NonNull Fragment fragment) {
        x0 x0Var = this.f8607c.get(fragment.mWho);
        if (x0Var != null) {
            return x0Var;
        }
        x0 x0Var2 = new x0();
        this.f8607c.put(fragment.mWho, x0Var2);
        return x0Var2;
    }

    public boolean l() {
        return this.f8609f;
    }

    public void m(@NonNull Fragment fragment) {
        if (this.f8611h) {
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v(FragmentManager.TAG, "Ignoring removeRetainedFragment as the state is already saved");
            }
        } else {
            if (this.f8605a.remove(fragment.mWho) == null || !FragmentManager.isLoggingEnabled(2)) {
                return;
            }
            Log.v(FragmentManager.TAG, "Updating retained Fragments: Removed " + fragment);
        }
    }

    @Deprecated
    public void n(@Nullable r rVar) {
        this.f8605a.clear();
        this.f8606b.clear();
        this.f8607c.clear();
        if (rVar != null) {
            Collection<Fragment> collectionB = rVar.b();
            if (collectionB != null) {
                for (Fragment fragment : collectionB) {
                    if (fragment != null) {
                        this.f8605a.put(fragment.mWho, fragment);
                    }
                }
            }
            Map<String, r> mapA = rVar.a();
            if (mapA != null) {
                for (Map.Entry<String, r> entry : mapA.entrySet()) {
                    s sVar = new s(this.f8608d);
                    sVar.n(entry.getValue());
                    this.f8606b.put(entry.getKey(), sVar);
                }
            }
            Map<String, x0> mapC = rVar.c();
            if (mapC != null) {
                this.f8607c.putAll(mapC);
            }
        }
        this.f8610g = false;
    }

    public void o(boolean z11) {
        this.f8611h = z11;
    }

    @Override // androidx.lifecycle.t0
    public void onCleared() {
        if (FragmentManager.isLoggingEnabled(3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onCleared called for ");
            sb2.append(this);
        }
        this.f8609f = true;
    }

    public boolean p(@NonNull Fragment fragment) {
        if (this.f8605a.containsKey(fragment.mWho)) {
            return this.f8608d ? this.f8609f : !this.f8610g;
        }
        return true;
    }

    @NonNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder("FragmentManagerViewModel{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append("} Fragments (");
        Iterator<Fragment> it = this.f8605a.values().iterator();
        while (it.hasNext()) {
            sb2.append(it.next());
            if (it.hasNext()) {
                sb2.append(", ");
            }
        }
        sb2.append(") Child Non Config (");
        Iterator<String> it2 = this.f8606b.keySet().iterator();
        while (it2.hasNext()) {
            sb2.append(it2.next());
            if (it2.hasNext()) {
                sb2.append(", ");
            }
        }
        sb2.append(") ViewModelStores (");
        Iterator<String> it3 = this.f8607c.keySet().iterator();
        while (it3.hasNext()) {
            sb2.append(it3.next());
            if (it3.hasNext()) {
                sb2.append(", ");
            }
        }
        sb2.append(')');
        return sb2.toString();
    }
}
