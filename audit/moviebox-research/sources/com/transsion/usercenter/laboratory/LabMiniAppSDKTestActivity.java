package com.transsion.usercenter.laboratory;

import android.text.Editable;
import android.view.View;
import android.widget.Toast;
import com.transsion.baselib.report.launch.RoomAppMMKV;
import com.transsion.baseui.activity.BaseNewActivity;
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
public final class LabMiniAppSDKTestActivity extends BaseNewActivity<xy.c> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f59350i = new a(null);

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void r0(LabMiniAppSDKTestActivity this$0, View view) {
        String string;
        String string2;
        Intrinsics.g(this$0, "this$0");
        Editable text = ((xy.c) this$0.getMViewBinding()).f80728c.getText();
        String str = "";
        if (text == null || (string = text.toString()) == null) {
            string = "";
        }
        if (string.length() == 0) {
            Toast.makeText(this$0, "appId is empty", 1).show();
            return;
        }
        RoomAppMMKV roomAppMMKV = RoomAppMMKV.f51271a;
        roomAppMMKV.a().putString("KEY_TEST_MIN_APP_SDK_APP_ID", string);
        Editable text2 = ((xy.c) this$0.getMViewBinding()).f80729d.getText();
        if (text2 != null && (string2 = text2.toString()) != null) {
            str = string2;
        }
        if (str.length() > 0) {
            roomAppMMKV.a().putString("KEY_TEST_MIN_APP_SDK_SCENE_ID", string);
        }
        cs.a.f62808a.c(this$0, string, str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void s0(LabMiniAppSDKTestActivity this$0, View view) {
        String string;
        Intrinsics.g(this$0, "this$0");
        Editable text = ((xy.c) this$0.getMViewBinding()).f80727b.getText();
        if (text == null || (string = text.toString()) == null) {
            string = "";
        }
        if (string.length() == 0) {
            Toast.makeText(this$0, "deeplink is empty", 1).show();
        } else {
            RoomAppMMKV.f51271a.a().putString("KEY_TEST_MIN_APP_SDK_DEEPLINK", string);
            com.transsion.baselib.utils.i.e(string, null, 1, null);
        }
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public String U() {
        return "";
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void X() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void Y() {
        RoomAppMMKV roomAppMMKV = RoomAppMMKV.f51271a;
        String string = roomAppMMKV.a().getString("KEY_TEST_MIN_APP_SDK_APP_ID", "");
        if (string == null) {
            string = "";
        }
        if (string.length() > 0) {
            ((xy.c) getMViewBinding()).f80728c.setText(string);
        }
        String string2 = roomAppMMKV.a().getString("KEY_TEST_MIN_APP_SDK_SCENE_ID", "");
        if (string2 == null) {
            string2 = "";
        }
        if (string2.length() > 0) {
            ((xy.c) getMViewBinding()).f80729d.setText(string2);
        }
        String string3 = roomAppMMKV.a().getString("KEY_TEST_MIN_APP_SDK_DEEPLINK", "");
        String str = string3 != null ? string3 : "";
        if (str.length() > 0) {
            ((xy.c) getMViewBinding()).f80727b.setText(str);
        }
        ((xy.c) getMViewBinding()).f80730f.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.laboratory.v
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LabMiniAppSDKTestActivity.r0(this.f59411a, view);
            }
        });
        ((xy.c) getMViewBinding()).f80731g.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.laboratory.w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LabMiniAppSDKTestActivity.s0(this.f59413a, view);
            }
        });
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void Z() {
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void c0() {
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    /* JADX INFO: renamed from: q0, reason: merged with bridge method [inline-methods] */
    public xy.c getViewBinding() {
        xy.c cVarC = xy.c.c(getLayoutInflater());
        Intrinsics.f(cVarC, "inflate(layoutInflater)");
        return cVarC;
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void retryLoadData() {
    }
}
