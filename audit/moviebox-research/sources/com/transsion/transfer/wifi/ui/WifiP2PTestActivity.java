package com.transsion.transfer.wifi.ui;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import com.transsion.transfer.R$id;
import com.transsion.transfer.R$layout;
import com.transsion.transfer.itransfer.ITransferApi;
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
public final class WifiP2PTestActivity extends AppCompatActivity {
    public static final void O(WifiP2PTestActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        ((ITransferApi) com.alibaba.android.arouter.launcher.a.d().h(ITransferApi.class)).F0(this$0);
    }

    public static final void Q(WifiP2PTestActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        ((ITransferApi) com.alibaba.android.arouter.launcher.a.d().h(ITransferApi.class)).J0(this$0);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_wifi_p2p_test);
        ((AppCompatButton) findViewById(R$id.btnWifiCreate)).setOnClickListener(new View.OnClickListener() { // from class: com.transsion.transfer.wifi.ui.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WifiP2PTestActivity.O(this.f59240a, view);
            }
        });
        ((AppCompatButton) findViewById(R$id.btnWifiConnect)).setOnClickListener(new View.OnClickListener() { // from class: com.transsion.transfer.wifi.ui.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WifiP2PTestActivity.Q(this.f59241a, view);
            }
        });
    }
}
