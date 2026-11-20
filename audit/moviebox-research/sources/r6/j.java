package r6;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import kotlin.Metadata;
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
@Metadata
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f75157a;

    static {
        String strI = androidx.work.j.i("NetworkStateTracker");
        Intrinsics.f(strI, "tagWithPrefix(\"NetworkStateTracker\")");
        f75157a = strI;
    }

    public static final g<p6.b> a(Context context, t6.c taskExecutor) {
        Intrinsics.g(context, "context");
        Intrinsics.g(taskExecutor, "taskExecutor");
        return Build.VERSION.SDK_INT >= 24 ? new i(context, taskExecutor) : new k(context, taskExecutor);
    }

    public static final p6.b c(ConnectivityManager connectivityManager) {
        Intrinsics.g(connectivityManager, "<this>");
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        boolean z11 = false;
        boolean z12 = activeNetworkInfo != null && activeNetworkInfo.isConnected();
        boolean zD = d(connectivityManager);
        boolean zA = h3.a.a(connectivityManager);
        if (activeNetworkInfo != null && !activeNetworkInfo.isRoaming()) {
            z11 = true;
        }
        return new p6.b(z12, zD, zA, z11);
    }

    public static final boolean d(ConnectivityManager connectivityManager) {
        Intrinsics.g(connectivityManager, "<this>");
        if (Build.VERSION.SDK_INT < 23) {
            return false;
        }
        try {
            NetworkCapabilities networkCapabilitiesA = androidx.work.impl.utils.k.a(connectivityManager, androidx.work.impl.utils.l.a(connectivityManager));
            if (networkCapabilitiesA != null) {
                return androidx.work.impl.utils.k.b(networkCapabilitiesA, 16);
            }
            return false;
        } catch (SecurityException e11) {
            androidx.work.j.e().d(f75157a, "Unable to validate active network", e11);
            return false;
        }
    }
}
