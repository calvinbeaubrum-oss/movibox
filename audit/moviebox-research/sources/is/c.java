package is;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.blankj.utilcode.util.d0;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f67675b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f67676c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f67678e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f67679f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f67680g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public GestureDetector f67681h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public a f67682i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f67683j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public View f67684k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f67674a = c.class.getSimpleName();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f67677d = true;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final GestureDetector.OnGestureListener f67685l = new GestureDetectorOnGestureListenerC0716c();

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public interface a {
        void a();

        void b(float f11, float f12);

        void c(float f11, float f12);

        void d(float f11, float f12);

        void e();

        void onDoubleTap(MotionEvent motionEvent);

        void onLongPress(MotionEvent motionEvent);
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements GestureDetector.OnDoubleTapListener {
        public b() {
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent e11) {
            Intrinsics.g(e11, "e");
            a aVar = c.this.f67682i;
            if (aVar == null) {
                return false;
            }
            aVar.onDoubleTap(e11);
            return false;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTapEvent(MotionEvent e11) {
            Intrinsics.g(e11, "e");
            return false;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent e11) {
            Intrinsics.g(e11, "e");
            a aVar = c.this.f67682i;
            if (aVar == null) {
                return false;
            }
            aVar.a();
            return false;
        }
    }

    /* JADX INFO: renamed from: is.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class GestureDetectorOnGestureListenerC0716c implements GestureDetector.OnGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f67687a;

        public GestureDetectorOnGestureListenerC0716c() {
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent e11) {
            Intrinsics.g(e11, "e");
            this.f67687a = e11.getX();
            return true;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent e11, float f11, float f12) {
            Intrinsics.g(e11, "e2");
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent e11) {
            Intrinsics.g(e11, "e");
            a aVar = c.this.f67682i;
            if (aVar != null) {
                aVar.onLongPress(e11);
            }
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent e11, float f11, float f12) {
            Intrinsics.g(e11, "e2");
            if (!c.this.f67677d || motionEvent == null) {
                return false;
            }
            if (Math.abs(f11) <= Math.abs(f12)) {
                boolean unused = c.this.f67678e;
            } else if (!c.this.f67680g && !c.this.f67679f) {
                c.this.f67678e = true;
            }
            if (c.this.f67678e) {
                a aVar = c.this.f67682i;
                if (aVar != null) {
                    aVar.b(motionEvent.getX(), e11.getX());
                }
            } else if (c.this.f67683j) {
                c cVar = c.this;
                View view = cVar.f67684k;
                Intrinsics.d(view);
                if (cVar.p(view, (int) this.f67687a)) {
                    c.this.f67680g = true;
                    a aVar2 = c.this.f67682i;
                    if (aVar2 != null) {
                        aVar2.c(motionEvent.getY(), e11.getY());
                    }
                } else {
                    c cVar2 = c.this;
                    View view2 = cVar2.f67684k;
                    Intrinsics.d(view2);
                    if (cVar2.r(view2, (int) this.f67687a)) {
                        c.this.f67679f = true;
                        a aVar3 = c.this.f67682i;
                        if (aVar3 != null) {
                            aVar3.d(motionEvent.getY(), e11.getY());
                        }
                    }
                }
            } else if (c.this.o((int) this.f67687a)) {
                c.this.f67680g = true;
                a aVar4 = c.this.f67682i;
                if (aVar4 != null) {
                    aVar4.c(motionEvent.getY(), e11.getY());
                }
            } else if (c.this.q((int) this.f67687a)) {
                c.this.f67679f = true;
                a aVar5 = c.this.f67682i;
                if (aVar5 != null) {
                    aVar5.d(motionEvent.getY(), e11.getY());
                }
            }
            return true;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onShowPress(MotionEvent e11) {
            Intrinsics.g(e11, "e");
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent e11) {
            Intrinsics.g(e11, "e");
            return false;
        }
    }

    public c(Context context, View view) {
        this.f67675b = context;
        this.f67676c = view;
        m();
    }

    public static final boolean n(c this$0, View view, MotionEvent motionEvent) {
        Intrinsics.g(this$0, "this$0");
        int action = motionEvent.getAction();
        if (action == 1 || action == 3) {
            a aVar = this$0.f67682i;
            if (aVar != null) {
                aVar.e();
            }
            this$0.f67680g = false;
            this$0.f67679f = false;
            this$0.f67678e = false;
        }
        GestureDetector gestureDetector = this$0.f67681h;
        Intrinsics.d(gestureDetector);
        return gestureDetector.onTouchEvent(motionEvent);
    }

    public final void l(boolean z11) {
        this.f67677d = z11;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void m() {
        this.f67681h = new GestureDetector(this.f67675b, this.f67685l);
        View view = this.f67676c;
        Intrinsics.d(view);
        view.setOnTouchListener(new View.OnTouchListener() { // from class: is.b
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                return c.n(this.f67673a, view2, motionEvent);
            }
        });
        GestureDetector gestureDetector = this.f67681h;
        Intrinsics.d(gestureDetector);
        gestureDetector.setOnDoubleTapListener(new b());
    }

    public final boolean o(int i11) {
        return i11 < d0.e() / 2;
    }

    public final boolean p(View view, int i11) {
        Intrinsics.g(view, "view");
        return i11 < view.getMeasuredWidth() / 2;
    }

    public final boolean q(int i11) {
        return i11 > d0.e() / 2;
    }

    public final boolean r(View view, int i11) {
        Intrinsics.g(view, "view");
        return i11 > view.getMeasuredWidth() / 2;
    }

    public final void s(a aVar) {
        this.f67682i = aVar;
    }
}
