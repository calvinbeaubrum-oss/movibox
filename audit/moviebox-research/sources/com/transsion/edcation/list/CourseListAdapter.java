package com.transsion.edcation.list;

import android.app.Application;
import android.view.View;
import com.alibaba.android.arouter.facade.Postcard;
import com.blankj.utilcode.util.Utils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.video.VideoDetailPlayDao;
import com.transsion.edcation.R$id;
import com.transsion.edcation.R$layout;
import com.transsion.edcation.bean.CourseBean;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.Cover;
import h9.f;
import h9.i;
import h9.j;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public final class CourseListAdapter extends BaseQuickAdapter<CourseBean, BaseViewHolder> implements j {
    public final Lazy H;

    public CourseListAdapter(int i11) {
        super(i11, null, 2, null);
        this.H = LazyKt__LazyJVMKt.b(new Function0<VideoDetailPlayDao>() { // from class: com.transsion.edcation.list.CourseListAdapter$mVideoDetailPlayDao$2
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

    public /* synthetic */ CourseListAdapter(int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? R$layout.item_my_course_list : i11);
    }

    public static final void J0(CourseListAdapter this$0, CourseBean item, View view) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(item, "$item");
        M0(this$0, item, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final VideoDetailPlayDao K0() {
        return (VideoDetailPlayDao) this.H.getValue();
    }

    public static /* synthetic */ void M0(CourseListAdapter courseListAdapter, CourseBean courseBean, String str, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str = null;
        }
        courseListAdapter.L0(courseBean, str);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* JADX INFO: renamed from: I0, reason: merged with bridge method [inline-methods] */
    public void x(BaseViewHolder holder, final CourseBean item) {
        String url;
        Intrinsics.g(holder, "holder");
        Intrinsics.g(item, "item");
        holder.setText(R$id.item_title, item.getTitle());
        ShapeableImageView shapeableImageView = (ShapeableImageView) holder.getViewOrNull(R$id.item_image);
        if (shapeableImageView != null) {
            Cover cover = item.getCover();
            if (cover == null || (url = cover.getUrl()) == null) {
                url = "";
            }
            qw.a.b(shapeableImageView, url, 12.0f);
        }
        so.c.j(holder.getView(R$id.item_jump), true);
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.edcation.list.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CourseListAdapter.J0(this.f51893a, item, view);
            }
        });
        kotlinx.coroutines.j.d(l0.a(w0.b()), null, null, new CourseListAdapter$convert$2(this, item, holder, null), 3, null);
    }

    public final void L0(CourseBean courseBean, String str) {
        if (courseBean == null) {
            return;
        }
        Postcard postcardB = com.alibaba.android.arouter.launcher.a.d().b("/movie/detail");
        Integer subjectType = courseBean.getSubjectType();
        postcardB.withInt("subject_type", subjectType != null ? subjectType.intValue() : SubjectType.EDUCATION.getValue()).withString("id", courseBean.getSubjectId()).withString("module_name", str).withBoolean("autoPlay", true).navigation();
    }

    @Override // h9.j
    public /* synthetic */ f a(BaseQuickAdapter baseQuickAdapter) {
        return i.a(this, baseQuickAdapter);
    }
}
