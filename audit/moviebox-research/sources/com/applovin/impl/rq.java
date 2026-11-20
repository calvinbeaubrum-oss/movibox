package com.applovin.impl;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import com.google.android.gms.gcm.Task;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.util.concurrent.atomic.AtomicReference;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class rq extends GLSurfaceView implements tq {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f22171b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f22172a;

    /* JADX INFO: compiled from: source.java */
    public static final class a implements GLSurfaceView.Renderer {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static final float[] f22173j = {1.164f, 1.164f, 1.164f, 0.0f, -0.392f, 2.017f, 1.596f, -0.813f, 0.0f};

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private static final float[] f22174k = {1.164f, 1.164f, 1.164f, 0.0f, -0.213f, 2.112f, 1.793f, -0.533f, 0.0f};

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private static final float[] f22175l = {1.168f, 1.168f, 1.168f, 0.0f, -0.188f, 2.148f, 1.683f, -0.652f, 0.0f};

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private static final String[] f22176m = {"y_tex", "u_tex", "v_tex"};

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private static final FloatBuffer f22177n = ba.a(new float[]{-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f, -1.0f});

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final GLSurfaceView f22178a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int[] f22179b = new int[3];

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int[] f22180c = new int[3];

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int[] f22181d = new int[3];

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int[] f22182e = new int[3];

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final AtomicReference f22183f = new AtomicReference();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final FloatBuffer[] f22184g = new FloatBuffer[3];

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f22185h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f22186i;

        public a(GLSurfaceView gLSurfaceView) {
            this.f22178a = gLSurfaceView;
            for (int i11 = 0; i11 < 3; i11++) {
                int[] iArr = this.f22181d;
                this.f22182e[i11] = -1;
                iArr[i11] = -1;
            }
        }

        private void a() {
            GLES20.glGenTextures(3, this.f22179b, 0);
            for (int i11 = 0; i11 < 3; i11++) {
                GLES20.glUniform1i(GLES20.glGetUniformLocation(this.f22185h, f22176m[i11]), i11);
                GLES20.glActiveTexture(33984 + i11);
                GLES20.glBindTexture(3553, this.f22179b[i11]);
                GLES20.glTexParameterf(3553, 10241, 9729.0f);
                GLES20.glTexParameterf(3553, Task.EXTRAS_LIMIT_BYTES, 9729.0f);
                GLES20.glTexParameterf(3553, 10242, 33071.0f);
                GLES20.glTexParameterf(3553, 10243, 33071.0f);
            }
            ba.a();
        }

        public void a(sq sqVar) {
            d8.a(this.f22183f.getAndSet(sqVar));
            this.f22178a.requestRender();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            d8.a(this.f22183f.getAndSet(null));
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i11, int i12) {
            GLES20.glViewport(0, 0, i11, i12);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            int iA = ba.a("varying vec2 interp_tc_y;\nvarying vec2 interp_tc_u;\nvarying vec2 interp_tc_v;\nattribute vec4 in_pos;\nattribute vec2 in_tc_y;\nattribute vec2 in_tc_u;\nattribute vec2 in_tc_v;\nvoid main() {\n  gl_Position = in_pos;\n  interp_tc_y = in_tc_y;\n  interp_tc_u = in_tc_u;\n  interp_tc_v = in_tc_v;\n}\n", "precision mediump float;\nvarying vec2 interp_tc_y;\nvarying vec2 interp_tc_u;\nvarying vec2 interp_tc_v;\nuniform sampler2D y_tex;\nuniform sampler2D u_tex;\nuniform sampler2D v_tex;\nuniform mat3 mColorConversion;\nvoid main() {\n  vec3 yuv;\n  yuv.x = texture2D(y_tex, interp_tc_y).r - 0.0625;\n  yuv.y = texture2D(u_tex, interp_tc_u).r - 0.5;\n  yuv.z = texture2D(v_tex, interp_tc_v).r - 0.5;\n  gl_FragColor = vec4(mColorConversion * yuv, 1.0);\n}\n");
            this.f22185h = iA;
            GLES20.glUseProgram(iA);
            int iGlGetAttribLocation = GLES20.glGetAttribLocation(this.f22185h, "in_pos");
            GLES20.glEnableVertexAttribArray(iGlGetAttribLocation);
            GLES20.glVertexAttribPointer(iGlGetAttribLocation, 2, 5126, false, 0, (Buffer) f22177n);
            this.f22180c[0] = GLES20.glGetAttribLocation(this.f22185h, "in_tc_y");
            GLES20.glEnableVertexAttribArray(this.f22180c[0]);
            this.f22180c[1] = GLES20.glGetAttribLocation(this.f22185h, "in_tc_u");
            GLES20.glEnableVertexAttribArray(this.f22180c[1]);
            this.f22180c[2] = GLES20.glGetAttribLocation(this.f22185h, "in_tc_v");
            GLES20.glEnableVertexAttribArray(this.f22180c[2]);
            ba.a();
            this.f22186i = GLES20.glGetUniformLocation(this.f22185h, "mColorConversion");
            ba.a();
            a();
            ba.a();
        }
    }

    public rq(Context context) {
        this(context, null);
    }

    public rq(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a aVar = new a(this);
        this.f22172a = aVar;
        setPreserveEGLContextOnPause(true);
        setEGLContextClientVersion(2);
        setRenderer(aVar);
        setRenderMode(0);
    }

    @Deprecated
    public tq getVideoDecoderOutputBufferRenderer() {
        return this;
    }

    public void setOutputBuffer(sq sqVar) {
        this.f22172a.a(sqVar);
    }
}
