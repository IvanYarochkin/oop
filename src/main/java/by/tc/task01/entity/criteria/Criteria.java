package by.tc.task01.entity.criteria;

import java.util.HashMap;
import java.util.Map;

public class Criteria<E> {
    private String applianceType;

    private Map<E, Object> criteria = new HashMap<E, Object>();

    public Criteria() {
        applianceType = "";
    }

    public Map<E, Object> getCriteria() {
        return criteria;
    }

    public void add(E searchCriteria, Object value) {
        criteria.put(searchCriteria, value);
    }

    public void add(E searchCriteria, Double value) {
        if ( value == value.intValue() ) {
            criteria.put(searchCriteria, value.intValue());
        } else {
            criteria.put(searchCriteria, value);
        }
    }

    public void add(E searchCriteria, Float value) {
        if ( value == value.intValue() ) {
            criteria.put(searchCriteria, value.intValue());
        } else {
            criteria.put(searchCriteria, value);
        }
    }

    public String getApplianceType() {
        return applianceType;
    }

    public void setApplianceType(String applianceType) {
        this.applianceType = applianceType;
    }
}
