package com.transsion.postdetail.ui.interceptor;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.applovin.sdk.AppLovinEventTypes;
import com.blankj.utilcode.util.Utils;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpHost;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.videofloat.VideoPipManager;
import com.transsnet.downloader.R$string;
import com.transsnet.downloader.manager.DownloadEsHelper;
import com.transsnet.downloader.util.DownloadUtil;
import com.transsnet.downloader.util.LocalVideoNotExistUtil;
import java.io.File;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.l;
import kotlinx.coroutines.j;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.w0;
import uo.b;

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
/* JADX INFO: loaded from: classes.dex */
@Interceptor(name = "LocalVideoDetailInterceptor", priority = 1)
@Metadata
public final class LocalVideoDetailInterceptor implements IInterceptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f55949a = new a(null);

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.transsion.postdetail.ui.interceptor.LocalVideoDetailInterceptor$process$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    @DebugMetadata(c = "com.transsion.postdetail.ui.interceptor.LocalVideoDetailInterceptor$process$1", f = "LocalVideoDetailInterceptor.kt", l = {ModuleDescriptor.MODULE_VERSION}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
        final /* synthetic */ InterceptorCallback $callback;
        final /* synthetic */ Postcard $postcard;
        final /* synthetic */ String $resourceId;
        final /* synthetic */ String $subjectId;
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ LocalVideoDetailInterceptor this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str, LocalVideoDetailInterceptor localVideoDetailInterceptor, Postcard postcard, InterceptorCallback interceptorCallback, String str2, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$resourceId = str;
            this.this$0 = localVideoDetailInterceptor;
            this.$postcard = postcard;
            this.$callback = interceptorCallback;
            this.$subjectId = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$resourceId, this.this$0, this.$postcard, this.$callback, this.$subjectId, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            String str;
            String str2;
            Object objE = kotlin.coroutines.intrinsics.a.e();
            int i11 = this.label;
            if (i11 == 0) {
                ResultKt.b(obj);
                str = this.$resourceId;
                if (str != null) {
                    String str3 = this.$subjectId;
                    DownloadEsHelper downloadEsHelperA = DownloadEsHelper.f60994m.a();
                    this.L$0 = str;
                    this.L$1 = str3;
                    this.label = 1;
                    Object objK = downloadEsHelperA.k(str, this);
                    if (objK == objE) {
                        return objE;
                    }
                    str2 = str3;
                    obj = objK;
                }
                this.this$0.B1(this.$postcard, this.$callback);
                return Unit.f68710a;
            }
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            str2 = (String) this.L$1;
            str = (String) this.L$0;
            ResultKt.b(obj);
            DownloadBean downloadBean = (DownloadBean) obj;
            if (downloadBean != null && DownloadUtil.f61136a.c(downloadBean)) {
                b.f78622a.c("Download_LocalVideoDetailInterceptor", "---文件不存在或者下载进度相差10M的重新下载,resourceId:" + str + ", subjectId:" + str2, true);
                downloadBean.setReDownload(true);
            }
            this.this$0.B1(this.$postcard, this.$callback);
            return Unit.f68710a;
        }
    }

    public final boolean A1(String str, String str2) {
        if (str == null) {
            File file = new File(str2);
            if (file.exists() && file.length() > 0) {
                return true;
            }
        } else {
            if (l.L(str2, AppLovinEventTypes.USER_VIEWED_CONTENT, false, 2, null)) {
                l3.a aVarG = l3.a.g(Utils.a(), Uri.parse(str2));
                if (aVarG != null) {
                    return aVarG.e();
                }
                return true;
            }
            File file2 = new File(str2);
            if (file2.exists() && file2.length() > 0) {
                return true;
            }
        }
        return false;
    }

    public final void B1(Postcard postcard, InterceptorCallback interceptorCallback) {
        try {
            int i11 = postcard.getExtras().getInt("subject_type", -1);
            if (i11 < 0) {
                String queryParameter = postcard.getUri().getQueryParameter("subject_type");
                i11 = queryParameter != null ? Integer.parseInt(queryParameter) : -1;
            }
            if (i11 == SubjectType.SHORT_TV.getValue()) {
                com.alibaba.android.arouter.launcher.a.d().b("/shorts/detail").with(postcard.getExtras()).navigation(postcard.getContext());
                if (interceptorCallback != null) {
                    interceptorCallback.onInterrupt(new RuntimeException("local video intercept to shortTV"));
                    return;
                }
                return;
            }
            b.a.j(b.f78622a, "VideoFloat", LocalVideoDetailInterceptor.class.getSimpleName() + " open page ----2", false, 4, null);
            if (interceptorCallback != null) {
                interceptorCallback.onContinue(postcard);
            }
        } catch (Throwable unused) {
            if (interceptorCallback != null) {
                interceptorCallback.onContinue(postcard);
            }
        }
    }

    @Override // com.alibaba.android.arouter.facade.template.IProvider
    public void init(Context context) {
    }

    @Override // com.alibaba.android.arouter.facade.template.IInterceptor
    public void process(Postcard postcard, InterceptorCallback interceptorCallback) {
        String path;
        if (!Intrinsics.b(postcard != null ? postcard.getPath() : null, "/video/detail")) {
            if (!Intrinsics.b(postcard != null ? postcard.getPath() : null, "/shorts/detail")) {
                if (interceptorCallback != null) {
                    interceptorCallback.onContinue(postcard);
                    return;
                }
                return;
            }
            VideoPipManager.a.a(VideoPipManager.f60024a.a(), false, 1, null);
            Bundle extras = postcard.getExtras();
            Serializable serializable = extras.getSerializable("item_object");
            Subject subject = serializable instanceof Subject ? (Subject) serializable : null;
            String string = subject == null ? extras.getString("id") : subject.getSubjectId();
            int i11 = extras.getInt("ep");
            int i12 = extras.getInt("extra_series_position", -1);
            if (string == null) {
                if (interceptorCallback != null) {
                    interceptorCallback.onContinue(postcard);
                    return;
                }
                return;
            }
            DownloadBean downloadBeanS = DownloadEsHelper.f60994m.a().s(string, i11);
            if ((downloadBeanS != null ? downloadBeanS.getPath() : null) == null || !downloadBeanS.isCompleted()) {
                if (interceptorCallback != null) {
                    interceptorCallback.onContinue(postcard);
                    return;
                }
                return;
            }
            String resourceId = downloadBeanS.getResourceId();
            String path2 = downloadBeanS.getPath();
            Intrinsics.d(path2);
            if (A1(resourceId, path2)) {
                if (interceptorCallback != null) {
                    interceptorCallback.onContinue(postcard);
                    return;
                }
                return;
            } else {
                LocalVideoNotExistUtil localVideoNotExistUtil = LocalVideoNotExistUtil.f61140a;
                Context context = postcard.getContext();
                Intrinsics.f(context, "postcard.context");
                localVideoNotExistUtil.n(context, downloadBeanS, i12);
                return;
            }
        }
        VideoPipManager.a.a(VideoPipManager.f60024a.a(), false, 1, null);
        Bundle extras2 = postcard.getExtras();
        String string2 = extras2.getString("extra_url");
        String string3 = extras2.getString("extra_subject_id");
        if (string3 == null) {
            string3 = "";
        }
        String string4 = extras2.getString("extra_local_path");
        String string5 = extras2.getString("extra_resource_id");
        boolean z11 = extras2.getBoolean("extra_is_series");
        int i13 = extras2.getInt("extra_series_position", -1);
        boolean z12 = extras2.getBoolean("extra_completed", true);
        if (extras2.getBoolean("extra_from_deeplink", false)) {
            if (interceptorCallback != null) {
                interceptorCallback.onContinue(postcard);
                return;
            }
            return;
        }
        if (string5 != null) {
            DownloadBean downloadBeanL = DownloadEsHelper.f60994m.a().l(string5);
            if (downloadBeanL != null && (path = downloadBeanL.getPath()) != null) {
                string4 = path;
            }
            extras2.putString("extra_local_path", string4);
        }
        b.a aVar = b.f78622a;
        aVar.c("Download_LocalVideoDetailInterceptor", "isDownloadCompleted  = " + z12 + "， path = " + string4, true);
        boolean z13 = (string2 == null || l.L(string2, HttpHost.DEFAULT_SCHEME_NAME, false, 2, null) || string3.length() != 0) ? false : true;
        if (string4 == null || string4.length() <= 0) {
            b.a.f(aVar, "Download_LocalVideoDetailInterceptor", "file is error, show error dialog, ", false, 4, null);
            LocalVideoNotExistUtil localVideoNotExistUtil2 = LocalVideoNotExistUtil.f61140a;
            Context context2 = postcard.getContext();
            Intrinsics.f(context2, "postcard.context");
            Intrinsics.d(string5);
            localVideoNotExistUtil2.o(context2, string5, string4, z11, i13);
            return;
        }
        boolean zA1 = A1(string5, string4);
        if (!z12) {
            b.a.f(aVar, "Download_LocalVideoDetailInterceptor", "downloading play, open page", false, 4, null);
            j.d(l0.a(w0.b()), null, null, new AnonymousClass1(string5, this, postcard, interceptorCallback, string3, null), 3, null);
            return;
        }
        if (zA1) {
            b.a.f(aVar, "Download_LocalVideoDetailInterceptor", "open page", false, 4, null);
            B1(postcard, interceptorCallback);
            return;
        }
        b.a.f(aVar, "Download_LocalVideoDetailInterceptor", "file is error, show error dialog, c, isOutside = " + z13, false, 4, null);
        if (z13) {
            zp.b.f82110a.d(R$string.download_no_local_file_tips);
            return;
        }
        LocalVideoNotExistUtil localVideoNotExistUtil3 = LocalVideoNotExistUtil.f61140a;
        Context context3 = postcard.getContext();
        Intrinsics.f(context3, "postcard.context");
        Intrinsics.d(string5);
        localVideoNotExistUtil3.o(context3, string5, string4, z11, i13);
    }
}
