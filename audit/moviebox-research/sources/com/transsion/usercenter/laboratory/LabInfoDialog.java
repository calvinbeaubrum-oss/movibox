package com.transsion.usercenter.laboratory;

import android.app.Application;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import com.blankj.utilcode.util.Utils;
import com.tencent.mmkv.MMKV;
import com.tn.lib.util.device.TNDeviceHelper;
import com.tn.lib.widget.R$color;
import com.transsion.baseui.dialog.BaseDialog;
import com.transsion.usercenter.R$layout;
import com.transsion.usercenter.R$style;
import com.transsnet.loginapi.ILoginApi;
import com.transsnet.loginapi.bean.UserInfo;
import java.util.Locale;
import java.util.TimeZone;
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
public final class LabInfoDialog extends BaseDialog {
    public LabInfoDialog() {
        super(R$layout.dialog_lab_info);
    }

    public static final void q0(LabInfoDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.dismiss();
    }

    public static final void r0(xy.q viewBinding, LabInfoDialog this$0, View view) {
        Intrinsics.g(viewBinding, "$viewBinding");
        Intrinsics.g(this$0, "this$0");
        com.blankj.utilcode.util.g.a(viewBinding.f80919d.getText().toString());
        Toast.makeText(this$0.getContext(), "copy success", 1).show();
        this$0.dismiss();
    }

    public final up.c o0(int i11, int i12) {
        up.c.a aVarC = up.c.e().e("user_id = ").c(i11);
        UserInfo userInfoP = ((ILoginApi) com.alibaba.android.arouter.launcher.a.d().h(ILoginApi.class)).P();
        up.c.a aVarC2 = aVarC.e((userInfoP != null ? userInfoP.getUserId() : null) + "\n").c(i12).e("device_id = ").c(i11);
        TNDeviceHelper tNDeviceHelper = TNDeviceHelper.f49455a;
        up.c.a aVarC3 = aVarC2.e(tNDeviceHelper.g() + "\n").c(i12).e("version_name = ").c(i11).e(com.blankj.utilcode.util.c.f() + "\n").c(i12).e("version_code = ").c(i11).e(com.blankj.utilcode.util.c.d() + "\n").c(i12).e("os_version = ").c(i11).e(tNDeviceHelper.m() + "\n").c(i12).e("model = ").c(i11).e(tNDeviceHelper.k() + "\n").c(i12).e("install_ch = ").c(i11).e(ip.a.f67589a.a() + "\n").c(i12).e("gaid = ").c(i11).e(tNDeviceHelper.h() + "\n").c(i12).e("net = ").c(i11).e(com.tn.lib.util.networkinfo.f.f49475a.d() + "\n").c(i12).e("region = ").c(i11).e(Locale.getDefault().getCountry() + "\n").c(i12).e("timezone = ").c(i11).e(TimeZone.getDefault().getID() + "\n").c(i12).e("sp_code = ").c(i11).e(p0() + "\n").c(i12).e("channel = ").c(i11);
        fp.b.a aVar = fp.b.f65208a;
        Application applicationA = Utils.a();
        Intrinsics.f(applicationA, "getApp()");
        up.c.a aVarC4 = aVarC3.e(aVar.e(applicationA) + "\n").c(i12).e("package = ").c(i11).e(com.blankj.utilcode.util.c.c() + "\n").c(i12).e("SignatureMD5 = ").c(i11);
        com.transsion.baselib.utils.d dVar = com.transsion.baselib.utils.d.f51308a;
        Application applicationA2 = Utils.a();
        Intrinsics.f(applicationA2, "getApp()");
        up.c.a aVarC5 = aVarC4.e(dVar.a(applicationA2) + "\n").c(i12).e("SignatureSha1 = ").c(i11);
        Application applicationA3 = Utils.a();
        Intrinsics.f(applicationA3, "getApp()");
        up.c.a aVarC6 = aVarC5.e(com.transsion.baselib.utils.d.c(applicationA3) + "\n").c(i12).e("SignatureSHA256 = ").c(i11);
        Application applicationA4 = Utils.a();
        Intrinsics.f(applicationA4, "getApp()");
        up.c cVarB = aVarC6.e(dVar.b(applicationA4) + "\n").c(i12).b();
        Intrinsics.f(cVarB, "builder()\n            .t…or)\n\n            .build()");
        return cVarB;
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
        final xy.q qVarA = xy.q.a(view);
        Intrinsics.f(qVarA, "bind(view)");
        qVarA.f80919d.setText(o0(z2.a.getColor(view.getContext(), R$color.main), z2.a.getColor(view.getContext(), R$color.text_02)));
        qVarA.f80917b.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.laboratory.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LabInfoDialog.q0(this.f59395a, view2);
            }
        });
        qVarA.f80918c.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.laboratory.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LabInfoDialog.r0(qVarA, this, view2);
            }
        });
    }

    public final String p0() {
        String string;
        MMKV mmkvC = ip.a.f67589a.c();
        String str = "";
        if (mmkvC != null && (string = mmkvC.getString("sp_code", "")) != null) {
            str = string;
        }
        return TextUtils.isEmpty(str) ? TNDeviceHelper.f49455a.n() : str;
    }
}
