package oq;

import java.util.List;
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
    public static final a f72510a = new a();

    public final void a(List<String> strings) {
        Intrinsics.g(strings, "strings");
        e.f72517a.c(strings);
    }

    public final void b() {
        com.transsion.ad.a.z(com.transsion.ad.a.f50276a, a.class.getSimpleName() + " --> setFullSearchModelSkipHotSplashAd() --> 接收到了deeplink事件 --> 全搜的时候热启动不展示热启动广告", false, 2, null);
        b.f72511a.b(true);
    }

    public final void c(boolean z11) {
        c.f72513a.b(z11);
    }

    public final void d(boolean z11) {
        e.f72517a.d(z11);
    }
}
