package com.transsion.ninegridview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class NineGridViewNew extends ViewGroup {
    public static final a Companion = new a(null);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static av.b f53914v = new c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f53915a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f53916b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f53917c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f53918d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f53919f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f53920g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f53921h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f53922i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f53923j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f53924k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f53925l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f53926m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f53927n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f53928o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f53929p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public List<ImageView> f53930q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public List<? extends ImageInfo> f53931r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public NineGridViewAdapter f53932s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final float f53933t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final float f53934u;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NineGridViewNew(Context context) {
        this(context, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NineGridViewNew(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NineGridViewNew(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
        this.f53916b = 1;
        this.f53917c = 250;
        this.f53918d = 1.0f;
        this.f53919f = 9;
        this.f53920g = 2;
        this.f53921h = this.f53915a;
        this.f53933t = 2.1111112f;
        this.f53934u = 0.75f;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.f53920g = (int) TypedValue.applyDimension(1, this.f53920g, displayMetrics);
        this.f53917c = (int) TypedValue.applyDimension(1, this.f53917c, displayMetrics);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.NineGridView);
        Intrinsics.f(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…R.styleable.NineGridView)");
        this.f53920g = (int) typedArrayObtainStyledAttributes.getDimension(R$styleable.NineGridView_ngv_gridSpacing, this.f53920g);
        this.f53917c = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.NineGridView_ngv_singleImageSize, this.f53917c);
        this.f53918d = typedArrayObtainStyledAttributes.getFloat(R$styleable.NineGridView_ngv_singleImageRatio, this.f53918d);
        this.f53919f = typedArrayObtainStyledAttributes.getInt(R$styleable.NineGridView_ngv_maxSize, this.f53919f);
        this.f53921h = typedArrayObtainStyledAttributes.getInt(R$styleable.NineGridView_ngv_mode, this.f53921h);
        typedArrayObtainStyledAttributes.recycle();
        this.f53930q = new ArrayList();
    }

    public static final void h(NineGridViewNew this$0, int i11, View view) {
        Intrinsics.g(this$0, "this$0");
        NineGridViewAdapter nineGridViewAdapter = this$0.f53932s;
        Intrinsics.d(nineGridViewAdapter);
        Context context = this$0.getContext();
        NineGridViewAdapter nineGridViewAdapter2 = this$0.f53932s;
        Intrinsics.d(nineGridViewAdapter2);
        nineGridViewAdapter.onImageItemClick(context, this$0, i11, nineGridViewAdapter2.getImageInfo());
    }

    /* JADX WARN: Code duplicated, block: B:8:0x001f A[PHI: r1
  0x001f: PHI (r1v3 float) = (r1v1 float), (r1v2 float) binds: [B:7:0x001d, B:10:0x0029] A[DONT_GENERATE, DONT_INLINE]] */
    public final void b(ImageInfo imageInfo, int i11, int i12) {
        int i13;
        if (imageInfo.imageViewWidth <= 0.0f || imageInfo.imageViewHeight <= 0.0f) {
            return;
        }
        int iE = e(i11, i12);
        this.f53924k = iE;
        float f11 = imageInfo.imageViewWidth;
        float f12 = imageInfo.imageViewHeight;
        float f13 = f11 / f12;
        float f14 = this.f53933t;
        if (f13 > f14) {
            i13 = (int) (iE / f14);
        } else {
            float f15 = f11 / f12;
            f14 = this.f53934u;
            if (f15 < f14) {
                i13 = (int) (iE / f14);
            } else {
                i13 = (int) (((iE * 1.0f) / f11) * f12);
            }
        }
        this.f53925l = i13;
        this.f53927n = 0;
        this.f53929p = 0;
    }

    /* JADX WARN: Code duplicated, block: B:8:0x001f A[PHI: r1
  0x001f: PHI (r1v3 float) = (r1v1 float), (r1v2 float) binds: [B:7:0x001d, B:10:0x0029] A[DONT_GENERATE, DONT_INLINE]] */
    public final void c(ImageInfo imageInfo, int i11, int i12) {
        int i13;
        if (imageInfo.imageViewWidth <= 0.0f || imageInfo.imageViewHeight <= 0.0f) {
            return;
        }
        int iE = e(i11, i12);
        this.f53926m = iE;
        float f11 = imageInfo.imageViewWidth;
        float f12 = imageInfo.imageViewHeight;
        float f13 = f11 / f12;
        float f14 = this.f53933t;
        if (f13 > f14) {
            i13 = (int) (iE / f14);
        } else {
            float f15 = f11 / f12;
            f14 = this.f53934u;
            if (f15 < f14) {
                i13 = (int) (iE / f14);
            } else {
                i13 = (int) (((iE * 1.0f) / f11) * f12);
            }
        }
        this.f53927n = i13;
        this.f53929p = 0;
    }

    /* JADX WARN: Code duplicated, block: B:8:0x001f A[PHI: r1
  0x001f: PHI (r1v3 float) = (r1v1 float), (r1v2 float) binds: [B:7:0x001d, B:10:0x0029] A[DONT_GENERATE, DONT_INLINE]] */
    public final void d(ImageInfo imageInfo, int i11, int i12) {
        int i13;
        if (imageInfo.imageViewWidth <= 0.0f || imageInfo.imageViewHeight <= 0.0f) {
            return;
        }
        int iE = e(i11, i12);
        this.f53928o = iE;
        float f11 = imageInfo.imageViewWidth;
        float f12 = imageInfo.imageViewHeight;
        float f13 = f11 / f12;
        float f14 = this.f53933t;
        if (f13 > f14) {
            i13 = (int) (iE / f14);
        } else {
            float f15 = f11 / f12;
            f14 = this.f53934u;
            if (f15 < f14) {
                i13 = (int) (iE / f14);
            } else {
                i13 = (int) (((iE * 1.0f) / f11) * f12);
            }
        }
        this.f53929p = i13;
    }

    public final int e(int i11, int i12) {
        return (i11 - (this.f53920g * (i12 - 1))) / i12;
    }

    public final int f(int i11) {
        List<? extends ImageInfo> list = this.f53931r;
        if (list != null) {
            switch (list.size()) {
                case 1:
                case 2:
                case 6:
                case 9:
                    return i11 % 3;
                case 3:
                case 4:
                    return i11 % 2 == 0 ? 0 : 1;
                case 5:
                    return i11 < 3 ? i11 % 2 : (i11 - 1) % 2;
                case 7:
                    return i11 < 4 ? i11 % 3 : (i11 - 1) % 3;
                case 8:
                    return i11 < 5 ? i11 % 3 : (i11 - 2) % 3;
            }
        }
        return 0;
    }

    public final ImageView g(final int i11) {
        List<ImageView> list = this.f53930q;
        Intrinsics.d(list);
        if (i11 < list.size()) {
            List<ImageView> list2 = this.f53930q;
            Intrinsics.d(list2);
            return list2.get(i11);
        }
        NineGridViewAdapter nineGridViewAdapter = this.f53932s;
        Intrinsics.d(nineGridViewAdapter);
        ImageView imageViewGenerateImageView = nineGridViewAdapter.generateImageView(getContext());
        Intrinsics.f(imageViewGenerateImageView, "mAdapter!!.generateImageView(context)");
        imageViewGenerateImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.ninegridview.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NineGridViewNew.h(this.f53953a, i11, view);
            }
        });
        List<ImageView> list3 = this.f53930q;
        if (list3 != null) {
            list3.add(imageViewGenerateImageView);
        }
        return imageViewGenerateImageView;
    }

    public final int getMODE_FILL() {
        return this.f53915a;
    }

    public final int getMODE_GRID() {
        return this.f53916b;
    }

    public final int getMaxSize() {
        return this.f53919f;
    }

    public final int i(int i11) {
        List<? extends ImageInfo> list = this.f53931r;
        if (list == null) {
            return 0;
        }
        switch (list.size()) {
            case 1:
            case 2:
                return 1;
            case 3:
            case 4:
                return i11 < 2 ? 1 : 2;
            case 5:
                if (i11 < 2) {
                    return 1;
                }
                return i11 == 2 ? 2 : 3;
            case 6:
                return i11 < 3 ? 1 : 2;
            case 7:
                if (i11 < 3) {
                    return 1;
                }
                return i11 == 3 ? 2 : 3;
            case 8:
                if (i11 < 3) {
                    return 1;
                }
                return (3 > i11 || i11 >= 5) ? 3 : 2;
            case 9:
                if (i11 < 3) {
                    return 1;
                }
                return (3 > i11 || i11 >= 6) ? 3 : 2;
            default:
                return 0;
        }
    }

    public final ImageInfo j(ImageInfo imageInfo, ImageInfo imageInfo2) {
        return imageInfo.imageViewHeight <= imageInfo2.imageViewHeight ? imageInfo : imageInfo2;
    }

    public final ImageInfo k(ImageInfo imageInfo, ImageInfo imageInfo2, ImageInfo imageInfo3) {
        return j(j(imageInfo, imageInfo2), imageInfo3);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        List<? extends ImageInfo> list = this.f53931r;
        if (list == null) {
            return;
        }
        Intrinsics.d(list);
        list.get(0).alreadyShow = 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        List<? extends ImageInfo> list = this.f53931r;
        if (list == null) {
            return;
        }
        int size = list != null ? list.size() : 0;
        List<? extends ImageInfo> list2 = this.f53931r;
        Intrinsics.d(list2);
        if (list2.get(0).alreadyShow == 1) {
            return;
        }
        List<? extends ImageInfo> list3 = this.f53931r;
        Intrinsics.d(list3);
        list3.get(0).alreadyShow = 1;
        for (int i15 = 0; i15 < size; i15++) {
            View childAt = getChildAt(i15);
            Intrinsics.e(childAt, "null cannot be cast to non-null type android.widget.ImageView");
            ImageView imageView = (ImageView) childAt;
            int i16 = i(i15);
            int iF = f(i15);
            List<? extends ImageInfo> list4 = this.f53931r;
            ImageInfo imageInfo = list4 != null ? list4.get(i15) : null;
            if (i16 == 1) {
                int paddingLeft = ((this.f53924k + this.f53920g) * iF) + getPaddingLeft();
                int paddingTop = getPaddingTop();
                imageView.layout(paddingLeft, paddingTop, this.f53924k + paddingLeft, this.f53925l + paddingTop);
                av.b bVar = f53914v;
                if (bVar != null) {
                    bVar.a(getContext(), imageView, imageInfo != null ? imageInfo.bigImageUrl : null, this.f53924k, this.f53925l, imageInfo != null ? imageInfo.thumbnailUrl : null);
                }
            } else if (i16 != 2) {
                int paddingLeft2 = ((this.f53928o + this.f53920g) * iF) + getPaddingLeft();
                int paddingTop2 = (this.f53920g * (i16 - 1)) + this.f53925l + this.f53927n + getPaddingTop();
                imageView.layout(paddingLeft2, paddingTop2, this.f53928o + paddingLeft2, this.f53929p + paddingTop2);
                av.b bVar2 = f53914v;
                if (bVar2 != null) {
                    bVar2.a(getContext(), imageView, imageInfo != null ? imageInfo.bigImageUrl : null, this.f53928o, this.f53929p, imageInfo != null ? imageInfo.thumbnailUrl : null);
                }
            } else {
                int paddingLeft3 = ((this.f53926m + this.f53920g) * iF) + getPaddingLeft();
                int paddingTop3 = (this.f53920g * (i16 - 1)) + this.f53925l + getPaddingTop();
                imageView.layout(paddingLeft3, paddingTop3, this.f53926m + paddingLeft3, this.f53927n + paddingTop3);
                av.b bVar3 = f53914v;
                if (bVar3 != null) {
                    bVar3.a(getContext(), imageView, imageInfo != null ? imageInfo.bigImageUrl : null, this.f53926m, this.f53927n, imageInfo != null ? imageInfo.thumbnailUrl : null);
                }
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        int size = View.MeasureSpec.getSize(i11);
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        List<? extends ImageInfo> list = this.f53931r;
        int paddingTop = 0;
        if (list != null && (!list.isEmpty())) {
            switch (list.size()) {
                case 1:
                    b(list.get(0), paddingLeft, 1);
                    break;
                case 2:
                    b(j(list.get(0), list.get(1)), paddingLeft, 2);
                    break;
                case 3:
                    b(j(list.get(0), list.get(1)), paddingLeft, 2);
                    c(list.get(2), paddingLeft, 1);
                    break;
                case 4:
                    b(j(list.get(0), list.get(1)), paddingLeft, 2);
                    c(j(list.get(2), list.get(3)), paddingLeft, 2);
                    break;
                case 5:
                    b(j(list.get(0), list.get(1)), paddingLeft, 2);
                    c(list.get(2), paddingLeft, 1);
                    d(j(list.get(3), list.get(4)), paddingLeft, 2);
                    break;
                case 6:
                    b(k(list.get(0), list.get(1), list.get(2)), paddingLeft, 3);
                    c(k(list.get(3), list.get(4), list.get(5)), paddingLeft, 3);
                    break;
                case 7:
                    b(k(list.get(0), list.get(1), list.get(2)), paddingLeft, 3);
                    c(list.get(3), paddingLeft, 1);
                    d(k(list.get(4), list.get(5), list.get(6)), paddingLeft, 3);
                    break;
                case 8:
                    b(k(list.get(0), list.get(1), list.get(2)), paddingLeft, 3);
                    c(j(list.get(3), list.get(4)), paddingLeft, 2);
                    d(k(list.get(5), list.get(6), list.get(7)), paddingLeft, 3);
                    break;
                case 9:
                    b(k(list.get(0), list.get(1), list.get(2)), paddingLeft, 3);
                    c(k(list.get(3), list.get(4), list.get(5)), paddingLeft, 3);
                    d(k(list.get(6), list.get(7), list.get(8)), paddingLeft, 3);
                    break;
            }
            size = getPaddingRight() + paddingLeft + getPaddingLeft();
            paddingTop = this.f53925l + this.f53927n + this.f53929p + (this.f53920g * (this.f53923j - 1)) + getPaddingTop() + getPaddingBottom();
        }
        setMeasuredDimension(size, paddingTop);
    }

    public final void setAdapter(NineGridViewAdapter adapter) {
        Intrinsics.g(adapter, "adapter");
        this.f53932s = adapter;
        List<ImageInfo> imageInfo = adapter.getImageInfo();
        if (imageInfo == null || imageInfo.isEmpty()) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        int size = imageInfo.size();
        int i11 = this.f53919f;
        if (1 <= i11 && i11 < size) {
            imageInfo = imageInfo.subList(0, i11);
            size = imageInfo.size();
        }
        if (size == 1) {
            this.f53922i = 1;
            this.f53923j = 1;
        } else if (2 <= size && size < 6) {
            this.f53922i = 2;
            this.f53923j = (size / 2) + (size % 2 == 0 ? 0 : 1);
        } else if (6 <= size && size < 10) {
            this.f53922i = 3;
            this.f53923j = (size / 3) + (size % 3 == 0 ? 0 : 1);
        }
        List<? extends ImageInfo> list = this.f53931r;
        if (list == null) {
            for (int size2 = 0; size2 < size; size2++) {
                addView(g(size2), generateDefaultLayoutParams());
            }
        } else {
            size2 = list != null ? list.size() : 0;
            if (size2 > size) {
                removeViews(size, size2 - size);
            } else if (size2 < size) {
                while (size2 < size) {
                    addView(g(size2), generateDefaultLayoutParams());
                    size2++;
                }
            }
        }
        int size3 = adapter.getImageInfo().size();
        int i12 = this.f53919f;
        if (size3 > i12) {
            View childAt = getChildAt(i12 - 1);
            if (childAt instanceof NineGridViewWrapper) {
                ((NineGridViewWrapper) childAt).setMoreNum(adapter.getImageInfo().size() - this.f53919f);
            }
        }
        this.f53931r = imageInfo;
        requestLayout();
    }

    public final void setGridSpacing(int i11) {
        this.f53920g = i11;
    }

    public final void setMaxSize(int i11) {
        this.f53919f = i11;
    }

    public final void setSingleImageRatio(float f11) {
        this.f53918d = f11;
    }

    public final void setSingleImageSize(int i11) {
        this.f53917c = i11;
    }
}
