package com.cloud.hisavana.sdk.manager;

import android.graphics.Rect;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.View;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.hisavana.sdk.w1;
import com.cloud.hisavana.sdk.z;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
@SourceDebugExtension
public final class VideoMeasureManager {
    public static final VideoMeasureManager INSTANCE = new VideoMeasureManager();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HandlerThread f29870a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Handler f29871b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final CopyOnWriteArrayList<w1> f29872c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Runnable f29873d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Runnable f29874e;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            VideoMeasureManager.f29871b.post(VideoMeasureManager.f29873d);
            VideoMeasureManager.f29871b.postDelayed(this, 500L);
        }
    }

    static {
        HandlerThread handlerThread = new HandlerThread("h_video_thread");
        handlerThread.start();
        f29870a = handlerThread;
        f29871b = new Handler(handlerThread.getLooper());
        f29872c = new CopyOnWriteArrayList<>();
        f29873d = new Runnable() { // from class: com.cloud.hisavana.sdk.manager.b
            @Override // java.lang.Runnable
            public final void run() {
                VideoMeasureManager.k();
            }
        };
        f29874e = new a();
    }

    public static final void i(AdsDTO adsDTO) {
        w1 w1Var;
        if (adsDTO == null) {
            w1Var = null;
            break;
        }
        Iterator<T> it = f29872c.iterator();
        do {
            if (!it.hasNext()) {
                w1Var = null;
                break;
            }
            w1Var = (w1) it.next();
        } while (!Intrinsics.b(w1Var.b(), adsDTO));
        if (w1Var != null) {
            f29872c.remove(w1Var);
        }
        z zVarA = z.a();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("current measure list size is ");
        CopyOnWriteArrayList<w1> copyOnWriteArrayList = f29872c;
        sb2.append(copyOnWriteArrayList.size());
        zVarA.d("VideoMeasureManager", sb2.toString());
        if (copyOnWriteArrayList.size() <= 0) {
            INSTANCE.stopMeasure();
        }
    }

    public static final void j(w1 measureImpl) {
        Intrinsics.g(measureImpl, "$measureImpl");
        CopyOnWriteArrayList<w1> copyOnWriteArrayList = f29872c;
        if (copyOnWriteArrayList.contains(measureImpl)) {
            copyOnWriteArrayList.remove(copyOnWriteArrayList.indexOf(measureImpl));
        }
        copyOnWriteArrayList.add(measureImpl);
        if (copyOnWriteArrayList.size() > 20) {
            copyOnWriteArrayList.remove(0);
        }
        INSTANCE.startMeasure();
        z.a().d("VideoMeasureManager", "------------->measureList size is " + copyOnWriteArrayList.size());
    }

    public static final void k() {
        Iterator<T> it = f29872c.iterator();
        while (it.hasNext()) {
            ((w1) it.next()).d();
        }
    }

    public final double d(View view) {
        if (view == null || view.getWindowVisibility() != 0) {
            return 0.0d;
        }
        Rect rect = new Rect();
        if (view.getGlobalVisibleRect(rect) && view.isShown()) {
            double dHeight = ((double) rect.height()) * ((double) rect.width());
            double height = ((double) view.getHeight()) * ((double) view.getWidth());
            if (height <= 0.0d) {
                return 0.0d;
            }
            return (dHeight * ((double) 100)) / height;
        }
        return 0.0d;
    }

    public final void f(final AdsDTO adsDTO) {
        z.a().d("VideoMeasureManager", "-------------> remove video ad measure");
        f29871b.post(new Runnable() { // from class: com.cloud.hisavana.sdk.manager.a
            @Override // java.lang.Runnable
            public final void run() {
                VideoMeasureManager.i(adsDTO);
            }
        });
    }

    public final void g(final w1 measureImpl) {
        Intrinsics.g(measureImpl, "measureImpl");
        z.a().d("VideoMeasureManager", "-------------> add video ad measure");
        f29871b.post(new Runnable() { // from class: com.cloud.hisavana.sdk.manager.c
            @Override // java.lang.Runnable
            public final void run() {
                VideoMeasureManager.j(measureImpl);
            }
        });
    }

    public final void startMeasure() {
        z zVarA = z.a();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("current measure list size is ");
        CopyOnWriteArrayList<w1> copyOnWriteArrayList = f29872c;
        sb2.append(copyOnWriteArrayList.size());
        zVarA.d("VideoMeasureManager", sb2.toString());
        if (copyOnWriteArrayList.size() > 0) {
            Handler handler = f29871b;
            handler.post(f29873d);
            handler.post(f29874e);
        }
    }

    public final void stopMeasure() {
        z.a().d("VideoMeasureManager", "stop video ad measure");
        Handler handler = f29871b;
        handler.removeCallbacks(f29873d);
        handler.removeCallbacks(f29874e);
    }
}
