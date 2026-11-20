package r6;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import androidx.annotation.RequiresApi;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(24)
@Metadata
public final class i extends g<p6.b> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ConnectivityManager f75154f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final a f75155g;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends ConnectivityManager.NetworkCallback {
        public a() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network network, NetworkCapabilities capabilities) {
            Intrinsics.g(network, "network");
            Intrinsics.g(capabilities, "capabilities");
            androidx.work.j.e().a(j.f75157a, "Network capabilities changed: " + capabilities);
            i iVar = i.this;
            iVar.g(j.c(iVar.f75154f));
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            Intrinsics.g(network, "network");
            androidx.work.j.e().a(j.f75157a, "Network connection lost");
            i iVar = i.this;
            iVar.g(j.c(iVar.f75154f));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(Context context, t6.c taskExecutor) {
        super(context, taskExecutor);
        Intrinsics.g(context, "context");
        Intrinsics.g(taskExecutor, "taskExecutor");
        Object systemService = d().getSystemService("connectivity");
        Intrinsics.e(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        this.f75154f = (ConnectivityManager) systemService;
        this.f75155g = new a();
    }

    @Override // r6.g
    public void h() {
        try {
            androidx.work.j.e().a(j.f75157a, "Registering network callback");
            androidx.work.impl.utils.m.a(this.f75154f, this.f75155g);
        } catch (IllegalArgumentException e11) {
            androidx.work.j.e().d(j.f75157a, "Received exception while registering network callback", e11);
        } catch (SecurityException e12) {
            androidx.work.j.e().d(j.f75157a, "Received exception while registering network callback", e12);
        }
    }

    @Override // r6.g
    public void i() {
        try {
            androidx.work.j.e().a(j.f75157a, "Unregistering network callback");
            androidx.work.impl.utils.k.c(this.f75154f, this.f75155g);
        } catch (IllegalArgumentException e11) {
            androidx.work.j.e().d(j.f75157a, "Received exception while unregistering network callback", e11);
        } catch (SecurityException e12) {
            androidx.work.j.e().d(j.f75157a, "Received exception while unregistering network callback", e12);
        }
    }

    @Override // r6.g
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public p6.b e() {
        return j.c(this.f75154f);
    }
}
