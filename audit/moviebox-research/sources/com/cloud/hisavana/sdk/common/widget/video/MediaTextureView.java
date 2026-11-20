package com.cloud.hisavana.sdk.common.widget.video;

import android.content.Context;
import android.view.TextureView;
import android.view.View;
import com.cloud.hisavana.sdk.z;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class MediaTextureView extends TextureView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f29576a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f29577b;

    public MediaTextureView(Context context) {
        super(context);
    }

    public void adaptVideoSize(int i11, int i12) {
        z.a().d("MediaTextureView", "videoWidth --->" + i11);
        z.a().d("MediaTextureView", "videoHeight --->" + i12);
        z.a().d("MediaTextureView", "this.videoWidth --->" + this.f29577b);
        z.a().d("MediaTextureView", "this.videoHeight --->" + this.f29576a);
        if (this.f29577b == i11 || this.f29576a == i12) {
            return;
        }
        this.f29577b = i11;
        this.f29576a = i12;
        requestLayout();
    }

    @Override // android.view.View
    public void onMeasure(int i11, int i12) {
        int i13;
        int i14;
        float rotation = getRotation();
        if (rotation == 90.0f || rotation == 270.0f) {
            i12 = i11;
            i11 = i12;
        }
        int defaultSize = View.getDefaultSize(this.f29577b, i11);
        int defaultSize2 = View.getDefaultSize(this.f29576a, i12);
        if (this.f29577b > 0 && this.f29576a > 0) {
            int mode = View.MeasureSpec.getMode(i11);
            int size = View.MeasureSpec.getSize(i11);
            int mode2 = View.MeasureSpec.getMode(i12);
            int size2 = View.MeasureSpec.getSize(i12);
            z.a().d("MediaTextureView", "widthSpecMode --->" + mode);
            z.a().d("MediaTextureView", "heightSpecMode --->" + mode2);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z.a().d("MediaTextureView", "onMeasure --->1");
                z.a().d("MediaTextureView", "widthSpecSize --->" + size + " heightSpecSize--->" + size2);
                int i15 = this.f29577b;
                int i16 = i15 * size2;
                int i17 = this.f29576a;
                int i18 = size * i17;
                if (i16 < i18) {
                    defaultSize = i16 / i17;
                } else {
                    if (i16 > i18) {
                        int i19 = i18 / i15;
                        defaultSize = size;
                        defaultSize2 = i19;
                    } else {
                        defaultSize = size;
                    }
                    z.a().d("MediaTextureView", "width --->" + defaultSize + " height--->" + defaultSize2);
                }
                defaultSize2 = size2;
                z.a().d("MediaTextureView", "width --->" + defaultSize + " height--->" + defaultSize2);
            } else if (mode == 1073741824) {
                z.a().d("MediaTextureView", "onMeasure --->2");
                int i21 = this.f29576a;
                int i22 = this.f29577b;
                int i23 = (size * i21) / i22;
                if (mode2 != Integer.MIN_VALUE || i23 <= size2) {
                    defaultSize = size;
                    defaultSize2 = i23;
                } else {
                    defaultSize = (i22 * size2) / i21;
                    defaultSize2 = size2;
                }
            } else {
                if (mode2 == 1073741824) {
                    z.a().d("MediaTextureView", "onMeasure --->3");
                    i13 = this.f29577b;
                    i14 = this.f29576a;
                    int i24 = (size2 * i13) / i14;
                    if (mode != Integer.MIN_VALUE || i24 <= size) {
                        defaultSize2 = size2;
                        defaultSize = i24;
                    }
                } else {
                    if (size > 0 || size2 > 0) {
                        i13 = this.f29577b;
                        int i25 = size / i13;
                        i14 = this.f29576a;
                        if (i25 >= size2 / i14) {
                            defaultSize = (i13 * size2) / i14;
                        }
                    } else {
                        defaultSize = size;
                    }
                    defaultSize2 = size2;
                }
                defaultSize2 = (i14 * size) / i13;
                defaultSize = size;
            }
        }
        setMeasuredDimension(defaultSize, defaultSize2);
    }

    @Override // android.view.View
    public void setRotation(float f11) {
        if (f11 != getRotation()) {
            super.setRotation(f11);
            requestLayout();
        }
    }
}
