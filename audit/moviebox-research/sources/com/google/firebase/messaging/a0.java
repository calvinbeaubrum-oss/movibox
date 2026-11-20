package com.google.firebase.messaging;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.google.android.gms.cloudmessaging.Rpc;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.transsion.api.gateway.utils.EncoderUtil;
import com.transsion.api.gateway.utils.SafeStringUtils;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ExecutionException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final jj.e f40814a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f0 f40815b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Rpc f40816c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final bl.b<xl.i> f40817d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final bl.b<HeartBeatInfo> f40818e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final cl.g f40819f;

    public a0(jj.e eVar, f0 f0Var, bl.b<xl.i> bVar, bl.b<HeartBeatInfo> bVar2, cl.g gVar) {
        this(eVar, f0Var, new Rpc(eVar.j()), bVar, bVar2, gVar);
    }

    public a0(jj.e eVar, f0 f0Var, Rpc rpc, bl.b<xl.i> bVar, bl.b<HeartBeatInfo> bVar2, cl.g gVar) {
        this.f40814a = eVar;
        this.f40815b = f0Var;
        this.f40816c = rpc;
        this.f40817d = bVar;
        this.f40818e = bVar2;
        this.f40819f = gVar;
    }

    public static String b(byte[] bArr) {
        return Base64.encodeToString(bArr, 11);
    }

    public static boolean g(String str) {
        return "SERVICE_NOT_AVAILABLE".equals(str) || "INTERNAL_SERVER_ERROR".equals(str) || "InternalServerError".equals(str);
    }

    public final Task<String> c(Task<Bundle> task) {
        return task.continueWith(new b6.m(), new Continuation() { // from class: com.google.firebase.messaging.z
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task2) {
                return this.f40962a.h(task2);
            }
        });
    }

    public final String d() {
        try {
            return b(MessageDigest.getInstance(EncoderUtil.ALGORITHM_SHA_1).digest(this.f40814a.l().getBytes()));
        } catch (NoSuchAlgorithmException unused) {
            return "[HASH-ERROR]";
        }
    }

    public Task<String> e() {
        return c(j(f0.c(this.f40814a), "*", new Bundle()));
    }

    public final String f(Bundle bundle) throws IOException {
        if (bundle == null) {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        }
        String string = bundle.getString("registration_id");
        if (string != null) {
            return string;
        }
        String string2 = bundle.getString("unregistered");
        if (string2 != null) {
            return string2;
        }
        String string3 = bundle.getString("error");
        if ("RST".equals(string3)) {
            throw new IOException("INSTANCE_ID_RESET");
        }
        if (string3 != null) {
            throw new IOException(string3);
        }
        Log.w("FirebaseMessaging", "Unexpected response: " + bundle, new Throwable());
        throw new IOException("SERVICE_NOT_AVAILABLE");
    }

    public final /* synthetic */ String h(Task task) throws Exception {
        return f((Bundle) task.getResult(IOException.class));
    }

    public final void i(String str, String str2, Bundle bundle) throws ExecutionException, InterruptedException {
        HeartBeatInfo.HeartBeat heartBeatB;
        bundle.putString("scope", str2);
        bundle.putString("sender", str);
        bundle.putString("subtype", str);
        bundle.putString("gmp_app_id", this.f40814a.m().c());
        bundle.putString("gmsv", Integer.toString(this.f40815b.d()));
        bundle.putString("osv", Integer.toString(Build.VERSION.SDK_INT));
        bundle.putString("app_ver", this.f40815b.a());
        bundle.putString("app_ver_name", this.f40815b.b());
        bundle.putString("firebase-app-name-hash", d());
        try {
            String strB = ((cl.k) Tasks.await(this.f40819f.a(false))).b();
            if (TextUtils.isEmpty(strB)) {
                Log.w("FirebaseMessaging", "FIS auth token is empty");
            } else {
                bundle.putString("Goog-Firebase-Installations-Auth", strB);
            }
        } catch (InterruptedException e11) {
            e = e11;
            Log.e("FirebaseMessaging", "Failed to get FIS auth token", e);
        } catch (ExecutionException e12) {
            e = e12;
            Log.e("FirebaseMessaging", "Failed to get FIS auth token", e);
        }
        bundle.putString(SafeStringUtils.SP_APPID, (String) Tasks.await(this.f40819f.getId()));
        bundle.putString("cliv", "fcm-23.3.1");
        HeartBeatInfo heartBeatInfo = this.f40818e.get();
        xl.i iVar = this.f40817d.get();
        if (heartBeatInfo == null || iVar == null || (heartBeatB = heartBeatInfo.b("fire-iid")) == HeartBeatInfo.HeartBeat.NONE) {
            return;
        }
        bundle.putString("Firebase-Client-Log-Type", Integer.toString(heartBeatB.getCode()));
        bundle.putString("Firebase-Client", iVar.a());
    }

    public final Task<Bundle> j(String str, String str2, Bundle bundle) {
        try {
            i(str, str2, bundle);
            return this.f40816c.send(bundle);
        } catch (InterruptedException | ExecutionException e11) {
            return Tasks.forException(e11);
        }
    }

    public Task<?> k(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("gcm.topic", "/topics/" + str2);
        return c(j(str, "/topics/" + str2, bundle));
    }

    public Task<?> l(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("gcm.topic", "/topics/" + str2);
        bundle.putString(RequestParameters.SUBRESOURCE_DELETE, "1");
        return c(j(str, "/topics/" + str2, bundle));
    }
}
