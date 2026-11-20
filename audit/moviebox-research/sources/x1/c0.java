package x1;

import androidx.compose.ui.autofill.AutofillType;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

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
public final class c0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f79788d = new a(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f79789e = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<AutofillType> f79790a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public y1.i f79791b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<String, Unit> f79792c;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final List<AutofillType> a() {
        return this.f79790a;
    }

    public final y1.i b() {
        return this.f79791b;
    }

    public final Function1<String, Unit> c() {
        return this.f79792c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c0)) {
            return false;
        }
        c0 c0Var = (c0) obj;
        return Intrinsics.b(this.f79790a, c0Var.f79790a) && Intrinsics.b(this.f79791b, c0Var.f79791b) && this.f79792c == c0Var.f79792c;
    }

    public int hashCode() {
        int iHashCode = this.f79790a.hashCode() * 31;
        y1.i iVar = this.f79791b;
        int iHashCode2 = (iHashCode + (iVar != null ? iVar.hashCode() : 0)) * 31;
        Function1<String, Unit> function1 = this.f79792c;
        return iHashCode2 + (function1 != null ? function1.hashCode() : 0);
    }
}
