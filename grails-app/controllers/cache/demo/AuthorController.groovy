package cache.demo

class AuthorController {

    static defaultAction = "list"

    //Example of Association caching
    def list() {
        def startTime = System.nanoTime()
        Author author
        List<String> bookTitles
        LogSql.execute {
            author = Author.get(1)
            bookTitles = author?.books*.title
        }
        def endTime = System.nanoTime()
        def diff = (endTime - startTime) / 1000000000
        println "Time Taken to Execute query : ${diff}"
        [author: author, bookTitles: bookTitles, timeTaken: diff]
    }

    def updateAuthor() {
        Author author = Author.get(1);
        author.name = "Grails author"
        author.save()
    }
}
