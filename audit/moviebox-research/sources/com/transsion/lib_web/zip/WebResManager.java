package com.transsion.lib_web.zip;

import android.app.Application;
import android.text.TextUtils;
import com.blankj.utilcode.util.Utils;
import com.tencent.mmkv.MMKV;
import com.tn.lib.net.manager.NetServiceGenerator;
import com.transsion.lib_web.zip.db.WebResDatabase;
import com.transsion.lib_web.zip.db.WebResRemoteBean;
import com.transsion.lib_web.zip.db.WebViewCacheConfigData;
import hu.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.g;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.w0;

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
@SourceDebugExtension
public final class WebResManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final WebResManager f53069a = new WebResManager();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f53070b = LazyKt__LazyJVMKt.b(new Function0<a>() { // from class: com.transsion.lib_web.zip.WebResManager$iWebResApi$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final a invoke() {
            return (a) NetServiceGenerator.f49399d.a().i(a.class);
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f53071c = LazyKt__LazyJVMKt.b(new Function0<MMKV>() { // from class: com.transsion.lib_web.zip.WebResManager$mmkv$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final MMKV invoke() {
            return MMKV.z("mb_web_res");
        }
    });

    /* JADX WARN: Code duplicated, block: B:22:0x0073  */
    /* JADX WARN: Code duplicated, block: B:28:0x008e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:30:? A[LOOP:0: B:20:0x006d->B:30:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object h(Continuation<? super Unit> continuation) throws Throwable {
        WebResManager$checkDownloadZip$1 webResManager$checkDownloadZip$1;
        ju.a aVarI;
        ju.a aVar;
        Iterator it;
        WebViewCacheConfigData webViewCacheConfigData;
        b bVar;
        Application applicationA;
        if (continuation instanceof WebResManager$checkDownloadZip$1) {
            webResManager$checkDownloadZip$1 = (WebResManager$checkDownloadZip$1) continuation;
            int i11 = webResManager$checkDownloadZip$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                webResManager$checkDownloadZip$1.label = i11 - Integer.MIN_VALUE;
            } else {
                webResManager$checkDownloadZip$1 = new WebResManager$checkDownloadZip$1(this, continuation);
            }
        } else {
            webResManager$checkDownloadZip$1 = new WebResManager$checkDownloadZip$1(this, continuation);
        }
        Object objA = webResManager$checkDownloadZip$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = webResManager$checkDownloadZip$1.label;
        if (i12 != 0) {
            if (i12 == 1) {
                aVarI = (ju.a) webResManager$checkDownloadZip$1.L$0;
                ResultKt.b(objA);
            } else {
                if (i12 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                it = (Iterator) webResManager$checkDownloadZip$1.L$1;
                aVar = (ju.a) webResManager$checkDownloadZip$1.L$0;
                ResultKt.b(objA);
            }
            while (it.hasNext()) {
                webViewCacheConfigData = (WebViewCacheConfigData) it.next();
                bVar = b.f53072a;
                applicationA = Utils.a();
                Intrinsics.f(applicationA, "getApp()");
                webResManager$checkDownloadZip$1.L$0 = aVar;
                webResManager$checkDownloadZip$1.L$1 = it;
                webResManager$checkDownloadZip$1.label = 2;
                if (bVar.a(applicationA, webViewCacheConfigData, webResManager$checkDownloadZip$1) == objE) {
                    return objE;
                }
            }
            return Unit.f68710a;
        }
        ResultKt.b(objA);
        WebResDatabase.b bVar2 = WebResDatabase.f53073p;
        Application applicationA2 = Utils.a();
        Intrinsics.f(applicationA2, "getApp()");
        aVarI = bVar2.b(applicationA2).I();
        webResManager$checkDownloadZip$1.L$0 = aVarI;
        webResManager$checkDownloadZip$1.label = 1;
        objA = aVarI.a(webResManager$checkDownloadZip$1);
        if (objA == objE) {
            return objE;
        }
        aVar = aVarI;
        it = ((Iterable) objA).iterator();
        while (it.hasNext()) {
            webViewCacheConfigData = (WebViewCacheConfigData) it.next();
            bVar = b.f53072a;
            applicationA = Utils.a();
            Intrinsics.f(applicationA, "getApp()");
            webResManager$checkDownloadZip$1.L$0 = aVar;
            webResManager$checkDownloadZip$1.L$1 = it;
            webResManager$checkDownloadZip$1.label = 2;
            if (bVar.a(applicationA, webViewCacheConfigData, webResManager$checkDownloadZip$1) == objE) {
                return objE;
            }
        }
        return Unit.f68710a;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0083  */
    /* JADX WARN: Code duplicated, block: B:25:0x009a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0098 -> B:26:0x009b). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object i(kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r9 = this;
            boolean r0 = r10 instanceof com.transsion.lib_web.zip.WebResManager$clearCacheFile$1
            if (r0 == 0) goto L13
            r0 = r10
            com.transsion.lib_web.zip.WebResManager$clearCacheFile$1 r0 = (com.transsion.lib_web.zip.WebResManager$clearCacheFile$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.transsion.lib_web.zip.WebResManager$clearCacheFile$1 r0 = new com.transsion.lib_web.zip.WebResManager$clearCacheFile$1
            r0.<init>(r9, r10)
        L18:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.e()
            int r2 = r0.label
            java.lang.String r3 = "getApp()"
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L52
            if (r2 == r5) goto L46
            if (r2 != r4) goto L3e
            java.lang.Object r2 = r0.L$3
            com.transsion.lib_web.zip.db.WebViewCacheConfigData r2 = (com.transsion.lib_web.zip.db.WebViewCacheConfigData) r2
            java.lang.Object r5 = r0.L$2
            java.util.Iterator r5 = (java.util.Iterator) r5
            java.lang.Object r6 = r0.L$1
            ju.a r6 = (ju.a) r6
            java.lang.Object r7 = r0.L$0
            ju.a r7 = (ju.a) r7
            kotlin.ResultKt.b(r10)
            goto L9b
        L3e:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L46:
            java.lang.Object r2 = r0.L$1
            ju.a r2 = (ju.a) r2
            java.lang.Object r5 = r0.L$0
            ju.a r5 = (ju.a) r5
            kotlin.ResultKt.b(r10)
            goto L74
        L52:
            kotlin.ResultKt.b(r10)
            com.transsion.lib_web.zip.db.WebResDatabase$b r10 = com.transsion.lib_web.zip.db.WebResDatabase.f53073p
            android.app.Application r2 = com.blankj.utilcode.util.Utils.a()
            kotlin.jvm.internal.Intrinsics.f(r2, r3)
            com.transsion.lib_web.zip.db.WebResDatabase r10 = r10.b(r2)
            ju.a r2 = r10.I()
            r0.L$0 = r2
            r0.L$1 = r2
            r0.label = r5
            java.lang.Object r10 = r2.a(r0)
            if (r10 != r1) goto L73
            return r1
        L73:
            r5 = r2
        L74:
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            java.util.Iterator r10 = r10.iterator()
            r6 = r2
            r7 = r5
            r5 = r10
        L7d:
            boolean r10 = r5.hasNext()
            if (r10 == 0) goto La8
            java.lang.Object r10 = r5.next()
            r2 = r10
            com.transsion.lib_web.zip.db.WebViewCacheConfigData r2 = (com.transsion.lib_web.zip.db.WebViewCacheConfigData) r2
            r0.L$0 = r7
            r0.L$1 = r6
            r0.L$2 = r5
            r0.L$3 = r2
            r0.label = r4
            java.lang.Object r10 = r6.d(r2, r0)
            if (r10 != r1) goto L9b
            return r1
        L9b:
            com.transsion.lib_web.zip.b r10 = com.transsion.lib_web.zip.b.f53072a
            android.app.Application r8 = com.blankj.utilcode.util.Utils.a()
            kotlin.jvm.internal.Intrinsics.f(r8, r3)
            r10.b(r8, r2)
            goto L7d
        La8:
            kotlin.Unit r10 = kotlin.Unit.f68710a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.lib_web.zip.WebResManager.i(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:44:0x00f1 A[LOOP:0: B:42:0x00eb->B:44:0x00f1, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    public final Object j(List<WebViewCacheConfigData> list, Continuation<? super Unit> continuation) throws Throwable {
        WebResManager$deleteExpiredData$1 webResManager$deleteExpiredData$1;
        ju.a aVarI;
        List<WebViewCacheConfigData> list2;
        Object objA;
        ju.a aVar;
        List<WebViewCacheConfigData> list3;
        if (continuation instanceof WebResManager$deleteExpiredData$1) {
            webResManager$deleteExpiredData$1 = (WebResManager$deleteExpiredData$1) continuation;
            int i11 = webResManager$deleteExpiredData$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                webResManager$deleteExpiredData$1.label = i11 - Integer.MIN_VALUE;
            } else {
                webResManager$deleteExpiredData$1 = new WebResManager$deleteExpiredData$1(this, continuation);
            }
        } else {
            webResManager$deleteExpiredData$1 = new WebResManager$deleteExpiredData$1(this, continuation);
        }
        Object obj = webResManager$deleteExpiredData$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = webResManager$deleteExpiredData$1.label;
        if (i12 != 0) {
            if (i12 == 1) {
                aVarI = (ju.a) webResManager$deleteExpiredData$1.L$2;
                ju.a aVar2 = (ju.a) webResManager$deleteExpiredData$1.L$1;
                List<WebViewCacheConfigData> list4 = (List) webResManager$deleteExpiredData$1.L$0;
                ResultKt.b(obj);
                objA = obj;
                list2 = list4;
                aVar = aVar2;
            } else {
                if (i12 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                list3 = (List) webResManager$deleteExpiredData$1.L$1;
                ResultKt.b(obj);
            }
            for (WebViewCacheConfigData webViewCacheConfigData : list3) {
                b bVar = b.f53072a;
                Application applicationA = Utils.a();
                Intrinsics.f(applicationA, "getApp()");
                bVar.b(applicationA, webViewCacheConfigData);
            }
            return Unit.f68710a;
        }
        ResultKt.b(obj);
        WebResDatabase.b bVar2 = WebResDatabase.f53073p;
        Application applicationA2 = Utils.a();
        Intrinsics.f(applicationA2, "getApp()");
        aVarI = bVar2.b(applicationA2).I();
        list2 = list;
        webResManager$deleteExpiredData$1.L$0 = list2;
        webResManager$deleteExpiredData$1.L$1 = aVarI;
        webResManager$deleteExpiredData$1.L$2 = aVarI;
        webResManager$deleteExpiredData$1.label = 1;
        objA = aVarI.a(webResManager$deleteExpiredData$1);
        if (objA == objE) {
            return objE;
        }
        aVar = aVarI;
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : (Iterable) objA) {
            WebViewCacheConfigData webViewCacheConfigData2 = (WebViewCacheConfigData) obj2;
            List<WebViewCacheConfigData> list5 = list2;
            if (!(list5 instanceof Collection) || !list5.isEmpty()) {
                Iterator<T> it = list5.iterator();
                do {
                    if (it.hasNext()) {
                    }
                } while (!Intrinsics.b(((WebViewCacheConfigData) it.next()).getZipMd5(), webViewCacheConfigData2.getZipMd5()));
            }
            arrayList.add(obj2);
        }
        if (!arrayList.isEmpty()) {
            webResManager$deleteExpiredData$1.L$0 = aVar;
            webResManager$deleteExpiredData$1.L$1 = arrayList;
            webResManager$deleteExpiredData$1.L$2 = null;
            webResManager$deleteExpiredData$1.label = 2;
            if (aVarI.e(arrayList, webResManager$deleteExpiredData$1) == objE) {
                return objE;
            }
            list3 = arrayList;
            while (r0.hasNext()) {
                b bVar3 = b.f53072a;
                Application applicationA3 = Utils.a();
                Intrinsics.f(applicationA3, "getApp()");
                bVar3.b(applicationA3, webViewCacheConfigData);
            }
        }
        return Unit.f68710a;
    }

    public final String k() {
        String simpleName = WebResManager.class.getSimpleName();
        Intrinsics.f(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    public final a l() {
        return (a) f53070b.getValue();
    }

    public final MMKV m() {
        Object value = f53071c.getValue();
        Intrinsics.f(value, "<get-mmkv>(...)");
        return (MMKV) value;
    }

    public final void n() {
        j.d(l0.a(w0.b()), null, null, new WebResManager$getWebResConfig$1(null), 3, null);
    }

    /* JADX WARN: Code duplicated, block: B:45:0x0158 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:46:0x0159  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object o(WebResRemoteBean webResRemoteBean, String str, Continuation<? super Unit> continuation) throws Throwable {
        WebResManager$handleData$1 webResManager$handleData$1;
        WebResRemoteBean webResRemoteBean2;
        List<WebViewCacheConfigData> list;
        ju.a aVar;
        WebResManager webResManager;
        WebResRemoteBean webResRemoteBean3;
        if (continuation instanceof WebResManager$handleData$1) {
            webResManager$handleData$1 = (WebResManager$handleData$1) continuation;
            int i11 = webResManager$handleData$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                webResManager$handleData$1.label = i11 - Integer.MIN_VALUE;
            } else {
                webResManager$handleData$1 = new WebResManager$handleData$1(this, continuation);
            }
        } else {
            webResManager$handleData$1 = new WebResManager$handleData$1(this, continuation);
        }
        Object obj = webResManager$handleData$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = webResManager$handleData$1.label;
        if (i12 != 0) {
            if (i12 == 1) {
                ResultKt.b(obj);
                return Unit.f68710a;
            }
            if (i12 == 2) {
                ResultKt.b(obj);
                return Unit.f68710a;
            }
            if (i12 == 3) {
                list = (List) webResManager$handleData$1.L$2;
                aVar = (ju.a) webResManager$handleData$1.L$1;
                webResRemoteBean2 = (WebResRemoteBean) webResManager$handleData$1.L$0;
                ResultKt.b(obj);
                webResManager = f53069a;
                webResManager$handleData$1.L$0 = webResRemoteBean2;
                webResManager$handleData$1.L$1 = aVar;
                webResManager$handleData$1.L$2 = null;
                webResManager$handleData$1.label = 4;
                if (webResManager.j(list, webResManager$handleData$1) == objE) {
                    return objE;
                }
                webResRemoteBean3 = webResRemoteBean2;
            } else if (i12 == 4) {
                ju.a aVar2 = (ju.a) webResManager$handleData$1.L$1;
                WebResRemoteBean webResRemoteBean4 = (WebResRemoteBean) webResManager$handleData$1.L$0;
                ResultKt.b(obj);
                aVar = aVar2;
                webResRemoteBean3 = webResRemoteBean4;
            } else {
                if (i12 != 5) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                webResRemoteBean3 = (WebResRemoteBean) webResManager$handleData$1.L$0;
                ResultKt.b(obj);
            }
            WebResManager webResManager2 = f53069a;
            webResManager2.m().putString("lastUpdateTime", webResRemoteBean3.getLastUpdateTime());
            h.f66795a.a(webResManager2.k() + " --> handleData() --> 数据库增量更新完成 --> 删除过期资源");
            return Unit.f68710a;
        }
        ResultKt.b(obj);
        if (TextUtils.equals("0", webResRemoteBean.getLastUpdateTime())) {
            h.f66795a.a(k() + " --> 服务端的数据都下架了 --> curLastUpdateTime = " + str + " --> lastUpdateTime = " + webResRemoteBean.getLastUpdateTime());
            webResManager$handleData$1.label = 1;
            if (i(webResManager$handleData$1) == objE) {
                return objE;
            }
            return Unit.f68710a;
        }
        if (TextUtils.equals(str, webResRemoteBean.getLastUpdateTime())) {
            h.f66795a.a(k() + " --> 已经是最新数据 --> curLastUpdateTime = " + str + " --> lastUpdateTime = " + webResRemoteBean.getLastUpdateTime());
            webResManager$handleData$1.label = 2;
            if (h(webResManager$handleData$1) == objE) {
                return objE;
            }
            return Unit.f68710a;
        }
        WebResDatabase.b bVar = WebResDatabase.f53073p;
        Application applicationA = Utils.a();
        Intrinsics.f(applicationA, "getApp()");
        ju.a aVarI = bVar.b(applicationA).I();
        h hVar = h.f66795a;
        WebResManager webResManager3 = f53069a;
        hVar.a(webResManager3.k() + " --> handleData() --> success --> curLastUpdateTime = " + str + " --> response = " + webResRemoteBean);
        List<WebViewCacheConfigData> list2 = webResRemoteBean.getList();
        if (list2 == null) {
            list2 = g.l();
        }
        webResManager$handleData$1.L$0 = webResRemoteBean;
        webResManager$handleData$1.L$1 = aVarI;
        webResManager$handleData$1.L$2 = list2;
        webResManager$handleData$1.label = 3;
        if (webResManager3.q(list2, webResManager$handleData$1) == objE) {
            return objE;
        }
        webResRemoteBean2 = webResRemoteBean;
        list = list2;
        aVar = aVarI;
        webResManager = f53069a;
        webResManager$handleData$1.L$0 = webResRemoteBean2;
        webResManager$handleData$1.L$1 = aVar;
        webResManager$handleData$1.L$2 = null;
        webResManager$handleData$1.label = 4;
        if (webResManager.j(list, webResManager$handleData$1) == objE) {
            return objE;
        }
        webResRemoteBean3 = webResRemoteBean2;
        WebResManager webResManager4 = f53069a;
        webResManager$handleData$1.L$0 = webResRemoteBean3;
        webResManager$handleData$1.L$1 = aVar;
        webResManager$handleData$1.label = 5;
        if (webResManager4.h(webResManager$handleData$1) == objE) {
            return objE;
        }
        WebResManager webResManager5 = f53069a;
        webResManager5.m().putString("lastUpdateTime", webResRemoteBean3.getLastUpdateTime());
        h.f66795a.a(webResManager5.k() + " --> handleData() --> 数据库增量更新完成 --> 删除过期资源");
        return Unit.f68710a;
    }

    public final void p() {
        ObserveNetworkState.f53068a.c();
    }

    /* JADX WARN: Code duplicated, block: B:19:0x007d  */
    /* JADX WARN: Code duplicated, block: B:21:0x0097 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:22:0x0098  */
    /* JADX WARN: Code duplicated, block: B:25:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:30:0x00cf A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:31:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x00d0 -> B:17:0x0077). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object q(java.util.List<com.transsion.lib_web.zip.db.WebViewCacheConfigData> r12, kotlin.coroutines.Continuation<? super kotlin.Unit> r13) {
        /*
            Method dump skipped, instruction units count: 217
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.lib_web.zip.WebResManager.q(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
