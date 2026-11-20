package d2;

import androidx.compose.runtime.i1;
import androidx.compose.runtime.u2;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
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
public final class c implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<a, Boolean> f62872a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i1 f62873b;

    /* JADX WARN: Multi-variable type inference failed */
    public c(int i11, Function1<? super a, Boolean> function1) {
        this.f62872a = function1;
        this.f62873b = u2.c(a.c(i11), null, 2, null);
    }

    public /* synthetic */ c(int i11, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(i11, function1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // d2.b
    public int a() {
        return ((a) this.f62873b.getValue()).i();
    }

    public void b(int i11) {
        this.f62873b.setValue(a.c(i11));
    }
}
