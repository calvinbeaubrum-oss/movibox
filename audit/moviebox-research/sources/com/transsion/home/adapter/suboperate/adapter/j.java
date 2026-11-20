package com.transsion.home.adapter.suboperate.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.blankj.utilcode.util.d0;
import com.blankj.utilcode.util.f0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.banner.R$mipmap;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.edcation.CourseManager;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;
import com.transsion.home.fragment.tab.SubTabFragment;
import com.transsion.home.utils.HomeUtilsKt;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.OperateItem;
import com.transsion.moviedetailapi.bean.RankingListItem;
import com.transsion.moviedetailapi.bean.Subject;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public final class j extends BaseQuickAdapter<RankingListItem, BaseViewHolder> {
    public final OperateItem H;
    public final int I;
    public final int J;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(int i11, OperateItem operateItem, int i12) {
        super(i11, null, 2, null);
        Intrinsics.g(operateItem, "operateItem");
        this.H = operateItem;
        this.I = i12;
        this.J = Math.min(d0.e(), d0.c()) - f0.a(54.0f);
    }

    public /* synthetic */ j(int i11, OperateItem operateItem, int i12, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this((i13 & 1) != 0 ? R$layout.item_provider_ranklist : i11, operateItem, i12);
    }

    public static final void K0(Subject subject, j this$0, RankingListItem item, int i11, View view) {
        Intrinsics.g(subject, "$subject");
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(item, "$item");
        HomeUtilsKt.b(subject, "opt_ranking_list");
        this$0.P0(item, i11);
    }

    private final int L0(int i11) {
        if (i11 == 0) {
            return R$mipmap.ic_rank_01;
        }
        if (i11 != 1) {
            return i11 != 2 ? R$mipmap.ic_rank_defalut : R$mipmap.ic_rank_03;
        }
        return R$mipmap.ic_rank_02;
    }

    public static final void N0(Subject subject, j this$0, View view) {
        Intrinsics.g(subject, "$subject");
        Intrinsics.g(this$0, "this$0");
        CourseManager.q(CourseManager.f51853a, subject, null, 2, null);
        ct.a.b(subject, SubTabFragment.f52541r.a(this$0.I), "opt_banner");
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* JADX INFO: renamed from: I0, reason: merged with bridge method [inline-methods] */
    public void x(BaseViewHolder holder, final RankingListItem item) {
        Intrinsics.g(holder, "holder");
        Intrinsics.g(item, "item");
        LinearLayout linearLayout = (LinearLayout) holder.getView(R$id.sub_operation_rankinglist_root);
        linearLayout.removeAllViews();
        ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
        layoutParams.width = this.J;
        linearLayout.setLayoutParams(layoutParams);
        List<Subject> subjects = item.getSubjects();
        if (subjects != null) {
            final int i11 = 0;
            for (Object obj : subjects) {
                int i12 = i11 + 1;
                if (i11 < 0) {
                    kotlin.collections.g.u();
                }
                final Subject subject = (Subject) obj;
                View viewM0 = M0(getContext(), subject, linearLayout, i11);
                linearLayout.addView(viewM0);
                viewM0.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.suboperate.adapter.h
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        j.K0(subject, this, item, i11, view);
                    }
                });
                O0(item, i11);
                i11 = i12;
            }
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* JADX INFO: renamed from: J0, reason: merged with bridge method [inline-methods] */
    public void y(BaseViewHolder holder, RankingListItem item, List<? extends Object> payloads) {
        Integer seenStatus;
        Intrinsics.g(holder, "holder");
        Intrinsics.g(item, "item");
        Intrinsics.g(payloads, "payloads");
        super.y(holder, item, payloads);
        int iIntValue = 0;
        Subject subject = (Subject) payloads.get(0);
        List<Subject> subjects = item.getSubjects();
        int iJ0 = subjects != null ? CollectionsKt___CollectionsKt.j0(subjects, subject) : -1;
        LinearLayout linearLayout = (LinearLayout) holder.getView(R$id.sub_operation_rankinglist_root);
        if (iJ0 < 0 || iJ0 >= linearLayout.getChildCount()) {
            return;
        }
        ImageView imageView = (ImageView) linearLayout.getChildAt(iJ0).findViewById(R$id.sub_operation_rankinglist_add_icon);
        Intrinsics.f(imageView, "imageView");
        if (subject != null && (seenStatus = subject.getSeenStatus()) != null) {
            iIntValue = seenStatus.intValue();
        }
        Q0(imageView, iIntValue);
    }

    public final View M0(Context context, final Subject subject, ViewGroup viewGroup, int i11) {
        String strValueOf;
        String url;
        View view = LayoutInflater.from(context).inflate(R$layout.item_provider_ranklist_items, viewGroup, false);
        View viewFindViewById = view.findViewById(R$id.sub_operation_rankinglist_cover);
        Intrinsics.f(viewFindViewById, "view.findViewById(R.id.s…ration_rankinglist_cover)");
        ShapeableImageView shapeableImageView = (ShapeableImageView) viewFindViewById;
        ImageHelper.Companion companion = ImageHelper.f51371a;
        Cover cover = subject.getCover();
        companion.r(context, shapeableImageView, (cover == null || (url = cover.getUrl()) == null) ? "" : url, (4088 & 8) != 0 ? companion.d() : 0, (4088 & 16) != 0 ? companion.c() : 0, (4088 & 32) != 0, (4088 & 64) != 0, (4088 & 128) != 0, (4088 & 256) != 0 ? false : false, (4088 & 512) != 0 ? false : false, (4088 & 1024) != 0 ? false : false, (4088 & 2048) != 0 ? 25 : 0);
        ((TextView) view.findViewById(R$id.sub_operation_rankinglist_title)).setText(subject.getTitle());
        ((TextView) view.findViewById(R$id.sub_operation_rankinglist_tag)).setText(defpackage.a.b(context, subject));
        ImageView subscribeIcon = (ImageView) view.findViewById(R$id.sub_operation_rankinglist_add_icon);
        if (subscribeIcon != null) {
            subscribeIcon.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.suboperate.adapter.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    j.N0(subject, this, view2);
                }
            });
        }
        Intrinsics.f(subscribeIcon, "subscribeIcon");
        Integer seenStatus = subject.getSeenStatus();
        Q0(subscribeIcon, seenStatus != null ? seenStatus.intValue() : 0);
        AppCompatImageView appCompatImageView = (AppCompatImageView) view.findViewById(R$id.sub_operation_rankinglist_rank);
        if (appCompatImageView != null) {
            appCompatImageView.setImageResource(L0(i11));
        }
        TextView textView = (TextView) view.findViewById(R$id.sub_operation_rankinglist_text);
        if (i11 > 2) {
            if (i11 < 9) {
                strValueOf = "0" + (i11 + 1);
            } else {
                strValueOf = String.valueOf(i11 + 1);
            }
            textView.setText(strValueOf);
        } else {
            textView.setText("");
        }
        Intrinsics.f(view, "view");
        return view;
    }

    public final void O0(RankingListItem rankingListItem, int i11) {
        List<Subject> subjects = rankingListItem.getSubjects();
        Subject subject = subjects != null ? subjects.get(i11) : null;
        HashMap map = new HashMap();
        map.put("event_type", "browse_rank_list_item");
        map.put("sequence", String.valueOf(i11));
        map.put("subject_type", String.valueOf(subject != null ? subject.getSubjectType() : null));
        map.put("tabId", String.valueOf(this.I));
        String title = rankingListItem.getTitle();
        if (title == null) {
            title = "";
        }
        map.put("groupTitle", title);
        ot.b.a(this.H, map);
        if (subject != null) {
            ot.b.c(subject, map);
        }
        com.transsion.baselib.helper.a.f51183a.d(SubTabFragment.f52541r.a(this.I), map);
    }

    public final void P0(RankingListItem rankingListItem, int i11) {
        List<Subject> subjects = rankingListItem.getSubjects();
        Subject subject = subjects != null ? subjects.get(i11) : null;
        HashMap map = new HashMap();
        map.put("event_type", "click_rank_list_item");
        map.put("sequence", String.valueOf(i11));
        map.put("subject_type", String.valueOf(subject != null ? subject.getSubjectType() : null));
        map.put("tabId", String.valueOf(this.I));
        String title = rankingListItem.getTitle();
        if (title == null) {
            title = "";
        }
        map.put("groupTitle", title);
        ot.b.a(this.H, map);
        if (subject != null) {
            ot.b.c(subject, map);
        }
        com.transsion.baselib.helper.a.f51183a.b(SubTabFragment.f52541r.a(this.I), map);
    }

    public final void Q0(ImageView imageView, int i11) {
        imageView.setImageResource(i11 == 1 ? com.transsion.baseui.R$mipmap.ic_added : com.transsion.baseui.R$mipmap.ic_add);
    }
}
