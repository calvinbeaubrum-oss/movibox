package com.cloud.tmc.miniapp.ad;

import android.content.Context;
import android.text.TextUtils;
import com.cloud.tmc.ad.IAdManagerProxy;
import com.cloud.tmc.ad.bean.AdShowBean;
import com.cloud.tmc.ad.bean.AdStyleBean;
import com.cloud.tmc.ad.bean.response.AdsDTO;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.utils.g;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.miniapp.NewTaskManager;
import com.cloud.tmc.miniapp.ad.interstitial.AdInterstitialHtmlView$Builder;
import hd.j;
import ia.c;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import jd.f;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@SourceDebugExtension
public final class AdManager implements IAdManagerProxy {
    public static final b Companion = new b();
    public static final String TAG = "AdManager";
    public final ConcurrentHashMap<String, a> OooO00o = new ConcurrentHashMap<>();
    public String OooO0O0;
    public Long OooO0OO;

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f31326a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ConcurrentHashMap<String, jd.b> f31327b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ConcurrentHashMap<String, jd.b> f31328c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final ConcurrentHashMap<String, ia.a> f31329d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final ConcurrentHashMap<String, ia.b> f31330e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final ConcurrentHashMap<String, c> f31331f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final ConcurrentLinkedQueue<String> f31332g;

        public a() {
            this(null, null, null, null, null, null, null, 127);
        }

        public a(String str, ConcurrentHashMap<String, jd.b> htmlContextMap, ConcurrentHashMap<String, jd.b> allStyleContextMap, ConcurrentHashMap<String, ia.a> adEventlistenerMap, ConcurrentHashMap<String, ia.b> adFillingEventlistenerMap, ConcurrentHashMap<String, c> adShowEventListenerMap, ConcurrentLinkedQueue<String> adShowList) {
            Intrinsics.g(htmlContextMap, "htmlContextMap");
            Intrinsics.g(allStyleContextMap, "allStyleContextMap");
            Intrinsics.g(adEventlistenerMap, "adEventlistenerMap");
            Intrinsics.g(adFillingEventlistenerMap, "adFillingEventlistenerMap");
            Intrinsics.g(adShowEventListenerMap, "adShowEventListenerMap");
            Intrinsics.g(adShowList, "adShowList");
            this.f31326a = str;
            this.f31327b = htmlContextMap;
            this.f31328c = allStyleContextMap;
            this.f31329d = adEventlistenerMap;
            this.f31330e = adFillingEventlistenerMap;
            this.f31331f = adShowEventListenerMap;
            this.f31332g = adShowList;
        }

