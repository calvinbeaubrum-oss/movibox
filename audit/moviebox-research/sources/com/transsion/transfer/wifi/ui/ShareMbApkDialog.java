package com.transsion.transfer.wifi.ui;

import android.app.Dialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.lifecycle.v;
import com.blankj.utilcode.util.f0;
import com.google.android.material.imageview.ShapeableImageView;
import com.tn.lib.widget.R$style;
import com.transsion.baseui.dialog.BaseDialog;
import com.transsion.transfer.R$layout;
import com.transsion.transfer.R$string;
import com.transsion.transfer.wifi.qrcode.QrCodeUtil;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k0;

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
public final class ShareMbApkDialog extends BaseDialog {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ky.e f59201c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public qy.a f59202d;

    /* JADX INFO: renamed from: com.transsion.transfer.wifi.ui.ShareMbApkDialog$onViewCreated$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsion.transfer.wifi.ui.ShareMbApkDialog$onViewCreated$1", f = "ShareMbApkDialog.kt", l = {53}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ShareMbApkDialog.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Unit unit;
            ky.e eVar;
            ShapeableImageView shapeableImageView;
            Object objE = kotlin.coroutines.intrinsics.a.e();
            int i11 = this.label;
            if (i11 == 0) {
                ResultKt.b(obj);
                QrCodeUtil qrCodeUtil = QrCodeUtil.f59192a;
                String strB = qrCodeUtil.b(ShareMbApkDialog.this.f59202d);
                int iA = f0.a(240.0f);
                int iA2 = f0.a(240.0f);
                this.label = 1;
                obj = qrCodeUtil.f(strB, iA, iA2, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            Bitmap bitmap = (Bitmap) obj;
            if (bitmap == null || (eVar = ShareMbApkDialog.this.f59201c) == null || (shapeableImageView = eVar.f69689c) == null) {
                unit = null;
            } else {
                shapeableImageView.setImageBitmap(bitmap);
                unit = Unit.f68710a;
            }
            if (unit == null) {
                ShareMbApkDialog shareMbApkDialog = ShareMbApkDialog.this;
                com.transsion.transfer.wifi.util.g.d(com.transsion.transfer.wifi.util.g.f59252a, shareMbApkDialog.g0() + " --> createSuccess() --> syncEncodeQRCode() --> 创建二维码失败了", false, 2, null);
                zp.b.f82110a.e(shareMbApkDialog.getResources().getString(R$string.transfer_fail));
                shareMbApkDialog.dismissAllowingStateLoss();
            }
            return Unit.f68710a;
        }
    }

    public ShareMbApkDialog() {
        super(R$layout.dialog_share_mb_apk_layout);
    }

    public static final void p0(ShareMbApkDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R$style.center_DialogStyle);
        com.transsion.transfer.wifi.util.g.b(com.transsion.transfer.wifi.util.g.f59252a, g0() + " --> onCreate() --> 分享弹窗", false, 2, null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        AppCompatImageView appCompatImageView;
        Window window;
        Window window2;
        Intrinsics.g(view, "view");
        super.onViewCreated(view, bundle);
        Dialog dialog = getDialog();
        if (dialog != null && (window2 = dialog.getWindow()) != null) {
            window2.setLayout(-1, -2);
        }
        Dialog dialog2 = getDialog();
        if (dialog2 != null && (window = dialog2.getWindow()) != null) {
            window.setGravity(17);
        }
        Dialog dialog3 = getDialog();
        if (dialog3 != null) {
            dialog3.setCancelable(false);
        }
        this.f59201c = ky.e.a(view);
        kotlinx.coroutines.j.d(v.a(this), null, null, new AnonymousClass1(null), 3, null);
        py.c.f74067a.n();
        ky.e eVar = this.f59201c;
        if (eVar == null || (appCompatImageView = eVar.f69688b) == null) {
            return;
        }
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.transfer.wifi.ui.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ShareMbApkDialog.p0(this.f59227a, view2);
            }
        });
    }

    public final void q0(qy.a aVar) {
        this.f59202d = aVar;
    }
}
