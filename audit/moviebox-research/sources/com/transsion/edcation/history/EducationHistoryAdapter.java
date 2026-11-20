package com.transsion.edcation.history;

import android.app.Application;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.blankj.utilcode.util.Utils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.video.VideoDetailPlayBean;
import com.transsion.baselib.db.video.VideoDetailPlayDao;
import com.transsion.baselib.utils.m;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.edcation.R$id;
import com.transsion.edcation.R$layout;
import com.transsion.moviedetailapi.SubjectType;
import com.transsnet.downloader.DownloadManagerApi;
import h9.f;
import h9.i;
import h9.j;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class EducationHistoryAdapter extends BaseQuickAdapter<VideoDetailPlayBean, BaseViewHolder> implements j {
    public final Lazy H;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EducationHistoryAdapter(List<VideoDetailPlayBean> data) {
        super(R$layout.item_education_history, data);
        Intrinsics.g(data, "data");
        this.H = LazyKt__LazyJVMKt.b(new Function0<VideoDetailPlayDao>() { // from class: com.transsion.edcation.history.EducationHistoryAdapter$mVideoDetailPlayDao$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final VideoDetailPlayDao invoke() {
                AppDatabase.v0 v0Var = AppDatabase.f51036p;
                Application applicationA = Utils.a();
                Intrinsics.f(applicationA, "getApp()");
                return v0Var.b(applicationA).O0();
            }
        });
    }

    public static final void K0(EducationHistoryAdapter this$0, VideoDetailPlayBean item, View view) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(item, "$item");
        this$0.M0(item, this$0.getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final VideoDetailPlayDao L0() {
        return (VideoDetailPlayDao) this.H.getValue();
    }

    public final void I0(VideoDetailPlayBean videoDetailPlayBean, TextView textView) {
        kotlinx.coroutines.j.d(l0.a(w0.b()), null, null, new EducationHistoryAdapter$calculateProgress$1(this, videoDetailPlayBean, textView, null), 3, null);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* JADX INFO: renamed from: J0, reason: merged with bridge method [inline-methods] */
    public void x(BaseViewHolder holder, final VideoDetailPlayBean item) {
        Intrinsics.g(holder, "holder");
        Intrinsics.g(item, "item");
        ShapeableImageView shapeableImageView = (ShapeableImageView) holder.getView(R$id.education_history_cover);
        ImageHelper.Companion companion = ImageHelper.f51371a;
        Context context = getContext();
        String coverUrl = item.getCoverUrl();
        if (coverUrl == null) {
            coverUrl = "";
        }
        companion.r(context, shapeableImageView, coverUrl, (4088 & 8) != 0 ? companion.d() : 0, (4088 & 16) != 0 ? companion.c() : 0, (4088 & 32) != 0, (4088 & 64) != 0, (4088 & 128) != 0, (4088 & 256) != 0 ? false : false, (4088 & 512) != 0 ? false : false, (4088 & 1024) != 0 ? false : false, (4088 & 2048) != 0 ? 25 : 0);
        holder.setText(R$id.education_history_title, item.getTitle());
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.edcation.history.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EducationHistoryAdapter.K0(this.f51889a, item, view);
            }
        });
        I0(item, (TextView) holder.getView(R$id.education_history_tag));
    }

    public final String M0(VideoDetailPlayBean videoDetailPlayBean, Context context) {
        if (!m.f51320a.b()) {
            DownloadManagerApi.a aVar = DownloadManagerApi.f60274j;
            if (DownloadManagerApi.n2(aVar.a(), videoDetailPlayBean != null ? videoDetailPlayBean.getSubjectId() : null, videoDetailPlayBean != null ? videoDetailPlayBean.getId() : null, false, false, 8, null) && (context instanceof FragmentActivity)) {
                if (videoDetailPlayBean != null && videoDetailPlayBean.getId() != null) {
                    aVar.a().j2((FragmentActivity) context, videoDetailPlayBean.getId(), "Education History");
                }
                return "play_subject";
            }
        }
        com.alibaba.android.arouter.launcher.a.d().b("/movie/detail").withInt("subject_type", SubjectType.EDUCATION.getValue()).withString("id", videoDetailPlayBean != null ? videoDetailPlayBean.getSubjectId() : null).withString("module_name", "Education History").navigation();
        return "play_subject";
    }

    @Override // h9.j
    public /* synthetic */ f a(BaseQuickAdapter baseQuickAdapter) {
        return i.a(this, baseQuickAdapter);
    }
}
