package com.fierysoul.polycoin.items;

import com.fierysoul.polycoin.util.enums.InstEnum;

public class RatingUserItem {

    final InstEnum inst;
    final String name;
    final Integer culturePoints, sportPoints, societyPoints, studiesPoints, sciencePoints;

    public RatingUserItem(String name, InstEnum inst, int culturePoints, int sportPoints, int societyPoints, int studiesPoints, int sciencePoints) {
        this.name = name;
        this.inst = inst;
        this.culturePoints = culturePoints;
        this.sportPoints = sportPoints;
        this.societyPoints = societyPoints;
        this.studiesPoints = studiesPoints;
        this.sciencePoints = sciencePoints;
    }

    public String getName() {
        return name;
    }

    public InstEnum getInst() {
        return inst;
    }

    public Integer getCulturePoints() {
        return culturePoints;
    }

    public Integer getSportPoints() {
        return sportPoints;
    }

    public Integer getSocietyPoints() {
        return societyPoints;
    }

    public Integer getStudiesPoints() {
        return studiesPoints;
    }

    public Integer getSciencePoints() {
        return sciencePoints;
    }

    public Integer getPoints() {
        return  culturePoints + sportPoints + societyPoints + studiesPoints + sciencePoints;
    }
}
