package com.transsion.ninegridview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.blankj.utilcode.util.f0;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class NineGridView extends ViewGroup {
    public static final int MODE_FILL = 0;
    public static final int MODE_GRID = 1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static av.b f53899n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f53900a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f53901b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f53902c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f53903d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f53904f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f53905g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f53906h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f53907i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f53908j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public List<ImageView> f53909k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public List<ImageInfo> f53910l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public NineGridViewAdapter f53911m;

    /* JADX INFO: compiled from: source.java */
    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f53912a;

        public a(int i11) {
            this.f53912a = i11;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            NineGridViewAdapter nineGridViewAdapter = NineGridView.this.f53911m;
            Context context = NineGridView.this.getContext();
            NineGridView nineGridView = NineGridView.this;
            nineGridViewAdapter.onImageItemClick(context, nineGridView, this.f53912a, nineGridView.f53911m.getImageInfo());
        }
    }

    public NineGridView(Context context) {
        this(context, null);
    }

    public NineGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NineGridView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f53900a = 250;
        this.f53901b = 1.0f;
        this.f53902c = 9;
        this.f53903d = 3;
        this.f53904f = 0;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.f53903d = (int) TypedValue.applyDimension(1, this.f53903d, displayMetrics);
        this.f53900a = (int) TypedValue.applyDimension(1, this.f53900a, displayMetrics);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.NineGridView);
        this.f53903d = (int) typedArrayObtainStyledAttributes.getDimension(R$styleable.NineGridView_ngv_gridSpacing, this.f53903d);
        this.f53900a = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.NineGridView_ngv_singleImageSize, this.f53900a);
        this.f53901b = typedArrayObtainStyledAttributes.getFloat(R$styleable.NineGridView_ngv_singleImageRatio, this.f53901b);
        this.f53902c = typedArrayObtainStyledAttributes.getInt(R$styleable.NineGridView_ngv_maxSize, this.f53902c);
        this.f53904f = typedArrayObtainStyledAttributes.getInt(R$styleable.NineGridView_ngv_mode, this.f53904f);
        typedArrayObtainStyledAttributes.recycle();
        this.f53909k = new ArrayList();
    }

    public static av.b getImageLoader() {
        return f53899n;
    }

    public static void setImageLoader(av.b bVar) {
        f53899n = bVar;
    }

    public final ImageView b(int i11) {
        if (i11 < this.f53909k.size()) {
            return this.f53909k.get(i11);
        }
        ImageView imageViewGenerateImageView = this.f53911m.generateImageView(getContext());
        imageViewGenerateImageView.setOnClickListener(new a(i11));
        this.f53909k.add(imageViewGenerateImageView);
        return imageViewGenerateImageView;
    }

    public int getMaxSize() {
        return this.f53902c;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        List<ImageInfo> list = this.f53910l;
        if (list == null) {
            return;
        }
        int size = list.size();
        for (int i15 = 0; i15 < size; i15++) {
            ImageView imageView = (ImageView) getChildAt(i15);
            int i16 = this.f53905g;
            int paddingLeft = ((this.f53907i + this.f53903d) * (i15 % i16)) + getPaddingLeft();
            int paddingTop = ((this.f53908j + this.f53903d) * (i15 / i16)) + getPaddingTop();
            imageView.layout(paddingLeft, paddingTop, this.f53907i + paddingLeft, this.f53908j + paddingTop);
            av.b bVar = f53899n;
            if (bVar != null) {
                bVar.a(getContext(), imageView, this.f53910l.get(i15).bigImageUrl, this.f53907i, this.f53908j, this.f53910l.get(i15).thumbnailUrl);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0073  */
    /* JADX WARN: Code duplicated, block: B:18:0x0086  */
    @Override // android.view.View
    public void onMeasure(int i11, int i12) {
        int iMin;
        int i13;
        int i14;
        super.onMeasure(i11, i12);
        int size = View.MeasureSpec.getSize(i11);
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        List<ImageInfo> list = this.f53910l;
        int paddingTop = 0;
        if (list != null && list.size() > 0) {
            if (this.f53910l.size() == 1) {
                ImageInfo imageInfo = this.f53910l.get(0);
                float f11 = imageInfo.imageViewWidth;
                if (f11 > 0.0f) {
                    float f12 = imageInfo.imageViewHeight;
                    if (f12 <= 0.0f) {
                        iMin = Math.min(this.f53900a, paddingLeft);
                        this.f53907i = iMin;
                        i13 = (int) (iMin / this.f53901b);
                        this.f53908j = i13;
                        i14 = this.f53900a;
                        if (i13 > i14) {
                            this.f53907i = (int) (iMin * ((i14 * 1.0f) / i13));
                            this.f53908j = i14;
                        }
                    } else if (f11 > f12) {
                        int iMin2 = Math.min(f0.a(216.0f), (int) imageInfo.imageViewWidth);
                        this.f53907i = iMin2;
                        this.f53908j = (iMin2 * ((int) imageInfo.imageViewHeight)) / ((int) imageInfo.imageViewWidth);
                    } else {
                        int iMin3 = Math.min(f0.a(216.0f), (int) imageInfo.imageViewHeight);
                        this.f53908j = iMin3;
                        this.f53907i = (iMin3 * ((int) imageInfo.imageViewWidth)) / ((int) imageInfo.imageViewHeight);
                    }
                } else {
                    iMin = Math.min(this.f53900a, paddingLeft);
                    this.f53907i = iMin;
                    i13 = (int) (iMin / this.f53901b);
                    this.f53908j = i13;
                    i14 = this.f53900a;
                    if (i13 > i14) {
                        this.f53907i = (int) (iMin * ((i14 * 1.0f) / i13));
                        this.f53908j = i14;
                    }
                }
            } else {
                int i15 = (paddingLeft - (this.f53903d * 2)) / 3;
                this.f53908j = i15;
                this.f53907i = i15;
            }
            int i16 = this.f53907i;
            int i17 = this.f53905g;
            size = (i16 * i17) + (this.f53903d * (i17 - 1)) + getPaddingLeft() + getPaddingRight();
            int i18 = this.f53908j;
            int i19 = this.f53906h;
            paddingTop = (i18 * i19) + (this.f53903d * (i19 - 1)) + getPaddingTop() + getPaddingBottom();
        }
        setMeasuredDimension(size, paddingTop);
    }

    public void setAdapter(@NonNull NineGridViewAdapter nineGridViewAdapter) {
        this.f53911m = nineGridViewAdapter;
        List<ImageInfo> imageInfo = nineGridViewAdapter.getImageInfo();
        if (imageInfo == null || imageInfo.isEmpty()) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        int size = imageInfo.size();
        int i11 = this.f53902c;
        if (i11 > 0 && size > i11) {
            imageInfo = imageInfo.subList(0, i11);
            size = imageInfo.size();
        }
        this.f53906h = (size / 3) + (size % 3 == 0 ? 0 : 1);
        this.f53905g = 3;
        if (this.f53904f == 1 && size == 4) {
            this.f53906h = 2;
            this.f53905g = 2;
        }
        List<ImageInfo> list = this.f53910l;
        if (list == null) {
            for (int i12 = 0; i12 < size; i12++) {
                ImageView imageViewB = b(i12);
                if (imageViewB == null) {
                    return;
                }
                addView(imageViewB, generateDefaultLayoutParams());
            }
        } else {
            int size2 = list.size();
            if (size2 > size) {
                removeViews(size, size2 - size);
            } else if (size2 < size) {
                while (size2 < size) {
                    ImageView imageViewB2 = b(size2);
                    if (imageViewB2 == null) {
                        return;
                    }
                    addView(imageViewB2, generateDefaultLayoutParams());
                    size2++;
                }
            }
        }
        int size3 = nineGridViewAdapter.getImageInfo().size();
        int i13 = this.f53902c;
        if (size3 > i13) {
            View childAt = getChildAt(i13 - 1);
            if (childAt instanceof NineGridViewWrapper) {
                ((NineGridViewWrapper) childAt).setMoreNum(nineGridViewAdapter.getImageInfo().size() - this.f53902c);
            }
        }
        this.f53910l = imageInfo;
        requestLayout();
    }

    public void setGridSpacing(int i11) {
        this.f53903d = i11;
    }

    public void setMaxSize(int i11) {
        this.f53902c = i11;
    }

    public void setSingleImageRatio(float f11) {
        this.f53901b = f11;
    }

    public void setSingleImageSize(int i11) {
        this.f53900a = i11;
    }
}
