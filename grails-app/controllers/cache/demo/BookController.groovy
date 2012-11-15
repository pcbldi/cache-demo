package cache.demo

class BookController {

    def index() {
        Book book
        LogSql.execute {
            book = Book.get(1)
        }
        render "---> ${book?.title}----${ book?.author?.name}"
    }

    def list() {
        List<Book> books
        def startTime = System.nanoTime()
        LogSql.execute {
            books = Book.list()
        }
        def endTime = System.nanoTime()
        def diff = (endTime - startTime) / 1000000000
        println "Time Taken to Execute query : ${diff}"
        [books: books, timeTaken: diff] //query caching
    }

    def add() {
        Author author = Author.get(1)
        String addBookMessage = new Book(title: 'grails In Action', author: author).save(failOnError: true) ?
            "Book Added Successfully" : "Error in adding Book";
        [message: addBookMessage]
    }

    def update() {
        Book book = Book.get(1)
        book.title = "Grails Book"
        book.save(failOnError: true)
    }

}
