package cache.demo

class Author {

    String name

    Collection<Book> books
    static hasMany = [books: Book]

    static constraints = {
        name(blank: false, nullable: false)
    }

    static mapping = {
        cache usage: 'read-write'
        books cache: true
    }
}
