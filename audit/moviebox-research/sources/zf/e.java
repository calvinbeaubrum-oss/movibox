package zf;

import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.RSRuntimeException;
import androidx.renderscript.Allocation;
import androidx.renderscript.Element;
import androidx.renderscript.RenderScript;
import androidx.renderscript.ScriptIntrinsicBlur;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class e implements c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Boolean f81967e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RenderScript f81968a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ScriptIntrinsicBlur f81969b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Allocation f81970c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Allocation f81971d;

    public static boolean c(Context context) {
        if (f81967e == null && context != null) {
            f81967e = Boolean.valueOf((context.getApplicationInfo().flags & 2) != 0);
        }
        return f81967e == Boolean.TRUE;
    }

    @Override // zf.c
    public void a(Bitmap bitmap, Bitmap bitmap2) {
        this.f81970c.copyFrom(bitmap);
        this.f81969b.setInput(this.f81970c);
        this.f81969b.forEach(this.f81971d);
        this.f81971d.copyTo(bitmap2);
    }

    @Override // zf.c
    public boolean b(Context context, Bitmap bitmap, float f11) {
        if (this.f81968a == null) {
            try {
                RenderScript renderScriptCreate = RenderScript.create(context);
                this.f81968a = renderScriptCreate;
                this.f81969b = ScriptIntrinsicBlur.create(renderScriptCreate, Element.U8_4(renderScriptCreate));
            } catch (RSRuntimeException e11) {
                if (c(context)) {
                    throw e11;
                }
                release();
                return false;
            }
        }
        this.f81969b.setRadius(f11);
        Allocation allocationCreateFromBitmap = Allocation.createFromBitmap(this.f81968a, bitmap, Allocation.MipmapControl.MIPMAP_NONE, 1);
        this.f81970c = allocationCreateFromBitmap;
        this.f81971d = Allocation.createTyped(this.f81968a, allocationCreateFromBitmap.getType());
        return true;
    }

    @Override // zf.c
    public void release() {
        Allocation allocation = this.f81970c;
        if (allocation != null) {
            allocation.destroy();
            this.f81970c = null;
        }
        Allocation allocation2 = this.f81971d;
        if (allocation2 != null) {
            allocation2.destroy();
            this.f81971d = null;
        }
        ScriptIntrinsicBlur scriptIntrinsicBlur = this.f81969b;
        if (scriptIntrinsicBlur != null) {
            scriptIntrinsicBlur.destroy();
            this.f81969b = null;
        }
        RenderScript renderScript = this.f81968a;
        if (renderScript != null) {
            renderScript.destroy();
            this.f81968a = null;
        }
    }
}
