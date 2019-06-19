package rewards

class Request {

    Date orderDate
    Integer orderNumber
    Float orderTotal
    static belongsTo = [customer:Customer]
    static hasMany = [requestItems:RequestItem]

    static constraints = {

    }
}
