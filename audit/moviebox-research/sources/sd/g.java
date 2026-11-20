package sd;

import androidx.appcompat.app.w;
import com.cloud.tmc.kernel.log.TmcLogger;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f76294a = new g();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f76295b = "MiniDialogManager";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap<String, WeakReference<w>> f76296c = new ConcurrentHashMap<>();

    public final void a(String token, w wVar) {
        Intrinsics.g(token, "token");
        try {
            b(token);
            TmcLogger.c(f76295b, "addDialog token -> " + token);
            f76296c.put(token, new WeakReference<>(wVar));
        } catch (Throwable th2) {
            TmcLogger.g(f76295b, "addDialog", th2);
        }
    }

    public final void b(String token) {
        w wVar;
        Intrinsics.g(token, "token");
        try {
            String str = f76295b;
            TmcLogger.c(str, "cancelDialogUI??? token -> " + token + ' ');
            WeakReference<w> weakReference = f76296c.get(token);
            if (weakReference != null && (wVar = weakReference.get()) != null) {
                if (wVar.isShowing()) {
                    TmcLogger.c(str, "cancelDialogUI dismiss token->" + token);
                    wVar.dismiss();
                }
                c(token);
            }
        } catch (Throwable th2) {
            TmcLogger.g(f76295b, "cancelDialogUI", th2);
        }
    }

    public final void c(String token) {
        Intrinsics.g(token, "token");
        try {
            TmcLogger.c(f76295b, "removeDialog token ->" + token);
            f76296c.remove(token);
        } catch (Throwable th2) {
            TmcLogger.g(f76295b, "removeDialog", th2);
        }
    }
}
