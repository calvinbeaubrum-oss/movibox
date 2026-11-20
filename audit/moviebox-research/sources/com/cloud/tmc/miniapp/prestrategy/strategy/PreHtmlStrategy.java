package com.cloud.tmc.miniapp.prestrategy.strategy;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.cloud.tmc.integration.MiniAppConfigHelper;
import com.cloud.tmc.integration.proxy.PreHtmStrategyProxy;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.network.INetWorkProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PointAnalyseType;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.kernel.service.ConfigService;
import com.cloud.tmc.kernel.utils.o;
import com.cloud.tmc.miniutils.util.h;
import com.google.gson.reflect.TypeToken;
import com.hisavana.common.constant.ComConstants;
import hd.k;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Cookie;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class PreHtmlStrategy implements PreHtmStrategyProxy {
    public static final a Companion = new a();
    public static final String KEY_FILE_PRE_HTML = "miniStrategyPreHtml";
    public static final String KEY_PRE_HTML_LIST = "miniStrategyPreHtmlList";
    public final String OooO00o = "PreHtmlStrategy";
    public List<String> OooO0O0;
    public AtomicInteger OooO0OO;

    /* JADX INFO: compiled from: source.java */
    public static final class a {
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b implements wc.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f31658a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ PreHtmlStrategy f31659b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Function1<Boolean, Unit> f31660c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Context f31661d;

        /* JADX WARN: Multi-variable type inference failed */
        public b(String str, int i11, PreHtmlStrategy preHtmlStrategy, Function1<? super Boolean, Unit> function1, Context context) {
            this.f31659b = preHtmlStrategy;
            this.f31660c = function1;
            this.f31661d = context;
            this.f31658a = str;
        }

        @Override // wc.b
        public void a(int i11, String str, Map<String, String> map, List<Cookie> list, String str2) {
            try {
                PreHtmlStrategy.access$removePreRequestNum(this.f31659b);
                TmcLogger.c(this.f31659b.OooO00o, "requestHtml-> success " + this.f31658a);
                if (i11 == 200) {
                    PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
                    PointAnalyseType pointAnalyseType = PointAnalyseType.PRE_REQUEST_HTML_RET;
                    Bundle bundle = new Bundle();
                    bundle.putInt("ret", 2);
                    bundle.putInt("triggerType", 1);
                    Unit unit = Unit.f68710a;
                    performanceAnalyseProxy.record("", pointAnalyseType, "", bundle);
                    List list2 = this.f31659b.OooO0O0;
                    PreHtmlStrategy preHtmlStrategy = this.f31659b;
                    Context context = this.f31661d;
                    synchronized (list2) {
                        try {
                            if (preHtmlStrategy.OooO0O0.contains(this.f31658a)) {
                                KVStorageProxy kVStorageProxy = (KVStorageProxy) tc.a.a(KVStorageProxy.class);
                                String str3 = this.f31658a;
                                if (str == null) {
                                    str = "";
                                }
                                kVStorageProxy.putString(context, PreHtmlStrategy.KEY_FILE_PRE_HTML, str3, str);
                                int configInt = ((ConfigService) tc.a.a(ConfigService.class)).getConfigInt("maxminiPreRequest", 10);
                                TmcLogger.c(preHtmlStrategy.OooO00o, "requestHtml.size->" + preHtmlStrategy.OooO0O0.size());
                                while (preHtmlStrategy.OooO0O0.size() > configInt) {
                                    TmcLogger.b("requestHtml.size->" + preHtmlStrategy.OooO0O0.size());
                                    String str4 = (String) preHtmlStrategy.OooO0O0.get(0);
                                    ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).remove(context, PreHtmlStrategy.KEY_FILE_PRE_HTML, str4);
                                    TmcLogger.c(preHtmlStrategy.OooO00o, "remove preCache " + str4);
                                    preHtmlStrategy.OooO0O0.remove(0);
                                }
                                KVStorageProxy kVStorageProxy2 = (KVStorageProxy) tc.a.a(KVStorageProxy.class);
                                String strA = o.a(preHtmlStrategy.OooO0O0);
                                if (strA == null) {
                                    strA = "";
                                }
                                kVStorageProxy2.putString(context, PreHtmlStrategy.KEY_FILE_PRE_HTML, PreHtmlStrategy.KEY_PRE_HTML_LIST, strA);
                                ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).putLong(context, PreHtmlStrategy.KEY_FILE_PRE_HTML, this.f31658a + "_time", System.currentTimeMillis());
                            } else {
                                TmcLogger.c(preHtmlStrategy.OooO00o, "requestHtml-> pre request not in preRequestList -> " + this.f31658a);
                            }
                            Unit unit2 = Unit.f68710a;
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                } else {
                    PerformanceAnalyseProxy performanceAnalyseProxy2 = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
                    PointAnalyseType pointAnalyseType2 = PointAnalyseType.PRE_REQUEST_HTML_RET;
                    Bundle bundle2 = new Bundle();
                    bundle2.putInt("ret", 1);
                    bundle2.putInt("triggerType", 1);
                    Unit unit3 = Unit.f68710a;
                    performanceAnalyseProxy2.record("", pointAnalyseType2, "", bundle2);
                }
                Function1<Boolean, Unit> function1 = this.f31660c;
                if (function1 != null) {
                    function1.invoke(Boolean.TRUE);
                }
            } catch (Throwable th3) {
                Function1<Boolean, Unit> function2 = this.f31660c;
                if (function2 != null) {
                    function2.invoke(Boolean.FALSE);
                }
                TmcLogger.g(this.f31659b.OooO00o, "requestHtml-> Throwable", th3);
            }
        }

        @Override // wc.b
        public void b(String str, String str2, String str3) {
            k.a("requestZeroSharpNewsHtml-> ", str2, this.f31659b.OooO00o);
            try {
                Function1<Boolean, Unit> function1 = this.f31660c;
                if (function1 != null) {
                    function1.invoke(Boolean.FALSE);
                }
                this.f31659b.OooO0O0.remove(this.f31658a);
                PreHtmlStrategy.access$removePreRequestNum(this.f31659b);
                PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
                PointAnalyseType pointAnalyseType = PointAnalyseType.PRE_REQUEST_HTML_RET;
                Bundle bundle = new Bundle();
                bundle.putInt("ret", 0);
                bundle.putInt("triggerType", 1);
                Unit unit = Unit.f68710a;
                performanceAnalyseProxy.record("", pointAnalyseType, "", bundle);
            } catch (Throwable th2) {
                TmcLogger.g(this.f31659b.OooO00o, "requestZeroSharpNewsHtml", th2);
            }
        }
    }

    public PreHtmlStrategy() {
        List<String> listSynchronizedList = Collections.synchronizedList(new ArrayList());
        Intrinsics.f(listSynchronizedList, "synchronizedList(ArrayList())");
        this.OooO0O0 = listSynchronizedList;
        this.OooO0OO = new AtomicInteger(0);
    }

    public static final void access$removePreRequestNum(PreHtmlStrategy preHtmlStrategy) {
        preHtmlStrategy.getClass();
        try {
            if (preHtmlStrategy.OooO0OO.get() > 0) {
                preHtmlStrategy.OooO0OO.decrementAndGet();
            }
        } catch (Throwable th2) {
            TmcLogger.g(preHtmlStrategy.OooO00o, "removePreRequestNum", th2);
        }
    }

    public final int OooO00o() {
        return ((ConfigService) tc.a.a(ConfigService.class)).getConfigInt("miniPreHtmlRequestNum", 3);
    }

    @Override // com.cloud.tmc.integration.proxy.PreHtmStrategyProxy
    public boolean checkPreHtmlCache(Context context, String urlMd5, boolean z11) {
        long j11;
        long jC;
        Intrinsics.g(urlMd5, "urlMd5");
        if (context == null) {
            return true;
        }
        try {
            j11 = ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).getLong(context, KEY_FILE_PRE_HTML, urlMd5 + "_time");
        } catch (Throwable th2) {
            TmcLogger.h(this.OooO00o, th2);
            j11 = 0;
        }
        if (j11 == 0) {
            return true;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - j11;
        try {
            jC = ((long) (MiniAppConfigHelper.f30370a.c("preHtmlExpiredTime", 24) * 3600)) * 1000;
        } catch (Throwable unused) {
            jC = ComConstants.REQ_CLOUD_CONFIG_INTERVAL_IF_NEED;
        }
        if (jCurrentTimeMillis < jC) {
            return true;
        }
        TmcLogger.c(this.OooO00o, "html cache is expired");
        if (z11) {
            this.OooO0O0.remove(urlMd5);
            ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).remove(context, KEY_FILE_PRE_HTML, urlMd5);
            ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).putLong(context, KEY_FILE_PRE_HTML, h.a.a(urlMd5, "_time"), -1L);
        }
        return false;
    }

    @Override // com.cloud.tmc.integration.proxy.PreHtmStrategyProxy
    public String getPreHtmlCache(Context context, String md5, int i11, boolean z11) {
        Intrinsics.g(context, "context");
        Intrinsics.g(md5, "md5");
        PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
        PointAnalyseType pointAnalyseType = PointAnalyseType.GET_PRE_HTML;
        Bundle bundle = new Bundle();
        bundle.putInt("getPreHtmlChannel", i11);
        Unit unit = Unit.f68710a;
        performanceAnalyseProxy.record("", pointAnalyseType, "", bundle);
        String string = ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).getString(context, KEY_FILE_PRE_HTML, md5);
        if (string == null) {
            string = "";
        }
        if (TextUtils.isEmpty(string)) {
            PerformanceAnalyseProxy performanceAnalyseProxy2 = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
            PointAnalyseType pointAnalyseType2 = PointAnalyseType.GET_PRE_HTML_HIT;
            Bundle bundle2 = new Bundle();
            bundle2.putInt("getPreHtmlChannel", i11);
            bundle2.putInt("hitRet", 0);
            performanceAnalyseProxy2.record("", pointAnalyseType2, "", bundle2);
            return "";
        }
        if (!z11 || checkPreHtmlCache(context, md5, false)) {
            PerformanceAnalyseProxy performanceAnalyseProxy3 = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
            PointAnalyseType pointAnalyseType3 = PointAnalyseType.GET_PRE_HTML_HIT;
            Bundle bundle3 = new Bundle();
            bundle3.putInt("getPreHtmlChannel", i11);
            bundle3.putInt("hitRet", 2);
            bundle3.putInt("triggerType", 1);
            performanceAnalyseProxy3.record("", pointAnalyseType3, "", bundle3);
            return string;
        }
        PerformanceAnalyseProxy performanceAnalyseProxy4 = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
        PointAnalyseType pointAnalyseType4 = PointAnalyseType.GET_PRE_HTML_HIT;
        Bundle bundle4 = new Bundle();
        bundle4.putInt("getPreHtmlChannel", i11);
        bundle4.putInt("hitRet", 1);
        bundle4.putInt("triggerType", 1);
        performanceAnalyseProxy4.record("", pointAnalyseType4, "", bundle4);
        return "";
    }

    @Override // com.cloud.tmc.integration.proxy.PreHtmStrategyProxy
    public void requestHtml(Context context, String contentUrl, Function1<? super Boolean, Unit> function1) {
        Intrinsics.g(context, "context");
        Intrinsics.g(contentUrl, "contentUrl");
        synchronized (this.OooO0O0) {
            try {
                try {
                    if (this.OooO0OO.get() >= OooO00o()) {
                        TmcLogger.f(this.OooO00o, "requestNum >=" + OooO00o() + " return");
                        Bundle bundle = new Bundle();
                        bundle.putString("failReason", "requestNum >=" + OooO00o() + " return");
                        trackPreStrategyFailPoint(bundle);
                        if (function1 != null) {
                            function1.invoke(Boolean.FALSE);
                        }
                        return;
                    }
                    if (contentUrl.length() == 0) {
                        TmcLogger.f(this.OooO00o, "contentUrl is empty");
                        if (function1 != null) {
                            function1.invoke(Boolean.FALSE);
                        }
                        return;
                    }
                    if (this.OooO0O0.size() == 0) {
                        String string = ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).getString(context, KEY_FILE_PRE_HTML, KEY_PRE_HTML_LIST);
                        if (string == null) {
                            string = "";
                        }
                        Intrinsics.f(string, "TmcProxy.get(KVStoragePr…                  ) ?: \"\"");
                        if (string.length() > 0) {
                            ArrayList list = (ArrayList) com.cloud.tmc.miniutils.util.k.e(string, new TypeToken<ArrayList<String>>() { // from class: com.cloud.tmc.miniapp.prestrategy.strategy.PreHtmlStrategy$requestHtml$1$list$1
                            }.getType());
                            List<String> list2 = this.OooO0O0;
                            Intrinsics.f(list, "list");
                            list2.addAll(list);
                            TmcLogger.c(this.OooO00o, "preRequestList is init");
                        }
                    }
                    String md5 = h.b(contentUrl);
                    if (this.OooO0O0.contains(md5)) {
                        Intrinsics.f(md5, "md5");
                        if (PreHtmStrategyProxy.a.a(this, context, md5, false, 4, null)) {
                            TmcLogger.c(this.OooO00o, "content url is exist");
                            if (function1 != null) {
                                function1.invoke(Boolean.FALSE);
                            }
                            return;
                        }
                    }
                    try {
                        this.OooO0OO.incrementAndGet();
                    } catch (Throwable th2) {
                        TmcLogger.g(this.OooO00o, "addPreRequestNum", th2);
                    }
                    List<String> list3 = this.OooO0O0;
                    Intrinsics.f(md5, "md5");
                    list3.add(md5);
                    ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).putLong(context, KEY_FILE_PRE_HTML, md5 + "_time", 0L);
                    TmcLogger.c(this.OooO00o, "md5->" + md5);
                    PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
                    PointAnalyseType pointAnalyseType = PointAnalyseType.PRE_REQUEST_HTML;
                    Bundle bundle2 = new Bundle();
                    bundle2.putInt("triggerType", 1);
                    Unit unit = Unit.f68710a;
                    performanceAnalyseProxy.record("", pointAnalyseType, "", bundle2);
                    ((INetWorkProxy) tc.a.a(INetWorkProxy.class)).get(contentUrl, null, null, Boolean.FALSE, new b(md5, 1, this, function1, context));
                    Unit unit2 = Unit.f68710a;
                } catch (Throwable th3) {
                    if (function1 != null) {
                        function1.invoke(Boolean.FALSE);
                    }
                    TmcLogger.g(this.OooO00o, "requestZeroSharpNewsHtml", th3);
                }
            } catch (Throwable th4) {
                throw th4;
            }
        }
    }

    @Override // com.cloud.tmc.integration.proxy.PreHtmStrategyProxy
    public void trackPreStrategyFailPoint(Bundle bundle) {
        if (MiniAppConfigHelper.f30370a.b("enablePreStrategyTrackPoint", false)) {
            PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
            PointAnalyseType pointAnalyseType = PointAnalyseType.PRE_STRATEGY_FAIL;
            if (bundle == null) {
                bundle = new Bundle();
            }
            performanceAnalyseProxy.record("", pointAnalyseType, "", bundle);
        }
    }
}
