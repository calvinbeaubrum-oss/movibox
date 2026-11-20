package b1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.activity.result.ActivityResult;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.r;
import androidx.lifecycle.u;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.random.Random;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Integer, String> f13882a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Integer> f13883b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, e> f13884c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ArrayList<String> f13885d = new ArrayList<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final transient Map<String, d<?>> f13886e = new HashMap();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, Object> f13887f = new HashMap();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Bundle f13888g = new Bundle();

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public class a implements r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f13889a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b1.a f13890b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ c1.a f13891c;

        public a(String str, b1.a aVar, c1.a aVar2) {
            this.f13889a = str;
            this.f13890b = aVar;
            this.f13891c = aVar2;
        }

        @Override // androidx.lifecycle.r
        public void onStateChanged(@NonNull u uVar, @NonNull Lifecycle.Event event) {
            if (!Lifecycle.Event.ON_START.equals(event)) {
                if (Lifecycle.Event.ON_STOP.equals(event)) {
                    c.this.f13886e.remove(this.f13889a);
                    return;
                } else {
                    if (Lifecycle.Event.ON_DESTROY.equals(event)) {
                        c.this.l(this.f13889a);
                        return;
                    }
                    return;
                }
            }
            c.this.f13886e.put(this.f13889a, new d<>(this.f13890b, this.f13891c));
            if (c.this.f13887f.containsKey(this.f13889a)) {
                Object obj = c.this.f13887f.get(this.f13889a);
                c.this.f13887f.remove(this.f13889a);
                this.f13890b.a(obj);
            }
            ActivityResult activityResult = (ActivityResult) c.this.f13888g.getParcelable(this.f13889a);
            if (activityResult != null) {
                c.this.f13888g.remove(this.f13889a);
                this.f13890b.a(this.f13891c.c(activityResult.getResultCode(), activityResult.getData()));
            }
        }
    }

    /* JADX INFO: Add missing generic type declarations: [I] */
    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public class b<I> extends b1.b<I> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f13893a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c1.a f13894b;

        public b(String str, c1.a aVar) {
            this.f13893a = str;
            this.f13894b = aVar;
        }

        @Override // b1.b
        public void b(I i11, @Nullable androidx.core.app.b bVar) throws Exception {
            Integer num = c.this.f13883b.get(this.f13893a);
            if (num != null) {
                c.this.f13885d.add(this.f13893a);
                try {
                    c.this.f(num.intValue(), this.f13894b, i11, bVar);
                    return;
                } catch (Exception e11) {
                    c.this.f13885d.remove(this.f13893a);
                    throw e11;
                }
            }
            throw new IllegalStateException("Attempting to launch an unregistered ActivityResultLauncher with contract " + this.f13894b + " and input " + i11 + ". You must ensure the ActivityResultLauncher is registered before calling launch().");
        }

        @Override // b1.b
        public void c() {
            c.this.l(this.f13893a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [I] */
    /* JADX INFO: renamed from: b1.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public class C0138c<I> extends b1.b<I> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f13896a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c1.a f13897b;

        public C0138c(String str, c1.a aVar) {
            this.f13896a = str;
            this.f13897b = aVar;
        }

        @Override // b1.b
        public void b(I i11, @Nullable androidx.core.app.b bVar) throws Exception {
            Integer num = c.this.f13883b.get(this.f13896a);
            if (num != null) {
                c.this.f13885d.add(this.f13896a);
                try {
                    c.this.f(num.intValue(), this.f13897b, i11, bVar);
                    return;
                } catch (Exception e11) {
                    c.this.f13885d.remove(this.f13896a);
                    throw e11;
                }
            }
            throw new IllegalStateException("Attempting to launch an unregistered ActivityResultLauncher with contract " + this.f13897b + " and input " + i11 + ". You must ensure the ActivityResultLauncher is registered before calling launch().");
        }

        @Override // b1.b
        public void c() {
            c.this.l(this.f13896a);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public static class d<O> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b1.a<O> f13899a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final c1.a<?, O> f13900b;

        public d(b1.a<O> aVar, c1.a<?, O> aVar2) {
            this.f13899a = aVar;
            this.f13900b = aVar2;
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Lifecycle f13901a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ArrayList<r> f13902b = new ArrayList<>();

        public e(@NonNull Lifecycle lifecycle) {
            this.f13901a = lifecycle;
        }

        public void a(@NonNull r rVar) {
            this.f13901a.a(rVar);
            this.f13902b.add(rVar);
        }

        public void b() {
            Iterator<r> it = this.f13902b.iterator();
            while (it.hasNext()) {
                this.f13901a.d(it.next());
            }
            this.f13902b.clear();
        }
    }

    public final void a(int i11, String str) {
        this.f13882a.put(Integer.valueOf(i11), str);
        this.f13883b.put(str, Integer.valueOf(i11));
    }

    public final boolean b(int i11, int i12, @Nullable Intent intent) {
        String str = this.f13882a.get(Integer.valueOf(i11));
        if (str == null) {
            return false;
        }
        d(str, i12, intent, this.f13886e.get(str));
        return true;
    }

    public final <O> boolean c(int i11, @SuppressLint({"UnknownNullness"}) O o11) {
        b1.a<?> aVar;
        String str = this.f13882a.get(Integer.valueOf(i11));
        if (str == null) {
            return false;
        }
        d<?> dVar = this.f13886e.get(str);
        if (dVar == null || (aVar = dVar.f13899a) == null) {
            this.f13888g.remove(str);
            this.f13887f.put(str, o11);
            return true;
        }
        if (!this.f13885d.remove(str)) {
            return true;
        }
        aVar.a(o11);
        return true;
    }

    public final <O> void d(String str, int i11, @Nullable Intent intent, @Nullable d<O> dVar) {
        if (dVar == null || dVar.f13899a == null || !this.f13885d.contains(str)) {
            this.f13887f.remove(str);
            this.f13888g.putParcelable(str, new ActivityResult(i11, intent));
        } else {
            dVar.f13899a.a(dVar.f13900b.c(i11, intent));
            this.f13885d.remove(str);
        }
    }

    public final int e() {
        int iNextInt = Random.Default.nextInt(2147418112);
        while (true) {
            int i11 = iNextInt + 65536;
            if (!this.f13882a.containsKey(Integer.valueOf(i11))) {
                return i11;
            }
            iNextInt = Random.Default.nextInt(2147418112);
        }
    }

    public abstract <I, O> void f(int i11, @NonNull c1.a<I, O> aVar, @SuppressLint({"UnknownNullness"}) I i12, @Nullable androidx.core.app.b bVar);

    public final void g(@Nullable Bundle bundle) {
        if (bundle == null) {
            return;
        }
        ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
        ArrayList<String> stringArrayList = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
        if (stringArrayList == null || integerArrayList == null) {
            return;
        }
        this.f13885d = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS");
        this.f13888g.putAll(bundle.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT"));
        for (int i11 = 0; i11 < stringArrayList.size(); i11++) {
            String str = stringArrayList.get(i11);
            if (this.f13883b.containsKey(str)) {
                Integer numRemove = this.f13883b.remove(str);
                if (!this.f13888g.containsKey(str)) {
                    this.f13882a.remove(numRemove);
                }
            }
            a(integerArrayList.get(i11).intValue(), stringArrayList.get(i11));
        }
    }

    public final void h(@NonNull Bundle bundle) {
        bundle.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", new ArrayList<>(this.f13883b.values()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", new ArrayList<>(this.f13883b.keySet()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS", new ArrayList<>(this.f13885d));
        bundle.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", (Bundle) this.f13888g.clone());
    }

    @NonNull
    public final <I, O> b1.b<I> i(@NonNull String str, @NonNull u uVar, @NonNull c1.a<I, O> aVar, @NonNull b1.a<O> aVar2) {
        Lifecycle lifecycle = uVar.getLifecycle();
        if (lifecycle.b().isAtLeast(Lifecycle.State.STARTED)) {
            throw new IllegalStateException("LifecycleOwner " + uVar + " is attempting to register while current state is " + lifecycle.b() + ". LifecycleOwners must call register before they are STARTED.");
        }
        k(str);
        e eVar = this.f13884c.get(str);
        if (eVar == null) {
            eVar = new e(lifecycle);
        }
        eVar.a(new a(str, aVar2, aVar));
        this.f13884c.put(str, eVar);
        return new b(str, aVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    public final <I, O> b1.b<I> j(@NonNull String str, @NonNull c1.a<I, O> aVar, @NonNull b1.a<O> aVar2) {
        k(str);
        this.f13886e.put(str, new d<>(aVar2, aVar));
        if (this.f13887f.containsKey(str)) {
            Object obj = this.f13887f.get(str);
            this.f13887f.remove(str);
            aVar2.a(obj);
        }
        ActivityResult activityResult = (ActivityResult) this.f13888g.getParcelable(str);
        if (activityResult != null) {
            this.f13888g.remove(str);
            aVar2.a(aVar.c(activityResult.getResultCode(), activityResult.getData()));
        }
        return new C0138c(str, aVar);
    }

    public final void k(String str) {
        if (this.f13883b.get(str) != null) {
            return;
        }
        a(e(), str);
    }

    public final void l(@NonNull String str) {
        Integer numRemove;
        if (!this.f13885d.contains(str) && (numRemove = this.f13883b.remove(str)) != null) {
            this.f13882a.remove(numRemove);
        }
        this.f13886e.remove(str);
        if (this.f13887f.containsKey(str)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + str + ": " + this.f13887f.get(str));
            this.f13887f.remove(str);
        }
        if (this.f13888g.containsKey(str)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + str + ": " + this.f13888g.getParcelable(str));
            this.f13888g.remove(str);
        }
        e eVar = this.f13884c.get(str);
        if (eVar != null) {
            eVar.b();
            this.f13884c.remove(str);
        }
    }
}
