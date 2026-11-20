package ux;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.blankj.utilcode.util.Utils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tn.lib.widget.R$color;
import com.transsion.subtitle.R$drawable;
import com.transsion.subtitle.R$id;
import com.transsion.subtitle.R$layout;
import com.transsion.subtitle.R$mipmap;
import h9.f;
import h9.i;
import h9.j;
import java.util.List;
import kotlin.Metadata;
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
@Metadata
public final class b extends BaseQuickAdapter<vx.a, BaseViewHolder> implements j {
    public boolean H;
    public boolean I;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(List<vx.a> dataList) {
        super(R$layout.dialog_subtitle_lan_list_item, dataList);
        Intrinsics.g(dataList, "dataList");
        this.I = true;
    }

    private final int I0(boolean z11) {
        return z11 ? z2.a.getColor(Utils.a(), R$color.white) : z2.a.getColor(Utils.a(), R$color.white_40);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* JADX INFO: renamed from: G0, reason: merged with bridge method [inline-methods] */
    public void x(BaseViewHolder holder, vx.a item) {
        Intrinsics.g(holder, "holder");
        Intrinsics.g(item, "item");
        Q0(holder, item);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* JADX INFO: renamed from: H0, reason: merged with bridge method [inline-methods] */
    public void y(BaseViewHolder holder, vx.a item, List<? extends Object> payloads) {
        Intrinsics.g(holder, "holder");
        Intrinsics.g(item, "item");
        Intrinsics.g(payloads, "payloads");
        super.y(holder, item, payloads);
        if (!payloads.isEmpty()) {
            Object obj = payloads.get(0);
            if (obj instanceof vx.a) {
                item.b().setStatus(((vx.a) obj).b().getStatus());
                R0(holder, item);
                L0(holder, item);
            }
        }
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void J0(boolean z11) {
        this.H = z11;
        notifyDataSetChanged();
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void K0(boolean z11) {
        this.I = z11;
        notifyDataSetChanged();
    }

    public final void L0(BaseViewHolder baseViewHolder, vx.a aVar) {
        int i11;
        TextView textView = (TextView) baseViewHolder.getView(R$id.ivBilingual);
        if (TextUtils.isEmpty(aVar.a())) {
            i11 = 8;
        } else {
            textView.setText(aVar.a());
            i11 = 0;
        }
        textView.setVisibility(i11);
        textView.setTextColor(I0(this.I));
    }

    public final void M0(ImageView imageView, boolean z11) {
        if (imageView != null) {
            if (z11) {
                imageView.setImageResource(R$mipmap.subtitle_ic_download_group_selected);
            } else {
                imageView.setImageResource(R$mipmap.subtitle_ic_download_group_selected_2);
            }
        }
    }

    public final void N0(ImageView imageView, boolean z11) {
        if (imageView != null) {
            if (z11) {
                imageView.setImageResource(R$drawable.subtitle_ic_download_group_unselected);
            } else {
                imageView.setImageResource(R$drawable.subtitle_ic_download_group_unselected_2);
            }
        }
    }

    public final void O0(ImageView imageView, boolean z11) {
        if (imageView != null) {
            if (z11) {
                imageView.setImageResource(R$drawable.subtitle_download_no);
            } else {
                imageView.setImageResource(R$drawable.subtitle_download_no_2);
            }
        }
    }

    public final void P0(ImageView imageView, boolean z11) {
        if (imageView != null) {
            if (z11) {
                imageView.setImageResource(R$drawable.subtitle_checked);
            } else {
                imageView.setImageResource(R$drawable.subtitle_checked_2);
            }
        }
    }

    public final void Q0(BaseViewHolder baseViewHolder, vx.a aVar) {
        L0(baseViewHolder, aVar);
        TextView textView = (TextView) baseViewHolder.getView(R$id.tvSubtitle);
        textView.setText(aVar.b().getName());
        textView.setTextColor(I0(this.I));
        R0(baseViewHolder, aVar);
    }

    public final void R0(BaseViewHolder baseViewHolder, vx.a aVar) {
        ProgressBar progressBar = (ProgressBar) baseViewHolder.getView(R$id.progress);
        ImageView imageView = (ImageView) baseViewHolder.getView(R$id.ivState);
        progressBar.setVisibility(8);
        imageView.setVisibility(0);
        if (this.H) {
            if (aVar.f()) {
                M0(imageView, this.I);
                return;
            }
            if (aVar.b().getStatus() == 2) {
                progressBar.setVisibility(0);
                imageView.setVisibility(8);
                return;
            } else if (aVar.d()) {
                N0(imageView, this.I);
                return;
            } else {
                O0(imageView, this.I);
                return;
            }
        }
        if (aVar.f()) {
            P0(imageView, this.I);
            return;
        }
        if (aVar.b().getStatus() == 2) {
            progressBar.setVisibility(0);
            imageView.setVisibility(8);
        } else if (aVar.d()) {
            imageView.setVisibility(4);
        } else {
            O0(imageView, this.I);
        }
    }

    @Override // h9.j
    public /* synthetic */ f a(BaseQuickAdapter baseQuickAdapter) {
        return i.a(this, baseQuickAdapter);
    }
}
