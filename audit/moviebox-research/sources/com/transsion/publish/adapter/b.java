package com.transsion.publish.adapter;

import android.view.View;
import android.widget.FrameLayout;
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
public final class b extends RecyclerView.a0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f56376b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f56377c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FrameLayout f56378d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ImageView f56379f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(View itemView) {
        super(itemView);
        Intrinsics.g(itemView, "itemView");
        View viewFindViewById = itemView.findViewById(R$id.tv_title);
        Intrinsics.f(viewFindViewById, "itemView.findViewById(R.id.tv_title)");
        this.f56376b = (TextView) viewFindViewById;
        View viewFindViewById2 = itemView.findViewById(R$id.tv_desc);
        Intrinsics.f(viewFindViewById2, "itemView.findViewById(R.id.tv_desc)");
        this.f56377c = (TextView) viewFindViewById2;
        View viewFindViewById3 = itemView.findViewById(R$id.rl_close);
        Intrinsics.f(viewFindViewById3, "itemView.findViewById(R.id.rl_close)");
        this.f56378d = (FrameLayout) viewFindViewById3;
        View viewFindViewById4 = itemView.findViewById(R$id.iv_play);
        Intrinsics.f(viewFindViewById4, "itemView.findViewById(R.id.iv_play)");
        this.f56379f = (ImageView) viewFindViewById4;
    }

    public final ImageView e() {
        return this.f56379f;
    }

    public final FrameLayout f() {
        return this.f56378d;
    }

    public final TextView g() {
        return this.f56377c;
    }

    public final TextView h() {
        return this.f56376b;
    }
}
