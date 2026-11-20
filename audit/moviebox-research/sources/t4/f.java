package t4;

import android.opengl.GLES20;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.media3.common.util.GlUtil;
import java.nio.Buffer;
import java.nio.FloatBuffer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final float[] f76875j = {1.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 1.0f, 1.0f};

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final float[] f76876k = {1.0f, 0.0f, 0.0f, 0.0f, -0.5f, 0.0f, 0.0f, 0.5f, 1.0f};

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final float[] f76877l = {1.0f, 0.0f, 0.0f, 0.0f, -0.5f, 0.0f, 0.0f, 1.0f, 1.0f};

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final float[] f76878m = {0.5f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 1.0f, 1.0f};

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final float[] f76879n = {0.5f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.5f, 1.0f, 1.0f};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f76880a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public a f76881b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public a f76882c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public androidx.media3.common.util.a f76883d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f76884e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f76885f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f76886g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f76887h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f76888i;

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f76889a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final FloatBuffer f76890b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final FloatBuffer f76891c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f76892d;

        public a(d.b bVar) {
            this.f76889a = bVar.a();
            this.f76890b = GlUtil.e(bVar.f76873c);
            this.f76891c = GlUtil.e(bVar.f76874d);
            int i11 = bVar.f76872b;
            if (i11 == 1) {
                this.f76892d = 5;
            } else if (i11 != 2) {
                this.f76892d = 4;
            } else {
                this.f76892d = 6;
            }
        }
    }

    public static boolean c(d dVar) {
        d.a aVar = dVar.f76866a;
        d.a aVar2 = dVar.f76867b;
        return aVar.b() == 1 && aVar.a(0).f76871a == 0 && aVar2.b() == 1 && aVar2.a(0).f76871a == 0;
    }

    public void a(int i11, float[] fArr, boolean z11) {
        float[] fArr2;
        a aVar = z11 ? this.f76882c : this.f76881b;
        if (aVar == null) {
            return;
        }
        int i12 = this.f76880a;
        if (i12 == 1) {
            fArr2 = z11 ? f76877l : f76876k;
        } else if (i12 == 2) {
            fArr2 = z11 ? f76879n : f76878m;
        } else {
            fArr2 = f76875j;
        }
        GLES20.glUniformMatrix3fv(this.f76885f, 1, false, fArr2, 0);
        GLES20.glUniformMatrix4fv(this.f76884e, 1, false, fArr, 0);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, i11);
        GLES20.glUniform1i(this.f76888i, 0);
        try {
            GlUtil.b();
        } catch (GlUtil.GlException e11) {
            Log.e("ProjectionRenderer", "Failed to bind uniforms", e11);
        }
        GLES20.glVertexAttribPointer(this.f76886g, 3, 5126, false, 12, (Buffer) aVar.f76890b);
        try {
            GlUtil.b();
        } catch (GlUtil.GlException e12) {
            Log.e("ProjectionRenderer", "Failed to load position data", e12);
        }
        GLES20.glVertexAttribPointer(this.f76887h, 2, 5126, false, 8, (Buffer) aVar.f76891c);
        try {
            GlUtil.b();
        } catch (GlUtil.GlException e13) {
            Log.e("ProjectionRenderer", "Failed to load texture data", e13);
        }
        GLES20.glDrawArrays(aVar.f76892d, 0, aVar.f76889a);
        try {
            GlUtil.b();
        } catch (GlUtil.GlException e14) {
            Log.e("ProjectionRenderer", "Failed to render", e14);
        }
    }

    public void b() {
        try {
            androidx.media3.common.util.a aVar = new androidx.media3.common.util.a("uniform mat4 uMvpMatrix;\nuniform mat3 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec2 aTexCoords;\nvarying vec2 vTexCoords;\n// Standard transformation.\nvoid main() {\n  gl_Position = uMvpMatrix * aPosition;\n  vTexCoords = (uTexMatrix * vec3(aTexCoords, 1)).xy;\n}\n", "// This is required since the texture data is GL_TEXTURE_EXTERNAL_OES.\n#extension GL_OES_EGL_image_external : require\nprecision mediump float;\n// Standard texture rendering shader.\nuniform samplerExternalOES uTexture;\nvarying vec2 vTexCoords;\nvoid main() {\n  gl_FragColor = texture2D(uTexture, vTexCoords);\n}\n");
            this.f76883d = aVar;
            this.f76884e = aVar.j("uMvpMatrix");
            this.f76885f = this.f76883d.j("uTexMatrix");
            this.f76886g = this.f76883d.e("aPosition");
            this.f76887h = this.f76883d.e("aTexCoords");
            this.f76888i = this.f76883d.j("uTexture");
        } catch (GlUtil.GlException e11) {
            Log.e("ProjectionRenderer", "Failed to initialize the program", e11);
        }
    }

    public void d(d dVar) {
        if (c(dVar)) {
            this.f76880a = dVar.f76868c;
            a aVar = new a(dVar.f76866a.a(0));
            this.f76881b = aVar;
            if (!dVar.f76869d) {
                aVar = new a(dVar.f76867b.a(0));
            }
            this.f76882c = aVar;
        }
    }
}
