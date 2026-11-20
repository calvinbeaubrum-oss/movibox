package androidx.compose.ui.platform;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class z2 implements y2 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f5564b = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final androidx.compose.runtime.i1<androidx.compose.ui.input.pointer.j0> f5565c = androidx.compose.runtime.u2.c(androidx.compose.ui.input.pointer.j0.a(androidx.compose.ui.input.pointer.t.a()), null, 2, null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final androidx.compose.runtime.i1<Boolean> f5566a = androidx.compose.runtime.u2.c(Boolean.FALSE, null, 2, null);

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public void a(int i11) {
        f5565c.setValue(androidx.compose.ui.input.pointer.j0.a(i11));
    }

    public void b(boolean z11) {
        this.f5566a.setValue(Boolean.valueOf(z11));
    }
}
