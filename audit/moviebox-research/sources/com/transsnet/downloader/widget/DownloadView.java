package com.transsnet.downloader.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import com.tn.lib.widget.R$color;
import com.tn.lib.widget.R$styleable;
import com.tn.lib.widget.TnTextView;
import com.transsion.baseui.R$mipmap;
import com.transsion.baseui.R$string;
import com.transsnet.downloader.DownloadManagerApi;
import com.transsnet.downloader.R$layout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
@SourceDebugExtension
public final class DownloadView extends FrameLayout {
    public static final int ADD_COURSE = 2;
    public static final int COURSE_ADDED = 3;
    public static final a Companion = new a(null);
    public static final int DOWNLOAD = 0;
    public static final int PLAY = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public h00.r f61341a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f61342b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f61343c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f61344d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f61345f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f61346g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f61347h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Integer f61348i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f61349j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f61350k;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DownloadView(Context context) {
        this(context, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DownloadView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
        this.f61342b = com.transsion.core.utils.e.a(12.0f);
        this.f61343c = R$mipmap.ic_download_red;
        this.f61344d = com.tn.lib.widget.R$mipmap.icon_play_white;
        this.f61346g = 1;
        this.f61347h = -1;
        this.f61349j = "";
        a(attributeSet);
        b();
    }

    public static /* synthetic */ void setAttrs$default(DownloadView downloadView, Integer num, Float f11, Integer num2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            num = null;
        }
        if ((i11 & 2) != 0) {
            f11 = null;
        }
        if ((i11 & 4) != 0) {
            num2 = null;
        }
        downloadView.setAttrs(num, f11, num2);
    }

