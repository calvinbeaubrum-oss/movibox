package com.transsion.home.p003enum;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public enum BottomTabType {
    HOME("BT_HOME"),
    SHORT_TV("BT_SHORTTV"),
    H5TAB("BT_H5"),
    OPERATION("BT_OPERATE"),
    DOWNLOAD("BT_DOWNLOADS"),
    PREMIUM("BT_PREMIUM"),
    ROOM("BT_COMMUNITY"),
    SPORTS_LIVE("BT_LIVE"),
    NOVEL("BT_NOVEL"),
    ME("BT_ME");

    public static final a Companion = new a(null);
    public static final String TAB_CODE_COMMUNITY = "COMMUNITY";
    public static final String TAB_CODE_DOWNLOAD = "DOWNLOADS";
    public static final String TAB_CODE_HOME = "HOME";
    public static final String TAB_CODE_ME = "ME";
    public static final String TAB_CODE_MUSIC = "MUSIC";
    public static final String TAB_CODE_NOVEL = "LIVE";
    public static final String TAB_CODE_PREMIUM = "PREMIUM";
    public static final String TAB_CODE_SHORT_TV = "SHORTTV";
    public static final String TAB_OPEN_TYPE_LAND_PAGE = "NEW_PAGE";
    public static final String TAB_OPEN_TYPE_TAB = "REDIRECT";
    private final String value;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    BottomTabType(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }
}
