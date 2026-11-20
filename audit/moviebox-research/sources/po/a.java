package po;

import com.applovin.sdk.AppLovinMediationProvider;
import java.util.Map;
import java.util.TimeZone;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f73954a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f73955b = "";

    public final String a() {
        if (!b(f73955b)) {
            String str = f73955b;
            Intrinsics.d(str);
            return str;
        }
        TimeZone timeZone = TimeZone.getDefault();
        String id2 = timeZone.getID();
        if (b(id2)) {
            String displayName = timeZone.getDisplayName(false, 0);
            if (b(displayName)) {
                f73955b = "";
                displayName = AppLovinMediationProvider.UNKNOWN;
            } else {
                f73955b = displayName;
            }
            id2 = displayName;
            Intrinsics.f(id2, "{\n            val name =…e\n            }\n        }");
        } else {
            f73955b = id2;
            Intrinsics.f(id2, "{\n            zoneStr = …\n            id\n        }");
        }
        return id2;
    }

    public final boolean b(String str) {
        return str == null || str.length() == 0;
    }

    public final boolean c(Map<?, ?> map) {
        return (map == null || map.isEmpty()) ? false : true;
    }
}
