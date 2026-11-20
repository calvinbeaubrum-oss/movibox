package androidx.media3.exoplayer.video;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.media3.common.util.GlUtil;
import androidx.media3.decoder.VideoDecoderOutputBuffer;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.util.concurrent.atomic.AtomicReference;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class VideoDecoderGLSurfaceView extends GLSurfaceView implements n {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f11532b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f11533a;

    /* JADX INFO: compiled from: source.java */
    public static final class a implements GLSurfaceView.Renderer {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final float[] f11534l = {1.164f, 1.164f, 1.164f, 0.0f, -0.392f, 2.017f, 1.596f, -0.813f, 0.0f};

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final float[] f11535m = {1.164f, 1.164f, 1.164f, 0.0f, -0.213f, 2.112f, 1.793f, -0.533f, 0.0f};

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final float[] f11536n = {1.168f, 1.168f, 1.168f, 0.0f, -0.188f, 2.148f, 1.683f, -0.652f, 0.0f};

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final String[] f11537o = {"y_tex", "u_tex", "v_tex"};

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final FloatBuffer f11538p = GlUtil.e(new float[]{-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f, -1.0f});

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final GLSurfaceView f11539a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int[] f11540b = new int[3];

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int[] f11541c = new int[3];

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int[] f11542d = new int[3];

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int[] f11543f = new int[3];

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final AtomicReference<VideoDecoderOutputBuffer> f11544g = new AtomicReference<>();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final FloatBuffer[] f11545h = new FloatBuffer[3];

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public androidx.media3.common.util.a f11546i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f11547j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public VideoDecoderOutputBuffer f11548k;

        public a(GLSurfaceView gLSurfaceView) {
            this.f11539a = gLSurfaceView;
            for (int i11 = 0; i11 < 3; i11++) {
                int[] iArr = this.f11542d;
                this.f11543f[i11] = -1;
                iArr[i11] = -1;
            }
        }

        public void a(VideoDecoderOutputBuffer videoDecoderOutputBuffer) {
            VideoDecoderOutputBuffer andSet = this.f11544g.getAndSet(videoDecoderOutputBuffer);
            if (andSet != null) {
                andSet.release();
            }
            this.f11539a.requestRender();
        }

        public final void b() {
            try {
                GLES20.glGenTextures(3, this.f11540b, 0);
                for (int i11 = 0; i11 < 3; i11++) {
                    GLES20.glUniform1i(this.f11546i.j(f11537o[i11]), i11);
                    GLES20.glActiveTexture(33984 + i11);
                    GlUtil.a(3553, this.f11540b[i11]);
                }
                GlUtil.b();
            } catch (GlUtil.GlException e11) {
                Log.e("VideoDecoderGLSV", "Failed to set up the textures", e11);
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            VideoDecoderOutputBuffer andSet = this.f11544g.getAndSet(null);
            if (andSet == null && this.f11548k == null) {
                return;
            }
            if (andSet != null) {
                VideoDecoderOutputBuffer videoDecoderOutputBuffer = this.f11548k;
                if (videoDecoderOutputBuffer != null) {
                    videoDecoderOutputBuffer.release();
                }
                this.f11548k = andSet;
            }
            VideoDecoderOutputBuffer videoDecoderOutputBuffer2 = (VideoDecoderOutputBuffer) z3.a.e(this.f11548k);
            float[] fArr = f11535m;
            int i11 = videoDecoderOutputBuffer2.colorspace;
            if (i11 == 1) {
                fArr = f11534l;
            } else if (i11 == 3) {
                fArr = f11536n;
            }
            GLES20.glUniformMatrix3fv(this.f11547j, 1, false, fArr, 0);
            int[] iArr = (int[]) z3.a.e(videoDecoderOutputBuffer2.yuvStrides);
            ByteBuffer[] byteBufferArr = (ByteBuffer[]) z3.a.e(videoDecoderOutputBuffer2.yuvPlanes);
            int i12 = 0;
            while (i12 < 3) {
                int i13 = i12 == 0 ? videoDecoderOutputBuffer2.height : (videoDecoderOutputBuffer2.height + 1) / 2;
                GLES20.glActiveTexture(33984 + i12);
                GLES20.glBindTexture(3553, this.f11540b[i12]);
                GLES20.glPixelStorei(3317, 1);
                GLES20.glTexImage2D(3553, 0, 6409, iArr[i12], i13, 0, 6409, 5121, byteBufferArr[i12]);
                i12++;
            }
            int i14 = videoDecoderOutputBuffer2.width;
            int i15 = (i14 + 1) / 2;
            int[] iArr2 = {i14, i15, i15};
            for (int i16 = 0; i16 < 3; i16++) {
                if (this.f11542d[i16] != iArr2[i16] || this.f11543f[i16] != iArr[i16]) {
                    z3.a.g(iArr[i16] != 0);
                    float f11 = iArr2[i16] / iArr[i16];
                    this.f11545h[i16] = GlUtil.e(new float[]{0.0f, 0.0f, 0.0f, 1.0f, f11, 0.0f, f11, 1.0f});
                    GLES20.glVertexAttribPointer(this.f11541c[i16], 2, 5126, false, 0, (Buffer) this.f11545h[i16]);
                    this.f11542d[i16] = iArr2[i16];
                    this.f11543f[i16] = iArr[i16];
                }
            }
            GLES20.glClear(16384);
            GLES20.glDrawArrays(5, 0, 4);
            try {
                GlUtil.b();
            } catch (GlUtil.GlException e11) {
                Log.e("VideoDecoderGLSV", "Failed to draw a frame", e11);
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i11, int i12) {
            GLES20.glViewport(0, 0, i11, i12);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            try {
                androidx.media3.common.util.a aVar = new androidx.media3.common.util.a("varying vec2 interp_tc_y;\nvarying vec2 interp_tc_u;\nvarying vec2 interp_tc_v;\nattribute vec4 in_pos;\nattribute vec2 in_tc_y;\nattribute vec2 in_tc_u;\nattribute vec2 in_tc_v;\nvoid main() {\n  gl_Position = in_pos;\n  interp_tc_y = in_tc_y;\n  interp_tc_u = in_tc_u;\n  interp_tc_v = in_tc_v;\n}\n", "precision mediump float;\nvarying vec2 interp_tc_y;\nvarying vec2 interp_tc_u;\nvarying vec2 interp_tc_v;\nuniform sampler2D y_tex;\nuniform sampler2D u_tex;\nuniform sampler2D v_tex;\nuniform mat3 mColorConversion;\nvoid main() {\n  vec3 yuv;\n  yuv.x = texture2D(y_tex, interp_tc_y).r - 0.0625;\n  yuv.y = texture2D(u_tex, interp_tc_u).r - 0.5;\n  yuv.z = texture2D(v_tex, interp_tc_v).r - 0.5;\n  gl_FragColor = vec4(mColorConversion * yuv, 1.0);\n}\n");
                this.f11546i = aVar;
                GLES20.glVertexAttribPointer(aVar.e("in_pos"), 2, 5126, false, 0, (Buffer) f11538p);
                this.f11541c[0] = this.f11546i.e("in_tc_y");
                this.f11541c[1] = this.f11546i.e("in_tc_u");
                this.f11541c[2] = this.f11546i.e("in_tc_v");
                this.f11547j = this.f11546i.j("mColorConversion");
                GlUtil.b();
                b();
                GlUtil.b();
            } catch (GlUtil.GlException e11) {
                Log.e("VideoDecoderGLSV", "Failed to set up the textures and program", e11);
            }
        }
    }

    public VideoDecoderGLSurfaceView(Context context) {
        this(context, null);
    }

    public VideoDecoderGLSurfaceView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a aVar = new a(this);
        this.f11533a = aVar;
        setPreserveEGLContextOnPause(true);
        setEGLContextClientVersion(2);
        setRenderer(aVar);
        setRenderMode(0);
    }

    @Deprecated
    public n getVideoDecoderOutputBufferRenderer() {
        return this;
    }

    @Override // androidx.media3.exoplayer.video.n
    public void setOutputBuffer(VideoDecoderOutputBuffer videoDecoderOutputBuffer) {
        this.f11533a.a(videoDecoderOutputBuffer);
    }
}
