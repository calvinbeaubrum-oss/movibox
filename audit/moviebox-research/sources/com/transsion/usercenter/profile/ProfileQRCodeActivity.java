package com.transsion.usercenter.profile;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.google.zxing.BarcodeFormat;
import com.gyf.immersionbar.ImmersionBar;
import com.transsion.baselib.utils.ActivityPermissionUtil;
import com.transsion.baseui.activity.BaseNewActivity;
import com.transsion.usercenter.profile.dialog.ProfileCameraPermissionDialog;
import com.transsion.web.api.WebPageIdentity;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
@Route(path = "/profile/qr_code")
@Metadata
public final class ProfileQRCodeActivity extends BaseNewActivity<xy.j> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final a f59542k = new a(null);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final b1.b<String> f59543i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final xn.a f59544j;

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
    public static final class b implements xn.a {
        public b() {
        }

        @Override // xn.a
        public void a(List<? extends com.google.zxing.k> resultPoints) {
            Intrinsics.g(resultPoints, "resultPoints");
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // xn.a
        public void b(xn.c result) {
            Intrinsics.g(result, "result");
            if (result.e() != null) {
                ((xy.j) ProfileQRCodeActivity.this.getMViewBinding()).f80832f.pause();
                String scannedText = result.e();
                ProfileQRCodeActivity profileQRCodeActivity = ProfileQRCodeActivity.this;
                Intrinsics.f(scannedText, "scannedText");
                profileQRCodeActivity.y0(scannedText);
            }
        }
    }

    public ProfileQRCodeActivity() {
        b1.b<String> bVarRegisterForActivityResult = registerForActivityResult(new c1.i(), new b1.a() { // from class: com.transsion.usercenter.profile.n
            @Override // b1.a
            public final void a(Object obj) {
                ProfileQRCodeActivity.B0(this.f59592a, ((Boolean) obj).booleanValue());
            }
        });
        Intrinsics.f(bVarRegisterForActivityResult, "registerForActivityResul…        }\n        }\n    }");
        this.f59543i = bVarRegisterForActivityResult;
        this.f59544j = new b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void B0(ProfileQRCodeActivity this$0, boolean z11) {
        Intrinsics.g(this$0, "this$0");
        if (z11) {
            ((xy.j) this$0.getMViewBinding()).f80832f.resume();
        } else if (Build.VERSION.SDK_INT >= 23) {
            if (this$0.shouldShowRequestPermissionRationale("android.permission.CAMERA")) {
                this$0.C0(false);
            } else {
                this$0.C0(true);
            }
        }
    }

    public static final void x0(ProfileQRCodeActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y0(String str) {
        if (v0().contains(str)) {
            com.transsion.baselib.utils.i.e(str, null, 1, null);
        } else {
            com.alibaba.android.arouter.launcher.a.d().b(WebPageIdentity.WEB_VIEW).withString("url", str + (StringsKt__StringsKt.Q(str, "?", false, 2, null) ? "&" : "?") + "web_unlock_key=web_unlock_value").navigation();
        }
        finish();
    }

    public final void A0() {
        this.f59543i.a("android.permission.CAMERA");
    }

    public final void C0(final boolean z11) {
        ProfileCameraPermissionDialog profileCameraPermissionDialog = new ProfileCameraPermissionDialog();
        profileCameraPermissionDialog.t0(new Function1<Boolean, Unit>() { // from class: com.transsion.usercenter.profile.ProfileQRCodeActivity$showNoPermission$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.f68710a;
            }

            public final void invoke(boolean z12) {
                if (!z12) {
                    this.finish();
                } else if (z11) {
                    this.z0();
                } else {
                    this.A0();
                }
            }
        });
        profileCameraPermissionDialog.j0(this, "ProfileCameraPermissionDialog");
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public String U() {
        return "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void X() {
        ((xy.j) getMViewBinding()).f80829b.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.profile.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProfileQRCodeActivity.x0(this.f59591a, view);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void Y() {
        ((xy.j) getMViewBinding()).f80832f.setDecoderFactory(new xn.n(kotlin.collections.g.o(BarcodeFormat.QR_CODE, BarcodeFormat.CODE_39)));
        ((xy.j) getMViewBinding()).f80832f.initializeFromIntent(getIntent());
        ((xy.j) getMViewBinding()).f80832f.decodeContinuous(this.f59544j);
        ImageView imageView = ((xy.j) getMViewBinding()).f80831d;
        Intrinsics.f(imageView, "mViewBinding.vStatusSpace");
        so.c.e(imageView);
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void Z() {
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public boolean a0() {
        return false;
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void c0() {
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void d0() {
        super.d0();
        u0();
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(128);
        ImmersionBar.with(this).transparentBar().init();
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.activity.BaseNewActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        ((xy.j) getMViewBinding()).f80832f.pause();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.activity.BaseNewActivity, com.transsion.baseui.activity.BaseMusicFloatActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        ((xy.j) getMViewBinding()).f80832f.resume();
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void retryLoadData() {
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public boolean setImmersionStatusBar() {
        return false;
    }

    public final void u0() {
        if (Build.VERSION.SDK_INT >= 23 && z2.a.checkSelfPermission(this, "android.permission.CAMERA") != 0) {
            A0();
        }
    }

    public final List<String> v0() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("oneroom://com.community.oneroom");
        arrayList.add("oneroom://com.community.moviebox");
        arrayList.add("https://v.aoneroom.com");
        arrayList.add("https://h5.aoneroom.com");
        arrayList.add("https://m.mvbrowse.com");
        return arrayList;
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    /* JADX INFO: renamed from: w0, reason: merged with bridge method [inline-methods] */
    public xy.j getViewBinding() {
        xy.j jVarC = xy.j.c(getLayoutInflater());
        Intrinsics.f(jVarC, "inflate(layoutInflater)");
        return jVarC;
    }

    public final void z0() {
        ActivityPermissionUtil.f51294a.c("android.settings.APPLICATION_DETAILS_SETTINGS", 1023, new Function0<Unit>() { // from class: com.transsion.usercenter.profile.ProfileQRCodeActivity$openSettingPermission$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                if (z2.a.checkSelfPermission(this.this$0, "android.permission.CAMERA") == 0) {
                    return;
                }
                this.this$0.C0(true);
            }
        });
    }
}
