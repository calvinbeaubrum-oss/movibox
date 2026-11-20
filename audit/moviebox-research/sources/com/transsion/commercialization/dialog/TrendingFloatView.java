package com.transsion.commercialization.dialog;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.blankj.utilcode.util.Utils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.transsion.baselib.report.m;
import com.transsion.baselib.task.ArouterUtil;
import com.transsion.bean.HomePopupEntity;
import com.transsion.bean.HomePopupInfo;
import com.transsion.commercialization.R$id;
import com.transsion.commercialization.R$layout;
import com.transsion.commercializationapi.ICommonDialogApi;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
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
public final class TrendingFloatView extends FrameLayout {
    public static final a Companion = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HomePopupEntity f51637a;

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
    public static final class b implements RequestListener<Drawable> {
        public b() {
        }

        @Override // com.bumptech.glide.request.RequestListener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean onResourceReady(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z11) {
            uo.b.a.f(uo.b.f78622a, "zxb_popup", TrendingFloatView.this.getClassTag() + " --> init() --> onResourceReady() --> 图片加载成功", false, 4, null);
            TrendingFloatView.this.f();
            TrendingFloatView.this.setVisibility(0);
            return false;
        }

        @Override // com.bumptech.glide.request.RequestListener
        public boolean onLoadFailed(GlideException glideException, Object obj, Target<Drawable> target, boolean z11) {
            return true;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TrendingFloatView(Context context) {
        super(context);
        Intrinsics.g(context, "context");
        addView(LayoutInflater.from(getContext()).inflate(R$layout.widget_float_view_layout, (ViewGroup) this, false), -2, -2);
        setVisibility(8);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TrendingFloatView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.g(context, "context");
        addView(LayoutInflater.from(getContext()).inflate(R$layout.widget_float_view_layout, (ViewGroup) this, false), -2, -2);
        setVisibility(8);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TrendingFloatView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
        addView(LayoutInflater.from(getContext()).inflate(R$layout.widget_float_view_layout, (ViewGroup) this, false), -2, -2);
        setVisibility(8);
    }

    public static /* synthetic */ void e(TrendingFloatView trendingFloatView, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = false;
        }
        trendingFloatView.d(z11);
    }

