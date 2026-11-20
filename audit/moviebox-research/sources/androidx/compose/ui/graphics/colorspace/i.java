package androidx.compose.ui.graphics.colorspace;

import androidx.collection.c0;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;

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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@SourceDebugExtension
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c0<h> f4061a;

    static {
        g gVar = g.f4027a;
        int iD = gVar.w().d();
        int iD2 = gVar.w().d();
        n.a aVar = n.f4079a;
        DefaultConstructorMarker defaultConstructorMarker = null;
        f4061a = androidx.collection.o.c(iD | (iD2 << 6) | (aVar.b() << 12), h.f4051g.c(gVar.w()), gVar.w().d() | (gVar.t().d() << 6) | (aVar.b() << 12), new h(gVar.w(), gVar.t(), aVar.b(), defaultConstructorMarker), gVar.t().d() | (gVar.w().d() << 6) | (aVar.b() << 12), new h(gVar.t(), gVar.w(), aVar.b(), defaultConstructorMarker));
    }

    public static final c0<h> a() {
        return f4061a;
    }
}
