package yl;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.abt.AbtException;
import com.google.firebase.concurrent.FirebaseExecutors;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class f {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final byte[] f81512l = new byte[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f81513a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final jj.e f81514b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final kj.b f81515c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Executor f81516d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final zl.d f81517e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final zl.d f81518f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final zl.d f81519g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.google.firebase.remoteconfig.internal.b f81520h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final zl.j f81521i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final com.google.firebase.remoteconfig.internal.c f81522j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final cl.g f81523k;

    public f(Context context, jj.e eVar, cl.g gVar, @Nullable kj.b bVar, Executor executor, zl.d dVar, zl.d dVar2, zl.d dVar3, com.google.firebase.remoteconfig.internal.b bVar2, zl.j jVar, com.google.firebase.remoteconfig.internal.c cVar) {
        this.f81513a = context;
        this.f81514b = eVar;
        this.f81523k = gVar;
        this.f81515c = bVar;
        this.f81516d = executor;
        this.f81517e = dVar;
        this.f81518f = dVar2;
        this.f81519g = dVar3;
        this.f81520h = bVar2;
        this.f81521i = jVar;
        this.f81522j = cVar;
    }

    @NonNull
    public static f k() {
        return l(jj.e.k());
    }

    @NonNull
    public static f l(@NonNull jj.e eVar) {
        return ((m) eVar.i(m.class)).e();
    }

    public static boolean p(com.google.firebase.remoteconfig.internal.a aVar, @Nullable com.google.firebase.remoteconfig.internal.a aVar2) {
        return aVar2 == null || !aVar.e().equals(aVar2.e());
    }

    public static /* synthetic */ Task r(com.google.firebase.remoteconfig.internal.b.a aVar) throws Exception {
        return Tasks.forResult(null);
    }

    public static List<Map<String, String>> x(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            HashMap map = new HashMap();
            JSONObject jSONObject = jSONArray.getJSONObject(i11);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                map.put(next, jSONObject.getString(next));
            }
            arrayList.add(map);
        }
        return arrayList;
    }

    @NonNull
    public Task<Boolean> f() {
        final Task<com.google.firebase.remoteconfig.internal.a> taskE = this.f81517e.e();
        final Task<com.google.firebase.remoteconfig.internal.a> taskE2 = this.f81518f.e();
        return Tasks.whenAllComplete((Task<?>[]) new Task[]{taskE, taskE2}).continueWithTask(this.f81516d, new Continuation() { // from class: yl.d
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return this.f81508a.q(taskE, taskE2, task);
            }
        });
    }

    @NonNull
    public Task<Void> g() {
        return this.f81520h.h().onSuccessTask(FirebaseExecutors.a(), new SuccessContinuation() { // from class: yl.c
            @Override // com.google.android.gms.tasks.SuccessContinuation
            public final Task then(Object obj) {
                return f.r((com.google.firebase.remoteconfig.internal.b.a) obj);
            }
        });
    }

    @NonNull
    public Task<Boolean> h() {
        return g().onSuccessTask(this.f81516d, new SuccessContinuation() { // from class: yl.b
            @Override // com.google.android.gms.tasks.SuccessContinuation
            public final Task then(Object obj) {
                return this.f81507a.s((Void) obj);
            }
        });
    }

    @NonNull
    public Map<String, i> i() {
        return this.f81521i.d();
    }

    @NonNull
    public g j() {
        return this.f81522j.c();
    }

    @NonNull
    public Set<String> m(@NonNull String str) {
        return this.f81521i.g(str);
    }

    public long n(@NonNull String str) {
        return this.f81521i.i(str);
    }

    @NonNull
    public String o(@NonNull String str) {
        return this.f81521i.k(str);
    }

    public final /* synthetic */ Task q(Task task, Task task2, Task task3) throws Exception {
        if (!task.isSuccessful() || task.getResult() == null) {
            return Tasks.forResult(Boolean.FALSE);
        }
        com.google.firebase.remoteconfig.internal.a aVar = (com.google.firebase.remoteconfig.internal.a) task.getResult();
        return (!task2.isSuccessful() || p(aVar, (com.google.firebase.remoteconfig.internal.a) task2.getResult())) ? this.f81518f.k(aVar).continueWith(this.f81516d, new Continuation() { // from class: yl.e
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task4) {
                return Boolean.valueOf(this.f81511a.u(task4));
            }
        }) : Tasks.forResult(Boolean.FALSE);
    }

    public final /* synthetic */ Task s(Void r11) throws Exception {
        return f();
    }

    public final /* synthetic */ Void t(h hVar) throws Exception {
        this.f81522j.i(hVar);
        return null;
    }

    public final boolean u(Task<com.google.firebase.remoteconfig.internal.a> task) {
        if (!task.isSuccessful()) {
            return false;
        }
        this.f81517e.d();
        if (task.getResult() != null) {
            y(task.getResult().c());
            return true;
        }
        Log.e("FirebaseRemoteConfig", "Activated configs written to disk are null.");
        return true;
    }

    @NonNull
    public Task<Void> v(@NonNull final h hVar) {
        return Tasks.call(this.f81516d, new Callable() { // from class: yl.a
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f81505a.t(hVar);
            }
        });
    }

    public void w() {
        this.f81518f.e();
        this.f81519g.e();
        this.f81517e.e();
    }

    public void y(@NonNull JSONArray jSONArray) {
        if (this.f81515c == null) {
            return;
        }
        try {
            this.f81515c.k(x(jSONArray));
        } catch (AbtException e11) {
            Log.w("FirebaseRemoteConfig", "Could not update ABT experiments.", e11);
        } catch (JSONException e12) {
            Log.e("FirebaseRemoteConfig", "Could not parse ABT experiments from the JSON response.", e12);
        }
    }
}
