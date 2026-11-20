package com.cloud.hisavana.sdk;

import android.text.TextUtils;
import com.cloud.hisavana.net.disklrucache.ImageCacheURL;
import com.cloud.hisavana.net.disklrucache.utils.SafeKeyUtils;
import com.cloud.hisavana.net.utils.StorageUtils;
import com.cloud.hisavana.sdk.data.bean.inapp.ApkInfo;
import com.cloud.hisavana.sdk.data.bean.inapp.DefaultAdDTO;
import com.cloud.hisavana.sdk.data.bean.inapp.PsAppInfo;
import com.cloud.hisavana.sdk.data.bean.request.AdxImpBean;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.hisavana.sdk.data.bean.response.AdsProtocolBean;
import com.cloud.hisavana.sdk.data.bean.response.NativeBean;
import com.cloud.hisavana.sdk.internal.agentpage.AgentPageJsBridge;
import com.cloud.sdk.commonutil.gsonutil.GsonUtil;
import com.cloud.sdk.commonutil.util.DeviceUtil;
import com.google.android.gms.common.api.Api;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt__StringsKt;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
@SourceDebugExtension
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b0 f29174a = new b0();

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends TypeToken<List<? extends String>> {
    }

    public final int a(PsAppInfo psAppInfo) {
        List<ApkInfo> apkList;
        if (!i(ca.d.f(), psAppInfo.getModelWhite(), psAppInfo.getModelBlack(), true)) {
            return 11;
        }
        List<ApkInfo> apkList2 = psAppInfo.getApkList();
        if (apkList2 != null && !apkList2.isEmpty() && (apkList = psAppInfo.getApkList()) != null) {
            for (ApkInfo apkInfo : apkList) {
                if (apkInfo != null) {
                    b0 b0Var = f29174a;
                    if (b0Var.i(DeviceUtil.d(), apkInfo.getCountryCodes(), null, false)) {
                        int iG = ca.d.g();
                        Integer sysVersionCode = apkInfo.getSysVersionCode();
                        Intrinsics.f(sysVersionCode, "it.sysVersionCode");
                        if (iG >= sysVersionCode.intValue() && b0Var.i(ca.d.h(), apkInfo.getAndroidSupportVersion(), null, false) && b0Var.i(ca.d.a(), apkInfo.getBrand(), null, true) && b0Var.i(ca.d.f(), apkInfo.getModel(), apkInfo.getNonModel(), true) && b0Var.l(ca.d.b(), apkInfo.getCpus())) {
                            return 0;
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        return 12;
    }

    public final int b(String str, DefaultAdDTO ad2, String str2, PsAppInfo psAppInfo) {
        Intrinsics.g(ad2, "ad");
        try {
            if (!h(DeviceUtil.d(), ad2.getCountryWhite(), ad2.getCountryBlack())) {
                return 7;
            }
            if (!h(ca.d.a(), ad2.getBrandWhite(), ad2.getBrandBlack())) {
                return 8;
            }
            if (k(str, ad2.getEndDate())) {
                return 1;
            }
            if (k(ad2.getStartDate(), str)) {
                return 2;
            }
            if (ad2.getShowMaxOfDay() <= 0) {
                return 9;
            }
            String displayedDate = ad2.getDisplayedDate();
            if (displayedDate != null && displayedDate.length() != 0 && TextUtils.equals(ad2.getDisplayedDate(), str) && ad2.getDisplayedTimes() >= ad2.getShowMaxOfDay()) {
                return 3;
            }
            int iA = w9.s.a(ad2.getPullNewestLive(), str2, null);
            if (iA != 0) {
                return iA == 1 ? 5 : 6;
            }
            if ((ad2.getPullNewestLive() == 1 || ad2.getPullNewestLive() == 2) && psAppInfo != null) {
                return f29174a.a(psAppInfo);
            }
            return 0;
        } catch (Exception e11) {
            z.a().w("DefaultAdUtil", "check ad validity error: " + e11.getMessage());
            return Api.BaseClientBuilder.API_PRIORITY_OTHER;
        }
    }

    public final AdsDTO c(DefaultAdDTO ad2, boolean z11) {
        StringBuilder sb2;
        String str;
        Intrinsics.g(ad2, "ad");
        AdsDTO adsDTO = new AdsDTO();
        AdxImpBean adxImpBean = new AdxImpBean();
        adxImpBean.pmid = ad2.getCodeSeatId();
        adxImpBean.adt = ad2.getAdType();
        adsDTO.setImpBeanRequest(adxImpBean);
        adsDTO.setAdCreativeId(ad2.getAdCreativeId());
        adsDTO.setFirstPrice(ad2.getFirstPrice());
        adsDTO.setSettlementRatio(ad2.getSettlementRatio());
        adsDTO.setMaterialStyle(ad2.getMaterialStyle());
        NativeBean nativeBean = new NativeBean();
        NativeBean.TitleDTO titleDTO = new NativeBean.TitleDTO(ad2.getTitle());
        NativeBean.DescriptDTO descriptDTO = new NativeBean.DescriptDTO(ad2.getDescription());
        NativeBean.ButtonDTO buttonDTO = new NativeBean.ButtonDTO(ad2.getButton());
        String logoUrl = ad2.getLogoUrl();
        NativeBean.LogoDTO logoDTO = z11 ? new NativeBean.LogoDTO(f(logoUrl)) : new NativeBean.LogoDTO(logoUrl);
        ArrayList arrayList = new ArrayList();
        String mainIngUrl = ad2.getMainIngUrl();
        arrayList.add(z11 ? new NativeBean.MainImagesDTO(f(mainIngUrl)) : new NativeBean.MainImagesDTO(mainIngUrl));
        nativeBean.setTitle(titleDTO);
        nativeBean.setDescript(descriptDTO);
        nativeBean.setLogo(logoDTO);
        nativeBean.setButton(buttonDTO);
        nativeBean.setMainImages(arrayList);
        String adChoiceImageUrl = ad2.getAdChoiceImageUrl();
        if (z11) {
            adChoiceImageUrl = f(adChoiceImageUrl);
        }
        adsDTO.setAdChoiceImageUrl(adChoiceImageUrl);
        adsDTO.setNativeObject(nativeBean);
        adsDTO.setAdLaunchTypes(4);
        adsDTO.setExpiredDate(ad2.getEndDate());
        String pageUrl = ad2.getPageUrl();
        Intrinsics.f(pageUrl, "ad.pageUrl");
        if (StringsKt__StringsKt.Q(pageUrl, AgentPageJsBridge.AGENT_PAGE_INFO, false, 2, null) && z11) {
            String pageUrl2 = ad2.getPageUrl();
            Intrinsics.f(pageUrl2, "ad.pageUrl");
            if (StringsKt__StringsKt.Q(pageUrl2, "?", false, 2, null)) {
                sb2 = new StringBuilder();
                sb2.append(ad2.getPageUrl());
                str = "&htmlfromlocal=true";
            } else {
                sb2 = new StringBuilder();
                sb2.append(ad2.getPageUrl());
                str = "?htmlfromlocal=true";
            }
            sb2.append(str);
            ad2.setPageUrl(sb2.toString());
        }
        adsDTO.setClickUrl(ad2.getPageUrl());
        adsDTO.setCampaignname(ad2.getCampaignname());
        Integer materialType = ad2.getMaterialType();
        Intrinsics.f(materialType, "ad.materialType");
        adsDTO.setDefaultMaterialType(materialType.intValue());
        adsDTO.setFromLocal(z11);
        adsDTO.setShowTime(ad2.getShowTime());
        if (ad2.getAppInfo() != null) {
            adsDTO.setAppInfo(ad2.getAppInfo());
            adsDTO.setPslinkInfo(e1.v(adsDTO));
        }
        adsDTO.setDeepLinkUrl(ad2.getDeepLinkUrl());
        if (ad2.getClickUrls() != null) {
            try {
                adsDTO.setStoreDeeplink((ArrayList) GsonUtil.b(ad2.getClickUrls(), new a().getType()));
            } catch (Exception unused) {
            }
        }
        adsDTO.setPullNewestLive(Integer.valueOf(ad2.getPullNewestLive()));
        AdsProtocolBean.Ext ext = new AdsProtocolBean.Ext();
        if (ad2.getPullNewestLive() == 1 || ad2.getPullNewestLive() == 2) {
            ext.setStoreFlag(1);
            ext.setStoreTitle(com.cloud.sdk.commonutil.util.f.a().getString(R$string.download_by_pamlstore));
        }
        adsDTO.setExt(ext);
        adsDTO.setMaterialWith(ad2.getMaterialWidth());
        adsDTO.setMaterialHeight(ad2.getMaterialHeight());
        adsDTO.setPackageName(ad2.getPackageName());
        adsDTO.setShowTrackingSecretKey(ad2.getShowTrackingSecretKey());
        adsDTO.setClickTrackingUrls(ad2.getClickTrackingUrls());
        adsDTO.setShowTrackingUrls(ad2.getShowTrackingUrls());
        adsDTO.setPsClickTrackingUrls(ad2.getPsClickTrackingUrls());
        adsDTO.setTrackType(Integer.valueOf(ad2.getTrackType()));
        NativeBean nativeObject = adsDTO.getNativeObject();
        if (nativeObject != null) {
            nativeObject.setRating(Integer.valueOf(ad2.getRating()));
        }
        adsDTO.setScale(ad2.getScale());
        adsDTO.setRewardDuration(Integer.valueOf(ad2.getRewardDuration()));
        adsDTO.setDefaultAdSupportNetType(ad2.getSupportNetType());
        return adsDTO;
    }

    public final String d() {
        try {
            String str = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Calendar.getInstance().getTime());
            return str == null ? "" : str;
        } catch (Exception unused) {
            return "";
        }
    }

    public final String e(AdsDTO ad2) {
        Intrinsics.g(ad2, "ad");
        if (ad2.getAdType() == 6) {
            return null;
        }
        if (ad2.getAdType() == 2 && (TextUtils.equals(ad2.getMaterialStyle(), "B20301") || TextUtils.equals(ad2.getMaterialStyle(), "B20302") || TextUtils.equals(ad2.getMaterialStyle(), "B20303"))) {
            return null;
        }
        return ad2.getLogoUrl();
    }

    public final String f(String str) {
        if (str == null) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        File fileC = StorageUtils.c(com.cloud.sdk.commonutil.util.f.a(), true);
        sb2.append(fileC != null ? fileC.getAbsolutePath() : null);
        sb2.append(File.separator);
        sb2.append(SafeKeyUtils.b(new ImageCacheURL(str)));
        sb2.append(".0");
        return sb2.toString();
    }

    public final boolean g(String str, String str2) {
        if (str != null && str.length() != 0 && str2 != null && str2.length() != 0) {
            Iterator it = (TextUtils.isEmpty(str2) ? kotlin.collections.g.l() : StringsKt__StringsKt.E0(str2, new String[]{","}, false, 0, 6, null)).iterator();
            while (it.hasNext()) {
                if (StringsKt__StringsKt.O(str, (String) it.next(), true)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean h(String str, String str2, String str3) {
        if ((str2 == null || str2.length() == 0) && (str3 == null || str3.length() == 0)) {
            return true;
        }
        if (str == null || str.length() == 0) {
            return false;
        }
        Locale locale = Locale.getDefault();
        Intrinsics.f(locale, "getDefault()");
        String lowerCase = str.toLowerCase(locale);
        Intrinsics.f(lowerCase, "toLowerCase(...)");
        if (str2 != null && str2.length() != 0) {
            Locale locale2 = Locale.getDefault();
            Intrinsics.f(locale2, "getDefault()");
            String lowerCase2 = str2.toLowerCase(locale2);
            Intrinsics.f(lowerCase2, "toLowerCase(...)");
            return StringsKt__StringsKt.E0(lowerCase2, new String[]{","}, false, 0, 6, null).contains(lowerCase);
        }
        if (str3 != null && str3.length() != 0) {
            Locale locale3 = Locale.getDefault();
            Intrinsics.f(locale3, "getDefault()");
            String lowerCase3 = str3.toLowerCase(locale3);
            Intrinsics.f(lowerCase3, "toLowerCase(...)");
            if (!StringsKt__StringsKt.E0(lowerCase3, new String[]{","}, false, 0, 6, null).contains(lowerCase)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x005f  */
    /* JADX WARN: Code duplicated, block: B:32:0x008c  */
    public final boolean i(String str, String str2, String str3, boolean z11) {
        boolean z12;
        boolean z13;
        if (((str2 == null || str2.length() == 0) && !z11) || str == null || str.length() == 0) {
            return false;
        }
        Locale locale = Locale.getDefault();
        Intrinsics.f(locale, "getDefault()");
        String lowerCase = str.toLowerCase(locale);
        Intrinsics.f(lowerCase, "toLowerCase(...)");
        if (str2 == null || str2.length() == 0 || kotlin.text.l.v(str2, "all", true)) {
            z12 = true;
        } else {
            Locale locale2 = Locale.getDefault();
            Intrinsics.f(locale2, "getDefault()");
            String lowerCase2 = str2.toLowerCase(locale2);
            Intrinsics.f(lowerCase2, "toLowerCase(...)");
            if (StringsKt__StringsKt.E0(lowerCase2, new String[]{","}, false, 0, 6, null).contains(lowerCase)) {
                z12 = true;
            } else {
                z12 = false;
            }
        }
        if (str3 == null || str3.length() == 0) {
            z13 = true;
        } else {
            Locale locale3 = Locale.getDefault();
            Intrinsics.f(locale3, "getDefault()");
            String lowerCase3 = str3.toLowerCase(locale3);
            Intrinsics.f(lowerCase3, "toLowerCase(...)");
            if (StringsKt__StringsKt.E0(lowerCase3, new String[]{","}, false, 0, 6, null).contains(lowerCase)) {
                z13 = false;
            } else {
                z13 = true;
            }
        }
        return z12 && z13;
    }

    public final String j(AdsDTO ad2) {
        String logoUrl;
        String str;
        Intrinsics.g(ad2, "ad");
        if (ad2.getAdType() == 6 || (ad2.getAdType() == 2 && (TextUtils.equals(ad2.getMaterialStyle(), "B20301") || TextUtils.equals(ad2.getMaterialStyle(), "B20302") || TextUtils.equals(ad2.getMaterialStyle(), "B20303")))) {
            logoUrl = ad2.getLogoUrl();
            str = "{\n            ad.logoUrl\n        }";
        } else {
            logoUrl = ad2.getAdImgUrl();
            str = "{\n            ad.adImgUrl\n        }";
        }
        Intrinsics.f(logoUrl, str);
        return logoUrl;
    }

    public final boolean k(String str, String str2) {
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0) {
            return false;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        try {
            Date date = simpleDateFormat.parse(str);
            if (date == null) {
                date = new Date();
            }
            Date date2 = simpleDateFormat.parse(str2);
            if (date2 == null) {
                date2 = new Date();
            }
            return date.compareTo(date2) > 0;
        } catch (Exception unused) {
            return false;
        }
    }

    public final boolean l(String str, String str2) {
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0) {
            return false;
        }
        List listE0 = StringsKt__StringsKt.E0(str, new String[]{","}, false, 0, 6, null);
        ArrayList arrayList = new ArrayList(kotlin.collections.h.v(listE0, 10));
        Iterator it = listE0.iterator();
        while (it.hasNext()) {
            arrayList.add(StringsKt__StringsKt.Z0((String) it.next()).toString());
        }
        Set setO0 = CollectionsKt___CollectionsKt.O0(arrayList);
        List listE1 = StringsKt__StringsKt.E0(str2, new String[]{","}, false, 0, 6, null);
        ArrayList arrayList2 = new ArrayList(kotlin.collections.h.v(listE1, 10));
        Iterator it2 = listE1.iterator();
        while (it2.hasNext()) {
            arrayList2.add(StringsKt__StringsKt.Z0((String) it2.next()).toString());
        }
        return !CollectionsKt___CollectionsKt.k0(setO0, CollectionsKt___CollectionsKt.O0(arrayList2)).isEmpty();
    }
}
