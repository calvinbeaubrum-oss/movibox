package athena;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;
import com.transsion.athena.config.AthenaConfig;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static WeakReference<Activity> f13758a;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f13759a;

        public b(String str, boolean z11) {
            this.f13759a = str;
        }

        public String a() {
            return this.f13759a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public static final class c implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f13760a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final LinkedBlockingQueue<IBinder> f13761b;

        public c() {
            this.f13760a = false;
            this.f13761b = new LinkedBlockingQueue<>(1);
        }

        public IBinder a() throws InterruptedException {
            if (this.f13760a) {
                throw new IllegalStateException();
            }
            this.f13760a = true;
            return this.f13761b.poll(10L, TimeUnit.SECONDS);
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f13761b.put(iBinder);
            } catch (InterruptedException e11) {
                e11.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public static final class d implements IInterface {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public IBinder f13762a;

        public d(IBinder iBinder) {
            this.f13762a = iBinder;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.f13762a;
        }

        public String e0() throws RemoteException {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.f13762a.transact(1, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readString();
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }

        public boolean f0(boolean z11) throws RemoteException {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                parcelObtain.writeInt(z11 ? 1 : 0);
                this.f13762a.transact(2, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readInt() != 0;
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0029  */
    /* JADX WARN: Code duplicated, block: B:25:0x004d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:26:0x004f  */
    /* JADX WARN: Code duplicated, block: B:31:0x0060  */
    public static int a(Activity activity) {
        Intent intent;
        ActivityInfo activityInfo;
        Uri referrer;
        if (activity == null || (intent = activity.getIntent()) == null) {
            return 0;
        }
        if (intent.getBooleanExtra(AthenaConfig.ATHENA_PUSH_CALL, false)) {
            return 3;
        }
        String callingPackage = activity.getCallingPackage();
        String str = "";
        ResolveInfo resolveInfoResolveActivity = null;
        if (TextUtils.isEmpty(callingPackage)) {
            Intent intent2 = activity.getIntent();
            if (intent2 != null) {
                referrer = (Uri) intent2.getParcelableExtra("android.intent.extra.REFERRER");
                if (referrer == null) {
                    int i11 = Build.VERSION.SDK_INT;
                    if (i11 >= 22) {
                        String stringExtra = intent2.getStringExtra("android.intent.extra.REFERRER_NAME");
                        if (!TextUtils.isEmpty(stringExtra)) {
                            referrer = Uri.parse(stringExtra);
                        } else if (i11 >= 22) {
                            referrer = activity.getReferrer();
                        } else {
                            referrer = null;
                        }
                    } else if (i11 >= 22) {
                        referrer = activity.getReferrer();
                    } else {
                        referrer = null;
                    }
                }
            } else {
                referrer = null;
            }
            if (referrer != null) {
                callingPackage = referrer.getHost();
                if (TextUtils.isEmpty(callingPackage)) {
                    callingPackage = "";
                }
            } else {
                callingPackage = "";
            }
        }
        String packageName = activity.getPackageName();
        if (!TextUtils.isEmpty(callingPackage) && !callingPackage.equals(packageName)) {
            Intent intent3 = new Intent("android.intent.action.MAIN");
            intent3.addCategory("android.intent.category.HOME");
            PackageManager packageManager = activity.getPackageManager();
            if (packageManager != null) {
                try {
                    resolveInfoResolveActivity = packageManager.resolveActivity(intent3, 0);
                } catch (Exception e11) {
                    a0.c(e11.getMessage());
                }
                if (resolveInfoResolveActivity != null && (activityInfo = resolveInfoResolveActivity.activityInfo) != null) {
                    String str2 = activityInfo.packageName;
                    if (!"android".equals(str2) && !TextUtils.isEmpty(str2)) {
                        str = str2;
                    }
                }
            }
            if (!TextUtils.isEmpty(str)) {
                return !callingPackage.equals(str) ? 2 : 1;
            }
            if (!d(activity, callingPackage)) {
                return 2;
            }
        }
        return 1;
    }

    public static b b(Context context) throws Exception {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("Cannot be called from the main thread");
        }
        context.getPackageManager().getPackageInfo("com.android.vending", 0);
        c cVar = new c();
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        if (context.bindService(intent, cVar, 1)) {
            try {
                try {
                    IBinder iBinderA = cVar.a();
                    if (iBinderA != null) {
                        d dVar = new d(iBinderA);
                        b bVar = new b(dVar.e0(), dVar.f0(true));
                        context.unbindService(cVar);
                        return bVar;
                    }
                    context.unbindService(cVar);
                } catch (Exception e11) {
                    throw e11;
                }
            } catch (Throwable th2) {
                context.unbindService(cVar);
                throw th2;
            }
            context.unbindService(cVar);
            throw th2;
        }
        throw new IOException("Google Play connection failed");
    }

    public static void c() {
        WeakReference<Activity> weakReference = f13758a;
        if (weakReference != null) {
            weakReference.clear();
            f13758a = null;
        }
    }

    public static boolean d(Context context, String str) {
        PackageManager packageManager;
        List<ResolveInfo> listQueryIntentActivities;
        if (TextUtils.isEmpty(str) || (packageManager = context.getPackageManager()) == null) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        try {
            listQueryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
        } catch (Exception e11) {
            a0.c(e11.getMessage());
            listQueryIntentActivities = null;
        }
        if (listQueryIntentActivities == null) {
            return false;
        }
        Iterator<ResolveInfo> it = listQueryIntentActivities.iterator();
        while (it.hasNext()) {
            ActivityInfo activityInfo = it.next().activityInfo;
            if (activityInfo != null && str.equals(activityInfo.packageName)) {
                return true;
            }
        }
        return false;
    }

    public static Activity e() {
        WeakReference<Activity> weakReference = f13758a;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        return f13758a.get();
    }

    public static void f(Activity activity) {
        f13758a = new WeakReference<>(activity);
    }
}
