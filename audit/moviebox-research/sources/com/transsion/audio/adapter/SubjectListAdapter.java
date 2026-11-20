package com.transsion.audio.adapter;

import android.app.Application;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.audio.R$id;
import com.transsion.audio.R$layout;
import com.transsion.audio.fragment.SubjectListFragment;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.moviedetailapi.DownloadItem;
import h9.f;
import h9.j;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.i;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class SubjectListAdapter extends BaseQuickAdapter<DownloadItem, BaseViewHolder> implements j {
    public a H;
    public final Lazy I;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public interface a {
        void a(DownloadItem downloadItem);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubjectListAdapter(List<DownloadItem> dataList) {
        super(R$layout.adapter_item_audio_list, dataList);
        Intrinsics.g(dataList, "dataList");
        this.I = LazyKt__LazyJVMKt.b(new Function0<rr.a>() { // from class: com.transsion.audio.adapter.SubjectListAdapter$audioDao$2
            @Override // kotlin.jvm.functions.Function0
            public final rr.a invoke() {
                Application applicationA = com.tn.lib.util.a.f49452a.a();
                if (applicationA != null) {
                    return AppDatabase.f51036p.b(applicationA).D0();
                }
                return null;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final rr.a J0() {
        return (rr.a) this.I.getValue();
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* JADX INFO: renamed from: H0, reason: merged with bridge method [inline-methods] */
    public void x(BaseViewHolder holder, DownloadItem item) throws InterruptedException {
        Intrinsics.g(holder, "holder");
        Intrinsics.g(item, "item");
        uo.b.a.f(uo.b.f78622a, SubjectListFragment.f50804r.a(), "convert 22 item " + item.getUrl(), false, 4, null);
        N0(holder, item);
        L0(holder, item);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* JADX INFO: renamed from: I0, reason: merged with bridge method [inline-methods] */
    public void y(BaseViewHolder holder, DownloadItem item, List<? extends Object> payloads) throws InterruptedException {
        Intrinsics.g(holder, "holder");
        Intrinsics.g(item, "item");
        Intrinsics.g(payloads, "payloads");
        super.y(holder, item, payloads);
        uo.b.a.f(uo.b.f78622a, SubjectListFragment.f50804r.a(), "convert 11 item " + item.getUrl(), false, 4, null);
        L0(holder, item);
    }

    public final a K0() {
        return this.H;
    }

    public final void L0(BaseViewHolder baseViewHolder, DownloadItem downloadItem) throws InterruptedException {
        i.b(null, new SubjectListAdapter$refresh$1(downloadItem, baseViewHolder, this, null), 1, null);
    }

    public final void M0(a listener) {
        Intrinsics.g(listener, "listener");
        this.H = listener;
    }

    public final void N0(BaseViewHolder baseViewHolder, DownloadItem downloadItem) {
        baseViewHolder.setText(R$id.tv_name, downloadItem.getName());
        int i11 = R$id.tv_size;
        Long size = downloadItem.getSize();
        baseViewHolder.setText(i11, size != null ? tp.a.a(size.longValue(), 1) : null);
    }

    @Override // h9.j
    public /* synthetic */ f a(BaseQuickAdapter baseQuickAdapter) {
        return h9.i.a(this, baseQuickAdapter);
    }
}
