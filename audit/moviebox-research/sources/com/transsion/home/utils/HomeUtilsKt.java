package com.transsion.home.utils;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.android.arouter.facade.Postcard;
import com.transsion.baselib.utils.m;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.AppointSubject;
import com.transsion.moviedetailapi.bean.BannerBean;
import com.transsion.moviedetailapi.bean.BannerData;
import com.transsion.moviedetailapi.bean.CustomData;
import com.transsion.moviedetailapi.bean.LiveListItem;
import com.transsion.moviedetailapi.bean.OperateItem;
import com.transsion.moviedetailapi.bean.PlayListItem;
import com.transsion.moviedetailapi.bean.RankingListData;
import com.transsion.moviedetailapi.bean.RankingListItem;
import com.transsion.moviedetailapi.bean.ResourceDetectors;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsnet.downloader.DownloadManagerApi;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@SourceDebugExtension
public final class HomeUtilsKt {
    public static final void a(List<OperateItem> list, final String str) {
        List<BannerData> items;
        String ops;
        List<LiveListItem> liveList;
        List<RankingListItem> items2;
        List<BannerData> banners;
        if (str == null || str.length() == 0) {
            return;
        }
        Function1<List<? extends Subject>, Unit> function1 = new Function1<List<? extends Subject>, Unit>() { // from class: com.transsion.home.utils.HomeUtilsKt$convertOperateOps$replaceSubjectOps$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends Subject> list2) {
                invoke2(list2);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<? extends Subject> list2) {
                if (list2 != null) {
                    String str2 = str;
                    for (Subject subject : list2) {
                        String ops2 = subject.getOps();
                        if (ops2 == null || ops2.length() == 0) {
                            subject.setOps(str2);
                        }
                    }
                }
            }
        };
        if (list != null) {
            for (OperateItem operateItem : list) {
                BannerBean banner = operateItem.getBanner();
                List<BannerData> banners2 = banner != null ? banner.getBanners() : null;
                if (banners2 == null || banners2.isEmpty()) {
                    List<AppointSubject> subjects = operateItem.getSubjects();
                    if (subjects == null || subjects.isEmpty()) {
                        CustomData customData = operateItem.getCustomData();
                        if ((customData != null ? customData.getItems() : null) != null) {
                            CustomData customData2 = operateItem.getCustomData();
                            if (customData2 != null && (items = customData2.getItems()) != null) {
                                Iterator<T> it = items.iterator();
                                while (it.hasNext()) {
                                    ((BannerData) it.next()).setOps(str);
                                }
                            }
                        } else {
                            List<Subject> rankings = operateItem.getRankings();
                            if (rankings == null || rankings.isEmpty()) {
                                RankingListData rankingListData = operateItem.getRankingListData();
                                List<RankingListItem> items3 = rankingListData != null ? rankingListData.getItems() : null;
                                if (items3 != null && !items3.isEmpty()) {
                                    RankingListData rankingListData2 = operateItem.getRankingListData();
                                    if (rankingListData2 != null && (items2 = rankingListData2.getItems()) != null) {
                                        Iterator<T> it2 = items2.iterator();
                                        while (it2.hasNext()) {
                                            function1.invoke(((RankingListItem) it2.next()).getSubjects());
                                        }
                                    }
                                } else if (operateItem.getFeedsSubject() != null) {
                                    Subject feedsSubject = operateItem.getFeedsSubject();
                                    ops = feedsSubject != null ? feedsSubject.getOps() : null;
                                    if (ops == null || ops.length() == 0) {
                                        Subject feedsSubject2 = operateItem.getFeedsSubject();
                                        if (feedsSubject2 != null) {
                                            feedsSubject2.setOps(str);
                                        }
                                    }
                                } else {
                                    List<LiveListItem> liveList2 = operateItem.getLiveList();
                                    if (liveList2 != null && !liveList2.isEmpty() && (liveList = operateItem.getLiveList()) != null) {
                                        for (LiveListItem liveListItem : liveList) {
                                            String ops2 = liveListItem.getOps();
                                            if (ops2 == null || ops2.length() == 0) {
                                                liveListItem.setOps(str);
                                            }
                                        }
                                    }
                                }
                            } else {
                                function1.invoke(operateItem.getRankings());
                            }
                        }
                    } else {
                        function1.invoke(operateItem.getSubjects());
                        if (operateItem.getPlayListData() != null) {
                            PlayListItem playListData = operateItem.getPlayListData();
                            ops = playListData != null ? playListData.getOps() : null;
                            if (ops == null || ops.length() == 0) {
                                PlayListItem playListData2 = operateItem.getPlayListData();
                                if (playListData2 != null) {
                                    playListData2.setOps(str);
                                }
                            }
                        }
                    }
                } else {
                    BannerBean banner2 = operateItem.getBanner();
                    if (banner2 != null && (banners = banner2.getBanners()) != null) {
                        for (BannerData bannerData : banners) {
                            if (bannerData != null) {
                                bannerData.setOps(str);
                            }
                        }
                    }
                }
            }
        }
    }

    public static final void b(Subject subject, String playModule) {
        Intrinsics.g(playModule, "playModule");
        if (subject == null) {
            return;
        }
        Postcard postcardB = com.alibaba.android.arouter.launcher.a.d().b("/movie/detail");
        Integer subjectType = subject.getSubjectType();
        postcardB.withInt("subject_type", subjectType != null ? subjectType.intValue() : SubjectType.MOVIE.getValue()).withString("id", subject.getSubjectId()).withString("module_name", playModule).withInt("season", subject.getSeason()).withBoolean("autoPlay", true).withString("ops", subject.getOps()).navigation();
    }

    public static final String c(Subject subject, String pageName, Context context, String playModule) {
        String resourceLink;
        ResourceDetectors resourceDetector;
        String subjectId;
        ResourceDetectors resourceDetector2;
        Intrinsics.g(pageName, "pageName");
        Intrinsics.g(context, "context");
        Intrinsics.g(playModule, "playModule");
        if (subject != null) {
            Integer subjectType = subject.getSubjectType();
            int value = SubjectType.SHORT_TV.getValue();
            if (subjectType != null && subjectType.intValue() == value) {
                DownloadManagerApi.f60274j.a().a2((FragmentActivity) context, pageName, (384 & 4) != 0 ? "" : "", subject.getOps(), (384 & 16) != 0 ? null : "download_subject", (384 & 32) != 0 ? false : true, (384 & 64) != 0 ? null : subject, (384 & 128) != 0 ? null : null, (384 & 256) != 0 ? Boolean.FALSE : null);
                return "download_subject";
            }
        }
        if (m.f51320a.b()) {
            b(subject, playModule);
        } else {
            DownloadManagerApi.a aVar = DownloadManagerApi.f60274j;
            if (!DownloadManagerApi.n2(aVar.a(), subject != null ? subject.getSubjectId() : null, (subject == null || (resourceDetector2 = subject.getResourceDetector()) == null) ? null : resourceDetector2.getResourceId(), subject != null && subject.isSeries(), false, 8, null)) {
                DownloadManagerApi downloadManagerApiA = aVar.a();
                FragmentActivity fragmentActivity = (FragmentActivity) context;
                String ops = subject != null ? subject.getOps() : null;
                if (subject == null || (resourceDetector = subject.getResourceDetector()) == null || (resourceLink = resourceDetector.getResourceLink()) == null) {
                    resourceLink = "";
                }
                downloadManagerApiA.P1(fragmentActivity, subject, pageName, (960 & 8) != 0 ? "" : null, ops, resourceLink, (960 & 64) != 0 ? "" : null, (960 & 128) != 0 ? null : null, (960 & 256) != 0 ? null : null, (960 & 512) != 0 ? false : false);
                return "download_subject";
            }
            if (subject != null && (subjectId = subject.getSubjectId()) != null) {
                DownloadManagerApi.p2(aVar.a(), subjectId, context, pageName, null, 8, null);
            }
        }
        return "play_subject";
    }
}
