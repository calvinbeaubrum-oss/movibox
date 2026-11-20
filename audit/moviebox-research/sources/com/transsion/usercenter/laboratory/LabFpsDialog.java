package com.transsion.usercenter.laboratory;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.transsion.baselib.report.launch.RoomAppMMKV;
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
public final class LabFpsDialog extends BaseDialog {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public xy.o f59348c;

    public LabFpsDialog() {
        super(R$layout.dialog_lab_fps_layout);
    }

    public static final void p0(LabFpsDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    public static final void q0(LabFpsDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    public static final void r0(RadioGroup radioGroup, int i11) {
        if (i11 == R$id.radioButtonFpsOpen) {
            zp.b.f82110a.e("show fps");
            RoomAppMMKV.f51271a.a().putString("debug_fps", "open");
        } else if (i11 == R$id.radioButtonFpsClose) {
            zp.b.f82110a.e("dismiss fps");
            RoomAppMMKV.f51271a.a().putString("debug_fps", CampaignEx.JSON_NATIVE_VIDEO_CLOSE);
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
        this.f59348c = xy.o.a(view);
        if (getActivity() != null) {
            if (Intrinsics.b(RoomAppMMKV.f51271a.a().getString("debug_fps", ""), "open")) {
                xy.o oVar = this.f59348c;
                if (oVar != null && (radioGroup3 = oVar.f80887g) != null) {
                    radioGroup3.check(R$id.radioButtonFpsOpen);
                }
            } else {
                xy.o oVar2 = this.f59348c;
                if (oVar2 != null && (radioGroup2 = oVar2.f80887g) != null) {
                    radioGroup2.check(R$id.radioButtonFpsClose);
                }
            }
        }
        xy.o oVar3 = this.f59348c;
        if (oVar3 != null && (button2 = oVar3.f80883b) != null) {
            button2.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.laboratory.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    LabFpsDialog.p0(this.f59384a, view2);
                }
            });
        }
        xy.o oVar4 = this.f59348c;
        if (oVar4 != null && (button = oVar4.f80884c) != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.laboratory.j
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    LabFpsDialog.q0(this.f59386a, view2);
                }
            });
        }
        xy.o oVar5 = this.f59348c;
        if (oVar5 == null || (radioGroup = oVar5.f80887g) == null) {
            return;
        }
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.transsion.usercenter.laboratory.k
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup4, int i11) {
                LabFpsDialog.r0(radioGroup4, i11);
            }
        });
    }
}
