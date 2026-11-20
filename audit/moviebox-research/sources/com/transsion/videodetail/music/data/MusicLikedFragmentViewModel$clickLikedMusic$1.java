package com.transsion.videodetail.music.data;

import com.transsion.moviedetailapi.bean.Staff;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.videodetail.music.bean.LikeListActionEnum;
import com.transsion.videodetail.music.bean.MusicLikedRemoteItemBean;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.k0;

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
@DebugMetadata(c = "com.transsion.videodetail.music.data.MusicLikedFragmentViewModel$clickLikedMusic$1", f = "MusicLikedFragmentViewModel.kt", l = {117, 122}, m = "invokeSuspend")
public final class MusicLikedFragmentViewModel$clickLikedMusic$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Subject $subject;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ MusicLikedFragmentViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MusicLikedFragmentViewModel$clickLikedMusic$1(Subject subject, MusicLikedFragmentViewModel musicLikedFragmentViewModel, Continuation<? super MusicLikedFragmentViewModel$clickLikedMusic$1> continuation) {
        super(2, continuation);
        this.$subject = subject;
        this.this$0 = musicLikedFragmentViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        MusicLikedFragmentViewModel$clickLikedMusic$1 musicLikedFragmentViewModel$clickLikedMusic$1 = new MusicLikedFragmentViewModel$clickLikedMusic$1(this.$subject, this.this$0, continuation);
        musicLikedFragmentViewModel$clickLikedMusic$1.L$0 = obj;
        return musicLikedFragmentViewModel$clickLikedMusic$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((MusicLikedFragmentViewModel$clickLikedMusic$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objM163constructorimpl;
        Subject subject;
        MusicLikedFragmentViewModel musicLikedFragmentViewModel;
        MusicLikedRemoteItemBean musicLikedRemoteItemBean;
        Subject subject2;
        MusicLikedFragmentViewModel musicLikedFragmentViewModel2;
        MusicLikedRemoteItemBean musicLikedRemoteItemBean2;
        LikeListActionEnum likeListActionEnum;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        try {
            if (i11 == 0) {
                ResultKt.b(obj);
                subject = this.$subject;
                musicLikedFragmentViewModel = this.this$0;
                Result.Companion companion = Result.Companion;
                musicLikedRemoteItemBean = new MusicLikedRemoteItemBean(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
                musicLikedRemoteItemBean.setSubjectId(subject.getSubjectId());
                musicLikedRemoteItemBean.setTitle(subject.getTitle());
                musicLikedRemoteItemBean.setCover(subject.getCover());
                musicLikedRemoteItemBean.setCountryName(subject.getCountryName());
                musicLikedRemoteItemBean.setGenre(subject.getGenre());
                musicLikedRemoteItemBean.setReleaseDate(subject.getReleaseDate());
                musicLikedRemoteItemBean.setDurationSeconds(subject.getDurationSeconds());
                musicLikedRemoteItemBean.setLikeTime(Boxing.e(System.currentTimeMillis()));
                List<Staff> staffList = subject.getStaffList();
                if (staffList != null && (!staffList.isEmpty())) {
                    Staff staff = staffList.get(0);
                    musicLikedRemoteItemBean.setSingerName(staff.getName());
                    musicLikedRemoteItemBean.setSingerAvatar(staff.getAvatarUrl());
                }
                Integer likeStatus = subject.getLikeStatus();
                if (likeStatus != null && likeStatus.intValue() == 0) {
                    this.L$0 = subject;
                    this.L$1 = musicLikedFragmentViewModel;
                    this.L$2 = musicLikedRemoteItemBean;
                    this.label = 1;
                    if (musicLikedFragmentViewModel.z(musicLikedRemoteItemBean, this) == objE) {
                        return objE;
                    }
                    subject2 = subject;
                    musicLikedFragmentViewModel2 = musicLikedFragmentViewModel;
                    musicLikedRemoteItemBean2 = musicLikedRemoteItemBean;
                    likeListActionEnum = LikeListActionEnum.ADD;
                    musicLikedRemoteItemBean = musicLikedRemoteItemBean2;
                    musicLikedFragmentViewModel = musicLikedFragmentViewModel2;
                    subject = subject2;
                } else if (likeStatus != null && likeStatus.intValue() == 1) {
                    this.L$0 = subject;
                    this.L$1 = musicLikedFragmentViewModel;
                    this.L$2 = musicLikedRemoteItemBean;
                    this.label = 2;
                    if (musicLikedFragmentViewModel.o(musicLikedRemoteItemBean, this) == objE) {
                        return objE;
                    }
                    subject2 = subject;
                    musicLikedFragmentViewModel2 = musicLikedFragmentViewModel;
                    musicLikedRemoteItemBean2 = musicLikedRemoteItemBean;
                    likeListActionEnum = LikeListActionEnum.REMOVE;
                    musicLikedRemoteItemBean = musicLikedRemoteItemBean2;
                    musicLikedFragmentViewModel = musicLikedFragmentViewModel2;
                    subject = subject2;
                } else {
                    likeListActionEnum = LikeListActionEnum.ADD;
                }
            } else if (i11 == 1) {
                musicLikedRemoteItemBean2 = (MusicLikedRemoteItemBean) this.L$2;
                musicLikedFragmentViewModel2 = (MusicLikedFragmentViewModel) this.L$1;
                subject2 = (Subject) this.L$0;
                ResultKt.b(obj);
                likeListActionEnum = LikeListActionEnum.ADD;
                musicLikedRemoteItemBean = musicLikedRemoteItemBean2;
                musicLikedFragmentViewModel = musicLikedFragmentViewModel2;
                subject = subject2;
            } else {
                if (i11 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                musicLikedRemoteItemBean2 = (MusicLikedRemoteItemBean) this.L$2;
                musicLikedFragmentViewModel2 = (MusicLikedFragmentViewModel) this.L$1;
                subject2 = (Subject) this.L$0;
                ResultKt.b(obj);
                likeListActionEnum = LikeListActionEnum.REMOVE;
                musicLikedRemoteItemBean = musicLikedRemoteItemBean2;
                musicLikedFragmentViewModel = musicLikedFragmentViewModel2;
                subject = subject2;
            }
            musicLikedRemoteItemBean.setActionEnum(likeListActionEnum);
            musicLikedFragmentViewModel.f59923g.n(musicLikedRemoteItemBean);
            musicLikedFragmentViewModel.t();
            musicLikedFragmentViewModel.C(subject.getSubjectId(), likeListActionEnum);
            objM163constructorimpl = Result.m163constructorimpl(Unit.f68710a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        Result.m166exceptionOrNullimpl(objM163constructorimpl);
        return Unit.f68710a;
    }
}
