package com.transsion.usercenter.setting.labelsfeedback.sender;

import android.app.Application;
import android.util.Log;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.d0;
import androidx.work.ExistingWorkPolicy;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;
import androidx.work.d;
import androidx.work.k;
import com.blankj.utilcode.util.n;
import com.tencent.mmkv.MMKV;
import com.tn.lib.util.networkinfo.f;
import com.transsion.usercenter.R$string;
import com.transsion.usercenter.setting.labelsfeedback.model.FbDataModel;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.w0;
import zp.b;

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
@Metadata
@SourceDebugExtension
public final class FBSender {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final FBSender f59746a = new FBSender();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f59747b = LazyKt__LazyJVMKt.b(new Function0<MMKV>() { // from class: com.transsion.usercenter.setting.labelsfeedback.sender.FBSender$mmkv$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final MMKV invoke() {
            return MMKV.z("feedback_mmkv");
        }
    });

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    @Metadata
    public static final class a implements d0<WorkInfo> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveData<WorkInfo> f59748a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f59749b;

        /* JADX INFO: renamed from: com.transsion.usercenter.setting.labelsfeedback.sender.FBSender$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        @Metadata
        public /* synthetic */ class C0613a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f59750a;

            static {
                int[] iArr = new int[WorkInfo.State.values().length];
                try {
                    iArr[WorkInfo.State.SUCCEEDED.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[WorkInfo.State.FAILED.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                f59750a = iArr;
            }
        }

        public a(LiveData<WorkInfo> liveData, String str) {
            this.f59748a = liveData;
            this.f59749b = str;
        }

        @Override // androidx.lifecycle.d0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(WorkInfo workInfo) {
            WorkInfo.State stateA = workInfo != null ? workInfo.a() : null;
            int i11 = stateA == null ? -1 : C0613a.f59750a[stateA.ordinal()];
            if (i11 == 1) {
                b.f82110a.d(R$string.feedback_tips_suceess);
                this.f59748a.o(this);
                FBSender.f59746a.i(null);
            } else {
                if (i11 != 2) {
                    return;
                }
                b.f82110a.d(R$string.feedback_tips_failed);
                this.f59748a.o(this);
                FBSender.f59746a.i(this.f59749b);
            }
        }
    }

    public final String c() {
        return e().f("key_failed_json");
    }

    public final FbDataModel d() {
        String strC = c();
        if (strC == null) {
            return null;
        }
        try {
            return (FbDataModel) n.d(strC, FbDataModel.class);
        } catch (Exception e11) {
            String message = e11.getMessage();
            if (message == null) {
                message = "unable to parse json";
            }
            Log.e("feedback", message);
            return null;
        }
    }

    public final MMKV e() {
        Object value = f59747b.getValue();
        Intrinsics.f(value, "<get-mmkv>(...)");
        return (MMKV) value;
    }

    public final void f(Application application) throws Throwable {
        String strC;
        Intrinsics.g(application, "application");
        if (f.f49475a.e() && (strC = c()) != null) {
            f59746a.h(strC, application);
        }
    }

    public final void g(FbDataModel model, Application application) {
        Intrinsics.g(model, "model");
        Intrinsics.g(application, "application");
        j.d(l0.a(w0.b()), null, null, new FBSender$send$1(model, application, null), 3, null);
    }

    public final void h(String str, Application application) throws Throwable {
        k.a aVar = new k.a(FbSenderWorker.class);
        Pair[] pairArr = {TuplesKt.a("key_work_data", str)};
        d.a aVar2 = new d.a();
        Pair pair = pairArr[0];
        aVar2.b((String) pair.getFirst(), pair.getSecond());
        d dVarA = aVar2.a();
        Intrinsics.f(dVarA, "dataBuilder.build()");
        aVar.l(dVarA);
        k kVarB = aVar.b();
        WorkManager workManagerG = WorkManager.g(application);
        Intrinsics.f(workManagerG, "getInstance(application)");
        workManagerG.a("feedback work name", ExistingWorkPolicy.REPLACE, kVarB).a();
        LiveData<WorkInfo> liveDataH = workManagerG.h(kVarB.a());
        Intrinsics.f(liveDataH, "workManager.getWorkInfoB…LiveData(senderWorker.id)");
        j.d(l0.a(w0.c()), null, null, new FBSender$sendJson$1(liveDataH, new a(liveDataH, str), null), 3, null);
    }

    public final void i(String str) {
        if (str == null) {
            e().remove("key_failed_json");
        } else {
            e().p("key_failed_json", str);
        }
    }
}
