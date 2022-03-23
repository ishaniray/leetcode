class Solution {
    public String validIPAddress(String queryIP) {
        if (queryIP.length() == 0) {
            return "Neither";
        }
        
        if (isIPv4(queryIP)) {
            return "IPv4";
        }
        
        if(isIPv6(queryIP)) {
            return "IPv6";
        }
        
        return "Neither";        
    }
    
    private boolean isIPv4(String ip) {
        if (ip.charAt(ip.length() - 1) == '.') {
            return false;
        }
        
        String[] octets = ip.split("\\.");
        
        if (octets.length != 4) {
            return false;
        }
        
        for (String octet : octets) {
            if (octet.length() < 1 || octet.length() > 3) {
                return false;
            }
            
            if (octet.length() > 1 && octet.charAt(0) == '0') {
                return false;
            }
            
            if (!octet.matches("[0-9]+")) {
                return false;
            }
            
            if (Integer.parseInt(octet) > 255) {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean isIPv6(String ip) {
        if (ip.charAt(ip.length() - 1) == ':') {
            return false;
        }
        
        String[] hextets = ip.split(":");
        
        if (hextets.length != 8) {
            return false;
        }
        
        for (String hextet : hextets) {
            if (hextet.length() < 1 || hextet.length() > 4) {
                return false;
            }
            
            if (!hextet.matches("[0-9a-fA-F]+")) {
                return false;
            }
        }
        
        return true;
    }
}