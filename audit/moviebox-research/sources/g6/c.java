package g6;

import android.app.ActivityManager;
import android.database.Cursor;
import android.net.Uri;
import androidx.annotation.RequiresApi;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
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
/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(19)
@Metadata
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f65413a = new c();

    @JvmStatic
    public static final Uri a(Cursor cursor) {
        Intrinsics.g(cursor, "cursor");
        Uri notificationUri = cursor.getNotificationUri();
        Intrinsics.f(notificationUri, "cursor.notificationUri");
        return notificationUri;
    }

    @JvmStatic
    public static final boolean b(ActivityManager activityManager) {
        Intrinsics.g(activityManager, "activityManager");
        return activityManager.isLowRamDevice();
    }
}
