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
import com.transsion.moviedetailapi.bean.ResourceDetectors;
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
public final class ResourceDetectorAloneAdapter extends BaseQuickAdapter<ResourceDetectors, BaseViewHolder> {
    public String H;
    public Subject I;
    public DownloadView J;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResourceDetectorAloneAdapter(Subject subject, List<ResourceDetectors> list) {
        super(R$layout.adapter_resource_detector_alone_layout, list);
        Intrinsics.g(list, "list");
        this.I = subject;
    }

    private final void H0() {
        Context context = getContext();
        Intrinsics.e(context, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        Function1<AddToDownloadEvent, Unit> function1 = new Function1<AddToDownloadEvent, Unit>() { // from class: com.transsion.moviedetail.adapter.ResourceDetectorAloneAdapter$observeAddToDownload$1
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
                    Iterator<ResourceDetectors> it = this.this$0.D().iterator();
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

    /* JADX WARN: Code duplicated, block: B:23:0x0076  */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* JADX INFO: renamed from: G0, reason: merged with bridge method [inline-methods] */
    public void x(BaseViewHolder holder, ResourceDetectors item) {
        Integer durationSeconds;
        Intrinsics.g(holder, "holder");
        Intrinsics.g(item, "item");
        int i11 = R$id.tvTitle;
        Subject subject = this.I;
        holder.setText(i11, subject != null ? subject.getTitle() : null);
        Integer type = item.getType();
        long jLongValue = 0;
        if (type != null && type.intValue() == 0) {
            Long totalSize = item.getTotalSize();
            if (totalSize != null) {
                jLongValue = totalSize.longValue();
            }
        } else {
            Long firstSize = item.getFirstSize();
            if (firstSize != null) {
                jLongValue = firstSize.longValue();
            }
        }
        Subject subject2 = this.I;
        if (subject2 == null || (durationSeconds = subject2.getDurationSeconds()) == null) {
            holder.setText(R$id.tvSize, tp.a.a(jLongValue, 1));
        } else {
            int iIntValue = durationSeconds.intValue();
            if (holder.setText(R$id.tvSize, tp.a.a(jLongValue, 1) + " · " + TimeUtilKt.i(((long) iIntValue) * 1000)) == null) {
                holder.setText(R$id.tvSize, tp.a.a(jLongValue, 1));
            }
        }
        DownloadView downloadView = (DownloadView) holder.getView(R$id.innerIvDownload);
        this.J = downloadView;
        if (downloadView != null) {
            downloadView.setPageFrom("subjectdetail");
        }
        this.H = item.getResourceId();
        DownloadView downloadView2 = this.J;
        if (downloadView2 != null) {
            Subject subject3 = this.I;
            String subjectId = subject3 != null ? subject3.getSubjectId() : null;
            String str = this.H;
            Subject subject4 = this.I;
            DownloadView.setShowType$default(downloadView2, subjectId, str, subject4 != null ? Boolean.valueOf(subject4.isSeries()) : null, false, 0, 24, null);
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        Intrinsics.g(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        H0();
    }
}
