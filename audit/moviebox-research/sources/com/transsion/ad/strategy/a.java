package com.transsion.ad.strategy;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.n;
import com.transsion.ad.R$string;
import com.transsion.ad.monopoly.model.AdMaterialList;
import com.transsion.ad.monopoly.model.AdPlans;
import com.transsion.ad.monopoly.plan.AdPlanSourceManager;
import com.transsion.ad.ps.model.RecommendInfo;
import com.transsion.ad.web.AdWebActivity;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.mvel2.ast.ASTNode;

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
@Metadata
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f50582a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f50583b = "{\n            \"adSource\": \"ps_candidate\",\n            \"buttonText\": \"Go\",\n            \"categoryCode\": \"1896ff1657b2408daeb264ba6d370bf2\",\n            \"categoryName\": \"Finance\",\n            \"detail\": {\n                \"downloadCount\": \"27073080\",\n                \"iconUrl\": \"https://cdn2.palmplaystore.com/static/59/42d6df6edbe84bdd926fab309aa48261-V02222_512~512.webp?blurhash=LVRpFBkB%5E%23j%5BbHjaoLfQ%7ESa%7C9Jjt\",\n                \"img0\": \"https://cdn2.palmplaystore.com/static/889/0a4a8ed888f04551bcef55e4d31187ff-V02222_288~512.webp?blurhash=LWC%5D6r0f%2BYRO*JkWXos.5q%3FGNGXn\",\n                \"img1\": \"https://cdn2.palmplaystore.com/static/881/b88eab70ee8e445a836225f7fd7c7180-V02222_288~512.webp?blurhash=LqHM4j%7EpXnRj4oI%5Bxtx%5DNeM%7BShae\",\n                \"img2\": \"https://cdn2.palmplaystore.com/static/791/41db2f5cea9549f584c0bae3a7b1b1c9-V02222_288~512.webp?blurhash=LQFj%24.WU4mS7*woHMcRll.tQR%3BR-\",\n                \"img3\": \"https://cdn2.palmplaystore.com/static/181/e99237f24ede40f4a9fd56a08a1c30a5-V02222_288~512.webp?blurhash=LE9ums%7D5Uu9b4p9IPBxZm%25kryDvd\",\n                \"img4\": \"https://cdn2.palmplaystore.com/static/574/2bddbb51c7874e7a906ceb55a75b9124-V02222_288~512.webp?blurhash=LVGTa6n301RP3ERP_3n%23PXo%7DxBW%3D\",\n                \"isOffer\": 1,\n                \"itemID\": \"s_b7801ad36c0a0e4c7fc1f1e72bb04b2d\",\n                \"lan\": \"EN\",\n                \"name\": \"Moniepoint Personal Banking\",\n                \"packageName\": \"com.moniepoint.personal\",\n                \"safeTagList\": [\n                    {\n                        \"icon\": \"https://cdn2.palmplaystore.com/static/673/fa007ff1d5c14939b7d52a5d87247b5f.webp\",\n                        \"id\": 100033,\n                        \"isDeleted\": 0,\n                        \"name\": \"Free\",\n                        \"priority\": 90,\n                        \"type\": 4\n                    }\n                ],\n                \"safetyStyle\": 1,\n                \"score\": \"4.0\",\n                \"screenshotMode\": [\n                    0,\n                    0,\n                    0,\n                    0,\n                    0\n                ],\n                \"simpleDescription\": \"Send money & airtime, request a debit card & manage your savings from one place\",\n                \"sourceSize\": \"71526348\",\n                \"star\": \"4\",\n                \"tagList\": [],\n                \"versionCode\": \"2068\"\n            },\n            \"downloadCount\": 27061226,\n            \"exists\": null,\n            \"gpLink\": \"https://play.google.com/store/apps/details?id=com.moniepoint.personal&hl=en\",\n            \"iconUrl\": \"https://cdn2.palmplaystore.com/static/59/42d6df6edbe84bdd926fab309aa48261-V02222_512~512.webp?blurhash=LVRpFBkB%5E%23j%5BbHjaoLfQ%7ESa%7C9Jjt\",\n            \"id\": 580,\n            \"isOffer\": 1,\n            \"itemID\": \"s_b7801ad36c0a0e4c7fc1f1e72bb04b2d\",\n            \"name\": null,\n            \"offerDesc\": \"\",\n            \"packageName\": \"com.moniepoint.personal\",\n            \"planName\": \"Moniepoint上线测试20250313-MB信息流竖屏\",\n            \"showContent\": \"https://cdn2.palmplaystore.com/static/403/f2d43eb546cb4cd9ad61fe9adec150d4.webp?blurhash=LXE%7B%5EdOtxrR401rpIVtl%7EUtRkCaK\",\n            \"showType\": 9,\n            \"simpleDescription\": \"Send money & airtime, request a debit card & manage your savings from one place\",\n            \"size\": 71526348,\n            \"star\": \"4.0\",\n            \"verifyGoogle\": \"F\",\n            \"versionCode\": 2068,\n            \"versionName\": \"1.23.0\"\n        }";

    public static /* synthetic */ void b(a aVar, String str, String str2, AdPlans adPlans, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            adPlans = null;
        }
        aVar.a(str, str2, adPlans);
    }

    public static /* synthetic */ void e(a aVar, String str, String str2, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str2 = null;
        }
        aVar.d(str, str2);
    }

    public final void a(String str, String str2, AdPlans adPlans) {
        List<AdMaterialList> adMaterialList;
        AdMaterialList adMaterialList2;
        List<AdMaterialList> adMaterialList3;
        AdMaterialList adMaterialList4;
        RecommendInfo psRecommendInfo;
        com.transsion.ad.a.t(com.transsion.ad.a.f50276a, "AdClickManager --> adClick() --> deeplink = " + str + " --> h5Url = " + str2, false, 2, null);
        if (f(adPlans)) {
            return;
        }
        String gpLink = (adPlans == null || (adMaterialList3 = adPlans.getAdMaterialList()) == null || (adMaterialList4 = adMaterialList3.get(0)) == null || (psRecommendInfo = adMaterialList4.getPsRecommendInfo()) == null) ? null : psRecommendInfo.getGpLink();
        if (!AdPlanSourceManager.f50540a.g(adPlans)) {
            if (c(str)) {
                return;
            }
            e(this, str2, null, 2, null);
            return;
        }
        com.transsion.ad.ps.b bVar = com.transsion.ad.ps.b.f50555a;
        if (bVar.m() || gpLink == null || !StringsKt__StringsKt.Q(gpLink, "play.google.com", false, 2, null)) {
            bVar.o((adPlans == null || (adMaterialList = adPlans.getAdMaterialList()) == null || (adMaterialList2 = adMaterialList.get(0)) == null) ? null : adMaterialList2.getPsRecommendInfo(), true, String.valueOf(adPlans != null ? adPlans.getExtAdSlot() : null));
        } else {
            c(gpLink);
        }
    }

    public final boolean c(String str) {
        Object objM163constructorimpl;
        try {
            Result.Companion companion = Result.Companion;
            Uri uri = Uri.parse(str);
            Intent intent = new Intent();
            intent.setData(uri);
            intent.setAction("android.intent.action.VIEW");
            intent.setFlags(ASTNode.DEOP);
            Utils.a().startActivity(intent);
            objM163constructorimpl = Result.m163constructorimpl(Boolean.TRUE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        Throwable thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(objM163constructorimpl);
        if (thM166exceptionOrNullimpl != null) {
            com.transsion.ad.a.z(com.transsion.ad.a.f50276a, f50582a.getClass().getSimpleName() + " --> jumpDeeplink() --> e = " + thM166exceptionOrNullimpl, false, 2, null);
            objM163constructorimpl = Boolean.FALSE;
        }
        return ((Boolean) objM163constructorimpl).booleanValue();
    }

    public final void d(String str, String str2) {
        com.tn.lib.util.networkinfo.f fVar = com.tn.lib.util.networkinfo.f.f49475a;
        if (fVar.e()) {
            Application applicationA = Utils.a();
            Intrinsics.f(applicationA, "getApp()");
            if (fVar.j(applicationA)) {
                AdUrlParameterReplaceManager adUrlParameterReplaceManager = AdUrlParameterReplaceManager.f50563a;
                if (str == null) {
                    str = "";
                }
                AdWebActivity.f50677a.a(adUrlParameterReplaceManager.a(str));
                return;
            }
        }
        Activity activityB = com.blankj.utilcode.util.a.b();
        ToastUtils.r(activityB != null ? activityB.getString(R$string.ad_no_network) : null, new Object[0]);
    }

    public final boolean f(AdPlans adPlans) {
        Object objM163constructorimpl;
        try {
            Result.Companion companion = Result.Companion;
            if (!AdPlanSourceManager.f50540a.e(adPlans)) {
                return false;
            }
            List<AdMaterialList> adMaterialList = adPlans != null ? adPlans.getAdMaterialList() : null;
            List<AdMaterialList> list = adMaterialList;
            if (list != null && !list.isEmpty()) {
                String psLink = adMaterialList.get(0).getPsLink();
                if (TextUtils.isEmpty(psLink)) {
                    return false;
                }
                com.transsion.ad.ps.b.f50555a.o((RecommendInfo) n.d(psLink, RecommendInfo.class), true, String.valueOf(adPlans.getExtAdSlot()));
                objM163constructorimpl = Result.m163constructorimpl(Boolean.TRUE);
            }
            return false;
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        if (Result.m166exceptionOrNullimpl(objM163constructorimpl) != null) {
            objM163constructorimpl = Boolean.FALSE;
        }
        return ((Boolean) objM163constructorimpl).booleanValue();
    }
}
