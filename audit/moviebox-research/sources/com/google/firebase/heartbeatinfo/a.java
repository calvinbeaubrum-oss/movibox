package com.google.firebase.heartbeatinfo;

import android.content.Context;
import android.util.Base64OutputStream;
import androidx.annotation.NonNull;
import androidx.core.os.s;
import bl.b;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.io.ByteArrayOutputStream;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.zip.GZIPOutputStream;
import jj.e;
import org.json.JSONArray;
import org.json.JSONObject;
import rj.b0;
import rj.c;
import rj.r;
import xl.i;
import zk.f;
import zk.h;
import zk.n;
import zk.o;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class a implements h, HeartBeatInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b<n> f40606a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f40607b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b<i> f40608c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set<f> f40609d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Executor f40610e;

    public a(final Context context, final String str, Set<f> set, b<i> bVar, Executor executor) {
        this((b<n>) new b() { // from class: zk.e
            @Override // bl.b
            public final Object get() {
                return com.google.firebase.heartbeatinfo.a.j(context, str);
            }
        }, set, executor, bVar, context);
    }

    public a(b<n> bVar, Set<f> set, Executor executor, b<i> bVar2, Context context) {
        this.f40606a = bVar;
        this.f40609d = set;
        this.f40610e = executor;
        this.f40608c = bVar2;
        this.f40607b = context;
    }

    @NonNull
    public static c<a> g() {
        final b0 b0VarA = b0.a(qj.a.class, Executor.class);
        return c.d(a.class, h.class, HeartBeatInfo.class).b(r.j(Context.class)).b(r.j(e.class)).b(r.m(f.class)).b(r.l(i.class)).b(r.k(b0VarA)).f(new rj.h() { // from class: zk.d
            @Override // rj.h
            public final Object a(rj.e eVar) {
                return com.google.firebase.heartbeatinfo.a.h(b0VarA, eVar);
            }
        }).d();
    }

    public static /* synthetic */ a h(b0 b0Var, rj.e eVar) {
        return new a((Context) eVar.b(Context.class), ((e) eVar.b(e.class)).n(), (Set<f>) eVar.c(f.class), (b<i>) eVar.f(i.class), (Executor) eVar.e(b0Var));
    }

    public static /* synthetic */ n j(Context context, String str) {
        return new n(context, str);
    }

    @Override // zk.h
    public Task<String> a() {
        return s.a(this.f40607b) ^ true ? Tasks.forResult("") : Tasks.call(this.f40610e, new Callable() { // from class: zk.c
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f82059a.i();
            }
        });
    }

    @Override // com.google.firebase.heartbeatinfo.HeartBeatInfo
    @NonNull
    public synchronized HeartBeatInfo.HeartBeat b(@NonNull String str) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        n nVar = this.f40606a.get();
        if (!nVar.i(jCurrentTimeMillis)) {
            return HeartBeatInfo.HeartBeat.NONE;
        }
        nVar.g();
        return HeartBeatInfo.HeartBeat.GLOBAL;
    }

    public final /* synthetic */ String i() throws Exception {
        String string;
        synchronized (this) {
            try {
                n nVar = this.f40606a.get();
                List<o> listC = nVar.c();
                nVar.b();
                JSONArray jSONArray = new JSONArray();
                for (int i11 = 0; i11 < listC.size(); i11++) {
                    o oVar = listC.get(i11);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("agent", oVar.c());
                    jSONObject.put("dates", new JSONArray((Collection) oVar.b()));
                    jSONArray.put(jSONObject);
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("heartbeats", jSONArray);
                jSONObject2.put("version", "2");
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                Base64OutputStream base64OutputStream = new Base64OutputStream(byteArrayOutputStream, 11);
                try {
                    GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(base64OutputStream);
                    try {
                        gZIPOutputStream.write(jSONObject2.toString().getBytes("UTF-8"));
                        gZIPOutputStream.close();
                        base64OutputStream.close();
                        string = byteArrayOutputStream.toString("UTF-8");
                    } catch (Throwable th2) {
                        try {
                            gZIPOutputStream.close();
                        } catch (Throwable th3) {
                            th2.addSuppressed(th3);
                        }
                        throw th2;
                    }
                } catch (Throwable th4) {
                    try {
                        base64OutputStream.close();
                    } catch (Throwable th5) {
                        th4.addSuppressed(th5);
                    }
                    throw th4;
                }
            } catch (Throwable th6) {
                throw th6;
            }
        }
        return string;
    }

    public final /* synthetic */ Void k() throws Exception {
        synchronized (this) {
            this.f40606a.get().k(System.currentTimeMillis(), this.f40608c.get().a());
        }
        return null;
    }

    public Task<Void> l() {
        if (this.f40609d.size() > 0 && !(!s.a(this.f40607b))) {
            return Tasks.call(this.f40610e, new Callable() { // from class: zk.b
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.f82058a.k();
                }
            });
        }
        return Tasks.forResult(null);
    }
}
