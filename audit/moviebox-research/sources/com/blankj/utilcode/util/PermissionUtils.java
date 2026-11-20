package com.blankj.utilcode.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.util.Pair;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class PermissionUtils {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static PermissionUtils f25241h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static b f25242i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static b f25243j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String[] f25244a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f25245b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Set<String> f25246c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List<String> f25247d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<String> f25248e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List<String> f25249f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List<String> f25250g;

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(api = 23)
    public static final class PermissionActivityImpl extends UtilsTransActivity.TransActivityDelegate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static int f25251a = -1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static PermissionActivityImpl f25252b = new PermissionActivityImpl();

        /* JADX INFO: compiled from: source.java */
        public class a implements Utils.b<Intent> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f25253a;

            public a(int i11) {
                this.f25253a = i11;
            }

            @Override // com.blankj.utilcode.util.Utils.b
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void accept(Intent intent) {
                intent.putExtra("TYPE", this.f25253a);
            }
        }

        public static void start(int i11) {
            UtilsTransActivity.M(new a(i11), f25252b);
        }

        public final void a(int i11) {
            if (i11 == 2) {
                if (PermissionUtils.f25242i == null) {
                    return;
                }
                if (PermissionUtils.u()) {
                    PermissionUtils.f25242i.onGranted();
                } else {
                    PermissionUtils.f25242i.a();
                }
                b unused = PermissionUtils.f25242i = null;
                return;
            }
            if (i11 != 3 || PermissionUtils.f25243j == null) {
                return;
            }
            if (PermissionUtils.t()) {
                PermissionUtils.f25243j.onGranted();
            } else {
                PermissionUtils.f25243j.a();
            }
            b unused2 = PermissionUtils.f25243j = null;
        }

        public final void b(final UtilsTransActivity utilsTransActivity) {
            if (PermissionUtils.f25241h.A(utilsTransActivity, new Runnable() { // from class: com.blankj.utilcode.util.PermissionUtils.PermissionActivityImpl.3
                @Override // java.lang.Runnable
                public void run() {
                    utilsTransActivity.requestPermissions((String[]) PermissionUtils.f25241h.f25247d.toArray(new String[0]), 1);
                }
            })) {
                return;
            }
            utilsTransActivity.requestPermissions((String[]) PermissionUtils.f25241h.f25247d.toArray(new String[0]), 1);
        }

        @Override // com.blankj.utilcode.util.UtilsTransActivity.TransActivityDelegate
        public boolean dispatchTouchEvent(@NonNull UtilsTransActivity utilsTransActivity, MotionEvent motionEvent) {
            utilsTransActivity.finish();
            return true;
        }

        @Override // com.blankj.utilcode.util.UtilsTransActivity.TransActivityDelegate
        public void onActivityResult(@NonNull UtilsTransActivity utilsTransActivity, int i11, int i12, Intent intent) {
            utilsTransActivity.finish();
        }

        @Override // com.blankj.utilcode.util.UtilsTransActivity.TransActivityDelegate
        public void onCreated(@NonNull UtilsTransActivity utilsTransActivity, @Nullable Bundle bundle) {
            utilsTransActivity.getWindow().addFlags(262160);
            int intExtra = utilsTransActivity.getIntent().getIntExtra("TYPE", -1);
            if (intExtra != 1) {
                if (intExtra == 2) {
                    f25251a = 2;
                    PermissionUtils.D(utilsTransActivity, 2);
                    return;
                } else if (intExtra == 3) {
                    f25251a = 3;
                    PermissionUtils.B(utilsTransActivity, 3);
                    return;
                } else {
                    utilsTransActivity.finish();
                    Log.e("PermissionUtils", "type is wrong.");
                    return;
                }
            }
            if (PermissionUtils.f25241h == null) {
                Log.e("PermissionUtils", "sInstance is null.");
                utilsTransActivity.finish();
                return;
            }
            if (PermissionUtils.f25241h.f25247d == null) {
                Log.e("PermissionUtils", "mPermissionsRequest is null.");
                utilsTransActivity.finish();
            } else if (PermissionUtils.f25241h.f25247d.size() <= 0) {
                Log.e("PermissionUtils", "mPermissionsRequest's size is no more than 0.");
                utilsTransActivity.finish();
            } else {
                PermissionUtils.i(PermissionUtils.f25241h);
                PermissionUtils.j(PermissionUtils.f25241h);
                b(utilsTransActivity);
            }
        }

        @Override // com.blankj.utilcode.util.UtilsTransActivity.TransActivityDelegate
        public void onDestroy(@NonNull UtilsTransActivity utilsTransActivity) {
            int i11 = f25251a;
            if (i11 != -1) {
                a(i11);
                f25251a = -1;
            }
            super.onDestroy(utilsTransActivity);
        }

        @Override // com.blankj.utilcode.util.UtilsTransActivity.TransActivityDelegate
        public void onRequestPermissionsResult(@NonNull UtilsTransActivity utilsTransActivity, int i11, @NonNull String[] strArr, @NonNull int[] iArr) {
            utilsTransActivity.finish();
            if (PermissionUtils.f25241h == null || PermissionUtils.f25241h.f25247d == null) {
                return;
            }
            PermissionUtils.f25241h.w(utilsTransActivity);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface a {
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
        void a();

        void onGranted();
    }

    /* JADX INFO: compiled from: source.java */
    public interface c {
    }

    public PermissionUtils(String... strArr) {
        this.f25244a = strArr;
        f25241h = this;
    }

    @TargetApi(23)
    public static void B(Activity activity, int i11) {
        Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
        intent.setData(Uri.parse("package:" + Utils.a().getPackageName()));
        if (j0.z(intent)) {
            activity.startActivityForResult(intent, i11);
        } else {
            v();
        }
    }

    @TargetApi(23)
    public static void D(Activity activity, int i11) {
        Intent intent = new Intent("android.settings.action.MANAGE_WRITE_SETTINGS");
        intent.setData(Uri.parse("package:" + Utils.a().getPackageName()));
        if (j0.z(intent)) {
            activity.startActivityForResult(intent, i11);
        } else {
            v();
        }
    }

    public static /* synthetic */ c i(PermissionUtils permissionUtils) {
        permissionUtils.getClass();
        return null;
    }

    public static /* synthetic */ a j(PermissionUtils permissionUtils) {
        permissionUtils.getClass();
        return null;
    }

    public static List<String> n() {
        return o(Utils.a().getPackageName());
    }

    public static List<String> o(String str) {
        try {
            String[] strArr = Utils.a().getPackageManager().getPackageInfo(str, 4096).requestedPermissions;
            return strArr == null ? Collections.emptyList() : Arrays.asList(strArr);
        } catch (PackageManager.NameNotFoundException e11) {
            e11.printStackTrace();
            return Collections.emptyList();
        }
    }

    public static Pair<List<String>, List<String>> q(String... strArr) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        List<String> listN = n();
        for (String str : strArr) {
            boolean z11 = false;
            for (String str2 : i8.a.a(str)) {
                if (listN.contains(str2)) {
                    arrayList.add(str2);
                    z11 = true;
                }
            }
            if (!z11) {
                arrayList2.add(str);
                Log.e("PermissionUtils", "U should add the permission of " + str + " in manifest.");
            }
        }
        return Pair.create(arrayList, arrayList2);
    }

    public static boolean r(String str) {
        return Build.VERSION.SDK_INT < 23 || z2.a.checkSelfPermission(Utils.a(), str) == 0;
    }

    public static boolean s(String... strArr) {
        Pair<List<String>, List<String>> pairQ = q(strArr);
        if (!((List) pairQ.second).isEmpty()) {
            return false;
        }
        Iterator it = ((List) pairQ.first).iterator();
        while (it.hasNext()) {
            if (!r((String) it.next())) {
                return false;
            }
        }
        return true;
    }

    @RequiresApi(api = 23)
    public static boolean t() {
        return Settings.canDrawOverlays(Utils.a());
    }

    @RequiresApi(api = 23)
    public static boolean u() {
        return Settings.System.canWrite(Utils.a());
    }

    public static void v() {
        Intent intentO = j0.o(Utils.a().getPackageName(), true);
        if (j0.z(intentO)) {
            Utils.a().startActivity(intentO);
        }
    }

    public static PermissionUtils x(String... strArr) {
        return new PermissionUtils(strArr);
    }

    @RequiresApi(api = 23)
    public final boolean A(UtilsTransActivity utilsTransActivity, Runnable runnable) {
        return false;
    }

    @RequiresApi(api = 23)
    public final void C() {
        PermissionActivityImpl.start(1);
    }

    public PermissionUtils m(b bVar) {
        this.f25245b = bVar;
        return this;
    }

    public final void p(Activity activity) {
        for (String str : this.f25247d) {
            if (r(str)) {
                this.f25248e.add(str);
            } else {
                this.f25249f.add(str);
                if (!activity.shouldShowRequestPermissionRationale(str)) {
                    this.f25250g.add(str);
                }
            }
        }
    }

    public final void w(Activity activity) {
        p(activity);
        z();
    }

    public void y() {
        String[] strArr = this.f25244a;
        if (strArr == null || strArr.length <= 0) {
            Log.w("PermissionUtils", "No permissions to request.");
            return;
        }
        this.f25246c = new LinkedHashSet();
        this.f25247d = new ArrayList();
        this.f25248e = new ArrayList();
        this.f25249f = new ArrayList();
        this.f25250g = new ArrayList();
        Pair<List<String>, List<String>> pairQ = q(this.f25244a);
        this.f25246c.addAll((Collection) pairQ.first);
        this.f25249f.addAll((Collection) pairQ.second);
        if (Build.VERSION.SDK_INT < 23) {
            this.f25248e.addAll(this.f25246c);
            z();
            return;
        }
        for (String str : this.f25246c) {
            if (r(str)) {
                this.f25248e.add(str);
            } else {
                this.f25247d.add(str);
            }
        }
        if (this.f25247d.isEmpty()) {
            z();
        } else {
            C();
        }
    }

    public final void z() {
        if (this.f25245b != null) {
            if (this.f25249f.isEmpty()) {
                this.f25245b.onGranted();
            } else {
                this.f25245b.a();
            }
            this.f25245b = null;
        }
    }
}
