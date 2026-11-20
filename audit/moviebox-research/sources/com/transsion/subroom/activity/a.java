package com.transsion.subroom.activity;

import com.transsion.home.R$mipmap;
import com.transsion.home.bean.BottomTabItem;
import com.transsion.home.p003enum.BottomTabType;
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
@Metadata
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f58026a = new a();

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final int a(BottomTabItem bottomTabItem) {
        if (bottomTabItem != null && bottomTabItem.isLargeUiType()) {
            return Intrinsics.b(bottomTabItem.getBtTabCode(), BottomTabType.TAB_CODE_COMMUNITY) ? R$mipmap.ic_tab_big_community : com.transsion.subroom.R$mipmap.ic_tab_bottom_large_default;
        }
        String btTabCode = bottomTabItem != null ? bottomTabItem.getBtTabCode() : null;
        if (btTabCode != null) {
            switch (btTabCode.hashCode()) {
                case -1509822498:
                    if (btTabCode.equals(BottomTabType.TAB_CODE_SHORT_TV)) {
                        return R$mipmap.ic_tab_short_tv_unactive;
                    }
                    break;
                case -195667765:
                    if (btTabCode.equals(BottomTabType.TAB_CODE_DOWNLOAD)) {
                        return R$mipmap.ic_tab_downloads_unactive_dark;
                    }
                    break;
                case 2456:
                    if (btTabCode.equals(BottomTabType.TAB_CODE_ME)) {
                        return R$mipmap.ic_tab_me_unactive_dark;
                    }
                    break;
                case 2223327:
                    if (btTabCode.equals(BottomTabType.TAB_CODE_HOME)) {
                        return R$mipmap.ic_tab_home_unactive_dark;
                    }
                    break;
                case 2337004:
                    if (btTabCode.equals(BottomTabType.TAB_CODE_NOVEL)) {
                        return R$mipmap.ic_tab_novel_unactive;
                    }
                    break;
                case 73725445:
                    if (btTabCode.equals(BottomTabType.TAB_CODE_MUSIC)) {
                        return R$mipmap.ic_tab_music_unactive_dark;
                    }
                    break;
                case 399530551:
                    if (btTabCode.equals(BottomTabType.TAB_CODE_PREMIUM)) {
                        return R$mipmap.ic_tab_premium_unactive;
                    }
                    break;
            }
        }
        return 0;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final int b(BottomTabItem bottomTabItem) {
        if (bottomTabItem != null && bottomTabItem.isLargeUiType()) {
            return Intrinsics.b(bottomTabItem.getBtTabCode(), BottomTabType.TAB_CODE_COMMUNITY) ? R$mipmap.ic_tab_big_community : com.transsion.subroom.R$mipmap.ic_tab_bottom_large_default;
        }
        String btTabCode = bottomTabItem != null ? bottomTabItem.getBtTabCode() : null;
        if (btTabCode != null) {
            switch (btTabCode.hashCode()) {
                case -1509822498:
                    if (btTabCode.equals(BottomTabType.TAB_CODE_SHORT_TV)) {
                        return R$mipmap.ic_tab_short_tv_active;
                    }
                    break;
                case -195667765:
                    if (btTabCode.equals(BottomTabType.TAB_CODE_DOWNLOAD)) {
                        return R$mipmap.ic_tab_downloads_active;
                    }
                    break;
                case 2456:
                    if (btTabCode.equals(BottomTabType.TAB_CODE_ME)) {
                        return R$mipmap.ic_tab_me_active;
                    }
                    break;
                case 2223327:
                    if (btTabCode.equals(BottomTabType.TAB_CODE_HOME)) {
                        return R$mipmap.ic_tab_home_active;
                    }
                    break;
                case 2337004:
                    if (btTabCode.equals(BottomTabType.TAB_CODE_NOVEL)) {
                        return R$mipmap.ic_tab_novel_active;
                    }
                    break;
                case 73725445:
                    if (btTabCode.equals(BottomTabType.TAB_CODE_MUSIC)) {
                        return R$mipmap.ic_tab_music_active;
                    }
                    break;
                case 399530551:
                    if (btTabCode.equals(BottomTabType.TAB_CODE_PREMIUM)) {
                        return R$mipmap.ic_tab_premium_activit;
                    }
                    break;
            }
        }
        return 0;
    }
}
