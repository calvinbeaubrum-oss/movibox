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
public final class c extends RecyclerView.a0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageView f56385b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f56386c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f56387d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f56388f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(View view) {
        super(view);
        Intrinsics.d(view);
        this.f56385b = (ImageView) view.findViewById(R$id.iv_photo);
        this.f56386c = view.findViewById(R$id.iv_clear);
        this.f56387d = view.findViewById(R$id.rl_add);
        this.f56388f = (TextView) view.findViewById(R$id.tv_number);
    }

    public final View e() {
        return this.f56387d;
    }

    public final View f() {
        return this.f56386c;
    }

    public final ImageView g() {
        return this.f56385b;
    }

    public final TextView h() {
        return this.f56388f;
    }
}
