package androidx.work.impl.utils;

import android.content.ComponentName;
import android.content.Context;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f13539a = androidx.work.j.i("PackageManagerHelper");

    public static void a(@NonNull Context context, @NonNull Class<?> cls, boolean z11) {
        try {
            context.getPackageManager().setComponentEnabledSetting(new ComponentName(context, cls.getName()), z11 ? 1 : 2, 1);
            androidx.work.j jVarE = androidx.work.j.e();
            String str = f13539a;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(cls.getName());
            sb2.append(" ");
            sb2.append(z11 ? "enabled" : "disabled");
            jVarE.a(str, sb2.toString());
        } catch (Exception e11) {
            androidx.work.j jVarE2 = androidx.work.j.e();
            String str2 = f13539a;
            StringBuilder sb3 = new StringBuilder();
            sb3.append(cls.getName());
            sb3.append("could not be ");
            sb3.append(z11 ? "enabled" : "disabled");
            jVarE2.b(str2, sb3.toString(), e11);
        }
    }
}
