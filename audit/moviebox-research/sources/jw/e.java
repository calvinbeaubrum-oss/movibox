package jw;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.publish.R$layout;
import com.transsion.publish.view.operation.OperationBean;
import java.util.ArrayList;
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
public final class e extends RecyclerView.Adapter<f> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public List<OperationBean> f68161i = new ArrayList();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public a f68162j;

    public static final void h(e this$0, OperationBean info, int i11, View view) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(info, "$info");
        a aVar = this$0.f68162j;
        if (aVar != null) {
            aVar.a(info, i11);
        }
    }

    public final void e(List<OperationBean> data) {
        Intrinsics.g(data, "data");
        int size = this.f68161i.size();
        this.f68161i.addAll(data);
        notifyItemRangeInserted(size, data.size());
    }

    public final List<OperationBean> f() {
        return this.f68161i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(f holder, final int i11) {
        Intrinsics.g(holder, "holder");
        final OperationBean operationBean = this.f68161i.get(i11);
        if (operationBean.getStatus()) {
            holder.e().setImageResource(operationBean.getEnable());
        } else {
            holder.e().setImageResource(operationBean.getDisable());
        }
        holder.f().setOnClickListener(new View.OnClickListener() { // from class: jw.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e.h(this.f68158a, operationBean, i11, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f68161i.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public f onCreateViewHolder(ViewGroup parent, int i11) {
        Intrinsics.g(parent, "parent");
        View view = LayoutInflater.from(parent.getContext()).inflate(R$layout.item_operation_layout, parent, false);
        Intrinsics.f(view, "view");
        return new f(view);
    }

    public final void j(a itemClick) {
        Intrinsics.g(itemClick, "itemClick");
        this.f68162j = itemClick;
    }
}
