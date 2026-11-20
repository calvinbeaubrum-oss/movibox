package com.transsnet.downloader.dialog;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.transsion.baseui.dialog.BaseDialog;
import com.transsnet.downloader.R$layout;
import com.transsnet.downloader.R$string;
import com.transsnet.downloader.R$style;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class DownloadConfirmDialog extends BaseDialog {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a f60505j = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function1<? super Boolean, Unit> f60506c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public h00.g f60507d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f60508f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f60509g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f60510h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f60511i;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ DownloadConfirmDialog b(a aVar, String str, String str2, String str3, String str4, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = null;
            }
            if ((i11 & 2) != 0) {
                str2 = null;
            }
            if ((i11 & 8) != 0) {
                str4 = null;
            }
            return aVar.a(str, str2, str3, str4);
        }

        public final DownloadConfirmDialog a(String str, String str2, String str3, String str4) {
            DownloadConfirmDialog downloadConfirmDialog = new DownloadConfirmDialog();
            downloadConfirmDialog.setArguments(androidx.core.os.c.b(TuplesKt.a("no_text", str), TuplesKt.a("yes_text", str2), TuplesKt.a(CampaignEx.JSON_KEY_TITLE, str3), TuplesKt.a("tips", str4)));
            return downloadConfirmDialog;
        }
    }

    public DownloadConfirmDialog() {
        super(R$layout.dialog_download_confirm);
    }

    private final void o0(View view) {
        AppCompatTextView appCompatTextView;
        AppCompatTextView appCompatTextView2;
        AppCompatTextView appCompatTextView3;
        AppCompatTextView appCompatTextView4;
        AppCompatTextView appCompatTextView5;
        AppCompatTextView appCompatTextView6;
        h00.g gVarA = h00.g.a(view);
        this.f60507d = gVarA;
        AppCompatTextView appCompatTextView7 = gVarA != null ? gVarA.f65849b : null;
        if (appCompatTextView7 != null) {
            appCompatTextView7.setText(this.f60508f);
        }
        h00.g gVar = this.f60507d;
        AppCompatTextView appCompatTextView8 = gVar != null ? gVar.f65850c : null;
        if (appCompatTextView8 != null) {
            appCompatTextView8.setText(this.f60509g);
        }
        h00.g gVar2 = this.f60507d;
        if (gVar2 != null && (appCompatTextView6 = gVar2.f65849b) != null) {
            appCompatTextView6.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.dialog.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    DownloadConfirmDialog.p0(this.f60580a, view2);
                }
            });
        }
        h00.g gVar3 = this.f60507d;
        if (gVar3 != null && (appCompatTextView5 = gVar3.f65850c) != null) {
            appCompatTextView5.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.dialog.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    DownloadConfirmDialog.q0(this.f60582a, view2);
                }
            });
        }
        String str = this.f60510h;
        if (str == null || str.length() == 0) {
            h00.g gVar4 = this.f60507d;
            if (gVar4 != null && (appCompatTextView = gVar4.f65852f) != null) {
                so.c.g(appCompatTextView);
            }
        } else {
            h00.g gVar5 = this.f60507d;
            if (gVar5 != null && (appCompatTextView4 = gVar5.f65852f) != null) {
                so.c.k(appCompatTextView4);
            }
            h00.g gVar6 = this.f60507d;
            AppCompatTextView appCompatTextView9 = gVar6 != null ? gVar6.f65852f : null;
            if (appCompatTextView9 != null) {
                appCompatTextView9.setText(this.f60510h);
            }
        }
        String str2 = this.f60511i;
        if (str2 == null || str2.length() == 0) {
            h00.g gVar7 = this.f60507d;
            if (gVar7 == null || (appCompatTextView2 = gVar7.f65851d) == null) {
                return;
            }
            so.c.g(appCompatTextView2);
            return;
        }
        h00.g gVar8 = this.f60507d;
        if (gVar8 != null && (appCompatTextView3 = gVar8.f65851d) != null) {
            so.c.k(appCompatTextView3);
        }
        h00.g gVar9 = this.f60507d;
        AppCompatTextView appCompatTextView10 = gVar9 != null ? gVar9.f65851d : null;
        if (appCompatTextView10 == null) {
            return;
        }
        appCompatTextView10.setText(this.f60511i);
    }

    public static final void p0(DownloadConfirmDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
        Function1<? super Boolean, Unit> function1 = this$0.f60506c;
        if (function1 != null) {
            function1.invoke(Boolean.FALSE);
        }
    }

    public static final void q0(DownloadConfirmDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
        Function1<? super Boolean, Unit> function1 = this$0.f60506c;
        if (function1 != null) {
            function1.invoke(Boolean.TRUE);
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R$style.BaseDialogStyle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.g(view, "view");
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f60508f = arguments.getString("no_text", getString(R$string.cancel));
            this.f60509g = arguments.getString("yes_text", getString(R$string.confirm));
            this.f60510h = arguments.getString(CampaignEx.JSON_KEY_TITLE);
            this.f60511i = arguments.getString("tips");
        }
        o0(view);
    }

    public final void r0(Function1<? super Boolean, Unit> call) {
        Intrinsics.g(call, "call");
        this.f60506c = call;
    }
}
