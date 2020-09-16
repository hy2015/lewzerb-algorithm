package com.lewzerb.lazada;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IpStoreImpl implements IpStore{

    public static void main(String[] args) {
        IpStore ipStore = new IpStoreImpl();
        ipStore.loadData();

        System.out.println(ipStore.provinceOfIp("11.9.46.1"));
        System.out.println(ipStore.provinceOfIp("18.4.46.1"));
        System.out.println(ipStore.provinceOfIp("45.9.46.1"));
    }

    static class IpAddress {
        long beginIp;
        long endIp;
        String province;

        public IpAddress(long beginIp, long endIp, String province) {
            this.beginIp = beginIp;
            this.endIp = endIp;
            this.province = province;
        }

        public long getBeginIp() {
            return beginIp;
        }

        public long getEndIp() {
            return endIp;
        }

        public String getProvince() {
            return province;
        }
    }

    Map<Long, IpAddress> ipAddressHashMap = new HashMap<>();
    List<Long> beginIpList = new ArrayList<>();


    static final String IP_TEXT = "19.2.32.1,19.2.33.1,广东\n"
        + "18.3.54.1,18.5.32.1, 广西\n"
        + "26.3.54.1,27.5.32.1, 上海\n"
        + "11.2.66.1,11.9.46.1, 江苏\n"
        + "13.3.54.1,13.5.32.1, 新疆\n"
        + "30.2.66.1,33.9.46.1, 湖南\n"
        + "44.2.66.1,46.9.46.1, 河北\n"
        + "20.43.54.1,25.43.55.1,北京";

    @Override
    public void loadData() {
        String[] provinceIPAddresses = IP_TEXT.split("\n");
        for (String provinceIPAddress : provinceIPAddresses) {
            String[] provinceGroup = provinceIPAddress.split(",");
            String begin = provinceGroup[0].trim();
            String end = provinceGroup[1].trim();
            String province = provinceGroup[2].trim();

            String[] begins = begin.split("\\.");
            String[] ends = end.split("\\.");

            long beginLong, endLong;
            beginLong = getIPLong(begins);
            endLong = getIPLong(ends);

            ipAddressHashMap.put(beginLong, new IpAddress(beginLong, endLong, province));
            beginIpList.add(beginLong);
        }
    }

    @Override
    public String provinceOfIp(String ip) {
        beginIpList.sort(Long::compareTo);
        Long[] beginArr = new Long[beginIpList.size()];
        beginIpList.toArray(beginArr);

        long targetIpLong = getIPLong(ip.split("\\."));
        int beginCursor = binarySearch(beginArr, targetIpLong);

        if(beginCursor < 0) return null;
        IpAddress ipAddress = ipAddressHashMap.get(beginArr[beginCursor]);
        if(targetIpLong >= ipAddress.getBeginIp()
            && targetIpLong <= ipAddress.getEndIp()){
            return ipAddress.getProvince();
        }
        return null;
    }

    private int binarySearch(Long[] longArr, Long target){
        int low = 0;
        int high = longArr.length - 1;

        while(low <= high){
            int mid = (low + high) / 2;
            if(longArr[mid] > target){
                high = mid - 1;
            } else if(longArr[mid] < target){
                low = mid + 1;
            } else {
               return mid;
            }
        }
        return high;

    }


    private long getIPLong(String[] ips) {
        long sum = 0;
        for (int i = 0; i < ips.length; i++) {
            sum += Integer.parseInt(ips[i]) << (24 - 8 * i);
        }
        return sum;
    }
}
