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
public final class y extends RecyclerView.a0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageView f56472b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f56473c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f56474d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f56475f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f56476g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(View itemView) {
        super(itemView);
        Intrinsics.g(itemView, "itemView");
        View viewFindViewById = itemView.findViewById(R$id.iv_cover);
        Intrinsics.f(viewFindViewById, "itemView.findViewById(R.id.iv_cover)");
        this.f56472b = (ImageView) viewFindViewById;
        View viewFindViewById2 = itemView.findViewById(R$id.tv_title);
        Intrinsics.f(viewFindViewById2, "itemView.findViewById(R.id.tv_title)");
        this.f56473c = (TextView) viewFindViewById2;
        View viewFindViewById3 = itemView.findViewById(R$id.tv_desc);
        Intrinsics.f(viewFindViewById3, "itemView.findViewById(R.id.tv_desc)");
        this.f56474d = viewFindViewById3;
        View viewFindViewById4 = itemView.findViewById(R$id.rl_close);
        Intrinsics.f(viewFindViewById4, "itemView.findViewById(R.id.rl_close)");
        this.f56475f = viewFindViewById4;
        View viewFindViewById5 = itemView.findViewById(R$id.layout);
        Intrinsics.f(viewFindViewById5, "itemView.findViewById(R.id.layout)");
        this.f56476g = viewFindViewById5;
    }

    public final View e() {
        return this.f56475f;
    }

    public final TextView f() {
        return this.f56473c;
    }
}
