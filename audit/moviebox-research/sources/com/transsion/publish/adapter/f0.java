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
public final class f0 extends RecyclerView.a0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageView f56418b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f56419c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f56420d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f56421f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f0(View itemView) {
        super(itemView);
        Intrinsics.g(itemView, "itemView");
        View viewFindViewById = itemView.findViewById(R$id.sv_item_cover);
        Intrinsics.f(viewFindViewById, "itemView.findViewById(R.id.sv_item_cover)");
        this.f56418b = (ImageView) viewFindViewById;
        View viewFindViewById2 = itemView.findViewById(R$id.tv_select);
        Intrinsics.f(viewFindViewById2, "itemView.findViewById(R.id.tv_select)");
        this.f56419c = (TextView) viewFindViewById2;
        View viewFindViewById3 = itemView.findViewById(R$id.view_masking);
        Intrinsics.f(viewFindViewById3, "itemView.findViewById(R.id.view_masking)");
        this.f56420d = viewFindViewById3;
        View viewFindViewById4 = itemView.findViewById(R$id.rl_select);
        Intrinsics.f(viewFindViewById4, "itemView.findViewById(R.id.rl_select)");
        this.f56421f = viewFindViewById4;
    }

    public final ImageView e() {
        return this.f56418b;
    }

    public final View f() {
        return this.f56421f;
    }

    public final TextView g() {
        return this.f56419c;
    }

    public final View h() {
        return this.f56420d;
    }
}
