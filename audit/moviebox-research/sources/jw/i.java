package jw;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tn.lib.widget.TnTextView;
import com.transsion.publish.R$color;
import com.transsion.publish.R$drawable;
import com.transsion.publish.R$layout;
import com.transsion.publish.R$string;
import com.transsion.publish.view.operation.OperationBean;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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
public final class i extends RecyclerView.Adapter<g> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public List<OperationBean> f68171i = new ArrayList();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public b f68172j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Map<String, Integer> f68173k;

    public i() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.f68173k = linkedHashMap;
        linkedHashMap.put(String.valueOf(R$drawable.ic_film_photos), Integer.valueOf(R$string.photo));
        this.f68173k.put(String.valueOf(R$drawable.ic_film_videos), Integer.valueOf(R$string.video));
        this.f68173k.put(String.valueOf(R$drawable.ic_film_audio), Integer.valueOf(R$string.audio));
        this.f68173k.put(String.valueOf(R$drawable.ic_film_work), Integer.valueOf(R$string.mention_a_specific_movie_audio));
        this.f68173k.put(String.valueOf(R$drawable.ic_film_link), Integer.valueOf(R$string.add_a_link));
    }

    public static final void g(i this$0, OperationBean info, int i11, View view) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(info, "$info");
        b bVar = this$0.f68172j;
        if (bVar != null) {
            bVar.a(info, i11);
        }
    }

    public final List<OperationBean> e() {
        return this.f68171i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(g holder, final int i11) {
        Intrinsics.g(holder, "holder");
        final OperationBean operationBean = this.f68171i.get(i11);
        if (operationBean.getStatus()) {
            holder.f().setImageResource(operationBean.getEnable());
            holder.e().setTextColor(com.blankj.utilcode.util.h.a(R$color.color_ff333333));
        } else {
            holder.f().setImageResource(operationBean.getDisable());
            holder.e().setTextColor(com.blankj.utilcode.util.h.a(R$color.color_ff999999));
        }
        TnTextView tnTextViewE = holder.e();
        Integer num = this.f68173k.get(String.valueOf(operationBean.getEnable()));
        tnTextViewE.setTextById(num != null ? num.intValue() : 0);
        holder.g().setOnClickListener(new View.OnClickListener() { // from class: jw.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                i.g(this.f68168a, operationBean, i11, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f68171i.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public g onCreateViewHolder(ViewGroup parent, int i11) {
        Intrinsics.g(parent, "parent");
        View view = LayoutInflater.from(parent.getContext()).inflate(R$layout.item_operation_vertical_layout, parent, false);
        Intrinsics.f(view, "view");
        return new g(view);
    }

    public final void i(List<OperationBean> data) {
        Intrinsics.g(data, "data");
        this.f68171i.clear();
        this.f68171i.addAll(data);
        notifyDataSetChanged();
    }

    public final void j(b itemClick) {
        Intrinsics.g(itemClick, "itemClick");
        this.f68172j = itemClick;
    }
}
