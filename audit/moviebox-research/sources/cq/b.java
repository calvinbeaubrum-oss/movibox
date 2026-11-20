package cq;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tn.lib.tranpay.R$drawable;
import com.tn.lib.tranpay.R$id;
import com.tn.lib.tranpay.R$layout;
import com.tn.tranpay.bean.MediumInputBean;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
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
public final class b extends BaseQuickAdapter<MediumInputBean, BaseViewHolder> {
    public final boolean H;
    public final String I;
    public MediumInputBean J;
    public Function2<? super MediumInputBean, ? super View, Unit> K;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(List<MediumInputBean> dataList, boolean z11, String str) {
        super(R$layout.tran_item_pay_method, dataList);
        Intrinsics.g(dataList, "dataList");
        this.H = z11;
        this.I = str;
    }

    public static final void I0(b this$0, MediumInputBean item, BaseViewHolder holder, View view) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(item, "$item");
        Intrinsics.g(holder, "$holder");
        this$0.J = item;
        Function2<? super MediumInputBean, ? super View, Unit> function2 = this$0.K;
        if (function2 != null) {
            View view2 = holder.itemView;
            Intrinsics.f(view2, "holder.itemView");
            function2.invoke(item, view2);
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* JADX INFO: renamed from: H0, reason: merged with bridge method [inline-methods] */
    public void x(final BaseViewHolder holder, final MediumInputBean item) {
        Intrinsics.g(holder, "holder");
        Intrinsics.g(item, "item");
        ((AppCompatTextView) holder.getView(R$id.iv_title)).setText(item.getName());
        AppCompatImageView appCompatImageView = (AppCompatImageView) holder.getView(R$id.iv_icon);
        Glide.with(appCompatImageView.getContext()).load2(item.getLogo()).placeholder(R$drawable.placeholder).transition(DrawableTransitionOptions.withCrossFade()).into(appCompatImageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: cq.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b.I0(this.f62776a, item, holder, view);
            }
        });
        View view = holder.getView(R$id.iv_line);
        if (holder.getBindingAdapterPosition() == D().size() - 1) {
            view.setVisibility(8);
        } else {
            view.setVisibility(0);
        }
        AppCompatTextView appCompatTextView = (AppCompatTextView) holder.getView(R$id.iv_tag_recommend);
        AppCompatTextView appCompatTextView2 = (AppCompatTextView) holder.getView(R$id.iv_tag_frequently);
        if (this.I == null || !this.H) {
            if (holder.getBindingAdapterPosition() == 0) {
                appCompatTextView.setVisibility(0);
            } else {
                appCompatTextView.setVisibility(8);
            }
            appCompatTextView2.setVisibility(8);
            return;
        }
        if (Intrinsics.b(item.getCode(), this.I)) {
            appCompatTextView2.setVisibility(0);
        } else {
            appCompatTextView2.setVisibility(8);
        }
        appCompatTextView.setVisibility(8);
    }

    public final void J0(Function2<? super MediumInputBean, ? super View, Unit> clickCallback) {
        Intrinsics.g(clickCallback, "clickCallback");
        this.K = clickCallback;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return D().size();
    }
}
