package com.transsion.usercenter.laboratory;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import com.transsion.baselib.report.launch.RoomAppMMKV;
import com.transsion.baseui.dialog.BaseDialog;
import com.transsion.usercenter.R$layout;
import com.transsion.usercenter.R$style;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@SourceDebugExtension
public final class LabPwdDialog extends BaseDialog {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f59352g = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f59353c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f59354d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function0<Unit> f59355f;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class b implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ xy.t f59356a;

        public b(xy.t tVar) {
            this.f59356a = tVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Editable text = this.f59356a.f80966d.getText();
            if (text == null || text.length() == 0) {
                this.f59356a.f80967f.setErrorEnabled(false);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    public LabPwdDialog() {
        super(R$layout.dialog_lab_pwd);
        this.f59353c = "-321";
        this.f59354d = "031A68C3912D796E235A72EE0BF89C16";
    }

    public static final void o0(LabPwdDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.dismiss();
    }

    public static final void p0(xy.t viewBinding, LabPwdDialog this$0, View view) {
        Intrinsics.g(viewBinding, "$viewBinding");
        Intrinsics.g(this$0, "this$0");
        String lowerCase = viewBinding.f80966d.getText().toString().toLowerCase(Locale.ROOT);
        Intrinsics.f(lowerCase, "toLowerCase(...)");
        if (!com.blankj.utilcode.util.g0.b(com.blankj.utilcode.util.k.b(lowerCase + this$0.f59353c), this$0.f59354d)) {
            viewBinding.f80967f.setErrorEnabled(true);
            viewBinding.f80967f.setError("wrong password");
            return;
        }
        RoomAppMMKV.f51271a.a().putLong("lab_enter_password_time", System.currentTimeMillis());
        Function0<Unit> function0 = this$0.f59355f;
        if (function0 != null) {
            function0.invoke();
        }
        this$0.dismiss();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setCancelable(false);
        setStyle(0, R$style.BaseDialogStyle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.g(view, "view");
        super.onViewCreated(view, bundle);
        final xy.t tVarA = xy.t.a(view);
        Intrinsics.f(tVarA, "bind(view)");
        tVarA.f80967f.setHelperText("input password");
        tVarA.f80964b.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.laboratory.a0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LabPwdDialog.o0(this.f59365a, view2);
            }
        });
        tVarA.f80965c.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.laboratory.b0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LabPwdDialog.p0(tVarA, this, view2);
            }
        });
        tVarA.f80967f.setBoxBackgroundColor(0);
        EditText editText = tVarA.f80966d;
        Intrinsics.f(editText, "viewBinding.etPwd");
        editText.addTextChangedListener(new b(tVarA));
    }

    public final LabPwdDialog q0(Function0<Unit> callback) {
        Intrinsics.g(callback, "callback");
        this.f59355f = callback;
        return this;
    }
}
