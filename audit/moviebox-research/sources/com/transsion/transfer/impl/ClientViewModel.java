package com.transsion.transfer.impl;

import android.app.Application;
import android.os.Environment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.c0;
import androidx.lifecycle.u0;
import com.blankj.utilcode.util.Utils;
import com.transsion.transfer.impl.client.TransferClient;
import com.transsion.transfer.impl.entity.FileData;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.w0;

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
public final class ClientViewModel extends androidx.lifecycle.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Application f58915b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c0<Boolean> f58916c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final oy.b<List<FileData>> f58917d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final oy.b<Integer> f58918f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final oy.b<Pair<String, Triple<TaskState, Long, Long>>> f58919g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final oy.b<String> f58920h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f58921i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final a f58922j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final b f58923k;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Function3<String, Boolean, String, Unit> {
        public a() {
        }

        public void a(String str, boolean z11, String str2) {
            ClientViewModel.this.f58921i = str;
            ClientViewModel.this.f58916c.n(Boolean.valueOf(z11));
            if (z11) {
                return;
            }
            py.b.f74066a.j(str2, TransferClient.f58969t.h());
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(String str, Boolean bool, String str2) {
            a(str, bool.booleanValue(), str2);
            return Unit.f68710a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements com.transsion.transfer.impl.b {
        public b() {
        }

        @Override // com.transsion.transfer.impl.b
        public void L(String remoteFilePath, long j11, long j12) {
            Intrinsics.g(remoteFilePath, "remoteFilePath");
            ClientViewModel.this.f58919g.n(new Pair(remoteFilePath, new Triple(TaskState.TRANSFERRING, Long.valueOf(j11), Long.valueOf(j12))));
        }

        @Override // com.transsion.transfer.impl.b
        public void R(String remoteFilePath, TaskState state, long j11, long j12, long j13, String str) {
            Intrinsics.g(remoteFilePath, "remoteFilePath");
            Intrinsics.g(state, "state");
            if (state == TaskState.CONNECTING) {
                py.b.f74066a.h(remoteFilePath, j12, TransferClient.f58969t.h());
            } else if (state == TaskState.FINISH) {
                py.b.f74066a.g(remoteFilePath, true, null, j12, j13, TransferClient.f58969t.h());
            } else if (state == TaskState.ERROR || state == TaskState.NO_FILE) {
                py.b.f74066a.g(remoteFilePath, false, "file no found", j11, j13, TransferClient.f58969t.h());
            }
            ClientViewModel.this.f58919g.n(new Pair(remoteFilePath, new Triple(state, Long.valueOf(j11), Long.valueOf(j12))));
        }

        @Override // com.transsion.transfer.impl.b
        public void Y() {
            ClientViewModel.this.f58916c.n(Boolean.FALSE);
            py.b.f74066a.j("normal", TransferClient.f58969t.h());
        }

        @Override // com.transsion.transfer.impl.b
        public void l(int i11) {
            ClientViewModel.this.f58918f.n(Integer.valueOf(i11));
        }

        @Override // com.transsion.transfer.impl.b
        public void z(String remoteFilePath) {
            Intrinsics.g(remoteFilePath, "remoteFilePath");
            ClientViewModel.this.f58919g.n(new Pair(remoteFilePath, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClientViewModel(Application application) {
        super(application);
        Intrinsics.g(application, "application");
        this.f58915b = application;
        this.f58916c = new c0<>();
        this.f58917d = new oy.b<>();
        this.f58918f = new oy.b<>();
        this.f58919g = new oy.b<>();
        this.f58920h = new oy.b<>();
        this.f58922j = new a();
        this.f58923k = new b();
    }

    public final void h(final Function2<? super Boolean, ? super String, Unit> function2) {
        TransferClient.Companion companion = TransferClient.f58969t;
        if (!companion.d()) {
            if (function2 != null) {
                function2.invoke(Boolean.FALSE, "no connect info");
            }
        } else {
            com.transsion.transfer.impl.a aVarF = companion.f();
            aVarF.k(this.f58923k);
            aVarF.b(this.f58922j);
            aVarF.d(new Function2<Boolean, String, Unit>() { // from class: com.transsion.transfer.impl.ClientViewModel$connect$2

                /* JADX INFO: renamed from: com.transsion.transfer.impl.ClientViewModel$connect$2$1, reason: invalid class name */
                /* JADX INFO: compiled from: source.java */
                @Metadata
                @DebugMetadata(c = "com.transsion.transfer.impl.ClientViewModel$connect$2$1", f = "ClientViewModel.kt", l = {}, m = "invokeSuspend")
                public static final class AnonymousClass1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
                    final /* synthetic */ Function2<Boolean, String, Unit> $callback;
                    final /* synthetic */ String $error;
                    final /* synthetic */ boolean $res;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    public AnonymousClass1(Function2<? super Boolean, ? super String, Unit> function2, boolean z11, String str, Continuation<? super AnonymousClass1> continuation) {
                        super(2, continuation);
                        this.$callback = function2;
                        this.$res = z11;
                        this.$error = str;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new AnonymousClass1(this.$callback, this.$res, this.$error, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
                        return ((AnonymousClass1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) throws Throwable {
                        kotlin.coroutines.intrinsics.a.e();
                        if (this.label != 0) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.b(obj);
                        Function2<Boolean, String, Unit> function2 = this.$callback;
                        if (function2 != null) {
                            function2.invoke(Boxing.a(this.$res), this.$error);
                        }
                        return Unit.f68710a;
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, String str) {
                    invoke(bool.booleanValue(), str);
                    return Unit.f68710a;
                }

                public final void invoke(boolean z11, String error) {
                    Intrinsics.g(error, "error");
                    this.this$0.f58916c.n(Boolean.valueOf(z11));
                    kotlinx.coroutines.j.d(u0.a(this.this$0), w0.c(), null, new AnonymousClass1(function2, z11, error, null), 2, null);
                }
            });
        }
    }

    public final File i() {
        return new File(Utils.a().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS), "transfer");
    }

    public final LiveData<Integer> j() {
        return this.f58918f;
    }

    public final LiveData<Boolean> k() {
        return this.f58916c;
    }

    public final String l() {
        TransferClient.Companion companion = TransferClient.f58969t;
        if (!companion.d()) {
            return "";
        }
        com.transsion.transfer.impl.a aVarF = companion.f();
        aVarF.k(this.f58923k);
        aVarF.b(this.f58922j);
        String strJ = aVarF.j();
        if (strJ != null) {
            this.f58921i = strJ;
        }
        return strJ;
    }

    public final LiveData<String> m() {
        return this.f58920h;
    }

    public final int n() {
        return ry.a.f75766a.e().size();
    }

    public final void o(boolean z11) {
        ry.a aVar = ry.a.f75766a;
        if (!aVar.h() && !z11) {
            this.f58917d.n(aVar.d());
            return;
        }
        TransferClient.Companion companion = TransferClient.f58969t;
        if (companion.d()) {
            py.b.f74066a.i(companion.h());
            com.transsion.transfer.impl.a aVarF = companion.f();
            aVarF.k(this.f58923k);
            aVarF.b(this.f58922j);
            String absolutePath = i().getAbsolutePath();
            Intrinsics.f(absolutePath, "getCacheRootFile().absolutePath");
            aVarF.e(absolutePath, new Function2<List<FileData>, Exception, Unit>() { // from class: com.transsion.transfer.impl.ClientViewModel$getTransferList$2
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(List<FileData> list, Exception exc) {
                    invoke2(list, exc);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(List<FileData> list, Exception exc) {
                    if (exc == null) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("getTransferList: ");
                        sb2.append(list);
                        this.this$0.f58917d.n(list);
                        return;
                    }
                    exc.printStackTrace();
                    String message = exc.getMessage();
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("getTransferList error: ");
                    sb3.append(message);
                    sb3.append(" ");
                }
            });
        }
    }

    @Override // androidx.lifecycle.t0
    public void onCleared() {
        super.onCleared();
        TransferClient.Companion companion = TransferClient.f58969t;
        if (companion.d()) {
            com.transsion.transfer.impl.a aVarF = companion.f();
            aVarF.g(this.f58923k);
            aVarF.b(null);
        }
    }

    public final LiveData<List<FileData>> p() {
        return this.f58917d;
    }

    public final LiveData<Pair<String, Triple<TaskState, Long, Long>>> q() {
        return this.f58919g;
    }

    public final int r() {
        ry.a aVar = ry.a.f75766a;
        return aVar.f().size() + aVar.g().size();
    }

    public final boolean s() {
        TransferClient.Companion companion = TransferClient.f58969t;
        if (!companion.d()) {
            return false;
        }
        com.transsion.transfer.impl.a aVarF = companion.f();
        aVarF.k(this.f58923k);
        aVarF.b(this.f58922j);
        return aVarF.h();
    }

    public final void t(FileData fileData) {
        Intrinsics.g(fileData, "fileData");
        TransferClient.Companion companion = TransferClient.f58969t;
        if (companion.d()) {
            com.transsion.transfer.impl.a aVarF = companion.f();
            aVarF.k(this.f58923k);
            aVarF.b(this.f58922j);
            aVarF.f(fileData);
        }
    }

    public final void u(final Function1<? super Boolean, Unit> callback) {
        Intrinsics.g(callback, "callback");
        TransferClient.Companion companion = TransferClient.f58969t;
        if (companion.d()) {
            com.transsion.transfer.impl.a aVarF = companion.f();
            aVarF.k(this.f58923k);
            aVarF.b(this.f58922j);
            aVarF.a(new Function1<Exception, Unit>() { // from class: com.transsion.transfer.impl.ClientViewModel$sendServerCreateNotify$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Exception exc) {
                    invoke2(exc);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Exception exc) {
                    String message = exc != null ? exc.getMessage() : null;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("sendServerCreateNotify:  ");
                    sb2.append(message);
                    callback.invoke(Boolean.valueOf(exc == null));
                }
            });
        }
    }

    public final void v(Function0<Unit> callback) {
        Intrinsics.g(callback, "callback");
        TransferClient.Companion companion = TransferClient.f58969t;
        if (!companion.d()) {
            callback.invoke();
            return;
        }
        com.transsion.transfer.impl.a aVarF = companion.f();
        aVarF.k(this.f58923k);
        aVarF.b(this.f58922j);
        aVarF.c(callback);
    }

    public final void w(List<FileData> files) {
        Intrinsics.g(files, "files");
        if (!files.isEmpty()) {
            TransferClient.Companion companion = TransferClient.f58969t;
            if (companion.d()) {
                com.transsion.transfer.impl.a aVarF = companion.f();
                aVarF.k(this.f58923k);
                aVarF.b(this.f58922j);
                String absolutePath = i().getAbsolutePath();
                Intrinsics.f(absolutePath, "getCacheRootFile().absolutePath");
                aVarF.i(absolutePath, files, new Function1<List<String>, Unit>() { // from class: com.transsion.transfer.impl.ClientViewModel$transferFiles$2
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(List<String> list) {
                        invoke2(list);
                        return Unit.f68710a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(List<String> it) {
                        Intrinsics.g(it, "it");
                        py.b.f74066a.m(it.size(), TransferClient.f58969t.h());
                    }
                });
            }
        }
    }
}
