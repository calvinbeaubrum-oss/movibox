package py;

import android.annotation.SuppressLint;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Build;
import com.blankj.utilcode.util.Utils;
import com.transsion.transfer.wifi.util.g;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f74064a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Network f74065b;

    public final String a() {
        String simpleName = a.class.getSimpleName();
        Intrinsics.f(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    public final void b() {
        Object objM163constructorimpl;
        try {
            Result.Companion companion = Result.Companion;
            if (f74065b != null) {
                f74065b = null;
            }
            if (Build.VERSION.SDK_INT >= 23) {
                Object systemService = Utils.a().getApplicationContext().getSystemService("connectivity");
                ConnectivityManager connectivityManager = systemService instanceof ConnectivityManager ? (ConnectivityManager) systemService : null;
                if (connectivityManager != null) {
                    connectivityManager.bindProcessToNetwork(null);
                }
            } else {
                ConnectivityManager.setProcessDefaultNetwork(null);
            }
            g.b(g.f59252a, f74064a.a() + " --> releaseDefaultNetwork() --> Success", false, 2, null);
            objM163constructorimpl = Result.m163constructorimpl(Unit.f68710a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        Throwable thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(objM163constructorimpl);
        if (thM166exceptionOrNullimpl == null) {
            return;
        }
        g.d(g.f59252a, f74064a.a() + " --> releaseDefaultNetwork() --> it = " + thM166exceptionOrNullimpl, false, 2, null);
    }

    @SuppressLint({"MissingPermission"})
    public final boolean c() {
        NetworkInfo networkInfo;
        Object systemService = Utils.a().getApplicationContext().getSystemService("connectivity");
        Intrinsics.e(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
        int i11 = 0;
        boolean z11 = false;
        do {
            i11++;
            Network[] allNetworks = connectivityManager.getAllNetworks();
            Intrinsics.f(allNetworks, "cm.allNetworks");
            g.b(g.f59252a, a() + " --> setProcessDefaultNetwork() --> setProcessDefaultNetwork size = " + allNetworks.length, false, 2, null);
            for (Network network : allNetworks) {
                try {
                    networkInfo = connectivityManager.getNetworkInfo(network);
                } catch (Exception e11) {
                    e11.printStackTrace();
                    networkInfo = null;
                }
                g gVar = g.f59252a;
                g.b(gVar, a() + " --> setProcessDefaultNetwork() --> setProcessDefaultNetwork = " + networkInfo + ", network = " + network, false, 2, null);
                if (networkInfo != null && networkInfo.getType() == 1) {
                    g.b(gVar, a() + " --> setProcessDefaultNetwork() --> setProcessDefaultNetwork2 = " + network, false, 2, null);
                    f74065b = network;
                    if (Build.VERSION.SDK_INT >= 23) {
                        connectivityManager.bindProcessToNetwork(network);
                    } else {
                        ConnectivityManager.setProcessDefaultNetwork(network);
                    }
                    z11 = true;
                }
            }
            if (z11) {
                g.b(g.f59252a, a() + " --> setProcessDefaultNetwork() --> setProcessDefaultNetwork OK!", false, 2, null);
                break;
            }
            g.b(g.f59252a, a() + " --> setProcessDefaultNetwork() --> setProcessDefaultNetwork failed, start to sleep", false, 2, null);
        } while (i11 < 20);
        return z11;
    }
}
