package androidx.compose.ui.draw;

import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;

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
public final class j implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f3857a = new j();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f3858b = y1.m.f81091b.a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final LayoutDirection f3859c = LayoutDirection.Ltr;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final q2.e f3860d = q2.g.a(1.0f, 1.0f);

    @Override // androidx.compose.ui.draw.a
    public q2.e getDensity() {
        return f3860d;
    }

    @Override // androidx.compose.ui.draw.a
    public LayoutDirection getLayoutDirection() {
        return f3859c;
    }

    @Override // androidx.compose.ui.draw.a
    public long i() {
        return f3858b;
    }
}