        public /* synthetic */ a(String str, ConcurrentHashMap concurrentHashMap, ConcurrentHashMap concurrentHashMap2, ConcurrentHashMap concurrentHashMap3, ConcurrentHashMap concurrentHashMap4, ConcurrentHashMap concurrentHashMap5, ConcurrentLinkedQueue concurrentLinkedQueue, int i11) {
            this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? new ConcurrentHashMap() : null, (i11 & 4) != 0 ? new ConcurrentHashMap() : null, (i11 & 8) != 0 ? new ConcurrentHashMap() : null, (i11 & 16) != 0 ? new ConcurrentHashMap() : null, (i11 & 32) != 0 ? new ConcurrentHashMap() : null, (i11 & 64) != 0 ? new ConcurrentLinkedQueue() : null);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics.b(this.f31326a, aVar.f31326a) && Intrinsics.b(this.f31327b, aVar.f31327b) && Intrinsics.b(this.f31328c, aVar.f31328c) && Intrinsics.b(this.f31329d, aVar.f31329d) && Intrinsics.b(this.f31330e, aVar.f31330e) && Intrinsics.b(this.f31331f, aVar.f31331f) && Intrinsics.b(this.f31332g, aVar.f31332g);
        }

        public int hashCode() {
            String str = this.f31326a;
            return this.f31332g.hashCode() + ((this.f31331f.hashCode() + ((this.f31330e.hashCode() + ((this.f31329d.hashCode() + ((this.f31328c.hashCode() + ((this.f31327b.hashCode() + ((str == null ? 0 : str.hashCode()) * 31)) * 31)) * 31)) * 31)) * 31)) * 31);
        }

        public String toString() {
            StringBuilder sbA = j.a("AppAdData(appId=");
            sbA.append(this.f31326a);
            sbA.append(", htmlContextMap=");
            sbA.append(this.f31327b);
            sbA.append(", allStyleContextMap=");
            sbA.append(this.f31328c);
            sbA.append(", adEventlistenerMap=");
            sbA.append(this.f31329d);
            sbA.append(", adFillingEventlistenerMap=");
            sbA.append(this.f31330e);
            sbA.append(", adShowEventListenerMap=");
            sbA.append(this.f31331f);
            sbA.append(", adShowList=");
            sbA.append(this.f31332g);
            sbA.append(')');
            return sbA.toString();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b {
    }

    public final void OooO00o(String str, AdsDTO adsDTO, String str2, String str3, App app, AdStyleBean adStyleBean, ia.a aVar) {
        Context context;
        ConcurrentHashMap<String, jd.b> concurrentHashMap;
        ConcurrentHashMap<String, jd.b> concurrentHashMap2;
        jd.b bVar;
        tb.b appContext = app.getAppContext();
        if (appContext == null || (context = appContext.getContext()) == null) {
            OooO00o(str, app, "系统异常");
            return;
        }
        if (TextUtils.isEmpty(str2) || !new File(str2).exists() || (str3 != null && !TextUtils.isEmpty(str3) && !new File(str3).exists())) {
            OooO00o(str, app, "广告图片不存在");
            return;
        }
        a aVar2 = this.OooO00o.get(app.getAppId());
        if (aVar2 == null || (concurrentHashMap2 = aVar2.f31328c) == null || (bVar = concurrentHashMap2.get(str)) == null || !bVar.p()) {
            f fVar = new f(context, str, str2, str3, adsDTO.getNativeObject().getTitleTxt(), adsDTO.getNativeObject().getDescriptionTxt(), adsDTO.getNativeObject().getButtonText(), adStyleBean, aVar);
            a aVar3 = this.OooO00o.get(app.getAppId());
            if (aVar3 == null || (concurrentHashMap = aVar3.f31328c) == null) {
                return;
            }
            concurrentHashMap.put(str, fVar);
        }
    }

    public final void OooO00o(String str, App app) {
        ConcurrentHashMap<String, ia.a> concurrentHashMap;
        ConcurrentLinkedQueue<String> concurrentLinkedQueue;
        ConcurrentHashMap<String, c> concurrentHashMap2;
        ConcurrentHashMap<String, ia.b> concurrentHashMap3;
        ConcurrentHashMap<String, jd.b> concurrentHashMap4;
        ConcurrentHashMap<String, jd.b> concurrentHashMap5;
        a aVar = this.OooO00o.get(app.getAppId());
        if (aVar != null && (concurrentHashMap5 = aVar.f31327b) != null && concurrentHashMap5.containsKey(str)) {
            jd.b bVar = aVar.f31327b.get(str);
            AdInterstitialHtmlView$Builder adInterstitialHtmlView$Builder = bVar instanceof AdInterstitialHtmlView$Builder ? (AdInterstitialHtmlView$Builder) bVar : null;
            if (adInterstitialHtmlView$Builder != null) {
                adInterstitialHtmlView$Builder.C();
            }
            aVar.f31327b.remove(str);
        }
        if (aVar != null && (concurrentHashMap4 = aVar.f31328c) != null && concurrentHashMap4.containsKey(str)) {
            jd.b bVar2 = aVar.f31328c.get(str);
            f fVar = bVar2 instanceof f ? (f) bVar2 : null;
            if (fVar != null) {
                fVar.A = null;
            }
            aVar.f31328c.remove(str);
        }
        if (aVar != null && (concurrentHashMap3 = aVar.f31330e) != null && concurrentHashMap3.containsKey(str)) {
            aVar.f31330e.remove(str);
        }
        if (aVar != null && (concurrentHashMap2 = aVar.f31331f) != null && concurrentHashMap2.containsKey(str)) {
            aVar.f31331f.remove(str);
        }
        if (aVar != null && (concurrentLinkedQueue = aVar.f31332g) != null) {
            concurrentLinkedQueue.remove(str);
        }
        if (aVar == null || (concurrentHashMap = aVar.f31329d) == null || !concurrentHashMap.containsKey(str)) {
            return;
        }
        aVar.f31329d.remove(str);
    }

    public final void OooO00o(String str, App app, String str2) {
        ConcurrentHashMap<String, ia.b> concurrentHashMap;
        ia.b bVar;
        TmcLogger.f(TAG, "fillingInterstitialFail -> errMsg: " + str2);
        a aVar = this.OooO00o.get(app.getAppId());
        if (aVar != null && (concurrentHashMap = aVar.f31330e) != null && (bVar = concurrentHashMap.get(str)) != null) {
            bVar.b(str, false);
        }
        OooO00o(str, app);
    }

    public final void OooO0O0(String str, App app, String str2) {
        ConcurrentHashMap<String, c> concurrentHashMap;
        c cVar;
        TmcLogger.f(TAG, "showInterstitialFail -> errMsg: " + str2);
        a aVar = this.OooO00o.get(app.getAppId());
        if (aVar != null && (concurrentHashMap = aVar.f31331f) != null && (cVar = concurrentHashMap.get(str)) != null) {
            cVar.c(str, false, new AdShowBean(0, 0, 0L, 0, 0L, null, 0, 0, false, 511, null));
        }
        OooO00o(str, app);
    }

    @Override // com.cloud.tmc.ad.IAdManagerProxy
    public void applicationDestroy() {
        Iterator<Map.Entry<String, a>> it = this.OooO00o.entrySet().iterator();
        while (it.hasNext()) {
            String str = it.next().getValue().f31326a;
            if (str != null) {
                onDestroy(str);
            }
        }
    }

    @Override // com.cloud.tmc.ad.IAdManagerProxy
    public void close(String triggerId, App app) {
        ConcurrentLinkedQueue<String> concurrentLinkedQueue;
        Intrinsics.g(triggerId, "triggerId");
        Intrinsics.g(app, "app");
        a aVar = this.OooO00o.get(app.getAppId());
        if (aVar == null || (concurrentLinkedQueue = aVar.f31332g) == null || !concurrentLinkedQueue.contains(triggerId)) {
            TmcLogger.f(TAG, "广告关闭失败 -> 未曝光triggerId: " + triggerId);
            return;
        }
        if (aVar.f31327b.containsKey(triggerId)) {
            jd.b bVar = aVar.f31327b.get(triggerId);
            if (bVar != null) {
                bVar.f67984x = true;
                bVar.l();
                return;
            } else {
                TmcLogger.f(TAG, "广告关闭失败 -> html形式实例不存在triggerId: " + triggerId);
                return;
            }
        }
        if (aVar.f31328c.containsKey(triggerId)) {
            jd.b bVar2 = aVar.f31328c.get(triggerId);
            if (bVar2 != null) {
                bVar2.f67984x = true;
                bVar2.l();
            } else {
                TmcLogger.f(TAG, "广告关闭失败 -> json形式实例不存在triggerId: " + triggerId);
            }
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.cloud.tmc.ad.IAdManagerProxy
    public void fillingInterstitial(String triggerId, AdsDTO adsDTO, String str, String str2, App app, ia.b listener) {
        a aVar;
        ConcurrentHashMap<String, ia.b> concurrentHashMap;
        a aVar2;
        ConcurrentHashMap<String, ia.a> concurrentHashMap2;
        Context context;
        ConcurrentHashMap<String, jd.b> concurrentHashMap3;
        ConcurrentHashMap<String, ia.a> concurrentHashMap4;
        ConcurrentHashMap<String, ia.a> concurrentHashMap5;
        ConcurrentHashMap<String, ia.b> concurrentHashMap6;
        Intrinsics.g(triggerId, "triggerId");
        Intrinsics.g(adsDTO, "adsDTO");
        Intrinsics.g(app, "app");
        Intrinsics.g(listener, "listener");
        a aVar3 = this.OooO00o.get(app.getAppId());
        if ((aVar3 == null || (concurrentHashMap6 = aVar3.f31330e) == null || !concurrentHashMap6.containsKey(triggerId)) && (aVar = this.OooO00o.get(app.getAppId())) != null && (concurrentHashMap = aVar.f31330e) != null) {
            concurrentHashMap.put(triggerId, listener);
        }
        a aVar4 = this.OooO00o.get(app.getAppId());
        if ((aVar4 == null || (concurrentHashMap5 = aVar4.f31329d) == null || !concurrentHashMap5.containsKey(triggerId)) && (aVar2 = this.OooO00o.get(app.getAppId())) != null && (concurrentHashMap2 = aVar2.f31329d) != null) {
            concurrentHashMap2.put(triggerId, new com.cloud.tmc.miniapp.ad.a(this, app));
        }
        a aVar5 = this.OooO00o.get(app.getAppId());
        ia.a aVar6 = (aVar5 == null || (concurrentHashMap4 = aVar5.f31329d) == null) ? null : concurrentHashMap4.get(triggerId);
        if (!this.OooO00o.containsKey(app.getAppId())) {
            OooO00o(triggerId, app, "请先初始化");
            return;
        }
        Integer codeSeatType = adsDTO.getCodeSeatType();
        if (codeSeatType == null || codeSeatType.intValue() != 3) {
            OooO00o(triggerId, app, "非插屏类型");
            return;
        }
        Object obj = !TextUtils.isEmpty(adsDTO.getAdm()) ? "fromTypeHtml" : "fromTypeJson";
        tb.b appContext = app.getAppContext();
        if (appContext == null || appContext.getContext() == null) {
            return;
        }
        if (Intrinsics.b(obj, "fromTypeHtml")) {
            if (TextUtils.isEmpty(adsDTO.getAdm())) {
                OooO00o(triggerId, app, "adm内容不能为空");
                return;
            }
            if (adsDTO.getScales() == null || adsDTO.getScales().size() == 0) {
                OooO00o(triggerId, app, "代码为比例不能为空");
                return;
            }
            tb.b appContext2 = app.getAppContext();
            if (appContext2 == null || (context = appContext2.getContext()) == null) {
                OooO00o(triggerId, app, "系统异常");
                return;
            }
            String adm = adsDTO.getAdm();
            Intrinsics.f(adm, "adsDTO.adm");
            String str3 = adsDTO.getScales().get(0);
            Intrinsics.f(str3, "adsDTO.scales[0]");
            AdInterstitialHtmlView$Builder adInterstitialHtmlView$Builder = new AdInterstitialHtmlView$Builder(context, triggerId, adm, str3, aVar6);
            a aVar7 = this.OooO00o.get(app.getAppId());
            if (aVar7 == null || (concurrentHashMap3 = aVar7.f31327b) == null) {
                return;
            }
            concurrentHashMap3.put(triggerId, adInterstitialHtmlView$Builder);
            return;
        }
        if (!Intrinsics.b(obj, "fromTypeJson")) {
            TmcLogger.f(TAG, "填充 -> triggerId: " + triggerId + ", 不存在的广告形式");
            return;
        }
        if (str == null) {
            OooO00o(triggerId, app, "广告图片不存在");
            return;
        }
        String materialStyle = adsDTO.getMaterialStyle();
        if (materialStyle != null) {
            switch (materialStyle.hashCode()) {
                case 2149406:
                    if (materialStyle.equals("FA14")) {
                        OooO00o(triggerId, adsDTO, str, str2, app, new AdStyleBean(true, true, true, true), aVar6);
                        return;
                    }
                    break;
                case 68925418:
                    if (materialStyle.equals("I1101")) {
                        OooO00o(triggerId, adsDTO, str, str2, app, new AdStyleBean(true, true, true, true), aVar6);
                        return;
                    }
                    break;
                case 68925419:
                    if (materialStyle.equals("I1102")) {
                        OooO00o(triggerId, adsDTO, str, str2, app, new AdStyleBean(true, false, true, true), aVar6);
                        return;
                    }
                    break;
                case 68925420:
                    if (materialStyle.equals("I1103")) {
                        OooO00o(triggerId, adsDTO, str, str2, app, new AdStyleBean(true, true, false, true), aVar6);
                        return;
                    }
                    break;
                case 68925423:
                    if (materialStyle.equals("I1106")) {
                        OooO00o(triggerId, adsDTO, str, str2, app, new AdStyleBean(true, true, false, true), aVar6);
                        return;
                    }
                    break;
                case 68925424:
                    if (materialStyle.equals("I1107")) {
                        OooO00o(triggerId, adsDTO, str, str2, app, new AdStyleBean(false, false, false, false), aVar6);
                        return;
                    }
                    break;
            }
        }
        OooO00o(triggerId, app, "非adm materialStyle 不符合");
    }

    @Override // com.cloud.tmc.ad.IAdManagerProxy
    public String getAdSdkFrameworkVersion() {
        if (this.OooO0O0 == null) {
            this.OooO0O0 = g.f31057a.a().i("ad_sdk_version");
        }
        String str = this.OooO0O0;
        return str == null ? "" : str;
    }

    @Override // com.cloud.tmc.ad.IAdManagerProxy
    public long getAdSdkFrameworkVersionInt() {
        if (this.OooO0OO == null) {
            this.OooO0OO = Long.valueOf(g.f31057a.a().g("ad_sdk_version_int"));
        }
        Long l11 = this.OooO0OO;
        if (l11 != null) {
            return l11.longValue();
        }
        return 0L;
    }

    @Override // com.cloud.tmc.ad.IAdManagerProxy
    public void onCreate(App app) {
        String str;
        Intrinsics.g(app, "app");
        List<String> listM = NewTaskManager.f31301b.getInstance().m();
        for (Map.Entry<String, a> entry : this.OooO00o.entrySet()) {
            if (!listM.contains(entry.getKey()) && (str = entry.getValue().f31326a) != null) {
                onDestroy(str);
            }
        }
        if (TextUtils.isEmpty(app.getAppId()) || this.OooO00o.containsKey(app.getAppId())) {
            return;
        }
        ConcurrentHashMap<String, a> concurrentHashMap = this.OooO00o;
        String appId = app.getAppId();
        Intrinsics.f(appId, "app.appId");
        concurrentHashMap.put(appId, new a(app.getAppId(), null, null, null, null, null, null, WebSocketProtocol.PAYLOAD_SHORT));
    }

    @Override // com.cloud.tmc.ad.IAdManagerProxy
    public void onDestroy(String str) {
        a aVar;
        if (str == null || (aVar = this.OooO00o.get(str)) == null) {
            return;
        }
        Iterator<Map.Entry<String, jd.b>> it = aVar.f31327b.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            jd.b value = it.next().getValue();
            AdInterstitialHtmlView$Builder adInterstitialHtmlView$Builder = value instanceof AdInterstitialHtmlView$Builder ? (AdInterstitialHtmlView$Builder) value : null;
            if (adInterstitialHtmlView$Builder != null) {
                adInterstitialHtmlView$Builder.C();
            }
            it.remove();
        }
        Iterator<Map.Entry<String, jd.b>> it2 = aVar.f31328c.entrySet().iterator();
        while (it2.hasNext()) {
            jd.b value2 = it2.next().getValue();
            f fVar = value2 instanceof f ? (f) value2 : null;
            if (fVar != null) {
                fVar.A = null;
            }
            it2.remove();
        }
        aVar.f31330e.clear();
        aVar.f31331f.clear();
        aVar.f31332g.clear();
        aVar.f31329d.clear();
    }

    @Override // com.cloud.tmc.ad.IAdManagerProxy
    public void showInterstitial(String triggerId, App app, AdsDTO adsDTO, c listener) {
        a aVar;
        ConcurrentHashMap<String, c> concurrentHashMap;
        ConcurrentHashMap<String, jd.b> concurrentHashMap2;
        ConcurrentHashMap<String, jd.b> concurrentHashMap3;
        a aVar2;
        ConcurrentHashMap<String, jd.b> concurrentHashMap4;
        ConcurrentHashMap<String, jd.b> concurrentHashMap5;
        ConcurrentHashMap<String, c> concurrentHashMap6;
        Intrinsics.g(triggerId, "triggerId");
        Intrinsics.g(app, "app");
        Intrinsics.g(adsDTO, "adsDTO");
        Intrinsics.g(listener, "listener");
        a aVar3 = this.OooO00o.get(app.getAppId());
        if ((aVar3 == null || (concurrentHashMap6 = aVar3.f31331f) == null || !concurrentHashMap6.containsKey(triggerId)) && (aVar = this.OooO00o.get(app.getAppId())) != null && (concurrentHashMap = aVar.f31331f) != null) {
            concurrentHashMap.put(triggerId, listener);
        }
        jd.b bVar = null;
        if (!TextUtils.isEmpty(adsDTO.getAdm()) && (aVar2 = this.OooO00o.get(app.getAppId())) != null && (concurrentHashMap4 = aVar2.f31327b) != null && concurrentHashMap4.containsKey(triggerId)) {
            a aVar4 = this.OooO00o.get(app.getAppId());
            if (aVar4 != null && (concurrentHashMap5 = aVar4.f31327b) != null) {
                bVar = concurrentHashMap5.get(triggerId);
            }
            if (bVar != null) {
                bVar.q();
                return;
            } else {
                OooO0O0(triggerId, app, "html广告填充实例为null");
                return;
            }
        }
        a aVar5 = this.OooO00o.get(app.getAppId());
        if (aVar5 == null || (concurrentHashMap2 = aVar5.f31328c) == null || !concurrentHashMap2.containsKey(triggerId)) {
            OooO0O0(triggerId, app, "不存在广告形式");
            return;
        }
        a aVar6 = this.OooO00o.get(app.getAppId());
        if (aVar6 != null && (concurrentHashMap3 = aVar6.f31328c) != null) {
            bVar = concurrentHashMap3.get(triggerId);
        }
        if (bVar != null) {
            bVar.q();
        } else {
            OooO0O0(triggerId, app, "json广告填充实例为null");
        }
    }
}
