package com.transsnet.downloader.popup;

import android.view.View;
import com.blankj.utilcode.util.d0;
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
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f61091a = new c();

    public final int[] a(View anchorView, View contentView) {
        Intrinsics.g(anchorView, "anchorView");
        Intrinsics.g(contentView, "contentView");
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        anchorView.getLocationOnScreen(iArr2);
        int height = anchorView.getHeight();
        int iC = d0.c();
        int iE = d0.e();
        contentView.measure(0, 0);
        int measuredHeight = contentView.getMeasuredHeight();
        int measuredWidth = contentView.getMeasuredWidth();
        int i11 = iArr2[1];
        if ((iC - i11) - height < measuredHeight) {
            iArr[0] = iE - measuredWidth;
            iArr[1] = i11 - measuredHeight;
        } else {
            iArr[0] = iE - measuredWidth;
            iArr[1] = i11 + height;
        }
        return iArr;
    }
}
