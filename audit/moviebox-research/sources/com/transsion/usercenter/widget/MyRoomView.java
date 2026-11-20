package com.transsion.usercenter.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import androidx.annotation.StringRes;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import com.google.android.material.imageview.ShapeableImageView;
import com.tn.lib.widget.R$color;
import com.tn.lib.widget.TnTextView;
import com.transsion.baseui.R$mipmap;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.baseui.util.h;
import com.transsion.usercenter.R$drawable;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;
import com.transsion.usercenter.R$string;
import com.transsion.usercenter.profile.bean.CoverUrl;
import com.transsion.usercenter.widget.MyRoomView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import so.c;
import tp.f;
import xy.r0;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class MyRoomView extends ConstraintLayout {
    public static final a Companion = new a(null);
    public static final int LAYOUT_TYPE_DOWNLOADS = 2;
    public static final int LAYOUT_TYPE_MY_ROOM = 1;
    public static final int LAYOUT_TYPE_WATCHER_LATER = 3;
    public static final int ON_CLICK_TYPE_BTN = 5;
    public static final int ON_CLICK_TYPE_ITEM = 4;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public r0 f59756a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f59757b;

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
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f59758a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f59759b;

        public b(String str, int i11) {
            this.f59758a = str;
            this.f59759b = i11;
        }

        public final int a() {
            return this.f59759b;
        }

        public final String b() {
            return this.f59758a;
        }

        public final void c(String str) {
            this.f59758a = str;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return Intrinsics.b(this.f59758a, bVar.f59758a) && this.f59759b == bVar.f59759b;
        }

        public int hashCode() {
            String str = this.f59758a;
            return ((str == null ? 0 : str.hashCode()) * 31) + this.f59759b;
        }

        public String toString() {
            return "MyViewDownloads(url=" + this.f59758a + ", type=" + this.f59759b + ")";
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MyRoomView(Context context) {
        this(context, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MyRoomView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MyRoomView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
        this.f59757b = 1;
        View.inflate(context, R$layout.view_my_room_layout, this);
        this.f59756a = r0.a(this);
    }

    public static final void i(Function0 itemClick, View view) {
        Intrinsics.g(itemClick, "$itemClick");
        itemClick.invoke();
    }

    public static /* synthetic */ void k(MyRoomView myRoomView, String str, String str2, String str3, String str4, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            str = "";
        }
        if ((i12 & 2) != 0) {
            str2 = "";
        }
        if ((i12 & 4) != 0) {
            str3 = "";
        }
        if ((i12 & 8) != 0) {
            str4 = "";
        }
        if ((i12 & 16) != 0) {
            i11 = R$drawable.profile_shape_dotted_line_img;
        }
        myRoomView.j(str, str2, str3, str4, i11);
    }

    public static final void m(Function0 itemClick, View view) {
        Intrinsics.g(itemClick, "$itemClick");
        itemClick.invoke();
    }

    public static final void n(Function1 itemClick, View view) {
        Intrinsics.g(itemClick, "$itemClick");
        itemClick.invoke(4);
    }

    public static final void o(Function1 itemClick, View view) {
        Intrinsics.g(itemClick, "$itemClick");
        itemClick.invoke(5);
    }

    public static /* synthetic */ void showDownloadsData$default(MyRoomView myRoomView, int i11, Integer num, b bVar, b bVar2, b bVar3, Function0 function0, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            num = 0;
        }
        myRoomView.showDownloadsData(i11, num, bVar, bVar2, bVar3, function0);
    }

    public final int f(int i11) {
        if (i11 != 1) {
            return i11 != 2 ? R$drawable.profile_shape_dotted_line_img : R$mipmap.ic_default_video;
        }
        return R$mipmap.default_audio_ic_9_16;
    }

    public final void g(ImageView imageView, String str, int i11) {
        if (imageView != null) {
            ImageHelper.Companion companion = ImageHelper.f51371a;
            Context context = imageView.getContext();
            Intrinsics.f(context, "context");
            String str2 = str == null ? "" : str;
            f fVar = f.f77260a;
            Context context2 = imageView.getContext();
            Intrinsics.f(context2, "context");
            int iA = fVar.a(context2, 26.0f);
            Context context3 = imageView.getContext();
            Intrinsics.f(context3, "context");
            companion.o(context, imageView, str2, (32704 & 8) != 0 ? R$color.skeleton : i11, (32704 & 16) != 0 ? companion.d() : iA, (32704 & 32) != 0 ? companion.c() : fVar.a(context3, 26.0f), (32704 & 64) != 0 ? 0 : 0, (32704 & 128) != 0, (32704 & 256) != 0 ? "" : null, (32704 & 512) != 0, (32704 & 1024) != 0, (32704 & 2048) != 0 ? false : false, (32704 & 4096) != 0 ? false : false, (32704 & 8192) != 0 ? false : false, (32704 & 16384) != 0 ? 25 : 0);
        }
    }

    public final void h(Integer num) {
        r0 r0Var = this.f59756a;
        AppCompatTextView appCompatTextView = r0Var != null ? r0Var.f80950j : null;
        if (appCompatTextView == null) {
            return;
        }
        appCompatTextView.setText(h.f51463a.a(String.valueOf(num)));
    }

    public final void j(String str, String str2, String str3, String str4, int i11) {
        r0 r0Var = this.f59756a;
        g(r0Var != null ? r0Var.f80946f : null, str, i11);
        r0 r0Var2 = this.f59756a;
        g(r0Var2 != null ? r0Var2.f80947g : null, str2, i11);
        r0 r0Var3 = this.f59756a;
        g(r0Var3 != null ? r0Var3.f80948h : null, str3, i11);
        r0 r0Var4 = this.f59756a;
        g(r0Var4 != null ? r0Var4.f80949i : null, str4, i11);
    }

    public final void l(b bVar, b bVar2, b bVar3) {
        ShapeableImageView shapeableImageView;
        String strB;
        ShapeableImageView shapeableImageView2;
        String strB2;
        ShapeableImageView shapeableImageView3;
        String strB3;
        r0 r0Var = this.f59756a;
        if (r0Var != null && (shapeableImageView3 = r0Var.f80946f) != null) {
            if (TextUtils.isEmpty(bVar != null ? bVar.b() : null) && bVar != null) {
                bVar.c("ivUrl1.url");
            }
            ImageHelper.Companion companion = ImageHelper.f51371a;
            Context context = shapeableImageView3.getContext();
            Intrinsics.f(context, "context");
            String str = (bVar == null || (strB3 = bVar.b()) == null) ? "ivUrl1?.url" : strB3;
            int iF = f(bVar != null ? bVar.a() : 3);
            f fVar = f.f77260a;
            Context context2 = shapeableImageView3.getContext();
            Intrinsics.f(context2, "context");
            int iA = fVar.a(context2, 26.0f);
            Context context3 = shapeableImageView3.getContext();
            Intrinsics.f(context3, "context");
            companion.o(context, shapeableImageView3, str, (32704 & 8) != 0 ? R$color.skeleton : iF, (32704 & 16) != 0 ? companion.d() : iA, (32704 & 32) != 0 ? companion.c() : fVar.a(context3, 26.0f), (32704 & 64) != 0 ? 0 : 0, (32704 & 128) != 0, (32704 & 256) != 0 ? "" : null, (32704 & 512) != 0, (32704 & 1024) != 0, (32704 & 2048) != 0 ? false : false, (32704 & 4096) != 0 ? false : false, (32704 & 8192) != 0 ? false : false, (32704 & 16384) != 0 ? 25 : 0);
        }
        r0 r0Var2 = this.f59756a;
        if (r0Var2 != null && (shapeableImageView2 = r0Var2.f80947g) != null) {
            if (TextUtils.isEmpty(bVar2 != null ? bVar2.b() : null) && bVar2 != null) {
                bVar2.c("ivUrl2.url");
            }
            ImageHelper.Companion companion2 = ImageHelper.f51371a;
            Context context4 = shapeableImageView2.getContext();
            Intrinsics.f(context4, "context");
            String str2 = (bVar2 == null || (strB2 = bVar2.b()) == null) ? "ivUrl1?.url" : strB2;
            int iF2 = f(bVar2 != null ? bVar2.a() : 3);
            f fVar2 = f.f77260a;
            Context context5 = shapeableImageView2.getContext();
            Intrinsics.f(context5, "context");
            int iA2 = fVar2.a(context5, 26.0f);
            Context context6 = shapeableImageView2.getContext();
            Intrinsics.f(context6, "context");
            companion2.o(context4, shapeableImageView2, str2, (32704 & 8) != 0 ? R$color.skeleton : iF2, (32704 & 16) != 0 ? companion2.d() : iA2, (32704 & 32) != 0 ? companion2.c() : fVar2.a(context6, 26.0f), (32704 & 64) != 0 ? 0 : 0, (32704 & 128) != 0, (32704 & 256) != 0 ? "" : null, (32704 & 512) != 0, (32704 & 1024) != 0, (32704 & 2048) != 0 ? false : false, (32704 & 4096) != 0 ? false : false, (32704 & 8192) != 0 ? false : false, (32704 & 16384) != 0 ? 25 : 0);
        }
        r0 r0Var3 = this.f59756a;
        if (r0Var3 == null || (shapeableImageView = r0Var3.f80948h) == null) {
            return;
        }
        if (TextUtils.isEmpty(bVar3 != null ? bVar3.b() : null) && bVar3 != null) {
            bVar3.c("ivUrl3.url");
        }
        ImageHelper.Companion companion3 = ImageHelper.f51371a;
        Context context7 = shapeableImageView.getContext();
        Intrinsics.f(context7, "context");
        String str3 = (bVar3 == null || (strB = bVar3.b()) == null) ? "ivUrl1?.url" : strB;
        int iF3 = f(bVar3 != null ? bVar3.a() : 3);
        f fVar3 = f.f77260a;
        Context context8 = shapeableImageView.getContext();
        Intrinsics.f(context8, "context");
        int iA3 = fVar3.a(context8, 26.0f);
        Context context9 = shapeableImageView.getContext();
        Intrinsics.f(context9, "context");
        companion3.o(context7, shapeableImageView, str3, (32704 & 8) != 0 ? R$color.skeleton : iF3, (32704 & 16) != 0 ? companion3.d() : iA3, (32704 & 32) != 0 ? companion3.c() : fVar3.a(context9, 26.0f), (32704 & 64) != 0 ? 0 : 0, (32704 & 128) != 0, (32704 & 256) != 0 ? "" : null, (32704 & 512) != 0, (32704 & 1024) != 0, (32704 & 2048) != 0 ? false : false, (32704 & 4096) != 0 ? false : false, (32704 & 8192) != 0 ? false : false, (32704 & 16384) != 0 ? 25 : 0);
    }

    public final void resetUserUi() {
        TnTextView tnTextView;
        ShapeableImageView shapeableImageView;
        AppCompatTextView appCompatTextView;
        ShapeableImageView shapeableImageView2;
        TnTextView tnTextView2;
        ShapeableImageView shapeableImageView3;
        r0 r0Var = this.f59756a;
        if (r0Var != null && (shapeableImageView3 = r0Var.f80949i) != null) {
            c.k(shapeableImageView3);
        }
        r0 r0Var2 = this.f59756a;
        ViewParent parent = (r0Var2 == null || (tnTextView2 = r0Var2.f80951k) == null) ? null : tnTextView2.getParent();
        ConstraintLayout constraintLayout = parent instanceof ConstraintLayout ? (ConstraintLayout) parent : null;
        if (constraintLayout != null) {
            ViewGroup.LayoutParams layoutParams = constraintLayout.getLayoutParams();
            Intrinsics.e(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            layoutParams.width = gs.a.a(162);
            constraintLayout.setLayoutParams(layoutParams);
        }
        r0 r0Var3 = this.f59756a;
        ViewGroup.LayoutParams layoutParams2 = (r0Var3 == null || (shapeableImageView2 = r0Var3.f80949i) == null) ? null : shapeableImageView2.getLayoutParams();
        Intrinsics.e(layoutParams2, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams2;
        bVar.setMarginEnd(gs.a.a(32));
        r0 r0Var4 = this.f59756a;
        ShapeableImageView shapeableImageView4 = r0Var4 != null ? r0Var4.f80949i : null;
        if (shapeableImageView4 != null) {
            shapeableImageView4.setLayoutParams(bVar);
        }
        r0 r0Var5 = this.f59756a;
        ViewGroup.LayoutParams layoutParams3 = (r0Var5 == null || (appCompatTextView = r0Var5.f80950j) == null) ? null : appCompatTextView.getLayoutParams();
        Intrinsics.e(layoutParams3, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.b bVar2 = (ConstraintLayout.b) layoutParams3;
        bVar2.f7315t = -1;
        bVar2.f7295j = -1;
        int i11 = R$id.ivPlaceholder4;
        bVar2.f7313s = i11;
        bVar2.f7293i = i11;
        bVar2.f7299l = i11;
        bVar2.f7319v = 0;
        ((ViewGroup.MarginLayoutParams) bVar2).topMargin = 0;
        r0 r0Var6 = this.f59756a;
        AppCompatTextView appCompatTextView2 = r0Var6 != null ? r0Var6.f80950j : null;
        if (appCompatTextView2 != null) {
            appCompatTextView2.setLayoutParams(bVar2);
        }
        r0 r0Var7 = this.f59756a;
        ViewGroup.LayoutParams layoutParams4 = (r0Var7 == null || (shapeableImageView = r0Var7.f80946f) == null) ? null : shapeableImageView.getLayoutParams();
        Intrinsics.e(layoutParams4, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.b bVar3 = (ConstraintLayout.b) layoutParams4;
        bVar3.f7295j = R$id.tvTitle;
        ((ViewGroup.MarginLayoutParams) bVar3).topMargin = gs.a.a(12);
        r0 r0Var8 = this.f59756a;
        ShapeableImageView shapeableImageView5 = r0Var8 != null ? r0Var8.f80946f : null;
        if (shapeableImageView5 != null) {
            shapeableImageView5.setLayoutParams(bVar3);
        }
        r0 r0Var9 = this.f59756a;
        ViewGroup.LayoutParams layoutParams5 = (r0Var9 == null || (tnTextView = r0Var9.f80943b) == null) ? null : tnTextView.getLayoutParams();
        Intrinsics.e(layoutParams5, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.b bVar4 = (ConstraintLayout.b) layoutParams5;
        bVar4.f7295j = R$id.tvTitle;
        r0 r0Var10 = this.f59756a;
        TnTextView tnTextView3 = r0Var10 != null ? r0Var10.f80943b : null;
        if (tnTextView3 == null) {
            return;
        }
        tnTextView3.setLayoutParams(bVar4);
    }

    public final void setTitle(@StringRes int i11) {
        TnTextView tnTextView;
        r0 r0Var = this.f59756a;
        if (r0Var == null || (tnTextView = r0Var.f80951k) == null) {
            return;
        }
        tnTextView.setTextById(i11);
    }

    public final void showCollectionData(int i11, boolean z11, Integer num, CoverUrl coverUrl, CoverUrl coverUrl2, CoverUrl coverUrl3, CoverUrl coverUrl4, final Function0<Unit> itemClick) {
        ConstraintLayout constraintLayout;
        Intrinsics.g(itemClick, "itemClick");
        this.f59757b = i11;
        h(num);
        r0 r0Var = this.f59756a;
        g(r0Var != null ? r0Var.f80946f : null, coverUrl != null ? coverUrl.getCoverUrl() : null, (coverUrl == null || coverUrl.getType() != 1) ? R$drawable.profile_shape_dotted_line_img : com.transsion.usercenter.R$mipmap.profile_staff_avatar_empty);
        r0 r0Var2 = this.f59756a;
        g(r0Var2 != null ? r0Var2.f80947g : null, coverUrl2 != null ? coverUrl2.getCoverUrl() : null, (coverUrl2 == null || coverUrl2.getType() != 1) ? R$drawable.profile_shape_dotted_line_img : com.transsion.usercenter.R$mipmap.profile_staff_avatar_empty);
        r0 r0Var3 = this.f59756a;
        g(r0Var3 != null ? r0Var3.f80948h : null, coverUrl3 != null ? coverUrl3.getCoverUrl() : null, (coverUrl3 == null || coverUrl3.getType() != 1) ? R$drawable.profile_shape_dotted_line_img : com.transsion.usercenter.R$mipmap.profile_staff_avatar_empty);
        r0 r0Var4 = this.f59756a;
        g(r0Var4 != null ? r0Var4.f80949i : null, coverUrl4 != null ? coverUrl4.getCoverUrl() : null, (coverUrl4 == null || coverUrl4.getType() != 1) ? R$drawable.profile_shape_dotted_line_img : com.transsion.usercenter.R$mipmap.profile_staff_avatar_empty);
        r0 r0Var5 = this.f59756a;
        if (r0Var5 == null || (constraintLayout = r0Var5.f80944c) == null) {
            return;
        }
        constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: nz.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MyRoomView.i(itemClick, view);
            }
        });
    }

    public final void showDownloadsData(int i11, Integer num, b bVar, b bVar2, b bVar3, final Function0<Unit> itemClick) {
        ConstraintLayout constraintLayout;
        Intrinsics.g(itemClick, "itemClick");
        this.f59757b = i11;
        h(num);
        l(bVar, bVar2, bVar3);
        r0 r0Var = this.f59756a;
        if (r0Var == null || (constraintLayout = r0Var.f80944c) == null) {
            return;
        }
        constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: nz.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MyRoomView.m(itemClick, view);
            }
        });
    }

    public final void showMyRoomData(int i11, boolean z11, Integer num, String str, String str2, String str3, String str4, final Function1<? super Integer, Unit> itemClick) {
        Group group;
        TnTextView tnTextView;
        ConstraintLayout constraintLayout;
        TnTextView tnTextView2;
        Intrinsics.g(itemClick, "itemClick");
        this.f59757b = i11;
        r0 r0Var = this.f59756a;
        if (r0Var != null && (tnTextView2 = r0Var.f80943b) != null) {
            tnTextView2.setTextById(R$string.profile_add_room);
        }
        h(num);
        if (num == null || num.intValue() != 0) {
            k(this, str, str2, str3, str4, 0, 16, null);
            r0 r0Var2 = this.f59756a;
            TnTextView tnTextView3 = r0Var2 != null ? r0Var2.f80943b : null;
            if (tnTextView3 != null) {
                tnTextView3.setVisibility(8);
            }
            r0 r0Var3 = this.f59756a;
            group = r0Var3 != null ? r0Var3.f80945d : null;
            if (group != null) {
                group.setVisibility(0);
            }
        } else if (z11) {
            r0 r0Var4 = this.f59756a;
            TnTextView tnTextView4 = r0Var4 != null ? r0Var4.f80943b : null;
            if (tnTextView4 != null) {
                tnTextView4.setVisibility(0);
            }
            r0 r0Var5 = this.f59756a;
            group = r0Var5 != null ? r0Var5.f80945d : null;
            if (group != null) {
                group.setVisibility(8);
            }
        } else {
            r0 r0Var6 = this.f59756a;
            TnTextView tnTextView5 = r0Var6 != null ? r0Var6.f80943b : null;
            if (tnTextView5 != null) {
                tnTextView5.setVisibility(8);
            }
            r0 r0Var7 = this.f59756a;
            group = r0Var7 != null ? r0Var7.f80945d : null;
            if (group != null) {
                group.setVisibility(0);
            }
        }
        r0 r0Var8 = this.f59756a;
        if (r0Var8 != null && (constraintLayout = r0Var8.f80944c) != null) {
            constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: nz.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MyRoomView.n(itemClick, view);
                }
            });
        }
        r0 r0Var9 = this.f59756a;
        if (r0Var9 == null || (tnTextView = r0Var9.f80943b) == null) {
            return;
        }
        tnTextView.setOnClickListener(new View.OnClickListener() { // from class: nz.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MyRoomView.o(itemClick, view);
            }
        });
    }
}
