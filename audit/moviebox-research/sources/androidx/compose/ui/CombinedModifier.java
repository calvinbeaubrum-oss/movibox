package androidx.compose.ui;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

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
public final class CombinedModifier implements f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f3766b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f3767c;

    public CombinedModifier(f fVar, f fVar2) {
        this.f3766b = fVar;
        this.f3767c = fVar2;
    }

    public final f a() {
        return this.f3767c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.ui.f
    public <R> R c(R r11, Function2<? super R, ? super f.b, ? extends R> function2) {
        return (R) this.f3767c.c(this.f3766b.c(r11, function2), function2);
    }

    @Override // androidx.compose.ui.f
    public boolean d(Function1<? super f.b, Boolean> function1) {
        return this.f3766b.d(function1) && this.f3767c.d(function1);
    }

    public boolean equals(Object obj) {
        if (obj instanceof CombinedModifier) {
            CombinedModifier combinedModifier = (CombinedModifier) obj;
            if (Intrinsics.b(this.f3766b, combinedModifier.f3766b) && Intrinsics.b(this.f3767c, combinedModifier.f3767c)) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.compose.ui.f
    public /* synthetic */ f f(f fVar) {
        return e.a(this, fVar);
    }

    public int hashCode() {
        return this.f3766b.hashCode() + (this.f3767c.hashCode() * 31);
    }

    public final f o() {
        return this.f3766b;
    }

    public String toString() {
        return '[' + ((String) c("", new Function2<String, f.b, String>() { // from class: androidx.compose.ui.CombinedModifier.toString.1
            @Override // kotlin.jvm.functions.Function2
            public final String invoke(String str, f.b bVar) {
                if (str.length() == 0) {
                    return bVar.toString();
                }
                return str + ", " + bVar;
            }
        })) + ']';
    }
}