    public static /* synthetic */ void setShowType$default(DownloadView downloadView, String str, String str2, Boolean bool, boolean z11, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            str = "";
        }
        if ((i12 & 2) != 0) {
            str2 = "";
        }
        if ((i12 & 4) != 0) {
            bool = Boolean.FALSE;
        }
        if ((i12 & 8) != 0) {
            z11 = false;
        }
        if ((i12 & 16) != 0) {
            i11 = R$string.download_movie;
        }
        downloadView.setShowType(str, str2, bool, z11, i11);
    }

    public final void a(AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.download_view);
        Intrinsics.f(typedArrayObtainStyledAttributes, "context.obtainStyledAttr….styleable.download_view)");
        try {
            try {
                this.f61342b = typedArrayObtainStyledAttributes.getDimension(R$styleable.download_view_tips_textSize, this.f61342b);
                this.f61343c = typedArrayObtainStyledAttributes.getResourceId(R$styleable.download_view_iconSrc, this.f61343c);
                this.f61344d = typedArrayObtainStyledAttributes.getResourceId(R$styleable.download_view_playIconSrc, this.f61344d);
                this.f61346g = typedArrayObtainStyledAttributes.getInteger(R$styleable.download_view_tips_textStyle, 1);
                this.f61347h = typedArrayObtainStyledAttributes.getColor(R$styleable.download_view_tips_textColor, z2.a.getColor(getContext(), R$color.white));
                if (typedArrayObtainStyledAttributes.hasValue(R$styleable.download_view_tips_textColor)) {
                    this.f61348i = Integer.valueOf(typedArrayObtainStyledAttributes.getColor(R$styleable.download_view_tips_textColor, z2.a.getColor(getContext(), R$color.white)));
                }
                this.f61345f = typedArrayObtainStyledAttributes.getColor(R$styleable.download_view_tips_textVisibility, 0);
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public final void b() {
        Typeface typefaceD;
        TnTextView tnTextView;
        TnTextView tnTextView2;
        AppCompatImageView appCompatImageView;
        View.inflate(getContext(), R$layout.download_view_type_list, this);
        h00.r rVarA = h00.r.a(this);
        this.f61341a = rVarA;
        if (rVarA != null && (appCompatImageView = rVarA.f66003b) != null) {
            appCompatImageView.setImageResource(this.f61343c);
        }
        Integer num = this.f61348i;
        if (num != null) {
            h00.r rVar = this.f61341a;
            AppCompatImageView appCompatImageView2 = rVar != null ? rVar.f66003b : null;
            if (appCompatImageView2 != null) {
                Intrinsics.d(num);
                appCompatImageView2.setImageTintList(ColorStateList.valueOf(num.intValue()));
            }
        }
        h00.r rVar2 = this.f61341a;
        if (rVar2 != null && (tnTextView2 = rVar2.f66005d) != null) {
            tnTextView2.setTextSize(0, this.f61342b);
        }
        h00.r rVar3 = this.f61341a;
        if (rVar3 != null && (tnTextView = rVar3.f66005d) != null) {
            tnTextView.setTextColor(this.f61347h);
        }
        h00.r rVar4 = this.f61341a;
        TnTextView tnTextView3 = rVar4 != null ? rVar4.f66005d : null;
        if (tnTextView3 != null) {
            tnTextView3.setVisibility(this.f61345f);
        }
        h00.r rVar5 = this.f61341a;
        TnTextView tnTextView4 = rVar5 != null ? rVar5.f66005d : null;
        if (tnTextView4 == null) {
            return;
        }
        int i11 = this.f61346g;
        if (i11 == 0) {
            Context context = getContext();
            Intrinsics.f(context, "context");
            typefaceD = so.a.d(context);
        } else if (i11 == 1) {
            Context context2 = getContext();
            Intrinsics.f(context2, "context");
            typefaceD = so.a.c(context2);
        } else if (i11 == 2) {
            Context context3 = getContext();
            Intrinsics.f(context3, "context");
            typefaceD = so.a.a(context3);
        } else if (i11 != 3) {
            Context context4 = getContext();
            Intrinsics.f(context4, "context");
            typefaceD = so.a.c(context4);
        } else {
            Context context5 = getContext();
            Intrinsics.f(context5, "context");
            typefaceD = so.a.b(context5);
        }
        tnTextView4.setTypeface(typefaceD);
    }

    public final h00.r getMViewBinding() {
        return this.f61341a;
    }

    public final int getShowType() {
        return this.f61350k;
    }

    public final int getType() {
        return this.f61350k;
    }

    public final void setAddCourse() {
        TnTextView tnTextView;
        AppCompatImageView appCompatImageView;
        this.f61350k = 2;
        h00.r rVar = this.f61341a;
        if (rVar != null && (appCompatImageView = rVar.f66003b) != null) {
            appCompatImageView.setImageResource(R$mipmap.ic_add);
        }
        h00.r rVar2 = this.f61341a;
        if (rVar2 == null || (tnTextView = rVar2.f66005d) == null) {
            return;
        }
        tnTextView.setTextById(R$string.education_add_course);
    }

    public final void setAttrs(Integer num, Float f11, Integer num2) {
        h00.r rVar;
        TnTextView tnTextView;
        TnTextView tnTextView2;
        AppCompatImageView appCompatImageView;
        if (num2 != null) {
            int iIntValue = num2.intValue();
            h00.r rVar2 = this.f61341a;
            if (rVar2 != null && (appCompatImageView = rVar2.f66003b) != null) {
                appCompatImageView.setImageResource(iIntValue);
            }
        }
        if (f11 != null) {
            float fFloatValue = f11.floatValue();
            h00.r rVar3 = this.f61341a;
            if (rVar3 != null && (tnTextView2 = rVar3.f66005d) != null) {
                tnTextView2.setTextSize(0, fFloatValue);
            }
        }
        if (num == null || (rVar = this.f61341a) == null || (tnTextView = rVar.f66005d) == null) {
            return;
        }
        tnTextView.setTextColor(num.intValue());
    }

    public final void setCourseAdded() {
        TnTextView tnTextView;
        AppCompatImageView appCompatImageView;
        this.f61350k = 3;
        h00.r rVar = this.f61341a;
        if (rVar != null && (appCompatImageView = rVar.f66003b) != null) {
            appCompatImageView.setImageResource(R$mipmap.ic_added);
        }
        h00.r rVar2 = this.f61341a;
        if (rVar2 == null || (tnTextView = rVar2.f66005d) == null) {
            return;
        }
        tnTextView.setTextById(R$string.education_added);
    }

    public final void setMViewBinding(h00.r rVar) {
        this.f61341a = rVar;
    }

    public final void setPageFrom(String pageName) {
        Intrinsics.g(pageName, "pageName");
        this.f61349j = pageName;
    }

    public final void setShowPlayType() {
        h00.r rVar;
        AppCompatImageView appCompatImageView;
        AppCompatImageView appCompatImageView2;
        TnTextView tnTextView;
        AppCompatImageView appCompatImageView3;
        this.f61350k = 1;
        h00.r rVar2 = this.f61341a;
        if (rVar2 != null && (appCompatImageView3 = rVar2.f66003b) != null) {
            appCompatImageView3.setImageResource(this.f61344d);
        }
        h00.r rVar3 = this.f61341a;
        if (rVar3 != null && (tnTextView = rVar3.f66005d) != null) {
            tnTextView.setTextById(R$string.play);
        }
        h00.r rVar4 = this.f61341a;
        Drawable drawable = (rVar4 == null || (appCompatImageView2 = rVar4.f66003b) == null) ? null : appCompatImageView2.getDrawable();
        if (drawable == null || (rVar = this.f61341a) == null || (appCompatImageView = rVar.f66003b) == null) {
            return;
        }
        appCompatImageView.setImageDrawable(drawable);
    }

    public final void setShowType(String str, String str2, Boolean bool, boolean z11, int i11) {
        h00.r rVar;
        AppCompatImageView appCompatImageView;
        AppCompatImageView appCompatImageView2;
        TnTextView tnTextView;
        AppCompatImageView appCompatImageView3;
        TnTextView tnTextView2;
        AppCompatImageView appCompatImageView4;
        boolean zM2 = DownloadManagerApi.f60274j.a().m2(str, str2, bool != null ? bool.booleanValue() : false, z11);
        this.f61350k = zM2 ? 1 : 0;
        if (!zM2) {
            h00.r rVar2 = this.f61341a;
            if (rVar2 != null && (appCompatImageView4 = rVar2.f66003b) != null) {
                appCompatImageView4.setImageResource(this.f61343c);
            }
            h00.r rVar3 = this.f61341a;
            if (rVar3 == null || (tnTextView2 = rVar3.f66005d) == null) {
                return;
            }
            tnTextView2.setTextById(i11);
            return;
        }
        h00.r rVar4 = this.f61341a;
        if (rVar4 != null && (appCompatImageView3 = rVar4.f66003b) != null) {
            appCompatImageView3.setImageResource(this.f61344d);
        }
        h00.r rVar5 = this.f61341a;
        if (rVar5 != null && (tnTextView = rVar5.f66005d) != null) {
            tnTextView.setTextById(R$string.play);
        }
        h00.r rVar6 = this.f61341a;
        Drawable drawable = (rVar6 == null || (appCompatImageView2 = rVar6.f66003b) == null) ? null : appCompatImageView2.getDrawable();
        if (drawable == null || (rVar = this.f61341a) == null || (appCompatImageView = rVar.f66003b) == null) {
            return;
        }
        appCompatImageView.setImageDrawable(drawable);
    }

    public final void setType(int i11) {
        this.f61350k = i11;
    }
}
