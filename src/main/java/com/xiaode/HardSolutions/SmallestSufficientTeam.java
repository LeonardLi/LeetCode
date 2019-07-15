package com.xiaode.HardSolutions;

import java.util.*;

/**
 * Created by liyangde on Jul, 2019
 */
public class SmallestSufficientTeam {
    public int[] smallestSufficientTeam(String[] skills, List<List<String>> people) {
        int sLen = skills.length, pLen = people.size();

        //init skmap, store the skill-index in the map
        Map<String, Integer> skmap = new HashMap<>();
        for (int i = 0; i < sLen; i++)
            skmap.put(skills[i], i);

        //allocate skill array, size = 2^(sLen)
        Set<Integer>[] skillArr = new Set[1 << sLen];
        skillArr[0] = new HashSet<>();

        // outer loop iterates the people
        for (int ppl = 0; ppl < pLen; ppl++) {
            // use bitset to mark the skills each one has
            int pplSkill =  0;
            for (String sks : people.get(ppl)) {
                pplSkill |= 1 << (skmap.get(sks));
            }
            // inner loop iterate skill array 0-2^(sLen)-1
            for (int k = 0; k < skillArr.length; k++) {
                if (skillArr[k] == null) continue;
                Set<Integer> currSkills = skillArr[k];
                int combined = k | pplSkill;

                //k-th people's skills are already existed
                if (combined == k) continue;

                //if skillArr[combined] is null or currSkills has 2 more items than skillArr[combined], add current people
                //replace the old one
                if (skillArr[combined] == null || skillArr[combined].size() > currSkills.size() + 1) {
                    Set<Integer> cSkills = new HashSet<>(currSkills);
                    cSkills.add(ppl);
                    skillArr[combined] = cSkills;
                }
            }
        }

        Set<Integer> resSet = skillArr[(1 << sLen) -1];
        int[] res = new int[resSet.size()];
        int pos = 0;
        for (Integer n : resSet)
            res[pos++] = n;
        return res;
    }
}
