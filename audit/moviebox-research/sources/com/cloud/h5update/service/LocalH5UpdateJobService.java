package com.cloud.h5update.service;

import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import com.cloud.h5update.service.LocalH5UpdateJobService;
import com.cloud.h5update.utils.ExecutorUtils;
import com.cloud.h5update.utils.l;
import k9.b;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class LocalH5UpdateJobService extends JobService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f28892a = new a(null);

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context) {
            Intrinsics.g(context, "context");
            Object systemService = context.getSystemService("jobscheduler");
            if (systemService == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.app.job.JobScheduler");
            }
            ((JobScheduler) systemService).schedule(new JobInfo.Builder(1001, new ComponentName(context, (Class<?>) LocalH5UpdateJobService.class)).setRequiredNetworkType(2).setRequiresCharging(true).build());
        }
    }

    public static final void b() {
        l.f28923a.e(b.f68501g.a());
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        Intrinsics.g(jobParameters, "jobParameters");
        ExecutorUtils.g().execute(new Runnable() { // from class: n9.a
            @Override // java.lang.Runnable
            public final void run() {
                LocalH5UpdateJobService.b();
            }
        });
        return false;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        Intrinsics.g(jobParameters, "jobParameters");
        return false;
    }
}
