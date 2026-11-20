package com.transsion.baselib.utils;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.UtilsTransActivity;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class ActivityPermissionUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ActivityPermissionUtil f51294a = new ActivityPermissionUtil();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Function0<Unit> f51295b;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class PermissionTransActivityImpl extends UtilsTransActivity.TransActivityDelegate {
        private static final String ACTION = "extra_action";
        private static final String ACTION_2 = "extra_action2";
        private static final String REQUEST_CODE = "extra_request_code";
        public static final a Companion = new a(null);
        private static final Lazy<PermissionTransActivityImpl> instance$delegate = LazyKt__LazyJVMKt.b(new Function0<PermissionTransActivityImpl>() { // from class: com.transsion.baselib.utils.ActivityPermissionUtil$PermissionTransActivityImpl$Companion$instance$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ActivityPermissionUtil.PermissionTransActivityImpl invoke() {
                return new ActivityPermissionUtil.PermissionTransActivityImpl();
            }
        });

        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class a {
            public a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public static final void d(String action, String str, int i11, Intent intent) {
                Intrinsics.g(action, "$action");
                intent.putExtra(PermissionTransActivityImpl.ACTION, action);
                intent.putExtra(PermissionTransActivityImpl.ACTION_2, str);
                intent.putExtra(PermissionTransActivityImpl.REQUEST_CODE, i11);
            }

            public final PermissionTransActivityImpl b() {
                return (PermissionTransActivityImpl) PermissionTransActivityImpl.instance$delegate.getValue();
            }

            public final void c(final String action, final String str, final int i11) {
                Intrinsics.g(action, "action");
                UtilsTransActivity.M(new Utils.b() { // from class: com.transsion.baselib.utils.a
                    @Override // com.blankj.utilcode.util.Utils.b
                    public final void accept(Object obj) {
                        ActivityPermissionUtil.PermissionTransActivityImpl.a.d(action, str, i11, (Intent) obj);
                    }
                }, b());
            }
        }

        @Override // com.blankj.utilcode.util.UtilsTransActivity.TransActivityDelegate
        public void onActivityResult(UtilsTransActivity activity, int i11, int i12, Intent intent) {
            Intrinsics.g(activity, "activity");
            activity.finish();
        }

        @Override // com.blankj.utilcode.util.UtilsTransActivity.TransActivityDelegate
        public void onCreated(UtilsTransActivity activity, Bundle bundle) {
            Intrinsics.g(activity, "activity");
            activity.getWindow().addFlags(262160);
            String stringExtra = activity.getIntent().getStringExtra(ACTION);
            String stringExtra2 = activity.getIntent().getStringExtra(ACTION_2);
            int intExtra = activity.getIntent().getIntExtra(REQUEST_CODE, 10000);
            if (stringExtra == null || stringExtra.length() == 0) {
                activity.finish();
                return;
            }
            if (activity.isFinishing() || activity.isDestroyed()) {
                return;
            }
            try {
                activity.startActivityForResult(new Intent(stringExtra, Uri.parse("package:" + activity.getPackageName())), intExtra);
            } catch (Throwable unused) {
                if (stringExtra2 == null || stringExtra2.length() == 0) {
                    activity.finish();
                    return;
                }
                try {
                    activity.startActivityForResult(new Intent(stringExtra2, Uri.parse("package:" + activity.getPackageName())), intExtra);
                } catch (Throwable unused2) {
                    activity.finish();
                }
            }
        }

        @Override // com.blankj.utilcode.util.UtilsTransActivity.TransActivityDelegate
        public void onDestroy(UtilsTransActivity activity) {
            Intrinsics.g(activity, "activity");
            Function0 function0 = ActivityPermissionUtil.f51295b;
            if (function0 != null) {
                function0.invoke();
            }
        }
    }

    public final void c(String action, int i11, Function0<Unit> callback) {
        Intrinsics.g(action, "action");
        Intrinsics.g(callback, "callback");
        d(action, null, i11, callback);
    }

    public final void d(String action, String str, int i11, final Function0<Unit> callback) {
        Intrinsics.g(action, "action");
        Intrinsics.g(callback, "callback");
        f51295b = new Function0<Unit>() { // from class: com.transsion.baselib.utils.ActivityPermissionUtil$requestPermission$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                callback.invoke();
                ActivityPermissionUtil.f51295b = null;
            }
        };
        PermissionTransActivityImpl.Companion.c(action, str, i11);
    }
}
