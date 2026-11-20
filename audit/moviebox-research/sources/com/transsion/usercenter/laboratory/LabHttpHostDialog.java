package com.transsion.usercenter.laboratory;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mmkv.MMKV;
import com.tn.lib.net.dns.or.CacheIpPool;
import com.transsion.baseui.dialog.BaseDialog;
import com.transsion.usercenter.R$layout;
import com.transsion.usercenter.R$style;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

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
public final class LabHttpHostDialog extends BaseDialog implements View.OnClickListener {
    public LabHttpHostDialog() {
        super(R$layout.dialog_lab_http_host);
    }

    public static final void q0(LabHttpHostDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.dismiss();
    }

    public static final void r0(xy.p viewBinding, LabHttpHostDialog this$0, View view) {
        Intrinsics.g(viewBinding, "$viewBinding");
        Intrinsics.g(this$0, "this$0");
        Editable text = viewBinding.f80903d.getText();
        if (text == null || text.length() == 0) {
            zp.b.f82110a.e("text is null~");
        } else {
            this$0.t0(text.toString());
            this$0.dismiss();
        }
    }

    public static final void s0(LabHttpHostDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        Toast.makeText(this$0.getContext(), "reset success", 1).show();
        this$0.t0("");
        this$0.dismiss();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.e(view, "null cannot be cast to non-null type android.widget.TextView");
        t0(((TextView) view).getText().toString());
        dismiss();
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
        final xy.p pVarA = xy.p.a(view);
        Intrinsics.f(pVarA, "bind(view)");
        pVarA.f80910l.setText(CacheIpPool.f49384a.g());
        pVarA.f80901b.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.laboratory.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LabHttpHostDialog.q0(this.f59389a, view2);
            }
        });
        pVarA.f80902c.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.laboratory.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LabHttpHostDialog.r0(pVarA, this, view2);
            }
        });
        pVarA.f80904f.setOnClickListener(this);
        pVarA.f80905g.setOnClickListener(this);
        pVarA.f80906h.setOnClickListener(this);
        pVarA.f80907i.setOnClickListener(this);
        pVarA.f80908j.setOnClickListener(this);
        pVarA.f80909k.setOnClickListener(this);
        pVarA.f80911m.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.laboratory.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LabHttpHostDialog.s0(this.f59393a, view2);
            }
        });
    }

    public final boolean p0(String str) {
        return new Regex("^((?=[a-zA-Z0-9-]{1,63}\\.)(xn--)?[a-zA-Z0-9]+(-[a-zA-Z0-9]+)*\\.)+[a-zA-Z]{2,6}(:\\d{1,5})?$").matches(str);
    }

    public final void t0(String str) {
        if (!TextUtils.isEmpty(str) && !p0(str)) {
            Toast.makeText(getContext(), str + "\" invalidate,please fix", 1).show();
            return;
        }
        Toast.makeText(getContext(), "set \"" + str + "\" success", 1).show();
        MMKV mmkvC = ip.a.f67589a.c();
        if (mmkvC != null) {
            mmkvC.putString("mock_host_key", str);
        }
    }
}
