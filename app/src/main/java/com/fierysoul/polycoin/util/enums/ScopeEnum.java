package com.fierysoul.polycoin.util.enums;

public enum ScopeEnum {

    ALL("Все"), CULTURE("Культура"), SPORT("Спорт"), SOCIETY("Общество"), STUDIES("Учеба"), SCIENCE("Наука");

    public String translate;
    ScopeEnum (String translate) {
        this.translate = translate;
    }

}
