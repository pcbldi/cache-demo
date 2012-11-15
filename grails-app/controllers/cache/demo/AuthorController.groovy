package cache.demo

class AuthorController {

    def sessionFactory

    def index() {
        def startTime = System.nanoTime()
        List<Book> books
        Author author
        author = Author.get(1)
        books = author.books as List<Book>
        def endTime = System.nanoTime()
        def diff = (endTime - startTime) / 1000000000
        render author?.name
        render books
        println "TIME TAKEN IS :::" + diff
    }


    def action2() {
        def startTime = System.nanoTime()
        List<Book> books
        Author author
        author = Author.get(1)
        books = author.books
        def endTime = System.nanoTime()
        def diff = (startTime - endTime) / 1000000000
        println "TIME TAKEN IS :::" + diff
    }


    def updateAuthor() {
        Author author = Author.get(1);
        author.name = "Grails author"
        author.save()
    }
}
