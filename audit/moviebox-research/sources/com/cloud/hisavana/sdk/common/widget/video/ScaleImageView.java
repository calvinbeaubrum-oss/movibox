package com.cloud.hisavana.sdk.common.widget.video;

import android.content.Context;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import com.cloud.hisavana.sdk.z;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class ScaleImageView extends AppCompatImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f29591a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f29592b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f29593c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScaleImageView(Context context) {
        super(context);
        Intrinsics.g(context, "context");
        this.f29593c = "ScaleImageView";
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i11, int i12) {
        int i13;
        float rotation = getRotation();
        if (rotation == 90.0f || rotation == 270.0f) {
            i12 = i11;
            i11 = i12;
        }
        int defaultSize = View.getDefaultSize(this.f29592b, i11);
        int defaultSize2 = View.getDefaultSize(this.f29591a, i12);
        if (this.f29592b > 0 && this.f29591a > 0) {
            int mode = View.MeasureSpec.getMode(i11);
            int size = View.MeasureSpec.getSize(i11);
            int mode2 = View.MeasureSpec.getMode(i12);
            int size2 = View.MeasureSpec.getSize(i12);
            z.a().d(this.f29593c, "widthSpecMode --->" + mode);
            z.a().d(this.f29593c, "heightSpecMode --->" + mode2);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z.a().d(this.f29593c, "onMeasure --->1");
                z.a().d(this.f29593c, "widthSpecSize --->" + size + " heightSpecSize--->" + size2);
                int i14 = this.f29592b;
                int i15 = i14 * size2;
                int i16 = this.f29591a;
                int i17 = size * i16;
                if (i15 < i17) {
                    defaultSize = i15 / i16;
                } else {
                    if (i15 > i17) {
                        int i18 = i17 / i14;
                        defaultSize = size;
                        defaultSize2 = i18;
                    } else {
                        defaultSize = size;
                    }
                    z.a().d(this.f29593c, "width --->" + defaultSize + " height--->" + defaultSize2);
                }
                defaultSize2 = size2;
                z.a().d(this.f29593c, "width --->" + defaultSize + " height--->" + defaultSize2);
            } else if (mode == 1073741824) {
                z.a().d(this.f29593c, "onMeasure --->2");
                int i19 = this.f29591a;
                int i21 = this.f29592b;
                int i22 = (size * i19) / i21;
                if (mode2 != Integer.MIN_VALUE || i22 <= size2) {
                    defaultSize = size;
                    defaultSize2 = i22;
                } else {
                    defaultSize = (i21 * size2) / i19;
                    defaultSize2 = size2;
                }
            } else {
                if (mode2 == 1073741824) {
                    z.a().d(this.f29593c, "onMeasure --->3");
                    int i23 = this.f29592b;
                    int i24 = this.f29591a;
                    int i25 = (size2 * i23) / i24;
                    if (mode != Integer.MIN_VALUE || i25 <= size) {
                        defaultSize2 = size2;
                        defaultSize = i25;
                    } else {
                        defaultSize2 = (i24 * size) / i23;
                    }
                } else {
                    int i26 = this.f29592b;
                    int i27 = this.f29591a;
                    if (mode2 != Integer.MIN_VALUE || i27 <= size2) {
                        i13 = i26;
                        size2 = i27;
                    } else {
                        i13 = (size2 * i26) / i27;
                    }
                    if (mode != Integer.MIN_VALUE || i13 <= size) {
                        defaultSize = i13;
                        defaultSize2 = size2;
                    } else {
                        defaultSize2 = (i27 * size) / i26;
                    }
                }
                defaultSize = size;
            }
        }
        setMeasuredDimension(defaultSize, defaultSize2);
    }

    public final void setSize(int i11, int i12) {
        z.a().d(this.f29593c, "videoWidth = " + i11 + "    videoHeight=" + i12);
        if (this.f29592b == i11 || this.f29591a == i12) {
            return;
        }
        this.f29592b = i11;
        this.f29591a = i12;
        requestLayout();
    }
}
