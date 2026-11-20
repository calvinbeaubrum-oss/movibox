package com.transsion.publish.adapter;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.imageview.ShapeableImageView;
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
public final class i0 extends RecyclerView.a0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ShapeableImageView f56440b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AppCompatTextView f56441c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public AppCompatTextView f56442d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public AppCompatImageView f56443f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i0(View itemView) {
        super(itemView);
        Intrinsics.g(itemView, "itemView");
        View viewFindViewById = itemView.findViewById(R$id.ivCover);
        Intrinsics.f(viewFindViewById, "itemView.findViewById(R.id.ivCover)");
        this.f56440b = (ShapeableImageView) viewFindViewById;
        View viewFindViewById2 = itemView.findViewById(R$id.tvSubjectTitle);
        Intrinsics.f(viewFindViewById2, "itemView.findViewById(R.id.tvSubjectTitle)");
        this.f56441c = (AppCompatTextView) viewFindViewById2;
        View viewFindViewById3 = itemView.findViewById(R$id.tvSubjectYear);
        Intrinsics.f(viewFindViewById3, "itemView.findViewById(R.id.tvSubjectYear)");
        this.f56442d = (AppCompatTextView) viewFindViewById3;
        View viewFindViewById4 = itemView.findViewById(R$id.iv_publish_subject_delete);
        Intrinsics.f(viewFindViewById4, "itemView.findViewById(R.…v_publish_subject_delete)");
        this.f56443f = (AppCompatImageView) viewFindViewById4;
    }

    public final ShapeableImageView e() {
        return this.f56440b;
    }

    public final AppCompatImageView f() {
        return this.f56443f;
    }

    public final AppCompatTextView g() {
        return this.f56442d;
    }

    public final AppCompatTextView h() {
        return this.f56441c;
    }
}
