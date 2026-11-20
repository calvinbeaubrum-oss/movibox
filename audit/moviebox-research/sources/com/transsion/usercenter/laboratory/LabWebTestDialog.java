package com.transsion.usercenter.laboratory;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Toast;
import com.transsion.baselib.report.launch.RoomAppMMKV;
import com.transsion.baseui.dialog.BaseDialog;
import com.transsion.usercenter.R$layout;
import com.transsion.usercenter.R$style;
import com.transsion.web.api.WebPageIdentity;
import kotlin.Metadata;
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
public final class LabWebTestDialog extends BaseDialog {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f59359c = new a(null);

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public LabWebTestDialog() {
        super(R$layout.dialog_lab_web);
    }

    public static final void n0(xy.v viewBinding, LabWebTestDialog this$0, View view) {
        Intrinsics.g(viewBinding, "$viewBinding");
        Intrinsics.g(this$0, "this$0");
        Editable text = viewBinding.f80977c.getText();
        String string = text != null ? text.toString() : null;
        if (string == null || string.length() == 0) {
            Toast.makeText(this$0.getContext(), "url is empty", 1).show();
            return;
        }
        RoomAppMMKV.f51271a.a().putString("key_web_test_url", string);
        com.alibaba.android.arouter.launcher.a.d().b(WebPageIdentity.WEB_VIEW).withString("url", string).navigation();
        this$0.dismiss();
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
        final xy.v vVarA = xy.v.a(view);
        Intrinsics.f(vVarA, "bind(view)");
        String string = RoomAppMMKV.f51271a.a().getString("key_web_test_url", "");
        vVarA.f80977c.setText(string != null ? string : "");
        vVarA.f80976b.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.laboratory.f0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LabWebTestDialog.n0(vVarA, this, view2);
            }
        });
    }
}
