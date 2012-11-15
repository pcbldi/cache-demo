import cache.demo.Author
import cache.demo.Book

class BootStrap {

    def init = { servletContext ->

        Author author = new Author(name: "author 1").save();
        (1..5).each {
            author.addToBooks(new Book(title: "book ${it}", author: author))
        }
    }
    def destroy = {
    }
}
