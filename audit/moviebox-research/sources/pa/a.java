package pa;

import android.os.Bundle;
import com.cloud.tmc.component_api_ps.ipc.MiniAppProtocolIpcProcessor;
import kotlin.Metadata;
import la.b;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class a extends pd.a.AbstractBinderC0801a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f73723a = "IIPCMiniProtocolMainServerImpl";

    @Override // pd.a
    public boolean G(String str, String str2, Bundle bundle) {
        try {
            MiniAppProtocolIpcProcessor.f30350a.g(str2, bundle);
            return true;
        } catch (Throwable th2) {
            b.c(this.f73723a, "onQueryAppBitmapSuccess", th2);
            return true;
        }
    }

    @Override // pd.a
    public boolean J(String str, String str2, Bundle bundle) {
        try {
            MiniAppProtocolIpcProcessor.f30350a.g(str2, bundle);
            return true;
        } catch (Throwable th2) {
            b.c(this.f73723a, "onQueryAppBitmapSuccess", th2);
            return true;
        }
    }

    @Override // pd.a
    public boolean m(String str, String str2, Bundle bundle) {
        try {
            MiniAppProtocolIpcProcessor.f30350a.g(str2, bundle);
            return true;
        } catch (Throwable th2) {
            b.c(this.f73723a, "onQueryAppBitmapSuccess", th2);
            return true;
        }
    }

    @Override // pd.a
    public boolean u(String str, String str2, Bundle bundle) {
        try {
            MiniAppProtocolIpcProcessor.f30350a.g(str2, bundle);
            return true;
        } catch (Throwable th2) {
            b.c(this.f73723a, "onQueryAppBitmapSuccess", th2);
            return true;
        }
    }
}
