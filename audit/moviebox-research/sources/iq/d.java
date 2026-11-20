package iq;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f67594a = new d();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String[] f67595b = new String[0];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String[] f67596c = new String[0];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String[] f67597d = new String[0];

    @JvmStatic
    public static final boolean a(String host) {
        Intrinsics.g(host, "host");
        return kotlin.collections.d.I(f67597d, host);
    }

    @JvmStatic
    public static final boolean b(String host) {
        Intrinsics.g(host, "host");
        return kotlin.collections.d.I(f67595b, host);
    }

    @JvmStatic
    public static final boolean c(String host) {
        Intrinsics.g(host, "host");
        return kotlin.collections.d.I(f67596c, host);
    }

    @JvmStatic
    public static final boolean d() {
        return f67597d.length == 0;
    }

    public final void e(String[] hosts) {
        Intrinsics.g(hosts, "hosts");
        f67597d = hosts;
    }
}
