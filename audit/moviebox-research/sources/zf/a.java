package zf;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RSRuntimeException;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@TargetApi(17)
public class a implements c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Boolean f81957e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RenderScript f81958a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ScriptIntrinsicBlur f81959b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Allocation f81960c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Allocation f81961d;

    public static boolean c(Context context) {
        if (f81957e == null && context != null) {
            f81957e = Boolean.valueOf((context.getApplicationInfo().flags & 2) != 0);
        }
        return f81957e == Boolean.TRUE;
    }

    @Override // zf.c
    public void a(Bitmap bitmap, Bitmap bitmap2) {
        this.f81960c.copyFrom(bitmap);
        this.f81959b.setInput(this.f81960c);
        this.f81959b.forEach(this.f81961d);
        this.f81961d.copyTo(bitmap2);
    }

    @Override // zf.c
    public boolean b(Context context, Bitmap bitmap, float f11) {
        if (this.f81958a == null) {
            try {
                RenderScript renderScriptCreate = RenderScript.create(context);
                this.f81958a = renderScriptCreate;
                this.f81959b = ScriptIntrinsicBlur.create(renderScriptCreate, Element.U8_4(renderScriptCreate));
            } catch (RSRuntimeException e11) {
                if (c(context)) {
                    throw e11;
                }
                release();
                return false;
            }
        }
        this.f81959b.setRadius(f11);
        Allocation allocationCreateFromBitmap = Allocation.createFromBitmap(this.f81958a, bitmap, Allocation.MipmapControl.MIPMAP_NONE, 1);
        this.f81960c = allocationCreateFromBitmap;
        this.f81961d = Allocation.createTyped(this.f81958a, allocationCreateFromBitmap.getType());
        return true;
    }

    @Override // zf.c
    public void release() {
        Allocation allocation = this.f81960c;
        if (allocation != null) {
            allocation.destroy();
            this.f81960c = null;
        }
        Allocation allocation2 = this.f81961d;
        if (allocation2 != null) {
            allocation2.destroy();
            this.f81961d = null;
        }
        ScriptIntrinsicBlur scriptIntrinsicBlur = this.f81959b;
        if (scriptIntrinsicBlur != null) {
            scriptIntrinsicBlur.destroy();
            this.f81959b = null;
        }
        RenderScript renderScript = this.f81958a;
        if (renderScript != null) {
            renderScript.destroy();
            this.f81958a = null;
        }
    }
}
