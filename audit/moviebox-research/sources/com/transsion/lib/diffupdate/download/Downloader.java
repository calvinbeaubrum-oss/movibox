package com.transsion.lib.diffupdate.download;

import android.os.Build;
import android.util.Log;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;
import com.transsion.gslb.Worker;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.FilesKt__FileReadWriteKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.a2;
import kotlinx.coroutines.h;
import kotlinx.coroutines.j;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.w0;
import l.p;

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
@SourceDebugExtension
public final class Downloader implements com.transsion.lib.diffupdate.download.a {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final a f53033o = new a(null);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static int f53034p = 3;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f53035a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f53036b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f53037c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.transsion.lib.diffupdate.download.b f53038d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f53039e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f53040f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f53041g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f53042h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f53043i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final File f53044j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final File f53045k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f53046l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f53047m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f53048n;

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
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f53049a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f53050b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f53051c;

        public b(long j11, long j12, String subFileName) {
            Intrinsics.g(subFileName, "subFileName");
            this.f53049a = j11;
            this.f53050b = j12;
            this.f53051c = subFileName;
        }

        public final long a() {
            return this.f53050b;
        }

        public final long b() {
            return this.f53049a;
        }

        public final String c() {
            return this.f53051c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f53049a == bVar.f53049a && this.f53050b == bVar.f53050b && Intrinsics.b(this.f53051c, bVar.f53051c);
        }

        public int hashCode() {
            return (((p.a(this.f53049a) * 31) + p.a(this.f53050b)) * 31) + this.f53051c.hashCode();
        }

