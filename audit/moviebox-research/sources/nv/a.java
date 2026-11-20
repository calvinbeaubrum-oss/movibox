package nv;

import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
import com.transsion.player.p006enum.PlayMimeType;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import lv.c;

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
    public static final a f72164a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f72165b;

    public final String a(lv.a bean) {
        Intrinsics.g(bean, "bean");
        if (bean.s() == PlayMimeType.DASH) {
            return "3";
        }
        if (bean.s() == PlayMimeType.HLS) {
            return bean.t() ? "5" : PrepareException.ERROR_NO_URL;
        }
        c cVar = (c) CollectionsKt___CollectionsKt.g0(bean.i());
        return (cVar == null || !cVar.h()) ? "0" : "4";
    }

    public final boolean b() {
        return f72165b;
    }

    public final void c(boolean z11) {
        f72165b = z11;
    }
}
