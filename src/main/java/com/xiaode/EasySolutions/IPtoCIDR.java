package com.xiaode.EasySolutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liyangde on Nov, 2018
 *
 * Given a start IP address ip and a number of ips we need to cover n, return a representation of the range as a list (of smallest possible length) of CIDR blocks.
 *
 * A CIDR block is a string consisting of an IP, followed by a slash, and then the prefix length. For example: "123.45.67.89/20". That prefix length "20" represents the number of common prefix bits in the specified range.
 *
 * Example 1:
 * Input: ip = "255.0.0.7", n = 10
 * Output: ["255.0.0.7/32","255.0.0.8/29","255.0.0.16/32"]
 * Explanation:
 * The initial ip address, when converted to binary, looks like this (spaces added for clarity):
 * 255.0.0.7 -> 11111111 00000000 00000000 00000111
 * The address "255.0.0.7/32" specifies all addresses with a common prefix of 32 bits to the given address,
 * ie. just this one address.
 *
 * The address "255.0.0.8/29" specifies all addresses with a common prefix of 29 bits to the given address:
 * 255.0.0.8 -> 11111111 00000000 00000000 00001000
 * Addresses with common prefix of 29 bits are:
 * 11111111 00000000 00000000 00001000
 * 11111111 00000000 00000000 00001001
 * 11111111 00000000 00000000 00001010
 * 11111111 00000000 00000000 00001011
 * 11111111 00000000 00000000 00001100
 * 11111111 00000000 00000000 00001101
 * 11111111 00000000 00000000 00001110
 * 11111111 00000000 00000000 00001111
 *
 * The address "255.0.0.16/32" specifies all addresses with a common prefix of 32 bits to the given address,
 * ie. just 11111111 00000000 00000000 00010000.
 *
 * In total, the answer specifies the range of 10 ips starting with the address 255.0.0.7 .
 *
 * There were other representations, such as:
 * ["255.0.0.7/32","255.0.0.8/30", "255.0.0.12/30", "255.0.0.16/32"],
 * but our answer was the shortest possible.
 *
 * Also note that a representation beginning with say, "255.0.0.7/30" would be incorrect,
 * because it includes addresses like 255.0.0.4 = 11111111 00000000 00000000 00000100
 * that are outside the specified range.
 * Note:
 * ip will be a valid IPv4 address.
 * Every implied address ip + x (for x < n) will be a valid IPv4 address.
 * n will be an integer in the range [1, 1000].
 */
public class IPtoCIDR {

    public List<String> ipToCIDR(String ipString, int range) {
        int ip = convertStringIPtoNum(ipString);
        List<String> cidrBlocks = new ArrayList<>();
        while(range > 0) {
            int zeros = getZeros(ip);
            int thisRange = 1 << zeros;
            thisRange = Math.min(range,thisRange);
            getCidrBlocks(ip, thisRange, cidrBlocks);
            ip += thisRange;
            range -= thisRange;
        }
        return cidrBlocks;
    }

    private int getZeros(int ip) {
        int zeros = 0;
        for(int i = 0; i<32; i++) {
            if((ip & (1 << i)) == 0) {
                zeros++;
            } else break;
        }
        return zeros;
    }

    private void getCidrBlocks(int ip, int range, List<String> cidrBlocks) {
        if(range <= 0) return;
        int i = 0;
        while((1 << i+1) <= range) i++; // Get power of 2 within range
        int prefixLength = 32-i;
        int thisRange = 1 << i;
        String ipString = convertNumToIPString(ip) + "/" + prefixLength;
        cidrBlocks.add(ipString);
        getCidrBlocks(ip+thisRange,range-thisRange,cidrBlocks);
    }

    private String convertNumToIPString(int num) {
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<4; i++) {
            if(i>0) sb.insert(0, '.');
            sb.insert(0,(num & 255));
            num >>= 8;
        }
        return sb.toString();
    }

    private int convertStringIPtoNum(String ipstring) {
        String[] ipArray = ipstring.split("[.]");
        int ip = 0;
        for(int i=0; i<4; i++) {
            ip += Integer.parseInt(ipArray[i]) * (1 << (8*(3-i)));
        }
        return ip;
    }
}
