package com.cloud.tmc.integration.utils;

import android.graphics.Point;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import com.cloud.tmc.kernel.log.TmcLogger;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
@SourceDebugExtension
public final class l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l0 f31070a = new l0();

    @JvmStatic
    public static final void a(View view, List<Point> points) {
        String str;
        Point point;
        String str2;
        String str3;
        String str4;
        String str5;
        Intrinsics.g(view, "view");
        Intrinsics.g(points, "points");
        long jUptimeMillis = SystemClock.uptimeMillis();
        Iterator it = points.iterator();
        int i11 = 0;
        while (it.hasNext()) {
            Object next = it.next();
            int i12 = i11 + 1;
            if (i11 < 0) {
                kotlin.collections.g.u();
            }
            Point point2 = (Point) next;
            String str6 = " eventTime: ";
            if (i11 == 0) {
                long j11 = ((long) 50) + jUptimeMillis;
                point = point2;
                boolean zDispatchTouchEvent = view.dispatchTouchEvent(MotionEvent.obtain(jUptimeMillis, j11, 0, point2.x, point2.y, 0));
                StringBuilder sb2 = new StringBuilder();
                sb2.append("simulateTouchEvent: ACTION_DOWN ");
                sb2.append(zDispatchTouchEvent);
                str = " x: ";
                sb2.append(str);
                sb2.append(point.x);
                str2 = " y: ";
                sb2.append(str2);
                sb2.append(point.y);
                sb2.append(" downTime: ");
                sb2.append(jUptimeMillis);
                str6 = " eventTime: ";
                sb2.append(str6);
                sb2.append(j11);
                str3 = "TouchEventUtils";
                TmcLogger.c(str3, sb2.toString());
            } else {
                str = " x: ";
                point = point2;
                str2 = " y: ";
                str3 = "TouchEventUtils";
            }
            if (i11 == 0 || i11 == points.size() - 1) {
                str4 = str2;
                str5 = "  downTime: ";
            } else {
                long j12 = jUptimeMillis + ((long) (i11 * 50));
                long j13 = ((long) (i12 * 50)) + jUptimeMillis;
                str4 = str2;
                boolean zDispatchTouchEvent2 = view.dispatchTouchEvent(MotionEvent.obtain(j12, j13, 2, point.x, point.y, 0));
                StringBuilder sb3 = new StringBuilder();
                sb3.append("simulateTouchEvent: ACTION_MOVE ");
                sb3.append(zDispatchTouchEvent2);
                sb3.append(str);
                sb3.append(point.x);
                sb3.append(str4);
                sb3.append(point.y);
                str5 = "  downTime: ";
                sb3.append(str5);
                sb3.append(j12);
                str6 = str6;
                sb3.append(str6);
                sb3.append(j13);
                str3 = str3;
                TmcLogger.c(str3, sb3.toString());
            }
            if (i11 == points.size() - 1) {
                long j14 = jUptimeMillis + ((long) (i11 * 50));
                long j15 = ((long) (i12 * 50)) + jUptimeMillis;
                TmcLogger.c(str3, "simulateTouchEvent: ACTION_UP " + view.dispatchTouchEvent(MotionEvent.obtain(j14, j15, 1, point.x, point.y, 0)) + str + point.x + str4 + point.y + str5 + j14 + str6 + j15);
            }
            i11 = i12;
            it = it;
            jUptimeMillis = jUptimeMillis;
        }
    }
}
