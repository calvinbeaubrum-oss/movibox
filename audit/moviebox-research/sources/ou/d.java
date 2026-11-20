package ou;

import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.member.R$id;
import com.transsion.member.R$layout;
import com.transsion.member.R$string;
import com.transsion.memberapi.SkuItem;
import java.math.BigDecimal;
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
public final class d extends BaseQuickAdapter<SkuItem, BaseViewHolder> {
    public AppCompatTextView H;
    public ConstraintLayout I;
    public SkuItem J;
    public Function2<? super SkuItem, ? super View, Unit> K;
    public boolean L;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(List<SkuItem> dataList) {
        super(R$layout.item_redeem, dataList);
        Intrinsics.g(dataList, "dataList");
        this.L = true;
    }

    public static final void I0(d this$0, SkuItem item, View it) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(item, "$item");
        uo.b.a.g(uo.b.f78622a, "Should redeem", false, 2, null);
        Function2<? super SkuItem, ? super View, Unit> function2 = this$0.K;
        if (function2 != null) {
            Intrinsics.f(it, "it");
            function2.invoke(item, it);
        }
    }

    private final void L0(int i11) {
        SkuItem skuItem = this.J;
        J0((skuItem != null ? skuItem.getPrice() : 0.0d) <= ((double) i11));
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* JADX INFO: renamed from: H0, reason: merged with bridge method [inline-methods] */
    public void x(BaseViewHolder holder, final SkuItem item) {
        Intrinsics.g(holder, "holder");
        Intrinsics.g(item, "item");
        AppCompatTextView appCompatTextView = (AppCompatTextView) holder.getView(R$id.title);
        appCompatTextView.setText(appCompatTextView.getContext().getString(R$string.member_sku_set_title, item.getDurationCount(), item.getDurationUnitDesc()));
        ((AppCompatTextView) holder.getView(R$id.price)).setText(new BigDecimal(String.valueOf(item.getPrice())).stripTrailingZeros().toPlainString());
        this.H = (AppCompatTextView) holder.getView(R$id.btn_redeem);
        this.I = (ConstraintLayout) holder.getView(R$id.iv_redeem_container);
        this.J = item;
        Integer userPoints = item.getUserPoints();
        L0(userPoints != null ? userPoints.intValue() : 0);
        AppCompatTextView appCompatTextView2 = this.H;
        if (appCompatTextView2 != null) {
            appCompatTextView2.setOnClickListener(new View.OnClickListener() { // from class: ou.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    d.I0(this.f73422a, item, view);
                }
            });
        }
    }

    public final void J0(boolean z11) {
        ConstraintLayout constraintLayout = this.I;
        if (constraintLayout != null) {
            constraintLayout.setAlpha(z11 ? 1.0f : 0.4f);
        }
        AppCompatTextView appCompatTextView = this.H;
        if (appCompatTextView != null) {
            appCompatTextView.setEnabled(z11);
        }
        this.L = z11;
    }

    public final void K0(Function2<? super SkuItem, ? super View, Unit> clickCallback) {
        Intrinsics.g(clickCallback, "clickCallback");
        this.K = clickCallback;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return D().size();
    }
}
