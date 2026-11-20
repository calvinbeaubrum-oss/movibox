package com.cloud.tmc.miniutils.util;

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
/* JADX INFO: loaded from: classes4.dex */
public final class PermissionUtils {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static PermissionUtils f31962h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static b f31963i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static b f31964j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String[] f31965a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f31966b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Set<String> f31967c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List<String> f31968d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<String> f31969e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List<String> f31970f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List<String> f31971g;

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(api = 23)
    public static final class PermissionActivityImpl extends UtilsTransActivity.TransActivityDelegate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static int f31972a = -1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static PermissionActivityImpl f31973b = new PermissionActivityImpl();

        /* JADX INFO: compiled from: source.java */
        public class a implements e0.b<Intent> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f31974a;

            public a(int i11) {
                this.f31974a = i11;
            }

            @Override // com.cloud.tmc.miniutils.util.e0.b
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void accept(Intent intent) {
                intent.putExtra("TYPE", this.f31974a);
            }
        }

        public static void start(int i11) {
            UtilsTransActivity.M(new a(i11), f31973b);
        }

        public final void a(int i11) {
            if (i11 == 2) {
                if (PermissionUtils.f31963i == null) {
                    return;
                }
                if (PermissionUtils.u()) {
                    PermissionUtils.f31963i.onGranted();
                } else {
                    PermissionUtils.f31963i.a();
                }
                b unused = PermissionUtils.f31963i = null;
                return;
            }
            if (i11 != 3 || PermissionUtils.f31964j == null) {
                return;
            }
            if (PermissionUtils.t()) {
                PermissionUtils.f31964j.onGranted();
            } else {
                PermissionUtils.f31964j.a();
            }
            b unused2 = PermissionUtils.f31964j = null;
        }

        public final void b(final UtilsTransActivity utilsTransActivity) {
            if (PermissionUtils.f31962h.B(utilsTransActivity, new Runnable() { // from class: com.cloud.tmc.miniutils.util.PermissionUtils.PermissionActivityImpl.3
                @Override // java.lang.Runnable
                public void run() {
                    utilsTransActivity.requestPermissions((String[]) PermissionUtils.f31962h.f31968d.toArray(new String[0]), 1);
                }
            })) {
                return;
            }
            utilsTransActivity.requestPermissions((String[]) PermissionUtils.f31962h.f31968d.toArray(new String[0]), 1);
        }

        @Override // com.cloud.tmc.miniutils.util.UtilsTransActivity.TransActivityDelegate
        public boolean dispatchTouchEvent(@NonNull UtilsTransActivity utilsTransActivity, MotionEvent motionEvent) {
            utilsTransActivity.finish();
            return true;
        }

        @Override // com.cloud.tmc.miniutils.util.UtilsTransActivity.TransActivityDelegate
        public void onActivityResult(@NonNull UtilsTransActivity utilsTransActivity, int i11, int i12, Intent intent) {
            utilsTransActivity.finish();
        }

        @Override // com.cloud.tmc.miniutils.util.UtilsTransActivity.TransActivityDelegate
        public void onCreated(@NonNull UtilsTransActivity utilsTransActivity, @Nullable Bundle bundle) {
            utilsTransActivity.getWindow().addFlags(262160);
            int intExtra = utilsTransActivity.getIntent().getIntExtra("TYPE", -1);
            if (intExtra != 1) {
                if (intExtra == 2) {
                    f31972a = 2;
                    PermissionUtils.E(utilsTransActivity, 2);
                    return;
                } else if (intExtra == 3) {
                    f31972a = 3;
                    PermissionUtils.C(utilsTransActivity, 3);
                    return;
                } else {
                    utilsTransActivity.finish();
                    Log.e("PermissionUtils", "type is wrong.");
                    return;
                }
            }
            if (PermissionUtils.f31962h == null) {
                Log.e("PermissionUtils", "sInstance is null.");
                utilsTransActivity.finish();
                return;
            }
            if (PermissionUtils.f31962h.f31968d == null) {
                Log.e("PermissionUtils", "mPermissionsRequest is null.");
                utilsTransActivity.finish();
            } else if (PermissionUtils.f31962h.f31968d.size() <= 0) {
                Log.e("PermissionUtils", "mPermissionsRequest's size is no more than 0.");
                utilsTransActivity.finish();
            } else {
                PermissionUtils.i(PermissionUtils.f31962h);
                PermissionUtils.j(PermissionUtils.f31962h);
                b(utilsTransActivity);
            }
        }

        @Override // com.cloud.tmc.miniutils.util.UtilsTransActivity.TransActivityDelegate
        public void onDestroy(@NonNull UtilsTransActivity utilsTransActivity) {
            int i11 = f31972a;
            if (i11 != -1) {
                a(i11);
                f31972a = -1;
            }
            super.onDestroy(utilsTransActivity);
        }

        @Override // com.cloud.tmc.miniutils.util.UtilsTransActivity.TransActivityDelegate
        public void onRequestPermissionsResult(@NonNull UtilsTransActivity utilsTransActivity, int i11, @NonNull String[] strArr, @NonNull int[] iArr) {
            utilsTransActivity.finish();
            if (PermissionUtils.f31962h == null || PermissionUtils.f31962h.f31968d == null) {
                return;
            }
            PermissionUtils.f31962h.w(utilsTransActivity);
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
        this.f31965a = strArr;
        f31962h = this;
    }

    @TargetApi(23)
    public static void C(Activity activity, int i11) {
        Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
        intent.setData(Uri.parse("package:" + e0.a().getPackageName()));
        if (h0.s(intent)) {
            activity.startActivityForResult(intent, i11);
        } else {
            v();
        }
    }

    @TargetApi(23)
    public static void E(Activity activity, int i11) {
        Intent intent = new Intent("android.settings.action.MANAGE_WRITE_SETTINGS");
        intent.setData(Uri.parse("package:" + e0.a().getPackageName()));
        if (h0.s(intent)) {
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
        return o(e0.a().getPackageName());
    }

    public static List<String> o(String str) {
        try {
            String[] strArr = e0.a().getPackageManager().getPackageInfo(str, 4096).requestedPermissions;
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
            for (String str2 : ud.a.a(str)) {
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
        return Build.VERSION.SDK_INT < 23 || z2.a.checkSelfPermission(e0.a(), str) == 0;
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
        return Settings.canDrawOverlays(e0.a());
    }

    @RequiresApi(api = 23)
    public static boolean u() {
        return Settings.System.canWrite(e0.a());
    }

    public static void v() {
        Intent intentL = h0.l(e0.a().getPackageName(), true);
        if (h0.s(intentL)) {
            e0.a().startActivity(intentL);
        }
    }

    public static PermissionUtils x(String... strArr) {
        return new PermissionUtils(strArr);
    }

    public static PermissionUtils y(String... strArr) {
        return x(strArr);
    }

    public final void A() {
        if (this.f31966b != null) {
            if (this.f31970f.isEmpty()) {
                this.f31966b.onGranted();
            } else if (Build.VERSION.SDK_INT < 34 || !((this.f31968d.contains("android.permission.READ_MEDIA_IMAGES") || this.f31968d.contains("android.permission.READ_MEDIA_VIDEO")) && r("android.permission.READ_MEDIA_VISUAL_USER_SELECTED"))) {
                this.f31966b.a();
            } else {
                this.f31966b.onGranted();
            }
            this.f31966b = null;
        }
    }

    @RequiresApi(api = 23)
    public final boolean B(UtilsTransActivity utilsTransActivity, Runnable runnable) {
        return false;
    }

    @RequiresApi(api = 23)
    public final void D() {
        PermissionActivityImpl.start(1);
    }

    public PermissionUtils m(b bVar) {
        this.f31966b = bVar;
        return this;
    }

    public final void p(Activity activity) {
        for (String str : this.f31968d) {
            if (r(str)) {
                this.f31969e.add(str);
            } else {
                this.f31970f.add(str);
                if (!activity.shouldShowRequestPermissionRationale(str)) {
                    this.f31971g.add(str);
                }
            }
        }
    }

    public final void w(Activity activity) {
        p(activity);
        A();
    }

    public void z() {
        String[] strArr = this.f31965a;
        if (strArr == null || strArr.length <= 0) {
            Log.w("PermissionUtils", "No permissions to request.");
            return;
        }
        if (Build.VERSION.SDK_INT >= 34) {
            int i11 = 0;
            while (true) {
                String[] strArr2 = this.f31965a;
                if (i11 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i11];
                if (str.equals("STORAGE_READ") || str.equals("STORAGE_WRITE")) {
                    b bVar = this.f31966b;
                    if (bVar != null) {
                        bVar.onGranted();
                    }
                    this.f31966b = null;
                    return;
                }
                i11++;
            }
        }
        this.f31967c = new LinkedHashSet();
        this.f31968d = new ArrayList();
        this.f31969e = new ArrayList();
        this.f31970f = new ArrayList();
        this.f31971g = new ArrayList();
        Pair<List<String>, List<String>> pairQ = q(this.f31965a);
        this.f31967c.addAll((Collection) pairQ.first);
        this.f31970f.addAll((Collection) pairQ.second);
        int i12 = Build.VERSION.SDK_INT;
        if (i12 < 23) {
            this.f31969e.addAll(this.f31967c);
            A();
            return;
        }
        if (i12 >= 34) {
            boolean zContains = this.f31967c.contains("android.permission.READ_MEDIA_VISUAL_USER_SELECTED");
            for (String str2 : this.f31967c) {
                if (zContains) {
                    this.f31968d.add(str2);
                } else if (r(str2)) {
                    this.f31969e.add(str2);
                } else {
                    this.f31968d.add(str2);
                }
            }
        } else {
            for (String str3 : this.f31967c) {
                if (r(str3)) {
                    this.f31969e.add(str3);
                } else {
                    this.f31968d.add(str3);
                }
            }
        }
        if (this.f31968d.isEmpty()) {
            A();
        } else {
            D();
        }
    }
}
