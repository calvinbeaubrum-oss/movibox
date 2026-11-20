package com.transsion.commercialization.gameres;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.blankj.utilcode.util.f0;
import com.google.android.material.imageview.ShapeableImageView;
import com.noober.background.drawable.DrawableCreator;
import com.noober.background.view.BLConstraintLayout;
import com.tn.lib.widget.R$color;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.commercialization.R$layout;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import os.h;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public class GameResView extends BLConstraintLayout implements ss.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f51655a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f51656b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ps.a f51657c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, String> f51658d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GameResView(Context context) {
        super(context);
        Intrinsics.g(context, "context");
        this.f51656b = "detail";
        this.f51658d = new LinkedHashMap();
        View.inflate(getContext(), R$layout.view_game_resource, this);
        h hVarA = h.a(this);
        Intrinsics.f(hVarA, "bind(this)");
        this.f51655a = hVarA;
        setBackground(new DrawableCreator.Builder().setCornersRadius(f0.a(8.0f)).setSolidColor(getContext().getResources().getColor(R$color.module_04)).build());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GameResView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.g(context, "context");
        this.f51656b = "detail";
        this.f51658d = new LinkedHashMap();
        View.inflate(getContext(), R$layout.view_game_resource, this);
        h hVarA = h.a(this);
        Intrinsics.f(hVarA, "bind(this)");
        this.f51655a = hVarA;
        setBackground(new DrawableCreator.Builder().setCornersRadius(f0.a(8.0f)).setSolidColor(getContext().getResources().getColor(R$color.module_04)).build());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GameResView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
        this.f51656b = "detail";
        this.f51658d = new LinkedHashMap();
        View.inflate(getContext(), R$layout.view_game_resource, this);
        h hVarA = h.a(this);
        Intrinsics.f(hVarA, "bind(this)");
        this.f51655a = hVarA;
        setBackground(new DrawableCreator.Builder().setCornersRadius(f0.a(8.0f)).setSolidColor(getContext().getResources().getColor(R$color.module_04)).build());
    }

    public final String getGamePageStyle() {
        return this.f51656b;
    }

    public final h getViewBinding() {
        return this.f51655a;
    }

    public void setContent(ps.a info) {
        Intrinsics.g(info, "info");
        this.f51657c = info;
        ImageHelper.Companion companion = ImageHelper.f51371a;
        Context context = getContext();
        Intrinsics.f(context, "context");
        ShapeableImageView shapeableImageView = this.f51655a.f73412b;
        Intrinsics.f(shapeableImageView, "viewBinding.ivCover");
        companion.r(context, shapeableImageView, info.c(), (4088 & 8) != 0 ? companion.d() : 0, (4088 & 16) != 0 ? companion.c() : 0, (4088 & 32) != 0, (4088 & 64) != 0, (4088 & 128) != 0, (4088 & 256) != 0 ? false : false, (4088 & 512) != 0 ? false : false, (4088 & 1024) != 0 ? false : false, (4088 & 2048) != 0 ? 25 : 0);
        this.f51655a.f73418i.setText(info.d());
        this.f51655a.f73417h.setText(info.f());
        this.f51655a.f73416g.setText(info.e());
        this.f51655a.f73414d.setText(info.b());
    }

    public final void setGamePageStyle(String str) {
        Intrinsics.g(str, "<set-?>");
        this.f51656b = str;
    }

    @Override // ss.a
    public void setPageStyle(String style) {
        Intrinsics.g(style, "style");
        this.f51656b = style;
        if (Intrinsics.b(style, "fullscreen")) {
            setBackground(new DrawableCreator.Builder().setCornersRadius(f0.a(8.0f)).setSolidColor(getContext().getResources().getColor(R$color.black_50)).build());
            this.f51655a.f73418i.setTextColor(getContext().getResources().getColor(R$color.white));
            int color = getContext().getResources().getColor(R$color.white_60);
            this.f51655a.f73417h.setTextColor(color);
            this.f51655a.f73416g.setTextColor(color);
            this.f51655a.f73414d.setTextColor(color);
            this.f51655a.f73419j.setBackgroundColor(color);
        } else if (Intrinsics.b(style, "detail")) {
            setBackground(new DrawableCreator.Builder().setCornersRadius(f0.a(8.0f)).setSolidColor(getContext().getResources().getColor(R$color.module_04)).build());
            this.f51655a.f73418i.setTextColor(getContext().getResources().getColor(R$color.text_01));
            int color2 = getContext().getResources().getColor(R$color.text_01);
            this.f51655a.f73417h.setTextColor(color2);
            this.f51655a.f73416g.setTextColor(color2);
            this.f51655a.f73414d.setTextColor(color2);
            this.f51655a.f73419j.setBackgroundColor(color2);
        }
        if (this.f51658d.containsKey(style)) {
            return;
        }
        this.f51658d.put(style, "");
        ps.a aVar = this.f51657c;
        if (aVar != null) {
            qs.a.f74884a.c(aVar, style);
        }
    }
}
