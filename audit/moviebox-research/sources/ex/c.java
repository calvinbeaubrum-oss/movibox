package ex;

import android.app.Activity;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blankj.utilcode.util.KeyboardUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.tn.lib.widget.R$string;
import com.transsion.baselib.utils.i;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.search.R$drawable;
import com.transsion.search.R$id;
import com.transsion.search.R$layout;
import com.transsion.search.bean.GroupInfo;
import com.transsion.search.fragment.hot.SearchHotFragment;
import h9.j;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@SourceDebugExtension
public final class c extends BaseQuickAdapter<GroupInfo, BaseViewHolder> implements j {
    public final String H;
    public final int I;
    public final boolean J;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(String parentCategory, int i11) {
        super(R$layout.provider_result_group, null, 2, null);
        Intrinsics.g(parentCategory, "parentCategory");
        this.H = parentCategory;
        this.I = i11;
        this.J = com.transsion.baselib.utils.g.f51315a.b();
    }

    public static final void I0(c this$0, GroupInfo item, View view) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(item, "$item");
        this$0.J0(item);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* JADX INFO: renamed from: H0, reason: merged with bridge method [inline-methods] */
    public void x(BaseViewHolder holder, final GroupInfo item) {
        int i11;
        Intrinsics.g(holder, "holder");
        Intrinsics.g(item, "item");
        ShapeableImageView shapeableImageView = (ShapeableImageView) holder.getView(R$id.search_result_provider_group_cover);
        ViewGroup.LayoutParams layoutParams = shapeableImageView.getLayoutParams();
        Intrinsics.e(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
        tp.f fVar = tp.f.f77260a;
        Context context = shapeableImageView.getContext();
        Intrinsics.f(context, "this.context");
        bVar.setMarginStart(fVar.a(context, 12.0f));
        shapeableImageView.setLayoutParams(bVar);
        ImageHelper.Companion companion = ImageHelper.f51371a;
        Context context2 = getContext();
        String url = item.getCover().getUrl();
        if (url == null) {
            url = "";
        }
        String thumbnail = item.getCover().getThumbnail();
        if (thumbnail == null) {
            thumbnail = "";
        }
        companion.q(context2, shapeableImageView, url, (8120 & 8) != 0 ? companion.d() : 0, (8120 & 16) != 0 ? companion.c() : 0, (8120 & 32) != 0, (8120 & 64) != 0 ? "" : thumbnail, (8120 & 128) != 0, (8120 & 256) != 0, (8120 & 512) != 0 ? false : false, (8120 & 1024) != 0 ? false : false, (8120 & 2048) != 0 ? false : false, (8120 & 4096) != 0 ? 25 : 0);
        int iP = P(item);
        if (iP == 0) {
            i11 = R$drawable.bg_hot_subject_no1;
        } else if (iP != 1) {
            i11 = iP != 2 ? R$drawable.bg_hot_subject_no4 : R$drawable.bg_hot_subject_no3;
        } else {
            i11 = R$drawable.bg_hot_subject_no2;
        }
        holder.setVisible(R$id.search_result_provider_group_index_text, true);
        holder.setBackgroundResource(R$id.search_result_provider_group_index_text, i11);
        holder.setText(R$id.search_result_provider_group_index_text, String.valueOf(iP + 1));
        holder.setText(R$id.search_result_provider_group_title, item.getName());
        Long userCount = item.getUserCount();
        String strA = userCount != null ? i.a(userCount.longValue()) : null;
        Context context3 = getContext();
        int i12 = R$string.members;
        Object[] objArr = new Object[1];
        if (strA == null) {
            strA = "0";
        }
        objArr[0] = strA;
        CharSequence string = context3.getString(i12, objArr);
        Intrinsics.f(string, "context.getString(com.tn…mbers, userCountStr?:\"0\")");
        holder.setText(R$id.search_result_provider_group_member, string);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        List<String> tags = item.getTags();
        if (tags != null) {
            int i13 = 0;
            for (Object obj : tags) {
                int i14 = i13 + 1;
                if (i13 < 0) {
                    kotlin.collections.g.u();
                }
                spannableStringBuilder.append((CharSequence) obj);
                List<String> tags2 = item.getTags();
                if (i13 < (tags2 != null ? tags2.size() : 0) - 1) {
                    spannableStringBuilder.append((CharSequence) "￼");
                    spannableStringBuilder.setSpan(xw.f.b(getContext()), spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 33);
                }
                i13 = i14;
            }
        }
        if (spannableStringBuilder.length() > 0) {
            holder.setText(R$id.search_result_provider_group_des, spannableStringBuilder);
            holder.setVisible(R$id.search_result_provider_group_des, true);
        } else {
            holder.setGone(R$id.search_result_provider_group_des, true);
        }
        holder.setVisible(R$id.search_result_provider_group_arrow, false);
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: ex.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c.I0(this.f64462a, item, view);
            }
        });
    }

    public final void J0(GroupInfo groupInfo) {
        K0(groupInfo.getGroupId(), groupInfo.getOps(), P(groupInfo));
        if (getContext() instanceof Activity) {
            Context context = getContext();
            Intrinsics.e(context, "null cannot be cast to non-null type android.app.Activity");
            if (KeyboardUtils.g((Activity) context)) {
                Context context2 = getContext();
                Intrinsics.e(context2, "null cannot be cast to non-null type android.app.Activity");
                KeyboardUtils.d((Activity) context2);
            }
        }
        com.alibaba.android.arouter.launcher.a.d().b("/room/detail").withString("id", groupInfo.getGroupId()).navigation();
    }

    public final void K0(String str, String str2, int i11) {
        HashMap map = new HashMap();
        map.put("event_type", "hot_rank_click");
        if (str == null) {
            str = "";
        }
        map.put("group_id", str);
        map.put("index", String.valueOf(i11));
        if (str2 == null) {
            str2 = "";
        }
        map.put("ops", str2);
        map.put("lowMemoryDevice", String.valueOf(this.J));
        map.put("parentTitle", this.H);
        map.put("parentIndex", String.valueOf(this.I));
        com.transsion.baselib.helper.a.f51183a.e(SearchHotFragment.PAGE_NAME, map);
    }

    @Override // h9.j
    public /* synthetic */ h9.f a(BaseQuickAdapter baseQuickAdapter) {
        return h9.i.a(this, baseQuickAdapter);
    }
}
