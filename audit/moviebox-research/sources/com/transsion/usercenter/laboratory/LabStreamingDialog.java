package com.transsion.usercenter.laboratory;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import com.transsion.baselib.utils.PlayMode;
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
public final class LabStreamingDialog extends BaseDialog {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public xy.u f59357c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public PlayMode f59358d;

    public LabStreamingDialog() {
        super(R$layout.dialog_lab_streaming_layout);
    }

    public static final void p0(LabStreamingDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    public static final void q0(LabStreamingDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        zp.b.f82110a.e("当前媒体播放模式是 playMode = " + this$0.f59358d);
        PlayMode playMode = this$0.f59358d;
        if (playMode != null) {
            com.transsion.baselib.utils.m.f51320a.c(playMode);
        }
        this$0.dismissAllowingStateLoss();
    }

    public static final void r0(LabStreamingDialog this$0, RadioGroup radioGroup, int i11) {
        Intrinsics.g(this$0, "this$0");
        if (i11 == R$id.radioButtonDownload) {
            zp.b.f82110a.e("PlayMode.DOWNLOAD");
            this$0.f59358d = PlayMode.DOWNLOAD;
        } else if (i11 == R$id.radioButtonStream) {
            zp.b.f82110a.e("PlayMode.STREAM");
            this$0.f59358d = PlayMode.STREAM;
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
        Intrinsics.g(view, "view");
        super.onViewCreated(view, bundle);
        this.f59357c = xy.u.a(view);
        if (getActivity() != null) {
            if (com.transsion.baselib.utils.m.f51320a.b()) {
                xy.u uVar = this.f59357c;
                if (uVar != null && (radioGroup3 = uVar.f80974g) != null) {
                    radioGroup3.check(R$id.radioButtonStream);
                }
                this.f59358d = PlayMode.STREAM;
            } else {
                xy.u uVar2 = this.f59357c;
                if (uVar2 != null && (radioGroup2 = uVar2.f80974g) != null) {
                    radioGroup2.check(R$id.radioButtonDownload);
                }
                this.f59358d = PlayMode.DOWNLOAD;
            }
        }
        xy.u uVar3 = this.f59357c;
        if (uVar3 != null && (button2 = uVar3.f80970b) != null) {
            button2.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.laboratory.c0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    LabStreamingDialog.p0(this.f59372a, view2);
                }
            });
        }
        xy.u uVar4 = this.f59357c;
        if (uVar4 != null && (button = uVar4.f80971c) != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.laboratory.d0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    LabStreamingDialog.q0(this.f59374a, view2);
                }
            });
        }
        xy.u uVar5 = this.f59357c;
        if (uVar5 == null || (radioGroup = uVar5.f80974g) == null) {
            return;
        }
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.transsion.usercenter.laboratory.e0
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup4, int i11) {
                LabStreamingDialog.r0(this.f59376a, radioGroup4, i11);
            }
        });
    }
}
