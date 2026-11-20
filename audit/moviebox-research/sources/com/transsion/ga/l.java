package com.transsion.ga;

import android.content.Context;
import android.database.sqlite.SQLiteFullException;
import android.os.Process;
import android.util.Log;
import athena.a0;
import com.transsion.athena.data.TrackData;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile l f51969b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f51970a;

    public l(Context context) {
        this.f51970a = context;
    }

    public static l a() {
        return f51969b;
    }

    public static void b(Context context) {
        if (f51969b == null) {
            synchronized (l.class) {
                try {
                    if (f51969b == null) {
                        f51969b = new l(context);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    public void c(e eVar) {
        String stackTraceString;
        long usableSpace;
        int iD = cr.b.d();
        if (iD == 0) {
            a0.a("trackException tid not configure");
            return;
        }
        String strA = eVar.a();
        if (strA.contains("addJSON")) {
            return;
        }
        TrackData trackDataAdd = new TrackData().add("count", 1, 1).add("eid", strA).add("pid", Process.myPid(), 2).add("extra", eVar.b(), 2);
        Throwable cause = eVar.getCause();
        if (cause == null) {
            stackTraceString = null;
        } else if (cause instanceof SQLiteFullException) {
            stackTraceString = cause.getClass().getName();
        } else {
            stackTraceString = cause.getCause() != null ? Log.getStackTraceString(cause.getCause()) : Log.getStackTraceString(cause);
            if (stackTraceString.length() > 2048) {
                stackTraceString = stackTraceString.substring(0, 2048);
            }
        }
        TrackData trackDataAdd2 = trackDataAdd.add("stackTrace", stackTraceString);
        if (strA.contains("sql")) {
            try {
                usableSpace = this.f51970a.getFilesDir().getUsableSpace();
            } catch (Exception e11) {
                e11.printStackTrace();
                usableSpace = 0;
            }
            trackDataAdd2.add("usableSpace", usableSpace);
        }
        AthenaAnalytics.z(iD).Q("ev_athena", trackDataAdd2, iD);
    }
}
