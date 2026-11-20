package com.transsion.push.notification;

import android.app.Activity;
import android.os.Build;
import androidx.core.app.ActivityCompat;
import com.tencent.mmkv.MMKV;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class NoticePermissionUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final NoticePermissionUtils f56924a = new NoticePermissionUtils();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f56925b = LazyKt__LazyJVMKt.b(new Function0<MMKV>() { // from class: com.transsion.push.notification.NoticePermissionUtils$mmkv$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final MMKV invoke() {
            return MMKV.z("NoticePermission");
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static long f56926c;

    public static /* synthetic */ void b(NoticePermissionUtils noticePermissionUtils, Activity activity, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i11 = 530;
        }
        noticePermissionUtils.a(activity, i11);
    }

    public final void a(Activity activity, int i11) {
        Intrinsics.g(activity, "activity");
        if (Build.VERSION.SDK_INT >= 33) {
            f56926c = System.currentTimeMillis();
            ActivityCompat.g(activity, new String[]{"android.permission.POST_NOTIFICATIONS"}, i11);
        }
    }
}
