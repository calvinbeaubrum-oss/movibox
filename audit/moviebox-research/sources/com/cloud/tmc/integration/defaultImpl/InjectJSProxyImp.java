package com.cloud.tmc.integration.defaultImpl;

import android.text.TextUtils;
import com.cloud.tmc.kernel.service.ConfigService;
import com.cloud.tmc.miniutils.util.k;
import com.cloud.tmc.render.bean.InjectStrategy;
import com.cloud.tmc.render.bean.JSConfig;
import com.cloud.tmc.render.proxy.InjectJSProxy;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.collections.g;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
@SourceDebugExtension
public final class InjectJSProxyImp implements InjectJSProxy {
    public static final String STRATEGY_INJECT_JS_IN_PAGEFINISHED = "pageFinished";
    public static final String STRATEGY_INJECT_JS_IN_PAGESTAET = "pageStart";
    public static final String STRATEGY_INJECT_JS_IN_PRELOADURL = "preLoadurl";
    public static final String TAG = "InjectJS";
    public static final a Companion = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicInteger f30706a = new AtomicInteger(1);

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final int a() {
        AtomicInteger atomicInteger = f30706a;
        int iIncrementAndGet = atomicInteger.incrementAndGet();
        return iIncrementAndGet > 5000 ? atomicInteger.getAndSet(1) : iIncrementAndGet;
    }

    public final void b(Map<String, InjectStrategy> map, String str, String str2) {
        if (!map.containsKey(str)) {
            map.put(str, new InjectStrategy(str, str2));
            return;
        }
        InjectStrategy injectStrategy = map.get(str);
        if (injectStrategy == null) {
            return;
        }
        injectStrategy.setScript(injectStrategy.getScript() + str2);
    }

    public final ArrayList<JSConfig> c() {
        Object objE = k.e(((ConfigService) tc.a.a(ConfigService.class)).getConfigString("injectJSConfigV3", "[{\"jsName\":\"bgm_fix_min.js\",\"jsPath\":\"http://app-oss.byte-app.com/common/js/bgm_fix_min.js\",\"appIdBlackList\":[],\"appIdWhiteList\":[\"1000355985110831104\",\"5000321129995288576\"],\"injectStrategy\":[\"pageStart\"]},{\"jsName\":\"game_preformance_monitor_1_min.js\",\"jsPath\":\"http://app-oss.byte-app.com/common/js/game_preformance_monitor_1_min.js\",\"appIdBlackList\":[],\"appIdWhiteList\":[\"5*\",\"1000355985110831104\",\"3000289718657171456\"],\"injectStrategy\":[\"pageStart\"]},{\"jsName\":\"byteh5monitor.aio.min.js\",\"jsPath\":\"http://app-oss.byte-app.com/common/js/byteh5monitor.aio.min.js\",\"appIdBlackList\":[\"3000376718002012160\"],\"appIdWhiteList\":[\"3*\",\"1000497027976413184\"],\"injectStrategy\":[\"pageStart\"]},{\"jsName\":\"byteh5privacy.aio.min.js\",\"jsPath\":\"http://app-oss.byte-app.com/common/js/byteh5privacy.aio.min.js\",\"appIdBlackList\":[\"3000376718002012160\"],\"appIdWhiteList\":[\"3*\",\"5*\",\"1000355985110831104\",\"1000788264193941504\"],\"injectStrategy\":[\"pageStart\"]}]"), new TypeToken<ArrayList<JSConfig>>() { // from class: com.cloud.tmc.integration.defaultImpl.InjectJSProxyImp$getInjectJSConfig$1
        }.getType());
        Intrinsics.f(objE, "fromJson(injectJSConfigS…ist<JSConfig>>() {}.type)");
        return (ArrayList) objE;
    }

    @Override // com.cloud.tmc.render.proxy.InjectJSProxy
    public Map<String, InjectStrategy> getInjectStrategy(String appId) {
        Intrinsics.g(appId, "appId");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int i11 = 0;
        for (Object obj : getTartgetInjectJSData(appId)) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                g.u();
            }
            JSConfig jSConfig = (JSConfig) obj;
            StringBuffer stringBuffer = new StringBuffer();
            int iA = a();
            stringBuffer.append("var scriptElement" + iA + " = document.createElement('script');\n");
            stringBuffer.append("scriptElement" + iA + ".src = '" + jSConfig.getJsPath() + "';\n");
            StringBuilder sb2 = new StringBuilder();
            sb2.append("document.head.appendChild(scriptElement");
            sb2.append(iA);
            sb2.append(");\n");
            stringBuffer.append(sb2.toString());
            for (String str : jSConfig.getInjectStrategy()) {
                String string = stringBuffer.toString();
                Intrinsics.f(string, "script.toString()");
                b(linkedHashMap, str, string);
            }
            i11 = i12;
        }
        return linkedHashMap;
    }

    @Override // com.cloud.tmc.render.proxy.InjectJSProxy
    public List<JSConfig> getTartgetInjectJSData(String appId) {
        Intrinsics.g(appId, "appId");
        ArrayList arrayList = new ArrayList();
        for (JSConfig jSConfig : c()) {
            if (!TextUtils.isEmpty(appId)) {
                boolean z11 = true;
                if (!jSConfig.getAppIdWhiteList().contains(appId)) {
                    ArrayList<String> appIdWhiteList = jSConfig.getAppIdWhiteList();
                    StringBuilder sb2 = new StringBuilder();
                    String strSubstring = appId.substring(0, 1);
                    Intrinsics.f(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                    sb2.append(strSubstring);
                    sb2.append('*');
                    if (!appIdWhiteList.contains(sb2.toString())) {
                        z11 = false;
                    }
                }
                if (!jSConfig.getAppIdBlackList().contains(appId) && z11) {
                    arrayList.add(jSConfig);
                }
            }
        }
        return arrayList;
    }
}
