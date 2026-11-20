package com.transsion.commercialization.pslink;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import com.tn.lib.widget.R$color;
import com.transsion.ad.ps.model.RecommendInfo;
import com.transsion.baselib.utils.o;
import com.transsion.commercialization.R$string;
import com.transsion.commercialization.R$styleable;
import com.transsnet.launcherlib.PalmStoreDownLoadTaskInfo;
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
public final class PsLinkDownLoadButton extends ProgressBar {
    public static final int BG_STYLE_DEF_BG_08 = 1;
    public static final int BG_STYLE_GRADIENT = 2;
    public static final a Companion = new a(null);
    public static final int STATE_INSTALLED = 6;
    public static final int STATE_NETWORK_ERROR = 12;
    public static final int STATE_PROGRESS_DOWNLOADING = 2;
    public static final int STATE_PROGRESS_INSTALLED = 5;
    public static final int STATE_PROGRESS_INSTALLING = 4;
    public static final int STATE_PROGRESS_NONE = 0;
    public static final int STATE_PROGRESS_PAUSE = 3;
    public static final int STATE_PROGRESS_WAITING = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f51688a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f51689b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f51690c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f51691d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f51692f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f51693g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f51694h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f51695i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f51696j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Paint f51697k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Paint f51698l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Paint f51699m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Path f51700n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public PorterDuffXfermode f51701o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public RecommendInfo f51702p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final b f51703q;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements com.transsion.commercialization.pslink.b {
        public b() {
        }

        @Override // com.transsion.commercialization.pslink.b
        public void a(String callBackName, String param, PalmStoreDownLoadTaskInfo palmStoreDownLoadTaskInfo, String str) {
            Intrinsics.g(callBackName, "callBackName");
            Intrinsics.g(param, "param");
            com.transsion.commercialization.pslink.a.f51724a.a("callBackCommon: " + callBackName + ", " + param + ", " + str);
            RecommendInfo recommendInfo = PsLinkDownLoadButton.this.f51702p;
            if (TextUtils.equals(recommendInfo != null ? recommendInfo.getPackageName() : null, str)) {
                PsLinkDownLoadButton.this.c(callBackName, param, palmStoreDownLoadTaskInfo, str);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PsLinkDownLoadButton(Context context) {
        this(context, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PsLinkDownLoadButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PsLinkDownLoadButton(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
        this.f51688a = 1;
        this.f51695i = o(R$color.bg_08);
        this.f51696j = InputDeviceCompat.SOURCE_ANY;
        this.f51697k = new Paint();
        this.f51698l = new Paint();
        this.f51699m = new Paint();
        this.f51700n = new Path();
        this.f51701o = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
        this.f51703q = new b();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.PsLinkDownLoadButton);
        Intrinsics.f(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…ble.PsLinkDownLoadButton)");
        this.f51689b = typedArrayObtainStyledAttributes.getDimension(R$styleable.PsLinkDownLoadButton_border_radius, 0.0f);
        this.f51690c = typedArrayObtainStyledAttributes.getDimension(R$styleable.PsLinkDownLoadButton_border_width, 6.0f);
        this.f51691d = typedArrayObtainStyledAttributes.getDimension(R$styleable.PsLinkDownLoadButton_progress_textSize, 46.0f);
        this.f51688a = typedArrayObtainStyledAttributes.getInt(R$styleable.PsLinkDownLoadButton_bg_style, 1);
        typedArrayObtainStyledAttributes.recycle();
        this.f51697k.setAntiAlias(true);
        this.f51698l.setAntiAlias(true);
        this.f51699m.setTextSize(this.f51691d);
        this.f51699m.setAntiAlias(true);
    }

    private final String getClassTag() {
        String simpleName = PsLinkDownLoadButton.class.getSimpleName();
        Intrinsics.f(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    private final String getPercent() {
        return TextUtils.concat(String.valueOf(b()), "%").toString();
    }

    private final void setInnerProgress(PalmStoreDownLoadTaskInfo palmStoreDownLoadTaskInfo) {
        int progress = palmStoreDownLoadTaskInfo != null ? (int) palmStoreDownLoadTaskInfo.getProgress() : 0;
        if (progress > 100) {
            progress = 100;
        }
        setProgress(progress);
    }

    private final void setState(int i11) {
        this.f51694h = i11;
        postInvalidate();
    }

    public final void a() {
        PsLinkServiceHelper.f51717a.g(this.f51703q);
    }

    public final int b() {
        return (int) (100 * ((getProgress() * 1.0f) / getMax()));
    }

    public final void c(String str, String str2, PalmStoreDownLoadTaskInfo palmStoreDownLoadTaskInfo, String str3) {
        com.transsion.commercialization.pslink.a aVar = com.transsion.commercialization.pslink.a.f51724a;
        String classTag = getClassTag();
        Integer numValueOf = palmStoreDownLoadTaskInfo != null ? Integer.valueOf(palmStoreDownLoadTaskInfo.getStatus()) : null;
        Float fValueOf = palmStoreDownLoadTaskInfo != null ? Float.valueOf(palmStoreDownLoadTaskInfo.getProgress()) : null;
        aVar.b(classTag + " --> dealWithCallBack() --> 开始刷新数据 -- callBackName = " + str + " -- pkgName = " + str3 + " -- status = " + numValueOf + " -- progress = " + fValueOf + "-- param.length = " + str2.length());
        if (palmStoreDownLoadTaskInfo == null) {
            if (TextUtils.equals("installApp", str)) {
                RecommendInfo recommendInfo = this.f51702p;
                if (recommendInfo != null) {
                    recommendInfo.setPalmStoreDownLoadTaskInfo(null);
                }
                setState(5);
                return;
            }
            if (TextUtils.equals("removedApp", str)) {
                setState(0);
                return;
            } else {
                setState(0);
                return;
            }
        }
        RecommendInfo recommendInfo2 = this.f51702p;
        if (recommendInfo2 != null) {
            recommendInfo2.setPalmStoreDownLoadTaskInfo(palmStoreDownLoadTaskInfo);
        }
        int status = palmStoreDownLoadTaskInfo.getStatus();
        if (status == 1) {
            setState(1);
            return;
        }
        if (status == 2) {
            setInnerProgress(palmStoreDownLoadTaskInfo);
            setState(2);
            return;
        }
        if (status == 3) {
            setInnerProgress(palmStoreDownLoadTaskInfo);
            setState(3);
            f.f51726a.h(str3, palmStoreDownLoadTaskInfo.getStatus());
        } else if (status == 6) {
            setState(5);
            f.f51726a.h(str3, palmStoreDownLoadTaskInfo.getStatus());
        } else if (status == 11) {
            setState(4);
        } else {
            if (status != 12) {
                return;
            }
            setState(12);
            f.f51726a.h(str3, palmStoreDownLoadTaskInfo.getStatus());
        }
    }

    public final void d(Canvas canvas) {
        l(canvas, o(R$color.brand_gradient_start), o(R$color.brand_gradient_center), o(R$color.brand_gradient_end));
        String string = getContext().getResources().getString(R$string.ps_link_install);
        Intrinsics.f(string, "context.resources.getStr…R.string.ps_link_install)");
        k(canvas, string);
    }

    public final void e(Canvas canvas) {
        int i11 = this.f51688a;
        if (i11 == 1) {
            int i12 = this.f51695i;
            l(canvas, i12, i12, i12);
        } else if (i11 == 2) {
            l(canvas, o(R$color.brand_gradient_start_60), o(R$color.brand_gradient_center_60), o(R$color.brand_gradient_end_60));
        }
        j(canvas);
        k(canvas, "");
        g(canvas, "");
    }

    public final void f(Canvas canvas) {
        int i11 = this.f51688a;
        if (i11 == 1) {
            int i12 = this.f51695i;
            l(canvas, i12, i12, i12);
        } else if (i11 == 2) {
            l(canvas, o(R$color.brand_gradient_start), o(R$color.brand_gradient_center), o(R$color.brand_gradient_end));
        }
        String string = getContext().getResources().getString(R$string.ps_link_open);
        Intrinsics.f(string, "context.resources.getString(R.string.ps_link_open)");
        k(canvas, string);
    }

    public final void g(Canvas canvas, String str) {
        this.f51699m.setColor(-1);
        if (TextUtils.isEmpty(str)) {
            str = getPercent();
        }
        float fMeasureText = this.f51699m.measureText(str);
        float fDescent = this.f51699m.descent() + this.f51699m.ascent();
        float f11 = 2;
        float measuredWidth = (getMeasuredWidth() - fMeasureText) / f11;
        float f12 = (this.f51693g / 2) - (fDescent / f11);
        float progress = ((getProgress() - (100 / getMax())) * getMeasuredWidth()) / 100;
        if (progress > measuredWidth) {
            canvas.translate(getPaddingLeft(), getPaddingTop());
        }
        canvas.clipRect(measuredWidth, 0.0f, progress, getMeasuredHeight());
        canvas.drawText(str, measuredWidth, f12, this.f51699m);
    }

    public final void h(Canvas canvas) {
        l(canvas, o(R$color.brand_gradient_start), o(R$color.brand_gradient_center), o(R$color.brand_gradient_end));
        String string = getContext().getResources().getString(R$string.ps_link_installing);
        Intrinsics.f(string, "context.resources.getStr…tring.ps_link_installing)");
        k(canvas, string);
    }

    public final void i(Canvas canvas) {
        int i11 = this.f51688a;
        if (i11 == 1) {
            int i12 = this.f51695i;
            l(canvas, i12, i12, i12);
        } else if (i11 == 2) {
            l(canvas, o(R$color.brand_gradient_start_60), o(R$color.brand_gradient_center_60), o(R$color.brand_gradient_end_60));
        }
        j(canvas);
        String string = getContext().getResources().getString(R$string.ps_link_continue);
        Intrinsics.f(string, "context.resources.getStr….string.ps_link_continue)");
        k(canvas, string);
        String string2 = getContext().getResources().getString(R$string.ps_link_continue);
        Intrinsics.f(string2, "context.resources.getStr….string.ps_link_continue)");
        g(canvas, string2);
    }

    public final void j(Canvas canvas) {
        Paint paint = this.f51697k;
        Paint.Style style = Paint.Style.FILL;
        paint.setStyle(style);
        float progress = this.f51692f * ((getProgress() * 1.0f) / getMax());
        int iSaveLayer = canvas.saveLayer(0.0f, 0.0f, progress, getHeight(), this.f51697k);
        float f11 = this.f51690c;
        RectF rectF = new RectF(f11, f11, this.f51692f - f11, this.f51693g - f11);
        this.f51697k.setShader(null);
        this.f51697k.setColor(InputDeviceCompat.SOURCE_ANY);
        float f12 = this.f51689b;
        canvas.drawRoundRect(rectF, f12, f12, this.f51697k);
        this.f51698l.setStyle(style);
        this.f51698l.setShader(p(rectF));
        this.f51700n.reset();
        this.f51700n.addRect(new RectF(0.0f, 0.0f, progress, this.f51693g), Path.Direction.CCW);
        this.f51698l.setXfermode(this.f51701o);
        canvas.drawPath(this.f51700n, this.f51698l);
        canvas.restoreToCount(iSaveLayer);
        this.f51698l.setXfermode(null);
    }

    public final void k(Canvas canvas, String str) {
        if (com.transsion.ad.ps.b.f50555a.l()) {
            canvas.rotate(180.0f, this.f51692f / 2.0f, this.f51693g / 2.0f);
        }
        Paint paint = this.f51699m;
        int i11 = this.f51694h;
        int i12 = -1;
        if (i11 != 0 && i11 != 1 && ((i11 == 2 || i11 == 3 || i11 == 5) && this.f51688a != 2 && !o.f51321a.a())) {
            i12 = ViewCompat.MEASURED_STATE_MASK;
        }
        paint.setColor(i12);
        Paint paint2 = this.f51699m;
        Context context = getContext();
        Intrinsics.f(context, "context");
        paint2.setTypeface(so.a.a(context));
        if (TextUtils.isEmpty(str)) {
            str = getPercent();
        }
        float f11 = 2;
        canvas.drawText(str, (this.f51692f / 2) - (this.f51699m.measureText(str) / f11), (this.f51693g / 2) - ((this.f51699m.descent() + this.f51699m.ascent()) / f11), this.f51699m);
    }

    public final void l(Canvas canvas, int... iArr) {
        this.f51697k.setStyle(Paint.Style.FILL);
        float f11 = this.f51690c;
        RectF rectF = new RectF(f11, f11, this.f51692f - f11, this.f51693g - f11);
        this.f51697k.setShader(new LinearGradient(0.0f, 0.0f, rectF.right, rectF.bottom, iArr, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
        float f12 = this.f51689b;
        canvas.drawRoundRect(rectF, f12, f12, this.f51697k);
    }

    public final void m(Canvas canvas) {
        int i11 = this.f51688a;
        if (i11 == 1) {
            int i12 = this.f51695i;
            l(canvas, i12, i12, i12);
        } else if (i11 == 2) {
            l(canvas, o(R$color.brand_gradient_start_60), o(R$color.brand_gradient_center_60), o(R$color.brand_gradient_end_60));
        }
        j(canvas);
        String string = getContext().getString(com.transsion.baseui.R$string.retry_text);
        Intrinsics.f(string, "context.getString(com.tr…seui.R.string.retry_text)");
        k(canvas, string);
    }

    public final void n(Canvas canvas) {
        l(canvas, o(R$color.brand_gradient_start), o(R$color.brand_gradient_center), o(R$color.brand_gradient_end));
        String string = getContext().getResources().getString(R$string.ps_link_waiting);
        Intrinsics.f(string, "context.resources.getStr…R.string.ps_link_waiting)");
        k(canvas, string);
    }

    public final int o(int i11) {
        return Build.VERSION.SDK_INT >= 23 ? getContext().getColor(i11) : getContext().getResources().getColor(i11);
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        a();
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        q();
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onDraw(Canvas canvas) {
        Intrinsics.g(canvas, "canvas");
        if (com.transsion.ad.ps.b.f50555a.l()) {
            canvas.rotate(180.0f, this.f51692f / 2.0f, this.f51693g / 2.0f);
        }
        int i11 = this.f51694h;
        if (i11 == 0) {
            d(canvas);
            return;
        }
        if (i11 == 1) {
            n(canvas);
            return;
        }
        if (i11 == 2) {
            e(canvas);
            return;
        }
        if (i11 == 3) {
            i(canvas);
            return;
        }
        if (i11 == 4) {
            h(canvas);
        } else if (i11 == 5) {
            f(canvas);
        } else {
            if (i11 != 12) {
                return;
            }
            m(canvas);
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        int size = View.MeasureSpec.getSize(i11);
        int size2 = View.MeasureSpec.getSize(i12);
        float f11 = 2;
        int iMeasureText = (int) (this.f51699m.measureText("下载") + (this.f51690c * f11));
        int iDescent = (int) (this.f51699m.descent() + Math.abs(this.f51699m.ascent()) + (this.f51690c * f11));
        if (getLayoutParams().width == -2 && getLayoutParams().height == -2) {
            setMeasuredDimension(iMeasureText, iDescent);
        } else if (getLayoutParams().width == -2) {
            setMeasuredDimension(iMeasureText, size2);
        } else if (getLayoutParams().height == -2) {
            setMeasuredDimension(size, iDescent);
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        this.f51692f = (getWidth() - getPaddingLeft()) - getPaddingRight();
        this.f51693g = (getHeight() - getPaddingTop()) - getPaddingBottom();
    }

    public final LinearGradient p(RectF rectF) {
        return new LinearGradient(0.0f, 0.0f, rectF.right, rectF.bottom, new int[]{o(R$color.brand_gradient_start), o(R$color.brand_gradient_center), o(R$color.brand_gradient_end)}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP);
    }

    public final void q() {
        PsLinkServiceHelper.f51717a.m(this.f51703q);
    }

    public final void setItemInfo(RecommendInfo itemInfo) {
        PalmStoreDownLoadTaskInfo palmStoreDownLoadTaskInfo;
        String packageName;
        Intrinsics.g(itemInfo, "itemInfo");
        this.f51702p = itemInfo;
        if ((itemInfo != null ? itemInfo.getPalmStoreDownLoadTaskInfo() : null) == null) {
            com.transsion.ad.ps.b bVar = com.transsion.ad.ps.b.f50555a;
            RecommendInfo recommendInfo = this.f51702p;
            if (recommendInfo == null || (packageName = recommendInfo.getPackageName()) == null) {
                packageName = "";
            }
            if (bVar.b(packageName)) {
                setState(5);
                return;
            } else {
                setState(0);
                return;
            }
        }
        RecommendInfo recommendInfo2 = this.f51702p;
        Integer numValueOf = (recommendInfo2 == null || (palmStoreDownLoadTaskInfo = recommendInfo2.getPalmStoreDownLoadTaskInfo()) == null) ? null : Integer.valueOf(palmStoreDownLoadTaskInfo.getStatus());
        if (numValueOf != null && numValueOf.intValue() == 1) {
            setState(1);
            return;
        }
        if (numValueOf != null && numValueOf.intValue() == 11) {
            setState(4);
            return;
        }
        if (numValueOf != null && numValueOf.intValue() == 3) {
            RecommendInfo recommendInfo3 = this.f51702p;
            setInnerProgress(recommendInfo3 != null ? recommendInfo3.getPalmStoreDownLoadTaskInfo() : null);
            setState(3);
        } else if (numValueOf != null && numValueOf.intValue() == 2) {
            RecommendInfo recommendInfo4 = this.f51702p;
            setInnerProgress(recommendInfo4 != null ? recommendInfo4.getPalmStoreDownLoadTaskInfo() : null);
            setState(2);
        } else if (numValueOf != null && numValueOf.intValue() == 12) {
            setState(12);
        }
    }
}
