package com.transsion.startup.work;

import android.content.Context;
import androidx.work.CoroutineWorker;
import androidx.work.WorkerParameters;
import androidx.work.i;
import com.transsion.ad.monopoly.manager.AdPlansRequestManager;
import com.transsion.mb.config.download.RequestConfig;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlinx.coroutines.r0;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class NetworkDataSourceWorker extends CoroutineWorker {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Companion f57978d = new Companion(null);

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Code duplicated, block: B:8:0x0014  */
        public final Object a(Continuation<? super Unit> continuation) throws Throwable {
            NetworkDataSourceWorker$Companion$realWork$1 networkDataSourceWorker$Companion$realWork$1;
            if (continuation instanceof NetworkDataSourceWorker$Companion$realWork$1) {
                networkDataSourceWorker$Companion$realWork$1 = (NetworkDataSourceWorker$Companion$realWork$1) continuation;
                int i11 = networkDataSourceWorker$Companion$realWork$1.label;
                if ((i11 & Integer.MIN_VALUE) != 0) {
                    networkDataSourceWorker$Companion$realWork$1.label = i11 - Integer.MIN_VALUE;
                } else {
                    networkDataSourceWorker$Companion$realWork$1 = new NetworkDataSourceWorker$Companion$realWork$1(this, continuation);
                }
            } else {
                networkDataSourceWorker$Companion$realWork$1 = new NetworkDataSourceWorker$Companion$realWork$1(this, continuation);
            }
            NetworkDataSourceWorker$Companion$realWork$1 networkDataSourceWorker$Companion$realWork$2 = networkDataSourceWorker$Companion$realWork$1;
            Object obj = networkDataSourceWorker$Companion$realWork$2.result;
            Object objE = kotlin.coroutines.intrinsics.a.e();
            int i12 = networkDataSourceWorker$Companion$realWork$2.label;
            if (i12 != 0) {
                if (i12 == 1) {
                    ResultKt.b(obj);
                } else {
                    if (i12 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                }
                RequestConfig.f53099a.l();
                return Unit.f68710a;
            }
            ResultKt.b(obj);
            int iNextInt = Random.Default.nextInt(0, 60);
            b.a.f(b.f78622a, "NetworkDataSourceWorker", "doWork random * " + iNextInt, false, 4, null);
            networkDataSourceWorker$Companion$realWork$2.label = 1;
            if (r0.a(((long) iNextInt) * 1000, networkDataSourceWorker$Companion$realWork$2) == objE) {
                return objE;
            }
            AdPlansRequestManager adPlansRequestManager = AdPlansRequestManager.f50530a;
            networkDataSourceWorker$Companion$realWork$2.label = 2;
            if (AdPlansRequestManager.s(adPlansRequestManager, "/wefeed-mobile-bff/ad/config", null, networkDataSourceWorker$Companion$realWork$2, 2, null) == objE) {
                return objE;
            }
            RequestConfig.f53099a.l();
            return Unit.f68710a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetworkDataSourceWorker(Context context, WorkerParameters params) {
        super(context, params);
        Intrinsics.g(context, "context");
        Intrinsics.g(params, "params");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // androidx.work.CoroutineWorker
    public Object d(Continuation<? super i.a> continuation) throws Throwable {
        NetworkDataSourceWorker$doWork$1 networkDataSourceWorker$doWork$1;
        if (continuation instanceof NetworkDataSourceWorker$doWork$1) {
            networkDataSourceWorker$doWork$1 = (NetworkDataSourceWorker$doWork$1) continuation;
            int i11 = networkDataSourceWorker$doWork$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                networkDataSourceWorker$doWork$1.label = i11 - Integer.MIN_VALUE;
            } else {
                networkDataSourceWorker$doWork$1 = new NetworkDataSourceWorker$doWork$1(this, continuation);
            }
        } else {
            networkDataSourceWorker$doWork$1 = new NetworkDataSourceWorker$doWork$1(this, continuation);
        }
        Object obj = networkDataSourceWorker$doWork$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = networkDataSourceWorker$doWork$1.label;
        try {
            if (i12 == 0) {
                ResultKt.b(obj);
                Companion companion = f57978d;
                networkDataSourceWorker$doWork$1.label = 1;
                if (companion.a(networkDataSourceWorker$doWork$1) == objE) {
                    return objE;
                }
            } else {
                if (i12 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            i.a aVarC = i.a.c();
            Intrinsics.f(aVarC, "success()");
            return aVarC;
        } catch (Exception e11) {
            e11.printStackTrace();
            i.a aVarA = i.a.a();
            Intrinsics.f(aVarA, "failure()");
            return aVarA;
        }
    }
}
