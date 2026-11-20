package xz;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f80999a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f81000b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ScaleGestureDetector f81001c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final GestureDetector f81002d;

    /* JADX INFO: renamed from: xz.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class C0907a extends GestureDetector.SimpleOnGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f81003a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f81004b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ c f81006d;

        public C0907a(c cVar) {
            this.f81006d = cVar;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent e11) {
            Intrinsics.g(e11, "e");
            this.f81003a = e11.getRawX();
            this.f81004b = e11.getRawY();
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent e11, float f11, float f12) {
            Intrinsics.g(e11, "e2");
            if (a.this.f80999a) {
                return false;
            }
            this.f81006d.b(e11.getRawX() - this.f81003a, e11.getRawY() - this.f81004b);
            this.f81003a = e11.getRawX();
            this.f81004b = e11.getRawY();
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent e11) {
            Intrinsics.g(e11, "e");
            this.f81006d.a();
            return false;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements ScaleGestureDetector.OnScaleGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f81007a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f81008b;

        public b(c cVar, a aVar) {
            this.f81007a = cVar;
            this.f81008b = aVar;
        }

        public static final void b(a this$0) {
            Intrinsics.g(this$0, "this$0");
            this$0.f80999a = false;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector detector) {
            Intrinsics.g(detector, "detector");
            this.f81007a.onScale(detector);
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScaleBegin(ScaleGestureDetector detector) {
            Intrinsics.g(detector, "detector");
            this.f81008b.f80999a = true;
            this.f81008b.f81000b.removeCallbacksAndMessages(null);
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public void onScaleEnd(ScaleGestureDetector detector) {
            Intrinsics.g(detector, "detector");
            this.f81008b.f81000b.removeCallbacksAndMessages(null);
            Handler handler = this.f81008b.f81000b;
            final a aVar = this.f81008b;
            handler.postDelayed(new Runnable() { // from class: xz.b
                @Override // java.lang.Runnable
                public final void run() {
                    a.b.b(aVar);
                }
            }, 700L);
        }
    }

    public a(Context context, c videoFloatGestureListener) {
        Intrinsics.g(context, "context");
        Intrinsics.g(videoFloatGestureListener, "videoFloatGestureListener");
        this.f81000b = new Handler(Looper.getMainLooper());
        this.f81001c = new ScaleGestureDetector(context, new b(videoFloatGestureListener, this));
        this.f81002d = new GestureDetector(context, new C0907a(videoFloatGestureListener));
    }

    public final boolean d(MotionEvent ev2) {
        Intrinsics.g(ev2, "ev");
        return this.f81001c.onTouchEvent(ev2) || this.f81002d.onTouchEvent(ev2);
    }
}
