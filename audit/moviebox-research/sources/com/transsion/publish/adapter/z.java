package com.transsion.publish.adapter;

import android.view.View;
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
public final class z extends RecyclerView.a0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f56477b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f56478c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(View itemView) {
        super(itemView);
        Intrinsics.g(itemView, "itemView");
        View viewFindViewById = itemView.findViewById(R$id.tvLocation);
        Intrinsics.f(viewFindViewById, "itemView.findViewById(R.id.tvLocation)");
        this.f56477b = (TextView) viewFindViewById;
        View viewFindViewById2 = itemView.findViewById(R$id.iv_publish_location_delete);
        Intrinsics.f(viewFindViewById2, "itemView.findViewById(R.…_publish_location_delete)");
        this.f56478c = viewFindViewById2;
    }

    public final View e() {
        return this.f56478c;
    }

    public final TextView f() {
        return this.f56477b;
    }
}
