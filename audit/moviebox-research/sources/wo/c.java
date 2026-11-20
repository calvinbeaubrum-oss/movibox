package wo;

import com.tencent.mmkv.MMKV;
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
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f79578a = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static MMKV f79579b;

    public final String a(String key, String defaultValue) {
        Intrinsics.g(key, "key");
        Intrinsics.g(defaultValue, "defaultValue");
        if (f79579b == null) {
            f79579b = MMKV.z("mmkv_net");
        }
        MMKV mmkv = f79579b;
        String string = mmkv != null ? mmkv.getString(key, defaultValue) : null;
        return string == null ? defaultValue : string;
    }

    public final void b(String key, String value) {
        Intrinsics.g(key, "key");
        Intrinsics.g(value, "value");
        if (f79579b == null) {
            f79579b = MMKV.z("mmkv_net");
        }
        MMKV mmkv = f79579b;
        if (mmkv != null) {
            mmkv.putString(key, value);
        }
    }
}