    public static final void g(final TrendingFloatView this$0, final HomePopupEntity homePopupEntity) {
        Intrinsics.g(this$0, "this$0");
        AppCompatImageView appCompatImageView = (AppCompatImageView) this$0.findViewById(R$id.ivClose);
        appCompatImageView.setVisibility(0);
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.commercialization.dialog.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TrendingFloatView.h(this.f51653a, homePopupEntity, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getClassTag() {
        String simpleName = TrendingFloatView.class.getSimpleName();
        Intrinsics.f(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    public static final void h(TrendingFloatView this$0, HomePopupEntity homePopupEntity, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.setVisibility(8);
        ((ICommonDialogApi) com.alibaba.android.arouter.launcher.a.d().h(ICommonDialogApi.class)).b0(homePopupEntity);
        this$0.d(true);
    }

    public static final void i(HomePopupEntity homePopupEntity, TrendingFloatView this$0, View view) {
        String externalUrl;
        HomePopupInfo widget;
        String innerUrl;
        HomePopupInfo widget2;
        String innerUrl2;
        HomePopupInfo widget3;
        Intrinsics.g(this$0, "this$0");
        com.transsion.ad.strategy.a aVar = com.transsion.ad.strategy.a.f50582a;
        if (homePopupEntity == null || (widget3 = homePopupEntity.getWidget()) == null || (externalUrl = widget3.getExternalUrl()) == null) {
            externalUrl = "";
        }
        if (aVar.c(externalUrl)) {
            return;
        }
        if (homePopupEntity == null || (widget2 = homePopupEntity.getWidget()) == null || (innerUrl2 = widget2.getInnerUrl()) == null || l.L(innerUrl2, "oneroom://com.community.oneroom?type=", false, 2, null)) {
            ArouterUtil arouterUtil = ArouterUtil.f51292a;
            Context context = this$0.getContext();
            Intrinsics.f(context, "context");
            ArouterUtil.c(arouterUtil, context, (homePopupEntity == null || (widget = homePopupEntity.getWidget()) == null || (innerUrl = widget.getInnerUrl()) == null) ? "" : innerUrl, null, 4, null);
        } else {
            com.transsion.ad.strategy.a.b(aVar, homePopupEntity.getWidget().getInnerUrl(), homePopupEntity.getWidget().getInnerUrl(), null, 4, null);
        }
        e(this$0, false, 1, null);
    }

    public final void d(boolean z11) {
        HomePopupInfo widget;
        HomePopupInfo widget2;
        HomePopupInfo widget3;
        HashMap map = new HashMap();
        HomePopupEntity homePopupEntity = this.f51637a;
        String name = null;
        map.put("widget_id", String.valueOf((homePopupEntity == null || (widget3 = homePopupEntity.getWidget()) == null) ? null : Long.valueOf(widget3.getId())));
        HomePopupEntity homePopupEntity2 = this.f51637a;
        map.put("widget_type", String.valueOf((homePopupEntity2 == null || (widget2 = homePopupEntity2.getWidget()) == null) ? null : Integer.valueOf(widget2.getType())));
        HomePopupEntity homePopupEntity3 = this.f51637a;
        if (homePopupEntity3 != null && (widget = homePopupEntity3.getWidget()) != null) {
            name = widget.getName();
        }
        map.put("widget_name", String.valueOf(name));
        if (z11) {
            map.put("widget_close", CampaignEx.JSON_NATIVE_VIDEO_CLOSE);
        }
        m.f51277a.m("home_common_widget", "click", map);
    }

    public final void f() {
        HomePopupInfo widget;
        HomePopupInfo widget2;
        HomePopupInfo widget3;
        HashMap map = new HashMap();
        HomePopupEntity homePopupEntity = this.f51637a;
        String name = null;
        map.put("widget_id", String.valueOf((homePopupEntity == null || (widget3 = homePopupEntity.getWidget()) == null) ? null : Long.valueOf(widget3.getId())));
        HomePopupEntity homePopupEntity2 = this.f51637a;
        map.put("widget_type", String.valueOf((homePopupEntity2 == null || (widget2 = homePopupEntity2.getWidget()) == null) ? null : Integer.valueOf(widget2.getType())));
        HomePopupEntity homePopupEntity3 = this.f51637a;
        if (homePopupEntity3 != null && (widget = homePopupEntity3.getWidget()) != null) {
            name = widget.getName();
        }
        map.put("widget_name", String.valueOf(name));
        m.f51277a.t("home_common_widget", "dialog_show", map);
    }

    public final void showData(final HomePopupEntity homePopupEntity) {
        HomePopupInfo widget;
        HomePopupInfo widget2;
        HomePopupInfo widget3;
        HomePopupInfo widget4;
        HomePopupInfo widget5;
        String img = null;
        if (TextUtils.isEmpty((homePopupEntity == null || (widget5 = homePopupEntity.getWidget()) == null) ? null : widget5.getImg())) {
            setVisibility(8);
            return;
        }
        HomePopupEntity homePopupEntity2 = this.f51637a;
        if (TextUtils.equals((homePopupEntity2 == null || (widget4 = homePopupEntity2.getWidget()) == null) ? null : widget4.getImg(), (homePopupEntity == null || (widget3 = homePopupEntity.getWidget()) == null) ? null : widget3.getImg())) {
            return;
        }
        this.f51637a = homePopupEntity;
        RequestManager requestManagerWith = Glide.with(Utils.a());
        if (homePopupEntity != null && (widget2 = homePopupEntity.getWidget()) != null) {
            img = widget2.getImg();
        }
        requestManagerWith.load2(img).listener(new b()).into((ImageView) findViewById(R$id.f51601iv));
        postDelayed(new Runnable() { // from class: com.transsion.commercialization.dialog.g
            @Override // java.lang.Runnable
            public final void run() {
                TrendingFloatView.g(this.f51649a, homePopupEntity);
            }
        }, ((long) ((homePopupEntity == null || (widget = homePopupEntity.getWidget()) == null) ? 0 : widget.getCloseDelay())) * 1000);
        setOnClickListener(new View.OnClickListener() { // from class: com.transsion.commercialization.dialog.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TrendingFloatView.i(homePopupEntity, this, view);
            }
        });
    }
}
