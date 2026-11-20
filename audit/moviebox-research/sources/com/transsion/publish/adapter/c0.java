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
public final class c0 extends RecyclerView.a0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageView f56389b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f56390c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f56391d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f56392f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ImageView f56393g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f56394h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c0(View itemView) {
        super(itemView);
        Intrinsics.g(itemView, "itemView");
        View viewFindViewById = itemView.findViewById(R$id.sv_item_cover);
        Intrinsics.f(viewFindViewById, "itemView.findViewById(R.id.sv_item_cover)");
        this.f56389b = (ImageView) viewFindViewById;
        View viewFindViewById2 = itemView.findViewById(R$id.tv_title);
        Intrinsics.f(viewFindViewById2, "itemView.findViewById(R.id.tv_title)");
        this.f56390c = (TextView) viewFindViewById2;
        View viewFindViewById3 = itemView.findViewById(R$id.tv_desc);
        Intrinsics.f(viewFindViewById3, "itemView.findViewById(R.id.tv_desc)");
        this.f56391d = (TextView) viewFindViewById3;
        View viewFindViewById4 = itemView.findViewById(R$id.tv_select);
        Intrinsics.f(viewFindViewById4, "itemView.findViewById(R.id.tv_select)");
        this.f56392f = (TextView) viewFindViewById4;
        View viewFindViewById5 = itemView.findViewById(R$id.iv_play);
        Intrinsics.f(viewFindViewById5, "itemView.findViewById(R.id.iv_play)");
        this.f56393g = (ImageView) viewFindViewById5;
        View viewFindViewById6 = itemView.findViewById(R$id.view_masking);
        Intrinsics.f(viewFindViewById6, "itemView.findViewById(R.id.view_masking)");
        this.f56394h = viewFindViewById6;
    }

    public final ImageView e() {
        return this.f56393g;
    }

    public final TextView f() {
        return this.f56391d;
    }

    public final TextView g() {
        return this.f56392f;
    }

    public final TextView h() {
        return this.f56390c;
    }

    public final View i() {
        return this.f56394h;
    }
}
