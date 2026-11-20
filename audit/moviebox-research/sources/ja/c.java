package ja;

import com.cloud.tmc.ad.bean.response.DataDTO;
import com.cloud.tmc.integration.utils.g;
import java.text.SimpleDateFormat;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class c {
    public static void a(DataDTO dataDTO) {
        if (dataDTO == null) {
            return;
        }
        try {
            g.f31057a.a().o("services_time_difference_value", System.currentTimeMillis() - new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS Z").parse(dataDTO.getTime()).getTime());
        } catch (Exception unused) {
        }
    }
}
