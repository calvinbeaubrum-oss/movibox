package com.transsion.postdetail.util;

import android.annotation.SuppressLint;
import com.tn.lib.util.networkinfo.NetworkType;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.moviedetailapi.bean.Video;
import com.transsion.postdetail.layer.local.LocalUiType;
import com.transsion.subtitle.helper.LocalVideoUiType;
import java.text.SimpleDateFormat;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@SourceDebugExtension
public final class l {

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f56222a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f56223b;

        static {
            int[] iArr = new int[NetworkType.values().length];
            try {
                iArr[NetworkType.NETWORK_WIFI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[NetworkType.NETWORK_5G.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[NetworkType.NETWORK_4G.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[NetworkType.NETWORK_3G.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[NetworkType.NETWORK_2G.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f56222a = iArr;
            int[] iArr2 = new int[LocalUiType.values().length];
            try {
                iArr2[LocalUiType.LAND.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[LocalUiType.MIDDLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[LocalUiType.PORTRAIT.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            f56223b = iArr2;
        }
    }

    public static final Video a(List<Video> list) {
        Video video = null;
        if (list != null) {
            for (Video video2 : list) {
                Integer definition = video2.getDefinition();
                if (definition != null && definition.intValue() == 3) {
                    video = video2;
                }
            }
        }
        if (video == null && list != null && (!list.isEmpty())) {
            video = list.get(0);
        }
        return video;
    }

    public static final String b(DownloadBean downloadBean) {
        if (downloadBean == null || !downloadBean.isInnerRes()) {
            return "2";
        }
        return (downloadBean == null || downloadBean.getStatus() != 5) ? "1" : "0";
    }

    public static final LocalVideoUiType c(LocalUiType uiType) {
        Intrinsics.g(uiType, "uiType");
        int i11 = a.f56223b[uiType.ordinal()];
        if (i11 == 1) {
            return LocalVideoUiType.LAND;
        }
        if (i11 == 2) {
            return LocalVideoUiType.MIDDLE;
        }
        if (i11 == 3) {
            return LocalVideoUiType.PORTRAIT;
        }
        throw new NoWhenBranchMatchedException();
    }

    @SuppressLint({"SimpleDateFormat"})
    public static final String d() {
        return new SimpleDateFormat("HH:mm").format(Long.valueOf(System.currentTimeMillis())).toString();
    }
}
