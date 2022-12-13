package com.fierysoul.polycoin.app.main.settings;

import com.fierysoul.polycoin.util.enums.InstEnum;
import com.fierysoul.polycoin.util.enums.ScopeEnum;

public class FilterSettings {

    InstEnum inst;
    ScopeEnum scope;
    int course;

    public FilterSettings() {}

    public void setInst(InstEnum inst) {
        this.inst = inst;
    }

    public void setScope(ScopeEnum scope) {
        this.scope = scope;
    }
}
