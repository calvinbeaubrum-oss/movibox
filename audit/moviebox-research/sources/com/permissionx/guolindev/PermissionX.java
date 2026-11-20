package com.permissionx.guolindev;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mmkv.MMKV;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import zn.a;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class PermissionX {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PermissionX f48641a = new PermissionX();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f48642b = LazyKt__LazyJVMKt.b(new Function0<MMKV>() { // from class: com.permissionx.guolindev.PermissionX$mmkv$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final MMKV invoke() {
            return MMKV.z("kv_permission_x");
        }
    });

    public final boolean a(Context context) {
        Intrinsics.g(context, "context");
        return NotificationManagerCompat.from(context).areNotificationsEnabled();
    }

    public final boolean b(Context context) {
        Intrinsics.g(context, "context");
        if (Build.VERSION.SDK_INT < 26) {
            return false;
        }
        Object systemService = context.getSystemService("appops");
        AppOpsManager appOpsManager = systemService instanceof AppOpsManager ? (AppOpsManager) systemService : null;
        Integer numValueOf = appOpsManager != null ? Integer.valueOf(appOpsManager.checkOpNoThrow("android:picture_in_picture", Process.myUid(), context.getPackageName())) : null;
        return numValueOf != null && numValueOf.intValue() == 0;
    }

    public final MMKV c() {
        Object value = f48642b.getValue();
        Intrinsics.f(value, "<get-mmkv>(...)");
        return (MMKV) value;
    }

    public final a d(FragmentActivity activity) {
        Intrinsics.g(activity, "activity");
        return new a(activity);
    }

    public final boolean e(Context context, String permission) {
        Intrinsics.g(context, "context");
        Intrinsics.g(permission, "permission");
        return z2.a.checkSelfPermission(context, permission) == 0;
    }
}
