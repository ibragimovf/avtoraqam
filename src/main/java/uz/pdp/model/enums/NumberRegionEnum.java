package uz.pdp.model.enums;

public enum NumberRegionEnum {
    TOSHKENT("01"),
    TOSHKENT_VILOYATI("10"),
    SIRDARYO("20"),
    JIZZAX("25"),
    SAMARQAND("30"),
    FARGONA("40"),
    NAMANGAN("50"),
    ANDIJON("60"),
    QASHQADARYO("70"),
    SURXANDARYO("75"),
    BUXORO("80"),
    XORAZM("85"),
    NAVOIY("90"),
    QORAQALPOGISTON("95");

    private final String number;

    NumberRegionEnum(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }
}
