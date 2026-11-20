package com.transsion.usercenter;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.tn.lib.widget.toast.core.h;
import com.transsion.usercenter.ProfileEditNicknameDialog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

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
public final class ProfileEditNicknameDialog extends DialogFragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f59284a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public EditText f59285b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function1<? super String, Unit> f59286c = new Function1<String, Unit>() { // from class: com.transsion.usercenter.ProfileEditNicknameDialog$callback$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.f68710a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String it) {
            Intrinsics.g(it, "it");
        }
    };

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f59287d = "";

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements com.transsion.usercenter.a.InterfaceC0609a {
        public a() {
        }

        @Override // com.transsion.usercenter.a.InterfaceC0609a
        public void a() {
            h.f50034a.a(ProfileEditNicknameDialog.this.getString(R$string.profile_edit_nickname_tip));
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b extends wy.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ EditText f59290b;

        public b(EditText editText) {
            this.f59290b = editText;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TextView textView = ProfileEditNicknameDialog.this.f59284a;
            if (textView == null) {
                return;
            }
            textView.setText(this.f59290b.getText().length() + "/30");
        }
    }

    public static final boolean m0(ProfileEditNicknameDialog this$0, TextView textView, int i11, KeyEvent keyEvent) {
        Intrinsics.g(this$0, "this$0");
        if (i11 != 6) {
            return false;
        }
        this$0.dismissAllowingStateLoss();
        EditText editText = this$0.f59285b;
        this$0.k0(String.valueOf(editText != null ? editText.getText() : null));
        return true;
    }

    public static final void n0(ProfileEditNicknameDialog this$0) {
        Intrinsics.g(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        InputMethodManager inputMethodManager = (InputMethodManager) (activity != null ? activity.getSystemService("input_method") : null);
        EditText editText = this$0.f59285b;
        if (editText != null) {
            editText.requestFocus();
        }
        if (inputMethodManager != null) {
            inputMethodManager.showSoftInput(this$0.f59285b, 0);
        }
    }

    public static final void o0(ProfileEditNicknameDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        EditText editText = this$0.f59285b;
        if (editText != null) {
            editText.setText("");
        }
    }

    public final void k0(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f59286c.invoke(StringsKt__StringsKt.Z0(str).toString());
    }

    public final void l0(View view) {
        EditText editText = (EditText) view.findViewById(R$id.etNickname);
        editText.setText(this.f59287d);
        com.transsion.usercenter.a aVar = new com.transsion.usercenter.a(30);
        aVar.a(new a());
        editText.setFilters(new com.transsion.usercenter.a[]{aVar});
        editText.addTextChangedListener(new b(editText));
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: wy.m
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i11, KeyEvent keyEvent) {
                return ProfileEditNicknameDialog.m0(this.f79761a, textView, i11, keyEvent);
            }
        });
        editText.setSelection(editText.getText().length());
        this.f59285b = editText;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.g(inflater, "inflater");
        return inflater.inflate(R$layout.profile_edit_nickname_dialog, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: wy.k
            @Override // java.lang.Runnable
            public final void run() {
                ProfileEditNicknameDialog.n0(this.f79759a);
            }
        }, 100L);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        Intrinsics.f(attributes, "it.attributes");
        attributes.gravity = 80;
        attributes.width = -1;
        window.setAttributes(attributes);
        window.setBackgroundDrawable(new ColorDrawable(0));
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        TextView textView;
        Intrinsics.g(view, "view");
        super.onViewCreated(view, bundle);
        this.f59284a = (TextView) view.findViewById(R$id.tvCount);
        if (!TextUtils.isEmpty(this.f59287d) && (textView = this.f59284a) != null) {
            textView.setText(this.f59287d.length() + "/30");
        }
        ((ImageView) view.findViewById(R$id.ivClear)).setOnClickListener(new View.OnClickListener() { // from class: wy.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ProfileEditNicknameDialog.o0(this.f79760a, view2);
            }
        });
        l0(view);
    }
}
