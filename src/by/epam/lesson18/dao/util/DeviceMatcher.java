package by.epam.lesson18.dao.util;

import by.epam.lesson18.bean.criteria.Criteria;

import java.util.*;

public class DeviceMatcher {

    private List<String> linesFromTxt;
    private Criteria criteria;

    public DeviceMatcher(List<String> linesFromTxt, Criteria criteria) {
        this.linesFromTxt = linesFromTxt;
        this.criteria = criteria;
    }



    private List<String> achievePatternsToFineDevice() {
        List<String> patterns = new ArrayList<>();
        Map<String, Object> criterias = criteria.getCriteria();
        Set<Map.Entry<String, Object>> entrySet = criterias.entrySet();
        for (Map.Entry<String, Object> entry : entrySet) {
            patterns.add(entry.getKey() + "=" + entry.getValue());
        }
        return patterns;
    }

    public List<String> match() {
        List<String> linesAreMatched = new ArrayList<>();
        List<String> patterns = achievePatternsToFineDevice();
        for (String line : linesFromTxt) {
            if (checkIfAllPatternsMatch(line, patterns)) {
                linesAreMatched.add(line);
            }
        }
        return linesAreMatched ;
    }

    private boolean checkIfAllPatternsMatch(String line, List<String> patterns) {
        for (String pattern : patterns) {
            if (!line.contains(pattern)) {
                return false;
            }
        }
        return true;
    }


}
