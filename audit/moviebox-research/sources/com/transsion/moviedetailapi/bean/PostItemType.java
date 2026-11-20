package com.transsion.moviedetailapi.bean;

import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public enum PostItemType {
    SUBJECT("SUBJECT"),
    OP_RANKING("RANKING"),
    FILTER("FILTER"),
    BANNER("BANNER"),
    CUSTOM_DATA("CUSTOM"),
    APPOINTMENT_LIST("APPOINTMENT_LIST"),
    OP_SUBJECTS_MOVIE("SUBJECTS_MOVIE"),
    RANKING_MOVIE_HORIZONTAL("SUBJ_MOVIE_HORIZ"),
    RANKING_LIST("RANKING_LIST"),
    RANKING_LIST_MUSIC("MUSIC_CHARTS"),
    SPORT_LIVE("SPORT_LIVE"),
    SINGLE_IMAGE("SINGLE_IMAGE"),
    PLAY_LIST("PLAY_LIST"),
    RANKING_LIST_NUMBER("RANKING_HORIZ"),
    HORIZONTAL_BANNER("HORIZONTAL_BANNER"),
    SINGLE_SUBJECT("SINGLE_SUBJECT"),
    EDUCATION_SUBJECT("EDUCATION_SUBJECT"),
    GRID_SUBJECT("GRID_SUBJECT"),
    GAME_LIST("GAME_LIST"),
    NO_NETWORK("no_network"),
    TRENDING_NATIVE_AD("TRENDING_NATIVE_AD"),
    HONOR("HONOR"),
    FEEDS_TITLE("FEEDS_TITLE"),
    MY_COURSE("MY_COURSE"),
    ROOM("ROOM");

    public static final a Companion = new a(null);
    private final String value;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    @SourceDebugExtension
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PostItemType a(String value) {
            Intrinsics.g(value, "value");
            for (PostItemType postItemType : PostItemType.values()) {
                if (Intrinsics.b(postItemType.getValue(), value)) {
                    return postItemType;
                }
            }
            return null;
        }
    }

    PostItemType(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }
}
