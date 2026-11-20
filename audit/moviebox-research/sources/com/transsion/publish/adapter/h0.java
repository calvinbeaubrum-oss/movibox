package com.transsion.publish.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.publish.R$id;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class h0 extends RecyclerView.a0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageView f56434b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f56435c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f56436d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f56437f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f56438g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h0(View itemView) {
        super(itemView);
        Intrinsics.g(itemView, "itemView");
        View viewFindViewById = itemView.findViewById(R$id.sv_item_cover);
        Intrinsics.f(viewFindViewById, "itemView.findViewById(R.id.sv_item_cover)");
        this.f56434b = (ImageView) viewFindViewById;
        View viewFindViewById2 = itemView.findViewById(R$id.sv_item_layer);
        Intrinsics.f(viewFindViewById2, "itemView.findViewById(R.id.sv_item_layer)");
        this.f56435c = viewFindViewById2;
        View viewFindViewById3 = itemView.findViewById(R$id.sv_item_duration);
        Intrinsics.f(viewFindViewById3, "itemView.findViewById(R.id.sv_item_duration)");
        this.f56436d = (TextView) viewFindViewById3;
        View viewFindViewById4 = itemView.findViewById(R$id.tv_select);
        Intrinsics.f(viewFindViewById4, "itemView.findViewById(R.id.tv_select)");
        this.f56437f = (TextView) viewFindViewById4;
        View viewFindViewById5 = itemView.findViewById(R$id.rl_select);
        Intrinsics.f(viewFindViewById5, "itemView.findViewById(R.id.rl_select)");
        this.f56438g = viewFindViewById5;
    }

    public final ImageView e() {
        return this.f56434b;
    }

    public final View f() {
        return this.f56435c;
    }

    public final View g() {
        return this.f56438g;
    }

    public final TextView h() {
        return this.f56436d;
    }

    public final TextView i() {
        return this.f56437f;
    }
}
