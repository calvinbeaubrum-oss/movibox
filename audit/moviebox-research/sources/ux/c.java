package ux;

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
public final class c extends BaseQuickAdapter<vx.a, BaseViewHolder> implements j {
    public final boolean H;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(boolean z11, List<vx.a> dataList) {
        super(z11 ? R$layout.dialog_subtitle_list_item : R$layout.dialog_subtitle_lan_list_item, dataList);
        Intrinsics.g(dataList, "dataList");
        this.H = z11;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* JADX INFO: renamed from: G0, reason: merged with bridge method [inline-methods] */
    public void x(BaseViewHolder holder, vx.a item) {
        String lanName;
        Intrinsics.g(holder, "holder");
        Intrinsics.g(item, "item");
        if (!this.H) {
            ((TextView) holder.getView(R$id.tv_subtitle)).setText(item.b().getName());
            ((ImageView) holder.getView(R$id.iv_check)).setSelected(item.f());
            return;
        }
        Long size = item.b().getSize();
        if ((size != null ? size.longValue() : 0L) > 100) {
            String lanName2 = item.b().getLanName();
            Long size2 = item.b().getSize();
            lanName = lanName2 + ", " + tp.a.a(size2 != null ? size2.longValue() : 1L, 1);
        } else {
            lanName = item.b().getLanName();
        }
        up.c.a aVarC = up.c.e().e(item.b().getSubtitleName() + " ").c(-1).e(lanName).d(12).c(z2.a.getColor(Utils.a(), R$color.white_40));
        Intrinsics.f(aVarC, "builder().text(item.dbBe…  )\n                    )");
        ((TextView) holder.getView(R$id.tv_subtitle)).setText(aVarC.b());
        I0(holder, item);
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
                if (this.H) {
                    I0(holder, item);
                }
            }
        }
    }

    public final void I0(BaseViewHolder baseViewHolder, vx.a aVar) {
        ImageView imageView = (ImageView) baseViewHolder.getView(R$id.iv_check);
        ProgressBar progressBar = (ProgressBar) baseViewHolder.getView(R$id.progress);
        int status = aVar.b().getStatus();
        if (status != 0) {
            if (status == 2) {
                so.c.g(imageView);
                so.c.k(progressBar);
                return;
            } else {
                if (status == 5) {
                    imageView.setImageResource(R$mipmap.ic_subtitle_downloaded);
                    if (aVar.f()) {
                        so.c.k(imageView);
                    } else {
                        so.c.h(imageView);
                    }
                    so.c.g(progressBar);
                    return;
                }
                if (status != 6) {
                    return;
                }
            }
        }
        imageView.setImageResource(R$drawable.subtitle_download_green);
        so.c.k(imageView);
        so.c.g(progressBar);
    }

    @Override // h9.j
    public /* synthetic */ f a(BaseQuickAdapter baseQuickAdapter) {
        return i.a(this, baseQuickAdapter);
    }
}
