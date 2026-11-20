package com.facebook.ads.redexgen.uinode;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.TextureView;
import com.facebook.ads.internal.exoplayer2.thirdparty.Format;
import com.facebook.ads.internal.exoplayer2.thirdparty.metadata.Metadata;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class Y4 implements InterfaceC1380Id, InterfaceC1198Aj, InterfaceC1318Fr, DZ, SurfaceHolder.Callback, TextureView.SurfaceTextureListener {
    public static String[] A01 = {"nMHZhEZSp5EcTMzj890UQSIKsf7nOssk", "WLzxKTE2vNTMCpqDs", "SfczCGFglH", "X5aT15p3N3rGxVL5g", "GbnJfxrb9aQYK7s9S1Y8QTSWgx7P8ZxV", "tLWa3XxeFvyx8wOT4", "wILb6N7ReXeeP8cmU", "dyBLf42uqj"};
    public final /* synthetic */ EH A00;

    public Y4(EH eh2) {
        this.A00 = eh2;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1198Aj
    public final void AAo(String str, long j11, long j12) {
        Iterator it = this.A00.A0I.iterator();
        while (it.hasNext()) {
            ((InterfaceC1198Aj) it.next()).AAo(str, j11, j12);
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1198Aj
    public final void AAp(BC bc2) {
        for (InterfaceC1198Aj interfaceC1198Aj : this.A00.A0I) {
            String[] strArr = A01;
            if (strArr[1].length() != strArr[6].length()) {
                throw new RuntimeException();
            }
            A01[4] = "5uZ3F86UAJ67QZD2oUJwcWpEFJTFqeup";
            interfaceC1198Aj.AAp(bc2);
        }
        this.A00.A06 = null;
        this.A00.A09 = null;
        this.A00.A01 = 0;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1198Aj
    public final void AAq(BC bc2) {
        this.A00.A09 = bc2;
        Iterator it = this.A00.A0I.iterator();
        while (it.hasNext()) {
            ((InterfaceC1198Aj) it.next()).AAq(bc2);
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1198Aj
    public final void AAr(Format format) {
        this.A00.A06 = format;
        Iterator it = this.A00.A0I.iterator();
        while (it.hasNext()) {
            ((InterfaceC1198Aj) it.next()).AAr(format);
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1198Aj
    public final void AAs(int i11) {
        this.A00.A01 = i11;
        Iterator it = this.A00.A0I.iterator();
        while (it.hasNext()) {
            ((InterfaceC1198Aj) it.next()).AAs(i11);
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1198Aj
    public final void AAt(int i11, long j11, long j12) {
        Iterator it = this.A00.A0I.iterator();
        while (it.hasNext()) {
            ((InterfaceC1198Aj) it.next()).AAt(i11, j11, j12);
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1318Fr
    public final void ABF(List<C1314Fn> list) {
        this.A00.A0C = list;
        Iterator it = this.A00.A0K.iterator();
        while (it.hasNext()) {
            ((InterfaceC1318Fr) it.next()).ABF(list);
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1380Id
    public final void ABN(int i11, long j11) {
        Iterator it = this.A00.A0L.iterator();
        while (it.hasNext()) {
            ((InterfaceC1380Id) it.next()).ABN(i11, j11);
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.DZ
    public final void ACK(Metadata metadata) {
        Iterator it = this.A00.A0J.iterator();
        while (it.hasNext()) {
            ((DZ) it.next()).ACK(metadata);
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1380Id
    public final void ACt(Surface surface) {
        if (this.A00.A03 == surface) {
            Iterator it = this.A00.A0M.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
        Iterator it2 = this.A00.A0L.iterator();
        while (it2.hasNext()) {
            ((InterfaceC1380Id) it2.next()).ACt(surface);
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1380Id
    public final void ADU(String str, long j11, long j12) {
        Iterator it = this.A00.A0L.iterator();
        while (it.hasNext()) {
            ((InterfaceC1380Id) it.next()).ADU(str, j11, j12);
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1380Id
    public final void ADV(BC bc2) {
        Iterator it = this.A00.A0L.iterator();
        while (it.hasNext()) {
            ((InterfaceC1380Id) it.next()).ADV(bc2);
        }
        this.A00.A07 = null;
        String[] strArr = A01;
        if (strArr[1].length() != strArr[6].length()) {
            throw new RuntimeException();
        }
        A01[0] = "zG8NefRqMKYqbgzRufdCrC4W5rqrDhRZ";
        this.A00.A0A = null;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1380Id
    public final void ADW(BC bc2) {
        this.A00.A0A = bc2;
        Iterator it = this.A00.A0L.iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            if (A01[0].charAt(5) == '7') {
                throw new RuntimeException();
            }
            A01[4] = "B3QwduSxUwudXX0SLqqw26pCzLpqq2sU";
            if (!zHasNext) {
                return;
            } else {
                ((InterfaceC1380Id) it.next()).ADW(bc2);
            }
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1380Id
    public final void ADa(Format format) {
        this.A00.A07 = format;
        Iterator it = this.A00.A0L.iterator();
        while (it.hasNext()) {
            ((InterfaceC1380Id) it.next()).ADa(format);
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1380Id
    public final void ADf(int i11, int i12, int i13, float f11) {
        Iterator it = this.A00.A0M.iterator();
        while (it.hasNext()) {
            ((IU) it.next()).ADf(i11, i12, i13, f11);
        }
        Iterator it2 = this.A00.A0L.iterator();
        while (true) {
            boolean zHasNext = it2.hasNext();
            String[] strArr = A01;
            if (strArr[3].length() != strArr[5].length()) {
                throw new RuntimeException();
            }
            A01[4] = "2vUTxC8fdDWhhRkArIujhTo4qLvFXYNt";
            if (!zHasNext) {
                return;
            } else {
                ((InterfaceC1380Id) it2.next()).ADf(i11, i12, i13, f11);
            }
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i11, int i12) {
        this.A00.A0G(new Surface(surfaceTexture), true);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.A00.A0G(null, true);
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i11, int i12) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i11, int i12, int i13) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.A00.A0G(surfaceHolder.getSurface(), false);
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.A00.A0G(null, false);
    }
}
