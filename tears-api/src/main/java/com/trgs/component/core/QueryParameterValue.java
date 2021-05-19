package com.trgs.component.core;

/**
 * @author Eduardo rodrigues
 *
 * @version $Revision$
 *
 * Created : Feb 15, 2010
 */
public class QueryParameterValue {

    private Object value;
    private String required="false";
    
    
    /**
     * 
     */
    public QueryParameterValue() {
        super();
    }
    
    public QueryParameterValue(Object value) {
        super();
        this.value = value;
    }
    

    /**
     * @return Returns the required.
     */
    public String getRequired() {
        return required;
    }
    /**
     * @param required The required to set.
     */
    public void setRequired(String required) {
        this.required = required;
    }
    /**
     * @return Returns the value.
     */
    public Object getValue() {
        return value;
    }
    /**
     * @param value The value to set.
     */
    public void setValue(Object value) {
        this.value = value;
    }
}
