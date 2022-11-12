package ccu.tra.ccutrabase.common.constant;

public class Constants {
    public static final String tokenUrl = "https://tdx.transportdata.tw/auth/realms/TDXConnect/protocol/openid-connect/token";
    public static final String tdxUrl_v2 = "https://tdx.transportdata.tw/api/basic/v2/Rail/TRA/";
    public static final String tdxUrl_v3 = "https://tdx.transportdata.tw/api/basic/v3/Rail/TRA/";
    public static final String grant_type = "client_credentials";
    
    public interface TDX_DailyTimetable {
        String Today = "DailyTimetable/Today";
    }
    public interface TimestampOfDate {
        long oneDay = 24 * 3600 * 1000;
    }

}
