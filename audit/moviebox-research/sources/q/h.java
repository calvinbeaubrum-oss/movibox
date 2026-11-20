package q;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import androidx.core.view.MotionEventCompat;
import androidx.media3.container.MdtaMetadataEntry;
import com.bykv.vk.openvk.preload.falconx.statistic.StatisticData;
import com.cloud.tmc.integration.proxy.ReportProxy;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.AppManager;
import com.cloud.tmc.integration.utils.AppUtils;
import com.cloud.tmc.integration.utils.q;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.performanceanalyse.ICommunicationTimeProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PointAnalyseType;
import com.cloud.tmc.kernel.utils.p;
import com.cloud.tmc.miniapp.base.BaseActivity;
import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
import com.google.android.gms.fido.u2f.api.common.RegisterRequest;
import com.google.gson.Gson;
import com.mbridge.msdk.MBridgeConstans;
import com.transsion.baselib.db.download.DownloadBean;
import com.vungle.warren.error.VungleException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import kd.k;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.s;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.l;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension
public final class h {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f74093e = new a();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final AtomicLong f74094f = new AtomicLong(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f74095a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f74096b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f74097c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, q.b> f74098d = new LinkedHashMap();

    /* JADX INFO: compiled from: source.java */
    public static final class a {
    }

    /* JADX INFO: compiled from: source.java */
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f74099a;

        static {
            int[] iArr = new int[PointAnalyseType.values().length];
            try {
                iArr[PointAnalyseType.POINT_START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PointAnalyseType.POINT_JS_BRIDGE_READY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PointAnalyseType.POINT_RENDER_READY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PointAnalyseType.POINT_PAGE_OPEN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[PointAnalyseType.POINT_PAGE_CREATE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[PointAnalyseType.POINT_RENDER_T1.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[PointAnalyseType.POINT_RENDER_T2.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[PointAnalyseType.POINT_WORKER_READY.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[PointAnalyseType.POINT_SDK_PV.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[PointAnalyseType.POINT_PAGE_PV.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[PointAnalyseType.POINT_EXIT_CLICK.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[PointAnalyseType.POINT_EXIT_MINIAPP.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[PointAnalyseType.POINT_NAV_HOME_PRESSED.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[PointAnalyseType.POINT_MORE_ENTER.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[PointAnalyseType.POINT_MORE_EXIT.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr[PointAnalyseType.POINT_SHORT_CUT.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr[PointAnalyseType.POINT_SHARE.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr[PointAnalyseType.POINT_SHARE_URL.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr[PointAnalyseType.POINT_SHARE_SAVE.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr[PointAnalyseType.POINT_REFRESH.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr[PointAnalyseType.POINT_ENTER_DEVELOP.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                iArr[PointAnalyseType.POINT_CLICK_AUTH.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                iArr[PointAnalyseType.POINT_CLICK_MESSAGE.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                iArr[PointAnalyseType.POINT_CLICK_WIDGET.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                iArr[PointAnalyseType.POINT_CLICK_WHATSAPP.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                iArr[PointAnalyseType.POINT_CLICK_TELEGRAM.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                iArr[PointAnalyseType.POINT_CLICK_ICON_SHARE.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                iArr[PointAnalyseType.POINT_CLICK_MC.ordinal()] = 28;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                iArr[PointAnalyseType.POINT_LAUNCH_MINIAPP_START.ordinal()] = 29;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                iArr[PointAnalyseType.POINT_LAUNCH_MINIAPP_HOT_OPEN.ordinal()] = 30;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                iArr[PointAnalyseType.POINT_DOWNLOAD_V8_START.ordinal()] = 31;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                iArr[PointAnalyseType.POINT_DOWNLOAD_V8_SUCCESS.ordinal()] = 32;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                iArr[PointAnalyseType.POINT_DOWNLOAD_V8_FAIL.ordinal()] = 33;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                iArr[PointAnalyseType.POINT_CHECK_WHITESCREEN.ordinal()] = 34;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                iArr[PointAnalyseType.POINT_FPS.ordinal()] = 35;
            } catch (NoSuchFieldError unused35) {
            }
            try {
                iArr[PointAnalyseType.POINT_CHAIN_START.ordinal()] = 36;
            } catch (NoSuchFieldError unused36) {
            }
            try {
                iArr[PointAnalyseType.POINT_CHAIN_END.ordinal()] = 37;
            } catch (NoSuchFieldError unused37) {
            }
            try {
                iArr[PointAnalyseType.POINT_CHAIN_INSERT.ordinal()] = 38;
            } catch (NoSuchFieldError unused38) {
            }
            try {
                iArr[PointAnalyseType.POINT_CHAIN_CLEAR.ordinal()] = 39;
            } catch (NoSuchFieldError unused39) {
            }
            try {
                iArr[PointAnalyseType.POINT_H5_PAGE_ONFINISHED.ordinal()] = 40;
            } catch (NoSuchFieldError unused40) {
            }
            try {
                iArr[PointAnalyseType.POINT_LOG_ERROR.ordinal()] = 41;
            } catch (NoSuchFieldError unused41) {
            }
            try {
                iArr[PointAnalyseType.POINT_PRIVACY_AGREEMENT.ordinal()] = 42;
            } catch (NoSuchFieldError unused42) {
            }
            try {
                iArr[PointAnalyseType.POINT_GET_PACKAGE_FILE.ordinal()] = 43;
            } catch (NoSuchFieldError unused43) {
            }
            try {
                iArr[PointAnalyseType.POINT_PACKAGE_UPDATE_START.ordinal()] = 44;
            } catch (NoSuchFieldError unused44) {
            }
            try {
                iArr[PointAnalyseType.POINT_PACKAGE_UPDATE_SUCCESS.ordinal()] = 45;
            } catch (NoSuchFieldError unused45) {
            }
            try {
                iArr[PointAnalyseType.POINT_PACKAGE_UPDATE_FAIL.ordinal()] = 46;
            } catch (NoSuchFieldError unused46) {
            }
            try {
                iArr[PointAnalyseType.POINT_PACKAGE_DOWNLOAD_START.ordinal()] = 47;
            } catch (NoSuchFieldError unused47) {
            }
            try {
                iArr[PointAnalyseType.POINT_PACKAGE_DOWNLOAD_SUCCESS.ordinal()] = 48;
            } catch (NoSuchFieldError unused48) {
            }
            try {
                iArr[PointAnalyseType.POINT_PACKAGE_DOWNLOAD_FAILED.ordinal()] = 49;
            } catch (NoSuchFieldError unused49) {
            }
            try {
                iArr[PointAnalyseType.POINT_PACKAGE_DOWNLOAD_USER_EXIT.ordinal()] = 50;
            } catch (NoSuchFieldError unused50) {
            }
            try {
                iArr[PointAnalyseType.POINT_APP_CHAIN_START.ordinal()] = 51;
            } catch (NoSuchFieldError unused51) {
            }
            try {
                iArr[PointAnalyseType.POINT_APP_CHAIN_END.ordinal()] = 52;
            } catch (NoSuchFieldError unused52) {
            }
            try {
                iArr[PointAnalyseType.POINT_PAGE_CHAIN_START.ordinal()] = 53;
            } catch (NoSuchFieldError unused53) {
            }
            try {
                iArr[PointAnalyseType.POINT_PAGE_CHAIN_END.ordinal()] = 54;
            } catch (NoSuchFieldError unused54) {
            }
            try {
                iArr[PointAnalyseType.POINT_APP_CHAIN_CLEAR.ordinal()] = 55;
            } catch (NoSuchFieldError unused55) {
            }
            try {
                iArr[PointAnalyseType.POINT_PAGE_CHAIN_CLEAR.ordinal()] = 56;
            } catch (NoSuchFieldError unused56) {
            }
            try {
                iArr[PointAnalyseType.POINT_APP_CHAIN_INSERT.ordinal()] = 57;
            } catch (NoSuchFieldError unused57) {
            }
            try {
                iArr[PointAnalyseType.POINT_APP_CHAIN_FAIL.ordinal()] = 58;
            } catch (NoSuchFieldError unused58) {
            }
            try {
                iArr[PointAnalyseType.POINT_PAGE_CHAIN_FAIL.ordinal()] = 59;
            } catch (NoSuchFieldError unused59) {
            }
            try {
                iArr[PointAnalyseType.POINT_MINIAPP_FOREGROUND_TIME.ordinal()] = 60;
            } catch (NoSuchFieldError unused60) {
            }
            try {
                iArr[PointAnalyseType.POINT_GET_ODID.ordinal()] = 61;
            } catch (NoSuchFieldError unused61) {
            }
            try {
                iArr[PointAnalyseType.POINT_HOT_RELOAD.ordinal()] = 62;
            } catch (NoSuchFieldError unused62) {
            }
            try {
                iArr[PointAnalyseType.POINT_OPEN_PAGE_ACTION.ordinal()] = 63;
            } catch (NoSuchFieldError unused63) {
            }
            try {
                iArr[PointAnalyseType.POINT_PIN_FOR_LATER_EX.ordinal()] = 64;
            } catch (NoSuchFieldError unused64) {
            }
            try {
                iArr[PointAnalyseType.POINT_PIN_FOR_LATER_CLICK.ordinal()] = 65;
            } catch (NoSuchFieldError unused65) {
            }
            try {
                iArr[PointAnalyseType.POINT_PIN_FOR_LATER_BANNER_EX.ordinal()] = 66;
            } catch (NoSuchFieldError unused66) {
            }
            try {
                iArr[PointAnalyseType.POINT_PIN_FOR_LATER_BANNER_CLICK.ordinal()] = 67;
            } catch (NoSuchFieldError unused67) {
            }
            try {
                iArr[PointAnalyseType.POINT_PIN_FOR_LATER_ADD_MC_CLICK.ordinal()] = 68;
            } catch (NoSuchFieldError unused68) {
            }
            try {
                iArr[PointAnalyseType.POINT_PIN_FOR_LATER_ADD_MC_EX.ordinal()] = 69;
            } catch (NoSuchFieldError unused69) {
            }
            try {
                iArr[PointAnalyseType.POINT_PRIVACY_EX.ordinal()] = 70;
            } catch (NoSuchFieldError unused70) {
            }
            try {
                iArr[PointAnalyseType.POINT_PRIVACY_CLICK.ordinal()] = 71;
            } catch (NoSuchFieldError unused71) {
            }
            try {
                iArr[PointAnalyseType.ADD_MINI_APP_TO_DESKTOP.ordinal()] = 72;
            } catch (NoSuchFieldError unused72) {
            }
            try {
                iArr[PointAnalyseType.PRE_REQUEST_HTML.ordinal()] = 73;
            } catch (NoSuchFieldError unused73) {
            }
            try {
                iArr[PointAnalyseType.PRE_REQUEST_HTML_RET.ordinal()] = 74;
            } catch (NoSuchFieldError unused74) {
            }
            try {
                iArr[PointAnalyseType.GET_PRE_HTML.ordinal()] = 75;
            } catch (NoSuchFieldError unused75) {
            }
            try {
                iArr[PointAnalyseType.GET_PRE_HTML_HIT.ordinal()] = 76;
            } catch (NoSuchFieldError unused76) {
            }
            try {
                iArr[PointAnalyseType.POINT_OPEN_BROWSER.ordinal()] = 77;
            } catch (NoSuchFieldError unused77) {
            }
            try {
                iArr[PointAnalyseType.PRE_STRATEGY_FAIL.ordinal()] = 78;
            } catch (NoSuchFieldError unused78) {
            }
            try {
                iArr[PointAnalyseType.POINT_LATER_OFFLINE_EX.ordinal()] = 79;
            } catch (NoSuchFieldError unused79) {
            }
            try {
                iArr[PointAnalyseType.POINT_LATER_OFFLINE_APP_EX.ordinal()] = 80;
            } catch (NoSuchFieldError unused80) {
            }
            try {
                iArr[PointAnalyseType.POINT_LATER_OFFLINE_CLICK.ordinal()] = 81;
            } catch (NoSuchFieldError unused81) {
            }
            try {
                iArr[PointAnalyseType.POINT_GET_ADD_EX.ordinal()] = 82;
            } catch (NoSuchFieldError unused82) {
            }
            try {
                iArr[PointAnalyseType.POINT_GET_TOAST_ADD_EX.ordinal()] = 83;
            } catch (NoSuchFieldError unused83) {
            }
            try {
                iArr[PointAnalyseType.POINT_GET_ADD_CLICK.ordinal()] = 84;
            } catch (NoSuchFieldError unused84) {
            }
            try {
                iArr[PointAnalyseType.POINT_GET_ADD_NOSHOW.ordinal()] = 85;
            } catch (NoSuchFieldError unused85) {
            }
            f74099a = iArr;
        }
    }

    public final void a() {
        try {
            g0.e.f65310a.b();
        } catch (Throwable th2) {
            TmcLogger.g("PointTrack", "tryInitAthena failed!", th2);
        }
    }

    public final void b(Bundle bundle) {
        Map<String, Long> map;
        Long l11;
        String string = bundle.getString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.M, "");
        String string2 = bundle.getString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.N, "");
        if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2) || !this.f74098d.containsKey(string)) {
            return;
        }
        q.b bVar = this.f74098d.get(string);
        if (bVar != null) {
            if (Intrinsics.b(bVar.f74070b, string2)) {
                bundle.putString("openType", MBridgeConstans.DYNAMIC_VIEW_WX_APP);
                long jCurrentTimeMillis = System.currentTimeMillis();
                Long l12 = bVar.f74071c.get("18");
                bundle.putLong("openAppTime", jCurrentTimeMillis - (l12 != null ? l12.longValue() : jCurrentTimeMillis));
                Long l13 = bVar.f74071c.get("17");
                bundle.putLong("openPageTime", jCurrentTimeMillis - (l13 != null ? l13.longValue() : jCurrentTimeMillis));
            } else {
                bundle.putString("openType", "page");
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                f fVar = bVar.f74073e.get(string2);
                bundle.putLong("openPageTime", jCurrentTimeMillis2 - ((fVar == null || (map = fVar.f74086c) == null || (l11 = map.get("17")) == null) ? jCurrentTimeMillis2 : l11.longValue()));
            }
        }
        bundle.remove(com.cloud.tmc.kernel.proxy.performanceanalyse.a.L);
        bundle.remove(com.cloud.tmc.kernel.proxy.performanceanalyse.a.M);
        bundle.remove(com.cloud.tmc.kernel.proxy.performanceanalyse.a.N);
    }

    public final void c(Bundle bundle, String str) {
        tb.b appContext;
        Context context;
        if (str != null) {
            try {
                App appFindApp = ((AppManager) tc.a.a(AppManager.class)).findApp(str);
                if (appFindApp == null || (appContext = appFindApp.getAppContext()) == null || (context = appContext.getContext()) == null) {
                    return;
                }
                Intrinsics.f(context, "context");
                bundle.putString("queryShortcutExist", String.valueOf(AppUtils.f31011a.v(context, str)));
            } catch (Throwable th2) {
                TmcLogger.g("PointTrack", "queryShortcutStatus failed!", th2);
            }
        }
    }

    public final void d(String str) {
        App appFindApp;
        if (str != null) {
            try {
                App appFindApp2 = ((AppManager) tc.a.a(AppManager.class)).findApp(str);
                if ((appFindApp2 != null ? (lb.c) appFindApp2.getData(lb.c.class) : null) != null || (appFindApp = ((AppManager) tc.a.a(AppManager.class)).findApp(str)) == null) {
                    return;
                }
                lb.c cVar = new lb.c();
                cVar.d();
                cVar.b();
                cVar.a();
                Unit unit = Unit.f68710a;
                appFindApp.setData(lb.c.class, cVar);
            } catch (Throwable th2) {
                TmcLogger.g("PointTrack", "startRecordForegroundTime failed!", th2);
            }
        }
    }

    public final void e(String str, Bundle bundle) {
        Map<String, Long> map;
        q.b bVar;
        Map<String, Long> map2;
        Map<String, Long> map3;
        Map<String, Long> map4;
        Map<String, f> map5;
        f fVar;
        Map<String, f> map6;
        q.b bVar2;
        Map<String, Long> map7;
        Map<String, Long> map8;
        String string = bundle.getString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.L, "");
        String appId = bundle.getString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.M, "");
        String pagePath = bundle.getString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.N, "");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("chainStart -> msg:");
        sb2.append(str);
        sb2.append(", type:");
        sb2.append(string);
        sb2.append(", pagePath:");
        k.a(sb2, pagePath, "oldChain");
        if (!this.f74098d.containsKey(appId)) {
            Map<String, q.b> map9 = this.f74098d;
            Intrinsics.f(appId, "appId");
            map9.put(appId, new q.b(appId, null, new LinkedHashMap(), new LinkedHashMap(), new LinkedHashMap(), 0, 0, 0, 0, false, "", "", "", "", false));
        }
        if (Intrinsics.b(MBridgeConstans.DYNAMIC_VIEW_WX_APP, string)) {
            q.b bVar3 = this.f74098d.get(appId);
            if ((bVar3 != null && (map8 = bVar3.f74071c) != null && map8.containsKey(str)) || (bVar2 = this.f74098d.get(appId)) == null || (map7 = bVar2.f74071c) == null) {
                return;
            }
            map7.put(str, Long.valueOf(System.currentTimeMillis()));
            return;
        }
        if (!Intrinsics.b("page", string) || pagePath == null || pagePath.length() == 0) {
            return;
        }
        q.b bVar4 = this.f74098d.get(appId);
        Map<String, f> map10 = bVar4 != null ? bVar4.f74073e : null;
        if ((map10 == null || !map10.containsKey(pagePath)) && map10 != null) {
            Intrinsics.f(pagePath, "pagePath");
            map10.put(pagePath, new f(pagePath, "", new LinkedHashMap(), new LinkedHashMap(), "", "", ""));
        }
        if (Intrinsics.b(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31221l, str)) {
            String renderId = bundle.getString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.X, "");
            q.b bVar5 = this.f74098d.get(appId);
            f fVar2 = (bVar5 == null || (map6 = bVar5.f74073e) == null) ? null : map6.get(pagePath);
            if (fVar2 != null) {
                Intrinsics.f(renderId, "renderId");
                Intrinsics.g(renderId, "<set-?>");
                fVar2.f74085b = renderId;
            }
        }
        if (Intrinsics.b("21", str)) {
            String string2 = bundle.getString("navigationType");
            q.b bVar6 = this.f74098d.get(appId);
            if (bVar6 != null && (map5 = bVar6.f74073e) != null && (fVar = map5.get(pagePath)) != null) {
                if (string2 == null) {
                    string2 = "";
                }
                Intrinsics.g(string2, "<set-?>");
                fVar.f74090g = string2;
            }
        }
        f fVar3 = map10 != null ? map10.get(pagePath) : null;
        if ((fVar3 == null || (map4 = fVar3.f74086c) == null || !map4.containsKey(str)) && fVar3 != null && (map = fVar3.f74086c) != null) {
            map.put(str, Long.valueOf(System.currentTimeMillis()));
        }
        q.b bVar7 = this.f74098d.get(appId);
        if ((bVar7 != null ? bVar7.f74070b : null) == null) {
            q.b bVar8 = this.f74098d.get(appId);
            if (bVar8 != null) {
                bVar8.f74070b = pagePath;
            }
            q.b bVar9 = this.f74098d.get(appId);
            if (bVar9 != null) {
                String string3 = bundle.getString("pageRandomId");
                if (string3 == null) {
                    string3 = "";
                }
                Intrinsics.g(string3, "<set-?>");
                bVar9.f74082n = string3;
            }
            q.b bVar10 = this.f74098d.get(appId);
            if (bVar10 != null) {
                String string4 = bundle.getString("navigationType");
                String str2 = string4 != null ? string4 : "";
                Intrinsics.g(str2, "<set-?>");
                bVar10.f74081m = str2;
            }
        }
        q.b bVar11 = this.f74098d.get(appId);
        if (Intrinsics.b(pagePath, bVar11 != null ? bVar11.f74070b : null)) {
            q.b bVar12 = this.f74098d.get(appId);
            if ((bVar12 != null && (map3 = bVar12.f74071c) != null && map3.containsKey(str)) || (bVar = this.f74098d.get(appId)) == null || (map2 = bVar.f74071c) == null) {
                return;
            }
            map2.put(str, Long.valueOf(System.currentTimeMillis()));
        }
    }

    /* JADX WARN: Code duplicated, block: B:384:0x081d A[Catch: all -> 0x0a9b, TryCatch #3 {all -> 0x0a9b, blocks: (B:287:0x0624, B:291:0x0677, B:293:0x067f, B:295:0x0689, B:297:0x068f, B:299:0x0696, B:301:0x06a0, B:303:0x06a6, B:305:0x06b4, B:307:0x06ba, B:309:0x06c2, B:311:0x06c9, B:374:0x07da, B:376:0x07e2, B:378:0x07ec, B:380:0x07f3, B:382:0x07f9, B:479:0x0a86, B:384:0x081d, B:386:0x082b, B:388:0x0835, B:390:0x083c, B:392:0x0842, B:394:0x084c, B:396:0x0853, B:397:0x0870, B:399:0x08b0, B:401:0x08b6, B:402:0x08be, B:404:0x08c4, B:405:0x08ef, B:406:0x08f1, B:408:0x08f6, B:410:0x0904, B:412:0x090a, B:414:0x0911, B:416:0x0915, B:419:0x091c, B:421:0x0927, B:422:0x0932, B:424:0x0945, B:426:0x094b, B:428:0x0958, B:430:0x095e, B:432:0x096b, B:434:0x0975, B:436:0x0982, B:438:0x098c, B:440:0x0999, B:442:0x09a5, B:444:0x09b4, B:447:0x09bc, B:449:0x09cb, B:452:0x09d3, B:454:0x09f9, B:456:0x09ff, B:458:0x0a07, B:460:0x0a0e, B:462:0x0a38, B:464:0x0a3e, B:466:0x0a46, B:468:0x0a4d, B:470:0x0a5e, B:472:0x0a64, B:474:0x0a6c, B:475:0x0a70, B:478:0x0a82, B:312:0x06d7, B:314:0x06df, B:316:0x06e9, B:318:0x06ef, B:320:0x06f7, B:322:0x06fd, B:324:0x0704, B:326:0x070e, B:328:0x0714, B:330:0x071c, B:332:0x0722, B:334:0x0730, B:336:0x0736, B:338:0x073e, B:340:0x0744, B:342:0x074c, B:344:0x0753, B:345:0x075f, B:347:0x0769, B:349:0x0770, B:351:0x0776, B:353:0x0780, B:355:0x0786, B:357:0x078d, B:359:0x0797, B:361:0x079d, B:363:0x07ab, B:365:0x07b1, B:367:0x07b9, B:369:0x07bf, B:371:0x07c7, B:373:0x07ce), top: B:583:0x0624 }] */
    /* JADX WARN: Code duplicated, block: B:386:0x082b A[Catch: all -> 0x0a9b, TryCatch #3 {all -> 0x0a9b, blocks: (B:287:0x0624, B:291:0x0677, B:293:0x067f, B:295:0x0689, B:297:0x068f, B:299:0x0696, B:301:0x06a0, B:303:0x06a6, B:305:0x06b4, B:307:0x06ba, B:309:0x06c2, B:311:0x06c9, B:374:0x07da, B:376:0x07e2, B:378:0x07ec, B:380:0x07f3, B:382:0x07f9, B:479:0x0a86, B:384:0x081d, B:386:0x082b, B:388:0x0835, B:390:0x083c, B:392:0x0842, B:394:0x084c, B:396:0x0853, B:397:0x0870, B:399:0x08b0, B:401:0x08b6, B:402:0x08be, B:404:0x08c4, B:405:0x08ef, B:406:0x08f1, B:408:0x08f6, B:410:0x0904, B:412:0x090a, B:414:0x0911, B:416:0x0915, B:419:0x091c, B:421:0x0927, B:422:0x0932, B:424:0x0945, B:426:0x094b, B:428:0x0958, B:430:0x095e, B:432:0x096b, B:434:0x0975, B:436:0x0982, B:438:0x098c, B:440:0x0999, B:442:0x09a5, B:444:0x09b4, B:447:0x09bc, B:449:0x09cb, B:452:0x09d3, B:454:0x09f9, B:456:0x09ff, B:458:0x0a07, B:460:0x0a0e, B:462:0x0a38, B:464:0x0a3e, B:466:0x0a46, B:468:0x0a4d, B:470:0x0a5e, B:472:0x0a64, B:474:0x0a6c, B:475:0x0a70, B:478:0x0a82, B:312:0x06d7, B:314:0x06df, B:316:0x06e9, B:318:0x06ef, B:320:0x06f7, B:322:0x06fd, B:324:0x0704, B:326:0x070e, B:328:0x0714, B:330:0x071c, B:332:0x0722, B:334:0x0730, B:336:0x0736, B:338:0x073e, B:340:0x0744, B:342:0x074c, B:344:0x0753, B:345:0x075f, B:347:0x0769, B:349:0x0770, B:351:0x0776, B:353:0x0780, B:355:0x0786, B:357:0x078d, B:359:0x0797, B:361:0x079d, B:363:0x07ab, B:365:0x07b1, B:367:0x07b9, B:369:0x07bf, B:371:0x07c7, B:373:0x07ce), top: B:583:0x0624 }] */
    /* JADX WARN: Code duplicated, block: B:388:0x0835 A[Catch: all -> 0x0a9b, TryCatch #3 {all -> 0x0a9b, blocks: (B:287:0x0624, B:291:0x0677, B:293:0x067f, B:295:0x0689, B:297:0x068f, B:299:0x0696, B:301:0x06a0, B:303:0x06a6, B:305:0x06b4, B:307:0x06ba, B:309:0x06c2, B:311:0x06c9, B:374:0x07da, B:376:0x07e2, B:378:0x07ec, B:380:0x07f3, B:382:0x07f9, B:479:0x0a86, B:384:0x081d, B:386:0x082b, B:388:0x0835, B:390:0x083c, B:392:0x0842, B:394:0x084c, B:396:0x0853, B:397:0x0870, B:399:0x08b0, B:401:0x08b6, B:402:0x08be, B:404:0x08c4, B:405:0x08ef, B:406:0x08f1, B:408:0x08f6, B:410:0x0904, B:412:0x090a, B:414:0x0911, B:416:0x0915, B:419:0x091c, B:421:0x0927, B:422:0x0932, B:424:0x0945, B:426:0x094b, B:428:0x0958, B:430:0x095e, B:432:0x096b, B:434:0x0975, B:436:0x0982, B:438:0x098c, B:440:0x0999, B:442:0x09a5, B:444:0x09b4, B:447:0x09bc, B:449:0x09cb, B:452:0x09d3, B:454:0x09f9, B:456:0x09ff, B:458:0x0a07, B:460:0x0a0e, B:462:0x0a38, B:464:0x0a3e, B:466:0x0a46, B:468:0x0a4d, B:470:0x0a5e, B:472:0x0a64, B:474:0x0a6c, B:475:0x0a70, B:478:0x0a82, B:312:0x06d7, B:314:0x06df, B:316:0x06e9, B:318:0x06ef, B:320:0x06f7, B:322:0x06fd, B:324:0x0704, B:326:0x070e, B:328:0x0714, B:330:0x071c, B:332:0x0722, B:334:0x0730, B:336:0x0736, B:338:0x073e, B:340:0x0744, B:342:0x074c, B:344:0x0753, B:345:0x075f, B:347:0x0769, B:349:0x0770, B:351:0x0776, B:353:0x0780, B:355:0x0786, B:357:0x078d, B:359:0x0797, B:361:0x079d, B:363:0x07ab, B:365:0x07b1, B:367:0x07b9, B:369:0x07bf, B:371:0x07c7, B:373:0x07ce), top: B:583:0x0624 }] */
    /* JADX WARN: Code duplicated, block: B:389:0x083a  */
    /* JADX WARN: Code duplicated, block: B:392:0x0842 A[Catch: all -> 0x0a9b, TryCatch #3 {all -> 0x0a9b, blocks: (B:287:0x0624, B:291:0x0677, B:293:0x067f, B:295:0x0689, B:297:0x068f, B:299:0x0696, B:301:0x06a0, B:303:0x06a6, B:305:0x06b4, B:307:0x06ba, B:309:0x06c2, B:311:0x06c9, B:374:0x07da, B:376:0x07e2, B:378:0x07ec, B:380:0x07f3, B:382:0x07f9, B:479:0x0a86, B:384:0x081d, B:386:0x082b, B:388:0x0835, B:390:0x083c, B:392:0x0842, B:394:0x084c, B:396:0x0853, B:397:0x0870, B:399:0x08b0, B:401:0x08b6, B:402:0x08be, B:404:0x08c4, B:405:0x08ef, B:406:0x08f1, B:408:0x08f6, B:410:0x0904, B:412:0x090a, B:414:0x0911, B:416:0x0915, B:419:0x091c, B:421:0x0927, B:422:0x0932, B:424:0x0945, B:426:0x094b, B:428:0x0958, B:430:0x095e, B:432:0x096b, B:434:0x0975, B:436:0x0982, B:438:0x098c, B:440:0x0999, B:442:0x09a5, B:444:0x09b4, B:447:0x09bc, B:449:0x09cb, B:452:0x09d3, B:454:0x09f9, B:456:0x09ff, B:458:0x0a07, B:460:0x0a0e, B:462:0x0a38, B:464:0x0a3e, B:466:0x0a46, B:468:0x0a4d, B:470:0x0a5e, B:472:0x0a64, B:474:0x0a6c, B:475:0x0a70, B:478:0x0a82, B:312:0x06d7, B:314:0x06df, B:316:0x06e9, B:318:0x06ef, B:320:0x06f7, B:322:0x06fd, B:324:0x0704, B:326:0x070e, B:328:0x0714, B:330:0x071c, B:332:0x0722, B:334:0x0730, B:336:0x0736, B:338:0x073e, B:340:0x0744, B:342:0x074c, B:344:0x0753, B:345:0x075f, B:347:0x0769, B:349:0x0770, B:351:0x0776, B:353:0x0780, B:355:0x0786, B:357:0x078d, B:359:0x0797, B:361:0x079d, B:363:0x07ab, B:365:0x07b1, B:367:0x07b9, B:369:0x07bf, B:371:0x07c7, B:373:0x07ce), top: B:583:0x0624 }] */
    /* JADX WARN: Code duplicated, block: B:404:0x08c4 A[Catch: all -> 0x0a9b, LOOP:1: B:402:0x08be->B:404:0x08c4, LOOP_END, TryCatch #3 {all -> 0x0a9b, blocks: (B:287:0x0624, B:291:0x0677, B:293:0x067f, B:295:0x0689, B:297:0x068f, B:299:0x0696, B:301:0x06a0, B:303:0x06a6, B:305:0x06b4, B:307:0x06ba, B:309:0x06c2, B:311:0x06c9, B:374:0x07da, B:376:0x07e2, B:378:0x07ec, B:380:0x07f3, B:382:0x07f9, B:479:0x0a86, B:384:0x081d, B:386:0x082b, B:388:0x0835, B:390:0x083c, B:392:0x0842, B:394:0x084c, B:396:0x0853, B:397:0x0870, B:399:0x08b0, B:401:0x08b6, B:402:0x08be, B:404:0x08c4, B:405:0x08ef, B:406:0x08f1, B:408:0x08f6, B:410:0x0904, B:412:0x090a, B:414:0x0911, B:416:0x0915, B:419:0x091c, B:421:0x0927, B:422:0x0932, B:424:0x0945, B:426:0x094b, B:428:0x0958, B:430:0x095e, B:432:0x096b, B:434:0x0975, B:436:0x0982, B:438:0x098c, B:440:0x0999, B:442:0x09a5, B:444:0x09b4, B:447:0x09bc, B:449:0x09cb, B:452:0x09d3, B:454:0x09f9, B:456:0x09ff, B:458:0x0a07, B:460:0x0a0e, B:462:0x0a38, B:464:0x0a3e, B:466:0x0a46, B:468:0x0a4d, B:470:0x0a5e, B:472:0x0a64, B:474:0x0a6c, B:475:0x0a70, B:478:0x0a82, B:312:0x06d7, B:314:0x06df, B:316:0x06e9, B:318:0x06ef, B:320:0x06f7, B:322:0x06fd, B:324:0x0704, B:326:0x070e, B:328:0x0714, B:330:0x071c, B:332:0x0722, B:334:0x0730, B:336:0x0736, B:338:0x073e, B:340:0x0744, B:342:0x074c, B:344:0x0753, B:345:0x075f, B:347:0x0769, B:349:0x0770, B:351:0x0776, B:353:0x0780, B:355:0x0786, B:357:0x078d, B:359:0x0797, B:361:0x079d, B:363:0x07ab, B:365:0x07b1, B:367:0x07b9, B:369:0x07bf, B:371:0x07c7, B:373:0x07ce), top: B:583:0x0624 }] */
    /* JADX WARN: Code duplicated, block: B:408:0x08f6 A[Catch: all -> 0x0a9b, TryCatch #3 {all -> 0x0a9b, blocks: (B:287:0x0624, B:291:0x0677, B:293:0x067f, B:295:0x0689, B:297:0x068f, B:299:0x0696, B:301:0x06a0, B:303:0x06a6, B:305:0x06b4, B:307:0x06ba, B:309:0x06c2, B:311:0x06c9, B:374:0x07da, B:376:0x07e2, B:378:0x07ec, B:380:0x07f3, B:382:0x07f9, B:479:0x0a86, B:384:0x081d, B:386:0x082b, B:388:0x0835, B:390:0x083c, B:392:0x0842, B:394:0x084c, B:396:0x0853, B:397:0x0870, B:399:0x08b0, B:401:0x08b6, B:402:0x08be, B:404:0x08c4, B:405:0x08ef, B:406:0x08f1, B:408:0x08f6, B:410:0x0904, B:412:0x090a, B:414:0x0911, B:416:0x0915, B:419:0x091c, B:421:0x0927, B:422:0x0932, B:424:0x0945, B:426:0x094b, B:428:0x0958, B:430:0x095e, B:432:0x096b, B:434:0x0975, B:436:0x0982, B:438:0x098c, B:440:0x0999, B:442:0x09a5, B:444:0x09b4, B:447:0x09bc, B:449:0x09cb, B:452:0x09d3, B:454:0x09f9, B:456:0x09ff, B:458:0x0a07, B:460:0x0a0e, B:462:0x0a38, B:464:0x0a3e, B:466:0x0a46, B:468:0x0a4d, B:470:0x0a5e, B:472:0x0a64, B:474:0x0a6c, B:475:0x0a70, B:478:0x0a82, B:312:0x06d7, B:314:0x06df, B:316:0x06e9, B:318:0x06ef, B:320:0x06f7, B:322:0x06fd, B:324:0x0704, B:326:0x070e, B:328:0x0714, B:330:0x071c, B:332:0x0722, B:334:0x0730, B:336:0x0736, B:338:0x073e, B:340:0x0744, B:342:0x074c, B:344:0x0753, B:345:0x075f, B:347:0x0769, B:349:0x0770, B:351:0x0776, B:353:0x0780, B:355:0x0786, B:357:0x078d, B:359:0x0797, B:361:0x079d, B:363:0x07ab, B:365:0x07b1, B:367:0x07b9, B:369:0x07bf, B:371:0x07c7, B:373:0x07ce), top: B:583:0x0624 }] */
    /* JADX WARN: Code duplicated, block: B:413:0x090f  */
    /* JADX WARN: Code duplicated, block: B:416:0x0915 A[Catch: all -> 0x0a9b, TryCatch #3 {all -> 0x0a9b, blocks: (B:287:0x0624, B:291:0x0677, B:293:0x067f, B:295:0x0689, B:297:0x068f, B:299:0x0696, B:301:0x06a0, B:303:0x06a6, B:305:0x06b4, B:307:0x06ba, B:309:0x06c2, B:311:0x06c9, B:374:0x07da, B:376:0x07e2, B:378:0x07ec, B:380:0x07f3, B:382:0x07f9, B:479:0x0a86, B:384:0x081d, B:386:0x082b, B:388:0x0835, B:390:0x083c, B:392:0x0842, B:394:0x084c, B:396:0x0853, B:397:0x0870, B:399:0x08b0, B:401:0x08b6, B:402:0x08be, B:404:0x08c4, B:405:0x08ef, B:406:0x08f1, B:408:0x08f6, B:410:0x0904, B:412:0x090a, B:414:0x0911, B:416:0x0915, B:419:0x091c, B:421:0x0927, B:422:0x0932, B:424:0x0945, B:426:0x094b, B:428:0x0958, B:430:0x095e, B:432:0x096b, B:434:0x0975, B:436:0x0982, B:438:0x098c, B:440:0x0999, B:442:0x09a5, B:444:0x09b4, B:447:0x09bc, B:449:0x09cb, B:452:0x09d3, B:454:0x09f9, B:456:0x09ff, B:458:0x0a07, B:460:0x0a0e, B:462:0x0a38, B:464:0x0a3e, B:466:0x0a46, B:468:0x0a4d, B:470:0x0a5e, B:472:0x0a64, B:474:0x0a6c, B:475:0x0a70, B:478:0x0a82, B:312:0x06d7, B:314:0x06df, B:316:0x06e9, B:318:0x06ef, B:320:0x06f7, B:322:0x06fd, B:324:0x0704, B:326:0x070e, B:328:0x0714, B:330:0x071c, B:332:0x0722, B:334:0x0730, B:336:0x0736, B:338:0x073e, B:340:0x0744, B:342:0x074c, B:344:0x0753, B:345:0x075f, B:347:0x0769, B:349:0x0770, B:351:0x0776, B:353:0x0780, B:355:0x0786, B:357:0x078d, B:359:0x0797, B:361:0x079d, B:363:0x07ab, B:365:0x07b1, B:367:0x07b9, B:369:0x07bf, B:371:0x07c7, B:373:0x07ce), top: B:583:0x0624 }] */
    /* JADX WARN: Code duplicated, block: B:417:0x0918  */
    /* JADX WARN: Code duplicated, block: B:419:0x091c A[Catch: all -> 0x0a9b, TryCatch #3 {all -> 0x0a9b, blocks: (B:287:0x0624, B:291:0x0677, B:293:0x067f, B:295:0x0689, B:297:0x068f, B:299:0x0696, B:301:0x06a0, B:303:0x06a6, B:305:0x06b4, B:307:0x06ba, B:309:0x06c2, B:311:0x06c9, B:374:0x07da, B:376:0x07e2, B:378:0x07ec, B:380:0x07f3, B:382:0x07f9, B:479:0x0a86, B:384:0x081d, B:386:0x082b, B:388:0x0835, B:390:0x083c, B:392:0x0842, B:394:0x084c, B:396:0x0853, B:397:0x0870, B:399:0x08b0, B:401:0x08b6, B:402:0x08be, B:404:0x08c4, B:405:0x08ef, B:406:0x08f1, B:408:0x08f6, B:410:0x0904, B:412:0x090a, B:414:0x0911, B:416:0x0915, B:419:0x091c, B:421:0x0927, B:422:0x0932, B:424:0x0945, B:426:0x094b, B:428:0x0958, B:430:0x095e, B:432:0x096b, B:434:0x0975, B:436:0x0982, B:438:0x098c, B:440:0x0999, B:442:0x09a5, B:444:0x09b4, B:447:0x09bc, B:449:0x09cb, B:452:0x09d3, B:454:0x09f9, B:456:0x09ff, B:458:0x0a07, B:460:0x0a0e, B:462:0x0a38, B:464:0x0a3e, B:466:0x0a46, B:468:0x0a4d, B:470:0x0a5e, B:472:0x0a64, B:474:0x0a6c, B:475:0x0a70, B:478:0x0a82, B:312:0x06d7, B:314:0x06df, B:316:0x06e9, B:318:0x06ef, B:320:0x06f7, B:322:0x06fd, B:324:0x0704, B:326:0x070e, B:328:0x0714, B:330:0x071c, B:332:0x0722, B:334:0x0730, B:336:0x0736, B:338:0x073e, B:340:0x0744, B:342:0x074c, B:344:0x0753, B:345:0x075f, B:347:0x0769, B:349:0x0770, B:351:0x0776, B:353:0x0780, B:355:0x0786, B:357:0x078d, B:359:0x0797, B:361:0x079d, B:363:0x07ab, B:365:0x07b1, B:367:0x07b9, B:369:0x07bf, B:371:0x07c7, B:373:0x07ce), top: B:583:0x0624 }] */
    /* JADX WARN: Code duplicated, block: B:420:0x0925  */
    /* JADX WARN: Code duplicated, block: B:424:0x0945 A[Catch: all -> 0x0a9b, TryCatch #3 {all -> 0x0a9b, blocks: (B:287:0x0624, B:291:0x0677, B:293:0x067f, B:295:0x0689, B:297:0x068f, B:299:0x0696, B:301:0x06a0, B:303:0x06a6, B:305:0x06b4, B:307:0x06ba, B:309:0x06c2, B:311:0x06c9, B:374:0x07da, B:376:0x07e2, B:378:0x07ec, B:380:0x07f3, B:382:0x07f9, B:479:0x0a86, B:384:0x081d, B:386:0x082b, B:388:0x0835, B:390:0x083c, B:392:0x0842, B:394:0x084c, B:396:0x0853, B:397:0x0870, B:399:0x08b0, B:401:0x08b6, B:402:0x08be, B:404:0x08c4, B:405:0x08ef, B:406:0x08f1, B:408:0x08f6, B:410:0x0904, B:412:0x090a, B:414:0x0911, B:416:0x0915, B:419:0x091c, B:421:0x0927, B:422:0x0932, B:424:0x0945, B:426:0x094b, B:428:0x0958, B:430:0x095e, B:432:0x096b, B:434:0x0975, B:436:0x0982, B:438:0x098c, B:440:0x0999, B:442:0x09a5, B:444:0x09b4, B:447:0x09bc, B:449:0x09cb, B:452:0x09d3, B:454:0x09f9, B:456:0x09ff, B:458:0x0a07, B:460:0x0a0e, B:462:0x0a38, B:464:0x0a3e, B:466:0x0a46, B:468:0x0a4d, B:470:0x0a5e, B:472:0x0a64, B:474:0x0a6c, B:475:0x0a70, B:478:0x0a82, B:312:0x06d7, B:314:0x06df, B:316:0x06e9, B:318:0x06ef, B:320:0x06f7, B:322:0x06fd, B:324:0x0704, B:326:0x070e, B:328:0x0714, B:330:0x071c, B:332:0x0722, B:334:0x0730, B:336:0x0736, B:338:0x073e, B:340:0x0744, B:342:0x074c, B:344:0x0753, B:345:0x075f, B:347:0x0769, B:349:0x0770, B:351:0x0776, B:353:0x0780, B:355:0x0786, B:357:0x078d, B:359:0x0797, B:361:0x079d, B:363:0x07ab, B:365:0x07b1, B:367:0x07b9, B:369:0x07bf, B:371:0x07c7, B:373:0x07ce), top: B:583:0x0624 }] */
    /* JADX WARN: Code duplicated, block: B:425:0x094a  */
    /* JADX WARN: Code duplicated, block: B:428:0x0958 A[Catch: all -> 0x0a9b, TryCatch #3 {all -> 0x0a9b, blocks: (B:287:0x0624, B:291:0x0677, B:293:0x067f, B:295:0x0689, B:297:0x068f, B:299:0x0696, B:301:0x06a0, B:303:0x06a6, B:305:0x06b4, B:307:0x06ba, B:309:0x06c2, B:311:0x06c9, B:374:0x07da, B:376:0x07e2, B:378:0x07ec, B:380:0x07f3, B:382:0x07f9, B:479:0x0a86, B:384:0x081d, B:386:0x082b, B:388:0x0835, B:390:0x083c, B:392:0x0842, B:394:0x084c, B:396:0x0853, B:397:0x0870, B:399:0x08b0, B:401:0x08b6, B:402:0x08be, B:404:0x08c4, B:405:0x08ef, B:406:0x08f1, B:408:0x08f6, B:410:0x0904, B:412:0x090a, B:414:0x0911, B:416:0x0915, B:419:0x091c, B:421:0x0927, B:422:0x0932, B:424:0x0945, B:426:0x094b, B:428:0x0958, B:430:0x095e, B:432:0x096b, B:434:0x0975, B:436:0x0982, B:438:0x098c, B:440:0x0999, B:442:0x09a5, B:444:0x09b4, B:447:0x09bc, B:449:0x09cb, B:452:0x09d3, B:454:0x09f9, B:456:0x09ff, B:458:0x0a07, B:460:0x0a0e, B:462:0x0a38, B:464:0x0a3e, B:466:0x0a46, B:468:0x0a4d, B:470:0x0a5e, B:472:0x0a64, B:474:0x0a6c, B:475:0x0a70, B:478:0x0a82, B:312:0x06d7, B:314:0x06df, B:316:0x06e9, B:318:0x06ef, B:320:0x06f7, B:322:0x06fd, B:324:0x0704, B:326:0x070e, B:328:0x0714, B:330:0x071c, B:332:0x0722, B:334:0x0730, B:336:0x0736, B:338:0x073e, B:340:0x0744, B:342:0x074c, B:344:0x0753, B:345:0x075f, B:347:0x0769, B:349:0x0770, B:351:0x0776, B:353:0x0780, B:355:0x0786, B:357:0x078d, B:359:0x0797, B:361:0x079d, B:363:0x07ab, B:365:0x07b1, B:367:0x07b9, B:369:0x07bf, B:371:0x07c7, B:373:0x07ce), top: B:583:0x0624 }] */
    /* JADX WARN: Code duplicated, block: B:429:0x095d  */
    /* JADX WARN: Code duplicated, block: B:432:0x096b A[Catch: all -> 0x0a9b, TryCatch #3 {all -> 0x0a9b, blocks: (B:287:0x0624, B:291:0x0677, B:293:0x067f, B:295:0x0689, B:297:0x068f, B:299:0x0696, B:301:0x06a0, B:303:0x06a6, B:305:0x06b4, B:307:0x06ba, B:309:0x06c2, B:311:0x06c9, B:374:0x07da, B:376:0x07e2, B:378:0x07ec, B:380:0x07f3, B:382:0x07f9, B:479:0x0a86, B:384:0x081d, B:386:0x082b, B:388:0x0835, B:390:0x083c, B:392:0x0842, B:394:0x084c, B:396:0x0853, B:397:0x0870, B:399:0x08b0, B:401:0x08b6, B:402:0x08be, B:404:0x08c4, B:405:0x08ef, B:406:0x08f1, B:408:0x08f6, B:410:0x0904, B:412:0x090a, B:414:0x0911, B:416:0x0915, B:419:0x091c, B:421:0x0927, B:422:0x0932, B:424:0x0945, B:426:0x094b, B:428:0x0958, B:430:0x095e, B:432:0x096b, B:434:0x0975, B:436:0x0982, B:438:0x098c, B:440:0x0999, B:442:0x09a5, B:444:0x09b4, B:447:0x09bc, B:449:0x09cb, B:452:0x09d3, B:454:0x09f9, B:456:0x09ff, B:458:0x0a07, B:460:0x0a0e, B:462:0x0a38, B:464:0x0a3e, B:466:0x0a46, B:468:0x0a4d, B:470:0x0a5e, B:472:0x0a64, B:474:0x0a6c, B:475:0x0a70, B:478:0x0a82, B:312:0x06d7, B:314:0x06df, B:316:0x06e9, B:318:0x06ef, B:320:0x06f7, B:322:0x06fd, B:324:0x0704, B:326:0x070e, B:328:0x0714, B:330:0x071c, B:332:0x0722, B:334:0x0730, B:336:0x0736, B:338:0x073e, B:340:0x0744, B:342:0x074c, B:344:0x0753, B:345:0x075f, B:347:0x0769, B:349:0x0770, B:351:0x0776, B:353:0x0780, B:355:0x0786, B:357:0x078d, B:359:0x0797, B:361:0x079d, B:363:0x07ab, B:365:0x07b1, B:367:0x07b9, B:369:0x07bf, B:371:0x07c7, B:373:0x07ce), top: B:583:0x0624 }] */
    /* JADX WARN: Code duplicated, block: B:433:0x0972  */
    /* JADX WARN: Code duplicated, block: B:436:0x0982 A[Catch: all -> 0x0a9b, TryCatch #3 {all -> 0x0a9b, blocks: (B:287:0x0624, B:291:0x0677, B:293:0x067f, B:295:0x0689, B:297:0x068f, B:299:0x0696, B:301:0x06a0, B:303:0x06a6, B:305:0x06b4, B:307:0x06ba, B:309:0x06c2, B:311:0x06c9, B:374:0x07da, B:376:0x07e2, B:378:0x07ec, B:380:0x07f3, B:382:0x07f9, B:479:0x0a86, B:384:0x081d, B:386:0x082b, B:388:0x0835, B:390:0x083c, B:392:0x0842, B:394:0x084c, B:396:0x0853, B:397:0x0870, B:399:0x08b0, B:401:0x08b6, B:402:0x08be, B:404:0x08c4, B:405:0x08ef, B:406:0x08f1, B:408:0x08f6, B:410:0x0904, B:412:0x090a, B:414:0x0911, B:416:0x0915, B:419:0x091c, B:421:0x0927, B:422:0x0932, B:424:0x0945, B:426:0x094b, B:428:0x0958, B:430:0x095e, B:432:0x096b, B:434:0x0975, B:436:0x0982, B:438:0x098c, B:440:0x0999, B:442:0x09a5, B:444:0x09b4, B:447:0x09bc, B:449:0x09cb, B:452:0x09d3, B:454:0x09f9, B:456:0x09ff, B:458:0x0a07, B:460:0x0a0e, B:462:0x0a38, B:464:0x0a3e, B:466:0x0a46, B:468:0x0a4d, B:470:0x0a5e, B:472:0x0a64, B:474:0x0a6c, B:475:0x0a70, B:478:0x0a82, B:312:0x06d7, B:314:0x06df, B:316:0x06e9, B:318:0x06ef, B:320:0x06f7, B:322:0x06fd, B:324:0x0704, B:326:0x070e, B:328:0x0714, B:330:0x071c, B:332:0x0722, B:334:0x0730, B:336:0x0736, B:338:0x073e, B:340:0x0744, B:342:0x074c, B:344:0x0753, B:345:0x075f, B:347:0x0769, B:349:0x0770, B:351:0x0776, B:353:0x0780, B:355:0x0786, B:357:0x078d, B:359:0x0797, B:361:0x079d, B:363:0x07ab, B:365:0x07b1, B:367:0x07b9, B:369:0x07bf, B:371:0x07c7, B:373:0x07ce), top: B:583:0x0624 }] */
    /* JADX WARN: Code duplicated, block: B:437:0x0989  */
    /* JADX WARN: Code duplicated, block: B:440:0x0999 A[Catch: all -> 0x0a9b, TryCatch #3 {all -> 0x0a9b, blocks: (B:287:0x0624, B:291:0x0677, B:293:0x067f, B:295:0x0689, B:297:0x068f, B:299:0x0696, B:301:0x06a0, B:303:0x06a6, B:305:0x06b4, B:307:0x06ba, B:309:0x06c2, B:311:0x06c9, B:374:0x07da, B:376:0x07e2, B:378:0x07ec, B:380:0x07f3, B:382:0x07f9, B:479:0x0a86, B:384:0x081d, B:386:0x082b, B:388:0x0835, B:390:0x083c, B:392:0x0842, B:394:0x084c, B:396:0x0853, B:397:0x0870, B:399:0x08b0, B:401:0x08b6, B:402:0x08be, B:404:0x08c4, B:405:0x08ef, B:406:0x08f1, B:408:0x08f6, B:410:0x0904, B:412:0x090a, B:414:0x0911, B:416:0x0915, B:419:0x091c, B:421:0x0927, B:422:0x0932, B:424:0x0945, B:426:0x094b, B:428:0x0958, B:430:0x095e, B:432:0x096b, B:434:0x0975, B:436:0x0982, B:438:0x098c, B:440:0x0999, B:442:0x09a5, B:444:0x09b4, B:447:0x09bc, B:449:0x09cb, B:452:0x09d3, B:454:0x09f9, B:456:0x09ff, B:458:0x0a07, B:460:0x0a0e, B:462:0x0a38, B:464:0x0a3e, B:466:0x0a46, B:468:0x0a4d, B:470:0x0a5e, B:472:0x0a64, B:474:0x0a6c, B:475:0x0a70, B:478:0x0a82, B:312:0x06d7, B:314:0x06df, B:316:0x06e9, B:318:0x06ef, B:320:0x06f7, B:322:0x06fd, B:324:0x0704, B:326:0x070e, B:328:0x0714, B:330:0x071c, B:332:0x0722, B:334:0x0730, B:336:0x0736, B:338:0x073e, B:340:0x0744, B:342:0x074c, B:344:0x0753, B:345:0x075f, B:347:0x0769, B:349:0x0770, B:351:0x0776, B:353:0x0780, B:355:0x0786, B:357:0x078d, B:359:0x0797, B:361:0x079d, B:363:0x07ab, B:365:0x07b1, B:367:0x07b9, B:369:0x07bf, B:371:0x07c7, B:373:0x07ce), top: B:583:0x0624 }] */
    /* JADX WARN: Code duplicated, block: B:441:0x09a2  */
    /* JADX WARN: Code duplicated, block: B:446:0x09ba  */
    /* JADX WARN: Code duplicated, block: B:451:0x09d1  */
    /* JADX WARN: Code duplicated, block: B:459:0x0a0c  */
    /* JADX WARN: Code duplicated, block: B:467:0x0a4b  */
    /* JADX WARN: Code duplicated, block: B:477:0x0a81  */
    /* JADX WARN: Code duplicated, block: B:478:0x0a82 A[Catch: all -> 0x0a9b, TryCatch #3 {all -> 0x0a9b, blocks: (B:287:0x0624, B:291:0x0677, B:293:0x067f, B:295:0x0689, B:297:0x068f, B:299:0x0696, B:301:0x06a0, B:303:0x06a6, B:305:0x06b4, B:307:0x06ba, B:309:0x06c2, B:311:0x06c9, B:374:0x07da, B:376:0x07e2, B:378:0x07ec, B:380:0x07f3, B:382:0x07f9, B:479:0x0a86, B:384:0x081d, B:386:0x082b, B:388:0x0835, B:390:0x083c, B:392:0x0842, B:394:0x084c, B:396:0x0853, B:397:0x0870, B:399:0x08b0, B:401:0x08b6, B:402:0x08be, B:404:0x08c4, B:405:0x08ef, B:406:0x08f1, B:408:0x08f6, B:410:0x0904, B:412:0x090a, B:414:0x0911, B:416:0x0915, B:419:0x091c, B:421:0x0927, B:422:0x0932, B:424:0x0945, B:426:0x094b, B:428:0x0958, B:430:0x095e, B:432:0x096b, B:434:0x0975, B:436:0x0982, B:438:0x098c, B:440:0x0999, B:442:0x09a5, B:444:0x09b4, B:447:0x09bc, B:449:0x09cb, B:452:0x09d3, B:454:0x09f9, B:456:0x09ff, B:458:0x0a07, B:460:0x0a0e, B:462:0x0a38, B:464:0x0a3e, B:466:0x0a46, B:468:0x0a4d, B:470:0x0a5e, B:472:0x0a64, B:474:0x0a6c, B:475:0x0a70, B:478:0x0a82, B:312:0x06d7, B:314:0x06df, B:316:0x06e9, B:318:0x06ef, B:320:0x06f7, B:322:0x06fd, B:324:0x0704, B:326:0x070e, B:328:0x0714, B:330:0x071c, B:332:0x0722, B:334:0x0730, B:336:0x0736, B:338:0x073e, B:340:0x0744, B:342:0x074c, B:344:0x0753, B:345:0x075f, B:347:0x0769, B:349:0x0770, B:351:0x0776, B:353:0x0780, B:355:0x0786, B:357:0x078d, B:359:0x0797, B:361:0x079d, B:363:0x07ab, B:365:0x07b1, B:367:0x07b9, B:369:0x07bf, B:371:0x07c7, B:373:0x07ce), top: B:583:0x0624 }] */
    /* JADX WARN: Code duplicated, block: B:537:0x0cea  */
    /* JADX WARN: Code duplicated, block: B:541:0x0cf9  */
    /* JADX WARN: Code duplicated, block: B:544:0x0d00  */
    /* JADX WARN: Code duplicated, block: B:546:0x0d16  */
    /* JADX WARN: Code duplicated, block: B:548:0x0d1c  */
    /* JADX WARN: Code duplicated, block: B:549:0x0d2e  */
    /* JADX WARN: Code duplicated, block: B:551:0x0d32  */
    /* JADX WARN: Code duplicated, block: B:553:0x0d53  */
    /* JADX WARN: Code duplicated, block: B:556:0x0d88  */
    /* JADX WARN: Code duplicated, block: B:559:0x0d9b  */
    /* JADX WARN: Code duplicated, block: B:568:0x0de4  */
    /* JADX WARN: Code duplicated, block: B:569:0x0de6  */
    /* JADX WARN: Code duplicated, block: B:586:0x0dbe A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:588:0x0da9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:589:0x0dc2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:591:0x0d95 A[SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:404:0x08c4, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:544:0x0d00, please report this as an issue */
    public void f(String str, PointAnalyseType target, String str2, Bundle bundle) {
        long jCurrentTimeMillis;
        long jCurrentTimeMillis2;
        long j11;
        long jCurrentTimeMillis3;
        q.b bVar;
        Map<String, Long> mapD;
        q.b bVar2;
        Map<String, Long> mapB;
        Map<String, f> mapK;
        f fVar;
        Map<String, Long> mapB2;
        Long l11;
        Map<String, f> mapK2;
        f fVar2;
        Map<String, Long> mapB3;
        q.b bVar3;
        Map<String, f> mapK3;
        f fVar3;
        Map<String, Long> mapA;
        Map<String, f> mapK4;
        f fVar4;
        Map<String, Long> mapB4;
        Long l12;
        q.b bVar4;
        String strG;
        q.b bVar5;
        q.b bVar6;
        q.b bVar7;
        boolean zA;
        q.b bVar8;
        int iF;
        q.b bVar9;
        int iE;
        q.b bVar10;
        int iM;
        q.b bVar11;
        int iL;
        q.b bVar12;
        String strH;
        q.b bVar13;
        String strO;
        q.b bVar14;
        String strF;
        q.b bVar15;
        String strF2;
        q.b bVar16;
        q.b bVar17;
        Map<String, f> mapK5;
        f fVar5;
        Map<String, f> mapK6;
        f fVar6;
        Map<String, f> mapK7;
        f fVar7;
        App appFindApp;
        Context context;
        BaseActivity baseActivity;
        Boolean boolValueOf;
        tb.b appContext;
        Map<String, Long> mapB5;
        Map<String, Long> mapD2;
        q.b bVar18;
        Map<String, Long> mapB6;
        Map<String, Long> mapD3;
        Long l13;
        String strC;
        String strE;
        Map<String, f> mapK8;
        Map<String, f> mapK9;
        f fVar8;
        Map<String, f> mapK10;
        f fVar9;
        Map<String, f> mapK11;
        f fVar10;
        Map<String, f> mapK12;
        Map<String, f> mapK13;
        f fVar11;
        Map<String, f> mapK14;
        f fVar12;
        Map<String, f> mapK15;
        f fVar13;
        Map<String, f> mapK16;
        String strH2;
        String strO2;
        Map<String, f> mapK17;
        f fVar14;
        String str3;
        r.a aVar;
        String strA;
        PointAnalyseType pointAnalyseType;
        StringBuilder sb2;
        HashMap<String, Object> data;
        boolean z11;
        Iterator<T> it;
        Map.Entry entry;
        Object value;
        String str4 = str;
        String str5 = str2;
        Intrinsics.g(target, "target");
        Bundle data2 = new Bundle();
        if (bundle != null) {
            data2.putAll(bundle);
            Unit unit = Unit.f68710a;
        }
        String str6 = "miniapp_exposure";
        String strD = null;
        String str7 = "";
        switch (b.f74099a[target.ordinal()]) {
            case 1:
                str7 = "";
                str4 = str4;
                str5 = str5;
                this.f74095a = System.currentTimeMillis();
                this.f74096b = 0L;
                Unit unit2 = Unit.f68710a;
                str6 = str7;
                jCurrentTimeMillis = 0;
                str3 = str6;
                if (str5 != null || TextUtils.isEmpty(str2)) {
                    strA = str7;
                } else {
                    strA = h.a.a("-信息:", str5);
                }
                if (jCurrentTimeMillis > 0) {
                    strA = "-耗时:" + jCurrentTimeMillis + strA;
                }
                if (jCurrentTimeMillis > 0) {
                    pointAnalyseType = target;
                    if (pointAnalyseType == PointAnalyseType.POINT_RENDER_T1) {
                        TmcLogger.b(l.H(strA, "-", "", false, 4, null));
                    }
                } else {
                    pointAnalyseType = target;
                }
                if (str4 != null) {
                    sb2 = new StringBuilder();
                    sb2.append('[');
                    sb2.append(str4);
                    sb2.append("]:");
                } else {
                    sb2 = new StringBuilder();
                }
                sb2.append(target.getDes());
                sb2.append(strA);
                String string = sb2.toString();
                ReportProxy reportProxy = (ReportProxy) tc.a.a(ReportProxy.class);
                data2.putString(PointAnalyseType.class.getSimpleName() + '.' + target.name(), string);
                data = target.getData();
                if (data != null) {
                    Set<Map.Entry<String, Object>> setEntrySet = data.entrySet();
                    Intrinsics.f(setEntrySet, "it.entries");
                    it = setEntrySet.iterator();
                    while (it.hasNext()) {
                        entry = (Map.Entry) it.next();
                        value = entry.getValue();
                        if (value instanceof String) {
                            String str8 = (String) entry.getKey();
                            Object value2 = entry.getValue();
                            Intrinsics.e(value2, "null cannot be cast to non-null type kotlin.String");
                            data2.putString(str8, (String) value2);
                        } else if (value instanceof Long) {
                            String str9 = (String) entry.getKey();
                            Object value3 = entry.getValue();
                            Intrinsics.e(value3, "null cannot be cast to non-null type kotlin.Long");
                            data2.putLong(str9, ((Long) value3).longValue());
                        }
                    }
                    Unit unit3 = Unit.f68710a;
                }
                Unit unit4 = Unit.f68710a;
                reportProxy.report(str4, str3, data2);
                if (jCurrentTimeMillis != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                p.b("TmcPerferenceAnalyse", string, z11);
                com.cloud.tmc.kernel.proxy.performanceanalyse.b.a(pointAnalyseType, string);
                break;
            case 2:
                jCurrentTimeMillis = System.currentTimeMillis() - this.f74095a;
                Unit unit5 = Unit.f68710a;
                str6 = str7;
                str3 = str6;
                if (str5 != null) {
                    strA = str7;
                } else {
                    strA = str7;
                }
                if (jCurrentTimeMillis > 0) {
                    strA = "-耗时:" + jCurrentTimeMillis + strA;
                }
                if (jCurrentTimeMillis > 0) {
                    pointAnalyseType = target;
                    if (pointAnalyseType == PointAnalyseType.POINT_RENDER_T1) {
                        TmcLogger.b(l.H(strA, "-", "", false, 4, null));
                    }
                } else {
                    pointAnalyseType = target;
                }
                if (str4 != null) {
                    sb2 = new StringBuilder();
                    sb2.append('[');
                    sb2.append(str4);
                    sb2.append("]:");
                } else {
                    sb2 = new StringBuilder();
                }
                sb2.append(target.getDes());
                sb2.append(strA);
                String string2 = sb2.toString();
                ReportProxy reportProxy2 = (ReportProxy) tc.a.a(ReportProxy.class);
                data2.putString(PointAnalyseType.class.getSimpleName() + '.' + target.name(), string2);
                data = target.getData();
                if (data != null) {
                    Set<Map.Entry<String, Object>> setEntrySet2 = data.entrySet();
                    Intrinsics.f(setEntrySet2, "it.entries");
                    it = setEntrySet2.iterator();
                    while (it.hasNext()) {
                        entry = (Map.Entry) it.next();
                        value = entry.getValue();
                        if (value instanceof String) {
                            String str10 = (String) entry.getKey();
                            Object value4 = entry.getValue();
                            Intrinsics.e(value4, "null cannot be cast to non-null type kotlin.String");
                            data2.putString(str10, (String) value4);
                        } else if (value instanceof Long) {
                            String str11 = (String) entry.getKey();
                            Object value5 = entry.getValue();
                            Intrinsics.e(value5, "null cannot be cast to non-null type kotlin.Long");
                            data2.putLong(str11, ((Long) value5).longValue());
                        }
                    }
                    Unit unit6 = Unit.f68710a;
                }
                Unit unit7 = Unit.f68710a;
                reportProxy2.report(str4, str3, data2);
                if (jCurrentTimeMillis != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                p.b("TmcPerferenceAnalyse", string2, z11);
                com.cloud.tmc.kernel.proxy.performanceanalyse.b.a(pointAnalyseType, string2);
                break;
            case 3:
                jCurrentTimeMillis = System.currentTimeMillis() - this.f74095a;
                Unit unit8 = Unit.f68710a;
                str6 = str7;
                str3 = str6;
                if (str5 != null) {
                    strA = str7;
                } else {
                    strA = str7;
                }
                if (jCurrentTimeMillis > 0) {
                    strA = "-耗时:" + jCurrentTimeMillis + strA;
                }
                if (jCurrentTimeMillis > 0) {
                    pointAnalyseType = target;
                    if (pointAnalyseType == PointAnalyseType.POINT_RENDER_T1) {
                        TmcLogger.b(l.H(strA, "-", "", false, 4, null));
                    }
                } else {
                    pointAnalyseType = target;
                }
                if (str4 != null) {
                    sb2 = new StringBuilder();
                    sb2.append('[');
                    sb2.append(str4);
                    sb2.append("]:");
                } else {
                    sb2 = new StringBuilder();
                }
                sb2.append(target.getDes());
                sb2.append(strA);
                String string3 = sb2.toString();
                ReportProxy reportProxy3 = (ReportProxy) tc.a.a(ReportProxy.class);
                data2.putString(PointAnalyseType.class.getSimpleName() + '.' + target.name(), string3);
                data = target.getData();
                if (data != null) {
                    Set<Map.Entry<String, Object>> setEntrySet3 = data.entrySet();
                    Intrinsics.f(setEntrySet3, "it.entries");
                    it = setEntrySet3.iterator();
                    while (it.hasNext()) {
                        entry = (Map.Entry) it.next();
                        value = entry.getValue();
                        if (value instanceof String) {
                            String str12 = (String) entry.getKey();
                            Object value6 = entry.getValue();
                            Intrinsics.e(value6, "null cannot be cast to non-null type kotlin.String");
                            data2.putString(str12, (String) value6);
                        } else if (value instanceof Long) {
                            String str13 = (String) entry.getKey();
                            Object value7 = entry.getValue();
                            Intrinsics.e(value7, "null cannot be cast to non-null type kotlin.Long");
                            data2.putLong(str13, ((Long) value7).longValue());
                        }
                    }
                    Unit unit9 = Unit.f68710a;
                }
                Unit unit10 = Unit.f68710a;
                reportProxy3.report(str4, str3, data2);
                if (jCurrentTimeMillis != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                p.b("TmcPerferenceAnalyse", string3, z11);
                com.cloud.tmc.kernel.proxy.performanceanalyse.b.a(pointAnalyseType, string3);
                break;
            case 4:
                str7 = "";
                str4 = str4;
                str5 = str5;
                this.f74097c = true;
                this.f74096b = System.currentTimeMillis();
                Unit unit11 = Unit.f68710a;
                str6 = str7;
                jCurrentTimeMillis = 0;
                str3 = str6;
                if (str5 != null) {
                    strA = str7;
                } else {
                    strA = str7;
                }
                if (jCurrentTimeMillis > 0) {
                    strA = "-耗时:" + jCurrentTimeMillis + strA;
                }
                if (jCurrentTimeMillis > 0) {
                    pointAnalyseType = target;
                    if (pointAnalyseType == PointAnalyseType.POINT_RENDER_T1) {
                        TmcLogger.b(l.H(strA, "-", "", false, 4, null));
                    }
                } else {
                    pointAnalyseType = target;
                }
                if (str4 != null) {
                    sb2 = new StringBuilder();
                    sb2.append('[');
                    sb2.append(str4);
                    sb2.append("]:");
                } else {
                    sb2 = new StringBuilder();
                }
                sb2.append(target.getDes());
                sb2.append(strA);
                String string4 = sb2.toString();
                ReportProxy reportProxy4 = (ReportProxy) tc.a.a(ReportProxy.class);
                data2.putString(PointAnalyseType.class.getSimpleName() + '.' + target.name(), string4);
                data = target.getData();
                if (data != null) {
                    Set<Map.Entry<String, Object>> setEntrySet4 = data.entrySet();
                    Intrinsics.f(setEntrySet4, "it.entries");
                    it = setEntrySet4.iterator();
                    while (it.hasNext()) {
                        entry = (Map.Entry) it.next();
                        value = entry.getValue();
                        if (value instanceof String) {
                            String str14 = (String) entry.getKey();
                            Object value8 = entry.getValue();
                            Intrinsics.e(value8, "null cannot be cast to non-null type kotlin.String");
                            data2.putString(str14, (String) value8);
                        } else if (value instanceof Long) {
                            String str15 = (String) entry.getKey();
                            Object value9 = entry.getValue();
                            Intrinsics.e(value9, "null cannot be cast to non-null type kotlin.Long");
                            data2.putLong(str15, ((Long) value9).longValue());
                        }
                    }
                    Unit unit12 = Unit.f68710a;
                }
                Unit unit13 = Unit.f68710a;
                reportProxy4.report(str4, str3, data2);
                if (jCurrentTimeMillis != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                p.b("TmcPerferenceAnalyse", string4, z11);
                com.cloud.tmc.kernel.proxy.performanceanalyse.b.a(pointAnalyseType, string4);
                break;
            case 5:
                str7 = "";
                str4 = str4;
                str5 = str5;
                if (!this.f74097c) {
                    this.f74096b = System.currentTimeMillis();
                }
                Unit unit14 = Unit.f68710a;
                str6 = str7;
                jCurrentTimeMillis = 0;
                str3 = str6;
                if (str5 != null) {
                    strA = str7;
                } else {
                    strA = str7;
                }
                if (jCurrentTimeMillis > 0) {
                    strA = "-耗时:" + jCurrentTimeMillis + strA;
                }
                if (jCurrentTimeMillis > 0) {
                    pointAnalyseType = target;
                    if (pointAnalyseType == PointAnalyseType.POINT_RENDER_T1) {
                        TmcLogger.b(l.H(strA, "-", "", false, 4, null));
                    }
                } else {
                    pointAnalyseType = target;
                }
                if (str4 != null) {
                    sb2 = new StringBuilder();
                    sb2.append('[');
                    sb2.append(str4);
                    sb2.append("]:");
                } else {
                    sb2 = new StringBuilder();
                }
                sb2.append(target.getDes());
                sb2.append(strA);
                String string5 = sb2.toString();
                ReportProxy reportProxy5 = (ReportProxy) tc.a.a(ReportProxy.class);
                data2.putString(PointAnalyseType.class.getSimpleName() + '.' + target.name(), string5);
                data = target.getData();
                if (data != null) {
                    Set<Map.Entry<String, Object>> setEntrySet5 = data.entrySet();
                    Intrinsics.f(setEntrySet5, "it.entries");
                    it = setEntrySet5.iterator();
                    while (it.hasNext()) {
                        entry = (Map.Entry) it.next();
                        value = entry.getValue();
                        if (value instanceof String) {
                            String str16 = (String) entry.getKey();
                            Object value10 = entry.getValue();
                            Intrinsics.e(value10, "null cannot be cast to non-null type kotlin.String");
                            data2.putString(str16, (String) value10);
                        } else if (value instanceof Long) {
                            String str17 = (String) entry.getKey();
                            Object value11 = entry.getValue();
                            Intrinsics.e(value11, "null cannot be cast to non-null type kotlin.Long");
                            data2.putLong(str17, ((Long) value11).longValue());
                        }
                    }
                    Unit unit15 = Unit.f68710a;
                }
                Unit unit16 = Unit.f68710a;
                reportProxy5.report(str4, str3, data2);
                if (jCurrentTimeMillis != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                p.b("TmcPerferenceAnalyse", string5, z11);
                com.cloud.tmc.kernel.proxy.performanceanalyse.b.a(pointAnalyseType, string5);
                break;
            case 6:
                str7 = "";
                str4 = str4;
                str5 = str5;
                this.f74097c = false;
                if (this.f74096b == 0) {
                    jCurrentTimeMillis2 = System.currentTimeMillis();
                    j11 = this.f74095a;
                } else {
                    jCurrentTimeMillis2 = System.currentTimeMillis();
                    j11 = this.f74096b;
                }
                long j12 = jCurrentTimeMillis2 - j11;
                data2.putString("object_id", "201");
                data2.putString("render_time", String.valueOf(j12));
                Unit unit17 = Unit.f68710a;
                jCurrentTimeMillis = j12;
                str3 = str6;
                if (str5 != null) {
                    strA = str7;
                } else {
                    strA = str7;
                }
                if (jCurrentTimeMillis > 0) {
                    strA = "-耗时:" + jCurrentTimeMillis + strA;
                }
                if (jCurrentTimeMillis > 0) {
                    pointAnalyseType = target;
                    if (pointAnalyseType == PointAnalyseType.POINT_RENDER_T1) {
                        TmcLogger.b(l.H(strA, "-", "", false, 4, null));
                    }
                } else {
                    pointAnalyseType = target;
                }
                if (str4 != null) {
                    sb2 = new StringBuilder();
                    sb2.append('[');
                    sb2.append(str4);
                    sb2.append("]:");
                } else {
                    sb2 = new StringBuilder();
                }
                sb2.append(target.getDes());
                sb2.append(strA);
                String string6 = sb2.toString();
                ReportProxy reportProxy6 = (ReportProxy) tc.a.a(ReportProxy.class);
                data2.putString(PointAnalyseType.class.getSimpleName() + '.' + target.name(), string6);
                data = target.getData();
                if (data != null) {
                    Set<Map.Entry<String, Object>> setEntrySet6 = data.entrySet();
                    Intrinsics.f(setEntrySet6, "it.entries");
                    it = setEntrySet6.iterator();
                    while (it.hasNext()) {
                        entry = (Map.Entry) it.next();
                        value = entry.getValue();
                        if (value instanceof String) {
                            String str18 = (String) entry.getKey();
                            Object value12 = entry.getValue();
                            Intrinsics.e(value12, "null cannot be cast to non-null type kotlin.String");
                            data2.putString(str18, (String) value12);
                        } else if (value instanceof Long) {
                            String str19 = (String) entry.getKey();
                            Object value13 = entry.getValue();
                            Intrinsics.e(value13, "null cannot be cast to non-null type kotlin.Long");
                            data2.putLong(str19, ((Long) value13).longValue());
                        }
                    }
                    Unit unit18 = Unit.f68710a;
                }
                Unit unit19 = Unit.f68710a;
                reportProxy6.report(str4, str3, data2);
                if (jCurrentTimeMillis != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                p.b("TmcPerferenceAnalyse", string6, z11);
                com.cloud.tmc.kernel.proxy.performanceanalyse.b.a(pointAnalyseType, string6);
                break;
            case 7:
                jCurrentTimeMillis3 = System.currentTimeMillis() - this.f74095a;
                Unit unit20 = Unit.f68710a;
                jCurrentTimeMillis = jCurrentTimeMillis3;
                str6 = str7;
                str3 = str6;
                if (str5 != null) {
                    strA = str7;
                } else {
                    strA = str7;
                }
                if (jCurrentTimeMillis > 0) {
                    strA = "-耗时:" + jCurrentTimeMillis + strA;
                }
                if (jCurrentTimeMillis > 0) {
                    pointAnalyseType = target;
                    if (pointAnalyseType == PointAnalyseType.POINT_RENDER_T1) {
                        TmcLogger.b(l.H(strA, "-", "", false, 4, null));
                    }
                } else {
                    pointAnalyseType = target;
                }
                if (str4 != null) {
                    sb2 = new StringBuilder();
                    sb2.append('[');
                    sb2.append(str4);
                    sb2.append("]:");
                } else {
                    sb2 = new StringBuilder();
                }
                sb2.append(target.getDes());
                sb2.append(strA);
                String string7 = sb2.toString();
                ReportProxy reportProxy7 = (ReportProxy) tc.a.a(ReportProxy.class);
                data2.putString(PointAnalyseType.class.getSimpleName() + '.' + target.name(), string7);
                data = target.getData();
                if (data != null) {
                    Set<Map.Entry<String, Object>> setEntrySet7 = data.entrySet();
                    Intrinsics.f(setEntrySet7, "it.entries");
                    it = setEntrySet7.iterator();
                    while (it.hasNext()) {
                        entry = (Map.Entry) it.next();
                        value = entry.getValue();
                        if (value instanceof String) {
                            String str110 = (String) entry.getKey();
                            Object value14 = entry.getValue();
                            Intrinsics.e(value14, "null cannot be cast to non-null type kotlin.String");
                            data2.putString(str110, (String) value14);
                        } else if (value instanceof Long) {
                            String str111 = (String) entry.getKey();
                            Object value15 = entry.getValue();
                            Intrinsics.e(value15, "null cannot be cast to non-null type kotlin.Long");
                            data2.putLong(str111, ((Long) value15).longValue());
                        }
                    }
                    Unit unit110 = Unit.f68710a;
                }
                Unit unit111 = Unit.f68710a;
                reportProxy7.report(str4, str3, data2);
                if (jCurrentTimeMillis != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                p.b("TmcPerferenceAnalyse", string7, z11);
                com.cloud.tmc.kernel.proxy.performanceanalyse.b.a(pointAnalyseType, string7);
                break;
            case 8:
                jCurrentTimeMillis3 = System.currentTimeMillis() - this.f74095a;
                Unit unit21 = Unit.f68710a;
                jCurrentTimeMillis = jCurrentTimeMillis3;
                str6 = str7;
                str3 = str6;
                if (str5 != null) {
                    strA = str7;
                } else {
                    strA = str7;
                }
                if (jCurrentTimeMillis > 0) {
                    strA = "-耗时:" + jCurrentTimeMillis + strA;
                }
                if (jCurrentTimeMillis > 0) {
                    pointAnalyseType = target;
                    if (pointAnalyseType == PointAnalyseType.POINT_RENDER_T1) {
                        TmcLogger.b(l.H(strA, "-", "", false, 4, null));
                    }
                } else {
                    pointAnalyseType = target;
                }
                if (str4 != null) {
                    sb2 = new StringBuilder();
                    sb2.append('[');
                    sb2.append(str4);
                    sb2.append("]:");
                } else {
                    sb2 = new StringBuilder();
                }
                sb2.append(target.getDes());
                sb2.append(strA);
                String string8 = sb2.toString();
                ReportProxy reportProxy8 = (ReportProxy) tc.a.a(ReportProxy.class);
                data2.putString(PointAnalyseType.class.getSimpleName() + '.' + target.name(), string8);
                data = target.getData();
                if (data != null) {
                    Set<Map.Entry<String, Object>> setEntrySet8 = data.entrySet();
                    Intrinsics.f(setEntrySet8, "it.entries");
                    it = setEntrySet8.iterator();
                    while (it.hasNext()) {
                        entry = (Map.Entry) it.next();
                        value = entry.getValue();
                        if (value instanceof String) {
                            String str112 = (String) entry.getKey();
                            Object value16 = entry.getValue();
                            Intrinsics.e(value16, "null cannot be cast to non-null type kotlin.String");
                            data2.putString(str112, (String) value16);
                        } else if (value instanceof Long) {
                            String str113 = (String) entry.getKey();
                            Object value17 = entry.getValue();
                            Intrinsics.e(value17, "null cannot be cast to non-null type kotlin.Long");
                            data2.putLong(str113, ((Long) value17).longValue());
                        }
                    }
                    Unit unit112 = Unit.f68710a;
                }
                Unit unit113 = Unit.f68710a;
                reportProxy8.report(str4, str3, data2);
                if (jCurrentTimeMillis != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                p.b("TmcPerferenceAnalyse", string8, z11);
                com.cloud.tmc.kernel.proxy.performanceanalyse.b.a(pointAnalyseType, string8);
                break;
            case 9:
                str7 = "";
                str4 = str4;
                str5 = str5;
                Unit unit22 = Unit.f68710a;
                str6 = "miniapp_sdkInit";
                jCurrentTimeMillis = 0;
                str3 = str6;
                if (str5 != null) {
                    strA = str7;
                } else {
                    strA = str7;
                }
                if (jCurrentTimeMillis > 0) {
                    strA = "-耗时:" + jCurrentTimeMillis + strA;
                }
                if (jCurrentTimeMillis > 0) {
                    pointAnalyseType = target;
                    if (pointAnalyseType == PointAnalyseType.POINT_RENDER_T1) {
                        TmcLogger.b(l.H(strA, "-", "", false, 4, null));
                    }
                } else {
                    pointAnalyseType = target;
                }
                if (str4 != null) {
                    sb2 = new StringBuilder();
                    sb2.append('[');
                    sb2.append(str4);
                    sb2.append("]:");
                } else {
                    sb2 = new StringBuilder();
                }
                sb2.append(target.getDes());
                sb2.append(strA);
                String string9 = sb2.toString();
                ReportProxy reportProxy9 = (ReportProxy) tc.a.a(ReportProxy.class);
                data2.putString(PointAnalyseType.class.getSimpleName() + '.' + target.name(), string9);
                data = target.getData();
                if (data != null) {
                    Set<Map.Entry<String, Object>> setEntrySet9 = data.entrySet();
                    Intrinsics.f(setEntrySet9, "it.entries");
                    it = setEntrySet9.iterator();
                    while (it.hasNext()) {
                        entry = (Map.Entry) it.next();
                        value = entry.getValue();
                        if (value instanceof String) {
                            String str114 = (String) entry.getKey();
                            Object value18 = entry.getValue();
                            Intrinsics.e(value18, "null cannot be cast to non-null type kotlin.String");
                            data2.putString(str114, (String) value18);
                        } else if (value instanceof Long) {
                            String str115 = (String) entry.getKey();
                            Object value19 = entry.getValue();
                            Intrinsics.e(value19, "null cannot be cast to non-null type kotlin.Long");
                            data2.putLong(str115, ((Long) value19).longValue());
                        }
                    }
                    Unit unit114 = Unit.f68710a;
                }
                Unit unit115 = Unit.f68710a;
                reportProxy9.report(str4, str3, data2);
                if (jCurrentTimeMillis != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                p.b("TmcPerferenceAnalyse", string9, z11);
                com.cloud.tmc.kernel.proxy.performanceanalyse.b.a(pointAnalyseType, string9);
                break;
            case 10:
                str7 = "";
                str4 = str4;
                str5 = str5;
                data2.putString("object_id", "200");
                Unit unit23 = Unit.f68710a;
                jCurrentTimeMillis = 0;
                str3 = str6;
                if (str5 != null) {
                    strA = str7;
                } else {
                    strA = str7;
                }
                if (jCurrentTimeMillis > 0) {
                    strA = "-耗时:" + jCurrentTimeMillis + strA;
                }
                if (jCurrentTimeMillis > 0) {
                    pointAnalyseType = target;
                    if (pointAnalyseType == PointAnalyseType.POINT_RENDER_T1) {
                        TmcLogger.b(l.H(strA, "-", "", false, 4, null));
                    }
                } else {
                    pointAnalyseType = target;
                }
                if (str4 != null) {
                    sb2 = new StringBuilder();
                    sb2.append('[');
                    sb2.append(str4);
                    sb2.append("]:");
                } else {
                    sb2 = new StringBuilder();
                }
                sb2.append(target.getDes());
                sb2.append(strA);
                String string10 = sb2.toString();
                ReportProxy reportProxy10 = (ReportProxy) tc.a.a(ReportProxy.class);
                data2.putString(PointAnalyseType.class.getSimpleName() + '.' + target.name(), string10);
                data = target.getData();
                if (data != null) {
                    Set<Map.Entry<String, Object>> setEntrySet10 = data.entrySet();
                    Intrinsics.f(setEntrySet10, "it.entries");
                    it = setEntrySet10.iterator();
                    while (it.hasNext()) {
                        entry = (Map.Entry) it.next();
                        value = entry.getValue();
                        if (value instanceof String) {
                            String str116 = (String) entry.getKey();
                            Object value110 = entry.getValue();
                            Intrinsics.e(value110, "null cannot be cast to non-null type kotlin.String");
                            data2.putString(str116, (String) value110);
                        } else if (value instanceof Long) {
                            String str117 = (String) entry.getKey();
                            Object value111 = entry.getValue();
                            Intrinsics.e(value111, "null cannot be cast to non-null type kotlin.Long");
                            data2.putLong(str117, ((Long) value111).longValue());
                        }
                    }
                    Unit unit116 = Unit.f68710a;
                }
                Unit unit117 = Unit.f68710a;
                reportProxy10.report(str4, str3, data2);
                if (jCurrentTimeMillis != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                p.b("TmcPerferenceAnalyse", string10, z11);
                com.cloud.tmc.kernel.proxy.performanceanalyse.b.a(pointAnalyseType, string10);
                break;
            case 11:
                data2.putString("object_id", PrepareException.ERROR_MINI_APP_CLOSE);
                Unit unit24 = Unit.f68710a;
                str6 = "miniapp_click";
                jCurrentTimeMillis = 0;
                str3 = str6;
                if (str5 != null) {
                    strA = str7;
                } else {
                    strA = str7;
                }
                if (jCurrentTimeMillis > 0) {
                    strA = "-耗时:" + jCurrentTimeMillis + strA;
                }
                if (jCurrentTimeMillis > 0) {
                    pointAnalyseType = target;
                    if (pointAnalyseType == PointAnalyseType.POINT_RENDER_T1) {
                        TmcLogger.b(l.H(strA, "-", "", false, 4, null));
                    }
                } else {
                    pointAnalyseType = target;
                }
                if (str4 != null) {
                    sb2 = new StringBuilder();
                    sb2.append('[');
                    sb2.append(str4);
                    sb2.append("]:");
                } else {
                    sb2 = new StringBuilder();
                }
                sb2.append(target.getDes());
                sb2.append(strA);
                String string11 = sb2.toString();
                ReportProxy reportProxy11 = (ReportProxy) tc.a.a(ReportProxy.class);
                data2.putString(PointAnalyseType.class.getSimpleName() + '.' + target.name(), string11);
                data = target.getData();
                if (data != null) {
                    Set<Map.Entry<String, Object>> setEntrySet11 = data.entrySet();
                    Intrinsics.f(setEntrySet11, "it.entries");
                    it = setEntrySet11.iterator();
                    while (it.hasNext()) {
                        entry = (Map.Entry) it.next();
                        value = entry.getValue();
                        if (value instanceof String) {
                            String str118 = (String) entry.getKey();
                            Object value112 = entry.getValue();
                            Intrinsics.e(value112, "null cannot be cast to non-null type kotlin.String");
                            data2.putString(str118, (String) value112);
                        } else if (value instanceof Long) {
                            String str119 = (String) entry.getKey();
                            Object value113 = entry.getValue();
                            Intrinsics.e(value113, "null cannot be cast to non-null type kotlin.Long");
                            data2.putLong(str119, ((Long) value113).longValue());
                        }
                    }
                    Unit unit118 = Unit.f68710a;
                }
                Unit unit119 = Unit.f68710a;
                reportProxy11.report(str4, str3, data2);
                if (jCurrentTimeMillis != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                p.b("TmcPerferenceAnalyse", string11, z11);
                com.cloud.tmc.kernel.proxy.performanceanalyse.b.a(pointAnalyseType, string11);
                break;
            case 12:
                data2.putString("object_id", PrepareException.ERROR_MINI_APPID);
                Unit unit25 = Unit.f68710a;
                str6 = "miniapp_click";
                jCurrentTimeMillis = 0;
                str3 = str6;
                if (str5 != null) {
                    strA = str7;
                } else {
                    strA = str7;
                }
                if (jCurrentTimeMillis > 0) {
                    strA = "-耗时:" + jCurrentTimeMillis + strA;
                }
                if (jCurrentTimeMillis > 0) {
                    pointAnalyseType = target;
                    if (pointAnalyseType == PointAnalyseType.POINT_RENDER_T1) {
                        TmcLogger.b(l.H(strA, "-", "", false, 4, null));
                    }
                } else {
                    pointAnalyseType = target;
                }
                if (str4 != null) {
                    sb2 = new StringBuilder();
                    sb2.append('[');
                    sb2.append(str4);
                    sb2.append("]:");
                } else {
                    sb2 = new StringBuilder();
                }
                sb2.append(target.getDes());
                sb2.append(strA);
                String string12 = sb2.toString();
                ReportProxy reportProxy12 = (ReportProxy) tc.a.a(ReportProxy.class);
                data2.putString(PointAnalyseType.class.getSimpleName() + '.' + target.name(), string12);
                data = target.getData();
                if (data != null) {
                    Set<Map.Entry<String, Object>> setEntrySet12 = data.entrySet();
                    Intrinsics.f(setEntrySet12, "it.entries");
                    it = setEntrySet12.iterator();
                    while (it.hasNext()) {
                        entry = (Map.Entry) it.next();
                        value = entry.getValue();
                        if (value instanceof String) {
                            String str1110 = (String) entry.getKey();
                            Object value114 = entry.getValue();
                            Intrinsics.e(value114, "null cannot be cast to non-null type kotlin.String");
                            data2.putString(str1110, (String) value114);
                        } else if (value instanceof Long) {
                            String str1111 = (String) entry.getKey();
                            Object value115 = entry.getValue();
                            Intrinsics.e(value115, "null cannot be cast to non-null type kotlin.Long");
                            data2.putLong(str1111, ((Long) value115).longValue());
                        }
                    }
                    Unit unit1110 = Unit.f68710a;
                }
                Unit unit1111 = Unit.f68710a;
                reportProxy12.report(str4, str3, data2);
                if (jCurrentTimeMillis != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                p.b("TmcPerferenceAnalyse", string12, z11);
                com.cloud.tmc.kernel.proxy.performanceanalyse.b.a(pointAnalyseType, string12);
                break;
            case 13:
                data2.putString("object_id", PrepareException.ERROR_DOWNLOAD_PACKAGE_URL_EMPTY);
                Unit unit26 = Unit.f68710a;
                str6 = "miniapp_click";
                jCurrentTimeMillis = 0;
                str3 = str6;
                if (str5 != null) {
                    strA = str7;
                } else {
                    strA = str7;
                }
                if (jCurrentTimeMillis > 0) {
                    strA = "-耗时:" + jCurrentTimeMillis + strA;
                }
                if (jCurrentTimeMillis > 0) {
                    pointAnalyseType = target;
                    if (pointAnalyseType == PointAnalyseType.POINT_RENDER_T1) {
                        TmcLogger.b(l.H(strA, "-", "", false, 4, null));
                    }
                } else {
                    pointAnalyseType = target;
                }
                if (str4 != null) {
                    sb2 = new StringBuilder();
                    sb2.append('[');
                    sb2.append(str4);
                    sb2.append("]:");
                } else {
                    sb2 = new StringBuilder();
                }
                sb2.append(target.getDes());
                sb2.append(strA);
                String string13 = sb2.toString();
                ReportProxy reportProxy13 = (ReportProxy) tc.a.a(ReportProxy.class);
                data2.putString(PointAnalyseType.class.getSimpleName() + '.' + target.name(), string13);
                data = target.getData();
                if (data != null) {
                    Set<Map.Entry<String, Object>> setEntrySet13 = data.entrySet();
                    Intrinsics.f(setEntrySet13, "it.entries");
                    it = setEntrySet13.iterator();
                    while (it.hasNext()) {
                        entry = (Map.Entry) it.next();
                        value = entry.getValue();
                        if (value instanceof String) {
                            String str1112 = (String) entry.getKey();
                            Object value116 = entry.getValue();
                            Intrinsics.e(value116, "null cannot be cast to non-null type kotlin.String");
                            data2.putString(str1112, (String) value116);
                        } else if (value instanceof Long) {
                            String str1113 = (String) entry.getKey();
                            Object value117 = entry.getValue();
                            Intrinsics.e(value117, "null cannot be cast to non-null type kotlin.Long");
                            data2.putLong(str1113, ((Long) value117).longValue());
                        }
                    }
                    Unit unit1112 = Unit.f68710a;
                }
                Unit unit1113 = Unit.f68710a;
                reportProxy13.report(str4, str3, data2);
                if (jCurrentTimeMillis != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                p.b("TmcPerferenceAnalyse", string13, z11);
                com.cloud.tmc.kernel.proxy.performanceanalyse.b.a(pointAnalyseType, string13);
                break;
            case 14:
                data2.putString("object_id", PrepareException.ERROR_LOCAL_DATA_FILE_SCAN);
                Unit unit27 = Unit.f68710a;
                str6 = "miniapp_click";
                jCurrentTimeMillis = 0;
                str3 = str6;
                if (str5 != null) {
                    strA = str7;
                } else {
                    strA = str7;
                }
                if (jCurrentTimeMillis > 0) {
                    strA = "-耗时:" + jCurrentTimeMillis + strA;
                }
                if (jCurrentTimeMillis > 0) {
                    pointAnalyseType = target;
                    if (pointAnalyseType == PointAnalyseType.POINT_RENDER_T1) {
                        TmcLogger.b(l.H(strA, "-", "", false, 4, null));
                    }
                } else {
                    pointAnalyseType = target;
                }
                if (str4 != null) {
                    sb2 = new StringBuilder();
                    sb2.append('[');
                    sb2.append(str4);
                    sb2.append("]:");
                } else {
                    sb2 = new StringBuilder();
                }
                sb2.append(target.getDes());
                sb2.append(strA);
                String string14 = sb2.toString();
                ReportProxy reportProxy14 = (ReportProxy) tc.a.a(ReportProxy.class);
                data2.putString(PointAnalyseType.class.getSimpleName() + '.' + target.name(), string14);
                data = target.getData();
                if (data != null) {
                    Set<Map.Entry<String, Object>> setEntrySet14 = data.entrySet();
                    Intrinsics.f(setEntrySet14, "it.entries");
                    it = setEntrySet14.iterator();
                    while (it.hasNext()) {
                        entry = (Map.Entry) it.next();
                        value = entry.getValue();
                        if (value instanceof String) {
                            String str1114 = (String) entry.getKey();
                            Object value118 = entry.getValue();
                            Intrinsics.e(value118, "null cannot be cast to non-null type kotlin.String");
                            data2.putString(str1114, (String) value118);
                        } else if (value instanceof Long) {
                            String str1115 = (String) entry.getKey();
                            Object value119 = entry.getValue();
                            Intrinsics.e(value119, "null cannot be cast to non-null type kotlin.Long");
                            data2.putLong(str1115, ((Long) value119).longValue());
                        }
                    }
                    Unit unit1114 = Unit.f68710a;
                }
                Unit unit1115 = Unit.f68710a;
                reportProxy14.report(str4, str3, data2);
                if (jCurrentTimeMillis != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                p.b("TmcPerferenceAnalyse", string14, z11);
                com.cloud.tmc.kernel.proxy.performanceanalyse.b.a(pointAnalyseType, string14);
                break;
            case 15:
                data2.putString("object_id", PrepareException.ERROR_WARMUP_DOWNLOAD_EXCEPTION);
                Unit unit28 = Unit.f68710a;
                str6 = "miniapp_click";
                jCurrentTimeMillis = 0;
                str3 = str6;
                if (str5 != null) {
                    strA = str7;
                } else {
                    strA = str7;
                }
                if (jCurrentTimeMillis > 0) {
                    strA = "-耗时:" + jCurrentTimeMillis + strA;
                }
                if (jCurrentTimeMillis > 0) {
                    pointAnalyseType = target;
                    if (pointAnalyseType == PointAnalyseType.POINT_RENDER_T1) {
                        TmcLogger.b(l.H(strA, "-", "", false, 4, null));
                    }
                } else {
                    pointAnalyseType = target;
                }
                if (str4 != null) {
                    sb2 = new StringBuilder();
                    sb2.append('[');
                    sb2.append(str4);
                    sb2.append("]:");
                } else {
                    sb2 = new StringBuilder();
                }
                sb2.append(target.getDes());
                sb2.append(strA);
                String string15 = sb2.toString();
                ReportProxy reportProxy15 = (ReportProxy) tc.a.a(ReportProxy.class);
                data2.putString(PointAnalyseType.class.getSimpleName() + '.' + target.name(), string15);
                data = target.getData();
                if (data != null) {
                    Set<Map.Entry<String, Object>> setEntrySet15 = data.entrySet();
                    Intrinsics.f(setEntrySet15, "it.entries");
                    it = setEntrySet15.iterator();
                    while (it.hasNext()) {
                        entry = (Map.Entry) it.next();
                        value = entry.getValue();
                        if (value instanceof String) {
                            String str1116 = (String) entry.getKey();
                            Object value1110 = entry.getValue();
                            Intrinsics.e(value1110, "null cannot be cast to non-null type kotlin.String");
                            data2.putString(str1116, (String) value1110);
                        } else if (value instanceof Long) {
                            String str1117 = (String) entry.getKey();
                            Object value1111 = entry.getValue();
                            Intrinsics.e(value1111, "null cannot be cast to non-null type kotlin.Long");
                            data2.putLong(str1117, ((Long) value1111).longValue());
                        }
                    }
                    Unit unit1116 = Unit.f68710a;
                }
                Unit unit1117 = Unit.f68710a;
                reportProxy15.report(str4, str3, data2);
                if (jCurrentTimeMillis != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                p.b("TmcPerferenceAnalyse", string15, z11);
                com.cloud.tmc.kernel.proxy.performanceanalyse.b.a(pointAnalyseType, string15);
                break;
            case 16:
                data2.putString("object_id", PrepareException.ERROR_FILE2VURL_FRAMEWORK_FILE_EXCEPTION);
                Unit unit29 = Unit.f68710a;
                str6 = "miniapp_click";
                jCurrentTimeMillis = 0;
                str3 = str6;
                if (str5 != null) {
                    strA = str7;
                } else {
                    strA = str7;
                }
                if (jCurrentTimeMillis > 0) {
                    strA = "-耗时:" + jCurrentTimeMillis + strA;
                }
                if (jCurrentTimeMillis > 0) {
                    pointAnalyseType = target;
                    if (pointAnalyseType == PointAnalyseType.POINT_RENDER_T1) {
                        TmcLogger.b(l.H(strA, "-", "", false, 4, null));
                    }
                } else {
                    pointAnalyseType = target;
                }
                if (str4 != null) {
                    sb2 = new StringBuilder();
                    sb2.append('[');
                    sb2.append(str4);
                    sb2.append("]:");
                } else {
                    sb2 = new StringBuilder();
                }
                sb2.append(target.getDes());
                sb2.append(strA);
                String string16 = sb2.toString();
                ReportProxy reportProxy16 = (ReportProxy) tc.a.a(ReportProxy.class);
                data2.putString(PointAnalyseType.class.getSimpleName() + '.' + target.name(), string16);
                data = target.getData();
                if (data != null) {
                    Set<Map.Entry<String, Object>> setEntrySet16 = data.entrySet();
                    Intrinsics.f(setEntrySet16, "it.entries");
                    it = setEntrySet16.iterator();
                    while (it.hasNext()) {
                        entry = (Map.Entry) it.next();
                        value = entry.getValue();
                        if (value instanceof String) {
                            String str1118 = (String) entry.getKey();
                            Object value1112 = entry.getValue();
                            Intrinsics.e(value1112, "null cannot be cast to non-null type kotlin.String");
                            data2.putString(str1118, (String) value1112);
                        } else if (value instanceof Long) {
                            String str1119 = (String) entry.getKey();
                            Object value1113 = entry.getValue();
                            Intrinsics.e(value1113, "null cannot be cast to non-null type kotlin.Long");
                            data2.putLong(str1119, ((Long) value1113).longValue());
                        }
                    }
                    Unit unit1118 = Unit.f68710a;
                }
                Unit unit1119 = Unit.f68710a;
                reportProxy16.report(str4, str3, data2);
                if (jCurrentTimeMillis != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                p.b("TmcPerferenceAnalyse", string16, z11);
                com.cloud.tmc.kernel.proxy.performanceanalyse.b.a(pointAnalyseType, string16);
                break;
            case 17:
                data2.putString("object_id", PrepareException.ERROR_FILE2VURL_MINIAPP_FILE_EXCEPTION);
                Unit unit30 = Unit.f68710a;
                str6 = "miniapp_click";
                jCurrentTimeMillis = 0;
                str3 = str6;
                if (str5 != null) {
                    strA = str7;
                } else {
                    strA = str7;
                }
                if (jCurrentTimeMillis > 0) {
                    strA = "-耗时:" + jCurrentTimeMillis + strA;
                }
                if (jCurrentTimeMillis > 0) {
                    pointAnalyseType = target;
                    if (pointAnalyseType == PointAnalyseType.POINT_RENDER_T1) {
                        TmcLogger.b(l.H(strA, "-", "", false, 4, null));
                    }
                } else {
                    pointAnalyseType = target;
                }
                if (str4 != null) {
                    sb2 = new StringBuilder();
                    sb2.append('[');
                    sb2.append(str4);
                    sb2.append("]:");
                } else {
                    sb2 = new StringBuilder();
                }
                sb2.append(target.getDes());
                sb2.append(strA);
                String string17 = sb2.toString();
                ReportProxy reportProxy17 = (ReportProxy) tc.a.a(ReportProxy.class);
                data2.putString(PointAnalyseType.class.getSimpleName() + '.' + target.name(), string17);
                data = target.getData();
                if (data != null) {
                    Set<Map.Entry<String, Object>> setEntrySet17 = data.entrySet();
                    Intrinsics.f(setEntrySet17, "it.entries");
                    it = setEntrySet17.iterator();
                    while (it.hasNext()) {
                        entry = (Map.Entry) it.next();
                        value = entry.getValue();
                        if (value instanceof String) {
                            String str11110 = (String) entry.getKey();
                            Object value1114 = entry.getValue();
                            Intrinsics.e(value1114, "null cannot be cast to non-null type kotlin.String");
                            data2.putString(str11110, (String) value1114);
                        } else if (value instanceof Long) {
                            String str11111 = (String) entry.getKey();
                            Object value1115 = entry.getValue();
                            Intrinsics.e(value1115, "null cannot be cast to non-null type kotlin.Long");
                            data2.putLong(str11111, ((Long) value1115).longValue());
                        }
                    }
                    Unit unit11110 = Unit.f68710a;
                }
                Unit unit11111 = Unit.f68710a;
                reportProxy17.report(str4, str3, data2);
                if (jCurrentTimeMillis != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                p.b("TmcPerferenceAnalyse", string17, z11);
                com.cloud.tmc.kernel.proxy.performanceanalyse.b.a(pointAnalyseType, string17);
                break;
            case 18:
                data2.putString("object_id", "16");
                Unit unit31 = Unit.f68710a;
                str6 = "miniapp_click";
                jCurrentTimeMillis = 0;
                str3 = str6;
                if (str5 != null) {
                    strA = str7;
                } else {
                    strA = str7;
                }
                if (jCurrentTimeMillis > 0) {
                    strA = "-耗时:" + jCurrentTimeMillis + strA;
                }
                if (jCurrentTimeMillis > 0) {
                    pointAnalyseType = target;
                    if (pointAnalyseType == PointAnalyseType.POINT_RENDER_T1) {
                        TmcLogger.b(l.H(strA, "-", "", false, 4, null));
                    }
                } else {
                    pointAnalyseType = target;
                }
                if (str4 != null) {
                    sb2 = new StringBuilder();
                    sb2.append('[');
                    sb2.append(str4);
                    sb2.append("]:");
                } else {
                    sb2 = new StringBuilder();
                }
                sb2.append(target.getDes());
                sb2.append(strA);
                String string18 = sb2.toString();
                ReportProxy reportProxy18 = (ReportProxy) tc.a.a(ReportProxy.class);
                data2.putString(PointAnalyseType.class.getSimpleName() + '.' + target.name(), string18);
                data = target.getData();
                if (data != null) {
                    Set<Map.Entry<String, Object>> setEntrySet18 = data.entrySet();
                    Intrinsics.f(setEntrySet18, "it.entries");
                    it = setEntrySet18.iterator();
                    while (it.hasNext()) {
                        entry = (Map.Entry) it.next();
                        value = entry.getValue();
                        if (value instanceof String) {
                            String str11112 = (String) entry.getKey();
                            Object value1116 = entry.getValue();
                            Intrinsics.e(value1116, "null cannot be cast to non-null type kotlin.String");
                            data2.putString(str11112, (String) value1116);
                        } else if (value instanceof Long) {
                            String str11113 = (String) entry.getKey();
                            Object value1117 = entry.getValue();
                            Intrinsics.e(value1117, "null cannot be cast to non-null type kotlin.Long");
                            data2.putLong(str11113, ((Long) value1117).longValue());
                        }
                    }
                    Unit unit11112 = Unit.f68710a;
                }
                Unit unit11113 = Unit.f68710a;
                reportProxy18.report(str4, str3, data2);
                if (jCurrentTimeMillis != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                p.b("TmcPerferenceAnalyse", string18, z11);
                com.cloud.tmc.kernel.proxy.performanceanalyse.b.a(pointAnalyseType, string18);
                break;
            case 19:
                data2.putString("object_id", "17");
                Unit unit32 = Unit.f68710a;
                str6 = "miniapp_click";
                jCurrentTimeMillis = 0;
                str3 = str6;
                if (str5 != null) {
                    strA = str7;
                } else {
                    strA = str7;
                }
                if (jCurrentTimeMillis > 0) {
                    strA = "-耗时:" + jCurrentTimeMillis + strA;
                }
                if (jCurrentTimeMillis > 0) {
                    pointAnalyseType = target;
                    if (pointAnalyseType == PointAnalyseType.POINT_RENDER_T1) {
                        TmcLogger.b(l.H(strA, "-", "", false, 4, null));
                    }
                } else {
                    pointAnalyseType = target;
                }
                if (str4 != null) {
                    sb2 = new StringBuilder();
                    sb2.append('[');
                    sb2.append(str4);
                    sb2.append("]:");
                } else {
                    sb2 = new StringBuilder();
                }
                sb2.append(target.getDes());
                sb2.append(strA);
                String string19 = sb2.toString();
                ReportProxy reportProxy19 = (ReportProxy) tc.a.a(ReportProxy.class);
                data2.putString(PointAnalyseType.class.getSimpleName() + '.' + target.name(), string19);
                data = target.getData();
                if (data != null) {
                    Set<Map.Entry<String, Object>> setEntrySet19 = data.entrySet();
                    Intrinsics.f(setEntrySet19, "it.entries");
                    it = setEntrySet19.iterator();
                    while (it.hasNext()) {
                        entry = (Map.Entry) it.next();
                        value = entry.getValue();
                        if (value instanceof String) {
                            String str11114 = (String) entry.getKey();
                            Object value1118 = entry.getValue();
                            Intrinsics.e(value1118, "null cannot be cast to non-null type kotlin.String");
                            data2.putString(str11114, (String) value1118);
                        } else if (value instanceof Long) {
                            String str11115 = (String) entry.getKey();
                            Object value1119 = entry.getValue();
                            Intrinsics.e(value1119, "null cannot be cast to non-null type kotlin.Long");
                            data2.putLong(str11115, ((Long) value1119).longValue());
                        }
                    }
                    Unit unit11114 = Unit.f68710a;
                }
                Unit unit11115 = Unit.f68710a;
                reportProxy19.report(str4, str3, data2);
                if (jCurrentTimeMillis != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                p.b("TmcPerferenceAnalyse", string19, z11);
                com.cloud.tmc.kernel.proxy.performanceanalyse.b.a(pointAnalyseType, string19);
                break;
            case 20:
                data2.putString("object_id", "18");
                Unit unit33 = Unit.f68710a;
                str6 = "miniapp_click";
                jCurrentTimeMillis = 0;
                str3 = str6;
                if (str5 != null) {
                    strA = str7;
                } else {
                    strA = str7;
                }
                if (jCurrentTimeMillis > 0) {
                    strA = "-耗时:" + jCurrentTimeMillis + strA;
                }
                if (jCurrentTimeMillis > 0) {
                    pointAnalyseType = target;
                    if (pointAnalyseType == PointAnalyseType.POINT_RENDER_T1) {
                        TmcLogger.b(l.H(strA, "-", "", false, 4, null));
                    }
                } else {
                    pointAnalyseType = target;
                }
                if (str4 != null) {
                    sb2 = new StringBuilder();
                    sb2.append('[');
                    sb2.append(str4);
                    sb2.append("]:");
                } else {
                    sb2 = new StringBuilder();
                }
                sb2.append(target.getDes());
                sb2.append(strA);
                String string110 = sb2.toString();
                ReportProxy reportProxy110 = (ReportProxy) tc.a.a(ReportProxy.class);
                data2.putString(PointAnalyseType.class.getSimpleName() + '.' + target.name(), string110);
                data = target.getData();
                if (data != null) {
                    Set<Map.Entry<String, Object>> setEntrySet110 = data.entrySet();
                    Intrinsics.f(setEntrySet110, "it.entries");
                    it = setEntrySet110.iterator();
                    while (it.hasNext()) {
                        entry = (Map.Entry) it.next();
                        value = entry.getValue();
                        if (value instanceof String) {
                            String str11116 = (String) entry.getKey();
                            Object value11110 = entry.getValue();
                            Intrinsics.e(value11110, "null cannot be cast to non-null type kotlin.String");
                            data2.putString(str11116, (String) value11110);
                        } else if (value instanceof Long) {
                            String str11117 = (String) entry.getKey();
                            Object value11111 = entry.getValue();
                            Intrinsics.e(value11111, "null cannot be cast to non-null type kotlin.Long");
                            data2.putLong(str11117, ((Long) value11111).longValue());
                        }
                    }
                    Unit unit11116 = Unit.f68710a;
                }
                Unit unit11117 = Unit.f68710a;
                reportProxy110.report(str4, str3, data2);
                if (jCurrentTimeMillis != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                p.b("TmcPerferenceAnalyse", string110, z11);
                com.cloud.tmc.kernel.proxy.performanceanalyse.b.a(pointAnalyseType, string110);
                break;
            case 21:
                data2.putString("object_id", "19");
                Unit unit34 = Unit.f68710a;
                str6 = "miniapp_click";
                jCurrentTimeMillis = 0;
                str3 = str6;
                if (str5 != null) {
                    strA = str7;
                } else {
                    strA = str7;
                }
                if (jCurrentTimeMillis > 0) {
                    strA = "-耗时:" + jCurrentTimeMillis + strA;
                }
                if (jCurrentTimeMillis > 0) {
                    pointAnalyseType = target;
                    if (pointAnalyseType == PointAnalyseType.POINT_RENDER_T1) {
                        TmcLogger.b(l.H(strA, "-", "", false, 4, null));
                    }
                } else {
                    pointAnalyseType = target;
                }
                if (str4 != null) {
                    sb2 = new StringBuilder();
                    sb2.append('[');
                    sb2.append(str4);
                    sb2.append("]:");
                } else {
                    sb2 = new StringBuilder();
                }
                sb2.append(target.getDes());
                sb2.append(strA);
                String string111 = sb2.toString();
                ReportProxy reportProxy111 = (ReportProxy) tc.a.a(ReportProxy.class);
                data2.putString(PointAnalyseType.class.getSimpleName() + '.' + target.name(), string111);
                data = target.getData();
                if (data != null) {
                    Set<Map.Entry<String, Object>> setEntrySet111 = data.entrySet();
                    Intrinsics.f(setEntrySet111, "it.entries");
                    it = setEntrySet111.iterator();
                    while (it.hasNext()) {
                        entry = (Map.Entry) it.next();
                        value = entry.getValue();
                        if (value instanceof String) {
                            String str11118 = (String) entry.getKey();
                            Object value11112 = entry.getValue();
                            Intrinsics.e(value11112, "null cannot be cast to non-null type kotlin.String");
                            data2.putString(str11118, (String) value11112);
                        } else if (value instanceof Long) {
                            String str11119 = (String) entry.getKey();
                            Object value11113 = entry.getValue();
                            Intrinsics.e(value11113, "null cannot be cast to non-null type kotlin.Long");
                            data2.putLong(str11119, ((Long) value11113).longValue());
                        }
                    }
                    Unit unit11118 = Unit.f68710a;
                }
                Unit unit11119 = Unit.f68710a;
                reportProxy111.report(str4, str3, data2);
                if (jCurrentTimeMillis != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                p.b("TmcPerferenceAnalyse", string111, z11);
                com.cloud.tmc.kernel.proxy.performanceanalyse.b.a(pointAnalyseType, string111);
                break;
            case 22:
                data2.putString("object_id", "20");
                Unit unit35 = Unit.f68710a;
                str6 = "miniapp_click";
                jCurrentTimeMillis = 0;
                str3 = str6;
                if (str5 != null) {
                    strA = str7;
                } else {
                    strA = str7;
                }
                if (jCurrentTimeMillis > 0) {
                    strA = "-耗时:" + jCurrentTimeMillis + strA;
                }
                if (jCurrentTimeMillis > 0) {
                    pointAnalyseType = target;
                    if (pointAnalyseType == PointAnalyseType.POINT_RENDER_T1) {
                        TmcLogger.b(l.H(strA, "-", "", false, 4, null));
                    }
                } else {
                    pointAnalyseType = target;
                }
                if (str4 != null) {
                    sb2 = new StringBuilder();
                    sb2.append('[');
                    sb2.append(str4);
                    sb2.append("]:");
                } else {
                    sb2 = new StringBuilder();
                }
                sb2.append(target.getDes());
                sb2.append(strA);
                String string112 = sb2.toString();
                ReportProxy reportProxy112 = (ReportProxy) tc.a.a(ReportProxy.class);
                data2.putString(PointAnalyseType.class.getSimpleName() + '.' + target.name(), string112);
                data = target.getData();
                if (data != null) {
                    Set<Map.Entry<String, Object>> setEntrySet112 = data.entrySet();
                    Intrinsics.f(setEntrySet112, "it.entries");
                    it = setEntrySet112.iterator();
                    while (it.hasNext()) {
                        entry = (Map.Entry) it.next();
                        value = entry.getValue();
                        if (value instanceof String) {
                            String str111110 = (String) entry.getKey();
                            Object value11114 = entry.getValue();
                            Intrinsics.e(value11114, "null cannot be cast to non-null type kotlin.String");
                            data2.putString(str111110, (String) value11114);
                        } else if (value instanceof Long) {
                            String str111111 = (String) entry.getKey();
                            Object value11115 = entry.getValue();
                            Intrinsics.e(value11115, "null cannot be cast to non-null type kotlin.Long");
                            data2.putLong(str111111, ((Long) value11115).longValue());
                        }
                    }
                    Unit unit111110 = Unit.f68710a;
                }
                Unit unit111111 = Unit.f68710a;
                reportProxy112.report(str4, str3, data2);
                if (jCurrentTimeMillis != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                p.b("TmcPerferenceAnalyse", string112, z11);
                com.cloud.tmc.kernel.proxy.performanceanalyse.b.a(pointAnalyseType, string112);
                break;
            case 23:
                data2.putString("object_id", "21");
                Unit unit36 = Unit.f68710a;
                str6 = "miniapp_click";
                jCurrentTimeMillis = 0;
                str3 = str6;
                if (str5 != null) {
                    strA = str7;
                } else {
                    strA = str7;
                }
                if (jCurrentTimeMillis > 0) {
                    strA = "-耗时:" + jCurrentTimeMillis + strA;
                }
                if (jCurrentTimeMillis > 0) {
                    pointAnalyseType = target;
                    if (pointAnalyseType == PointAnalyseType.POINT_RENDER_T1) {
                        TmcLogger.b(l.H(strA, "-", "", false, 4, null));
                    }
                } else {
                    pointAnalyseType = target;
                }
                if (str4 != null) {
                    sb2 = new StringBuilder();
                    sb2.append('[');
                    sb2.append(str4);
                    sb2.append("]:");
                } else {
                    sb2 = new StringBuilder();
                }
                sb2.append(target.getDes());
                sb2.append(strA);
                String string113 = sb2.toString();
                ReportProxy reportProxy113 = (ReportProxy) tc.a.a(ReportProxy.class);
                data2.putString(PointAnalyseType.class.getSimpleName() + '.' + target.name(), string113);
                data = target.getData();
                if (data != null) {
                    Set<Map.Entry<String, Object>> setEntrySet113 = data.entrySet();
                    Intrinsics.f(setEntrySet113, "it.entries");
                    it = setEntrySet113.iterator();
                    while (it.hasNext()) {
                        entry = (Map.Entry) it.next();
                        value = entry.getValue();
                        if (value instanceof String) {
                            String str111112 = (String) entry.getKey();
                            Object value11116 = entry.getValue();
                            Intrinsics.e(value11116, "null cannot be cast to non-null type kotlin.String");
                            data2.putString(str111112, (String) value11116);
                        } else if (value instanceof Long) {
                            String str111113 = (String) entry.getKey();
                            Object value11117 = entry.getValue();
                            Intrinsics.e(value11117, "null cannot be cast to non-null type kotlin.Long");
                            data2.putLong(str111113, ((Long) value11117).longValue());
                        }
                    }
                    Unit unit111112 = Unit.f68710a;
                }
                Unit unit111113 = Unit.f68710a;
                reportProxy113.report(str4, str3, data2);
                if (jCurrentTimeMillis != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                p.b("TmcPerferenceAnalyse", string113, z11);
                com.cloud.tmc.kernel.proxy.performanceanalyse.b.a(pointAnalyseType, string113);
                break;
            case 24:
                data2.putString("object_id", "22");
                Unit unit37 = Unit.f68710a;
                str6 = "miniapp_click";
                jCurrentTimeMillis = 0;
                str3 = str6;
                if (str5 != null) {
                    strA = str7;
                } else {
                    strA = str7;
                }
                if (jCurrentTimeMillis > 0) {
                    strA = "-耗时:" + jCurrentTimeMillis + strA;
                }
                if (jCurrentTimeMillis > 0) {
                    pointAnalyseType = target;
                    if (pointAnalyseType == PointAnalyseType.POINT_RENDER_T1) {
                        TmcLogger.b(l.H(strA, "-", "", false, 4, null));
                    }
                } else {
                    pointAnalyseType = target;
                }
                if (str4 != null) {
                    sb2 = new StringBuilder();
                    sb2.append('[');
                    sb2.append(str4);
                    sb2.append("]:");
                } else {
                    sb2 = new StringBuilder();
                }
                sb2.append(target.getDes());
                sb2.append(strA);
                String string114 = sb2.toString();
                ReportProxy reportProxy114 = (ReportProxy) tc.a.a(ReportProxy.class);
                data2.putString(PointAnalyseType.class.getSimpleName() + '.' + target.name(), string114);
                data = target.getData();
                if (data != null) {
                    Set<Map.Entry<String, Object>> setEntrySet114 = data.entrySet();
                    Intrinsics.f(setEntrySet114, "it.entries");
                    it = setEntrySet114.iterator();
                    while (it.hasNext()) {
                        entry = (Map.Entry) it.next();
                        value = entry.getValue();
                        if (value instanceof String) {
                            String str111114 = (String) entry.getKey();
                            Object value11118 = entry.getValue();
                            Intrinsics.e(value11118, "null cannot be cast to non-null type kotlin.String");
                            data2.putString(str111114, (String) value11118);
                        } else if (value instanceof Long) {
                            String str111115 = (String) entry.getKey();
                            Object value11119 = entry.getValue();
                            Intrinsics.e(value11119, "null cannot be cast to non-null type kotlin.Long");
                            data2.putLong(str111115, ((Long) value11119).longValue());
                        }
                    }
                    Unit unit111114 = Unit.f68710a;
                }
                Unit unit111115 = Unit.f68710a;
                reportProxy114.report(str4, str3, data2);
                if (jCurrentTimeMillis != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                p.b("TmcPerferenceAnalyse", string114, z11);
                com.cloud.tmc.kernel.proxy.performanceanalyse.b.a(pointAnalyseType, string114);
                break;
            case 25:
                data2.putString("object_id", "23");
                Unit unit38 = Unit.f68710a;
                str6 = "miniapp_click";
                jCurrentTimeMillis = 0;
                str3 = str6;
                if (str5 != null) {
                    strA = str7;
                } else {
                    strA = str7;
                }
                if (jCurrentTimeMillis > 0) {
                    strA = "-耗时:" + jCurrentTimeMillis + strA;
                }
                if (jCurrentTimeMillis > 0) {
                    pointAnalyseType = target;
                    if (pointAnalyseType == PointAnalyseType.POINT_RENDER_T1) {
                        TmcLogger.b(l.H(strA, "-", "", false, 4, null));
                    }
                } else {
                    pointAnalyseType = target;
                }
                if (str4 != null) {
                    sb2 = new StringBuilder();
                    sb2.append('[');
                    sb2.append(str4);
                    sb2.append("]:");
                } else {
                    sb2 = new StringBuilder();
                }
                sb2.append(target.getDes());
                sb2.append(strA);
                String string115 = sb2.toString();
                ReportProxy reportProxy115 = (ReportProxy) tc.a.a(ReportProxy.class);
                data2.putString(PointAnalyseType.class.getSimpleName() + '.' + target.name(), string115);
                data = target.getData();
                if (data != null) {
                    Set<Map.Entry<String, Object>> setEntrySet115 = data.entrySet();
                    Intrinsics.f(setEntrySet115, "it.entries");
                    it = setEntrySet115.iterator();
                    while (it.hasNext()) {
                        entry = (Map.Entry) it.next();
                        value = entry.getValue();
                        if (value instanceof String) {
                            String str111116 = (String) entry.getKey();
                            Object value111110 = entry.getValue();
                            Intrinsics.e(value111110, "null cannot be cast to non-null type kotlin.String");
                            data2.putString(str111116, (String) value111110);
                        } else if (value instanceof Long) {
                            String str111117 = (String) entry.getKey();
                            Object value111111 = entry.getValue();
                            Intrinsics.e(value111111, "null cannot be cast to non-null type kotlin.Long");
                            data2.putLong(str111117, ((Long) value111111).longValue());
                        }
                    }
                    Unit unit111116 = Unit.f68710a;
                }
                Unit unit111117 = Unit.f68710a;
                reportProxy115.report(str4, str3, data2);
                if (jCurrentTimeMillis != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                p.b("TmcPerferenceAnalyse", string115, z11);
                com.cloud.tmc.kernel.proxy.performanceanalyse.b.a(pointAnalyseType, string115);
                break;
            case 26:
                data2.putString("object_id", "24");
                Unit unit39 = Unit.f68710a;
                str6 = "miniapp_click";
                jCurrentTimeMillis = 0;
                str3 = str6;
                if (str5 != null) {
                    strA = str7;
                } else {
                    strA = str7;
                }
                if (jCurrentTimeMillis > 0) {
                    strA = "-耗时:" + jCurrentTimeMillis + strA;
                }
                if (jCurrentTimeMillis > 0) {
                    pointAnalyseType = target;
                    if (pointAnalyseType == PointAnalyseType.POINT_RENDER_T1) {
                        TmcLogger.b(l.H(strA, "-", "", false, 4, null));
                    }
                } else {
                    pointAnalyseType = target;
                }
                if (str4 != null) {
                    sb2 = new StringBuilder();
                    sb2.append('[');
                    sb2.append(str4);
                    sb2.append("]:");
                } else {
                    sb2 = new StringBuilder();
                }
                sb2.append(target.getDes());
                sb2.append(strA);
                String string116 = sb2.toString();
                ReportProxy reportProxy116 = (ReportProxy) tc.a.a(ReportProxy.class);
                data2.putString(PointAnalyseType.class.getSimpleName() + '.' + target.name(), string116);
                data = target.getData();
                if (data != null) {
                    Set<Map.Entry<String, Object>> setEntrySet116 = data.entrySet();
                    Intrinsics.f(setEntrySet116, "it.entries");
                    it = setEntrySet116.iterator();
                    while (it.hasNext()) {
                        entry = (Map.Entry) it.next();
                        value = entry.getValue();
                        if (value instanceof String) {
                            String str111118 = (String) entry.getKey();
                            Object value111112 = entry.getValue();
                            Intrinsics.e(value111112, "null cannot be cast to non-null type kotlin.String");
                            data2.putString(str111118, (String) value111112);
                        } else if (value instanceof Long) {
                            String str111119 = (String) entry.getKey();
                            Object value111113 = entry.getValue();
                            Intrinsics.e(value111113, "null cannot be cast to non-null type kotlin.Long");
                            data2.putLong(str111119, ((Long) value111113).longValue());
                        }
                    }
                    Unit unit111118 = Unit.f68710a;
                }
                Unit unit111119 = Unit.f68710a;
                reportProxy116.report(str4, str3, data2);
                if (jCurrentTimeMillis != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                p.b("TmcPerferenceAnalyse", string116, z11);
                com.cloud.tmc.kernel.proxy.performanceanalyse.b.a(pointAnalyseType, string116);
                break;
            case 27:
                data2.putString("object_id", "25");
                Unit unit40 = Unit.f68710a;
                str6 = "miniapp_click";
                jCurrentTimeMillis = 0;
                str3 = str6;
                if (str5 != null) {
                    strA = str7;
                } else {
                    strA = str7;
                }
                if (jCurrentTimeMillis > 0) {
                    strA = "-耗时:" + jCurrentTimeMillis + strA;
                }
                if (jCurrentTimeMillis > 0) {
                    pointAnalyseType = target;
                    if (pointAnalyseType == PointAnalyseType.POINT_RENDER_T1) {
                        TmcLogger.b(l.H(strA, "-", "", false, 4, null));
                    }
                } else {
                    pointAnalyseType = target;
                }
                if (str4 != null) {
                    sb2 = new StringBuilder();
                    sb2.append('[');
                    sb2.append(str4);
                    sb2.append("]:");
                } else {
                    sb2 = new StringBuilder();
                }
                sb2.append(target.getDes());
                sb2.append(strA);
                String string117 = sb2.toString();
                ReportProxy reportProxy117 = (ReportProxy) tc.a.a(ReportProxy.class);
                data2.putString(PointAnalyseType.class.getSimpleName() + '.' + target.name(), string117);
                data = target.getData();
                if (data != null) {
                    Set<Map.Entry<String, Object>> setEntrySet117 = data.entrySet();
                    Intrinsics.f(setEntrySet117, "it.entries");
                    it = setEntrySet117.iterator();
                    while (it.hasNext()) {
                        entry = (Map.Entry) it.next();
                        value = entry.getValue();
                        if (value instanceof String) {
                            String str1111110 = (String) entry.getKey();
                            Object value111114 = entry.getValue();
                            Intrinsics.e(value111114, "null cannot be cast to non-null type kotlin.String");
                            data2.putString(str1111110, (String) value111114);
                        } else if (value instanceof Long) {
                            String str1111111 = (String) entry.getKey();
                            Object value111115 = entry.getValue();
                            Intrinsics.e(value111115, "null cannot be cast to non-null type kotlin.Long");
                            data2.putLong(str1111111, ((Long) value111115).longValue());
                        }
                    }
                    Unit unit1111110 = Unit.f68710a;
                }
                Unit unit1111111 = Unit.f68710a;
                reportProxy117.report(str4, str3, data2);
                if (jCurrentTimeMillis != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                p.b("TmcPerferenceAnalyse", string117, z11);
                com.cloud.tmc.kernel.proxy.performanceanalyse.b.a(pointAnalyseType, string117);
                break;
            case 28:
                data2.putString("object_id", "26");
                Unit unit41 = Unit.f68710a;
                str6 = "miniapp_click";
                jCurrentTimeMillis = 0;
                str3 = str6;
                if (str5 != null) {
                    strA = str7;
                } else {
                    strA = str7;
                }
                if (jCurrentTimeMillis > 0) {
                    strA = "-耗时:" + jCurrentTimeMillis + strA;
                }
                if (jCurrentTimeMillis > 0) {
                    pointAnalyseType = target;
                    if (pointAnalyseType == PointAnalyseType.POINT_RENDER_T1) {
                        TmcLogger.b(l.H(strA, "-", "", false, 4, null));
                    }
                } else {
                    pointAnalyseType = target;
                }
                if (str4 != null) {
                    sb2 = new StringBuilder();
                    sb2.append('[');
                    sb2.append(str4);
                    sb2.append("]:");
                } else {
                    sb2 = new StringBuilder();
                }
                sb2.append(target.getDes());
                sb2.append(strA);
                String string118 = sb2.toString();
                ReportProxy reportProxy118 = (ReportProxy) tc.a.a(ReportProxy.class);
                data2.putString(PointAnalyseType.class.getSimpleName() + '.' + target.name(), string118);
                data = target.getData();
                if (data != null) {
                    Set<Map.Entry<String, Object>> setEntrySet118 = data.entrySet();
                    Intrinsics.f(setEntrySet118, "it.entries");
                    it = setEntrySet118.iterator();
                    while (it.hasNext()) {
                        entry = (Map.Entry) it.next();
                        value = entry.getValue();
                        if (value instanceof String) {
                            String str1111112 = (String) entry.getKey();
                            Object value111116 = entry.getValue();
                            Intrinsics.e(value111116, "null cannot be cast to non-null type kotlin.String");
                            data2.putString(str1111112, (String) value111116);
                        } else if (value instanceof Long) {
                            String str1111113 = (String) entry.getKey();
                            Object value111117 = entry.getValue();
                            Intrinsics.e(value111117, "null cannot be cast to non-null type kotlin.Long");
                            data2.putLong(str1111113, ((Long) value111117).longValue());
                        }
                    }
                    Unit unit1111112 = Unit.f68710a;
                }
                Unit unit1111113 = Unit.f68710a;
                reportProxy118.report(str4, str3, data2);
                if (jCurrentTimeMillis != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                p.b("TmcPerferenceAnalyse", string118, z11);
                com.cloud.tmc.kernel.proxy.performanceanalyse.b.a(pointAnalyseType, string118);
                break;
            case VungleException.INCORRECT_DEFAULT_API_USAGE /* 29 */:
                str7 = "";
                str4 = str4;
                str5 = str5;
                data2.putString("object_id", "2");
                data2.putString(NotificationCompat.CATEGORY_STATUS, "0");
                Unit unit42 = Unit.f68710a;
                str6 = "miniapp_start";
                jCurrentTimeMillis = 0;
                str3 = str6;
                if (str5 != null) {
                    strA = str7;
                } else {
                    strA = str7;
                }
                if (jCurrentTimeMillis > 0) {
                    strA = "-耗时:" + jCurrentTimeMillis + strA;
                }
                if (jCurrentTimeMillis > 0) {
                    pointAnalyseType = target;
                    if (pointAnalyseType == PointAnalyseType.POINT_RENDER_T1) {
                        TmcLogger.b(l.H(strA, "-", "", false, 4, null));
                    }
                } else {
                    pointAnalyseType = target;
                }
                if (str4 != null) {
                    sb2 = new StringBuilder();
                    sb2.append('[');
                    sb2.append(str4);
                    sb2.append("]:");
                } else {
                    sb2 = new StringBuilder();
                }
                sb2.append(target.getDes());
                sb2.append(strA);
                String string119 = sb2.toString();
                ReportProxy reportProxy119 = (ReportProxy) tc.a.a(ReportProxy.class);
                data2.putString(PointAnalyseType.class.getSimpleName() + '.' + target.name(), string119);
                data = target.getData();
                if (data != null) {
                    Set<Map.Entry<String, Object>> setEntrySet119 = data.entrySet();
                    Intrinsics.f(setEntrySet119, "it.entries");
                    it = setEntrySet119.iterator();
                    while (it.hasNext()) {
                        entry = (Map.Entry) it.next();
                        value = entry.getValue();
                        if (value instanceof String) {
                            String str1111114 = (String) entry.getKey();
                            Object value111118 = entry.getValue();
                            Intrinsics.e(value111118, "null cannot be cast to non-null type kotlin.String");
                            data2.putString(str1111114, (String) value111118);
                        } else if (value instanceof Long) {
                            String str1111115 = (String) entry.getKey();
                            Object value111119 = entry.getValue();
                            Intrinsics.e(value111119, "null cannot be cast to non-null type kotlin.Long");
                            data2.putLong(str1111115, ((Long) value111119).longValue());
                        }
                    }
                    Unit unit1111114 = Unit.f68710a;
                }
                Unit unit1111115 = Unit.f68710a;
                reportProxy119.report(str4, str3, data2);
                if (jCurrentTimeMillis != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                p.b("TmcPerferenceAnalyse", string119, z11);
                com.cloud.tmc.kernel.proxy.performanceanalyse.b.a(pointAnalyseType, string119);
                break;
            case 30:
                str7 = "";
                str4 = str4;
                str5 = str5;
                data2.putString("object_id", "2");
                data2.putString(NotificationCompat.CATEGORY_STATUS, "3");
                Unit unit43 = Unit.f68710a;
                str6 = "miniapp_start";
                jCurrentTimeMillis = 0;
                str3 = str6;
                if (str5 != null) {
                    strA = str7;
                } else {
                    strA = str7;
                }
                if (jCurrentTimeMillis > 0) {
                    strA = "-耗时:" + jCurrentTimeMillis + strA;
                }
                if (jCurrentTimeMillis > 0) {
                    pointAnalyseType = target;
                    if (pointAnalyseType == PointAnalyseType.POINT_RENDER_T1) {
                        TmcLogger.b(l.H(strA, "-", "", false, 4, null));
                    }
                } else {
                    pointAnalyseType = target;
                }
                if (str4 != null) {
                    sb2 = new StringBuilder();
                    sb2.append('[');
                    sb2.append(str4);
                    sb2.append("]:");
                } else {
                    sb2 = new StringBuilder();
                }
                sb2.append(target.getDes());
                sb2.append(strA);
                String string1110 = sb2.toString();
                ReportProxy reportProxy1110 = (ReportProxy) tc.a.a(ReportProxy.class);
                data2.putString(PointAnalyseType.class.getSimpleName() + '.' + target.name(), string1110);
                data = target.getData();
                if (data != null) {
                    Set<Map.Entry<String, Object>> setEntrySet1110 = data.entrySet();
                    Intrinsics.f(setEntrySet1110, "it.entries");
                    it = setEntrySet1110.iterator();
                    while (it.hasNext()) {
                        entry = (Map.Entry) it.next();
                        value = entry.getValue();
                        if (value instanceof String) {
                            String str1111116 = (String) entry.getKey();
                            Object value1111110 = entry.getValue();
                            Intrinsics.e(value1111110, "null cannot be cast to non-null type kotlin.String");
                            data2.putString(str1111116, (String) value1111110);
                        } else if (value instanceof Long) {
                            String str1111117 = (String) entry.getKey();
                            Object value1111111 = entry.getValue();
                            Intrinsics.e(value1111111, "null cannot be cast to non-null type kotlin.Long");
                            data2.putLong(str1111117, ((Long) value1111111).longValue());
                        }
                    }
                    Unit unit1111116 = Unit.f68710a;
                }
                Unit unit1111117 = Unit.f68710a;
                reportProxy1110.report(str4, str3, data2);
                if (jCurrentTimeMillis != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                p.b("TmcPerferenceAnalyse", string1110, z11);
                com.cloud.tmc.kernel.proxy.performanceanalyse.b.a(pointAnalyseType, string1110);
                break;
            case VungleException.WEB_CRASH /* 31 */:
                str7 = "";
                str4 = str4;
                str5 = str5;
                data2.putString("object_id", StatisticData.ERROR_CODE_NOT_FOUND);
                data2.putString(NotificationCompat.CATEGORY_STATUS, "0");
                Unit unit44 = Unit.f68710a;
                str6 = "miniapp_download";
                jCurrentTimeMillis = 0;
                str3 = str6;
                if (str5 != null) {
                    strA = str7;
                } else {
                    strA = str7;
                }
                if (jCurrentTimeMillis > 0) {
                    strA = "-耗时:" + jCurrentTimeMillis + strA;
                }
                if (jCurrentTimeMillis > 0) {
                    pointAnalyseType = target;
                    if (pointAnalyseType == PointAnalyseType.POINT_RENDER_T1) {
                        TmcLogger.b(l.H(strA, "-", "", false, 4, null));
                    }
                } else {
                    pointAnalyseType = target;
                }
                if (str4 != null) {
                    sb2 = new StringBuilder();
                    sb2.append('[');
                    sb2.append(str4);
                    sb2.append("]:");
                } else {
                    sb2 = new StringBuilder();
                }
                sb2.append(target.getDes());
                sb2.append(strA);
                String string1111 = sb2.toString();
                ReportProxy reportProxy1111 = (ReportProxy) tc.a.a(ReportProxy.class);
                data2.putString(PointAnalyseType.class.getSimpleName() + '.' + target.name(), string1111);
                data = target.getData();
                if (data != null) {
                    Set<Map.Entry<String, Object>> setEntrySet1111 = data.entrySet();
                    Intrinsics.f(setEntrySet1111, "it.entries");
                    it = setEntrySet1111.iterator();
                    while (it.hasNext()) {
                        entry = (Map.Entry) it.next();
                        value = entry.getValue();
                        if (value instanceof String) {
                            String str1111118 = (String) entry.getKey();
                            Object value1111112 = entry.getValue();
                            Intrinsics.e(value1111112, "null cannot be cast to non-null type kotlin.String");
                            data2.putString(str1111118, (String) value1111112);
                        } else if (value instanceof Long) {
                            String str1111119 = (String) entry.getKey();
                            Object value1111113 = entry.getValue();
                            Intrinsics.e(value1111113, "null cannot be cast to non-null type kotlin.Long");
                            data2.putLong(str1111119, ((Long) value1111113).longValue());
                        }
                    }
                    Unit unit1111118 = Unit.f68710a;
                }
                Unit unit1111119 = Unit.f68710a;
                reportProxy1111.report(str4, str3, data2);
                if (jCurrentTimeMillis != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                p.b("TmcPerferenceAnalyse", string1111, z11);
                com.cloud.tmc.kernel.proxy.performanceanalyse.b.a(pointAnalyseType, string1111);
                break;
            case 32:
                str7 = "";
                str4 = str4;
                str5 = str5;
                data2.putString("object_id", StatisticData.ERROR_CODE_NOT_FOUND);
                data2.putString(NotificationCompat.CATEGORY_STATUS, "2");
                Unit unit45 = Unit.f68710a;
                str6 = "miniapp_download";
                jCurrentTimeMillis = 0;
                str3 = str6;
                if (str5 != null) {
                    strA = str7;
                } else {
                    strA = str7;
                }
                if (jCurrentTimeMillis > 0) {
                    strA = "-耗时:" + jCurrentTimeMillis + strA;
                }
                if (jCurrentTimeMillis > 0) {
                    pointAnalyseType = target;
                    if (pointAnalyseType == PointAnalyseType.POINT_RENDER_T1) {
                        TmcLogger.b(l.H(strA, "-", "", false, 4, null));
                    }
                } else {
                    pointAnalyseType = target;
                }
                if (str4 != null) {
                    sb2 = new StringBuilder();
                    sb2.append('[');
                    sb2.append(str4);
                    sb2.append("]:");
                } else {
                    sb2 = new StringBuilder();
                }
                sb2.append(target.getDes());
                sb2.append(strA);
                String string1112 = sb2.toString();
                ReportProxy reportProxy1112 = (ReportProxy) tc.a.a(ReportProxy.class);
                data2.putString(PointAnalyseType.class.getSimpleName() + '.' + target.name(), string1112);
                data = target.getData();
                if (data != null) {
                    Set<Map.Entry<String, Object>> setEntrySet1112 = data.entrySet();
                    Intrinsics.f(setEntrySet1112, "it.entries");
                    it = setEntrySet1112.iterator();
                    while (it.hasNext()) {
                        entry = (Map.Entry) it.next();
                        value = entry.getValue();
                        if (value instanceof String) {
                            String str11111110 = (String) entry.getKey();
                            Object value1111114 = entry.getValue();
                            Intrinsics.e(value1111114, "null cannot be cast to non-null type kotlin.String");
                            data2.putString(str11111110, (String) value1111114);
                        } else if (value instanceof Long) {
                            String str11111111 = (String) entry.getKey();
                            Object value1111115 = entry.getValue();
                            Intrinsics.e(value1111115, "null cannot be cast to non-null type kotlin.Long");
                            data2.putLong(str11111111, ((Long) value1111115).longValue());
                        }
                    }
                    Unit unit11111110 = Unit.f68710a;
                }
                Unit unit11111111 = Unit.f68710a;
                reportProxy1112.report(str4, str3, data2);
                if (jCurrentTimeMillis != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                p.b("TmcPerferenceAnalyse", string1112, z11);
                com.cloud.tmc.kernel.proxy.performanceanalyse.b.a(pointAnalyseType, string1112);
                break;
            case 33:
                str7 = "";
                str4 = str4;
                str5 = str5;
                data2.putString("object_id", StatisticData.ERROR_CODE_NOT_FOUND);
                data2.putString(NotificationCompat.CATEGORY_STATUS, "1");
                Unit unit46 = Unit.f68710a;
                str6 = "miniapp_download";
                jCurrentTimeMillis = 0;
                str3 = str6;
                if (str5 != null) {
                    strA = str7;
                } else {
                    strA = str7;
                }
                if (jCurrentTimeMillis > 0) {
                    strA = "-耗时:" + jCurrentTimeMillis + strA;
                }
                if (jCurrentTimeMillis > 0) {
                    pointAnalyseType = target;
                    if (pointAnalyseType == PointAnalyseType.POINT_RENDER_T1) {
                        TmcLogger.b(l.H(strA, "-", "", false, 4, null));
                    }
                } else {
                    pointAnalyseType = target;
                }
                if (str4 != null) {
                    sb2 = new StringBuilder();
                    sb2.append('[');
                    sb2.append(str4);
                    sb2.append("]:");
                } else {
                    sb2 = new StringBuilder();
                }
                sb2.append(target.getDes());
                sb2.append(strA);
                String string1113 = sb2.toString();
                ReportProxy reportProxy1113 = (ReportProxy) tc.a.a(ReportProxy.class);
                data2.putString(PointAnalyseType.class.getSimpleName() + '.' + target.name(), string1113);
                data = target.getData();
                if (data != null) {
                    Set<Map.Entry<String, Object>> setEntrySet1113 = data.entrySet();
                    Intrinsics.f(setEntrySet1113, "it.entries");
                    it = setEntrySet1113.iterator();
                    while (it.hasNext()) {
                        entry = (Map.Entry) it.next();
                        value = entry.getValue();
                        if (value instanceof String) {
                            String str11111112 = (String) entry.getKey();
                            Object value1111116 = entry.getValue();
                            Intrinsics.e(value1111116, "null cannot be cast to non-null type kotlin.String");
                            data2.putString(str11111112, (String) value1111116);
                        } else if (value instanceof Long) {
                            String str11111113 = (String) entry.getKey();
                            Object value1111117 = entry.getValue();
                            Intrinsics.e(value1111117, "null cannot be cast to non-null type kotlin.Long");
                            data2.putLong(str11111113, ((Long) value1111117).longValue());
                        }
                    }
                    Unit unit11111112 = Unit.f68710a;
                }
                Unit unit11111113 = Unit.f68710a;
                reportProxy1113.report(str4, str3, data2);
                if (jCurrentTimeMillis != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                p.b("TmcPerferenceAnalyse", string1113, z11);
                com.cloud.tmc.kernel.proxy.performanceanalyse.b.a(pointAnalyseType, string1113);
                break;
            case 34:
                str7 = "";
                str4 = str4;
                str5 = str5;
                data2.putString("object_id", "202");
                Unit unit47 = Unit.f68710a;
                jCurrentTimeMillis = 0;
                str3 = str6;
                if (str5 != null) {
                    strA = str7;
                } else {
                    strA = str7;
                }
                if (jCurrentTimeMillis > 0) {
                    strA = "-耗时:" + jCurrentTimeMillis + strA;
                }
                if (jCurrentTimeMillis > 0) {
                    pointAnalyseType = target;
                    if (pointAnalyseType == PointAnalyseType.POINT_RENDER_T1) {
                        TmcLogger.b(l.H(strA, "-", "", false, 4, null));
                    }
                } else {
                    pointAnalyseType = target;
                }
                if (str4 != null) {
                    sb2 = new StringBuilder();
                    sb2.append('[');
                    sb2.append(str4);
                    sb2.append("]:");
                } else {
                    sb2 = new StringBuilder();
                }
                sb2.append(target.getDes());
                sb2.append(strA);
                String string1114 = sb2.toString();
                ReportProxy reportProxy1114 = (ReportProxy) tc.a.a(ReportProxy.class);
                data2.putString(PointAnalyseType.class.getSimpleName() + '.' + target.name(), string1114);
                data = target.getData();
                if (data != null) {
                    Set<Map.Entry<String, Object>> setEntrySet1114 = data.entrySet();
                    Intrinsics.f(setEntrySet1114, "it.entries");
                    it = setEntrySet1114.iterator();
                    while (it.hasNext()) {
                        entry = (Map.Entry) it.next();
                        value = entry.getValue();
                        if (value instanceof String) {
                            String str11111114 = (String) entry.getKey();
                            Object value1111118 = entry.getValue();
                            Intrinsics.e(value1111118, "null cannot be cast to non-null type kotlin.String");
                            data2.putString(str11111114, (String) value1111118);
                        } else if (value instanceof Long) {
                            String str11111115 = (String) entry.getKey();
                            Object value1111119 = entry.getValue();
                            Intrinsics.e(value1111119, "null cannot be cast to non-null type kotlin.Long");
                            data2.putLong(str11111115, ((Long) value1111119).longValue());
                        }
                    }
                    Unit unit11111114 = Unit.f68710a;
                }
                Unit unit11111115 = Unit.f68710a;
                reportProxy1114.report(str4, str3, data2);
                if (jCurrentTimeMillis != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                p.b("TmcPerferenceAnalyse", string1114, z11);
                com.cloud.tmc.kernel.proxy.performanceanalyse.b.a(pointAnalyseType, string1114);
                break;
            case 35:
                str7 = "";
                str4 = str4;
                str5 = str5;
                data2.putString("object_id", "600");
                Unit unit48 = Unit.f68710a;
                str6 = "miniapp_fps";
                jCurrentTimeMillis = 0;
                str3 = str6;
                if (str5 != null) {
                    strA = str7;
                } else {
                    strA = str7;
                }
                if (jCurrentTimeMillis > 0) {
                    strA = "-耗时:" + jCurrentTimeMillis + strA;
                }
                if (jCurrentTimeMillis > 0) {
                    pointAnalyseType = target;
                    if (pointAnalyseType == PointAnalyseType.POINT_RENDER_T1) {
                        TmcLogger.b(l.H(strA, "-", "", false, 4, null));
                    }
                } else {
                    pointAnalyseType = target;
                }
                if (str4 != null) {
                    sb2 = new StringBuilder();
                    sb2.append('[');
                    sb2.append(str4);
                    sb2.append("]:");
                } else {
                    sb2 = new StringBuilder();
                }
                sb2.append(target.getDes());
                sb2.append(strA);
                String string1115 = sb2.toString();
                ReportProxy reportProxy1115 = (ReportProxy) tc.a.a(ReportProxy.class);
                data2.putString(PointAnalyseType.class.getSimpleName() + '.' + target.name(), string1115);
                data = target.getData();
                if (data != null) {
                    Set<Map.Entry<String, Object>> setEntrySet1115 = data.entrySet();
                    Intrinsics.f(setEntrySet1115, "it.entries");
                    it = setEntrySet1115.iterator();
                    while (it.hasNext()) {
                        entry = (Map.Entry) it.next();
                        value = entry.getValue();
                        if (value instanceof String) {
                            String str11111116 = (String) entry.getKey();
                            Object value11111110 = entry.getValue();
                            Intrinsics.e(value11111110, "null cannot be cast to non-null type kotlin.String");
                            data2.putString(str11111116, (String) value11111110);
                        } else if (value instanceof Long) {
                            String str11111117 = (String) entry.getKey();
                            Object value11111111 = entry.getValue();
                            Intrinsics.e(value11111111, "null cannot be cast to non-null type kotlin.Long");
                            data2.putLong(str11111117, ((Long) value11111111).longValue());
                        }
                    }
                    Unit unit11111116 = Unit.f68710a;
                }
                Unit unit11111117 = Unit.f68710a;
                reportProxy1115.report(str4, str3, data2);
                if (jCurrentTimeMillis != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                p.b("TmcPerferenceAnalyse", string1115, z11);
                com.cloud.tmc.kernel.proxy.performanceanalyse.b.a(pointAnalyseType, string1115);
                break;
            case 36:
                if (str5 != null) {
                    e(str5, data2);
                    Unit unit49 = Unit.f68710a;
                }
                break;
            case 37:
                str5 = str5;
                if (str5 == null) {
                    str4 = str;
                    str7 = "";
                    str3 = str7;
                    jCurrentTimeMillis = 0;
                    if (str5 != null) {
                        strA = str7;
                    } else {
                        strA = str7;
                    }
                    if (jCurrentTimeMillis > 0) {
                        strA = "-耗时:" + jCurrentTimeMillis + strA;
                    }
                    if (jCurrentTimeMillis > 0) {
                        pointAnalyseType = target;
                        if (pointAnalyseType == PointAnalyseType.POINT_RENDER_T1) {
                            TmcLogger.b(l.H(strA, "-", "", false, 4, null));
                        }
                    } else {
                        pointAnalyseType = target;
                    }
                    if (str4 != null) {
                        sb2 = new StringBuilder();
                        sb2.append('[');
                        sb2.append(str4);
                        sb2.append("]:");
                    } else {
                        sb2 = new StringBuilder();
                    }
                    sb2.append(target.getDes());
                    sb2.append(strA);
                    String string1116 = sb2.toString();
                    ReportProxy reportProxy1116 = (ReportProxy) tc.a.a(ReportProxy.class);
                    data2.putString(PointAnalyseType.class.getSimpleName() + '.' + target.name(), string1116);
                    data = target.getData();
                    if (data != null) {
                        Set<Map.Entry<String, Object>> setEntrySet1116 = data.entrySet();
                        Intrinsics.f(setEntrySet1116, "it.entries");
                        it = setEntrySet1116.iterator();
                        while (it.hasNext()) {
                            entry = (Map.Entry) it.next();
                            value = entry.getValue();
                            if (value instanceof String) {
                                String str11111118 = (String) entry.getKey();
                                Object value11111112 = entry.getValue();
                                Intrinsics.e(value11111112, "null cannot be cast to non-null type kotlin.String");
                                data2.putString(str11111118, (String) value11111112);
                            } else if (value instanceof Long) {
                                String str11111119 = (String) entry.getKey();
                                Object value11111113 = entry.getValue();
                                Intrinsics.e(value11111113, "null cannot be cast to non-null type kotlin.Long");
                                data2.putLong(str11111119, ((Long) value11111113).longValue());
                            }
                        }
                        Unit unit11111118 = Unit.f68710a;
                    }
                    Unit unit11111119 = Unit.f68710a;
                    reportProxy1116.report(str4, str3, data2);
                    if (jCurrentTimeMillis != 0) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    p.b("TmcPerferenceAnalyse", string1116, z11);
                    com.cloud.tmc.kernel.proxy.performanceanalyse.b.a(pointAnalyseType, string1116);
                } else {
                    try {
                        String string20 = data2.getString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.L, "");
                        String appId = data2.getString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.M, "");
                        String pagePath = data2.getString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.N, "");
                        String string21 = data2.getString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.O, "");
                        TmcLogger.c("oldChain", "chainEnd -> msg:" + str5 + ", type:" + string20 + ", pagePath:" + pagePath + ", reportPagePath:" + string21);
                        String reportPagePath = TextUtils.isEmpty(string21) ? pagePath : string21;
                        if (Intrinsics.b(MBridgeConstans.DYNAMIC_VIEW_WX_APP, string20)) {
                            q.b bVar19 = this.f74098d.get(appId);
                            if (bVar19 != null && (mapD2 = bVar19.d()) != null && mapD2.containsKey(str5) && (bVar18 = this.f74098d.get(appId)) != null && (mapB6 = bVar18.b()) != null) {
                                long jCurrentTimeMillis4 = System.currentTimeMillis();
                                q.b bVar20 = this.f74098d.get(appId);
                                mapB6.put(str5, Long.valueOf(jCurrentTimeMillis4 - ((bVar20 == null || (mapD3 = bVar20.d()) == null || (l13 = mapD3.get(str5)) == null) ? 0L : l13.longValue())));
                            }
                        } else if (Intrinsics.b("page", string20)) {
                            q.b bVar21 = this.f74098d.get(appId);
                            if (bVar21 != null && (mapK2 = bVar21.k()) != null && (fVar2 = mapK2.get(pagePath)) != null && (mapB3 = fVar2.b()) != null && mapB3.containsKey(str5) && (bVar3 = this.f74098d.get(appId)) != null && (mapK3 = bVar3.k()) != null && (fVar3 = mapK3.get(pagePath)) != null && (mapA = fVar3.a()) != null) {
                                long jCurrentTimeMillis5 = System.currentTimeMillis();
                                q.b bVar22 = this.f74098d.get(appId);
                                mapA.put(str5, Long.valueOf(jCurrentTimeMillis5 - ((bVar22 == null || (mapK4 = bVar22.k()) == null || (fVar4 = mapK4.get(pagePath)) == null || (mapB4 = fVar4.b()) == null || (l12 = mapB4.get(str5)) == null) ? 0L : l12.longValue())));
                            }
                            q.b bVar23 = this.f74098d.get(appId);
                            if (Intrinsics.b(pagePath, bVar23 != null ? bVar23.g() : null) && (bVar = this.f74098d.get(appId)) != null && (mapD = bVar.d()) != null && mapD.containsKey(str5) && (bVar2 = this.f74098d.get(appId)) != null && (mapB = bVar2.b()) != null) {
                                long jCurrentTimeMillis6 = System.currentTimeMillis();
                                q.b bVar24 = this.f74098d.get(appId);
                                mapB.put(str5, Long.valueOf(jCurrentTimeMillis6 - ((bVar24 == null || (mapK = bVar24.k()) == null || (fVar = mapK.get(pagePath)) == null || (mapB2 = fVar.b()) == null || (l11 = mapB2.get(str5)) == null) ? 0L : l11.longValue())));
                            }
                        }
                        if (Intrinsics.b(str5, com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31229q)) {
                            q.b bVar25 = this.f74098d.get(appId);
                            if (Intrinsics.b(pagePath, bVar25 != null ? bVar25.g() : null)) {
                                str7 = "";
                                if (Intrinsics.b(str5, com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31230r)) {
                                    bVar4 = this.f74098d.get(appId);
                                    if (bVar4 != null) {
                                        strG = bVar4.g();
                                    } else {
                                        strG = null;
                                    }
                                    if (Intrinsics.b(pagePath, strG)) {
                                        bVar5 = this.f74098d.get(appId);
                                        if (bVar5 == null) {
                                        }
                                        TmcLogger.c("oldChain", "reportApp -> msg:" + str5 + ", type:" + string20 + ", pagePath:" + pagePath + ", reportPagePath:" + reportPagePath);
                                        d(str);
                                        str4 = str;
                                        c(data2, str4);
                                        a();
                                        data2.putString("object_id", "300");
                                        bVar6 = this.f74098d.get(appId);
                                        if (bVar6 != null) {
                                            for (Map.Entry<String, Long> entry2 : mapB5.entrySet()) {
                                                data2.putLong("chain_id_" + entry2.getKey(), entry2.getValue().longValue());
                                            }
                                            Unit unit50 = Unit.f68710a;
                                        }
                                        data2.putString("page_path", reportPagePath);
                                        if (str4 != null) {
                                            appFindApp = ((AppManager) tc.a.a(AppManager.class)).findApp(str4);
                                            if (appFindApp != null) {
                                                context = null;
                                            } else {
                                                context = null;
                                            }
                                            if (context instanceof BaseActivity) {
                                                baseActivity = (BaseActivity) context;
                                            } else {
                                                baseActivity = null;
                                            }
                                            if (baseActivity != null) {
                                                boolValueOf = Boolean.valueOf(baseActivity.getMStarted());
                                            } else {
                                                boolValueOf = null;
                                            }
                                            data2.putString("isForeground", String.valueOf(boolValueOf));
                                            Unit unit51 = Unit.f68710a;
                                        }
                                        data2.putString("app_launcher_status", "true");
                                        bVar7 = this.f74098d.get(appId);
                                        if (bVar7 != null) {
                                            zA = bVar7.a();
                                        } else {
                                            zA = false;
                                        }
                                        data2.putBoolean("offScreenRender", zA);
                                        bVar8 = this.f74098d.get(appId);
                                        if (bVar8 != null) {
                                            iF = bVar8.f();
                                        } else {
                                            iF = -1;
                                        }
                                        data2.putInt("downloadFrameworkMode", iF);
                                        bVar9 = this.f74098d.get(appId);
                                        if (bVar9 != null) {
                                            iE = bVar9.e();
                                        } else {
                                            iE = -1;
                                        }
                                        data2.putInt("downloadAppMode", iE);
                                        bVar10 = this.f74098d.get(appId);
                                        if (bVar10 != null) {
                                            iM = bVar10.m();
                                        } else {
                                            iM = -1;
                                        }
                                        data2.putInt("zipFrameworkMode", iM);
                                        bVar11 = this.f74098d.get(appId);
                                        if (bVar11 != null) {
                                            iL = bVar11.l();
                                        } else {
                                            iL = -1;
                                        }
                                        data2.putInt("zipAppMode", iL);
                                        bVar12 = this.f74098d.get(appId);
                                        if (bVar12 != null) {
                                            strH = str7;
                                        } else {
                                            strH = str7;
                                        }
                                        data2.putString("appH5ProgressStatus", strH);
                                        bVar13 = this.f74098d.get(appId);
                                        if (bVar13 != null) {
                                            strO = str7;
                                        } else {
                                            strO = str7;
                                        }
                                        data2.putString("appDomContentLoadedStatus", strO);
                                        String str20 = "chain_id_" + com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31231s;
                                        ICommunicationTimeProxy iCommunicationTimeProxy = (ICommunicationTimeProxy) tc.a.a(ICommunicationTimeProxy.class);
                                        bVar14 = this.f74098d.get(appId);
                                        if (bVar14 != null) {
                                            strF = null;
                                        } else {
                                            strF = null;
                                        }
                                        data2.putLong(str20, iCommunicationTimeProxy.getTotalTime(strF));
                                        String str21 = "chain_id_" + com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31232t;
                                        ICommunicationTimeProxy iCommunicationTimeProxy2 = (ICommunicationTimeProxy) tc.a.a(ICommunicationTimeProxy.class);
                                        bVar15 = this.f74098d.get(appId);
                                        if (bVar15 != null) {
                                            strF2 = null;
                                        } else {
                                            strF2 = null;
                                        }
                                        data2.putInt(str21, iCommunicationTimeProxy2.getTotalNum(strF2));
                                        bVar16 = this.f74098d.get(appId);
                                        if (bVar16 != null) {
                                            strD = fVar5.d();
                                        }
                                        data2.putString("navigationType", strD);
                                        bVar17 = this.f74098d.get(appId);
                                        if (bVar17 == null) {
                                            bVar17.c(true);
                                        }
                                    }
                                }
                            } else {
                                Intrinsics.f(appId, "appId");
                                Intrinsics.f(pagePath, "pagePath");
                                Intrinsics.f(reportPagePath, "reportPagePath");
                                str7 = "";
                                g(appId, pagePath, data2, str, reportPagePath);
                            }
                            str4 = str;
                        } else {
                            str7 = "";
                            if (Intrinsics.b(str5, com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31230r)) {
                                bVar4 = this.f74098d.get(appId);
                                if (bVar4 != null) {
                                    strG = bVar4.g();
                                } else {
                                    strG = null;
                                }
                                if (Intrinsics.b(pagePath, strG)) {
                                    bVar5 = this.f74098d.get(appId);
                                    if (bVar5 == null && bVar5.n()) {
                                        Intrinsics.f(appId, "appId");
                                        Intrinsics.f(pagePath, "pagePath");
                                        Intrinsics.f(reportPagePath, "reportPagePath");
                                        g(appId, pagePath, data2, str, reportPagePath);
                                        str4 = str;
                                    } else {
                                        TmcLogger.c("oldChain", "reportApp -> msg:" + str5 + ", type:" + string20 + ", pagePath:" + pagePath + ", reportPagePath:" + reportPagePath);
                                        d(str);
                                        str4 = str;
                                        c(data2, str4);
                                        a();
                                        data2.putString("object_id", "300");
                                        bVar6 = this.f74098d.get(appId);
                                        if (bVar6 != null && (mapB5 = bVar6.b()) != null) {
                                            while (r1.hasNext()) {
                                                data2.putLong("chain_id_" + entry2.getKey(), entry2.getValue().longValue());
                                            }
                                            Unit unit52 = Unit.f68710a;
                                        }
                                        data2.putString("page_path", reportPagePath);
                                        if (str4 != null) {
                                            appFindApp = ((AppManager) tc.a.a(AppManager.class)).findApp(str4);
                                            if (appFindApp != null || (appContext = appFindApp.getAppContext()) == null) {
                                                context = null;
                                            } else {
                                                context = appContext.getContext();
                                            }
                                            if (context instanceof BaseActivity) {
                                                baseActivity = (BaseActivity) context;
                                            } else {
                                                baseActivity = null;
                                            }
                                            if (baseActivity != null) {
                                                boolValueOf = Boolean.valueOf(baseActivity.getMStarted());
                                            } else {
                                                boolValueOf = null;
                                            }
                                            data2.putString("isForeground", String.valueOf(boolValueOf));
                                            Unit unit53 = Unit.f68710a;
                                        }
                                        data2.putString("app_launcher_status", "true");
                                        bVar7 = this.f74098d.get(appId);
                                        if (bVar7 != null) {
                                            zA = bVar7.a();
                                        } else {
                                            zA = false;
                                        }
                                        data2.putBoolean("offScreenRender", zA);
                                        bVar8 = this.f74098d.get(appId);
                                        if (bVar8 != null) {
                                            iF = bVar8.f();
                                        } else {
                                            iF = -1;
                                        }
                                        data2.putInt("downloadFrameworkMode", iF);
                                        bVar9 = this.f74098d.get(appId);
                                        if (bVar9 != null) {
                                            iE = bVar9.e();
                                        } else {
                                            iE = -1;
                                        }
                                        data2.putInt("downloadAppMode", iE);
                                        bVar10 = this.f74098d.get(appId);
                                        if (bVar10 != null) {
                                            iM = bVar10.m();
                                        } else {
                                            iM = -1;
                                        }
                                        data2.putInt("zipFrameworkMode", iM);
                                        bVar11 = this.f74098d.get(appId);
                                        if (bVar11 != null) {
                                            iL = bVar11.l();
                                        } else {
                                            iL = -1;
                                        }
                                        data2.putInt("zipAppMode", iL);
                                        bVar12 = this.f74098d.get(appId);
                                        if (bVar12 != null || (strH = bVar12.h()) == null) {
                                            strH = str7;
                                        }
                                        data2.putString("appH5ProgressStatus", strH);
                                        bVar13 = this.f74098d.get(appId);
                                        if (bVar13 != null || (strO = bVar13.o()) == null) {
                                            strO = str7;
                                        }
                                        data2.putString("appDomContentLoadedStatus", strO);
                                        String str22 = "chain_id_" + com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31231s;
                                        ICommunicationTimeProxy iCommunicationTimeProxy3 = (ICommunicationTimeProxy) tc.a.a(ICommunicationTimeProxy.class);
                                        bVar14 = this.f74098d.get(appId);
                                        if (bVar14 != null || (mapK7 = bVar14.k()) == null || (fVar7 = mapK7.get(pagePath)) == null) {
                                            strF = null;
                                        } else {
                                            strF = fVar7.f();
                                        }
                                        data2.putLong(str22, iCommunicationTimeProxy3.getTotalTime(strF));
                                        String str23 = "chain_id_" + com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31232t;
                                        ICommunicationTimeProxy iCommunicationTimeProxy4 = (ICommunicationTimeProxy) tc.a.a(ICommunicationTimeProxy.class);
                                        bVar15 = this.f74098d.get(appId);
                                        if (bVar15 != null || (mapK6 = bVar15.k()) == null || (fVar6 = mapK6.get(pagePath)) == null) {
                                            strF2 = null;
                                        } else {
                                            strF2 = fVar6.f();
                                        }
                                        data2.putInt(str23, iCommunicationTimeProxy4.getTotalNum(strF2));
                                        bVar16 = this.f74098d.get(appId);
                                        if (bVar16 != null && (mapK5 = bVar16.k()) != null && (fVar5 = mapK5.get(pagePath)) != null) {
                                            strD = fVar5.d();
                                        }
                                        data2.putString("navigationType", strD);
                                        bVar17 = this.f74098d.get(appId);
                                        if (bVar17 == null) {
                                            bVar17.c(true);
                                        }
                                    }
                                }
                            }
                        }
                        data2.remove(com.cloud.tmc.kernel.proxy.performanceanalyse.a.L);
                        data2.remove(com.cloud.tmc.kernel.proxy.performanceanalyse.a.M);
                        data2.remove(com.cloud.tmc.kernel.proxy.performanceanalyse.a.N);
                        Unit unit54 = Unit.f68710a;
                        str6 = "miniapp_time";
                        jCurrentTimeMillis = 0;
                        str3 = str6;
                        if (str5 != null) {
                            strA = str7;
                        } else {
                            strA = str7;
                        }
                        if (jCurrentTimeMillis > 0) {
                            strA = "-耗时:" + jCurrentTimeMillis + strA;
                        }
                        if (jCurrentTimeMillis > 0) {
                            pointAnalyseType = target;
                            if (pointAnalyseType == PointAnalyseType.POINT_RENDER_T1) {
                                TmcLogger.b(l.H(strA, "-", "", false, 4, null));
                            }
                        } else {
                            pointAnalyseType = target;
                        }
                        if (str4 != null) {
                            sb2 = new StringBuilder();
                            sb2.append('[');
                            sb2.append(str4);
                            sb2.append("]:");
                        } else {
                            sb2 = new StringBuilder();
                        }
                        sb2.append(target.getDes());
                        sb2.append(strA);
                        String string1117 = sb2.toString();
                        ReportProxy reportProxy1117 = (ReportProxy) tc.a.a(ReportProxy.class);
                        data2.putString(PointAnalyseType.class.getSimpleName() + '.' + target.name(), string1117);
                        data = target.getData();
                        if (data != null) {
                            Set<Map.Entry<String, Object>> setEntrySet1117 = data.entrySet();
                            Intrinsics.f(setEntrySet1117, "it.entries");
                            it = setEntrySet1117.iterator();
                            while (it.hasNext()) {
                                entry = (Map.Entry) it.next();
                                value = entry.getValue();
                                if (value instanceof String) {
                                    String str111111110 = (String) entry.getKey();
                                    Object value11111114 = entry.getValue();
                                    Intrinsics.e(value11111114, "null cannot be cast to non-null type kotlin.String");
                                    data2.putString(str111111110, (String) value11111114);
                                } else if (value instanceof Long) {
                                    String str111111111 = (String) entry.getKey();
                                    Object value11111115 = entry.getValue();
                                    Intrinsics.e(value11111115, "null cannot be cast to non-null type kotlin.Long");
                                    data2.putLong(str111111111, ((Long) value11111115).longValue());
                                }
                            }
                            Unit unit111111110 = Unit.f68710a;
                        }
                        Unit unit111111111 = Unit.f68710a;
                        reportProxy1117.report(str4, str3, data2);
                        if (jCurrentTimeMillis != 0) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        p.b("TmcPerferenceAnalyse", string1117, z11);
                        com.cloud.tmc.kernel.proxy.performanceanalyse.b.a(pointAnalyseType, string1117);
                    } catch (Throwable unused) {
                        return;
                    }
                }
                break;
            case 38:
                h(data2);
                Unit unit55 = Unit.f68710a;
                str4 = str;
                str5 = str2;
                str7 = "";
                str6 = str7;
                jCurrentTimeMillis = 0;
                str3 = str6;
                if (str5 != null) {
                    strA = str7;
                } else {
                    strA = str7;
                }
                if (jCurrentTimeMillis > 0) {
                    strA = "-耗时:" + jCurrentTimeMillis + strA;
                }
                if (jCurrentTimeMillis > 0) {
                    pointAnalyseType = target;
                    if (pointAnalyseType == PointAnalyseType.POINT_RENDER_T1) {
                        TmcLogger.b(l.H(strA, "-", "", false, 4, null));
                    }
                } else {
                    pointAnalyseType = target;
                }
                if (str4 != null) {
                    sb2 = new StringBuilder();
                    sb2.append('[');
                    sb2.append(str4);
                    sb2.append("]:");
                } else {
                    sb2 = new StringBuilder();
                }
                sb2.append(target.getDes());
                sb2.append(strA);
                String string1118 = sb2.toString();
                ReportProxy reportProxy1118 = (ReportProxy) tc.a.a(ReportProxy.class);
                data2.putString(PointAnalyseType.class.getSimpleName() + '.' + target.name(), string1118);
                data = target.getData();
                if (data != null) {
                    Set<Map.Entry<String, Object>> setEntrySet1118 = data.entrySet();
                    Intrinsics.f(setEntrySet1118, "it.entries");
                    it = setEntrySet1118.iterator();
                    while (it.hasNext()) {
                        entry = (Map.Entry) it.next();
                        value = entry.getValue();
                        if (value instanceof String) {
                            String str111111112 = (String) entry.getKey();
                            Object value11111116 = entry.getValue();
                            Intrinsics.e(value11111116, "null cannot be cast to non-null type kotlin.String");
                            data2.putString(str111111112, (String) value11111116);
                        } else if (value instanceof Long) {
                            String str111111113 = (String) entry.getKey();
                            Object value11111117 = entry.getValue();
                            Intrinsics.e(value11111117, "null cannot be cast to non-null type kotlin.Long");
                            data2.putLong(str111111113, ((Long) value11111117).longValue());
                        }
                    }
                    Unit unit111111112 = Unit.f68710a;
                }
                Unit unit111111113 = Unit.f68710a;
                reportProxy1118.report(str4, str3, data2);
                if (jCurrentTimeMillis != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                p.b("TmcPerferenceAnalyse", string1118, z11);
                com.cloud.tmc.kernel.proxy.performanceanalyse.b.a(pointAnalyseType, string1118);
                break;
            case 39:
                if (str5 == null) {
                    str4 = str;
                    str5 = str2;
                    str7 = "";
                    str3 = "miniapp_exposure";
                    jCurrentTimeMillis = 0;
                    if (str5 != null) {
                        strA = str7;
                    } else {
                        strA = str7;
                    }
                    if (jCurrentTimeMillis > 0) {
                        strA = "-耗时:" + jCurrentTimeMillis + strA;
                    }
                    if (jCurrentTimeMillis > 0) {
                        pointAnalyseType = target;
                        if (pointAnalyseType == PointAnalyseType.POINT_RENDER_T1) {
                            TmcLogger.b(l.H(strA, "-", "", false, 4, null));
                        }
                    } else {
                        pointAnalyseType = target;
                    }
                    if (str4 != null) {
                        sb2 = new StringBuilder();
                        sb2.append('[');
                        sb2.append(str4);
                        sb2.append("]:");
                    } else {
                        sb2 = new StringBuilder();
                    }
                    sb2.append(target.getDes());
                    sb2.append(strA);
                    String string1119 = sb2.toString();
                    ReportProxy reportProxy1119 = (ReportProxy) tc.a.a(ReportProxy.class);
                    data2.putString(PointAnalyseType.class.getSimpleName() + '.' + target.name(), string1119);
                    data = target.getData();
                    if (data != null) {
                        Set<Map.Entry<String, Object>> setEntrySet1119 = data.entrySet();
                        Intrinsics.f(setEntrySet1119, "it.entries");
                        it = setEntrySet1119.iterator();
                        while (it.hasNext()) {
                            entry = (Map.Entry) it.next();
                            value = entry.getValue();
                            if (value instanceof String) {
                                String str111111114 = (String) entry.getKey();
                                Object value11111118 = entry.getValue();
                                Intrinsics.e(value11111118, "null cannot be cast to non-null type kotlin.String");
                                data2.putString(str111111114, (String) value11111118);
                            } else if (value instanceof Long) {
                                String str111111115 = (String) entry.getKey();
                                Object value11111119 = entry.getValue();
                                Intrinsics.e(value11111119, "null cannot be cast to non-null type kotlin.Long");
                                data2.putLong(str111111115, ((Long) value11111119).longValue());
                            }
                        }
                        Unit unit111111114 = Unit.f68710a;
                    }
                    Unit unit111111115 = Unit.f68710a;
                    reportProxy1119.report(str4, str3, data2);
                    if (jCurrentTimeMillis != 0) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    p.b("TmcPerferenceAnalyse", string1119, z11);
                    com.cloud.tmc.kernel.proxy.performanceanalyse.b.a(pointAnalyseType, string1119);
                } else {
                    try {
                        String string22 = data2.getString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.L, "");
                        String string23 = data2.getString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.M, "");
                        String string24 = data2.getString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.N, "");
                        String string25 = data2.getString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.O, "");
                        TmcLogger.c("oldChain", "chainClear -> msg:" + str5 + ", type:" + string22 + ", pagePath:" + string24 + ", reportPagePath:" + string25);
                        if (TextUtils.isEmpty(string25)) {
                            string25 = string24;
                        }
                        if (Intrinsics.b(string22, MBridgeConstans.DYNAMIC_VIEW_WX_APP)) {
                            q.b bVar26 = this.f74098d.get(string23);
                            Map<String, Long> mapD4 = bVar26 != null ? bVar26.d() : null;
                            q.b bVar27 = this.f74098d.get(string23);
                            Map<String, Long> mapB7 = bVar27 != null ? bVar27.b() : null;
                            q.b bVar28 = this.f74098d.get(string23);
                            String strG2 = bVar28 != null ? bVar28.g() : null;
                            if (mapD4 != null && mapD4.containsKey(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31230r) && mapB7 != null && mapB7.containsKey(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31230r)) {
                                ICommunicationTimeProxy iCommunicationTimeProxy5 = (ICommunicationTimeProxy) tc.a.a(ICommunicationTimeProxy.class);
                                q.b bVar29 = this.f74098d.get(string23);
                                if (bVar29 != null && (mapK17 = bVar29.k()) != null && (fVar14 = mapK17.get(strG2)) != null) {
                                    strD = fVar14.f();
                                }
                                iCommunicationTimeProxy5.clear(strD);
                                this.f74098d.remove(string23);
                            } else {
                                data2.putString("object_id", "203");
                                data2.putString("page_path", string25);
                                data2.putString("app_launcher_status", "false");
                                try {
                                    data2.putString("app_launcher_fail_reason", new Gson().toJson(s.j(TuplesKt.a("chainStartData", mapD4), TuplesKt.a("chainEndData", mapB7))).toString());
                                    break;
                                } catch (Throwable unused2) {
                                }
                                q.b bVar30 = this.f74098d.get(string23);
                                data2.putInt("downloadFrameworkMode", bVar30 != null ? bVar30.f() : -1);
                                q.b bVar31 = this.f74098d.get(string23);
                                data2.putInt("downloadAppMode", bVar31 != null ? bVar31.e() : -1);
                                q.b bVar32 = this.f74098d.get(string23);
                                data2.putInt("zipFrameworkMode", bVar32 != null ? bVar32.m() : -1);
                                q.b bVar33 = this.f74098d.get(string23);
                                data2.putInt("zipAppMode", bVar33 != null ? bVar33.l() : -1);
                                q.b bVar34 = this.f74098d.get(string23);
                                if (bVar34 == null || (strH2 = bVar34.h()) == null) {
                                    strH2 = "";
                                }
                                data2.putString("appH5ProgressStatus", strH2);
                                q.b bVar35 = this.f74098d.get(string23);
                                if (bVar35 == null || (strO2 = bVar35.o()) == null) {
                                    strO2 = "";
                                }
                                data2.putString("appDomContentLoadedStatus", strO2);
                                q.b bVar36 = this.f74098d.get(string23);
                                data2.putBoolean("offScreenRender", bVar36 != null ? bVar36.a() : false);
                                if (!data2.containsKey("pageRandomId")) {
                                    q.b bVar37 = this.f74098d.get(string23);
                                    data2.putString("pageRandomId", bVar37 != null ? bVar37.i() : null);
                                }
                                q.b bVar38 = this.f74098d.get(string23);
                                data2.putString("navigationType", bVar38 != null ? bVar38.j() : null);
                                this.f74098d.remove(string23);
                            }
                            break;
                        } else if (Intrinsics.b(string22, "page")) {
                            q.b bVar39 = this.f74098d.get(string23);
                            if (!Intrinsics.b(string24, bVar39 != null ? bVar39.g() : null)) {
                                q.b bVar40 = this.f74098d.get(string23);
                                Map<String, Long> mapB8 = (bVar40 == null || (mapK15 = bVar40.k()) == null || (fVar13 = mapK15.get(string24)) == null) ? null : fVar13.b();
                                q.b bVar41 = this.f74098d.get(string23);
                                Map<String, Long> mapA2 = (bVar41 == null || (mapK14 = bVar41.k()) == null || (fVar12 = mapK14.get(string24)) == null) ? null : fVar12.a();
                                if (mapB8 != null && mapB8.containsKey(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31229q) && mapA2 != null && mapA2.containsKey(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31229q)) {
                                    ICommunicationTimeProxy iCommunicationTimeProxy6 = (ICommunicationTimeProxy) tc.a.a(ICommunicationTimeProxy.class);
                                    q.b bVar42 = this.f74098d.get(string23);
                                    if (bVar42 != null && (mapK13 = bVar42.k()) != null && (fVar11 = mapK13.get(string24)) != null) {
                                        strD = fVar11.f();
                                    }
                                    iCommunicationTimeProxy6.clear(strD);
                                    q.b bVar43 = this.f74098d.get(string23);
                                    if (bVar43 != null && (mapK12 = bVar43.k()) != null) {
                                        mapK12.remove(string24);
                                        break;
                                    }
                                } else {
                                    data2.putString("object_id", "204");
                                    data2.putString("page_path", string25);
                                    data2.putString("open_page_status", "false");
                                    try {
                                        data2.putString("open_page_fail_reason", new Gson().toJson(s.j(TuplesKt.a("chainStartData", mapB8), TuplesKt.a("chainEndData", mapA2))).toString());
                                        break;
                                    } catch (Throwable unused3) {
                                    }
                                    q.b bVar44 = this.f74098d.get(string23);
                                    data2.putInt("downloadFrameworkMode", bVar44 != null ? bVar44.f() : -1);
                                    q.b bVar45 = this.f74098d.get(string23);
                                    if (bVar45 == null || (mapK11 = bVar45.k()) == null || (fVar10 = mapK11.get(string24)) == null || (strC = fVar10.c()) == null) {
                                        strC = "";
                                    }
                                    data2.putString("pageH5ProgressStatus", strC);
                                    q.b bVar46 = this.f74098d.get(string23);
                                    if (bVar46 == null || (mapK10 = bVar46.k()) == null || (fVar9 = mapK10.get(string24)) == null || (strE = fVar9.e()) == null) {
                                        strE = "";
                                    }
                                    data2.putString("pageDomContentLoadedStatus", strE);
                                    q.b bVar47 = this.f74098d.get(string23);
                                    data2.putInt("downloadAppMode", bVar47 != null ? bVar47.e() : -1);
                                    q.b bVar48 = this.f74098d.get(string23);
                                    data2.putInt("zipFrameworkMode", bVar48 != null ? bVar48.m() : -1);
                                    q.b bVar49 = this.f74098d.get(string23);
                                    data2.putInt("zipAppMode", bVar49 != null ? bVar49.l() : -1);
                                    q.b bVar50 = this.f74098d.get(string23);
                                    if (bVar50 != null && (mapK9 = bVar50.k()) != null && (fVar8 = mapK9.get(string24)) != null) {
                                        strD = fVar8.d();
                                    }
                                    data2.putString("navigationType", strD);
                                    q.b bVar51 = this.f74098d.get(string23);
                                    if (bVar51 != null && (mapK8 = bVar51.k()) != null) {
                                        mapK8.remove(string24);
                                    }
                                }
                            } else {
                                q.b bVar52 = this.f74098d.get(string23);
                                if (bVar52 != null && (mapK16 = bVar52.k()) != null) {
                                    mapK16.remove(string24);
                                    break;
                                }
                            }
                        }
                        data2.remove(com.cloud.tmc.kernel.proxy.performanceanalyse.a.L);
                        data2.remove(com.cloud.tmc.kernel.proxy.performanceanalyse.a.M);
                        data2.remove(com.cloud.tmc.kernel.proxy.performanceanalyse.a.N);
                        Unit unit56 = Unit.f68710a;
                        str4 = str;
                        str5 = str2;
                        str7 = "";
                        jCurrentTimeMillis = 0;
                        str3 = str6;
                        if (str5 != null) {
                            strA = str7;
                        } else {
                            strA = str7;
                        }
                        if (jCurrentTimeMillis > 0) {
                            strA = "-耗时:" + jCurrentTimeMillis + strA;
                        }
                        if (jCurrentTimeMillis > 0) {
                            pointAnalyseType = target;
                            if (pointAnalyseType == PointAnalyseType.POINT_RENDER_T1) {
                                TmcLogger.b(l.H(strA, "-", "", false, 4, null));
                            }
                        } else {
                            pointAnalyseType = target;
                        }
                        if (str4 != null) {
                            sb2 = new StringBuilder();
                            sb2.append('[');
                            sb2.append(str4);
                            sb2.append("]:");
                        } else {
                            sb2 = new StringBuilder();
                        }
                        sb2.append(target.getDes());
                        sb2.append(strA);
                        String string11110 = sb2.toString();
                        ReportProxy reportProxy11110 = (ReportProxy) tc.a.a(ReportProxy.class);
                        data2.putString(PointAnalyseType.class.getSimpleName() + '.' + target.name(), string11110);
                        data = target.getData();
                        if (data != null) {
                            Set<Map.Entry<String, Object>> setEntrySet11110 = data.entrySet();
                            Intrinsics.f(setEntrySet11110, "it.entries");
                            it = setEntrySet11110.iterator();
                            while (it.hasNext()) {
                                entry = (Map.Entry) it.next();
                                value = entry.getValue();
                                if (value instanceof String) {
                                    String str111111116 = (String) entry.getKey();
                                    Object value111111110 = entry.getValue();
                                    Intrinsics.e(value111111110, "null cannot be cast to non-null type kotlin.String");
                                    data2.putString(str111111116, (String) value111111110);
                                } else if (value instanceof Long) {
                                    String str111111117 = (String) entry.getKey();
                                    Object value111111111 = entry.getValue();
                                    Intrinsics.e(value111111111, "null cannot be cast to non-null type kotlin.Long");
                                    data2.putLong(str111111117, ((Long) value111111111).longValue());
                                }
                            }
                            Unit unit111111116 = Unit.f68710a;
                        }
                        Unit unit111111117 = Unit.f68710a;
                        reportProxy11110.report(str4, str3, data2);
                        if (jCurrentTimeMillis != 0) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        p.b("TmcPerferenceAnalyse", string11110, z11);
                        com.cloud.tmc.kernel.proxy.performanceanalyse.b.a(pointAnalyseType, string11110);
                    } catch (Throwable unused4) {
                        return;
                    }
                }
                break;
            case 40:
                b(data2);
                Unit unit57 = Unit.f68710a;
                str6 = "mini_h5_onPageFinished";
                str7 = "";
                str4 = str4;
                str5 = str5;
                jCurrentTimeMillis = 0;
                str3 = str6;
                if (str5 != null) {
                    strA = str7;
                } else {
                    strA = str7;
                }
                if (jCurrentTimeMillis > 0) {
                    strA = "-耗时:" + jCurrentTimeMillis + strA;
                }
                if (jCurrentTimeMillis > 0) {
                    pointAnalyseType = target;
                    if (pointAnalyseType == PointAnalyseType.POINT_RENDER_T1) {
                        TmcLogger.b(l.H(strA, "-", "", false, 4, null));
                    }
                } else {
                    pointAnalyseType = target;
                }
                if (str4 != null) {
                    sb2 = new StringBuilder();
                    sb2.append('[');
                    sb2.append(str4);
                    sb2.append("]:");
                } else {
                    sb2 = new StringBuilder();
                }
                sb2.append(target.getDes());
                sb2.append(strA);
                String string11111 = sb2.toString();
                ReportProxy reportProxy11111 = (ReportProxy) tc.a.a(ReportProxy.class);
                data2.putString(PointAnalyseType.class.getSimpleName() + '.' + target.name(), string11111);
                data = target.getData();
                if (data != null) {
                    Set<Map.Entry<String, Object>> setEntrySet11111 = data.entrySet();
                    Intrinsics.f(setEntrySet11111, "it.entries");
                    it = setEntrySet11111.iterator();
                    while (it.hasNext()) {
                        entry = (Map.Entry) it.next();
                        value = entry.getValue();
                        if (value instanceof String) {
                            String str111111118 = (String) entry.getKey();
                            Object value111111112 = entry.getValue();
                            Intrinsics.e(value111111112, "null cannot be cast to non-null type kotlin.String");
                            data2.putString(str111111118, (String) value111111112);
                        } else if (value instanceof Long) {
                            String str111111119 = (String) entry.getKey();
                            Object value111111113 = entry.getValue();
                            Intrinsics.e(value111111113, "null cannot be cast to non-null type kotlin.Long");
                            data2.putLong(str111111119, ((Long) value111111113).longValue());
                        }
                    }
                    Unit unit111111118 = Unit.f68710a;
                }
                Unit unit111111119 = Unit.f68710a;
                reportProxy11111.report(str4, str3, data2);
                if (jCurrentTimeMillis != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                p.b("TmcPerferenceAnalyse", string11111, z11);
                com.cloud.tmc.kernel.proxy.performanceanalyse.b.a(pointAnalyseType, string11111);
                break;
            case 41:
                Unit unit58 = Unit.f68710a;
                str6 = "miniapp_log_e";
                str7 = "";
                str4 = str4;
                str5 = str5;
                jCurrentTimeMillis = 0;
                str3 = str6;
                if (str5 != null) {
                    strA = str7;
                } else {
                    strA = str7;
                }
                if (jCurrentTimeMillis > 0) {
                    strA = "-耗时:" + jCurrentTimeMillis + strA;
                }
                if (jCurrentTimeMillis > 0) {
                    pointAnalyseType = target;
                    if (pointAnalyseType == PointAnalyseType.POINT_RENDER_T1) {
                        TmcLogger.b(l.H(strA, "-", "", false, 4, null));
                    }
                } else {
                    pointAnalyseType = target;
                }
                if (str4 != null) {
                    sb2 = new StringBuilder();
                    sb2.append('[');
                    sb2.append(str4);
                    sb2.append("]:");
                } else {
                    sb2 = new StringBuilder();
                }
                sb2.append(target.getDes());
                sb2.append(strA);
                String string11112 = sb2.toString();
                ReportProxy reportProxy11112 = (ReportProxy) tc.a.a(ReportProxy.class);
                data2.putString(PointAnalyseType.class.getSimpleName() + '.' + target.name(), string11112);
                data = target.getData();
                if (data != null) {
                    Set<Map.Entry<String, Object>> setEntrySet11112 = data.entrySet();
                    Intrinsics.f(setEntrySet11112, "it.entries");
                    it = setEntrySet11112.iterator();
                    while (it.hasNext()) {
                        entry = (Map.Entry) it.next();
                        value = entry.getValue();
                        if (value instanceof String) {
                            String str1111111110 = (String) entry.getKey();
                            Object value111111114 = entry.getValue();
                            Intrinsics.e(value111111114, "null cannot be cast to non-null type kotlin.String");
                            data2.putString(str1111111110, (String) value111111114);
                        } else if (value instanceof Long) {
                            String str1111111111 = (String) entry.getKey();
                            Object value111111115 = entry.getValue();
                            Intrinsics.e(value111111115, "null cannot be cast to non-null type kotlin.Long");
                            data2.putLong(str1111111111, ((Long) value111111115).longValue());
                        }
                    }
                    Unit unit1111111110 = Unit.f68710a;
                }
                Unit unit1111111111 = Unit.f68710a;
                reportProxy11112.report(str4, str3, data2);
                if (jCurrentTimeMillis != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                p.b("TmcPerferenceAnalyse", string11112, z11);
                com.cloud.tmc.kernel.proxy.performanceanalyse.b.a(pointAnalyseType, string11112);
                break;
            case MotionEventCompat.AXIS_GENERIC_11 /* 42 */:
                data2.putString("gaId", q.d());
                Unit unit59 = Unit.f68710a;
                str6 = "privacy_policy_click";
                str7 = "";
                str4 = str4;
                str5 = str5;
                jCurrentTimeMillis = 0;
                str3 = str6;
                if (str5 != null) {
                    strA = str7;
                } else {
                    strA = str7;
                }
                if (jCurrentTimeMillis > 0) {
                    strA = "-耗时:" + jCurrentTimeMillis + strA;
                }
                if (jCurrentTimeMillis > 0) {
                    pointAnalyseType = target;
                    if (pointAnalyseType == PointAnalyseType.POINT_RENDER_T1) {
                        TmcLogger.b(l.H(strA, "-", "", false, 4, null));
                    }
                } else {
                    pointAnalyseType = target;
                }
                if (str4 != null) {
                    sb2 = new StringBuilder();
                    sb2.append('[');
                    sb2.append(str4);
                    sb2.append("]:");
                } else {
                    sb2 = new StringBuilder();
                }
                sb2.append(target.getDes());
                sb2.append(strA);
                String string11113 = sb2.toString();
                ReportProxy reportProxy11113 = (ReportProxy) tc.a.a(ReportProxy.class);
                data2.putString(PointAnalyseType.class.getSimpleName() + '.' + target.name(), string11113);
                data = target.getData();
                if (data != null) {
                    Set<Map.Entry<String, Object>> setEntrySet11113 = data.entrySet();
                    Intrinsics.f(setEntrySet11113, "it.entries");
                    it = setEntrySet11113.iterator();
                    while (it.hasNext()) {
                        entry = (Map.Entry) it.next();
                        value = entry.getValue();
                        if (value instanceof String) {
                            String str1111111112 = (String) entry.getKey();
                            Object value111111116 = entry.getValue();
                            Intrinsics.e(value111111116, "null cannot be cast to non-null type kotlin.String");
                            data2.putString(str1111111112, (String) value111111116);
                        } else if (value instanceof Long) {
                            String str1111111113 = (String) entry.getKey();
                            Object value111111117 = entry.getValue();
                            Intrinsics.e(value111111117, "null cannot be cast to non-null type kotlin.Long");
                            data2.putLong(str1111111113, ((Long) value111111117).longValue());
                        }
                    }
                    Unit unit1111111112 = Unit.f68710a;
                }
                Unit unit1111111113 = Unit.f68710a;
                reportProxy11113.report(str4, str3, data2);
                if (jCurrentTimeMillis != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                p.b("TmcPerferenceAnalyse", string11113, z11);
                com.cloud.tmc.kernel.proxy.performanceanalyse.b.a(pointAnalyseType, string11113);
                break;
            case MotionEventCompat.AXIS_GENERIC_12 /* 43 */:
                Unit unit60 = Unit.f68710a;
                str6 = "miniapp_get_package_file";
                str7 = "";
                str4 = str4;
                str5 = str5;
                jCurrentTimeMillis = 0;
                str3 = str6;
                if (str5 != null) {
                    strA = str7;
                } else {
                    strA = str7;
                }
                if (jCurrentTimeMillis > 0) {
                    strA = "-耗时:" + jCurrentTimeMillis + strA;
                }
                if (jCurrentTimeMillis > 0) {
                    pointAnalyseType = target;
                    if (pointAnalyseType == PointAnalyseType.POINT_RENDER_T1) {
                        TmcLogger.b(l.H(strA, "-", "", false, 4, null));
                    }
                } else {
                    pointAnalyseType = target;
                }
                if (str4 != null) {
                    sb2 = new StringBuilder();
                    sb2.append('[');
                    sb2.append(str4);
                    sb2.append("]:");
                } else {
                    sb2 = new StringBuilder();
                }
                sb2.append(target.getDes());
                sb2.append(strA);
                String string11114 = sb2.toString();
                ReportProxy reportProxy11114 = (ReportProxy) tc.a.a(ReportProxy.class);
                data2.putString(PointAnalyseType.class.getSimpleName() + '.' + target.name(), string11114);
                data = target.getData();
                if (data != null) {
                    Set<Map.Entry<String, Object>> setEntrySet11114 = data.entrySet();
                    Intrinsics.f(setEntrySet11114, "it.entries");
                    it = setEntrySet11114.iterator();
                    while (it.hasNext()) {
                        entry = (Map.Entry) it.next();
                        value = entry.getValue();
                        if (value instanceof String) {
                            String str1111111114 = (String) entry.getKey();
                            Object value111111118 = entry.getValue();
                            Intrinsics.e(value111111118, "null cannot be cast to non-null type kotlin.String");
                            data2.putString(str1111111114, (String) value111111118);
                        } else if (value instanceof Long) {
                            String str1111111115 = (String) entry.getKey();
                            Object value111111119 = entry.getValue();
                            Intrinsics.e(value111111119, "null cannot be cast to non-null type kotlin.Long");
                            data2.putLong(str1111111115, ((Long) value111111119).longValue());
                        }
                    }
                    Unit unit1111111114 = Unit.f68710a;
                }
                Unit unit1111111115 = Unit.f68710a;
                reportProxy11114.report(str4, str3, data2);
                if (jCurrentTimeMillis != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                p.b("TmcPerferenceAnalyse", string11114, z11);
                com.cloud.tmc.kernel.proxy.performanceanalyse.b.a(pointAnalyseType, string11114);
                break;
            case MotionEventCompat.AXIS_GENERIC_13 /* 44 */:
                data2.putString("object_id", "901");
                Unit unit61 = Unit.f68710a;
                str7 = "";
                str4 = str4;
                str5 = str5;
                str6 = "miniapp_package_update";
                jCurrentTimeMillis = 0;
                str3 = str6;
                if (str5 != null) {
                    strA = str7;
                } else {
                    strA = str7;
                }
                if (jCurrentTimeMillis > 0) {
                    strA = "-耗时:" + jCurrentTimeMillis + strA;
                }
                if (jCurrentTimeMillis > 0) {
                    pointAnalyseType = target;
                    if (pointAnalyseType == PointAnalyseType.POINT_RENDER_T1) {
                        TmcLogger.b(l.H(strA, "-", "", false, 4, null));
                    }
                } else {
                    pointAnalyseType = target;
                }
                if (str4 != null) {
                    sb2 = new StringBuilder();
                    sb2.append('[');
                    sb2.append(str4);
                    sb2.append("]:");
                } else {
                    sb2 = new StringBuilder();
                }
                sb2.append(target.getDes());
                sb2.append(strA);
                String string11115 = sb2.toString();
                ReportProxy reportProxy11115 = (ReportProxy) tc.a.a(ReportProxy.class);
                data2.putString(PointAnalyseType.class.getSimpleName() + '.' + target.name(), string11115);
                data = target.getData();
                if (data != null) {
                    Set<Map.Entry<String, Object>> setEntrySet11115 = data.entrySet();
                    Intrinsics.f(setEntrySet11115, "it.entries");
                    it = setEntrySet11115.iterator();
                    while (it.hasNext()) {
                        entry = (Map.Entry) it.next();
                        value = entry.getValue();
                        if (value instanceof String) {
                            String str1111111116 = (String) entry.getKey();
                            Object value1111111110 = entry.getValue();
                            Intrinsics.e(value1111111110, "null cannot be cast to non-null type kotlin.String");
                            data2.putString(str1111111116, (String) value1111111110);
                        } else if (value instanceof Long) {
                            String str1111111117 = (String) entry.getKey();
                            Object value1111111111 = entry.getValue();
                            Intrinsics.e(value1111111111, "null cannot be cast to non-null type kotlin.Long");
                            data2.putLong(str1111111117, ((Long) value1111111111).longValue());
                        }
                    }
                    Unit unit1111111116 = Unit.f68710a;
                }
                Unit unit1111111117 = Unit.f68710a;
                reportProxy11115.report(str4, str3, data2);
                if (jCurrentTimeMillis != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                p.b("TmcPerferenceAnalyse", string11115, z11);
                com.cloud.tmc.kernel.proxy.performanceanalyse.b.a(pointAnalyseType, string11115);
                break;
            case MotionEventCompat.AXIS_GENERIC_14 /* 45 */:
                data2.putString("object_id", "902");
                Unit unit62 = Unit.f68710a;
                str7 = "";
                str4 = str4;
                str5 = str5;
                str6 = "miniapp_package_update";
                jCurrentTimeMillis = 0;
                str3 = str6;
                if (str5 != null) {
                    strA = str7;
                } else {
                    strA = str7;
                }
                if (jCurrentTimeMillis > 0) {
                    strA = "-耗时:" + jCurrentTimeMillis + strA;
                }
                if (jCurrentTimeMillis > 0) {
                    pointAnalyseType = target;
                    if (pointAnalyseType == PointAnalyseType.POINT_RENDER_T1) {
                        TmcLogger.b(l.H(strA, "-", "", false, 4, null));
                    }
                } else {
                    pointAnalyseType = target;
                }
                if (str4 != null) {
                    sb2 = new StringBuilder();
                    sb2.append('[');
                    sb2.append(str4);
                    sb2.append("]:");
                } else {
                    sb2 = new StringBuilder();
                }
                sb2.append(target.getDes());
                sb2.append(strA);
                String string11116 = sb2.toString();
                ReportProxy reportProxy11116 = (ReportProxy) tc.a.a(ReportProxy.class);
                data2.putString(PointAnalyseType.class.getSimpleName() + '.' + target.name(), string11116);
                data = target.getData();
                if (data != null) {
                    Set<Map.Entry<String, Object>> setEntrySet11116 = data.entrySet();
                    Intrinsics.f(setEntrySet11116, "it.entries");
                    it = setEntrySet11116.iterator();
                    while (it.hasNext()) {
                        entry = (Map.Entry) it.next();
                        value = entry.getValue();
                        if (value instanceof String) {
                            String str1111111118 = (String) entry.getKey();
                            Object value1111111112 = entry.getValue();
                            Intrinsics.e(value1111111112, "null cannot be cast to non-null type kotlin.String");
                            data2.putString(str1111111118, (String) value1111111112);
                        } else if (value instanceof Long) {
                            String str1111111119 = (String) entry.getKey();
                            Object value1111111113 = entry.getValue();
                            Intrinsics.e(value1111111113, "null cannot be cast to non-null type kotlin.Long");
                            data2.putLong(str1111111119, ((Long) value1111111113).longValue());
                        }
                    }
                    Unit unit1111111118 = Unit.f68710a;
                }
                Unit unit1111111119 = Unit.f68710a;
                reportProxy11116.report(str4, str3, data2);
                if (jCurrentTimeMillis != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                p.b("TmcPerferenceAnalyse", string11116, z11);
                com.cloud.tmc.kernel.proxy.performanceanalyse.b.a(pointAnalyseType, string11116);
                break;
            case MotionEventCompat.AXIS_GENERIC_15 /* 46 */:
                data2.putString("object_id", "903");
                Unit unit63 = Unit.f68710a;
                str7 = "";
                str4 = str4;
                str5 = str5;
                str6 = "miniapp_package_update";
                jCurrentTimeMillis = 0;
                str3 = str6;
                if (str5 != null) {
                    strA = str7;
                } else {
                    strA = str7;
                }
                if (jCurrentTimeMillis > 0) {
                    strA = "-耗时:" + jCurrentTimeMillis + strA;
                }
                if (jCurrentTimeMillis > 0) {
                    pointAnalyseType = target;
                    if (pointAnalyseType == PointAnalyseType.POINT_RENDER_T1) {
                        TmcLogger.b(l.H(strA, "-", "", false, 4, null));
                    }
                } else {
                    pointAnalyseType = target;
                }
                if (str4 != null) {
                    sb2 = new StringBuilder();
                    sb2.append('[');
                    sb2.append(str4);
                    sb2.append("]:");
                } else {
                    sb2 = new StringBuilder();
                }
                sb2.append(target.getDes());
                sb2.append(strA);
                String string11117 = sb2.toString();
                ReportProxy reportProxy11117 = (ReportProxy) tc.a.a(ReportProxy.class);
                data2.putString(PointAnalyseType.class.getSimpleName() + '.' + target.name(), string11117);
                data = target.getData();
                if (data != null) {
                    Set<Map.Entry<String, Object>> setEntrySet11117 = data.entrySet();
                    Intrinsics.f(setEntrySet11117, "it.entries");
                    it = setEntrySet11117.iterator();
                    while (it.hasNext()) {
                        entry = (Map.Entry) it.next();
                        value = entry.getValue();
                        if (value instanceof String) {
                            String str11111111110 = (String) entry.getKey();
                            Object value1111111114 = entry.getValue();
                            Intrinsics.e(value1111111114, "null cannot be cast to non-null type kotlin.String");
                            data2.putString(str11111111110, (String) value1111111114);
                        } else if (value instanceof Long) {
                            String str11111111111 = (String) entry.getKey();
                            Object value1111111115 = entry.getValue();
                            Intrinsics.e(value1111111115, "null cannot be cast to non-null type kotlin.Long");
                            data2.putLong(str11111111111, ((Long) value1111111115).longValue());
                        }
                    }
                    Unit unit11111111110 = Unit.f68710a;
                }
                Unit unit11111111111 = Unit.f68710a;
                reportProxy11117.report(str4, str3, data2);
                if (jCurrentTimeMillis != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                p.b("TmcPerferenceAnalyse", string11117, z11);
                com.cloud.tmc.kernel.proxy.performanceanalyse.b.a(pointAnalyseType, string11117);
                break;
            case MotionEventCompat.AXIS_GENERIC_16 /* 47 */:
                data2.putString("object_id", "904");
                Unit unit64 = Unit.f68710a;
                str7 = "";
                str4 = str4;
                str5 = str5;
                str6 = "miniapp_package_update";
                jCurrentTimeMillis = 0;
                str3 = str6;
                if (str5 != null) {
                    strA = str7;
                } else {
                    strA = str7;
                }
                if (jCurrentTimeMillis > 0) {
                    strA = "-耗时:" + jCurrentTimeMillis + strA;
                }
                if (jCurrentTimeMillis > 0) {
                    pointAnalyseType = target;
                    if (pointAnalyseType == PointAnalyseType.POINT_RENDER_T1) {
                        TmcLogger.b(l.H(strA, "-", "", false, 4, null));
                    }
                } else {
                    pointAnalyseType = target;
                }
                if (str4 != null) {
                    sb2 = new StringBuilder();
                    sb2.append('[');
                    sb2.append(str4);
                    sb2.append("]:");
                } else {
                    sb2 = new StringBuilder();
                }
                sb2.append(target.getDes());
                sb2.append(strA);
                String string11118 = sb2.toString();
                ReportProxy reportProxy11118 = (ReportProxy) tc.a.a(ReportProxy.class);
                data2.putString(PointAnalyseType.class.getSimpleName() + '.' + target.name(), string11118);
                data = target.getData();
                if (data != null) {
                    Set<Map.Entry<String, Object>> setEntrySet11118 = data.entrySet();
                    Intrinsics.f(setEntrySet11118, "it.entries");
                    it = setEntrySet11118.iterator();
                    while (it.hasNext()) {
                        entry = (Map.Entry) it.next();
                        value = entry.getValue();
                        if (value instanceof String) {
                            String str11111111112 = (String) entry.getKey();
                            Object value1111111116 = entry.getValue();
                            Intrinsics.e(value1111111116, "null cannot be cast to non-null type kotlin.String");
                            data2.putString(str11111111112, (String) value1111111116);
                        } else if (value instanceof Long) {
                            String str11111111113 = (String) entry.getKey();
                            Object value1111111117 = entry.getValue();
                            Intrinsics.e(value1111111117, "null cannot be cast to non-null type kotlin.Long");
                            data2.putLong(str11111111113, ((Long) value1111111117).longValue());
                        }
                    }
                    Unit unit11111111112 = Unit.f68710a;
                }
                Unit unit11111111113 = Unit.f68710a;
                reportProxy11118.report(str4, str3, data2);
                if (jCurrentTimeMillis != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                p.b("TmcPerferenceAnalyse", string11118, z11);
                com.cloud.tmc.kernel.proxy.performanceanalyse.b.a(pointAnalyseType, string11118);
                break;
            case 48:
                data2.putString("object_id", "905");
                Unit unit65 = Unit.f68710a;
                str7 = "";
                str4 = str4;
                str5 = str5;
                str6 = "miniapp_package_update";
                jCurrentTimeMillis = 0;
                str3 = str6;
                if (str5 != null) {
                    strA = str7;
                } else {
                    strA = str7;
                }
                if (jCurrentTimeMillis > 0) {
                    strA = "-耗时:" + jCurrentTimeMillis + strA;
                }
                if (jCurrentTimeMillis > 0) {
                    pointAnalyseType = target;
                    if (pointAnalyseType == PointAnalyseType.POINT_RENDER_T1) {
                        TmcLogger.b(l.H(strA, "-", "", false, 4, null));
                    }
                } else {
                    pointAnalyseType = target;
                }
                if (str4 != null) {
                    sb2 = new StringBuilder();
                    sb2.append('[');
                    sb2.append(str4);
                    sb2.append("]:");
                } else {
                    sb2 = new StringBuilder();
                }
                sb2.append(target.getDes());
                sb2.append(strA);
                String string11119 = sb2.toString();
                ReportProxy reportProxy11119 = (ReportProxy) tc.a.a(ReportProxy.class);
                data2.putString(PointAnalyseType.class.getSimpleName() + '.' + target.name(), string11119);
                data = target.getData();
                if (data != null) {
                    Set<Map.Entry<String, Object>> setEntrySet11119 = data.entrySet();
                    Intrinsics.f(setEntrySet11119, "it.entries");
                    it = setEntrySet11119.iterator();
                    while (it.hasNext()) {
                        entry = (Map.Entry) it.next();
                        value = entry.getValue();
                        if (value instanceof String) {
                            String str11111111114 = (String) entry.getKey();
                            Object value1111111118 = entry.getValue();
                            Intrinsics.e(value1111111118, "null cannot be cast to non-null type kotlin.String");
                            data2.putString(str11111111114, (String) value1111111118);
                        } else if (value instanceof Long) {
                            String str11111111115 = (String) entry.getKey();
                            Object value1111111119 = entry.getValue();
                            Intrinsics.e(value1111111119, "null cannot be cast to non-null type kotlin.Long");
                            data2.putLong(str11111111115, ((Long) value1111111119).longValue());
                        }
                    }
                    Unit unit11111111114 = Unit.f68710a;
                }
                Unit unit11111111115 = Unit.f68710a;
                reportProxy11119.report(str4, str3, data2);
                if (jCurrentTimeMillis != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                p.b("TmcPerferenceAnalyse", string11119, z11);
                com.cloud.tmc.kernel.proxy.performanceanalyse.b.a(pointAnalyseType, string11119);
                break;
            case 49:
                data2.putString("object_id", "906");
                Unit unit66 = Unit.f68710a;
                str7 = "";
                str4 = str4;
                str5 = str5;
                str6 = "miniapp_package_update";
                jCurrentTimeMillis = 0;
                str3 = str6;
                if (str5 != null) {
                    strA = str7;
                } else {
                    strA = str7;
                }
                if (jCurrentTimeMillis > 0) {
                    strA = "-耗时:" + jCurrentTimeMillis + strA;
                }
                if (jCurrentTimeMillis > 0) {
                    pointAnalyseType = target;
                    if (pointAnalyseType == PointAnalyseType.POINT_RENDER_T1) {
                        TmcLogger.b(l.H(strA, "-", "", false, 4, null));
                    }
                } else {
                    pointAnalyseType = target;
                }
                if (str4 != null) {
                    sb2 = new StringBuilder();
                    sb2.append('[');
                    sb2.append(str4);
                    sb2.append("]:");
                } else {
                    sb2 = new StringBuilder();
                }
                sb2.append(target.getDes());
                sb2.append(strA);
                String string111110 = sb2.toString();
                ReportProxy reportProxy111110 = (ReportProxy) tc.a.a(ReportProxy.class);
                data2.putString(PointAnalyseType.class.getSimpleName() + '.' + target.name(), string111110);
                data = target.getData();
                if (data != null) {
                    Set<Map.Entry<String, Object>> setEntrySet111110 = data.entrySet();
                    Intrinsics.f(setEntrySet111110, "it.entries");
                    it = setEntrySet111110.iterator();
                    while (it.hasNext()) {
                        entry = (Map.Entry) it.next();
                        value = entry.getValue();
                        if (value instanceof String) {
                            String str11111111116 = (String) entry.getKey();
                            Object value11111111110 = entry.getValue();
                            Intrinsics.e(value11111111110, "null cannot be cast to non-null type kotlin.String");
                            data2.putString(str11111111116, (String) value11111111110);
                        } else if (value instanceof Long) {
                            String str11111111117 = (String) entry.getKey();
                            Object value11111111111 = entry.getValue();
                            Intrinsics.e(value11111111111, "null cannot be cast to non-null type kotlin.Long");
                            data2.putLong(str11111111117, ((Long) value11111111111).longValue());
                        }
                    }
                    Unit unit11111111116 = Unit.f68710a;
                }
                Unit unit11111111117 = Unit.f68710a;
                reportProxy111110.report(str4, str3, data2);
                if (jCurrentTimeMillis != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                p.b("TmcPerferenceAnalyse", string111110, z11);
                com.cloud.tmc.kernel.proxy.performanceanalyse.b.a(pointAnalyseType, string111110);
                break;
            case 50:
                data2.putString("object_id", "907");
                Unit unit67 = Unit.f68710a;
                str7 = "";
                str4 = str4;
                str5 = str5;
                str6 = "miniapp_package_update";
                jCurrentTimeMillis = 0;
                str3 = str6;
                if (str5 != null) {
                    strA = str7;
                } else {
                    strA = str7;
                }
                if (jCurrentTimeMillis > 0) {
                    strA = "-耗时:" + jCurrentTimeMillis + strA;
                }
                if (jCurrentTimeMillis > 0) {
                    pointAnalyseType = target;
                    if (pointAnalyseType == PointAnalyseType.POINT_RENDER_T1) {
                        TmcLogger.b(l.H(strA, "-", "", false, 4, null));
                    }
                } else {
                    pointAnalyseType = target;
                }
                if (str4 != null) {
                    sb2 = new StringBuilder();
                    sb2.append('[');
                    sb2.append(str4);
                    sb2.append("]:");
                } else {
                    sb2 = new StringBuilder();
                }
                sb2.append(target.getDes());
                sb2.append(strA);
                String string111111 = sb2.toString();
                ReportProxy reportProxy111111 = (ReportProxy) tc.a.a(ReportProxy.class);
                data2.putString(PointAnalyseType.class.getSimpleName() + '.' + target.name(), string111111);
                data = target.getData();
                if (data != null) {
                    Set<Map.Entry<String, Object>> setEntrySet111111 = data.entrySet();
                    Intrinsics.f(setEntrySet111111, "it.entries");
                    it = setEntrySet111111.iterator();
                    while (it.hasNext()) {
                        entry = (Map.Entry) it.next();
                        value = entry.getValue();
                        if (value instanceof String) {
                            String str11111111118 = (String) entry.getKey();
                            Object value11111111112 = entry.getValue();
                            Intrinsics.e(value11111111112, "null cannot be cast to non-null type kotlin.String");
                            data2.putString(str11111111118, (String) value11111111112);
                        } else if (value instanceof Long) {
                            String str11111111119 = (String) entry.getKey();
                            Object value11111111113 = entry.getValue();
                            Intrinsics.e(value11111111113, "null cannot be cast to non-null type kotlin.Long");
                            data2.putLong(str11111111119, ((Long) value11111111113).longValue());
                        }
                    }
                    Unit unit11111111118 = Unit.f68710a;
                }
                Unit unit11111111119 = Unit.f68710a;
                reportProxy111111.report(str4, str3, data2);
                if (jCurrentTimeMillis != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                p.b("TmcPerferenceAnalyse", string111111, z11);
                com.cloud.tmc.kernel.proxy.performanceanalyse.b.a(pointAnalyseType, string111111);
                break;
            case 51:
                if (str5 != null) {
                    if (!s.b.f75901a.g(str5, str4, data2)) {
                        Unit unit68 = Unit.f68710a;
                        str7 = "";
                        str4 = str4;
                        str5 = str5;
                        str6 = str7;
                        jCurrentTimeMillis = 0;
                        str3 = str6;
                        if (str5 != null) {
                            strA = str7;
                        } else {
                            strA = str7;
                        }
                        if (jCurrentTimeMillis > 0) {
                            strA = "-耗时:" + jCurrentTimeMillis + strA;
                        }
                        if (jCurrentTimeMillis > 0) {
                            pointAnalyseType = target;
                            if (pointAnalyseType == PointAnalyseType.POINT_RENDER_T1) {
                                TmcLogger.b(l.H(strA, "-", "", false, 4, null));
                            }
                        } else {
                            pointAnalyseType = target;
                        }
                        if (str4 != null) {
                            sb2 = new StringBuilder();
                            sb2.append('[');
                            sb2.append(str4);
                            sb2.append("]:");
                        } else {
                            sb2 = new StringBuilder();
                        }
                        sb2.append(target.getDes());
                        sb2.append(strA);
                        String string111112 = sb2.toString();
                        ReportProxy reportProxy111112 = (ReportProxy) tc.a.a(ReportProxy.class);
                        data2.putString(PointAnalyseType.class.getSimpleName() + '.' + target.name(), string111112);
                        data = target.getData();
                        if (data != null) {
                            Set<Map.Entry<String, Object>> setEntrySet111112 = data.entrySet();
                            Intrinsics.f(setEntrySet111112, "it.entries");
                            it = setEntrySet111112.iterator();
                            while (it.hasNext()) {
                                entry = (Map.Entry) it.next();
                                value = entry.getValue();
                                if (value instanceof String) {
                                    String str111111111110 = (String) entry.getKey();
                                    Object value11111111114 = entry.getValue();
                                    Intrinsics.e(value11111111114, "null cannot be cast to non-null type kotlin.String");
                                    data2.putString(str111111111110, (String) value11111111114);
                                } else if (value instanceof Long) {
                                    String str111111111111 = (String) entry.getKey();
                                    Object value11111111115 = entry.getValue();
                                    Intrinsics.e(value11111111115, "null cannot be cast to non-null type kotlin.Long");
                                    data2.putLong(str111111111111, ((Long) value11111111115).longValue());
                                }
                            }
                            Unit unit111111111110 = Unit.f68710a;
                        }
                        Unit unit111111111111 = Unit.f68710a;
                        reportProxy111112.report(str4, str3, data2);
                        if (jCurrentTimeMillis != 0) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        p.b("TmcPerferenceAnalyse", string111112, z11);
                        com.cloud.tmc.kernel.proxy.performanceanalyse.b.a(pointAnalyseType, string111112);
                        break;
                    }
                }
                str7 = "";
                str4 = str4;
                str5 = str5;
                str3 = str7;
                jCurrentTimeMillis = 0;
                if (str5 != null) {
                    strA = str7;
                } else {
                    strA = str7;
                }
                if (jCurrentTimeMillis > 0) {
                    strA = "-耗时:" + jCurrentTimeMillis + strA;
                }
                if (jCurrentTimeMillis > 0) {
                    pointAnalyseType = target;
                    if (pointAnalyseType == PointAnalyseType.POINT_RENDER_T1) {
                        TmcLogger.b(l.H(strA, "-", "", false, 4, null));
                    }
                } else {
                    pointAnalyseType = target;
                }
                if (str4 != null) {
                    sb2 = new StringBuilder();
                    sb2.append('[');
                    sb2.append(str4);
                    sb2.append("]:");
                } else {
                    sb2 = new StringBuilder();
                }
                sb2.append(target.getDes());
                sb2.append(strA);
                String string111113 = sb2.toString();
                ReportProxy reportProxy111113 = (ReportProxy) tc.a.a(ReportProxy.class);
                data2.putString(PointAnalyseType.class.getSimpleName() + '.' + target.name(), string111113);
                data = target.getData();
                if (data != null) {
                    Set<Map.Entry<String, Object>> setEntrySet111113 = data.entrySet();
                    Intrinsics.f(setEntrySet111113, "it.entries");
                    it = setEntrySet111113.iterator();
                    while (it.hasNext()) {
                        entry = (Map.Entry) it.next();
                        value = entry.getValue();
                        if (value instanceof String) {
                            String str111111111112 = (String) entry.getKey();
                            Object value11111111116 = entry.getValue();
                            Intrinsics.e(value11111111116, "null cannot be cast to non-null type kotlin.String");
                            data2.putString(str111111111112, (String) value11111111116);
                        } else if (value instanceof Long) {
                            String str111111111113 = (String) entry.getKey();
                            Object value11111111117 = entry.getValue();
                            Intrinsics.e(value11111111117, "null cannot be cast to non-null type kotlin.Long");
                            data2.putLong(str111111111113, ((Long) value11111111117).longValue());
                        }
                    }
                    Unit unit111111111112 = Unit.f68710a;
                }
                Unit unit111111111113 = Unit.f68710a;
                reportProxy111113.report(str4, str3, data2);
                if (jCurrentTimeMillis != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                p.b("TmcPerferenceAnalyse", string111113, z11);
                com.cloud.tmc.kernel.proxy.performanceanalyse.b.a(pointAnalyseType, string111113);
                break;
            case 52:
                if (str5 != null) {
                    if (!s.b.f75901a.e(str5, str4, data2)) {
                        Unit unit69 = Unit.f68710a;
                        str7 = "";
                        str4 = str4;
                        str5 = str5;
                        str6 = str7;
                        jCurrentTimeMillis = 0;
                        str3 = str6;
                        if (str5 != null) {
                            strA = str7;
                        } else {
                            strA = str7;
                        }
                        if (jCurrentTimeMillis > 0) {
                            strA = "-耗时:" + jCurrentTimeMillis + strA;
                        }
                        if (jCurrentTimeMillis > 0) {
                            pointAnalyseType = target;
                            if (pointAnalyseType == PointAnalyseType.POINT_RENDER_T1) {
                                TmcLogger.b(l.H(strA, "-", "", false, 4, null));
                            }
                        } else {
                            pointAnalyseType = target;
                        }
                        if (str4 != null) {
                            sb2 = new StringBuilder();
                            sb2.append('[');
                            sb2.append(str4);
                            sb2.append("]:");
                        } else {
                            sb2 = new StringBuilder();
                        }
                        sb2.append(target.getDes());
                        sb2.append(strA);
                        String string111114 = sb2.toString();
                        ReportProxy reportProxy111114 = (ReportProxy) tc.a.a(ReportProxy.class);
                        data2.putString(PointAnalyseType.class.getSimpleName() + '.' + target.name(), string111114);
                        data = target.getData();
                        if (data != null) {
                            Set<Map.Entry<String, Object>> setEntrySet111114 = data.entrySet();
                            Intrinsics.f(setEntrySet111114, "it.entries");
                            it = setEntrySet111114.iterator();
                            while (it.hasNext()) {
                                entry = (Map.Entry) it.next();
                                value = entry.getValue();
                                if (value instanceof String) {
                                    String str111111111114 = (String) entry.getKey();
                                    Object value11111111118 = entry.getValue();
                                    Intrinsics.e(value11111111118, "null cannot be cast to non-null type kotlin.String");
                                    data2.putString(str111111111114, (String) value11111111118);
                                } else if (value instanceof Long) {
                                    String str111111111115 = (String) entry.getKey();
                                    Object value11111111119 = entry.getValue();
                                    Intrinsics.e(value11111111119, "null cannot be cast to non-null type kotlin.Long");
                                    data2.putLong(str111111111115, ((Long) value11111111119).longValue());
                                }
                            }
                            Unit unit111111111114 = Unit.f68710a;
                        }
                        Unit unit111111111115 = Unit.f68710a;
                        reportProxy111114.report(str4, str3, data2);
                        if (jCurrentTimeMillis != 0) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        p.b("TmcPerferenceAnalyse", string111114, z11);
                        com.cloud.tmc.kernel.proxy.performanceanalyse.b.a(pointAnalyseType, string111114);
                        break;
                    }
                }
                str7 = "";
                str4 = str4;
                str5 = str5;
                str3 = str7;
                jCurrentTimeMillis = 0;
                if (str5 != null) {
                    strA = str7;
                } else {
                    strA = str7;
                }
                if (jCurrentTimeMillis > 0) {
                    strA = "-耗时:" + jCurrentTimeMillis + strA;
                }
                if (jCurrentTimeMillis > 0) {
                    pointAnalyseType = target;
                    if (pointAnalyseType == PointAnalyseType.POINT_RENDER_T1) {
                        TmcLogger.b(l.H(strA, "-", "", false, 4, null));
                    }
                } else {
                    pointAnalyseType = target;
                }
                if (str4 != null) {
                    sb2 = new StringBuilder();
                    sb2.append('[');
                    sb2.append(str4);
                    sb2.append("]:");
                } else {
                    sb2 = new StringBuilder();
                }
                sb2.append(target.getDes());
                sb2.append(strA);
                String string111115 = sb2.toString();
                ReportProxy reportProxy111115 = (ReportProxy) tc.a.a(ReportProxy.class);
                data2.putString(PointAnalyseType.class.getSimpleName() + '.' + target.name(), string111115);
                data = target.getData();
                if (data != null) {
                    Set<Map.Entry<String, Object>> setEntrySet111115 = data.entrySet();
                    Intrinsics.f(setEntrySet111115, "it.entries");
                    it = setEntrySet111115.iterator();
                    while (it.hasNext()) {
                        entry = (Map.Entry) it.next();
                        value = entry.getValue();
                        if (value instanceof String) {
                            String str111111111116 = (String) entry.getKey();
                            Object value111111111110 = entry.getValue();
                            Intrinsics.e(value111111111110, "null cannot be cast to non-null type kotlin.String");
                            data2.putString(str111111111116, (String) value111111111110);
                        } else if (value instanceof Long) {
                            String str111111111117 = (String) entry.getKey();
                            Object value111111111111 = entry.getValue();
                            Intrinsics.e(value111111111111, "null cannot be cast to non-null type kotlin.Long");
                            data2.putLong(str111111111117, ((Long) value111111111111).longValue());
                        }
                    }
                    Unit unit111111111116 = Unit.f68710a;
                }
                Unit unit111111111117 = Unit.f68710a;
                reportProxy111115.report(str4, str3, data2);
                if (jCurrentTimeMillis != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                p.b("TmcPerferenceAnalyse", string111115, z11);
                com.cloud.tmc.kernel.proxy.performanceanalyse.b.a(pointAnalyseType, string111115);
                break;
            case 53:
                if (str5 != null) {
                    if (!r.b.f75020a.e(str5, str4, data2)) {
                        Unit unit70 = Unit.f68710a;
                        str7 = "";
                        str4 = str4;
                        str5 = str5;
                        str6 = str7;
                        jCurrentTimeMillis = 0;
                        str3 = str6;
                        if (str5 != null) {
                            strA = str7;
                        } else {
                            strA = str7;
                        }
                        if (jCurrentTimeMillis > 0) {
                            strA = "-耗时:" + jCurrentTimeMillis + strA;
                        }
                        if (jCurrentTimeMillis > 0) {
                            pointAnalyseType = target;
                            if (pointAnalyseType == PointAnalyseType.POINT_RENDER_T1) {
                                TmcLogger.b(l.H(strA, "-", "", false, 4, null));
                            }
                        } else {
                            pointAnalyseType = target;
                        }
                        if (str4 != null) {
                            sb2 = new StringBuilder();
                            sb2.append('[');
                            sb2.append(str4);
                            sb2.append("]:");
                        } else {
                            sb2 = new StringBuilder();
                        }
                        sb2.append(target.getDes());
                        sb2.append(strA);
                        String string111116 = sb2.toString();
                        ReportProxy reportProxy111116 = (ReportProxy) tc.a.a(ReportProxy.class);
                        data2.putString(PointAnalyseType.class.getSimpleName() + '.' + target.name(), string111116);
                        data = target.getData();
                        if (data != null) {
                            Set<Map.Entry<String, Object>> setEntrySet111116 = data.entrySet();
                            Intrinsics.f(setEntrySet111116, "it.entries");
                            it = setEntrySet111116.iterator();
                            while (it.hasNext()) {
                                entry = (Map.Entry) it.next();
                                value = entry.getValue();
                                if (value instanceof String) {
                                    String str111111111118 = (String) entry.getKey();
                                    Object value111111111112 = entry.getValue();
                                    Intrinsics.e(value111111111112, "null cannot be cast to non-null type kotlin.String");
                                    data2.putString(str111111111118, (String) value111111111112);
                                } else if (value instanceof Long) {
                                    String str111111111119 = (String) entry.getKey();
                                    Object value111111111113 = entry.getValue();
                                    Intrinsics.e(value111111111113, "null cannot be cast to non-null type kotlin.Long");
                                    data2.putLong(str111111111119, ((Long) value111111111113).longValue());
                                }
                            }
                            Unit unit111111111118 = Unit.f68710a;
                        }
                        Unit unit111111111119 = Unit.f68710a;
                        reportProxy111116.report(str4, str3, data2);
                        if (jCurrentTimeMillis != 0) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        p.b("TmcPerferenceAnalyse", string111116, z11);
                        com.cloud.tmc.kernel.proxy.performanceanalyse.b.a(pointAnalyseType, string111116);
                        break;
                    }
                }
                str7 = "";
                str4 = str4;
                str5 = str5;
                str3 = str7;
                jCurrentTimeMillis = 0;
                if (str5 != null) {
                    strA = str7;
                } else {
                    strA = str7;
                }
                if (jCurrentTimeMillis > 0) {
                    strA = "-耗时:" + jCurrentTimeMillis + strA;
                }
                if (jCurrentTimeMillis > 0) {
                    pointAnalyseType = target;
                    if (pointAnalyseType == PointAnalyseType.POINT_RENDER_T1) {
                        TmcLogger.b(l.H(strA, "-", "", false, 4, null));
                    }
                } else {
                    pointAnalyseType = target;
                }
                if (str4 != null) {
                    sb2 = new StringBuilder();
                    sb2.append('[');
                    sb2.append(str4);
                    sb2.append("]:");
                } else {
                    sb2 = new StringBuilder();
                }
                sb2.append(target.getDes());
                sb2.append(strA);
                String string111117 = sb2.toString();
                ReportProxy reportProxy111117 = (ReportProxy) tc.a.a(ReportProxy.class);
                data2.putString(PointAnalyseType.class.getSimpleName() + '.' + target.name(), string111117);
                data = target.getData();
                if (data != null) {
                    Set<Map.Entry<String, Object>> setEntrySet111117 = data.entrySet();
                    Intrinsics.f(setEntrySet111117, "it.entries");
                    it = setEntrySet111117.iterator();
                    while (it.hasNext()) {
                        entry = (Map.Entry) it.next();
                        value = entry.getValue();
                        if (value instanceof String) {
                            String str1111111111110 = (String) entry.getKey();
                            Object value111111111114 = entry.getValue();
                            Intrinsics.e(value111111111114, "null cannot be cast to non-null type kotlin.String");
                            data2.putString(str1111111111110, (String) value111111111114);
                        } else if (value instanceof Long) {
                            String str1111111111111 = (String) entry.getKey();
                            Object value111111111115 = entry.getValue();
                            Intrinsics.e(value111111111115, "null cannot be cast to non-null type kotlin.Long");
                            data2.putLong(str1111111111111, ((Long) value111111111115).longValue());
                        }
                    }
                    Unit unit1111111111110 = Unit.f68710a;
                }
                Unit unit1111111111111 = Unit.f68710a;
                reportProxy111117.report(str4, str3, data2);
                if (jCurrentTimeMillis != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                p.b("TmcPerferenceAnalyse", string111117, z11);
                com.cloud.tmc.kernel.proxy.performanceanalyse.b.a(pointAnalyseType, string111117);
                break;
            case 54:
                if (str5 != null) {
                    if (!r.b.f75020a.d(str5, str4, data2)) {
                        Unit unit71 = Unit.f68710a;
                        str7 = "";
                        str4 = str4;
                        str5 = str5;
                        str6 = str7;
                        jCurrentTimeMillis = 0;
                        str3 = str6;
                        if (str5 != null) {
                            strA = str7;
                        } else {
                            strA = str7;
                        }
                        if (jCurrentTimeMillis > 0) {
                            strA = "-耗时:" + jCurrentTimeMillis + strA;
                        }
                        if (jCurrentTimeMillis > 0) {
                            pointAnalyseType = target;
                            if (pointAnalyseType == PointAnalyseType.POINT_RENDER_T1) {
                                TmcLogger.b(l.H(strA, "-", "", false, 4, null));
                            }
                        } else {
                            pointAnalyseType = target;
                        }
                        if (str4 != null) {
                            sb2 = new StringBuilder();
                            sb2.append('[');
                            sb2.append(str4);
                            sb2.append("]:");
                        } else {
                            sb2 = new StringBuilder();
                        }
                        sb2.append(target.getDes());
                        sb2.append(strA);
                        String string111118 = sb2.toString();
                        ReportProxy reportProxy111118 = (ReportProxy) tc.a.a(ReportProxy.class);
                        data2.putString(PointAnalyseType.class.getSimpleName() + '.' + target.name(), string111118);
                        data = target.getData();
                        if (data != null) {
                            Set<Map.Entry<String, Object>> setEntrySet111118 = data.entrySet();
                            Intrinsics.f(setEntrySet111118, "it.entries");
                            it = setEntrySet111118.iterator();
                            while (it.hasNext()) {
                                entry = (Map.Entry) it.next();
                                value = entry.getValue();
                                if (value instanceof String) {
                                    String str1111111111112 = (String) entry.getKey();
                                    Object value111111111116 = entry.getValue();
                                    Intrinsics.e(value111111111116, "null cannot be cast to non-null type kotlin.String");
                                    data2.putString(str1111111111112, (String) value111111111116);
                                } else if (value instanceof Long) {
                                    String str1111111111113 = (String) entry.getKey();
                                    Object value111111111117 = entry.getValue();
                                    Intrinsics.e(value111111111117, "null cannot be cast to non-null type kotlin.Long");
                                    data2.putLong(str1111111111113, ((Long) value111111111117).longValue());
                                }
                            }
                            Unit unit1111111111112 = Unit.f68710a;
                        }
                        Unit unit1111111111113 = Unit.f68710a;
                        reportProxy111118.report(str4, str3, data2);
                        if (jCurrentTimeMillis != 0) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        p.b("TmcPerferenceAnalyse", string111118, z11);
                        com.cloud.tmc.kernel.proxy.performanceanalyse.b.a(pointAnalyseType, string111118);
                        break;
                    }
                }
                str7 = "";
                str4 = str4;
                str5 = str5;
                str3 = str7;
                jCurrentTimeMillis = 0;
                if (str5 != null) {
                    strA = str7;
                } else {
                    strA = str7;
                }
                if (jCurrentTimeMillis > 0) {
                    strA = "-耗时:" + jCurrentTimeMillis + strA;
                }
                if (jCurrentTimeMillis > 0) {
                    pointAnalyseType = target;
                    if (pointAnalyseType == PointAnalyseType.POINT_RENDER_T1) {
                        TmcLogger.b(l.H(strA, "-", "", false, 4, null));
                    }
                } else {
                    pointAnalyseType = target;
                }
                if (str4 != null) {
                    sb2 = new StringBuilder();
                    sb2.append('[');
                    sb2.append(str4);
                    sb2.append("]:");
                } else {
                    sb2 = new StringBuilder();
                }
                sb2.append(target.getDes());
                sb2.append(strA);
                String string111119 = sb2.toString();
                ReportProxy reportProxy111119 = (ReportProxy) tc.a.a(ReportProxy.class);
                data2.putString(PointAnalyseType.class.getSimpleName() + '.' + target.name(), string111119);
                data = target.getData();
                if (data != null) {
                    Set<Map.Entry<String, Object>> setEntrySet111119 = data.entrySet();
                    Intrinsics.f(setEntrySet111119, "it.entries");
                    it = setEntrySet111119.iterator();
                    while (it.hasNext()) {
                        entry = (Map.Entry) it.next();
                        value = entry.getValue();
                        if (value instanceof String) {
                            String str1111111111114 = (String) entry.getKey();
                            Object value111111111118 = entry.getValue();
                            Intrinsics.e(value111111111118, "null cannot be cast to non-null type kotlin.String");
                            data2.putString(str1111111111114, (String) value111111111118);
                        } else if (value instanceof Long) {
                            String str1111111111115 = (String) entry.getKey();
                            Object value111111111119 = entry.getValue();
                            Intrinsics.e(value111111111119, "null cannot be cast to non-null type kotlin.Long");
                            data2.putLong(str1111111111115, ((Long) value111111111119).longValue());
                        }
                    }
                    Unit unit1111111111114 = Unit.f68710a;
                }
                Unit unit1111111111115 = Unit.f68710a;
                reportProxy111119.report(str4, str3, data2);
                if (jCurrentTimeMillis != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                p.b("TmcPerferenceAnalyse", string111119, z11);
                com.cloud.tmc.kernel.proxy.performanceanalyse.b.a(pointAnalyseType, string111119);
                break;
            case 55:
                if (!s.b.f75901a.f(str4, data2)) {
                    Unit unit72 = Unit.f68710a;
                    str7 = "";
                    str4 = str4;
                    str5 = str5;
                    str6 = str7;
                    jCurrentTimeMillis = 0;
                    str3 = str6;
                    if (str5 != null) {
                        strA = str7;
                    } else {
                        strA = str7;
                    }
                    if (jCurrentTimeMillis > 0) {
                        strA = "-耗时:" + jCurrentTimeMillis + strA;
                    }
                    if (jCurrentTimeMillis > 0) {
                        pointAnalyseType = target;
                        if (pointAnalyseType == PointAnalyseType.POINT_RENDER_T1) {
                            TmcLogger.b(l.H(strA, "-", "", false, 4, null));
                        }
                    } else {
                        pointAnalyseType = target;
                    }
                    if (str4 != null) {
                        sb2 = new StringBuilder();
                        sb2.append('[');
                        sb2.append(str4);
                        sb2.append("]:");
                    } else {
                        sb2 = new StringBuilder();
                    }
                    sb2.append(target.getDes());
                    sb2.append(strA);
                    String string1111110 = sb2.toString();
                    ReportProxy reportProxy1111110 = (ReportProxy) tc.a.a(ReportProxy.class);
                    data2.putString(PointAnalyseType.class.getSimpleName() + '.' + target.name(), string1111110);
                    data = target.getData();
                    if (data != null) {
                        Set<Map.Entry<String, Object>> setEntrySet1111110 = data.entrySet();
                        Intrinsics.f(setEntrySet1111110, "it.entries");
                        it = setEntrySet1111110.iterator();
                        while (it.hasNext()) {
                            entry = (Map.Entry) it.next();
                            value = entry.getValue();
                            if (value instanceof String) {
                                String str1111111111116 = (String) entry.getKey();
                                Object value1111111111110 = entry.getValue();
                                Intrinsics.e(value1111111111110, "null cannot be cast to non-null type kotlin.String");
                                data2.putString(str1111111111116, (String) value1111111111110);
                            } else if (value instanceof Long) {
                                String str1111111111117 = (String) entry.getKey();
                                Object value1111111111111 = entry.getValue();
                                Intrinsics.e(value1111111111111, "null cannot be cast to non-null type kotlin.Long");
                                data2.putLong(str1111111111117, ((Long) value1111111111111).longValue());
                            }
                        }
                        Unit unit1111111111116 = Unit.f68710a;
                    }
                    Unit unit1111111111117 = Unit.f68710a;
                    reportProxy1111110.report(str4, str3, data2);
                    if (jCurrentTimeMillis != 0) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    p.b("TmcPerferenceAnalyse", string1111110, z11);
                    com.cloud.tmc.kernel.proxy.performanceanalyse.b.a(pointAnalyseType, string1111110);
                    break;
                }
                break;
            case 56:
                if (!r.b.f75020a.c(str4, data2)) {
                    Unit unit73 = Unit.f68710a;
                    str7 = "";
                    str4 = str4;
                    str5 = str5;
                    str6 = str7;
                    jCurrentTimeMillis = 0;
                    str3 = str6;
                    if (str5 != null) {
                        strA = str7;
                    } else {
                        strA = str7;
                    }
                    if (jCurrentTimeMillis > 0) {
                        strA = "-耗时:" + jCurrentTimeMillis + strA;
                    }
                    if (jCurrentTimeMillis > 0) {
                        pointAnalyseType = target;
                        if (pointAnalyseType == PointAnalyseType.POINT_RENDER_T1) {
                            TmcLogger.b(l.H(strA, "-", "", false, 4, null));
                        }
                    } else {
                        pointAnalyseType = target;
                    }
                    if (str4 != null) {
                        sb2 = new StringBuilder();
                        sb2.append('[');
                        sb2.append(str4);
                        sb2.append("]:");
                    } else {
                        sb2 = new StringBuilder();
                    }
                    sb2.append(target.getDes());
                    sb2.append(strA);
                    String string1111111 = sb2.toString();
                    ReportProxy reportProxy1111111 = (ReportProxy) tc.a.a(ReportProxy.class);
                    data2.putString(PointAnalyseType.class.getSimpleName() + '.' + target.name(), string1111111);
                    data = target.getData();
                    if (data != null) {
                        Set<Map.Entry<String, Object>> setEntrySet1111111 = data.entrySet();
                        Intrinsics.f(setEntrySet1111111, "it.entries");
                        it = setEntrySet1111111.iterator();
                        while (it.hasNext()) {
                            entry = (Map.Entry) it.next();
                            value = entry.getValue();
                            if (value instanceof String) {
                                String str1111111111118 = (String) entry.getKey();
                                Object value1111111111112 = entry.getValue();
                                Intrinsics.e(value1111111111112, "null cannot be cast to non-null type kotlin.String");
                                data2.putString(str1111111111118, (String) value1111111111112);
                            } else if (value instanceof Long) {
                                String str1111111111119 = (String) entry.getKey();
                                Object value1111111111113 = entry.getValue();
                                Intrinsics.e(value1111111111113, "null cannot be cast to non-null type kotlin.Long");
                                data2.putLong(str1111111111119, ((Long) value1111111111113).longValue());
                            }
                        }
                        Unit unit1111111111118 = Unit.f68710a;
                    }
                    Unit unit1111111111119 = Unit.f68710a;
                    reportProxy1111111.report(str4, str3, data2);
                    if (jCurrentTimeMillis != 0) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    p.b("TmcPerferenceAnalyse", string1111111, z11);
                    com.cloud.tmc.kernel.proxy.performanceanalyse.b.a(pointAnalyseType, string1111111);
                    break;
                }
                break;
            case DownloadBean.STATUS_COMPLETED_REMOVED /* 57 */:
                if (!s.b.f75901a.h(str4, data2)) {
                    Unit unit74 = Unit.f68710a;
                    str7 = "";
                    str4 = str4;
                    str5 = str5;
                    str6 = str7;
                    jCurrentTimeMillis = 0;
                    str3 = str6;
                    if (str5 != null) {
                        strA = str7;
                    } else {
                        strA = str7;
                    }
                    if (jCurrentTimeMillis > 0) {
                        strA = "-耗时:" + jCurrentTimeMillis + strA;
                    }
                    if (jCurrentTimeMillis > 0) {
                        pointAnalyseType = target;
                        if (pointAnalyseType == PointAnalyseType.POINT_RENDER_T1) {
                            TmcLogger.b(l.H(strA, "-", "", false, 4, null));
                        }
                    } else {
                        pointAnalyseType = target;
                    }
                    if (str4 != null) {
                        sb2 = new StringBuilder();
                        sb2.append('[');
                        sb2.append(str4);
                        sb2.append("]:");
                    } else {
                        sb2 = new StringBuilder();
                    }
                    sb2.append(target.getDes());
                    sb2.append(strA);
                    String string1111112 = sb2.toString();
                    ReportProxy reportProxy1111112 = (ReportProxy) tc.a.a(ReportProxy.class);
                    data2.putString(PointAnalyseType.class.getSimpleName() + '.' + target.name(), string1111112);
                    data = target.getData();
                    if (data != null) {
                        Set<Map.Entry<String, Object>> setEntrySet1111112 = data.entrySet();
                        Intrinsics.f(setEntrySet1111112, "it.entries");
                        it = setEntrySet1111112.iterator();
                        while (it.hasNext()) {
                            entry = (Map.Entry) it.next();
                            value = entry.getValue();
                            if (value instanceof String) {
                                String str11111111111110 = (String) entry.getKey();
                                Object value1111111111114 = entry.getValue();
                                Intrinsics.e(value1111111111114, "null cannot be cast to non-null type kotlin.String");
                                data2.putString(str11111111111110, (String) value1111111111114);
                            } else if (value instanceof Long) {
                                String str11111111111111 = (String) entry.getKey();
                                Object value1111111111115 = entry.getValue();
                                Intrinsics.e(value1111111111115, "null cannot be cast to non-null type kotlin.Long");
                                data2.putLong(str11111111111111, ((Long) value1111111111115).longValue());
                            }
                        }
                        Unit unit11111111111110 = Unit.f68710a;
                    }
                    Unit unit11111111111111 = Unit.f68710a;
                    reportProxy1111112.report(str4, str3, data2);
                    if (jCurrentTimeMillis != 0) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    p.b("TmcPerferenceAnalyse", string1111112, z11);
                    com.cloud.tmc.kernel.proxy.performanceanalyse.b.a(pointAnalyseType, string1111112);
                    break;
                }
                break;
            case 58:
                if (!s.b.f75901a.d(str4, data2)) {
                    Unit unit75 = Unit.f68710a;
                    str7 = "";
                    str4 = str4;
                    str5 = str5;
                    str6 = str7;
                    jCurrentTimeMillis = 0;
                    str3 = str6;
                    if (str5 != null) {
                        strA = str7;
                    } else {
                        strA = str7;
                    }
                    if (jCurrentTimeMillis > 0) {
                        strA = "-耗时:" + jCurrentTimeMillis + strA;
                    }
                    if (jCurrentTimeMillis > 0) {
                        pointAnalyseType = target;
                        if (pointAnalyseType == PointAnalyseType.POINT_RENDER_T1) {
                            TmcLogger.b(l.H(strA, "-", "", false, 4, null));
                        }
                    } else {
                        pointAnalyseType = target;
                    }
                    if (str4 != null) {
                        sb2 = new StringBuilder();
                        sb2.append('[');
                        sb2.append(str4);
                        sb2.append("]:");
                    } else {
                        sb2 = new StringBuilder();
                    }
                    sb2.append(target.getDes());
                    sb2.append(strA);
                    String string1111113 = sb2.toString();
                    ReportProxy reportProxy1111113 = (ReportProxy) tc.a.a(ReportProxy.class);
                    data2.putString(PointAnalyseType.class.getSimpleName() + '.' + target.name(), string1111113);
                    data = target.getData();
                    if (data != null) {
                        Set<Map.Entry<String, Object>> setEntrySet1111113 = data.entrySet();
                        Intrinsics.f(setEntrySet1111113, "it.entries");
                        it = setEntrySet1111113.iterator();
                        while (it.hasNext()) {
                            entry = (Map.Entry) it.next();
                            value = entry.getValue();
                            if (value instanceof String) {
                                String str11111111111112 = (String) entry.getKey();
                                Object value1111111111116 = entry.getValue();
                                Intrinsics.e(value1111111111116, "null cannot be cast to non-null type kotlin.String");
                                data2.putString(str11111111111112, (String) value1111111111116);
                            } else if (value instanceof Long) {
                                String str11111111111113 = (String) entry.getKey();
                                Object value1111111111117 = entry.getValue();
                                Intrinsics.e(value1111111111117, "null cannot be cast to non-null type kotlin.Long");
                                data2.putLong(str11111111111113, ((Long) value1111111111117).longValue());
                            }
                        }
                        Unit unit11111111111112 = Unit.f68710a;
                    }
                    Unit unit11111111111113 = Unit.f68710a;
                    reportProxy1111113.report(str4, str3, data2);
                    if (jCurrentTimeMillis != 0) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    p.b("TmcPerferenceAnalyse", string1111113, z11);
                    com.cloud.tmc.kernel.proxy.performanceanalyse.b.a(pointAnalyseType, string1111113);
                    break;
                }
                break;
            case 59:
                Intrinsics.g(data2, "data");
                StringBuilder sb3 = new StringBuilder();
                sb3.append("recordPageStageFail #########> appId:");
                sb3.append(str4);
                sb3.append(", data:");
                sb3.append(data2);
                if (str4 != null) {
                    try {
                        s.a aVar2 = (s.a) ((LinkedHashMap) s.b.f75902b).get(str4);
                        if (aVar2 != null) {
                            String string26 = data2.getString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.W, "");
                            if (!TextUtils.isEmpty(string26) && (aVar = aVar2.f75893f.get(string26)) != null && Intrinsics.b(aVar.f75013b, string26) && Intrinsics.b(aVar.f75012a, data2.getString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.N, ""))) {
                                r.b.f75020a.a(aVar2, aVar, data2);
                            }
                        }
                    } catch (Throwable unused5) {
                        return;
                    }
                }
                break;
            case 60:
                Unit unit76 = Unit.f68710a;
                str6 = "miniapp_foreground_time";
                str7 = "";
                str4 = str4;
                str5 = str5;
                jCurrentTimeMillis = 0;
                str3 = str6;
                if (str5 != null) {
                    strA = str7;
                } else {
                    strA = str7;
                }
                if (jCurrentTimeMillis > 0) {
                    strA = "-耗时:" + jCurrentTimeMillis + strA;
                }
                if (jCurrentTimeMillis > 0) {
                    pointAnalyseType = target;
                    if (pointAnalyseType == PointAnalyseType.POINT_RENDER_T1) {
                        TmcLogger.b(l.H(strA, "-", "", false, 4, null));
                    }
                } else {
                    pointAnalyseType = target;
                }
                if (str4 != null) {
                    sb2 = new StringBuilder();
                    sb2.append('[');
                    sb2.append(str4);
                    sb2.append("]:");
                } else {
                    sb2 = new StringBuilder();
                }
                sb2.append(target.getDes());
                sb2.append(strA);
                String string1111114 = sb2.toString();
                ReportProxy reportProxy1111114 = (ReportProxy) tc.a.a(ReportProxy.class);
                data2.putString(PointAnalyseType.class.getSimpleName() + '.' + target.name(), string1111114);
                data = target.getData();
                if (data != null) {
                    Set<Map.Entry<String, Object>> setEntrySet1111114 = data.entrySet();
                    Intrinsics.f(setEntrySet1111114, "it.entries");
                    it = setEntrySet1111114.iterator();
                    while (it.hasNext()) {
                        entry = (Map.Entry) it.next();
                        value = entry.getValue();
                        if (value instanceof String) {
                            String str11111111111114 = (String) entry.getKey();
                            Object value1111111111118 = entry.getValue();
                            Intrinsics.e(value1111111111118, "null cannot be cast to non-null type kotlin.String");
                            data2.putString(str11111111111114, (String) value1111111111118);
                        } else if (value instanceof Long) {
                            String str11111111111115 = (String) entry.getKey();
                            Object value1111111111119 = entry.getValue();
                            Intrinsics.e(value1111111111119, "null cannot be cast to non-null type kotlin.Long");
                            data2.putLong(str11111111111115, ((Long) value1111111111119).longValue());
                        }
                    }
                    Unit unit11111111111114 = Unit.f68710a;
                }
                Unit unit11111111111115 = Unit.f68710a;
                reportProxy1111114.report(str4, str3, data2);
                if (jCurrentTimeMillis != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                p.b("TmcPerferenceAnalyse", string1111114, z11);
                com.cloud.tmc.kernel.proxy.performanceanalyse.b.a(pointAnalyseType, string1111114);
                break;
            case 61:
                Unit unit77 = Unit.f68710a;
                str6 = "miniapp_get_odid";
                str7 = "";
                str4 = str4;
                str5 = str5;
                jCurrentTimeMillis = 0;
                str3 = str6;
                if (str5 != null) {
                    strA = str7;
                } else {
                    strA = str7;
                }
                if (jCurrentTimeMillis > 0) {
                    strA = "-耗时:" + jCurrentTimeMillis + strA;
                }
                if (jCurrentTimeMillis > 0) {
                    pointAnalyseType = target;
                    if (pointAnalyseType == PointAnalyseType.POINT_RENDER_T1) {
                        TmcLogger.b(l.H(strA, "-", "", false, 4, null));
                    }
                } else {
                    pointAnalyseType = target;
                }
                if (str4 != null) {
                    sb2 = new StringBuilder();
                    sb2.append('[');
                    sb2.append(str4);
                    sb2.append("]:");
                } else {
                    sb2 = new StringBuilder();
                }
                sb2.append(target.getDes());
                sb2.append(strA);
                String string1111115 = sb2.toString();
                ReportProxy reportProxy1111115 = (ReportProxy) tc.a.a(ReportProxy.class);
                data2.putString(PointAnalyseType.class.getSimpleName() + '.' + target.name(), string1111115);
                data = target.getData();
                if (data != null) {
                    Set<Map.Entry<String, Object>> setEntrySet1111115 = data.entrySet();
                    Intrinsics.f(setEntrySet1111115, "it.entries");
                    it = setEntrySet1111115.iterator();
                    while (it.hasNext()) {
                        entry = (Map.Entry) it.next();
                        value = entry.getValue();
                        if (value instanceof String) {
                            String str11111111111116 = (String) entry.getKey();
                            Object value11111111111110 = entry.getValue();
                            Intrinsics.e(value11111111111110, "null cannot be cast to non-null type kotlin.String");
                            data2.putString(str11111111111116, (String) value11111111111110);
                        } else if (value instanceof Long) {
                            String str11111111111117 = (String) entry.getKey();
                            Object value11111111111111 = entry.getValue();
                            Intrinsics.e(value11111111111111, "null cannot be cast to non-null type kotlin.Long");
                            data2.putLong(str11111111111117, ((Long) value11111111111111).longValue());
                        }
                    }
                    Unit unit11111111111116 = Unit.f68710a;
                }
                Unit unit11111111111117 = Unit.f68710a;
                reportProxy1111115.report(str4, str3, data2);
                if (jCurrentTimeMillis != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                p.b("TmcPerferenceAnalyse", string1111115, z11);
                com.cloud.tmc.kernel.proxy.performanceanalyse.b.a(pointAnalyseType, string1111115);
                break;
            case 62:
                Unit unit78 = Unit.f68710a;
                str6 = "miniapp_hot_open";
                str7 = "";
                str4 = str4;
                str5 = str5;
                jCurrentTimeMillis = 0;
                str3 = str6;
                if (str5 != null) {
                    strA = str7;
                } else {
                    strA = str7;
                }
                if (jCurrentTimeMillis > 0) {
                    strA = "-耗时:" + jCurrentTimeMillis + strA;
                }
                if (jCurrentTimeMillis > 0) {
                    pointAnalyseType = target;
                    if (pointAnalyseType == PointAnalyseType.POINT_RENDER_T1) {
                        TmcLogger.b(l.H(strA, "-", "", false, 4, null));
                    }
                } else {
                    pointAnalyseType = target;
                }
                if (str4 != null) {
                    sb2 = new StringBuilder();
                    sb2.append('[');
                    sb2.append(str4);
                    sb2.append("]:");
                } else {
                    sb2 = new StringBuilder();
                }
                sb2.append(target.getDes());
                sb2.append(strA);
                String string1111116 = sb2.toString();
                ReportProxy reportProxy1111116 = (ReportProxy) tc.a.a(ReportProxy.class);
                data2.putString(PointAnalyseType.class.getSimpleName() + '.' + target.name(), string1111116);
                data = target.getData();
                if (data != null) {
                    Set<Map.Entry<String, Object>> setEntrySet1111116 = data.entrySet();
                    Intrinsics.f(setEntrySet1111116, "it.entries");
                    it = setEntrySet1111116.iterator();
                    while (it.hasNext()) {
                        entry = (Map.Entry) it.next();
                        value = entry.getValue();
                        if (value instanceof String) {
                            String str11111111111118 = (String) entry.getKey();
                            Object value11111111111112 = entry.getValue();
                            Intrinsics.e(value11111111111112, "null cannot be cast to non-null type kotlin.String");
                            data2.putString(str11111111111118, (String) value11111111111112);
                        } else if (value instanceof Long) {
                            String str11111111111119 = (String) entry.getKey();
                            Object value11111111111113 = entry.getValue();
                            Intrinsics.e(value11111111111113, "null cannot be cast to non-null type kotlin.Long");
                            data2.putLong(str11111111111119, ((Long) value11111111111113).longValue());
                        }
                    }
                    Unit unit11111111111118 = Unit.f68710a;
                }
                Unit unit11111111111119 = Unit.f68710a;
                reportProxy1111116.report(str4, str3, data2);
                if (jCurrentTimeMillis != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                p.b("TmcPerferenceAnalyse", string1111116, z11);
                com.cloud.tmc.kernel.proxy.performanceanalyse.b.a(pointAnalyseType, string1111116);
                break;
            case 63:
                Unit unit79 = Unit.f68710a;
                str6 = "mini_open_page_action";
                str7 = "";
                str4 = str4;
                str5 = str5;
                jCurrentTimeMillis = 0;
                str3 = str6;
                if (str5 != null) {
                    strA = str7;
                } else {
                    strA = str7;
                }
                if (jCurrentTimeMillis > 0) {
                    strA = "-耗时:" + jCurrentTimeMillis + strA;
                }
                if (jCurrentTimeMillis > 0) {
                    pointAnalyseType = target;
                    if (pointAnalyseType == PointAnalyseType.POINT_RENDER_T1) {
                        TmcLogger.b(l.H(strA, "-", "", false, 4, null));
                    }
                } else {
                    pointAnalyseType = target;
                }
                if (str4 != null) {
                    sb2 = new StringBuilder();
                    sb2.append('[');
                    sb2.append(str4);
                    sb2.append("]:");
                } else {
                    sb2 = new StringBuilder();
                }
                sb2.append(target.getDes());
                sb2.append(strA);
                String string1111117 = sb2.toString();
                ReportProxy reportProxy1111117 = (ReportProxy) tc.a.a(ReportProxy.class);
                data2.putString(PointAnalyseType.class.getSimpleName() + '.' + target.name(), string1111117);
                data = target.getData();
                if (data != null) {
                    Set<Map.Entry<String, Object>> setEntrySet1111117 = data.entrySet();
                    Intrinsics.f(setEntrySet1111117, "it.entries");
                    it = setEntrySet1111117.iterator();
                    while (it.hasNext()) {
                        entry = (Map.Entry) it.next();
                        value = entry.getValue();
                        if (value instanceof String) {
                            String str111111111111110 = (String) entry.getKey();
                            Object value11111111111114 = entry.getValue();
                            Intrinsics.e(value11111111111114, "null cannot be cast to non-null type kotlin.String");
                            data2.putString(str111111111111110, (String) value11111111111114);
                        } else if (value instanceof Long) {
                            String str111111111111111 = (String) entry.getKey();
                            Object value11111111111115 = entry.getValue();
                            Intrinsics.e(value11111111111115, "null cannot be cast to non-null type kotlin.Long");
                            data2.putLong(str111111111111111, ((Long) value11111111111115).longValue());
                        }
                    }
                    Unit unit111111111111110 = Unit.f68710a;
                }
                Unit unit111111111111111 = Unit.f68710a;
                reportProxy1111117.report(str4, str3, data2);
                if (jCurrentTimeMillis != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                p.b("TmcPerferenceAnalyse", string1111117, z11);
                com.cloud.tmc.kernel.proxy.performanceanalyse.b.a(pointAnalyseType, string1111117);
                break;
            case 64:
                Unit unit80 = Unit.f68710a;
                str6 = "Pinforlater_ex";
                str7 = "";
                str4 = str4;
                str5 = str5;
                jCurrentTimeMillis = 0;
                str3 = str6;
                if (str5 != null) {
                    strA = str7;
                } else {
                    strA = str7;
                }
                if (jCurrentTimeMillis > 0) {
                    strA = "-耗时:" + jCurrentTimeMillis + strA;
                }
                if (jCurrentTimeMillis > 0) {
                    pointAnalyseType = target;
                    if (pointAnalyseType == PointAnalyseType.POINT_RENDER_T1) {
                        TmcLogger.b(l.H(strA, "-", "", false, 4, null));
                    }
                } else {
                    pointAnalyseType = target;
                }
                if (str4 != null) {
                    sb2 = new StringBuilder();
                    sb2.append('[');
                    sb2.append(str4);
                    sb2.append("]:");
                } else {
                    sb2 = new StringBuilder();
                }
                sb2.append(target.getDes());
                sb2.append(strA);
                String string1111118 = sb2.toString();
                ReportProxy reportProxy1111118 = (ReportProxy) tc.a.a(ReportProxy.class);
                data2.putString(PointAnalyseType.class.getSimpleName() + '.' + target.name(), string1111118);
                data = target.getData();
                if (data != null) {
                    Set<Map.Entry<String, Object>> setEntrySet1111118 = data.entrySet();
                    Intrinsics.f(setEntrySet1111118, "it.entries");
                    it = setEntrySet1111118.iterator();
                    while (it.hasNext()) {
                        entry = (Map.Entry) it.next();
                        value = entry.getValue();
                        if (value instanceof String) {
                            String str111111111111112 = (String) entry.getKey();
                            Object value11111111111116 = entry.getValue();
                            Intrinsics.e(value11111111111116, "null cannot be cast to non-null type kotlin.String");
                            data2.putString(str111111111111112, (String) value11111111111116);
                        } else if (value instanceof Long) {
                            String str111111111111113 = (String) entry.getKey();
                            Object value11111111111117 = entry.getValue();
                            Intrinsics.e(value11111111111117, "null cannot be cast to non-null type kotlin.Long");
                            data2.putLong(str111111111111113, ((Long) value11111111111117).longValue());
                        }
                    }
                    Unit unit111111111111112 = Unit.f68710a;
                }
                Unit unit111111111111113 = Unit.f68710a;
                reportProxy1111118.report(str4, str3, data2);
                if (jCurrentTimeMillis != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                p.b("TmcPerferenceAnalyse", string1111118, z11);
                com.cloud.tmc.kernel.proxy.performanceanalyse.b.a(pointAnalyseType, string1111118);
                break;
            case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                Unit unit81 = Unit.f68710a;
                str6 = "Pinforlater_click";
                str7 = "";
                str4 = str4;
                str5 = str5;
                jCurrentTimeMillis = 0;
                str3 = str6;
                if (str5 != null) {
                    strA = str7;
                } else {
                    strA = str7;
                }
                if (jCurrentTimeMillis > 0) {
                    strA = "-耗时:" + jCurrentTimeMillis + strA;
                }
                if (jCurrentTimeMillis > 0) {
                    pointAnalyseType = target;
                    if (pointAnalyseType == PointAnalyseType.POINT_RENDER_T1) {
                        TmcLogger.b(l.H(strA, "-", "", false, 4, null));
                    }
                } else {
                    pointAnalyseType = target;
                }
                if (str4 != null) {
                    sb2 = new StringBuilder();
                    sb2.append('[');
                    sb2.append(str4);
                    sb2.append("]:");
                } else {
                    sb2 = new StringBuilder();
                }
                sb2.append(target.getDes());
                sb2.append(strA);
                String string1111119 = sb2.toString();
                ReportProxy reportProxy1111119 = (ReportProxy) tc.a.a(ReportProxy.class);
                data2.putString(PointAnalyseType.class.getSimpleName() + '.' + target.name(), string1111119);
                data = target.getData();
                if (data != null) {
                    Set<Map.Entry<String, Object>> setEntrySet1111119 = data.entrySet();
                    Intrinsics.f(setEntrySet1111119, "it.entries");
                    it = setEntrySet1111119.iterator();
                    while (it.hasNext()) {
                        entry = (Map.Entry) it.next();
                        value = entry.getValue();
                        if (value instanceof String) {
                            String str111111111111114 = (String) entry.getKey();
                            Object value11111111111118 = entry.getValue();
                            Intrinsics.e(value11111111111118, "null cannot be cast to non-null type kotlin.String");
                            data2.putString(str111111111111114, (String) value11111111111118);
                        } else if (value instanceof Long) {
                            String str111111111111115 = (String) entry.getKey();
                            Object value11111111111119 = entry.getValue();
                            Intrinsics.e(value11111111111119, "null cannot be cast to non-null type kotlin.Long");
                            data2.putLong(str111111111111115, ((Long) value11111111111119).longValue());
                        }
                    }
                    Unit unit111111111111114 = Unit.f68710a;
                }
                Unit unit111111111111115 = Unit.f68710a;
                reportProxy1111119.report(str4, str3, data2);
                if (jCurrentTimeMillis != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                p.b("TmcPerferenceAnalyse", string1111119, z11);
                com.cloud.tmc.kernel.proxy.performanceanalyse.b.a(pointAnalyseType, string1111119);
                break;
            case 66:
                Unit unit82 = Unit.f68710a;
                str6 = "later_banner_ex";
                str7 = "";
                str4 = str4;
                str5 = str5;
                jCurrentTimeMillis = 0;
                str3 = str6;
                if (str5 != null) {
                    strA = str7;
                } else {
                    strA = str7;
                }
                if (jCurrentTimeMillis > 0) {
                    strA = "-耗时:" + jCurrentTimeMillis + strA;
                }
                if (jCurrentTimeMillis > 0) {
                    pointAnalyseType = target;
                    if (pointAnalyseType == PointAnalyseType.POINT_RENDER_T1) {
                        TmcLogger.b(l.H(strA, "-", "", false, 4, null));
                    }
                } else {
                    pointAnalyseType = target;
                }
                if (str4 != null) {
                    sb2 = new StringBuilder();
                    sb2.append('[');
                    sb2.append(str4);
                    sb2.append("]:");
                } else {
                    sb2 = new StringBuilder();
                }
                sb2.append(target.getDes());
                sb2.append(strA);
                String string11111110 = sb2.toString();
                ReportProxy reportProxy11111110 = (ReportProxy) tc.a.a(ReportProxy.class);
                data2.putString(PointAnalyseType.class.getSimpleName() + '.' + target.name(), string11111110);
                data = target.getData();
                if (data != null) {
                    Set<Map.Entry<String, Object>> setEntrySet11111110 = data.entrySet();
                    Intrinsics.f(setEntrySet11111110, "it.entries");
                    it = setEntrySet11111110.iterator();
                    while (it.hasNext()) {
                        entry = (Map.Entry) it.next();
                        value = entry.getValue();
                        if (value instanceof String) {
                            String str111111111111116 = (String) entry.getKey();
                            Object value111111111111110 = entry.getValue();
                            Intrinsics.e(value111111111111110, "null cannot be cast to non-null type kotlin.String");
                            data2.putString(str111111111111116, (String) value111111111111110);
                        } else if (value instanceof Long) {
                            String str111111111111117 = (String) entry.getKey();
                            Object value111111111111111 = entry.getValue();
                            Intrinsics.e(value111111111111111, "null cannot be cast to non-null type kotlin.Long");
                            data2.putLong(str111111111111117, ((Long) value111111111111111).longValue());
                        }
                    }
                    Unit unit111111111111116 = Unit.f68710a;
                }
                Unit unit111111111111117 = Unit.f68710a;
                reportProxy11111110.report(str4, str3, data2);
                if (jCurrentTimeMillis != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                p.b("TmcPerferenceAnalyse", string11111110, z11);
                com.cloud.tmc.kernel.proxy.performanceanalyse.b.a(pointAnalyseType, string11111110);
                break;
            case MdtaMetadataEntry.TYPE_INDICATOR_INT32 /* 67 */:
                Unit unit83 = Unit.f68710a;
                str6 = "later_banner_click";
                str7 = "";
                str4 = str4;
                str5 = str5;
                jCurrentTimeMillis = 0;
                str3 = str6;
                if (str5 != null) {
                    strA = str7;
                } else {
                    strA = str7;
                }
                if (jCurrentTimeMillis > 0) {
                    strA = "-耗时:" + jCurrentTimeMillis + strA;
                }
                if (jCurrentTimeMillis > 0) {
                    pointAnalyseType = target;
                    if (pointAnalyseType == PointAnalyseType.POINT_RENDER_T1) {
                        TmcLogger.b(l.H(strA, "-", "", false, 4, null));
                    }
                } else {
                    pointAnalyseType = target;
                }
                if (str4 != null) {
                    sb2 = new StringBuilder();
                    sb2.append('[');
                    sb2.append(str4);
                    sb2.append("]:");
                } else {
                    sb2 = new StringBuilder();
                }
                sb2.append(target.getDes());
                sb2.append(strA);
                String string11111111 = sb2.toString();
                ReportProxy reportProxy11111111 = (ReportProxy) tc.a.a(ReportProxy.class);
                data2.putString(PointAnalyseType.class.getSimpleName() + '.' + target.name(), string11111111);
                data = target.getData();
                if (data != null) {
                    Set<Map.Entry<String, Object>> setEntrySet11111111 = data.entrySet();
                    Intrinsics.f(setEntrySet11111111, "it.entries");
                    it = setEntrySet11111111.iterator();
                    while (it.hasNext()) {
                        entry = (Map.Entry) it.next();
                        value = entry.getValue();
                        if (value instanceof String) {
                            String str111111111111118 = (String) entry.getKey();
                            Object value111111111111112 = entry.getValue();
                            Intrinsics.e(value111111111111112, "null cannot be cast to non-null type kotlin.String");
                            data2.putString(str111111111111118, (String) value111111111111112);
                        } else if (value instanceof Long) {
                            String str111111111111119 = (String) entry.getKey();
                            Object value111111111111113 = entry.getValue();
                            Intrinsics.e(value111111111111113, "null cannot be cast to non-null type kotlin.Long");
                            data2.putLong(str111111111111119, ((Long) value111111111111113).longValue());
                        }
                    }
                    Unit unit111111111111118 = Unit.f68710a;
                }
                Unit unit111111111111119 = Unit.f68710a;
                reportProxy11111111.report(str4, str3, data2);
                if (jCurrentTimeMillis != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                p.b("TmcPerferenceAnalyse", string11111111, z11);
                com.cloud.tmc.kernel.proxy.performanceanalyse.b.a(pointAnalyseType, string11111111);
                break;
            case 68:
                Unit unit84 = Unit.f68710a;
                str6 = "later_addmc_click";
                str7 = "";
                str4 = str4;
                str5 = str5;
                jCurrentTimeMillis = 0;
                str3 = str6;
                if (str5 != null) {
                    strA = str7;
                } else {
                    strA = str7;
                }
                if (jCurrentTimeMillis > 0) {
                    strA = "-耗时:" + jCurrentTimeMillis + strA;
                }
                if (jCurrentTimeMillis > 0) {
                    pointAnalyseType = target;
                    if (pointAnalyseType == PointAnalyseType.POINT_RENDER_T1) {
                        TmcLogger.b(l.H(strA, "-", "", false, 4, null));
                    }
                } else {
                    pointAnalyseType = target;
                }
                if (str4 != null) {
                    sb2 = new StringBuilder();
                    sb2.append('[');
                    sb2.append(str4);
                    sb2.append("]:");
                } else {
                    sb2 = new StringBuilder();
                }
                sb2.append(target.getDes());
                sb2.append(strA);
                String string11111112 = sb2.toString();
                ReportProxy reportProxy11111112 = (ReportProxy) tc.a.a(ReportProxy.class);
                data2.putString(PointAnalyseType.class.getSimpleName() + '.' + target.name(), string11111112);
                data = target.getData();
                if (data != null) {
                    Set<Map.Entry<String, Object>> setEntrySet11111112 = data.entrySet();
                    Intrinsics.f(setEntrySet11111112, "it.entries");
                    it = setEntrySet11111112.iterator();
                    while (it.hasNext()) {
                        entry = (Map.Entry) it.next();
                        value = entry.getValue();
                        if (value instanceof String) {
                            String str1111111111111110 = (String) entry.getKey();
                            Object value111111111111114 = entry.getValue();
                            Intrinsics.e(value111111111111114, "null cannot be cast to non-null type kotlin.String");
                            data2.putString(str1111111111111110, (String) value111111111111114);
                        } else if (value instanceof Long) {
                            String str1111111111111111 = (String) entry.getKey();
                            Object value111111111111115 = entry.getValue();
                            Intrinsics.e(value111111111111115, "null cannot be cast to non-null type kotlin.Long");
                            data2.putLong(str1111111111111111, ((Long) value111111111111115).longValue());
                        }
                    }
                    Unit unit1111111111111110 = Unit.f68710a;
                }
                Unit unit1111111111111111 = Unit.f68710a;
                reportProxy11111112.report(str4, str3, data2);
                if (jCurrentTimeMillis != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                p.b("TmcPerferenceAnalyse", string11111112, z11);
                com.cloud.tmc.kernel.proxy.performanceanalyse.b.a(pointAnalyseType, string11111112);
                break;
            case 69:
                Unit unit85 = Unit.f68710a;
                str6 = "later_addmc_ex";
                str7 = "";
                str4 = str4;
                str5 = str5;
                jCurrentTimeMillis = 0;
                str3 = str6;
                if (str5 != null) {
                    strA = str7;
                } else {
                    strA = str7;
                }
                if (jCurrentTimeMillis > 0) {
                    strA = "-耗时:" + jCurrentTimeMillis + strA;
                }
                if (jCurrentTimeMillis > 0) {
                    pointAnalyseType = target;
                    if (pointAnalyseType == PointAnalyseType.POINT_RENDER_T1) {
                        TmcLogger.b(l.H(strA, "-", "", false, 4, null));
                    }
                } else {
                    pointAnalyseType = target;
                }
                if (str4 != null) {
                    sb2 = new StringBuilder();
                    sb2.append('[');
                    sb2.append(str4);
                    sb2.append("]:");
                } else {
                    sb2 = new StringBuilder();
                }
                sb2.append(target.getDes());
                sb2.append(strA);
                String string11111113 = sb2.toString();
                ReportProxy reportProxy11111113 = (ReportProxy) tc.a.a(ReportProxy.class);
                data2.putString(PointAnalyseType.class.getSimpleName() + '.' + target.name(), string11111113);
                data = target.getData();
                if (data != null) {
                    Set<Map.Entry<String, Object>> setEntrySet11111113 = data.entrySet();
                    Intrinsics.f(setEntrySet11111113, "it.entries");
                    it = setEntrySet11111113.iterator();
                    while (it.hasNext()) {
                        entry = (Map.Entry) it.next();
                        value = entry.getValue();
                        if (value instanceof String) {
                            String str1111111111111112 = (String) entry.getKey();
                            Object value111111111111116 = entry.getValue();
                            Intrinsics.e(value111111111111116, "null cannot be cast to non-null type kotlin.String");
                            data2.putString(str1111111111111112, (String) value111111111111116);
                        } else if (value instanceof Long) {
                            String str1111111111111113 = (String) entry.getKey();
                            Object value111111111111117 = entry.getValue();
                            Intrinsics.e(value111111111111117, "null cannot be cast to non-null type kotlin.Long");
                            data2.putLong(str1111111111111113, ((Long) value111111111111117).longValue());
                        }
                    }
                    Unit unit1111111111111112 = Unit.f68710a;
                }
                Unit unit1111111111111113 = Unit.f68710a;
                reportProxy11111113.report(str4, str3, data2);
                if (jCurrentTimeMillis != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                p.b("TmcPerferenceAnalyse", string11111113, z11);
                com.cloud.tmc.kernel.proxy.performanceanalyse.b.a(pointAnalyseType, string11111113);
                break;
            case 70:
                Unit unit86 = Unit.f68710a;
                str6 = "privacy_ex";
                str7 = "";
                str4 = str4;
                str5 = str5;
                jCurrentTimeMillis = 0;
                str3 = str6;
                if (str5 != null) {
                    strA = str7;
                } else {
                    strA = str7;
                }
                if (jCurrentTimeMillis > 0) {
                    strA = "-耗时:" + jCurrentTimeMillis + strA;
                }
                if (jCurrentTimeMillis > 0) {
                    pointAnalyseType = target;
                    if (pointAnalyseType == PointAnalyseType.POINT_RENDER_T1) {
                        TmcLogger.b(l.H(strA, "-", "", false, 4, null));
                    }
                } else {
                    pointAnalyseType = target;
                }
                if (str4 != null) {
                    sb2 = new StringBuilder();
                    sb2.append('[');
                    sb2.append(str4);
                    sb2.append("]:");
                } else {
                    sb2 = new StringBuilder();
                }
                sb2.append(target.getDes());
                sb2.append(strA);
                String string11111114 = sb2.toString();
                ReportProxy reportProxy11111114 = (ReportProxy) tc.a.a(ReportProxy.class);
                data2.putString(PointAnalyseType.class.getSimpleName() + '.' + target.name(), string11111114);
                data = target.getData();
                if (data != null) {
                    Set<Map.Entry<String, Object>> setEntrySet11111114 = data.entrySet();
                    Intrinsics.f(setEntrySet11111114, "it.entries");
                    it = setEntrySet11111114.iterator();
                    while (it.hasNext()) {
                        entry = (Map.Entry) it.next();
                        value = entry.getValue();
                        if (value instanceof String) {
                            String str1111111111111114 = (String) entry.getKey();
                            Object value111111111111118 = entry.getValue();
                            Intrinsics.e(value111111111111118, "null cannot be cast to non-null type kotlin.String");
                            data2.putString(str1111111111111114, (String) value111111111111118);
                        } else if (value instanceof Long) {
                            String str1111111111111115 = (String) entry.getKey();
                            Object value111111111111119 = entry.getValue();
                            Intrinsics.e(value111111111111119, "null cannot be cast to non-null type kotlin.Long");
                            data2.putLong(str1111111111111115, ((Long) value111111111111119).longValue());
                        }
                    }
                    Unit unit1111111111111114 = Unit.f68710a;
                }
                Unit unit1111111111111115 = Unit.f68710a;
                reportProxy11111114.report(str4, str3, data2);
                if (jCurrentTimeMillis != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                p.b("TmcPerferenceAnalyse", string11111114, z11);
                com.cloud.tmc.kernel.proxy.performanceanalyse.b.a(pointAnalyseType, string11111114);
                break;
            case 71:
                Unit unit87 = Unit.f68710a;
                str6 = "privacy_click";
                str7 = "";
                str4 = str4;
                str5 = str5;
                jCurrentTimeMillis = 0;
                str3 = str6;
                if (str5 != null) {
                    strA = str7;
                } else {
                    strA = str7;
                }
                if (jCurrentTimeMillis > 0) {
                    strA = "-耗时:" + jCurrentTimeMillis + strA;
                }
                if (jCurrentTimeMillis > 0) {
                    pointAnalyseType = target;
                    if (pointAnalyseType == PointAnalyseType.POINT_RENDER_T1) {
                        TmcLogger.b(l.H(strA, "-", "", false, 4, null));
                    }
                } else {
                    pointAnalyseType = target;
                }
                if (str4 != null) {
                    sb2 = new StringBuilder();
                    sb2.append('[');
                    sb2.append(str4);
                    sb2.append("]:");
                } else {
                    sb2 = new StringBuilder();
                }
                sb2.append(target.getDes());
                sb2.append(strA);
                String string11111115 = sb2.toString();
                ReportProxy reportProxy11111115 = (ReportProxy) tc.a.a(ReportProxy.class);
                data2.putString(PointAnalyseType.class.getSimpleName() + '.' + target.name(), string11111115);
                data = target.getData();
                if (data != null) {
                    Set<Map.Entry<String, Object>> setEntrySet11111115 = data.entrySet();
                    Intrinsics.f(setEntrySet11111115, "it.entries");
                    it = setEntrySet11111115.iterator();
                    while (it.hasNext()) {
                        entry = (Map.Entry) it.next();
                        value = entry.getValue();
                        if (value instanceof String) {
                            String str1111111111111116 = (String) entry.getKey();
                            Object value1111111111111110 = entry.getValue();
                            Intrinsics.e(value1111111111111110, "null cannot be cast to non-null type kotlin.String");
                            data2.putString(str1111111111111116, (String) value1111111111111110);
                        } else if (value instanceof Long) {
                            String str1111111111111117 = (String) entry.getKey();
                            Object value1111111111111111 = entry.getValue();
                            Intrinsics.e(value1111111111111111, "null cannot be cast to non-null type kotlin.Long");
                            data2.putLong(str1111111111111117, ((Long) value1111111111111111).longValue());
                        }
                    }
                    Unit unit1111111111111116 = Unit.f68710a;
                }
                Unit unit1111111111111117 = Unit.f68710a;
                reportProxy11111115.report(str4, str3, data2);
                if (jCurrentTimeMillis != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                p.b("TmcPerferenceAnalyse", string11111115, z11);
                com.cloud.tmc.kernel.proxy.performanceanalyse.b.a(pointAnalyseType, string11111115);
                break;
            case 72:
                Unit unit88 = Unit.f68710a;
                str6 = "addMiniAppToDesktop";
                str7 = "";
                str4 = str4;
                str5 = str5;
                jCurrentTimeMillis = 0;
                str3 = str6;
                if (str5 != null) {
                    strA = str7;
                } else {
                    strA = str7;
                }
                if (jCurrentTimeMillis > 0) {
                    strA = "-耗时:" + jCurrentTimeMillis + strA;
                }
                if (jCurrentTimeMillis > 0) {
                    pointAnalyseType = target;
                    if (pointAnalyseType == PointAnalyseType.POINT_RENDER_T1) {
                        TmcLogger.b(l.H(strA, "-", "", false, 4, null));
                    }
                } else {
                    pointAnalyseType = target;
                }
                if (str4 != null) {
                    sb2 = new StringBuilder();
                    sb2.append('[');
                    sb2.append(str4);
                    sb2.append("]:");
                } else {
                    sb2 = new StringBuilder();
                }
                sb2.append(target.getDes());
                sb2.append(strA);
                String string11111116 = sb2.toString();
                ReportProxy reportProxy11111116 = (ReportProxy) tc.a.a(ReportProxy.class);
                data2.putString(PointAnalyseType.class.getSimpleName() + '.' + target.name(), string11111116);
                data = target.getData();
                if (data != null) {
                    Set<Map.Entry<String, Object>> setEntrySet11111116 = data.entrySet();
                    Intrinsics.f(setEntrySet11111116, "it.entries");
                    it = setEntrySet11111116.iterator();
                    while (it.hasNext()) {
                        entry = (Map.Entry) it.next();
                        value = entry.getValue();
                        if (value instanceof String) {
                            String str1111111111111118 = (String) entry.getKey();
                            Object value1111111111111112 = entry.getValue();
                            Intrinsics.e(value1111111111111112, "null cannot be cast to non-null type kotlin.String");
                            data2.putString(str1111111111111118, (String) value1111111111111112);
                        } else if (value instanceof Long) {
                            String str1111111111111119 = (String) entry.getKey();
                            Object value1111111111111113 = entry.getValue();
                            Intrinsics.e(value1111111111111113, "null cannot be cast to non-null type kotlin.Long");
                            data2.putLong(str1111111111111119, ((Long) value1111111111111113).longValue());
                        }
                    }
                    Unit unit1111111111111118 = Unit.f68710a;
                }
                Unit unit1111111111111119 = Unit.f68710a;
                reportProxy11111116.report(str4, str3, data2);
                if (jCurrentTimeMillis != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                p.b("TmcPerferenceAnalyse", string11111116, z11);
                com.cloud.tmc.kernel.proxy.performanceanalyse.b.a(pointAnalyseType, string11111116);
                break;
            case 73:
                Unit unit89 = Unit.f68710a;
                str6 = "preRequestHtml";
                str7 = "";
                str4 = str4;
                str5 = str5;
                jCurrentTimeMillis = 0;
                str3 = str6;
                if (str5 != null) {
                    strA = str7;
                } else {
                    strA = str7;
                }
                if (jCurrentTimeMillis > 0) {
                    strA = "-耗时:" + jCurrentTimeMillis + strA;
                }
                if (jCurrentTimeMillis > 0) {
                    pointAnalyseType = target;
                    if (pointAnalyseType == PointAnalyseType.POINT_RENDER_T1) {
                        TmcLogger.b(l.H(strA, "-", "", false, 4, null));
                    }
                } else {
                    pointAnalyseType = target;
                }
                if (str4 != null) {
                    sb2 = new StringBuilder();
                    sb2.append('[');
                    sb2.append(str4);
                    sb2.append("]:");
                } else {
                    sb2 = new StringBuilder();
                }
                sb2.append(target.getDes());
                sb2.append(strA);
                String string11111117 = sb2.toString();
                ReportProxy reportProxy11111117 = (ReportProxy) tc.a.a(ReportProxy.class);
                data2.putString(PointAnalyseType.class.getSimpleName() + '.' + target.name(), string11111117);
                data = target.getData();
                if (data != null) {
                    Set<Map.Entry<String, Object>> setEntrySet11111117 = data.entrySet();
                    Intrinsics.f(setEntrySet11111117, "it.entries");
                    it = setEntrySet11111117.iterator();
                    while (it.hasNext()) {
                        entry = (Map.Entry) it.next();
                        value = entry.getValue();
                        if (value instanceof String) {
                            String str11111111111111110 = (String) entry.getKey();
                            Object value1111111111111114 = entry.getValue();
                            Intrinsics.e(value1111111111111114, "null cannot be cast to non-null type kotlin.String");
                            data2.putString(str11111111111111110, (String) value1111111111111114);
                        } else if (value instanceof Long) {
                            String str11111111111111111 = (String) entry.getKey();
                            Object value1111111111111115 = entry.getValue();
                            Intrinsics.e(value1111111111111115, "null cannot be cast to non-null type kotlin.Long");
                            data2.putLong(str11111111111111111, ((Long) value1111111111111115).longValue());
                        }
                    }
                    Unit unit11111111111111110 = Unit.f68710a;
                }
                Unit unit11111111111111111 = Unit.f68710a;
                reportProxy11111117.report(str4, str3, data2);
                if (jCurrentTimeMillis != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                p.b("TmcPerferenceAnalyse", string11111117, z11);
                com.cloud.tmc.kernel.proxy.performanceanalyse.b.a(pointAnalyseType, string11111117);
                break;
            case 74:
                Unit unit90 = Unit.f68710a;
                str6 = "preRequestHtmlRet";
                str7 = "";
                str4 = str4;
                str5 = str5;
                jCurrentTimeMillis = 0;
                str3 = str6;
                if (str5 != null) {
                    strA = str7;
                } else {
                    strA = str7;
                }
                if (jCurrentTimeMillis > 0) {
                    strA = "-耗时:" + jCurrentTimeMillis + strA;
                }
                if (jCurrentTimeMillis > 0) {
                    pointAnalyseType = target;
                    if (pointAnalyseType == PointAnalyseType.POINT_RENDER_T1) {
                        TmcLogger.b(l.H(strA, "-", "", false, 4, null));
                    }
                } else {
                    pointAnalyseType = target;
                }
                if (str4 != null) {
                    sb2 = new StringBuilder();
                    sb2.append('[');
                    sb2.append(str4);
                    sb2.append("]:");
                } else {
                    sb2 = new StringBuilder();
                }
                sb2.append(target.getDes());
                sb2.append(strA);
                String string11111118 = sb2.toString();
                ReportProxy reportProxy11111118 = (ReportProxy) tc.a.a(ReportProxy.class);
                data2.putString(PointAnalyseType.class.getSimpleName() + '.' + target.name(), string11111118);
                data = target.getData();
                if (data != null) {
                    Set<Map.Entry<String, Object>> setEntrySet11111118 = data.entrySet();
                    Intrinsics.f(setEntrySet11111118, "it.entries");
                    it = setEntrySet11111118.iterator();
                    while (it.hasNext()) {
                        entry = (Map.Entry) it.next();
                        value = entry.getValue();
                        if (value instanceof String) {
                            String str11111111111111112 = (String) entry.getKey();
                            Object value1111111111111116 = entry.getValue();
                            Intrinsics.e(value1111111111111116, "null cannot be cast to non-null type kotlin.String");
                            data2.putString(str11111111111111112, (String) value1111111111111116);
                        } else if (value instanceof Long) {
                            String str11111111111111113 = (String) entry.getKey();
                            Object value1111111111111117 = entry.getValue();
                            Intrinsics.e(value1111111111111117, "null cannot be cast to non-null type kotlin.Long");
                            data2.putLong(str11111111111111113, ((Long) value1111111111111117).longValue());
                        }
                    }
                    Unit unit11111111111111112 = Unit.f68710a;
                }
                Unit unit11111111111111113 = Unit.f68710a;
                reportProxy11111118.report(str4, str3, data2);
                if (jCurrentTimeMillis != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                p.b("TmcPerferenceAnalyse", string11111118, z11);
                com.cloud.tmc.kernel.proxy.performanceanalyse.b.a(pointAnalyseType, string11111118);
                break;
            case 75:
                Unit unit91 = Unit.f68710a;
                str6 = "getPreHtml";
                str7 = "";
                str4 = str4;
                str5 = str5;
                jCurrentTimeMillis = 0;
                str3 = str6;
                if (str5 != null) {
                    strA = str7;
                } else {
                    strA = str7;
                }
                if (jCurrentTimeMillis > 0) {
                    strA = "-耗时:" + jCurrentTimeMillis + strA;
                }
                if (jCurrentTimeMillis > 0) {
                    pointAnalyseType = target;
                    if (pointAnalyseType == PointAnalyseType.POINT_RENDER_T1) {
                        TmcLogger.b(l.H(strA, "-", "", false, 4, null));
                    }
                } else {
                    pointAnalyseType = target;
                }
                if (str4 != null) {
                    sb2 = new StringBuilder();
                    sb2.append('[');
                    sb2.append(str4);
                    sb2.append("]:");
                } else {
                    sb2 = new StringBuilder();
                }
                sb2.append(target.getDes());
                sb2.append(strA);
                String string11111119 = sb2.toString();
                ReportProxy reportProxy11111119 = (ReportProxy) tc.a.a(ReportProxy.class);
                data2.putString(PointAnalyseType.class.getSimpleName() + '.' + target.name(), string11111119);
                data = target.getData();
                if (data != null) {
                    Set<Map.Entry<String, Object>> setEntrySet11111119 = data.entrySet();
                    Intrinsics.f(setEntrySet11111119, "it.entries");
                    it = setEntrySet11111119.iterator();
                    while (it.hasNext()) {
                        entry = (Map.Entry) it.next();
                        value = entry.getValue();
                        if (value instanceof String) {
                            String str11111111111111114 = (String) entry.getKey();
                            Object value1111111111111118 = entry.getValue();
                            Intrinsics.e(value1111111111111118, "null cannot be cast to non-null type kotlin.String");
                            data2.putString(str11111111111111114, (String) value1111111111111118);
                        } else if (value instanceof Long) {
                            String str11111111111111115 = (String) entry.getKey();
                            Object value1111111111111119 = entry.getValue();
                            Intrinsics.e(value1111111111111119, "null cannot be cast to non-null type kotlin.Long");
                            data2.putLong(str11111111111111115, ((Long) value1111111111111119).longValue());
                        }
                    }
                    Unit unit11111111111111114 = Unit.f68710a;
                }
                Unit unit11111111111111115 = Unit.f68710a;
                reportProxy11111119.report(str4, str3, data2);
                if (jCurrentTimeMillis != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                p.b("TmcPerferenceAnalyse", string11111119, z11);
                com.cloud.tmc.kernel.proxy.performanceanalyse.b.a(pointAnalyseType, string11111119);
                break;
            case 76:
                Unit unit92 = Unit.f68710a;
                str6 = "getPreHtmlHit";
                str7 = "";
                str4 = str4;
                str5 = str5;
                jCurrentTimeMillis = 0;
                str3 = str6;
                if (str5 != null) {
                    strA = str7;
                } else {
                    strA = str7;
                }
                if (jCurrentTimeMillis > 0) {
                    strA = "-耗时:" + jCurrentTimeMillis + strA;
                }
                if (jCurrentTimeMillis > 0) {
                    pointAnalyseType = target;
                    if (pointAnalyseType == PointAnalyseType.POINT_RENDER_T1) {
                        TmcLogger.b(l.H(strA, "-", "", false, 4, null));
                    }
                } else {
                    pointAnalyseType = target;
                }
                if (str4 != null) {
                    sb2 = new StringBuilder();
                    sb2.append('[');
                    sb2.append(str4);
                    sb2.append("]:");
                } else {
                    sb2 = new StringBuilder();
                }
                sb2.append(target.getDes());
                sb2.append(strA);
                String string111111110 = sb2.toString();
                ReportProxy reportProxy111111110 = (ReportProxy) tc.a.a(ReportProxy.class);
                data2.putString(PointAnalyseType.class.getSimpleName() + '.' + target.name(), string111111110);
                data = target.getData();
                if (data != null) {
                    Set<Map.Entry<String, Object>> setEntrySet111111110 = data.entrySet();
                    Intrinsics.f(setEntrySet111111110, "it.entries");
                    it = setEntrySet111111110.iterator();
                    while (it.hasNext()) {
                        entry = (Map.Entry) it.next();
                        value = entry.getValue();
                        if (value instanceof String) {
                            String str11111111111111116 = (String) entry.getKey();
                            Object value11111111111111110 = entry.getValue();
                            Intrinsics.e(value11111111111111110, "null cannot be cast to non-null type kotlin.String");
                            data2.putString(str11111111111111116, (String) value11111111111111110);
                        } else if (value instanceof Long) {
                            String str11111111111111117 = (String) entry.getKey();
                            Object value11111111111111111 = entry.getValue();
                            Intrinsics.e(value11111111111111111, "null cannot be cast to non-null type kotlin.Long");
                            data2.putLong(str11111111111111117, ((Long) value11111111111111111).longValue());
                        }
                    }
                    Unit unit11111111111111116 = Unit.f68710a;
                }
                Unit unit11111111111111117 = Unit.f68710a;
                reportProxy111111110.report(str4, str3, data2);
                if (jCurrentTimeMillis != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                p.b("TmcPerferenceAnalyse", string111111110, z11);
                com.cloud.tmc.kernel.proxy.performanceanalyse.b.a(pointAnalyseType, string111111110);
                break;
            case 77:
                data2.putString("object_id", "27");
                Unit unit93 = Unit.f68710a;
                str6 = "miniapp_click";
                jCurrentTimeMillis = 0;
                str3 = str6;
                if (str5 != null) {
                    strA = str7;
                } else {
                    strA = str7;
                }
                if (jCurrentTimeMillis > 0) {
                    strA = "-耗时:" + jCurrentTimeMillis + strA;
                }
                if (jCurrentTimeMillis > 0) {
                    pointAnalyseType = target;
                    if (pointAnalyseType == PointAnalyseType.POINT_RENDER_T1) {
                        TmcLogger.b(l.H(strA, "-", "", false, 4, null));
                    }
                } else {
                    pointAnalyseType = target;
                }
                if (str4 != null) {
                    sb2 = new StringBuilder();
                    sb2.append('[');
                    sb2.append(str4);
                    sb2.append("]:");
                } else {
                    sb2 = new StringBuilder();
                }
                sb2.append(target.getDes());
                sb2.append(strA);
                String string111111111 = sb2.toString();
                ReportProxy reportProxy111111111 = (ReportProxy) tc.a.a(ReportProxy.class);
                data2.putString(PointAnalyseType.class.getSimpleName() + '.' + target.name(), string111111111);
                data = target.getData();
                if (data != null) {
                    Set<Map.Entry<String, Object>> setEntrySet111111111 = data.entrySet();
                    Intrinsics.f(setEntrySet111111111, "it.entries");
                    it = setEntrySet111111111.iterator();
                    while (it.hasNext()) {
                        entry = (Map.Entry) it.next();
                        value = entry.getValue();
                        if (value instanceof String) {
                            String str11111111111111118 = (String) entry.getKey();
                            Object value11111111111111112 = entry.getValue();
                            Intrinsics.e(value11111111111111112, "null cannot be cast to non-null type kotlin.String");
                            data2.putString(str11111111111111118, (String) value11111111111111112);
                        } else if (value instanceof Long) {
                            String str11111111111111119 = (String) entry.getKey();
                            Object value11111111111111113 = entry.getValue();
                            Intrinsics.e(value11111111111111113, "null cannot be cast to non-null type kotlin.Long");
                            data2.putLong(str11111111111111119, ((Long) value11111111111111113).longValue());
                        }
                    }
                    Unit unit11111111111111118 = Unit.f68710a;
                }
                Unit unit11111111111111119 = Unit.f68710a;
                reportProxy111111111.report(str4, str3, data2);
                if (jCurrentTimeMillis != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                p.b("TmcPerferenceAnalyse", string111111111, z11);
                com.cloud.tmc.kernel.proxy.performanceanalyse.b.a(pointAnalyseType, string111111111);
                break;
            case 78:
                Unit unit94 = Unit.f68710a;
                str6 = "preStrategyFail";
                str7 = "";
                str4 = str4;
                str5 = str5;
                jCurrentTimeMillis = 0;
                str3 = str6;
                if (str5 != null) {
                    strA = str7;
                } else {
                    strA = str7;
                }
                if (jCurrentTimeMillis > 0) {
                    strA = "-耗时:" + jCurrentTimeMillis + strA;
                }
                if (jCurrentTimeMillis > 0) {
                    pointAnalyseType = target;
                    if (pointAnalyseType == PointAnalyseType.POINT_RENDER_T1) {
                        TmcLogger.b(l.H(strA, "-", "", false, 4, null));
                    }
                } else {
                    pointAnalyseType = target;
                }
                if (str4 != null) {
                    sb2 = new StringBuilder();
                    sb2.append('[');
                    sb2.append(str4);
                    sb2.append("]:");
                } else {
                    sb2 = new StringBuilder();
                }
                sb2.append(target.getDes());
                sb2.append(strA);
                String string111111112 = sb2.toString();
                ReportProxy reportProxy111111112 = (ReportProxy) tc.a.a(ReportProxy.class);
                data2.putString(PointAnalyseType.class.getSimpleName() + '.' + target.name(), string111111112);
                data = target.getData();
                if (data != null) {
                    Set<Map.Entry<String, Object>> setEntrySet111111112 = data.entrySet();
                    Intrinsics.f(setEntrySet111111112, "it.entries");
                    it = setEntrySet111111112.iterator();
                    while (it.hasNext()) {
                        entry = (Map.Entry) it.next();
                        value = entry.getValue();
                        if (value instanceof String) {
                            String str111111111111111110 = (String) entry.getKey();
                            Object value11111111111111114 = entry.getValue();
                            Intrinsics.e(value11111111111111114, "null cannot be cast to non-null type kotlin.String");
                            data2.putString(str111111111111111110, (String) value11111111111111114);
                        } else if (value instanceof Long) {
                            String str111111111111111111 = (String) entry.getKey();
                            Object value11111111111111115 = entry.getValue();
                            Intrinsics.e(value11111111111111115, "null cannot be cast to non-null type kotlin.Long");
                            data2.putLong(str111111111111111111, ((Long) value11111111111111115).longValue());
                        }
                    }
                    Unit unit111111111111111110 = Unit.f68710a;
                }
                Unit unit111111111111111111 = Unit.f68710a;
                reportProxy111111112.report(str4, str3, data2);
                if (jCurrentTimeMillis != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                p.b("TmcPerferenceAnalyse", string111111112, z11);
                com.cloud.tmc.kernel.proxy.performanceanalyse.b.a(pointAnalyseType, string111111112);
                break;
            case 79:
                Unit unit95 = Unit.f68710a;
                str6 = "later_offline_ex";
                str7 = "";
                str4 = str4;
                str5 = str5;
                jCurrentTimeMillis = 0;
                str3 = str6;
                if (str5 != null) {
                    strA = str7;
                } else {
                    strA = str7;
                }
                if (jCurrentTimeMillis > 0) {
                    strA = "-耗时:" + jCurrentTimeMillis + strA;
                }
                if (jCurrentTimeMillis > 0) {
                    pointAnalyseType = target;
                    if (pointAnalyseType == PointAnalyseType.POINT_RENDER_T1) {
                        TmcLogger.b(l.H(strA, "-", "", false, 4, null));
                    }
                } else {
                    pointAnalyseType = target;
                }
                if (str4 != null) {
                    sb2 = new StringBuilder();
                    sb2.append('[');
                    sb2.append(str4);
                    sb2.append("]:");
                } else {
                    sb2 = new StringBuilder();
                }
                sb2.append(target.getDes());
                sb2.append(strA);
                String string111111113 = sb2.toString();
                ReportProxy reportProxy111111113 = (ReportProxy) tc.a.a(ReportProxy.class);
                data2.putString(PointAnalyseType.class.getSimpleName() + '.' + target.name(), string111111113);
                data = target.getData();
                if (data != null) {
                    Set<Map.Entry<String, Object>> setEntrySet111111113 = data.entrySet();
                    Intrinsics.f(setEntrySet111111113, "it.entries");
                    it = setEntrySet111111113.iterator();
                    while (it.hasNext()) {
                        entry = (Map.Entry) it.next();
                        value = entry.getValue();
                        if (value instanceof String) {
                            String str111111111111111112 = (String) entry.getKey();
                            Object value11111111111111116 = entry.getValue();
                            Intrinsics.e(value11111111111111116, "null cannot be cast to non-null type kotlin.String");
                            data2.putString(str111111111111111112, (String) value11111111111111116);
                        } else if (value instanceof Long) {
                            String str111111111111111113 = (String) entry.getKey();
                            Object value11111111111111117 = entry.getValue();
                            Intrinsics.e(value11111111111111117, "null cannot be cast to non-null type kotlin.Long");
                            data2.putLong(str111111111111111113, ((Long) value11111111111111117).longValue());
                        }
                    }
                    Unit unit111111111111111112 = Unit.f68710a;
                }
                Unit unit111111111111111113 = Unit.f68710a;
                reportProxy111111113.report(str4, str3, data2);
                if (jCurrentTimeMillis != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                p.b("TmcPerferenceAnalyse", string111111113, z11);
                com.cloud.tmc.kernel.proxy.performanceanalyse.b.a(pointAnalyseType, string111111113);
                break;
            case 80:
                Unit unit96 = Unit.f68710a;
                str6 = "later_offline_app_ex";
                str7 = "";
                str4 = str4;
                str5 = str5;
                jCurrentTimeMillis = 0;
                str3 = str6;
                if (str5 != null) {
                    strA = str7;
                } else {
                    strA = str7;
                }
                if (jCurrentTimeMillis > 0) {
                    strA = "-耗时:" + jCurrentTimeMillis + strA;
                }
                if (jCurrentTimeMillis > 0) {
                    pointAnalyseType = target;
                    if (pointAnalyseType == PointAnalyseType.POINT_RENDER_T1) {
                        TmcLogger.b(l.H(strA, "-", "", false, 4, null));
                    }
                } else {
                    pointAnalyseType = target;
                }
                if (str4 != null) {
                    sb2 = new StringBuilder();
                    sb2.append('[');
                    sb2.append(str4);
                    sb2.append("]:");
                } else {
                    sb2 = new StringBuilder();
                }
                sb2.append(target.getDes());
                sb2.append(strA);
                String string111111114 = sb2.toString();
                ReportProxy reportProxy111111114 = (ReportProxy) tc.a.a(ReportProxy.class);
                data2.putString(PointAnalyseType.class.getSimpleName() + '.' + target.name(), string111111114);
                data = target.getData();
                if (data != null) {
                    Set<Map.Entry<String, Object>> setEntrySet111111114 = data.entrySet();
                    Intrinsics.f(setEntrySet111111114, "it.entries");
                    it = setEntrySet111111114.iterator();
                    while (it.hasNext()) {
                        entry = (Map.Entry) it.next();
                        value = entry.getValue();
                        if (value instanceof String) {
                            String str111111111111111114 = (String) entry.getKey();
                            Object value11111111111111118 = entry.getValue();
                            Intrinsics.e(value11111111111111118, "null cannot be cast to non-null type kotlin.String");
                            data2.putString(str111111111111111114, (String) value11111111111111118);
                        } else if (value instanceof Long) {
                            String str111111111111111115 = (String) entry.getKey();
                            Object value11111111111111119 = entry.getValue();
                            Intrinsics.e(value11111111111111119, "null cannot be cast to non-null type kotlin.Long");
                            data2.putLong(str111111111111111115, ((Long) value11111111111111119).longValue());
                        }
                    }
                    Unit unit111111111111111114 = Unit.f68710a;
                }
                Unit unit111111111111111115 = Unit.f68710a;
                reportProxy111111114.report(str4, str3, data2);
                if (jCurrentTimeMillis != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                p.b("TmcPerferenceAnalyse", string111111114, z11);
                com.cloud.tmc.kernel.proxy.performanceanalyse.b.a(pointAnalyseType, string111111114);
                break;
            case 81:
                Unit unit97 = Unit.f68710a;
                str6 = "later_offline_click";
                str7 = "";
                str4 = str4;
                str5 = str5;
                jCurrentTimeMillis = 0;
                str3 = str6;
                if (str5 != null) {
                    strA = str7;
                } else {
                    strA = str7;
                }
                if (jCurrentTimeMillis > 0) {
                    strA = "-耗时:" + jCurrentTimeMillis + strA;
                }
                if (jCurrentTimeMillis > 0) {
                    pointAnalyseType = target;
                    if (pointAnalyseType == PointAnalyseType.POINT_RENDER_T1) {
                        TmcLogger.b(l.H(strA, "-", "", false, 4, null));
                    }
                } else {
                    pointAnalyseType = target;
                }
                if (str4 != null) {
                    sb2 = new StringBuilder();
                    sb2.append('[');
                    sb2.append(str4);
                    sb2.append("]:");
                } else {
                    sb2 = new StringBuilder();
                }
                sb2.append(target.getDes());
                sb2.append(strA);
                String string111111115 = sb2.toString();
                ReportProxy reportProxy111111115 = (ReportProxy) tc.a.a(ReportProxy.class);
                data2.putString(PointAnalyseType.class.getSimpleName() + '.' + target.name(), string111111115);
                data = target.getData();
                if (data != null) {
                    Set<Map.Entry<String, Object>> setEntrySet111111115 = data.entrySet();
                    Intrinsics.f(setEntrySet111111115, "it.entries");
                    it = setEntrySet111111115.iterator();
                    while (it.hasNext()) {
                        entry = (Map.Entry) it.next();
                        value = entry.getValue();
                        if (value instanceof String) {
                            String str111111111111111116 = (String) entry.getKey();
                            Object value111111111111111110 = entry.getValue();
                            Intrinsics.e(value111111111111111110, "null cannot be cast to non-null type kotlin.String");
                            data2.putString(str111111111111111116, (String) value111111111111111110);
                        } else if (value instanceof Long) {
                            String str111111111111111117 = (String) entry.getKey();
                            Object value111111111111111111 = entry.getValue();
                            Intrinsics.e(value111111111111111111, "null cannot be cast to non-null type kotlin.Long");
                            data2.putLong(str111111111111111117, ((Long) value111111111111111111).longValue());
                        }
                    }
                    Unit unit111111111111111116 = Unit.f68710a;
                }
                Unit unit111111111111111117 = Unit.f68710a;
                reportProxy111111115.report(str4, str3, data2);
                if (jCurrentTimeMillis != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                p.b("TmcPerferenceAnalyse", string111111115, z11);
                com.cloud.tmc.kernel.proxy.performanceanalyse.b.a(pointAnalyseType, string111111115);
                break;
            case 82:
                Unit unit98 = Unit.f68710a;
                str6 = "get-add-ex";
                str7 = "";
                str4 = str4;
                str5 = str5;
                jCurrentTimeMillis = 0;
                str3 = str6;
                if (str5 != null) {
                    strA = str7;
                } else {
                    strA = str7;
                }
                if (jCurrentTimeMillis > 0) {
                    strA = "-耗时:" + jCurrentTimeMillis + strA;
                }
                if (jCurrentTimeMillis > 0) {
                    pointAnalyseType = target;
                    if (pointAnalyseType == PointAnalyseType.POINT_RENDER_T1) {
                        TmcLogger.b(l.H(strA, "-", "", false, 4, null));
                    }
                } else {
                    pointAnalyseType = target;
                }
                if (str4 != null) {
                    sb2 = new StringBuilder();
                    sb2.append('[');
                    sb2.append(str4);
                    sb2.append("]:");
                } else {
                    sb2 = new StringBuilder();
                }
                sb2.append(target.getDes());
                sb2.append(strA);
                String string111111116 = sb2.toString();
                ReportProxy reportProxy111111116 = (ReportProxy) tc.a.a(ReportProxy.class);
                data2.putString(PointAnalyseType.class.getSimpleName() + '.' + target.name(), string111111116);
                data = target.getData();
                if (data != null) {
                    Set<Map.Entry<String, Object>> setEntrySet111111116 = data.entrySet();
                    Intrinsics.f(setEntrySet111111116, "it.entries");
                    it = setEntrySet111111116.iterator();
                    while (it.hasNext()) {
                        entry = (Map.Entry) it.next();
                        value = entry.getValue();
                        if (value instanceof String) {
                            String str111111111111111118 = (String) entry.getKey();
                            Object value111111111111111112 = entry.getValue();
                            Intrinsics.e(value111111111111111112, "null cannot be cast to non-null type kotlin.String");
                            data2.putString(str111111111111111118, (String) value111111111111111112);
                        } else if (value instanceof Long) {
                            String str111111111111111119 = (String) entry.getKey();
                            Object value111111111111111113 = entry.getValue();
                            Intrinsics.e(value111111111111111113, "null cannot be cast to non-null type kotlin.Long");
                            data2.putLong(str111111111111111119, ((Long) value111111111111111113).longValue());
                        }
                    }
                    Unit unit111111111111111118 = Unit.f68710a;
                }
                Unit unit111111111111111119 = Unit.f68710a;
                reportProxy111111116.report(str4, str3, data2);
                if (jCurrentTimeMillis != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                p.b("TmcPerferenceAnalyse", string111111116, z11);
                com.cloud.tmc.kernel.proxy.performanceanalyse.b.a(pointAnalyseType, string111111116);
                break;
            case 83:
                Unit unit99 = Unit.f68710a;
                str6 = "get-toast-add-ex";
                str7 = "";
                str4 = str4;
                str5 = str5;
                jCurrentTimeMillis = 0;
                str3 = str6;
                if (str5 != null) {
                    strA = str7;
                } else {
                    strA = str7;
                }
                if (jCurrentTimeMillis > 0) {
                    strA = "-耗时:" + jCurrentTimeMillis + strA;
                }
                if (jCurrentTimeMillis > 0) {
                    pointAnalyseType = target;
                    if (pointAnalyseType == PointAnalyseType.POINT_RENDER_T1) {
                        TmcLogger.b(l.H(strA, "-", "", false, 4, null));
                    }
                } else {
                    pointAnalyseType = target;
                }
                if (str4 != null) {
                    sb2 = new StringBuilder();
                    sb2.append('[');
                    sb2.append(str4);
                    sb2.append("]:");
                } else {
                    sb2 = new StringBuilder();
                }
                sb2.append(target.getDes());
                sb2.append(strA);
                String string111111117 = sb2.toString();
                ReportProxy reportProxy111111117 = (ReportProxy) tc.a.a(ReportProxy.class);
                data2.putString(PointAnalyseType.class.getSimpleName() + '.' + target.name(), string111111117);
                data = target.getData();
                if (data != null) {
                    Set<Map.Entry<String, Object>> setEntrySet111111117 = data.entrySet();
                    Intrinsics.f(setEntrySet111111117, "it.entries");
                    it = setEntrySet111111117.iterator();
                    while (it.hasNext()) {
                        entry = (Map.Entry) it.next();
                        value = entry.getValue();
                        if (value instanceof String) {
                            String str1111111111111111110 = (String) entry.getKey();
                            Object value111111111111111114 = entry.getValue();
                            Intrinsics.e(value111111111111111114, "null cannot be cast to non-null type kotlin.String");
                            data2.putString(str1111111111111111110, (String) value111111111111111114);
                        } else if (value instanceof Long) {
                            String str1111111111111111111 = (String) entry.getKey();
                            Object value111111111111111115 = entry.getValue();
                            Intrinsics.e(value111111111111111115, "null cannot be cast to non-null type kotlin.Long");
                            data2.putLong(str1111111111111111111, ((Long) value111111111111111115).longValue());
                        }
                    }
                    Unit unit1111111111111111110 = Unit.f68710a;
                }
                Unit unit1111111111111111111 = Unit.f68710a;
                reportProxy111111117.report(str4, str3, data2);
                if (jCurrentTimeMillis != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                p.b("TmcPerferenceAnalyse", string111111117, z11);
                com.cloud.tmc.kernel.proxy.performanceanalyse.b.a(pointAnalyseType, string111111117);
                break;
            case 84:
                Unit unit100 = Unit.f68710a;
                str6 = "get-add-click";
                str7 = "";
                str4 = str4;
                str5 = str5;
                jCurrentTimeMillis = 0;
                str3 = str6;
                if (str5 != null) {
                    strA = str7;
                } else {
                    strA = str7;
                }
                if (jCurrentTimeMillis > 0) {
                    strA = "-耗时:" + jCurrentTimeMillis + strA;
                }
                if (jCurrentTimeMillis > 0) {
                    pointAnalyseType = target;
                    if (pointAnalyseType == PointAnalyseType.POINT_RENDER_T1) {
                        TmcLogger.b(l.H(strA, "-", "", false, 4, null));
                    }
                } else {
                    pointAnalyseType = target;
                }
                if (str4 != null) {
                    sb2 = new StringBuilder();
                    sb2.append('[');
                    sb2.append(str4);
                    sb2.append("]:");
                } else {
                    sb2 = new StringBuilder();
                }
                sb2.append(target.getDes());
                sb2.append(strA);
                String string111111118 = sb2.toString();
                ReportProxy reportProxy111111118 = (ReportProxy) tc.a.a(ReportProxy.class);
                data2.putString(PointAnalyseType.class.getSimpleName() + '.' + target.name(), string111111118);
                data = target.getData();
                if (data != null) {
                    Set<Map.Entry<String, Object>> setEntrySet111111118 = data.entrySet();
                    Intrinsics.f(setEntrySet111111118, "it.entries");
                    it = setEntrySet111111118.iterator();
                    while (it.hasNext()) {
                        entry = (Map.Entry) it.next();
                        value = entry.getValue();
                        if (value instanceof String) {
                            String str1111111111111111112 = (String) entry.getKey();
                            Object value111111111111111116 = entry.getValue();
                            Intrinsics.e(value111111111111111116, "null cannot be cast to non-null type kotlin.String");
                            data2.putString(str1111111111111111112, (String) value111111111111111116);
                        } else if (value instanceof Long) {
                            String str1111111111111111113 = (String) entry.getKey();
                            Object value111111111111111117 = entry.getValue();
                            Intrinsics.e(value111111111111111117, "null cannot be cast to non-null type kotlin.Long");
                            data2.putLong(str1111111111111111113, ((Long) value111111111111111117).longValue());
                        }
                    }
                    Unit unit1111111111111111112 = Unit.f68710a;
                }
                Unit unit1111111111111111113 = Unit.f68710a;
                reportProxy111111118.report(str4, str3, data2);
                if (jCurrentTimeMillis != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                p.b("TmcPerferenceAnalyse", string111111118, z11);
                com.cloud.tmc.kernel.proxy.performanceanalyse.b.a(pointAnalyseType, string111111118);
                break;
            case 85:
                Unit unit101 = Unit.f68710a;
                str6 = "get-add-noshow";
                str7 = "";
                str4 = str4;
                str5 = str5;
                jCurrentTimeMillis = 0;
                str3 = str6;
                if (str5 != null) {
                    strA = str7;
                } else {
                    strA = str7;
                }
                if (jCurrentTimeMillis > 0) {
                    strA = "-耗时:" + jCurrentTimeMillis + strA;
                }
                if (jCurrentTimeMillis > 0) {
                    pointAnalyseType = target;
                    if (pointAnalyseType == PointAnalyseType.POINT_RENDER_T1) {
                        TmcLogger.b(l.H(strA, "-", "", false, 4, null));
                    }
                } else {
                    pointAnalyseType = target;
                }
                if (str4 != null) {
                    sb2 = new StringBuilder();
                    sb2.append('[');
                    sb2.append(str4);
                    sb2.append("]:");
                } else {
                    sb2 = new StringBuilder();
                }
                sb2.append(target.getDes());
                sb2.append(strA);
                String string111111119 = sb2.toString();
                ReportProxy reportProxy111111119 = (ReportProxy) tc.a.a(ReportProxy.class);
                data2.putString(PointAnalyseType.class.getSimpleName() + '.' + target.name(), string111111119);
                data = target.getData();
                if (data != null) {
                    Set<Map.Entry<String, Object>> setEntrySet111111119 = data.entrySet();
                    Intrinsics.f(setEntrySet111111119, "it.entries");
                    it = setEntrySet111111119.iterator();
                    while (it.hasNext()) {
                        entry = (Map.Entry) it.next();
                        value = entry.getValue();
                        if (value instanceof String) {
                            String str1111111111111111114 = (String) entry.getKey();
                            Object value111111111111111118 = entry.getValue();
                            Intrinsics.e(value111111111111111118, "null cannot be cast to non-null type kotlin.String");
                            data2.putString(str1111111111111111114, (String) value111111111111111118);
                        } else if (value instanceof Long) {
                            String str1111111111111111115 = (String) entry.getKey();
                            Object value111111111111111119 = entry.getValue();
                            Intrinsics.e(value111111111111111119, "null cannot be cast to non-null type kotlin.Long");
                            data2.putLong(str1111111111111111115, ((Long) value111111111111111119).longValue());
                        }
                    }
                    Unit unit1111111111111111114 = Unit.f68710a;
                }
                Unit unit1111111111111111115 = Unit.f68710a;
                reportProxy111111119.report(str4, str3, data2);
                if (jCurrentTimeMillis != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                p.b("TmcPerferenceAnalyse", string111111119, z11);
                com.cloud.tmc.kernel.proxy.performanceanalyse.b.a(pointAnalyseType, string111111119);
                break;
            default:
                Unit unit102 = Unit.f68710a;
                str7 = "";
                str4 = str4;
                str5 = str5;
                str6 = str7;
                jCurrentTimeMillis = 0;
                str3 = str6;
                if (str5 != null) {
                    strA = str7;
                } else {
                    strA = str7;
                }
                if (jCurrentTimeMillis > 0) {
                    strA = "-耗时:" + jCurrentTimeMillis + strA;
                }
                if (jCurrentTimeMillis > 0) {
                    pointAnalyseType = target;
                    if (pointAnalyseType == PointAnalyseType.POINT_RENDER_T1) {
                        TmcLogger.b(l.H(strA, "-", "", false, 4, null));
                    }
                } else {
                    pointAnalyseType = target;
                }
                if (str4 != null) {
                    sb2 = new StringBuilder();
                    sb2.append('[');
                    sb2.append(str4);
                    sb2.append("]:");
                } else {
                    sb2 = new StringBuilder();
                }
                sb2.append(target.getDes());
                sb2.append(strA);
                String string1111111110 = sb2.toString();
                ReportProxy reportProxy1111111110 = (ReportProxy) tc.a.a(ReportProxy.class);
                data2.putString(PointAnalyseType.class.getSimpleName() + '.' + target.name(), string1111111110);
                data = target.getData();
                if (data != null) {
                    Set<Map.Entry<String, Object>> setEntrySet1111111110 = data.entrySet();
                    Intrinsics.f(setEntrySet1111111110, "it.entries");
                    it = setEntrySet1111111110.iterator();
                    while (it.hasNext()) {
                        entry = (Map.Entry) it.next();
                        value = entry.getValue();
                        if (value instanceof String) {
                            String str1111111111111111116 = (String) entry.getKey();
                            Object value1111111111111111110 = entry.getValue();
                            Intrinsics.e(value1111111111111111110, "null cannot be cast to non-null type kotlin.String");
                            data2.putString(str1111111111111111116, (String) value1111111111111111110);
                        } else if (value instanceof Long) {
                            String str1111111111111111117 = (String) entry.getKey();
                            Object value1111111111111111111 = entry.getValue();
                            Intrinsics.e(value1111111111111111111, "null cannot be cast to non-null type kotlin.Long");
                            data2.putLong(str1111111111111111117, ((Long) value1111111111111111111).longValue());
                        }
                    }
                    Unit unit1111111111111111116 = Unit.f68710a;
                }
                Unit unit1111111111111111117 = Unit.f68710a;
                reportProxy1111111110.report(str4, str3, data2);
                if (jCurrentTimeMillis != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                p.b("TmcPerferenceAnalyse", string1111111110, z11);
                com.cloud.tmc.kernel.proxy.performanceanalyse.b.a(pointAnalyseType, string1111111110);
                break;
        }
    }

    public final void g(String str, String str2, Bundle bundle, String str3, String str4) {
        String str5;
        Map<String, f> map;
        f fVar;
        Map<String, f> map2;
        f fVar2;
        Map<String, f> map3;
        f fVar3;
        Map<String, f> map4;
        f fVar4;
        String str6;
        Map<String, f> map5;
        f fVar5;
        tb.b appContext;
        Map<String, f> map6;
        f fVar6;
        Map<String, Long> map7;
        TmcLogger.c("oldChain", "reportPage -> appId:" + str + ", pagePath:" + str2 + ", miniappId:" + str3 + ", reportPagePath:" + str4);
        try {
            d(str3);
            c(bundle, str3);
            try {
                g0.e.f65310a.b();
            } catch (Throwable th2) {
                TmcLogger.g("PointTrack", "tryInitAthena failed!", th2);
            }
            bundle.putString("object_id", "300");
            q.b bVar = this.f74098d.get(str);
            if (bVar != null && (map6 = bVar.f74073e) != null && (fVar6 = map6.get(str2)) != null && (map7 = fVar6.f74087d) != null) {
                for (Map.Entry<String, Long> entry : map7.entrySet()) {
                    bundle.putLong("chain_id_" + entry.getKey(), entry.getValue().longValue());
                }
            }
            bundle.putString("page_path", str4);
            bundle.putString("open_page_status", "true");
            String str7 = null;
            if (str3 != null) {
                App appFindApp = ((AppManager) tc.a.a(AppManager.class)).findApp(str3);
                Context context = (appFindApp == null || (appContext = appFindApp.getAppContext()) == null) ? null : appContext.getContext();
                BaseActivity baseActivity = context instanceof BaseActivity ? (BaseActivity) context : null;
                bundle.putString("isForeground", String.valueOf(baseActivity != null ? Boolean.valueOf(baseActivity.getMStarted()) : null));
            }
            q.b bVar2 = this.f74098d.get(str);
            bundle.putInt("downloadFrameworkMode", bVar2 != null ? bVar2.f74074f : -1);
            q.b bVar3 = this.f74098d.get(str);
            String str8 = "";
            if (bVar3 == null || (map5 = bVar3.f74073e) == null || (fVar5 = map5.get(str2)) == null || (str5 = fVar5.f74088e) == null) {
                str5 = "";
            }
            bundle.putString("pageH5ProgressStatus", str5);
            q.b bVar4 = this.f74098d.get(str);
            if (bVar4 != null && (map4 = bVar4.f74073e) != null && (fVar4 = map4.get(str2)) != null && (str6 = fVar4.f74089f) != null) {
                str8 = str6;
            }
            bundle.putString("pageDomContentLoadedStatus", str8);
            q.b bVar5 = this.f74098d.get(str);
            bundle.putInt("downloadAppMode", bVar5 != null ? bVar5.f74075g : -1);
            q.b bVar6 = this.f74098d.get(str);
            bundle.putInt("zipFrameworkMode", bVar6 != null ? bVar6.f74076h : -1);
            q.b bVar7 = this.f74098d.get(str);
            bundle.putInt("zipAppMode", bVar7 != null ? bVar7.f74077i : -1);
            String str9 = "chain_id_" + com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31231s;
            ICommunicationTimeProxy iCommunicationTimeProxy = (ICommunicationTimeProxy) tc.a.a(ICommunicationTimeProxy.class);
            q.b bVar8 = this.f74098d.get(str);
            bundle.putLong(str9, iCommunicationTimeProxy.getTotalTime((bVar8 == null || (map3 = bVar8.f74073e) == null || (fVar3 = map3.get(str2)) == null) ? null : fVar3.f74085b));
            String str10 = "chain_id_" + com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31232t;
            ICommunicationTimeProxy iCommunicationTimeProxy2 = (ICommunicationTimeProxy) tc.a.a(ICommunicationTimeProxy.class);
            q.b bVar9 = this.f74098d.get(str);
            bundle.putInt(str10, iCommunicationTimeProxy2.getTotalNum((bVar9 == null || (map2 = bVar9.f74073e) == null || (fVar2 = map2.get(str2)) == null) ? null : fVar2.f74085b));
            q.b bVar10 = this.f74098d.get(str);
            if (bVar10 != null && (map = bVar10.f74073e) != null && (fVar = map.get(str2)) != null) {
                str7 = fVar.f74090g;
            }
            bundle.putString("navigationType", str7);
        } catch (Throwable unused) {
        }
    }

    public final void h(Bundle bundle) {
        Map<String, f> map;
        f fVar;
        try {
            String string = bundle.getString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.L, "");
            String string2 = bundle.getString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.M, "");
            if (this.f74098d.containsKey(string2)) {
                if (Intrinsics.b(MBridgeConstans.DYNAMIC_VIEW_WX_APP, string)) {
                    q.b bVar = this.f74098d.get(string2);
                    if (bVar != null) {
                        if (bundle.containsKey(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31200a0)) {
                            bVar.f74074f = bundle.getInt(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31200a0, 0);
                        } else if (bundle.containsKey(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31204c0)) {
                            bVar.f74075g = bundle.getInt(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31204c0, 0);
                        } else if (bundle.containsKey(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31202b0)) {
                            bVar.f74076h = bundle.getInt(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31202b0, 0);
                        } else if (bundle.containsKey(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31206d0)) {
                            bVar.f74077i = bundle.getInt(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31206d0, 0);
                        } else if (bundle.containsKey(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31216i0)) {
                            String string3 = bundle.getString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31216i0, "");
                            Intrinsics.f(string3, "bundle.getString(APP_H5_PROGRESS_STATUS, \"\")");
                            Intrinsics.g(string3, "<set-?>");
                            bVar.f74079k = string3;
                        } else if (bundle.containsKey(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31222l0)) {
                            String string4 = bundle.getString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31222l0, "");
                            Intrinsics.f(string4, "bundle.getString(APP_DOMCONTENTLOADED_STATUS, \"\")");
                            Intrinsics.g(string4, "<set-?>");
                            bVar.f74080l = string4;
                        } else if (bundle.containsKey(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31218j0)) {
                            bVar.f74083o = bundle.getBoolean(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31218j0, false);
                        }
                    }
                } else if (Intrinsics.b("page", string)) {
                    String string5 = bundle.getString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.N, "");
                    q.b bVar2 = this.f74098d.get(string2);
                    if (bVar2 != null && (map = bVar2.f74073e) != null && (fVar = map.get(string5)) != null) {
                        if (bundle.containsKey(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31220k0)) {
                            String string6 = bundle.getString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31220k0, "");
                            Intrinsics.f(string6, "bundle.getString(PAGE_H5_PROGRESS_STATUS, \"\")");
                            Intrinsics.g(string6, "<set-?>");
                            fVar.f74088e = string6;
                        } else if (bundle.containsKey(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31224m0)) {
                            String string7 = bundle.getString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31224m0, "");
                            Intrinsics.f(string7, "bundle.getString(PAGE_DOMCONTENTLOADED_STATUS, \"\")");
                            Intrinsics.g(string7, "<set-?>");
                            fVar.f74089f = string7;
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            TmcLogger.e("chainInsert fail:" + th2);
        }
    }
}
