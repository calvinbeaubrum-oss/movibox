package com.cloud.tmc.integration.utils;

import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.service.ConfigService;
import com.hisavana.common.constant.ComConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
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
public final class PopWindowManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PopWindowManager f31020a = new PopWindowManager();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, ArrayList<PopWindowData>> f31021b = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f31022c = "PopWindowManager";

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class PopWindowData extends rc.b {
        private String appId;
        private long delayTime;
        private boolean ignoreInterval;
        private a popWindowController;
        private int priority;

        public PopWindowData(String appId, long j11, int i11, a popWindowController, boolean z11) {
            Intrinsics.g(appId, "appId");
            Intrinsics.g(popWindowController, "popWindowController");
            this.appId = appId;
            this.delayTime = j11;
            this.priority = i11;
            this.popWindowController = popWindowController;
            this.ignoreInterval = z11;
        }

        public /* synthetic */ PopWindowData(String str, long j11, int i11, a aVar, boolean z11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, j11, i11, aVar, (i12 & 16) != 0 ? false : z11);
        }

        public static /* synthetic */ PopWindowData copy$default(PopWindowData popWindowData, String str, long j11, int i11, a aVar, boolean z11, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                str = popWindowData.appId;
            }
            if ((i12 & 2) != 0) {
                j11 = popWindowData.delayTime;
            }
            long j12 = j11;
            if ((i12 & 4) != 0) {
                i11 = popWindowData.priority;
            }
            int i13 = i11;
            if ((i12 & 8) != 0) {
                aVar = popWindowData.popWindowController;
            }
            a aVar2 = aVar;
            if ((i12 & 16) != 0) {
                z11 = popWindowData.ignoreInterval;
            }
            return popWindowData.copy(str, j12, i13, aVar2, z11);
        }

        public final String component1() {
            return this.appId;
        }

        public final long component2() {
            return this.delayTime;
        }

        public final int component3() {
            return this.priority;
        }

        public final a component4() {
            return this.popWindowController;
        }

        public final boolean component5() {
            return this.ignoreInterval;
        }

        public final PopWindowData copy(String appId, long j11, int i11, a popWindowController, boolean z11) {
            Intrinsics.g(appId, "appId");
            Intrinsics.g(popWindowController, "popWindowController");
            return new PopWindowData(appId, j11, i11, popWindowController, z11);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PopWindowData)) {
                return false;
            }
            PopWindowData popWindowData = (PopWindowData) obj;
            return Intrinsics.b(this.appId, popWindowData.appId) && this.delayTime == popWindowData.delayTime && this.priority == popWindowData.priority && Intrinsics.b(this.popWindowController, popWindowData.popWindowController) && this.ignoreInterval == popWindowData.ignoreInterval;
        }

        public final String getAppId() {
            return this.appId;
        }

        public final long getDelayTime() {
            return this.delayTime;
        }

        public final boolean getIgnoreInterval() {
            return this.ignoreInterval;
        }

        public final a getPopWindowController() {
            return this.popWindowController;
        }

        public final int getPriority() {
            return this.priority;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v9, types: [int] */
        /* JADX WARN: Type inference failed for: r1v6, types: [int] */
        /* JADX WARN: Type inference failed for: r1v7 */
        /* JADX WARN: Type inference failed for: r1v8 */
        public int hashCode() {
            int iHashCode = ((((((this.appId.hashCode() * 31) + l.p.a(this.delayTime)) * 31) + this.priority) * 31) + this.popWindowController.hashCode()) * 31;
            boolean z11 = this.ignoreInterval;
            ?? r11 = z11;
            if (z11) {
                r11 = 1;
            }
            return iHashCode + r11;
        }

        public final void setAppId(String str) {
            Intrinsics.g(str, "<set-?>");
            this.appId = str;
        }

        public final void setDelayTime(long j11) {
            this.delayTime = j11;
        }

        public final void setIgnoreInterval(boolean z11) {
            this.ignoreInterval = z11;
        }

        public final void setPopWindowController(a aVar) {
            Intrinsics.g(aVar, "<set-?>");
            this.popWindowController = aVar;
        }

        public final void setPriority(int i11) {
            this.priority = i11;
        }

        public String toString() {
            return "PopWindowData(appId=" + this.appId + ", delayTime=" + this.delayTime + ", priority=" + this.priority + ", popWindowController=" + this.popWindowController + ", ignoreInterval=" + this.ignoreInterval + ')';
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public interface a {
        void a(PopWindowData popWindowData);

        void show(String str);
    }

    public final void a(String key, PopWindowData bean) {
        Intrinsics.g(key, "key");
        Intrinsics.g(bean, "bean");
        ConcurrentHashMap<String, ArrayList<PopWindowData>> concurrentHashMap = f31021b;
        synchronized (concurrentHashMap) {
            try {
                ArrayList<PopWindowData> arrayList = concurrentHashMap.get(key);
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                } else {
                    Intrinsics.f(arrayList, "controllerMap[key] ?: ArrayList()");
                }
                Iterator<PopWindowData> it = arrayList.iterator();
                int i11 = 0;
                while (true) {
                    if (!it.hasNext()) {
                        i11 = -1;
                        break;
                    } else if (it.next().getDelayTime() >= bean.getDelayTime()) {
                        break;
                    } else {
                        i11++;
                    }
                }
                if (i11 == -1) {
                    arrayList.add(bean);
                } else {
                    arrayList.add(i11, bean);
                }
                f31021b.put(key, arrayList);
                f31020a.c(key);
            } catch (Throwable unused) {
                TmcLogger.e(f31022c);
            }
            Unit unit = Unit.f68710a;
        }
    }

    public final void b(String key) {
        Intrinsics.g(key, "key");
        ConcurrentHashMap<String, ArrayList<PopWindowData>> concurrentHashMap = f31021b;
        synchronized (concurrentHashMap) {
            try {
                concurrentHashMap.remove(key);
            } catch (Throwable th2) {
                TmcLogger.f(f31022c, "clearPopWindow error: " + th2);
                Unit unit = Unit.f68710a;
            }
        }
    }

    public final void c(String str) {
        PopWindowData popWindowData;
        try {
            ArrayList<PopWindowData> arrayList = f31021b.get(str);
            if (arrayList == null || (popWindowData = (PopWindowData) CollectionsKt___CollectionsKt.g0(arrayList)) == null) {
                return;
            }
            popWindowData.getPopWindowController().a(popWindowData);
        } catch (Throwable th2) {
            TmcLogger.f(f31022c, "refreshPopWindow error: " + th2);
        }
    }

    public final void d(String key, long j11) {
        Intrinsics.g(key, "key");
        ConcurrentHashMap<String, ArrayList<PopWindowData>> concurrentHashMap = f31021b;
        synchronized (concurrentHashMap) {
            try {
                ArrayList arrayList = new ArrayList();
                ArrayList<PopWindowData> arrayList2 = concurrentHashMap.get(key);
                PopWindowData popWindowData = null;
                if (arrayList2 != null) {
                    Intrinsics.f(arrayList2, "controllerMap[key]");
                    for (PopWindowData popWindowData2 : arrayList2) {
                        if (popWindowData != null) {
                            int configInt = ((ConfigService) tc.a.a(ConfigService.class)).getConfigInt("miniPopwindowintervalTime", ComConstants.AD_TIMEOUT_MILLIS);
                            TmcLogger.c(f31022c, "KEY_MINI_POPWINDOW_INTERVAL_TIME->" + configInt);
                            if (!(!popWindowData.getIgnoreInterval())) {
                                continue;
                            } else if (popWindowData2.getDelayTime() - popWindowData.getDelayTime() >= configInt || popWindowData2.getIgnoreInterval()) {
                                break;
                                break;
                            } else if (popWindowData2.getPriority() > popWindowData.getPriority()) {
                                arrayList.add(popWindowData);
                            } else {
                                arrayList.add(popWindowData2);
                            }
                        }
                        popWindowData = popWindowData2;
                    }
                }
                if (popWindowData != null && j11 >= popWindowData.getDelayTime()) {
                    arrayList.add(popWindowData);
                }
                ArrayList<PopWindowData> arrayList3 = f31021b.get(key);
                if (arrayList3 != null) {
                    arrayList3.removeAll(CollectionsKt___CollectionsKt.O0(arrayList));
                }
                if (popWindowData != null) {
                    if (j11 >= popWindowData.getDelayTime()) {
                        popWindowData.getPopWindowController().show(popWindowData.getAppId());
                        f31020a.c(key);
                    } else {
                        popWindowData.getPopWindowController().a(popWindowData);
                    }
                    Unit unit = Unit.f68710a;
                }
            } catch (Throwable th2) {
                TmcLogger.f(f31022c, "showPopWindow error :" + th2);
                Unit unit2 = Unit.f68710a;
            }
        }
    }
}
