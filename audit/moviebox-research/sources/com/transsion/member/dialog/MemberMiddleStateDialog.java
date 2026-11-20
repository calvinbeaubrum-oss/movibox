package com.transsion.member.dialog;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import androidx.activity.result.ActivityResult;
import com.tn.lib.widget.R$style;
import com.transsion.baseui.dialog.BaseDialog;
import com.transsion.member.MemberActivity;
import com.transsion.memberapi.MemberSource;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class MemberMiddleStateDialog extends BaseDialog {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f53277h = new a(null);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f53278i = 8;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f53279c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public MemberSource f53280d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public su.b f53281f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final b1.b<Intent> f53282g;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MemberMiddleStateDialog a(boolean z11) {
            MemberMiddleStateDialog memberMiddleStateDialog = new MemberMiddleStateDialog();
            Bundle bundle = new Bundle();
            bundle.putBoolean("key_scrolltotask", z11);
            memberMiddleStateDialog.setArguments(bundle);
            return memberMiddleStateDialog;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements b1.a<ActivityResult> {
        public b() {
        }

        @Override // b1.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final void a(ActivityResult activityResult) {
            MemberMiddleStateDialog.this.f53279c = activityResult.getResultCode() == -1;
            com.transsion.member.a.f53220a.a(MemberMiddleStateDialog.this.g0() + " --> startActivity --> registerForActivityResult() --> isPayMemberSuccess = " + MemberMiddleStateDialog.this.f53279c);
            if (MemberMiddleStateDialog.this.isAdded()) {
                MemberMiddleStateDialog.this.dismissAllowingStateLoss();
            }
        }
    }

    public MemberMiddleStateDialog() {
        b1.b<Intent> bVarRegisterForActivityResult = registerForActivityResult(new c1.j(), new b());
        Intrinsics.f(bVarRegisterForActivityResult, "registerForActivityResul…)\n            }\n        }");
        this.f53282g = bVarRegisterForActivityResult;
    }

    public final void o0(su.b callback) {
        Intrinsics.g(callback, "callback");
        this.f53281f = callback;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R$style.center_DialogStyle);
        com.transsion.member.a.f53220a.a(g0() + " --> onCreate()");
        Intent intent = new Intent(requireContext(), (Class<?>) MemberActivity.class);
        MemberSource memberSource = this.f53280d;
        intent.putExtra("source", memberSource != null ? memberSource.getValue() : null);
        Bundle arguments = getArguments();
        intent.putExtra("extra_member_scroll_bottom", arguments != null ? Boolean.valueOf(arguments.getBoolean("key_scrolltotask")) : null);
        this.f53282g.a(intent);
    }

    @Override // com.transsion.baseui.dialog.BaseDialog, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.g(dialog, "dialog");
        super.onDismiss(dialog);
        if (this.f53279c) {
            su.b bVar = this.f53281f;
            if (bVar != null) {
                bVar.onSuccess();
                return;
            }
            return;
        }
        su.b bVar2 = this.f53281f;
        if (bVar2 != null) {
            bVar2.a();
        }
    }

    public final void p0(MemberSource memberSource) {
        this.f53280d = memberSource;
    }
}
