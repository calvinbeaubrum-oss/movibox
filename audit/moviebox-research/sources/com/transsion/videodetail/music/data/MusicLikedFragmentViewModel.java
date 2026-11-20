package com.transsion.videodetail.music.data;

import android.app.Application;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.c0;
import androidx.lifecycle.t0;
import androidx.lifecycle.u0;
import com.blankj.utilcode.util.Utils;
import com.tn.lib.net.bean.BaseDto;
import com.tn.lib.net.manager.NetServiceGenerator;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.db.music.MusicLikedDbBean;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Pager;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.videodetail.music.bean.LikeListActionEnum;
import com.transsion.videodetail.music.bean.MusicLikedMultiItemEntity;
import com.transsion.videodetail.music.bean.MusicLikedRemoteBean;
import com.transsion.videodetail.music.bean.MusicLikedRemoteItemBean;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.h;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.j;
import tr.c;

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
public final class MusicLikedFragmentViewModel extends t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f59918a = "0";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<MusicLikedRemoteItemBean> f59919b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f59920c = LazyKt__LazyJVMKt.b(new Function0<vr.a>() { // from class: com.transsion.videodetail.music.data.MusicLikedFragmentViewModel$musicLikedDao$2
        @Override // kotlin.jvm.functions.Function0
        public final vr.a invoke() {
            AppDatabase.v0 v0Var = AppDatabase.f51036p;
            Application applicationA = Utils.a();
            Intrinsics.f(applicationA, "getApp()");
            return v0Var.b(applicationA).H0();
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f59921d = LazyKt__LazyJVMKt.b(new Function0<c>() { // from class: com.transsion.videodetail.music.data.MusicLikedFragmentViewModel$downloadDao$2
        @Override // kotlin.jvm.functions.Function0
        public final c invoke() {
            AppDatabase.v0 v0Var = AppDatabase.f51036p;
            Application applicationA = Utils.a();
            Intrinsics.f(applicationA, "getApp()");
            return v0Var.b(applicationA).E0();
        }
    });

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f59922f = LazyKt__LazyJVMKt.b(new Function0<a>() { // from class: com.transsion.videodetail.music.data.MusicLikedFragmentViewModel$musicLikedApi$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final a invoke() {
            return (a) NetServiceGenerator.f49399d.a().i(a.class);
        }
    });

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c0<MusicLikedRemoteItemBean> f59923g = new c0<>();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c0<List<MusicLikedMultiItemEntity>> f59924h = new c0<>();

    /* JADX INFO: Access modifiers changed from: private */
    public final String p() {
        String simpleName = MusicLikedFragmentViewModel.class.getSimpleName();
        Intrinsics.f(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    public final void A(String str, Function1<? super String, Unit> callback) {
        Intrinsics.g(callback, "callback");
        j.d(u0.a(this), null, null, new MusicLikedFragmentViewModel$isDownload$1(this, str, callback, null), 3, null);
    }

    public final void B(String str, Function1<? super Boolean, Unit> callback) {
        Intrinsics.g(callback, "callback");
        j.d(u0.a(this), null, null, new MusicLikedFragmentViewModel$isLiked$1(this, str, callback, null), 3, null);
    }

    public final void C(String str, LikeListActionEnum action) {
        Intrinsics.g(action, "action");
        j.d(u0.a(this), null, null, new MusicLikedFragmentViewModel$likedMusic$1(str, action, this, null), 3, null);
    }

    /* JADX WARN: Code duplicated, block: B:23:0x007d  */
    /* JADX WARN: Code duplicated, block: B:25:0x009e A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:26:0x009f  */
    /* JADX WARN: Code duplicated, block: B:29:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:30:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x009f -> B:27:0x00a3). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object D(kotlin.coroutines.Continuation<? super kotlin.Unit> r14) {
        /*
            Method dump skipped, instruction units count: 201
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.videodetail.music.data.MusicLikedFragmentViewModel.D(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:57:0x0105 A[Catch: all -> 0x006a, TryCatch #2 {all -> 0x006a, blocks: (B:66:0x0144, B:28:0x0066, B:37:0x00a9, B:39:0x00b3, B:41:0x00b9, B:42:0x00c4, B:44:0x00cc, B:46:0x00d2, B:48:0x00e0, B:50:0x00e8, B:52:0x00ee, B:54:0x00f4, B:57:0x0105, B:58:0x0118, B:60:0x011e, B:61:0x012c, B:63:0x0133, B:69:0x0172), top: B:86:0x0066 }] */
    /* JADX WARN: Code duplicated, block: B:60:0x011e A[Catch: all -> 0x006a, LOOP:0: B:58:0x0118->B:60:0x011e, LOOP_END, TryCatch #2 {all -> 0x006a, blocks: (B:66:0x0144, B:28:0x0066, B:37:0x00a9, B:39:0x00b3, B:41:0x00b9, B:42:0x00c4, B:44:0x00cc, B:46:0x00d2, B:48:0x00e0, B:50:0x00e8, B:52:0x00ee, B:54:0x00f4, B:57:0x0105, B:58:0x0118, B:60:0x011e, B:61:0x012c, B:63:0x0133, B:69:0x0172), top: B:86:0x0066 }] */
    /* JADX WARN: Code duplicated, block: B:63:0x0133 A[Catch: all -> 0x006a, TryCatch #2 {all -> 0x006a, blocks: (B:66:0x0144, B:28:0x0066, B:37:0x00a9, B:39:0x00b3, B:41:0x00b9, B:42:0x00c4, B:44:0x00cc, B:46:0x00d2, B:48:0x00e0, B:50:0x00e8, B:52:0x00ee, B:54:0x00f4, B:57:0x0105, B:58:0x0118, B:60:0x011e, B:61:0x012c, B:63:0x0133, B:69:0x0172), top: B:86:0x0066 }] */
    /* JADX WARN: Code duplicated, block: B:65:0x0143 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:68:0x0171 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:69:0x0172 A[Catch: all -> 0x006a, TRY_LEAVE, TryCatch #2 {all -> 0x006a, blocks: (B:66:0x0144, B:28:0x0066, B:37:0x00a9, B:39:0x00b3, B:41:0x00b9, B:42:0x00c4, B:44:0x00cc, B:46:0x00d2, B:48:0x00e0, B:50:0x00e8, B:52:0x00ee, B:54:0x00f4, B:57:0x0105, B:58:0x0118, B:60:0x011e, B:61:0x012c, B:63:0x0133, B:69:0x0172), top: B:86:0x0066 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Instruction removed from duplicated block: B:69:0x0172, please report this as an issue */
    public final Object E(Continuation<? super Unit> continuation) throws Throwable {
        MusicLikedFragmentViewModel$loadNetData$1 musicLikedFragmentViewModel$loadNetData$1;
        MusicLikedFragmentViewModel musicLikedFragmentViewModel;
        MusicLikedFragmentViewModel musicLikedFragmentViewModel2;
        MusicLikedRemoteBean musicLikedRemoteBean;
        MusicLikedRemoteBean musicLikedRemoteBean2;
        List<MusicLikedDbBean> arrayList;
        Iterator<T> it;
        vr.a aVarW;
        Pager pager;
        Pager pager2;
        List<MusicLikedRemoteItemBean> items;
        Object objM163constructorimpl;
        if (continuation instanceof MusicLikedFragmentViewModel$loadNetData$1) {
            musicLikedFragmentViewModel$loadNetData$1 = (MusicLikedFragmentViewModel$loadNetData$1) continuation;
            int i11 = musicLikedFragmentViewModel$loadNetData$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                musicLikedFragmentViewModel$loadNetData$1.label = i11 - Integer.MIN_VALUE;
            } else {
                musicLikedFragmentViewModel$loadNetData$1 = new MusicLikedFragmentViewModel$loadNetData$1(this, continuation);
            }
        } else {
            musicLikedFragmentViewModel$loadNetData$1 = new MusicLikedFragmentViewModel$loadNetData$1(this, continuation);
        }
        Object objA = musicLikedFragmentViewModel$loadNetData$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = musicLikedFragmentViewModel$loadNetData$1.label;
        if (i12 != 0) {
            if (i12 != 1) {
                try {
                    if (i12 == 2) {
                        musicLikedFragmentViewModel = (MusicLikedFragmentViewModel) musicLikedFragmentViewModel$loadNetData$1.L$0;
                    } else if (i12 == 3) {
                        List<MusicLikedDbBean> list = (List) musicLikedFragmentViewModel$loadNetData$1.L$1;
                        MusicLikedFragmentViewModel musicLikedFragmentViewModel3 = (MusicLikedFragmentViewModel) musicLikedFragmentViewModel$loadNetData$1.L$0;
                        try {
                            ResultKt.b(objA);
                            arrayList = list;
                            musicLikedFragmentViewModel2 = musicLikedFragmentViewModel3;
                            sz.a.f76638a.a(musicLikedFragmentViewModel2.p() + " --> loadNetData() --> 数据库写入成功 --> size = " + arrayList.size());
                            musicLikedFragmentViewModel$loadNetData$1.L$0 = musicLikedFragmentViewModel2;
                            musicLikedFragmentViewModel$loadNetData$1.L$1 = null;
                            musicLikedFragmentViewModel$loadNetData$1.label = 4;
                            if (musicLikedFragmentViewModel2.D(musicLikedFragmentViewModel$loadNetData$1) == objE) {
                                return objE;
                            }
                            musicLikedFragmentViewModel = musicLikedFragmentViewModel2;
                            objM163constructorimpl = Result.m163constructorimpl(Unit.f68710a);
                        } catch (Throwable th2) {
                            th = th2;
                            musicLikedFragmentViewModel = musicLikedFragmentViewModel3;
                            Result.Companion companion = Result.Companion;
                            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th));
                        }
                    } else {
                        if (i12 != 4) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        musicLikedFragmentViewModel = (MusicLikedFragmentViewModel) musicLikedFragmentViewModel$loadNetData$1.L$0;
                    }
                    ResultKt.b(objA);
                    objM163constructorimpl = Result.m163constructorimpl(Unit.f68710a);
                } catch (Throwable th3) {
                    th = th3;
                    Result.Companion companion2 = Result.Companion;
                    objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th));
                }
            } else {
                musicLikedFragmentViewModel2 = (MusicLikedFragmentViewModel) musicLikedFragmentViewModel$loadNetData$1.L$0;
                try {
                    ResultKt.b(objA);
                    BaseDto baseDto = (BaseDto) objA;
                    musicLikedRemoteBean = (MusicLikedRemoteBean) baseDto.getData();
                    if (musicLikedRemoteBean != null && (items = musicLikedRemoteBean.getItems()) != null) {
                        Boxing.a(musicLikedFragmentViewModel2.f59919b.addAll(items));
                    }
                    musicLikedRemoteBean2 = (MusicLikedRemoteBean) baseDto.getData();
                    if (musicLikedRemoteBean2 == null && (pager = musicLikedRemoteBean2.getPager()) != null && Intrinsics.b(pager.getHasMore(), Boxing.a(true))) {
                        MusicLikedRemoteBean musicLikedRemoteBean3 = (MusicLikedRemoteBean) baseDto.getData();
                        musicLikedFragmentViewModel2.f59918a = String.valueOf((musicLikedRemoteBean3 == null || (pager2 = musicLikedRemoteBean3.getPager()) == null) ? null : pager2.getNextPage());
                        musicLikedFragmentViewModel$loadNetData$1.L$0 = musicLikedFragmentViewModel2;
                        musicLikedFragmentViewModel$loadNetData$1.label = 2;
                        if (musicLikedFragmentViewModel2.E(musicLikedFragmentViewModel$loadNetData$1) == objE) {
                            return objE;
                        }
                    } else {
                        List<MusicLikedRemoteItemBean> list2 = musicLikedFragmentViewModel2.f59919b;
                        arrayList = new ArrayList<>(h.v(list2, 10));
                        it = list2.iterator();
                        while (it.hasNext()) {
                            arrayList.add(musicLikedFragmentViewModel2.n((MusicLikedRemoteItemBean) it.next()));
                        }
                        if (!arrayList.isEmpty()) {
                            aVarW = musicLikedFragmentViewModel2.w();
                            musicLikedFragmentViewModel$loadNetData$1.L$0 = musicLikedFragmentViewModel2;
                            musicLikedFragmentViewModel$loadNetData$1.L$1 = arrayList;
                            musicLikedFragmentViewModel$loadNetData$1.label = 3;
                            if (aVarW.b(arrayList, musicLikedFragmentViewModel$loadNetData$1) == objE) {
                                return objE;
                            }
                            sz.a.f76638a.a(musicLikedFragmentViewModel2.p() + " --> loadNetData() --> 数据库写入成功 --> size = " + arrayList.size());
                            musicLikedFragmentViewModel$loadNetData$1.L$0 = musicLikedFragmentViewModel2;
                            musicLikedFragmentViewModel$loadNetData$1.L$1 = null;
                            musicLikedFragmentViewModel$loadNetData$1.label = 4;
                            if (musicLikedFragmentViewModel2.D(musicLikedFragmentViewModel$loadNetData$1) == objE) {
                                return objE;
                            }
                        } else {
                            sz.a.f76638a.c(musicLikedFragmentViewModel2.p() + " --> loadNetData() --> 本地和服务端都没数据");
                            musicLikedFragmentViewModel2.f59924h.n(null);
                        }
                    }
                    musicLikedFragmentViewModel = musicLikedFragmentViewModel2;
                    objM163constructorimpl = Result.m163constructorimpl(Unit.f68710a);
                } catch (Throwable th4) {
                    th = th4;
                    musicLikedFragmentViewModel = musicLikedFragmentViewModel2;
                    Result.Companion companion3 = Result.Companion;
                    objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th));
                }
            }
            Result.Companion companion4 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th));
        } else {
            ResultKt.b(objA);
            try {
                Result.Companion companion5 = Result.Companion;
                sz.a.f76638a.a(p() + " --> loadNetData() --> 获取服务端的数据 --> page = " + this.f59918a);
                a aVarV = v();
                String str = this.f59918a;
                musicLikedFragmentViewModel$loadNetData$1.L$0 = this;
                musicLikedFragmentViewModel$loadNetData$1.label = 1;
                objA = a.C0614a.a(aVarV, str, 0, null, musicLikedFragmentViewModel$loadNetData$1, 6, null);
                if (objA == objE) {
                    return objE;
                }
                musicLikedFragmentViewModel2 = this;
                BaseDto baseDto2 = (BaseDto) objA;
                musicLikedRemoteBean = (MusicLikedRemoteBean) baseDto2.getData();
                if (musicLikedRemoteBean != null) {
                    Boxing.a(musicLikedFragmentViewModel2.f59919b.addAll(items));
                }
                musicLikedRemoteBean2 = (MusicLikedRemoteBean) baseDto2.getData();
                if (musicLikedRemoteBean2 == null) {
                    List<MusicLikedRemoteItemBean> list3 = musicLikedFragmentViewModel2.f59919b;
                    arrayList = new ArrayList<>(h.v(list3, 10));
                    it = list3.iterator();
                    while (it.hasNext()) {
                        arrayList.add(musicLikedFragmentViewModel2.n((MusicLikedRemoteItemBean) it.next()));
                    }
                    if (!arrayList.isEmpty()) {
                        aVarW = musicLikedFragmentViewModel2.w();
                        musicLikedFragmentViewModel$loadNetData$1.L$0 = musicLikedFragmentViewModel2;
                        musicLikedFragmentViewModel$loadNetData$1.L$1 = arrayList;
                        musicLikedFragmentViewModel$loadNetData$1.label = 3;
                        if (aVarW.b(arrayList, musicLikedFragmentViewModel$loadNetData$1) == objE) {
                            return objE;
                        }
                        sz.a.f76638a.a(musicLikedFragmentViewModel2.p() + " --> loadNetData() --> 数据库写入成功 --> size = " + arrayList.size());
                        musicLikedFragmentViewModel$loadNetData$1.L$0 = musicLikedFragmentViewModel2;
                        musicLikedFragmentViewModel$loadNetData$1.L$1 = null;
                        musicLikedFragmentViewModel$loadNetData$1.label = 4;
                        if (musicLikedFragmentViewModel2.D(musicLikedFragmentViewModel$loadNetData$1) == objE) {
                            return objE;
                        }
                    } else {
                        sz.a.f76638a.c(musicLikedFragmentViewModel2.p() + " --> loadNetData() --> 本地和服务端都没数据");
                        musicLikedFragmentViewModel2.f59924h.n(null);
                    }
                } else {
                    List<MusicLikedRemoteItemBean> list4 = musicLikedFragmentViewModel2.f59919b;
                    arrayList = new ArrayList<>(h.v(list4, 10));
                    it = list4.iterator();
                    while (it.hasNext()) {
                        arrayList.add(musicLikedFragmentViewModel2.n((MusicLikedRemoteItemBean) it.next()));
                    }
                    if (!arrayList.isEmpty()) {
                        aVarW = musicLikedFragmentViewModel2.w();
                        musicLikedFragmentViewModel$loadNetData$1.L$0 = musicLikedFragmentViewModel2;
                        musicLikedFragmentViewModel$loadNetData$1.L$1 = arrayList;
                        musicLikedFragmentViewModel$loadNetData$1.label = 3;
                        if (aVarW.b(arrayList, musicLikedFragmentViewModel$loadNetData$1) == objE) {
                            return objE;
                        }
                        sz.a.f76638a.a(musicLikedFragmentViewModel2.p() + " --> loadNetData() --> 数据库写入成功 --> size = " + arrayList.size());
                        musicLikedFragmentViewModel$loadNetData$1.L$0 = musicLikedFragmentViewModel2;
                        musicLikedFragmentViewModel$loadNetData$1.L$1 = null;
                        musicLikedFragmentViewModel$loadNetData$1.label = 4;
                        if (musicLikedFragmentViewModel2.D(musicLikedFragmentViewModel$loadNetData$1) == objE) {
                            return objE;
                        }
                    } else {
                        sz.a.f76638a.c(musicLikedFragmentViewModel2.p() + " --> loadNetData() --> 本地和服务端都没数据");
                        musicLikedFragmentViewModel2.f59924h.n(null);
                    }
                }
                musicLikedFragmentViewModel = musicLikedFragmentViewModel2;
                objM163constructorimpl = Result.m163constructorimpl(Unit.f68710a);
            } catch (Throwable th5) {
                th = th5;
                musicLikedFragmentViewModel = this;
                Result.Companion companion6 = Result.Companion;
                objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th));
            }
        }
        Throwable thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(objM163constructorimpl);
        if (thM166exceptionOrNullimpl != null) {
            sz.a.f76638a.b(musicLikedFragmentViewModel.p() + " --> loadNetData() --> 网络请求异常 --> " + thM166exceptionOrNullimpl.getMessage());
            musicLikedFragmentViewModel.f59924h.n(null);
        }
        return Unit.f68710a;
    }

    public final void m(Subject subject) {
        Intrinsics.g(subject, "subject");
        j.d(u0.a(this), null, null, new MusicLikedFragmentViewModel$clickLikedMusic$1(subject, this, null), 3, null);
    }

    public final MusicLikedDbBean n(MusicLikedRemoteItemBean musicLikedRemoteItemBean) {
        String subjectId = musicLikedRemoteItemBean.getSubjectId();
        if (subjectId == null) {
            subjectId = "";
        }
        String str = subjectId;
        String title = musicLikedRemoteItemBean.getTitle();
        Cover cover = musicLikedRemoteItemBean.getCover();
        String url = cover != null ? cover.getUrl() : null;
        String countryName = musicLikedRemoteItemBean.getCountryName();
        String genre = musicLikedRemoteItemBean.getGenre();
        String releaseDate = musicLikedRemoteItemBean.getReleaseDate();
        Integer durationSeconds = musicLikedRemoteItemBean.getDurationSeconds();
        int iIntValue = durationSeconds != null ? durationSeconds.intValue() : 0;
        String singerName = musicLikedRemoteItemBean.getSingerName();
        String singerAvatar = musicLikedRemoteItemBean.getSingerAvatar();
        Long likeTime = musicLikedRemoteItemBean.getLikeTime();
        return new MusicLikedDbBean(str, title, url, countryName, genre, releaseDate, iIntValue, singerName, singerAvatar, "", likeTime != null ? likeTime.longValue() : System.currentTimeMillis());
    }

    public final Object o(MusicLikedRemoteItemBean musicLikedRemoteItemBean, Continuation<? super Unit> continuation) {
        if (musicLikedRemoteItemBean != null) {
            vr.a aVarW = w();
            String subjectId = musicLikedRemoteItemBean.getSubjectId();
            if (subjectId == null) {
                subjectId = "";
            }
            Object objD = aVarW.d(subjectId, continuation);
            if (objD == kotlin.coroutines.intrinsics.a.e()) {
                return objD;
            }
        }
        return Unit.f68710a;
    }

    public final c q() {
        return (c) this.f59921d.getValue();
    }

    public final void r(String str, Function1<? super DownloadBean, Unit> callback) {
        Intrinsics.g(callback, "callback");
        j.d(u0.a(this), null, null, new MusicLikedFragmentViewModel$getDownloadEntity$1(this, str, callback, null), 3, null);
    }

    public final LiveData<MusicLikedRemoteItemBean> s() {
        return this.f59923g;
    }

    public final void t() {
        j.d(u0.a(this), null, null, new MusicLikedFragmentViewModel$getLocalMusicLiked$1(this, null), 3, null);
    }

    public final void u(String from) {
        Intrinsics.g(from, "from");
        j.d(u0.a(this), null, null, new MusicLikedFragmentViewModel$getMusicLiked$1(this, from, null), 3, null);
    }

    public final a v() {
        return (a) this.f59922f.getValue();
    }

    public final vr.a w() {
        return (vr.a) this.f59920c.getValue();
    }

    public final void x(String str, Function1<? super MusicLikedDbBean, Unit> callback) {
        Intrinsics.g(callback, "callback");
        j.d(u0.a(this), null, null, new MusicLikedFragmentViewModel$getMusicLikedEntity$1(this, str, callback, null), 3, null);
    }

    public final LiveData<List<MusicLikedMultiItemEntity>> y() {
        return this.f59924h;
    }

    public final Object z(MusicLikedRemoteItemBean musicLikedRemoteItemBean, Continuation<? super Unit> continuation) {
        Object objF;
        return (musicLikedRemoteItemBean == null || (objF = w().f(n(musicLikedRemoteItemBean), continuation)) != kotlin.coroutines.intrinsics.a.e()) ? Unit.f68710a : objF;
    }
}
