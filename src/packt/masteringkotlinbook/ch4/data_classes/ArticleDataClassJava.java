package packt.masteringkotlinbook.ch4.data_classes;

import java.util.Objects;

public class ArticleDataClassJava {
    private String title;
    private String author;

    private String snippet;

    public ArticleDataClassJava(String title, String author) {
        this.title = title;
        this.author = author;
        this.snippet = "";
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSnippet() {
        return snippet;
    }

    public void setSnippet(String snippet) {
        this.snippet = snippet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArticleDataClassJava that = (ArticleDataClassJava) o;
        return title.equals(that.title) && author.equals(that.author);
    }

    @Override
    public String toString() {
        return "ArticleDataClassJava{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author);
    }
}
