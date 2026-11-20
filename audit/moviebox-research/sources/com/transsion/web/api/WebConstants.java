package com.transsion.web.api;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class WebConstants {
    public static final String BOTTOM_MARGIN = "bottom_margin";
    public static final Companion Companion = new Companion(null);
    public static final String FIELD_DEEPLINK = "deeplink";
    public static final String FIELD_ITEM = "item";
    public static final String FIELD_LOAD_URL_ONLY = "load_url_only";
    public static final String FIELD_STATUS_BAR_HIDDEN = "tool_status_bar_hidden";
    public static final String FIELD_TOOL_BAR_HIDDEN = "tool_bar_hidden";
    public static final String FIELD_URL = "url";
    public static final String HEADER_BG = "header_GB";
    public static final String NEED_HEADER = "need_header";
    public static final String PAGE_FROM = "page_from";
    public static final String TAB_CODE = "tab_code";

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
