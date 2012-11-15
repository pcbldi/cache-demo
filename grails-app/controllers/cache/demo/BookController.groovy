package cache.demo

class BookController {

    static defaultAction = "list"

    //Simple Caching example
    def list() {
        List<Book> books
        def startTime = System.nanoTime()
        LogSql.execute {
            books = Book.list()
        }
        def endTime = System.nanoTime()
        def diff = (endTime - startTime) / 1000000000
        println "Time Taken to Execute query : ${diff}"
        [books: books, timeTaken: diff]
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
        String message = book.save(failOnError: true) ? "Book updated Successfully" : "Error in updating Book"
        render(view: 'add', model: [message: message])
    }

    //Example of Query Caching
    def findAllGrailsBooks() {
        List<Book> books = []
        def startTime = System.nanoTime()
        LogSql.execute {
            books = Book.findAllByTitleIlike("%Grails%")
        }
        def endTime = System.nanoTime()
        def diff = (endTime - startTime) / 1000000000
        println "Time Taken to Execute query : ${diff}"
        render([view: 'list', model: [books: books, timeTaken: diff]])
    }

}
