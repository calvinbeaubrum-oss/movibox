package com.google.firebase.iid;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.cloudmessaging.Rpc;
import com.google.android.gms.common.annotation.KeepForSdk;
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
@KeepForSdk
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final jj.e f40645a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n f40646b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Rpc f40647c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final bl.b<xl.i> f40648d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final bl.b<HeartBeatInfo> f40649e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final cl.g f40650f;

    public k(jj.e eVar, n nVar, bl.b<xl.i> bVar, bl.b<HeartBeatInfo> bVar2, cl.g gVar) {
        this(eVar, nVar, new Rpc(eVar.j()), bVar, bVar2, gVar);
    }

    public k(jj.e eVar, n nVar, Rpc rpc, bl.b<xl.i> bVar, bl.b<HeartBeatInfo> bVar2, cl.g gVar) {
        this.f40645a = eVar;
        this.f40646b = nVar;
        this.f40647c = rpc;
        this.f40648d = bVar;
        this.f40649e = bVar2;
        this.f40650f = gVar;
    }

    public static String a(byte[] bArr) {
        return Base64.encodeToString(bArr, 11);
    }

    public static boolean f(String str) {
        return "SERVICE_NOT_AVAILABLE".equals(str) || "INTERNAL_SERVER_ERROR".equals(str) || "InternalServerError".equals(str);
    }

    public final Task<String> b(Task<Bundle> task) {
        return task.continueWith(b.a(), new Continuation(this) { // from class: com.google.firebase.iid.j

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final k f40644a;

            {
                this.f40644a = this;
            }

            @Override // com.google.android.gms.tasks.Continuation
            public Object then(Task task2) {
                return this.f40644a.g(task2);
            }
        });
    }

    public final String c() {
        try {
            return a(MessageDigest.getInstance(EncoderUtil.ALGORITHM_SHA_1).digest(this.f40645a.l().getBytes()));
        } catch (NoSuchAlgorithmException unused) {
            return "[HASH-ERROR]";
        }
    }

    public Task<String> d(String str, String str2, String str3) {
        return b(i(str, str2, str3, new Bundle()));
    }

    public final String e(Bundle bundle) throws IOException {
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
        String strValueOf = String.valueOf(bundle);
        StringBuilder sb2 = new StringBuilder(strValueOf.length() + 21);
        sb2.append("Unexpected response: ");
        sb2.append(strValueOf);
        Log.w("FirebaseInstanceId", sb2.toString(), new Throwable());
        throw new IOException("SERVICE_NOT_AVAILABLE");
    }

    public final /* synthetic */ String g(Task task) throws Exception {
        return e((Bundle) task.getResult(IOException.class));
    }

    public final Bundle h(String str, String str2, String str3, Bundle bundle) {
        HeartBeatInfo.HeartBeat heartBeatB;
        bundle.putString("scope", str3);
        bundle.putString("sender", str2);
        bundle.putString("subtype", str2);
        bundle.putString(SafeStringUtils.SP_APPID, str);
        bundle.putString("gmp_app_id", this.f40645a.m().c());
        bundle.putString("gmsv", Integer.toString(this.f40646b.d()));
        bundle.putString("osv", Integer.toString(Build.VERSION.SDK_INT));
        bundle.putString("app_ver", this.f40646b.a());
        bundle.putString("app_ver_name", this.f40646b.b());
        bundle.putString("firebase-app-name-hash", c());
        try {
            String strB = ((cl.k) Tasks.await(this.f40650f.a(false))).b();
            if (TextUtils.isEmpty(strB)) {
                Log.w("FirebaseInstanceId", "FIS auth token is empty");
            } else {
                bundle.putString("Goog-Firebase-Installations-Auth", strB);
            }
        } catch (InterruptedException e11) {
            e = e11;
            Log.e("FirebaseInstanceId", "Failed to get FIS auth token", e);
        } catch (ExecutionException e12) {
            e = e12;
            Log.e("FirebaseInstanceId", "Failed to get FIS auth token", e);
        }
        bundle.putString("cliv", "fiid-21.1.0");
        HeartBeatInfo heartBeatInfo = this.f40649e.get();
        xl.i iVar = this.f40648d.get();
        if (heartBeatInfo != null && iVar != null && (heartBeatB = heartBeatInfo.b("fire-iid")) != HeartBeatInfo.HeartBeat.NONE) {
            bundle.putString("Firebase-Client-Log-Type", Integer.toString(heartBeatB.getCode()));
            bundle.putString("Firebase-Client", iVar.a());
        }
        return bundle;
    }

    public final Task<Bundle> i(String str, String str2, String str3, Bundle bundle) {
        h(str, str2, str3, bundle);
        return this.f40647c.send(bundle);
    }
}
