package com.transsnet.downloader.viewmodel;

import android.app.Application;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.c0;
import androidx.lifecycle.u0;
import com.alibaba.android.arouter.facade.Postcard;
import com.blankj.utilcode.util.Utils;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.audio.AudioBean;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.db.video.ShortTVPlayDao;
import com.transsion.baselib.db.video.VideoDetailPlayBean;
import com.transsion.baselib.db.video.VideoDetailPlayDao;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.room.api.IAudioApi;
import com.transsion.room.api.IFloatingApi;
import com.transsnet.downloader.DownloadManagerApi;
import com.transsnet.downloader.bean.HistoricalPlayRecordBean;
import com.transsnet.downloader.bean.HistoricalPlayRecordMultipleEntity;
import com.transsnet.downloader.manager.DownloadEsHelper;
import com.transsnet.downloader.util.DownloadUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.g;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.g1;
import kotlinx.coroutines.flow.v0;
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
@SourceDebugExtension
public final class HistoricalPlayRecordViewModel extends a {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f61264n;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c0<List<HistoricalPlayRecordMultipleEntity>> f61253b = new c0<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c0<List<HistoricalPlayRecordMultipleEntity>> f61254c = new c0<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f61255d = LazyKt__LazyJVMKt.b(new Function0<c0<List<HistoricalPlayRecordMultipleEntity>>>() { // from class: com.transsnet.downloader.viewmodel.HistoricalPlayRecordViewModel$transferReceivedVideoList$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final c0<List<HistoricalPlayRecordMultipleEntity>> invoke() {
            return new c0<>();
        }
    });

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c0<Map<String, List<HistoricalPlayRecordMultipleEntity>>> f61256f = new c0<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f61257g = LazyKt__LazyJVMKt.b(new Function0<v0<Integer>>() { // from class: com.transsnet.downloader.viewmodel.HistoricalPlayRecordViewModel$refreshFlow$2
        @Override // kotlin.jvm.functions.Function0
        public final v0<Integer> invoke() {
            return g1.a(-1);
        }
    });

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f61258h = LazyKt__LazyJVMKt.b(new Function0<rr.a>() { // from class: com.transsnet.downloader.viewmodel.HistoricalPlayRecordViewModel$audioDao$2
        @Override // kotlin.jvm.functions.Function0
        public final rr.a invoke() {
            Application applicationA = com.tn.lib.util.a.f49452a.a();
            if (applicationA != null) {
                return AppDatabase.f51036p.b(applicationA).D0();
            }
            return null;
        }
    });

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f61259i = LazyKt__LazyJVMKt.b(new Function0<ShortTVPlayDao>() { // from class: com.transsnet.downloader.viewmodel.HistoricalPlayRecordViewModel$shortTVPlayDao$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ShortTVPlayDao invoke() {
            AppDatabase.v0 v0Var = AppDatabase.f51036p;
            Application applicationA = Utils.a();
            Intrinsics.f(applicationA, "getApp()");
            return v0Var.b(applicationA).K0();
        }
    });

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f61260j = LazyKt__LazyJVMKt.b(new Function0<VideoDetailPlayDao>() { // from class: com.transsnet.downloader.viewmodel.HistoricalPlayRecordViewModel$videoDetailPlayDao$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final VideoDetailPlayDao invoke() {
            AppDatabase.v0 v0Var = AppDatabase.f51036p;
            Application applicationA = Utils.a();
            Intrinsics.f(applicationA, "getApp()");
            return v0Var.b(applicationA).O0();
        }
    });

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f61261k = LazyKt__LazyJVMKt.b(new Function0<IAudioApi>() { // from class: com.transsnet.downloader.viewmodel.HistoricalPlayRecordViewModel$mAudioApi$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final IAudioApi invoke() {
            return (IAudioApi) com.alibaba.android.arouter.launcher.a.d().h(IAudioApi.class);
        }
    });

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f61262l = LazyKt__LazyJVMKt.b(new Function0<IFloatingApi>() { // from class: com.transsnet.downloader.viewmodel.HistoricalPlayRecordViewModel$mFloatApi$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final IFloatingApi invoke() {
            return (IFloatingApi) com.alibaba.android.arouter.launcher.a.d().h(IFloatingApi.class);
        }
    });

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f61263m = "lastFormatTime";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f61265o = 10;

    /* JADX INFO: Access modifiers changed from: private */
    public final VideoDetailPlayDao G() {
        return (VideoDetailPlayDao) this.f61260j.getValue();
    }

    public static /* synthetic */ void I(HistoricalPlayRecordViewModel historicalPlayRecordViewModel, boolean z11, boolean z12, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = true;
        }
        if ((i11 & 2) != 0) {
            z12 = false;
        }
        historicalPlayRecordViewModel.H(z11, z12);
    }

    public static /* synthetic */ List o(HistoricalPlayRecordViewModel historicalPlayRecordViewModel, List list, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = true;
        }
        return historicalPlayRecordViewModel.n(list, z11);
    }

    public final void A() {
        j.d(u0.a(this), w0.b(), null, new HistoricalPlayRecordViewModel$getOutsideLocalFileList$1(this, null), 2, null);
    }

    /* JADX WARN: Code duplicated, block: B:23:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:25:0x00da  */
    /* JADX WARN: Code duplicated, block: B:28:0x00f2 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:29:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:32:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:39:0x0137 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:41:0x0143  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x010a -> B:36:0x0114). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0135 -> B:40:0x0138). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object B(java.util.List<com.transsnet.downloader.bean.HistoricalPlayRecordBean> r17, kotlin.coroutines.Continuation<? super kotlin.Unit> r18) {
        /*
            Method dump skipped, instruction units count: 356
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.viewmodel.HistoricalPlayRecordViewModel.B(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final v0<Integer> C() {
        return (v0) this.f61257g.getValue();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object D(List<HistoricalPlayRecordBean> list, Continuation<? super Unit> continuation) throws Throwable {
        HistoricalPlayRecordViewModel$getTransferReceivedVideoDataList$2 historicalPlayRecordViewModel$getTransferReceivedVideoDataList$2;
        List arrayList;
        Object objJ;
        HistoricalPlayRecordViewModel historicalPlayRecordViewModel;
        if (continuation instanceof HistoricalPlayRecordViewModel$getTransferReceivedVideoDataList$2) {
            historicalPlayRecordViewModel$getTransferReceivedVideoDataList$2 = (HistoricalPlayRecordViewModel$getTransferReceivedVideoDataList$2) continuation;
            int i11 = historicalPlayRecordViewModel$getTransferReceivedVideoDataList$2.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                historicalPlayRecordViewModel$getTransferReceivedVideoDataList$2.label = i11 - Integer.MIN_VALUE;
            } else {
                historicalPlayRecordViewModel$getTransferReceivedVideoDataList$2 = new HistoricalPlayRecordViewModel$getTransferReceivedVideoDataList$2(this, continuation);
            }
        } else {
            historicalPlayRecordViewModel$getTransferReceivedVideoDataList$2 = new HistoricalPlayRecordViewModel$getTransferReceivedVideoDataList$2(this, continuation);
        }
        Object obj = historicalPlayRecordViewModel$getTransferReceivedVideoDataList$2.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = historicalPlayRecordViewModel$getTransferReceivedVideoDataList$2.label;
        if (i12 == 0) {
            ResultKt.b(obj);
            arrayList = new ArrayList();
            DownloadEsHelper downloadEsHelperA = DownloadEsHelper.f60994m.a();
            historicalPlayRecordViewModel$getTransferReceivedVideoDataList$2.L$0 = this;
            historicalPlayRecordViewModel$getTransferReceivedVideoDataList$2.L$1 = list;
            historicalPlayRecordViewModel$getTransferReceivedVideoDataList$2.L$2 = arrayList;
            historicalPlayRecordViewModel$getTransferReceivedVideoDataList$2.label = 1;
            objJ = DownloadEsHelper.J(downloadEsHelperA, false, historicalPlayRecordViewModel$getTransferReceivedVideoDataList$2, 1, null);
            if (objJ == objE) {
                return objE;
            }
            historicalPlayRecordViewModel = this;
        } else {
            if (i12 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            List list2 = (List) historicalPlayRecordViewModel$getTransferReceivedVideoDataList$2.L$2;
            List<HistoricalPlayRecordBean> list3 = (List) historicalPlayRecordViewModel$getTransferReceivedVideoDataList$2.L$1;
            HistoricalPlayRecordViewModel historicalPlayRecordViewModel2 = (HistoricalPlayRecordViewModel) historicalPlayRecordViewModel$getTransferReceivedVideoDataList$2.L$0;
            ResultKt.b(obj);
            arrayList = list2;
            list = list3;
            historicalPlayRecordViewModel = historicalPlayRecordViewModel2;
            objJ = obj;
        }
        List list4 = (List) objJ;
        if (list4 != null) {
            Iterator it = list4.iterator();
            while (it.hasNext()) {
                arrayList.add(historicalPlayRecordViewModel.c((DownloadBean) it.next()));
            }
        }
        if (list != null) {
            Boxing.a(list.addAll(arrayList));
        }
        historicalPlayRecordViewModel.F().n(o(historicalPlayRecordViewModel, arrayList, false, 2, null));
        return Unit.f68710a;
    }

    public final void E() {
        j.d(u0.a(this), w0.b(), null, new HistoricalPlayRecordViewModel$getTransferReceivedVideoDataList$1(this, null), 2, null);
    }

    public final c0<List<HistoricalPlayRecordMultipleEntity>> F() {
        return (c0) this.f61255d.getValue();
    }

    public final void H(boolean z11, boolean z12) {
        j.d(u0.a(this), w0.b(), null, new HistoricalPlayRecordViewModel$getVideoPlayHistoricalList$1(z12, this, z11, null), 2, null);
    }

    public final void J() {
        j.d(u0.a(this), w0.b(), null, new HistoricalPlayRecordViewModel$loadVideoCover$1(this, null), 2, null);
    }

    public final Object K(HistoricalPlayRecordBean historicalPlayRecordBean, Continuation<? super Unit> continuation) {
        Object objR;
        Object objS;
        Object objT;
        int type = historicalPlayRecordBean.getType();
        if (type == 1) {
            AudioBean audio = historicalPlayRecordBean.getAudio();
            if (audio != null && (objR = r(audio, continuation)) == kotlin.coroutines.intrinsics.a.e()) {
                return objR;
            }
        } else if (type != 7) {
            DownloadBean video = historicalPlayRecordBean.getVideo();
            if (video != null && (objT = t(video, continuation)) == kotlin.coroutines.intrinsics.a.e()) {
                return objT;
            }
        } else {
            VideoDetailPlayBean streamVideo = historicalPlayRecordBean.getStreamVideo();
            if (streamVideo != null && (objS = s(streamVideo, continuation)) == kotlin.coroutines.intrinsics.a.e()) {
                return objS;
            }
        }
        return Unit.f68710a;
    }

    public final void L(HistoricalPlayRecordMultipleEntity historicalPlayRecordMultipleEntity, FragmentActivity fragmentActivity, String str) {
        HistoricalPlayRecordBean historical;
        if (historicalPlayRecordMultipleEntity == null || historicalPlayRecordMultipleEntity.getType() == 1 || (historical = historicalPlayRecordMultipleEntity.getHistorical()) == null) {
            return;
        }
        int type = historical.getType();
        if (type == 1) {
            M(historical, fragmentActivity);
            return;
        }
        if (type == 2 || type == 3 || type == 5) {
            P(historical, fragmentActivity, str);
        } else if (type == 6) {
            O(historical, fragmentActivity, str);
        } else {
            if (type != 7) {
                return;
            }
            N(historical.getStreamVideo(), fragmentActivity, str);
        }
    }

    public final void M(HistoricalPlayRecordBean historicalPlayRecordBean, FragmentActivity fragmentActivity) {
        IAudioApi iAudioApiX;
        AudioBean audio = historicalPlayRecordBean.getAudio();
        if (audio != null) {
            IAudioApi iAudioApiX2 = x();
            if (iAudioApiX2 != null && iAudioApiX2.D(audio) && (iAudioApiX = x()) != null && iAudioApiX.p1()) {
                IAudioApi iAudioApiX3 = x();
                if (iAudioApiX3 != null) {
                    iAudioApiX3.stop();
                    return;
                }
                return;
            }
            IAudioApi iAudioApiX4 = x();
            if (iAudioApiX4 != null) {
                IAudioApi.a.a(iAudioApiX4, audio, false, 2, null);
            }
            IFloatingApi iFloatingApiY = y();
            if (iFloatingApiY != null) {
                iFloatingApiY.y(new WeakReference<>(fragmentActivity), audio);
            }
        }
    }

    public final void N(VideoDetailPlayBean videoDetailPlayBean, FragmentActivity fragmentActivity, String str) {
        Integer subjectType;
        String downloadFilePath = videoDetailPlayBean != null ? videoDetailPlayBean.getDownloadFilePath() : null;
        boolean zR = c.f61276a.r(downloadFilePath);
        if (downloadFilePath == null || downloadFilePath.length() == 0 || !zR) {
            com.alibaba.android.arouter.launcher.a.d().b("/movie/detail").withInt("subject_type", (videoDetailPlayBean == null || (subjectType = videoDetailPlayBean.getSubjectType()) == null) ? SubjectType.MOVIE.getValue() : subjectType.intValue()).withString("id", videoDetailPlayBean != null ? videoDetailPlayBean.getSubjectId() : null).withString("module_name", HistoricalPlayRecordViewModel.class.getSimpleName()).navigation();
        } else if (fragmentActivity != null) {
            DownloadManagerApi.f60274j.a().j2(fragmentActivity, videoDetailPlayBean.getId(), str);
        }
    }

    public final void O(HistoricalPlayRecordBean historicalPlayRecordBean, FragmentActivity fragmentActivity, String str) {
        String subjectId;
        if (fragmentActivity != null) {
            Postcard postcardWithInt = com.alibaba.android.arouter.launcher.a.d().b("/movie/detail").withInt("subject_type", SubjectType.MUSIC.getValue());
            VideoDetailPlayBean streamVideo = historicalPlayRecordBean.getStreamVideo();
            if (streamVideo == null || (subjectId = streamVideo.getSubjectId()) == null) {
                DownloadBean video = historicalPlayRecordBean.getVideo();
                subjectId = video != null ? video.getSubjectId() : null;
            }
            postcardWithInt.withString("id", subjectId).navigation();
        }
    }

    public final void P(HistoricalPlayRecordBean historicalPlayRecordBean, FragmentActivity fragmentActivity, String str) {
        DownloadBean video = historicalPlayRecordBean.getVideo();
        if (video == null || fragmentActivity == null) {
            return;
        }
        if (video.isShotTV()) {
            com.alibaba.android.arouter.launcher.a.d().b("/shorts/detail").withSerializable("item_object", DownloadUtil.f61136a.p(video)).withInt("ep", video.getEp()).navigation();
        } else {
            DownloadManagerApi.f60274j.a().i2(fragmentActivity, video, str);
        }
    }

    public final void Q(int i11) {
        this.f61264n = i11;
    }

    public final List<HistoricalPlayRecordMultipleEntity> n(List<HistoricalPlayRecordBean> list, boolean z11) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(16, 0.75f, true);
        for (HistoricalPlayRecordBean historicalPlayRecordBean : list) {
            if (linkedHashMap.containsKey(historicalPlayRecordBean.getOriginalFormatTime())) {
                List list2 = (List) linkedHashMap.get(historicalPlayRecordBean.getOriginalFormatTime());
                if (list2 != null) {
                    list2.add(historicalPlayRecordBean);
                }
            } else {
                String originalFormatTime = historicalPlayRecordBean.getOriginalFormatTime();
                if (originalFormatTime == null) {
                    originalFormatTime = "";
                }
                linkedHashMap.put(originalFormatTime, g.q(historicalPlayRecordBean));
            }
        }
        ArrayList arrayList = new ArrayList();
        String formatTime = "lastFormatTime";
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            if (z11 && !TextUtils.equals(((HistoricalPlayRecordBean) ((List) entry.getValue()).get(0)).getFormatTime(), formatTime)) {
                formatTime = ((HistoricalPlayRecordBean) ((List) entry.getValue()).get(0)).getFormatTime();
                arrayList.add(new HistoricalPlayRecordMultipleEntity(1, null, ((HistoricalPlayRecordBean) ((List) entry.getValue()).get(0)).getFormatTime(), null));
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator it = ((Iterable) entry.getValue()).iterator();
            while (it.hasNext()) {
                arrayList2.add(new HistoricalPlayRecordMultipleEntity(2, (HistoricalPlayRecordBean) it.next(), ((HistoricalPlayRecordBean) ((List) entry.getValue()).get(0)).getFormatTime(), null));
            }
            arrayList.addAll(arrayList2);
        }
        return arrayList;
    }

    public final void p(HistoricalPlayRecordMultipleEntity historicalPlayRecordMultipleEntity, Function0<Unit> callback) {
        Intrinsics.g(callback, "callback");
        j.d(u0.a(this), null, null, new HistoricalPlayRecordViewModel$delete$2(historicalPlayRecordMultipleEntity, this, callback, null), 3, null);
    }

    public final void q(Function0<Unit> callback) {
        Intrinsics.g(callback, "callback");
        j.d(u0.a(this), null, null, new HistoricalPlayRecordViewModel$deleteAll$2(this, callback, null), 3, null);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object r(AudioBean audioBean, Continuation<? super Unit> continuation) throws Throwable {
        HistoricalPlayRecordViewModel$deleteAudioRecord$1 historicalPlayRecordViewModel$deleteAudioRecord$1;
        if (continuation instanceof HistoricalPlayRecordViewModel$deleteAudioRecord$1) {
            historicalPlayRecordViewModel$deleteAudioRecord$1 = (HistoricalPlayRecordViewModel$deleteAudioRecord$1) continuation;
            int i11 = historicalPlayRecordViewModel$deleteAudioRecord$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                historicalPlayRecordViewModel$deleteAudioRecord$1.label = i11 - Integer.MIN_VALUE;
            } else {
                historicalPlayRecordViewModel$deleteAudioRecord$1 = new HistoricalPlayRecordViewModel$deleteAudioRecord$1(this, continuation);
            }
        } else {
            historicalPlayRecordViewModel$deleteAudioRecord$1 = new HistoricalPlayRecordViewModel$deleteAudioRecord$1(this, continuation);
        }
        Object obj = historicalPlayRecordViewModel$deleteAudioRecord$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = historicalPlayRecordViewModel$deleteAudioRecord$1.label;
        if (i12 == 0) {
            ResultKt.b(obj);
            rr.a aVarU = u();
            if (aVarU != null) {
                historicalPlayRecordViewModel$deleteAudioRecord$1.L$0 = audioBean;
                historicalPlayRecordViewModel$deleteAudioRecord$1.label = 1;
                if (aVarU.b(audioBean, historicalPlayRecordViewModel$deleteAudioRecord$1) == objE) {
                    return objE;
                }
            }
        } else {
            if (i12 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            audioBean = (AudioBean) historicalPlayRecordViewModel$deleteAudioRecord$1.L$0;
            ResultKt.b(obj);
        }
        c.f61276a.x("delete --- " + audioBean.getTitle() + " ---audio recording");
        return Unit.f68710a;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x007b  */
    /* JADX WARN: Code duplicated, block: B:32:0x0093 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:34:? A[LOOP:0: B:24:0x0075->B:34:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object s(VideoDetailPlayBean videoDetailPlayBean, Continuation<? super Unit> continuation) throws Throwable {
        HistoricalPlayRecordViewModel$deleteStreamRecord$1 historicalPlayRecordViewModel$deleteStreamRecord$1;
        HistoricalPlayRecordViewModel historicalPlayRecordViewModel;
        HistoricalPlayRecordViewModel historicalPlayRecordViewModel2;
        VideoDetailPlayBean videoDetailPlayBean2;
        Iterator it;
        VideoDetailPlayBean videoDetailPlayBean3;
        VideoDetailPlayDao videoDetailPlayDaoG;
        if (continuation instanceof HistoricalPlayRecordViewModel$deleteStreamRecord$1) {
            historicalPlayRecordViewModel$deleteStreamRecord$1 = (HistoricalPlayRecordViewModel$deleteStreamRecord$1) continuation;
            int i11 = historicalPlayRecordViewModel$deleteStreamRecord$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                historicalPlayRecordViewModel$deleteStreamRecord$1.label = i11 - Integer.MIN_VALUE;
            } else {
                historicalPlayRecordViewModel$deleteStreamRecord$1 = new HistoricalPlayRecordViewModel$deleteStreamRecord$1(this, continuation);
            }
        } else {
            historicalPlayRecordViewModel$deleteStreamRecord$1 = new HistoricalPlayRecordViewModel$deleteStreamRecord$1(this, continuation);
        }
        Object objI = historicalPlayRecordViewModel$deleteStreamRecord$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = historicalPlayRecordViewModel$deleteStreamRecord$1.label;
        if (i12 != 0) {
            if (i12 == 1) {
                videoDetailPlayBean = (VideoDetailPlayBean) historicalPlayRecordViewModel$deleteStreamRecord$1.L$1;
                historicalPlayRecordViewModel = (HistoricalPlayRecordViewModel) historicalPlayRecordViewModel$deleteStreamRecord$1.L$0;
                ResultKt.b(objI);
            } else {
                if (i12 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                it = (Iterator) historicalPlayRecordViewModel$deleteStreamRecord$1.L$2;
                videoDetailPlayBean2 = (VideoDetailPlayBean) historicalPlayRecordViewModel$deleteStreamRecord$1.L$1;
                historicalPlayRecordViewModel2 = (HistoricalPlayRecordViewModel) historicalPlayRecordViewModel$deleteStreamRecord$1.L$0;
                ResultKt.b(objI);
            }
            while (it.hasNext()) {
                videoDetailPlayBean3 = (VideoDetailPlayBean) it.next();
                videoDetailPlayDaoG = historicalPlayRecordViewModel2.G();
                historicalPlayRecordViewModel$deleteStreamRecord$1.L$0 = historicalPlayRecordViewModel2;
                historicalPlayRecordViewModel$deleteStreamRecord$1.L$1 = videoDetailPlayBean2;
                historicalPlayRecordViewModel$deleteStreamRecord$1.L$2 = it;
                historicalPlayRecordViewModel$deleteStreamRecord$1.label = 2;
                if (videoDetailPlayDaoG.g(videoDetailPlayBean3, historicalPlayRecordViewModel$deleteStreamRecord$1) == objE) {
                    return objE;
                }
            }
            c.f61276a.x("delete --- " + videoDetailPlayBean2.getSubjectId() + " --- video recording --> success");
            return Unit.f68710a;
        }
        ResultKt.b(objI);
        VideoDetailPlayDao videoDetailPlayDaoG2 = G();
        String subjectId = videoDetailPlayBean.getSubjectId();
        historicalPlayRecordViewModel$deleteStreamRecord$1.L$0 = this;
        historicalPlayRecordViewModel$deleteStreamRecord$1.L$1 = videoDetailPlayBean;
        historicalPlayRecordViewModel$deleteStreamRecord$1.label = 1;
        objI = videoDetailPlayDaoG2.i(subjectId, historicalPlayRecordViewModel$deleteStreamRecord$1);
        if (objI == objE) {
            return objE;
        }
        historicalPlayRecordViewModel = this;
        List arrayList = (List) objI;
        if (arrayList == null) {
            arrayList = new ArrayList();
        }
        historicalPlayRecordViewModel2 = historicalPlayRecordViewModel;
        videoDetailPlayBean2 = videoDetailPlayBean;
        it = arrayList.iterator();
        while (it.hasNext()) {
            videoDetailPlayBean3 = (VideoDetailPlayBean) it.next();
            videoDetailPlayDaoG = historicalPlayRecordViewModel2.G();
            historicalPlayRecordViewModel$deleteStreamRecord$1.L$0 = historicalPlayRecordViewModel2;
            historicalPlayRecordViewModel$deleteStreamRecord$1.L$1 = videoDetailPlayBean2;
            historicalPlayRecordViewModel$deleteStreamRecord$1.L$2 = it;
            historicalPlayRecordViewModel$deleteStreamRecord$1.label = 2;
            if (videoDetailPlayDaoG.g(videoDetailPlayBean3, historicalPlayRecordViewModel$deleteStreamRecord$1) == objE) {
                return objE;
            }
        }
        c.f61276a.x("delete --- " + videoDetailPlayBean2.getSubjectId() + " --- video recording --> success");
        return Unit.f68710a;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object t(DownloadBean downloadBean, Continuation<? super Unit> continuation) throws Throwable {
        HistoricalPlayRecordViewModel$deleteVideoRecord$1 historicalPlayRecordViewModel$deleteVideoRecord$1;
        if (continuation instanceof HistoricalPlayRecordViewModel$deleteVideoRecord$1) {
            historicalPlayRecordViewModel$deleteVideoRecord$1 = (HistoricalPlayRecordViewModel$deleteVideoRecord$1) continuation;
            int i11 = historicalPlayRecordViewModel$deleteVideoRecord$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                historicalPlayRecordViewModel$deleteVideoRecord$1.label = i11 - Integer.MIN_VALUE;
            } else {
                historicalPlayRecordViewModel$deleteVideoRecord$1 = new HistoricalPlayRecordViewModel$deleteVideoRecord$1(this, continuation);
            }
        } else {
            historicalPlayRecordViewModel$deleteVideoRecord$1 = new HistoricalPlayRecordViewModel$deleteVideoRecord$1(this, continuation);
        }
        Object obj = historicalPlayRecordViewModel$deleteVideoRecord$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = historicalPlayRecordViewModel$deleteVideoRecord$1.label;
        if (i12 == 0) {
            ResultKt.b(obj);
            downloadBean.setRead(1);
            downloadBean.setLastPlayTimeStamp(0L);
            downloadBean.setReadProgress(0L);
            DownloadEsHelper downloadEsHelperA = DownloadEsHelper.f60994m.a();
            historicalPlayRecordViewModel$deleteVideoRecord$1.L$0 = downloadBean;
            historicalPlayRecordViewModel$deleteVideoRecord$1.label = 1;
            if (downloadEsHelperA.P(downloadBean, historicalPlayRecordViewModel$deleteVideoRecord$1) == objE) {
                return objE;
            }
        } else {
            if (i12 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            downloadBean = (DownloadBean) historicalPlayRecordViewModel$deleteVideoRecord$1.L$0;
            ResultKt.b(obj);
        }
        c.f61276a.x("delete --- " + downloadBean.getName() + " --- video recording --> success");
        return Unit.f68710a;
    }

    public final rr.a u() {
        return (rr.a) this.f61258h.getValue();
    }

    public final c0<List<HistoricalPlayRecordMultipleEntity>> v() {
        return this.f61253b;
    }

    public final c0<List<HistoricalPlayRecordMultipleEntity>> w() {
        return this.f61254c;
    }

    public final IAudioApi x() {
        return (IAudioApi) this.f61261k.getValue();
    }

    public final IFloatingApi y() {
        return (IFloatingApi) this.f61262l.getValue();
    }

    public final int z() {
        return this.f61264n;
    }
}
