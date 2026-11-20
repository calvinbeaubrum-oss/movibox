package com.transsion.home.adapter.suboperate.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.blankj.utilcode.util.d0;
import com.blankj.utilcode.util.f0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.baseui.R$mipmap;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.edcation.CourseManager;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;
import com.transsion.home.fragment.tab.SubTabFragment;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Subject;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class m extends BaseQuickAdapter<Subject, BaseViewHolder> {
    public final int H;
    public final float I;
    public final float J;
    public Function2<? super Integer, ? super Subject, Unit> K;

    public m(int i11, int i12) {
        super(i11, null, 2, null);
        this.H = i12;
        float fE = (d0.e() - f0.a(32.0f)) / 2.0f;
        this.I = fE;
        this.J = (fE * 9.0f) / 16;
    }

    public /* synthetic */ m(int i11, int i12, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this((i13 & 1) != 0 ? R$layout.item_sub_operation_ranking_education : i11, i12);
    }

    public static final void J0(Subject item, m this$0, View view) {
        Intrinsics.g(item, "$item");
        Intrinsics.g(this$0, "this$0");
        CourseManager.q(CourseManager.f51853a, item, null, 2, null);
        ct.a.b(item, SubTabFragment.f52541r.a(this$0.H), "opt_ranking");
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* JADX INFO: renamed from: H0, reason: merged with bridge method [inline-methods] */
    public void x(BaseViewHolder holder, final Subject item) {
        String url;
        String thumbnail;
        Intrinsics.g(holder, "holder");
        Intrinsics.g(item, "item");
        holder.setText(R$id.sub_operation_ranking_education_title, item.getTitle());
        holder.setText(R$id.sub_operation_ranking_education_tag, defpackage.a.b(getContext(), item));
        ImageView imageView = (ImageView) holder.getView(R$id.sub_operation_ranking_education_cover);
        imageView.getLayoutParams().height = (int) this.J;
        ImageHelper.Companion companion = ImageHelper.f51371a;
        Context context = imageView.getContext();
        Intrinsics.f(context, "context");
        Cover cover = item.getCover();
        if (cover == null || (url = cover.getUrl()) == null) {
            url = "";
        }
        int i11 = (int) this.I;
        Cover cover2 = item.getCover();
        if (cover2 == null || (thumbnail = cover2.getThumbnail()) == null) {
            thumbnail = "";
        }
        companion.q(context, imageView, url, (8120 & 8) != 0 ? companion.d() : i11, (8120 & 16) != 0 ? companion.c() : 0, (8120 & 32) != 0, (8120 & 64) != 0 ? "" : thumbnail, (8120 & 128) != 0, (8120 & 256) != 0, (8120 & 512) != 0 ? false : false, (8120 & 1024) != 0 ? false : false, (8120 & 2048) != 0 ? false : false, (8120 & 4096) != 0 ? 25 : 0);
        ((ImageView) holder.getView(R$id.sub_operation_ranking_education_add_icon)).setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.suboperate.adapter.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                m.J0(item, this, view);
            }
        });
        Integer seenStatus = item.getSeenStatus();
        L0(holder, seenStatus != null ? seenStatus.intValue() : 0);
        Function2<? super Integer, ? super Subject, Unit> function2 = this.K;
        if (function2 != null) {
            function2.invoke(Integer.valueOf(P(item)), item);
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* JADX INFO: renamed from: I0, reason: merged with bridge method [inline-methods] */
    public void y(BaseViewHolder holder, Subject item, List<? extends Object> payloads) {
        Intrinsics.g(holder, "holder");
        Intrinsics.g(item, "item");
        Intrinsics.g(payloads, "payloads");
        if (payloads.isEmpty()) {
            return;
        }
        Object obj = payloads.get(payloads.size() - 1);
        if (obj instanceof Integer) {
            L0(holder, ((Number) obj).intValue());
        }
    }

    public final void K0(Function2<? super Integer, ? super Subject, Unit> listener) {
        Intrinsics.g(listener, "listener");
        this.K = listener;
    }

    public final void L0(BaseViewHolder baseViewHolder, int i11) {
        baseViewHolder.setImageResource(R$id.sub_operation_ranking_education_add_icon, i11 == 1 ? R$mipmap.ic_added : R$mipmap.ic_add);
    }
}
