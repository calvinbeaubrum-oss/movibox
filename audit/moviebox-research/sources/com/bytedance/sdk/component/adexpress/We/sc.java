package com.bytedance.sdk.component.adexpress.We;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import com.bytedance.sdk.component.utils.Tf;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class sc {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1, types: [android.renderscript.BaseObj] */
    /* JADX WARN: Type inference failed for: r6v5, types: [android.renderscript.BaseObj, android.renderscript.ScriptIntrinsicBlur] */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1, types: [android.renderscript.Allocation] */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8, types: [android.renderscript.Allocation] */
    public static Bitmap sc(Context context, Bitmap bitmap, int i11) {
        RenderScript renderScriptCreate;
        Allocation allocationCreateFromBitmap;
        ?? Create;
        ?? CreateFromBitmap;
        com.bytedance.sdk.component.adexpress.sc.sc.zY zYVarZY;
        try {
            int i12 = Build.VERSION.SDK_INT;
            if (com.bytedance.sdk.component.adexpress.We.pFF() && i12 < 26) {
                try {
                    com.bytedance.sdk.component.adexpress.sc.sc.zY zYVarZY2 = com.bytedance.sdk.component.adexpress.sc.sc.sc.sc().zY();
                    if (zYVarZY2 != null) {
                        zYVarZY2.Xc();
                    }
                } catch (Throwable th2) {
                    Tf.sc("BlurUtils", "gaussianBlur destrot error: " + th2.getMessage());
                }
                return null;
            }
            Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, Math.round(bitmap.getWidth() * 0.2f), Math.round(bitmap.getHeight() * 0.2f), false);
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmapCreateScaledBitmap);
            renderScriptCreate = RenderScript.create(context);
            if (renderScriptCreate == null) {
                try {
                    com.bytedance.sdk.component.adexpress.sc.sc.zY zYVarZY3 = com.bytedance.sdk.component.adexpress.sc.sc.sc.sc().zY();
                    if (zYVarZY3 != null && zYVarZY3.Xc() && renderScriptCreate != null) {
                        if (i12 >= 23) {
                            RenderScript.releaseAllContexts();
                        } else {
                            renderScriptCreate.destroy();
                        }
                    }
                } catch (Throwable th3) {
                    Tf.sc("BlurUtils", "gaussianBlur destrot error: " + th3.getMessage());
                }
                return null;
            }
            try {
                Create = ScriptIntrinsicBlur.create(renderScriptCreate, Element.U8_4(renderScriptCreate));
                try {
                    allocationCreateFromBitmap = Allocation.createFromBitmap(renderScriptCreate, bitmapCreateScaledBitmap);
                    try {
                        CreateFromBitmap = Allocation.createFromBitmap(renderScriptCreate, bitmapCreateBitmap);
                        try {
                            Create.setRadius(i11);
                            Create.setInput(allocationCreateFromBitmap);
                            Create.forEach(CreateFromBitmap);
                            CreateFromBitmap.copyTo(bitmapCreateBitmap);
                            try {
                                com.bytedance.sdk.component.adexpress.sc.sc.zY zYVarZY4 = com.bytedance.sdk.component.adexpress.sc.sc.sc.sc().zY();
                                if (zYVarZY4 != null && zYVarZY4.Xc()) {
                                    if (i12 >= 23) {
                                        RenderScript.releaseAllContexts();
                                    } else {
                                        renderScriptCreate.destroy();
                                    }
                                    if (allocationCreateFromBitmap != null) {
                                        allocationCreateFromBitmap.destroy();
                                    }
                                    CreateFromBitmap.destroy();
                                    Create.destroy();
                                }
                            } catch (Throwable th4) {
                                Tf.sc("BlurUtils", "gaussianBlur destrot error: " + th4.getMessage());
                            }
                            return bitmapCreateBitmap;
                        } catch (Throwable th5) {
                            th = th5;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        CreateFromBitmap = 0;
                    }
                } catch (Throwable th7) {
                    th = th7;
                    allocationCreateFromBitmap = null;
                    CreateFromBitmap = 0;
                }
            } catch (Throwable th8) {
                th = th8;
                allocationCreateFromBitmap = null;
                Create = allocationCreateFromBitmap;
                CreateFromBitmap = Create;
            }
        } catch (Throwable th9) {
            th = th9;
            renderScriptCreate = null;
            allocationCreateFromBitmap = null;
        }
        Create = allocationCreateFromBitmap;
        CreateFromBitmap = Create;
        try {
            Tf.sc("BlurUtils", "gaussianBlur error: " + th.getMessage());
            try {
                if (zYVarZY == null) {
                    return null;
                }
                return null;
            } catch (Throwable th10) {
                return null;
            }
        } finally {
            try {
                zYVarZY = com.bytedance.sdk.component.adexpress.sc.sc.sc.sc().zY();
                if (zYVarZY != null && zYVarZY.Xc()) {
                    if (renderScriptCreate != null) {
                        if (Build.VERSION.SDK_INT >= 23) {
                            RenderScript.releaseAllContexts();
                        } else {
                            renderScriptCreate.destroy();
                        }
                    }
                    if (allocationCreateFromBitmap != null) {
                        allocationCreateFromBitmap.destroy();
                    }
                    if (CreateFromBitmap != 0) {
                        CreateFromBitmap.destroy();
                    }
                    if (Create != 0) {
                        Create.destroy();
                    }
                }
            } catch (Throwable th11) {
                Tf.sc("BlurUtils", "gaussianBlur destrot error: " + th11.getMessage());
            }
        }
    }
}
