package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdx extends zzdu {
    /* JADX WARN: Code duplicated, block: B:15:0x0033  */
    @Override // com.google.android.gms.internal.ads.zzdt
    public final void zze(ByteBuffer byteBuffer) {
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        int i11 = iLimit - iPosition;
        int i12 = this.zzb.zzd;
        if (i12 == 3) {
            i11 += i11;
        } else if (i12 == 4) {
            i11 /= 2;
        } else {
            if (i12 != 21) {
                if (i12 == 22) {
                    i11 /= 2;
                } else if (i12 != 268435456) {
                    if (i12 != 1342177280) {
                        if (i12 != 1610612736) {
                            throw new IllegalStateException();
                        }
                        i11 /= 2;
                    }
                }
            }
            i11 /= 3;
            i11 += i11;
        }
        ByteBuffer byteBufferZzj = zzj(i11);
        int i13 = this.zzb.zzd;
        if (i13 == 3) {
            while (iPosition < iLimit) {
                byteBufferZzj.put((byte) 0);
                byteBufferZzj.put((byte) ((byteBuffer.get(iPosition) & 255) - 128));
                iPosition++;
            }
        } else if (i13 == 4) {
            while (iPosition < iLimit) {
                short sMax = (short) (Math.max(-1.0f, Math.min(byteBuffer.getFloat(iPosition), 1.0f)) * 32767.0f);
                byteBufferZzj.put((byte) (sMax & 255));
                byteBufferZzj.put((byte) ((sMax >> 8) & 255));
                iPosition += 4;
            }
        } else if (i13 == 21) {
            while (iPosition < iLimit) {
                byteBufferZzj.put(byteBuffer.get(iPosition + 1));
                byteBufferZzj.put(byteBuffer.get(iPosition + 2));
                iPosition += 3;
            }
        } else if (i13 == 22) {
            while (iPosition < iLimit) {
                byteBufferZzj.put(byteBuffer.get(iPosition + 2));
                byteBufferZzj.put(byteBuffer.get(iPosition + 3));
                iPosition += 4;
            }
        } else if (i13 == 268435456) {
            while (iPosition < iLimit) {
                byteBufferZzj.put(byteBuffer.get(iPosition + 1));
                byteBufferZzj.put(byteBuffer.get(iPosition));
                iPosition += 2;
            }
        } else if (i13 == 1342177280) {
            while (iPosition < iLimit) {
                byteBufferZzj.put(byteBuffer.get(iPosition + 1));
                byteBufferZzj.put(byteBuffer.get(iPosition));
                iPosition += 3;
            }
        } else {
            if (i13 != 1610612736) {
                throw new IllegalStateException();
            }
            while (iPosition < iLimit) {
                byteBufferZzj.put(byteBuffer.get(iPosition + 1));
                byteBufferZzj.put(byteBuffer.get(iPosition));
                iPosition += 4;
            }
        }
        byteBuffer.position(byteBuffer.limit());
        byteBufferZzj.flip();
    }

    @Override // com.google.android.gms.internal.ads.zzdu
    public final zzdr zzi(zzdr zzdrVar) throws zzds {
        int i11 = zzdrVar.zzd;
        if (i11 != 3) {
            if (i11 == 2) {
                return zzdr.zza;
            }
            if (i11 != 268435456 && i11 != 21 && i11 != 1342177280 && i11 != 22 && i11 != 1610612736 && i11 != 4) {
                throw new zzds("Unhandled input format:", zzdrVar);
            }
        }
        return new zzdr(zzdrVar.zzb, zzdrVar.zzc, 2);
    }
}
