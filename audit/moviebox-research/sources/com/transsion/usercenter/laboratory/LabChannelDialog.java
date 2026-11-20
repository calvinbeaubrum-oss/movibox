package com.transsion.usercenter.laboratory;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import androidx.fragment.app.FragmentActivity;
import com.transsion.baseui.dialog.BaseDialog;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;
import com.transsion.usercenter.R$style;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

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
public final class LabChannelDialog extends BaseDialog {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public xy.m f59344c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f59345d;

    public LabChannelDialog() {
        super(R$layout.dialog_lab_channel_layout);
        this.f59345d = "";
    }

    public static final void p0(LabChannelDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    public static final void q0(LabChannelDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        if (!TextUtils.isEmpty(this$0.f59345d)) {
            fp.b.f65208a.j(this$0.f59345d);
            zp.b.f82110a.e("自定义成功 -- channel = " + this$0.f59345d);
        }
        this$0.dismissAllowingStateLoss();
    }

    public static final void r0(LabChannelDialog this$0, RadioGroup radioGroup, int i11) {
        Intrinsics.g(this$0, "this$0");
        if (i11 == R$id.radioButtonGP) {
            zp.b.f82110a.e("gp");
            this$0.f59345d = "gp";
        } else if (i11 == R$id.radioButtonPS) {
            zp.b.f82110a.e("ps");
            this$0.f59345d = "ps";
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R$style.BaseDialogStyle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        RadioGroup radioGroup;
        Button button;
        Button button2;
        RadioGroup radioGroup2;
        RadioGroup radioGroup3;
        RadioGroup radioGroup4;
        Intrinsics.g(view, "view");
        super.onViewCreated(view, bundle);
        this.f59344c = xy.m.a(view);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            String strE = fp.b.f65208a.e(activity);
            if (TextUtils.equals("ps", strE)) {
                xy.m mVar = this.f59344c;
                if (mVar != null && (radioGroup4 = mVar.f80863g) != null) {
                    radioGroup4.check(R$id.radioButtonPS);
                }
            } else if (TextUtils.equals("gp", strE)) {
                xy.m mVar2 = this.f59344c;
                if (mVar2 != null && (radioGroup3 = mVar2.f80863g) != null) {
                    radioGroup3.check(R$id.radioButtonGP);
                }
            } else {
                xy.m mVar3 = this.f59344c;
                if (mVar3 != null && (radioGroup2 = mVar3.f80863g) != null) {
                    radioGroup2.clearCheck();
                }
            }
        }
        xy.m mVar4 = this.f59344c;
        if (mVar4 != null && (button2 = mVar4.f80859b) != null) {
            button2.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.laboratory.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    LabChannelDialog.p0(this.f59364a, view2);
                }
            });
        }
        xy.m mVar5 = this.f59344c;
        if (mVar5 != null && (button = mVar5.f80860c) != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.laboratory.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    LabChannelDialog.q0(this.f59368a, view2);
                }
            });
        }
        xy.m mVar6 = this.f59344c;
        if (mVar6 == null || (radioGroup = mVar6.f80863g) == null) {
            return;
        }
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.transsion.usercenter.laboratory.c
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup5, int i11) {
                LabChannelDialog.r0(this.f59371a, radioGroup5, i11);
            }
        });
    }
}
