package com.transsnet.downloader.viewmodel;

import android.app.Application;
import android.text.TextUtils;
import androidx.lifecycle.c0;
import com.blankj.utilcode.util.m;
import com.tn.lib.net.manager.NetServiceGenerator;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.report.launch.RoomAppMMKV;
import com.transsnet.downloader.DownloadManagerApi;
import com.transsnet.downloader.bean.DownloadListBean;
import com.transsnet.downloader.bean.DownloadUrlBean;
import com.transsnet.downloader.manager.DownloadEsHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.g;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
@Metadata
@SourceDebugExtension
public final class DownloadListManager {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final a f61186m = new a(null);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Lazy<DownloadListManager> f61187n = LazyKt__LazyJVMKt.a(LazyThreadSafetyMode.SYNCHRONIZED, new Function0<DownloadListManager>() { // from class: com.transsnet.downloader.viewmodel.DownloadListManager$Companion$instance$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final DownloadListManager invoke() {
            return new DownloadListManager();
        }
    });

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public c0<List<DownloadBean>> f61194g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public c0<DownloadBean> f61195h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public c0<DownloadUrlBean> f61197j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f61188a = LazyKt__LazyJVMKt.b(new Function0<i00.a>() { // from class: com.transsnet.downloader.viewmodel.DownloadListManager$service$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final i00.a invoke() {
            return (i00.a) NetServiceGenerator.f49399d.a().i(i00.a.class);
        }
    });

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f61189b = LazyKt__LazyJVMKt.b(new Function0<tr.c>() { // from class: com.transsnet.downloader.viewmodel.DownloadListManager$downloadDao$2
        @Override // kotlin.jvm.functions.Function0
        public final tr.c invoke() {
            Application applicationA = com.tn.lib.util.a.f49452a.a();
            if (applicationA != null) {
                return AppDatabase.f51036p.b(applicationA).E0();
            }
            return null;
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f61190c = LazyKt__LazyJVMKt.b(new Function0<c0<List<DownloadBean>>>() { // from class: com.transsnet.downloader.viewmodel.DownloadListManager$downloadListLiveData$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final c0<List<DownloadBean>> invoke() {
            return new c0<>();
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f61191d = LazyKt__LazyJVMKt.b(new Function0<c0<List<DownloadBean>>>() { // from class: com.transsnet.downloader.viewmodel.DownloadListManager$downloadedListLiveData$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final c0<List<DownloadBean>> invoke() {
            return new c0<>();
        }
    });

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f61192e = LazyKt__LazyJVMKt.b(new Function0<c0<List<DownloadBean>>>() { // from class: com.transsnet.downloader.viewmodel.DownloadListManager$downloadingListLiveData$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final c0<List<DownloadBean>> invoke() {
            return new c0<>();
        }
    });

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f61193f = LazyKt__LazyJVMKt.b(new Function0<c0<DownloadBean>>() { // from class: com.transsnet.downloader.viewmodel.DownloadListManager$seriesListLiveData$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final c0<DownloadBean> invoke() {
            return new c0<>();
        }
    });

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ConcurrentHashMap<Integer, c0<DownloadListBean>> f61196i = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f61198k = true;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Map<String, Integer> f61199l = new LinkedHashMap();

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DownloadListManager a() {
            return (DownloadListManager) DownloadListManager.f61187n.getValue();
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    @Metadata
    public static final class b extends zo.a<DownloadUrlBean> {
        public b() {
        }

        @Override // zo.a
        public void a(String str, String str2) {
            uo.b.a.f(uo.b.f78622a, "downloadAna", "url download, get config failure, liveData is null = " + (DownloadListManager.this.F() == null), false, 4, null);
            c0<DownloadUrlBean> c0VarF = DownloadListManager.this.F();
            if (c0VarF != null) {
                c0VarF.n(null);
            }
        }

        @Override // zo.a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(DownloadUrlBean downloadUrlBean) {
            uo.b.a.s(uo.b.f78622a, "downloadAna", "url download, get config success, liveData is null = " + (DownloadListManager.this.F() == null), false, 4, null);
            c0<DownloadUrlBean> c0VarF = DownloadListManager.this.F();
            if (c0VarF != null) {
                c0VarF.n(downloadUrlBean);
            }
        }
    }

    public static /* synthetic */ void C(DownloadListManager downloadListManager, String str, int i11, int i12, String str2, int i13, int i14, Object obj) {
        int i15 = (i14 & 2) != 0 ? 1 : i11;
        int i16 = (i14 & 4) != 0 ? 20 : i12;
        if ((i14 & 8) != 0) {
            str2 = "";
        }
        String str3 = str2;
        if ((i14 & 16) != 0) {
            i13 = RoomAppMMKV.f51271a.a().getInt("download_last_resolution", 0);
        }
        downloadListManager.B(str, i15, i16, str3, i13);
    }

    public static /* synthetic */ void x(DownloadListManager downloadListManager, boolean z11, boolean z12, com.transsion.ad.bidding.nativead.c cVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = true;
        }
        if ((i11 & 2) != 0) {
            z12 = false;
        }
        if ((i11 & 4) != 0) {
            cVar = null;
        }
        downloadListManager.w(z11, z12, cVar);
    }

    public final i00.a A() {
        return (i00.a) this.f61188a.getValue();
    }

    public final void B(String str, int i11, int i12, String str2, int i13) {
        j.d(l0.a(w0.b()), null, null, new DownloadListManager$getShortTVList$1(i13, this, str, i11, i12, str2, null), 3, null);
    }

    public final Object D(Continuation<? super List<? extends DownloadBean>> continuation) {
        return DownloadEsHelper.f60994m.a().H(continuation);
    }

    public final void E(String str, String linkUrl) {
        Intrinsics.g(linkUrl, "linkUrl");
        if (this.f61197j == null) {
            this.f61197j = new c0<>();
        }
        A().e(cp.a.f62775a.a(), linkUrl, str).e(zo.d.f82109a.c()).subscribe(new b());
    }

    public final c0<DownloadUrlBean> F() {
        return this.f61197j;
    }

    public final List<DownloadBean> G(List<? extends DownloadBean> list) {
        int i11;
        int i12;
        Iterator it;
        ArrayList arrayList = new ArrayList();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<T> it2 = list.iterator();
        while (true) {
            i11 = 0;
            i12 = 1;
            if (!it2.hasNext()) {
                break;
            }
            DownloadBean downloadBean = (DownloadBean) it2.next();
            if (linkedHashMap.containsKey(downloadBean.getSubjectId())) {
                if (downloadBean.isVideo() && Intrinsics.b(downloadBean.getResourceId(), downloadBean.getUrl())) {
                    arrayList.add(downloadBean);
                } else {
                    List list2 = (List) linkedHashMap.get(downloadBean.getSubjectId());
                    if (list2 != null) {
                        list2.add(downloadBean);
                    }
                }
            } else if (downloadBean.getSubjectId() != null) {
                String subjectId = downloadBean.getSubjectId();
                Intrinsics.d(subjectId);
                linkedHashMap.put(subjectId, g.q(downloadBean));
            } else {
                arrayList.add(downloadBean);
            }
        }
        Iterator it3 = linkedHashMap.entrySet().iterator();
        while (it3.hasNext()) {
            Map.Entry entry = (Map.Entry) it3.next();
            if (((List) entry.getValue()).size() == i12) {
                arrayList.add(((List) entry.getValue()).get(i11));
            } else {
                if (((List) entry.getValue()).size() > i12) {
                    DownloadBean downloadBean2 = (DownloadBean) ((List) entry.getValue()).get(i11);
                    DownloadBean downloadBean3 = new DownloadBean("series", "series", "", downloadBean2.getCover(), 0L, null, null, null, null, downloadBean2.getUpdateTimeStamp(), 0L, 0, 0, 0, 0L, downloadBean2.getCreateAt(), 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, 0L, 0, 0, null, null, 0L, null, null, 0L, 0, 0L, null, 0, null, null, false, false, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, -33312, 1073741823, null);
                    downloadBean3.setStatus(10);
                    List list3 = (List) entry.getValue();
                    if (list3.size() > i12) {
                        kotlin.collections.j.z(list3, new Comparator() { // from class: com.transsnet.downloader.viewmodel.DownloadListManager$handleDownloaded$lambda$6$$inlined$sortBy$1
                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // java.util.Comparator
                            public final int compare(T t11, T t12) {
                                return kotlin.comparisons.b.d(Integer.valueOf(((DownloadBean) t11).getEpse()), Integer.valueOf(((DownloadBean) t12).getEpse()));
                            }
                        });
                    }
                    downloadBean3.getSeriesList().addAll((Collection) entry.getValue());
                    DownloadBean downloadBean4 = downloadBean2;
                    long jLongValue = 0;
                    long jLongValue2 = 0;
                    long readProgress = 0;
                    boolean z11 = false;
                    int i13 = 0;
                    boolean z12 = false;
                    for (DownloadBean downloadBean5 : (List) entry.getValue()) {
                        it3 = it3;
                        if (downloadBean5.getStatus() == 14) {
                            i13 = 1;
                        } else {
                            if (downloadBean5.isTransferFailed()) {
                                z11 = true;
                            }
                            if (!z12 && !downloadBean5.isTransferFailed() && downloadBean5.isFileExist()) {
                                downloadBean4 = downloadBean5;
                                z12 = true;
                            }
                            Long size = downloadBean5.getSize();
                            jLongValue += size != null ? size.longValue() : 0L;
                            Long duration = downloadBean5.getDuration();
                            jLongValue2 += duration != null ? duration.longValue() : 0L;
                            readProgress += downloadBean5.getReadProgress();
                        }
                    }
                    it = it3;
                    downloadBean3.setTransferFailed(z11);
                    downloadBean3.setThumbnail(downloadBean2.getThumbnail());
                    downloadBean3.setCount(((List) entry.getValue()).size() - i13);
                    downloadBean3.setSize(Long.valueOf(jLongValue));
                    downloadBean3.setDuration(Long.valueOf(jLongValue2));
                    downloadBean3.setOps(downloadBean2.getOps());
                    downloadBean3.setTotalEpisode(downloadBean2.getTotalEpisode());
                    downloadBean3.setSubjectId(downloadBean2.getSubjectId());
                    downloadBean3.setSubjectName(downloadBean2.getSubjectName());
                    downloadBean3.setReadProgress(readProgress);
                    downloadBean3.setRootPath(downloadBean4.getRootPath());
                    downloadBean3.setRootPathType(downloadBean4.getRootPathType());
                    downloadBean3.setType(downloadBean2.getType());
                    downloadBean3.setSubjectType(downloadBean2.getSubjectType());
                    O(downloadBean3);
                    arrayList.add(downloadBean3);
                }
                it3 = it;
                i11 = 0;
                i12 = 1;
            }
            it = it3;
            it3 = it;
            i11 = 0;
            i12 = 1;
        }
        if (arrayList.size() > 1) {
            kotlin.collections.j.z(arrayList, new Comparator() { // from class: com.transsnet.downloader.viewmodel.DownloadListManager$handleDownloaded$$inlined$sortByDescending$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t11, T t12) {
                    return kotlin.comparisons.b.d(Long.valueOf(((DownloadBean) t12).getCreateAt()), Long.valueOf(((DownloadBean) t11).getCreateAt()));
                }
            });
        }
        return arrayList;
    }

    public final void H(List<DownloadBean> list) {
        if (this.f61199l == null) {
            this.f61199l = new LinkedHashMap();
        }
        this.f61199l.clear();
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            String resourceId = list.get(i11).getResourceId();
            if (resourceId != null && resourceId.length() > 0) {
                this.f61199l.put(resourceId, Integer.valueOf(i11));
            }
        }
    }

    public final void I(List<DownloadBean> list, com.transsion.ad.bidding.nativead.c cVar) {
        Object objM163constructorimpl;
        Object objValueOf;
        if (cVar == null) {
            return;
        }
        try {
            Result.Companion companion = Result.Companion;
            DownloadBean downloadBean = new DownloadBean("ad", "ad", "ad", "", 0L, null, null, null, null, null, 0L, 0, 0, 0, 0L, 0L, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, 0L, 0, 0, null, null, 0L, null, null, 0L, 0, 0L, null, 0, null, null, false, false, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, -32, 1073741823, null);
            downloadBean.setStatus(13);
            downloadBean.setWrapNativeManager(cVar);
            if (!cVar.r0()) {
                return;
            }
            if (2 >= list.size()) {
                objValueOf = Boolean.valueOf(list.add(downloadBean));
            } else {
                list.add(2, downloadBean);
                objValueOf = Unit.f68710a;
            }
            objM163constructorimpl = Result.m163constructorimpl(objValueOf);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        if (Result.m166exceptionOrNullimpl(objM163constructorimpl) == null) {
            return;
        }
        com.transsion.ad.a.j(com.transsion.ad.a.f50276a, "An exception occurred when the ad was inserted into the list", false, 2, null);
    }

    public final boolean J() {
        return this.f61198k;
    }

    public final void K(c0<List<DownloadBean>> c0Var) {
        this.f61194g = c0Var;
    }

    public final void L(c0<DownloadBean> c0Var) {
        this.f61195h = c0Var;
    }

    public final void M(boolean z11) {
        this.f61198k = z11;
    }

    public final void N(c0<DownloadUrlBean> c0Var) {
        this.f61197j = c0Var;
    }

    public final void O(DownloadBean downloadBean) {
        if (z().f() == null) {
            return;
        }
        DownloadBean downloadBeanF = z().f();
        if (Intrinsics.b(downloadBeanF != null ? downloadBeanF.getSubjectId() : null, downloadBean.getSubjectId())) {
            z().n(downloadBean);
        }
    }

    public final void i(DownloadBean downloadBean) {
        Intrinsics.g(downloadBean, "downloadBean");
        if (this.f61195h == null) {
            this.f61195h = new c0<>();
        }
        c0<DownloadBean> c0Var = this.f61195h;
        if (c0Var == null) {
            return;
        }
        c0Var.q(downloadBean);
    }

    public final void j(List<? extends DownloadBean> list) throws InterruptedException {
        if (list != null) {
            for (DownloadBean downloadBean : list) {
                if (!TextUtils.isEmpty(downloadBean.getSubjectId()) && !TextUtils.isEmpty(downloadBean.getResourceId()) && !downloadBean.isShotTV()) {
                    DownloadManagerApi.f60274j.a().V1(downloadBean.getSubjectId(), downloadBean.getResourceId(), downloadBean.isSeries(), downloadBean.getTotalEpisode(), false, downloadBean.getResolution() > 0);
                }
            }
        }
    }

    public final void k(int i11) {
        if (this.f61196i.containsKey(Integer.valueOf(i11))) {
            return;
        }
        this.f61196i.put(Integer.valueOf(i11), new c0<>());
    }

    public final void l(List<DownloadBean> list) {
        if (!list.isEmpty()) {
            return;
        }
        try {
            m.c(DownloadEsHelper.f60994m.a().n());
        } catch (Throwable unused) {
        }
    }

    public final Object m(List<? extends DownloadBean> list, Continuation<? super List<DownloadBean>> continuation) {
        ArrayList arrayList = new ArrayList();
        if (list != null && (!list.isEmpty())) {
            arrayList.addAll(G(list));
        }
        uo.b.a.f(uo.b.f78622a, "DownloadPanel", "2-  get getDownloadedList success = " + arrayList.size(), false, 4, null);
        return arrayList;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object n(Continuation<? super List<DownloadBean>> continuation) throws Throwable {
        DownloadListManager$downloadingList$1 downloadListManager$downloadingList$1;
        if (continuation instanceof DownloadListManager$downloadingList$1) {
            downloadListManager$downloadingList$1 = (DownloadListManager$downloadingList$1) continuation;
            int i11 = downloadListManager$downloadingList$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                downloadListManager$downloadingList$1.label = i11 - Integer.MIN_VALUE;
            } else {
                downloadListManager$downloadingList$1 = new DownloadListManager$downloadingList$1(this, continuation);
            }
        } else {
            downloadListManager$downloadingList$1 = new DownloadListManager$downloadingList$1(this, continuation);
        }
        Object objX = downloadListManager$downloadingList$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = downloadListManager$downloadingList$1.label;
        if (i12 == 0) {
            ResultKt.b(objX);
            DownloadEsHelper downloadEsHelperA = DownloadEsHelper.f60994m.a();
            downloadListManager$downloadingList$1.label = 1;
            objX = downloadEsHelperA.x(downloadListManager$downloadingList$1);
            if (objX == objE) {
                return objE;
            }
        } else {
            if (i12 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(objX);
        }
        List list = (List) objX;
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            List list2 = list;
            if (!list2.isEmpty()) {
                int size = list.size();
                int i13 = 0;
                while (true) {
                    if (i13 >= size) {
                        i13 = -1;
                        break;
                    }
                    DownloadBean downloadBean = (DownloadBean) list.get(i13);
                    if (downloadBean.isDownloading() && !downloadBean.isPreDownload()) {
                        break;
                    }
                    i13++;
                }
                if (i13 > 0) {
                    Collections.swap(list, i13, 0);
                }
                arrayList.addAll(list2);
            }
        }
        uo.b.a.f(uo.b.f78622a, "DownloadPanel", "1 -- get getDownloadingList success = " + arrayList.size(), false, 4, null);
        return arrayList;
    }

    public final c0<List<DownloadBean>> o() {
        return this.f61194g;
    }

    public final ConcurrentHashMap<Integer, c0<DownloadListBean>> p() {
        return this.f61196i;
    }

    public final c0<List<DownloadBean>> q() {
        return (c0) this.f61190c.getValue();
    }

    public final Map<String, Integer> r() {
        return this.f61199l;
    }

    public final c0<DownloadBean> s() {
        return this.f61195h;
    }

    public final void t() {
        j.d(l0.a(w0.b()), null, null, new DownloadListManager$getDownloadedList$1(this, null), 3, null);
    }

    public final c0<List<DownloadBean>> u() {
        return (c0) this.f61191d.getValue();
    }

    public final c0<List<DownloadBean>> v() {
        return (c0) this.f61192e.getValue();
    }

    public final void w(boolean z11, boolean z12, com.transsion.ad.bidding.nativead.c cVar) {
        t();
        j.d(l0.a(w0.b()), null, null, new DownloadListManager$getList$1(z12, this, z11, cVar, null), 3, null);
    }

    public final Object y(int i11, Continuation<? super List<? extends DownloadBean>> continuation) {
        return DownloadEsHelper.f60994m.a().B(i11, continuation);
    }

    public final c0<DownloadBean> z() {
        return (c0) this.f61193f.getValue();
    }
}
