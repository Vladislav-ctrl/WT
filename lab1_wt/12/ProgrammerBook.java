package by.bsuir.ausiukevich.task12;

import java.util.Objects;

public class ProgrammerBook extends Book {
    private String language;
    private int level;

    public ProgrammerBook(String title, String author, int price, String language, int level) {
        super(title, author, price);
        this.language = language;
        this.level = level;
    }

    public ProgrammerBook(String title, String author, int price, int isbn, String language, int level) {
        super(title, author, price, isbn);
        this.language = language;
        this.level = level;
    }

    public ProgrammerBook(String language, int level) {
        this.language = language;
        this.level = level;
    }

    public ProgrammerBook() {

    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public int hashCode() {
        int hashLanguage = (language != null) ? language.hashCode() : 0;
        return super.hashCode() + hashLanguage + 31 * level;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        if (this == o) {
            return true;
        }
        if (!super.equals(o)) {
            return false;
        }
        ProgrammerBook book = (ProgrammerBook) o;
        return language.equals(book.getLanguage()) && level == book.getLevel();
    }

    @Override
    public String toString() {
        return super.toString() + " ProgrammerBook {language = " + language + ", level = " + level + "}";
    }

}
