package com.transsion.usercenter;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import com.transsion.usercenter.ProfileEditGenderDialog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@SourceDebugExtension
public final class ProfileEditGenderDialog extends DialogFragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function1<? super Integer, Unit> f59282a = new Function1<Integer, Unit>() { // from class: com.transsion.usercenter.ProfileEditGenderDialog$callback$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke(num.intValue());
            return Unit.f68710a;
        }

        public final void invoke(int i11) {
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f59283b;

    public static final void k0(ProfileEditGenderDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.j0(1);
        this$0.dismissAllowingStateLoss();
    }

    public static final void l0(ProfileEditGenderDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.j0(2);
        this$0.dismissAllowingStateLoss();
    }

    public static final void m0(ProfileEditGenderDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.j0(0);
        this$0.dismissAllowingStateLoss();
    }

    public final void j0(int i11) {
        this.f59282a.invoke(Integer.valueOf(i11));
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.g(inflater, "inflater");
        return inflater.inflate(R$layout.profile_edit_gender_dialog, viewGroup, false);
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
        Context context;
        Intrinsics.g(view, "view");
        super.onViewCreated(view, bundle);
        ((TextView) view.findViewById(R$id.tvFemale)).setOnClickListener(new View.OnClickListener() { // from class: wy.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ProfileEditGenderDialog.k0(this.f79756a, view2);
            }
        });
        ((TextView) view.findViewById(R$id.tvMale)).setOnClickListener(new View.OnClickListener() { // from class: wy.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ProfileEditGenderDialog.l0(this.f79757a, view2);
            }
        });
        ((TextView) view.findViewById(R$id.tvNotToSay)).setOnClickListener(new View.OnClickListener() { // from class: wy.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ProfileEditGenderDialog.m0(this.f79758a, view2);
            }
        });
        int i11 = this.f59283b;
        if (i11 > 0) {
            if (i11 != 1) {
                textView = i11 != 2 ? null : (TextView) view.findViewById(R$id.tvMale);
            } else {
                textView = (TextView) view.findViewById(R$id.tvFemale);
            }
            if (textView == null || (context = getContext()) == null) {
                return;
            }
            z2.a.getColor(context, com.tn.lib.widget.R$color.cl32);
        }
    }
}
