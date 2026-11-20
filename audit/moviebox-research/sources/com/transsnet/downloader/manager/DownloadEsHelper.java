package com.transsnet.downloader.manager;

import android.app.Application;
import com.blankj.utilcode.util.Utils;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.db.download.DownloadEsBean;
import com.transsion.baselib.db.download.SubtitleBean;
import com.transsion.baselib.db.video.VideoLandAdBean;
import com.transsion.baselib.db.video.f;
import com.transsion.baselib.report.launch.RoomAppMMKV;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsnet.downloader.R$string;
import com.transsnet.downloader.util.DownloadUtil;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.flow.event.sync.event.LocalVideoEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import tr.m;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
@SourceDebugExtension
public final class DownloadEsHelper {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final a f60994m = new a(null);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Lazy<DownloadEsHelper> f60995n = LazyKt__LazyJVMKt.b(new Function0<DownloadEsHelper>() { // from class: com.transsnet.downloader.manager.DownloadEsHelper$Companion$instance$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final DownloadEsHelper invoke() {
            return new DownloadEsHelper();
        }
    });

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, DownloadBean> f60996a = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<String, SubtitleBean> f60997b = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap<String, VideoLandAdBean> f60998c = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConcurrentHashMap<String, DownloadBean> f60999d = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ConcurrentHashMap<String, DownloadBean> f61000e = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f61001f = "";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f61002g = "";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f61003h = 1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f61004i = LazyKt__LazyJVMKt.b(new Function0<tr.c>() { // from class: com.transsnet.downloader.manager.DownloadEsHelper$downloadDao$2
        @Override // kotlin.jvm.functions.Function0
        public final tr.c invoke() {
            Application applicationA = com.tn.lib.util.a.f49452a.a();
            if (applicationA != null) {
                return AppDatabase.f51036p.b(applicationA).E0();
            }
            return null;
        }
    });

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f61005j = LazyKt__LazyJVMKt.b(new Function0<m>() { // from class: com.transsnet.downloader.manager.DownloadEsHelper$subtitleDao$2
        @Override // kotlin.jvm.functions.Function0
        public final m invoke() {
            Application applicationA = com.tn.lib.util.a.f49452a.a();
            if (applicationA != null) {
                return AppDatabase.f51036p.b(applicationA).M0();
            }
            return null;
        }
    });

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f61006k = LazyKt__LazyJVMKt.b(new Function0<f>() { // from class: com.transsnet.downloader.manager.DownloadEsHelper$videoLandAdDao$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final f invoke() {
            Application applicationA = com.tn.lib.util.a.f49452a.a();
            if (applicationA != null) {
                return AppDatabase.f51036p.b(applicationA).P0();
            }
            return null;
        }
    });

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public tr.e f61007l;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DownloadEsHelper a() {
            return (DownloadEsHelper) DownloadEsHelper.f60995n.getValue();
        }
    }

    public static /* synthetic */ Object A(DownloadEsHelper downloadEsHelper, String str, boolean z11, Continuation continuation, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        return downloadEsHelper.z(str, z11, continuation);
    }

    public static /* synthetic */ Object J(DownloadEsHelper downloadEsHelper, boolean z11, Continuation continuation, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = false;
        }
        return downloadEsHelper.I(z11, continuation);
    }

    public static /* synthetic */ Object w(DownloadEsHelper downloadEsHelper, boolean z11, Continuation continuation, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = false;
        }
        return downloadEsHelper.v(z11, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:38:0x0079 A[Catch: all -> 0x0030, TryCatch #0 {all -> 0x0030, blocks: (B:13:0x002b, B:69:0x0112, B:70:0x0115, B:72:0x011c, B:73:0x0122, B:75:0x0128, B:20:0x0047, B:39:0x0082, B:41:0x0088, B:43:0x0096, B:44:0x009a, B:46:0x00a0, B:48:0x00a8, B:49:0x00ac, B:60:0x00f6, B:50:0x00b9, B:52:0x00bf, B:53:0x00db, B:55:0x00e1, B:56:0x00e4, B:58:0x00ec, B:59:0x00f0, B:23:0x004f, B:34:0x006d, B:36:0x0072, B:38:0x0079, B:26:0x0056, B:28:0x005b, B:30:0x0061, B:66:0x0109), top: B:80:0x0023 }] */
    /* JADX WARN: Code duplicated, block: B:72:0x011c A[Catch: all -> 0x0030, TryCatch #0 {all -> 0x0030, blocks: (B:13:0x002b, B:69:0x0112, B:70:0x0115, B:72:0x011c, B:73:0x0122, B:75:0x0128, B:20:0x0047, B:39:0x0082, B:41:0x0088, B:43:0x0096, B:44:0x009a, B:46:0x00a0, B:48:0x00a8, B:49:0x00ac, B:60:0x00f6, B:50:0x00b9, B:52:0x00bf, B:53:0x00db, B:55:0x00e1, B:56:0x00e4, B:58:0x00ec, B:59:0x00f0, B:23:0x004f, B:34:0x006d, B:36:0x0072, B:38:0x0079, B:26:0x0056, B:28:0x005b, B:30:0x0061, B:66:0x0109), top: B:80:0x0023 }] */
    /* JADX WARN: Code duplicated, block: B:75:0x0128 A[Catch: all -> 0x0030, LOOP:0: B:73:0x0122->B:75:0x0128, LOOP_END, TRY_LEAVE, TryCatch #0 {all -> 0x0030, blocks: (B:13:0x002b, B:69:0x0112, B:70:0x0115, B:72:0x011c, B:73:0x0122, B:75:0x0128, B:20:0x0047, B:39:0x0082, B:41:0x0088, B:43:0x0096, B:44:0x009a, B:46:0x00a0, B:48:0x00a8, B:49:0x00ac, B:60:0x00f6, B:50:0x00b9, B:52:0x00bf, B:53:0x00db, B:55:0x00e1, B:56:0x00e4, B:58:0x00ec, B:59:0x00f0, B:23:0x004f, B:34:0x006d, B:36:0x0072, B:38:0x0079, B:26:0x0056, B:28:0x005b, B:30:0x0061, B:66:0x0109), top: B:80:0x0023 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code duplicated, block: B:86:? A[RETURN, SYNTHETIC] */
    public final Object B(int i11, Continuation<? super List<? extends DownloadBean>> continuation) throws Throwable {
        DownloadEsHelper$getRecentlyByNum$1 downloadEsHelper$getRecentlyByNum$1;
        List list;
        DownloadEsHelper downloadEsHelper;
        ArrayList arrayList;
        DownloadEsHelper downloadEsHelper2;
        Iterator it;
        List list2;
        ArrayList arrayList2;
        Iterator it2;
        if (continuation instanceof DownloadEsHelper$getRecentlyByNum$1) {
            downloadEsHelper$getRecentlyByNum$1 = (DownloadEsHelper$getRecentlyByNum$1) continuation;
            int i12 = downloadEsHelper$getRecentlyByNum$1.label;
            if ((i12 & Integer.MIN_VALUE) != 0) {
                downloadEsHelper$getRecentlyByNum$1.label = i12 - Integer.MIN_VALUE;
            } else {
                downloadEsHelper$getRecentlyByNum$1 = new DownloadEsHelper$getRecentlyByNum$1(this, continuation);
            }
        } else {
            downloadEsHelper$getRecentlyByNum$1 = new DownloadEsHelper$getRecentlyByNum$1(this, continuation);
        }
        Object objE = downloadEsHelper$getRecentlyByNum$1.result;
        Object objE2 = kotlin.coroutines.intrinsics.a.e();
        int i13 = downloadEsHelper$getRecentlyByNum$1.label;
        try {
            if (i13 == 0) {
                ResultKt.b(objE);
                tr.e eVar = this.f61007l;
                list = null;
                if (eVar != null) {
                    if (eVar != null) {
                        downloadEsHelper$getRecentlyByNum$1.label = 3;
                        objE = eVar.e(i11, downloadEsHelper$getRecentlyByNum$1);
                        if (objE == objE2) {
                            return objE2;
                        }
                        list = (List) objE;
                    }
                    arrayList2 = new ArrayList();
                    if (list != null) {
                        it2 = list.iterator();
                        while (it2.hasNext()) {
                            arrayList2.add(DownloadEsBean.Companion.b((DownloadEsBean) it2.next()));
                        }
                    }
                    return arrayList2;
                }
                tr.c cVarM = m();
                if (cVarM != null) {
                    downloadEsHelper$getRecentlyByNum$1.L$0 = this;
                    downloadEsHelper$getRecentlyByNum$1.label = 1;
                    objE = cVarM.e(i11, downloadEsHelper$getRecentlyByNum$1);
                    if (objE == objE2) {
                        return objE2;
                    }
                    downloadEsHelper = this;
                    list = (List) objE;
                } else {
                    downloadEsHelper = this;
                }
                arrayList = new ArrayList();
                if (list != null) {
                    return arrayList;
                }
                downloadEsHelper2 = downloadEsHelper;
                it = list.iterator();
                list2 = arrayList;
            } else if (i13 == 1) {
                downloadEsHelper = (DownloadEsHelper) downloadEsHelper$getRecentlyByNum$1.L$0;
                ResultKt.b(objE);
                list = (List) objE;
                arrayList = new ArrayList();
                if (list != null) {
                    return arrayList;
                }
                downloadEsHelper2 = downloadEsHelper;
                it = list.iterator();
                list2 = arrayList;
            } else {
                if (i13 != 2) {
                    if (i13 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(objE);
                    list = (List) objE;
                    arrayList2 = new ArrayList();
                    if (list != null) {
                        it2 = list.iterator();
                        while (it2.hasNext()) {
                            arrayList2.add(DownloadEsBean.Companion.b((DownloadEsBean) it2.next()));
                        }
                    }
                    return arrayList2;
                }
                it = (Iterator) downloadEsHelper$getRecentlyByNum$1.L$2;
                list2 = (List) downloadEsHelper$getRecentlyByNum$1.L$1;
                downloadEsHelper2 = (DownloadEsHelper) downloadEsHelper$getRecentlyByNum$1.L$0;
                ResultKt.b(objE);
            }
            while (it.hasNext()) {
                DownloadBean downloadBean = (DownloadBean) it.next();
                ConcurrentHashMap<String, DownloadBean> concurrentHashMap = downloadEsHelper2.f60996a;
                String resourceId = downloadBean.getResourceId();
                if (resourceId == null) {
                    resourceId = downloadBean.getUrl();
                }
                if (concurrentHashMap.containsKey(resourceId)) {
                    ConcurrentHashMap<String, DownloadBean> concurrentHashMap2 = downloadEsHelper2.f60996a;
                    String resourceId2 = downloadBean.getResourceId();
                    if (resourceId2 == null) {
                        resourceId2 = downloadBean.getUrl();
                    }
                    DownloadBean downloadBean2 = concurrentHashMap2.get(resourceId2);
                    Intrinsics.d(downloadBean2);
                    downloadBean = downloadBean2;
                    list2.add(downloadBean);
                } else {
                    if (downloadBean.isShotTV()) {
                        downloadEsHelper2.f60999d.put(downloadBean.getSubjectId() + downloadBean.getEp(), downloadBean);
                    }
                    String subjectId = downloadBean.getSubjectId();
                    if (subjectId != null) {
                        downloadEsHelper2.L(subjectId, downloadBean);
                    }
                    ConcurrentHashMap<String, DownloadBean> concurrentHashMap3 = downloadEsHelper2.f60996a;
                    String resourceId3 = downloadBean.getResourceId();
                    if (resourceId3 == null) {
                        resourceId3 = downloadBean.getUrl();
                    }
                    concurrentHashMap3.put(resourceId3, downloadBean);
                    list2.add(downloadBean);
                }
                downloadEsHelper$getRecentlyByNum$1.L$0 = downloadEsHelper2;
                downloadEsHelper$getRecentlyByNum$1.L$1 = list2;
                downloadEsHelper$getRecentlyByNum$1.L$2 = it;
                downloadEsHelper$getRecentlyByNum$1.label = 2;
                if (downloadEsHelper2.f(downloadBean, downloadEsHelper$getRecentlyByNum$1) == objE2) {
                    return objE2;
                }
            }
            return list2;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return new ArrayList();
        }
    }

    /* JADX WARN: Code duplicated, block: B:35:0x0070 A[Catch: all -> 0x0038, TryCatch #0 {all -> 0x0038, blocks: (B:13:0x0034, B:36:0x0078, B:38:0x007e, B:40:0x008c, B:41:0x0090, B:43:0x0096, B:45:0x009e, B:46:0x00a2, B:54:0x00e3, B:47:0x00af, B:49:0x00b5, B:50:0x00d1, B:52:0x00d9, B:53:0x00dd, B:20:0x0047, B:31:0x0064, B:33:0x0069, B:35:0x0070, B:23:0x004e, B:25:0x0052, B:27:0x0058, B:58:0x00f3), top: B:62:0x0022 }] */
    /* JADX WARN: Code duplicated, block: B:38:0x007e A[Catch: all -> 0x0038, TryCatch #0 {all -> 0x0038, blocks: (B:13:0x0034, B:36:0x0078, B:38:0x007e, B:40:0x008c, B:41:0x0090, B:43:0x0096, B:45:0x009e, B:46:0x00a2, B:54:0x00e3, B:47:0x00af, B:49:0x00b5, B:50:0x00d1, B:52:0x00d9, B:53:0x00dd, B:20:0x0047, B:31:0x0064, B:33:0x0069, B:35:0x0070, B:23:0x004e, B:25:0x0052, B:27:0x0058, B:58:0x00f3), top: B:62:0x0022 }] */
    /* JADX WARN: Code duplicated, block: B:40:0x008c A[Catch: all -> 0x0038, TryCatch #0 {all -> 0x0038, blocks: (B:13:0x0034, B:36:0x0078, B:38:0x007e, B:40:0x008c, B:41:0x0090, B:43:0x0096, B:45:0x009e, B:46:0x00a2, B:54:0x00e3, B:47:0x00af, B:49:0x00b5, B:50:0x00d1, B:52:0x00d9, B:53:0x00dd, B:20:0x0047, B:31:0x0064, B:33:0x0069, B:35:0x0070, B:23:0x004e, B:25:0x0052, B:27:0x0058, B:58:0x00f3), top: B:62:0x0022 }] */
    /* JADX WARN: Code duplicated, block: B:43:0x0096 A[Catch: all -> 0x0038, TryCatch #0 {all -> 0x0038, blocks: (B:13:0x0034, B:36:0x0078, B:38:0x007e, B:40:0x008c, B:41:0x0090, B:43:0x0096, B:45:0x009e, B:46:0x00a2, B:54:0x00e3, B:47:0x00af, B:49:0x00b5, B:50:0x00d1, B:52:0x00d9, B:53:0x00dd, B:20:0x0047, B:31:0x0064, B:33:0x0069, B:35:0x0070, B:23:0x004e, B:25:0x0052, B:27:0x0058, B:58:0x00f3), top: B:62:0x0022 }] */
    /* JADX WARN: Code duplicated, block: B:45:0x009e A[Catch: all -> 0x0038, TryCatch #0 {all -> 0x0038, blocks: (B:13:0x0034, B:36:0x0078, B:38:0x007e, B:40:0x008c, B:41:0x0090, B:43:0x0096, B:45:0x009e, B:46:0x00a2, B:54:0x00e3, B:47:0x00af, B:49:0x00b5, B:50:0x00d1, B:52:0x00d9, B:53:0x00dd, B:20:0x0047, B:31:0x0064, B:33:0x0069, B:35:0x0070, B:23:0x004e, B:25:0x0052, B:27:0x0058, B:58:0x00f3), top: B:62:0x0022 }] */
    /* JADX WARN: Code duplicated, block: B:47:0x00af A[Catch: all -> 0x0038, TryCatch #0 {all -> 0x0038, blocks: (B:13:0x0034, B:36:0x0078, B:38:0x007e, B:40:0x008c, B:41:0x0090, B:43:0x0096, B:45:0x009e, B:46:0x00a2, B:54:0x00e3, B:47:0x00af, B:49:0x00b5, B:50:0x00d1, B:52:0x00d9, B:53:0x00dd, B:20:0x0047, B:31:0x0064, B:33:0x0069, B:35:0x0070, B:23:0x004e, B:25:0x0052, B:27:0x0058, B:58:0x00f3), top: B:62:0x0022 }] */
    /* JADX WARN: Code duplicated, block: B:49:0x00b5 A[Catch: all -> 0x0038, TryCatch #0 {all -> 0x0038, blocks: (B:13:0x0034, B:36:0x0078, B:38:0x007e, B:40:0x008c, B:41:0x0090, B:43:0x0096, B:45:0x009e, B:46:0x00a2, B:54:0x00e3, B:47:0x00af, B:49:0x00b5, B:50:0x00d1, B:52:0x00d9, B:53:0x00dd, B:20:0x0047, B:31:0x0064, B:33:0x0069, B:35:0x0070, B:23:0x004e, B:25:0x0052, B:27:0x0058, B:58:0x00f3), top: B:62:0x0022 }] */
    /* JADX WARN: Code duplicated, block: B:52:0x00d9 A[Catch: all -> 0x0038, TryCatch #0 {all -> 0x0038, blocks: (B:13:0x0034, B:36:0x0078, B:38:0x007e, B:40:0x008c, B:41:0x0090, B:43:0x0096, B:45:0x009e, B:46:0x00a2, B:54:0x00e3, B:47:0x00af, B:49:0x00b5, B:50:0x00d1, B:52:0x00d9, B:53:0x00dd, B:20:0x0047, B:31:0x0064, B:33:0x0069, B:35:0x0070, B:23:0x004e, B:25:0x0052, B:27:0x0058, B:58:0x00f3), top: B:62:0x0022 }] */
    /* JADX WARN: Code duplicated, block: B:64:0x00f1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:66:? A[LOOP:0: B:36:0x0078->B:66:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Instruction removed from duplicated block: B:49:0x00b5, please report this as an issue */
    public final Object C(String str, Continuation<? super List<? extends DownloadBean>> continuation) throws Throwable {
        DownloadEsHelper$getSeries$1 downloadEsHelper$getSeries$1;
        List list;
        DownloadEsHelper downloadEsHelper;
        List arrayList;
        DownloadEsHelper downloadEsHelper2;
        Iterator it;
        DownloadBean downloadBean;
        ConcurrentHashMap<String, DownloadBean> concurrentHashMap;
        String resourceId;
        String resourceId2;
        String resourceId3;
        if (continuation instanceof DownloadEsHelper$getSeries$1) {
            downloadEsHelper$getSeries$1 = (DownloadEsHelper$getSeries$1) continuation;
            int i11 = downloadEsHelper$getSeries$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                downloadEsHelper$getSeries$1.label = i11 - Integer.MIN_VALUE;
            } else {
                downloadEsHelper$getSeries$1 = new DownloadEsHelper$getSeries$1(this, continuation);
            }
        } else {
            downloadEsHelper$getSeries$1 = new DownloadEsHelper$getSeries$1(this, continuation);
        }
        Object objK = downloadEsHelper$getSeries$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = downloadEsHelper$getSeries$1.label;
        try {
            if (i12 != 0) {
                if (i12 == 1) {
                    downloadEsHelper = (DownloadEsHelper) downloadEsHelper$getSeries$1.L$0;
                    ResultKt.b(objK);
                } else {
                    if (i12 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    it = (Iterator) downloadEsHelper$getSeries$1.L$2;
                    arrayList = (List) downloadEsHelper$getSeries$1.L$1;
                    downloadEsHelper2 = (DownloadEsHelper) downloadEsHelper$getSeries$1.L$0;
                    ResultKt.b(objK);
                }
                while (it.hasNext()) {
                    downloadBean = (DownloadBean) it.next();
                    concurrentHashMap = downloadEsHelper2.f60996a;
                    resourceId = downloadBean.getResourceId();
                    if (resourceId == null) {
                        resourceId = downloadBean.getUrl();
                    }
                    if (concurrentHashMap.containsKey(resourceId)) {
                        ConcurrentHashMap<String, DownloadBean> concurrentHashMap2 = downloadEsHelper2.f60996a;
                        resourceId3 = downloadBean.getResourceId();
                        if (resourceId3 == null) {
                            resourceId3 = downloadBean.getUrl();
                        }
                        DownloadBean downloadBean2 = concurrentHashMap2.get(resourceId3);
                        Intrinsics.d(downloadBean2);
                        downloadBean = downloadBean2;
                        arrayList.add(downloadBean);
                    } else {
                        if (downloadBean.isShotTV()) {
                            downloadEsHelper2.f60999d.put(downloadBean.getSubjectId() + downloadBean.getEp(), downloadBean);
                        }
                        ConcurrentHashMap<String, DownloadBean> concurrentHashMap3 = downloadEsHelper2.f60996a;
                        resourceId2 = downloadBean.getResourceId();
                        if (resourceId2 == null) {
                            resourceId2 = downloadBean.getUrl();
                        }
                        concurrentHashMap3.put(resourceId2, downloadBean);
                        arrayList.add(downloadBean);
                    }
                    downloadEsHelper$getSeries$1.L$0 = downloadEsHelper2;
                    downloadEsHelper$getSeries$1.L$1 = arrayList;
                    downloadEsHelper$getSeries$1.L$2 = it;
                    downloadEsHelper$getSeries$1.label = 2;
                    if (downloadEsHelper2.f(downloadBean, downloadEsHelper$getSeries$1) == objE) {
                        return objE;
                    }
                }
                return arrayList;
            }
            ResultKt.b(objK);
            if (this.f61007l != null) {
                return new ArrayList();
            }
            tr.c cVarM = m();
            if (cVarM != null) {
                downloadEsHelper$getSeries$1.L$0 = this;
                downloadEsHelper$getSeries$1.label = 1;
                objK = cVarM.k(str, downloadEsHelper$getSeries$1);
                if (objK == objE) {
                    return objE;
                }
                downloadEsHelper = this;
            } else {
                list = null;
                downloadEsHelper = this;
            }
            arrayList = new ArrayList();
            if (list != null) {
                downloadEsHelper2 = downloadEsHelper;
                it = list.iterator();
                while (it.hasNext()) {
                    downloadBean = (DownloadBean) it.next();
                    concurrentHashMap = downloadEsHelper2.f60996a;
                    resourceId = downloadBean.getResourceId();
                    if (resourceId == null) {
                        resourceId = downloadBean.getUrl();
                    }
                    if (concurrentHashMap.containsKey(resourceId)) {
                        ConcurrentHashMap<String, DownloadBean> concurrentHashMap4 = downloadEsHelper2.f60996a;
                        resourceId3 = downloadBean.getResourceId();
                        if (resourceId3 == null) {
                            resourceId3 = downloadBean.getUrl();
                        }
                        DownloadBean downloadBean3 = concurrentHashMap4.get(resourceId3);
                        Intrinsics.d(downloadBean3);
                        downloadBean = downloadBean3;
                        arrayList.add(downloadBean);
                    } else {
                        if (downloadBean.isShotTV()) {
                            downloadEsHelper2.f60999d.put(downloadBean.getSubjectId() + downloadBean.getEp(), downloadBean);
                        }
                        ConcurrentHashMap<String, DownloadBean> concurrentHashMap5 = downloadEsHelper2.f60996a;
                        resourceId2 = downloadBean.getResourceId();
                        if (resourceId2 == null) {
                            resourceId2 = downloadBean.getUrl();
                        }
                        concurrentHashMap5.put(resourceId2, downloadBean);
                        arrayList.add(downloadBean);
                    }
                    downloadEsHelper$getSeries$1.L$0 = downloadEsHelper2;
                    downloadEsHelper$getSeries$1.L$1 = arrayList;
                    downloadEsHelper$getSeries$1.L$2 = it;
                    downloadEsHelper$getSeries$1.label = 2;
                    if (downloadEsHelper2.f(downloadBean, downloadEsHelper$getSeries$1) == objE) {
                        return objE;
                    }
                }
            }
            return arrayList;
            list = (List) objK;
            arrayList = new ArrayList();
            if (list != null) {
                downloadEsHelper2 = downloadEsHelper;
                it = list.iterator();
                while (it.hasNext()) {
                    downloadBean = (DownloadBean) it.next();
                    concurrentHashMap = downloadEsHelper2.f60996a;
                    resourceId = downloadBean.getResourceId();
                    if (resourceId == null) {
                        resourceId = downloadBean.getUrl();
                    }
                    if (concurrentHashMap.containsKey(resourceId)) {
                        ConcurrentHashMap<String, DownloadBean> concurrentHashMap6 = downloadEsHelper2.f60996a;
                        resourceId3 = downloadBean.getResourceId();
                        if (resourceId3 == null) {
                            resourceId3 = downloadBean.getUrl();
                        }
                        DownloadBean downloadBean4 = concurrentHashMap6.get(resourceId3);
                        Intrinsics.d(downloadBean4);
                        downloadBean = downloadBean4;
                        arrayList.add(downloadBean);
                    } else {
                        if (downloadBean.isShotTV()) {
                            downloadEsHelper2.f60999d.put(downloadBean.getSubjectId() + downloadBean.getEp(), downloadBean);
                        }
                        ConcurrentHashMap<String, DownloadBean> concurrentHashMap7 = downloadEsHelper2.f60996a;
                        resourceId2 = downloadBean.getResourceId();
                        if (resourceId2 == null) {
                            resourceId2 = downloadBean.getUrl();
                        }
                        concurrentHashMap7.put(resourceId2, downloadBean);
                        arrayList.add(downloadBean);
                    }
                    downloadEsHelper$getSeries$1.L$0 = downloadEsHelper2;
                    downloadEsHelper$getSeries$1.L$1 = arrayList;
                    downloadEsHelper$getSeries$1.L$2 = it;
                    downloadEsHelper$getSeries$1.label = 2;
                    if (downloadEsHelper2.f(downloadBean, downloadEsHelper$getSeries$1) == objE) {
                        return objE;
                    }
                }
            }
            return arrayList;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return new ArrayList();
        }
    }

    /* JADX WARN: Code duplicated, block: B:35:0x0070 A[Catch: all -> 0x0038, TryCatch #0 {all -> 0x0038, blocks: (B:13:0x0034, B:36:0x0078, B:38:0x007e, B:40:0x008c, B:41:0x0090, B:43:0x0096, B:45:0x009e, B:46:0x00a2, B:54:0x00e3, B:47:0x00af, B:49:0x00b5, B:50:0x00d1, B:52:0x00d9, B:53:0x00dd, B:20:0x0047, B:31:0x0064, B:33:0x0069, B:35:0x0070, B:23:0x004e, B:25:0x0052, B:27:0x0058, B:58:0x00f3), top: B:62:0x0022 }] */
    /* JADX WARN: Code duplicated, block: B:38:0x007e A[Catch: all -> 0x0038, TryCatch #0 {all -> 0x0038, blocks: (B:13:0x0034, B:36:0x0078, B:38:0x007e, B:40:0x008c, B:41:0x0090, B:43:0x0096, B:45:0x009e, B:46:0x00a2, B:54:0x00e3, B:47:0x00af, B:49:0x00b5, B:50:0x00d1, B:52:0x00d9, B:53:0x00dd, B:20:0x0047, B:31:0x0064, B:33:0x0069, B:35:0x0070, B:23:0x004e, B:25:0x0052, B:27:0x0058, B:58:0x00f3), top: B:62:0x0022 }] */
    /* JADX WARN: Code duplicated, block: B:40:0x008c A[Catch: all -> 0x0038, TryCatch #0 {all -> 0x0038, blocks: (B:13:0x0034, B:36:0x0078, B:38:0x007e, B:40:0x008c, B:41:0x0090, B:43:0x0096, B:45:0x009e, B:46:0x00a2, B:54:0x00e3, B:47:0x00af, B:49:0x00b5, B:50:0x00d1, B:52:0x00d9, B:53:0x00dd, B:20:0x0047, B:31:0x0064, B:33:0x0069, B:35:0x0070, B:23:0x004e, B:25:0x0052, B:27:0x0058, B:58:0x00f3), top: B:62:0x0022 }] */
    /* JADX WARN: Code duplicated, block: B:43:0x0096 A[Catch: all -> 0x0038, TryCatch #0 {all -> 0x0038, blocks: (B:13:0x0034, B:36:0x0078, B:38:0x007e, B:40:0x008c, B:41:0x0090, B:43:0x0096, B:45:0x009e, B:46:0x00a2, B:54:0x00e3, B:47:0x00af, B:49:0x00b5, B:50:0x00d1, B:52:0x00d9, B:53:0x00dd, B:20:0x0047, B:31:0x0064, B:33:0x0069, B:35:0x0070, B:23:0x004e, B:25:0x0052, B:27:0x0058, B:58:0x00f3), top: B:62:0x0022 }] */
    /* JADX WARN: Code duplicated, block: B:45:0x009e A[Catch: all -> 0x0038, TryCatch #0 {all -> 0x0038, blocks: (B:13:0x0034, B:36:0x0078, B:38:0x007e, B:40:0x008c, B:41:0x0090, B:43:0x0096, B:45:0x009e, B:46:0x00a2, B:54:0x00e3, B:47:0x00af, B:49:0x00b5, B:50:0x00d1, B:52:0x00d9, B:53:0x00dd, B:20:0x0047, B:31:0x0064, B:33:0x0069, B:35:0x0070, B:23:0x004e, B:25:0x0052, B:27:0x0058, B:58:0x00f3), top: B:62:0x0022 }] */
    /* JADX WARN: Code duplicated, block: B:47:0x00af A[Catch: all -> 0x0038, TryCatch #0 {all -> 0x0038, blocks: (B:13:0x0034, B:36:0x0078, B:38:0x007e, B:40:0x008c, B:41:0x0090, B:43:0x0096, B:45:0x009e, B:46:0x00a2, B:54:0x00e3, B:47:0x00af, B:49:0x00b5, B:50:0x00d1, B:52:0x00d9, B:53:0x00dd, B:20:0x0047, B:31:0x0064, B:33:0x0069, B:35:0x0070, B:23:0x004e, B:25:0x0052, B:27:0x0058, B:58:0x00f3), top: B:62:0x0022 }] */
    /* JADX WARN: Code duplicated, block: B:49:0x00b5 A[Catch: all -> 0x0038, TryCatch #0 {all -> 0x0038, blocks: (B:13:0x0034, B:36:0x0078, B:38:0x007e, B:40:0x008c, B:41:0x0090, B:43:0x0096, B:45:0x009e, B:46:0x00a2, B:54:0x00e3, B:47:0x00af, B:49:0x00b5, B:50:0x00d1, B:52:0x00d9, B:53:0x00dd, B:20:0x0047, B:31:0x0064, B:33:0x0069, B:35:0x0070, B:23:0x004e, B:25:0x0052, B:27:0x0058, B:58:0x00f3), top: B:62:0x0022 }] */
    /* JADX WARN: Code duplicated, block: B:52:0x00d9 A[Catch: all -> 0x0038, TryCatch #0 {all -> 0x0038, blocks: (B:13:0x0034, B:36:0x0078, B:38:0x007e, B:40:0x008c, B:41:0x0090, B:43:0x0096, B:45:0x009e, B:46:0x00a2, B:54:0x00e3, B:47:0x00af, B:49:0x00b5, B:50:0x00d1, B:52:0x00d9, B:53:0x00dd, B:20:0x0047, B:31:0x0064, B:33:0x0069, B:35:0x0070, B:23:0x004e, B:25:0x0052, B:27:0x0058, B:58:0x00f3), top: B:62:0x0022 }] */
    /* JADX WARN: Code duplicated, block: B:64:0x00f1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:66:? A[LOOP:0: B:36:0x0078->B:66:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Instruction removed from duplicated block: B:49:0x00b5, please report this as an issue */
    public final Object D(String str, Continuation<? super List<? extends DownloadBean>> continuation) throws Throwable {
        DownloadEsHelper$getSeriesCompleted$1 downloadEsHelper$getSeriesCompleted$1;
        List list;
        DownloadEsHelper downloadEsHelper;
        List arrayList;
        DownloadEsHelper downloadEsHelper2;
        Iterator it;
        DownloadBean downloadBean;
        ConcurrentHashMap<String, DownloadBean> concurrentHashMap;
        String resourceId;
        String resourceId2;
        String resourceId3;
        if (continuation instanceof DownloadEsHelper$getSeriesCompleted$1) {
            downloadEsHelper$getSeriesCompleted$1 = (DownloadEsHelper$getSeriesCompleted$1) continuation;
            int i11 = downloadEsHelper$getSeriesCompleted$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                downloadEsHelper$getSeriesCompleted$1.label = i11 - Integer.MIN_VALUE;
            } else {
                downloadEsHelper$getSeriesCompleted$1 = new DownloadEsHelper$getSeriesCompleted$1(this, continuation);
            }
        } else {
            downloadEsHelper$getSeriesCompleted$1 = new DownloadEsHelper$getSeriesCompleted$1(this, continuation);
        }
        Object objL = downloadEsHelper$getSeriesCompleted$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = downloadEsHelper$getSeriesCompleted$1.label;
        try {
            if (i12 != 0) {
                if (i12 == 1) {
                    downloadEsHelper = (DownloadEsHelper) downloadEsHelper$getSeriesCompleted$1.L$0;
                    ResultKt.b(objL);
                } else {
                    if (i12 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    it = (Iterator) downloadEsHelper$getSeriesCompleted$1.L$2;
                    arrayList = (List) downloadEsHelper$getSeriesCompleted$1.L$1;
                    downloadEsHelper2 = (DownloadEsHelper) downloadEsHelper$getSeriesCompleted$1.L$0;
                    ResultKt.b(objL);
                }
                while (it.hasNext()) {
                    downloadBean = (DownloadBean) it.next();
                    concurrentHashMap = downloadEsHelper2.f60996a;
                    resourceId = downloadBean.getResourceId();
                    if (resourceId == null) {
                        resourceId = downloadBean.getUrl();
                    }
                    if (concurrentHashMap.containsKey(resourceId)) {
                        ConcurrentHashMap<String, DownloadBean> concurrentHashMap2 = downloadEsHelper2.f60996a;
                        resourceId3 = downloadBean.getResourceId();
                        if (resourceId3 == null) {
                            resourceId3 = downloadBean.getUrl();
                        }
                        DownloadBean downloadBean2 = concurrentHashMap2.get(resourceId3);
                        Intrinsics.d(downloadBean2);
                        downloadBean = downloadBean2;
                        arrayList.add(downloadBean);
                    } else {
                        if (downloadBean.isShotTV()) {
                            downloadEsHelper2.f60999d.put(downloadBean.getSubjectId() + downloadBean.getEp(), downloadBean);
                        }
                        ConcurrentHashMap<String, DownloadBean> concurrentHashMap3 = downloadEsHelper2.f60996a;
                        resourceId2 = downloadBean.getResourceId();
                        if (resourceId2 == null) {
                            resourceId2 = downloadBean.getUrl();
                        }
                        concurrentHashMap3.put(resourceId2, downloadBean);
                        arrayList.add(downloadBean);
                    }
                    downloadEsHelper$getSeriesCompleted$1.L$0 = downloadEsHelper2;
                    downloadEsHelper$getSeriesCompleted$1.L$1 = arrayList;
                    downloadEsHelper$getSeriesCompleted$1.L$2 = it;
                    downloadEsHelper$getSeriesCompleted$1.label = 2;
                    if (downloadEsHelper2.f(downloadBean, downloadEsHelper$getSeriesCompleted$1) == objE) {
                        return objE;
                    }
                }
                return arrayList;
            }
            ResultKt.b(objL);
            if (this.f61007l != null) {
                return new ArrayList();
            }
            tr.c cVarM = m();
            if (cVarM != null) {
                downloadEsHelper$getSeriesCompleted$1.L$0 = this;
                downloadEsHelper$getSeriesCompleted$1.label = 1;
                objL = cVarM.l(str, downloadEsHelper$getSeriesCompleted$1);
                if (objL == objE) {
                    return objE;
                }
                downloadEsHelper = this;
            } else {
                list = null;
                downloadEsHelper = this;
            }
            arrayList = new ArrayList();
            if (list != null) {
                downloadEsHelper2 = downloadEsHelper;
                it = list.iterator();
                while (it.hasNext()) {
                    downloadBean = (DownloadBean) it.next();
                    concurrentHashMap = downloadEsHelper2.f60996a;
                    resourceId = downloadBean.getResourceId();
                    if (resourceId == null) {
                        resourceId = downloadBean.getUrl();
                    }
                    if (concurrentHashMap.containsKey(resourceId)) {
                        ConcurrentHashMap<String, DownloadBean> concurrentHashMap4 = downloadEsHelper2.f60996a;
                        resourceId3 = downloadBean.getResourceId();
                        if (resourceId3 == null) {
                            resourceId3 = downloadBean.getUrl();
                        }
                        DownloadBean downloadBean3 = concurrentHashMap4.get(resourceId3);
                        Intrinsics.d(downloadBean3);
                        downloadBean = downloadBean3;
                        arrayList.add(downloadBean);
                    } else {
                        if (downloadBean.isShotTV()) {
                            downloadEsHelper2.f60999d.put(downloadBean.getSubjectId() + downloadBean.getEp(), downloadBean);
                        }
                        ConcurrentHashMap<String, DownloadBean> concurrentHashMap5 = downloadEsHelper2.f60996a;
                        resourceId2 = downloadBean.getResourceId();
                        if (resourceId2 == null) {
                            resourceId2 = downloadBean.getUrl();
                        }
                        concurrentHashMap5.put(resourceId2, downloadBean);
                        arrayList.add(downloadBean);
                    }
                    downloadEsHelper$getSeriesCompleted$1.L$0 = downloadEsHelper2;
                    downloadEsHelper$getSeriesCompleted$1.L$1 = arrayList;
                    downloadEsHelper$getSeriesCompleted$1.L$2 = it;
                    downloadEsHelper$getSeriesCompleted$1.label = 2;
                    if (downloadEsHelper2.f(downloadBean, downloadEsHelper$getSeriesCompleted$1) == objE) {
                        return objE;
                    }
                }
            }
            return arrayList;
            list = (List) objL;
            arrayList = new ArrayList();
            if (list != null) {
                downloadEsHelper2 = downloadEsHelper;
                it = list.iterator();
                while (it.hasNext()) {
                    downloadBean = (DownloadBean) it.next();
                    concurrentHashMap = downloadEsHelper2.f60996a;
                    resourceId = downloadBean.getResourceId();
                    if (resourceId == null) {
                        resourceId = downloadBean.getUrl();
                    }
                    if (concurrentHashMap.containsKey(resourceId)) {
                        ConcurrentHashMap<String, DownloadBean> concurrentHashMap6 = downloadEsHelper2.f60996a;
                        resourceId3 = downloadBean.getResourceId();
                        if (resourceId3 == null) {
                            resourceId3 = downloadBean.getUrl();
                        }
                        DownloadBean downloadBean4 = concurrentHashMap6.get(resourceId3);
                        Intrinsics.d(downloadBean4);
                        downloadBean = downloadBean4;
                        arrayList.add(downloadBean);
                    } else {
                        if (downloadBean.isShotTV()) {
                            downloadEsHelper2.f60999d.put(downloadBean.getSubjectId() + downloadBean.getEp(), downloadBean);
                        }
                        ConcurrentHashMap<String, DownloadBean> concurrentHashMap7 = downloadEsHelper2.f60996a;
                        resourceId2 = downloadBean.getResourceId();
                        if (resourceId2 == null) {
                            resourceId2 = downloadBean.getUrl();
                        }
                        concurrentHashMap7.put(resourceId2, downloadBean);
                        arrayList.add(downloadBean);
                    }
                    downloadEsHelper$getSeriesCompleted$1.L$0 = downloadEsHelper2;
                    downloadEsHelper$getSeriesCompleted$1.L$1 = arrayList;
                    downloadEsHelper$getSeriesCompleted$1.L$2 = it;
                    downloadEsHelper$getSeriesCompleted$1.label = 2;
                    if (downloadEsHelper2.f(downloadBean, downloadEsHelper$getSeriesCompleted$1) == objE) {
                        return objE;
                    }
                }
            }
            return arrayList;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return new ArrayList();
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object E(String str, int i11, int i12, Continuation<? super DownloadBean> continuation) throws Throwable {
        DownloadEsHelper$getSubjectDownloadBean$1 downloadEsHelper$getSubjectDownloadBean$1;
        DownloadEsHelper downloadEsHelper;
        if (continuation instanceof DownloadEsHelper$getSubjectDownloadBean$1) {
            downloadEsHelper$getSubjectDownloadBean$1 = (DownloadEsHelper$getSubjectDownloadBean$1) continuation;
            int i13 = downloadEsHelper$getSubjectDownloadBean$1.label;
            if ((i13 & Integer.MIN_VALUE) != 0) {
                downloadEsHelper$getSubjectDownloadBean$1.label = i13 - Integer.MIN_VALUE;
            } else {
                downloadEsHelper$getSubjectDownloadBean$1 = new DownloadEsHelper$getSubjectDownloadBean$1(this, continuation);
            }
        } else {
            downloadEsHelper$getSubjectDownloadBean$1 = new DownloadEsHelper$getSubjectDownloadBean$1(this, continuation);
        }
        Object objA = downloadEsHelper$getSubjectDownloadBean$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i14 = downloadEsHelper$getSubjectDownloadBean$1.label;
        try {
            if (i14 == 0) {
                ResultKt.b(objA);
                tr.c cVarM = m();
                if (cVarM != null) {
                    downloadEsHelper$getSubjectDownloadBean$1.L$0 = this;
                    downloadEsHelper$getSubjectDownloadBean$1.label = 1;
                    objA = cVarM.A(str, i11, i12, downloadEsHelper$getSubjectDownloadBean$1);
                    if (objA == objE) {
                        return objE;
                    }
                    downloadEsHelper = this;
                }
                return null;
            }
            if (i14 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            downloadEsHelper = (DownloadEsHelper) downloadEsHelper$getSubjectDownloadBean$1.L$0;
            ResultKt.b(objA);
            DownloadBean downloadBean = (DownloadBean) objA;
            if (downloadBean == null) {
                return null;
            }
            ConcurrentHashMap<String, DownloadBean> concurrentHashMap = downloadEsHelper.f60996a;
            String resourceId = downloadBean.getResourceId();
            if (resourceId == null) {
                resourceId = downloadBean.getUrl();
            }
            if (concurrentHashMap.containsKey(resourceId)) {
                ConcurrentHashMap<String, DownloadBean> concurrentHashMap2 = downloadEsHelper.f60996a;
                String resourceId2 = downloadBean.getResourceId();
                if (resourceId2 == null) {
                    resourceId2 = downloadBean.getUrl();
                }
                return concurrentHashMap2.get(resourceId2);
            }
            ConcurrentHashMap<String, DownloadBean> concurrentHashMap3 = downloadEsHelper.f60996a;
            String resourceId3 = downloadBean.getResourceId();
            if (resourceId3 == null) {
                resourceId3 = downloadBean.getUrl();
            }
            concurrentHashMap3.put(resourceId3, downloadBean);
            return downloadBean;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    public final DownloadBean F(String subjectId, int i11, int i12) {
        Intrinsics.g(subjectId, "subjectId");
        return this.f61000e.get(subjectId + i11 + i12);
    }

    public final m G() {
        return (m) this.f61005j.getValue();
    }

    /* JADX WARN: Code duplicated, block: B:38:0x0079 A[Catch: all -> 0x0031, TryCatch #0 {all -> 0x0031, blocks: (B:13:0x002c, B:69:0x0112, B:72:0x0117, B:73:0x0122, B:75:0x0128, B:20:0x0048, B:39:0x0082, B:41:0x0088, B:43:0x0096, B:44:0x009a, B:46:0x00a0, B:48:0x00a8, B:49:0x00ac, B:60:0x00f6, B:50:0x00b9, B:52:0x00bf, B:53:0x00db, B:55:0x00e1, B:56:0x00e4, B:58:0x00ec, B:59:0x00f0, B:23:0x0050, B:34:0x006d, B:36:0x0072, B:38:0x0079, B:26:0x0057, B:28:0x005b, B:30:0x0061, B:66:0x0109), top: B:81:0x0024 }] */
    /* JADX WARN: Code duplicated, block: B:71:0x0116  */
    /* JADX WARN: Code duplicated, block: B:72:0x0117 A[Catch: all -> 0x0031, TryCatch #0 {all -> 0x0031, blocks: (B:13:0x002c, B:69:0x0112, B:72:0x0117, B:73:0x0122, B:75:0x0128, B:20:0x0048, B:39:0x0082, B:41:0x0088, B:43:0x0096, B:44:0x009a, B:46:0x00a0, B:48:0x00a8, B:49:0x00ac, B:60:0x00f6, B:50:0x00b9, B:52:0x00bf, B:53:0x00db, B:55:0x00e1, B:56:0x00e4, B:58:0x00ec, B:59:0x00f0, B:23:0x0050, B:34:0x006d, B:36:0x0072, B:38:0x0079, B:26:0x0057, B:28:0x005b, B:30:0x0061, B:66:0x0109), top: B:81:0x0024 }] */
    /* JADX WARN: Code duplicated, block: B:75:0x0128 A[Catch: all -> 0x0031, LOOP:0: B:73:0x0122->B:75:0x0128, LOOP_END, TRY_LEAVE, TryCatch #0 {all -> 0x0031, blocks: (B:13:0x002c, B:69:0x0112, B:72:0x0117, B:73:0x0122, B:75:0x0128, B:20:0x0048, B:39:0x0082, B:41:0x0088, B:43:0x0096, B:44:0x009a, B:46:0x00a0, B:48:0x00a8, B:49:0x00ac, B:60:0x00f6, B:50:0x00b9, B:52:0x00bf, B:53:0x00db, B:55:0x00e1, B:56:0x00e4, B:58:0x00ec, B:59:0x00f0, B:23:0x0050, B:34:0x006d, B:36:0x0072, B:38:0x0079, B:26:0x0057, B:28:0x005b, B:30:0x0061, B:66:0x0109), top: B:81:0x0024 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code duplicated, block: B:87:? A[RETURN, SYNTHETIC] */
    public final Object H(Continuation<? super List<? extends DownloadBean>> continuation) throws Throwable {
        DownloadEsHelper$getTotalList$1 downloadEsHelper$getTotalList$1;
        DownloadEsHelper downloadEsHelper;
        ArrayList arrayList;
        DownloadEsHelper downloadEsHelper2;
        Iterator it;
        List list;
        List list2;
        ArrayList arrayList2;
        Iterator it2;
        if (continuation instanceof DownloadEsHelper$getTotalList$1) {
            downloadEsHelper$getTotalList$1 = (DownloadEsHelper$getTotalList$1) continuation;
            int i11 = downloadEsHelper$getTotalList$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                downloadEsHelper$getTotalList$1.label = i11 - Integer.MIN_VALUE;
            } else {
                downloadEsHelper$getTotalList$1 = new DownloadEsHelper$getTotalList$1(this, continuation);
            }
        } else {
            downloadEsHelper$getTotalList$1 = new DownloadEsHelper$getTotalList$1(this, continuation);
        }
        Object objD = downloadEsHelper$getTotalList$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = downloadEsHelper$getTotalList$1.label;
        List list3 = null;
        try {
            if (i12 == 0) {
                ResultKt.b(objD);
                tr.e eVar = this.f61007l;
                if (eVar != null) {
                    if (eVar != null) {
                        downloadEsHelper$getTotalList$1.label = 3;
                        objD = eVar.d(downloadEsHelper$getTotalList$1);
                        if (objD == objE) {
                            return objE;
                        }
                        list2 = (List) objD;
                        if (list2 != null) {
                            arrayList2 = new ArrayList();
                            it2 = list2.iterator();
                            while (it2.hasNext()) {
                                arrayList2.add(DownloadEsBean.Companion.b((DownloadEsBean) it2.next()));
                            }
                            return arrayList2;
                        }
                    }
                    return null;
                }
                tr.c cVarM = m();
                if (cVarM != null) {
                    downloadEsHelper$getTotalList$1.L$0 = this;
                    downloadEsHelper$getTotalList$1.label = 1;
                    objD = cVarM.d(downloadEsHelper$getTotalList$1);
                    if (objD == objE) {
                        return objE;
                    }
                    downloadEsHelper = this;
                    list3 = (List) objD;
                } else {
                    downloadEsHelper = this;
                }
                arrayList = new ArrayList();
                if (list3 != null) {
                    return arrayList;
                }
                downloadEsHelper2 = downloadEsHelper;
                it = list3.iterator();
                list = arrayList;
            } else if (i12 == 1) {
                downloadEsHelper = (DownloadEsHelper) downloadEsHelper$getTotalList$1.L$0;
                ResultKt.b(objD);
                list3 = (List) objD;
                arrayList = new ArrayList();
                if (list3 != null) {
                    return arrayList;
                }
                downloadEsHelper2 = downloadEsHelper;
                it = list3.iterator();
                list = arrayList;
            } else {
                if (i12 != 2) {
                    if (i12 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(objD);
                    list2 = (List) objD;
                    if (list2 != null) {
                        return null;
                    }
                    arrayList2 = new ArrayList();
                    it2 = list2.iterator();
                    while (it2.hasNext()) {
                        arrayList2.add(DownloadEsBean.Companion.b((DownloadEsBean) it2.next()));
                    }
                    return arrayList2;
                }
                it = (Iterator) downloadEsHelper$getTotalList$1.L$2;
                list = (List) downloadEsHelper$getTotalList$1.L$1;
                downloadEsHelper2 = (DownloadEsHelper) downloadEsHelper$getTotalList$1.L$0;
                ResultKt.b(objD);
            }
            while (it.hasNext()) {
                DownloadBean downloadBean = (DownloadBean) it.next();
                ConcurrentHashMap<String, DownloadBean> concurrentHashMap = downloadEsHelper2.f60996a;
                String resourceId = downloadBean.getResourceId();
                if (resourceId == null) {
                    resourceId = downloadBean.getUrl();
                }
                if (concurrentHashMap.containsKey(resourceId)) {
                    ConcurrentHashMap<String, DownloadBean> concurrentHashMap2 = downloadEsHelper2.f60996a;
                    String resourceId2 = downloadBean.getResourceId();
                    if (resourceId2 == null) {
                        resourceId2 = downloadBean.getUrl();
                    }
                    DownloadBean downloadBean2 = concurrentHashMap2.get(resourceId2);
                    Intrinsics.d(downloadBean2);
                    downloadBean = downloadBean2;
                    list.add(downloadBean);
                } else {
                    if (downloadBean.isShotTV()) {
                        downloadEsHelper2.f60999d.put(downloadBean.getSubjectId() + downloadBean.getEp(), downloadBean);
                    }
                    String subjectId = downloadBean.getSubjectId();
                    if (subjectId != null) {
                        downloadEsHelper2.L(subjectId, downloadBean);
                    }
                    ConcurrentHashMap<String, DownloadBean> concurrentHashMap3 = downloadEsHelper2.f60996a;
                    String resourceId3 = downloadBean.getResourceId();
                    if (resourceId3 == null) {
                        resourceId3 = downloadBean.getUrl();
                    }
                    concurrentHashMap3.put(resourceId3, downloadBean);
                    list.add(downloadBean);
                }
                downloadEsHelper$getTotalList$1.L$0 = downloadEsHelper2;
                downloadEsHelper$getTotalList$1.L$1 = list;
                downloadEsHelper$getTotalList$1.L$2 = it;
                downloadEsHelper$getTotalList$1.label = 2;
                if (downloadEsHelper2.f(downloadBean, downloadEsHelper$getTotalList$1) == objE) {
                    return objE;
                }
            }
            return list;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return new ArrayList();
        }
    }

    /* JADX WARN: Code duplicated, block: B:30:0x006d A[Catch: all -> 0x0034, TryCatch #0 {all -> 0x0034, blocks: (B:12:0x0030, B:25:0x0062, B:30:0x006d, B:31:0x0073, B:33:0x0079, B:35:0x0087, B:36:0x008b, B:39:0x0093, B:41:0x009b, B:42:0x009f, B:44:0x00a7, B:45:0x00b4, B:47:0x00bc, B:48:0x00c0, B:49:0x00c7, B:50:0x00c9), top: B:54:0x0030 }] */
    /* JADX WARN: Code duplicated, block: B:33:0x0079 A[Catch: all -> 0x0034, TryCatch #0 {all -> 0x0034, blocks: (B:12:0x0030, B:25:0x0062, B:30:0x006d, B:31:0x0073, B:33:0x0079, B:35:0x0087, B:36:0x008b, B:39:0x0093, B:41:0x009b, B:42:0x009f, B:44:0x00a7, B:45:0x00b4, B:47:0x00bc, B:48:0x00c0, B:49:0x00c7, B:50:0x00c9), top: B:54:0x0030 }] */
    /* JADX WARN: Code duplicated, block: B:35:0x0087 A[Catch: all -> 0x0034, TryCatch #0 {all -> 0x0034, blocks: (B:12:0x0030, B:25:0x0062, B:30:0x006d, B:31:0x0073, B:33:0x0079, B:35:0x0087, B:36:0x008b, B:39:0x0093, B:41:0x009b, B:42:0x009f, B:44:0x00a7, B:45:0x00b4, B:47:0x00bc, B:48:0x00c0, B:49:0x00c7, B:50:0x00c9), top: B:54:0x0030 }] */
    /* JADX WARN: Code duplicated, block: B:47:0x00bc A[Catch: all -> 0x0034, TryCatch #0 {all -> 0x0034, blocks: (B:12:0x0030, B:25:0x0062, B:30:0x006d, B:31:0x0073, B:33:0x0079, B:35:0x0087, B:36:0x008b, B:39:0x0093, B:41:0x009b, B:42:0x009f, B:44:0x00a7, B:45:0x00b4, B:47:0x00bc, B:48:0x00c0, B:49:0x00c7, B:50:0x00c9), top: B:54:0x0030 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object I(boolean z11, Continuation<? super List<? extends DownloadBean>> continuation) throws Throwable {
        DownloadEsHelper$getTransferReceivedList$1 downloadEsHelper$getTransferReceivedList$1;
        List list;
        DownloadEsHelper downloadEsHelper;
        List<DownloadBean> list2;
        ConcurrentHashMap<String, DownloadBean> concurrentHashMap;
        String resourceId;
        String resourceId2;
        if (continuation instanceof DownloadEsHelper$getTransferReceivedList$1) {
            downloadEsHelper$getTransferReceivedList$1 = (DownloadEsHelper$getTransferReceivedList$1) continuation;
            int i11 = downloadEsHelper$getTransferReceivedList$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                downloadEsHelper$getTransferReceivedList$1.label = i11 - Integer.MIN_VALUE;
            } else {
                downloadEsHelper$getTransferReceivedList$1 = new DownloadEsHelper$getTransferReceivedList$1(this, continuation);
            }
        } else {
            downloadEsHelper$getTransferReceivedList$1 = new DownloadEsHelper$getTransferReceivedList$1(this, continuation);
        }
        Object obj = downloadEsHelper$getTransferReceivedList$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = downloadEsHelper$getTransferReceivedList$1.label;
        Unit unit = null;
        if (i12 == 0) {
            ResultKt.b(obj);
            ArrayList arrayList = new ArrayList();
            try {
                Result.Companion companion = Result.Companion;
                tr.c cVarM = m();
                if (cVarM != null) {
                    downloadEsHelper$getTransferReceivedList$1.L$0 = arrayList;
                    downloadEsHelper$getTransferReceivedList$1.L$1 = this;
                    downloadEsHelper$getTransferReceivedList$1.Z$0 = z11;
                    downloadEsHelper$getTransferReceivedList$1.label = 1;
                    Object objO = cVarM.o(downloadEsHelper$getTransferReceivedList$1);
                    if (objO == objE) {
                        return objE;
                    }
                    downloadEsHelper = this;
                    list = arrayList;
                    obj = objO;
                } else {
                    downloadEsHelper = this;
                    list = arrayList;
                    list2 = null;
                }
                if (list2 != null) {
                    for (DownloadBean downloadBean : list2) {
                        concurrentHashMap = downloadEsHelper.f60996a;
                        resourceId = downloadBean.getResourceId();
                        if (resourceId == null) {
                            resourceId = downloadBean.getUrl();
                        }
                        if (concurrentHashMap.containsKey(resourceId) || z11) {
                            ConcurrentHashMap<String, DownloadBean> concurrentHashMap2 = downloadEsHelper.f60996a;
                            resourceId2 = downloadBean.getResourceId();
                            if (resourceId2 == null) {
                                resourceId2 = downloadBean.getUrl();
                            }
                            concurrentHashMap2.put(resourceId2, downloadBean);
                            list.add(downloadBean);
                        } else {
                            ConcurrentHashMap<String, DownloadBean> concurrentHashMap3 = downloadEsHelper.f60996a;
                            String resourceId3 = downloadBean.getResourceId();
                            if (resourceId3 == null) {
                                resourceId3 = downloadBean.getUrl();
                            }
                            DownloadBean downloadBean2 = concurrentHashMap3.get(resourceId3);
                            if (downloadBean2 != null) {
                                Intrinsics.f(downloadBean2, "downloadBean");
                                Boxing.a(list.add(downloadBean2));
                            }
                        }
                    }
                    unit = Unit.f68710a;
                }
                Result.m163constructorimpl(unit);
            } catch (Throwable th2) {
                th = th2;
                list = arrayList;
                Result.Companion companion2 = Result.Companion;
                Result.m163constructorimpl(ResultKt.a(th));
            }
            return list;
        }
        if (i12 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        z11 = downloadEsHelper$getTransferReceivedList$1.Z$0;
        downloadEsHelper = (DownloadEsHelper) downloadEsHelper$getTransferReceivedList$1.L$1;
        list = (List) downloadEsHelper$getTransferReceivedList$1.L$0;
        try {
            ResultKt.b(obj);
        } catch (Throwable th3) {
            th = th3;
            Result.Companion companion3 = Result.Companion;
            Result.m163constructorimpl(ResultKt.a(th));
        }
        list2 = (List) obj;
        if (list2 != null) {
            while (r8.hasNext()) {
                concurrentHashMap = downloadEsHelper.f60996a;
                resourceId = downloadBean.getResourceId();
                if (resourceId == null) {
                    resourceId = downloadBean.getUrl();
                }
                if (concurrentHashMap.containsKey(resourceId)) {
                }
                ConcurrentHashMap<String, DownloadBean> concurrentHashMap4 = downloadEsHelper.f60996a;
                resourceId2 = downloadBean.getResourceId();
                if (resourceId2 == null) {
                    resourceId2 = downloadBean.getUrl();
                }
                concurrentHashMap4.put(resourceId2, downloadBean);
                list.add(downloadBean);
            }
            unit = Unit.f68710a;
        }
        Result.m163constructorimpl(unit);
        return list;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object K(DownloadBean downloadBean, Continuation<? super Unit> continuation) throws Throwable {
        DownloadEsHelper$insert$1 downloadEsHelper$insert$1;
        if (continuation instanceof DownloadEsHelper$insert$1) {
            downloadEsHelper$insert$1 = (DownloadEsHelper$insert$1) continuation;
            int i11 = downloadEsHelper$insert$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                downloadEsHelper$insert$1.label = i11 - Integer.MIN_VALUE;
            } else {
                downloadEsHelper$insert$1 = new DownloadEsHelper$insert$1(this, continuation);
            }
        } else {
            downloadEsHelper$insert$1 = new DownloadEsHelper$insert$1(this, continuation);
        }
        Object obj = downloadEsHelper$insert$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = downloadEsHelper$insert$1.label;
        try {
            if (i12 != 0) {
                if (i12 == 1) {
                    ResultKt.b(obj);
                    return Unit.f68710a;
                }
                if (i12 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                return Unit.f68710a;
            }
            ResultKt.b(obj);
            if (downloadBean.getStatus() == 7) {
                return Unit.f68710a;
            }
            tr.e eVar = this.f61007l;
            if (eVar != null) {
                if (eVar != null) {
                    DownloadEsBean downloadEsBeanA = DownloadEsBean.Companion.a(downloadBean);
                    downloadEsHelper$insert$1.label = 2;
                    if (eVar.c(downloadEsBeanA, downloadEsHelper$insert$1) == objE) {
                        return objE;
                    }
                }
                return Unit.f68710a;
            }
            if (downloadBean.isShotTV()) {
                this.f60999d.put(downloadBean.getSubjectId() + downloadBean.getEp(), downloadBean);
            }
            ConcurrentHashMap<String, DownloadBean> concurrentHashMap = this.f60996a;
            String resourceId = downloadBean.getResourceId();
            if (resourceId == null) {
                resourceId = downloadBean.getUrl();
            }
            concurrentHashMap.put(resourceId, downloadBean);
            tr.c cVarM = m();
            if (cVarM != null) {
                downloadEsHelper$insert$1.label = 1;
                if (cVarM.t(downloadBean, downloadEsHelper$insert$1) == objE) {
                    return objE;
                }
            }
            return Unit.f68710a;
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public final void L(String str, DownloadBean downloadBean) {
        DownloadBean downloadBean2 = this.f61000e.get(str);
        if ((downloadBean2 != null ? downloadBean2.getResolution() : 0) < downloadBean.getResolution()) {
            this.f61000e.put(str + downloadBean.getSe() + (downloadBean2 != null ? Integer.valueOf(downloadBean2.getEp()) : null), downloadBean);
        }
    }

    public final void M(String str) {
        Intrinsics.g(str, "<set-?>");
        this.f61001f = str;
    }

    public final void N(String str) {
        Intrinsics.g(str, "<set-?>");
        this.f61002g = str;
    }

    public final void O(int i11) {
        this.f61003h = i11;
    }

    /* JADX WARN: Code duplicated, block: B:37:0x0084 A[Catch: all -> 0x0030, TryCatch #0 {all -> 0x0030, blocks: (B:13:0x002b, B:19:0x003b, B:49:0x00b8, B:22:0x004c, B:35:0x007e, B:37:0x0084, B:39:0x0090, B:44:0x00a2, B:46:0x00a8, B:25:0x0053, B:27:0x005a, B:29:0x005d, B:31:0x0061, B:33:0x0069, B:34:0x006d, B:52:0x00bd), top: B:58:0x0023 }] */
    /* JADX WARN: Code duplicated, block: B:41:0x009e A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:42:0x009f  */
    /* JADX WARN: Code duplicated, block: B:46:0x00a8 A[Catch: all -> 0x0030, TryCatch #0 {all -> 0x0030, blocks: (B:13:0x002b, B:19:0x003b, B:49:0x00b8, B:22:0x004c, B:35:0x007e, B:37:0x0084, B:39:0x0090, B:44:0x00a2, B:46:0x00a8, B:25:0x0053, B:27:0x005a, B:29:0x005d, B:31:0x0061, B:33:0x0069, B:34:0x006d, B:52:0x00bd), top: B:58:0x0023 }] */
    /* JADX WARN: Code duplicated, block: B:48:0x00b7 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:59:0x00a2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x009f -> B:43:0x00a0). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object P(com.transsion.baselib.db.download.DownloadBean r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 210
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.manager.DownloadEsHelper.P(com.transsion.baselib.db.download.DownloadBean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object Q(String str, long j11, Continuation<? super Unit> continuation) throws Throwable {
        DownloadEsHelper$updateDuration$1 downloadEsHelper$updateDuration$1;
        if (continuation instanceof DownloadEsHelper$updateDuration$1) {
            downloadEsHelper$updateDuration$1 = (DownloadEsHelper$updateDuration$1) continuation;
            int i11 = downloadEsHelper$updateDuration$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                downloadEsHelper$updateDuration$1.label = i11 - Integer.MIN_VALUE;
            } else {
                downloadEsHelper$updateDuration$1 = new DownloadEsHelper$updateDuration$1(this, continuation);
            }
        } else {
            downloadEsHelper$updateDuration$1 = new DownloadEsHelper$updateDuration$1(this, continuation);
        }
        Object obj = downloadEsHelper$updateDuration$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = downloadEsHelper$updateDuration$1.label;
        try {
            if (i12 != 0) {
                if (i12 == 1) {
                    ResultKt.b(obj);
                    return Unit.f68710a;
                }
                if (i12 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                return Unit.f68710a;
            }
            ResultKt.b(obj);
            tr.e eVar = this.f61007l;
            if (eVar != null) {
                if (eVar != null) {
                    downloadEsHelper$updateDuration$1.label = 2;
                    if (eVar.j(str, j11, downloadEsHelper$updateDuration$1) == objE) {
                        return objE;
                    }
                }
                return Unit.f68710a;
            }
            DownloadBean downloadBean = this.f60996a.get(str);
            if (downloadBean != null) {
                downloadBean.setDuration(Boxing.e(j11));
            }
            tr.c cVarM = m();
            if (cVarM != null) {
                downloadEsHelper$updateDuration$1.label = 1;
                if (cVarM.j(str, j11, downloadEsHelper$updateDuration$1) == objE) {
                    return objE;
                }
            }
            return Unit.f68710a;
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    /* JADX WARN: Code duplicated, block: B:36:0x0083 A[Catch: all -> 0x0035, TryCatch #0 {all -> 0x0035, blocks: (B:13:0x0030, B:66:0x011a, B:20:0x004a, B:61:0x0106, B:63:0x010c, B:23:0x0055, B:32:0x0076, B:34:0x007d, B:36:0x0083, B:38:0x0091, B:39:0x0097, B:42:0x00a1, B:44:0x00aa, B:46:0x00b0, B:52:0x00e2, B:54:0x00e8, B:56:0x00ee, B:50:0x00dd, B:26:0x005c, B:28:0x0062), top: B:70:0x0028 }] */
    /* JADX WARN: Code duplicated, block: B:38:0x0091 A[Catch: all -> 0x0035, TryCatch #0 {all -> 0x0035, blocks: (B:13:0x0030, B:66:0x011a, B:20:0x004a, B:61:0x0106, B:63:0x010c, B:23:0x0055, B:32:0x0076, B:34:0x007d, B:36:0x0083, B:38:0x0091, B:39:0x0097, B:42:0x00a1, B:44:0x00aa, B:46:0x00b0, B:52:0x00e2, B:54:0x00e8, B:56:0x00ee, B:50:0x00dd, B:26:0x005c, B:28:0x0062), top: B:70:0x0028 }] */
    /* JADX WARN: Code duplicated, block: B:41:0x009f  */
    /* JADX WARN: Code duplicated, block: B:44:0x00aa A[Catch: all -> 0x0035, TryCatch #0 {all -> 0x0035, blocks: (B:13:0x0030, B:66:0x011a, B:20:0x004a, B:61:0x0106, B:63:0x010c, B:23:0x0055, B:32:0x0076, B:34:0x007d, B:36:0x0083, B:38:0x0091, B:39:0x0097, B:42:0x00a1, B:44:0x00aa, B:46:0x00b0, B:52:0x00e2, B:54:0x00e8, B:56:0x00ee, B:50:0x00dd, B:26:0x005c, B:28:0x0062), top: B:70:0x0028 }] */
    /* JADX WARN: Code duplicated, block: B:45:0x00af  */
    /* JADX WARN: Code duplicated, block: B:47:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:49:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:50:0x00dd A[Catch: all -> 0x0035, TryCatch #0 {all -> 0x0035, blocks: (B:13:0x0030, B:66:0x011a, B:20:0x004a, B:61:0x0106, B:63:0x010c, B:23:0x0055, B:32:0x0076, B:34:0x007d, B:36:0x0083, B:38:0x0091, B:39:0x0097, B:42:0x00a1, B:44:0x00aa, B:46:0x00b0, B:52:0x00e2, B:54:0x00e8, B:56:0x00ee, B:50:0x00dd, B:26:0x005c, B:28:0x0062), top: B:70:0x0028 }] */
    /* JADX WARN: Code duplicated, block: B:56:0x00ee A[Catch: all -> 0x0035, TryCatch #0 {all -> 0x0035, blocks: (B:13:0x0030, B:66:0x011a, B:20:0x004a, B:61:0x0106, B:63:0x010c, B:23:0x0055, B:32:0x0076, B:34:0x007d, B:36:0x0083, B:38:0x0091, B:39:0x0097, B:42:0x00a1, B:44:0x00aa, B:46:0x00b0, B:52:0x00e2, B:54:0x00e8, B:56:0x00ee, B:50:0x00dd, B:26:0x005c, B:28:0x0062), top: B:70:0x0028 }] */
    /* JADX WARN: Code duplicated, block: B:58:0x00ff A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:59:0x0100  */
    /* JADX WARN: Code duplicated, block: B:61:0x0106 A[Catch: all -> 0x0035, PHI: r0 r4 r9
  0x0106: PHI (r0v11 java.lang.String) = (r0v8 java.lang.String), (r0v13 java.lang.String) binds: [B:55:0x00ec, B:60:0x0103] A[DONT_GENERATE, DONT_INLINE]
  0x0106: PHI (r4v7 com.transsnet.downloader.manager.DownloadEsHelper) = (r4v4 com.transsnet.downloader.manager.DownloadEsHelper), (r4v10 com.transsnet.downloader.manager.DownloadEsHelper) binds: [B:55:0x00ec, B:60:0x0103] A[DONT_GENERATE, DONT_INLINE]
  0x0106: PHI (r9v5 long) = (r9v2 long), (r9v7 long) binds: [B:55:0x00ec, B:60:0x0103] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {all -> 0x0035, blocks: (B:13:0x0030, B:66:0x011a, B:20:0x004a, B:61:0x0106, B:63:0x010c, B:23:0x0055, B:32:0x0076, B:34:0x007d, B:36:0x0083, B:38:0x0091, B:39:0x0097, B:42:0x00a1, B:44:0x00aa, B:46:0x00b0, B:52:0x00e2, B:54:0x00e8, B:56:0x00ee, B:50:0x00dd, B:26:0x005c, B:28:0x0062), top: B:70:0x0028 }] */
    /* JADX WARN: Code duplicated, block: B:63:0x010c A[Catch: all -> 0x0035, TryCatch #0 {all -> 0x0035, blocks: (B:13:0x0030, B:66:0x011a, B:20:0x004a, B:61:0x0106, B:63:0x010c, B:23:0x0055, B:32:0x0076, B:34:0x007d, B:36:0x0083, B:38:0x0091, B:39:0x0097, B:42:0x00a1, B:44:0x00aa, B:46:0x00b0, B:52:0x00e2, B:54:0x00e8, B:56:0x00ee, B:50:0x00dd, B:26:0x005c, B:28:0x0062), top: B:70:0x0028 }] */
    /* JADX WARN: Code duplicated, block: B:65:0x0119 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    public final Object R(String str, int i11, long j11, Continuation<? super Unit> continuation) throws Throwable {
        DownloadEsHelper$updateReadProgress$3 downloadEsHelper$updateReadProgress$3;
        long j12;
        DownloadEsHelper downloadEsHelper;
        DownloadBean downloadBean;
        long jCurrentTimeMillis;
        String resourceId;
        tr.c cVarM;
        long j13;
        DownloadEsHelper downloadEsHelper2;
        String str2;
        DownloadBean downloadBean2;
        String resourceId2;
        Long duration;
        long jLongValue;
        tr.c cVarM2;
        if (continuation instanceof DownloadEsHelper$updateReadProgress$3) {
            downloadEsHelper$updateReadProgress$3 = (DownloadEsHelper$updateReadProgress$3) continuation;
            int i12 = downloadEsHelper$updateReadProgress$3.label;
            if ((i12 & Integer.MIN_VALUE) != 0) {
                downloadEsHelper$updateReadProgress$3.label = i12 - Integer.MIN_VALUE;
            } else {
                downloadEsHelper$updateReadProgress$3 = new DownloadEsHelper$updateReadProgress$3(this, continuation);
            }
        } else {
            downloadEsHelper$updateReadProgress$3 = new DownloadEsHelper$updateReadProgress$3(this, continuation);
        }
        Object objX = downloadEsHelper$updateReadProgress$3.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i13 = downloadEsHelper$updateReadProgress$3.label;
        try {
            if (i13 != 0) {
                if (i13 == 1) {
                    j12 = downloadEsHelper$updateReadProgress$3.J$0;
                    downloadEsHelper = (DownloadEsHelper) downloadEsHelper$updateReadProgress$3.L$0;
                    ResultKt.b(objX);
                } else if (i13 == 2) {
                    j13 = downloadEsHelper$updateReadProgress$3.J$0;
                    str2 = (String) downloadEsHelper$updateReadProgress$3.L$1;
                    downloadEsHelper2 = (DownloadEsHelper) downloadEsHelper$updateReadProgress$3.L$0;
                    ResultKt.b(objX);
                    resourceId = str2;
                    downloadEsHelper = downloadEsHelper2;
                    j12 = j13;
                    cVarM2 = downloadEsHelper.m();
                    if (cVarM2 != null) {
                        downloadEsHelper$updateReadProgress$3.L$0 = null;
                        downloadEsHelper$updateReadProgress$3.L$1 = null;
                        downloadEsHelper$updateReadProgress$3.label = 3;
                        if (cVarM2.s(resourceId, j12, downloadEsHelper$updateReadProgress$3) == objE) {
                            return objE;
                        }
                    }
                } else {
                    if (i13 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(objX);
                }
                return Unit.f68710a;
            }
            ResultKt.b(objX);
            tr.c cVarM3 = m();
            if (cVarM3 != null) {
                downloadEsHelper$updateReadProgress$3.L$0 = this;
                j12 = j11;
                downloadEsHelper$updateReadProgress$3.J$0 = j12;
                downloadEsHelper$updateReadProgress$3.label = 1;
                objX = cVarM3.x(str, i11, downloadEsHelper$updateReadProgress$3);
                if (objX == objE) {
                    return objE;
                }
                downloadEsHelper = this;
            } else {
                j12 = j11;
                downloadEsHelper = this;
                downloadBean = null;
            }
            jCurrentTimeMillis = System.currentTimeMillis();
            if (downloadBean == null) {
                downloadBean2 = downloadEsHelper.f60996a.get(downloadBean.getResourceId());
                if (downloadBean2 != null) {
                    downloadBean2.setReadProgress(j12);
                    downloadBean2.setLastPlayTimeStamp(jCurrentTimeMillis);
                }
                resourceId2 = downloadBean.getResourceId();
                if (resourceId2 == null) {
                    resourceId2 = "";
                }
                String str3 = resourceId2;
                duration = downloadBean.getDuration();
                if (duration != null) {
                    jLongValue = duration.longValue();
                } else {
                    jLongValue = 0;
                }
                LocalVideoEvent localVideoEvent = new LocalVideoEvent(str3, j12, jLongValue, true, false, 16, null);
                FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
                String name = LocalVideoEvent.class.getName();
                Intrinsics.f(name, "T::class.java.name");
                flowEventBus.postEvent(name, localVideoEvent, 0L);
            }
            if (downloadBean == null) {
                downloadBean.setReadProgress(j12);
            }
            if (downloadBean != null && (resourceId = downloadBean.getResourceId()) != null) {
                cVarM = downloadEsHelper.m();
                if (cVarM != null) {
                    downloadEsHelper$updateReadProgress$3.L$0 = downloadEsHelper;
                    downloadEsHelper$updateReadProgress$3.L$1 = resourceId;
                    downloadEsHelper$updateReadProgress$3.J$0 = j12;
                    downloadEsHelper$updateReadProgress$3.label = 2;
                    if (cVarM.u(resourceId, jCurrentTimeMillis, downloadEsHelper$updateReadProgress$3) == objE) {
                        return objE;
                    }
                    j13 = j12;
                    downloadEsHelper2 = downloadEsHelper;
                    str2 = resourceId;
                    resourceId = str2;
                    downloadEsHelper = downloadEsHelper2;
                    j12 = j13;
                    cVarM2 = downloadEsHelper.m();
                    if (cVarM2 != null) {
                        downloadEsHelper$updateReadProgress$3.L$0 = null;
                        downloadEsHelper$updateReadProgress$3.L$1 = null;
                        downloadEsHelper$updateReadProgress$3.label = 3;
                        if (cVarM2.s(resourceId, j12, downloadEsHelper$updateReadProgress$3) == objE) {
                            return objE;
                        }
                    }
                } else {
                    cVarM2 = downloadEsHelper.m();
                    if (cVarM2 != null) {
                        downloadEsHelper$updateReadProgress$3.L$0 = null;
                        downloadEsHelper$updateReadProgress$3.L$1 = null;
                        downloadEsHelper$updateReadProgress$3.label = 3;
                        if (cVarM2.s(resourceId, j12, downloadEsHelper$updateReadProgress$3) == objE) {
                            return objE;
                        }
                    }
                }
            }
            return Unit.f68710a;
            downloadBean = (DownloadBean) objX;
            jCurrentTimeMillis = System.currentTimeMillis();
            if (downloadBean == null) {
                downloadBean2 = downloadEsHelper.f60996a.get(downloadBean.getResourceId());
                if (downloadBean2 != null) {
                    downloadBean2.setReadProgress(j12);
                    downloadBean2.setLastPlayTimeStamp(jCurrentTimeMillis);
                }
                resourceId2 = downloadBean.getResourceId();
                if (resourceId2 == null) {
                    resourceId2 = "";
                }
                String str4 = resourceId2;
                duration = downloadBean.getDuration();
                if (duration != null) {
                    jLongValue = duration.longValue();
                } else {
                    jLongValue = 0;
                }
                LocalVideoEvent localVideoEvent2 = new LocalVideoEvent(str4, j12, jLongValue, true, false, 16, null);
                FlowEventBus flowEventBus2 = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
                String name2 = LocalVideoEvent.class.getName();
                Intrinsics.f(name2, "T::class.java.name");
                flowEventBus2.postEvent(name2, localVideoEvent2, 0L);
            }
            if (downloadBean == null) {
                downloadBean.setReadProgress(j12);
            }
            if (downloadBean != null) {
                cVarM = downloadEsHelper.m();
                if (cVarM != null) {
                    downloadEsHelper$updateReadProgress$3.L$0 = downloadEsHelper;
                    downloadEsHelper$updateReadProgress$3.L$1 = resourceId;
                    downloadEsHelper$updateReadProgress$3.J$0 = j12;
                    downloadEsHelper$updateReadProgress$3.label = 2;
                    if (cVarM.u(resourceId, jCurrentTimeMillis, downloadEsHelper$updateReadProgress$3) == objE) {
                        return objE;
                    }
                    j13 = j12;
                    downloadEsHelper2 = downloadEsHelper;
                    str2 = resourceId;
                    resourceId = str2;
                    downloadEsHelper = downloadEsHelper2;
                    j12 = j13;
                    cVarM2 = downloadEsHelper.m();
                    if (cVarM2 != null) {
                        downloadEsHelper$updateReadProgress$3.L$0 = null;
                        downloadEsHelper$updateReadProgress$3.L$1 = null;
                        downloadEsHelper$updateReadProgress$3.label = 3;
                        if (cVarM2.s(resourceId, j12, downloadEsHelper$updateReadProgress$3) == objE) {
                            return objE;
                        }
                    }
                } else {
                    cVarM2 = downloadEsHelper.m();
                    if (cVarM2 != null) {
                        downloadEsHelper$updateReadProgress$3.L$0 = null;
                        downloadEsHelper$updateReadProgress$3.L$1 = null;
                        downloadEsHelper$updateReadProgress$3.label = 3;
                        if (cVarM2.s(resourceId, j12, downloadEsHelper$updateReadProgress$3) == objE) {
                            return objE;
                        }
                    }
                }
            }
            return Unit.f68710a;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return Unit.f68710a;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object S(String str, long j11, Continuation<? super Unit> continuation) throws Throwable {
        DownloadEsHelper$updateReadProgress$1 downloadEsHelper$updateReadProgress$1;
        if (continuation instanceof DownloadEsHelper$updateReadProgress$1) {
            downloadEsHelper$updateReadProgress$1 = (DownloadEsHelper$updateReadProgress$1) continuation;
            int i11 = downloadEsHelper$updateReadProgress$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                downloadEsHelper$updateReadProgress$1.label = i11 - Integer.MIN_VALUE;
            } else {
                downloadEsHelper$updateReadProgress$1 = new DownloadEsHelper$updateReadProgress$1(this, continuation);
            }
        } else {
            downloadEsHelper$updateReadProgress$1 = new DownloadEsHelper$updateReadProgress$1(this, continuation);
        }
        Object obj = downloadEsHelper$updateReadProgress$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = downloadEsHelper$updateReadProgress$1.label;
        try {
            if (i12 == 0) {
                ResultKt.b(obj);
                if (this.f61007l == null) {
                    DownloadBean downloadBean = this.f60996a.get(str);
                    if (downloadBean != null) {
                        downloadBean.setReadProgress(j11);
                    }
                    tr.c cVarM = m();
                    if (cVarM != null) {
                        downloadEsHelper$updateReadProgress$1.label = 1;
                        if (cVarM.s(str, j11, downloadEsHelper$updateReadProgress$1) == objE) {
                            return objE;
                        }
                    }
                }
                return Unit.f68710a;
            }
            if (i12 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return Unit.f68710a;
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object T(String str, int i11, Continuation<? super Unit> continuation) throws Throwable {
        DownloadEsHelper$updateStatus$1 downloadEsHelper$updateStatus$1;
        if (continuation instanceof DownloadEsHelper$updateStatus$1) {
            downloadEsHelper$updateStatus$1 = (DownloadEsHelper$updateStatus$1) continuation;
            int i12 = downloadEsHelper$updateStatus$1.label;
            if ((i12 & Integer.MIN_VALUE) != 0) {
                downloadEsHelper$updateStatus$1.label = i12 - Integer.MIN_VALUE;
            } else {
                downloadEsHelper$updateStatus$1 = new DownloadEsHelper$updateStatus$1(this, continuation);
            }
        } else {
            downloadEsHelper$updateStatus$1 = new DownloadEsHelper$updateStatus$1(this, continuation);
        }
        Object obj = downloadEsHelper$updateStatus$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i13 = downloadEsHelper$updateStatus$1.label;
        try {
            if (i13 != 0) {
                if (i13 == 1) {
                    ResultKt.b(obj);
                    return Unit.f68710a;
                }
                if (i13 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                return Unit.f68710a;
            }
            ResultKt.b(obj);
            tr.e eVar = this.f61007l;
            if (eVar != null) {
                if (eVar != null) {
                    downloadEsHelper$updateStatus$1.label = 2;
                    if (eVar.h(str, i11, downloadEsHelper$updateStatus$1) == objE) {
                        return objE;
                    }
                }
                return Unit.f68710a;
            }
            DownloadBean downloadBean = this.f60996a.get(str);
            if (downloadBean != null) {
                downloadBean.setStatus(i11);
            }
            tr.c cVarM = m();
            if (cVarM != null) {
                downloadEsHelper$updateStatus$1.label = 1;
                if (cVarM.h(str, i11, downloadEsHelper$updateStatus$1) == objE) {
                    return objE;
                }
            }
            return Unit.f68710a;
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    public final Object U(String str, Subject subject, Continuation<? super Unit> continuation) throws Throwable {
        DownloadEsHelper$updateSubjectIfo$1 downloadEsHelper$updateSubjectIfo$1;
        if (continuation instanceof DownloadEsHelper$updateSubjectIfo$1) {
            downloadEsHelper$updateSubjectIfo$1 = (DownloadEsHelper$updateSubjectIfo$1) continuation;
            int i11 = downloadEsHelper$updateSubjectIfo$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                downloadEsHelper$updateSubjectIfo$1.label = i11 - Integer.MIN_VALUE;
            } else {
                downloadEsHelper$updateSubjectIfo$1 = new DownloadEsHelper$updateSubjectIfo$1(this, continuation);
            }
        } else {
            downloadEsHelper$updateSubjectIfo$1 = new DownloadEsHelper$updateSubjectIfo$1(this, continuation);
        }
        DownloadEsHelper$updateSubjectIfo$1 downloadEsHelper$updateSubjectIfo$2 = downloadEsHelper$updateSubjectIfo$1;
        Object obj = downloadEsHelper$updateSubjectIfo$2.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = downloadEsHelper$updateSubjectIfo$2.label;
        try {
            if (i12 == 0) {
                ResultKt.b(obj);
                DownloadBean downloadBean = this.f60996a.get(str);
                if (downloadBean != null) {
                    downloadBean.setRestrictLevel(subject.getRestrictLevel());
                    downloadBean.setReleaseDate(subject.getReleaseDate());
                    downloadBean.setCountryName(subject.getCountryName());
                    downloadBean.setSeNum(subject.getSeNum());
                    downloadBean.setGenre(subject.getGenre());
                    downloadBean.setSubtitles(subject.getSubtitles());
                    downloadBean.setImdbRate(subject.getImdbRate());
                }
                tr.c cVarM = m();
                if (cVarM != null) {
                    String restrictLevel = subject.getRestrictLevel();
                    String releaseDate = subject.getReleaseDate();
                    String countryName = subject.getCountryName();
                    Integer seNum = subject.getSeNum();
                    String genre = subject.getGenre();
                    String subtitles = subject.getSubtitles();
                    String imdbRate = subject.getImdbRate();
                    downloadEsHelper$updateSubjectIfo$2.label = 1;
                    if (cVarM.D(str, restrictLevel, releaseDate, countryName, seNum, genre, subtitles, imdbRate, downloadEsHelper$updateSubjectIfo$2) == objE) {
                        return objE;
                    }
                }
            } else {
                if (i12 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return Unit.f68710a;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return Unit.f68710a;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object V(String str, String str2, Continuation<? super Unit> continuation) throws Throwable {
        DownloadEsHelper$updateSubtitleSelectId$1 downloadEsHelper$updateSubtitleSelectId$1;
        if (continuation instanceof DownloadEsHelper$updateSubtitleSelectId$1) {
            downloadEsHelper$updateSubtitleSelectId$1 = (DownloadEsHelper$updateSubtitleSelectId$1) continuation;
            int i11 = downloadEsHelper$updateSubtitleSelectId$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                downloadEsHelper$updateSubtitleSelectId$1.label = i11 - Integer.MIN_VALUE;
            } else {
                downloadEsHelper$updateSubtitleSelectId$1 = new DownloadEsHelper$updateSubtitleSelectId$1(this, continuation);
            }
        } else {
            downloadEsHelper$updateSubtitleSelectId$1 = new DownloadEsHelper$updateSubtitleSelectId$1(this, continuation);
        }
        Object obj = downloadEsHelper$updateSubtitleSelectId$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = downloadEsHelper$updateSubtitleSelectId$1.label;
        try {
            if (i12 == 0) {
                ResultKt.b(obj);
                if (this.f61007l == null) {
                    DownloadBean downloadBean = this.f60996a.get(str);
                    if (downloadBean != null) {
                        downloadBean.setSubtitleSelectId(str2);
                    }
                    tr.c cVarM = m();
                    if (cVarM != null) {
                        downloadEsHelper$updateSubtitleSelectId$1.label = 1;
                        if (cVarM.c(str, str2, downloadEsHelper$updateSubtitleSelectId$1) == objE) {
                            return objE;
                        }
                    }
                }
                return Unit.f68710a;
            }
            if (i12 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return Unit.f68710a;
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object W(String str, int i11, int i12, Continuation<? super Unit> continuation) throws Throwable {
        DownloadEsHelper$updateWH$1 downloadEsHelper$updateWH$1;
        if (continuation instanceof DownloadEsHelper$updateWH$1) {
            downloadEsHelper$updateWH$1 = (DownloadEsHelper$updateWH$1) continuation;
            int i13 = downloadEsHelper$updateWH$1.label;
            if ((i13 & Integer.MIN_VALUE) != 0) {
                downloadEsHelper$updateWH$1.label = i13 - Integer.MIN_VALUE;
            } else {
                downloadEsHelper$updateWH$1 = new DownloadEsHelper$updateWH$1(this, continuation);
            }
        } else {
            downloadEsHelper$updateWH$1 = new DownloadEsHelper$updateWH$1(this, continuation);
        }
        Object obj = downloadEsHelper$updateWH$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i14 = downloadEsHelper$updateWH$1.label;
        try {
            if (i14 == 0) {
                ResultKt.b(obj);
                if (this.f61007l == null) {
                    DownloadBean downloadBean = this.f60996a.get(str);
                    if (downloadBean != null) {
                        downloadBean.setVideoWidth(i11);
                        downloadBean.setVideoHeight(i12);
                    }
                    tr.c cVarM = m();
                    if (cVarM != null) {
                        downloadEsHelper$updateWH$1.label = 1;
                        if (cVarM.n(str, i11, i12, downloadEsHelper$updateWH$1) == objE) {
                            return objE;
                        }
                    }
                }
                return Unit.f68710a;
            }
            if (i14 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return Unit.f68710a;
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public final File c() {
        File file = new File(tr.b.f77264a.c(), "builtIn");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public final File d() {
        e();
        File file = new File(tr.b.f77264a.d());
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public final void e() {
        String strD = tr.b.f77264a.d();
        RoomAppMMKV roomAppMMKV = RoomAppMMKV.f51271a;
        String string = roomAppMMKV.a().getString("download_root_path", strD);
        String string2 = roomAppMMKV.a().getString("download_root_path_name", null);
        if (string2 == null) {
            string2 = Utils.a().getString(R$string.str_download_dialog_path_moviebox_folder);
        }
        Intrinsics.f(string2, "RoomAppMMKV.mmkv.getStri…log_path_moviebox_folder)");
        int i11 = roomAppMMKV.a().getInt("download_root_path_type", 1);
        if (!DownloadUtil.f61136a.w()) {
            String string3 = Utils.a().getString(R$string.str_download_dialog_path_moviebox_folder);
            Intrinsics.f(string3, "getApp().getString(R.str…log_path_moviebox_folder)");
            this.f61002g = string3;
            this.f61001f = strD;
            this.f61003h = 1;
            return;
        }
        this.f61002g = string2;
        this.f61003h = i11;
        if (string == null || string.length() == 0) {
            string = strD;
        }
        this.f61001f = string;
        try {
            File file = new File(this.f61001f);
            if (file.exists()) {
                return;
            }
            file.mkdirs();
        } catch (Throwable th2) {
            uo.b.f78622a.h("DownloadEsHelper", "path error, path = " + this.f61002g + ", error = " + th2, true);
            String string4 = Utils.a().getString(R$string.str_download_dialog_path_moviebox_folder);
            Intrinsics.f(string4, "getApp().getString(R.str…log_path_moviebox_folder)");
            this.f61002g = string4;
            this.f61001f = strD;
            this.f61003h = 1;
        }
    }

    /* JADX WARN: Code duplicated, block: B:43:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:53:0x010f  */
    /* JADX WARN: Code duplicated, block: B:55:0x0115  */
    /* JADX WARN: Code duplicated, block: B:59:0x0127 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:60:0x0128  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object f(DownloadBean downloadBean, Continuation<? super Unit> continuation) throws Throwable {
        DownloadEsHelper$checkSubtitle$1 downloadEsHelper$checkSubtitle$1;
        List<SubtitleBean> list;
        DownloadEsHelper downloadEsHelper;
        List list2;
        String postId;
        m mVarG;
        DownloadEsHelper downloadEsHelper2;
        if (continuation instanceof DownloadEsHelper$checkSubtitle$1) {
            downloadEsHelper$checkSubtitle$1 = (DownloadEsHelper$checkSubtitle$1) continuation;
            int i11 = downloadEsHelper$checkSubtitle$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                downloadEsHelper$checkSubtitle$1.label = i11 - Integer.MIN_VALUE;
            } else {
                downloadEsHelper$checkSubtitle$1 = new DownloadEsHelper$checkSubtitle$1(this, continuation);
            }
        } else {
            downloadEsHelper$checkSubtitle$1 = new DownloadEsHelper$checkSubtitle$1(this, continuation);
        }
        Object objD = downloadEsHelper$checkSubtitle$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = downloadEsHelper$checkSubtitle$1.label;
        if (i12 == 0) {
            ResultKt.b(objD);
            if (!downloadBean.getSubtitleList().isEmpty()) {
                return Unit.f68710a;
            }
            if (downloadBean.getSubjectId() != null) {
                if (!downloadBean.isSeries()) {
                    m mVarG2 = G();
                    if (mVarG2 != null) {
                        String subjectId = downloadBean.getSubjectId();
                        Intrinsics.d(subjectId);
                        downloadEsHelper$checkSubtitle$1.L$0 = this;
                        downloadEsHelper$checkSubtitle$1.L$1 = downloadBean;
                        downloadEsHelper$checkSubtitle$1.label = 2;
                        objD = mVarG2.d(subjectId, downloadEsHelper$checkSubtitle$1);
                        if (objD == objE) {
                            return objE;
                        }
                        downloadEsHelper = this;
                        list = (List) objD;
                    }
                    list2 = list;
                    if (list2 != null) {
                        postId = downloadBean.getPostId();
                        if (postId != null) {
                            downloadEsHelper$checkSubtitle$1.L$0 = downloadEsHelper;
                            downloadEsHelper$checkSubtitle$1.L$1 = downloadBean;
                            downloadEsHelper$checkSubtitle$1.label = 3;
                            objD = mVarG.f(postId, downloadEsHelper$checkSubtitle$1);
                            if (objD == objE) {
                                return objE;
                            }
                            downloadEsHelper2 = downloadEsHelper;
                        }
                    } else {
                        postId = downloadBean.getPostId();
                        if (postId != null) {
                            downloadEsHelper$checkSubtitle$1.L$0 = downloadEsHelper;
                            downloadEsHelper$checkSubtitle$1.L$1 = downloadBean;
                            downloadEsHelper$checkSubtitle$1.label = 3;
                            objD = mVarG.f(postId, downloadEsHelper$checkSubtitle$1);
                            if (objD == objE) {
                                return objE;
                            }
                            downloadEsHelper2 = downloadEsHelper;
                        }
                    }
                    return Unit.f68710a;
                }
                m mVarG3 = G();
                if (mVarG3 != null) {
                    String subjectId2 = downloadBean.getSubjectId();
                    Intrinsics.d(subjectId2);
                    int ep2 = downloadBean.getEp();
                    int se2 = downloadBean.getSe();
                    downloadEsHelper$checkSubtitle$1.L$0 = this;
                    downloadEsHelper$checkSubtitle$1.L$1 = downloadBean;
                    downloadEsHelper$checkSubtitle$1.label = 1;
                    objD = mVarG3.e(subjectId2, ep2, se2, downloadEsHelper$checkSubtitle$1);
                    if (objD == objE) {
                        return objE;
                    }
                    downloadEsHelper = this;
                    list = (List) objD;
                }
                list2 = list;
                if (list2 != null) {
                    postId = downloadBean.getPostId();
                    if (postId != null) {
                        downloadEsHelper$checkSubtitle$1.L$0 = downloadEsHelper;
                        downloadEsHelper$checkSubtitle$1.L$1 = downloadBean;
                        downloadEsHelper$checkSubtitle$1.label = 3;
                        objD = mVarG.f(postId, downloadEsHelper$checkSubtitle$1);
                        if (objD == objE) {
                            return objE;
                        }
                        downloadEsHelper2 = downloadEsHelper;
                    }
                } else {
                    postId = downloadBean.getPostId();
                    if (postId != null) {
                        downloadEsHelper$checkSubtitle$1.L$0 = downloadEsHelper;
                        downloadEsHelper$checkSubtitle$1.L$1 = downloadBean;
                        downloadEsHelper$checkSubtitle$1.label = 3;
                        objD = mVarG.f(postId, downloadEsHelper$checkSubtitle$1);
                        if (objD == objE) {
                            return objE;
                        }
                        downloadEsHelper2 = downloadEsHelper;
                    }
                }
                return Unit.f68710a;
            }
            list = null;
            downloadEsHelper = this;
            list2 = list;
            if (list2 != null) {
                postId = downloadBean.getPostId();
                if (postId != null) {
                    downloadEsHelper$checkSubtitle$1.L$0 = downloadEsHelper;
                    downloadEsHelper$checkSubtitle$1.L$1 = downloadBean;
                    downloadEsHelper$checkSubtitle$1.label = 3;
                    objD = mVarG.f(postId, downloadEsHelper$checkSubtitle$1);
                    if (objD == objE) {
                        return objE;
                    }
                    downloadEsHelper2 = downloadEsHelper;
                }
            } else {
                postId = downloadBean.getPostId();
                if (postId != null) {
                    downloadEsHelper$checkSubtitle$1.L$0 = downloadEsHelper;
                    downloadEsHelper$checkSubtitle$1.L$1 = downloadBean;
                    downloadEsHelper$checkSubtitle$1.label = 3;
                    objD = mVarG.f(postId, downloadEsHelper$checkSubtitle$1);
                    if (objD == objE) {
                        return objE;
                    }
                    downloadEsHelper2 = downloadEsHelper;
                }
            }
            return Unit.f68710a;
        }
        if (i12 == 1) {
            downloadBean = (DownloadBean) downloadEsHelper$checkSubtitle$1.L$1;
            downloadEsHelper = (DownloadEsHelper) downloadEsHelper$checkSubtitle$1.L$0;
            ResultKt.b(objD);
            list = (List) objD;
            list2 = list;
            if (list2 != null) {
                postId = downloadBean.getPostId();
                if (postId != null) {
                    downloadEsHelper$checkSubtitle$1.L$0 = downloadEsHelper;
                    downloadEsHelper$checkSubtitle$1.L$1 = downloadBean;
                    downloadEsHelper$checkSubtitle$1.label = 3;
                    objD = mVarG.f(postId, downloadEsHelper$checkSubtitle$1);
                    if (objD == objE) {
                        return objE;
                    }
                    downloadEsHelper2 = downloadEsHelper;
                }
            } else {
                postId = downloadBean.getPostId();
                if (postId != null) {
                    downloadEsHelper$checkSubtitle$1.L$0 = downloadEsHelper;
                    downloadEsHelper$checkSubtitle$1.L$1 = downloadBean;
                    downloadEsHelper$checkSubtitle$1.label = 3;
                    objD = mVarG.f(postId, downloadEsHelper$checkSubtitle$1);
                    if (objD == objE) {
                        return objE;
                    }
                    downloadEsHelper2 = downloadEsHelper;
                }
            }
            return Unit.f68710a;
        }
        if (i12 == 2) {
            downloadBean = (DownloadBean) downloadEsHelper$checkSubtitle$1.L$1;
            downloadEsHelper = (DownloadEsHelper) downloadEsHelper$checkSubtitle$1.L$0;
            ResultKt.b(objD);
            list = (List) objD;
            list2 = list;
            if (list2 != null || list2.isEmpty()) {
                postId = downloadBean.getPostId();
                if (postId != null && (mVarG = downloadEsHelper.G()) != null) {
                    downloadEsHelper$checkSubtitle$1.L$0 = downloadEsHelper;
                    downloadEsHelper$checkSubtitle$1.L$1 = downloadBean;
                    downloadEsHelper$checkSubtitle$1.label = 3;
                    objD = mVarG.f(postId, downloadEsHelper$checkSubtitle$1);
                    if (objD == objE) {
                        return objE;
                    }
                    downloadEsHelper2 = downloadEsHelper;
                }
            } else {
                for (SubtitleBean subtitleBean : list) {
                    if (downloadEsHelper.f60997b.contains(subtitleBean.getResourceId())) {
                        List<SubtitleBean> subtitleList = downloadBean.getSubtitleList();
                        SubtitleBean subtitleBean2 = downloadEsHelper.f60997b.get(subtitleBean.getResourceId());
                        Intrinsics.d(subtitleBean2);
                        subtitleList.add(subtitleBean2);
                    } else {
                        downloadEsHelper.f60997b.put(subtitleBean.getResourceId(), subtitleBean);
                        downloadBean.getSubtitleList().add(subtitleBean);
                    }
                }
            }
            return Unit.f68710a;
        }
        if (i12 != 3) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        downloadBean = (DownloadBean) downloadEsHelper$checkSubtitle$1.L$1;
        downloadEsHelper2 = (DownloadEsHelper) downloadEsHelper$checkSubtitle$1.L$0;
        ResultKt.b(objD);
        List<SubtitleBean> list3 = (List) objD;
        if (list3 != null) {
            for (SubtitleBean subtitleBean3 : list3) {
                if (downloadEsHelper2.f60997b.contains(subtitleBean3.getResourceId())) {
                    List<SubtitleBean> subtitleList2 = downloadBean.getSubtitleList();
                    SubtitleBean subtitleBean4 = downloadEsHelper2.f60997b.get(subtitleBean3.getResourceId());
                    Intrinsics.d(subtitleBean4);
                    subtitleList2.add(subtitleBean4);
                } else {
                    downloadEsHelper2.f60997b.put(subtitleBean3.getResourceId(), subtitleBean3);
                    downloadBean.getSubtitleList().add(subtitleBean3);
                }
            }
        }
        return Unit.f68710a;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object g(String str, String str2, Continuation<? super Unit> continuation) throws Throwable {
        DownloadEsHelper$deleteByUrl$1 downloadEsHelper$deleteByUrl$1;
        if (continuation instanceof DownloadEsHelper$deleteByUrl$1) {
            downloadEsHelper$deleteByUrl$1 = (DownloadEsHelper$deleteByUrl$1) continuation;
            int i11 = downloadEsHelper$deleteByUrl$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                downloadEsHelper$deleteByUrl$1.label = i11 - Integer.MIN_VALUE;
            } else {
                downloadEsHelper$deleteByUrl$1 = new DownloadEsHelper$deleteByUrl$1(this, continuation);
            }
        } else {
            downloadEsHelper$deleteByUrl$1 = new DownloadEsHelper$deleteByUrl$1(this, continuation);
        }
        Object obj = downloadEsHelper$deleteByUrl$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = downloadEsHelper$deleteByUrl$1.label;
        try {
            if (i12 == 0) {
                ResultKt.b(obj);
                if (this.f61007l == null) {
                    if (this.f60996a.containsKey(str2)) {
                        this.f60996a.remove(str2);
                    }
                    tr.c cVarM = m();
                    if (cVarM != null) {
                        downloadEsHelper$deleteByUrl$1.label = 1;
                        if (cVarM.q(str, downloadEsHelper$deleteByUrl$1) == objE) {
                            return objE;
                        }
                    }
                }
                return Unit.f68710a;
            }
            if (i12 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return Unit.f68710a;
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    /* JADX WARN: Code duplicated, block: B:39:0x0079 A[Catch: all -> 0x002f, TryCatch #0 {all -> 0x002f, blocks: (B:13:0x002b, B:19:0x0039, B:42:0x0087, B:22:0x0045, B:37:0x0073, B:39:0x0079, B:25:0x004c, B:27:0x0050, B:29:0x0058, B:31:0x005f, B:33:0x0065, B:45:0x008c), top: B:51:0x0023 }] */
    /* JADX WARN: Code duplicated, block: B:41:0x0086 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object h(String str, String str2, Continuation<? super Unit> continuation) throws Throwable {
        DownloadEsHelper$deleteItem$1 downloadEsHelper$deleteItem$1;
        DownloadEsHelper downloadEsHelper;
        m mVarG;
        tr.c cVarM;
        if (continuation instanceof DownloadEsHelper$deleteItem$1) {
            downloadEsHelper$deleteItem$1 = (DownloadEsHelper$deleteItem$1) continuation;
            int i11 = downloadEsHelper$deleteItem$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                downloadEsHelper$deleteItem$1.label = i11 - Integer.MIN_VALUE;
            } else {
                downloadEsHelper$deleteItem$1 = new DownloadEsHelper$deleteItem$1(this, continuation);
            }
        } else {
            downloadEsHelper$deleteItem$1 = new DownloadEsHelper$deleteItem$1(this, continuation);
        }
        Object obj = downloadEsHelper$deleteItem$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = downloadEsHelper$deleteItem$1.label;
        try {
            if (i12 == 0) {
                ResultKt.b(obj);
                tr.e eVar = this.f61007l;
                if (eVar != null) {
                    if (eVar != null) {
                        downloadEsHelper$deleteItem$1.label = 3;
                        if (eVar.a(str, downloadEsHelper$deleteItem$1) == objE) {
                            return objE;
                        }
                    }
                    return Unit.f68710a;
                }
                if (this.f60996a.containsKey(str)) {
                    this.f60996a.remove(str);
                }
                if (str2 != null && (mVarG = G()) != null) {
                    downloadEsHelper$deleteItem$1.L$0 = this;
                    downloadEsHelper$deleteItem$1.L$1 = str;
                    downloadEsHelper$deleteItem$1.label = 1;
                    if (mVarG.a(str2, downloadEsHelper$deleteItem$1) == objE) {
                        return objE;
                    }
                }
                downloadEsHelper = this;
                cVarM = downloadEsHelper.m();
                if (cVarM != null) {
                    downloadEsHelper$deleteItem$1.L$0 = null;
                    downloadEsHelper$deleteItem$1.L$1 = null;
                    downloadEsHelper$deleteItem$1.label = 2;
                    if (cVarM.a(str, downloadEsHelper$deleteItem$1) == objE) {
                        return objE;
                    }
                }
            } else if (i12 == 1) {
                str = (String) downloadEsHelper$deleteItem$1.L$1;
                downloadEsHelper = (DownloadEsHelper) downloadEsHelper$deleteItem$1.L$0;
                ResultKt.b(obj);
                cVarM = downloadEsHelper.m();
                if (cVarM != null) {
                    downloadEsHelper$deleteItem$1.L$0 = null;
                    downloadEsHelper$deleteItem$1.L$1 = null;
                    downloadEsHelper$deleteItem$1.label = 2;
                    if (cVarM.a(str, downloadEsHelper$deleteItem$1) == objE) {
                        return objE;
                    }
                }
            } else {
                if (i12 != 2) {
                    if (i12 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                    return Unit.f68710a;
                }
                ResultKt.b(obj);
            }
            return Unit.f68710a;
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    /* JADX WARN: Code duplicated, block: B:44:0x0077 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object i(DownloadBean downloadBean, Continuation<? super Unit> continuation) throws Throwable {
        DownloadEsHelper$deleteTransferReceived$1 downloadEsHelper$deleteTransferReceived$1;
        Object objM163constructorimpl;
        String path;
        Object objM163constructorimpl2;
        Unit unit;
        if (continuation instanceof DownloadEsHelper$deleteTransferReceived$1) {
            downloadEsHelper$deleteTransferReceived$1 = (DownloadEsHelper$deleteTransferReceived$1) continuation;
            int i11 = downloadEsHelper$deleteTransferReceived$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                downloadEsHelper$deleteTransferReceived$1.label = i11 - Integer.MIN_VALUE;
            } else {
                downloadEsHelper$deleteTransferReceived$1 = new DownloadEsHelper$deleteTransferReceived$1(this, continuation);
            }
        } else {
            downloadEsHelper$deleteTransferReceived$1 = new DownloadEsHelper$deleteTransferReceived$1(this, continuation);
        }
        Object obj = downloadEsHelper$deleteTransferReceived$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = downloadEsHelper$deleteTransferReceived$1.label;
        try {
            if (i12 == 0) {
                ResultKt.b(obj);
                if (downloadBean != null) {
                    String resourceId = downloadBean.getResourceId();
                    if (resourceId != null) {
                        Result.Companion companion = Result.Companion;
                        tr.c cVarM = m();
                        if (cVarM != null) {
                            downloadEsHelper$deleteTransferReceived$1.L$0 = this;
                            downloadEsHelper$deleteTransferReceived$1.L$1 = downloadBean;
                            downloadEsHelper$deleteTransferReceived$1.label = 1;
                            if (cVarM.p(resourceId, downloadEsHelper$deleteTransferReceived$1) == objE) {
                                return objE;
                            }
                        } else {
                            unit = null;
                        }
                        objM163constructorimpl = Result.m163constructorimpl(unit);
                        Result.m162boximpl(objM163constructorimpl);
                        path = downloadBean.getPath();
                        if (path != null) {
                            try {
                                Result.Companion companion2 = Result.Companion;
                                objM163constructorimpl2 = Result.m163constructorimpl(Boxing.a(new File(path).delete()));
                            } catch (Throwable th2) {
                                Result.Companion companion3 = Result.Companion;
                                objM163constructorimpl2 = Result.m163constructorimpl(ResultKt.a(th2));
                            }
                            Result.m162boximpl(objM163constructorimpl2);
                        }
                    } else {
                        path = downloadBean.getPath();
                        if (path != null) {
                            Result.Companion companion4 = Result.Companion;
                            objM163constructorimpl2 = Result.m163constructorimpl(Boxing.a(new File(path).delete()));
                            Result.m162boximpl(objM163constructorimpl2);
                        }
                    }
                }
                return Unit.f68710a;
            }
            if (i12 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            downloadBean = (DownloadBean) downloadEsHelper$deleteTransferReceived$1.L$1;
            ResultKt.b(obj);
            unit = Unit.f68710a;
            objM163constructorimpl = Result.m163constructorimpl(unit);
        } catch (Throwable th3) {
            Result.Companion companion5 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th3));
        }
        Result.m162boximpl(objM163constructorimpl);
        path = downloadBean.getPath();
        if (path != null) {
            Result.Companion companion6 = Result.Companion;
            objM163constructorimpl2 = Result.m163constructorimpl(Boxing.a(new File(path).delete()));
            Result.m162boximpl(objM163constructorimpl2);
        }
        return Unit.f68710a;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x005d  */
    /* JADX WARN: Code duplicated, block: B:30:0x0069  */
    /* JADX WARN: Code duplicated, block: B:32:0x0077  */
    /* JADX WARN: Code duplicated, block: B:37:0x0089  */
    /* JADX WARN: Code duplicated, block: B:44:0x00a2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:45:0x0095 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:47:0x0081 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:50:0x0063 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object j(String str, Continuation<? super List<? extends DownloadBean>> continuation) throws Throwable {
        DownloadEsHelper$findDownloadBySubjectId$1 downloadEsHelper$findDownloadBySubjectId$1;
        List<DownloadBean> list;
        DownloadEsHelper downloadEsHelper;
        tr.c cVarM;
        ArrayList arrayList;
        ConcurrentHashMap<String, DownloadBean> concurrentHashMap;
        String resourceId;
        String resourceId2;
        DownloadBean downloadBean;
        if (continuation instanceof DownloadEsHelper$findDownloadBySubjectId$1) {
            downloadEsHelper$findDownloadBySubjectId$1 = (DownloadEsHelper$findDownloadBySubjectId$1) continuation;
            int i11 = downloadEsHelper$findDownloadBySubjectId$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                downloadEsHelper$findDownloadBySubjectId$1.label = i11 - Integer.MIN_VALUE;
            } else {
                downloadEsHelper$findDownloadBySubjectId$1 = new DownloadEsHelper$findDownloadBySubjectId$1(this, continuation);
            }
        } else {
            downloadEsHelper$findDownloadBySubjectId$1 = new DownloadEsHelper$findDownloadBySubjectId$1(this, continuation);
        }
        Object objR = downloadEsHelper$findDownloadBySubjectId$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = downloadEsHelper$findDownloadBySubjectId$1.label;
        if (i12 == 0) {
            ResultKt.b(objR);
            list = null;
            if (this.f61007l != null) {
                return null;
            }
            if (str == null || (cVarM = m()) == null) {
                downloadEsHelper = this;
            } else {
                downloadEsHelper$findDownloadBySubjectId$1.L$0 = this;
                downloadEsHelper$findDownloadBySubjectId$1.label = 1;
                objR = cVarM.r(str, downloadEsHelper$findDownloadBySubjectId$1);
                if (objR == objE) {
                    return objE;
                }
                downloadEsHelper = this;
            }
            arrayList = new ArrayList();
            if (list != null) {
                for (DownloadBean downloadBean2 : list) {
                    concurrentHashMap = downloadEsHelper.f60996a;
                    resourceId = downloadBean2.getResourceId();
                    if (resourceId == null) {
                        resourceId = downloadBean2.getUrl();
                    }
                    if (concurrentHashMap.containsKey(resourceId)) {
                        ConcurrentHashMap<String, DownloadBean> concurrentHashMap2 = downloadEsHelper.f60996a;
                        resourceId2 = downloadBean2.getResourceId();
                        if (resourceId2 == null) {
                            resourceId2 = downloadBean2.getUrl();
                        }
                        downloadBean = concurrentHashMap2.get(resourceId2);
                        if (downloadBean != null) {
                            Intrinsics.f(downloadBean, "downloadBean");
                            Boxing.a(arrayList.add(downloadBean));
                        }
                    } else {
                        arrayList.add(downloadBean2);
                    }
                }
            }
            return arrayList;
        }
        if (i12 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        downloadEsHelper = (DownloadEsHelper) downloadEsHelper$findDownloadBySubjectId$1.L$0;
        ResultKt.b(objR);
        list = (List) objR;
        arrayList = new ArrayList();
        if (list != null) {
            while (r0.hasNext()) {
                concurrentHashMap = downloadEsHelper.f60996a;
                resourceId = downloadBean2.getResourceId();
                if (resourceId == null) {
                    resourceId = downloadBean2.getUrl();
                }
                if (concurrentHashMap.containsKey(resourceId)) {
                    ConcurrentHashMap<String, DownloadBean> concurrentHashMap3 = downloadEsHelper.f60996a;
                    resourceId2 = downloadBean2.getResourceId();
                    if (resourceId2 == null) {
                        resourceId2 = downloadBean2.getUrl();
                    }
                    downloadBean = concurrentHashMap3.get(resourceId2);
                    if (downloadBean != null) {
                        Intrinsics.f(downloadBean, "downloadBean");
                        Boxing.a(arrayList.add(downloadBean));
                    }
                } else {
                    arrayList.add(downloadBean2);
                }
            }
        }
        return arrayList;
    }

    /* JADX WARN: Code duplicated, block: B:40:0x0084 A[Catch: all -> 0x0031, TryCatch #0 {all -> 0x0031, blocks: (B:13:0x002c, B:51:0x00a5, B:54:0x00aa, B:20:0x0040, B:23:0x004c, B:37:0x007d, B:40:0x0084, B:43:0x008c, B:26:0x0053, B:28:0x0057, B:30:0x005f, B:31:0x0069, B:33:0x006f, B:48:0x009c), top: B:59:0x0024 }] */
    /* JADX WARN: Code duplicated, block: B:53:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:54:0x00aa A[Catch: all -> 0x0031, TRY_LEAVE, TryCatch #0 {all -> 0x0031, blocks: (B:13:0x002c, B:51:0x00a5, B:54:0x00aa, B:20:0x0040, B:23:0x004c, B:37:0x007d, B:40:0x0084, B:43:0x008c, B:26:0x0053, B:28:0x0057, B:30:0x005f, B:31:0x0069, B:33:0x006f, B:48:0x009c), top: B:59:0x0024 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object k(String str, Continuation<? super DownloadBean> continuation) throws Throwable {
        DownloadEsHelper$findDownloadedByResourceId$1 downloadEsHelper$findDownloadedByResourceId$1;
        DownloadEsHelper downloadEsHelper;
        DownloadBean downloadBean;
        DownloadBean downloadBean2;
        DownloadEsBean downloadEsBean;
        if (continuation instanceof DownloadEsHelper$findDownloadedByResourceId$1) {
            downloadEsHelper$findDownloadedByResourceId$1 = (DownloadEsHelper$findDownloadedByResourceId$1) continuation;
            int i11 = downloadEsHelper$findDownloadedByResourceId$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                downloadEsHelper$findDownloadedByResourceId$1.label = i11 - Integer.MIN_VALUE;
            } else {
                downloadEsHelper$findDownloadedByResourceId$1 = new DownloadEsHelper$findDownloadedByResourceId$1(this, continuation);
            }
        } else {
            downloadEsHelper$findDownloadedByResourceId$1 = new DownloadEsHelper$findDownloadedByResourceId$1(this, continuation);
        }
        Object objB = downloadEsHelper$findDownloadedByResourceId$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = downloadEsHelper$findDownloadedByResourceId$1.label;
        try {
            if (i12 != 0) {
                if (i12 == 1) {
                    str = (String) downloadEsHelper$findDownloadedByResourceId$1.L$1;
                    downloadEsHelper = (DownloadEsHelper) downloadEsHelper$findDownloadedByResourceId$1.L$0;
                    ResultKt.b(objB);
                    downloadBean = (DownloadBean) objB;
                    if (downloadBean != null) {
                        downloadEsHelper.f60996a.put(str, downloadBean);
                    }
                    downloadBean2 = downloadBean;
                } else {
                    if (i12 != 2) {
                        if (i12 != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.b(objB);
                        downloadEsBean = (DownloadEsBean) objB;
                        if (downloadEsBean != null) {
                            return null;
                        }
                        return DownloadEsBean.Companion.b(downloadEsBean);
                    }
                    downloadBean2 = (DownloadBean) downloadEsHelper$findDownloadedByResourceId$1.L$0;
                    ResultKt.b(objB);
                }
                return downloadBean2;
            }
            ResultKt.b(objB);
            tr.e eVar = this.f61007l;
            if (eVar != null) {
                if (eVar != null) {
                    downloadEsHelper$findDownloadedByResourceId$1.label = 3;
                    objB = eVar.b(str, downloadEsHelper$findDownloadedByResourceId$1);
                    if (objB == objE) {
                        return objE;
                    }
                    downloadEsBean = (DownloadEsBean) objB;
                    if (downloadEsBean != null) {
                        return DownloadEsBean.Companion.b(downloadEsBean);
                    }
                }
                return null;
            }
            if (this.f60996a.containsKey(str)) {
                downloadBean2 = this.f60996a.get(str);
                downloadEsHelper = this;
            } else {
                tr.c cVarM = m();
                if (cVarM != null) {
                    downloadEsHelper$findDownloadedByResourceId$1.L$0 = this;
                    downloadEsHelper$findDownloadedByResourceId$1.L$1 = str;
                    downloadEsHelper$findDownloadedByResourceId$1.label = 1;
                    objB = cVarM.b(str, downloadEsHelper$findDownloadedByResourceId$1);
                    if (objB == objE) {
                        return objE;
                    }
                    downloadEsHelper = this;
                    downloadBean = (DownloadBean) objB;
                } else {
                    downloadEsHelper = this;
                    downloadBean = null;
                }
                if (downloadBean != null) {
                    downloadEsHelper.f60996a.put(str, downloadBean);
                }
                downloadBean2 = downloadBean;
            }
            if (downloadBean2 != null) {
                downloadEsHelper$findDownloadedByResourceId$1.L$0 = downloadBean2;
                downloadEsHelper$findDownloadedByResourceId$1.L$1 = null;
                downloadEsHelper$findDownloadedByResourceId$1.label = 2;
                if (downloadEsHelper.f(downloadBean2, downloadEsHelper$findDownloadedByResourceId$1) == objE) {
                    return objE;
                }
            }
            return downloadBean2;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    public final DownloadBean l(String resourceId) {
        Intrinsics.g(resourceId, "resourceId");
        if (this.f60996a.containsKey(resourceId)) {
            return this.f60996a.get(resourceId);
        }
        return null;
    }

    public final tr.c m() {
        return (tr.c) this.f61004i.getValue();
    }

    public final File n() {
        e();
        return new File(tr.b.f77264a.d());
    }

    public final String o() {
        return this.f61001f;
    }

    public final int p() {
        return this.f61003h;
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0076 A[Catch: all -> 0x003c, TryCatch #0 {all -> 0x003c, blocks: (B:13:0x0038, B:34:0x0080, B:36:0x0086, B:38:0x0094, B:39:0x0098, B:41:0x009e, B:43:0x00a6, B:44:0x00aa, B:49:0x00e1, B:45:0x00b7, B:47:0x00d7, B:48:0x00db, B:20:0x004f, B:29:0x006a, B:31:0x006f, B:33:0x0076, B:23:0x0056, B:25:0x005c), top: B:56:0x0022 }] */
    /* JADX WARN: Code duplicated, block: B:36:0x0086 A[Catch: all -> 0x003c, TryCatch #0 {all -> 0x003c, blocks: (B:13:0x0038, B:34:0x0080, B:36:0x0086, B:38:0x0094, B:39:0x0098, B:41:0x009e, B:43:0x00a6, B:44:0x00aa, B:49:0x00e1, B:45:0x00b7, B:47:0x00d7, B:48:0x00db, B:20:0x004f, B:29:0x006a, B:31:0x006f, B:33:0x0076, B:23:0x0056, B:25:0x005c), top: B:56:0x0022 }] */
    /* JADX WARN: Code duplicated, block: B:38:0x0094 A[Catch: all -> 0x003c, TryCatch #0 {all -> 0x003c, blocks: (B:13:0x0038, B:34:0x0080, B:36:0x0086, B:38:0x0094, B:39:0x0098, B:41:0x009e, B:43:0x00a6, B:44:0x00aa, B:49:0x00e1, B:45:0x00b7, B:47:0x00d7, B:48:0x00db, B:20:0x004f, B:29:0x006a, B:31:0x006f, B:33:0x0076, B:23:0x0056, B:25:0x005c), top: B:56:0x0022 }] */
    /* JADX WARN: Code duplicated, block: B:41:0x009e A[Catch: all -> 0x003c, TryCatch #0 {all -> 0x003c, blocks: (B:13:0x0038, B:34:0x0080, B:36:0x0086, B:38:0x0094, B:39:0x0098, B:41:0x009e, B:43:0x00a6, B:44:0x00aa, B:49:0x00e1, B:45:0x00b7, B:47:0x00d7, B:48:0x00db, B:20:0x004f, B:29:0x006a, B:31:0x006f, B:33:0x0076, B:23:0x0056, B:25:0x005c), top: B:56:0x0022 }] */
    /* JADX WARN: Code duplicated, block: B:43:0x00a6 A[Catch: all -> 0x003c, TryCatch #0 {all -> 0x003c, blocks: (B:13:0x0038, B:34:0x0080, B:36:0x0086, B:38:0x0094, B:39:0x0098, B:41:0x009e, B:43:0x00a6, B:44:0x00aa, B:49:0x00e1, B:45:0x00b7, B:47:0x00d7, B:48:0x00db, B:20:0x004f, B:29:0x006a, B:31:0x006f, B:33:0x0076, B:23:0x0056, B:25:0x005c), top: B:56:0x0022 }] */
    /* JADX WARN: Code duplicated, block: B:45:0x00b7 A[Catch: all -> 0x003c, TryCatch #0 {all -> 0x003c, blocks: (B:13:0x0038, B:34:0x0080, B:36:0x0086, B:38:0x0094, B:39:0x0098, B:41:0x009e, B:43:0x00a6, B:44:0x00aa, B:49:0x00e1, B:45:0x00b7, B:47:0x00d7, B:48:0x00db, B:20:0x004f, B:29:0x006a, B:31:0x006f, B:33:0x0076, B:23:0x0056, B:25:0x005c), top: B:56:0x0022 }] */
    /* JADX WARN: Code duplicated, block: B:47:0x00d7 A[Catch: all -> 0x003c, TryCatch #0 {all -> 0x003c, blocks: (B:13:0x0038, B:34:0x0080, B:36:0x0086, B:38:0x0094, B:39:0x0098, B:41:0x009e, B:43:0x00a6, B:44:0x00aa, B:49:0x00e1, B:45:0x00b7, B:47:0x00d7, B:48:0x00db, B:20:0x004f, B:29:0x006a, B:31:0x006f, B:33:0x0076, B:23:0x0056, B:25:0x005c), top: B:56:0x0022 }] */
    /* JADX WARN: Code duplicated, block: B:59:0x00f1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:61:? A[LOOP:0: B:34:0x0080->B:61:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:62:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Instruction removed from duplicated block: B:45:0x00b7, please report this as an issue */
    public final Object q(String str, Continuation<? super List<? extends DownloadBean>> continuation) throws Throwable {
        DownloadEsHelper$getEpisode$1 downloadEsHelper$getEpisode$1;
        List list;
        DownloadEsHelper downloadEsHelper;
        ArrayList arrayList;
        DownloadEsHelper downloadEsHelper2;
        List list2;
        String str2;
        Iterator it;
        DownloadBean downloadBean;
        ConcurrentHashMap<String, DownloadBean> concurrentHashMap;
        String resourceId;
        String resourceId2;
        String resourceId3;
        if (continuation instanceof DownloadEsHelper$getEpisode$1) {
            downloadEsHelper$getEpisode$1 = (DownloadEsHelper$getEpisode$1) continuation;
            int i11 = downloadEsHelper$getEpisode$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                downloadEsHelper$getEpisode$1.label = i11 - Integer.MIN_VALUE;
            } else {
                downloadEsHelper$getEpisode$1 = new DownloadEsHelper$getEpisode$1(this, continuation);
            }
        } else {
            downloadEsHelper$getEpisode$1 = new DownloadEsHelper$getEpisode$1(this, continuation);
        }
        Object objC = downloadEsHelper$getEpisode$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = downloadEsHelper$getEpisode$1.label;
        try {
            if (i12 != 0) {
                if (i12 == 1) {
                    str = (String) downloadEsHelper$getEpisode$1.L$1;
                    downloadEsHelper = (DownloadEsHelper) downloadEsHelper$getEpisode$1.L$0;
                    ResultKt.b(objC);
                } else {
                    if (i12 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    it = (Iterator) downloadEsHelper$getEpisode$1.L$3;
                    list2 = (List) downloadEsHelper$getEpisode$1.L$2;
                    str2 = (String) downloadEsHelper$getEpisode$1.L$1;
                    downloadEsHelper2 = (DownloadEsHelper) downloadEsHelper$getEpisode$1.L$0;
                    ResultKt.b(objC);
                }
                while (it.hasNext()) {
                    downloadBean = (DownloadBean) it.next();
                    concurrentHashMap = downloadEsHelper2.f60996a;
                    resourceId = downloadBean.getResourceId();
                    if (resourceId == null) {
                        resourceId = downloadBean.getUrl();
                    }
                    if (concurrentHashMap.containsKey(resourceId)) {
                        ConcurrentHashMap<String, DownloadBean> concurrentHashMap2 = downloadEsHelper2.f60996a;
                        resourceId3 = downloadBean.getResourceId();
                        if (resourceId3 == null) {
                            resourceId3 = downloadBean.getUrl();
                        }
                        DownloadBean downloadBean2 = concurrentHashMap2.get(resourceId3);
                        Intrinsics.d(downloadBean2);
                        downloadBean = downloadBean2;
                        list2.add(downloadBean);
                    } else {
                        downloadEsHelper2.f60999d.put(str2 + downloadBean.getEp(), downloadBean);
                        ConcurrentHashMap<String, DownloadBean> concurrentHashMap3 = downloadEsHelper2.f60996a;
                        resourceId2 = downloadBean.getResourceId();
                        if (resourceId2 == null) {
                            resourceId2 = downloadBean.getUrl();
                        }
                        concurrentHashMap3.put(resourceId2, downloadBean);
                        list2.add(downloadBean);
                    }
                    downloadEsHelper$getEpisode$1.L$0 = downloadEsHelper2;
                    downloadEsHelper$getEpisode$1.L$1 = str2;
                    downloadEsHelper$getEpisode$1.L$2 = list2;
                    downloadEsHelper$getEpisode$1.L$3 = it;
                    downloadEsHelper$getEpisode$1.label = 2;
                    if (downloadEsHelper2.f(downloadBean, downloadEsHelper$getEpisode$1) == objE) {
                        return objE;
                    }
                }
                return list2;
            }
            ResultKt.b(objC);
            tr.c cVarM = m();
            if (cVarM != null) {
                downloadEsHelper$getEpisode$1.L$0 = this;
                downloadEsHelper$getEpisode$1.L$1 = str;
                downloadEsHelper$getEpisode$1.label = 1;
                objC = cVarM.C(str, downloadEsHelper$getEpisode$1);
                if (objC == objE) {
                    return objE;
                }
                downloadEsHelper = this;
            } else {
                list = null;
                downloadEsHelper = this;
            }
            arrayList = new ArrayList();
            if (list != null) {
                return arrayList;
            }
            downloadEsHelper2 = downloadEsHelper;
            list2 = arrayList;
            str2 = str;
            it = list.iterator();
            while (it.hasNext()) {
                downloadBean = (DownloadBean) it.next();
                concurrentHashMap = downloadEsHelper2.f60996a;
                resourceId = downloadBean.getResourceId();
                if (resourceId == null) {
                    resourceId = downloadBean.getUrl();
                }
                if (concurrentHashMap.containsKey(resourceId)) {
                    ConcurrentHashMap<String, DownloadBean> concurrentHashMap4 = downloadEsHelper2.f60996a;
                    resourceId3 = downloadBean.getResourceId();
                    if (resourceId3 == null) {
                        resourceId3 = downloadBean.getUrl();
                    }
                    DownloadBean downloadBean3 = concurrentHashMap4.get(resourceId3);
                    Intrinsics.d(downloadBean3);
                    downloadBean = downloadBean3;
                    list2.add(downloadBean);
                } else {
                    downloadEsHelper2.f60999d.put(str2 + downloadBean.getEp(), downloadBean);
                    ConcurrentHashMap<String, DownloadBean> concurrentHashMap5 = downloadEsHelper2.f60996a;
                    resourceId2 = downloadBean.getResourceId();
                    if (resourceId2 == null) {
                        resourceId2 = downloadBean.getUrl();
                    }
                    concurrentHashMap5.put(resourceId2, downloadBean);
                    list2.add(downloadBean);
                }
                downloadEsHelper$getEpisode$1.L$0 = downloadEsHelper2;
                downloadEsHelper$getEpisode$1.L$1 = str2;
                downloadEsHelper$getEpisode$1.L$2 = list2;
                downloadEsHelper$getEpisode$1.L$3 = it;
                downloadEsHelper$getEpisode$1.label = 2;
                if (downloadEsHelper2.f(downloadBean, downloadEsHelper$getEpisode$1) == objE) {
                    return objE;
                }
            }
            return list2;
            list = (List) objC;
            arrayList = new ArrayList();
            if (list != null) {
                return arrayList;
            }
            downloadEsHelper2 = downloadEsHelper;
            list2 = arrayList;
            str2 = str;
            it = list.iterator();
            while (it.hasNext()) {
                downloadBean = (DownloadBean) it.next();
                concurrentHashMap = downloadEsHelper2.f60996a;
                resourceId = downloadBean.getResourceId();
                if (resourceId == null) {
                    resourceId = downloadBean.getUrl();
                }
                if (concurrentHashMap.containsKey(resourceId)) {
                    ConcurrentHashMap<String, DownloadBean> concurrentHashMap6 = downloadEsHelper2.f60996a;
                    resourceId3 = downloadBean.getResourceId();
                    if (resourceId3 == null) {
                        resourceId3 = downloadBean.getUrl();
                    }
                    DownloadBean downloadBean4 = concurrentHashMap6.get(resourceId3);
                    Intrinsics.d(downloadBean4);
                    downloadBean = downloadBean4;
                    list2.add(downloadBean);
                } else {
                    downloadEsHelper2.f60999d.put(str2 + downloadBean.getEp(), downloadBean);
                    ConcurrentHashMap<String, DownloadBean> concurrentHashMap7 = downloadEsHelper2.f60996a;
                    resourceId2 = downloadBean.getResourceId();
                    if (resourceId2 == null) {
                        resourceId2 = downloadBean.getUrl();
                    }
                    concurrentHashMap7.put(resourceId2, downloadBean);
                    list2.add(downloadBean);
                }
                downloadEsHelper$getEpisode$1.L$0 = downloadEsHelper2;
                downloadEsHelper$getEpisode$1.L$1 = str2;
                downloadEsHelper$getEpisode$1.L$2 = list2;
                downloadEsHelper$getEpisode$1.L$3 = it;
                downloadEsHelper$getEpisode$1.label = 2;
                if (downloadEsHelper2.f(downloadBean, downloadEsHelper$getEpisode$1) == objE) {
                    return objE;
                }
            }
            return list2;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return new ArrayList();
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object r(String str, int i11, Continuation<? super DownloadBean> continuation) throws Throwable {
        DownloadEsHelper$getEpisodeBean$1 downloadEsHelper$getEpisodeBean$1;
        DownloadEsHelper downloadEsHelper;
        if (continuation instanceof DownloadEsHelper$getEpisodeBean$1) {
            downloadEsHelper$getEpisodeBean$1 = (DownloadEsHelper$getEpisodeBean$1) continuation;
            int i12 = downloadEsHelper$getEpisodeBean$1.label;
            if ((i12 & Integer.MIN_VALUE) != 0) {
                downloadEsHelper$getEpisodeBean$1.label = i12 - Integer.MIN_VALUE;
            } else {
                downloadEsHelper$getEpisodeBean$1 = new DownloadEsHelper$getEpisodeBean$1(this, continuation);
            }
        } else {
            downloadEsHelper$getEpisodeBean$1 = new DownloadEsHelper$getEpisodeBean$1(this, continuation);
        }
        Object objM = downloadEsHelper$getEpisodeBean$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i13 = downloadEsHelper$getEpisodeBean$1.label;
        try {
            if (i13 == 0) {
                ResultKt.b(objM);
                tr.c cVarM = m();
                if (cVarM != null) {
                    downloadEsHelper$getEpisodeBean$1.L$0 = this;
                    downloadEsHelper$getEpisodeBean$1.L$1 = str;
                    downloadEsHelper$getEpisodeBean$1.I$0 = i11;
                    downloadEsHelper$getEpisodeBean$1.label = 1;
                    objM = cVarM.m(str, i11, downloadEsHelper$getEpisodeBean$1);
                    if (objM == objE) {
                        return objE;
                    }
                    downloadEsHelper = this;
                }
                return null;
            }
            if (i13 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i11 = downloadEsHelper$getEpisodeBean$1.I$0;
            str = (String) downloadEsHelper$getEpisodeBean$1.L$1;
            downloadEsHelper = (DownloadEsHelper) downloadEsHelper$getEpisodeBean$1.L$0;
            ResultKt.b(objM);
            DownloadBean downloadBean = (DownloadBean) objM;
            if (downloadBean == null) {
                return null;
            }
            ConcurrentHashMap<String, DownloadBean> concurrentHashMap = downloadEsHelper.f60996a;
            String resourceId = downloadBean.getResourceId();
            if (resourceId == null) {
                resourceId = downloadBean.getUrl();
            }
            if (concurrentHashMap.containsKey(resourceId)) {
                ConcurrentHashMap<String, DownloadBean> concurrentHashMap2 = downloadEsHelper.f60996a;
                String resourceId2 = downloadBean.getResourceId();
                if (resourceId2 == null) {
                    resourceId2 = downloadBean.getUrl();
                }
                return concurrentHashMap2.get(resourceId2);
            }
            downloadEsHelper.f60999d.put(str + i11, downloadBean);
            ConcurrentHashMap<String, DownloadBean> concurrentHashMap3 = downloadEsHelper.f60996a;
            String resourceId3 = downloadBean.getResourceId();
            if (resourceId3 == null) {
                resourceId3 = downloadBean.getUrl();
            }
            concurrentHashMap3.put(resourceId3, downloadBean);
            return downloadBean;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    public final DownloadBean s(String subjectId, int i11) {
        Intrinsics.g(subjectId, "subjectId");
        return this.f60999d.get(subjectId + i11);
    }

    /* JADX WARN: Code duplicated, block: B:38:0x0079 A[Catch: all -> 0x0031, TryCatch #0 {all -> 0x0031, blocks: (B:13:0x002c, B:69:0x0112, B:72:0x0117, B:73:0x0122, B:75:0x0128, B:20:0x0048, B:39:0x0082, B:41:0x0088, B:43:0x0096, B:44:0x009a, B:46:0x00a0, B:48:0x00a8, B:49:0x00ac, B:60:0x00f6, B:50:0x00b9, B:52:0x00bf, B:53:0x00db, B:55:0x00e1, B:56:0x00e4, B:58:0x00ec, B:59:0x00f0, B:23:0x0050, B:34:0x006d, B:36:0x0072, B:38:0x0079, B:26:0x0057, B:28:0x005b, B:30:0x0061, B:66:0x0109), top: B:81:0x0024 }] */
    /* JADX WARN: Code duplicated, block: B:71:0x0116  */
    /* JADX WARN: Code duplicated, block: B:72:0x0117 A[Catch: all -> 0x0031, TryCatch #0 {all -> 0x0031, blocks: (B:13:0x002c, B:69:0x0112, B:72:0x0117, B:73:0x0122, B:75:0x0128, B:20:0x0048, B:39:0x0082, B:41:0x0088, B:43:0x0096, B:44:0x009a, B:46:0x00a0, B:48:0x00a8, B:49:0x00ac, B:60:0x00f6, B:50:0x00b9, B:52:0x00bf, B:53:0x00db, B:55:0x00e1, B:56:0x00e4, B:58:0x00ec, B:59:0x00f0, B:23:0x0050, B:34:0x006d, B:36:0x0072, B:38:0x0079, B:26:0x0057, B:28:0x005b, B:30:0x0061, B:66:0x0109), top: B:81:0x0024 }] */
    /* JADX WARN: Code duplicated, block: B:75:0x0128 A[Catch: all -> 0x0031, LOOP:0: B:73:0x0122->B:75:0x0128, LOOP_END, TRY_LEAVE, TryCatch #0 {all -> 0x0031, blocks: (B:13:0x002c, B:69:0x0112, B:72:0x0117, B:73:0x0122, B:75:0x0128, B:20:0x0048, B:39:0x0082, B:41:0x0088, B:43:0x0096, B:44:0x009a, B:46:0x00a0, B:48:0x00a8, B:49:0x00ac, B:60:0x00f6, B:50:0x00b9, B:52:0x00bf, B:53:0x00db, B:55:0x00e1, B:56:0x00e4, B:58:0x00ec, B:59:0x00f0, B:23:0x0050, B:34:0x006d, B:36:0x0072, B:38:0x0079, B:26:0x0057, B:28:0x005b, B:30:0x0061, B:66:0x0109), top: B:81:0x0024 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code duplicated, block: B:87:? A[RETURN, SYNTHETIC] */
    public final Object t(Continuation<? super List<? extends DownloadBean>> continuation) throws Throwable {
        DownloadEsHelper$getFailedDownload$1 downloadEsHelper$getFailedDownload$1;
        DownloadEsHelper downloadEsHelper;
        ArrayList arrayList;
        DownloadEsHelper downloadEsHelper2;
        Iterator it;
        List list;
        List list2;
        ArrayList arrayList2;
        Iterator it2;
        if (continuation instanceof DownloadEsHelper$getFailedDownload$1) {
            downloadEsHelper$getFailedDownload$1 = (DownloadEsHelper$getFailedDownload$1) continuation;
            int i11 = downloadEsHelper$getFailedDownload$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                downloadEsHelper$getFailedDownload$1.label = i11 - Integer.MIN_VALUE;
            } else {
                downloadEsHelper$getFailedDownload$1 = new DownloadEsHelper$getFailedDownload$1(this, continuation);
            }
        } else {
            downloadEsHelper$getFailedDownload$1 = new DownloadEsHelper$getFailedDownload$1(this, continuation);
        }
        Object objF = downloadEsHelper$getFailedDownload$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = downloadEsHelper$getFailedDownload$1.label;
        List list3 = null;
        try {
            if (i12 == 0) {
                ResultKt.b(objF);
                tr.e eVar = this.f61007l;
                if (eVar != null) {
                    if (eVar != null) {
                        downloadEsHelper$getFailedDownload$1.label = 3;
                        objF = eVar.f(downloadEsHelper$getFailedDownload$1);
                        if (objF == objE) {
                            return objE;
                        }
                        list2 = (List) objF;
                        if (list2 != null) {
                            arrayList2 = new ArrayList();
                            it2 = list2.iterator();
                            while (it2.hasNext()) {
                                arrayList2.add(DownloadEsBean.Companion.b((DownloadEsBean) it2.next()));
                            }
                            return arrayList2;
                        }
                    }
                    return null;
                }
                tr.c cVarM = m();
                if (cVarM != null) {
                    downloadEsHelper$getFailedDownload$1.L$0 = this;
                    downloadEsHelper$getFailedDownload$1.label = 1;
                    objF = cVarM.f(downloadEsHelper$getFailedDownload$1);
                    if (objF == objE) {
                        return objE;
                    }
                    downloadEsHelper = this;
                    list3 = (List) objF;
                } else {
                    downloadEsHelper = this;
                }
                arrayList = new ArrayList();
                if (list3 != null) {
                    return arrayList;
                }
                downloadEsHelper2 = downloadEsHelper;
                it = list3.iterator();
                list = arrayList;
            } else if (i12 == 1) {
                downloadEsHelper = (DownloadEsHelper) downloadEsHelper$getFailedDownload$1.L$0;
                ResultKt.b(objF);
                list3 = (List) objF;
                arrayList = new ArrayList();
                if (list3 != null) {
                    return arrayList;
                }
                downloadEsHelper2 = downloadEsHelper;
                it = list3.iterator();
                list = arrayList;
            } else {
                if (i12 != 2) {
                    if (i12 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(objF);
                    list2 = (List) objF;
                    if (list2 != null) {
                        return null;
                    }
                    arrayList2 = new ArrayList();
                    it2 = list2.iterator();
                    while (it2.hasNext()) {
                        arrayList2.add(DownloadEsBean.Companion.b((DownloadEsBean) it2.next()));
                    }
                    return arrayList2;
                }
                it = (Iterator) downloadEsHelper$getFailedDownload$1.L$2;
                list = (List) downloadEsHelper$getFailedDownload$1.L$1;
                downloadEsHelper2 = (DownloadEsHelper) downloadEsHelper$getFailedDownload$1.L$0;
                ResultKt.b(objF);
            }
            while (it.hasNext()) {
                DownloadBean downloadBean = (DownloadBean) it.next();
                ConcurrentHashMap<String, DownloadBean> concurrentHashMap = downloadEsHelper2.f60996a;
                String resourceId = downloadBean.getResourceId();
                if (resourceId == null) {
                    resourceId = downloadBean.getUrl();
                }
                if (concurrentHashMap.containsKey(resourceId)) {
                    ConcurrentHashMap<String, DownloadBean> concurrentHashMap2 = downloadEsHelper2.f60996a;
                    String resourceId2 = downloadBean.getResourceId();
                    if (resourceId2 == null) {
                        resourceId2 = downloadBean.getUrl();
                    }
                    DownloadBean downloadBean2 = concurrentHashMap2.get(resourceId2);
                    Intrinsics.d(downloadBean2);
                    downloadBean = downloadBean2;
                    list.add(downloadBean);
                } else {
                    if (downloadBean.isShotTV()) {
                        downloadEsHelper2.f60999d.put(downloadBean.getSubjectId() + downloadBean.getEp(), downloadBean);
                    }
                    String subjectId = downloadBean.getSubjectId();
                    if (subjectId != null) {
                        downloadEsHelper2.L(subjectId, downloadBean);
                    }
                    ConcurrentHashMap<String, DownloadBean> concurrentHashMap3 = downloadEsHelper2.f60996a;
                    String resourceId3 = downloadBean.getResourceId();
                    if (resourceId3 == null) {
                        resourceId3 = downloadBean.getUrl();
                    }
                    concurrentHashMap3.put(resourceId3, downloadBean);
                    list.add(downloadBean);
                }
                downloadEsHelper$getFailedDownload$1.L$0 = downloadEsHelper2;
                downloadEsHelper$getFailedDownload$1.L$1 = list;
                downloadEsHelper$getFailedDownload$1.L$2 = it;
                downloadEsHelper$getFailedDownload$1.label = 2;
                if (downloadEsHelper2.f(downloadBean, downloadEsHelper$getFailedDownload$1) == objE) {
                    return objE;
                }
            }
            return list;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return new ArrayList();
        }
    }

    /* JADX WARN: Code duplicated, block: B:29:0x005a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:30:0x005c A[Catch: all -> 0x007f, TryCatch #0 {all -> 0x007f, blocks: (B:12:0x002a, B:23:0x004b, B:25:0x0050, B:27:0x0054, B:32:0x0062, B:34:0x0068, B:36:0x006c, B:41:0x007a, B:39:0x0074, B:30:0x005c, B:17:0x0039, B:19:0x003f), top: B:44:0x0022 }] */
    /* JADX WARN: Code duplicated, block: B:31:0x0061  */
    /* JADX WARN: Code duplicated, block: B:34:0x0068 A[Catch: all -> 0x007f, TryCatch #0 {all -> 0x007f, blocks: (B:12:0x002a, B:23:0x004b, B:25:0x0050, B:27:0x0054, B:32:0x0062, B:34:0x0068, B:36:0x006c, B:41:0x007a, B:39:0x0074, B:30:0x005c, B:17:0x0039, B:19:0x003f), top: B:44:0x0022 }] */
    /* JADX WARN: Code duplicated, block: B:38:0x0072 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:39:0x0074 A[Catch: all -> 0x007f, TryCatch #0 {all -> 0x007f, blocks: (B:12:0x002a, B:23:0x004b, B:25:0x0050, B:27:0x0054, B:32:0x0062, B:34:0x0068, B:36:0x006c, B:41:0x007a, B:39:0x0074, B:30:0x005c, B:17:0x0039, B:19:0x003f), top: B:44:0x0022 }] */
    /* JADX WARN: Code duplicated, block: B:40:0x0079  */
    /* JADX WARN: Code duplicated, block: B:46:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object u(Continuation<? super DownloadBean> continuation) throws Throwable {
        DownloadEsHelper$getLatestDownloadVideo$1 downloadEsHelper$getLatestDownloadVideo$1;
        DownloadEsHelper downloadEsHelper;
        DownloadBean downloadBean;
        ConcurrentHashMap<String, DownloadBean> concurrentHashMap;
        String url;
        String url2;
        if (continuation instanceof DownloadEsHelper$getLatestDownloadVideo$1) {
            downloadEsHelper$getLatestDownloadVideo$1 = (DownloadEsHelper$getLatestDownloadVideo$1) continuation;
            int i11 = downloadEsHelper$getLatestDownloadVideo$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                downloadEsHelper$getLatestDownloadVideo$1.label = i11 - Integer.MIN_VALUE;
            } else {
                downloadEsHelper$getLatestDownloadVideo$1 = new DownloadEsHelper$getLatestDownloadVideo$1(this, continuation);
            }
        } else {
            downloadEsHelper$getLatestDownloadVideo$1 = new DownloadEsHelper$getLatestDownloadVideo$1(this, continuation);
        }
        Object objV = downloadEsHelper$getLatestDownloadVideo$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = downloadEsHelper$getLatestDownloadVideo$1.label;
        try {
            if (i12 == 0) {
                ResultKt.b(objV);
                tr.c cVarM = m();
                if (cVarM != null) {
                    downloadEsHelper$getLatestDownloadVideo$1.L$0 = this;
                    downloadEsHelper$getLatestDownloadVideo$1.label = 1;
                    objV = cVarM.v(downloadEsHelper$getLatestDownloadVideo$1);
                    if (objV == objE) {
                        return objE;
                    }
                    downloadEsHelper = this;
                } else {
                    downloadEsHelper = this;
                    downloadBean = null;
                }
                concurrentHashMap = downloadEsHelper.f60996a;
                if (downloadBean != null || (url = downloadBean.getResourceId()) == null) {
                    if (downloadBean != null) {
                        url = downloadBean.getUrl();
                    } else {
                        url = null;
                    }
                }
                if (concurrentHashMap.containsKey(url)) {
                    return downloadBean;
                }
                ConcurrentHashMap<String, DownloadBean> concurrentHashMap2 = downloadEsHelper.f60996a;
                if (downloadBean != null || (url2 = downloadBean.getResourceId()) == null) {
                    if (downloadBean != null) {
                        url2 = downloadBean.getUrl();
                    } else {
                        url2 = null;
                    }
                }
                return concurrentHashMap2.get(url2);
            }
            if (i12 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            downloadEsHelper = (DownloadEsHelper) downloadEsHelper$getLatestDownloadVideo$1.L$0;
            ResultKt.b(objV);
            downloadBean = (DownloadBean) objV;
            concurrentHashMap = downloadEsHelper.f60996a;
            if (downloadBean != null) {
                if (downloadBean != null) {
                    url = downloadBean.getUrl();
                } else {
                    url = null;
                }
            } else if (downloadBean != null) {
                url = downloadBean.getUrl();
            } else {
                url = null;
            }
            if (concurrentHashMap.containsKey(url)) {
                return downloadBean;
            }
            ConcurrentHashMap<String, DownloadBean> concurrentHashMap3 = downloadEsHelper.f60996a;
            if (downloadBean != null) {
                if (downloadBean != null) {
                    url2 = downloadBean.getUrl();
                } else {
                    url2 = null;
                }
            } else if (downloadBean != null) {
                url2 = downloadBean.getUrl();
            } else {
                url2 = null;
            }
            return concurrentHashMap3.get(url2);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:38:0x007d A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:39:0x007e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:40:0x0080 A[Catch: all -> 0x0031, TryCatch #0 {all -> 0x0031, blocks: (B:13:0x002c, B:71:0x0118, B:74:0x011d, B:75:0x0128, B:77:0x012e, B:20:0x0048, B:41:0x0088, B:43:0x008e, B:45:0x009c, B:46:0x00a0, B:48:0x00a6, B:50:0x00ae, B:51:0x00b2, B:62:0x00fc, B:52:0x00bf, B:54:0x00c5, B:55:0x00e1, B:57:0x00e7, B:58:0x00ea, B:60:0x00f2, B:61:0x00f6, B:23:0x0052, B:34:0x0071, B:36:0x0076, B:40:0x0080, B:26:0x0059, B:28:0x005d, B:30:0x0063, B:68:0x010f), top: B:83:0x0024 }] */
    /* JADX WARN: Code duplicated, block: B:73:0x011c  */
    /* JADX WARN: Code duplicated, block: B:74:0x011d A[Catch: all -> 0x0031, TryCatch #0 {all -> 0x0031, blocks: (B:13:0x002c, B:71:0x0118, B:74:0x011d, B:75:0x0128, B:77:0x012e, B:20:0x0048, B:41:0x0088, B:43:0x008e, B:45:0x009c, B:46:0x00a0, B:48:0x00a6, B:50:0x00ae, B:51:0x00b2, B:62:0x00fc, B:52:0x00bf, B:54:0x00c5, B:55:0x00e1, B:57:0x00e7, B:58:0x00ea, B:60:0x00f2, B:61:0x00f6, B:23:0x0052, B:34:0x0071, B:36:0x0076, B:40:0x0080, B:26:0x0059, B:28:0x005d, B:30:0x0063, B:68:0x010f), top: B:83:0x0024 }] */
    /* JADX WARN: Code duplicated, block: B:77:0x012e A[Catch: all -> 0x0031, LOOP:0: B:75:0x0128->B:77:0x012e, LOOP_END, TRY_LEAVE, TryCatch #0 {all -> 0x0031, blocks: (B:13:0x002c, B:71:0x0118, B:74:0x011d, B:75:0x0128, B:77:0x012e, B:20:0x0048, B:41:0x0088, B:43:0x008e, B:45:0x009c, B:46:0x00a0, B:48:0x00a6, B:50:0x00ae, B:51:0x00b2, B:62:0x00fc, B:52:0x00bf, B:54:0x00c5, B:55:0x00e1, B:57:0x00e7, B:58:0x00ea, B:60:0x00f2, B:61:0x00f6, B:23:0x0052, B:34:0x0071, B:36:0x0076, B:40:0x0080, B:26:0x0059, B:28:0x005d, B:30:0x0063, B:68:0x010f), top: B:83:0x0024 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code duplicated, block: B:89:? A[RETURN, SYNTHETIC] */
    public final Object v(boolean z11, Continuation<? super List<? extends DownloadBean>> continuation) throws Throwable {
        DownloadEsHelper$getListComplete$1 downloadEsHelper$getListComplete$1;
        DownloadEsHelper downloadEsHelper;
        ArrayList arrayList;
        Iterator it;
        DownloadEsHelper downloadEsHelper2;
        List list;
        List list2;
        ArrayList arrayList2;
        Iterator it2;
        if (continuation instanceof DownloadEsHelper$getListComplete$1) {
            downloadEsHelper$getListComplete$1 = (DownloadEsHelper$getListComplete$1) continuation;
            int i11 = downloadEsHelper$getListComplete$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                downloadEsHelper$getListComplete$1.label = i11 - Integer.MIN_VALUE;
            } else {
                downloadEsHelper$getListComplete$1 = new DownloadEsHelper$getListComplete$1(this, continuation);
            }
        } else {
            downloadEsHelper$getListComplete$1 = new DownloadEsHelper$getListComplete$1(this, continuation);
        }
        Object objG = downloadEsHelper$getListComplete$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = downloadEsHelper$getListComplete$1.label;
        List list3 = null;
        try {
            if (i12 == 0) {
                ResultKt.b(objG);
                tr.e eVar = this.f61007l;
                if (eVar != null) {
                    if (eVar != null) {
                        downloadEsHelper$getListComplete$1.label = 3;
                        objG = eVar.g(downloadEsHelper$getListComplete$1);
                        if (objG == objE) {
                            return objE;
                        }
                        list2 = (List) objG;
                        if (list2 != null) {
                            arrayList2 = new ArrayList();
                            it2 = list2.iterator();
                            while (it2.hasNext()) {
                                arrayList2.add(DownloadEsBean.Companion.b((DownloadEsBean) it2.next()));
                            }
                            return arrayList2;
                        }
                    }
                    return null;
                }
                tr.c cVarM = m();
                if (cVarM != null) {
                    downloadEsHelper$getListComplete$1.L$0 = this;
                    downloadEsHelper$getListComplete$1.Z$0 = z11;
                    downloadEsHelper$getListComplete$1.label = 1;
                    objG = cVarM.g(downloadEsHelper$getListComplete$1);
                    if (objG == objE) {
                        return objE;
                    }
                    downloadEsHelper = this;
                    list3 = (List) objG;
                } else {
                    downloadEsHelper = this;
                }
                arrayList = new ArrayList();
                if (z11) {
                    return list3;
                }
                if (list3 != null) {
                    return arrayList;
                }
                it = list3.iterator();
                downloadEsHelper2 = downloadEsHelper;
                list = arrayList;
            } else if (i12 == 1) {
                z11 = downloadEsHelper$getListComplete$1.Z$0;
                downloadEsHelper = (DownloadEsHelper) downloadEsHelper$getListComplete$1.L$0;
                ResultKt.b(objG);
                list3 = (List) objG;
                arrayList = new ArrayList();
                if (z11) {
                    return list3;
                }
                if (list3 != null) {
                    return arrayList;
                }
                it = list3.iterator();
                downloadEsHelper2 = downloadEsHelper;
                list = arrayList;
            } else {
                if (i12 != 2) {
                    if (i12 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(objG);
                    list2 = (List) objG;
                    if (list2 != null) {
                        return null;
                    }
                    arrayList2 = new ArrayList();
                    it2 = list2.iterator();
                    while (it2.hasNext()) {
                        arrayList2.add(DownloadEsBean.Companion.b((DownloadEsBean) it2.next()));
                    }
                    return arrayList2;
                }
                it = (Iterator) downloadEsHelper$getListComplete$1.L$2;
                list = (List) downloadEsHelper$getListComplete$1.L$1;
                downloadEsHelper2 = (DownloadEsHelper) downloadEsHelper$getListComplete$1.L$0;
                ResultKt.b(objG);
            }
            while (it.hasNext()) {
                DownloadBean downloadBean = (DownloadBean) it.next();
                ConcurrentHashMap<String, DownloadBean> concurrentHashMap = downloadEsHelper2.f60996a;
                String resourceId = downloadBean.getResourceId();
                if (resourceId == null) {
                    resourceId = downloadBean.getUrl();
                }
                if (concurrentHashMap.containsKey(resourceId)) {
                    ConcurrentHashMap<String, DownloadBean> concurrentHashMap2 = downloadEsHelper2.f60996a;
                    String resourceId2 = downloadBean.getResourceId();
                    if (resourceId2 == null) {
                        resourceId2 = downloadBean.getUrl();
                    }
                    DownloadBean downloadBean2 = concurrentHashMap2.get(resourceId2);
                    Intrinsics.d(downloadBean2);
                    downloadBean = downloadBean2;
                    list.add(downloadBean);
                } else {
                    if (downloadBean.isShotTV()) {
                        downloadEsHelper2.f60999d.put(downloadBean.getSubjectId() + downloadBean.getEp(), downloadBean);
                    }
                    String subjectId = downloadBean.getSubjectId();
                    if (subjectId != null) {
                        downloadEsHelper2.L(subjectId, downloadBean);
                    }
                    ConcurrentHashMap<String, DownloadBean> concurrentHashMap3 = downloadEsHelper2.f60996a;
                    String resourceId3 = downloadBean.getResourceId();
                    if (resourceId3 == null) {
                        resourceId3 = downloadBean.getUrl();
                    }
                    concurrentHashMap3.put(resourceId3, downloadBean);
                    list.add(downloadBean);
                }
                downloadEsHelper$getListComplete$1.L$0 = downloadEsHelper2;
                downloadEsHelper$getListComplete$1.L$1 = list;
                downloadEsHelper$getListComplete$1.L$2 = it;
                downloadEsHelper$getListComplete$1.label = 2;
                if (downloadEsHelper2.f(downloadBean, downloadEsHelper$getListComplete$1) == objE) {
                    return objE;
                }
            }
            return list;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return new ArrayList();
        }
    }

    /* JADX WARN: Code duplicated, block: B:38:0x0079 A[Catch: all -> 0x0031, TryCatch #0 {all -> 0x0031, blocks: (B:13:0x002c, B:69:0x0110, B:72:0x0115, B:73:0x0120, B:75:0x0126, B:20:0x0048, B:39:0x0082, B:41:0x0088, B:43:0x0096, B:44:0x009a, B:46:0x00a0, B:48:0x00a8, B:49:0x00ac, B:60:0x00f4, B:50:0x00b7, B:52:0x00bd, B:53:0x00d9, B:55:0x00df, B:56:0x00e2, B:58:0x00ea, B:59:0x00ee, B:23:0x0050, B:34:0x006d, B:36:0x0072, B:38:0x0079, B:26:0x0057, B:28:0x005b, B:30:0x0061, B:66:0x0107), top: B:81:0x0024 }] */
    /* JADX WARN: Code duplicated, block: B:71:0x0114  */
    /* JADX WARN: Code duplicated, block: B:72:0x0115 A[Catch: all -> 0x0031, TryCatch #0 {all -> 0x0031, blocks: (B:13:0x002c, B:69:0x0110, B:72:0x0115, B:73:0x0120, B:75:0x0126, B:20:0x0048, B:39:0x0082, B:41:0x0088, B:43:0x0096, B:44:0x009a, B:46:0x00a0, B:48:0x00a8, B:49:0x00ac, B:60:0x00f4, B:50:0x00b7, B:52:0x00bd, B:53:0x00d9, B:55:0x00df, B:56:0x00e2, B:58:0x00ea, B:59:0x00ee, B:23:0x0050, B:34:0x006d, B:36:0x0072, B:38:0x0079, B:26:0x0057, B:28:0x005b, B:30:0x0061, B:66:0x0107), top: B:81:0x0024 }] */
    /* JADX WARN: Code duplicated, block: B:75:0x0126 A[Catch: all -> 0x0031, LOOP:0: B:73:0x0120->B:75:0x0126, LOOP_END, TRY_LEAVE, TryCatch #0 {all -> 0x0031, blocks: (B:13:0x002c, B:69:0x0110, B:72:0x0115, B:73:0x0120, B:75:0x0126, B:20:0x0048, B:39:0x0082, B:41:0x0088, B:43:0x0096, B:44:0x009a, B:46:0x00a0, B:48:0x00a8, B:49:0x00ac, B:60:0x00f4, B:50:0x00b7, B:52:0x00bd, B:53:0x00d9, B:55:0x00df, B:56:0x00e2, B:58:0x00ea, B:59:0x00ee, B:23:0x0050, B:34:0x006d, B:36:0x0072, B:38:0x0079, B:26:0x0057, B:28:0x005b, B:30:0x0061, B:66:0x0107), top: B:81:0x0024 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code duplicated, block: B:87:? A[RETURN, SYNTHETIC] */
    public final Object x(Continuation<? super List<? extends DownloadBean>> continuation) throws Throwable {
        DownloadEsHelper$getListUnComplete$1 downloadEsHelper$getListUnComplete$1;
        DownloadEsHelper downloadEsHelper;
        ArrayList arrayList;
        DownloadEsHelper downloadEsHelper2;
        Iterator it;
        List list;
        List list2;
        ArrayList arrayList2;
        Iterator it2;
        if (continuation instanceof DownloadEsHelper$getListUnComplete$1) {
            downloadEsHelper$getListUnComplete$1 = (DownloadEsHelper$getListUnComplete$1) continuation;
            int i11 = downloadEsHelper$getListUnComplete$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                downloadEsHelper$getListUnComplete$1.label = i11 - Integer.MIN_VALUE;
            } else {
                downloadEsHelper$getListUnComplete$1 = new DownloadEsHelper$getListUnComplete$1(this, continuation);
            }
        } else {
            downloadEsHelper$getListUnComplete$1 = new DownloadEsHelper$getListUnComplete$1(this, continuation);
        }
        Object objI = downloadEsHelper$getListUnComplete$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = downloadEsHelper$getListUnComplete$1.label;
        List list3 = null;
        try {
            if (i12 == 0) {
                ResultKt.b(objI);
                tr.e eVar = this.f61007l;
                if (eVar != null) {
                    if (eVar != null) {
                        downloadEsHelper$getListUnComplete$1.label = 3;
                        objI = eVar.i(downloadEsHelper$getListUnComplete$1);
                        if (objI == objE) {
                            return objE;
                        }
                        list2 = (List) objI;
                        if (list2 != null) {
                            arrayList2 = new ArrayList();
                            it2 = list2.iterator();
                            while (it2.hasNext()) {
                                arrayList2.add(DownloadEsBean.Companion.b((DownloadEsBean) it2.next()));
                            }
                            return arrayList2;
                        }
                    }
                    return null;
                }
                tr.c cVarM = m();
                if (cVarM != null) {
                    downloadEsHelper$getListUnComplete$1.L$0 = this;
                    downloadEsHelper$getListUnComplete$1.label = 1;
                    objI = cVarM.i(downloadEsHelper$getListUnComplete$1);
                    if (objI == objE) {
                        return objE;
                    }
                    downloadEsHelper = this;
                    list3 = (List) objI;
                } else {
                    downloadEsHelper = this;
                }
                arrayList = new ArrayList();
                if (list3 != null) {
                    return arrayList;
                }
                downloadEsHelper2 = downloadEsHelper;
                it = list3.iterator();
                list = arrayList;
            } else if (i12 == 1) {
                downloadEsHelper = (DownloadEsHelper) downloadEsHelper$getListUnComplete$1.L$0;
                ResultKt.b(objI);
                list3 = (List) objI;
                arrayList = new ArrayList();
                if (list3 != null) {
                    return arrayList;
                }
                downloadEsHelper2 = downloadEsHelper;
                it = list3.iterator();
                list = arrayList;
            } else {
                if (i12 != 2) {
                    if (i12 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(objI);
                    list2 = (List) objI;
                    if (list2 != null) {
                        return null;
                    }
                    arrayList2 = new ArrayList();
                    it2 = list2.iterator();
                    while (it2.hasNext()) {
                        arrayList2.add(DownloadEsBean.Companion.b((DownloadEsBean) it2.next()));
                    }
                    return arrayList2;
                }
                it = (Iterator) downloadEsHelper$getListUnComplete$1.L$2;
                list = (List) downloadEsHelper$getListUnComplete$1.L$1;
                downloadEsHelper2 = (DownloadEsHelper) downloadEsHelper$getListUnComplete$1.L$0;
                ResultKt.b(objI);
            }
            while (it.hasNext()) {
                DownloadBean downloadBean = (DownloadBean) it.next();
                ConcurrentHashMap<String, DownloadBean> concurrentHashMap = downloadEsHelper2.f60996a;
                String resourceId = downloadBean.getResourceId();
                if (resourceId == null) {
                    resourceId = downloadBean.getUrl();
                }
                if (concurrentHashMap.containsKey(resourceId)) {
                    ConcurrentHashMap<String, DownloadBean> concurrentHashMap2 = downloadEsHelper2.f60996a;
                    String resourceId2 = downloadBean.getResourceId();
                    if (resourceId2 == null) {
                        resourceId2 = downloadBean.getUrl();
                    }
                    DownloadBean downloadBean2 = concurrentHashMap2.get(resourceId2);
                    Intrinsics.d(downloadBean2);
                    list.add(downloadBean2);
                } else {
                    if (downloadBean.isShotTV()) {
                        downloadEsHelper2.f60999d.put(downloadBean.getSubjectId() + downloadBean.getEp(), downloadBean);
                    }
                    String subjectId = downloadBean.getSubjectId();
                    if (subjectId != null) {
                        downloadEsHelper2.L(subjectId, downloadBean);
                    }
                    ConcurrentHashMap<String, DownloadBean> concurrentHashMap3 = downloadEsHelper2.f60996a;
                    String resourceId3 = downloadBean.getResourceId();
                    if (resourceId3 == null) {
                        resourceId3 = downloadBean.getUrl();
                    }
                    concurrentHashMap3.put(resourceId3, downloadBean);
                    list.add(downloadBean);
                }
                downloadEsHelper$getListUnComplete$1.L$0 = downloadEsHelper2;
                downloadEsHelper$getListUnComplete$1.L$1 = list;
                downloadEsHelper$getListUnComplete$1.L$2 = it;
                downloadEsHelper$getListUnComplete$1.label = 2;
                if (downloadEsHelper2.f(downloadBean, downloadEsHelper$getListUnComplete$1) == objE) {
                    return objE;
                }
            }
            return list;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return new ArrayList();
        }
    }

    public final Object y(Continuation<? super DownloadBean> continuation) {
        tr.c cVarM = m();
        if (cVarM != null) {
            return cVarM.y(continuation);
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:29:0x006f  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object z(String str, boolean z11, Continuation<? super DownloadBean> continuation) throws Throwable {
        DownloadEsHelper$getOutsideVideoHistoricalPlayRecord$3 downloadEsHelper$getOutsideVideoHistoricalPlayRecord$3;
        DownloadBean downloadBean;
        DownloadEsHelper downloadEsHelper;
        if (continuation instanceof DownloadEsHelper$getOutsideVideoHistoricalPlayRecord$3) {
            downloadEsHelper$getOutsideVideoHistoricalPlayRecord$3 = (DownloadEsHelper$getOutsideVideoHistoricalPlayRecord$3) continuation;
            int i11 = downloadEsHelper$getOutsideVideoHistoricalPlayRecord$3.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                downloadEsHelper$getOutsideVideoHistoricalPlayRecord$3.label = i11 - Integer.MIN_VALUE;
            } else {
                downloadEsHelper$getOutsideVideoHistoricalPlayRecord$3 = new DownloadEsHelper$getOutsideVideoHistoricalPlayRecord$3(this, continuation);
            }
        } else {
            downloadEsHelper$getOutsideVideoHistoricalPlayRecord$3 = new DownloadEsHelper$getOutsideVideoHistoricalPlayRecord$3(this, continuation);
        }
        Object objB = downloadEsHelper$getOutsideVideoHistoricalPlayRecord$3.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = downloadEsHelper$getOutsideVideoHistoricalPlayRecord$3.label;
        if (i12 == 0) {
            ResultKt.b(objB);
            downloadBean = null;
            if (this.f61007l != null) {
                return null;
            }
            if (this.f60996a.containsKey(str) && !z11) {
                return this.f60996a.get(str);
            }
            tr.c cVarM = m();
            if (cVarM != null) {
                downloadEsHelper$getOutsideVideoHistoricalPlayRecord$3.L$0 = this;
                downloadEsHelper$getOutsideVideoHistoricalPlayRecord$3.L$1 = str;
                downloadEsHelper$getOutsideVideoHistoricalPlayRecord$3.label = 1;
                objB = cVarM.B(str, downloadEsHelper$getOutsideVideoHistoricalPlayRecord$3);
                if (objB == objE) {
                    return objE;
                }
                downloadEsHelper = this;
            } else {
                downloadEsHelper = this;
            }
            if (downloadBean != null) {
                downloadEsHelper.f60996a.put(str, downloadBean);
            }
            return downloadBean;
        }
        if (i12 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        str = (String) downloadEsHelper$getOutsideVideoHistoricalPlayRecord$3.L$1;
        downloadEsHelper = (DownloadEsHelper) downloadEsHelper$getOutsideVideoHistoricalPlayRecord$3.L$0;
        ResultKt.b(objB);
        downloadBean = (DownloadBean) objB;
        if (downloadBean != null) {
            downloadEsHelper.f60996a.put(str, downloadBean);
        }
        return downloadBean;
    }
}
