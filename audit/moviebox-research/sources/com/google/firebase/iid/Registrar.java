package com.google.firebase.iid;

import androidx.annotation.Keep;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
@Keep
@KeepForSdk
public final class Registrar implements ComponentRegistrar {

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes6.dex */
    public static class a implements al.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final FirebaseInstanceId f40623a;

        public a(FirebaseInstanceId firebaseInstanceId) {
            this.f40623a = firebaseInstanceId;
        }

        @Override // al.a
        public String a() {
            return this.f40623a.m();
        }

        @Override // al.a
        public void b(al.a.InterfaceC0026a interfaceC0026a) {
            this.f40623a.a(interfaceC0026a);
        }

        @Override // al.a
        public Task<String> c() {
            String strM = this.f40623a.m();
            return strM != null ? Tasks.forResult(strM) : this.f40623a.i().continueWith(q.f40660a);
        }
    }

    public static final /* synthetic */ FirebaseInstanceId lambda$getComponents$0$Registrar(rj.e eVar) {
        return new FirebaseInstanceId((jj.e) eVar.b(jj.e.class), eVar.f(xl.i.class), eVar.f(HeartBeatInfo.class), (cl.g) eVar.b(cl.g.class));
    }

    public static final /* synthetic */ al.a lambda$getComponents$1$Registrar(rj.e eVar) {
        return new a((FirebaseInstanceId) eVar.b(FirebaseInstanceId.class));
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    @Keep
    public List<rj.c<?>> getComponents() {
        return Arrays.asList(rj.c.c(FirebaseInstanceId.class).b(rj.r.j(jj.e.class)).b(rj.r.i(xl.i.class)).b(rj.r.i(HeartBeatInfo.class)).b(rj.r.j(cl.g.class)).f(o.f40658a).c().d(), rj.c.c(al.a.class).b(rj.r.j(FirebaseInstanceId.class)).f(p.f40659a).d(), xl.h.b("fire-iid", "21.1.0"));
    }
}