        public String toString() {
            return "Range(start=" + this.f53049a + ", end=" + this.f53050b + ", subFileName=" + this.f53051c + ')';
        }
    }

    /* JADX INFO: renamed from: com.transsion.lib.diffupdate.download.Downloader$start$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsion.lib.diffupdate.download.Downloader$start$1", f = "Downloader.kt", l = {100, Worker.WHAT_QUIT, 137, 140, 171, 191}, m = "invokeSuspend")
    @SourceDebugExtension
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX INFO: renamed from: com.transsion.lib.diffupdate.download.Downloader$start$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        @Metadata
        @DebugMetadata(c = "com.transsion.lib.diffupdate.download.Downloader$start$1$1", f = "Downloader.kt", l = {}, m = "invokeSuspend")
        public static final class C05731 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ Downloader this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C05731(Downloader downloader, Continuation<? super C05731> continuation) {
                super(2, continuation);
                this.this$0 = downloader;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C05731(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
                return ((C05731) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                kotlin.coroutines.intrinsics.a.e();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                com.transsion.lib.diffupdate.download.b bVar = this.this$0.f53038d;
                if (bVar == null) {
                    return null;
                }
                com.transsion.lib.diffupdate.download.b.a.a(bVar, 1, "", null, 4, null);
                return Unit.f68710a;
            }
        }

        /* JADX INFO: renamed from: com.transsion.lib.diffupdate.download.Downloader$start$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: source.java */
        @Metadata
        @DebugMetadata(c = "com.transsion.lib.diffupdate.download.Downloader$start$1$2", f = "Downloader.kt", l = {}, m = "invokeSuspend")
        public static final class AnonymousClass2 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ Downloader this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(Downloader downloader, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.this$0 = downloader;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass2(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                kotlin.coroutines.intrinsics.a.e();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                com.transsion.lib.diffupdate.download.b bVar = this.this$0.f53038d;
                if (bVar == null) {
                    return null;
                }
                com.transsion.lib.diffupdate.download.b.a.a(bVar, 1, "", null, 4, null);
                return Unit.f68710a;
            }
        }

        /* JADX INFO: renamed from: com.transsion.lib.diffupdate.download.Downloader$start$1$4, reason: invalid class name */
        /* JADX INFO: compiled from: source.java */
        @Metadata
        @DebugMetadata(c = "com.transsion.lib.diffupdate.download.Downloader$start$1$4", f = "Downloader.kt", l = {}, m = "invokeSuspend")
        public static final class AnonymousClass4 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ Downloader this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass4(Downloader downloader, Continuation<? super AnonymousClass4> continuation) {
                super(2, continuation);
                this.this$0 = downloader;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass4(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
                return ((AnonymousClass4) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                kotlin.coroutines.intrinsics.a.e();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                com.transsion.lib.diffupdate.download.b bVar = this.this$0.f53038d;
                if (bVar == null) {
                    return null;
                }
                com.transsion.lib.diffupdate.download.b.a.a(bVar, 3, "download range error", null, 4, null);
                return Unit.f68710a;
            }
        }

        /* JADX INFO: renamed from: com.transsion.lib.diffupdate.download.Downloader$start$1$5, reason: invalid class name */
        /* JADX INFO: compiled from: source.java */
        @Metadata
        @DebugMetadata(c = "com.transsion.lib.diffupdate.download.Downloader$start$1$5", f = "Downloader.kt", l = {}, m = "invokeSuspend")
        public static final class AnonymousClass5 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
            final /* synthetic */ Ref.ObjectRef<File> $file;
            final /* synthetic */ Ref.BooleanRef $mergeResult;
            int label;
            final /* synthetic */ Downloader this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass5(Ref.ObjectRef<File> objectRef, Ref.BooleanRef booleanRef, Downloader downloader, Continuation<? super AnonymousClass5> continuation) {
                super(2, continuation);
                this.$file = objectRef;
                this.$mergeResult = booleanRef;
                this.this$0 = downloader;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass5(this.$file, this.$mergeResult, this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
                return ((AnonymousClass5) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                kotlin.coroutines.intrinsics.a.e();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                if (this.$file.element == null) {
                    com.transsion.lib.diffupdate.download.b bVar = this.this$0.f53038d;
                    if (bVar == null) {
                        return null;
                    }
                    com.transsion.lib.diffupdate.download.b.a.a(bVar, 4, "", null, 4, null);
                    return Unit.f68710a;
                }
                if (!this.$mergeResult.element) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("onError:");
                    sb2.append(this.$file.element.getPath());
                    com.transsion.lib.diffupdate.download.b bVar2 = this.this$0.f53038d;
                    if (bVar2 == null) {
                        return null;
                    }
                    com.transsion.lib.diffupdate.download.b.a.a(bVar2, 4, "", null, 4, null);
                    return Unit.f68710a;
                }
                StringBuilder sb3 = new StringBuilder();
                sb3.append("onSuccess:");
                sb3.append(this.$file.element.getPath());
                com.transsion.lib.diffupdate.download.b bVar3 = this.this$0.f53038d;
                if (bVar3 == null) {
                    return null;
                }
                File file = this.$file.element;
                bVar3.e(file, DownloadEncryptKt.a(file));
                return Unit.f68710a;
            }
        }

        /* JADX INFO: renamed from: com.transsion.lib.diffupdate.download.Downloader$start$1$6, reason: invalid class name */
        /* JADX INFO: compiled from: source.java */
        @Metadata
        @DebugMetadata(c = "com.transsion.lib.diffupdate.download.Downloader$start$1$6", f = "Downloader.kt", l = {}, m = "invokeSuspend")
        public static final class AnonymousClass6 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ Downloader this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass6(Downloader downloader, Continuation<? super AnonymousClass6> continuation) {
                super(2, continuation);
                this.this$0 = downloader;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass6(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
                return ((AnonymousClass6) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                kotlin.coroutines.intrinsics.a.e();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                com.transsion.lib.diffupdate.download.b bVar = this.this$0.f53038d;
                if (bVar == null) {
                    return null;
                }
                bVar.a(this.this$0.f53047m);
                return Unit.f68710a;
            }
        }

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = Downloader.this.new AnonymousClass1(continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
        }

        /* JADX WARN: Code duplicated, block: B:44:0x0119 A[Catch: all -> 0x001b, TryCatch #0 {all -> 0x001b, blocks: (B:6:0x0016, B:9:0x001e, B:49:0x0136, B:12:0x002b, B:42:0x0111, B:44:0x0119, B:46:0x011d, B:51:0x0139, B:53:0x0149, B:55:0x0164, B:56:0x0169, B:63:0x01a7, B:57:0x0170, B:59:0x019f, B:66:0x01c2, B:13:0x0030, B:29:0x00ad, B:14:0x0035, B:22:0x007c, B:17:0x0040, B:19:0x0068, B:24:0x007f, B:26:0x0098, B:31:0x00b0, B:33:0x00b8, B:34:0x00c7, B:35:0x00e0, B:37:0x00e6, B:38:0x0101), top: B:77:0x000b }] */
        /* JADX WARN: Code duplicated, block: B:46:0x011d A[Catch: all -> 0x001b, TryCatch #0 {all -> 0x001b, blocks: (B:6:0x0016, B:9:0x001e, B:49:0x0136, B:12:0x002b, B:42:0x0111, B:44:0x0119, B:46:0x011d, B:51:0x0139, B:53:0x0149, B:55:0x0164, B:56:0x0169, B:63:0x01a7, B:57:0x0170, B:59:0x019f, B:66:0x01c2, B:13:0x0030, B:29:0x00ad, B:14:0x0035, B:22:0x007c, B:17:0x0040, B:19:0x0068, B:24:0x007f, B:26:0x0098, B:31:0x00b0, B:33:0x00b8, B:34:0x00c7, B:35:0x00e0, B:37:0x00e6, B:38:0x0101), top: B:77:0x000b }] */
        /* JADX WARN: Code duplicated, block: B:48:0x0135 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:51:0x0139 A[Catch: all -> 0x001b, TryCatch #0 {all -> 0x001b, blocks: (B:6:0x0016, B:9:0x001e, B:49:0x0136, B:12:0x002b, B:42:0x0111, B:44:0x0119, B:46:0x011d, B:51:0x0139, B:53:0x0149, B:55:0x0164, B:56:0x0169, B:63:0x01a7, B:57:0x0170, B:59:0x019f, B:66:0x01c2, B:13:0x0030, B:29:0x00ad, B:14:0x0035, B:22:0x007c, B:17:0x0040, B:19:0x0068, B:24:0x007f, B:26:0x0098, B:31:0x00b0, B:33:0x00b8, B:34:0x00c7, B:35:0x00e0, B:37:0x00e6, B:38:0x0101), top: B:77:0x000b }] */
        /* JADX WARN: Code duplicated, block: B:53:0x0149 A[Catch: all -> 0x001b, TryCatch #0 {all -> 0x001b, blocks: (B:6:0x0016, B:9:0x001e, B:49:0x0136, B:12:0x002b, B:42:0x0111, B:44:0x0119, B:46:0x011d, B:51:0x0139, B:53:0x0149, B:55:0x0164, B:56:0x0169, B:63:0x01a7, B:57:0x0170, B:59:0x019f, B:66:0x01c2, B:13:0x0030, B:29:0x00ad, B:14:0x0035, B:22:0x007c, B:17:0x0040, B:19:0x0068, B:24:0x007f, B:26:0x0098, B:31:0x00b0, B:33:0x00b8, B:34:0x00c7, B:35:0x00e0, B:37:0x00e6, B:38:0x0101), top: B:77:0x000b }] */
        /* JADX WARN: Code duplicated, block: B:55:0x0164 A[Catch: all -> 0x001b, TryCatch #0 {all -> 0x001b, blocks: (B:6:0x0016, B:9:0x001e, B:49:0x0136, B:12:0x002b, B:42:0x0111, B:44:0x0119, B:46:0x011d, B:51:0x0139, B:53:0x0149, B:55:0x0164, B:56:0x0169, B:63:0x01a7, B:57:0x0170, B:59:0x019f, B:66:0x01c2, B:13:0x0030, B:29:0x00ad, B:14:0x0035, B:22:0x007c, B:17:0x0040, B:19:0x0068, B:24:0x007f, B:26:0x0098, B:31:0x00b0, B:33:0x00b8, B:34:0x00c7, B:35:0x00e0, B:37:0x00e6, B:38:0x0101), top: B:77:0x000b }] */
        /* JADX WARN: Code duplicated, block: B:57:0x0170 A[Catch: all -> 0x001b, TryCatch #0 {all -> 0x001b, blocks: (B:6:0x0016, B:9:0x001e, B:49:0x0136, B:12:0x002b, B:42:0x0111, B:44:0x0119, B:46:0x011d, B:51:0x0139, B:53:0x0149, B:55:0x0164, B:56:0x0169, B:63:0x01a7, B:57:0x0170, B:59:0x019f, B:66:0x01c2, B:13:0x0030, B:29:0x00ad, B:14:0x0035, B:22:0x007c, B:17:0x0040, B:19:0x0068, B:24:0x007f, B:26:0x0098, B:31:0x00b0, B:33:0x00b8, B:34:0x00c7, B:35:0x00e0, B:37:0x00e6, B:38:0x0101), top: B:77:0x000b }] */
        /* JADX WARN: Code duplicated, block: B:62:0x01a6  */
        /* JADX WARN: Code duplicated, block: B:65:0x01c1 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:66:0x01c2 A[Catch: all -> 0x001b, TRY_LEAVE, TryCatch #0 {all -> 0x001b, blocks: (B:6:0x0016, B:9:0x001e, B:49:0x0136, B:12:0x002b, B:42:0x0111, B:44:0x0119, B:46:0x011d, B:51:0x0139, B:53:0x0149, B:55:0x0164, B:56:0x0169, B:63:0x01a7, B:57:0x0170, B:59:0x019f, B:66:0x01c2, B:13:0x0030, B:29:0x00ad, B:14:0x0035, B:22:0x007c, B:17:0x0040, B:19:0x0068, B:24:0x007f, B:26:0x0098, B:31:0x00b0, B:33:0x00b8, B:34:0x00c7, B:35:0x00e0, B:37:0x00e6, B:38:0x0101), top: B:77:0x000b }] */
        /* JADX WARN: Code duplicated, block: B:68:0x01d9 A[RETURN] */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            List list;
            Ref.BooleanRef booleanRef;
            a2 a2VarC;
            AnonymousClass6 anonymousClass6;
            Ref.BooleanRef booleanRef2;
            File fileF;
            File file;
            T tL;
            a2 a2VarC2;
            AnonymousClass5 anonymousClass5;
            a2 a2VarC3;
            AnonymousClass4 anonymousClass4;
            Object objE = kotlin.coroutines.intrinsics.a.e();
            try {
                switch (this.label) {
                    case 0:
                        ResultKt.b(obj);
                        k0 k0Var = (k0) this.L$0;
                        Downloader downloader = Downloader.this;
                        downloader.f53040f = downloader.D();
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("fetchFileLength fileSize:");
                        sb2.append(Downloader.this.f53040f);
                        if (Downloader.this.f53040f <= 0) {
                            a2 a2VarC4 = w0.c();
                            C05731 c05731 = new C05731(Downloader.this, null);
                            this.label = 1;
                            if (h.g(a2VarC4, c05731, this) == objE) {
                                return objE;
                            }
                            return Unit.f68710a;
                        }
                        List listX = Downloader.this.x();
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("download ranges info:");
                        sb3.append(listX);
                        if (listX.isEmpty()) {
                            a2 a2VarC5 = w0.c();
                            AnonymousClass2 anonymousClass2 = new AnonymousClass2(Downloader.this, null);
                            this.label = 2;
                            if (h.g(a2VarC5, anonymousClass2, this) == objE) {
                                return objE;
                            }
                            return Unit.f68710a;
                        }
                        com.transsion.lib.diffupdate.download.b bVar = Downloader.this.f53038d;
                        if (bVar != null) {
                            bVar.b(Downloader.this.f53040f, Downloader.this.f53041g);
                        }
                        Ref.BooleanRef booleanRef3 = new Ref.BooleanRef();
                        List list2 = listX;
                        Downloader downloader2 = Downloader.this;
                        ArrayList arrayList = new ArrayList(kotlin.collections.h.v(list2, 10));
                        Iterator it = list2.iterator();
                        while (it.hasNext()) {
                            arrayList.add(j.d(k0Var, w0.b(), null, new Downloader$start$1$3$1(downloader2, (b) it.next(), booleanRef3, null), 2, null));
                        }
                        this.L$0 = listX;
                        this.L$1 = booleanRef3;
                        this.label = 3;
                        if (AwaitKt.b(arrayList, this) == objE) {
                            return objE;
                        }
                        list = listX;
                        booleanRef = booleanRef3;
                        if (!Downloader.this.f53042h) {
                            a2VarC = w0.c();
                            anonymousClass6 = new AnonymousClass6(Downloader.this, null);
                            this.L$0 = null;
                            this.L$1 = null;
                            this.label = 6;
                            if (h.g(a2VarC, anonymousClass6, this) == objE) {
                                return objE;
                            }
                        } else {
                            if (booleanRef.element) {
                                a2VarC3 = w0.c();
                                anonymousClass4 = new AnonymousClass4(Downloader.this, null);
                                this.L$0 = null;
                                this.L$1 = null;
                                this.label = 4;
                                if (h.g(a2VarC3, anonymousClass4, this) == objE) {
                                    return objE;
                                }
                                return Unit.f68710a;
                            }
                            booleanRef2 = new Ref.BooleanRef();
                            Ref.ObjectRef objectRef = new Ref.ObjectRef();
                            if (list.size() > 1) {
                                booleanRef2.element = Downloader.this.I(list);
                                StringBuilder sb4 = new StringBuilder();
                                sb4.append("merge ranges files mergeResult:");
                                sb4.append(booleanRef2.element);
                                if (booleanRef2.element) {
                                    Downloader.this.A();
                                }
                                tL = Downloader.this.L();
                            } else {
                                booleanRef2.element = true;
                                fileF = Downloader.this.F();
                                file = new File(Downloader.this.f53036b, ((b) list.get(0)).c());
                                StringBuilder sb5 = new StringBuilder();
                                sb5.append("only one range file mergeResult:");
                                sb5.append(booleanRef2.element);
                                if (fileF == null && file.renameTo(fileF)) {
                                    tL = fileF;
                                } else {
                                    tL = file;
                                }
                            }
                            objectRef.element = tL;
                            a2VarC2 = w0.c();
                            anonymousClass5 = new AnonymousClass5(objectRef, booleanRef2, Downloader.this, null);
                            this.L$0 = null;
                            this.L$1 = null;
                            this.label = 5;
                            if (h.g(a2VarC2, anonymousClass5, this) == objE) {
                                return objE;
                            }
                        }
                        return Unit.f68710a;
                    case 1:
                        ResultKt.b(obj);
                        return Unit.f68710a;
                    case 2:
                        ResultKt.b(obj);
                        return Unit.f68710a;
                    case 3:
                        booleanRef = (Ref.BooleanRef) this.L$1;
                        list = (List) this.L$0;
                        ResultKt.b(obj);
                        if (!Downloader.this.f53042h) {
                            a2VarC = w0.c();
                            anonymousClass6 = new AnonymousClass6(Downloader.this, null);
                            this.L$0 = null;
                            this.L$1 = null;
                            this.label = 6;
                            if (h.g(a2VarC, anonymousClass6, this) == objE) {
                                return objE;
                            }
                        } else {
                            if (booleanRef.element) {
                                a2VarC3 = w0.c();
                                anonymousClass4 = new AnonymousClass4(Downloader.this, null);
                                this.L$0 = null;
                                this.L$1 = null;
                                this.label = 4;
                                if (h.g(a2VarC3, anonymousClass4, this) == objE) {
                                    return objE;
                                }
                                return Unit.f68710a;
                            }
                            booleanRef2 = new Ref.BooleanRef();
                            Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                            if (list.size() > 1) {
                                booleanRef2.element = Downloader.this.I(list);
                                StringBuilder sb6 = new StringBuilder();
                                sb6.append("merge ranges files mergeResult:");
                                sb6.append(booleanRef2.element);
                                if (booleanRef2.element) {
                                    Downloader.this.A();
                                }
                                tL = Downloader.this.L();
                            } else {
                                booleanRef2.element = true;
                                fileF = Downloader.this.F();
                                file = new File(Downloader.this.f53036b, ((b) list.get(0)).c());
                                StringBuilder sb7 = new StringBuilder();
                                sb7.append("only one range file mergeResult:");
                                sb7.append(booleanRef2.element);
                                if (fileF == null) {
                                    tL = file;
                                } else {
                                    tL = file;
                                }
                            }
                            objectRef2.element = tL;
                            a2VarC2 = w0.c();
                            anonymousClass5 = new AnonymousClass5(objectRef2, booleanRef2, Downloader.this, null);
                            this.L$0 = null;
                            this.L$1 = null;
                            this.label = 5;
                            if (h.g(a2VarC2, anonymousClass5, this) == objE) {
                                return objE;
                            }
                        }
                        return Unit.f68710a;
                    case 4:
                        ResultKt.b(obj);
                        return Unit.f68710a;
                    case 5:
                    case 6:
                        ResultKt.b(obj);
                        return Unit.f68710a;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } catch (Throwable th2) {
                com.transsion.lib.diffupdate.download.b bVar2 = Downloader.this.f53038d;
                if (bVar2 != null) {
                    String message = th2.getMessage();
                    if (message == null) {
                        message = "";
                    }
                    bVar2.c(6, message, th2);
                }
            }
        }
    }

    public Downloader(String url, String savePath, String saveFileName, com.transsion.lib.diffupdate.download.b bVar) {
        Intrinsics.g(url, "url");
        Intrinsics.g(savePath, "savePath");
        Intrinsics.g(saveFileName, "saveFileName");
        this.f53035a = url;
        this.f53036b = savePath;
        this.f53037c = saveFileName;
        this.f53038d = bVar;
        this.f53039e = url;
        this.f53043i = LazyKt__LazyJVMKt.b(new Function0<String>() { // from class: com.transsion.lib.diffupdate.download.Downloader$fileMd5$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return DownloadEncryptKt.b(this.this$0.f53035a);
            }
        });
        this.f53044j = new File(savePath);
        this.f53045k = new File(savePath, E() + ".range");
        this.f53048n = LazyKt__LazyJVMKt.b(new Function0<Integer>() { // from class: com.transsion.lib.diffupdate.download.Downloader$numThreads$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                return Integer.valueOf(kotlin.ranges.a.g(Runtime.getRuntime().availableProcessors(), Downloader.f53034p));
            }
        });
    }

    public static /* synthetic */ Object N(Downloader downloader, int i11, Function0 function0, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = 5;
        }
        return downloader.M(i11, function0);
    }

    public final void A() {
        if (this.f53045k.exists()) {
            this.f53045k.delete();
        }
    }

    public final boolean B(File file) {
        if (!file.isDirectory()) {
            return file.delete();
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                Intrinsics.f(file2, "file");
                B(file2);
            }
        }
        return file.delete();
    }

    public final boolean C(final b bVar) {
        if (this.f53042h) {
            return false;
        }
        try {
            return ((Boolean) N(this, 0, new Function0<Boolean>() { // from class: com.transsion.lib.diffupdate.download.Downloader$downloadRange$1

                /* JADX INFO: renamed from: com.transsion.lib.diffupdate.download.Downloader$downloadRange$1$1, reason: invalid class name */
                /* JADX INFO: compiled from: source.java */
                @Metadata
                @DebugMetadata(c = "com.transsion.lib.diffupdate.download.Downloader$downloadRange$1$1", f = "Downloader.kt", l = {}, m = "invokeSuspend")
                public static final class AnonymousClass1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
                    final /* synthetic */ int $newProgress;
                    int label;
                    final /* synthetic */ Downloader this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public AnonymousClass1(Downloader downloader, int i11, Continuation<? super AnonymousClass1> continuation) {
                        super(2, continuation);
                        this.this$0 = downloader;
                        this.$newProgress = i11;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new AnonymousClass1(this.this$0, this.$newProgress, continuation);
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
                        b bVar = this.this$0.f53038d;
                        if (bVar != null) {
                            bVar.d(this.$newProgress, this.this$0.f53040f, this.this$0.f53041g);
                        }
                        return Unit.f68710a;
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Boolean invoke() throws IOException {
                    Object objM163constructorimpl;
                    File file = new File(this.this$0.f53036b, bVar.c());
                    long length = file.exists() ? file.length() : 0L;
                    if (bVar.a() > bVar.b() && length == (bVar.a() - bVar.b()) + 1) {
                        return Boolean.TRUE;
                    }
                    Downloader downloader = this.this$0;
                    try {
                        Result.Companion companion = Result.Companion;
                        objM163constructorimpl = Result.m163constructorimpl(new URL(downloader.f53039e));
                    } catch (Throwable th2) {
                        Result.Companion companion2 = Result.Companion;
                        objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
                    }
                    if (Result.m169isFailureimpl(objM163constructorimpl)) {
                        objM163constructorimpl = null;
                    }
                    URL url = (URL) objM163constructorimpl;
                    URLConnection uRLConnection = url != null ? (URLConnection) FirebasePerfUrlConnection.instrument(url.openConnection()) : null;
                    HttpURLConnection httpURLConnection = uRLConnection instanceof HttpURLConnection ? (HttpURLConnection) uRLConnection : null;
                    if (httpURLConnection == null) {
                        return Boolean.FALSE;
                    }
                    httpURLConnection.setConnectTimeout(10000);
                    httpURLConnection.setReadTimeout(DefaultLoadControl.DEFAULT_MIN_BUFFER_MS);
                    httpURLConnection.setRequestProperty("Range", "bytes=" + (bVar.b() + length) + '-' + bVar.a());
                    InputStream inputStream = httpURLConnection.getInputStream();
                    RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                    randomAccessFile.seek(length);
                    byte[] bArr = new byte[1024];
                    int i11 = inputStream.read(bArr);
                    while (true) {
                        if (i11 == -1 || this.this$0.f53042h) {
                            break;
                        }
                        randomAccessFile.write(bArr, 0, i11);
                        this.this$0.f53041g += (long) i11;
                        int i12 = this.this$0.f53040f > 0 ? (int) ((this.this$0.f53041g / this.this$0.f53040f) * ((double) 100)) : -1;
                        if (System.currentTimeMillis() >= this.this$0.f53046l + ((long) 1000)) {
                            this.this$0.f53046l = System.currentTimeMillis();
                            this.this$0.f53047m = i12;
                            j.d(l0.a(w0.c()), null, null, new AnonymousClass1(this.this$0, i12, null), 3, null);
                        }
                        i11 = inputStream.read(bArr);
                    }
                    inputStream.close();
                    randomAccessFile.close();
                    httpURLConnection.disconnect();
                    return Boolean.valueOf(!this.this$0.f53042h);
                }
            }, 1, null)).booleanValue();
        } catch (Throwable th2) {
            th2.printStackTrace();
            Log.e("Downloader", "downloadRange: " + th2.getMessage());
            return false;
        }
    }

    public final long D() throws IOException {
        Object objM163constructorimpl;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("fetchFileLength: ");
        sb2.append(this.f53035a);
        HttpURLConnection httpURLConnectionK = K(this.f53035a);
        if (httpURLConnectionK == null) {
            return -1L;
        }
        long contentLength = httpURLConnectionK.getContentLength();
        if (contentLength <= 0) {
            contentLength = Build.VERSION.SDK_INT >= 24 ? httpURLConnectionK.getContentLengthLong() : -1L;
            if (contentLength <= 0) {
                try {
                    Result.Companion companion = Result.Companion;
                    String headerField = httpURLConnectionK.getHeaderField(HttpHeaders.CONTENT_LENGTH);
                    Intrinsics.f(headerField, "it.getHeaderField(\"Content-Length\")");
                    objM163constructorimpl = Result.m163constructorimpl(Long.valueOf(Long.parseLong(headerField)));
                } catch (Throwable th2) {
                    Result.Companion companion2 = Result.Companion;
                    objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
                }
                if (Result.m169isFailureimpl(objM163constructorimpl)) {
                    objM163constructorimpl = null;
                }
                Long l11 = (Long) objM163constructorimpl;
                contentLength = l11 != null ? l11.longValue() : -1L;
            }
        }
        httpURLConnectionK.disconnect();
        return contentLength;
    }

    public final String E() {
        return (String) this.f53043i.getValue();
    }

    public final File F() {
        if (!new File(this.f53036b, this.f53037c).exists()) {
            return new File(this.f53036b, this.f53037c);
        }
        for (int i11 = 1; i11 < Integer.MAX_VALUE; i11++) {
            String str = J(this.f53037c) + '(' + i11 + ')' + O(this.f53037c);
            if (!new File(this.f53036b, str).exists()) {
                return new File(this.f53036b, str);
            }
        }
        return null;
    }

    public final int G() {
        return ((Number) this.f53048n.getValue()).intValue();
    }

    public final List<b> H() {
        ArrayList arrayList = new ArrayList();
        if (this.f53045k.exists()) {
            Iterator it = FilesKt__FileReadWriteKt.f(this.f53045k, null, 1, null).iterator();
            while (it.hasNext()) {
                List listE0 = StringsKt__StringsKt.E0((String) it.next(), new String[]{":"}, false, 0, 6, null);
                String str = (String) listE0.get(0);
                String str2 = (String) listE0.get(1);
                arrayList.add(new b(Long.parseLong(str), Long.parseLong(str2), (String) listE0.get(2)));
            }
            if (((b) CollectionsKt___CollectionsKt.q0(arrayList)).a() + 1 != this.f53040f) {
                arrayList.addAll(y());
            }
        } else {
            arrayList.addAll(z());
        }
        return arrayList;
    }

    public final boolean I(List<b> list) {
        try {
            File file = new File(this.f53036b, E());
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            for (b bVar : list) {
                File file2 = new File(this.f53036b, bVar.c());
                if (!file2.exists() || file2.length() != (bVar.a() - bVar.b()) + 1) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("mergeRangeFiles: rangeInfo:");
                    sb2.append(bVar);
                    sb2.append(" ,rangeFile exist:");
                    sb2.append(file2.exists());
                    sb2.append(" and length:");
                    sb2.append(file2.length());
                    file.delete();
                    return false;
                }
                FileInputStream fileInputStream = new FileInputStream(file2);
                byte[] bArr = new byte[1024];
                while (true) {
                    int i11 = fileInputStream.read(bArr);
                    if (i11 != -1) {
                        fileOutputStream.write(bArr, 0, i11);
                    }
                }
                fileInputStream.close();
                file2.delete();
            }
            fileOutputStream.close();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public final String J(String str) {
        Intrinsics.g(str, "<this>");
        return StringsKt__StringsKt.v0(str, O(str));
    }

    public final HttpURLConnection K(String str) throws IOException {
        Object objM163constructorimpl;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("redirectConnection: ");
        sb2.append(str);
        this.f53039e = str;
        try {
            Result.Companion companion = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(new URL(str));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        if (Result.m169isFailureimpl(objM163constructorimpl)) {
            objM163constructorimpl = null;
        }
        URL url = (URL) objM163constructorimpl;
        URLConnection uRLConnection = url != null ? (URLConnection) FirebasePerfUrlConnection.instrument(url.openConnection()) : null;
        HttpURLConnection httpURLConnection = uRLConnection instanceof HttpURLConnection ? (HttpURLConnection) uRLConnection : null;
        if (httpURLConnection == null) {
            return null;
        }
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setConnectTimeout(10000);
        int responseCode = httpURLConnection.getResponseCode();
        if (400 <= responseCode && responseCode < 600) {
            return null;
        }
        if (responseCode != 301 && responseCode != 302) {
            return httpURLConnection;
        }
        String headerField = httpURLConnection.getHeaderField(HttpHeaders.LOCATION);
        Intrinsics.f(headerField, "connection.getHeaderField(\"Location\")");
        return K(headerField);
    }

    public final File L() {
        File file = new File(this.f53036b, E());
        File fileF = F();
        return (fileF == null || !file.renameTo(fileF)) ? file : fileF;
    }

    public final <T> T M(int i11, Function0<? extends T> function0) {
        int i12 = i11 - 1;
        for (int i13 = 0; i13 < i12; i13++) {
            try {
                return function0.invoke();
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
        return function0.invoke();
    }

    public final String O(String str) {
        Intrinsics.g(str, "<this>");
        if (!StringsKt__StringsKt.Q(str, InstructionFileId.DOT, false, 2, null)) {
            return "";
        }
        String strSubstring = str.substring(StringsKt__StringsKt.j0(str, InstructionFileId.DOT, 0, false, 6, null));
        Intrinsics.f(strSubstring, "substring(...)");
        return strSubstring;
    }

    @Override // com.transsion.lib.diffupdate.download.a
    public void a() {
        boolean zB = B(this.f53044j);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("clearCache: ");
        sb2.append(zB);
    }

    @Override // com.transsion.lib.diffupdate.download.a
    public void start() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("downloadTask: ");
        sb2.append(this.f53035a);
        this.f53042h = false;
        if (!w()) {
            j.d(l0.a(w0.b()), null, null, new AnonymousClass1(null), 3, null);
            return;
        }
        File file = new File(this.f53036b, this.f53037c);
        com.transsion.lib.diffupdate.download.b bVar = this.f53038d;
        if (bVar != null) {
            bVar.e(file, DownloadEncryptKt.a(file));
        }
    }

    public final boolean w() {
        File file = new File(this.f53036b, this.f53037c);
        return file.exists() && file.length() > 0;
    }

    public final List<b> x() {
        this.f53041g = 0L;
        if (!this.f53045k.exists()) {
            return y();
        }
        List<b> listH = H();
        Iterator<T> it = listH.iterator();
        while (it.hasNext()) {
            File file = new File(this.f53036b, ((b) it.next()).c());
            this.f53041g += file.exists() ? file.length() : 0L;
        }
        return listH;
    }

    public final List<b> y() throws IOException {
        List<b> listZ = z();
        if (this.f53045k.exists() && this.f53045k.length() > 0) {
            this.f53045k.delete();
        }
        if (!this.f53044j.exists()) {
            this.f53044j.mkdirs();
        }
        this.f53045k.createNewFile();
        FilesKt__FileReadWriteKt.k(this.f53045k, CollectionsKt___CollectionsKt.o0(listZ, "\n", null, null, 0, null, new Function1<b, CharSequence>() { // from class: com.transsion.lib.diffupdate.download.Downloader$createRangeFile$1
            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(Downloader.b it) {
                Intrinsics.g(it, "it");
                return it.b() + ':' + it.a() + ':' + it.c();
            }
        }, 30, null), null, 2, null);
        return listZ;
    }

    public final List<b> z() {
        ArrayList arrayList = new ArrayList();
        long j11 = this.f53040f;
        if (j11 > 0) {
            long jG = j11 / ((long) G());
            int iG = G();
            int i11 = 0;
            while (i11 < iG) {
                arrayList.add(new b(((long) i11) * jG, (i11 == G() + (-1) ? this.f53040f : ((long) (i11 + 1)) * jG) - 1, E() + ".range" + i11));
                i11++;
            }
        } else {
            arrayList.add(new b(0L, -1L, E() + ".range0"));
        }
        return arrayList;
    }
}
