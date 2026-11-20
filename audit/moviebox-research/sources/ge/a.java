package ge;

import android.webkit.DownloadListener;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.node.Node;
import com.cloud.tmc.kernel.proxy.render.IWebViewDownloadProxy;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class a implements DownloadListener {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C0688a f65478b = new C0688a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Node f65479a;

    /* JADX INFO: renamed from: ge.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class C0688a {
        public C0688a() {
        }

        public /* synthetic */ C0688a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public a(Node node) {
        Intrinsics.g(node, "node");
        this.f65479a = node;
    }

    public final void a(JsonObject data) {
        Intrinsics.g(data, "data");
        try {
            ((IWebViewDownloadProxy) tc.a.a(IWebViewDownloadProxy.class)).dispatchDownloadFailEvent(this.f65479a, data);
        } catch (Throwable th2) {
            TmcLogger.g("DefaultDownloadListener", "", th2);
        }
    }

    @Override // android.webkit.DownloadListener
    public void onDownloadStart(String str, String str2, String str3, String str4, long j11) {
        try {
            ((IWebViewDownloadProxy) tc.a.a(IWebViewDownloadProxy.class)).dispatchDownloadEvent(this.f65479a, str, str2, str3, str4, j11);
        } catch (Throwable th2) {
            TmcLogger.g("DefaultDownloadListener", "", th2);
        }
    }
}
