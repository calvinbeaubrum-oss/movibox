package com.journeyapps.barcodescanner;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import com.google.zxing.DecodeHintType;
import com.google.zxing.client.android.R$id;
import java.util.HashMap;
import java.util.List;
import xn.c;
import xn.j;
import xn.k;
import xn.l;
import xn.m;
import xn.n;
import xn.v;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class BarcodeView extends CameraPreview {
    public DecodeMode C;
    public xn.a D;
    public m E;
    public k F;
    public Handler G;
    public final Handler.Callback H;

    /* JADX INFO: compiled from: source.java */
    public enum DecodeMode {
        NONE,
        SINGLE,
        CONTINUOUS
    }

    /* JADX INFO: compiled from: source.java */
    public class a implements Handler.Callback {
        public a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i11 = message.what;
            if (i11 == R$id.zxing_decode_succeeded) {
                c cVar = (c) message.obj;
                if (cVar != null && BarcodeView.this.D != null && BarcodeView.this.C != DecodeMode.NONE) {
                    BarcodeView.this.D.b(cVar);
                    if (BarcodeView.this.C == DecodeMode.SINGLE) {
                        BarcodeView.this.stopDecoding();
                    }
                }
                return true;
            }
            if (i11 == R$id.zxing_decode_failed) {
                return true;
            }
            if (i11 != R$id.zxing_possible_result_points) {
                return false;
            }
            List<com.google.zxing.k> list = (List) message.obj;
            if (BarcodeView.this.D != null && BarcodeView.this.C != DecodeMode.NONE) {
                BarcodeView.this.D.a(list);
            }
            return true;
        }
    }

    public BarcodeView(Context context) {
        super(context);
        this.C = DecodeMode.NONE;
        this.D = null;
        this.H = new a();
        C();
    }

    public BarcodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.C = DecodeMode.NONE;
        this.D = null;
        this.H = new a();
        C();
    }

    public BarcodeView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.C = DecodeMode.NONE;
        this.D = null;
        this.H = new a();
        C();
    }

    public final j A() {
        if (this.F == null) {
            this.F = B();
        }
        l lVar = new l();
        HashMap map = new HashMap();
        map.put(DecodeHintType.NEED_RESULT_POINT_CALLBACK, lVar);
        j jVarA = this.F.a(map);
        lVar.b(jVarA);
        return jVarA;
    }

    public k B() {
        return new n();
    }

    public final void C() {
        this.F = new n();
        this.G = new Handler(this.H);
    }

    public final void D() {
        E();
        if (this.C == DecodeMode.NONE || !isPreviewActive()) {
            return;
        }
        m mVar = new m(getCameraInstance(), A(), this.G);
        this.E = mVar;
        mVar.i(getPreviewFramingRect());
        this.E.k();
    }

    public final void E() {
        m mVar = this.E;
        if (mVar != null) {
            mVar.l();
            this.E = null;
        }
    }

    public void decodeContinuous(xn.a aVar) {
        this.C = DecodeMode.CONTINUOUS;
        this.D = aVar;
        D();
    }

    public void decodeSingle(xn.a aVar) {
        this.C = DecodeMode.SINGLE;
        this.D = aVar;
        D();
    }

    public k getDecoderFactory() {
        return this.F;
    }

    @Override // com.journeyapps.barcodescanner.CameraPreview
    public void pause() {
        E();
        super.pause();
    }

    @Override // com.journeyapps.barcodescanner.CameraPreview
    public void s() {
        super.s();
        D();
    }

    public void setDecoderFactory(k kVar) {
        v.a();
        this.F = kVar;
        m mVar = this.E;
        if (mVar != null) {
            mVar.j(A());
        }
    }

    public void stopDecoding() {
        this.C = DecodeMode.NONE;
        this.D = null;
        E();
    }
}
