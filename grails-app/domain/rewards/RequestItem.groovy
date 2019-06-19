package rewards

class RequestItem {

    Integer qty
    Float total
    static belongsTo = [request:Request, product:Product]

    static constraints = {
    }
}
