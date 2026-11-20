package com.transsion.moviedetail.fragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.noober.background.view.BLTextView;
import com.tn.lib.view.MaxHeightNestedScrollView;
import com.transsion.baselib.report.launch.RoomAppMMKV;
import com.transsion.baseui.R$style;
import com.transsion.baseui.dialog.BaseDialog;
import com.transsion.moviedetail.R$layout;
import com.transsion.web.api.WebConstants;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
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
public final class RestrictTipsDialog extends BaseDialog {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a f53538j = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public tu.d f53539c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f53540d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f53541f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f53542g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Function1<? super Boolean, Unit> f53543h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f53544i;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RestrictTipsDialog a(String tips, String pageFrom, String str) {
            Intrinsics.g(tips, "tips");
            Intrinsics.g(pageFrom, "pageFrom");
            RestrictTipsDialog restrictTipsDialog = new RestrictTipsDialog();
            restrictTipsDialog.setArguments(androidx.core.os.c.b(TuplesKt.a("tips", tips), TuplesKt.a(WebConstants.PAGE_FROM, pageFrom), TuplesKt.a("subject_id", str)));
            return restrictTipsDialog;
        }
    }

    public RestrictTipsDialog() {
        super(R$layout.dialog_restrict_tips);
    }

    private final void q0(View view) {
        LinearLayoutCompat linearLayoutCompat;
        BLTextView bLTextView;
        BLTextView bLTextView2;
        MaxHeightNestedScrollView maxHeightNestedScrollView;
        tu.d dVarA = tu.d.a(view);
        this.f53539c = dVarA;
        if (dVarA != null && (maxHeightNestedScrollView = dVarA.f77461d) != null) {
            maxHeightNestedScrollView.setMaxHeight(com.blankj.utilcode.util.f0.a(368.0f));
        }
        tu.d dVar = this.f53539c;
        AppCompatTextView appCompatTextView = dVar != null ? dVar.f77464h : null;
        if (appCompatTextView != null) {
            appCompatTextView.setText(this.f53540d);
        }
        tu.d dVar2 = this.f53539c;
        if (dVar2 != null && (bLTextView2 = dVar2.f77463g) != null) {
            bLTextView2.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.moviedetail.fragment.e0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    RestrictTipsDialog.r0(this.f53645a, view2);
                }
            });
        }
        tu.d dVar3 = this.f53539c;
        if (dVar3 != null && (bLTextView = dVar3.f77462f) != null) {
            bLTextView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.moviedetail.fragment.f0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    RestrictTipsDialog.s0(this.f53647a, view2);
                }
            });
        }
        tu.d dVar4 = this.f53539c;
        if (dVar4 == null || (linearLayoutCompat = dVar4.f77460c) == null) {
            return;
        }
        linearLayoutCompat.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.moviedetail.fragment.g0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                RestrictTipsDialog.t0(this.f53649a, view2);
            }
        });
    }

    public static final void r0(RestrictTipsDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.v0("confirm");
        Function1<? super Boolean, Unit> function1 = this$0.f53543h;
        if (function1 != null) {
            function1.invoke(Boolean.TRUE);
        }
        this$0.dismissAllowingStateLoss();
    }

    public static final void s0(RestrictTipsDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.v0("btn_back");
        this$0.f53544i = false;
        Function1<? super Boolean, Unit> function1 = this$0.f53543h;
        if (function1 != null) {
            function1.invoke(Boolean.FALSE);
        }
        this$0.dismissAllowingStateLoss();
    }

    public static final void t0(RestrictTipsDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        tu.d dVar = this$0.f53539c;
        ImageView imageView = dVar != null ? dVar.f77459b : null;
        if (imageView != null) {
            imageView.setSelected(!this$0.f53544i);
        }
        this$0.f53544i = !this$0.f53544i;
    }

    public static final boolean u0(RestrictTipsDialog this$0, DialogInterface dialogInterface, int i11, KeyEvent keyEvent) {
        Intrinsics.g(this$0, "this$0");
        if (i11 != 4 || keyEvent.getAction() != 1) {
            return false;
        }
        this$0.v0("action_back");
        this$0.f53544i = false;
        Function1<? super Boolean, Unit> function1 = this$0.f53543h;
        if (function1 != null) {
            function1.invoke(Boolean.FALSE);
        }
        this$0.dismissAllowingStateLoss();
        return true;
    }

    private final void v0(String str) {
        HashMap map = new HashMap();
        map.put("opt_type", str);
        map.put("not_show_select", String.valueOf(this.f53544i));
        String str2 = this.f53542g;
        if (str2 == null) {
            str2 = "";
        }
        map.put("subject_id", str2);
        String str3 = this.f53541f;
        map.put(WebConstants.PAGE_FROM, str3 != null ? str3 : "");
        com.transsion.baselib.report.m.f51277a.m("restrict_tips_dialog", "click", map);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setCancelable(false);
        setStyle(0, R$style.NormalDialogTheme);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f53540d = arguments.getString("tips");
            this.f53541f = arguments.getString(WebConstants.PAGE_FROM);
            this.f53542g = arguments.getString("subject_id");
        }
    }

    @Override // com.transsion.baseui.dialog.BaseDialog, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.f53544i) {
            RoomAppMMKV.f51271a.a().putBoolean("restrict_tips_dialog_again", false);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Window window;
        Intrinsics.g(view, "view");
        super.onViewCreated(view, bundle);
        int iE = com.blankj.utilcode.util.d0.e() - com.blankj.utilcode.util.f0.a(80.0f);
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setLayout(iE, -2);
            window.setGravity(17);
        }
        Dialog dialog2 = getDialog();
        if (dialog2 != null) {
            dialog2.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.transsion.moviedetail.fragment.d0
                @Override // android.content.DialogInterface.OnKeyListener
                public final boolean onKey(DialogInterface dialogInterface, int i11, KeyEvent keyEvent) {
                    return RestrictTipsDialog.u0(this.f53643a, dialogInterface, i11, keyEvent);
                }
            });
        }
        w0();
        q0(view);
    }

    public final void w0() {
        HashMap map = new HashMap();
        String str = this.f53541f;
        if (str == null) {
            str = "";
        }
        map.put(WebConstants.PAGE_FROM, str);
        String str2 = this.f53542g;
        map.put("subject_id", str2 != null ? str2 : "");
        com.transsion.baselib.report.m.f51277a.t("restrict_tips_dialog", "dialog_show", map);
    }

    public final void x0(Function1<? super Boolean, Unit> call) {
        Intrinsics.g(call, "call");
        this.f53543h = call;
    }
}
