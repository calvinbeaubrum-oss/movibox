package com.google.firebase.messaging;

import androidx.annotation.Keep;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
@Keep
@KeepForSdk
public class FirebaseMessagingRegistrar implements ComponentRegistrar {
    private static final String LIBRARY_NAME = "fire-fcm";

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ FirebaseMessaging lambda$getComponents$0(rj.e eVar) {
        return new FirebaseMessaging((jj.e) eVar.b(jj.e.class), (al.a) eVar.b(al.a.class), eVar.f(xl.i.class), eVar.f(HeartBeatInfo.class), (cl.g) eVar.b(cl.g.class), (cg.h) eVar.b(cg.h.class), (yk.d) eVar.b(yk.d.class));
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    @Keep
    public List<rj.c<?>> getComponents() {
        return Arrays.asList(rj.c.c(FirebaseMessaging.class).h(LIBRARY_NAME).b(rj.r.j(jj.e.class)).b(rj.r.h(al.a.class)).b(rj.r.i(xl.i.class)).b(rj.r.i(HeartBeatInfo.class)).b(rj.r.h(cg.h.class)).b(rj.r.j(cl.g.class)).b(rj.r.j(yk.d.class)).f(new rj.h() { // from class: com.google.firebase.messaging.y
            @Override // rj.h
            public final Object a(rj.e eVar) {
                return FirebaseMessagingRegistrar.lambda$getComponents$0(eVar);
            }
        }).c().d(), xl.h.b(LIBRARY_NAME, "23.3.1"));
    }
}
