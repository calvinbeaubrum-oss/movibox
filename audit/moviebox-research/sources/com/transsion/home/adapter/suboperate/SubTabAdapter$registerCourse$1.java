package com.transsion.home.adapter.suboperate;

import com.transsion.edcation.CourseManager;
import com.transsion.edcation.bean.CourseBean;
import com.transsion.moviedetailapi.bean.BannerBean;
import com.transsion.moviedetailapi.bean.BannerData;
import com.transsion.moviedetailapi.bean.OperateItem;
import com.transsion.moviedetailapi.bean.PostItemType;
import com.transsion.moviedetailapi.bean.RankingListData;
import com.transsion.moviedetailapi.bean.RankingListItem;
import com.transsion.moviedetailapi.bean.Subject;
import java.util.Iterator;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.g;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.b;
import kotlinx.coroutines.flow.u0;
import kotlinx.coroutines.k0;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "com.transsion.home.adapter.suboperate.SubTabAdapter$registerCourse$1", f = "SubTabAdapter.kt", l = {176}, m = "invokeSuspend")
public final class SubTabAdapter$registerCourse$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ SubTabAdapter this$0;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class a implements b<CourseBean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SubTabAdapter f52007a;

        public a(SubTabAdapter subTabAdapter) {
            this.f52007a = subTabAdapter;
        }

        @Override // kotlinx.coroutines.flow.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object emit(CourseBean courseBean, Continuation<? super Unit> continuation) {
            List<Subject> rankings;
            List<RankingListItem> items;
            List<BannerData> banners;
            Subject feedsSubject;
            int i11 = 0;
            for (Object obj : this.f52007a.D()) {
                int i12 = i11 + 1;
                if (i11 < 0) {
                    g.u();
                }
                OperateItem operateItem = (OperateItem) obj;
                String type = operateItem.getType();
                if (Intrinsics.b(type, PostItemType.SUBJECT.getValue())) {
                    Subject feedsSubject2 = operateItem.getFeedsSubject();
                    if (Intrinsics.b(feedsSubject2 != null ? feedsSubject2.getSubjectId() : null, courseBean.getSubjectId()) && (feedsSubject = operateItem.getFeedsSubject()) != null) {
                        feedsSubject.setSeenStatus(Boxing.d(courseBean.getSeenStatus()));
                    }
                } else if (Intrinsics.b(type, PostItemType.BANNER.getValue())) {
                    BannerBean banner = operateItem.getBanner();
                    if (banner != null && (banners = banner.getBanners()) != null) {
                        for (BannerData bannerData : banners) {
                            if (Intrinsics.b(bannerData != null ? bannerData.getSubjectId() : null, courseBean.getSubjectId()) && bannerData != null) {
                                bannerData.setSeenStatus(Boxing.d(courseBean.getSeenStatus()));
                            }
                        }
                    }
                } else if (Intrinsics.b(type, PostItemType.RANKING_LIST.getValue())) {
                    RankingListData rankingListData = operateItem.getRankingListData();
                    if (rankingListData != null && (items = rankingListData.getItems()) != null) {
                        Iterator<T> it = items.iterator();
                        while (it.hasNext()) {
                            List<Subject> subjects = ((RankingListItem) it.next()).getSubjects();
                            if (subjects != null) {
                                for (Subject subject : subjects) {
                                    if (Intrinsics.b(subject.getSubjectId(), courseBean.getSubjectId())) {
                                        subject.setSeenStatus(Boxing.d(courseBean.getSeenStatus()));
                                    }
                                }
                            }
                        }
                    }
                } else if (Intrinsics.b(type, PostItemType.OP_RANKING.getValue()) && (rankings = operateItem.getRankings()) != null) {
                    for (Subject subject2 : rankings) {
                        if (Intrinsics.b(subject2.getSubjectId(), courseBean.getSubjectId())) {
                            subject2.setSeenStatus(Boxing.d(courseBean.getSeenStatus()));
                        }
                    }
                }
                i11 = i12;
            }
            return Unit.f68710a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubTabAdapter$registerCourse$1(SubTabAdapter subTabAdapter, Continuation<? super SubTabAdapter$registerCourse$1> continuation) {
        super(2, continuation);
        this.this$0 = subTabAdapter;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SubTabAdapter$registerCourse$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((SubTabAdapter$registerCourse$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            u0<CourseBean> u0VarH = CourseManager.f51853a.h();
            a aVar = new a(this.this$0);
            this.label = 1;
            if (u0VarH.a(aVar, this) == objE) {
                return objE;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        throw new KotlinNothingValueException();
    }
}
