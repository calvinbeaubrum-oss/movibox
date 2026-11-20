package com.transsion.moviedetail.adapter;

import android.content.Context;
import android.text.TextUtils;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.Group;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.moviedetail.R$id;
import com.transsion.moviedetail.R$layout;
import com.transsion.moviedetailapi.DownloadItem;
import com.transsion.moviedetailapi.SubjectType;
import com.transsnet.downloader.widget.DownloadView;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.flow.event.sync.event.AddToDownloadEvent;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
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
@SourceDebugExtension
public final class ResourceDetectorCollectionAdapter extends BaseQuickAdapter<DownloadItem, BaseViewHolder> {
    public final String H;
    public final String I;
    public final List<DownloadItem> J;
    public final Integer K;
    public final boolean L;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResourceDetectorCollectionAdapter(String title, String str, List<DownloadItem> list, Integer num) {
        super(R$layout.adapter_resource_detector_collection_layout, list);
        Intrinsics.g(title, "title");
        Intrinsics.g(list, "list");
        this.H = title;
        this.I = str;
        this.J = list;
        this.K = num;
        this.L = num != null && num.intValue() == SubjectType.AUDIO.getValue();
    }

    private final void K0() {
        Context context = getContext();
        Intrinsics.e(context, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        Function1<AddToDownloadEvent, Unit> function1 = new Function1<AddToDownloadEvent, Unit>() { // from class: com.transsion.moviedetail.adapter.ResourceDetectorCollectionAdapter$observeAddToDownload$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(AddToDownloadEvent addToDownloadEvent) {
                invoke2(addToDownloadEvent);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(AddToDownloadEvent value) {
                Intrinsics.g(value, "value");
                try {
                    Iterator<DownloadItem> it = this.this$0.D().iterator();
                    int i11 = 0;
                    while (true) {
                        if (!it.hasNext()) {
                            i11 = -1;
                            break;
                        }
                        DownloadItem next = it.next();
                        if (!TextUtils.isEmpty(value.getResourceId()) && TextUtils.equals(next.getResourceId(), value.getResourceId())) {
                            break;
                        } else {
                            i11++;
                        }
                    }
                    if (i11 >= 0) {
                        this.this$0.notifyItemChanged(i11);
                    }
                } catch (Exception unused) {
                    uo.b.a.g(uo.b.f78622a, " callback change data fail", false, 2, null);
                }
            }
        };
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = AddToDownloadEvent.class.getName();
        Intrinsics.f(name, "T::class.java.name");
        flowEventBus.observeEvent((AppCompatActivity) context, name, Lifecycle.State.CREATED, w0.c().q(), false, function1);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* JADX INFO: renamed from: G0, reason: merged with bridge method [inline-methods] */
    public void x(BaseViewHolder holder, DownloadItem item) {
        Intrinsics.g(holder, "holder");
        Intrinsics.g(item, "item");
        uo.b.a.g(uo.b.f78622a, "ResourceDetectorCollectionAdapter " + holder.getLayoutPosition() + "  " + item.getName(), false, 2, null);
        ((Group) holder.getView(R$id.group)).setVisibility(0);
        holder.setGone(R$id.tvAll, true);
        holder.setText(R$id.tvTitle, J0(holder, item));
        int i11 = R$id.tvSize;
        Long size = item.getSize();
        holder.setText(i11, tp.a.a(size != null ? size.longValue() : 0L, 1));
        DownloadView.setShowType$default((DownloadView) holder.getView(R$id.innerIvDownload), null, item.getResourceId(), Boolean.FALSE, false, 0, 16, null);
    }

    public final String H0(int i11) {
        if (i11 >= 10) {
            return String.valueOf(i11);
        }
        return "0" + i11;
    }

    public final String I0(int i11) {
        if (this.L) {
            return "Chapter " + H0(i11);
        }
        return "Episode " + H0(i11);
    }

    public final String J0(BaseViewHolder baseViewHolder, DownloadItem downloadItem) {
        Throwable th2;
        String str;
        Object objM163constructorimpl;
        if (downloadItem.getEp() <= 0 && downloadItem.getSe() <= 0) {
            Integer epse = downloadItem.getEpse();
            if (epse == null || epse.intValue() <= 0) {
                return "";
            }
            Integer epse2 = downloadItem.getEpse();
            return I0(epse2 != null ? epse2.intValue() : 0);
        }
        try {
            Result.Companion companion = Result.Companion;
            str = new DecimalFormat("00").format(Integer.valueOf(downloadItem.getEp()));
            Intrinsics.f(str, "format.format(item.ep)");
            try {
                objM163constructorimpl = Result.m163constructorimpl(Unit.f68710a);
            } catch (Throwable th3) {
                th2 = th3;
                Result.Companion companion2 = Result.Companion;
                objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
            }
        } catch (Throwable th4) {
            th2 = th4;
            str = "";
        }
        if (Result.m166exceptionOrNullimpl(objM163constructorimpl) == null) {
            return str;
        }
        Integer epse3 = downloadItem.getEpse();
        return I0(epse3 != null ? epse3.intValue() : 0);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        Intrinsics.g(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        K0();
    }
}
