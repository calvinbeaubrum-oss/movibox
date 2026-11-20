package com.transsion.ninegridview.video;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import av.b;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.moviedetailapi.bean.GifBean;
import com.transsion.moviedetailapi.bean.Image;
import com.transsion.ninegridview.R$id;
import com.transsion.ninegridview.R$styleable;
import com.transsion.ninegridview.c;
import com.transsion.ninegridview.video.NineGridVideoView;
import com.transsion.player.ui.ORPlayerView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.g;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.l;

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
@SourceDebugExtension
public final class NineGridVideoView extends ViewGroup {
    public static final a Companion = new a(null);

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static b f54008t = new c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<Image> f54009a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f54010b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f54011c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f54012d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f54013f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List<NineGridItemView> f54014g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f54015h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f54016i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f54017j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f54018k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f54019l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f54020m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f54021n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f54022o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final float f54023p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final float f54024q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public NineGridVideoViewAdapter f54025r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f54026s;

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
    public NineGridVideoView(Context context) {
        this(context, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NineGridVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NineGridVideoView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
        this.f54010b = 4;
        this.f54011c = 250;
        this.f54012d = 1.0f;
        this.f54013f = 9;
        this.f54014g = new ArrayList();
        this.f54023p = 2.1111112f;
        this.f54024q = 0.75f;
        this.f54026s = true;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.f54010b = (int) TypedValue.applyDimension(1, this.f54010b, displayMetrics);
        this.f54011c = (int) TypedValue.applyDimension(1, this.f54011c, displayMetrics);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.NineGridView);
        Intrinsics.f(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…R.styleable.NineGridView)");
        this.f54010b = (int) typedArrayObtainStyledAttributes.getDimension(R$styleable.NineGridView_ngv_gridSpacing, this.f54010b);
        this.f54011c = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.NineGridView_ngv_singleImageSize, this.f54011c);
        this.f54012d = typedArrayObtainStyledAttributes.getFloat(R$styleable.NineGridView_ngv_singleImageRatio, this.f54012d);
        this.f54013f = typedArrayObtainStyledAttributes.getInt(R$styleable.NineGridView_ngv_maxSize, this.f54013f);
        this.f54026s = typedArrayObtainStyledAttributes.getBoolean(R$styleable.NineGridView_enable_click, true);
        typedArrayObtainStyledAttributes.recycle();
        setId(R$id.nine_grid);
    }

    public static final void i(NineGridVideoView this$0, NineGridItemView this_apply, int i11, View view) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(this_apply, "$this_apply");
        NineGridVideoViewAdapter nineGridVideoViewAdapter = this$0.f54025r;
        if (nineGridVideoViewAdapter != null) {
            Context context = this_apply.getContext();
            Intrinsics.f(context, "context");
            NineGridVideoViewAdapter nineGridVideoViewAdapter2 = this$0.f54025r;
            nineGridVideoViewAdapter.onItemClick(context, this$0, i11, nineGridVideoViewAdapter2 != null ? nineGridVideoViewAdapter2.getImageList() : null);
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x002c A[PHI: r2
  0x002c: PHI (r2v2 float) = (r2v0 float), (r2v1 float) binds: [B:13:0x002a, B:16:0x0034] A[DONT_GENERATE, DONT_INLINE]] */
    public final void b(Image image, int i11, int i12) {
        int i13;
        Integer width = image.getWidth();
        int iIntValue = width != null ? width.intValue() : 0;
        Integer height = image.getHeight();
        int iIntValue2 = height != null ? height.intValue() : 0;
        if (iIntValue <= 0 || iIntValue2 <= 0) {
            return;
        }
        int iF = f(i11, i12);
        this.f54017j = iF;
        float f11 = iIntValue / iIntValue2;
        float f12 = this.f54023p;
        if (f11 > f12) {
            i13 = (int) (iF / f12);
        } else {
            f12 = this.f54024q;
            if (f11 < f12) {
                i13 = (int) (iF / f12);
            } else {
                i13 = (int) (((iF * 1.0f) / iIntValue) * iIntValue2);
            }
        }
        this.f54018k = i13;
        this.f54020m = 0;
        this.f54022o = 0;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x002c A[PHI: r2
  0x002c: PHI (r2v2 float) = (r2v0 float), (r2v1 float) binds: [B:13:0x002a, B:16:0x0034] A[DONT_GENERATE, DONT_INLINE]] */
    public final void c(Image image, int i11, int i12) {
        int i13;
        Integer width = image.getWidth();
        int iIntValue = width != null ? width.intValue() : 0;
        Integer height = image.getHeight();
        int iIntValue2 = height != null ? height.intValue() : 0;
        if (iIntValue <= 0 || iIntValue2 <= 0) {
            return;
        }
        int iF = f(i11, i12);
        this.f54019l = iF;
        float f11 = iIntValue / iIntValue2;
        float f12 = this.f54023p;
        if (f11 > f12) {
            i13 = (int) (iF / f12);
        } else {
            f12 = this.f54024q;
            if (f11 < f12) {
                i13 = (int) (iF / f12);
            } else {
                i13 = (int) (((iF * 1.0f) / iIntValue) * iIntValue2);
            }
        }
        this.f54020m = i13;
        this.f54022o = 0;
    }

    public final boolean currentGifVisible(int i11) {
        String videoUrl;
        List<Image> list = this.f54009a;
        if (list != null) {
            int i12 = 0;
            for (Object obj : list) {
                int i13 = i12 + 1;
                if (i12 < 0) {
                    g.u();
                }
                GifBean gifBean = ((Image) obj).getGifBean();
                if (gifBean != null && (videoUrl = gifBean.getVideoUrl()) != null && videoUrl.length() > 0 && i11 == i12) {
                    View childAt = getChildAt(i12);
                    Rect rect = new Rect();
                    if (!Intrinsics.b(childAt != null ? Boolean.valueOf(childAt.getGlobalVisibleRect(rect)) : null, Boolean.TRUE)) {
                        continue;
                    } else if ((rect.height() * 1.0f) / (childAt.getHeight() * 1.0f) > 0.5f) {
                        return true;
                    }
                }
                i12 = i13;
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x002a A[PHI: r6
  0x002a: PHI (r6v3 float) = (r6v1 float), (r6v2 float) binds: [B:12:0x0028, B:16:0x0032] A[DONT_GENERATE, DONT_INLINE]] */
    public final void d(Image image, int i11, int i12) {
        float f11;
        Integer width = image.getWidth();
        int iIntValue = width != null ? width.intValue() : 0;
        Integer height = image.getHeight();
        int iIntValue2 = height != null ? height.intValue() : 0;
        if (iIntValue <= 0 || iIntValue2 <= 0) {
            return;
        }
        int iF = f(i11, i12);
        this.f54021n = iF;
        float f12 = iIntValue / iIntValue2;
        float f13 = this.f54023p;
        if (f12 > f13) {
            f11 = iF / f13;
        } else {
            f13 = this.f54024q;
            if (f12 < f13) {
                f11 = iF / f13;
            } else {
                f11 = ((iF * 1.0f) / iIntValue) * iIntValue2;
            }
        }
        this.f54022o = (int) f11;
    }

    public final void e() {
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (childAt != null && (childAt instanceof NineGridItemView)) {
                FrameLayout frameLayout = (FrameLayout) childAt.findViewById(R$id.video_container);
                if (frameLayout != null) {
                    frameLayout.removeAllViews();
                }
                ShapeableImageView shapeableImageView = (ShapeableImageView) childAt.findViewById(R$id.video_cover);
                if (shapeableImageView != null) {
                    Intrinsics.f(shapeableImageView, "findViewById<ShapeableImageView>(R.id.video_cover)");
                    so.c.k(shapeableImageView);
                    shapeableImageView.setImageResource(0);
                }
                AppCompatImageView appCompatImageView = (AppCompatImageView) childAt.findViewById(R$id.label_gif);
                if (appCompatImageView != null) {
                    Intrinsics.f(appCompatImageView, "findViewById<AppCompatImageView>(R.id.label_gif)");
                    so.c.g(appCompatImageView);
                }
            }
        }
    }

    public final int f(int i11, int i12) {
        return (i11 - (this.f54010b * (i12 - 1))) / i12;
    }

    public final int g(int i11) {
        List<Image> list = this.f54009a;
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

    public final int getGridSpacing() {
        return this.f54010b;
    }

    public final int getMaxImageSize() {
        return this.f54013f;
    }

    public final float getSingleImageRatio() {
        return this.f54012d;
    }

    public final int getSingleImageSize() {
        return this.f54011c;
    }

    public final NineGridItemView h(final int i11) {
        NineGridVideoViewAdapter nineGridVideoViewAdapter = this.f54025r;
        if (nineGridVideoViewAdapter == null) {
            return null;
        }
        if (i11 >= this.f54014g.size()) {
            Context context = getContext();
            Intrinsics.f(context, "context");
            final NineGridItemView nineGridItemViewGenerateItemView = nineGridVideoViewAdapter.generateItemView(context);
            if (this.f54026s) {
                nineGridItemViewGenerateItemView.setOnClickListener(new View.OnClickListener() { // from class: bv.c
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        NineGridVideoView.i(this.f14422a, nineGridItemViewGenerateItemView, i11, view);
                    }
                });
                this.f54014g.add(nineGridItemViewGenerateItemView);
            }
            return nineGridItemViewGenerateItemView;
        }
        NineGridItemView nineGridItemView = this.f54014g.get(i11);
        FrameLayout frameLayout = (FrameLayout) nineGridItemView.findViewById(R$id.video_container);
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
        ShapeableImageView shapeableImageView = (ShapeableImageView) nineGridItemView.findViewById(R$id.video_cover);
        if (shapeableImageView != null) {
            Intrinsics.f(shapeableImageView, "findViewById<ShapeableImageView>(R.id.video_cover)");
            shapeableImageView.setImageResource(0);
            so.c.k(shapeableImageView);
        }
        AppCompatImageView appCompatImageView = (AppCompatImageView) nineGridItemView.findViewById(R$id.label_gif);
        if (appCompatImageView == null) {
            return nineGridItemView;
        }
        Intrinsics.f(appCompatImageView, "findViewById<AppCompatImageView>(R.id.label_gif)");
        so.c.g(appCompatImageView);
        return nineGridItemView;
    }

    public final boolean hasGifVisible() {
        String videoUrl;
        List<Image> list = this.f54009a;
        if (list != null) {
            int i11 = 0;
            for (Object obj : list) {
                int i12 = i11 + 1;
                if (i11 < 0) {
                    g.u();
                }
                GifBean gifBean = ((Image) obj).getGifBean();
                if (gifBean != null && (videoUrl = gifBean.getVideoUrl()) != null && videoUrl.length() > 0) {
                    View childAt = getChildAt(i11);
                    Rect rect = new Rect();
                    if (!Intrinsics.b(childAt != null ? Boolean.valueOf(childAt.getGlobalVisibleRect(rect)) : null, Boolean.TRUE)) {
                        continue;
                    } else if ((rect.height() * 1.0f) / (childAt.getHeight() * 1.0f) > 0.5f) {
                        return true;
                    }
                }
                i11 = i12;
            }
        }
        return false;
    }

    public final int j(int i11) {
        List<Image> list = this.f54009a;
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

    public final Image k(Image image, Image image2) {
        Integer height = image.getHeight();
        int iIntValue = height != null ? height.intValue() : 0;
        Integer height2 = image2.getHeight();
        return iIntValue <= (height2 != null ? height2.intValue() : 0) ? image : image2;
    }

    public final Image l(Image image, Image image2, Image image3) {
        return k(k(image, image2), image3);
    }

    public final void loadImage() {
        String url;
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            Intrinsics.e(childAt, "null cannot be cast to non-null type com.transsion.ninegridview.video.NineGridItemView");
            NineGridItemView nineGridItemView = (NineGridItemView) childAt;
            List<Image> list = this.f54009a;
            Image image = list != null ? list.get(i11) : null;
            f54008t.b(getContext(), nineGridItemView, image, nineGridItemView.getWidth(), nineGridItemView.getHeight());
            AppCompatImageView appCompatImageView = (AppCompatImageView) nineGridItemView.findViewById(R$id.label_gif);
            if (appCompatImageView != null) {
                if (image == null || (url = image.getUrl()) == null || !l.u(url, ".gif", false, 2, null)) {
                    so.c.g(appCompatImageView);
                } else {
                    so.c.k(appCompatImageView);
                }
            }
        }
    }

    public final void m(NineGridItemView nineGridItemView, int i11, int i12, int i13, int i14, int i15, int i16) {
        nineGridItemView.layout(i11, i12, i13, i14);
        ((ShapeableImageView) nineGridItemView.findViewById(R$id.video_cover)).layout(0, 0, i15, i16);
        ((FrameLayout) nineGridItemView.findViewById(R$id.video_container)).layout(0, 0, i15, i16);
        ORPlayerView oRPlayerView = (ORPlayerView) nineGridItemView.findViewById(R$id.player_view);
        if (oRPlayerView != null) {
            oRPlayerView.layout(0, 0, i15, i16);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        List<Image> list = this.f54009a;
        if (list != null) {
            if (list == null || list.size() != 0) {
                List<Image> list2 = this.f54009a;
                int size = list2 != null ? list2.size() : 0;
                for (int i15 = 0; i15 < size; i15++) {
                    View childAt = getChildAt(i15);
                    Intrinsics.e(childAt, "null cannot be cast to non-null type com.transsion.ninegridview.video.NineGridItemView");
                    NineGridItemView nineGridItemView = (NineGridItemView) childAt;
                    int iJ = j(i15);
                    int iG = g(i15);
                    if (iJ == 1) {
                        int paddingLeft = ((this.f54017j + this.f54010b) * iG) + getPaddingLeft();
                        int paddingTop = getPaddingTop();
                        int i16 = this.f54017j;
                        int i17 = this.f54018k;
                        m(nineGridItemView, paddingLeft, paddingTop, paddingLeft + i16, paddingTop + i17, i16, i17);
                    } else if (iJ == 2) {
                        int paddingLeft2 = ((this.f54019l + this.f54010b) * iG) + getPaddingLeft();
                        int paddingTop2 = (this.f54010b * (iJ - 1)) + this.f54018k + getPaddingTop();
                        int i18 = this.f54019l;
                        int i19 = this.f54020m;
                        m(nineGridItemView, paddingLeft2, paddingTop2, paddingLeft2 + i18, paddingTop2 + i19, i18, i19);
                    } else if (iJ == 3) {
                        int paddingLeft3 = ((this.f54021n + this.f54010b) * iG) + getPaddingLeft();
                        int paddingTop3 = (this.f54010b * (iJ - 1)) + this.f54018k + this.f54020m + getPaddingTop();
                        int i21 = this.f54021n;
                        int i22 = this.f54022o;
                        m(nineGridItemView, paddingLeft3, paddingTop3, paddingLeft3 + i21, paddingTop3 + i22, i21, i22);
                    }
                }
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        int size = View.MeasureSpec.getSize(i11);
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        measureChildren(i11, i12);
        List<Image> list = this.f54009a;
        int paddingBottom = 0;
        if (list != null) {
            switch (list.size()) {
                case 1:
                    b(list.get(0), paddingLeft, 1);
                    break;
                case 2:
                    b(k(list.get(0), list.get(1)), paddingLeft, 2);
                    break;
                case 3:
                    b(k(list.get(0), list.get(1)), paddingLeft, 2);
                    c(list.get(2), paddingLeft, 1);
                    break;
                case 4:
                    b(k(list.get(0), list.get(1)), paddingLeft, 2);
                    c(k(list.get(2), list.get(3)), paddingLeft, 2);
                    break;
                case 5:
                    b(k(list.get(0), list.get(1)), paddingLeft, 2);
                    c(list.get(2), paddingLeft, 1);
                    d(k(list.get(3), list.get(4)), paddingLeft, 2);
                    break;
                case 6:
                    b(l(list.get(0), list.get(1), list.get(2)), paddingLeft, 3);
                    c(l(list.get(3), list.get(4), list.get(5)), paddingLeft, 3);
                    break;
                case 7:
                    b(l(list.get(0), list.get(1), list.get(2)), paddingLeft, 3);
                    c(list.get(3), paddingLeft, 1);
                    d(l(list.get(4), list.get(5), list.get(6)), paddingLeft, 3);
                    break;
                case 8:
                    b(l(list.get(0), list.get(1), list.get(2)), paddingLeft, 3);
                    c(k(list.get(3), list.get(4)), paddingLeft, 2);
                    d(l(list.get(5), list.get(6), list.get(7)), paddingLeft, 3);
                    break;
                case 9:
                    b(l(list.get(0), list.get(1), list.get(2)), paddingLeft, 3);
                    c(l(list.get(3), list.get(4), list.get(5)), paddingLeft, 3);
                    d(l(list.get(6), list.get(7), list.get(8)), paddingLeft, 3);
                    break;
            }
            size = paddingLeft + getPaddingLeft() + getPaddingRight();
            paddingBottom = getPaddingBottom() + this.f54018k + this.f54020m + this.f54022o + (this.f54010b * (this.f54016i - 1)) + getPaddingTop();
        }
        setMeasuredDimension(size, paddingBottom);
    }

    public final void setAdapter(NineGridVideoViewAdapter adapter) {
        Intrinsics.g(adapter, "adapter");
        this.f54025r = adapter;
        List<Image> imageList = adapter.getImageList();
        if (imageList.isEmpty()) {
            so.c.g(this);
            return;
        }
        so.c.k(this);
        int size = imageList.size();
        if (this.f54013f < size) {
            imageList = imageList.subList(0, imageList.size());
            size = imageList.size();
        }
        if (size == 1) {
            this.f54015h = 1;
            this.f54016i = 1;
        } else if (2 <= size && size < 6) {
            this.f54015h = 2;
            this.f54016i = (size / 2) + (size % 2 == 0 ? 0 : 1);
        } else if (6 <= size && size < 10) {
            this.f54015h = 3;
            this.f54016i = (size / 3) + (size % 3 == 0 ? 0 : 1);
        }
        List<Image> list = this.f54009a;
        if (list == null) {
            for (int size2 = 0; size2 < size; size2++) {
                addView(h(size2), generateDefaultLayoutParams());
            }
        } else {
            size2 = list != null ? list.size() : 0;
            if (size2 > size) {
                removeViews(size, size2 - size);
                e();
            } else if (size2 < size) {
                e();
                while (size2 < size) {
                    addView(h(size2), generateDefaultLayoutParams());
                    size2++;
                }
            } else {
                e();
            }
        }
        this.f54009a = imageList;
        requestLayout();
    }

    public final void setGridSpacing(int i11) {
        this.f54010b = i11;
    }

    public final void setMaxImageSize(int i11) {
        this.f54013f = i11;
    }

    public final void setSingleImageRatio(float f11) {
        this.f54012d = f11;
    }

    public final void setSingleImageSize(int i11) {
        this.f54011c = i11;
    }
}
