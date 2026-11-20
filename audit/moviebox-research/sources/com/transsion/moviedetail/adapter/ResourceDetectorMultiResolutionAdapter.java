package com.transsion.moviedetail.adapter;

import android.content.Context;
import android.text.TextUtils;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.baseui.util.TimeUtilKt;
import com.transsion.moviedetail.R$id;
import com.transsion.moviedetail.R$layout;
import com.transsion.moviedetailapi.DownloadItem;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsnet.downloader.widget.DownloadView;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.flow.event.sync.event.AddToDownloadEvent;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
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
public final class ResourceDetectorMultiResolutionAdapter extends BaseQuickAdapter<DownloadItem, BaseViewHolder> {
    public String H;
    public Subject I;
    public DownloadView J;

    public ResourceDetectorMultiResolutionAdapter(Subject subject, List<DownloadItem> list) {
        super(R$layout.adapter_resource_detector_alone_layout, list);
        this.I = subject;
    }

    private final void I0() {
        Context context = getContext();
        Intrinsics.e(context, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        Function1<AddToDownloadEvent, Unit> function1 = new Function1<AddToDownloadEvent, Unit>() { // from class: com.transsion.moviedetail.adapter.ResourceDetectorMultiResolutionAdapter$observeAddToDownload$1
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
                        } else if (TextUtils.equals(it.next().getResourceId(), value.getResourceId())) {
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
        int i11 = R$id.tvTitle;
        Integer resolution = item.getResolution();
        Subject subject = this.I;
        holder.setText(i11, resolution + "P " + (subject != null ? subject.getTitle() : null));
        Long size = item.getSize();
        long jLongValue = size != null ? size.longValue() : 0L;
        Long duration = item.getDuration();
        long jLongValue2 = duration != null ? duration.longValue() : 0L;
        String strA = tp.a.a(jLongValue, 1);
        if (jLongValue2 > 0) {
            strA = strA + " · " + TimeUtilKt.i(jLongValue2 * 1000);
        }
        holder.setText(R$id.tvSize, strA);
        DownloadView downloadView = (DownloadView) holder.getView(R$id.innerIvDownload);
        this.J = downloadView;
        if (downloadView != null) {
            downloadView.setPageFrom("subjectdetail");
        }
        String resourceId = item.getResourceId();
        this.H = resourceId;
        DownloadView downloadView2 = this.J;
        if (downloadView2 != null) {
            Subject subject2 = this.I;
            DownloadView.setShowType$default(downloadView2, null, resourceId, subject2 != null ? Boolean.valueOf(subject2.isSeries()) : null, false, 0, 24, null);
        }
    }

    public final Subject H0() {
        return this.I;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        Intrinsics.g(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        I0();
    }
}
