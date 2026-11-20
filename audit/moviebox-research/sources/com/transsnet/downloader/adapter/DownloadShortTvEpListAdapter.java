package com.transsnet.downloader.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsnet.downloader.widget.DownloadShortTvEpItemView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
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
public final class DownloadShortTvEpListAdapter extends RecyclerView.Adapter<EpisodeViewHolder> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<f00.c> f60304i = new ArrayList();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Function1<? super Integer, Unit> f60305j;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class EpisodeViewHolder extends BaseViewHolder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final DownloadShortTvEpItemView f60306b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public EpisodeViewHolder(DownloadShortTvEpItemView view) {
            super(view);
            Intrinsics.g(view, "view");
            this.f60306b = view;
        }

        public final DownloadShortTvEpItemView e() {
            return this.f60306b;
        }
    }

    public static final void h(DownloadShortTvEpListAdapter this$0, f00.c item, View view) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(item, "$item");
        Function1<? super Integer, Unit> function1 = this$0.f60305j;
        if (function1 != null) {
            function1.invoke(Integer.valueOf(item.a()));
        }
    }

    public final List<f00.c> e() {
        return this.f60304i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(EpisodeViewHolder holder, int i11) {
        Intrinsics.g(holder, "holder");
        final f00.c cVar = this.f60304i.get(i11);
        holder.e().showIndex(cVar.a() + 1);
        holder.e().showLockImg(!cVar.c());
        if (cVar.c()) {
            holder.e().setSelect(cVar.d());
            holder.e().showDownloadImg(cVar.b());
        }
        holder.e().setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.adapter.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DownloadShortTvEpListAdapter.h(this.f60384a, cVar, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(EpisodeViewHolder holder, int i11, List<Object> payloads) {
        Intrinsics.g(holder, "holder");
        Intrinsics.g(payloads, "payloads");
        super.onBindViewHolder(holder, i11, payloads);
        if (!payloads.isEmpty()) {
            Object obj = payloads.get(0);
            if (obj instanceof f00.c) {
                f00.c cVar = (f00.c) obj;
                holder.e().showLockImg(!cVar.c());
                if (cVar.c()) {
                    holder.e().setSelect(cVar.d());
                    holder.e().showDownloadImg(cVar.b());
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f60304i.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public EpisodeViewHolder onCreateViewHolder(ViewGroup parent, int i11) {
        Intrinsics.g(parent, "parent");
        Context context = parent.getContext();
        Intrinsics.f(context, "parent.context");
        DownloadShortTvEpItemView downloadShortTvEpItemView = new DownloadShortTvEpItemView(context);
        downloadShortTvEpItemView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        return new EpisodeViewHolder(downloadShortTvEpItemView);
    }

    public final void j(Function1<? super Integer, Unit> function1) {
        this.f60305j = function1;
    }
}
