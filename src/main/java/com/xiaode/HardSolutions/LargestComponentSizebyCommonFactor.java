package com.xiaode.HardSolutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by liyangde on Dec, 2018
 *
 * 952. Largest Component Size by Common Factor
 */
public class LargestComponentSizebyCommonFactor {
    public int largestComponentSize(int[] A) {
        List<Node> nodes = new ArrayList<>();
        for(int num : A) {
            Node node = new Node(num);
            nodes.add(node);
        }

        boolean[] isPrime = new boolean[100001];
        Arrays.fill(isPrime, true);
        //Set<Integer> primes = new HashSet<>();
        //all primes less than 100000
        for (int i = 2; i <= 100000; i++) {
            if (isPrime[i]) {
                for (int j = 2; j * i <= 100000; j++) {
                    isPrime[j * i] = false;
                }
            }
        }
        for (Node node1 : nodes) {
            if (!isPrime[node1.val]) continue;
            for(Node node2 : nodes) {
                if (isPrime[node1.val] && isPrime[node2.val]) continue;
                if(node1 == node2 || node1.connected.contains(node2)) continue;
                if(gcd(node1.val,node2.val) > 1) {
                    node1.connected.add(node2);
                    node2.connected.add(node1);
                }
            }
        }

        //
        int size = 0;
        int res = -1;
        Stack<Node> current;
        Stack<Node> next;
        for(Node node: nodes){
            current = new Stack<>();
            next = new Stack<>();
            if(!node.visited){
                current.add(node);
                while(current.size() != 0){
                    while(current.size() != 0) {
                        Node n = current.pop();
                        if (!n.visited){
                            n.visited = true;
                            for (Node connect : n.connected) {
                                next.push(connect);
                            }
                            size++;
                        }
                    }
                    current = next;
                    next = new Stack<>();
                }
                res = Math.max(size, res);
            }
            size = 0;
        }


        return res;
    }

    private int gcd(int a, int b) {
        while(a != b){
            if(a > b) a -= b;
            else b -= a;
        }
        return a;
    }

