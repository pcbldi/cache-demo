import cache.demo.Author
import cache.demo.Book

class BootStrap {

    def init = { servletContext ->
        List<String> bookTitles = ["Grails In Action", "Spring in Action", "HIbernate in Action", "Definitive Guide to Grails", "spring Unleashed",
                "HIbernate Unleashed"]
        Author author = new Author(name: "Anonymous").save();
        bookTitles.each {String bookTitle ->
            author.addToBooks(new Book(title: bookTitle, author: author))
        }
    }
    def destroy = {
    }
}
