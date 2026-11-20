package com.transsion.subtitle.bean;

import androidx.annotation.Keep;
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
/* JADX INFO: loaded from: classes8.dex */
@Keep
@Metadata
public final class QueryParameters {
    private final String episode;
    private final String query;
    private final String season;
    private final String sublanguageid;

    public QueryParameters(String episode, String query, String season, String sublanguageid) {
        Intrinsics.g(episode, "episode");
        Intrinsics.g(query, "query");
        Intrinsics.g(season, "season");
        Intrinsics.g(sublanguageid, "sublanguageid");
        this.episode = episode;
        this.query = query;
        this.season = season;
        this.sublanguageid = sublanguageid;
    }

    public static /* synthetic */ QueryParameters copy$default(QueryParameters queryParameters, String str, String str2, String str3, String str4, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = queryParameters.episode;
        }
        if ((i11 & 2) != 0) {
            str2 = queryParameters.query;
        }
        if ((i11 & 4) != 0) {
            str3 = queryParameters.season;
        }
        if ((i11 & 8) != 0) {
            str4 = queryParameters.sublanguageid;
        }
        return queryParameters.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.episode;
    }

    public final String component2() {
        return this.query;
    }

    public final String component3() {
        return this.season;
    }

    public final String component4() {
        return this.sublanguageid;
    }

    public final QueryParameters copy(String episode, String query, String season, String sublanguageid) {
        Intrinsics.g(episode, "episode");
        Intrinsics.g(query, "query");
        Intrinsics.g(season, "season");
        Intrinsics.g(sublanguageid, "sublanguageid");
        return new QueryParameters(episode, query, season, sublanguageid);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof QueryParameters)) {
            return false;
        }
        QueryParameters queryParameters = (QueryParameters) obj;
        return Intrinsics.b(this.episode, queryParameters.episode) && Intrinsics.b(this.query, queryParameters.query) && Intrinsics.b(this.season, queryParameters.season) && Intrinsics.b(this.sublanguageid, queryParameters.sublanguageid);
    }

    public final String getEpisode() {
        return this.episode;
    }

    public final String getQuery() {
        return this.query;
    }

    public final String getSeason() {
        return this.season;
    }

    public final String getSublanguageid() {
        return this.sublanguageid;
    }

    public int hashCode() {
        return (((((this.episode.hashCode() * 31) + this.query.hashCode()) * 31) + this.season.hashCode()) * 31) + this.sublanguageid.hashCode();
    }

    public String toString() {
        return "QueryParameters(episode=" + this.episode + ", query=" + this.query + ", season=" + this.season + ", sublanguageid=" + this.sublanguageid + ")";
    }
}
