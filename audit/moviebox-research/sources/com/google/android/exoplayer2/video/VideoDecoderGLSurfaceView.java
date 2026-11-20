package com.google.android.exoplayer2.video;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.GlUtil;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.util.concurrent.atomic.AtomicReference;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class VideoDecoderGLSurfaceView extends GLSurfaceView implements h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f35693b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f35694a;

    /* JADX INFO: compiled from: source.java */
    public static final class a implements GLSurfaceView.Renderer {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final float[] f35695l = {1.164f, 1.164f, 1.164f, 0.0f, -0.392f, 2.017f, 1.596f, -0.813f, 0.0f};

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final float[] f35696m = {1.164f, 1.164f, 1.164f, 0.0f, -0.213f, 2.112f, 1.793f, -0.533f, 0.0f};

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final float[] f35697n = {1.168f, 1.168f, 1.168f, 0.0f, -0.188f, 2.148f, 1.683f, -0.652f, 0.0f};

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final String[] f35698o = {"y_tex", "u_tex", "v_tex"};

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final FloatBuffer f35699p = GlUtil.e(new float[]{-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f, -1.0f});

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final GLSurfaceView f35700a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int[] f35701b = new int[3];

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int[] f35702c = new int[3];

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int[] f35703d = new int[3];

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int[] f35704f = new int[3];

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final AtomicReference<com.google.android.exoplayer2.decoder.h> f35705g = new AtomicReference<>();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final FloatBuffer[] f35706h = new FloatBuffer[3];

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public com.google.android.exoplayer2.util.n f35707i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f35708j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public com.google.android.exoplayer2.decoder.h f35709k;

        public a(GLSurfaceView gLSurfaceView) {
            this.f35700a = gLSurfaceView;
            for (int i11 = 0; i11 < 3; i11++) {
                int[] iArr = this.f35703d;
                this.f35704f[i11] = -1;
                iArr[i11] = -1;
            }
        }

        public void a(com.google.android.exoplayer2.decoder.h hVar) {
            com.google.android.exoplayer2.decoder.h andSet = this.f35705g.getAndSet(hVar);
            if (andSet != null) {
                andSet.m();
            }
            this.f35700a.requestRender();
        }

        public final void b() {
            GLES20.glGenTextures(3, this.f35701b, 0);
            for (int i11 = 0; i11 < 3; i11++) {
                GLES20.glUniform1i(this.f35707i.j(f35698o[i11]), i11);
                GLES20.glActiveTexture(33984 + i11);
                GlUtil.a(3553, this.f35701b[i11]);
            }
            GlUtil.c();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            com.google.android.exoplayer2.decoder.h andSet = this.f35705g.getAndSet(null);
            if (andSet == null && this.f35709k == null) {
                return;
            }
            if (andSet != null) {
                com.google.android.exoplayer2.decoder.h hVar = this.f35709k;
                if (hVar != null) {
                    hVar.m();
                }
                this.f35709k = andSet;
            }
            com.google.android.exoplayer2.decoder.h hVar2 = (com.google.android.exoplayer2.decoder.h) com.google.android.exoplayer2.util.a.e(this.f35709k);
            float[] fArr = f35696m;
            int i11 = hVar2.f33085i;
            if (i11 == 1) {
                fArr = f35695l;
            } else if (i11 == 3) {
                fArr = f35697n;
            }
            GLES20.glUniformMatrix3fv(this.f35708j, 1, false, fArr, 0);
            int[] iArr = (int[]) com.google.android.exoplayer2.util.a.e(hVar2.f33084h);
            ByteBuffer[] byteBufferArr = (ByteBuffer[]) com.google.android.exoplayer2.util.a.e(hVar2.f33083g);
            int i12 = 0;
            while (i12 < 3) {
                int i13 = i12 == 0 ? hVar2.f33082f : (hVar2.f33082f + 1) / 2;
                GLES20.glActiveTexture(33984 + i12);
                GLES20.glBindTexture(3553, this.f35701b[i12]);
                GLES20.glPixelStorei(3317, 1);
                GLES20.glTexImage2D(3553, 0, 6409, iArr[i12], i13, 0, 6409, 5121, byteBufferArr[i12]);
                i12++;
            }
            int i14 = hVar2.f33081d;
            int i15 = (i14 + 1) / 2;
            int[] iArr2 = {i14, i15, i15};
            for (int i16 = 0; i16 < 3; i16++) {
                if (this.f35703d[i16] != iArr2[i16] || this.f35704f[i16] != iArr[i16]) {
                    com.google.android.exoplayer2.util.a.g(iArr[i16] != 0);
                    float f11 = iArr2[i16] / iArr[i16];
                    this.f35706h[i16] = GlUtil.e(new float[]{0.0f, 0.0f, 0.0f, 1.0f, f11, 0.0f, f11, 1.0f});
                    GLES20.glVertexAttribPointer(this.f35702c[i16], 2, 5126, false, 0, (Buffer) this.f35706h[i16]);
                    this.f35703d[i16] = iArr2[i16];
                    this.f35704f[i16] = iArr[i16];
                }
            }
            GLES20.glClear(16384);
            GLES20.glDrawArrays(5, 0, 4);
            GlUtil.c();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i11, int i12) {
            GLES20.glViewport(0, 0, i11, i12);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            com.google.android.exoplayer2.util.n nVar = new com.google.android.exoplayer2.util.n("varying vec2 interp_tc_y;\nvarying vec2 interp_tc_u;\nvarying vec2 interp_tc_v;\nattribute vec4 in_pos;\nattribute vec2 in_tc_y;\nattribute vec2 in_tc_u;\nattribute vec2 in_tc_v;\nvoid main() {\n  gl_Position = in_pos;\n  interp_tc_y = in_tc_y;\n  interp_tc_u = in_tc_u;\n  interp_tc_v = in_tc_v;\n}\n", "precision mediump float;\nvarying vec2 interp_tc_y;\nvarying vec2 interp_tc_u;\nvarying vec2 interp_tc_v;\nuniform sampler2D y_tex;\nuniform sampler2D u_tex;\nuniform sampler2D v_tex;\nuniform mat3 mColorConversion;\nvoid main() {\n  vec3 yuv;\n  yuv.x = texture2D(y_tex, interp_tc_y).r - 0.0625;\n  yuv.y = texture2D(u_tex, interp_tc_u).r - 0.5;\n  yuv.z = texture2D(v_tex, interp_tc_v).r - 0.5;\n  gl_FragColor = vec4(mColorConversion * yuv, 1.0);\n}\n");
            this.f35707i = nVar;
            GLES20.glVertexAttribPointer(nVar.e("in_pos"), 2, 5126, false, 0, (Buffer) f35699p);
            this.f35702c[0] = this.f35707i.e("in_tc_y");
            this.f35702c[1] = this.f35707i.e("in_tc_u");
            this.f35702c[2] = this.f35707i.e("in_tc_v");
            this.f35708j = this.f35707i.j("mColorConversion");
            GlUtil.c();
            b();
            GlUtil.c();
        }
    }

    public VideoDecoderGLSurfaceView(Context context) {
        this(context, null);
    }

    public VideoDecoderGLSurfaceView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a aVar = new a(this);
        this.f35694a = aVar;
        setPreserveEGLContextOnPause(true);
        setEGLContextClientVersion(2);
        setRenderer(aVar);
        setRenderMode(0);
    }

    @Deprecated
    public h getVideoDecoderOutputBufferRenderer() {
        return this;
    }

    public void setOutputBuffer(com.google.android.exoplayer2.decoder.h hVar) {
        this.f35694a.a(hVar);
    }
}
