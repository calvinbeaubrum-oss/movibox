package nb;

import com.cloud.tmc.integration.utils.o0;
import com.cloud.tmc.kernel.log.TmcLogger;
import kotlin.Metadata;

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
public interface b {

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public static boolean a(b bVar, String str, String str2) {
            if (str == null) {
                str = "";
            }
            if (str2 == null) {
                str2 = "";
            }
            boolean zC = o0.f31090a.c(str, str2);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("框架包是否支持：");
            sb2.append(!zC);
            sb2.append("; 目标版本：");
            sb2.append(str);
            sb2.append(", 预热版本：");
            sb2.append(str2);
            TmcLogger.c("InnerWarmup", sb2.toString());
            return !zC;
        }
    }
}
