package cache.demo

class Book {

    String title

    static belongsTo = [author: Author]

    static constraints = {
    }

    static mapping = {cache usage: 'read-write'}
}
