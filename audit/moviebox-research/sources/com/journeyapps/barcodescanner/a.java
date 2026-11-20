package com.journeyapps.barcodescanner;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import androidx.core.app.ActivityCompat;
import com.google.android.gms.iid.InstanceID;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.client.android.R$string;
import com.google.zxing.k;
import fm.e;
import fm.h;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import xn.c;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class a {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f42539o = "a";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static int f42540p = 250;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Activity f42541a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public DecoratedBarcodeView f42542b;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public h f42548h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public e f42549i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Handler f42550j;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final CameraPreview.f f42553m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f42554n;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f42543c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f42544d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f42545e = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f42546f = "";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f42547g = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f42551k = false;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public xn.a f42552l = new C0473a();

    /* JADX INFO: renamed from: com.journeyapps.barcodescanner.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public class C0473a implements xn.a {
        public C0473a() {
        }

        @Override // xn.a
        public void a(List<k> list) {
        }

        @Override // xn.a
        public void b(final c cVar) {
            a.this.f42542b.pause();
            a.this.f42549i.f();
            a.this.f42550j.post(new Runnable() { // from class: xn.i
                @Override // java.lang.Runnable
                public final void run() {
                    this.f80612a.d(cVar);
                }
            });
        }

        public final /* synthetic */ void d(c cVar) {
            a.this.B(cVar);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements CameraPreview.f {
        public b() {
        }

        @Override // com.journeyapps.barcodescanner.CameraPreview.f
        public void a() {
        }

        @Override // com.journeyapps.barcodescanner.CameraPreview.f
        public void b() {
            if (a.this.f42551k) {
                String unused = a.f42539o;
                a.this.s();
            }
        }

        @Override // com.journeyapps.barcodescanner.CameraPreview.f
        public void c(Exception exc) {
            a aVar = a.this;
            aVar.m(aVar.f42541a.getString(R$string.zxing_msg_camera_framework_bug));
        }

        @Override // com.journeyapps.barcodescanner.CameraPreview.f
        public void d() {
        }

        @Override // com.journeyapps.barcodescanner.CameraPreview.f
        public void e() {
        }
    }

    public a(Activity activity, DecoratedBarcodeView decoratedBarcodeView) {
        b bVar = new b();
        this.f42553m = bVar;
        this.f42554n = false;
        this.f42541a = activity;
        this.f42542b = decoratedBarcodeView;
        decoratedBarcodeView.getBarcodeView().addStateListener(bVar);
        this.f42550j = new Handler();
        this.f42548h = new h(activity, new Runnable() { // from class: xn.e
            @Override // java.lang.Runnable
            public final void run() {
                this.f80608a.s();
            }
        });
        this.f42549i = new e(activity);
    }

    public static Intent A(c cVar, String str) {
        Intent intent = new Intent("com.google.zxing.client.android.SCAN");
        intent.addFlags(524288);
        intent.putExtra("SCAN_RESULT", cVar.toString());
        intent.putExtra("SCAN_RESULT_FORMAT", cVar.a().toString());
        byte[] bArrC = cVar.c();
        if (bArrC != null && bArrC.length > 0) {
            intent.putExtra("SCAN_RESULT_BYTES", bArrC);
        }
        Map<ResultMetadataType, Object> mapD = cVar.d();
        if (mapD != null) {
            ResultMetadataType resultMetadataType = ResultMetadataType.UPC_EAN_EXTENSION;
            if (mapD.containsKey(resultMetadataType)) {
                intent.putExtra("SCAN_RESULT_UPC_EAN_EXTENSION", mapD.get(resultMetadataType).toString());
            }
            Number number = (Number) mapD.get(ResultMetadataType.ORIENTATION);
            if (number != null) {
                intent.putExtra("SCAN_RESULT_ORIENTATION", number.intValue());
            }
            String str2 = (String) mapD.get(ResultMetadataType.ERROR_CORRECTION_LEVEL);
            if (str2 != null) {
                intent.putExtra("SCAN_RESULT_ERROR_CORRECTION_LEVEL", str2);
            }
            Iterable iterable = (Iterable) mapD.get(ResultMetadataType.BYTE_SEGMENTS);
            if (iterable != null) {
                Iterator it = iterable.iterator();
                int i11 = 0;
                while (it.hasNext()) {
                    intent.putExtra("SCAN_RESULT_BYTE_SEGMENTS_" + i11, (byte[]) it.next());
                    i11++;
                }
            }
        }
        if (str != null) {
            intent.putExtra("SCAN_RESULT_IMAGE_PATH", str);
        }
        return intent;
    }

    public void B(c cVar) {
        this.f42541a.setResult(-1, A(cVar, o(cVar)));
        k();
    }

    public void C() {
        Intent intent = new Intent("com.google.zxing.client.android.SCAN");
        intent.putExtra(InstanceID.ERROR_TIMEOUT, true);
        this.f42541a.setResult(0, intent);
        k();
    }

    public final void D() {
        Intent intent = new Intent("com.google.zxing.client.android.SCAN");
        intent.putExtra("MISSING_CAMERA_PERMISSION", true);
        this.f42541a.setResult(0, intent);
    }

    public void E(boolean z11, String str) {
        this.f42545e = z11;
        if (str == null) {
            str = "";
        }
        this.f42546f = str;
    }

    public void k() {
        if (this.f42542b.getBarcodeView().isCameraClosed()) {
            s();
        } else {
            this.f42551k = true;
        }
        this.f42542b.pause();
        this.f42548h.d();
    }

    public void l() {
        this.f42542b.decodeSingle(this.f42552l);
    }

    public void m(String str) {
        if (this.f42541a.isFinishing() || this.f42547g || this.f42551k) {
            return;
        }
        if (str.isEmpty()) {
            str = this.f42541a.getString(R$string.zxing_msg_camera_framework_bug);
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f42541a);
        builder.setTitle(this.f42541a.getString(R$string.zxing_app_name));
        builder.setMessage(str);
        builder.setPositiveButton(R$string.zxing_button_ok, new DialogInterface.OnClickListener() { // from class: xn.f
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i11) {
                this.f80609a.q(dialogInterface, i11);
            }
        });
        builder.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: xn.g
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                this.f80610a.r(dialogInterface);
            }
        });
        builder.show();
    }

    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public final void s() {
        this.f42541a.finish();
    }

    public final String o(c cVar) {
        if (this.f42544d) {
            Bitmap bitmapB = cVar.b();
            try {
                File fileCreateTempFile = File.createTempFile("barcodeimage", ".jpg", this.f42541a.getCacheDir());
                FileOutputStream fileOutputStream = new FileOutputStream(fileCreateTempFile);
                bitmapB.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                fileOutputStream.close();
                return fileCreateTempFile.getAbsolutePath();
            } catch (IOException e11) {
                Log.w(f42539o, "Unable to create temporary file and store bitmap! " + e11);
            }
        }
        return null;
    }

    public void p(Intent intent, Bundle bundle) {
        this.f42541a.getWindow().addFlags(128);
        if (bundle != null) {
            this.f42543c = bundle.getInt("SAVED_ORIENTATION_LOCK", -1);
        }
        if (intent != null) {
            if (intent.getBooleanExtra("SCAN_ORIENTATION_LOCKED", true)) {
                t();
            }
            if ("com.google.zxing.client.android.SCAN".equals(intent.getAction())) {
                this.f42542b.initializeFromIntent(intent);
            }
            if (!intent.getBooleanExtra("BEEP_ENABLED", true)) {
                this.f42549i.g(false);
            }
            if (intent.hasExtra("SHOW_MISSING_CAMERA_PERMISSION_DIALOG")) {
                E(intent.getBooleanExtra("SHOW_MISSING_CAMERA_PERMISSION_DIALOG", true), intent.getStringExtra("MISSING_CAMERA_PERMISSION_DIALOG_MESSAGE"));
            }
            if (intent.hasExtra(InstanceID.ERROR_TIMEOUT)) {
                this.f42550j.postDelayed(new Runnable() { // from class: xn.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f80611a.C();
                    }
                }, intent.getLongExtra(InstanceID.ERROR_TIMEOUT, 0L));
            }
            if (intent.getBooleanExtra("BARCODE_IMAGE_ENABLED", false)) {
                this.f42544d = true;
            }
        }
    }

    public final /* synthetic */ void q(DialogInterface dialogInterface, int i11) {
        s();
    }

    public final /* synthetic */ void r(DialogInterface dialogInterface) {
        s();
    }

    public void t() {
        if (this.f42543c == -1) {
            int rotation = this.f42541a.getWindowManager().getDefaultDisplay().getRotation();
            int i11 = this.f42541a.getResources().getConfiguration().orientation;
            int i12 = 0;
            if (i11 == 2) {
                if (rotation != 0 && rotation != 1) {
                    i12 = 8;
                }
            } else if (i11 == 1) {
                i12 = (rotation == 0 || rotation == 3) ? 1 : 9;
            }
            this.f42543c = i12;
        }
        this.f42541a.setRequestedOrientation(this.f42543c);
    }

    public void u() {
        this.f42547g = true;
        this.f42548h.d();
        this.f42550j.removeCallbacksAndMessages(null);
    }

    public void v() {
        this.f42548h.d();
        this.f42542b.pauseAndWait();
    }

    public void w(int i11, String[] strArr, int[] iArr) {
        if (i11 == f42540p) {
            if (iArr.length > 0 && iArr[0] == 0) {
                this.f42542b.resume();
                return;
            }
            D();
            if (this.f42545e) {
                m(this.f42546f);
            } else {
                k();
            }
        }
    }

    public void x() {
        if (Build.VERSION.SDK_INT >= 23) {
            z();
        } else {
            this.f42542b.resume();
        }
        this.f42548h.h();
    }

    public void y(Bundle bundle) {
        bundle.putInt("SAVED_ORIENTATION_LOCK", this.f42543c);
    }

    @TargetApi(23)
    public final void z() {
        if (z2.a.checkSelfPermission(this.f42541a, "android.permission.CAMERA") == 0) {
            this.f42542b.resume();
        } else {
            if (this.f42554n) {
                return;
            }
            ActivityCompat.g(this.f42541a, new String[]{"android.permission.CAMERA"}, f42540p);
            this.f42554n = true;
        }
    }
}
