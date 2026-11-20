package com.google.android.play.core.appupdate;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.android.play.core.install.InstallException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class u {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final com.google.android.play.core.appupdate.internal.s f38101e = new com.google.android.play.core.appupdate.internal.s("AppUpdateService");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Intent f38102f = new Intent("com.google.android.play.core.install.BIND_UPDATE_SERVICE").setPackage("com.android.vending");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public com.google.android.play.core.appupdate.internal.y f38103a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f38104b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f38105c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final w f38106d;

    public u(Context context, w wVar) {
        this.f38104b = context.getPackageName();
        this.f38105c = context;
        this.f38106d = wVar;
        if (com.google.android.play.core.appupdate.internal.c.a(context)) {
            this.f38103a = new com.google.android.play.core.appupdate.internal.y(com.google.android.play.core.appupdate.internal.z.a(context), f38101e, "AppUpdateService", f38102f, q.f38095a, null);
        }
    }

    public static /* bridge */ /* synthetic */ Bundle b(u uVar, String str) {
        Integer numValueOf;
        Bundle bundle = new Bundle();
        bundle.putAll(i());
        bundle.putString("package.name", str);
        try {
            numValueOf = Integer.valueOf(uVar.f38105c.getPackageManager().getPackageInfo(uVar.f38105c.getPackageName(), 0).versionCode);
        } catch (PackageManager.NameNotFoundException unused) {
            f38101e.b("The current version of the app could not be retrieved", new Object[0]);
            numValueOf = null;
        }
        if (numValueOf != null) {
            bundle.putInt("app.version.code", numValueOf.intValue());
        }
        return bundle;
    }

    public static /* bridge */ /* synthetic */ a f(u uVar, Bundle bundle, String str) {
        int i11 = bundle.getInt("version.code", -1);
        int i12 = bundle.getInt("update.availability");
        int i13 = bundle.getInt("install.status", 0);
        Integer numValueOf = bundle.getInt("client.version.staleness", -1) == -1 ? null : Integer.valueOf(bundle.getInt("client.version.staleness"));
        int i14 = bundle.getInt("in.app.update.priority", 0);
        long j11 = bundle.getLong("bytes.downloaded");
        long j12 = bundle.getLong("total.bytes.to.download");
        long j13 = bundle.getLong("additional.size.required");
        long jA = uVar.f38106d.a();
        PendingIntent pendingIntent = (PendingIntent) bundle.getParcelable("blocking.intent");
        PendingIntent pendingIntent2 = (PendingIntent) bundle.getParcelable("nonblocking.intent");
        PendingIntent pendingIntent3 = (PendingIntent) bundle.getParcelable("blocking.destructive.intent");
        PendingIntent pendingIntent4 = (PendingIntent) bundle.getParcelable("nonblocking.destructive.intent");
        HashMap map = new HashMap();
        map.put("blocking.destructive.intent", k(bundle.getIntegerArrayList("update.precondition.failures:blocking.destructive.intent")));
        map.put("nonblocking.destructive.intent", k(bundle.getIntegerArrayList("update.precondition.failures:nonblocking.destructive.intent")));
        map.put("blocking.intent", k(bundle.getIntegerArrayList("update.precondition.failures:blocking.intent")));
        map.put("nonblocking.intent", k(bundle.getIntegerArrayList("update.precondition.failures:nonblocking.intent")));
        return a.f(str, i11, i12, i13, numValueOf, i14, j11, j12, j13, jA, pendingIntent, pendingIntent2, pendingIntent3, pendingIntent4, map);
    }

    public static Bundle i() {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        Map mapA = com.google.android.play.core.appupdate.internal.o.a("app_update");
        bundle2.putInt("playcore_version_code", ((Integer) mapA.get("java")).intValue());
        if (mapA.containsKey("native")) {
            bundle2.putInt("playcore_native_version", ((Integer) mapA.get("native")).intValue());
        }
        if (mapA.containsKey("unity")) {
            bundle2.putInt("playcore_unity_version", ((Integer) mapA.get("unity")).intValue());
        }
        bundle.putAll(bundle2);
        bundle.putInt("playcore.version.code", 11004);
        return bundle;
    }

    public static Task j() {
        f38101e.b("onError(%d)", -9);
        return Tasks.forException(new InstallException(-9));
    }

    public static HashSet k(@Nullable ArrayList arrayList) {
        HashSet hashSet = new HashSet();
        if (arrayList != null) {
            hashSet.addAll(arrayList);
        }
        return hashSet;
    }

    public final Task d(String str) {
        if (this.f38103a == null) {
            return j();
        }
        f38101e.d("completeUpdate(%s)", str);
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f38103a.s(new zzn(this, taskCompletionSource, taskCompletionSource, str), taskCompletionSource);
        return taskCompletionSource.getTask();
    }

    public final Task e(String str) {
        if (this.f38103a == null) {
            return j();
        }
        f38101e.d("requestUpdateInfo(%s)", str);
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f38103a.s(new zzm(this, taskCompletionSource, str, taskCompletionSource), taskCompletionSource);
        return taskCompletionSource.getTask();
    }
}
