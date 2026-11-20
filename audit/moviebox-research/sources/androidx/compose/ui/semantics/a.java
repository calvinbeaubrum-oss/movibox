package androidx.compose.ui.semantics;

import kotlin.Function;
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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class a<T extends Function<? extends Boolean>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5627a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final T f5628b;

    public a(String str, T t11) {
        this.f5627a = str;
        this.f5628b = t11;
    }

    public final T a() {
        return this.f5628b;
    }

    public final String b() {
        return this.f5627a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Intrinsics.b(this.f5627a, aVar.f5627a) && Intrinsics.b(this.f5628b, aVar.f5628b);
    }

    public int hashCode() {
        String str = this.f5627a;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        T t11 = this.f5628b;
        return iHashCode + (t11 != null ? t11.hashCode() : 0);
    }

    public String toString() {
        return "AccessibilityAction(label=" + this.f5627a + ", action=" + this.f5628b + ')';
    }
}
