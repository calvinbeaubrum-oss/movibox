package com.transsnet.downloader.viewmodel;

import androidx.lifecycle.c0;
import androidx.lifecycle.t0;
import androidx.lifecycle.u0;
import com.blankj.utilcode.util.Utils;
import com.tn.lib.net.bean.BaseDto;
import com.tn.lib.net.manager.NetServiceGenerator;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.transfer.impl.entity.FileData;
import com.transsnet.downloader.R$string;
import com.transsnet.downloader.bean.MovieRecBean;
import com.transsnet.downloader.widget.TransferBottomToolsView;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.j;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class DownloadViewModel extends t0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f61236d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f61233a = DownloadViewModel.class.getSimpleName();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f61234b = LazyKt__LazyJVMKt.b(new Function0<i00.a>() { // from class: com.transsnet.downloader.viewmodel.DownloadViewModel$service$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final i00.a invoke() {
            return (i00.a) NetServiceGenerator.f49399d.a().i(i00.a.class);
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f61235c = LazyKt__LazyJVMKt.b(new Function0<c0<BaseDto<MovieRecBean>>>() { // from class: com.transsnet.downloader.viewmodel.DownloadViewModel$movieRecLiveData$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final c0<BaseDto<MovieRecBean>> invoke() {
            return new c0<>();
        }
    });

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f61237f = LazyKt__LazyJVMKt.b(new Function0<c0<List<String>>>() { // from class: com.transsnet.downloader.viewmodel.DownloadViewModel$downloadTabsLiveData$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final c0<List<String>> invoke() {
            return new c0<>();
        }
    });

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f61238g = LazyKt__LazyJVMKt.b(new Function0<c0<List<String>>>() { // from class: com.transsnet.downloader.viewmodel.DownloadViewModel$transferTabsLiveData$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final c0<List<String>> invoke() {
            return new c0<>();
        }
    });

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f61239h = LazyKt__LazyJVMKt.b(new Function0<c0<Integer>>() { // from class: com.transsnet.downloader.viewmodel.DownloadViewModel$downloadMainTabAutoChangeLiveData$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final c0<Integer> invoke() {
            return new c0<>();
        }
    });

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f61240i = LazyKt__LazyJVMKt.b(new Function0<c0<Integer>>() { // from class: com.transsnet.downloader.viewmodel.DownloadViewModel$transferTabAutoChangeLiveData$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final c0<Integer> invoke() {
            return new c0<>();
        }
    });

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f61241j = LazyKt__LazyJVMKt.b(new Function0<c0<Integer>>() { // from class: com.transsnet.downloader.viewmodel.DownloadViewModel$transferTabChangeLiveData$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final c0<Integer> invoke() {
            return new c0<>();
        }
    });

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f61242k = LazyKt__LazyJVMKt.b(new Function0<c0<Integer>>() { // from class: com.transsnet.downloader.viewmodel.DownloadViewModel$transferSelectedSizeLiveData$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final c0<Integer> invoke() {
            return new c0<>();
        }
    });

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f61243l = LazyKt__LazyJVMKt.b(new Function0<c0<String>>() { // from class: com.transsnet.downloader.viewmodel.DownloadViewModel$transferBottomStatusChangeLiveData$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final c0<String> invoke() {
            return new c0<>();
        }
    });

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f61244m = LazyKt__LazyJVMKt.b(new Function0<c0<Boolean>>() { // from class: com.transsnet.downloader.viewmodel.DownloadViewModel$transferSelectRemoveListCheckedLiveData$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final c0<Boolean> invoke() {
            return new c0<>();
        }
    });

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Map<Integer, c0<List<DownloadBean>>> f61245n = new LinkedHashMap();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final c0<List<DownloadBean>> f61246o = new c0<>();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final c0<List<DownloadBean>> f61247p = new c0<>();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final c0<List<DownloadBean>> f61248q = new c0<>();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f61249r = LazyKt__LazyJVMKt.b(new Function0<c0<DownloadBean>>() { // from class: com.transsnet.downloader.viewmodel.DownloadViewModel$transferCurSeriesLiveData$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final c0<DownloadBean> invoke() {
            return new c0<>();
        }
    });

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Lazy f61250s = LazyKt__LazyJVMKt.b(new Function0<c0<Boolean>>() { // from class: com.transsnet.downloader.viewmodel.DownloadViewModel$transferCurSeriesShowLiveData$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final c0<Boolean> invoke() {
            return new c0<>();
        }
    });

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Lazy f61251t = LazyKt__LazyJVMKt.b(new Function0<c0<DownloadBean>>() { // from class: com.transsnet.downloader.viewmodel.DownloadViewModel$transferSeriesCollectionRefreshLiveData$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final c0<DownloadBean> invoke() {
            return new c0<>();
        }
    });

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Lazy f61252u = LazyKt__LazyJVMKt.b(new Function0<c0<Boolean>>() { // from class: com.transsnet.downloader.viewmodel.DownloadViewModel$transferHaveFinishLiveData$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final c0<Boolean> invoke() {
            return new c0<>();
        }
    });

    public static /* synthetic */ void n(DownloadViewModel downloadViewModel, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = false;
        }
        downloadViewModel.m(z11);
    }

    public final c0<Boolean> A() {
        return (c0) this.f61244m.getValue();
    }

    public final c0<List<DownloadBean>> B(int i11) {
        if (this.f61245n.containsKey(Integer.valueOf(i11))) {
            return this.f61245n.get(Integer.valueOf(i11));
        }
        c0<List<DownloadBean>> c0Var = new c0<>();
        this.f61245n.put(Integer.valueOf(i11), c0Var);
        return c0Var;
    }

    public final Map<Integer, c0<List<DownloadBean>>> C() {
        return this.f61245n;
    }

    public final c0<Integer> D() {
        return (c0) this.f61242k.getValue();
    }

    public final c0<DownloadBean> E() {
        return (c0) this.f61251t.getValue();
    }

    public final c0<Integer> F() {
        return (c0) this.f61240i.getValue();
    }

    public final c0<Integer> G() {
        return (c0) this.f61241j.getValue();
    }

    public final c0<List<String>> H() {
        return (c0) this.f61238g.getValue();
    }

    public final DownloadBean I(List<? extends DownloadBean> list) {
        DownloadBean downloadBean = (DownloadBean) CollectionsKt___CollectionsKt.e0(list);
        DownloadBean downloadBean2 = new DownloadBean("series", "series", "", downloadBean.getCover(), 0L, null, null, null, null, downloadBean.getUpdateTimeStamp(), 0L, 0, 0, 0, 0L, downloadBean.getCreateAt(), 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, 0L, 0, 0, null, null, 0L, null, null, 0L, 0, 0L, null, 0, null, null, false, false, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, -33312, 1073741823, null);
        downloadBean2.setStatus(10);
        downloadBean2.getSeriesList().addAll(list);
        boolean z11 = false;
        DownloadBean downloadBean3 = downloadBean;
        long jLongValue = 0;
        long jLongValue2 = 0;
        long readProgress = 0;
        int i11 = 0;
        boolean z12 = false;
        for (DownloadBean downloadBean4 : list) {
            if (downloadBean4.getStatus() == 14) {
                i11 = 1;
            } else {
                if (downloadBean4.isTransferFailed()) {
                    z11 = true;
                }
                if (!z12 && !downloadBean4.isTransferFailed() && downloadBean4.isFileExist()) {
                    downloadBean3 = downloadBean4;
                    z12 = true;
                }
                Long size = downloadBean4.getSize();
                jLongValue += size != null ? size.longValue() : 0L;
                Long duration = downloadBean4.getDuration();
                jLongValue2 += duration != null ? duration.longValue() : 0L;
                readProgress += downloadBean4.getReadProgress();
            }
        }
        downloadBean2.setTransferFailed(z11);
        downloadBean2.setThumbnail(downloadBean.getThumbnail());
        downloadBean2.setCount(list.size() - i11);
        downloadBean2.setSize(Long.valueOf(jLongValue));
        downloadBean2.setDuration(Long.valueOf(jLongValue2));
        downloadBean2.setOps(downloadBean.getOps());
        downloadBean2.setTotalEpisode(downloadBean.getTotalEpisode());
        downloadBean2.setSubjectId(downloadBean.getSubjectId());
        downloadBean2.setSubjectName(downloadBean.getSubjectName());
        downloadBean2.setReadProgress(readProgress);
        downloadBean2.setRootPath(downloadBean3.getRootPath());
        downloadBean2.setRootPathType(downloadBean3.getRootPathType());
        downloadBean2.setType(downloadBean.getType());
        downloadBean2.setSubjectType(downloadBean.getSubjectType());
        return downloadBean2;
    }

    public final void J(List<DownloadBean> list) {
        DownloadBean downloadBean;
        List<DownloadBean> list2 = list;
        if (list2 == null || list2.isEmpty() || (downloadBean = (DownloadBean) CollectionsKt___CollectionsKt.g0(list)) == null || downloadBean.getTotalEpisode() <= list.size()) {
            return;
        }
        DownloadBean downloadBean2 = new DownloadBean("allEp", "allEp", downloadBean.getType() == 1 ? Utils.a().getResources().getString(R$string.download_series_all_chapters) : Utils.a().getResources().getString(R$string.download_series_all_episodes), "", 0L, null, null, null, null, null, 0L, 0, 0, 0, 0L, 0L, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, 0L, 0, 0, null, null, 0L, null, null, 0L, 0, 0L, null, 0, null, null, false, false, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, -32, 1073741823, null);
        downloadBean2.setStatus(14);
        list.add(downloadBean2);
    }

    public final void K(FileData data, Function0<Unit> callback) {
        Intrinsics.g(data, "data");
        Intrinsics.g(callback, "callback");
        uo.b.f78622a.n(TransferBottomToolsView.TAG, new String[]{"传输完成，保存到数据库, data:" + data}, true);
        if (data.getDownloadBean() != null) {
            DownloadBean downloadBean = data.getDownloadBean();
            Intrinsics.d(downloadBean);
            downloadBean.setFileType(3);
            downloadBean.setCreateAt(System.currentTimeMillis());
            downloadBean.setUpdateTimeStamp(Long.valueOf(System.currentTimeMillis()));
            downloadBean.setCover(data.getCoverFile().getAbsolutePath());
            downloadBean.setPath(data.getFileReceiveCachePath());
            downloadBean.setProgress(0L);
            j.d(u0.a(this), w0.b(), null, new DownloadViewModel$saveTransferData2DB$1$1(downloadBean, callback, null), 2, null);
            return;
        }
        String absolutePath = data.getCoverFile().getAbsolutePath();
        j.d(u0.a(this), w0.b(), null, new DownloadViewModel$saveTransferData2DB$2$1(new DownloadBean(data.getFileReceiveCachePath(), String.valueOf(data.getFileReceiveCachePath().hashCode()), data.getFileName(), absolutePath, Long.valueOf(data.getFileSize()), null, null, data.getFileReceiveCachePath(), null, Long.valueOf(System.currentTimeMillis()), 0L, 0, 0, 0, 0L, 0L, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, 0L, 0, 0, null, null, 0L, null, null, 0L, 0, 0L, null, 0, null, null, false, false, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, -1696, 1073741823, null), callback, null), 2, null);
    }

    public final void j() {
        n(this, false, 1, null);
        p();
    }

    public final c0<Integer> k() {
        return (c0) this.f61239h.getValue();
    }

    public final c0<List<String>> l() {
        return (c0) this.f61237f.getValue();
    }

    public final void m(boolean z11) {
        j.d(u0.a(this), w0.b(), null, new DownloadViewModel$getDownloadedList$1(z11, this, null), 2, null);
    }

    public final c0<List<DownloadBean>> o() {
        return this.f61247p;
    }

    public final void p() {
        j.d(u0.a(this), w0.b(), null, new DownloadViewModel$getDownloadingList$1(this, null), 2, null);
    }

    public final c0<List<DownloadBean>> q() {
        return this.f61246o;
    }

    public final void r(int i11, int i12) {
        if (this.f61236d) {
            return;
        }
        j.d(u0.a(this), w0.b(), null, new DownloadViewModel$getMovieRec$1(this, i11, i12, null), 2, null);
    }

    public final c0<BaseDto<MovieRecBean>> s() {
        return (c0) this.f61235c.getValue();
    }

    public final void t(String str) {
        j.d(u0.a(this), w0.b(), null, new DownloadViewModel$getSeriesList$1(str, this, null), 2, null);
    }

    public final c0<List<DownloadBean>> u() {
        return this.f61248q;
    }

    public final i00.a v() {
        return (i00.a) this.f61234b.getValue();
    }

    public final c0<String> w() {
        return (c0) this.f61243l.getValue();
    }

    public final c0<DownloadBean> x() {
        return (c0) this.f61249r.getValue();
    }

    public final c0<Boolean> y() {
        return (c0) this.f61250s.getValue();
    }

    public final c0<Boolean> z() {
        return (c0) this.f61252u.getValue();
    }
}
