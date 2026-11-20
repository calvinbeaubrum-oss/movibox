package com.transsion.commercialization.aha;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
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
@Keep
@Metadata
public final class AhaGameRequest implements Serializable {

    @SerializedName("query")
    private AhaGameQuery query;

    public AhaGameRequest(AhaGameQuery query) {
        Intrinsics.g(query, "query");
        this.query = query;
    }

    public static /* synthetic */ AhaGameRequest copy$default(AhaGameRequest ahaGameRequest, AhaGameQuery ahaGameQuery, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            ahaGameQuery = ahaGameRequest.query;
        }
        return ahaGameRequest.copy(ahaGameQuery);
    }

    public final AhaGameQuery component1() {
        return this.query;
    }

    public final AhaGameRequest copy(AhaGameQuery query) {
        Intrinsics.g(query, "query");
        return new AhaGameRequest(query);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AhaGameRequest) && Intrinsics.b(this.query, ((AhaGameRequest) obj).query);
    }

    public final AhaGameQuery getQuery() {
        return this.query;
    }

    public int hashCode() {
        return this.query.hashCode();
    }

    public final void setQuery(AhaGameQuery ahaGameQuery) {
        Intrinsics.g(ahaGameQuery, "<set-?>");
        this.query = ahaGameQuery;
    }

    public String toString() {
        return "AhaGameRequest(query=" + this.query + ")";
    }
}
