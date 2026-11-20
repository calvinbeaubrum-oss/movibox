package com.transsion.web.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.transsion.web.R$id;
import com.transsion.web.R$layout;
import com.transsion.web.R$string;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class SnifferFloatView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f60240a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SnifferFloatView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.g(context, "context");
        Intrinsics.g(attrs, "attrs");
        a();
    }

    public final void a() {
        LayoutInflater.from(getContext()).inflate(R$layout.view_sniffer_layout, this);
        this.f60240a = (TextView) findViewById(R$id.tv_download);
        setVisibility(8);
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
    }

    public final void show(int i11) {
        if (i11 > 0) {
            setVisibility(0);
        }
        TextView textView = this.f60240a;
        if (textView == null) {
            return;
        }
        textView.setText(getContext().getString(R$string.str_num_videos, Integer.valueOf(i11)));
    }
}
