package com.transsion.room.fragment;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.transsion.baselib.report.launch.RoomAppMMKV;
import com.transsion.room.R$id;
import com.transsion.room.R$layout;
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
public final class AdultRestrictedDialogFragment extends DialogFragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f57128a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f57129b;

    public AdultRestrictedDialogFragment() {
        super(R$layout.dialog_adult_restricted);
    }

    public static final void i0(AdultRestrictedDialogFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    public static final void j0(AdultRestrictedDialogFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        RoomAppMMKV.f51271a.a().putBoolean("adult_restricted", false);
        this$0.dismiss();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Window window;
        super.onActivityCreated(bundle);
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.setLayout(-1, -2);
        window.setGravity(17);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setCancelable(false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.g(view, "view");
        this.f57128a = (TextView) view.findViewById(R$id.btn_negative);
        this.f57129b = (TextView) view.findViewById(R$id.btn_positive);
        TextView textView = this.f57128a;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.room.fragment.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    AdultRestrictedDialogFragment.i0(this.f57237a, view2);
                }
            });
        }
        TextView textView2 = this.f57129b;
        if (textView2 != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.room.fragment.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    AdultRestrictedDialogFragment.j0(this.f57239a, view2);
                }
            });
        }
    }
}
