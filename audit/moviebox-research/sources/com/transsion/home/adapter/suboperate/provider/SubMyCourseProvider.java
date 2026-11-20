package com.transsion.home.adapter.suboperate.provider;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.f0;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.video.VideoDetailPlayDao;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.edcation.bean.CourseBean;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;
import com.transsion.home.fragment.tab.SubTabFragment;
import com.transsion.home.utils.HomeUtilsKt;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.OperateItem;
import com.transsion.moviedetailapi.bean.PostItemType;
import com.transsion.moviedetailapi.bean.Subject;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.q1;
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
public final class SubMyCourseProvider extends BaseItemProvider<OperateItem> implements androidx.lifecycle.f {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f52150f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public q1 f52151g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public BaseViewHolder f52152h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public CourseBean f52153i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f52154j = LazyKt__LazyJVMKt.b(new Function0<VideoDetailPlayDao>() { // from class: com.transsion.home.adapter.suboperate.provider.SubMyCourseProvider$mVideoDetailPlayDao$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final VideoDetailPlayDao invoke() {
            AppDatabase.v0 v0Var = AppDatabase.f51036p;
            Application applicationA = Utils.a();
            Intrinsics.f(applicationA, "getApp()");
            return v0Var.b(applicationA).O0();
        }
    });

    public SubMyCourseProvider(int i11) {
        this.f52150f = i11;
    }

    public static final void G(View view) {
        com.alibaba.android.arouter.launcher.a.d().b("/edu/courseList").navigation();
    }

    public static final void H(SubMyCourseProvider this$0, OperateItem item, View view) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(item, "$item");
        com.alibaba.android.arouter.launcher.a.d().b("/home/filter").withInt("tabId", this$0.f52150f).navigation();
        this$0.N("click_my_course_explore", item);
    }

    public static final void I(SubMyCourseProvider this$0, OperateItem item, View view) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(item, "$item");
        CourseBean courseBean = this$0.f52153i;
        if ((courseBean != null ? courseBean.getSubjectId() : null) != null) {
            CourseBean courseBean2 = this$0.f52153i;
            String subjectId = courseBean2 != null ? courseBean2.getSubjectId() : null;
            CourseBean courseBean3 = this$0.f52153i;
            HomeUtilsKt.b(new Subject(subjectId, courseBean3 != null ? courseBean3.getSubjectType() : null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, false, null, null, null, null, null, false, false, null, null, 0, false, false, 0L, null, null, 0L, null, 0, false, null, 0, null, null, null, null, null, null, null, -4, 4194303, null), "operation_course");
        }
        this$0.N("click_my_course_learn", item);
    }

    public static final void K(SubMyCourseProvider this$0) {
        Intrinsics.g(this$0, "this$0");
        this$0.Q();
    }

    private final void L() {
        this.f52151g = kotlinx.coroutines.j.d(l0.a(w0.b()), null, null, new SubMyCourseProvider$registerCourse$1(this, null), 3, null);
    }

    public static final void P(BaseViewHolder baseViewHolder, View view, float f11) {
        View view2 = baseViewHolder.getView(R$id.sub_operation_course_item_percent_view);
        view2.getLayoutParams().width = (int) ((view.getWidth() * f11) / 100);
        view2.setLayoutParams(view2.getLayoutParams());
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* JADX INFO: renamed from: F, reason: merged with bridge method [inline-methods] */
    public void a(BaseViewHolder helper, final OperateItem item) {
        Intrinsics.g(helper, "helper");
        Intrinsics.g(item, "item");
        helper.getView(R$id.sub_operation_course_title).setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.suboperate.provider.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SubMyCourseProvider.G(view);
            }
        });
        helper.getView(R$id.sub_operation_course_explore).setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.suboperate.provider.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SubMyCourseProvider.H(this.f52207a, item, view);
            }
        });
        helper.getView(R$id.sub_operation_course_learn).setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.suboperate.provider.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SubMyCourseProvider.I(this.f52209a, item, view);
            }
        });
        M(item);
    }

    public final VideoDetailPlayDao J() {
        return (VideoDetailPlayDao) this.f52154j.getValue();
    }

    public final void M(OperateItem operateItem) {
        HashMap map = new HashMap();
        map.put("event_type", "browse_my_course");
        map.put(CampaignEx.JSON_KEY_TITLE, String.valueOf(operateItem.getTitle()));
        map.put("tabId", String.valueOf(this.f52150f));
        com.transsion.baselib.helper.a.f51183a.a(SubTabFragment.f52541r.a(this.f52150f), map);
    }

    public final void N(String str, OperateItem operateItem) {
        String subjectId;
        HashMap map = new HashMap();
        map.put("event_type", str);
        map.put(CampaignEx.JSON_KEY_TITLE, String.valueOf(operateItem.getTitle()));
        map.put("tabId", String.valueOf(this.f52150f));
        CourseBean courseBean = this.f52153i;
        if (courseBean == null || (subjectId = courseBean.getSubjectId()) == null) {
            subjectId = "";
        }
        map.put("subjectId", subjectId);
        com.transsion.baselib.helper.a.f51183a.e(SubTabFragment.f52541r.a(this.f52150f), map);
    }

    public final void O(final BaseViewHolder baseViewHolder, final float f11) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.f68912a;
        String str = String.format("%.0f", Arrays.copyOf(new Object[]{Float.valueOf(f11)}, 1));
        Intrinsics.f(str, "format(...)");
        String str2 = str + "%";
        TextView textView = baseViewHolder != null ? (TextView) baseViewHolder.getView(R$id.sub_operation_course_item_percent_text) : null;
        if (textView != null) {
            textView.setText(str2);
        }
        final View view = baseViewHolder != null ? baseViewHolder.getView(R$id.sub_operation_course_item_percent_bg) : null;
        if (view != null) {
            view.post(new Runnable() { // from class: com.transsion.home.adapter.suboperate.provider.q
                @Override // java.lang.Runnable
                public final void run() {
                    SubMyCourseProvider.P(baseViewHolder, view, f11);
                }
            });
        }
    }

    public final void Q() {
        String title;
        ImageView imageView;
        Cover cover;
        String thumbnail;
        Cover cover2;
        String url;
        View view;
        View view2;
        View view3;
        View view4;
        if (this.f52153i == null) {
            BaseViewHolder baseViewHolder = this.f52152h;
            if (baseViewHolder != null && (view4 = baseViewHolder.getView(R$id.sub_operation_course_start_liner)) != null) {
                so.c.k(view4);
            }
            BaseViewHolder baseViewHolder2 = this.f52152h;
            if (baseViewHolder2 == null || (view3 = baseViewHolder2.getView(R$id.sub_operation_course_item_liner)) == null) {
                return;
            }
            so.c.h(view3);
            return;
        }
        BaseViewHolder baseViewHolder3 = this.f52152h;
        if (baseViewHolder3 != null && (view2 = baseViewHolder3.getView(R$id.sub_operation_course_start_liner)) != null) {
            so.c.h(view2);
        }
        BaseViewHolder baseViewHolder4 = this.f52152h;
        if (baseViewHolder4 != null && (view = baseViewHolder4.getView(R$id.sub_operation_course_item_liner)) != null) {
            so.c.k(view);
        }
        BaseViewHolder baseViewHolder5 = this.f52152h;
        String str = "";
        if (baseViewHolder5 != null && (imageView = (ImageView) baseViewHolder5.getView(R$id.sub_operation_course_item_image)) != null) {
            ImageHelper.Companion companion = ImageHelper.f51371a;
            Context context = imageView.getContext();
            Intrinsics.f(context, "it.context");
            CourseBean courseBean = this.f52153i;
            String str2 = (courseBean == null || (cover2 = courseBean.getCover()) == null || (url = cover2.getUrl()) == null) ? "" : url;
            int iA = f0.a(80.0f);
            CourseBean courseBean2 = this.f52153i;
            companion.q(context, imageView, str2, (8120 & 8) != 0 ? companion.d() : iA, (8120 & 16) != 0 ? companion.c() : 0, (8120 & 32) != 0, (8120 & 64) != 0 ? "" : (courseBean2 == null || (cover = courseBean2.getCover()) == null || (thumbnail = cover.getThumbnail()) == null) ? "" : thumbnail, (8120 & 128) != 0, (8120 & 256) != 0, (8120 & 512) != 0 ? false : false, (8120 & 1024) != 0 ? false : false, (8120 & 2048) != 0 ? false : false, (8120 & 4096) != 0 ? 25 : 0);
        }
        CourseBean courseBean3 = this.f52153i;
        if (courseBean3 != null && (title = courseBean3.getTitle()) != null) {
            str = title;
        }
        BaseViewHolder baseViewHolder6 = this.f52152h;
        TextView textView = baseViewHolder6 != null ? (TextView) baseViewHolder6.getView(R$id.sub_operation_course_item_title_text) : null;
        if (textView != null) {
            textView.setText(str);
        }
        kotlinx.coroutines.j.d(l0.a(w0.b()), null, null, new SubMyCourseProvider$updateCurrentCourse$2(this, null), 3, null);
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int h() {
        return PostItemType.MY_COURSE.ordinal();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int i() {
        return R$layout.item_sub_operation_my_course;
    }

    @Override // androidx.lifecycle.f
    public /* synthetic */ void onCreate(androidx.lifecycle.u uVar) {
        androidx.lifecycle.e.a(this, uVar);
    }

    @Override // androidx.lifecycle.f
    public /* synthetic */ void onDestroy(androidx.lifecycle.u uVar) {
        androidx.lifecycle.e.b(this, uVar);
    }

    @Override // androidx.lifecycle.f
    public /* synthetic */ void onPause(androidx.lifecycle.u uVar) {
        androidx.lifecycle.e.c(this, uVar);
    }

    @Override // androidx.lifecycle.f
    public void onResume(androidx.lifecycle.u owner) {
        Intrinsics.g(owner, "owner");
        androidx.lifecycle.e.d(this, owner);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.transsion.home.adapter.suboperate.provider.r
            @Override // java.lang.Runnable
            public final void run() {
                SubMyCourseProvider.K(this.f52206a);
            }
        }, 1000L);
    }

    @Override // androidx.lifecycle.f
    public /* synthetic */ void onStart(androidx.lifecycle.u uVar) {
        androidx.lifecycle.e.e(this, uVar);
    }

    @Override // androidx.lifecycle.f
    public /* synthetic */ void onStop(androidx.lifecycle.u uVar) {
        androidx.lifecycle.e.f(this, uVar);
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public void p(BaseViewHolder holder) {
        Intrinsics.g(holder, "holder");
        super.p(holder);
        this.f52152h = holder;
        if (this.f52151g == null) {
            L();
        }
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public void q(BaseViewHolder holder) {
        Intrinsics.g(holder, "holder");
        super.q(holder);
        this.f52152h = null;
        q1 q1Var = this.f52151g;
        if (q1Var != null) {
            q1.a.b(q1Var, null, 1, null);
        }
        this.f52151g = null;
    }
}
