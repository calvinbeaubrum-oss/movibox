package com.facebook.ads.redexgen.uinode;

import android.util.SparseArray;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class HS {
    public static byte[] A08;
    public static String[] A09 = {"tUmPyJA995IehdlgYh1M2HtFJdqk2qFq", "MsgCzq1VVfM7rzT56hJDHksvV5yXe4gF", "4HQ7m4N6DkH9M0uOuKNVPqKigOQvjf6k", "N6cNHUUPL7Fh24xE6qmpU0ogNc5efwpW", "s0cCARPqV4C670oPtvU1gEMcVzhG", "NrezJK25om3nHdODHZffKD7POu79MIOp", "J5KrgCJUtsnBlTAtkJ9UTDt78OFQHXma", "N8WE0W2EMF4cGNiI42Wit4NkXIy23rap"};
    public I6 A00;
    public boolean A01;
    public final SparseArray<String> A02;
    public final C1353Hc A03;
    public final HashMap<String, HR> A04;
    public final Cipher A05;
    public final SecretKeySpec A06;
    public final boolean A07;

    static {
        A05();
    }

    public HS(File file, byte[] bArr, boolean z11) {
        this.A07 = z11;
        if (bArr != null) {
            AbstractC1351Ha.A03(bArr.length == 16);
            try {
                this.A05 = A03();
                this.A06 = new SecretKeySpec(bArr, A02(0, 3, 51));
            } catch (NoSuchAlgorithmException | NoSuchPaddingException e11) {
                throw new IllegalStateException(e11);
            }
        } else {
            AbstractC1351Ha.A04(!z11);
            this.A05 = null;
            this.A06 = null;
        }
        this.A04 = new HashMap<>();
        this.A02 = new SparseArray<>();
        this.A03 = new C1353Hc(new File(file, A02(25, 24, 29)));
    }

    public static int A00(SparseArray<String> sparseArray) {
        int size = sparseArray.size();
        int iKeyAt = size == 0 ? 0 : sparseArray.keyAt(size - 1) + 1;
        if (iKeyAt < 0) {
            iKeyAt = 0;
            while (iKeyAt < size && iKeyAt == sparseArray.keyAt(iKeyAt)) {
                iKeyAt++;
            }
        }
        return iKeyAt;
    }

    private HR A01(String str) {
        HR hr2 = new HR(A00(this.A02), str);
        A06(hr2);
        this.A01 = true;
        return hr2;
    }

    public static String A02(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A08, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 50);
        }
        return new String(bArrCopyOfRange);
    }

    public static Cipher A03() throws NoSuchPaddingException, NoSuchAlgorithmException {
        int i11 = IF.A02;
        String strA02 = A02(3, 20, 105);
        if (i11 == 18) {
            try {
                return Cipher.getInstance(strA02, A02(23, 2, 95));
            } catch (Throwable unused) {
            }
        }
        return Cipher.getInstance(strA02);
    }

    private void A04() throws HI {
        try {
            try {
                C1352Hb c1352HbA03 = this.A03.A03();
                I6 i11 = this.A00;
                if (i11 == null) {
                    this.A00 = new I6(c1352HbA03);
                } else {
                    i11.A00(c1352HbA03);
                }
                DataOutputStream dataOutputStream = new DataOutputStream(this.A00);
                dataOutputStream.writeInt(2);
                dataOutputStream.writeInt(this.A07 ? 1 : 0);
                if (this.A07) {
                    byte[] bArr = new byte[16];
                    new Random().nextBytes(bArr);
                    dataOutputStream.write(bArr);
                    try {
                        this.A05.init(1, this.A06, new IvParameterSpec(bArr));
                        dataOutputStream.flush();
                        dataOutputStream = new DataOutputStream(new CipherOutputStream(this.A00, this.A05));
                    } catch (InvalidAlgorithmParameterException | InvalidKeyException e11) {
                        throw new IllegalStateException(e11);
                    }
                }
                dataOutputStream.writeInt(this.A04.size());
                int iA03 = 0;
                for (HR hr2 : this.A04.values()) {
                    hr2.A0A(dataOutputStream);
                    iA03 += hr2.A03(2);
                }
                dataOutputStream.writeInt(iA03);
                this.A03.A06(dataOutputStream);
                IF.A0X(null);
            } catch (IOException e12) {
                throw new HI(e12);
            }
        } catch (Throwable th2) {
            IF.A0X(null);
            throw th2;
        }
    }

    public static void A05() {
        A08 = new byte[]{-90, -86, -72, -36, -32, -18, -54, -34, -35, -34, -54, -21, -26, -34, -18, -48, -21, -36, -33, -33, -28, -23, -30, -45, -44, -78, -80, -78, -73, -76, -77, -82, -78, -66, -67, -61, -76, -67, -61, -82, -72, -67, -77, -76, -57, 125, -76, -57, -72};
    }

    private void A06(HR hr2) {
        this.A04.put(hr2.A03, hr2);
        this.A02.put(hr2.A02, hr2.A03);
    }

    private boolean A07() {
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(this.A03.A04());
            DataInputStream dataInputStream = new DataInputStream(bufferedInputStream);
            int i11 = dataInputStream.readInt();
            if (i11 < 0 || i11 > 2) {
                IF.A0X(dataInputStream);
                if (A09[5].charAt(29) != 'y') {
                    A09[2] = "8D0UmEy2ZnW8UG7osX1W3JX0L9oaaEfw";
                    return false;
                }
            } else {
                if ((dataInputStream.readInt() & 1) != 0) {
                    if (this.A05 == null) {
                        IF.A0X(dataInputStream);
                        return false;
                    }
                    byte[] bArr = new byte[16];
                    dataInputStream.readFully(bArr);
                    try {
                        this.A05.init(2, this.A06, new IvParameterSpec(bArr));
                        dataInputStream = new DataInputStream(new CipherInputStream(bufferedInputStream, this.A05));
                    } catch (InvalidAlgorithmParameterException | InvalidKeyException e11) {
                        throw new IllegalStateException(e11);
                    }
                } else if (this.A07) {
                    this.A01 = true;
                }
                int i12 = dataInputStream.readInt();
                int iA03 = 0;
                for (int i13 = 0; i13 < i12; i13++) {
                    HR hrA00 = HR.A00(i11, dataInputStream);
                    A06(hrA00);
                    iA03 += hrA00.A03(i11);
                    if (A09[7].charAt(6) == '2') {
                        String[] strArr = A09;
                        strArr[1] = "ZJbY63HcUYk99Ksy3hc0bS2ufxQ5OOHz";
                        strArr[0] = "iZFtciO5IqW0OGKPKhOgdI0MA24Af7Lq";
                    }
                }
                int i14 = dataInputStream.readInt();
                boolean z11 = dataInputStream.read() == -1;
                if (i14 == iA03 && z11) {
                    IF.A0X(dataInputStream);
                    return true;
                }
                IF.A0X(dataInputStream);
                if (A09[2].charAt(4) == 'm') {
                    A09[4] = "rTGlFpYWexwUg47qt5zizIuZpLnI";
                    return false;
                }
            }
            throw new RuntimeException();
        } catch (IOException unused) {
            if (0 != 0) {
                IF.A0X(null);
            }
            return false;
        } catch (Throwable th2) {
            if (0 != 0) {
                IF.A0X(null);
            }
            throw th2;
        }
    }

    public final int A08(String str) {
        return A0A(str).A02;
    }

    public final HR A09(String str) {
        return this.A04.get(str);
    }

    public final HR A0A(String str) {
        HR hr2 = this.A04.get(str);
        return hr2 == null ? A01(str) : hr2;
    }

    public final HU A0B(String str) {
        HR hrA09 = A09(str);
        return hrA09 != null ? hrA09.A05() : C1714Vh.A04;
    }

    public final String A0C(int i11) {
        return this.A02.get(i11);
    }

    public final Collection<HR> A0D() {
        return this.A04.values();
    }

    public final void A0E() {
        AbstractC1351Ha.A04(!this.A01);
        if (A07()) {
            return;
        }
        this.A03.A05();
        this.A04.clear();
        this.A02.clear();
    }

    public final void A0F() {
        String[] strArr = new String[this.A04.size()];
        this.A04.keySet().toArray(strArr);
        for (String str : strArr) {
            A0H(str);
        }
    }

    public final void A0G() throws HI {
        if (this.A01) {
            A04();
            this.A01 = false;
        }
    }

    public final void A0H(String str) {
        HR hr2 = this.A04.get(str);
        if (hr2 == null || !hr2.A0C() || hr2.A0D()) {
            return;
        }
        this.A04.remove(str);
        this.A02.remove(hr2.A02);
        if (A09[7].charAt(6) != '2') {
            throw new RuntimeException();
        }
        A09[7] = "jdWRL72EOrbCMRK3hJiACfcup0he26HP";
        this.A01 = true;
    }

    public final void A0I(String str, HW hw2) {
        if (A0A(str).A0F(hw2)) {
            this.A01 = true;
        }
    }
}
