package com.transsion.al.ka;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class JobUtils {
    private static final String TAG = "JobUtils";

    public static void startAppLockJobService(Context context) {
        JobInfo.Builder builder = new JobInfo.Builder(101, new ComponentName(context.getPackageName(), AppLockJobService.class.getName()));
        builder.setRequiredNetworkType(1);
        builder.setPersisted(false);
        builder.setMinimumLatency(ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS);
        builder.setOverrideDeadline(75000L);
        JobInfo jobInfoBuild = builder.build();
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        jobScheduler.cancel(101);
        try {
            jobScheduler.schedule(jobInfoBuild);
        } catch (Exception e11) {
            c.c(TAG, e11.getCause(), "");
        }
    }
}
