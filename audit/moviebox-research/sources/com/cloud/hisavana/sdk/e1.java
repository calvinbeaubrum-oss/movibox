package com.cloud.hisavana.sdk;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.core.content.FileProvider;
import com.cloud.hisavana.net.HttpRequest;
import com.cloud.hisavana.net.RequestParams;
import com.cloud.hisavana.net.disklrucache.utils.DiskLruCacheUtil;
import com.cloud.hisavana.net.impl.StringCallback;
import com.cloud.hisavana.net.utils.StorageUtils;
import com.cloud.hisavana.sdk.api.view.AdChoicesView;
import com.cloud.hisavana.sdk.bridge.HisavanaAdJsBridge;
import com.cloud.hisavana.sdk.common.activity.AgentPageLandingActivity;
import com.cloud.hisavana.sdk.common.activity.EWOfficialActivity;
import com.cloud.hisavana.sdk.common.activity.OfflineLandingActivity;
import com.cloud.hisavana.sdk.common.activity.OnlineLandingActivity;
import com.cloud.hisavana.sdk.common.activity.TAdWebFormsActivity;
import com.cloud.hisavana.sdk.common.athena.AthenaTracker;
import com.cloud.hisavana.sdk.common.bean.AdImage;
import com.cloud.hisavana.sdk.common.bean.ImgListDTO;
import com.cloud.hisavana.sdk.common.bean.PslinkInfo;
import com.cloud.hisavana.sdk.common.bean.TaNativeInfo;
import com.cloud.hisavana.sdk.common.constant.Constants;
import com.cloud.hisavana.sdk.common.constant.TaErrorCode;
import com.cloud.hisavana.sdk.common.http.DownLoadRequest;
import com.cloud.hisavana.sdk.common.http.listener.DrawableResponseListener;
import com.cloud.hisavana.sdk.common.tracking.DownUpPointBean;
import com.cloud.hisavana.sdk.data.bean.request.FormBean;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.hisavana.sdk.data.bean.response.AdsProtocolBean;
import com.cloud.hisavana.sdk.data.bean.response.ViewJson;
import com.cloud.hisavana.sdk.internal.agentpage.AgentPageJsBridge;
import com.cloud.hisavana.sdk.manager.NetStateManager;
import com.cloud.sdk.commonutil.gsonutil.GsonUtil;
import com.cloud.sdk.commonutil.util.DeviceUtil;
import com.cloud.sdk.commonutil.util.HSToastUtil;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.File;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import org.mvel2.ast.ASTNode;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class e1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static File f29678a;

    /* JADX INFO: compiled from: source.java */
    public class a extends DrawableResponseListener {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ViewJson f29679b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AdsDTO f29680c;

        public a(ViewJson viewJson, AdsDTO adsDTO) {
            this.f29679b = viewJson;
            this.f29680c = adsDTO;
        }

        @Override // com.cloud.hisavana.sdk.common.http.listener.ResponseBaseListener
        public void a(TaErrorCode taErrorCode) {
            z.a().e("ssp", "onRequestError " + taErrorCode);
        }

        @Override // com.cloud.hisavana.sdk.common.http.listener.DrawableResponseListener
        public void g(int i11, AdImage adImage) {
            this.f29679b.setFormPath(adImage == null ? "" : adImage.getFilePath());
            this.f29680c.setViewJson(GsonUtil.d(this.f29679b));
            z.a().d("ssp", "download form url successfully & file path=" + this.f29679b.getFormPath());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends StringCallback {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f29681e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f29682f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(boolean z11, int i11, String str) {
            super(z11);
            this.f29681e = i11;
            this.f29682f = str;
        }

        @Override // com.cloud.hisavana.net.impl.StringCallback
        public void y(int i11, String str, Throwable th2) {
            z.a().d("ssp", "sumbit form failure----->code: " + i11 + "  message: " + str);
            int i12 = this.f29681e + 1;
            if (i12 < 3) {
                e1.H(this.f29682f, i12);
            }
        }

        @Override // com.cloud.hisavana.net.impl.StringCallback
        public void z(int i11, String str) {
            z.a().d("ssp", "sumbit form success----->" + i11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AdsDTO f29683a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ s9.a f29684b;

        public c(AdsDTO adsDTO, s9.a aVar) {
            this.f29683a = adsDTO;
            this.f29684b = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            s9.a aVar;
            e1.g(com.cloud.sdk.commonutil.util.f.a(), this.f29683a);
            AdsDTO adsDTO = this.f29683a;
            if (adsDTO == null || adsDTO.isOfflineAd() || (aVar = this.f29684b) == null) {
                return;
            }
            aVar.a();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f29685a;

        static {
            int[] iArr = new int[e.values().length];
            f29685a = iArr;
            try {
                iArr[e.OPEN_PS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f29685a[e.OPEN_OTHER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f29685a[e.OPEN_FAILED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public enum e {
        OPEN_PS,
        OPEN_OTHER,
        OPEN_FAILED
    }

    public static boolean A(Context context, String str, String str2) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                if (!TextUtils.isEmpty(str2)) {
                    intent.setPackage(str2);
                }
                intent.setFlags(ASTNode.DEOP);
                context.startActivity(intent);
                return true;
            } catch (Exception unused) {
                z.a().w("PlatformUtil", "openAppWithDeepLink error : " + str);
            }
        }
        return false;
    }

    public static boolean B(Context context, String str, boolean z11) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.setPackage("com.android.chrome");
            if (z11) {
                intent.setFlags(ASTNode.DEOP);
            }
            context.startActivity(intent);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean C(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.contains("market://") || str.contains("play.google.com");
    }

    public static void D(AdsDTO adsDTO) {
        ViewJson.DialogJson dialogJson;
        if (adsDTO == null || TextUtils.isEmpty(adsDTO.getViewJson())) {
            return;
        }
        try {
            ViewJson viewJsonData = adsDTO.getViewJsonData();
            if (viewJsonData != null && !TextUtils.isEmpty(viewJsonData.getFormPath())) {
                File file = new File(viewJsonData.getFormPath());
                if (file.isFile() && file.exists()) {
                    return;
                }
            }
            if (viewJsonData == null || viewJsonData.getDialogType().intValue() != 1 || (dialogJson = viewJsonData.getDialogJson()) == null || TextUtils.isEmpty(dialogJson.getUrl())) {
                return;
            }
            DownLoadRequest.l(dialogJson.getUrl(), adsDTO, 5, true, new a(viewJsonData, adsDTO));
        } catch (Exception e11) {
            z.a().e("ssp", Log.getStackTraceString(e11));
        }
    }

    public static boolean E(Context context, String str) {
        int i11;
        ResolveInfo resolveInfo;
        ActivityInfo activityInfo;
        ApplicationInfo applicationInfo;
        if (context != null && !TextUtils.isEmpty(str) && (i11 = Build.VERSION.SDK_INT) >= 23 && ca.b.n0()) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                intent.setFlags(ASTNode.DEOP);
                intent.addCategory("android.intent.category.DEFAULT");
                intent.addCategory("android.intent.category.BROWSABLE");
                PackageManager packageManager = context.getPackageManager();
                List<ResolveInfo> listQueryIntentActivities = i11 >= 33 ? packageManager.queryIntentActivities(intent, PackageManager.ResolveInfoFlags.of(PlaybackStateCompat.ACTION_PREPARE_FROM_URI)) : packageManager.queryIntentActivities(intent, 131072);
                if (listQueryIntentActivities != null && listQueryIntentActivities.size() == 1 && (resolveInfo = listQueryIntentActivities.get(0)) != null && (activityInfo = resolveInfo.activityInfo) != null && (applicationInfo = activityInfo.applicationInfo) != null) {
                    int i12 = applicationInfo.flags;
                    if ((i12 & 1) == 0 && (i12 & 128) == 0) {
                        context.startActivity(intent);
                        return true;
                    }
                    z.a().w("PlatformUtil", "current link not support app link: " + resolveInfo.activityInfo.packageName);
                }
                return false;
            } catch (Exception unused) {
                z.a().w("PlatformUtil", "openWithAppLink error:" + str);
            }
        }
        return false;
    }

    public static boolean F(String str, int i11) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return DiskLruCacheUtil.g(i11).f(str);
        } catch (Exception e11) {
            z.a().e("ssp", Log.getStackTraceString(e11));
            return false;
        }
    }

    public static TaNativeInfo G(AdsDTO adsDTO) {
        String url;
        TaNativeInfo taNativeInfo = new TaNativeInfo();
        taNativeInfo.setAdItem(adsDTO);
        if (adsDTO == null || adsDTO.getNativeObject() == null) {
            return null;
        }
        try {
            taNativeInfo.setUuid(adsDTO.getUuid());
            taNativeInfo.setCodeSeatType(adsDTO.getCodeSeatType().intValue());
            taNativeInfo.setSequenceId(String.valueOf(adsDTO.getId()));
            taNativeInfo.setVer(adsDTO.getNativeObject().getVersion());
            taNativeInfo.setCtatext(adsDTO.getNativeObject().getButtonTxt(adsDTO.getInstallApk()));
            taNativeInfo.setDescription(adsDTO.getNativeObject().getDescriptionTxt());
            taNativeInfo.setTitle(adsDTO.getNativeObject().getTitleTxt());
            taNativeInfo.setHisavanaSource(adsDTO.getDspType().intValue());
            taNativeInfo.setPrice(String.valueOf(adsDTO.getFirstPrice()));
            taNativeInfo.setBidPrice(adsDTO.getFirstPrice().doubleValue());
            taNativeInfo.setOfflineAd(adsDTO.isOfflineAd());
            taNativeInfo.setRating(String.valueOf(adsDTO.getNativeObject().getRating()));
            taNativeInfo.setRequestId(adsDTO.getRid());
            taNativeInfo.setACReady(adsDTO.getACReady().booleanValue());
            AdImage adImage = new AdImage();
            String adChoiceClickUrl = "";
            int iIntValue = 0;
            if (adsDTO.getNativeObject().getMainImages() == null || adsDTO.getNativeObject().getMainImages().size() <= 0 || adsDTO.getNativeObject().getMainImages().get(0) == null) {
                adImage.setH(0);
                adImage.setW(0);
                url = "";
            } else {
                adImage.setH(adsDTO.getNativeObject().getMainImages().get(0).getHeight().intValue());
                adImage.setW(adsDTO.getNativeObject().getMainImages().get(0).getWidth().intValue());
                url = adsDTO.getNativeObject().getMainImages().get(0).getUrl();
            }
            adImage.setImgUrl(url);
            taNativeInfo.setImage(adImage);
            AdImage adImage2 = new AdImage();
            adImage2.setH(adsDTO.getNativeObject().getLogo() == null ? 0 : adsDTO.getNativeObject().getLogo().getHeight().intValue());
            if (adsDTO.getNativeObject().getLogo() != null) {
                iIntValue = adsDTO.getNativeObject().getLogo().getWidth().intValue();
            }
            adImage2.setW(iIntValue);
            adImage2.setImgUrl(adsDTO.getNativeObject().getLogo() == null ? "" : adsDTO.getNativeObject().getLogo().getUrl());
            taNativeInfo.setIconImage(adImage2);
            taNativeInfo.setStore(new AdImage());
            taNativeInfo.setAcImageUrl(adsDTO.getAdChoiceImageUrl() == null ? "" : adsDTO.getAdChoiceImageUrl());
            if (adsDTO.getAdChoiceClickUrl() != null) {
                adChoiceClickUrl = adsDTO.getAdChoiceClickUrl();
            }
            taNativeInfo.setAcClickUrl(adChoiceClickUrl);
            taNativeInfo.setAdvSeatType(adsDTO.getAdvSeatType());
            taNativeInfo.setMaterialStyle(adsDTO.getMaterialStyle());
            taNativeInfo.setAdType(adsDTO.getImpBeanRequest() == null ? 1 : adsDTO.getImpBeanRequest().adt);
            taNativeInfo.setAppInfo(adsDTO.getAppInfo());
            return taNativeInfo;
        } catch (Throwable th2) {
            z.a().e(Log.getStackTraceString(th2));
            return null;
        }
    }

    public static void H(String str, int i11) {
        try {
            RequestParams requestParams = new RequestParams();
            requestParams.h("Accept-Timezone", "UTC");
            requestParams.h("x-tr-devtype", "h5");
            requestParams.h("x-tr-region", "CN");
            com.cloud.sdk.commonutil.util.c.netLog("submitForm -> formParams = " + str);
            requestParams.l((FormBean) GsonUtil.a(str, FormBean.class));
            HttpRequest.j(aa.a.f() + "/eagllwin/clue/consumer-not-login/clue/cmd/submitClue", requestParams, new b(true, i11, str));
        } catch (Exception e11) {
            com.cloud.sdk.commonutil.util.c.netLog("submitForm --> " + Log.getStackTraceString(e11));
        }
    }

    public static boolean I(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                Uri uri = Uri.parse(str);
                Intent intent = new Intent();
                intent.setData(uri);
                intent.setAction("android.intent.action.VIEW");
                intent.setFlags(ASTNode.DEOP);
                context.startActivity(intent);
                z.a().d("PlatformUtil", "startOpenDeepLink succeed, deepLinkUrl: " + str);
                return true;
            } catch (Exception e11) {
                z.a().w("PlatformUtil", "startOpenDeepLink failed, deepLinkUrl: " + str + "\n error: " + e11.getMessage());
            }
        }
        return false;
    }

    public static void J(AdsDTO adsDTO) {
        z.a().d("PlatformUtil", "start reportAttributionUrls.");
        if (adsDTO == null) {
            return;
        }
        List<String> clickTrackingUrls = adsDTO.getClickTrackingUrls();
        if (clickTrackingUrls != null && !clickTrackingUrls.isEmpty()) {
            z.a().d("PlatformUtil", "report clickTrackingUrls: " + clickTrackingUrls);
            o1.m(clickTrackingUrls, adsDTO);
            return;
        }
        ArrayList<String> psClickTrackingUrls = adsDTO.getPsClickTrackingUrls();
        if (psClickTrackingUrls == null || psClickTrackingUrls.isEmpty() || adsDTO.isPsAd()) {
            z.a().w("PlatformUtil", "report attribition urls failed, urls is empty.");
            return;
        }
        o1.m(psClickTrackingUrls, adsDTO);
        z.a().d("PlatformUtil", "report psClickTrackingUrls: " + psClickTrackingUrls);
    }

    public static boolean K(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                Intent uri = Intent.parseUri(str, 1);
                uri.setAction("android.intent.action.VIEW");
                uri.addCategory("android.intent.category.DEFAULT");
                uri.setFlags(ASTNode.DEOP);
                uri.setComponent(null);
                uri.setSelector(null);
                context.startActivity(uri);
                z.a().d("PlatformUtil", "openIntentSchema succeed, url: " + str);
                return true;
            } catch (Exception e11) {
                z.a().w("PlatformUtil", "openIntentSchema failed, e: " + e11.getMessage());
            }
        }
        return false;
    }

    public static boolean L(Context context, String str) {
        ResolveInfo next;
        ActivityInfo activityInfo;
        if (context == null) {
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            z.a().w("PlatformUtil", "startApplicationWithPackageName failed, packageName is empty.");
            return false;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            if (packageInfo == null) {
                return false;
            }
            Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setPackage(packageInfo.packageName);
            List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
            if (listQueryIntentActivities != null && listQueryIntentActivities.size() != 0 && (next = listQueryIntentActivities.iterator().next()) != null && (activityInfo = next.activityInfo) != null) {
                String str2 = activityInfo.packageName;
                String str3 = activityInfo.name;
                if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                    Intent intent2 = new Intent("android.intent.action.MAIN");
                    intent2.addCategory("android.intent.category.LAUNCHER");
                    intent2.setFlags(ASTNode.DEOP);
                    intent2.setComponent(new ComponentName(str2, str3));
                    context.startActivity(intent2);
                    z.a().d("PlatformUtil", "startApplicationWithPackageName succeed, packageName: " + str);
                    return true;
                }
            }
            return false;
        } catch (Exception e11) {
            z.a().w("PlatformUtil", "startApplicationWithPackageName failed, packageName: " + str + "\n error: " + Log.getStackTraceString(e11));
            return false;
        }
    }

    public static boolean M(Context context, String str) {
        if (B(context, str, true)) {
            return true;
        }
        z.a().d("ssp", "Start page with Chrome Browser failed,Start default Browser.");
        return q(context, str, true);
    }

    public static int a(Context context, AdsDTO adsDTO, DownUpPointBean downUpPointBean, boolean z11) {
        boolean z12;
        z zVarA;
        String str;
        int i11 = 0;
        if (context == null) {
            zVarA = z.a();
            str = "context is null";
        } else {
            boolean z13 = !(context instanceof Activity);
            z.a().d("ssp", "newTask -------------------------------->" + z13);
            if (adsDTO != null) {
                adsDTO.setClick_link("");
                adsDTO.setClickid(g2.a());
                String clickUrl = adsDTO.getClickUrl();
                z.a().d("ssp", "landing url is : " + clickUrl);
                ViewJson viewJsonData = adsDTO.getViewJsonData();
                if (viewJsonData != null && viewJsonData.getDialogType().intValue() == 1) {
                    ViewJson.DialogJson dialogJson = viewJsonData.getDialogJson();
                    if (adsDTO.isOfflineAd() && dialogJson != null && !TextUtils.isEmpty(dialogJson.getUrl())) {
                        j(context, dialogJson.getUrl(), "", adsDTO, downUpPointBean);
                        if (!adsDTO.judgeOptimizeTracking()) {
                            J(adsDTO);
                        }
                        return 1;
                    }
                    if (viewJsonData.getFormPath() != null) {
                        File file = new File(viewJsonData.getFormPath());
                        if (dialogJson != null && !TextUtils.isEmpty(dialogJson.getUrl()) && file.exists()) {
                            j(context, dialogJson.getUrl(), file.getPath(), adsDTO, downUpPointBean);
                            if (!adsDTO.judgeOptimizeTracking()) {
                                J(adsDTO);
                            }
                            return 1;
                        }
                    }
                }
                if (adsDTO.getStoreDeeplink() != null && !adsDTO.getStoreDeeplink().isEmpty()) {
                    Intent intent = new Intent();
                    for (String str2 : adsDTO.getStoreDeeplink()) {
                        if (!TextUtils.isEmpty(str2)) {
                            try {
                                if (str2.startsWith(Constants.f29412b) && str2.split(":").length > 2) {
                                    String strSubstring = str2.substring(i11, str2.indexOf(":") + 1);
                                    String strSubstring2 = str2.substring(str2.indexOf(":") + 1);
                                    int iIndexOf = strSubstring2.indexOf(":");
                                    String strSubstring3 = strSubstring2.substring(i11, iIndexOf);
                                    String strDecode = URLDecoder.decode(strSubstring2.substring(iIndexOf + 1), "UTF-8");
                                    String str3 = strSubstring + strSubstring3;
                                    intent.putExtra(Constants.f29413c, strDecode);
                                    z.a().d("ssp", "linkUrl:" + str3 + ",sms_body:" + strDecode);
                                    intent.setData(Uri.parse(str3));
                                    intent.setAction("android.intent.action.VIEW");
                                    intent.setFlags(ASTNode.DEOP);
                                    context.startActivity(intent);
                                    o1.g(downUpPointBean, adsDTO, Boolean.FALSE);
                                    if (!adsDTO.judgeOptimizeTracking()) {
                                        J(adsDTO);
                                    }
                                    return 2;
                                }
                            } catch (Exception unused) {
                                z.a().d("ssp", "deeplink SMSTO process error");
                                i11 = 0;
                            }
                        }
                    }
                }
                n.L(adsDTO);
                if (y(context, adsDTO, adsDTO.getDeepLinkUrl())) {
                    String deepLinkUrl = adsDTO.getDeepLinkUrl();
                    adsDTO.setClick_link(deepLinkUrl);
                    AthenaTracker.L(adsDTO, deepLinkUrl, AthenaTracker.ClickJumpType.PULL_LIVE);
                    o1.g(downUpPointBean, adsDTO, Boolean.FALSE);
                    if (adsDTO.judgeOptimizeTracking()) {
                        return 3;
                    }
                    J(adsDTO);
                    return 3;
                }
                if (adsDTO.getDspType().intValue() == 1 && L(context, adsDTO.getPackageName())) {
                    z.a().d("PlatformUtil", "startLandingPage start App with packageName");
                    o1.g(downUpPointBean, adsDTO, Boolean.FALSE);
                    AthenaTracker.L(adsDTO, adsDTO.getPackageName(), AthenaTracker.ClickJumpType.PULL_LIVE);
                    if (!adsDTO.judgeOptimizeTracking()) {
                        J(adsDTO);
                    }
                    return 4;
                }
                if (adsDTO.getDspType().intValue() == 1 && L(context, adsDTO.getPsPackageName())) {
                    z.a().d("PlatformUtil", "startLandingPage start App with psPackageName");
                    o1.g(downUpPointBean, adsDTO, Boolean.FALSE);
                    AthenaTracker.L(adsDTO, adsDTO.getPsPackageName(), AthenaTracker.ClickJumpType.PULL_LIVE);
                    if (!adsDTO.judgeOptimizeTracking()) {
                        J(adsDTO);
                    }
                    return 4;
                }
                int i12 = d.f29685a[w(context, adsDTO, downUpPointBean, z11).ordinal()];
                if (i12 == 1) {
                    z.a().d("PlatformUtil", "startLandingPage startOpenAcquisitionLink");
                    boolean z14 = adsDTO.getTrackType().intValue() == 0;
                    boolean zG = w9.x.g(com.cloud.sdk.commonutil.util.f.a());
                    if (z14 && zG) {
                        z12 = true;
                    } else {
                        J(adsDTO);
                        z12 = false;
                    }
                    o1.g(downUpPointBean, adsDTO, Boolean.valueOf(z12));
                    return 5;
                }
                if (i12 == 2) {
                    z.a().d("PlatformUtil", "startLandingPage startOpenAcquisitionLink");
                    J(adsDTO);
                    o1.g(downUpPointBean, adsDTO, Boolean.FALSE);
                    return 6;
                }
                J(adsDTO);
                if (adsDTO.isOfflineAd() && TextUtils.isEmpty(adsDTO.getOfflineH5Url())) {
                    return 0;
                }
                if (TextUtils.isEmpty(clickUrl)) {
                    z.a().d("ssp", "Both deepLinkUrl and landing page is null");
                    return 0;
                }
                if (aa.a.j()) {
                    M(context, clickUrl);
                } else if (z(context, clickUrl)) {
                    o1.g(downUpPointBean, adsDTO, Boolean.FALSE);
                } else {
                    i(context, adsDTO, z13, true, downUpPointBean);
                }
                adsDTO.setClick_link(clickUrl);
                return 7;
            }
            zVarA = z.a();
            str = "adItem is null";
        }
        zVarA.d("ssp", str);
        return 0;
    }

    public static AdChoicesView b(Context context, AdsDTO adsDTO, s9.a aVar) {
        if (adsDTO == null) {
            return null;
        }
        if (adsDTO.getSource() != 4 && !adsDTO.getACReady().booleanValue()) {
            return null;
        }
        AdChoicesView adChoicesView = new AdChoicesView(context);
        int dimensionPixelOffset = context.getResources().getDimensionPixelOffset(R$dimen.ad_badge_height);
        adChoicesView.setLayoutParams(new RelativeLayout.LayoutParams(dimensionPixelOffset, dimensionPixelOffset));
        if (adsDTO.getSource() == 4) {
            DownLoadRequest.o(adsDTO.getAdChoiceImageUrl(), adsDTO, null, adChoicesView);
        } else {
            DownLoadRequest.p(adsDTO.getAdChoiceImageUrl(), adsDTO, 3, null, adChoicesView);
        }
        adChoicesView.setOnClickListener(new c(adsDTO, aVar));
        return adChoicesView;
    }

    public static AdsDTO c(TaNativeInfo taNativeInfo) {
        if (taNativeInfo == null) {
            return null;
        }
        AdsDTO adItem = taNativeInfo.getAdItem();
        if (adItem != null) {
            adItem.setACReady(Boolean.valueOf(taNativeInfo.isACReady()));
        }
        return adItem;
    }

    public static File d() {
        if (f29678a == null) {
            f29678a = StorageUtils.b(com.cloud.sdk.commonutil.util.f.a(), true);
        }
        return f29678a;
    }

    public static String e(AdsDTO adsDTO, String str, boolean z11) {
        StringBuilder sb2 = new StringBuilder(str.replace("HalfScreenType=Z", "HalfScreenType=B"));
        if (adsDTO.getPslinkInfoStatus()) {
            sb2.append("&isHalfScreen=1");
        }
        sb2.append("&isCurrActivityFullscreen=");
        sb2.append(z11);
        sb2.append("&sceneCode=");
        sb2.append(adsDTO.getCodeSeatId());
        return sb2.toString();
    }

    public static String f(String str, int i11) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        File file = new File(DiskLruCacheUtil.e(str, i11));
        return file.exists() ? file.getAbsolutePath() : "";
    }

    public static void g(Context context, AdsDTO adsDTO) {
        z.a().d("ssp", "PlatformUtil startPageByWebView for adchoice");
        if (adsDTO == null || adsDTO.getSource() != 4) {
            if (NetStateManager.checkNetworkState()) {
                i(context, adsDTO, true, false, null);
            } else {
                HSToastUtil.e(R$string.net_error_please_open_netwprk);
            }
        }
    }

    public static void h(Context context, AdsDTO adsDTO, Intent intent) {
        if (context == null || adsDTO == null || intent == null) {
            return;
        }
        if (adsDTO.getPslinkInfoStatus()) {
            z.a().d("PlatformUtil", "startOpenPslink HalfAppDetail,adsDTO.getPslinkInfoStatus():true");
            PslinkInfo pslinkInfo = adsDTO.getPslinkInfo();
            if (pslinkInfo != null) {
                Bundle bundle = new Bundle();
                if (TextUtils.equals(adsDTO.getHalfScreenType(), "Z")) {
                    pslinkInfo.setClickType(2);
                    z.a().d("PlatformUtil", "pslink half setClickType, click_install, halfScreenType = Z");
                }
                pslinkInfo.setTriggerId(adsDTO.getTriggerId());
                pslinkInfo.setAdCreativeId(adsDTO.getAdCreativeId());
                bundle.putParcelable("PslinkInfo", pslinkInfo);
                intent.putExtras(bundle);
                if (pslinkInfo.getIconUri() != null) {
                    context.grantUriPermission("com.transsnet.store", pslinkInfo.getIconUri(), 1);
                }
                if (pslinkInfo.getImgList() != null && !pslinkInfo.getImgList().isEmpty()) {
                    for (ImgListDTO imgListDTO : pslinkInfo.getImgList()) {
                        if (imgListDTO != null && imgListDTO.getUri() != null) {
                            context.grantUriPermission("com.transsnet.store", imgListDTO.getUri(), 1);
                        }
                    }
                }
                z.a().d("PlatformUtil", "startOpenPslink HalfAppDetail,pslinkInfo.getIconUri():" + pslinkInfo.getIconUri());
                adsDTO.setJumpToHalfscreen(true);
                String extJson = pslinkInfo.getExtJson();
                if (!TextUtils.isEmpty(extJson)) {
                    String strReplace = extJson.replace("\"developer2\":", "\"developer\":");
                    try {
                        JsonObject asJsonObject = JsonParser.parseString(strReplace).getAsJsonObject();
                        asJsonObject.addProperty("countryCode", DeviceUtil.d());
                        strReplace = asJsonObject.toString();
                    } catch (Exception e11) {
                        z.a().e("PlatformUtil", "extJson parseString exception: " + e11.getMessage());
                    }
                    intent.putExtra("psExtendFields", strReplace);
                    if (z.b()) {
                        z.a().d("PlatformUtil", "Pslink psExtendFields :" + strReplace);
                    }
                }
            }
        }
        Integer trackType = adsDTO.getTrackType();
        if (trackType.intValue() != -1) {
            z.a().d("PlatformUtil", "startOpenAcquisitionLink trackType " + trackType);
            intent.putStringArrayListExtra(HisavanaAdJsBridge.PS_CLICKTRACKING_URL, com.cloud.sdk.commonutil.util.p.c(o1.p(adsDTO.getPsClickTrackingUrls(), adsDTO)));
            intent.putExtra(HisavanaAdJsBridge.PS_CLICK_CURRENT_TIMEMILLIS, com.cloud.sdk.commonutil.util.p.b(System.currentTimeMillis() + ""));
            intent.putExtra(HisavanaAdJsBridge.PS_TRACKTYPE, com.cloud.sdk.commonutil.util.p.b(String.valueOf(trackType)));
        }
    }

    public static void i(Context context, AdsDTO adsDTO, boolean z11, boolean z12, DownUpPointBean downUpPointBean) {
        Intent intent;
        if (adsDTO == null) {
            z.a().e("PlatformUtil", "startPageByWebView,adItem is null");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("tag_ad_bean", adsDTO);
        if (z12) {
            bundle.putParcelable("pointBean", downUpPointBean);
            adsDTO.setClickUrlTs(System.currentTimeMillis());
            String clickUrl = adsDTO.getClickUrl();
            if (!TextUtils.isEmpty(clickUrl) && clickUrl.contains(AgentPageJsBridge.AGENT_PAGE_INFO)) {
                z.a().d("PlatformUtil", "Start page with WebView.agentpage ad");
                intent = new Intent(context, (Class<?>) AgentPageLandingActivity.class);
            } else if (!adsDTO.isOfflineAd() || NetStateManager.checkNetworkState()) {
                z.a().d("PlatformUtil", "Start page with WebView.online ad");
                if (!adsDTO.isOfflineAd() && !NetStateManager.checkNetworkState()) {
                    HSToastUtil.e(R$string.toast_no_network);
                }
                intent = new Intent(context, (Class<?>) OnlineLandingActivity.class);
            } else {
                z.a().d("PlatformUtil", "Start page with WebView.offline ad");
                intent = new Intent(context, (Class<?>) OfflineLandingActivity.class);
            }
        } else {
            z.a().d("PlatformUtil", "Start page with WebView.ew");
            intent = new Intent(context, (Class<?>) EWOfficialActivity.class);
        }
        intent.putExtras(bundle);
        if (z11) {
            intent.setFlags(ASTNode.DEOP);
        }
        context.startActivity(intent);
    }

    public static void j(Context context, String str, String str2, AdsDTO adsDTO, DownUpPointBean downUpPointBean) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Intent intent = new Intent(context, (Class<?>) TAdWebFormsActivity.class);
        intent.setFlags(268500992);
        intent.putExtra("ad_web_form_url", str);
        intent.putExtra("ad_web_form_file_path", str2);
        intent.putExtra("ad_web_form_dto", adsDTO);
        intent.putExtra("ad_web_form_point", downUpPointBean);
        context.startActivity(intent);
    }

    public static void k(List<TaNativeInfo> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (TaNativeInfo taNativeInfo : list) {
            if (taNativeInfo != null && taNativeInfo.getAdItem() != null) {
                D(taNativeInfo.getAdItem());
            }
        }
    }

    public static boolean l(Context context, BitmapFactory.Options options) {
        if (context == null) {
            return true;
        }
        int i11 = options.outWidth;
        int i12 = options.outHeight;
        if (i11 > 2000 || i12 > 2000) {
            return true;
        }
        long j11 = ((long) (i11 * i12)) * 4;
        if (j11 > 104857600) {
            return true;
        }
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return j11 > (memoryInfo.availMem * 2) / 3;
    }

    public static boolean m(Context context, AdsDTO adsDTO, String str) {
        if (context != null && adsDTO != null && !TextUtils.isEmpty(str)) {
            String str2 = str + "&hsTrace=" + adsDTO.getUuid();
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str2));
                intent.setFlags(ASTNode.DEOP);
                context.startActivity(intent);
                return true;
            } catch (Exception unused) {
                z.a().w("PlatformUtil", "openPageWithAhaLink error:" + str2);
            }
        }
        return false;
    }

    public static boolean n(Context context, AdsDTO adsDTO, String str, boolean z11) {
        if (context != null && adsDTO != null && !TextUtils.isEmpty(str)) {
            String strE = e(adsDTO, str, z11);
            if (z.b()) {
                z.a().d("PlatformUtil", "openPageWithPsLink,link is " + strE);
            }
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(strE));
                intent.setPackage("com.transsnet.store");
                h(context, adsDTO, intent);
                intent.setFlags(ASTNode.DEOP);
                context.startActivity(intent);
                return true;
            } catch (Exception unused) {
                z.a().w("PlatformUtil", "openPageWithPsLink error:" + strE);
            }
        }
        return false;
    }

    public static boolean o(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        return l(context, options);
    }

    public static boolean p(Context context, String str, String str2) {
        String str3 = "";
        try {
            if (!TextUtils.isEmpty(str)) {
                if (context.getPackageManager().getPackageInfo(TextUtils.isEmpty(str) ? "" : str, 0) != null) {
                    return true;
                }
            }
        } catch (Exception unused) {
            z.a().w("PlatformUtil", "the package name is " + str + " is not installed");
        }
        try {
            if (!TextUtils.isEmpty(str2)) {
                PackageManager packageManager = context.getPackageManager();
                if (!TextUtils.isEmpty(str2)) {
                    str3 = str2;
                }
                if (packageManager.getPackageInfo(str3, 0) != null) {
                    return true;
                }
            }
        } catch (Exception unused2) {
            z.a().w("PlatformUtil", "the package name is " + str2 + " is not installed");
        }
        return false;
    }

    public static boolean q(Context context, String str, boolean z11) {
        try {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            if (z11) {
                intent.setFlags(ASTNode.DEOP);
            }
            context.startActivity(intent);
            return true;
        } catch (Throwable th2) {
            z.a().e(Log.getStackTraceString(th2));
            return false;
        }
    }

    public static boolean r(Context context, byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return true;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        return l(context, options);
    }

    public static boolean s(AdsDTO adsDTO) {
        if (adsDTO == null) {
            return false;
        }
        return adsDTO.getAdImageWidth().intValue() > 2000 || adsDTO.getAdImageHeight().intValue() > 2000;
    }

    public static boolean t(String str) {
        return F(str, 1);
    }

    public static Uri u(String str, int i11) {
        try {
            if (TextUtils.isEmpty(str) || d() == null) {
                return null;
            }
            String strE = DiskLruCacheUtil.e(str, i11);
            if (TextUtils.isEmpty(strE)) {
                return null;
            }
            File file = new File(strE);
            if (!file.exists()) {
                return null;
            }
            if (Build.VERSION.SDK_INT <= 24) {
                return Uri.fromFile(file);
            }
            return FileProvider.getUriForFile(com.cloud.sdk.commonutil.util.f.a(), com.cloud.sdk.commonutil.util.f.a().getApplicationContext().getPackageName() + ".provider", file);
        } catch (Exception e11) {
            z.a().e("ssp", Log.getStackTraceString(e11));
            return null;
        }
    }

    public static PslinkInfo v(AdsDTO adsDTO) {
        PslinkInfo pslinkInfo = null;
        if (adsDTO != null && !TextUtils.isEmpty(adsDTO.getAppInfo())) {
            try {
                pslinkInfo = (PslinkInfo) GsonUtil.a(adsDTO.getAppInfo(), PslinkInfo.class);
            } catch (Exception unused) {
            }
            if (pslinkInfo != null) {
                pslinkInfo.setGaid(DeviceUtil.e());
                pslinkInfo.setShowId(adsDTO.getUuid());
                pslinkInfo.setAppPackageName(com.transsion.core.utils.a.a());
                pslinkInfo.setOfflineAd(adsDTO.isOfflineAd());
                pslinkInfo.setShowTrackingSecretKey(adsDTO.getShowTrackingSecretKey());
            }
        }
        return pslinkInfo;
    }

    public static e w(Context context, AdsDTO adsDTO, DownUpPointBean downUpPointBean, boolean z11) {
        if (adsDTO == null || context == null) {
            return e.OPEN_FAILED;
        }
        ArrayList<String> storeDeeplink = adsDTO.getStoreDeeplink();
        if (storeDeeplink == null || storeDeeplink.isEmpty()) {
            return e.OPEN_FAILED;
        }
        e eVar = e.OPEN_FAILED;
        for (String str : storeDeeplink) {
            if (!TextUtils.isEmpty(str)) {
                if (str.startsWith("palmplay://")) {
                    AdsProtocolBean.Ext ext = adsDTO.getExt();
                    if (ext == null || ext.getStoreFlag().intValue() == 1 || adsDTO.getAdType() == 6) {
                        if (adsDTO.getDspType().intValue() != 2 || !adsDTO.getPslinkInfoStatus() || !p(context, adsDTO.getPackageName(), adsDTO.getPsPackageName())) {
                            if (n(context, adsDTO, str, z11)) {
                                z.a().d("PlatformUtil", "startOpenAcquisitionLink,url is psLink: " + str);
                                AthenaTracker.ClickJumpType clickJumpType = adsDTO.isJumpToHalfscreen() ? AthenaTracker.ClickJumpType.PS_HALF_SCREEN : AthenaTracker.ClickJumpType.PS_FULL_SCREEN;
                                adsDTO.setClick_link(str);
                                AthenaTracker.L(adsDTO, str, clickJumpType);
                                return e.OPEN_PS;
                            }
                        }
                    }
                } else {
                    if (str.startsWith("aha://") && m(context, adsDTO, str)) {
                        z.a().d("PlatformUtil", "startOpenAcquisitionLink,url is ahaLink: " + str);
                        adsDTO.setClick_link(str);
                        AthenaTracker.L(adsDTO, str, AthenaTracker.ClickJumpType.OTHER);
                        return e.OPEN_OTHER;
                    }
                    if (C(str) && A(context, str, "com.android.vending")) {
                        z.a().d("PlatformUtil", "startOpenAcquisitionLink,url is GP link: " + str);
                        adsDTO.setClick_link(str);
                        AthenaTracker.L(adsDTO, str, AthenaTracker.ClickJumpType.GP);
                        return e.OPEN_OTHER;
                    }
                    if (A(context, str, null)) {
                        z.a().d("PlatformUtil", "startOpenAcquisitionLink,url is other link: " + str);
                        adsDTO.setClick_link(str);
                        AthenaTracker.L(adsDTO, str, AthenaTracker.ClickJumpType.OTHER);
                        return e.OPEN_OTHER;
                    }
                }
            }
        }
        return eVar;
    }

    public static List<TaNativeInfo> x(List<AdsDTO> list) {
        TaNativeInfo taNativeInfoG;
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (AdsDTO adsDTO : list) {
            if (adsDTO != null && (taNativeInfoG = G(adsDTO)) != null && !w9.w.b(taNativeInfoG)) {
                arrayList.add(taNativeInfoG);
            }
        }
        return arrayList;
    }

    public static boolean y(Context context, AdsDTO adsDTO, String str) {
        z zVarA;
        String str2;
        if (context == null || adsDTO == null) {
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            z.a().w("PlatformUtil", "startOpenDeepLink failed, deepLinkUrl is empty");
            return false;
        }
        if (!s0.f30028a.e(str, context, adsDTO)) {
            if (str.startsWith("intent://")) {
                if (str.startsWith("intent://play.google.com")) {
                    z.a().d("PlatformUtil", "startOpenDeepLink failed, deepLinkUrl url is gpLink: " + str);
                    return false;
                }
                if (K(context, str)) {
                    zVarA = z.a();
                    str2 = "startOpenDeepLink succeed, deepLinkUrl: " + str;
                }
            }
            if (!str.contains("play.google.com")) {
                return I(context, str);
            }
            z.a().d("PlatformUtil", "startOpenDeepLink failed, deepLinkUrl url is gpLink: " + str);
            return false;
        }
        zVarA = z.a();
        str2 = "startOpenActivationLink open mini app.";
        zVarA.d("PlatformUtil", str2);
        return true;
    }

    public static boolean z(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.startsWith("http://") || str.startsWith(AgentPageJsBridge.HTTPS)) {
            if (str.contains("play.google.com") && A(context, str, "com.android.vending")) {
                return true;
            }
            return E(context, str);
        }
        if (str.startsWith("market://") && A(context, str, "com.android.vending")) {
            return true;
        }
        return A(context, str, null);
    }
}
