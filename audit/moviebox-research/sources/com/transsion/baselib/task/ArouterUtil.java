package com.transsion.baselib.task;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.transsion.commercializationapi.ITaskCenterApi;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import ss.b;

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
public final class ArouterUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ArouterUtil f51292a = new ArouterUtil();

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.transsion.baselib.task.a f51293a;

        public a(com.transsion.baselib.task.a aVar) {
            this.f51293a = aVar;
        }

        @Override // ss.b
        public void a(boolean z11) {
            b.a.a(this, z11);
        }

        @Override // ss.b
        public void onFail() {
            com.transsion.baselib.task.a aVar = this.f51293a;
            if (aVar != null) {
                aVar.a(false);
            }
        }

        @Override // ss.b
        public void onSuccess() {
            com.transsion.baselib.task.a aVar = this.f51293a;
            if (aVar != null) {
                aVar.a(true);
            }
        }
    }

    public static /* synthetic */ void c(ArouterUtil arouterUtil, Context context, String str, com.transsion.baselib.task.a aVar, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            aVar = null;
        }
        arouterUtil.b(context, str, aVar);
    }

    public final boolean a(String str) {
        return TextUtils.equals("/common/dialog", Uri.parse(str).getQueryParameter("type"));
    }

    public final void b(Context context, String deeplink, com.transsion.baselib.task.a aVar) {
        Intrinsics.g(context, "context");
        Intrinsics.g(deeplink, "deeplink");
        if (TextUtils.isEmpty(deeplink)) {
            return;
        }
        if (a(deeplink)) {
            if (context instanceof FragmentActivity) {
                d((FragmentActivity) context, deeplink, aVar);
            }
        } else {
            try {
                Result.Companion companion = Result.Companion;
                Result.m163constructorimpl(com.alibaba.android.arouter.launcher.a.d().a(Uri.parse(deeplink)).navigation());
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                Result.m163constructorimpl(ResultKt.a(th2));
            }
        }
    }

    public final void d(FragmentActivity fragmentActivity, String str, final com.transsion.baselib.task.a aVar) {
        String queryParameter = Uri.parse(str).getQueryParameter("name");
        if (Intrinsics.b(queryParameter, "MemberPageVideoTaskDialog")) {
            ((ITaskCenterApi) com.alibaba.android.arouter.launcher.a.d().h(ITaskCenterApi.class)).u0(fragmentActivity, new Function1<Boolean, Unit>() { // from class: com.transsion.baselib.task.ArouterUtil$showDialog$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.f68710a;
                }

                public final void invoke(boolean z11) {
                    a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.a(z11);
                    }
                }
            });
            return;
        }
        if (Intrinsics.b(queryParameter, "DownloadInterceptDialog")) {
            ((ITaskCenterApi) com.alibaba.android.arouter.launcher.a.d().h(ITaskCenterApi.class)).h(new a(aVar));
            return;
        }
        uo.b.a.j(uo.b.f78622a, "cm_dialog", "name = " + queryParameter + " --> 没有匹配到", false, 4, null);
    }
}
