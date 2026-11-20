package com.transsion.ad.ps;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.c;
import com.cloud.hisavana.sdk.common.bean.ImgListDTO;
import com.cloud.hisavana.sdk.common.bean.PslinkInfo;
import com.transsion.ad.ps.model.ItemDetail;
import com.transsion.ad.ps.model.RecommendInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONException;
import org.json.JSONObject;
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
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f50555a = new b();

    public final void a(RecommendInfo recommendInfo, boolean z11, String scene) {
        Intrinsics.g(scene, "scene");
        String gpLink = recommendInfo != null ? recommendInfo.getGpLink() : null;
        if (!m() && gpLink != null && StringsKt__StringsKt.Q(gpLink, "play.google.com", false, 2, null)) {
            com.transsion.ad.strategy.a.f50582a.c(gpLink);
        } else if (m()) {
            o(recommendInfo, z11, scene);
        } else {
            p(recommendInfo);
        }
    }

    public final boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        PackageInfo packageInfo = null;
        try {
            Result.Companion companion = Result.Companion;
            PackageManager packageManager = Utils.a().getPackageManager();
            if (str == null) {
                str = "";
            }
            packageInfo = packageManager.getPackageInfo(str, 0);
            Result.m163constructorimpl(Unit.f68710a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m163constructorimpl(ResultKt.a(th2));
        }
        return packageInfo != null;
    }

    public final boolean c() {
        if (c.k("com.transsnet.store")) {
            return true;
        }
        return b("com.transsnet.store");
    }

    public final String d() {
        String simpleName = b.class.getSimpleName();
        Intrinsics.f(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    public final String e(RecommendInfo recommendInfo, String str) {
        return "palmplay://thirdlauncher.com/?entryType=AppDetail&packageName=" + (recommendInfo != null ? recommendInfo.getPackageName() : null) + "&_source=Moviebox&HalfScreenType=B&isHalfScreen=1&sceneCode=" + str;
    }

    public final String f(RecommendInfo recommendInfo) {
        return "palmplay://thirdlauncher.com/?entryType=AppDetail&packageName=" + (recommendInfo != null ? recommendInfo.getPackageName() : null) + "&_source=Moviebox";
    }

    public final String g(RecommendInfo recommendInfo, String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", recommendInfo != null ? Long.valueOf(recommendInfo.getId()) : null);
        jSONObject.put("isOffer", recommendInfo != null ? Integer.valueOf(recommendInfo.isOffer()) : null);
        jSONObject.put("showType", recommendInfo != null ? Integer.valueOf(recommendInfo.getShowType()) : null);
        jSONObject.put("planName", recommendInfo != null ? recommendInfo.getPlanName() : null);
        jSONObject.put("media", "MovieBox");
        jSONObject.put("scene", str);
        jSONObject.put("planId", recommendInfo != null ? Long.valueOf(recommendInfo.getId()) : null);
        jSONObject.put("c_source", "PS");
        jSONObject.put("adSource", recommendInfo != null ? recommendInfo.getAdSource() : null);
        jSONObject.put("mbVc", String.valueOf(c.d()));
        String string = jSONObject.toString();
        Intrinsics.f(string, "json.toString()");
        return string;
    }

    public final long h() {
        Application applicationA = Utils.a();
        Intrinsics.f(applicationA, "getApp()");
        return k(applicationA, "com.transsnet.store");
    }

    public final PslinkInfo i(RecommendInfo recommendInfo, boolean z11) {
        String name;
        ItemDetail detail;
        ItemDetail detail2;
        ItemDetail detail3;
        ItemDetail detail4;
        ItemDetail detail5;
        ItemDetail detail6;
        ItemDetail detail7;
        ItemDetail detail8;
        ItemDetail detail9;
        ItemDetail detail10;
        ItemDetail detail11;
        ItemDetail detail12;
        ItemDetail detail13;
        ItemDetail detail14;
        ItemDetail detail15;
        ItemDetail detail16;
        PslinkInfo pslinkInfo = new PslinkInfo();
        pslinkInfo.setClickType(z11 ? 2 : 1);
        pslinkInfo.setItemID(recommendInfo != null ? recommendInfo.getItemID() : null);
        pslinkInfo.setPackageName(recommendInfo != null ? recommendInfo.getPackageName() : null);
        pslinkInfo.setAppPackageName(Utils.a().getPackageName());
        if (recommendInfo == null || (name = recommendInfo.getName()) == null) {
            name = (recommendInfo == null || (detail = recommendInfo.getDetail()) == null) ? null : detail.getName();
        }
        pslinkInfo.setName(name);
        pslinkInfo.setStar(recommendInfo != null ? recommendInfo.getStar() : null);
        pslinkInfo.setDownloadCount(recommendInfo != null ? recommendInfo.getDownloadCount() : 0);
        pslinkInfo.setSourceSize(recommendInfo != null ? Long.valueOf(recommendInfo.getSize()).toString() : null);
        pslinkInfo.setIconUrl(recommendInfo != null ? recommendInfo.getIconUrl() : null);
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty((recommendInfo == null || (detail16 = recommendInfo.getDetail()) == null) ? null : detail16.getImg0())) {
            ImgListDTO imgListDTO = new ImgListDTO();
            imgListDTO.setUrl((recommendInfo == null || (detail15 = recommendInfo.getDetail()) == null) ? null : detail15.getImg0());
            arrayList.add(imgListDTO);
            imgListDTO.setHv(j((recommendInfo == null || (detail14 = recommendInfo.getDetail()) == null) ? null : detail14.getScreenshotMode(), arrayList.size() - 1));
        }
        if (!TextUtils.isEmpty((recommendInfo == null || (detail13 = recommendInfo.getDetail()) == null) ? null : detail13.getImg1())) {
            ImgListDTO imgListDTO2 = new ImgListDTO();
            imgListDTO2.setUrl((recommendInfo == null || (detail12 = recommendInfo.getDetail()) == null) ? null : detail12.getImg1());
            arrayList.add(imgListDTO2);
            imgListDTO2.setHv(j((recommendInfo == null || (detail11 = recommendInfo.getDetail()) == null) ? null : detail11.getScreenshotMode(), arrayList.size() - 1));
        }
        if (!TextUtils.isEmpty((recommendInfo == null || (detail10 = recommendInfo.getDetail()) == null) ? null : detail10.getImg2())) {
            ImgListDTO imgListDTO3 = new ImgListDTO();
            imgListDTO3.setUrl((recommendInfo == null || (detail9 = recommendInfo.getDetail()) == null) ? null : detail9.getImg2());
            arrayList.add(imgListDTO3);
            imgListDTO3.setHv(j((recommendInfo == null || (detail8 = recommendInfo.getDetail()) == null) ? null : detail8.getScreenshotMode(), arrayList.size() - 1));
        }
        if (!TextUtils.isEmpty((recommendInfo == null || (detail7 = recommendInfo.getDetail()) == null) ? null : detail7.getImg3())) {
            ImgListDTO imgListDTO4 = new ImgListDTO();
            imgListDTO4.setUrl((recommendInfo == null || (detail6 = recommendInfo.getDetail()) == null) ? null : detail6.getImg3());
            arrayList.add(imgListDTO4);
            imgListDTO4.setHv(j((recommendInfo == null || (detail5 = recommendInfo.getDetail()) == null) ? null : detail5.getScreenshotMode(), arrayList.size() - 1));
        }
        if (!TextUtils.isEmpty((recommendInfo == null || (detail4 = recommendInfo.getDetail()) == null) ? null : detail4.getImg4())) {
            ImgListDTO imgListDTO5 = new ImgListDTO();
            imgListDTO5.setUrl((recommendInfo == null || (detail3 = recommendInfo.getDetail()) == null) ? null : detail3.getImg4());
            arrayList.add(imgListDTO5);
            imgListDTO5.setHv(j((recommendInfo == null || (detail2 = recommendInfo.getDetail()) == null) ? null : detail2.getScreenshotMode(), arrayList.size() - 1));
        }
        pslinkInfo.setImgList(arrayList);
        pslinkInfo.setSimpleDescription(recommendInfo != null ? recommendInfo.getSimpleDescription() : null);
        return pslinkInfo;
    }

    public final int j(List<Integer> list, int i11) {
        Integer num;
        List<Integer> list2 = list;
        if (list2 == null || list2.isEmpty() || i11 < 0 || (num = list.get(i11 % list.size())) == null) {
            return 0;
        }
        return num.intValue();
    }

    public final long k(Context context, String str) {
        long longVersionCode = 0;
        try {
            Result.Companion companion = Result.Companion;
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            longVersionCode = Build.VERSION.SDK_INT >= 28 ? packageInfo.getLongVersionCode() : packageInfo.versionCode;
            Result.m163constructorimpl(Unit.f68710a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m163constructorimpl(ResultKt.a(th2));
        }
        return longVersionCode;
    }

    public final boolean l() {
        return TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1;
    }

    public final boolean m() {
        Application applicationA = Utils.a();
        Intrinsics.f(applicationA, "getApp()");
        return k(applicationA, "com.transsnet.store") >= 8403100;
    }

    public final boolean n(String str) {
        try {
            PackageManager packageManager = Utils.a().getPackageManager();
            if (str == null) {
                str = "";
            }
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            if (packageInfo == null) {
                return false;
            }
            Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setPackage(packageInfo.packageName);
            List<ResolveInfo> listQueryIntentActivities = Utils.a().getPackageManager().queryIntentActivities(intent, 0);
            Intrinsics.f(listQueryIntentActivities, "getApp().packageManager.…ivities(resolveIntent, 0)");
            if (listQueryIntentActivities.isEmpty()) {
                return false;
            }
            ResolveInfo next = listQueryIntentActivities.iterator().next();
            if ((next != null ? next.activityInfo : null) != null) {
                ActivityInfo activityInfo = next.activityInfo;
                String str2 = activityInfo.packageName;
                String str3 = activityInfo.name;
                if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                    Intent intent2 = new Intent("android.intent.action.MAIN");
                    intent2.addCategory("android.intent.category.LAUNCHER");
                    intent2.setFlags(ASTNode.DEOP);
                    intent2.setComponent(new ComponentName(str2, str3));
                    Utils.a().startActivity(intent2);
                    return true;
                }
                return false;
            }
        } catch (Exception e11) {
            com.transsion.ad.a.r(com.transsion.ad.a.f50276a, d() + " --> it = " + Log.getStackTraceString(e11), false, 2, null);
        }
        return false;
    }

    public final boolean o(RecommendInfo recommendInfo, boolean z11, String scene) {
        Object objM163constructorimpl;
        Intrinsics.g(scene, "scene");
        try {
            Result.Companion companion = Result.Companion;
            com.transsion.ad.a aVar = com.transsion.ad.a.f50276a;
            b bVar = f50555a;
            String strD = bVar.d();
            Application applicationA = Utils.a();
            Intrinsics.f(applicationA, "getApp()");
            com.transsion.ad.a.p(aVar, strD + " --> initListener() --> PS VCode = " + bVar.k(applicationA, "com.transsnet.store") + " -- isAutoDownload = " + z11 + " -- 点击了 itemInfo = " + recommendInfo, false, 2, null);
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            String strE = bVar.e(recommendInfo, scene);
            com.transsion.ad.a.r(aVar, bVar.d() + " --> startPsActivity() --> deeplink = " + strE, false, 2, null);
            intent.setData(Uri.parse(strE));
            intent.putExtra("PslinkInfo", bVar.i(recommendInfo, z11));
            intent.putExtra("versionCode", recommendInfo != null ? Integer.valueOf(recommendInfo.getVersionCode()) : null);
            intent.addFlags(32768);
            intent.addFlags(ASTNode.DEOP);
            intent.putExtra("psExtendFields", bVar.g(recommendInfo, scene));
            Utils.a().startActivity(intent);
            objM163constructorimpl = Result.m163constructorimpl(Boolean.TRUE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        Throwable thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(objM163constructorimpl);
        if (thM166exceptionOrNullimpl != null) {
            com.transsion.ad.a.r(com.transsion.ad.a.f50276a, f50555a.d() + " --> startPsActivity --> it = " + Log.getStackTraceString(thM166exceptionOrNullimpl), false, 2, null);
            objM163constructorimpl = Boolean.FALSE;
        }
        return ((Boolean) objM163constructorimpl).booleanValue();
    }

    public final boolean p(RecommendInfo recommendInfo) {
        Object objM163constructorimpl;
        try {
            Result.Companion companion = Result.Companion;
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(Uri.parse(f50555a.f(recommendInfo)));
            intent.putExtra("versionCode", c.d());
            intent.addFlags(32768);
            intent.addFlags(ASTNode.DEOP);
            Utils.a().startActivity(intent);
            objM163constructorimpl = Result.m163constructorimpl(Boolean.TRUE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        Throwable thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(objM163constructorimpl);
        if (thM166exceptionOrNullimpl != null) {
            com.transsion.ad.a.r(com.transsion.ad.a.f50276a, f50555a.d() + " --> startPsActivity --> it = " + Log.getStackTraceString(thM166exceptionOrNullimpl), false, 2, null);
            objM163constructorimpl = Boolean.FALSE;
        }
        return ((Boolean) objM163constructorimpl).booleanValue();
    }
}
