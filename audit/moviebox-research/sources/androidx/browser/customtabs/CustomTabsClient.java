package androidx.browser.customtabs;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class CustomTabsClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z0.b f1811a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ComponentName f1812b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f1813c;

    public CustomTabsClient(z0.b bVar, ComponentName componentName, Context context) {
        this.f1811a = bVar;
        this.f1812b = componentName;
        this.f1813c = context;
    }

    public static boolean a(@NonNull Context context, @Nullable String str, @NonNull f fVar) {
        fVar.setApplicationContext(context.getApplicationContext());
        Intent intent = new Intent("android.support.customtabs.action.CustomTabsService");
        if (!TextUtils.isEmpty(str)) {
            intent.setPackage(str);
        }
        return context.bindService(intent, fVar, 33);
    }

    @Nullable
    public static String c(@NonNull Context context, @Nullable List<String> list) {
        return d(context, list, false);
    }

    @Nullable
    public static String d(@NonNull Context context, @Nullable List<String> list, boolean z11) {
        ResolveInfo resolveInfoResolveActivity;
        PackageManager packageManager = context.getPackageManager();
        List<String> arrayList = list == null ? new ArrayList<>() : list;
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://"));
        if (!z11 && (resolveInfoResolveActivity = packageManager.resolveActivity(intent, 0)) != null) {
            String str = resolveInfoResolveActivity.activityInfo.packageName;
            ArrayList arrayList2 = new ArrayList(arrayList.size() + 1);
            arrayList2.add(str);
            if (list != null) {
                arrayList2.addAll(list);
            }
            arrayList = arrayList2;
        }
        Intent intent2 = new Intent("android.support.customtabs.action.CustomTabsService");
        for (String str2 : arrayList) {
            intent2.setPackage(str2);
            if (packageManager.resolveService(intent2, 0) != null) {
                return str2;
            }
        }
        if (Build.VERSION.SDK_INT < 30) {
            return null;
        }
        Log.w("CustomTabsClient", "Unable to find any Custom Tabs packages, you may need to add a <queries> element to your manifest. See the docs for CustomTabsClient#getPackageName.");
        return null;
    }

    public final z0.a.AbstractBinderC0920a b(@Nullable final c cVar) {
        return new z0.a.AbstractBinderC0920a() { // from class: androidx.browser.customtabs.CustomTabsClient.2

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Handler f1814a = new Handler(Looper.getMainLooper());

            @Override // z0.a
            public void M(final int i11, final int i12, @Nullable final Bundle bundle) throws RemoteException {
                if (cVar == null) {
                    return;
                }
                this.f1814a.post(new Runnable() { // from class: androidx.browser.customtabs.CustomTabsClient.2.6
                    @Override // java.lang.Runnable
                    public void run() {
                        cVar.onActivityResized(i11, i12, bundle);
                    }
                });
            }

            @Override // z0.a
            public void S(final int i11, final Bundle bundle) {
                if (cVar == null) {
                    return;
                }
                this.f1814a.post(new Runnable() { // from class: androidx.browser.customtabs.CustomTabsClient.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        cVar.onNavigationEvent(i11, bundle);
                    }
                });
            }

            @Override // z0.a
            public void X(final String str, final Bundle bundle) throws RemoteException {
                if (cVar == null) {
                    return;
                }
                this.f1814a.post(new Runnable() { // from class: androidx.browser.customtabs.CustomTabsClient.2.4
                    @Override // java.lang.Runnable
                    public void run() {
                        cVar.onPostMessage(str, bundle);
                    }
                });
            }

            @Override // z0.a
            public void Y(final Bundle bundle) throws RemoteException {
                if (cVar == null) {
                    return;
                }
                this.f1814a.post(new Runnable() { // from class: androidx.browser.customtabs.CustomTabsClient.2.3
                    @Override // java.lang.Runnable
                    public void run() {
                        cVar.onMessageChannelReady(bundle);
                    }
                });
            }

            @Override // z0.a
            public void a0(final int i11, final Uri uri, final boolean z11, @Nullable final Bundle bundle) throws RemoteException {
                if (cVar == null) {
                    return;
                }
                this.f1814a.post(new Runnable() { // from class: androidx.browser.customtabs.CustomTabsClient.2.5
                    @Override // java.lang.Runnable
                    public void run() {
                        cVar.onRelationshipValidationResult(i11, uri, z11, bundle);
                    }
                });
            }

            @Override // z0.a
            public Bundle h(@NonNull String str, @Nullable Bundle bundle) throws RemoteException {
                c cVar2 = cVar;
                if (cVar2 == null) {
                    return null;
                }
                return cVar2.extraCallbackWithResult(str, bundle);
            }

            @Override // z0.a
            public void s(final String str, final Bundle bundle) throws RemoteException {
                if (cVar == null) {
                    return;
                }
                this.f1814a.post(new Runnable() { // from class: androidx.browser.customtabs.CustomTabsClient.2.2
                    @Override // java.lang.Runnable
                    public void run() {
                        cVar.extraCallback(str, bundle);
                    }
                });
            }
        };
    }

    @Nullable
    public j e(@Nullable c cVar) {
        return f(cVar, null);
    }

    @Nullable
    public final j f(@Nullable c cVar, @Nullable PendingIntent pendingIntent) {
        boolean zD;
        z0.a.AbstractBinderC0920a abstractBinderC0920aB = b(cVar);
        try {
            if (pendingIntent != null) {
                Bundle bundle = new Bundle();
                bundle.putParcelable("android.support.customtabs.extra.SESSION_ID", pendingIntent);
                zD = this.f1811a.d0(abstractBinderC0920aB, bundle);
            } else {
                zD = this.f1811a.d(abstractBinderC0920aB);
            }
            if (zD) {
                return new j(this.f1811a, abstractBinderC0920aB, this.f1812b, pendingIntent);
            }
            return null;
        } catch (RemoteException unused) {
            return null;
        }
    }

    public boolean g(long j11) {
        try {
            return this.f1811a.K(j11);
        } catch (RemoteException unused) {
            return false;
        }
    }
}
