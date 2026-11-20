package com.transsnet.downloader.widget;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.f0;
import com.noober.background.drawable.DrawableCreator;
import com.noober.background.view.BLConstraintLayout;
import com.transsnet.downloader.R$color;
import com.transsnet.downloader.R$layout;
import com.transsnet.downloader.R$string;
import com.transsnet.downloader.util.DownloadUtil;
import h00.u0;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class DownloadPathEntranceView extends BLConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f61313a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u0 f61314b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f61315c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f61316d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function1<? super View, Unit> f61317f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Function1<? super View, Unit> f61318g;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DownloadPathEntranceView(Context context) {
        this(context, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DownloadPathEntranceView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadPathEntranceView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
        this.f61313a = "DownloadPathEntranceView";
        String string = Utils.a().getString(R$string.available);
        Intrinsics.f(string, "getApp().getString(R.string.available)");
        this.f61315c = string;
        this.f61316d = f0.a(16.0f);
        View.inflate(context, R$layout.layout_download_re_path_entrance, this);
        u0 u0VarA = u0.a(this);
        Intrinsics.f(u0VarA, "bind(this)");
        this.f61314b = u0VarA;
        c();
    }

    /* JADX WARN: Code duplicated, block: B:6:0x0013  */
    private final void c() {
        ConstraintLayout.b bVar;
        if (getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            Intrinsics.e(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            bVar = (ConstraintLayout.b) layoutParams;
            if (bVar == null) {
                bVar = new ConstraintLayout.b(-1, -2);
            }
        } else {
            bVar = new ConstraintLayout.b(-1, -2);
        }
        bVar.setMarginStart(this.f61316d);
        bVar.setMarginEnd(this.f61316d);
        setLayoutParams(bVar);
        setBackground(new DrawableCreator.Builder().setCornersRadius(f0.a(8.0f)).setSolidColor(getContext().getResources().getColor(R$color.download_module_1)).build());
        onPermissionRefresh();
        this.f61314b.f66046j.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.widget.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DownloadPathEntranceView.e(this.f61389a, view);
            }
        });
        this.f61314b.f66044h.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.widget.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DownloadPathEntranceView.f(this.f61390a, view);
            }
        });
        ConstraintLayout constraintLayout = this.f61314b.f66039b;
        Intrinsics.f(constraintLayout, "viewBinding.clPermission");
        com.transsion.baseui.util.n.a(constraintLayout, com.blankj.utilcode.util.i.e(8.0f));
    }

    public static final void e(DownloadPathEntranceView this$0, View it) {
        Function1<? super View, Unit> function1;
        Intrinsics.g(this$0, "this$0");
        if (Build.VERSION.SDK_INT < 23 || (function1 = this$0.f61318g) == null) {
            return;
        }
        Intrinsics.f(it, "it");
        function1.invoke(it);
    }

    public static final void f(DownloadPathEntranceView this$0, View it) {
        Function1<? super View, Unit> function1;
        Intrinsics.g(this$0, "this$0");
        if (this$0.f61314b.f66044h.getAlpha() != 1.0f || (function1 = this$0.f61317f) == null) {
            return;
        }
        Intrinsics.f(it, "it");
        function1.invoke(it);
    }

    public final void onPermissionDenied() {
        this.f61314b.f66044h.setAlpha(0.4f);
        Group group = this.f61314b.f66040c;
        Intrinsics.f(group, "viewBinding.groupPermission");
        so.c.k(group);
    }

    public final void onPermissionGranted() {
        uo.b.a.f(uo.b.f78622a, this.f61313a, "onPermissionGranted", false, 4, null);
        Group group = this.f61314b.f66040c;
        Intrinsics.f(group, "viewBinding.groupPermission");
        so.c.g(group);
        this.f61314b.f66044h.setAlpha(1.0f);
    }

    public final void onPermissionRefresh() {
        if (DownloadUtil.f61136a.w()) {
            onPermissionGranted();
        } else {
            onPermissionDenied();
        }
    }

    public final void setChangeClickCallback(Function1<? super View, Unit> callback) {
        Intrinsics.g(callback, "callback");
        this.f61317f = callback;
    }

    public final void setPermissionClickCallback(Function1<? super View, Unit> callback) {
        Intrinsics.g(callback, "callback");
        this.f61318g = callback;
    }

    public final void updatePathName(String pathName, long j11) {
        Intrinsics.g(pathName, "pathName");
        String string = Utils.a().getString(R$string.sdcard_name);
        Intrinsics.f(string, "getApp().getString(R.string.sdcard_name)");
        if (StringsKt__StringsKt.Q(pathName, string, false, 2, null)) {
            pathName = pathName + File.separator + tr.b.f77264a.e();
        }
        TextView textView = this.f61314b.f66045i;
        String str = getContext().getString(R$string.download_path_title_prefix) + " " + pathName;
        Intrinsics.f(str, "toString(...)");
        textView.setText(str);
        TextView textView2 = this.f61314b.f66043g;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(j11 <= 0 ? "0Mb" : tp.a.a(j11, 2));
        sb2.append(" ");
        sb2.append(this.f61315c);
        String string2 = sb2.toString();
        Intrinsics.f(string2, "toString(...)");
        textView2.setText(string2);
        this.f61314b.f66043g.setTextColor(Utils.a().getResources().getColor(j11 <= 0 ? com.tn.lib.widget.R$color.error_50 : com.tn.lib.widget.R$color.text_02));
    }
}