    class Node{
        public int val;
        public boolean visited = false;
        public List<Node> connected;
        Node(int val){
            this.val = val;
            connected = new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        LargestComponentSizebyCommonFactor l = new LargestComponentSizebyCommonFactor();
        System.out.println(l.largestComponentSize(new int[]{1,2,8195,4,8197,8198,8199,12,13,14,8212,23,25,8218,27,29,31,8225,8226,36,8229,40,8234,48,53,8248,57,8250,59,8256,65,66,68,8261,8263,72,8270,8205,80,81,8274,84,8278,8279,93,8287,8290,8291,103,104,106,8299,113,8307,8309,8310,120,8314,8315,128,1387,8328,1388,138,8215,8332,8333,8338,8339,148,8341,150,160,162,8361,171,173,8369,178,8372,181,182,184,186,8379,8380,8382,8384,8385,8387,8389,200,201,203,34,8398,8399,208,209,8408,217,8410,8413,8417,8418,8423,8425,8426,8427,8428,8429,8431,241,8434,8438,8442,42,8447,8449,259,8453,8454,8456,265,268,8461,8466,278,8472,281,2778,8478,289,290,8487,296,9607,8493,302,304,305,8498,8499,8501,311,315,8508,317,8245,8512,8513,8194,8517,8519,328,332,334,336,56,339,345,8538,8539,350,351,8251,356,8551,361,362,363,8556,365,367,368,369,375,8568,379,382,387,8583,1431,8588,8593,402,8598,8599,8600,8260,411,412,421,8617,8618,71,430,431,433,434,8627,436,437,439,8632,443,444,8639,448,8641,452,457,8650,459,8652,462,8657,8660,8661,8662,8271,476,477,479,480,481,8674,486,8273,491,492,8685,496,8690,8694,503,504,505,8698,8699,8700,509,8704,513,515,517,8711,8714,523,524,8718,528,8722,531,535,8728,8729,538,8734,8737,548,549,8743,8746,8747,1458,8750,8752,8753,8754,8755,564,8758,567,570,8763,8764,573,8768,8770,8773,8780,589,590,8783,592,593,8787,597,598,601,8797,606,8799,609,610,8803,613,8809,8812,8814,8819,628,629,8823,8824,8825,8826,641,8834,650,653,8846,9569,656,8849,658,659,8852,664,667,8861,8863,8865,8866,1150,678,8872,683,8876,8879,688,8881,691,692,693,8886,8888,699,701,8896,705,707,8900,709,8903,8904,713,8911,720,722,723,8916,729,5583,8927,741,8934,8935,748,8942,751,754,755,763,8956,8957,8958,767,8960,8961,8962,771,774,8967,8971,8972,8973,782,783,786,4315,788,789,790,792,8985,8987,797,8990,802,803,8996,8999,9007,9009,9010,9011,822,8329,9016,9018,827,833,8331,9028,845,141,9043,853,855,9050,860,9058,867,9060,9061,870,871,9064,9067,9071,880,884,9077,9078,9080,890,9083,894,896,9090,9091,902,904,907,908,909,910,9105,914,9108,917,918,9111,921,922,1519,9116,9118,9120,9123,9226,933,934,935,9129,939,9132,9133,945,9139,9142,9146,9147,9150,959,962,9155,9157,966,968,969,9162,9164,973,978,981,982,9175,984,986,9181,9183,996,9189,998,1001,9197,1006,9199,9200,1010,9205,9207,9210,1019,1022,9218,1029,1033,1034,1041,9237,9239,1049,1054,9247,1057,1058,9251,9252,9253,9254,9255,1065,1066,8370,9262,9270,9271,1081,1082,1084,8373,1088,1089,1091,1093,9288,9311,9292,1103,9296,1105,9299,1550,9304,9306,1115,1119,1123,1125,9319,1128,1131,1132,1136,1138,1139,9332,9333,9335,9337,9342,1151,9345,1156,1157,9351,1160,9356,1167,195,9367,9368,9371,1182,1184,1185,9379,1188,9384,1193,1196,9389,1199,1209,1211,9404,9406,9409,1218,1219,9412,9414,1224,9419,9420,9423,1233,1234,206,9431,9435,1248,9443,1253,9446,8401,9448,9450,1259,9453,1262,9455,9456,9461,9462,9464,1274,1278,1279,1280,1281,1282,9475,1284,9478,1294,1295,1296,1300,9774,1303,1304,9497,1306,1310,1312,1314,9507,9509,9510,1319,1322,9516,1325,1326,9520,9524,1333,1338,9533,8228,9538,9539,9540,226,118,1364,9559,9560,9561,9564,9566,9568,1377,1380,9573,1384,1385,9578,231,9580,1389,9789,9587,1397,1400,9595,1404,9597,1406,9599,1408,9605,1415,9608,9611,9614,1428,9622,9623,9625,1434,1435,1436,9631,1441,1443,9639,9640,9641,1452,9647,9648,9650,9656,1465,1467,9663,9665,1475,1479,9674,9675,9676,9677,9680,9681,9682,9683,1492,9686,1497,1498,1502,9697,9703,9706,1518,9711,9712,9716,1525,1526,1527,9720,1531,9724,9729,1622,9742,1551,9744,1553,1554,1556,1558,9751,9752,1563,9756,1566,9760,1569,1570,1575,1577,1579,9772,9773,1582,1583,9776,1586,1587,1588,9783,9784,1597,9790,9793,9796,1607,9800,9801,1611,1616,9809,9811,9814,1624,1627,1628,9821,9825,9831,9832,9833,1642,1643,1645,1648,9843,9846,1655,9851,9859,1670,1675,9868,9869,9870,9871,1682,1683,1684,8785,1687,9880,1695,9889,1700,1701,1704,9898,875,1708,9903,1712,1713,1715,9908,1718,9912,1722,1723,1725,9918,9921,1730,1731,9926,9928,9929,1740,9933,9935,9939,9940,9946,1756,9949,9951,1762,1659,1764,9959,1768,9961,9963,9965,9966,1777,1779,1780,9975,9979,1788,9982,1793,9986,9992,1803,9997,9999,1810,1811,1812,8494,1815,1819,8497,1833,1836,306,1840,1843,1848,1855,1857,1858,1859,1861,1876,1881,1882,1886,1887,1891,1892,1894,316,1900,1902,9875,1909,1913,1917,1918,1922,1924,1925,9879,322,325,1953,1957,1959,1960,1965,1966,1970,1971,1977,1980,1982,1983,1984,1986,1988,1990,1992,2000,2002,2003,2012,9893,2016,2018,2019,2026,2027,2030,2038,2039,2044,2051,2054,2056,2057,2060,2065,2067,2069,1711,2076,1433,9904,347,2087,2090,2093,2095,2097,2098,2103,2105,2113,2121,2122,2126,2129,2141,2143,2144,2146,2148,2151,359,2163,2164,2165,2168,2170,2173,2175,2183,2187,2193,9923,2196,2200,2205,2206,2208,8560,2216,2218,2220,2224,1736,2231,2233,2234,2246,2247,2251,2252,2256,376,2265,2266,2267,2271,2274,2279,2280,2282,2290,2291,2294,2296,2298,2301,2302,2303,2304,2305,2314,2317,2319,2327,2329,2330,2331,2342,9948,2347,2353,2354,2356,2359,2362,1759,2369,2379,2385,2386,2395,2397,2405,2416,9960,2425,2427,2429,1771,2436,2439,407,2444,2447,2448,2452,2457,2462,2466,2471,2472,2475,2476,2481,2488,2490,2502,2504,2506,2508,2509,2513,2516,2518,2519,2528,9086,2547,1790,2558,2562,2564,2568,2577,2578,2580,2582,2583,2587,2590,2594,8625,2600,2609,2619,2621,2624,2625,2630,2636,2637,2639,2641,2645,2651,2654,2658,2660,2675,2677,2679,447,2685,2687,2689,2690,2693,2697,2699,2700,2703,2704,2714,2718,2719,2721,2722,2723,2724,2726,2729,2734,2737,2745,2746,2754,2764,2771,2773,2774,1729,2781,2801,2802,2806,469,2822,2848,2856,2867,2870,2871,2872,2873,2876,2882,2885,8673,2891,2895,2896,2898,2901,2912,2913,2914,2917,2918,2921,2922,2925,2933,2940,2942,2944,2946,2949,2950,2958,2976,2980,2993,2995,3001,3002,3004,3011,3012,502,3018,3019,3022,3024,3031,3035,3054,3058,3061,3062,3064,3066,3067,3068,3072,3077,3078,3080,3081,3083,3088,3089,3091,3092,3097,3103,3121,3123,3131,3135,3136,3139,3141,3144,8716,3148,3151,3153,3159,3160,3166,3173,3181,3190,3194,3201,3203,3209,3210,3213,537,3228,3235,926,3240,3244,3245,3247,3253,3260,3261,3263,3265,3268,3271,3279,3284,3287,3290,3291,3292,3297,3299,3302,551,3317,1747,3320,3322,3324,3327,3330,3334,3336,3338,3339,3342,3345,3354,3359,560,3365,3370,3374,3376,3377,563,3380,3384,3388,3391,3398,3401,1933,3411,3413,3416,3417,3425,3426,3427,3430,3438,3442,3444,3457,3461,3464,578,3470,3472,3473,3476,3478,3484,3487,3488,3495,3507,3513,3515,3516,3518,3520,3521,3528,3539,3541,3544,3549,3550,3551,3557,3559,3561,3563,3564,3566,3571,3577,8789,3589,3594,3595,3596,3598,3602,3609,3610,3614,3615,3620,3623,3626,3630,3631,3633,3637,3639,607,3647,3650,3652,3653,8802,3668,3670,3673,3677,3681,3682,3684,3687,3692,3695,3697,3698,3699,3710,9671,620,3723,3725,3731,3732,3736,3738,3740,3742,3743,3745,3746,3749,3750,3756,3758,3759,3761,3762,8820,3774,3776,3777,3781,3783,3785,3790,3791,3792,3795,3797,3799,3802,3806,3808,3809,3810,3811,3820,3823,3830,3832,3834,3838,3846,3848,3850,3853,3854,3866,3867,3868,3871,3872,3875,3876,3879,3881,3883,3884,3885,3886,3888,3891,3900,3907,3909,3919,3927,3929,3931,3945,3958,3959,3961,3965,3979,3981,3985,3986,3988,3989,3998,4003,4010,4013,4014,4019,4021,4022,4023,4037,4040,4043,674,4048,4050,4051,4052,4056,4065,4067,4074,4083,4091,4092,4096,4097,4106,4107,4111,4117,4119,4120,4121,687,4127,4128,4144,4146,4148,4154,4158,4165,4167,4170,4174,4178,4184,4185,4186,4189,4194,4196,4198,4201,4204,4205,4209,4212,4216,4219,4220,4222,4226,4228,4229,4235,4244,4245,4247,4249,4252,4257,4265,4268,4270,4272,4274,4276,4284,4285,4287,4296,4298,4299,4306,4307,719,4317,4326,4327,4328,4333,4335,4343,4346,4349,4354,4356,4357,4364,4372,4381,4384,4389,4392,4398,4399,4404,4409,4414,4415,4421,4422,4429,4430,4434,4435,4445,4449,4451,4462,4463,4469,4470,4472,4475,4476,4478,4484,4486,4487,4495,4497,4500,4501,4504,4506,4507,4509,4517,4518,4520,4525,4529,4531,4536,4538,4541,4549,4552,4554,4563,4569,4570,4574,4576,4579,4582,4586,4589,4596,4597,4598,4600,4601,4603,4604,4607,4612,4616,4621,4623,4626,8963,4628,4630,4632,4642,4653,4654,4657,4658,4661,4662,4667,4679,4682,4684,4685,4687,4688,4690,4691,4695,4700,4701,4705,4706,4710,4713,4717,4720,4723,4728,4735,4736,4737,4739,4751,8984,4754,4755,793,4760,4761,4772,4776,4777,4778,4782,4784,4785,4786,4788,4789,4791,4793,4801,4802,4803,4806,4807,4808,4810,4813,4814,4821,4822,4823,4828,4830,4835,4838,4843,4845,4847,4852,4853,4858,4862,4867,4872,4877,4878,708,4889,4899,4900,4902,4905,4911,819,4919,4922,4927,4930,4937,4943,4947,4962,4964,4965,4971,4979,4986,4988,4992,4993,5000,5003,5009,5010,5013,5017,5028,5032,5033,5039,5044,5048,5064,5073,5075,5079,169,5083,5088,5091,5101,5103,5106,5113,5114,5116,5118,5122,5124,5127,5132,5141,5142,5143,5147,5155,5159,9052,5163,5167,5172,5175,5181,5182,5183,5189,5191,5193,5199,5201,5209,5210,5211,5213,5220,5229,5232,5237,5240,5247,5251,5254,5257,5260,5262,5273,5285,5291,5292,5293,5294,5297,5299,5303,5306,5308,5311,5312,5316,886,5318,5322,5323,5327,5334,5335,5337,5340,5342,5348,5350,5365,5367,5378,5390,5391,5392,5395,5404,5407,5409,5413,5414,5416,5417,5424,5431,5433,5438,5443,5448,5449,5451,5452,5453,5457,9102,5462,5464,5465,5468,5470,5473,5481,5484,5486,5490,5493,5501,9109,5505,5507,5511,5514,5515,5518,5522,5528,5534,5538,5544,5545,5551,5557,5558,5565,5567,5568,9733,3661,5589,5591,5592,932,5601,5602,5605,5613,5615,5619,937,5627,5631,5632,5637,5639,5640,5647,5651,5653,5656,5659,5660,5666,5667,5668,5676,5681,947,5689,5690,5691,5695,5705,5706,5720,5721,5722,5724,5725,5727,5733,5743,5746,5753,5754,5762,5763,5765,5770,5775,5784,5792,5798,5799,5814,5822,5828,5829,5832,5834,5835,5838,5841,5842,5849,5856,5860,5861,5862,5863,5864,5866,5867,5869,5873,5874,5877,5881,5887,5900,5905,5913,5914,5918,5922,5923,5932,5936,5937,5938,5941,5942,5948,5954,5956,5966,5969,5978,5979,5981,5983,5984,5986,5991,6000,9969,6002,6003,6009,6010,6011,6012,6014,6018,6020,6024,6027,6028,6034,6036,6039,6051,6052,6053,6055,6057,9202,6065,6066,6067,6077,6083,6084,6089,6095,6096,6099,6106,6108,6114,6118,6122,6123,6141,6143,750,6155,6156,6164,6177,6182,6186,6188,6199,6201,6203,6204,6205,6213,6214,6226,6232,6234,6237,6238,6240,6246,6248,6252,6253,6258,6260,6281,6283,6284,6285,6295,6310,6311,6318,6322,6327,6332,6333,6342,6345,1059,6367,6368,6370,1062,6375,6384,6392,6394,9258,6400,6404,6408,6415,6416,6425,6426,6438,6444,6450,6452,6458,6461,6463,6469,6470,6475,6483,6486,9274,6496,6500,9276,6510,6511,6513,6514,6516,6523,6528,6531,6532,6534,6542,6545,6548,6555,6564,6571,6577,6579,6584,6590,6591,6598,6599,6600,6605,6609,6610,6611,6612,9295,6625,6626,6628,6630,6633,9755,6635,1107,6645,6648,6650,6654,6657,6658,6663,6665,6668,6674,6676,6682,6685,6687,9307,6693,6696,6702,6705,6710,6714,6715,6719,6720,6721,6729,6732,6738,6748,6753,6761,1127,6765,6767,6770,6772,6773,6775,6777,6778,6780,6785,9323,6788,6790,6792,9324,6797,6798,6802,6803,6804,6808,6809,6812,6813,6820,6823,6825,6829,6830,6835,6838,6842,6843,6844,6848,6858,6863,6870,1145,6872,6877,6879,6880,6882,6883,6890,6891,6895,6901,9343,6912,6916,1153,6922,6924,6925,6926,6927,6930,6933,6935,6943,6945,6955,6957,6962,6964,6967,6968,6979,6980,6982,6989,6993,6994,7005,7014,7016,7024,9363,7030,7032,1598,7040,7043,7045,7046,7050,7052,1176,7064,7066,7071,7079,7083,7084,7090,7095,7096,7097,7100,7107,7112,7119,7131,7132,7133,7135,7139,7140,7146,1192,7156,7157,9385,7163,7167,7168,7169,7171,7172,7180,7186,7189,7198,7204,7209,7216,7219,7220,7221,7223,7225,7227,7237,7240,7242,7243,7249,7252,7255,7257,7258,7260,7262,7263,7264,7265,7273,9517,7295,7301,7303,7307,9410,7316,7317,7319,7323,7327,7331,7336,7347,7348,7354,7362,7371,7376,7377,7389,7395,7399,7404,7406,7408,7409,7410,7411,7413,7422,7428,7432,7444,7450,595,7452,7454,7455,7461,7465,7466,7467,7470,7472,7473,7475,7479,7484,7487,7491,7493,7495,7496,7498,8433,7502,7504,7507,7510,7516,7519,7522,7529,1069,7534,7535,7537,7544,7545,7552,7558,7563,7566,7575,7579,1264,7588,7589,7591,7598,7599,7601,7613,7621,7642,7643,9466,7648,7649,7655,7656,7658,7660,7663,7664,7665,7671,7672,7674,7676,7678,7683,7684,7692,7698,7699,7704,7713,1286,7719,7720,7725,7726,7732,7734,7735,7746,7748,7750,7752,7764,7766,7773,7774,7776,7780,7782,7785,7787,7790,7793,7799,7802,7804,7811,7813,7816,7817,1305,7832,7836,7839,7840,7841,7847,7848,7849,7854,7856,7866,7873,7874,7875,7881,4045,7889,7894,7900,7901,7908,1318,7911,7912,7915,7919,7921,7922,7923,7927,7929,7930,7931,7937,7951,7952,7962,8994,7966,7969,7970,7971,7973,7976,7980,7981,7984,7990,1332,7995,7996,7997,8004,8015,8017,8018,8019,8026,8027,8038,8039,8044,8049,8050,8057,8058,8059,8065,8066,8075,8076,8082,8087,542,8101,8105,8106,8108,8110,8116,8117,8118,8122,8123,8126,8127,8129,8132,8137,8140,8148,8153,8154,8159,8160,8165,8172,8173,8176,545,8190,8191}));
    }
}
