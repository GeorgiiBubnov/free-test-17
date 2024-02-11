package data;

public enum Language {

    RU("Русский", "Оптимизировать снабжение для"),
    TR("Türkçe", "Satınalma süreçlerini optimize etmenin en iyi yolu");


    private String name;
    private String description;

    Language(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }


    public String getDescription() {
        return description;
    }


}
