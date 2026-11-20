package dq;

import com.tn.tranpay.bean.QueryOrderResultContent;
import com.tn.tranpay.bean.QueryStatus;
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
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final QueryOrderResultContent f63527a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final QueryStatus f63528b;

    public b(QueryOrderResultContent queryOrderResultContent, QueryStatus status) {
        Intrinsics.g(status, "status");
        this.f63527a = queryOrderResultContent;
        this.f63528b = status;
    }

    public final QueryOrderResultContent a() {
        return this.f63527a;
    }

    public final QueryStatus b() {
        return this.f63528b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return Intrinsics.b(this.f63527a, bVar.f63527a) && this.f63528b == bVar.f63528b;
    }

    public int hashCode() {
        QueryOrderResultContent queryOrderResultContent = this.f63527a;
        return ((queryOrderResultContent == null ? 0 : queryOrderResultContent.hashCode()) * 31) + this.f63528b.hashCode();
    }

    public String toString() {
        return "QueryOrderResult(content=" + this.f63527a + ", status=" + this.f63528b + ")";
    }
}
