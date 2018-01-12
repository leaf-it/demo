package com.cotyledon.expression;

import java.util.function.BiFunction;

public final class BooleanExpression {
      private  String compareValue;
      private  String variable;
      private  String condition;
    public BooleanExpression(){}
    public BooleanExpression(String compareValue, String variable, String condition) {
        this.compareValue = compareValue;
        this.variable = variable;
        this.condition = condition;
    }

    public String getCompareValue() {
        return compareValue;
    }

    public void setCompareValue(String compareValue) {
        this.compareValue = compareValue;
    }

    public String getVariable() {
        return variable;
    }

    public void setVariable(String variable) {
        this.variable = variable;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
    public Boolean execute(){
        switch (this.condition){
            case IS : return  isBi.apply(this.compareValue,this.variable);
            case LIKE:return  likeBi.apply(this.compareValue,this.variable);
        }
        return  Boolean.FALSE;
    }

    public static final String IS = "is";
    public static final String LIKE = "like";
    private  BiFunction<String, String, Boolean> isBi = new BiFunction<String, String, Boolean>() {
        @Override
        public Boolean apply(String compared, String variable) {
            return Boolean.valueOf( variable.equals(compared));
        }
    };
    private BiFunction<String, String, Boolean> likeBi = new BiFunction<String, String, Boolean>() {
        @Override
        public Boolean apply(String compared, String variable) {
            return Boolean.valueOf(variable.contains(compared));
        }
    };

}
