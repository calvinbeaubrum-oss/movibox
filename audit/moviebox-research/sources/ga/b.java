package ga;

import android.os.Build;
import android.text.TextUtils;
import com.cloud.sdk.commonutil.util.c;
import com.cloud.tmc.ad.bean.AdExtraBean;
import com.cloud.tmc.ad.bean.DownUpPointBean;
import com.cloud.tmc.ad.bean.response.AdsDTO;
import com.cloud.tmc.ad.utils.MitNetUtil;
import com.cloud.tmc.integration.utils.g;
import com.cloud.tmc.integration.utils.q;
import com.cloud.tmc.kernel.utils.p;
import com.transsion.core.deviceinfo.DeviceInfo;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.l;

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
@SourceDebugExtension
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f65469a = new b();

    @JvmStatic
    public static final boolean d(String landingUrl) {
        Intrinsics.g(landingUrl, "landingUrl");
        if (TextUtils.isEmpty(landingUrl)) {
            return false;
        }
        a.C0686a c0686a = a.f65463a;
        return StringsKt__StringsKt.Q(landingUrl, c0686a.d(), false, 2, null) || StringsKt__StringsKt.Q(landingUrl, c0686a.c(), false, 2, null) || StringsKt__StringsKt.Q(landingUrl, c0686a.b(), false, 2, null) || StringsKt__StringsKt.Q(landingUrl, c0686a.a(), false, 2, null);
    }

    public final List<String> a(List<String> list) {
        ArrayList arrayList = new ArrayList();
        if (list == null || list.isEmpty()) {
            p.a(c.TRACK_TAG, "createAdmExposureServerUrls --> urls==null || urls.size()=<1 --> return ");
            return arrayList;
        }
        for (String str : list) {
            if (str != null) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    public final List<String> b(List<String> list, AdsDTO adsDTO, AdExtraBean adExtraBean, String str, DownUpPointBean downUpPointBean) {
        String strG;
        Intrinsics.g(adsDTO, "adsDTO");
        Intrinsics.g(adExtraBean, "adExtraBean");
        ArrayList arrayList = new ArrayList();
        if (downUpPointBean != null) {
            arrayList.add(f(downUpPointBean, adsDTO, adExtraBean, true));
        } else if (str != null && list != null) {
            for (String str2 : list) {
                if (str2 != null && (strG = f65469a.g(str2, str, 0.0d, null)) != null) {
                    arrayList.add(strG);
                }
            }
        }
        return arrayList;
    }

    public final List<String> c(List<String> list, AdsDTO adsDTO, AdExtraBean adExtraBean, DownUpPointBean pointBean) {
        Intrinsics.g(adsDTO, "adsDTO");
        Intrinsics.g(adExtraBean, "adExtraBean");
        Intrinsics.g(pointBean, "pointBean");
        ArrayList arrayList = new ArrayList();
        if (list == null || list.isEmpty()) {
            p.a(c.TRACK_TAG, "createPicExposureServerUrls--> urls==null || urls.size()=<1 --> return ");
            return arrayList;
        }
        for (String str : list) {
            if (str != null) {
                if (d(str)) {
                    adsDTO.setImpressionUrl(str);
                    String strF = f65469a.f(pointBean, adsDTO, adExtraBean, false);
                    if (strF != null && !TextUtils.isEmpty(strF)) {
                        arrayList.add(strF);
                    }
                } else {
                    b bVar = f65469a;
                    String clickid = adsDTO.getClickid();
                    Intrinsics.f(clickid, "adsDTO.clickid");
                    Double auctionSecondPrice = adsDTO.getAuctionSecondPrice();
                    Intrinsics.f(auctionSecondPrice, "adsDTO.auctionSecondPrice");
                    String strG = bVar.g(str, clickid, auctionSecondPrice.doubleValue(), adsDTO.getSettlementRatio());
                    if (strG != null && !TextUtils.isEmpty(strG)) {
                        arrayList.add(strG);
                    }
                }
            }
        }
        return arrayList;
    }

    public final String e(String str, String str2, double d11, BigDecimal bigDecimal) {
        if (str == null || str2 == null) {
            return str;
        }
        String strF = str;
        while (strF != null && StringsKt__StringsKt.Q(strF, "__CLICK_ID__", false, 2, null)) {
            strF = l.F(strF, "__CLICK_ID__", str2, false, 4, null);
        }
        String strValueOf = String.valueOf(System.currentTimeMillis() + g.f31057a.a().g("services_time_difference_value"));
        Intrinsics.f(strValueOf, "valueOf(\n            Sys…FFERENCE_VALUE)\n        )");
        String strF2 = strF;
        while (strF2 != null && StringsKt__StringsKt.Q(strF2, "__CLICK_TS__", false, 2, null)) {
            strF2 = l.F(strF2, "__CLICK_TS__", strValueOf, false, 4, null);
        }
        String strH = q.f31091a.h();
        String strF3 = strF2;
        while (strF3 != null && StringsKt__StringsKt.Q(strF3, "__CLICK_IP__", false, 2, null)) {
            strF3 = l.F(strF3, "__CLICK_IP__", strH, false, 4, null);
        }
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(d11);
        if (bigDecimal != null && bigDecimal.compareTo(BigDecimal.ZERO) > 0) {
            bigDecimalValueOf = bigDecimalValueOf.divide(bigDecimal, 0, 2).add(new BigDecimal(1));
        }
        String string = bigDecimalValueOf.divide(BigDecimal.valueOf(100L), 2, 2).toString();
        Intrinsics.f(string, "secondPriceDollar.toString()");
        String strF4 = strF3;
        while (strF4 != null && StringsKt__StringsKt.Q(strF4, "${AUCTION_PRICE}", false, 2, null)) {
            strF4 = l.F(strF4, "${AUCTION_PRICE}", string, false, 4, null);
        }
        return strF4;
    }

    public final String f(DownUpPointBean pointBean, AdsDTO adsDTO, AdExtraBean adExtraBean, boolean z11) {
        Intrinsics.g(pointBean, "pointBean");
        Intrinsics.g(adsDTO, "adsDTO");
        Intrinsics.g(adExtraBean, "adExtraBean");
        p.a(c.TRACK_TAG, "TrackingManager --> processUrl --> 处理前 url = " + adsDTO.getClickUrl());
        StringBuilder sb2 = new StringBuilder();
        if (z11) {
            sb2.append("xd=" + pointBean.getDownX());
            sb2.append("&yd=" + pointBean.getDownY());
            sb2.append("&xu=" + pointBean.getUpX());
            sb2.append("&yu=" + pointBean.getUpY());
        }
        sb2.append("&ai=" + adsDTO.getApp_id());
        sb2.append("&pn=" + com.transsion.core.utils.a.a());
        sb2.append("&ve=" + com.transsion.core.utils.a.c());
        sb2.append("&sv=" + adExtraBean.getSdkVersion());
        sb2.append("&ot=1");
        sb2.append("&ov=" + q.m());
        sb2.append("&nc=" + MitNetUtil.f30346a.a(ws.a.a()).ordinal());
        if (ha.a.c() != null && ha.a.d() != null) {
            sb2.append("&op=" + ha.a.c() + ha.a.d());
        }
        sb2.append("&ga=" + q.d());
        StringBuilder sb3 = new StringBuilder();
        sb3.append("&dt=");
        sb3.append(DeviceInfo.h() ? 2 : 1);
        sb2.append(sb3.toString());
        sb2.append("&br=" + Build.BRAND);
        sb2.append("&mo=" + Build.MODEL);
        sb2.append("&ma=" + Build.MANUFACTURER);
        sb2.append("&la=" + ja.a.c());
        sb2.append("&lo=" + ja.a.e());
        sb2.append("&iw=" + pointBean.getImageW());
        sb2.append("&ih=" + pointBean.getImageH());
        sb2.append("&ci=" + adsDTO.getClickid());
        sb2.append("&tr=" + adExtraBean.getTestMode());
        sb2.append("&ia=" + adsDTO.getInstallApk());
        if (z11) {
            sb2.append("&pt=" + adsDTO.getAdPsType());
        }
        if (!adsDTO.isOfflineAd()) {
            sb2.append("&ta=" + q.f31091a.f());
            sb2.append("&oi=");
        }
        p.a(c.TRACK_TAG, "athena --> sb=" + ((Object) sb2));
        String clickUrl = z11 ? adsDTO.getClickUrl() : adsDTO.getImpressionUrl();
        StringBuilder sb4 = new StringBuilder();
        sb4.append(clickUrl);
        sb4.append("&p1=");
        String string = sb2.toString();
        Intrinsics.f(string, "sb.toString()");
        sb4.append(com.cloud.tmc.integration.utils.a.a(string));
        sb4.append("&r1=");
        String newPrice_Click = adsDTO.getNewPrice_Click();
        Intrinsics.f(newPrice_Click, "adsDTO.newPrice_Click");
        sb4.append(com.cloud.tmc.integration.utils.a.a(newPrice_Click));
        String url = sb4.toString();
        p.a(c.TRACK_TAG, "TrackingManager --> processUrl --> process after url = " + url);
        Intrinsics.f(url, "url");
        return url;
    }

    public final String g(String str, String str2, double d11, BigDecimal bigDecimal) {
        return TextUtils.isEmpty(str) ? str : e(str, str2, d11, bigDecimal);
    }
}
