package com.transsion.player.longvideo.ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.blankj.utilcode.util.f0;
import com.gyf.immersionbar.BarHide;
import com.gyf.immersionbar.ImmersionBar;
import com.tn.lib.view.SwitchButton;
import com.transsion.baselib.report.launch.RoomAppMMKV;
import com.transsion.baseui.dialog.BaseDialog;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.R$layout;
import com.transsion.videofloat.VideoPipManager;
import com.transsnet.downloader.R$style;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class PlayerSettingDialog extends BaseDialog {
    public static final void n0(PlayerSettingDialog this$0, SwitchButton switchButton, boolean z11) {
        Intrinsics.g(this$0, "this$0");
        RoomAppMMKV.f51271a.a().putBoolean("k_pip_enable", z11);
        this$0.o0(z11);
    }

    public final void o0(boolean z11) {
        Context context = getContext();
        if (context instanceof FragmentActivity) {
            VideoPipManager.Companion companion = VideoPipManager.f60024a;
            if (!companion.a().h() || Build.VERSION.SDK_INT < 31) {
                return;
            }
            VideoPipManager.a.b(companion.a(), (FragmentActivity) context, false, z11, null, 8, null);
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R$style.DownloadBottomDialogTheme);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.g(inflater, "inflater");
        return inflater.inflate(R$layout.dialog_player_setting_layout, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Window window;
        Intrinsics.g(view, "view");
        super.onViewCreated(view, bundle);
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setWindowAnimations(so.c.f() ? com.tn.lib.widget.R$style.ActionSheetDialogLeft : com.tn.lib.widget.R$style.ActionSheetDialogRight);
            window.setGravity(so.c.f() ? GravityCompat.START : GravityCompat.END);
            window.setDimAmount(0.0f);
            window.setBackgroundDrawable(null);
            window.setLayout(f0.a(260.0f), -1);
            ImmersionBar immersionBarWith = ImmersionBar.with((DialogFragment) this);
            immersionBarWith.hideBar(BarHide.FLAG_HIDE_BAR);
            immersionBarWith.init();
        }
        SwitchButton switchButton = (SwitchButton) view.findViewById(R$id.switchBtn);
        switchButton.setChecked(RoomAppMMKV.f51271a.a().getBoolean("k_pip_enable", true));
        switchButton.setOnCheckedChangeListener(new SwitchButton.d() { // from class: com.transsion.player.longvideo.ui.dialog.i
            @Override // com.tn.lib.view.SwitchButton.d
            public final void a(SwitchButton switchButton2, boolean z11) {
                PlayerSettingDialog.n0(this.f54576a, switchButton2, z11);
            }
        });
    }
}
