package com.fierysoul.polycoin.util.enums;

public enum DirectionEnum {

    All("Все", InstEnum.ALL),
    D09_03_01("09.03.01 Информатика и вычислительная техника", InstEnum.IKNT),
    D09_03_02("09.03.02 Информационные системы и технологии", InstEnum.IKNT),
    D09_03_03("09.03.01 Прикладная информатика", InstEnum.IKNT),
    D09_03_04("09.03.04 Программная инженерия", InstEnum.IKNT),
    D01_03_03("01.03.03 Механика и математическое моделирование", InstEnum.FIZMEH),
    D01_03_05("01.03.05 Статистика", InstEnum.IPMEIT);

    public String translate;
    public InstEnum inst;
    DirectionEnum(String translate, InstEnum inst) {
        this.translate = translate;
        this.inst = inst;
    }
}
