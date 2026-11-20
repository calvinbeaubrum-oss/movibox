package com.facebook.ads.redexgen.uinode;

import android.net.Uri;
import com.facebook.ads.internal.exoplayer2.thirdparty.offline.DownloadAction;
import java.io.DataInputStream;
import java.io.IOException;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class WZ extends DownloadAction.Deserializer {
    public WZ(String str, int i11) {
        super(str, i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.internal.exoplayer2.thirdparty.offline.DownloadAction.Deserializer
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final WY A01(int i11, DataInputStream dataInputStream) throws IOException {
        Uri uri = Uri.parse(dataInputStream.readUTF());
        boolean z11 = dataInputStream.readBoolean();
        byte[] bArr = new byte[dataInputStream.readInt()];
        dataInputStream.readFully(bArr);
        return new WY(uri, z11, bArr, dataInputStream.readBoolean() ? dataInputStream.readUTF() : null);
    }
}
