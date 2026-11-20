package w9;

import android.text.TextUtils;
import com.cloud.hisavana.sdk.common.bean.VastClick;
import com.cloud.hisavana.sdk.common.bean.VastData;
import com.cloud.hisavana.sdk.common.bean.VastIcon;
import com.cloud.hisavana.sdk.common.bean.VastMedia;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.sdk.commonutil.util.DeviceUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f79345a = new a();

    public final String a(AdsDTO adsDTO) {
        String adImgUrl;
        VastMedia mainAd;
        if (adsDTO == null || !adsDTO.isVastTypeAd()) {
            adImgUrl = adsDTO != null ? adsDTO.getAdImgUrl() : null;
        } else {
            VastData videoInfo = adsDTO.getVideoInfo();
            if (videoInfo == null || (mainAd = videoInfo.getMainAd()) == null || (adImgUrl = mainAd.getMediaResource()) == null) {
                adImgUrl = "";
            }
        }
        com.cloud.hisavana.sdk.z.a().d("AdMediaUtil", "getAdMainUrl ---->  " + adImgUrl);
        return adImgUrl;
    }

    public final int b(AdsDTO adsDTO) {
        String type;
        VastMedia mainAd;
        int i11 = 0;
        if (adsDTO != null && adsDTO.isVastTypeAd()) {
            VastData videoInfo = adsDTO.getVideoInfo();
            if (videoInfo == null || (mainAd = videoInfo.getMainAd()) == null || (type = mainAd.getType()) == null) {
                type = "";
            }
            if (kotlin.text.l.L(type, "video/", false, 2, null)) {
                i11 = 1;
            } else {
                i11 = kotlin.text.l.L(type, "image/", false, 2, null) ? 2 : -1;
            }
        }
        com.cloud.hisavana.sdk.z.a().d("AdMediaUtil", "getAdMediaType ---->  " + i11);
        return i11;
    }

    public final List<String> c(AdsDTO adsDTO, int i11) {
        VastData videoInfo;
        VastClick vastClick;
        List<String> clickTrack;
        VastData videoInfo2;
        VastIcon icon;
        List<String> iconClickTracking;
        if (i11 == 1) {
            return (adsDTO == null || (videoInfo2 = adsDTO.getVideoInfo()) == null || (icon = videoInfo2.getIcon()) == null || (iconClickTracking = icon.getIconClickTracking()) == null) ? new ArrayList() : iconClickTracking;
        }
        return (adsDTO == null || (videoInfo = adsDTO.getVideoInfo()) == null || (vastClick = videoInfo.getVastClick()) == null || (clickTrack = vastClick.getClickTrack()) == null) ? new ArrayList() : clickTrack;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0035 A[PHI: r3
  0x0035: PHI (r3v5 java.lang.String) = (r3v3 java.lang.String), (r3v8 java.lang.String) binds: [B:30:0x004b, B:20:0x0032] A[DONT_GENERATE, DONT_INLINE]] */
    public final String d(AdsDTO adsDTO, int i11) {
        VastData videoInfo;
        VastClick vastClick;
        String videoClick;
        String iconClick;
        VastData videoInfo2;
        VastClick vastClick2;
        VastData videoInfo3;
        VastIcon icon;
        String str = "";
        if (i11 == 1) {
            if (adsDTO == null || (videoInfo3 = adsDTO.getVideoInfo()) == null || (icon = videoInfo3.getIcon()) == null || (iconClick = icon.getIconClick()) == null) {
                iconClick = "";
            }
            if (!TextUtils.isEmpty(iconClick)) {
                str = iconClick;
            } else if (adsDTO != null && (videoInfo2 = adsDTO.getVideoInfo()) != null && (vastClick2 = videoInfo2.getVastClick()) != null && (videoClick = vastClick2.getVideoClick()) != null) {
                str = videoClick;
            }
        } else if (adsDTO != null && (videoInfo = adsDTO.getVideoInfo()) != null && (vastClick = videoInfo.getVastClick()) != null && (videoClick = vastClick.getVideoClick()) != null) {
            str = videoClick;
        }
        com.cloud.hisavana.sdk.z.a().d("AdMediaUtil", "getClickUrl is ---> getClickUrl = " + str);
        return str;
    }

    public final String e(AdsDTO ad2, int i11) {
        int i12;
        Intrinsics.g(ad2, "ad");
        if (ad2.getSource() == 4) {
            i12 = 2;
        } else {
            i12 = ad2.isOfflineAd() ? 1 : 0;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("s_");
        String strN = DeviceUtil.n();
        Intrinsics.f(strN, "getUUID()");
        sb2.append(new Regex("-").replace(strN, ""));
        sb2.append(",n_");
        sb2.append(i11);
        sb2.append(",t_");
        sb2.append(i12);
        return sb2.toString();
    }
}
