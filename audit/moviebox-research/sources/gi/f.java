package gi;

import android.opengl.GLES20;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.GlUtil;
import com.google.android.exoplayer2.util.n;
import java.nio.Buffer;
import java.nio.FloatBuffer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class f {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final float[] f65520j = {1.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 1.0f, 1.0f};

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final float[] f65521k = {1.0f, 0.0f, 0.0f, 0.0f, -0.5f, 0.0f, 0.0f, 0.5f, 1.0f};

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final float[] f65522l = {1.0f, 0.0f, 0.0f, 0.0f, -0.5f, 0.0f, 0.0f, 1.0f, 1.0f};

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final float[] f65523m = {0.5f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 1.0f, 1.0f};

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final float[] f65524n = {0.5f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.5f, 1.0f, 1.0f};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f65525a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public a f65526b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public a f65527c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public n f65528d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f65529e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f65530f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f65531g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f65532h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f65533i;

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f65534a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final FloatBuffer f65535b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final FloatBuffer f65536c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f65537d;

        public a(d.b bVar) {
            this.f65534a = bVar.a();
            this.f65535b = GlUtil.e(bVar.f65518c);
            this.f65536c = GlUtil.e(bVar.f65519d);
            int i11 = bVar.f65517b;
            if (i11 == 1) {
                this.f65537d = 5;
            } else if (i11 != 2) {
                this.f65537d = 4;
            } else {
                this.f65537d = 6;
            }
        }
    }

    public static boolean c(d dVar) {
        d.a aVar = dVar.f65511a;
        d.a aVar2 = dVar.f65512b;
        return aVar.b() == 1 && aVar.a(0).f65516a == 0 && aVar2.b() == 1 && aVar2.a(0).f65516a == 0;
    }

    public void a(int i11, float[] fArr, boolean z11) {
        float[] fArr2;
        a aVar = z11 ? this.f65527c : this.f65526b;
        if (aVar == null) {
            return;
        }
        int i12 = this.f65525a;
        if (i12 == 1) {
            fArr2 = z11 ? f65522l : f65521k;
        } else if (i12 == 2) {
            fArr2 = z11 ? f65524n : f65523m;
        } else {
            fArr2 = f65520j;
        }
        GLES20.glUniformMatrix3fv(this.f65530f, 1, false, fArr2, 0);
        GLES20.glUniformMatrix4fv(this.f65529e, 1, false, fArr, 0);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, i11);
        GLES20.glUniform1i(this.f65533i, 0);
        GlUtil.c();
        GLES20.glVertexAttribPointer(this.f65531g, 3, 5126, false, 12, (Buffer) aVar.f65535b);
        GlUtil.c();
        GLES20.glVertexAttribPointer(this.f65532h, 2, 5126, false, 8, (Buffer) aVar.f65536c);
        GlUtil.c();
        GLES20.glDrawArrays(aVar.f65537d, 0, aVar.f65534a);
        GlUtil.c();
    }

    public void b() {
        n nVar = new n("uniform mat4 uMvpMatrix;\nuniform mat3 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec2 aTexCoords;\nvarying vec2 vTexCoords;\n// Standard transformation.\nvoid main() {\n  gl_Position = uMvpMatrix * aPosition;\n  vTexCoords = (uTexMatrix * vec3(aTexCoords, 1)).xy;\n}\n", "// This is required since the texture data is GL_TEXTURE_EXTERNAL_OES.\n#extension GL_OES_EGL_image_external : require\nprecision mediump float;\n// Standard texture rendering shader.\nuniform samplerExternalOES uTexture;\nvarying vec2 vTexCoords;\nvoid main() {\n  gl_FragColor = texture2D(uTexture, vTexCoords);\n}\n");
        this.f65528d = nVar;
        this.f65529e = nVar.j("uMvpMatrix");
        this.f65530f = this.f65528d.j("uTexMatrix");
        this.f65531g = this.f65528d.e("aPosition");
        this.f65532h = this.f65528d.e("aTexCoords");
        this.f65533i = this.f65528d.j("uTexture");
    }

    public void d(d dVar) {
        if (c(dVar)) {
            this.f65525a = dVar.f65513c;
            a aVar = new a(dVar.f65511a.a(0));
            this.f65526b = aVar;
            if (!dVar.f65514d) {
                aVar = new a(dVar.f65512b.a(0));
            }
            this.f65527c = aVar;
        }
    }
}
