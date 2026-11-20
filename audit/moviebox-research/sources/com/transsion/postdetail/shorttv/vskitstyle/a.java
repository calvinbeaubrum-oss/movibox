package com.transsion.postdetail.shorttv.vskitstyle;

import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.R$layout;
import com.transsion.postdetail.shorttv.widget.ShortTvEpisodeItemView;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import qx.d;

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
public final class a extends com.transsion.shorttv.episode.b {
    public a() {
        super(R$layout.item_episode);
    }

    @Override // com.transsion.shorttv.episode.b
    public void I0(int i11) {
        int i12;
        if (i11 == G0()) {
            return;
        }
        Iterator<d> it = D().iterator();
        int i13 = 0;
        int i14 = 0;
        while (true) {
            i12 = -1;
            if (!it.hasNext()) {
                i14 = -1;
                break;
            } else if (it.next().b() == G0()) {
                break;
            } else {
                i14++;
            }
        }
        H0(i11);
        if (i14 >= 0) {
            notifyItemChanged(i14, D().get(i14));
        }
        Iterator<d> it2 = D().iterator();
        while (it2.hasNext()) {
            if (it2.next().b() == i11) {
                i12 = i13;
                break;
            }
            i13++;
        }
        if (i12 >= 0) {
            notifyItemChanged(i12, D().get(i12));
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* JADX INFO: renamed from: J0, reason: merged with bridge method [inline-methods] */
    public void x(BaseViewHolder holder, d item) {
        Intrinsics.g(holder, "holder");
        Intrinsics.g(item, "item");
        ((ShortTvEpisodeItemView) holder.getView(R$id.v_ep)).showIndex(item.b());
        L0(item, holder);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* JADX INFO: renamed from: K0, reason: merged with bridge method [inline-methods] */
    public void y(BaseViewHolder holder, d item, List<? extends Object> payloads) {
        Intrinsics.g(holder, "holder");
        Intrinsics.g(item, "item");
        Intrinsics.g(payloads, "payloads");
        super.y(holder, item, payloads);
        if ((!payloads.isEmpty()) && (payloads.get(0) instanceof d)) {
            L0(item, holder);
        }
    }

    public final void L0(d dVar, BaseViewHolder baseViewHolder) {
        ShortTvEpisodeItemView shortTvEpisodeItemView = (ShortTvEpisodeItemView) baseViewHolder.getView(R$id.v_ep);
        if (dVar.e()) {
            int iA = dVar.a();
            if (2 > iA || iA >= 7) {
                shortTvEpisodeItemView.showDownloadStatus(false);
            } else {
                shortTvEpisodeItemView.showDownloadStatus(true);
            }
        } else {
            shortTvEpisodeItemView.showLockImg(true);
        }
        shortTvEpisodeItemView.showPlayingImg(dVar.b() == G0());
    }
}
