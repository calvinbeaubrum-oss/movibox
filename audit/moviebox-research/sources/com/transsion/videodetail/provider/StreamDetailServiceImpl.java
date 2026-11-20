package com.transsion.videodetail.provider;

import android.content.Context;
import androidx.core.os.c;
import androidx.fragment.app.Fragment;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.transsion.moviedetail.fragment.ForYouFragment;
import com.transsion.moviedetail.fragment.HotFragment;
import com.transsion.moviedetail.fragment.SubjectEduHeaderFragment;
import com.transsion.moviedetailapi.PostRankType;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.DubsInfo;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.videodetail.SubjectDetailHeaderFragment;
import com.transsion.videodetail.VideoDetailAudioTrackSelectDialog;
import com.transsion.videodetail.api.IStreamDetailService;
import com.transsion.videodetail.music.ui.SubjectMusicHeaderFragment;
import com.transsion.web.api.WebConstants;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

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
@Route(path = "/stream/details")
@Metadata
public final class StreamDetailServiceImpl implements IStreamDetailService {
    @Override // com.transsion.videodetail.api.IStreamDetailService
    public void K0(Fragment targetFragment, int i11, String subjectId, final Function1<? super DubsInfo, Unit> callback) {
        Intrinsics.g(targetFragment, "targetFragment");
        Intrinsics.g(subjectId, "subjectId");
        Intrinsics.g(callback, "callback");
        VideoDetailAudioTrackSelectDialog videoDetailAudioTrackSelectDialog = new VideoDetailAudioTrackSelectDialog();
        videoDetailAudioTrackSelectDialog.e1(subjectId);
        videoDetailAudioTrackSelectDialog.T0(targetFragment, i11);
        videoDetailAudioTrackSelectDialog.d1(new Function1<DubsInfo, Unit>() { // from class: com.transsion.videodetail.provider.StreamDetailServiceImpl$showAudioTrackFragment$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DubsInfo dubsInfo) {
                invoke2(dubsInfo);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DubsInfo it) {
                Intrinsics.g(it, "it");
                callback.invoke(it);
            }
        });
    }

    @Override // com.transsion.videodetail.api.IStreamDetailService
    public Fragment V(String str, String str2) {
        return HotFragment.D.a(str, str2, PostRankType.POST_RANK_TYPE_HOT);
    }

    @Override // com.transsion.videodetail.api.IStreamDetailService
    public Fragment a1(String str, Integer num, String str2, String str3, boolean z11, boolean z12) {
        return ForYouFragment.f53462z.a(str, num, str2, str3, z11, z12);
    }

    @Override // com.alibaba.android.arouter.facade.template.IProvider
    public void init(Context context) {
    }

    @Override // com.transsion.videodetail.api.IStreamDetailService
    public Fragment t0(Subject subject, String pageName, String str, boolean z11, boolean z12) {
        Fragment subjectMusicHeaderFragment;
        Intrinsics.g(pageName, "pageName");
        Integer subjectType = subject != null ? subject.getSubjectType() : null;
        int value = SubjectType.EDUCATION.getValue();
        if (subjectType != null && subjectType.intValue() == value) {
            subjectMusicHeaderFragment = new SubjectEduHeaderFragment();
        } else {
            subjectMusicHeaderFragment = (subjectType != null && subjectType.intValue() == SubjectType.MUSIC.getValue()) ? new SubjectMusicHeaderFragment() : new SubjectDetailHeaderFragment();
        }
        Pair[] pairArr = new Pair[8];
        pairArr[0] = TuplesKt.a("data_key_resource_detectors", subject);
        pairArr[1] = TuplesKt.a("ops", subject != null ? subject.getOps() : null);
        pairArr[2] = TuplesKt.a("module_name", str);
        pairArr[3] = TuplesKt.a("id", subject != null ? subject.getSubjectId() : null);
        pairArr[4] = TuplesKt.a("season", Integer.valueOf(subject != null ? subject.getSeason() : 0));
        pairArr[5] = TuplesKt.a(WebConstants.PAGE_FROM, pageName);
        pairArr[6] = TuplesKt.a("is_Intercept_detail", Boolean.valueOf(z11));
        pairArr[7] = TuplesKt.a("isOutsideVideo", Boolean.valueOf(z12));
        subjectMusicHeaderFragment.setArguments(c.b(pairArr));
        return subjectMusicHeaderFragment;
    }
}
