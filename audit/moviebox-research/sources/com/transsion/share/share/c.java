package com.transsion.share.share;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.d0;
import com.blankj.utilcode.util.f0;
import com.transsion.share.R$id;
import com.transsion.share.R$layout;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class c extends RecyclerView.Adapter<a> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public List<mx.a> f57749i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public com.transsion.share.share.a f57750j;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends RecyclerView.a0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public TextView f57751b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(view);
            Intrinsics.g(view, "view");
            View viewFindViewById = this.itemView.findViewById(R$id.tv_share);
            Intrinsics.f(viewFindViewById, "itemView.findViewById(R.id.tv_share)");
            this.f57751b = (TextView) viewFindViewById;
        }

        public final TextView e() {
            return this.f57751b;
        }
    }

    public c(List<mx.a> mDatas) {
        Intrinsics.g(mDatas, "mDatas");
        this.f57749i = mDatas;
    }

    public static final void f(c this$0, mx.a item, View view) {
        com.transsion.share.share.a aVar;
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(item, "$item");
        if (h.e(h.f57754a, view.hashCode(), 0L, 2, null) || (aVar = this$0.f57750j) == null) {
            return;
        }
        aVar.a(item);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a holder, int i11) {
        Intrinsics.g(holder, "holder");
        ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
        Intrinsics.e(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
        RecyclerView.n nVar = (RecyclerView.n) layoutParams;
        int iE = (d0.e() - f0.a(286.0f)) / 4;
        if (i11 == 0) {
            nVar.setMarginStart(f0.a(16.0f));
            nVar.setMarginEnd(iE);
        } else if (i11 == getItemCount() - 1) {
            nVar.setMarginStart(0);
            nVar.setMarginEnd(f0.a(16.0f));
        } else {
            nVar.setMarginStart(0);
            nVar.setMarginEnd(iE);
        }
        final mx.a aVar = this.f57749i.get(i11);
        holder.e().setText(aVar.b());
        holder.e().setCompoundDrawablesRelativeWithIntrinsicBounds(0, aVar.a(), 0, 0);
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.share.share.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c.f(this.f57747a, aVar, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup parent, int i11) {
        Intrinsics.g(parent, "parent");
        View view = LayoutInflater.from(parent.getContext()).inflate(R$layout.adapter_share, parent, false);
        Intrinsics.f(view, "view");
        return new a(view);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f57749i.size();
    }

    public final void h(@Nullable com.transsion.share.share.a onItemClickListener) {
        Intrinsics.g(onItemClickListener, "onItemClickListener");
        this.f57750j = onItemClickListener;
    }
}
